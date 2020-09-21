package com.baidu.swan.pms.c.a.c;

import android.util.Log;
import com.baidu.swan.pms.c.a.d.f;
import com.baidu.swan.pms.d;
/* loaded from: classes24.dex */
public class c extends a<f> implements com.baidu.swan.pms.c.a.d.b {
    private volatile f dHH;

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
        if (r6.aUP() > r0.aUP()) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(f fVar) {
        if (fVar != null) {
            if (this.dHH != null && this.dHH.k(fVar)) {
                fVar.aUH().Q(fVar.aUI());
                if (d.DEBUG) {
                    Log.d("PMSPriorityQueue", "enQueue: 要入队的任务和当前正在运行的任务相同->" + fVar);
                }
            } else {
                f aj = aj(fVar);
                if (aj != null) {
                    fVar.aUH().Q(fVar.aUI());
                    if (d.DEBUG) {
                        Log.d("PMSPriorityQueue", "enQueue: 队列中已经有相同的任务在排队等待处理->" + fVar);
                    }
                }
                int aUP = fVar.aUP();
                if (d.DEBUG) {
                    Log.d("PMSPriorityQueue", "[enQueue] priorityOption:" + aUP);
                }
                switch (aUP) {
                    case 200:
                        if (aj != null) {
                            this.mQueue.remove(aj);
                            this.mQueue.add(0, aj);
                            if (d.DEBUG) {
                                Log.d("PMSPriorityQueue", "enQueue: 有更高优先级的重复任务入队，任务提队头处理");
                            }
                        } else {
                            this.mQueue.add(0, fVar);
                        }
                        if (d.DEBUG) {
                            Log.d("PMSPriorityQueue", "[enQueue] a new task added to queue head. size:" + this.mQueue.size());
                            Log.d("PMSPriorityQueue", "[enQueue] task info:" + fVar);
                            break;
                        }
                        break;
                    case 300:
                        h(fVar);
                        if (aj != null) {
                            this.mQueue.remove(aj);
                            this.mQueue.add(0, aj);
                            if (d.DEBUG) {
                                Log.d("PMSPriorityQueue", "enQueue-stop running: 有更高优先级的重复任务入队，任务提队头处理");
                            }
                        } else {
                            this.mQueue.add(0, fVar);
                        }
                        if (d.DEBUG) {
                            Log.d("PMSPriorityQueue", "[enQueue] a new task added to queue head. size:" + this.mQueue.size());
                            Log.d("PMSPriorityQueue", "[enQueue] task info:" + fVar);
                            break;
                        }
                        break;
                    default:
                        if (aj == null) {
                            this.mQueue.add(fVar);
                            if (d.DEBUG) {
                                Log.d("PMSPriorityQueue", "[enQueue] append new task to queue tail. size:" + this.mQueue.size());
                                Log.d("PMSPriorityQueue", "[enQueue] task info:" + fVar);
                                break;
                            }
                        }
                        break;
                }
                notifyAll();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.c.a.c.a
    /* renamed from: aUD */
    public synchronized f aUB() {
        f fVar;
        fVar = (f) super.aUB();
        if (d.DEBUG) {
            Log.d("PMSPriorityQueue", "deQueue first task:" + fVar);
        }
        return fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.c.a.c.a
    /* renamed from: aUE */
    public synchronized f get() {
        f fVar;
        fVar = (f) super.get();
        if (d.DEBUG) {
            Log.d("PMSPriorityQueue", "get first task:" + fVar);
        }
        return fVar;
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void d(f<T> fVar) {
        this.dHH = fVar;
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (this.dHH == fVar) {
            this.dHH = null;
            if (d.DEBUG) {
                Log.d("PMSPriorityQueue", "notifyTaskEnd mCurrentTask == null:" + fVar);
            }
        }
        g(fVar);
    }

    private void g(f fVar) {
        if (fVar.aUR()) {
            if (d.DEBUG) {
                Log.d("PMSPriorityQueue", "processPendingTask:" + fVar);
            }
            fVar.hd(true);
            this.mQueue.add(0, fVar);
            if (d.DEBUG) {
                Log.d("PMSPriorityQueue", "PendingTask added-to-Queue-head:" + fVar);
            }
        }
    }

    private void h(f fVar) {
        f fVar2;
        if (fVar.aUP() == 300 && (fVar2 = this.dHH) != null) {
            if (fVar2.aUP() == 300) {
                if (d.DEBUG) {
                    Log.d("PMSPriorityQueue", "Hi-priority task is working, can't stop:" + fVar2);
                    return;
                }
                return;
            }
            fVar2.aUQ();
            for (int i = 0; i < 500 && this.dHH != null; i++) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

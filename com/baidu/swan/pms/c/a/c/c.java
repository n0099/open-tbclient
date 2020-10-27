package com.baidu.swan.pms.c.a.c;

import android.util.Log;
import com.baidu.swan.pms.c.a.d.f;
import com.baidu.swan.pms.d;
/* loaded from: classes15.dex */
public class c extends a<f> implements com.baidu.swan.pms.c.a.d.b {
    private volatile f ece;

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
        if (r6.aZr() > r0.aZr()) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(f fVar) {
        if (fVar != null) {
            if (this.ece != null && this.ece.k(fVar)) {
                fVar.aZj().T(fVar.aZk());
                if (d.DEBUG) {
                    Log.d("PMSPriorityQueue", "enQueue: 要入队的任务和当前正在运行的任务相同->" + fVar);
                }
            } else {
                f am = am(fVar);
                if (am != null) {
                    fVar.aZj().T(fVar.aZk());
                    if (d.DEBUG) {
                        Log.d("PMSPriorityQueue", "enQueue: 队列中已经有相同的任务在排队等待处理->" + fVar);
                    }
                }
                int aZr = fVar.aZr();
                if (d.DEBUG) {
                    Log.d("PMSPriorityQueue", "[enQueue] priorityOption:" + aZr);
                }
                switch (aZr) {
                    case 200:
                        if (am != null) {
                            this.mQueue.remove(am);
                            this.mQueue.add(0, am);
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
                        if (am != null) {
                            this.mQueue.remove(am);
                            this.mQueue.add(0, am);
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
                        if (am == null) {
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
    /* renamed from: aZf */
    public synchronized f aZd() {
        f fVar;
        fVar = (f) super.aZd();
        if (d.DEBUG) {
            Log.d("PMSPriorityQueue", "deQueue first task:" + fVar);
        }
        return fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.c.a.c.a
    /* renamed from: aZg */
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
        this.ece = fVar;
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (this.ece == fVar) {
            this.ece = null;
            if (d.DEBUG) {
                Log.d("PMSPriorityQueue", "notifyTaskEnd mCurrentTask == null:" + fVar);
            }
        }
        g(fVar);
    }

    private void g(f fVar) {
        if (fVar.aZt()) {
            if (d.DEBUG) {
                Log.d("PMSPriorityQueue", "processPendingTask:" + fVar);
            }
            fVar.hM(true);
            this.mQueue.add(0, fVar);
            if (d.DEBUG) {
                Log.d("PMSPriorityQueue", "PendingTask added-to-Queue-head:" + fVar);
            }
        }
    }

    private void h(f fVar) {
        f fVar2;
        if (fVar.aZr() == 300 && (fVar2 = this.ece) != null) {
            if (fVar2.aZr() == 300) {
                if (d.DEBUG) {
                    Log.d("PMSPriorityQueue", "Hi-priority task is working, can't stop:" + fVar2);
                    return;
                }
                return;
            }
            fVar2.aZs();
            for (int i = 0; i < 500 && this.ece != null; i++) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

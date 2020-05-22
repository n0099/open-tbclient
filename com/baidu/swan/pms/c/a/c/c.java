package com.baidu.swan.pms.c.a.c;

import android.util.Log;
import com.baidu.swan.pms.c.a.d.f;
import com.baidu.swan.pms.d;
/* loaded from: classes11.dex */
public class c extends a<f> implements com.baidu.swan.pms.c.a.d.b {
    private volatile f dlT;

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
        if (r6.aGH() > r0.aGH()) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(f fVar) {
        if (fVar != null) {
            if (this.dlT != null && this.dlT.k(fVar)) {
                fVar.aGz().O(fVar.aGA());
                if (d.DEBUG) {
                    Log.d("PMSPriorityQueue", "enQueue: 要入队的任务和当前正在运行的任务相同->" + fVar);
                }
            } else {
                f ag = ag(fVar);
                if (ag != null) {
                    fVar.aGz().O(fVar.aGA());
                    if (d.DEBUG) {
                        Log.d("PMSPriorityQueue", "enQueue: 队列中已经有相同的任务在排队等待处理->" + fVar);
                    }
                }
                int aGH = fVar.aGH();
                if (d.DEBUG) {
                    Log.d("PMSPriorityQueue", "[enQueue] priorityOption:" + aGH);
                }
                switch (aGH) {
                    case 200:
                        if (ag != null) {
                            this.mQueue.remove(ag);
                            this.mQueue.add(0, ag);
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
                        if (ag != null) {
                            this.mQueue.remove(ag);
                            this.mQueue.add(0, ag);
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
                        if (ag == null) {
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
    /* renamed from: aGv */
    public synchronized f aGt() {
        f fVar;
        fVar = (f) super.aGt();
        if (d.DEBUG) {
            Log.d("PMSPriorityQueue", "deQueue first task:" + fVar);
        }
        return fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.c.a.c.a
    /* renamed from: aGw */
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
        this.dlT = fVar;
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (this.dlT == fVar) {
            this.dlT = null;
            if (d.DEBUG) {
                Log.d("PMSPriorityQueue", "notifyTaskEnd mCurrentTask == null:" + fVar);
            }
        }
        g(fVar);
    }

    private void g(f fVar) {
        if (fVar.aGJ()) {
            if (d.DEBUG) {
                Log.d("PMSPriorityQueue", "processPendingTask:" + fVar);
            }
            fVar.gk(true);
            this.mQueue.add(0, fVar);
            if (d.DEBUG) {
                Log.d("PMSPriorityQueue", "PendingTask added-to-Queue-head:" + fVar);
            }
        }
    }

    private void h(f fVar) {
        f fVar2;
        if (fVar.aGH() == 300 && (fVar2 = this.dlT) != null) {
            if (fVar2.aGH() == 300) {
                if (d.DEBUG) {
                    Log.d("PMSPriorityQueue", "Hi-priority task is working, can't stop:" + fVar2);
                    return;
                }
                return;
            }
            fVar2.aGI();
            for (int i = 0; i < 500 && this.dlT != null; i++) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

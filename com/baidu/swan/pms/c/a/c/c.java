package com.baidu.swan.pms.c.a.c;

import android.util.Log;
import com.baidu.swan.pms.c.a.d.f;
import com.baidu.swan.pms.d;
/* loaded from: classes14.dex */
public class c extends a<f> implements com.baidu.swan.pms.c.a.d.b {
    private volatile f dFD;

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
        if (r6.aUd() > r0.aUd()) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(f fVar) {
        if (fVar != null) {
            if (this.dFD != null && this.dFD.k(fVar)) {
                fVar.aTV().P(fVar.aTW());
                if (d.DEBUG) {
                    Log.d("PMSPriorityQueue", "enQueue: 要入队的任务和当前正在运行的任务相同->" + fVar);
                }
            } else {
                f ai = ai(fVar);
                if (ai != null) {
                    fVar.aTV().P(fVar.aTW());
                    if (d.DEBUG) {
                        Log.d("PMSPriorityQueue", "enQueue: 队列中已经有相同的任务在排队等待处理->" + fVar);
                    }
                }
                int aUd = fVar.aUd();
                if (d.DEBUG) {
                    Log.d("PMSPriorityQueue", "[enQueue] priorityOption:" + aUd);
                }
                switch (aUd) {
                    case 200:
                        if (ai != null) {
                            this.mQueue.remove(ai);
                            this.mQueue.add(0, ai);
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
                        if (ai != null) {
                            this.mQueue.remove(ai);
                            this.mQueue.add(0, ai);
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
                        if (ai == null) {
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
    /* renamed from: aTR */
    public synchronized f aTP() {
        f fVar;
        fVar = (f) super.aTP();
        if (d.DEBUG) {
            Log.d("PMSPriorityQueue", "deQueue first task:" + fVar);
        }
        return fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.c.a.c.a
    /* renamed from: aTS */
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
        this.dFD = fVar;
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (this.dFD == fVar) {
            this.dFD = null;
            if (d.DEBUG) {
                Log.d("PMSPriorityQueue", "notifyTaskEnd mCurrentTask == null:" + fVar);
            }
        }
        g(fVar);
    }

    private void g(f fVar) {
        if (fVar.aUf()) {
            if (d.DEBUG) {
                Log.d("PMSPriorityQueue", "processPendingTask:" + fVar);
            }
            fVar.hf(true);
            this.mQueue.add(0, fVar);
            if (d.DEBUG) {
                Log.d("PMSPriorityQueue", "PendingTask added-to-Queue-head:" + fVar);
            }
        }
    }

    private void h(f fVar) {
        f fVar2;
        if (fVar.aUd() == 300 && (fVar2 = this.dFD) != null) {
            if (fVar2.aUd() == 300) {
                if (d.DEBUG) {
                    Log.d("PMSPriorityQueue", "Hi-priority task is working, can't stop:" + fVar2);
                    return;
                }
                return;
            }
            fVar2.aUe();
            for (int i = 0; i < 500 && this.dFD != null; i++) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

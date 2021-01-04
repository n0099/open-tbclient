package com.baidu.ar.statistic;

import android.content.Context;
import android.os.Process;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes6.dex */
class h implements Runnable {
    private Object mLock;
    private int wC;
    private volatile boolean wD;
    private i[] wE;
    private WeakReference<Context> wn;

    public h(Context context, Object obj, i[] iVarArr) {
        if (iVarArr == null) {
            throw new NullPointerException();
        }
        this.wn = new WeakReference<>(context);
        this.wC = 0;
        this.wD = false;
        this.mLock = obj;
        this.wE = iVarArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x000d A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        i iVar;
        List<List<a>> list;
        int i;
        int i2;
        if (this.wE.length == 0) {
            return;
        }
        Process.setThreadPriority(19);
        while (!Thread.currentThread().isInterrupted()) {
            i[] iVarArr = this.wE;
            int length = iVarArr.length;
            int i3 = 0;
            boolean z = false;
            List<List<a>> list2 = null;
            while (true) {
                if (i3 >= length) {
                    iVar = null;
                    list = list2;
                    break;
                }
                i iVar2 = iVarArr[i3];
                list = iVar2.gn();
                if (iVar2.go()) {
                    z = true;
                }
                if (list != null && list.size() > 0) {
                    iVar = iVar2;
                    break;
                } else {
                    i3++;
                    list2 = list;
                }
            }
            if (list != null && list.size() > 0 && iVar != null) {
                Context context = this.wn.get();
                if (context == null) {
                    break;
                }
                try {
                    i2 = 0;
                    for (List<a> list3 : list) {
                        try {
                            iVar.a(context, list3);
                            i2 += list3.size();
                        } catch (Exception e) {
                            e = e;
                            i = i2;
                            this.wC++;
                            e.printStackTrace(System.out);
                            i2 = i;
                            if (i2 > 0) {
                            }
                            if (this.wC <= 0) {
                            }
                        }
                    }
                    this.wC = 0;
                } catch (Exception e2) {
                    e = e2;
                    i = 0;
                }
                if (i2 > 0) {
                    iVar.update(i2);
                }
                if (this.wC <= 0) {
                    if (this.wD) {
                        break;
                    }
                    try {
                        int i4 = this.wC * 2000;
                        if (this.wC >= 7) {
                            i4 = 60000;
                        }
                        Thread.currentThread();
                        Thread.sleep(i4);
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                } else {
                    continue;
                }
            } else if (this.wD) {
                break;
            } else if (z) {
                try {
                    Thread.currentThread();
                    Thread.sleep(10L);
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            } else {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait();
                    } catch (InterruptedException e5) {
                        e5.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        for (i iVar3 : this.wE) {
            iVar3.save();
        }
    }

    public void shutdown() {
        this.wD = true;
    }
}

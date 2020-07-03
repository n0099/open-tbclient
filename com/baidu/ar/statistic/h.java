package com.baidu.ar.statistic;

import android.content.Context;
import android.os.Process;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes3.dex */
class h implements Runnable {
    private Object mLock;
    private WeakReference<Context> uW;
    private int vl;
    private volatile boolean vm;
    private i[] vn;

    public h(Context context, Object obj, i[] iVarArr) {
        if (iVarArr == null) {
            throw new NullPointerException();
        }
        this.uW = new WeakReference<>(context);
        this.vl = 0;
        this.vm = false;
        this.mLock = obj;
        this.vn = iVarArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0082 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x000d A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        i iVar;
        int i;
        int i2;
        if (this.vn.length == 0) {
            return;
        }
        Process.setThreadPriority(19);
        while (!Thread.currentThread().isInterrupted()) {
            i[] iVarArr = this.vn;
            int length = iVarArr.length;
            int i3 = 0;
            boolean z = false;
            List<List<a>> list = null;
            while (true) {
                if (i3 >= length) {
                    iVar = null;
                    break;
                }
                i iVar2 = iVarArr[i3];
                List<List<a>> eZ = iVar2.eZ();
                if (iVar2.fa()) {
                    z = true;
                }
                if (eZ != null && eZ.size() > 0) {
                    iVar = iVar2;
                    list = eZ;
                    break;
                }
                i3++;
                list = eZ;
            }
            if (list != null && list.size() > 0 && iVar != null) {
                Context context = this.uW.get();
                if (context == null) {
                    break;
                }
                try {
                    i2 = 0;
                    for (List<a> list2 : list) {
                        try {
                            iVar.a(context, list2);
                            i2 += list2.size();
                        } catch (Exception e) {
                            e = e;
                            i = i2;
                            this.vl++;
                            e.printStackTrace(System.out);
                            i2 = i;
                            if (i2 > 0) {
                            }
                            if (this.vl <= 0) {
                            }
                        }
                    }
                    this.vl = 0;
                } catch (Exception e2) {
                    e = e2;
                    i = 0;
                }
                if (i2 > 0) {
                    iVar.update(i2);
                }
                if (this.vl <= 0) {
                    if (this.vm) {
                        break;
                    }
                    try {
                        int i4 = this.vl * 2000;
                        if (this.vl >= 7) {
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
            } else if (this.vm) {
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
        for (i iVar3 : this.vn) {
            iVar3.save();
        }
    }

    public void shutdown() {
        this.vm = true;
    }
}

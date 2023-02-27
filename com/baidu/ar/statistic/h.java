package com.baidu.ar.statistic;

import android.content.Context;
import android.os.Process;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes.dex */
public class h implements Runnable {
    public Object mLock;
    public int wC;
    public volatile boolean wD;
    public i[] wE;
    public WeakReference<Context> wn;

    public h(Context context, Object obj, i[] iVarArr) {
        if (iVarArr == null) {
            throw null;
        }
        this.wn = new WeakReference<>(context);
        this.wC = 0;
        this.wD = false;
        this.mLock = obj;
        this.wE = iVarArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x000b A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        int i;
        int i2;
        if (this.wE.length == 0) {
            return;
        }
        Process.setThreadPriority(19);
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
            i[] iVarArr = this.wE;
            int length = iVarArr.length;
            i iVar = null;
            List<List<a>> list = null;
            int i3 = 0;
            boolean z = false;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                i iVar2 = iVarArr[i3];
                List<List<a>> gn = iVar2.gn();
                if (iVar2.go()) {
                    z = true;
                }
                if (gn != null && gn.size() > 0) {
                    iVar = iVar2;
                    list = gn;
                    break;
                }
                i3++;
                list = gn;
            }
            if (list != null && list.size() > 0 && iVar != null) {
                Context context = this.wn.get();
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
                            this.wC++;
                            e.printStackTrace(System.out);
                            if (i2 > 0) {
                            }
                            if (this.wC > 0) {
                            }
                        }
                    }
                    this.wC = 0;
                } catch (Exception e2) {
                    e = e2;
                    i2 = 0;
                }
                if (i2 > 0) {
                    iVar.update(i2);
                }
                if (this.wC > 0) {
                    continue;
                } else if (this.wD) {
                    break;
                } else {
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
                }
            } else if (this.wD) {
                break;
            } else if (z) {
                Thread.currentThread();
                Thread.sleep(10L);
            } else {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait();
                    } catch (InterruptedException e4) {
                        e4.printStackTrace();
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

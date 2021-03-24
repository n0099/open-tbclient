package com.alipay.apmobilesecuritysdk.f;

import android.os.Process;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f1743a;

    public c(b bVar) {
        this.f1743a = bVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:5:0x000e */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        try {
            Process.setThreadPriority(0);
            while (!linkedList.isEmpty()) {
                linkedList2 = this.f1743a.f1742c;
                Runnable runnable = (Runnable) linkedList2.get(0);
                linkedList3 = this.f1743a.f1742c;
                linkedList3.remove(0);
                if (runnable != null) {
                    runnable.run();
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f1743a.f1741b = null;
            throw th;
        }
        this.f1743a.f1741b = null;
    }
}

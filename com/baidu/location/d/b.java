package com.baidu.location.d;

import android.util.Log;
import java.lang.ref.WeakReference;
/* loaded from: classes15.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WeakReference f2707a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f2708b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, WeakReference weakReference) {
        this.f2708b = aVar;
        this.f2707a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        a aVar = (a) this.f2707a.get();
        if (aVar != null) {
            i = aVar.h;
            if (i == 3) {
                Log.d("baidu_location_service", "baidu location service force stopped ...");
                aVar.i = false;
                aVar.b();
            }
        }
    }
}

package com.baidu.location.d;

import android.util.Log;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WeakReference f6765a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f6766b;

    public b(a aVar, WeakReference weakReference) {
        this.f6766b = aVar;
        this.f6765a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2;
        a aVar = (a) this.f6765a.get();
        if (aVar != null) {
            i2 = aVar.f6763h;
            if (i2 == 3) {
                Log.d("baidu_location_service", "baidu location service force stopped ...");
                aVar.b();
            }
        }
    }
}

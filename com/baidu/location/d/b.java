package com.baidu.location.d;

import android.util.Log;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WeakReference f6665a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f6666b;

    public b(a aVar, WeakReference weakReference) {
        this.f6666b = aVar;
        this.f6665a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2;
        a aVar = (a) this.f6665a.get();
        if (aVar != null) {
            i2 = aVar.f6663h;
            if (i2 == 3) {
                Log.d("baidu_location_service", "baidu location service force stopped ...");
                aVar.b();
            }
        }
    }
}

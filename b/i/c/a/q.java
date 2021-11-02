package b.i.c.a;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.x;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public final class q implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Activity f32955e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ m f32956f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ l f32957g;

    public q(l lVar, Activity activity, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, activity, mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32957g = lVar;
        this.f32955e = activity;
        this.f32956f = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                aVar = this.f32957g.f32942d;
                String str = this.f32955e.getApplicationInfo().packageName;
                l lVar = this.f32957g;
                l = l.l();
                aVar.a(str, Collections.singletonList(l), new Bundle(), new x(this, atomicBoolean));
                new Handler().postDelayed(new r(this, atomicBoolean), 3000L);
            } catch (RemoteException unused) {
                l lVar2 = this.f32957g;
                l.n(this.f32955e, this.f32956f);
            }
        }
    }
}

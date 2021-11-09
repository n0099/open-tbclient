package b.i.c.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class p extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m f32953a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f32954b;

    public p(l lVar, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32954b = lVar;
        this.f32953a = mVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            String action = intent.getAction();
            Bundle extras = intent.getExtras();
            if ("com.google.android.play.core.install.ACTION_INSTALL_STATUS".equals(action) && extras != null && extras.containsKey("install.status")) {
                this.f32954b.p();
                int i2 = extras.getInt("install.status");
                if (i2 == 1 || i2 == 2 || i2 == 3) {
                    this.f32953a.a(com.google.ar.core.p.f63128a);
                } else if (i2 == 4) {
                    this.f32953a.a(com.google.ar.core.p.f63130c);
                } else if (i2 != 6) {
                } else {
                    this.f32953a.a(com.google.ar.core.p.f63129b);
                }
            }
        }
    }
}

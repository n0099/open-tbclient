package com.baidu.sofire.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.sofire.MyActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public final class d implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Intent a;
    public final /* synthetic */ WeakReference b;
    public final /* synthetic */ Context c;

    public d(Intent intent, WeakReference weakReference, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {intent, weakReference, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = intent;
        this.b = weakReference;
        this.c = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                String stringExtra = this.a.getStringExtra("c");
                Intent intent = new Intent();
                intent.putExtra("t", "a");
                intent.putExtra("c", stringExtra);
                String a = MyActivity.a((Activity) this.b.get());
                if (a == null) {
                    a = "";
                }
                intent.putExtra("source", a);
                a.a(this.c.getApplicationContext(), intent);
            } catch (Throwable unused) {
                int i = b.a;
            }
        }
    }
}

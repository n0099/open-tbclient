package com.alipay.sdk.widget;

import android.os.Handler;
import com.alipay.sdk.widget.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f2057a;

    public b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2057a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.AlertDialogC0018a alertDialogC0018a;
        a.AlertDialogC0018a alertDialogC0018a2;
        a.AlertDialogC0018a alertDialogC0018a3;
        Handler handler;
        a.AlertDialogC0018a alertDialogC0018a4;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            alertDialogC0018a = this.f2057a.f2051e;
            if (alertDialogC0018a == null) {
                a aVar = this.f2057a;
                a aVar2 = this.f2057a;
                aVar.f2051e = new a.AlertDialogC0018a(aVar2, aVar2.f2052f);
                alertDialogC0018a4 = this.f2057a.f2051e;
                z = this.f2057a.k;
                alertDialogC0018a4.setCancelable(z);
            }
            try {
                alertDialogC0018a2 = this.f2057a.f2051e;
                if (alertDialogC0018a2.isShowing()) {
                    return;
                }
                alertDialogC0018a3 = this.f2057a.f2051e;
                alertDialogC0018a3.show();
                handler = this.f2057a.l;
                handler.sendEmptyMessageDelayed(1, 15000L);
            } catch (Exception e2) {
                com.alipay.sdk.util.c.a(e2);
            }
        }
    }
}

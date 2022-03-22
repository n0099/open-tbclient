package com.baidu.location.b;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class y extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ x a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(x xVar, Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xVar, looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = xVar;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x009d -> B:44:0x00a0). Please submit an issue!!! */
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.baidu.location.c.a c2;
        com.baidu.location.c.h n;
        Location d2;
        String a;
        Handler handler;
        Handler handler2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            int i = message.what;
            try {
                if (i != 1) {
                    if (i == 2) {
                        c2 = t.c();
                        n = com.baidu.location.c.i.a().n();
                        d2 = t.d();
                        a = t.a();
                    } else if (i == 3) {
                        c2 = t.c();
                        n = null;
                        d2 = t.d();
                        a = a.a().c();
                    } else if (i != 4) {
                        if (i == 7) {
                            w.a().c();
                            return;
                        } else if (i == 8 || i == 9) {
                            message.getData();
                            return;
                        } else {
                            return;
                        }
                    } else {
                        boolean i2 = com.baidu.location.c.i.i();
                        if (com.baidu.location.e.k.b()) {
                            i2 = false;
                        }
                        if (i2) {
                            h.a().d();
                        }
                        handler = this.a.f25995d;
                        if (handler != null) {
                            handler2 = this.a.f25995d;
                            handler2.sendEmptyMessageDelayed(4, com.baidu.location.e.k.R);
                        }
                    }
                    w.a(c2, n, d2, a);
                    return;
                }
                Bundle data = message.getData();
                Location location = (Location) data.getParcelable("loc");
                data.getInt("satnum");
                if (location != null) {
                    d.a().a(location);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}

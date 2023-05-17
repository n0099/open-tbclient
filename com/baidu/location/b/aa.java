package com.baidu.location.b;

import android.location.GnssNavigationMessage;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class aa extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ z a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(z zVar, Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zVar, looper};
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
        this.a = zVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.baidu.location.c.a c;
        com.baidu.location.c.j n;
        Location d;
        String a;
        Handler handler;
        Handler handler2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            int i = message.what;
            if (i == 1) {
                Bundle data = message.getData();
                try {
                    Location location = (Location) data.getParcelable("loc");
                    data.getInt("satnum");
                    if (location != null) {
                        h.a().a(location);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (i == 2) {
                c = u.c();
                n = com.baidu.location.c.k.a().n();
                d = u.d();
                a = u.a();
            } else if (i != 3) {
                if (i == 4) {
                    boolean i2 = com.baidu.location.c.k.a().i();
                    if (com.baidu.location.e.k.b()) {
                        i2 = false;
                    }
                    if (i2) {
                        l.a().d();
                    }
                    try {
                        handler = this.a.d;
                        if (handler != null) {
                            handler2 = this.a.d;
                            handler2.sendEmptyMessageDelayed(4, com.baidu.location.e.k.Q);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    x.a().b();
                    return;
                } else if (i == 7) {
                    y.a().c();
                    return;
                } else if (i == 8 || i == 9) {
                    message.getData();
                    return;
                } else if (i != 11) {
                    return;
                } else {
                    Bundle data2 = message.getData();
                    try {
                        long j = data2.getLong("gps_time");
                        x.a().a((GnssNavigationMessage) data2.getParcelable("gnss_navigation_message"), j);
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
            } else {
                c = u.c();
                n = null;
                d = u.d();
                a = b.a().c();
            }
            y.a(c, n, d, a, u.e());
        }
    }
}

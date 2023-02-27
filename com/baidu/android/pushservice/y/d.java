package com.baidu.android.pushservice.y;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.pushservice.PushServiceReceiver;
import com.baidu.android.pushservice.a0.h;
import com.baidu.android.pushservice.a0.i;
import com.baidu.android.pushservice.a0.j;
import com.baidu.android.pushservice.a0.k;
import com.baidu.android.pushservice.pull.ClientEventInfo;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.y.e.f;
import com.baidu.android.pushservice.y.e.g;
import com.baidu.android.pushservice.z.e;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.ByteString;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends com.baidu.android.pushservice.z.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context c;
        public final /* synthetic */ ClientEventInfo d;

        public a(Context context, ClientEventInfo clientEventInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, clientEventInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = context;
            this.d = clientEventInfo;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (d.a) {
                    if (c.b(this.c, this.d)) {
                        b.a(this.d.getSource());
                        try {
                            com.baidu.android.pushservice.y.a.a(this.c).a(d.c(this.c, this.d), d.b(this.c), this.d);
                        } catch (Exception unused) {
                            Utility.a(this.c, this.d, false);
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-676423281, "Lcom/baidu/android/pushservice/y/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-676423281, "Lcom/baidu/android/pushservice/y/d;");
                return;
            }
        }
        a = new Object();
    }

    public static long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (System.currentTimeMillis() & 2147483647L) | (-2147483648L) : invokeV.longValue;
    }

    public static ByteString b(Context context, ClientEventInfo clientEventInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, clientEventInfo)) == null) {
            g.b f = g.Z().d(Utility.a(context, clientEventInfo.getHasConfirmDialog())).i(com.baidu.android.pushservice.l.d.i(context).b()).h(j.f(context) ? 1 : 2).b(3).e(Utility.a(context, false)).g(context.getPackageName()).g(com.baidu.android.pushservice.l.d.q(context) ? 1 : 0).d(h.b(context)).a(Utility.a(context, clientEventInfo.getHasConfirmDialog(), clientEventInfo.getIId())).c(Utility.b(context, clientEventInfo.getHasConfirmDialog(), clientEventInfo.getIId())).b(i.a(context, "last_time", System.currentTimeMillis() / 1000)).j(clientEventInfo.getSource()).h(clientEventInfo.getComponentName()).a(clientEventInfo.getAction() == null ? "" : clientEventInfo.getAction()).b(Utility.A(context)).a(Utility.B(context) ? 1 : 2).c(Utility.p(context)).e(Utility.x(context)).f(Build.VERSION.RELEASE).i(Utility.y(context)).a(Utility.u(context)).f(com.baidu.android.pushservice.t.a.a(context).b());
            return ByteString.copyFrom(f.j(context.getResources().getDisplayMetrics().density + "").c(k.a(context, "last_update_config_time", 0L) / 1000).build().toByteArray());
        }
        return (ByteString) invokeLL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            com.baidu.android.pushservice.g.d(context);
            String str = com.baidu.android.pushservice.g.d() + "/pull";
            String b = k.b(context, "push_ach_bypass_key");
            if (TextUtils.isEmpty(b)) {
                return str;
            }
            return str + "/" + b;
        }
        return (String) invokeL.objValue;
    }

    public static byte[] c(Context context, ClientEventInfo clientEventInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, clientEventInfo)) == null) {
            return f.x().b(com.baidu.android.pushservice.w.h.i.a()).d(com.baidu.android.pushservice.a.a()).a(b()).a(Utility.n(context, context.getPackageName()) ? "BaiduApp" : "DevApp").a(-76508268).c(3).a(b(context, clientEventInfo)).build().toByteArray();
        }
        return (byte[]) invokeLL.objValue;
    }

    public static boolean d(Context context, ClientEventInfo clientEventInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, clientEventInfo)) == null) {
            if (clientEventInfo == null) {
                clientEventInfo = new ClientEventInfo();
            }
            try {
                Intent intent = new Intent("com.baidu.android.pushservice.action.receiver.pullmsg");
                intent.setPackage(context.getPackageName());
                intent.setClass(context, PushServiceReceiver.class);
                intent.putExtra("pull_msg_event_info", clientEventInfo);
                context.sendBroadcast(intent);
                return true;
            } catch (Exception unused) {
                Utility.a(context, clientEventInfo, true);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void e(Context context, ClientEventInfo clientEventInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, clientEventInfo) == null) {
            e.a().a(new a(context, clientEventInfo));
        }
    }
}

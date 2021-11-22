package b.a.d0;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import b.a.e0.r.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.poly.widget.WechatSignAutoRenewActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e implements b.a.e0.s.g.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static e f1450c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f1451a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1452b;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e this$0;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = eVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && this.this$0.f1452b) {
                this.this$0.f1452b = false;
                try {
                    int intExtra = intent.getIntExtra("code", 0);
                    Intent intent2 = new Intent(PolyActivity.invokerActivity, WechatSignAutoRenewActivity.class);
                    intent2.putExtra("code", intExtra);
                    PolyActivity.invokerActivity.startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        public /* synthetic */ b(e eVar, a aVar) {
            this(eVar);
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1452b = false;
    }

    public static e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f1450c == null) {
                synchronized (e.class) {
                    if (f1450c == null) {
                        f1450c = new e();
                    }
                }
            }
            return f1450c;
        }
        return (e) invokeV.objValue;
    }

    @Override // b.a.e0.s.g.c
    public void a(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, str, str2) == null) {
            h.b("WECHAT signWechatAutoRenew appId=" + str);
            b.a.d0.h.a a2 = b.a.d0.a.a();
            if (a2 == null) {
                return;
            }
            if (!a2.b(activity)) {
                b.a.e0.t.e.b.f(activity, "您没有安装微信，请选择其他支付方式");
                activity.finish();
                return;
            }
            this.f1452b = true;
            f();
            e();
            a2.a(activity, str, str2);
            activity.finish();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f1451a = new b(this, null);
            PolyActivity.invokerActivity.getApplicationContext().registerReceiver(this.f1451a, new IntentFilter("com_baidu_poly_cashier_wechat_sign_auto_renew_receiver"));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f1451a == null) {
            return;
        }
        try {
            PolyActivity.invokerActivity.getApplicationContext().unregisterReceiver(this.f1451a);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

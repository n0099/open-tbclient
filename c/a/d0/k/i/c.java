package c.a.d0.k.i;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import c.a.d0.g;
import c.a.d0.k.h.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PayWebActivity;
import com.baidu.poly.widget.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.walletfacesdk.LightInvokerImpl;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f1862a;

    /* loaded from: classes.dex */
    public class a extends c.a.d0.k.a.a<Map<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f1863a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ m f1864b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f1865c;

        /* renamed from: c.a.d0.k.i.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0032a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.d0.p.c f1866e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f1867f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f1868g;

            public RunnableC0032a(a aVar, c.a.d0.p.c cVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, cVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1868g = aVar;
                this.f1866e = cVar;
                this.f1867f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.d0.p.c cVar = this.f1866e;
                    if (cVar != null && cVar.u()) {
                        this.f1866e.q();
                    }
                    this.f1868g.f1864b.a(0, this.f1867f);
                }
            }
        }

        public a(c cVar, String str, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1865c = cVar;
            this.f1863a = str;
            this.f1864b = mVar;
        }

        @Override // c.a.d0.k.a.a
        public void b(Throwable th, String str) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                if (str != null) {
                    message = str;
                } else {
                    message = th != null ? th.getMessage() : null;
                }
                m mVar = this.f1864b;
                mVar.a("launchpayment error msg is " + message, str);
                c.a.d0.k.h.b bVar = new c.a.d0.k.h.b("1");
                bVar.c(new com.baidu.poly.a.i.a("launchpayment error --> " + str, th).U());
                d.b(bVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d0.k.a.a
        /* renamed from: c */
        public void a(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
                d.f1828c = map.get("orderId");
                if (!map.containsKey("parentType")) {
                    this.f1865c.d(map, this.f1863a, this.f1864b);
                    return;
                }
                String str = map.get("parentType");
                if (TextUtils.isEmpty(str)) {
                    this.f1865c.d(map, this.f1863a, this.f1864b);
                } else if (4 != Integer.parseInt(str)) {
                    this.f1865c.d(map, this.f1863a, this.f1864b);
                } else {
                    String a2 = c.a.d0.n.b.a(0, map.get("orderId"), "Successful payment");
                    c.a.d0.p.c cVar = new c.a.d0.p.c(View.inflate(this.f1864b.getContext(), g.pay_success, null), -1, -1, true);
                    cVar.y(false);
                    cVar.A(false);
                    cVar.C(false);
                    cVar.E(this.f1864b, 0, 0, 0);
                    new Handler().postDelayed(new RunnableC0032a(this, cVar, a2), 2000L);
                    c.a.d0.k.h.a.g("8");
                    c.a.d0.n.d.e("WalletList->pay() 命中0单元");
                }
            }
        }
    }

    public c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1862a = bVar;
    }

    public final void a(Activity activity, String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, activity, str, map) == null) || activity == null || TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent(activity, PayWebActivity.class);
        intent.putExtra("load_url", str);
        Bundle bundle = new Bundle();
        for (String str2 : map.keySet()) {
            bundle.putString(str2, map.get(str2));
        }
        intent.putExtra("launch_payment_data", bundle);
        activity.startActivityForResult(intent, 200);
    }

    public void c(Bundle bundle, String str, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, str, mVar) == null) {
            c.a.d0.k.b.b.j().d(bundle, new a(this, str, mVar), str);
        }
    }

    public final void d(Map<String, String> map, String str, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, map, str, mVar) == null) {
            String str2 = map.get("extData");
            if (!TextUtils.isEmpty(str2)) {
                try {
                    if (TextUtils.equals(new JSONObject(str2).optString(LightInvokerImpl.VOICE_ACTIONTYPE), "H5")) {
                        String str3 = map.get("payUrl");
                        if (!TextUtils.isEmpty(str3)) {
                            if (e(mVar.getContext())) {
                                mVar.setWechatH5Pay(true);
                                mVar.setIsPreparePaying(false);
                                a((Activity) mVar.getContext(), str3, map);
                                c.a.d0.k.h.a.g("8");
                                return;
                            }
                            Toast.makeText(mVar.getContext(), "您没有安装微信，请选择其他支付方式", 0).show();
                            mVar.a(3, "wx_not_installed");
                            return;
                        }
                        mVar.a("H5 no corresponding url ", (String) null);
                        c.a.d0.k.h.a.d("8", null, "H5 no corresponding url");
                        return;
                    }
                } catch (Exception unused) {
                    mVar.a("launchpayment extData analyze failed ", (String) null);
                    c.a.d0.k.h.a.d("8", null, "launchpayment extData analyze failed");
                    return;
                }
            }
            this.f1862a.b(map, str, mVar);
        }
    }

    public final boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
            if (installedPackages != null) {
                for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                    if (installedPackages.get(i2).packageName.equals("com.tencent.mm")) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}

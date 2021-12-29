package c.a.h0.s;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import c.a.h0.i;
import c.a.h0.l.g;
import c.a.h0.p.f;
import c.a.h0.r.e;
import c.a.h0.r.h;
import c.a.h0.r.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.statistics.exception.SdkException;
import com.baidu.poly.wallet.paychannel.IChannelPay;
import com.baidu.poly.widget.ChannelListView;
import com.baidu.poly.widget.PayChannelEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;

    /* renamed from: b  reason: collision with root package name */
    public IChannelPay f3698b;

    /* loaded from: classes.dex */
    public class a extends c.a.h0.l.a<Map<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f3699b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f3700c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f3701d;

        public a(c cVar, String str, ChannelListView channelListView, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, channelListView, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3701d = cVar;
            this.a = str;
            this.f3699b = channelListView;
            this.f3700c = str2;
        }

        @Override // c.a.h0.l.a
        public void b(Throwable th, String str) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                if (str != null) {
                    message = str;
                } else {
                    message = th != null ? th.getMessage() : null;
                }
                ChannelListView channelListView = this.f3699b;
                channelListView.errorEnd(l.a().getString(i.pay_second_interface_fail) + message, str);
                c.a.h0.p.c cVar = new c.a.h0.p.c("1");
                cVar.b(new SdkException("pay_platform error --> " + str, th).getStackMessage());
                f.e(cVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.h0.l.a
        /* renamed from: d */
        public void c(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("exceptionCode", "0");
                if (!TextUtils.isEmpty(this.a)) {
                    hashMap.put("isFoldChannel", this.a);
                }
                c.a.h0.p.b.c("8", hashMap);
                this.f3699b.hideToastLoading();
                this.f3701d.f("STEP_INNER", map, this.f3700c, this.f3699b, null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.h0.s.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f3702b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f3703c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f3704d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f3705e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f3706f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f3707g;

        public b(c cVar, String str, Map map, ChannelListView channelListView, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, map, channelListView, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3707g = cVar;
            this.a = str;
            this.f3702b = map;
            this.f3703c = channelListView;
            this.f3704d = str2;
            this.f3705e = str3;
            this.f3706f = str4;
        }

        @Override // c.a.h0.s.g.a
        public void onResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                h.g("WalletChannel->thirdPay onResult statusCode = " + i2 + " msg = " + str);
                if (TextUtils.equals(this.a, "DIRECT_OUTTER")) {
                    this.f3707g.e(i2, str, this.f3702b, this.f3703c, this.f3704d);
                    return;
                }
                this.f3703c.payEnd(i2, e.a(i2, this.f3705e, str), "1", this.a, this.f3702b, this.f3706f);
            }
        }
    }

    /* renamed from: c.a.h0.s.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0139c extends c.a.h0.l.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0139c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.h0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.h0.l.a
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }
    }

    public c(Activity activity, IChannelPay iChannelPay) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, iChannelPay};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = activity;
        this.f3698b = iChannelPay;
    }

    public void b(Bundle bundle, PayChannelEntity payChannelEntity, String str, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, bundle, payChannelEntity, str, channelListView) == null) || payChannelEntity == null) {
            return;
        }
        String payChannel = payChannelEntity.getPayChannel();
        String installmentPeriod = payChannelEntity.getInstallmentPeriod();
        if (TextUtils.isEmpty(payChannel)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(c.a.h0.l.h.b.f3593b, payChannel);
        if (!TextUtils.isEmpty(installmentPeriod)) {
            jSONObject.put(c.a.h0.l.h.b.f3594c, installmentPeriod);
        }
        bundle.putString("reqData", jSONObject.toString());
        c.a.h0.l.h.b.j().u(bundle, new a(this, str, channelListView, payChannel));
    }

    public JSONObject c(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            if (TextUtils.isEmpty(map.get("payInfo"))) {
                return null;
            }
            try {
                return new JSONObject(new String(Base64.decode(map.get("payInfo"), 0)));
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public void d(Map<String, String> map, PayChannelEntity payChannelEntity, String str, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, map, payChannelEntity, str, channelListView) == null) {
            try {
                b(c.a.h0.r.i.a(map), payChannelEntity, str, channelListView);
            } catch (Throwable th) {
                String message = th.getMessage();
                channelListView.errorEnd("third pay error msg is " + message, null);
            }
        }
    }

    public final void e(int i2, String str, Map<String, String> map, ChannelListView channelListView, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, map, channelListView, str2}) == null) {
            if (!TextUtils.isEmpty(str2) && i2 == 0) {
                new g().d(str2, new c.a.h0.l.c(), new C0139c(this));
            }
            channelListView.payEnd(i2, c.a.h0.r.d.a(map.get("orderId"), map.get("payInfo"), str), "1");
        }
    }

    public void f(String str, Map<String, String> map, String str2, ChannelListView channelListView, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, str, map, str2, channelListView, str3) == null) {
            c.a.h0.s.g.b bVar = new c.a.h0.s.g.b();
            bVar.f3730b = c(map);
            bVar.a = str2;
            String str4 = map.get("payOrderNo");
            f.f3667f = str4;
            if (this.f3698b != null) {
                c.a.h0.p.b.d();
                this.f3698b.pay(this.a, bVar, new b(this, str, map, channelListView, str3, str4, str2));
                h.g("WalletChannel->thirdPay setIsPreparePaying()");
                channelListView.setIsPreparePaying(false);
            }
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (Activity) invokeV.objValue;
    }
}

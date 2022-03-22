package c.a.e0.j;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import c.a.e0.c.g;
import c.a.e0.g.f;
import c.a.e0.i.e;
import c.a.e0.i.h;
import c.a.e0.i.i;
import c.a.e0.i.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.statistics.exception.SdkException;
import com.baidu.poly.wallet.paychannel.IChannelPay;
import com.baidu.poly.widget.ChannelListView;
import com.baidu.poly.widget.PayChannelEntity;
import com.baidu.tieba.R;
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
    public IChannelPay f2822b;

    /* loaded from: classes.dex */
    public class a extends c.a.e0.c.a<Map<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f2823b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f2824c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f2825d;

        public a(c cVar, String str, ChannelListView channelListView, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, channelListView, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2825d = cVar;
            this.a = str;
            this.f2823b = channelListView;
            this.f2824c = str2;
        }

        @Override // c.a.e0.c.a
        public void b(Throwable th, String str) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                if (str != null) {
                    message = str;
                } else {
                    message = th != null ? th.getMessage() : null;
                }
                ChannelListView channelListView = this.f2823b;
                channelListView.R(l.a().getString(R.string.obfuscated_res_0x7f0f0d47) + message, str);
                c.a.e0.g.c cVar = new c.a.e0.g.c("1");
                cVar.b(new SdkException("pay_platform error --> " + str, th).getStackMessage());
                f.e(cVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e0.c.a
        /* renamed from: d */
        public void c(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("exceptionCode", "0");
                if (!TextUtils.isEmpty(this.a)) {
                    hashMap.put("isFoldChannel", this.a);
                }
                c.a.e0.g.b.c("8", hashMap);
                this.f2823b.V();
                this.f2825d.f("STEP_INNER", map, this.f2824c, this.f2823b, null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.e0.j.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f2826b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f2827c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f2828d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f2829e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f2830f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f2831g;

        public b(c cVar, String str, Map map, ChannelListView channelListView, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, map, channelListView, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2831g = cVar;
            this.a = str;
            this.f2826b = map;
            this.f2827c = channelListView;
            this.f2828d = str2;
            this.f2829e = str3;
            this.f2830f = str4;
        }

        @Override // c.a.e0.j.g.a
        public void onResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                h.g("WalletChannel->thirdPay onResult statusCode = " + i + " msg = " + str);
                if (TextUtils.equals(this.a, "DIRECT_OUTTER")) {
                    this.f2831g.e(i, str, this.f2826b, this.f2827c, this.f2828d);
                    return;
                }
                this.f2827c.b0(i, e.a(i, this.f2829e, str), "1", this.a, this.f2826b, this.f2830f);
            }
        }
    }

    /* renamed from: c.a.e0.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0127c extends c.a.e0.c.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0127c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.e0.c.a
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e0.c.a
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = activity;
        this.f2822b = iChannelPay;
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
        jSONObject.put(c.a.e0.c.h.b.f2731b, payChannel);
        if (!TextUtils.isEmpty(installmentPeriod)) {
            jSONObject.put(c.a.e0.c.h.b.f2732c, installmentPeriod);
        }
        bundle.putString("reqData", jSONObject.toString());
        c.a.e0.c.h.b.j().u(bundle, new a(this, str, channelListView, payChannel));
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
                b(i.a(map), payChannelEntity, str, channelListView);
            } catch (Throwable th) {
                String message = th.getMessage();
                channelListView.R("third pay error msg is " + message, null);
            }
        }
    }

    public final void e(int i, String str, Map<String, String> map, ChannelListView channelListView, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, map, channelListView, str2}) == null) {
            if (!TextUtils.isEmpty(str2) && i == 0) {
                new g().d(str2, new c.a.e0.c.c(), new C0127c(this));
            }
            channelListView.a0(i, c.a.e0.i.d.a(map.get("orderId"), map.get("payInfo"), str), "1");
        }
    }

    public void f(String str, Map<String, String> map, String str2, ChannelListView channelListView, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, str, map, str2, channelListView, str3) == null) {
            c.a.e0.j.g.b bVar = new c.a.e0.j.g.b();
            bVar.f2853b = c(map);
            bVar.a = str2;
            String str4 = map.get("payOrderNo");
            f.f2797f = str4;
            if (this.f2822b != null) {
                c.a.e0.g.b.d();
                this.f2822b.pay(this.a, bVar, new b(this, str, map, channelListView, str3, str4, str2));
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

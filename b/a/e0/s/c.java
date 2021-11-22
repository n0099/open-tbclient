package b.a.e0.s;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import b.a.e0.i;
import b.a.e0.l.g;
import b.a.e0.p.f;
import b.a.e0.r.e;
import b.a.e0.r.h;
import b.a.e0.r.l;
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

    /* renamed from: a  reason: collision with root package name */
    public Activity f2719a;

    /* renamed from: b  reason: collision with root package name */
    public IChannelPay f2720b;

    /* loaded from: classes.dex */
    public class a extends b.a.e0.l.a<Map<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2721a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f2722b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f2723c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f2724d;

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
            this.f2724d = cVar;
            this.f2721a = str;
            this.f2722b = channelListView;
            this.f2723c = str2;
        }

        @Override // b.a.e0.l.a
        public void b(Throwable th, String str) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                if (str != null) {
                    message = str;
                } else {
                    message = th != null ? th.getMessage() : null;
                }
                ChannelListView channelListView = this.f2722b;
                channelListView.errorEnd(l.a().getString(i.pay_second_interface_fail) + message, str);
                b.a.e0.p.c cVar = new b.a.e0.p.c("1");
                cVar.b(new SdkException("pay_platform error --> " + str, th).getStackMessage());
                f.e(cVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e0.l.a
        /* renamed from: d */
        public void c(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("exceptionCode", "0");
                if (!TextUtils.isEmpty(this.f2721a)) {
                    hashMap.put("isFoldChannel", this.f2721a);
                }
                b.a.e0.p.b.c("8", hashMap);
                this.f2722b.hideToastLoading();
                this.f2724d.f("STEP_INNER", map, this.f2723c, this.f2722b, null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.e0.s.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2725a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f2726b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f2727c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f2728d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f2729e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f2730f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f2731g;

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
            this.f2731g = cVar;
            this.f2725a = str;
            this.f2726b = map;
            this.f2727c = channelListView;
            this.f2728d = str2;
            this.f2729e = str3;
            this.f2730f = str4;
        }

        @Override // b.a.e0.s.g.a
        public void onResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                h.g("WalletChannel->thirdPay onResult statusCode = " + i2 + " msg = " + str);
                if (TextUtils.equals(this.f2725a, "DIRECT_OUTTER")) {
                    this.f2731g.e(i2, str, this.f2726b, this.f2727c, this.f2728d);
                    return;
                }
                this.f2727c.payEnd(i2, e.a(i2, this.f2729e, str), "1", this.f2725a, this.f2726b, this.f2730f);
            }
        }
    }

    /* renamed from: b.a.e0.s.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0055c extends b.a.e0.l.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0055c(c cVar) {
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

        @Override // b.a.e0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e0.l.a
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
        this.f2719a = activity;
        this.f2720b = iChannelPay;
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
        jSONObject.put(b.a.e0.l.h.b.f2580b, payChannel);
        if (!TextUtils.isEmpty(installmentPeriod)) {
            jSONObject.put(b.a.e0.l.h.b.f2581c, installmentPeriod);
        }
        bundle.putString("reqData", jSONObject.toString());
        b.a.e0.l.h.b.j().u(bundle, new a(this, str, channelListView, payChannel));
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
                b(b.a.e0.r.i.a(map), payChannelEntity, str, channelListView);
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
                new g().d(str2, new b.a.e0.l.c(), new C0055c(this));
            }
            channelListView.payEnd(i2, b.a.e0.r.d.a(map.get("orderId"), map.get("payInfo"), str), "1");
        }
    }

    public void f(String str, Map<String, String> map, String str2, ChannelListView channelListView, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, str, map, str2, channelListView, str3) == null) {
            b.a.e0.s.g.b bVar = new b.a.e0.s.g.b();
            bVar.f2766b = c(map);
            bVar.f2765a = str2;
            String str4 = map.get("payOrderNo");
            f.f2679f = str4;
            if (this.f2720b != null) {
                b.a.e0.p.b.d();
                this.f2720b.pay(this.f2719a, bVar, new b(this, str, map, channelListView, str3, str4, str2));
                h.g("WalletChannel->thirdPay setIsPreparePaying()");
                channelListView.setIsPreparePaying(false);
            }
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2719a : (Activity) invokeV.objValue;
    }
}

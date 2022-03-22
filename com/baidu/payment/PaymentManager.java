package com.baidu.payment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.e0.b;
import c.a.e0.j.e.a;
import c.a.e0.k.c;
import c.a.e0.k.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.wallet.paychannel.IChannelPay;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PaymentManager {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static c.a.e0.b f28164b = null;

    /* renamed from: c  reason: collision with root package name */
    public static c.a.e0.j.g.a f28165c = null;

    /* renamed from: d  reason: collision with root package name */
    public static int f28166d = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes4.dex */
    public class a extends b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.c0.e.b a;

        public a(PaymentManager paymentManager, c.a.c0.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.e0.b.c
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                if (i == 3) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        jSONObject.put("statusCode", 6);
                        this.a.onPayResult(6, jSONObject.toString());
                        return;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        this.a.onPayResult(6, str);
                        return;
                    }
                }
                this.a.onPayResult(i, str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.c0.e.d a;

        public b(PaymentManager paymentManager, c.a.c0.e.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.e0.b.d
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.onError(str);
            }
        }

        @Override // c.a.e0.b.d
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.onSuccess(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.c0.e.a a;

        public c(PaymentManager paymentManager, c.a.c0.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.e0.k.c.d
        public void a(boolean z, a.C0134a c0134a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, c0134a) == null) {
                this.a.a(z, c0134a == null ? null : c0134a.a());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements c.a.e0.j.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.c0.e.c a;

        public d(PaymentManager paymentManager, c.a.c0.e.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.e0.j.e.a
        public void a(a.C0129a c0129a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c0129a) == null) {
                this.a.a(a.C0129a.a(c0129a));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(222846301, "Lcom/baidu/payment/PaymentManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(222846301, "Lcom/baidu/payment/PaymentManager;");
        }
    }

    public PaymentManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = AppRuntime.getAppContext();
    }

    public static c.a.e0.b f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            c.a.e0.b bVar = f28164b;
            if (bVar != null) {
                return bVar;
            }
            f28166d = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("poly_cashier_env", 1);
            b.C0116b c0116b = new b.C0116b();
            c0116b.g(f28166d);
            c0116b.e(context.getApplicationContext());
            c0116b.f(false);
            c.a.e0.b d2 = c0116b.d();
            f28164b = d2;
            return d2;
        }
        return (c.a.e0.b) invokeL.objValue;
    }

    public static void g(c.a.e0.j.g.a aVar, int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65542, null, aVar, i, str) == null) || aVar == null) {
            return;
        }
        int i2 = 2;
        if (i == 0) {
            i2 = 0;
        } else if (i == 1) {
            i2 = 1;
        } else if (i != 2) {
            i2 = 3;
        }
        aVar.onResult(i2, str);
    }

    public static void i(int i, String str) {
        c.a.e0.j.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65543, null, i, str) == null) || (aVar = f28165c) == null) {
            return;
        }
        aVar.onResult(i, AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f0f21) + str);
        f28165c = null;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean d(Activity activity, String str, c.a.c0.e.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, str, bVar)) == null) {
            if (TextUtils.isEmpty(str) || activity == null) {
                return false;
            }
            c.a.c0.a.a().c(activity, str, bVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean e(Activity activity, String str, c.a.c0.e.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, bVar)) == null) {
            if (TextUtils.isEmpty(str) || activity == null) {
                return false;
            }
            c.a.c0.a.a().e(activity, str, bVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final IChannelPay h(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) ? new IChannelPay(this, activity) { // from class: com.baidu.payment.PaymentManager.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PaymentManager this$0;
            public final /* synthetic */ Activity val$businessActivity;

            /* renamed from: com.baidu.payment.PaymentManager$2$a */
            /* loaded from: classes4.dex */
            public class a implements c.a.c0.e.b {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c.a.e0.j.g.a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AnonymousClass2 f28167b;

                public a(AnonymousClass2 anonymousClass2, c.a.e0.j.g.a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {anonymousClass2, aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f28167b = anonymousClass2;
                    this.a = aVar;
                }

                @Override // c.a.c0.e.b
                public void onPayResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        c.a.e0.j.g.a aVar = this.a;
                        PaymentManager.g(aVar, i, this.f28167b.this$0.a.getString(R.string.obfuscated_res_0x7f0f025e) + str);
                    }
                }
            }

            /* renamed from: com.baidu.payment.PaymentManager$2$b */
            /* loaded from: classes4.dex */
            public class b implements c.a.c0.e.b {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c.a.e0.j.g.a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AnonymousClass2 f28168b;

                public b(AnonymousClass2 anonymousClass2, c.a.e0.j.g.a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {anonymousClass2, aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f28168b = anonymousClass2;
                    this.a = aVar;
                }

                @Override // c.a.c0.e.b
                public void onPayResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        c.a.e0.j.g.a aVar = this.a;
                        PaymentManager.g(aVar, i, this.f28168b.this$0.a.getString(R.string.obfuscated_res_0x7f0f15aa) + str);
                    }
                }
            }

            /* renamed from: com.baidu.payment.PaymentManager$2$c */
            /* loaded from: classes4.dex */
            public class c implements c.a.c0.e.b {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c.a.e0.j.g.a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AnonymousClass2 f28169b;

                public c(AnonymousClass2 anonymousClass2, c.a.e0.j.g.a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {anonymousClass2, aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f28169b = anonymousClass2;
                    this.a = aVar;
                }

                @Override // c.a.c0.e.b
                public void onPayResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        c.a.e0.j.g.a aVar = this.a;
                        PaymentManager.g(aVar, i, this.f28169b.this$0.a.getString(R.string.obfuscated_res_0x7f0f02c7) + str);
                    }
                }
            }

            /* renamed from: com.baidu.payment.PaymentManager$2$d */
            /* loaded from: classes4.dex */
            public class d implements c.a.c0.e.b {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c.a.e0.j.g.a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AnonymousClass2 f28170b;

                public d(AnonymousClass2 anonymousClass2, c.a.e0.j.g.a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {anonymousClass2, aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f28170b = anonymousClass2;
                    this.a = aVar;
                }

                @Override // c.a.c0.e.b
                public void onPayResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        c.a.e0.j.g.a aVar = this.a;
                        PaymentManager.g(aVar, i, this.f28170b.this$0.a.getString(R.string.obfuscated_res_0x7f0f03b1) + str);
                    }
                }
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, activity};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$businessActivity = activity;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
                if (r1.equals("BAIDU-CHINAPAY-B2C") != false) goto L14;
             */
            @Override // com.baidu.poly.wallet.paychannel.IChannelPay
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void pay(Activity activity2, c.a.e0.j.g.b bVar, c.a.e0.j.g.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, activity2, bVar, aVar) == null) {
                    char c2 = 6;
                    if (bVar == null || TextUtils.isEmpty(bVar.a) || bVar.f2853b == null) {
                        PaymentManager.g(aVar, 6, this.this$0.a.getString(R.string.obfuscated_res_0x7f0f0cdc));
                        return;
                    }
                    String str = bVar.a;
                    switch (str.hashCode()) {
                        case -1844318602:
                            if (str.equals("BAIDU-ALIPAY-WISE-HUABEI-INSTALLMENT")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1537577171:
                            if (str.equals("BAIDU-QUICKPAY")) {
                                c2 = 5;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1021180251:
                            if (str.equals("BAIDU-ALIPAY-WISE-HUABEI-PAY")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 299450696:
                            if (str.equals("BAIDU-BAIFUBAO-WISE")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1455583605:
                            if (str.equals("BAIDU-ALIPAY-WISE")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1525377225:
                            break;
                        case 2009937959:
                            if (str.equals("BAIDU-SUPER-WECHAT-WISE")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                        case 1:
                        case 2:
                            c.a.c0.b f2 = c.a.c0.b.f();
                            Activity activity3 = this.val$businessActivity;
                            if (activity3 == null) {
                                activity3 = activity2;
                            }
                            f2.a(activity3, bVar.f2853b.optString("orderInfo"), new a(this, aVar));
                            break;
                        case 3:
                            c.a.c0.b.f().e(activity2, bVar.f2853b, new b(this, aVar));
                            break;
                        case 4:
                            c.a.c0.b f3 = c.a.c0.b.f();
                            Activity activity4 = this.val$businessActivity;
                            if (activity4 == null) {
                                activity4 = activity2;
                            }
                            f3.b(activity4, bVar.f2853b.optString("orderInfo"), new c(this, aVar));
                            break;
                        case 5:
                            c.a.e0.j.g.a unused = PaymentManager.f28165c = aVar;
                            c.a.c0.c.c();
                            c.a.c0.b.f().d(activity2, bVar.f2853b);
                            break;
                        case 6:
                            c.a.c0.b.f().c(activity2, bVar.f2853b, new d(this, aVar));
                            break;
                        default:
                            aVar.onResult(3, this.this$0.a.getString(R.string.obfuscated_res_0x7f0f147c));
                            break;
                    }
                    activity2.finish();
                }
            }
        } : (IChannelPay) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void j(Activity activity, JSONObject jSONObject, String[] strArr, c.a.c0.e.b bVar) {
        char c2;
        char c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, jSONObject, strArr, bVar) == null) {
            String[] strArr2 = strArr;
            if (activity == null) {
                return;
            }
            Bundle bundle = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, jSONObject.optString(next));
            }
            String str = "BAIDU-CHINAPAY-B2C";
            if (strArr2 != null) {
                String[] strArr3 = new String[strArr2.length];
                int i = 0;
                while (i < strArr2.length) {
                    String str2 = strArr2[i];
                    switch (str2.hashCode()) {
                        case -2122629326:
                            if (str2.equals("Huabei")) {
                                c3 = 4;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case -1708856474:
                            if (str2.equals("WeChat")) {
                                c3 = 1;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case -1001747525:
                            if (str2.equals("Quickpay")) {
                                c3 = 3;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 1725926417:
                            if (str2.equals("Chinapay")) {
                                c3 = 5;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 1865715419:
                            if (str2.equals("BDWallet")) {
                                c3 = 2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 1963873898:
                            if (str2.equals("Alipay")) {
                                c3 = 0;
                                break;
                            }
                            c3 = 65535;
                            break;
                        default:
                            c3 = 65535;
                            break;
                    }
                    if (c3 == 0) {
                        strArr3[i] = "BAIDU-ALIPAY-WISE";
                    } else if (c3 == 1) {
                        strArr3[i] = "BAIDU-SUPER-WECHAT-WISE";
                    } else if (c3 == 2) {
                        strArr3[i] = "BAIDU-BAIFUBAO-WISE";
                    } else if (c3 == 3) {
                        strArr3[i] = "BAIDU-QUICKPAY";
                    } else if (c3 == 4) {
                        strArr3[i] = "BAIDU-ALIPAY-WISE-HUABEI-PAY";
                    } else if (c3 == 5) {
                        strArr3[i] = "BAIDU-CHINAPAY-B2C";
                    }
                    i++;
                    strArr2 = strArr;
                }
                bundle = bundle;
                bundle.putStringArray("blockedPayChannels", strArr3);
            }
            String string = bundle.getString(PolyActivity.CHOSEN_CHANNEL_KEY, "");
            if (!TextUtils.isEmpty(string)) {
                switch (string.hashCode()) {
                    case -2122629326:
                        if (string.equals("Huabei")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1708856474:
                        if (string.equals("WeChat")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1001747525:
                        if (string.equals("Quickpay")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1725926417:
                        if (string.equals("Chinapay")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1865715419:
                        if (string.equals("BDWallet")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1963873898:
                        if (string.equals("Alipay")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0) {
                    str = "BAIDU-ALIPAY-WISE";
                } else if (c2 == 1) {
                    str = "BAIDU-SUPER-WECHAT-WISE";
                } else if (c2 == 2) {
                    str = "BAIDU-BAIFUBAO-WISE";
                } else if (c2 == 3) {
                    str = "BAIDU-QUICKPAY";
                } else if (c2 == 4) {
                    str = "BAIDU-ALIPAY-WISE-HUABEI-PAY";
                } else if (c2 != 5) {
                    str = string;
                }
                bundle.putString(PolyActivity.CHOSEN_CHANNEL_KEY, str);
            }
            bundle.putString("zid", c.a.c0.a.a().j(activity));
            f(activity).b(activity, bundle, h(null), new PaymentAliChannelAuth(), c.a.c0.d.d(), new a(this, bVar));
        }
    }

    public void l(@NonNull Activity activity, @NonNull JSONArray jSONArray, @NonNull c.a.c0.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, activity, jSONArray, aVar) == null) {
            f(activity).f(activity, new c.a.e0.k.e.a(jSONArray), new c(this, aVar));
        }
    }

    public void m(@NonNull Bundle bundle, @NonNull c.a.c0.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bundle, dVar) == null) {
            f(AppRuntime.getAppContext()).d(bundle, new b(this, dVar));
        }
    }

    public void n(@NonNull Bundle bundle, @NonNull c.a.c0.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bundle, cVar) == null) {
            f(AppRuntime.getAppContext()).a(bundle, new d(this, cVar));
        }
    }

    public void o(JSONObject jSONObject, c.a.e0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, jSONObject, aVar) == null) {
            f(AppRuntime.getAppContext()).e(1, jSONObject, aVar);
        }
    }

    public void p(c.a.e0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            c.a.e0.b f2 = f(AppRuntime.getAppContext());
            f2.e(2, null, aVar);
            f2.c();
        }
    }
}

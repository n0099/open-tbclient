package com.baidu.payment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.wallet.paychannel.IChannelPay;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
import com.baidu.tieba.af1;
import com.baidu.tieba.dh1;
import com.baidu.tieba.fg1;
import com.baidu.tieba.gh1;
import com.baidu.tieba.hh1;
import com.baidu.tieba.le1;
import com.baidu.tieba.lh1;
import com.baidu.tieba.me1;
import com.baidu.tieba.ne1;
import com.baidu.tieba.nh1;
import com.baidu.tieba.oe1;
import com.baidu.tieba.pe1;
import com.baidu.tieba.qe1;
import com.baidu.tieba.re1;
import com.baidu.tieba.se1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PaymentManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static af1 b = null;
    public static gh1 c = null;
    public static int d = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

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

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes2.dex */
    public class a extends af1.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qe1 a;

        public a(PaymentManager paymentManager, qe1 qe1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, qe1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qe1Var;
        }

        @Override // com.baidu.tieba.af1.c
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                if (i == 3) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, 6);
                        this.a.onPayResult(6, jSONObject.toString());
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        this.a.onPayResult(6, str);
                        return;
                    }
                }
                this.a.onPayResult(i, str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements af1.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ se1 a;

        public b(PaymentManager paymentManager, se1 se1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, se1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = se1Var;
        }

        @Override // com.baidu.tieba.af1.d
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.onError(str);
            }
        }

        @Override // com.baidu.tieba.af1.d
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.onSuccess(str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements lh1.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pe1 a;

        public c(PaymentManager paymentManager, pe1 pe1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, pe1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pe1Var;
        }

        @Override // com.baidu.tieba.lh1.d
        public void a(boolean z, nh1.a aVar) {
            JSONObject a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, aVar) == null) {
                pe1 pe1Var = this.a;
                if (aVar == null) {
                    a = null;
                } else {
                    a = aVar.a();
                }
                pe1Var.a(z, a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements dh1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ re1 a;

        public d(PaymentManager paymentManager, re1 re1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, re1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = re1Var;
        }

        @Override // com.baidu.tieba.dh1
        public void a(dh1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.a(dh1.a.a(aVar));
            }
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

    public final IChannelPay h(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            return new IChannelPay(this, activity) { // from class: com.baidu.payment.PaymentManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PaymentManager this$0;
                public final /* synthetic */ Activity val$businessActivity;

                /* renamed from: com.baidu.payment.PaymentManager$2$a */
                /* loaded from: classes2.dex */
                public class a implements qe1 {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ gh1 a;
                    public final /* synthetic */ AnonymousClass2 b;

                    public a(AnonymousClass2 anonymousClass2, gh1 gh1Var) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass2, gh1Var};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = anonymousClass2;
                        this.a = gh1Var;
                    }

                    @Override // com.baidu.tieba.qe1
                    public void onPayResult(int i, String str) {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                            gh1 gh1Var = this.a;
                            PaymentManager.g(gh1Var, i, this.b.this$0.a.getString(R.string.obfuscated_res_0x7f0f0271) + str);
                        }
                    }
                }

                /* renamed from: com.baidu.payment.PaymentManager$2$b */
                /* loaded from: classes2.dex */
                public class b implements qe1 {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ gh1 a;
                    public final /* synthetic */ AnonymousClass2 b;

                    public b(AnonymousClass2 anonymousClass2, gh1 gh1Var) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass2, gh1Var};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = anonymousClass2;
                        this.a = gh1Var;
                    }

                    @Override // com.baidu.tieba.qe1
                    public void onPayResult(int i, String str) {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                            gh1 gh1Var = this.a;
                            PaymentManager.g(gh1Var, i, this.b.this$0.a.getString(R.string.obfuscated_res_0x7f0f1742) + str);
                        }
                    }
                }

                /* renamed from: com.baidu.payment.PaymentManager$2$c */
                /* loaded from: classes2.dex */
                public class c implements qe1 {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ gh1 a;
                    public final /* synthetic */ AnonymousClass2 b;

                    public c(AnonymousClass2 anonymousClass2, gh1 gh1Var) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass2, gh1Var};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = anonymousClass2;
                        this.a = gh1Var;
                    }

                    @Override // com.baidu.tieba.qe1
                    public void onPayResult(int i, String str) {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                            gh1 gh1Var = this.a;
                            PaymentManager.g(gh1Var, i, this.b.this$0.a.getString(R.string.obfuscated_res_0x7f0f02e6) + str);
                        }
                    }
                }

                /* renamed from: com.baidu.payment.PaymentManager$2$d */
                /* loaded from: classes2.dex */
                public class d implements qe1 {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ gh1 a;
                    public final /* synthetic */ AnonymousClass2 b;

                    public d(AnonymousClass2 anonymousClass2, gh1 gh1Var) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass2, gh1Var};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = anonymousClass2;
                        this.a = gh1Var;
                    }

                    @Override // com.baidu.tieba.qe1
                    public void onPayResult(int i, String str) {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                            gh1 gh1Var = this.a;
                            PaymentManager.g(gh1Var, i, this.b.this$0.a.getString(R.string.obfuscated_res_0x7f0f03ed) + str);
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
                public void pay(Activity activity2, hh1 hh1Var, gh1 gh1Var) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, activity2, hh1Var, gh1Var) == null) {
                        char c2 = 6;
                        if (hh1Var != null && !TextUtils.isEmpty(hh1Var.a) && hh1Var.b != null) {
                            String str = hh1Var.a;
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
                                    me1 f = me1.f();
                                    Activity activity3 = this.val$businessActivity;
                                    if (activity3 == null) {
                                        activity3 = activity2;
                                    }
                                    f.a(activity3, hh1Var.b.optString("orderInfo"), new a(this, gh1Var));
                                    break;
                                case 3:
                                    me1.f().e(activity2, hh1Var.b, new b(this, gh1Var));
                                    break;
                                case 4:
                                    me1 f2 = me1.f();
                                    Activity activity4 = this.val$businessActivity;
                                    if (activity4 == null) {
                                        activity4 = activity2;
                                    }
                                    f2.b(activity4, hh1Var.b.optString("orderInfo"), new c(this, gh1Var));
                                    break;
                                case 5:
                                    gh1 unused = PaymentManager.c = gh1Var;
                                    ne1.c();
                                    me1.f().d(activity2, hh1Var.b);
                                    break;
                                case 6:
                                    me1.f().c(activity2, hh1Var.b, new d(this, gh1Var));
                                    break;
                                default:
                                    gh1Var.onResult(3, this.this$0.a.getString(R.string.obfuscated_res_0x7f0f15fb));
                                    break;
                            }
                            activity2.finish();
                            return;
                        }
                        PaymentManager.g(gh1Var, 6, this.this$0.a.getString(R.string.obfuscated_res_0x7f0f0def));
                    }
                }
            };
        }
        return (IChannelPay) invokeL.objValue;
    }

    public void p(fg1 fg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fg1Var) == null) {
            af1 f = f(AppRuntime.getAppContext());
            f.e(2, null, fg1Var);
            f.c();
        }
    }

    public static void g(gh1 gh1Var, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65542, null, gh1Var, i, str) == null) && gh1Var != null) {
            int i2 = 2;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        i2 = 3;
                    }
                } else {
                    i2 = 1;
                }
            } else {
                i2 = 0;
            }
            gh1Var.onResult(i2, str);
        }
    }

    public boolean d(Activity activity, String str, qe1 qe1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, str, qe1Var)) == null) {
            if (TextUtils.isEmpty(str) || activity == null) {
                return false;
            }
            le1.a().c(activity, str, qe1Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean e(Activity activity, String str, qe1 qe1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, qe1Var)) == null) {
            if (TextUtils.isEmpty(str) || activity == null) {
                return false;
            }
            le1.a().e(activity, str, qe1Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void l(@NonNull Activity activity, @NonNull JSONArray jSONArray, @NonNull pe1 pe1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, activity, jSONArray, pe1Var) == null) {
            f(activity).f(activity, new nh1(jSONArray), new c(this, pe1Var));
        }
    }

    public static af1 f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            af1 af1Var = b;
            if (af1Var != null) {
                return af1Var;
            }
            d = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("poly_cashier_env", 1);
            af1.b bVar = new af1.b();
            bVar.g(d);
            bVar.e(context.getApplicationContext());
            bVar.f(false);
            af1 d2 = bVar.d();
            b = d2;
            return d2;
        }
        return (af1) invokeL.objValue;
    }

    public static void i(int i, String str) {
        gh1 gh1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65543, null, i, str) == null) && (gh1Var = c) != null) {
            gh1Var.onResult(i, AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1059) + str);
            c = null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void j(Activity activity, JSONObject jSONObject, String[] strArr, qe1 qe1Var) {
        char c2;
        char c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, jSONObject, strArr, qe1Var) == null) {
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
                    if (c3 != 0) {
                        if (c3 != 1) {
                            if (c3 != 2) {
                                if (c3 != 3) {
                                    if (c3 != 4) {
                                        if (c3 == 5) {
                                            strArr3[i] = "BAIDU-CHINAPAY-B2C";
                                        }
                                    } else {
                                        strArr3[i] = "BAIDU-ALIPAY-WISE-HUABEI-PAY";
                                    }
                                } else {
                                    strArr3[i] = "BAIDU-QUICKPAY";
                                }
                            } else {
                                strArr3[i] = "BAIDU-BAIFUBAO-WISE";
                            }
                        } else {
                            strArr3[i] = "BAIDU-SUPER-WECHAT-WISE";
                        }
                    } else {
                        strArr3[i] = "BAIDU-ALIPAY-WISE";
                    }
                    i++;
                    strArr2 = strArr;
                }
                bundle = bundle;
                bundle.putStringArray("blockedPayChannels", strArr3);
            }
            String string = bundle.getString("chosenChannel", "");
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
                bundle.putString("chosenChannel", str);
            }
            bundle.putString("zid", le1.a().j(activity));
            f(activity).b(activity, bundle, h(null), new PaymentAliChannelAuth(), oe1.d(), new a(this, qe1Var));
        }
    }

    public void m(@NonNull Bundle bundle, @NonNull se1 se1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bundle, se1Var) == null) {
            f(AppRuntime.getAppContext()).d(bundle, new b(this, se1Var));
        }
    }

    public void n(@NonNull Bundle bundle, @NonNull re1 re1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bundle, re1Var) == null) {
            f(AppRuntime.getAppContext()).a(bundle, new d(this, re1Var));
        }
    }

    public void o(JSONObject jSONObject, fg1 fg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, jSONObject, fg1Var) == null) {
            f(AppRuntime.getAppContext()).e(1, jSONObject, fg1Var);
        }
    }
}

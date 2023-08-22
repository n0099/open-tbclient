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
import com.baidu.tieba.ag1;
import com.baidu.tieba.ig1;
import com.baidu.tieba.li1;
import com.baidu.tieba.nh1;
import com.baidu.tieba.oi1;
import com.baidu.tieba.pi1;
import com.baidu.tieba.tf1;
import com.baidu.tieba.ti1;
import com.baidu.tieba.uf1;
import com.baidu.tieba.vf1;
import com.baidu.tieba.vi1;
import com.baidu.tieba.wf1;
import com.baidu.tieba.xf1;
import com.baidu.tieba.yf1;
import com.baidu.tieba.zf1;
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
/* loaded from: classes3.dex */
public class PaymentManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static ig1 b = null;
    public static oi1 c = null;
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

    /* loaded from: classes3.dex */
    public class a extends ig1.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yf1 a;

        public a(PaymentManager paymentManager, yf1 yf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, yf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yf1Var;
        }

        @Override // com.baidu.tieba.ig1.c
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                if (i == 3) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        jSONObject.put("statusCode", 6);
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

    /* loaded from: classes3.dex */
    public class b implements ig1.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ag1 a;

        public b(PaymentManager paymentManager, ag1 ag1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, ag1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ag1Var;
        }

        @Override // com.baidu.tieba.ig1.d
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.onError(str);
            }
        }

        @Override // com.baidu.tieba.ig1.d
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.onSuccess(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ti1.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf1 a;

        public c(PaymentManager paymentManager, xf1 xf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, xf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xf1Var;
        }

        @Override // com.baidu.tieba.ti1.d
        public void a(boolean z, vi1.a aVar) {
            JSONObject a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, aVar) == null) {
                xf1 xf1Var = this.a;
                if (aVar == null) {
                    a = null;
                } else {
                    a = aVar.a();
                }
                xf1Var.a(z, a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements li1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zf1 a;

        public d(PaymentManager paymentManager, zf1 zf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, zf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zf1Var;
        }

        @Override // com.baidu.tieba.li1
        public void a(li1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.a(li1.a.a(aVar));
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
                /* loaded from: classes3.dex */
                public class a implements yf1 {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ oi1 a;
                    public final /* synthetic */ AnonymousClass2 b;

                    public a(AnonymousClass2 anonymousClass2, oi1 oi1Var) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass2, oi1Var};
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
                        this.a = oi1Var;
                    }

                    @Override // com.baidu.tieba.yf1
                    public void onPayResult(int i, String str) {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                            oi1 oi1Var = this.a;
                            PaymentManager.g(oi1Var, i, this.b.this$0.a.getString(R.string.obfuscated_res_0x7f0f029c) + str);
                        }
                    }
                }

                /* renamed from: com.baidu.payment.PaymentManager$2$b */
                /* loaded from: classes3.dex */
                public class b implements yf1 {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ oi1 a;
                    public final /* synthetic */ AnonymousClass2 b;

                    public b(AnonymousClass2 anonymousClass2, oi1 oi1Var) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass2, oi1Var};
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
                        this.a = oi1Var;
                    }

                    @Override // com.baidu.tieba.yf1
                    public void onPayResult(int i, String str) {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                            oi1 oi1Var = this.a;
                            PaymentManager.g(oi1Var, i, this.b.this$0.a.getString(R.string.obfuscated_res_0x7f0f18f8) + str);
                        }
                    }
                }

                /* renamed from: com.baidu.payment.PaymentManager$2$c */
                /* loaded from: classes3.dex */
                public class c implements yf1 {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ oi1 a;
                    public final /* synthetic */ AnonymousClass2 b;

                    public c(AnonymousClass2 anonymousClass2, oi1 oi1Var) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass2, oi1Var};
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
                        this.a = oi1Var;
                    }

                    @Override // com.baidu.tieba.yf1
                    public void onPayResult(int i, String str) {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                            oi1 oi1Var = this.a;
                            PaymentManager.g(oi1Var, i, this.b.this$0.a.getString(R.string.obfuscated_res_0x7f0f0317) + str);
                        }
                    }
                }

                /* renamed from: com.baidu.payment.PaymentManager$2$d */
                /* loaded from: classes3.dex */
                public class d implements yf1 {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ oi1 a;
                    public final /* synthetic */ AnonymousClass2 b;

                    public d(AnonymousClass2 anonymousClass2, oi1 oi1Var) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass2, oi1Var};
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
                        this.a = oi1Var;
                    }

                    @Override // com.baidu.tieba.yf1
                    public void onPayResult(int i, String str) {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                            oi1 oi1Var = this.a;
                            PaymentManager.g(oi1Var, i, this.b.this$0.a.getString(R.string.obfuscated_res_0x7f0f043a) + str);
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
                public void pay(Activity activity2, pi1 pi1Var, oi1 oi1Var) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, activity2, pi1Var, oi1Var) == null) {
                        char c2 = 6;
                        if (pi1Var != null && !TextUtils.isEmpty(pi1Var.a) && pi1Var.b != null) {
                            String str = pi1Var.a;
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
                                    uf1 f = uf1.f();
                                    Activity activity3 = this.val$businessActivity;
                                    if (activity3 == null) {
                                        activity3 = activity2;
                                    }
                                    f.a(activity3, pi1Var.b.optString("orderInfo"), new a(this, oi1Var));
                                    break;
                                case 3:
                                    uf1.f().e(activity2, pi1Var.b, new b(this, oi1Var));
                                    break;
                                case 4:
                                    uf1 f2 = uf1.f();
                                    Activity activity4 = this.val$businessActivity;
                                    if (activity4 == null) {
                                        activity4 = activity2;
                                    }
                                    f2.b(activity4, pi1Var.b.optString("orderInfo"), new c(this, oi1Var));
                                    break;
                                case 5:
                                    oi1 unused = PaymentManager.c = oi1Var;
                                    vf1.c();
                                    uf1.f().d(activity2, pi1Var.b);
                                    break;
                                case 6:
                                    uf1.f().c(activity2, pi1Var.b, new d(this, oi1Var));
                                    break;
                                default:
                                    oi1Var.onResult(3, this.this$0.a.getString(R.string.obfuscated_res_0x7f0f1797));
                                    break;
                            }
                            activity2.finish();
                            return;
                        }
                        PaymentManager.g(oi1Var, 6, this.this$0.a.getString(R.string.obfuscated_res_0x7f0f0f0a));
                    }
                }
            };
        }
        return (IChannelPay) invokeL.objValue;
    }

    public void p(nh1 nh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nh1Var) == null) {
            ig1 f = f(AppRuntime.getAppContext());
            f.e(2, null, nh1Var);
            f.c();
        }
    }

    public static void g(oi1 oi1Var, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65542, null, oi1Var, i, str) == null) && oi1Var != null) {
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
            oi1Var.onResult(i2, str);
        }
    }

    public boolean d(Activity activity, String str, yf1 yf1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, str, yf1Var)) == null) {
            if (TextUtils.isEmpty(str) || activity == null) {
                return false;
            }
            tf1.a().c(activity, str, yf1Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean e(Activity activity, String str, yf1 yf1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, yf1Var)) == null) {
            if (TextUtils.isEmpty(str) || activity == null) {
                return false;
            }
            tf1.a().e(activity, str, yf1Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void l(@NonNull Activity activity, @NonNull JSONArray jSONArray, @NonNull xf1 xf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, activity, jSONArray, xf1Var) == null) {
            f(activity).f(activity, new vi1(jSONArray), new c(this, xf1Var));
        }
    }

    public static ig1 f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            ig1 ig1Var = b;
            if (ig1Var != null) {
                return ig1Var;
            }
            d = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("poly_cashier_env", 1);
            ig1.b bVar = new ig1.b();
            bVar.g(d);
            bVar.e(context.getApplicationContext());
            bVar.f(false);
            ig1 d2 = bVar.d();
            b = d2;
            return d2;
        }
        return (ig1) invokeL.objValue;
    }

    public static void i(int i, String str) {
        oi1 oi1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65543, null, i, str) == null) && (oi1Var = c) != null) {
            oi1Var.onResult(i, AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f11be) + str);
            c = null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void j(Activity activity, JSONObject jSONObject, String[] strArr, yf1 yf1Var) {
        char c2;
        char c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, jSONObject, strArr, yf1Var) == null) {
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
            bundle.putString("zid", tf1.a().j(activity));
            f(activity).b(activity, bundle, h(null), new PaymentAliChannelAuth(), wf1.d(), new a(this, yf1Var));
        }
    }

    public void m(@NonNull Bundle bundle, @NonNull ag1 ag1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bundle, ag1Var) == null) {
            f(AppRuntime.getAppContext()).d(bundle, new b(this, ag1Var));
        }
    }

    public void n(@NonNull Bundle bundle, @NonNull zf1 zf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bundle, zf1Var) == null) {
            f(AppRuntime.getAppContext()).a(bundle, new d(this, zf1Var));
        }
    }

    public void o(JSONObject jSONObject, nh1 nh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, jSONObject, nh1Var) == null) {
            f(AppRuntime.getAppContext()).e(1, jSONObject, nh1Var);
        }
    }
}

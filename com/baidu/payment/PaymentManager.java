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
import com.repackage.a91;
import com.repackage.b61;
import com.repackage.c61;
import com.repackage.c91;
import com.repackage.d61;
import com.repackage.e61;
import com.repackage.f61;
import com.repackage.g61;
import com.repackage.h61;
import com.repackage.i61;
import com.repackage.q61;
import com.repackage.s81;
import com.repackage.u71;
import com.repackage.v81;
import com.repackage.w81;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PaymentManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static q61 b = null;
    public static v81 c = null;
    public static int d = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes2.dex */
    public class a extends q61.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g61 a;

        public a(PaymentManager paymentManager, g61 g61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, g61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g61Var;
        }

        @Override // com.repackage.q61.c
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

    /* loaded from: classes2.dex */
    public class b implements q61.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i61 a;

        public b(PaymentManager paymentManager, i61 i61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, i61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i61Var;
        }

        @Override // com.repackage.q61.d
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.onError(str);
            }
        }

        @Override // com.repackage.q61.d
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.onSuccess(str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements a91.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f61 a;

        public c(PaymentManager paymentManager, f61 f61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, f61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f61Var;
        }

        @Override // com.repackage.a91.d
        public void a(boolean z, c91.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, aVar) == null) {
                this.a.a(z, aVar == null ? null : aVar.a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements s81 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h61 a;

        public d(PaymentManager paymentManager, h61 h61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, h61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h61Var;
        }

        @Override // com.repackage.s81
        public void a(s81.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.a(s81.a.a(aVar));
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

    public static q61 f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            q61 q61Var = b;
            if (q61Var != null) {
                return q61Var;
            }
            d = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("poly_cashier_env", 1);
            q61.b bVar = new q61.b();
            bVar.g(d);
            bVar.e(context.getApplicationContext());
            bVar.f(false);
            q61 d2 = bVar.d();
            b = d2;
            return d2;
        }
        return (q61) invokeL.objValue;
    }

    public static void g(v81 v81Var, int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65542, null, v81Var, i, str) == null) || v81Var == null) {
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
        v81Var.onResult(i2, str);
    }

    public static void i(int i, String str) {
        v81 v81Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65543, null, i, str) == null) || (v81Var = c) == null) {
            return;
        }
        v81Var.onResult(i, AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f0f50) + str);
        c = null;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean d(Activity activity, String str, g61 g61Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, str, g61Var)) == null) {
            if (TextUtils.isEmpty(str) || activity == null) {
                return false;
            }
            b61.a().c(activity, str, g61Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean e(Activity activity, String str, g61 g61Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, g61Var)) == null) {
            if (TextUtils.isEmpty(str) || activity == null) {
                return false;
            }
            b61.a().e(activity, str, g61Var);
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
            /* loaded from: classes2.dex */
            public class a implements g61 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ v81 a;
                public final /* synthetic */ AnonymousClass2 b;

                public a(AnonymousClass2 anonymousClass2, v81 v81Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {anonymousClass2, v81Var};
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
                    this.a = v81Var;
                }

                @Override // com.repackage.g61
                public void onPayResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        v81 v81Var = this.a;
                        PaymentManager.g(v81Var, i, this.b.this$0.a.getString(R.string.obfuscated_res_0x7f0f0262) + str);
                    }
                }
            }

            /* renamed from: com.baidu.payment.PaymentManager$2$b */
            /* loaded from: classes2.dex */
            public class b implements g61 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ v81 a;
                public final /* synthetic */ AnonymousClass2 b;

                public b(AnonymousClass2 anonymousClass2, v81 v81Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {anonymousClass2, v81Var};
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
                    this.a = v81Var;
                }

                @Override // com.repackage.g61
                public void onPayResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        v81 v81Var = this.a;
                        PaymentManager.g(v81Var, i, this.b.this$0.a.getString(R.string.obfuscated_res_0x7f0f15f4) + str);
                    }
                }
            }

            /* renamed from: com.baidu.payment.PaymentManager$2$c */
            /* loaded from: classes2.dex */
            public class c implements g61 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ v81 a;
                public final /* synthetic */ AnonymousClass2 b;

                public c(AnonymousClass2 anonymousClass2, v81 v81Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {anonymousClass2, v81Var};
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
                    this.a = v81Var;
                }

                @Override // com.repackage.g61
                public void onPayResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        v81 v81Var = this.a;
                        PaymentManager.g(v81Var, i, this.b.this$0.a.getString(R.string.obfuscated_res_0x7f0f02cf) + str);
                    }
                }
            }

            /* renamed from: com.baidu.payment.PaymentManager$2$d */
            /* loaded from: classes2.dex */
            public class d implements g61 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ v81 a;
                public final /* synthetic */ AnonymousClass2 b;

                public d(AnonymousClass2 anonymousClass2, v81 v81Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {anonymousClass2, v81Var};
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
                    this.a = v81Var;
                }

                @Override // com.repackage.g61
                public void onPayResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        v81 v81Var = this.a;
                        PaymentManager.g(v81Var, i, this.b.this$0.a.getString(R.string.obfuscated_res_0x7f0f03c0) + str);
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
            public void pay(Activity activity2, w81 w81Var, v81 v81Var) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, activity2, w81Var, v81Var) == null) {
                    char c2 = 6;
                    if (w81Var == null || TextUtils.isEmpty(w81Var.a) || w81Var.b == null) {
                        PaymentManager.g(v81Var, 6, this.this$0.a.getString(R.string.obfuscated_res_0x7f0f0cfc));
                        return;
                    }
                    String str = w81Var.a;
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
                            c61 f = c61.f();
                            Activity activity3 = this.val$businessActivity;
                            if (activity3 == null) {
                                activity3 = activity2;
                            }
                            f.a(activity3, w81Var.b.optString("orderInfo"), new a(this, v81Var));
                            break;
                        case 3:
                            c61.f().e(activity2, w81Var.b, new b(this, v81Var));
                            break;
                        case 4:
                            c61 f2 = c61.f();
                            Activity activity4 = this.val$businessActivity;
                            if (activity4 == null) {
                                activity4 = activity2;
                            }
                            f2.b(activity4, w81Var.b.optString("orderInfo"), new c(this, v81Var));
                            break;
                        case 5:
                            v81 unused = PaymentManager.c = v81Var;
                            d61.c();
                            c61.f().d(activity2, w81Var.b);
                            break;
                        case 6:
                            c61.f().c(activity2, w81Var.b, new d(this, v81Var));
                            break;
                        default:
                            v81Var.onResult(3, this.this$0.a.getString(R.string.obfuscated_res_0x7f0f14c2));
                            break;
                    }
                    activity2.finish();
                }
            }
        } : (IChannelPay) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void j(Activity activity, JSONObject jSONObject, String[] strArr, g61 g61Var) {
        char c2;
        char c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, jSONObject, strArr, g61Var) == null) {
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
            bundle.putString("zid", b61.a().j(activity));
            f(activity).b(activity, bundle, h(null), new PaymentAliChannelAuth(), e61.d(), new a(this, g61Var));
        }
    }

    public void l(@NonNull Activity activity, @NonNull JSONArray jSONArray, @NonNull f61 f61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, activity, jSONArray, f61Var) == null) {
            f(activity).f(activity, new c91(jSONArray), new c(this, f61Var));
        }
    }

    public void m(@NonNull Bundle bundle, @NonNull i61 i61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bundle, i61Var) == null) {
            f(AppRuntime.getAppContext()).d(bundle, new b(this, i61Var));
        }
    }

    public void n(@NonNull Bundle bundle, @NonNull h61 h61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bundle, h61Var) == null) {
            f(AppRuntime.getAppContext()).a(bundle, new d(this, h61Var));
        }
    }

    public void o(JSONObject jSONObject, u71 u71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, jSONObject, u71Var) == null) {
            f(AppRuntime.getAppContext()).e(1, jSONObject, u71Var);
        }
    }

    public void p(u71 u71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, u71Var) == null) {
            q61 f = f(AppRuntime.getAppContext());
            f.e(2, null, u71Var);
            f.c();
        }
    }
}

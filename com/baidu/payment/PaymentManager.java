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
import com.repackage.ca1;
import com.repackage.d71;
import com.repackage.e71;
import com.repackage.ea1;
import com.repackage.f71;
import com.repackage.g71;
import com.repackage.h71;
import com.repackage.i71;
import com.repackage.j71;
import com.repackage.k71;
import com.repackage.s71;
import com.repackage.u91;
import com.repackage.w81;
import com.repackage.x91;
import com.repackage.y91;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PaymentManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static s71 b = null;
    public static x91 c = null;
    public static int d = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes2.dex */
    public class a extends s71.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i71 a;

        public a(PaymentManager paymentManager, i71 i71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, i71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i71Var;
        }

        @Override // com.repackage.s71.c
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
    public class b implements s71.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k71 a;

        public b(PaymentManager paymentManager, k71 k71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, k71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k71Var;
        }

        @Override // com.repackage.s71.d
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.onError(str);
            }
        }

        @Override // com.repackage.s71.d
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.onSuccess(str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements ca1.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h71 a;

        public c(PaymentManager paymentManager, h71 h71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, h71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h71Var;
        }

        @Override // com.repackage.ca1.d
        public void a(boolean z, ea1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, aVar) == null) {
                this.a.a(z, aVar == null ? null : aVar.a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements u91 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j71 a;

        public d(PaymentManager paymentManager, j71 j71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, j71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j71Var;
        }

        @Override // com.repackage.u91
        public void a(u91.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.a(u91.a.a(aVar));
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

    public static s71 f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            s71 s71Var = b;
            if (s71Var != null) {
                return s71Var;
            }
            d = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("poly_cashier_env", 1);
            s71.b bVar = new s71.b();
            bVar.g(d);
            bVar.e(context.getApplicationContext());
            bVar.f(false);
            s71 d2 = bVar.d();
            b = d2;
            return d2;
        }
        return (s71) invokeL.objValue;
    }

    public static void g(x91 x91Var, int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65542, null, x91Var, i, str) == null) || x91Var == null) {
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
        x91Var.onResult(i2, str);
    }

    public static void i(int i, String str) {
        x91 x91Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65543, null, i, str) == null) || (x91Var = c) == null) {
            return;
        }
        x91Var.onResult(i, AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f0f25) + str);
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

    public boolean d(Activity activity, String str, i71 i71Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, str, i71Var)) == null) {
            if (TextUtils.isEmpty(str) || activity == null) {
                return false;
            }
            d71.a().c(activity, str, i71Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean e(Activity activity, String str, i71 i71Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, i71Var)) == null) {
            if (TextUtils.isEmpty(str) || activity == null) {
                return false;
            }
            d71.a().e(activity, str, i71Var);
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
            public class a implements i71 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ x91 a;
                public final /* synthetic */ AnonymousClass2 b;

                public a(AnonymousClass2 anonymousClass2, x91 x91Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {anonymousClass2, x91Var};
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
                    this.a = x91Var;
                }

                @Override // com.repackage.i71
                public void onPayResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        x91 x91Var = this.a;
                        PaymentManager.g(x91Var, i, this.b.this$0.a.getString(R.string.obfuscated_res_0x7f0f025f) + str);
                    }
                }
            }

            /* renamed from: com.baidu.payment.PaymentManager$2$b */
            /* loaded from: classes2.dex */
            public class b implements i71 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ x91 a;
                public final /* synthetic */ AnonymousClass2 b;

                public b(AnonymousClass2 anonymousClass2, x91 x91Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {anonymousClass2, x91Var};
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
                    this.a = x91Var;
                }

                @Override // com.repackage.i71
                public void onPayResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        x91 x91Var = this.a;
                        PaymentManager.g(x91Var, i, this.b.this$0.a.getString(R.string.obfuscated_res_0x7f0f15b1) + str);
                    }
                }
            }

            /* renamed from: com.baidu.payment.PaymentManager$2$c */
            /* loaded from: classes2.dex */
            public class c implements i71 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ x91 a;
                public final /* synthetic */ AnonymousClass2 b;

                public c(AnonymousClass2 anonymousClass2, x91 x91Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {anonymousClass2, x91Var};
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
                    this.a = x91Var;
                }

                @Override // com.repackage.i71
                public void onPayResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        x91 x91Var = this.a;
                        PaymentManager.g(x91Var, i, this.b.this$0.a.getString(R.string.obfuscated_res_0x7f0f02c8) + str);
                    }
                }
            }

            /* renamed from: com.baidu.payment.PaymentManager$2$d */
            /* loaded from: classes2.dex */
            public class d implements i71 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ x91 a;
                public final /* synthetic */ AnonymousClass2 b;

                public d(AnonymousClass2 anonymousClass2, x91 x91Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {anonymousClass2, x91Var};
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
                    this.a = x91Var;
                }

                @Override // com.repackage.i71
                public void onPayResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        x91 x91Var = this.a;
                        PaymentManager.g(x91Var, i, this.b.this$0.a.getString(R.string.obfuscated_res_0x7f0f03b8) + str);
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
            public void pay(Activity activity2, y91 y91Var, x91 x91Var) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, activity2, y91Var, x91Var) == null) {
                    char c2 = 6;
                    if (y91Var == null || TextUtils.isEmpty(y91Var.a) || y91Var.b == null) {
                        PaymentManager.g(x91Var, 6, this.this$0.a.getString(R.string.obfuscated_res_0x7f0f0cdf));
                        return;
                    }
                    String str = y91Var.a;
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
                            e71 f = e71.f();
                            Activity activity3 = this.val$businessActivity;
                            if (activity3 == null) {
                                activity3 = activity2;
                            }
                            f.a(activity3, y91Var.b.optString("orderInfo"), new a(this, x91Var));
                            break;
                        case 3:
                            e71.f().e(activity2, y91Var.b, new b(this, x91Var));
                            break;
                        case 4:
                            e71 f2 = e71.f();
                            Activity activity4 = this.val$businessActivity;
                            if (activity4 == null) {
                                activity4 = activity2;
                            }
                            f2.b(activity4, y91Var.b.optString("orderInfo"), new c(this, x91Var));
                            break;
                        case 5:
                            x91 unused = PaymentManager.c = x91Var;
                            f71.c();
                            e71.f().d(activity2, y91Var.b);
                            break;
                        case 6:
                            e71.f().c(activity2, y91Var.b, new d(this, x91Var));
                            break;
                        default:
                            x91Var.onResult(3, this.this$0.a.getString(R.string.obfuscated_res_0x7f0f1484));
                            break;
                    }
                    activity2.finish();
                }
            }
        } : (IChannelPay) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void j(Activity activity, JSONObject jSONObject, String[] strArr, i71 i71Var) {
        char c2;
        char c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, jSONObject, strArr, i71Var) == null) {
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
            bundle.putString("zid", d71.a().j(activity));
            f(activity).b(activity, bundle, h(null), new PaymentAliChannelAuth(), g71.d(), new a(this, i71Var));
        }
    }

    public void l(@NonNull Activity activity, @NonNull JSONArray jSONArray, @NonNull h71 h71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, activity, jSONArray, h71Var) == null) {
            f(activity).f(activity, new ea1(jSONArray), new c(this, h71Var));
        }
    }

    public void m(@NonNull Bundle bundle, @NonNull k71 k71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bundle, k71Var) == null) {
            f(AppRuntime.getAppContext()).d(bundle, new b(this, k71Var));
        }
    }

    public void n(@NonNull Bundle bundle, @NonNull j71 j71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bundle, j71Var) == null) {
            f(AppRuntime.getAppContext()).a(bundle, new d(this, j71Var));
        }
    }

    public void o(JSONObject jSONObject, w81 w81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, jSONObject, w81Var) == null) {
            f(AppRuntime.getAppContext()).e(1, jSONObject, w81Var);
        }
    }

    public void p(w81 w81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, w81Var) == null) {
            s71 f = f(AppRuntime.getAppContext());
            f.e(2, null, w81Var);
            f.c();
        }
    }
}

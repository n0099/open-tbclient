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
import com.baidu.tieba.bb1;
import com.baidu.tieba.be1;
import com.baidu.tieba.cb1;
import com.baidu.tieba.db1;
import com.baidu.tieba.de1;
import com.baidu.tieba.eb1;
import com.baidu.tieba.fb1;
import com.baidu.tieba.gb1;
import com.baidu.tieba.hb1;
import com.baidu.tieba.ib1;
import com.baidu.tieba.qb1;
import com.baidu.tieba.td1;
import com.baidu.tieba.vc1;
import com.baidu.tieba.wd1;
import com.baidu.tieba.xd1;
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
    public static qb1 b = null;
    public static wd1 c = null;
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
    public class a extends qb1.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gb1 a;

        public a(PaymentManager paymentManager, gb1 gb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, gb1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gb1Var;
        }

        @Override // com.baidu.tieba.qb1.c
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
    public class b implements qb1.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ib1 a;

        public b(PaymentManager paymentManager, ib1 ib1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, ib1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ib1Var;
        }

        @Override // com.baidu.tieba.qb1.d
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.onError(str);
            }
        }

        @Override // com.baidu.tieba.qb1.d
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.onSuccess(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements be1.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb1 a;

        public c(PaymentManager paymentManager, fb1 fb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, fb1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb1Var;
        }

        @Override // com.baidu.tieba.be1.d
        public void a(boolean z, de1.a aVar) {
            JSONObject a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, aVar) == null) {
                fb1 fb1Var = this.a;
                if (aVar == null) {
                    a = null;
                } else {
                    a = aVar.a();
                }
                fb1Var.a(z, a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements td1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hb1 a;

        public d(PaymentManager paymentManager, hb1 hb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, hb1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hb1Var;
        }

        @Override // com.baidu.tieba.td1
        public void a(td1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.a(td1.a.a(aVar));
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
                public class a implements gb1 {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ wd1 a;
                    public final /* synthetic */ AnonymousClass2 b;

                    public a(AnonymousClass2 anonymousClass2, wd1 wd1Var) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass2, wd1Var};
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
                        this.a = wd1Var;
                    }

                    @Override // com.baidu.tieba.gb1
                    public void onPayResult(int i, String str) {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                            wd1 wd1Var = this.a;
                            PaymentManager.g(wd1Var, i, this.b.this$0.a.getString(R.string.obfuscated_res_0x7f0f02a7) + str);
                        }
                    }
                }

                /* renamed from: com.baidu.payment.PaymentManager$2$b */
                /* loaded from: classes3.dex */
                public class b implements gb1 {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ wd1 a;
                    public final /* synthetic */ AnonymousClass2 b;

                    public b(AnonymousClass2 anonymousClass2, wd1 wd1Var) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass2, wd1Var};
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
                        this.a = wd1Var;
                    }

                    @Override // com.baidu.tieba.gb1
                    public void onPayResult(int i, String str) {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                            wd1 wd1Var = this.a;
                            PaymentManager.g(wd1Var, i, this.b.this$0.a.getString(R.string.obfuscated_res_0x7f0f1922) + str);
                        }
                    }
                }

                /* renamed from: com.baidu.payment.PaymentManager$2$c */
                /* loaded from: classes3.dex */
                public class c implements gb1 {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ wd1 a;
                    public final /* synthetic */ AnonymousClass2 b;

                    public c(AnonymousClass2 anonymousClass2, wd1 wd1Var) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass2, wd1Var};
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
                        this.a = wd1Var;
                    }

                    @Override // com.baidu.tieba.gb1
                    public void onPayResult(int i, String str) {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                            wd1 wd1Var = this.a;
                            PaymentManager.g(wd1Var, i, this.b.this$0.a.getString(R.string.obfuscated_res_0x7f0f0322) + str);
                        }
                    }
                }

                /* renamed from: com.baidu.payment.PaymentManager$2$d */
                /* loaded from: classes3.dex */
                public class d implements gb1 {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ wd1 a;
                    public final /* synthetic */ AnonymousClass2 b;

                    public d(AnonymousClass2 anonymousClass2, wd1 wd1Var) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass2, wd1Var};
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
                        this.a = wd1Var;
                    }

                    @Override // com.baidu.tieba.gb1
                    public void onPayResult(int i, String str) {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                            wd1 wd1Var = this.a;
                            PaymentManager.g(wd1Var, i, this.b.this$0.a.getString(R.string.obfuscated_res_0x7f0f0447) + str);
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
                public void pay(Activity activity2, xd1 xd1Var, wd1 wd1Var) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, activity2, xd1Var, wd1Var) == null) {
                        char c2 = 6;
                        if (xd1Var != null && !TextUtils.isEmpty(xd1Var.a) && xd1Var.b != null) {
                            String str = xd1Var.a;
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
                                    cb1 f = cb1.f();
                                    Activity activity3 = this.val$businessActivity;
                                    if (activity3 == null) {
                                        activity3 = activity2;
                                    }
                                    f.a(activity3, xd1Var.b.optString("orderInfo"), new a(this, wd1Var));
                                    break;
                                case 3:
                                    cb1.f().e(activity2, xd1Var.b, new b(this, wd1Var));
                                    break;
                                case 4:
                                    cb1 f2 = cb1.f();
                                    Activity activity4 = this.val$businessActivity;
                                    if (activity4 == null) {
                                        activity4 = activity2;
                                    }
                                    f2.b(activity4, xd1Var.b.optString("orderInfo"), new c(this, wd1Var));
                                    break;
                                case 5:
                                    wd1 unused = PaymentManager.c = wd1Var;
                                    db1.c();
                                    cb1.f().d(activity2, xd1Var.b);
                                    break;
                                case 6:
                                    cb1.f().c(activity2, xd1Var.b, new d(this, wd1Var));
                                    break;
                                default:
                                    wd1Var.onResult(3, this.this$0.a.getString(R.string.obfuscated_res_0x7f0f17be));
                                    break;
                            }
                            activity2.finish();
                            return;
                        }
                        PaymentManager.g(wd1Var, 6, this.this$0.a.getString(R.string.obfuscated_res_0x7f0f0f53));
                    }
                }
            };
        }
        return (IChannelPay) invokeL.objValue;
    }

    public void p(vc1 vc1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vc1Var) == null) {
            qb1 f = f(AppRuntime.getAppContext());
            f.e(2, null, vc1Var);
            f.c();
        }
    }

    public static void g(wd1 wd1Var, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65542, null, wd1Var, i, str) == null) && wd1Var != null) {
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
            wd1Var.onResult(i2, str);
        }
    }

    public boolean d(Activity activity, String str, gb1 gb1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, str, gb1Var)) == null) {
            if (TextUtils.isEmpty(str) || activity == null) {
                return false;
            }
            bb1.a().c(activity, str, gb1Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean e(Activity activity, String str, gb1 gb1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, gb1Var)) == null) {
            if (TextUtils.isEmpty(str) || activity == null) {
                return false;
            }
            bb1.a().e(activity, str, gb1Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void l(@NonNull Activity activity, @NonNull JSONArray jSONArray, @NonNull fb1 fb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, activity, jSONArray, fb1Var) == null) {
            f(activity).f(activity, new de1(jSONArray), new c(this, fb1Var));
        }
    }

    public static qb1 f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            qb1 qb1Var = b;
            if (qb1Var != null) {
                return qb1Var;
            }
            d = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("poly_cashier_env", 1);
            qb1.b bVar = new qb1.b();
            bVar.g(d);
            bVar.e(context.getApplicationContext());
            bVar.f(false);
            qb1 d2 = bVar.d();
            b = d2;
            return d2;
        }
        return (qb1) invokeL.objValue;
    }

    public static void i(int i, String str) {
        wd1 wd1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65543, null, i, str) == null) && (wd1Var = c) != null) {
            wd1Var.onResult(i, AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f120d) + str);
            c = null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void j(Activity activity, JSONObject jSONObject, String[] strArr, gb1 gb1Var) {
        char c2;
        char c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, jSONObject, strArr, gb1Var) == null) {
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
            bundle.putString("zid", bb1.a().j(activity));
            f(activity).b(activity, bundle, h(null), new PaymentAliChannelAuth(), eb1.d(), new a(this, gb1Var));
        }
    }

    public void m(@NonNull Bundle bundle, @NonNull ib1 ib1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bundle, ib1Var) == null) {
            f(AppRuntime.getAppContext()).d(bundle, new b(this, ib1Var));
        }
    }

    public void n(@NonNull Bundle bundle, @NonNull hb1 hb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bundle, hb1Var) == null) {
            f(AppRuntime.getAppContext()).a(bundle, new d(this, hb1Var));
        }
    }

    public void o(JSONObject jSONObject, vc1 vc1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, jSONObject, vc1Var) == null) {
            f(AppRuntime.getAppContext()).e(1, jSONObject, vc1Var);
        }
    }
}

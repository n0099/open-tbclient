package com.baidu.payment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.f0.e;
import c.a.h0.b;
import c.a.h0.s.e.a;
import c.a.h0.t.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.poly.wallet.paychannel.IChannelPay;
import com.baidu.poly.widget.CouponListDialog;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class PaymentManager {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static c.a.h0.b f38971b = null;

    /* renamed from: c  reason: collision with root package name */
    public static c.a.h0.s.g.a f38972c = null;

    /* renamed from: d  reason: collision with root package name */
    public static int f38973d = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes10.dex */
    public class a extends b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.f0.f.b a;

        public a(PaymentManager paymentManager, c.a.f0.f.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.h0.b.c
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                if (i2 == 3) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, 6);
                        this.a.onPayResult(6, jSONObject.toString());
                        return;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        this.a.onPayResult(6, str);
                        return;
                    }
                }
                this.a.onPayResult(i2, str);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.f0.f.d a;

        public b(PaymentManager paymentManager, c.a.f0.f.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.h0.b.d
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.onError(str);
            }
        }

        @Override // c.a.h0.b.d
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.onSuccess(str);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements CouponListDialog.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.f0.f.a a;

        public c(PaymentManager paymentManager, c.a.f0.f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.poly.widget.CouponListDialog.d
        public void a(boolean z, a.C0144a c0144a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, c0144a) == null) {
                this.a.a(z, c0144a == null ? null : c0144a.a());
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements c.a.h0.s.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.f0.f.c a;

        public d(PaymentManager paymentManager, c.a.f0.f.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentManager, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.h0.s.e.a
        public void a(a.C0141a c0141a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c0141a) == null) {
                this.a.a(a.C0141a.a(c0141a));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = AppRuntime.getAppContext();
    }

    public static c.a.h0.b f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            c.a.h0.b bVar = f38971b;
            if (bVar != null) {
                return bVar;
            }
            f38973d = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("poly_cashier_env", 1);
            b.C0128b c0128b = new b.C0128b();
            c0128b.g(f38973d);
            c0128b.e(context.getApplicationContext());
            c0128b.f(false);
            c.a.h0.b d2 = c0128b.d();
            f38971b = d2;
            return d2;
        }
        return (c.a.h0.b) invokeL.objValue;
    }

    public static void g(c.a.h0.s.g.a aVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65542, null, aVar, i2, str) == null) || aVar == null) {
            return;
        }
        int i3 = 2;
        if (i2 == 0) {
            i3 = 0;
        } else if (i2 == 1) {
            i3 = 1;
        } else if (i2 != 2) {
            i3 = 3;
        }
        aVar.onResult(i3, str);
    }

    public static void i(int i2, String str) {
        c.a.h0.s.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65543, null, i2, str) == null) || (aVar = f38972c) == null) {
            return;
        }
        aVar.onResult(i2, AppRuntime.getAppContext().getString(c.a.f0.d.quick_pay_result_title) + str);
        f38972c = null;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean d(Activity activity, String str, c.a.f0.f.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, str, bVar)) == null) {
            if (TextUtils.isEmpty(str) || activity == null) {
                return false;
            }
            c.a.f0.a.a().c(activity, str, bVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean e(Activity activity, String str, c.a.f0.f.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, bVar)) == null) {
            if (TextUtils.isEmpty(str) || activity == null) {
                return false;
            }
            c.a.f0.a.a().e(activity, str, bVar);
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
            /* loaded from: classes10.dex */
            public class a implements c.a.f0.f.b {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c.a.h0.s.g.a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AnonymousClass2 f38974b;

                public a(AnonymousClass2 anonymousClass2, c.a.h0.s.g.a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {anonymousClass2, aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38974b = anonymousClass2;
                    this.a = aVar;
                }

                @Override // c.a.f0.f.b
                public void onPayResult(int i2, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                        c.a.h0.s.g.a aVar = this.a;
                        PaymentManager.g(aVar, i2, this.f38974b.this$0.a.getString(c.a.f0.d.alipay_result_tiitle) + str);
                    }
                }
            }

            /* renamed from: com.baidu.payment.PaymentManager$2$b */
            /* loaded from: classes10.dex */
            public class b implements c.a.f0.f.b {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c.a.h0.s.g.a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AnonymousClass2 f38975b;

                public b(AnonymousClass2 anonymousClass2, c.a.h0.s.g.a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {anonymousClass2, aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38975b = anonymousClass2;
                    this.a = aVar;
                }

                @Override // c.a.f0.f.b
                public void onPayResult(int i2, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                        c.a.h0.s.g.a aVar = this.a;
                        PaymentManager.g(aVar, i2, this.f38975b.this$0.a.getString(c.a.f0.d.wx_pay_result_title) + str);
                    }
                }
            }

            /* renamed from: com.baidu.payment.PaymentManager$2$c */
            /* loaded from: classes10.dex */
            public class c implements c.a.f0.f.b {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c.a.h0.s.g.a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AnonymousClass2 f38976b;

                public c(AnonymousClass2 anonymousClass2, c.a.h0.s.g.a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {anonymousClass2, aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38976b = anonymousClass2;
                    this.a = aVar;
                }

                @Override // c.a.f0.f.b
                public void onPayResult(int i2, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                        c.a.h0.s.g.a aVar = this.a;
                        PaymentManager.g(aVar, i2, this.f38976b.this$0.a.getString(c.a.f0.d.baifubao_pay_result_title) + str);
                    }
                }
            }

            /* renamed from: com.baidu.payment.PaymentManager$2$d */
            /* loaded from: classes10.dex */
            public class d implements c.a.f0.f.b {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c.a.h0.s.g.a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AnonymousClass2 f38977b;

                public d(AnonymousClass2 anonymousClass2, c.a.h0.s.g.a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {anonymousClass2, aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38977b = anonymousClass2;
                    this.a = aVar;
                }

                @Override // c.a.f0.f.b
                public void onPayResult(int i2, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                        c.a.h0.s.g.a aVar = this.a;
                        PaymentManager.g(aVar, i2, this.f38977b.this$0.a.getString(c.a.f0.d.chinapay_pay_result_title) + str);
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
            public void pay(Activity activity2, c.a.h0.s.g.b bVar, c.a.h0.s.g.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, activity2, bVar, aVar) == null) {
                    char c2 = 6;
                    if (bVar == null || TextUtils.isEmpty(bVar.a) || bVar.f3730b == null) {
                        PaymentManager.g(aVar, 6, this.this$0.a.getString(c.a.f0.d.order_info_error));
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
                            if (str.equals(PayChannelController.BAIFUBAO_PAYCHANNEL)) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1455583605:
                            if (str.equals(PayChannelController.ALIPAY_PAYCHANNEL)) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1525377225:
                            break;
                        case 2009937959:
                            if (str.equals(PayChannelController.WXPAY_PAYCHANNEL)) {
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
                            c.a.f0.b f2 = c.a.f0.b.f();
                            Activity activity3 = this.val$businessActivity;
                            if (activity3 == null) {
                                activity3 = activity2;
                            }
                            f2.a(activity3, bVar.f3730b.optString("orderInfo"), new a(this, aVar));
                            break;
                        case 3:
                            c.a.f0.b.f().e(activity2, bVar.f3730b, new b(this, aVar));
                            break;
                        case 4:
                            c.a.f0.b f3 = c.a.f0.b.f();
                            Activity activity4 = this.val$businessActivity;
                            if (activity4 == null) {
                                activity4 = activity2;
                            }
                            f3.b(activity4, bVar.f3730b.optString("orderInfo"), new c(this, aVar));
                            break;
                        case 5:
                            c.a.h0.s.g.a unused = PaymentManager.f38972c = aVar;
                            c.a.f0.c.c();
                            c.a.f0.b.f().d(activity2, bVar.f3730b);
                            break;
                        case 6:
                            c.a.f0.b.f().c(activity2, bVar.f3730b, new d(this, aVar));
                            break;
                        default:
                            aVar.onResult(3, this.this$0.a.getString(c.a.f0.d.unknow_pay_channel));
                            break;
                    }
                    activity2.finish();
                }
            }
        } : (IChannelPay) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void j(Activity activity, JSONObject jSONObject, String[] strArr, c.a.f0.f.b bVar) {
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
                int i2 = 0;
                while (i2 < strArr2.length) {
                    String str2 = strArr2[i2];
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
                        strArr3[i2] = PayChannelController.ALIPAY_PAYCHANNEL;
                    } else if (c3 == 1) {
                        strArr3[i2] = PayChannelController.WXPAY_PAYCHANNEL;
                    } else if (c3 == 2) {
                        strArr3[i2] = PayChannelController.BAIFUBAO_PAYCHANNEL;
                    } else if (c3 == 3) {
                        strArr3[i2] = "BAIDU-QUICKPAY";
                    } else if (c3 == 4) {
                        strArr3[i2] = "BAIDU-ALIPAY-WISE-HUABEI-PAY";
                    } else if (c3 == 5) {
                        strArr3[i2] = "BAIDU-CHINAPAY-B2C";
                    }
                    i2++;
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
                    str = PayChannelController.ALIPAY_PAYCHANNEL;
                } else if (c2 == 1) {
                    str = PayChannelController.WXPAY_PAYCHANNEL;
                } else if (c2 == 2) {
                    str = PayChannelController.BAIFUBAO_PAYCHANNEL;
                } else if (c2 == 3) {
                    str = "BAIDU-QUICKPAY";
                } else if (c2 == 4) {
                    str = "BAIDU-ALIPAY-WISE-HUABEI-PAY";
                } else if (c2 != 5) {
                    str = string;
                }
                bundle.putString(PolyActivity.CHOSEN_CHANNEL_KEY, str);
            }
            bundle.putString("zid", c.a.f0.a.a().j(activity));
            f(activity).b(activity, bundle, h(null), new PaymentAliChannelAuth(), e.d(), new a(this, bVar));
        }
    }

    public void l(@NonNull Activity activity, @NonNull JSONArray jSONArray, @NonNull c.a.f0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, activity, jSONArray, aVar) == null) {
            f(activity).f(activity, new c.a.h0.t.c.a(jSONArray), new c(this, aVar));
        }
    }

    public void m(@NonNull Bundle bundle, @NonNull c.a.f0.f.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bundle, dVar) == null) {
            f(AppRuntime.getAppContext()).d(bundle, new b(this, dVar));
        }
    }

    public void n(@NonNull Bundle bundle, @NonNull c.a.f0.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bundle, cVar) == null) {
            f(AppRuntime.getAppContext()).a(bundle, new d(this, cVar));
        }
    }

    public void o(JSONObject jSONObject, c.a.h0.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, jSONObject, aVar) == null) {
            f(AppRuntime.getAppContext()).e(1, jSONObject, aVar);
        }
    }

    public void p(c.a.h0.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            c.a.h0.b f2 = f(AppRuntime.getAppContext());
            f2.e(2, null, aVar);
            f2.c();
        }
    }
}

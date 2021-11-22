package b.a.e0;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import b.a.e0.r.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.statistics.exception.SdkException;
import com.baidu.poly.wallet.paychannel.IChannelAuth;
import com.baidu.poly.wallet.paychannel.IChannelPay;
import com.baidu.poly.widget.CouponListDialog;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f2545a;

    /* loaded from: classes.dex */
    public class a extends b.a.e0.l.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f2546a;

        public a(b bVar, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2546a = dVar;
        }

        @Override // b.a.e0.l.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                b.a.e0.p.c cVar = new b.a.e0.p.c("1");
                cVar.b(new SdkException("gatewaylist error --> " + str, th).getStackMessage());
                b.a.e0.p.f.e(cVar);
                b.a.e0.r.h.g("requestChannelList onError result=" + str);
                d dVar = this.f2546a;
                if (dVar != null) {
                    dVar.onError(str);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e0.l.a
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                b.a.e0.r.h.g("requestChannelList onSuccess result=" + jSONObject.toString());
                d dVar = this.f2546a;
                if (dVar != null) {
                    dVar.onSuccess(jSONObject.toString());
                }
            }
        }
    }

    /* renamed from: b.a.e0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0044b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f2547a;

        /* renamed from: b  reason: collision with root package name */
        public Context f2548b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2549c;

        public C0044b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2547a = 1;
            this.f2549c = false;
        }

        public b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this, null) : (b) invokeV.objValue;
        }

        public C0044b e(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                this.f2548b = context;
                return this;
            }
            return (C0044b) invokeL.objValue;
        }

        public C0044b f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f2549c = z;
                return this;
            }
            return (C0044b) invokeZ.objValue;
        }

        public C0044b g(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.f2547a = i2;
                return this;
            }
            return (C0044b) invokeI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public abstract void a(int i2, String str);
    }

    /* loaded from: classes.dex */
    public interface d {
        void onError(String str);

        void onSuccess(String str);
    }

    public /* synthetic */ b(C0044b c0044b, b.a.e0.a aVar) {
        this(c0044b);
    }

    public void a(Bundle bundle, b.a.e0.s.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bundle, aVar) == null) {
            b.a.e0.s.e.b.a(bundle, aVar);
        }
    }

    public void b(Context context, Bundle bundle, IChannelPay iChannelPay, IChannelAuth iChannelAuth, b.a.e0.s.g.c cVar, c cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, bundle, iChannelPay, iChannelAuth, cVar, cVar2}) == null) {
            if (context == null) {
                throw new IllegalArgumentException("context can not be null");
            }
            if (bundle == null) {
                throw new IllegalArgumentException("arguments can not be null");
            }
            if (iChannelPay != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f2545a < 1000) {
                    b.a.e0.r.h.g("cashier pay time interval less than 1s");
                    return;
                }
                this.f2545a = currentTimeMillis;
                b.a.e0.r.h.g("cashier pay");
                String str = "1";
                b.a.e0.p.b.a("1", currentTimeMillis);
                String string = bundle.getString(PolyActivity.CHOSEN_CHANNEL_KEY);
                String string2 = bundle.getString(PolyActivity.PANEL_TYPE_KEY);
                if (TextUtils.equals(string2, "NONE") && !TextUtils.isEmpty(string)) {
                    str = "0";
                } else if (!TextUtils.equals(string2, PolyActivity.HALF_PANEL_TYPE) && TextUtils.equals(string2, PolyActivity.FULL_PANEL_TYPE)) {
                    str = "2";
                }
                b.a.e0.p.c cVar3 = new b.a.e0.p.c("0");
                cVar3.a(PolyActivity.PANEL_TYPE_KEY, str);
                b.a.e0.p.f.e(cVar3);
                PolyActivity.startPay(context, iChannelPay, iChannelAuth, cVar, cVar2, bundle);
                return;
            }
            throw new IllegalArgumentException("channelPay can not be null");
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.e0.p.e.g().h();
        }
    }

    public void d(Bundle bundle, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bundle, dVar) == null) {
            b.a.e0.p.b.a("1.01", System.currentTimeMillis());
            b.a.e0.l.h.b.j().f(b.a.e0.r.k.b(l.a(), bundle), true, new a(this, dVar));
        }
    }

    public void e(int i2, JSONObject jSONObject, b.a.e0.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i2, jSONObject, aVar) == null) {
            if (i2 == 1) {
                b.a.e0.l.h.a.c(jSONObject, aVar);
            } else if (i2 == 2) {
                b.a.e0.l.i.a.f(aVar);
            } else if (aVar != null) {
                aVar.a(1, "unknown command");
            }
        }
    }

    public void f(Activity activity, b.a.e0.t.c.a aVar, CouponListDialog.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, aVar, dVar) == null) {
            if (activity == null) {
                b.a.e0.r.h.d("couponEntity is null!");
            } else if (aVar != null && aVar.f2773b != null) {
                CouponListDialog couponListDialog = new CouponListDialog(activity);
                couponListDialog.setListener(dVar);
                couponListDialog.update(aVar.f2773b);
                couponListDialog.show();
            } else {
                b.a.e0.r.h.d("couponEntity || couponItemList is null!");
            }
        }
    }

    public b(C0044b c0044b) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c0044b};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2545a = 0L;
        if (c0044b != null) {
            if (c0044b.f2548b != null) {
                b.a.e0.l.h.a.b(c0044b.f2547a);
                b.a.e0.m.b.c(b.a.e0.m.a.d(c0044b.f2548b.getApplicationContext()));
                l.b(c0044b.f2548b.getApplicationContext());
                b.a.e0.r.h.f2696d = c0044b.f2549c;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("builder can not be null");
    }
}

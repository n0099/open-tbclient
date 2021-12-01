package c.a.f0;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.f0.r.l;
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
    public long a;

    /* loaded from: classes.dex */
    public class a extends c.a.f0.l.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

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
            this.a = dVar;
        }

        @Override // c.a.f0.l.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                c.a.f0.p.c cVar = new c.a.f0.p.c("1");
                cVar.b(new SdkException("gatewaylist error --> " + str, th).getStackMessage());
                c.a.f0.p.f.e(cVar);
                c.a.f0.r.h.g("requestChannelList onError result=" + str);
                d dVar = this.a;
                if (dVar != null) {
                    dVar.onError(str);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.f0.l.a
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                c.a.f0.r.h.g("requestChannelList onSuccess result=" + jSONObject.toString());
                d dVar = this.a;
                if (dVar != null) {
                    dVar.onSuccess(jSONObject.toString());
                }
            }
        }
    }

    /* renamed from: c.a.f0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0103b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public Context f3090b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3091c;

        public C0103b() {
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
            this.a = 1;
            this.f3091c = false;
        }

        public b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this, null) : (b) invokeV.objValue;
        }

        public C0103b e(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                this.f3090b = context;
                return this;
            }
            return (C0103b) invokeL.objValue;
        }

        public C0103b f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f3091c = z;
                return this;
            }
            return (C0103b) invokeZ.objValue;
        }

        public C0103b g(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.a = i2;
                return this;
            }
            return (C0103b) invokeI.objValue;
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

    public /* synthetic */ b(C0103b c0103b, c.a.f0.a aVar) {
        this(c0103b);
    }

    public void a(Bundle bundle, c.a.f0.s.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bundle, aVar) == null) {
            c.a.f0.s.e.b.a(bundle, aVar);
        }
    }

    public void b(Context context, Bundle bundle, IChannelPay iChannelPay, IChannelAuth iChannelAuth, c.a.f0.s.g.c cVar, c cVar2) {
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
                if (currentTimeMillis - this.a < 1000) {
                    c.a.f0.r.h.g("cashier pay time interval less than 1s");
                    return;
                }
                this.a = currentTimeMillis;
                c.a.f0.r.h.g("cashier pay");
                String str = "1";
                c.a.f0.p.b.a("1", currentTimeMillis);
                String string = bundle.getString(PolyActivity.CHOSEN_CHANNEL_KEY);
                String string2 = bundle.getString(PolyActivity.PANEL_TYPE_KEY);
                if (TextUtils.equals(string2, PolyActivity.NONE_PANEL_TYPE) && !TextUtils.isEmpty(string)) {
                    str = "0";
                } else if (!TextUtils.equals(string2, PolyActivity.HALF_PANEL_TYPE) && TextUtils.equals(string2, PolyActivity.FULL_PANEL_TYPE)) {
                    str = "2";
                }
                c.a.f0.p.c cVar3 = new c.a.f0.p.c("0");
                cVar3.a(PolyActivity.PANEL_TYPE_KEY, str);
                c.a.f0.p.f.e(cVar3);
                PolyActivity.startPay(context, iChannelPay, iChannelAuth, cVar, cVar2, bundle);
                return;
            }
            throw new IllegalArgumentException("channelPay can not be null");
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.f0.p.e.g().h();
        }
    }

    public void d(Bundle bundle, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bundle, dVar) == null) {
            c.a.f0.p.b.a("1.01", System.currentTimeMillis());
            c.a.f0.l.h.b.j().f(c.a.f0.r.k.b(l.a(), bundle), true, new a(this, dVar));
        }
    }

    public void e(int i2, JSONObject jSONObject, c.a.f0.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i2, jSONObject, aVar) == null) {
            if (i2 == 1) {
                c.a.f0.l.h.a.c(jSONObject, aVar);
            } else if (i2 == 2) {
                c.a.f0.l.i.a.f(aVar);
            } else if (aVar != null) {
                aVar.a(1, "unknown command");
            }
        }
    }

    public void f(Activity activity, c.a.f0.t.c.a aVar, CouponListDialog.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, aVar, dVar) == null) {
            if (activity == null) {
                c.a.f0.r.h.d("couponEntity is null!");
            } else if (aVar != null && aVar.f3259b != null) {
                CouponListDialog couponListDialog = new CouponListDialog(activity);
                couponListDialog.setListener(dVar);
                couponListDialog.update(aVar.f3259b);
                couponListDialog.show();
            } else {
                c.a.f0.r.h.d("couponEntity || couponItemList is null!");
            }
        }
    }

    public b(C0103b c0103b) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c0103b};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        if (c0103b != null) {
            if (c0103b.f3090b != null) {
                c.a.f0.l.h.a.b(c0103b.a);
                c.a.f0.m.b.c(c.a.f0.m.a.d(c0103b.f3090b.getApplicationContext()));
                l.b(c0103b.f3090b.getApplicationContext());
                c.a.f0.r.h.f3204d = c0103b.f3091c;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("builder can not be null");
    }
}

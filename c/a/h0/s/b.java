package c.a.h0.s;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import c.a.h0.g;
import c.a.h0.i;
import c.a.h0.p.f;
import c.a.h0.r.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.ChannelListView;
import com.baidu.poly.widget.PopupWindow;
import com.baidu.poly.widget.toast.ToastLoadingView;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile b f3683e;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public ToastLoadingView f3684b;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f3685c;

    /* renamed from: d  reason: collision with root package name */
    public PopupWindow f3686d;

    /* loaded from: classes.dex */
    public class a extends c.a.h0.l.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f3687b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f3688c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Bundle f3689d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f3690e;

        public a(b bVar, ChannelListView channelListView, boolean z, Context context, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, channelListView, Boolean.valueOf(z), context, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3690e = bVar;
            this.a = channelListView;
            this.f3687b = z;
            this.f3688c = context;
            this.f3689d = bundle;
        }

        @Override // c.a.h0.l.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                this.f3690e.f("2", str);
                this.a.errorEnd(this.f3688c.getString(i.wx_h5_trade_fail), null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.h0.l.a
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                int optInt = jSONObject.optInt("payStatus", 3);
                this.f3690e.f("1", String.valueOf(optInt));
                if (optInt == 2) {
                    this.a.payEnd(0, c.a.h0.r.e.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")), "0");
                } else if (this.f3687b) {
                    this.f3690e.j(this.f3688c, this.f3689d, this.a);
                } else {
                    this.f3690e.k(this.f3688c, this.a);
                }
            }
        }
    }

    /* renamed from: c.a.h0.s.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0138b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f3691e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f3692f;

        public View$OnClickListenerC0138b(b bVar, ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3692f = bVar;
            this.f3691e = channelListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f3692f.f3685c.n();
                c.a.h0.p.c cVar = new c.a.h0.p.c(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
                cVar.b("1");
                f.e(cVar);
                this.f3691e.payEnd(3, "pay failed , click choose window", "0");
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f3693e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f3694f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f3695g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f3696h;

        public c(b bVar, Context context, Bundle bundle, ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, bundle, channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3696h = bVar;
            this.f3693e = context;
            this.f3694f = bundle;
            this.f3695g = channelListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f3696h.f3685c.n();
                c.a.h0.p.c cVar = new c.a.h0.p.c(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
                cVar.b("2");
                f.e(cVar);
                this.f3696h.i(this.f3693e, this.f3694f, this.f3695g, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f3697e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3697e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f3697e.f3686d != null && this.f3697e.f3686d.r()) {
                this.f3697e.f3686d.n();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public e(b bVar, ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // com.baidu.poly.widget.PopupWindow.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.payEnd(3, "pay failed , click error window", "0");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-919908874, "Lc/a/h0/s/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-919908874, "Lc/a/h0/s/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f3683e == null) {
                synchronized (b.class) {
                    if (f3683e == null) {
                        f3683e = new b();
                    }
                }
            }
            return f3683e;
        }
        return (b) invokeV.objValue;
    }

    public final void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            c.a.h0.t.e.a.b(this.f3684b);
            try {
                if (this.a == 0) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.a);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                c.a.h0.p.c cVar = new c.a.h0.p.c(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN);
                cVar.c(jSONObject);
                f.e(cVar);
            } catch (JSONException e2) {
                if (h.f3680d) {
                    e2.printStackTrace();
                }
            } finally {
                this.a = 0L;
            }
        }
    }

    public final View g(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            if (activity == null || activity.getWindow() == null) {
                return null;
            }
            return activity.getWindow().getDecorView().findViewById(16908290);
        }
        return (View) invokeL.objValue;
    }

    public void i(Context context, Bundle bundle, ChannelListView channelListView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, bundle, channelListView, Boolean.valueOf(z)}) == null) || context == null || bundle == null || channelListView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f3684b = c.a.h0.t.e.a.c((ViewGroup) g((Activity) context), layoutParams, null, -1L);
        this.a = System.currentTimeMillis();
        c.a.h0.l.h.b.j().m(bundle, new a(this, channelListView, z, context, bundle));
    }

    public final void j(Context context, Bundle bundle, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, bundle, channelListView) == null) {
            View inflate = View.inflate(channelListView.getContext(), c.a.h0.h.pay_confirm, null);
            PopupWindow popupWindow = new PopupWindow(inflate, -1, -1, true);
            this.f3685c = popupWindow;
            popupWindow.w(false);
            this.f3685c.B(false);
            ((TextView) inflate.findViewById(g.bt_pay_meet_problems)).setOnClickListener(new View$OnClickListenerC0138b(this, channelListView));
            ((TextView) inflate.findViewById(g.bt_pay_already_finish)).setOnClickListener(new c(this, context, bundle, channelListView));
            this.f3685c.D(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
            f.e(new c.a.h0.p.c(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY));
        }
    }

    public final void k(Context context, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, channelListView) == null) {
            View inflate = View.inflate(channelListView.getContext(), c.a.h0.h.default_pop_window, null);
            ((TextView) inflate.findViewById(g.pop_title)).setText(i.pay_failed);
            ((TextView) inflate.findViewById(g.pop_tips)).setText(i.pay_failed_sub_text);
            PopupWindow popupWindow = new PopupWindow(inflate, -1, -1, true);
            this.f3686d = popupWindow;
            popupWindow.w(false);
            this.f3686d.B(false);
            this.f3686d.v(new ColorDrawable(0));
            ((TextView) inflate.findViewById(g.pop_button)).setOnClickListener(new d(this));
            this.f3686d.A(new e(this, channelListView));
            this.f3686d.D(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        }
    }
}

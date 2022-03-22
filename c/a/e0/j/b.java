package c.a.e0.j;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import c.a.e0.g.f;
import c.a.e0.i.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.ChannelListView;
import com.baidu.poly.widget.PopupWindow;
import com.baidu.poly.widget.toast.ToastLoadingView;
import com.baidu.sofire.d.D;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.R;
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
    public static volatile b f2810e;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public ToastLoadingView f2811b;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f2812c;

    /* renamed from: d  reason: collision with root package name */
    public PopupWindow f2813d;

    /* loaded from: classes.dex */
    public class a extends c.a.e0.c.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f2814b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f2815c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Bundle f2816d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f2817e;

        public a(b bVar, ChannelListView channelListView, boolean z, Context context, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, channelListView, Boolean.valueOf(z), context, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2817e = bVar;
            this.a = channelListView;
            this.f2814b = z;
            this.f2815c = context;
            this.f2816d = bundle;
        }

        @Override // c.a.e0.c.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                this.f2817e.f("2", str);
                this.a.R(this.f2815c.getString(R.string.obfuscated_res_0x7f0f15a8), null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e0.c.a
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                int optInt = jSONObject.optInt("payStatus", 3);
                this.f2817e.f("1", String.valueOf(optInt));
                if (optInt == 2) {
                    this.a.a0(0, c.a.e0.i.e.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")), "0");
                } else if (this.f2814b) {
                    this.f2817e.j(this.f2815c, this.f2816d, this.a);
                } else {
                    this.f2817e.k(this.f2815c, this.a);
                }
            }
        }
    }

    /* renamed from: c.a.e0.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0126b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f2818b;

        public View$OnClickListenerC0126b(b bVar, ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2818b = bVar;
            this.a = channelListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f2818b.f2812c.n();
                c.a.e0.g.c cVar = new c.a.e0.g.c(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
                cVar.b("1");
                f.e(cVar);
                this.a.a0(3, "pay failed , click choose window", "0");
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bundle f2819b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f2820c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f2821d;

        public c(b bVar, Context context, Bundle bundle, ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, bundle, channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2821d = bVar;
            this.a = context;
            this.f2819b = bundle;
            this.f2820c = channelListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f2821d.f2812c.n();
                c.a.e0.g.c cVar = new c.a.e0.g.c(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
                cVar.b("2");
                f.e(cVar);
                this.f2821d.i(this.a, this.f2819b, this.f2820c, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.a.f2813d != null && this.a.f2813d.r()) {
                this.a.f2813d.n();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.a0(3, "pay failed , click error window", "0");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(712279260, "Lc/a/e0/j/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(712279260, "Lc/a/e0/j/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f2810e == null) {
                synchronized (b.class) {
                    if (f2810e == null) {
                        f2810e = new b();
                    }
                }
            }
            return f2810e;
        }
        return (b) invokeV.objValue;
    }

    public final void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            c.a.e0.k.g.a.b(this.f2811b);
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
                    jSONObject.put(D.COLUMU_PLUGIN_DURATION, String.valueOf(valueOf));
                }
                c.a.e0.g.c cVar = new c.a.e0.g.c(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN);
                cVar.c(jSONObject);
                f.e(cVar);
            } catch (JSONException e2) {
                if (h.f2807d) {
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
        this.f2811b = c.a.e0.k.g.a.c((ViewGroup) g((Activity) context), layoutParams, null, -1L);
        this.a = System.currentTimeMillis();
        c.a.e0.c.h.b.j().m(bundle, new a(this, channelListView, z, context, bundle));
    }

    public final void j(Context context, Bundle bundle, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, bundle, channelListView) == null) {
            View inflate = View.inflate(channelListView.getContext(), R.layout.obfuscated_res_0x7f0d065a, null);
            PopupWindow popupWindow = new PopupWindow(inflate, -1, -1, true);
            this.f2812c = popupWindow;
            popupWindow.w(false);
            this.f2812c.B(false);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0903f4)).setOnClickListener(new View$OnClickListenerC0126b(this, channelListView));
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0903f3)).setOnClickListener(new c(this, context, bundle, channelListView));
            this.f2812c.D(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
            f.e(new c.a.e0.g.c("102"));
        }
    }

    public final void k(Context context, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, channelListView) == null) {
            View inflate = View.inflate(channelListView.getContext(), R.layout.obfuscated_res_0x7f0d0218, null);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0918a1)).setText(R.string.obfuscated_res_0x7f0f0d42);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0918a0)).setText(R.string.obfuscated_res_0x7f0f0d43);
            PopupWindow popupWindow = new PopupWindow(inflate, -1, -1, true);
            this.f2813d = popupWindow;
            popupWindow.w(false);
            this.f2813d.B(false);
            this.f2813d.v(new ColorDrawable(0));
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09189b)).setOnClickListener(new d(this));
            this.f2813d.A(new e(this, channelListView));
            this.f2813d.D(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        }
    }
}

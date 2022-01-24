package c.a.r0.j.p0.d.a;

import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
import c.a.r0.a.z2.n0;
import c.a.r0.a.z2.q0;
import c.a.r0.h.g;
import c.a.r0.j.p0.d.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b extends EventTargetImpl implements a.InterfaceC0772a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ApiButton f11289e;
    @V8JavascriptField
    public String image;
    @V8JavascriptField
    public c.a.r0.j.p0.d.a.a style;
    @V8JavascriptField
    public String text;
    @V8JavascriptField
    public String type;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f11290e;

        public a(b bVar) {
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
            this.f11290e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApiButton apiButton;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (apiButton = this.f11290e.f11289e) == null) {
                return;
            }
            c.a.r0.j.p0.b.d(apiButton);
            this.f11290e.f11289e = null;
        }
    }

    /* renamed from: c.a.r0.j.p0.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0773b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f11291e;

        public RunnableC0773b(b bVar) {
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
            this.f11291e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApiButton apiButton;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (apiButton = this.f11291e.f11289e) == null) {
                return;
            }
            apiButton.hide();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f11292e;

        public c(b bVar) {
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
            this.f11292e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApiButton apiButton;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (apiButton = this.f11292e.f11289e) == null) {
                return;
            }
            apiButton.show();
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11293e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f11294f;

        public d(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11294f = bVar;
            this.f11293e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (k.a) {
                    String str = "onFieldChangedCallback fieldName=" + this.f11293e;
                }
                if (this.f11294f.f11289e == null) {
                    return;
                }
                String str2 = this.f11293e;
                char c2 = 65535;
                int hashCode = str2.hashCode();
                if (hashCode != 3556653) {
                    if (hashCode == 100313435 && str2.equals("image")) {
                        c2 = 1;
                    }
                } else if (str2.equals("text")) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    b bVar = this.f11294f;
                    bVar.f11289e.setButtonText(bVar.text);
                } else if (c2 != 1) {
                } else {
                    b bVar2 = this.f11294f;
                    bVar2.f11289e.setImageUrl(bVar2.image);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f11295e;

        public e(b bVar) {
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
            this.f11295e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b bVar = this.f11295e;
                if (bVar.f11289e == null || bVar.B()) {
                    return;
                }
                this.f11295e.f11289e.bindStyle();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(JsObject jsObject, c.a.r0.a.l0.c cVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsObject, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.type = "text";
        this.text = c.a.r0.a.c1.a.c().getString(g.aiapps_aigames_userinfo_button_text_des);
        A(jsObject);
    }

    public final void A(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) {
            c.a.r0.a.y.b.a F = c.a.r0.a.y.b.a.F(jsObject);
            if (k.a) {
                if (("parse jsObject = " + F) != null) {
                    F.toString();
                }
            }
            if (F == null) {
                return;
            }
            this.type = F.C("type", this.type);
            this.text = F.C("text", this.text);
            this.image = F.C("image", this.image);
            c.a.r0.a.y.b.a x = F.x("style", null);
            this.style = x == null ? this.style : new c.a.r0.j.p0.d.a.a(x);
        }
    }

    public final boolean B() {
        InterceptResult invokeV;
        c.a.r0.a.m1.e.a.a z;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f11289e == null || this.style == null || (z = z()) == null || !c.a.r0.j.p0.b.f(this.f11289e, z)) ? false : true : invokeV.booleanValue;
    }

    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            q0.e0(new a(this));
        }
    }

    @JavascriptInterface
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            q0.e0(new RunnableC0773b(this));
        }
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            q0.e0(new d(this, str));
        }
    }

    @Override // c.a.r0.j.p0.d.a.a.InterfaceC0772a
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            q0.e0(new e(this));
        }
    }

    @JavascriptInterface
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            q0.e0(new c(this));
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        c.a.r0.j.p0.d.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f11289e == null || (aVar = this.style) == null) {
                return false;
            }
            aVar.b(this);
            c.a.r0.a.m1.e.a.a z = z();
            return z != null && c.a.r0.j.p0.b.a(this.f11289e, z);
        }
        return invokeV.booleanValue;
    }

    public final c.a.r0.a.m1.e.a.a z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c.a.r0.j.p0.d.a.a aVar = this.style;
            if (aVar == null || this.f11289e == null) {
                return null;
            }
            int g2 = n0.g(aVar.width);
            int g3 = n0.g(this.style.height);
            int g4 = n0.g(this.style.left);
            int g5 = n0.g(this.style.top);
            int g6 = n0.g(this.style.borderWidth) * 2;
            if (g2 < g6) {
                g2 = g6;
            }
            if (g3 < g6) {
                g3 = g6;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f11289e.getLayoutParams();
            if (layoutParams != null && layoutParams.width == g2 && layoutParams.height == g3 && layoutParams.leftMargin == g4 && layoutParams.topMargin == g5) {
                return null;
            }
            return new c.a.r0.a.m1.e.a.a(g4, g5, g2, g3);
        }
        return (c.a.r0.a.m1.e.a.a) invokeV.objValue;
    }
}

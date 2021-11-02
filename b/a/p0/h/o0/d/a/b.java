package b.a.p0.h.o0.d.a;

import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.q0;
import b.a.p0.f.g;
import b.a.p0.h.o0.d.a.a;
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
/* loaded from: classes4.dex */
public class b extends EventTargetImpl implements a.InterfaceC0579a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ApiButton f10618e;
    @V8JavascriptField
    public String image;
    @V8JavascriptField
    public b.a.p0.h.o0.d.a.a style;
    @V8JavascriptField
    public String text;
    @V8JavascriptField
    public String type;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10619e;

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
            this.f10619e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApiButton apiButton;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (apiButton = this.f10619e.f10618e) == null) {
                return;
            }
            b.a.p0.h.o0.b.d(apiButton);
            this.f10619e.f10618e = null;
        }
    }

    /* renamed from: b.a.p0.h.o0.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0580b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10620e;

        public RunnableC0580b(b bVar) {
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
            this.f10620e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApiButton apiButton;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (apiButton = this.f10620e.f10618e) == null) {
                return;
            }
            apiButton.hide();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10621e;

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
            this.f10621e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApiButton apiButton;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (apiButton = this.f10621e.f10618e) == null) {
                return;
            }
            apiButton.show();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10622e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f10623f;

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
            this.f10623f = bVar;
            this.f10622e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (k.f6397a) {
                    String str = "onFieldChangedCallback fieldName=" + this.f10622e;
                }
                if (this.f10623f.f10618e == null) {
                    return;
                }
                String str2 = this.f10622e;
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
                    b bVar = this.f10623f;
                    bVar.f10618e.setButtonText(bVar.text);
                } else if (c2 != 1) {
                } else {
                    b bVar2 = this.f10623f;
                    bVar2.f10618e.setImageUrl(bVar2.image);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10624e;

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
            this.f10624e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b bVar = this.f10624e;
                if (bVar.f10618e == null || bVar.A()) {
                    return;
                }
                this.f10624e.f10618e.bindStyle();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(JsObject jsObject, b.a.p0.a.l0.c cVar) {
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
        this.text = b.a.p0.a.c1.a.b().getString(g.aiapps_aigames_userinfo_button_text_des);
        z(jsObject);
    }

    public final boolean A() {
        InterceptResult invokeV;
        b.a.p0.a.l1.e.a.a y;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.f10618e == null || this.style == null || (y = y()) == null || !b.a.p0.h.o0.b.f(this.f10618e, y)) ? false : true : invokeV.booleanValue;
    }

    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            q0.b0(new a(this));
        }
    }

    @JavascriptInterface
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            q0.b0(new RunnableC0580b(this));
        }
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            q0.b0(new d(this, str));
        }
    }

    @Override // b.a.p0.h.o0.d.a.a.InterfaceC0579a
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q0.b0(new e(this));
        }
    }

    @JavascriptInterface
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            q0.b0(new c(this));
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        b.a.p0.h.o0.d.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f10618e == null || (aVar = this.style) == null) {
                return false;
            }
            aVar.b(this);
            b.a.p0.a.l1.e.a.a y = y();
            return y != null && b.a.p0.h.o0.b.a(this.f10618e, y);
        }
        return invokeV.booleanValue;
    }

    public final b.a.p0.a.l1.e.a.a y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b.a.p0.h.o0.d.a.a aVar = this.style;
            if (aVar == null || this.f10618e == null) {
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
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f10618e.getLayoutParams();
            if (layoutParams != null && layoutParams.width == g2 && layoutParams.height == g3 && layoutParams.leftMargin == g4 && layoutParams.topMargin == g5) {
                return null;
            }
            return new b.a.p0.a.l1.e.a.a(g4, g5, g2, g3);
        }
        return (b.a.p0.a.l1.e.a.a) invokeV.objValue;
    }

    public final void z(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) {
            b.a.p0.a.y.b.a F = b.a.p0.a.y.b.a.F(jsObject);
            if (k.f6397a) {
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
            b.a.p0.a.y.b.a x = F.x("style", null);
            this.style = x == null ? this.style : new b.a.p0.h.o0.d.a.a(x);
        }
    }
}

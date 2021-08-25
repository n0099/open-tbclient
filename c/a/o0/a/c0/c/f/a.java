package c.a.o0.a.c0.c.f;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.o0.a.v2.n0;
import c.a.o0.a.v2.x;
import c.a.o0.a.z0.f.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a extends c.a.o0.a.c0.a.a.a<SwanEditText, c.a.o0.a.c0.c.f.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public SwanAppActivity f4653i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.o0.a.h0.g.f f4654j;
    public c.a.o0.a.z0.f.b k;
    public int l;

    /* renamed from: c.a.o0.a.c0.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0124a extends c.a.o0.a.t0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f4655a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f4656b;

        public C0124a(a aVar, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4656b = aVar;
            this.f4655a = swanEditText;
        }

        @Override // c.a.o0.a.t0.a, c.a.o0.a.t0.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f4656b.k == null) {
                return;
            }
            this.f4656b.k.dismiss();
            this.f4656b.r0(this.f4655a);
        }

        @Override // c.a.o0.a.t0.a, c.a.o0.a.t0.b
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, keyEvent)) == null) {
                if (i2 != 4 || this.f4656b.k == null) {
                    return false;
                }
                this.f4656b.k.dismiss();
                this.f4656b.r0(this.f4655a);
                return true;
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f4657a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.c0.c.f.b f4658b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.t0.a f4659c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f4660d;

        public b(a aVar, SwanEditText swanEditText, c.a.o0.a.c0.c.f.b bVar, c.a.o0.a.t0.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText, bVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4660d = aVar;
            this.f4657a = swanEditText;
            this.f4658b = bVar;
            this.f4659c = aVar2;
        }

        @Override // c.a.o0.a.z0.f.b.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = c.a.o0.a.c0.b.a.f4616h;
                this.f4660d.A0(this.f4657a);
                this.f4660d.f4653i.unregisterCallback(this.f4659c);
            }
        }

        @Override // c.a.o0.a.z0.f.b.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                boolean unused = c.a.o0.a.c0.b.a.f4616h;
                a aVar = this.f4660d;
                aVar.B0(aVar.f4653i, this.f4657a, this.f4658b, i2);
                this.f4660d.f4653i.registerCallback(this.f4659c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.c0.c.f.b f4661a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f4662b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f4663c;

        public c(a aVar, c.a.o0.a.c0.c.f.b bVar, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4663c = aVar;
            this.f4661a = bVar;
            this.f4662b = swanEditText;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                c.a.o0.a.z0.c.d(c.a.o0.a.z0.b.d().c(), this.f4663c.l);
                if (this.f4661a.P) {
                    return true;
                }
                this.f4662b.clearFocus();
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f4664e;

        public d(a aVar, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4664e = swanEditText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || i3 == i4) {
                return;
            }
            c.a.o0.a.z0.c.c(this.f4664e, i3 > i4 ? '\b' : charSequence.charAt((i2 + i4) - 1));
        }
    }

    /* loaded from: classes.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.c0.c.f.b f4665e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f4666f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f4667g;

        public e(a aVar, c.a.o0.a.c0.c.f.b bVar, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4667g = aVar;
            this.f4665e = bVar;
            this.f4666f = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (c.a.o0.a.c0.b.a.f4616h) {
                    String str = "onFocusChange:" + z;
                }
                if (z) {
                    return;
                }
                c.a.o0.a.e0.d.g("Component-Input", "send blur callback");
                if (!TextUtils.equals("text", this.f4665e.O) && this.f4667g.k != null) {
                    this.f4667g.k.dismiss();
                }
                c.a.o0.a.z0.c.b(this.f4666f, this.f4667g.l);
                this.f4667g.r0(this.f4666f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.o0.a.p2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f4668a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f4669b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.c0.c.f.b f4670c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ View f4671d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4672e;

        public f(a aVar, SwanEditText swanEditText, SwanAppActivity swanAppActivity, c.a.o0.a.c0.c.f.b bVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText, swanAppActivity, bVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4672e = aVar;
            this.f4668a = swanEditText;
            this.f4669b = swanAppActivity;
            this.f4670c = bVar;
            this.f4671d = view;
        }

        @Override // c.a.o0.a.p2.a
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                this.f4672e.A0(this.f4668a);
                c.a.o0.a.p2.c.i().k(this.f4671d);
            }
        }

        @Override // c.a.o0.a.p2.a
        public void b(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) && this.f4668a.hasFocus()) {
                this.f4672e.B0(this.f4669b, this.f4668a, this.f4670c, i2);
            }
        }

        @Override // c.a.o0.a.p2.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(String str, JSONObject jSONObject);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@Nullable Context context, @NonNull c.a.o0.a.c0.c.f.b bVar, @NonNull SwanAppActivity swanAppActivity, @NonNull c.a.o0.a.h0.g.f fVar, @NonNull g gVar) {
        super(context, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar, swanAppActivity, fVar, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (c.a.o0.a.c0.a.a.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4653i = swanAppActivity;
        this.f4654j = fVar;
        c.a.o0.a.z0.c.a(gVar);
    }

    @Override // c.a.o0.a.c0.b.a
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.A();
        }
    }

    public final void A0(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanEditText) == null) {
            if (c.a.o0.a.c0.b.a.f4616h) {
                String str = "scrollBackWhenKeyboardHide, mKeyboardHeight：" + this.l;
            }
            if (this.l != 0) {
                this.l = 0;
                swanEditText.clearFocus();
                if (this.f4654j.i3().getScrollY() > 0) {
                    this.f4654j.i3().setScrollY(0);
                }
            }
        }
    }

    public final void B0(@NonNull SwanAppActivity swanAppActivity, @NonNull SwanEditText swanEditText, c.a.o0.a.c0.c.f.b bVar, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048579, this, swanAppActivity, swanEditText, bVar, i2) == null) {
            c.a.o0.a.p.e.c h2 = c.a.o0.a.g1.f.V().h();
            if (c.a.o0.a.c0.b.a.f4616h) {
                String str = "scrollUpWhenKeyboardShow, mKeyboardHeight：" + this.l + "，keyboardHeight : " + i2;
            }
            if (this.l == i2 || h2 == null) {
                return;
            }
            this.l = i2;
            c.a.o0.a.z0.c.f(swanEditText, i2);
            if (bVar.Q) {
                if (bVar.l == null) {
                    bVar.l = new c.a.o0.a.l1.e.a.a();
                }
                int webViewScrollY = h2.getWebViewScrollY();
                int height = swanEditText.getHeight();
                if (height == 0) {
                    height = bVar.l.f();
                }
                int height2 = ((this.f4654j.i3().getHeight() - bVar.l.h()) - height) + webViewScrollY + n0.k(swanAppActivity);
                int i4 = bVar.H;
                if (i4 > height2) {
                    i4 = height2;
                }
                int i5 = height2 - i2;
                int scrollY = this.f4654j.i3().getScrollY();
                if (i5 < 0) {
                    i3 = i4 - i5;
                } else {
                    if (i4 > i5) {
                        scrollY = i4 - i5;
                    }
                    i3 = scrollY;
                }
                this.f4654j.i3().setScrollY(i3);
            }
        }
    }

    public final void C0(SwanEditText swanEditText, c.a.o0.a.c0.c.f.b bVar, SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, swanEditText, bVar, swanAppActivity) == null) {
            swanEditText.setOnEditorActionListener(new c(this, bVar, swanEditText));
            d dVar = new d(this, swanEditText);
            swanEditText.setOnFocusChangeListener(new e(this, bVar, swanEditText));
            if (TextUtils.equals("text", bVar.O)) {
                View decorView = swanAppActivity.getWindow().getDecorView();
                c.a.o0.a.p2.c.i().l(decorView, bVar.f4629f, new f(this, swanEditText, swanAppActivity, bVar, decorView));
            }
            c.a.o0.a.z0.b.d().f(dVar);
            swanEditText.addTextChangedListener(dVar);
        }
    }

    public final void D0(SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, swanEditText) == null) {
            try {
                Method method = SwanEditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
                method.setAccessible(true);
                method.invoke(swanEditText, Boolean.FALSE);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                if (c.a.o0.a.c0.b.a.f4616h) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void r0(@Nullable SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, swanEditText) == null) {
            SwanAppActivity activity = c.a.o0.a.g1.f.V().getActivity();
            if (activity == null) {
                c.a.o0.a.e0.d.l("Component-Input", "activity is null when close input");
                return;
            }
            x.a(activity, activity.getWindow().getDecorView().getWindowToken());
            if (swanEditText == null) {
                return;
            }
            swanEditText.setOnFocusChangeListener(null);
            c.a.o0.a.e0.d.g("Component-Input", "remove input");
            if (C().a()) {
                c.a.o0.a.e0.d.g("Component-Input", "remove input success");
            } else {
                c.a.o0.a.e0.d.l("Component-Input", "remove input fail");
            }
            c.a.o0.a.z0.b.d().b();
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            r0(c.a.o0.a.z0.b.d().c());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.a.c0.b.a
    @NonNull
    /* renamed from: t0 */
    public SwanEditText v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, context)) == null) {
            s0();
            return c.a.o0.a.z0.b.d().a(context);
        }
        return (SwanEditText) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.a.c0.b.a
    /* renamed from: u0 */
    public void B(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, swanEditText) == null) {
            super.B(swanEditText);
            c.a.o0.a.c0.c.f.b bVar = (c.a.o0.a.c0.c.f.b) n();
            swanEditText.setText(bVar.x);
            int i2 = 1;
            swanEditText.setSingleLine(true);
            swanEditText.setTag(bVar.f4632i);
            if (!TextUtils.equals("text", bVar.O)) {
                String str = bVar.O;
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1193508181) {
                    if (hashCode == 95582509 && str.equals("digit")) {
                        c2 = 0;
                    }
                } else if (str.equals("idcard")) {
                    c2 = 1;
                }
                if (c2 == 0) {
                    i2 = 2;
                } else if (c2 != 1) {
                    i2 = 0;
                }
                this.k = new c.a.o0.a.z0.f.b(this.f4653i, swanEditText, i2, bVar.G);
                this.k.e(new b(this, swanEditText, bVar, new C0124a(this, swanEditText)));
                this.k.f();
            }
            if (bVar.M) {
                swanEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.a.c0.a.c.b
    /* renamed from: v0 */
    public void V(@NonNull SwanEditText swanEditText, @NonNull c.a.o0.a.c0.c.f.b bVar, @NonNull c.a.o0.a.c0.f.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, swanEditText, bVar, bVar2) == null) {
            boolean t = t();
            if (t) {
                swanEditText.removeTextChangedListener(c.a.o0.a.z0.b.d().e());
            }
            super.c0(swanEditText, bVar, bVar2);
            if (t) {
                swanEditText.addTextChangedListener(c.a.o0.a.z0.b.d().e());
            } else {
                C0(swanEditText, bVar, this.f4653i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.a.c0.a.d.a
    /* renamed from: w0 */
    public void T(@NonNull SwanEditText swanEditText, @NonNull c.a.o0.a.c0.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, swanEditText, bVar) == null) {
            boolean z = c.a.o0.a.c0.b.a.f4616h;
            swanEditText.setPadding(0, -6, 0, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.a.c0.a.c.b
    /* renamed from: x0 */
    public void W(@NonNull SwanEditText swanEditText, @NonNull c.a.o0.a.c0.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, swanEditText, bVar) == null) {
            boolean z = c.a.o0.a.c0.b.a.f4616h;
            if (t()) {
                super.W(swanEditText, bVar);
                try {
                    swanEditText.setSelection(bVar.x.length());
                } catch (IndexOutOfBoundsException e2) {
                    if (c.a.o0.a.c0.b.a.f4616h) {
                        e2.printStackTrace();
                    }
                    c.a.o0.a.c0.g.a.a("Component-Input", "value is invalid, out of max length");
                }
            } else if (TextUtils.equals(swanEditText.getText(), bVar.x)) {
            } else {
                c.a.o0.a.c0.g.a.a("Component-Input", "insert input: set text must before render");
                super.W(swanEditText, bVar);
            }
        }
    }

    @Override // c.a.o0.a.c0.b.a
    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            super.y(z);
            if (!z) {
                c.a.o0.a.c0.g.a.a("Component-Input", "attach fail");
            }
            SwanEditText swanEditText = (SwanEditText) q();
            if (swanEditText == null) {
                c.a.o0.a.c0.g.a.a("Component-Input", "onAttached with null editText");
                swanEditText = c.a.o0.a.z0.b.d().c();
            }
            swanEditText.setFocusable(true);
            swanEditText.setFocusableInTouchMode(true);
            swanEditText.requestFocus();
            if (TextUtils.equals(((c.a.o0.a.c0.c.f.b) n()).O, "text")) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.f4653i.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(swanEditText, 0);
                }
            } else if (Build.VERSION.SDK_INT >= 21) {
                swanEditText.setShowSoftInputOnFocus(false);
            } else {
                D0(swanEditText);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.a.c0.a.c.b
    /* renamed from: y0 */
    public void Y(@NonNull SwanEditText swanEditText, @NonNull c.a.o0.a.c0.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, swanEditText, bVar) == null) {
            boolean z = c.a.o0.a.c0.b.a.f4616h;
            String str = bVar.D;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1178781136) {
                if (hashCode == -841373419 && str.equals("boldItalic")) {
                    c2 = 1;
                }
            } else if (str.equals("italic")) {
                c2 = 0;
            }
            if (c2 == 0) {
                swanEditText.setTypeface(Typeface.SANS_SERIF, 2);
            } else if (c2 != 1) {
                super.Y(swanEditText, bVar);
            } else {
                swanEditText.setTypeface(Typeface.SANS_SERIF, 3);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.a.c0.a.c.b
    /* renamed from: z0 */
    public void Z(@NonNull SwanEditText swanEditText, @NonNull c.a.o0.a.c0.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, swanEditText, bVar) == null) {
            a0(swanEditText, bVar, 16);
        }
    }
}

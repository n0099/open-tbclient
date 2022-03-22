package c.a.n0.a.s.c.f;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.n0.a.p0.f.b;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.x;
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
public final class a extends c.a.n0.a.s.a.a.a<SwanEditText, c.a.n0.a.s.c.f.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActivity i;
    public c.a.n0.a.x.g.f j;
    public c.a.n0.a.p0.f.b k;
    public int l;

    /* renamed from: c.a.n0.a.s.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0440a extends c.a.n0.a.j0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f6110b;

        public C0440a(a aVar, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6110b = aVar;
            this.a = swanEditText;
        }

        @Override // c.a.n0.a.j0.a, c.a.n0.a.j0.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f6110b.k == null) {
                return;
            }
            this.f6110b.k.dismiss();
            this.f6110b.p0(this.a);
        }

        @Override // c.a.n0.a.j0.a, c.a.n0.a.j0.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, keyEvent)) == null) {
                if (i != 4 || this.f6110b.k == null) {
                    return false;
                }
                this.f6110b.k.dismiss();
                this.f6110b.p0(this.a);
                return true;
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.s.c.f.b f6111b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.j0.a f6112c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f6113d;

        public b(a aVar, SwanEditText swanEditText, c.a.n0.a.s.c.f.b bVar, c.a.n0.a.j0.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText, bVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6113d = aVar;
            this.a = swanEditText;
            this.f6111b = bVar;
            this.f6112c = aVar2;
        }

        @Override // c.a.n0.a.p0.f.b.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.a.n0.a.s.b.a.f6086h) {
                    Log.d("Component-Input", "numeric keyboard onKeyboardHide");
                }
                this.f6113d.y0(this.a);
                this.f6113d.i.unregisterCallback(this.f6112c);
            }
        }

        @Override // c.a.n0.a.p0.f.b.d
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (c.a.n0.a.s.b.a.f6086h) {
                    Log.d("Component-Input", "numeric keyboard onKeyboardShow");
                }
                a aVar = this.f6113d;
                aVar.z0(aVar.i, this.a, this.f6111b, i);
                this.f6113d.i.registerCallback(this.f6112c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.s.c.f.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f6114b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f6115c;

        public c(a aVar, c.a.n0.a.s.c.f.b bVar, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6115c = aVar;
            this.a = bVar;
            this.f6114b = swanEditText;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                c.a.n0.a.p0.c.d(c.a.n0.a.p0.b.d().c(), this.f6115c.l);
                if (this.a.M) {
                    return true;
                }
                this.f6114b.clearFocus();
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f6116b;

        public d(a aVar, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6116b = aVar;
            this.a = swanEditText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) || i2 == i3) {
                return;
            }
            c.a.n0.a.p0.c.c((c.a.n0.a.s.c.f.b) this.f6116b.n(), this.a, i2 > i3 ? '\b' : charSequence.charAt((i + i3) - 1));
        }
    }

    /* loaded from: classes.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.s.c.f.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f6117b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f6118c;

        public e(a aVar, c.a.n0.a.s.c.f.b bVar, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6118c = aVar;
            this.a = bVar;
            this.f6117b = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (c.a.n0.a.s.b.a.f6086h) {
                    Log.d("Component-Input", "onFocusChange:" + z);
                }
                if (z) {
                    return;
                }
                c.a.n0.a.u.d.i("Component-Input", "send blur callback");
                if (!TextUtils.equals("text", this.a.L) && this.f6118c.k != null) {
                    this.f6118c.k.dismiss();
                }
                c.a.n0.a.p0.c.b(this.f6117b, this.f6118c.l);
                this.f6118c.p0(this.f6117b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.n0.a.j2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f6119b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.s.c.f.b f6120c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ View f6121d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6122e;

        public f(a aVar, SwanEditText swanEditText, SwanAppActivity swanAppActivity, c.a.n0.a.s.c.f.b bVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText, swanAppActivity, bVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6122e = aVar;
            this.a = swanEditText;
            this.f6119b = swanAppActivity;
            this.f6120c = bVar;
            this.f6121d = view;
        }

        @Override // c.a.n0.a.j2.a
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                this.f6122e.y0(this.a);
                c.a.n0.a.j2.c.i().k(this.f6121d);
            }
        }

        @Override // c.a.n0.a.j2.a
        public void b(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) && this.a.hasFocus()) {
                this.f6122e.z0(this.f6119b, this.a, this.f6120c, i);
            }
        }

        @Override // c.a.n0.a.j2.a
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
    public a(@Nullable Context context, @NonNull c.a.n0.a.s.c.f.b bVar, @NonNull SwanAppActivity swanAppActivity, @NonNull c.a.n0.a.x.g.f fVar, @NonNull g gVar) {
        super(context, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar, swanAppActivity, fVar, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (c.a.n0.a.s.a.a.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = swanAppActivity;
        this.j = fVar;
        c.a.n0.a.p0.c.a(gVar);
    }

    public final void A0(SwanEditText swanEditText, c.a.n0.a.s.c.f.b bVar, SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanEditText, bVar, swanAppActivity) == null) {
            swanEditText.setOnEditorActionListener(new c(this, bVar, swanEditText));
            d dVar = new d(this, swanEditText);
            swanEditText.setOnFocusChangeListener(new e(this, bVar, swanEditText));
            if (TextUtils.equals("text", bVar.L)) {
                View decorView = swanAppActivity.getWindow().getDecorView();
                c.a.n0.a.j2.c.i().l(decorView, bVar.f6096b, new f(this, swanEditText, swanAppActivity, bVar, decorView));
            }
            c.a.n0.a.p0.b.d().f(dVar);
            swanEditText.addTextChangedListener(dVar);
        }
    }

    public final void B0(SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanEditText) == null) {
            try {
                Method method = SwanEditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
                method.setAccessible(true);
                method.invoke(swanEditText, Boolean.FALSE);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                if (c.a.n0.a.s.b.a.f6086h) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void p0(@Nullable SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, swanEditText) == null) {
            SwanAppActivity activity = c.a.n0.a.w0.f.U().getActivity();
            if (activity == null) {
                c.a.n0.a.u.d.o("Component-Input", "activity is null when close input");
                return;
            }
            x.a(activity, activity.getWindow().getDecorView().getWindowToken());
            if (swanEditText == null) {
                return;
            }
            swanEditText.setOnFocusChangeListener(null);
            c.a.n0.a.u.d.i("Component-Input", "remove input");
            if (B().a()) {
                c.a.n0.a.u.d.i("Component-Input", "remove input success");
            } else {
                c.a.n0.a.u.d.o("Component-Input", "remove input fail");
            }
            c.a.n0.a.p0.b.d().b();
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            p0(c.a.n0.a.p0.b.d().c());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.s.b.a
    @NonNull
    /* renamed from: r0 */
    public SwanEditText v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) {
            q0();
            return c.a.n0.a.p0.b.d().a(context);
        }
        return (SwanEditText) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.s.b.a
    /* renamed from: s0 */
    public void A(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, swanEditText) == null) {
            super.A(swanEditText);
            c.a.n0.a.s.c.f.b bVar = (c.a.n0.a.s.c.f.b) n();
            swanEditText.setText(bVar.t);
            int i = 1;
            swanEditText.setSingleLine(true);
            swanEditText.setTag(bVar.f6099e);
            if (!TextUtils.equals("text", bVar.L)) {
                String str = bVar.L;
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
                    i = 2;
                } else if (c2 != 1) {
                    i = 0;
                }
                this.k = new c.a.n0.a.p0.f.b(this.i, swanEditText, i, bVar.D);
                this.k.e(new b(this, swanEditText, bVar, new C0440a(this, swanEditText)));
                this.k.f();
            }
            if (bVar.J) {
                swanEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.s.a.a.a
    /* renamed from: t0 */
    public void a0(@NonNull SwanEditText swanEditText, @NonNull c.a.n0.a.s.c.f.b bVar, @NonNull c.a.n0.a.s.f.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, swanEditText, bVar, bVar2) == null) {
            boolean t = t();
            if (t) {
                swanEditText.removeTextChangedListener(c.a.n0.a.p0.b.d().e());
            }
            super.T(swanEditText, bVar, bVar2);
            if (t) {
                swanEditText.addTextChangedListener(c.a.n0.a.p0.b.d().e());
            } else {
                A0(swanEditText, bVar, this.i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.s.a.d.a
    /* renamed from: u0 */
    public void R(@NonNull SwanEditText swanEditText, @NonNull c.a.n0.a.s.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, swanEditText, bVar) == null) {
            if (c.a.n0.a.s.b.a.f6086h) {
                Log.d("Component-Input", "renderPadding");
            }
            swanEditText.setPadding(0, -6, 0, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.s.a.c.b
    /* renamed from: v0 */
    public void U(@NonNull SwanEditText swanEditText, @NonNull c.a.n0.a.s.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, swanEditText, bVar) == null) {
            if (c.a.n0.a.s.b.a.f6086h) {
                Log.d("Component-Input", "renderText");
            }
            if (t()) {
                super.U(swanEditText, bVar);
                try {
                    swanEditText.setSelection(bVar.t.length());
                } catch (IndexOutOfBoundsException e2) {
                    if (c.a.n0.a.s.b.a.f6086h) {
                        e2.printStackTrace();
                    }
                    c.a.n0.a.s.g.a.a("Component-Input", "value is invalid, out of max length");
                }
            } else if (TextUtils.equals(swanEditText.getText(), bVar.t)) {
            } else {
                c.a.n0.a.s.g.a.a("Component-Input", "insert input: set text must before render");
                super.U(swanEditText, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.s.a.c.b
    /* renamed from: w0 */
    public void W(@NonNull SwanEditText swanEditText, @NonNull c.a.n0.a.s.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, swanEditText, bVar) == null) {
            if (c.a.n0.a.s.b.a.f6086h) {
                Log.d("Component-Input", "renderTextStyleFontWeight");
            }
            String str = bVar.A;
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
                super.W(swanEditText, bVar);
            } else {
                swanEditText.setTypeface(Typeface.SANS_SERIF, 3);
            }
        }
    }

    @Override // c.a.n0.a.s.b.a
    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            super.x(z);
            if (!z) {
                c.a.n0.a.s.g.a.a("Component-Input", "attach fail");
            }
            SwanEditText swanEditText = (SwanEditText) q();
            if (swanEditText == null) {
                c.a.n0.a.s.g.a.a("Component-Input", "onAttached with null editText");
                swanEditText = c.a.n0.a.p0.b.d().c();
            }
            swanEditText.setFocusable(true);
            swanEditText.setFocusableInTouchMode(true);
            swanEditText.requestFocus();
            if (TextUtils.equals(((c.a.n0.a.s.c.f.b) n()).L, "text")) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.i.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(swanEditText, 0);
                }
            } else if (Build.VERSION.SDK_INT >= 21) {
                swanEditText.setShowSoftInputOnFocus(false);
            } else {
                B0(swanEditText);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.s.a.c.b
    /* renamed from: x0 */
    public void X(@NonNull SwanEditText swanEditText, @NonNull c.a.n0.a.s.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, swanEditText, bVar) == null) {
            Y(swanEditText, bVar, 16);
        }
    }

    public final void y0(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, swanEditText) == null) {
            if (c.a.n0.a.s.b.a.f6086h) {
                Log.d("Component-Input", "scrollBackWhenKeyboardHide, mKeyboardHeight：" + this.l);
            }
            if (this.l != 0) {
                this.l = 0;
                swanEditText.clearFocus();
                if (this.j.v3().getScrollY() > 0) {
                    this.j.v3().setScrollY(0);
                }
            }
        }
    }

    @Override // c.a.n0.a.s.b.a
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.z();
        }
    }

    public final void z0(@NonNull SwanAppActivity swanAppActivity, @NonNull SwanEditText swanEditText, c.a.n0.a.s.c.f.b bVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048600, this, swanAppActivity, swanEditText, bVar, i) == null) {
            c.a.n0.a.f.e.c i3 = c.a.n0.a.w0.f.U().i();
            if (c.a.n0.a.s.b.a.f6086h) {
                Log.d("Component-Input", "scrollUpWhenKeyboardShow, mKeyboardHeight：" + this.l + "，keyboardHeight : " + i);
            }
            if (this.l == i || i3 == null) {
                return;
            }
            this.l = i;
            c.a.n0.a.p0.c.f(swanEditText, i);
            if (bVar.N) {
                if (bVar.f6102h == null) {
                    bVar.f6102h = new c.a.n0.a.c1.e.a.a();
                }
                int webViewScrollY = i3.getWebViewScrollY();
                int height = swanEditText.getHeight();
                if (height == 0) {
                    height = bVar.f6102h.c();
                }
                int height2 = ((this.j.v3().getHeight() - bVar.f6102h.e()) - height) + webViewScrollY + n0.k(swanAppActivity);
                int i4 = bVar.E;
                if (i4 > height2) {
                    i4 = height2;
                }
                int i5 = height2 - i;
                int scrollY = this.j.v3().getScrollY();
                if (i5 < 0) {
                    i2 = i4 - i5;
                } else {
                    if (i4 > i5) {
                        scrollY = i4 - i5;
                    }
                    i2 = scrollY;
                }
                this.j.v3().setScrollY(i2);
            }
        }
    }
}

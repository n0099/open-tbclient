package c.a.r0.a.c0.c.f;

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
import c.a.r0.a.z0.f.b;
import c.a.r0.a.z2.n0;
import c.a.r0.a.z2.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.tachikoma.core.component.text.SpanItem;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a extends c.a.r0.a.c0.a.a.a<SwanEditText, c.a.r0.a.c0.c.f.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public SwanAppActivity f5443i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.a.h0.g.f f5444j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.r0.a.z0.f.b f5445k;
    public int l;

    /* renamed from: c.a.r0.a.c0.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0269a extends c.a.r0.a.t0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f5446b;

        public C0269a(a aVar, SwanEditText swanEditText) {
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
            this.f5446b = aVar;
            this.a = swanEditText;
        }

        @Override // c.a.r0.a.t0.a, c.a.r0.a.t0.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f5446b.f5445k == null) {
                return;
            }
            this.f5446b.f5445k.dismiss();
            this.f5446b.p0(this.a);
        }

        @Override // c.a.r0.a.t0.a, c.a.r0.a.t0.b
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, keyEvent)) == null) {
                if (i2 != 4 || this.f5446b.f5445k == null) {
                    return false;
                }
                this.f5446b.f5445k.dismiss();
                this.f5446b.p0(this.a);
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
        public final /* synthetic */ c.a.r0.a.c0.c.f.b f5447b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.t0.a f5448c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f5449d;

        public b(a aVar, SwanEditText swanEditText, c.a.r0.a.c0.c.f.b bVar, c.a.r0.a.t0.a aVar2) {
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
            this.f5449d = aVar;
            this.a = swanEditText;
            this.f5447b = bVar;
            this.f5448c = aVar2;
        }

        @Override // c.a.r0.a.z0.f.b.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = c.a.r0.a.c0.b.a.f5409h;
                this.f5449d.y0(this.a);
                this.f5449d.f5443i.unregisterCallback(this.f5448c);
            }
        }

        @Override // c.a.r0.a.z0.f.b.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                boolean unused = c.a.r0.a.c0.b.a.f5409h;
                a aVar = this.f5449d;
                aVar.z0(aVar.f5443i, this.a, this.f5447b, i2);
                this.f5449d.f5443i.registerCallback(this.f5448c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.c0.c.f.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f5450b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f5451c;

        public c(a aVar, c.a.r0.a.c0.c.f.b bVar, SwanEditText swanEditText) {
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
            this.f5451c = aVar;
            this.a = bVar;
            this.f5450b = swanEditText;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                c.a.r0.a.z0.c.d(c.a.r0.a.z0.b.d().c(), this.f5451c.l);
                if (this.a.Q) {
                    return true;
                }
                this.f5450b.clearFocus();
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
        public final /* synthetic */ SwanEditText f5452e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5453f;

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
            this.f5453f = aVar;
            this.f5452e = swanEditText;
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
            c.a.r0.a.z0.c.c((c.a.r0.a.c0.c.f.b) this.f5453f.n(), this.f5452e, i3 > i4 ? '\b' : charSequence.charAt((i2 + i4) - 1));
        }
    }

    /* loaded from: classes.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.c0.c.f.b f5454e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f5455f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f5456g;

        public e(a aVar, c.a.r0.a.c0.c.f.b bVar, SwanEditText swanEditText) {
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
            this.f5456g = aVar;
            this.f5454e = bVar;
            this.f5455f = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (c.a.r0.a.c0.b.a.f5409h) {
                    String str = "onFocusChange:" + z;
                }
                if (z) {
                    return;
                }
                c.a.r0.a.e0.d.i("Component-Input", "send blur callback");
                if (!TextUtils.equals("text", this.f5454e.P) && this.f5456g.f5445k != null) {
                    this.f5456g.f5445k.dismiss();
                }
                c.a.r0.a.z0.c.b(this.f5455f, this.f5456g.l);
                this.f5456g.p0(this.f5455f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.r0.a.t2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f5457b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.c0.c.f.b f5458c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ View f5459d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5460e;

        public f(a aVar, SwanEditText swanEditText, SwanAppActivity swanAppActivity, c.a.r0.a.c0.c.f.b bVar, View view) {
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
            this.f5460e = aVar;
            this.a = swanEditText;
            this.f5457b = swanAppActivity;
            this.f5458c = bVar;
            this.f5459d = view;
        }

        @Override // c.a.r0.a.t2.a
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                this.f5460e.y0(this.a);
                c.a.r0.a.t2.c.i().k(this.f5459d);
            }
        }

        @Override // c.a.r0.a.t2.a
        public void b(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) && this.a.hasFocus()) {
                this.f5460e.z0(this.f5457b, this.a, this.f5458c, i2);
            }
        }

        @Override // c.a.r0.a.t2.a
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
    public a(@Nullable Context context, @NonNull c.a.r0.a.c0.c.f.b bVar, @NonNull SwanAppActivity swanAppActivity, @NonNull c.a.r0.a.h0.g.f fVar, @NonNull g gVar) {
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
                super((Context) objArr2[0], (c.a.r0.a.c0.a.a.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5443i = swanAppActivity;
        this.f5444j = fVar;
        c.a.r0.a.z0.c.a(gVar);
    }

    public final void A0(SwanEditText swanEditText, c.a.r0.a.c0.c.f.b bVar, SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanEditText, bVar, swanAppActivity) == null) {
            swanEditText.setOnEditorActionListener(new c(this, bVar, swanEditText));
            d dVar = new d(this, swanEditText);
            swanEditText.setOnFocusChangeListener(new e(this, bVar, swanEditText));
            if (TextUtils.equals("text", bVar.P)) {
                View decorView = swanAppActivity.getWindow().getDecorView();
                c.a.r0.a.t2.c.i().l(decorView, bVar.f5421f, new f(this, swanEditText, swanAppActivity, bVar, decorView));
            }
            c.a.r0.a.z0.b.d().f(dVar);
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
                if (c.a.r0.a.c0.b.a.f5409h) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void p0(@Nullable SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, swanEditText) == null) {
            SwanAppActivity activity = c.a.r0.a.g1.f.U().getActivity();
            if (activity == null) {
                c.a.r0.a.e0.d.o("Component-Input", "activity is null when close input");
                return;
            }
            x.a(activity, activity.getWindow().getDecorView().getWindowToken());
            if (swanEditText == null) {
                return;
            }
            swanEditText.setOnFocusChangeListener(null);
            c.a.r0.a.e0.d.i("Component-Input", "remove input");
            if (B().a()) {
                c.a.r0.a.e0.d.i("Component-Input", "remove input success");
            } else {
                c.a.r0.a.e0.d.o("Component-Input", "remove input fail");
            }
            c.a.r0.a.z0.b.d().b();
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            p0(c.a.r0.a.z0.b.d().c());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.c0.b.a
    @NonNull
    /* renamed from: r0 */
    public SwanEditText v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) {
            q0();
            return c.a.r0.a.z0.b.d().a(context);
        }
        return (SwanEditText) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.c0.b.a
    /* renamed from: s0 */
    public void A(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, swanEditText) == null) {
            super.A(swanEditText);
            c.a.r0.a.c0.c.f.b bVar = (c.a.r0.a.c0.c.f.b) n();
            swanEditText.setText(bVar.x);
            int i2 = 1;
            swanEditText.setSingleLine(true);
            swanEditText.setTag(bVar.f5424i);
            if (!TextUtils.equals("text", bVar.P)) {
                String str = bVar.P;
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1193508181) {
                    if (hashCode == 95582509 && str.equals(CardAddResponse.CHECK_PWD_TYPE_DIGIT)) {
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
                this.f5445k = new c.a.r0.a.z0.f.b(this.f5443i, swanEditText, i2, bVar.H);
                this.f5445k.e(new b(this, swanEditText, bVar, new C0269a(this, swanEditText)));
                this.f5445k.f();
            }
            if (bVar.N) {
                swanEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.c0.a.a.a
    /* renamed from: t0 */
    public void a0(@NonNull SwanEditText swanEditText, @NonNull c.a.r0.a.c0.c.f.b bVar, @NonNull c.a.r0.a.c0.f.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, swanEditText, bVar, bVar2) == null) {
            boolean t = t();
            if (t) {
                swanEditText.removeTextChangedListener(c.a.r0.a.z0.b.d().e());
            }
            super.T(swanEditText, bVar, bVar2);
            if (t) {
                swanEditText.addTextChangedListener(c.a.r0.a.z0.b.d().e());
            } else {
                A0(swanEditText, bVar, this.f5443i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.c0.a.d.a
    /* renamed from: u0 */
    public void R(@NonNull SwanEditText swanEditText, @NonNull c.a.r0.a.c0.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, swanEditText, bVar) == null) {
            boolean z = c.a.r0.a.c0.b.a.f5409h;
            swanEditText.setPadding(0, -6, 0, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.c0.a.c.b
    /* renamed from: v0 */
    public void U(@NonNull SwanEditText swanEditText, @NonNull c.a.r0.a.c0.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, swanEditText, bVar) == null) {
            boolean z = c.a.r0.a.c0.b.a.f5409h;
            if (t()) {
                super.U(swanEditText, bVar);
                try {
                    swanEditText.setSelection(bVar.x.length());
                } catch (IndexOutOfBoundsException e2) {
                    if (c.a.r0.a.c0.b.a.f5409h) {
                        e2.printStackTrace();
                    }
                    c.a.r0.a.c0.g.a.a("Component-Input", "value is invalid, out of max length");
                }
            } else if (TextUtils.equals(swanEditText.getText(), bVar.x)) {
            } else {
                c.a.r0.a.c0.g.a.a("Component-Input", "insert input: set text must before render");
                super.U(swanEditText, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.c0.a.c.b
    /* renamed from: w0 */
    public void W(@NonNull SwanEditText swanEditText, @NonNull c.a.r0.a.c0.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, swanEditText, bVar) == null) {
            boolean z = c.a.r0.a.c0.b.a.f5409h;
            String str = bVar.E;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1178781136) {
                if (hashCode == -841373419 && str.equals("boldItalic")) {
                    c2 = 1;
                }
            } else if (str.equals(SpanItem.STYLE_ITALIC)) {
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

    @Override // c.a.r0.a.c0.b.a
    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            super.x(z);
            if (!z) {
                c.a.r0.a.c0.g.a.a("Component-Input", "attach fail");
            }
            SwanEditText swanEditText = (SwanEditText) q();
            if (swanEditText == null) {
                c.a.r0.a.c0.g.a.a("Component-Input", "onAttached with null editText");
                swanEditText = c.a.r0.a.z0.b.d().c();
            }
            swanEditText.setFocusable(true);
            swanEditText.setFocusableInTouchMode(true);
            swanEditText.requestFocus();
            if (TextUtils.equals(((c.a.r0.a.c0.c.f.b) n()).P, "text")) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.f5443i.getSystemService("input_method");
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
    @Override // c.a.r0.a.c0.a.c.b
    /* renamed from: x0 */
    public void X(@NonNull SwanEditText swanEditText, @NonNull c.a.r0.a.c0.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, swanEditText, bVar) == null) {
            Y(swanEditText, bVar, 16);
        }
    }

    public final void y0(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, swanEditText) == null) {
            if (c.a.r0.a.c0.b.a.f5409h) {
                String str = "scrollBackWhenKeyboardHide, mKeyboardHeight：" + this.l;
            }
            if (this.l != 0) {
                this.l = 0;
                swanEditText.clearFocus();
                if (this.f5444j.r3().getScrollY() > 0) {
                    this.f5444j.r3().setScrollY(0);
                }
            }
        }
    }

    @Override // c.a.r0.a.c0.b.a
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.z();
        }
    }

    public final void z0(@NonNull SwanAppActivity swanAppActivity, @NonNull SwanEditText swanEditText, c.a.r0.a.c0.c.f.b bVar, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048600, this, swanAppActivity, swanEditText, bVar, i2) == null) {
            c.a.r0.a.p.e.c i4 = c.a.r0.a.g1.f.U().i();
            if (c.a.r0.a.c0.b.a.f5409h) {
                String str = "scrollUpWhenKeyboardShow, mKeyboardHeight：" + this.l + "，keyboardHeight : " + i2;
            }
            if (this.l == i2 || i4 == null) {
                return;
            }
            this.l = i2;
            c.a.r0.a.z0.c.f(swanEditText, i2);
            if (bVar.R) {
                if (bVar.l == null) {
                    bVar.l = new c.a.r0.a.m1.e.a.a();
                }
                int webViewScrollY = i4.getWebViewScrollY();
                int height = swanEditText.getHeight();
                if (height == 0) {
                    height = bVar.l.c();
                }
                int height2 = ((this.f5444j.r3().getHeight() - bVar.l.f()) - height) + webViewScrollY + n0.k(swanAppActivity);
                int i5 = bVar.I;
                if (i5 > height2) {
                    i5 = height2;
                }
                int i6 = height2 - i2;
                int scrollY = this.f5444j.r3().getScrollY();
                if (i6 < 0) {
                    i3 = i5 - i6;
                } else {
                    if (i5 > i6) {
                        scrollY = i5 - i6;
                    }
                    i3 = scrollY;
                }
                this.f5444j.r3().setScrollY(i3);
            }
        }
    }
}

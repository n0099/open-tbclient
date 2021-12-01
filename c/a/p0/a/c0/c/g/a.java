package c.a.p0.a.c0.c.g;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.z2.g0;
import c.a.p0.a.z2.n0;
import c.a.p0.a.z2.q0;
import c.a.p0.a.z2.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.text.SpanItem;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a extends c.a.p0.a.c0.a.a.a<SwanEditText, c.a.p0.a.c0.c.g.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public SwanAppActivity f4417i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.a.h0.g.f f4418j;

    /* renamed from: k  reason: collision with root package name */
    public int f4419k;
    public i l;
    public String m;
    public int n;
    public ShowConfirmBarLayout o;
    public boolean p;
    public int q;

    /* renamed from: c.a.p0.a.c0.c.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0186a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.c0.c.g.b f4420e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f4421f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f4422g;

        public RunnableC0186a(a aVar, c.a.p0.a.c0.c.g.b bVar, SwanEditText swanEditText) {
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
            this.f4422g = aVar;
            this.f4420e = bVar;
            this.f4421f = swanEditText;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f4422g.f4417i != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) this.f4422g.f4417i.getSystemService("input_method");
                    if (inputMethodManager == null || !this.f4420e.T) {
                        return;
                    }
                    this.f4421f.setFocusable(true);
                    this.f4421f.setFocusableInTouchMode(true);
                    this.f4421f.requestFocus();
                    inputMethodManager.showSoftInput(this.f4421f, 0);
                    return;
                }
                c.a.p0.a.c0.g.a.a("Component-TextArea", "activity is null, set textarea attr failed");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements SwanEditText.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f4423b;

        public b(a aVar, SwanEditText swanEditText) {
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
            this.f4423b = aVar;
            this.a = swanEditText;
        }

        @Override // com.baidu.swan.apps.component.components.textarea.SwanEditText.a
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f4423b.F0(this.a, "selection");
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f4424e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f4425f;

        public c(a aVar, SwanEditText swanEditText) {
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
            this.f4425f = aVar;
            this.f4424e = swanEditText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.f4424e.hasFocus()) {
                c.a.p0.a.e0.d.i("Component-TextArea", "send input callback");
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f4424e.getLineCount() <= 0) {
                return;
            }
            if (this.f4425f.q != this.f4424e.getLineCount()) {
                c.a.p0.a.e0.d.i("Component-TextArea", "send line change callback");
                this.f4425f.F0(this.f4424e, "linechange");
            }
            int i5 = i4 - i3;
            if (i3 != i5) {
                this.f4425f.G0(this.f4424e, "input", i3 > i5 ? '\b' : charSequence.charAt((i2 + i5) - 1));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f4426e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f4427f;

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
            this.f4427f = aVar;
            this.f4426e = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (c.a.p0.a.c0.b.a.f4365h) {
                    String str = "onFocusChange:" + z;
                }
                if (z) {
                    if (this.f4427f.f4419k != 0) {
                        this.f4427f.F0(this.f4426e, AddFriendActivityConfig.TYPE_FOCUS);
                    }
                    this.f4427f.J0();
                    return;
                }
                this.f4427f.F0(this.f4426e, "blur");
                this.f4427f.I0();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.p0.a.t2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f4428b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f4429c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f4430d;

        /* renamed from: c.a.p0.a.c0.c.g.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0187a implements ShowConfirmBarLayout.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.p0.a.c0.c.g.b a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f4431b;

            public C0187a(e eVar, c.a.p0.a.c0.c.g.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4431b = eVar;
                this.a = bVar;
            }

            @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.b
            public void onClick(View view) {
                InputMethodManager inputMethodManager;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!this.a.b0 && (inputMethodManager = (InputMethodManager) this.f4431b.f4428b.getSystemService("input_method")) != null) {
                        inputMethodManager.hideSoftInputFromWindow(this.f4431b.a.getWindowToken(), 0);
                    }
                    c.a.p0.a.e0.d.i("Component-TextArea", "send confirm change callback");
                    e eVar = this.f4431b;
                    eVar.f4430d.F0(eVar.a, "confirm");
                }
            }
        }

        public e(a aVar, SwanEditText swanEditText, SwanAppActivity swanAppActivity, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText, swanAppActivity, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4430d = aVar;
            this.a = swanEditText;
            this.f4428b = swanAppActivity;
            this.f4429c = view;
        }

        @Override // c.a.p0.a.t2.a
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (this.f4430d.f4419k != 0) {
                    this.f4430d.f4419k = 0;
                    if (this.f4430d.f4418j.y3().getScrollY() > 0) {
                        this.f4430d.f4418j.y3().setScrollY(0);
                        this.f4430d.p = false;
                    }
                    if (this.f4430d.o != null && this.f4430d.o.getVisibility() == 0) {
                        ((FrameLayout) this.f4429c.findViewById(16908290)).removeView(this.f4430d.o);
                        this.f4430d.o = null;
                    }
                }
                if (this.a.hasFocus()) {
                    this.a.clearFocus();
                    boolean unused = c.a.p0.a.c0.b.a.f4365h;
                }
            }
        }

        @Override // c.a.p0.a.t2.a
        public void b(String str, int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
                c.a.p0.a.c0.c.g.b bVar = (c.a.p0.a.c0.c.g.b) this.f4430d.n();
                c.a.p0.a.p.e.c h2 = c.a.p0.a.g1.f.U().h();
                if (this.f4430d.f4419k == i2 || !this.a.hasFocus() || h2 == null) {
                    return;
                }
                this.f4430d.f4419k = i2;
                this.f4430d.n = this.a.getHeight();
                this.f4430d.F0(this.a, AddFriendActivityConfig.TYPE_FOCUS);
                boolean z = bVar.X;
                if (bVar.W) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    i3 = n0.g(38.0f);
                    if (this.f4430d.o == null) {
                        this.f4430d.o = new ShowConfirmBarLayout(this.f4428b);
                        this.f4430d.o.setOnConfirmButtonClickListener(new C0187a(this, bVar));
                        layoutParams.topMargin = ((this.f4429c.getHeight() - i2) - i3) - g0.c();
                        ((FrameLayout) this.f4429c.findViewById(16908290)).addView(this.f4430d.o, layoutParams);
                    }
                } else {
                    i3 = 0;
                }
                if (z) {
                    int webViewScrollY = !bVar.V ? h2.getWebViewScrollY() : 0;
                    c.a.p0.a.m1.e.a.a aVar = bVar.l;
                    int height = ((this.f4430d.f4418j.y3().getHeight() - (aVar != null ? aVar.f() : 0)) - this.a.getHeight()) + webViewScrollY;
                    int i4 = bVar.I;
                    if (height - i4 < i2) {
                        this.f4430d.p = true;
                        if (i4 > height) {
                            this.f4430d.f4418j.y3().setScrollY(i2 + i3);
                            return;
                        } else {
                            this.f4430d.f4418j.y3().setScrollY((i2 - height) + i4 + i3);
                            return;
                        }
                    }
                    this.f4430d.p = false;
                }
            }
        }

        @Override // c.a.p0.a.t2.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f4430d.q == this.a.getLineCount()) {
                return;
            }
            c.a.p0.a.e0.d.i("Component-TextArea", "send line change callback");
            this.f4430d.F0(this.a, "linechange");
            this.f4430d.E0(this.a, str);
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f4432e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4433f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f4434g;

        public f(a aVar, SwanEditText swanEditText, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4434g = aVar;
            this.f4432e = swanEditText;
            this.f4433f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f4432e == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            String obj = this.f4432e.getTag().toString();
            if (!TextUtils.equals(obj, ((c.a.p0.a.c0.c.g.b) this.f4434g.n()).f4377f)) {
                c.a.p0.a.c0.g.a.a("Component-TextArea", "changeTextAreaStatus with different id");
            }
            int D0 = this.f4434g.D0(this.f4432e);
            try {
                jSONObject.put("eventName", this.f4433f);
                jSONObject.put("value", this.f4432e.getText().toString());
                jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, this.f4432e.getSelectionStart());
                jSONObject.put("selectionStart", this.f4432e.getSelectionStart());
                jSONObject.put("selectionEnd", this.f4432e.getSelectionEnd());
                jSONObject.put("lineCount", this.f4432e.getLineCount());
                jSONObject.put("height", "" + n0.P(D0));
                jSONObject.put("keyboardHeight", "" + n0.P((float) this.f4434g.f4419k));
            } catch (JSONException e2) {
                if (c.a.p0.a.c0.b.a.f4365h) {
                    e2.printStackTrace();
                }
            }
            if (c.a.p0.a.c0.b.a.f4365h) {
                String str = "changeTextAreaStatus:" + jSONObject.toString();
            }
            this.f4434g.l.a(obj, this.f4434g.m, jSONObject);
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f4435e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4436f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4437g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f4438h;

        public g(a aVar, SwanEditText swanEditText, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4438h = aVar;
            this.f4435e = swanEditText;
            this.f4436f = str;
            this.f4437g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f4435e == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            String obj = this.f4435e.getTag().toString();
            if (!TextUtils.equals(obj, ((c.a.p0.a.c0.c.g.b) this.f4438h.n()).f4377f)) {
                c.a.p0.a.c0.g.a.a("Component-TextArea", "changeTextAreaStatus with different id");
            }
            int D0 = this.f4438h.D0(this.f4435e);
            try {
                jSONObject.put("eventName", this.f4436f);
                jSONObject.put("value", this.f4435e.getText().toString());
                jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, this.f4435e.getSelectionStart());
                jSONObject.put("selectionStart", this.f4435e.getSelectionStart());
                jSONObject.put("selectionEnd", this.f4435e.getSelectionEnd());
                jSONObject.put("lineCount", this.f4435e.getLineCount());
                jSONObject.put("height", "" + n0.P(D0));
                jSONObject.put("keyboardHeight", "" + n0.P((float) this.f4438h.f4419k));
                jSONObject.put("keyCode", this.f4437g);
            } catch (JSONException e2) {
                if (c.a.p0.a.c0.b.a.f4365h) {
                    e2.printStackTrace();
                }
            }
            if (c.a.p0.a.c0.b.a.f4365h) {
                String str = "changeTextAreaStatus:" + jSONObject.toString();
            }
            this.f4438h.l.a(obj, this.f4438h.m, jSONObject);
        }
    }

    /* loaded from: classes.dex */
    public class h implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.c0.c.g.b f4439b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f4440c;

        public h(a aVar, SwanEditText swanEditText, c.a.p0.a.c0.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4440c = aVar;
            this.a = swanEditText;
            this.f4439b = bVar;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 >= 2 && i2 <= 7) {
                    this.f4440c.F0(this.a, "confirm");
                }
                return this.f4439b.b0;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void a(String str, String str2, JSONObject jSONObject);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@Nullable Context context, @NonNull c.a.p0.a.c0.c.g.b bVar, @NonNull SwanAppActivity swanAppActivity, @NonNull c.a.p0.a.h0.g.f fVar, @NonNull i iVar) {
        super(context, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar, swanAppActivity, fVar, iVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (c.a.p0.a.c0.a.a.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = false;
        this.q = 1;
        this.f4417i = swanAppActivity;
        this.f4418j = fVar;
        this.l = iVar;
    }

    public final int D0(SwanEditText swanEditText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanEditText)) == null) {
            c.a.p0.a.c0.c.g.b bVar = (c.a.p0.a.c0.c.g.b) n();
            int lineCount = swanEditText.getLineCount();
            int lineHeight = swanEditText.getLineHeight();
            int i2 = bVar.Y;
            int i3 = bVar.Z;
            int height = swanEditText.getHeight();
            if (bVar.U) {
                int paddingTop = (lineHeight * lineCount) + swanEditText.getPaddingTop() + swanEditText.getPaddingBottom();
                if (i3 < i2) {
                    i3 = i2;
                }
                return paddingTop <= i2 ? i2 : paddingTop >= i3 ? i3 : paddingTop;
            }
            return height;
        }
        return invokeL.intValue;
    }

    public final void E0(SwanEditText swanEditText, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, swanEditText, str) == null) {
            c.a.p0.a.c0.c.g.b bVar = (c.a.p0.a.c0.c.g.b) n();
            if (!TextUtils.equals(str, bVar.f4377f)) {
                c.a.p0.a.c0.g.a.a("Component-TextArea", "keyBoardShow with different id");
            }
            boolean z = bVar.X;
            if (!swanEditText.hasFocus() || bVar.V) {
                return;
            }
            if (this.f4419k > 0 && z && this.p) {
                int scrollY = this.f4418j.y3().getScrollY() + (swanEditText.getHeight() - this.n);
                if (scrollY > 0) {
                    this.f4418j.y3().setScrollY(scrollY);
                } else {
                    this.f4418j.y3().setScrollY(0);
                }
            }
            this.n = swanEditText.getHeight();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void F0(SwanEditText swanEditText, String str) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, swanEditText, str) == null) {
            switch (str.hashCode()) {
                case -1715965556:
                    if (str.equals("selection")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3027047:
                    if (str.equals("blur")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 97604824:
                    if (str.equals(AddFriendActivityConfig.TYPE_FOCUS)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 100358090:
                    if (str.equals("input")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 259718308:
                    if (str.equals("linechange")) {
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
                this.q = swanEditText.getLineCount();
                ((c.a.p0.a.c0.c.g.b) n()).n(swanEditText.getHeight());
            } else if (c2 == 1) {
                ((c.a.p0.a.c0.c.g.b) n()).k(swanEditText.getText().toString());
            } else if (c2 == 2) {
                ((c.a.p0.a.c0.c.g.b) n()).r(true);
            } else if (c2 == 3) {
                ((c.a.p0.a.c0.c.g.b) n()).r(false);
            } else if (c2 == 4) {
                ((c.a.p0.a.c0.c.g.b) n()).m(swanEditText.getSelectionStart(), swanEditText.getSelectionEnd());
            }
            q0.a0(new f(this, swanEditText, str));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void G0(SwanEditText swanEditText, String str, int i2) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, swanEditText, str, i2) == null) {
            switch (str.hashCode()) {
                case -1715965556:
                    if (str.equals("selection")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3027047:
                    if (str.equals("blur")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 97604824:
                    if (str.equals(AddFriendActivityConfig.TYPE_FOCUS)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 100358090:
                    if (str.equals("input")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 259718308:
                    if (str.equals("linechange")) {
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
                this.q = swanEditText.getLineCount();
                ((c.a.p0.a.c0.c.g.b) n()).n(swanEditText.getHeight());
            } else if (c2 == 1) {
                ((c.a.p0.a.c0.c.g.b) n()).k(swanEditText.getText().toString());
            } else if (c2 == 2) {
                ((c.a.p0.a.c0.c.g.b) n()).r(true);
            } else if (c2 == 3) {
                ((c.a.p0.a.c0.c.g.b) n()).r(false);
            } else if (c2 == 4) {
                ((c.a.p0.a.c0.c.g.b) n()).m(swanEditText.getSelectionStart(), swanEditText.getSelectionEnd());
            }
            q0.a0(new g(this, swanEditText, str, i2));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.c0.a.a.a, c.a.p0.a.c0.a.c.b, c.a.p0.a.c0.a.d.a, c.a.p0.a.c0.b.a
    @NonNull
    /* renamed from: H0 */
    public c.a.p0.a.c0.f.b k(@NonNull c.a.p0.a.c0.c.g.b bVar, @NonNull c.a.p0.a.c0.c.g.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bVar, bVar2)) == null) {
            c.a.p0.a.c0.f.b k2 = super.k(bVar, bVar2);
            if (!TextUtils.equals(bVar.P, bVar2.P)) {
                k2.b(14);
            }
            if (bVar.Q != bVar2.Q) {
                k2.b(14);
            }
            if (!TextUtils.equals(bVar.R, bVar2.R)) {
                k2.b(14);
            }
            if (!TextUtils.equals(bVar.S, bVar2.S)) {
                k2.b(14);
            }
            if (bVar.a0 != bVar2.a0) {
                k2.b(15);
            }
            return k2;
        }
        return (c.a.p0.a.c0.f.b) invokeLL.objValue;
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SwanAppActivity activity = c.a.p0.a.g1.f.U().getActivity();
            if (activity == null) {
                c.a.p0.a.e0.d.o("Component-TextArea", "activity is null when close input");
                return;
            }
            boolean z = c.a.p0.a.c0.b.a.f4365h;
            x.a(activity, activity.getWindow().getDecorView().getWindowToken());
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SwanAppActivity activity = c.a.p0.a.g1.f.U().getActivity();
            if (activity == null) {
                c.a.p0.a.e0.d.o("Component-TextArea", "activity is null when open input");
                return;
            }
            boolean z = c.a.p0.a.c0.b.a.f4365h;
            x.b(activity, true);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.c0.b.a
    @NonNull
    /* renamed from: K0 */
    public SwanEditText v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) ? new SwanEditText(context) : (SwanEditText) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.c0.b.a
    /* renamed from: L0 */
    public void A(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, swanEditText) == null) {
            super.A(swanEditText);
            c.a.p0.a.c0.c.g.b bVar = (c.a.p0.a.c0.c.g.b) n();
            swanEditText.setTag(bVar.f4377f);
            swanEditText.setInputType(262144);
            swanEditText.setSingleLine(false);
            swanEditText.setHorizontallyScrolling(false);
            this.m = bVar.f4380i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.c0.a.a.a
    /* renamed from: M0 */
    public void a0(@NonNull SwanEditText swanEditText, @NonNull c.a.p0.a.c0.c.g.b bVar, @NonNull c.a.p0.a.c0.f.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, swanEditText, bVar, bVar2) == null) {
            super.T(swanEditText, bVar, bVar2);
            if (bVar2.a(14)) {
                Q0(swanEditText, bVar);
            }
            boolean z = !t();
            if (z) {
                swanEditText.setMinHeight(bVar.Y);
                swanEditText.setMaxHeight(bVar.Z);
            }
            q0.a0(new RunnableC0186a(this, bVar, swanEditText));
            if (bVar2.a(15)) {
                P0(swanEditText, bVar);
            }
            if (z) {
                V0(swanEditText, this.f4417i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.c0.a.a.a
    /* renamed from: N0 */
    public boolean c0(@NonNull SwanEditText swanEditText, @NonNull c.a.p0.a.c0.c.g.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, swanEditText, bVar)) == null) {
            if (TextUtils.isEmpty(bVar.M) || "default".equals(bVar.M)) {
                return false;
            }
            boolean c0 = super.c0(swanEditText, bVar);
            if (c0) {
                swanEditText.setOnEditorActionListener(new h(this, swanEditText, bVar));
            }
            return c0;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.c0.a.a.a
    /* renamed from: O0 */
    public void d0(@NonNull SwanEditText swanEditText, @NonNull c.a.p0.a.c0.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, swanEditText, bVar) == null) {
            Editable text = swanEditText.getText();
            int length = text != null ? text.length() : 0;
            if (bVar.T) {
                int i2 = bVar.J;
                if (i2 <= length && i2 >= 0) {
                    swanEditText.setSelection(i2);
                } else {
                    swanEditText.setSelection(length);
                }
            }
        }
    }

    public final void P0(@NonNull SwanEditText swanEditText, @NonNull c.a.p0.a.c0.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, swanEditText, bVar) == null) {
            boolean z = c.a.p0.a.c0.b.a.f4365h;
            swanEditText.setEnabled(!bVar.a0);
        }
    }

    public final void Q0(@NonNull SwanEditText swanEditText, @NonNull c.a.p0.a.c0.c.g.b bVar) {
        StyleSpan styleSpan;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, swanEditText, bVar) == null) {
            boolean z = c.a.p0.a.c0.b.a.f4365h;
            SpannableString spannableString = new SpannableString(bVar.P);
            String str = bVar.R;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1039745817) {
                if (hashCode == 3029637 && str.equals(SpanItem.STYLE_BOLD)) {
                    c2 = 1;
                }
            } else if (str.equals("normal")) {
                c2 = 0;
            }
            if (c2 == 0) {
                styleSpan = new StyleSpan(0);
            } else if (c2 != 1) {
                styleSpan = new StyleSpan(0);
            } else {
                styleSpan = new StyleSpan(1);
            }
            spannableString.setSpan(styleSpan, 0, bVar.P.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(SwanAppConfigData.t(bVar.S)), 0, bVar.P.length(), 33);
            spannableString.setSpan(new AbsoluteSizeSpan(bVar.Q, true), 0, bVar.P.length(), 33);
            swanEditText.setHint(spannableString);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.c0.a.a.a
    /* renamed from: R0 */
    public void f0(@NonNull SwanEditText swanEditText, @NonNull c.a.p0.a.c0.c.g.b bVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, swanEditText, bVar) == null) {
            Editable text = swanEditText.getText();
            int length = text != null ? text.length() : 0;
            int i3 = bVar.L;
            if (i3 > length || i3 <= 0 || (i2 = bVar.K) > i3 || i2 <= 0 || !bVar.T || swanEditText.hasFocus()) {
                return;
            }
            swanEditText.setSelection(bVar.K, bVar.L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.c0.a.c.b
    /* renamed from: S0 */
    public void U(@NonNull SwanEditText swanEditText, @NonNull c.a.p0.a.c0.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, swanEditText, bVar) == null) {
            boolean z = c.a.p0.a.c0.b.a.f4365h;
            if (TextUtils.equals(swanEditText.getText(), bVar.x)) {
                return;
            }
            swanEditText.setLineSpacing(bVar.C, 1.0f);
            swanEditText.setText(bVar.x);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.c0.a.c.b
    /* renamed from: T0 */
    public void X(@NonNull SwanEditText swanEditText, @NonNull c.a.p0.a.c0.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, swanEditText, bVar) == null) {
            super.Y(swanEditText, bVar, 48);
        }
    }

    public void U0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            if (!TextUtils.equals(((c.a.p0.a.c0.c.g.b) n()).f4377f, str)) {
                c.a.p0.a.c0.g.a.a("Component-TextArea", "sendLineChangeEvent with different id");
            }
            SwanEditText swanEditText = (SwanEditText) q();
            if (swanEditText == null) {
                c.a.p0.a.c0.g.a.a("Component-TextArea", "sendLineChangeEvent with a null editText");
            } else {
                F0(swanEditText, "linechange");
            }
        }
    }

    public final void V0(SwanEditText swanEditText, @NonNull SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, swanEditText, swanAppActivity) == null) {
            swanEditText.setSelectListener(new b(this, swanEditText));
            swanEditText.addTextChangedListener(new c(this, swanEditText));
            swanEditText.setOnFocusChangeListener(new d(this, swanEditText));
            c.a.p0.a.t2.b.g(((c.a.p0.a.c0.c.g.b) n()).f4377f, swanAppActivity, new e(this, swanEditText, swanAppActivity, swanAppActivity.getWindow().getDecorView()));
        }
    }
}

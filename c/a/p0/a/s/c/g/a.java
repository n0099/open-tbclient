package c.a.p0.a.s.c.g;

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
import c.a.p0.a.p2.g0;
import c.a.p0.a.p2.n0;
import c.a.p0.a.p2.q0;
import c.a.p0.a.p2.x;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a extends c.a.p0.a.s.a.a.a<SwanEditText, c.a.p0.a.s.c.g.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public SwanAppActivity f7320i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.a.x.g.f f7321j;
    public int k;
    public i l;
    public String m;
    public int n;
    public ShowConfirmBarLayout o;
    public boolean p;
    public int q;

    /* renamed from: c.a.p0.a.s.c.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0453a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.s.c.g.b f7322e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f7323f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f7324g;

        public RunnableC0453a(a aVar, c.a.p0.a.s.c.g.b bVar, SwanEditText swanEditText) {
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
            this.f7324g = aVar;
            this.f7322e = bVar;
            this.f7323f = swanEditText;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f7324g.f7320i != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) this.f7324g.f7320i.getSystemService("input_method");
                    if (inputMethodManager == null || !this.f7322e.T) {
                        return;
                    }
                    this.f7323f.setFocusable(true);
                    this.f7323f.setFocusableInTouchMode(true);
                    this.f7323f.requestFocus();
                    inputMethodManager.showSoftInput(this.f7323f, 0);
                    return;
                }
                c.a.p0.a.s.g.a.a("Component-TextArea", "activity is null, set textarea attr failed");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements SwanEditText.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f7325b;

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
            this.f7325b = aVar;
            this.a = swanEditText;
        }

        @Override // com.baidu.swan.apps.component.components.textarea.SwanEditText.a
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f7325b.F0(this.a, "selection");
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f7326e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7327f;

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
            this.f7327f = aVar;
            this.f7326e = swanEditText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.f7326e.hasFocus()) {
                c.a.p0.a.u.d.i("Component-TextArea", "send input callback");
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f7326e.getLineCount() <= 0) {
                return;
            }
            if (this.f7327f.q != this.f7326e.getLineCount()) {
                c.a.p0.a.u.d.i("Component-TextArea", "send line change callback");
                this.f7327f.F0(this.f7326e, "linechange");
            }
            int i5 = i4 - i3;
            if (i3 != i5) {
                this.f7327f.G0(this.f7326e, "input", i3 > i5 ? '\b' : charSequence.charAt((i2 + i5) - 1));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f7328e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7329f;

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
            this.f7329f = aVar;
            this.f7328e = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (c.a.p0.a.s.b.a.f7271h) {
                    String str = "onFocusChange:" + z;
                }
                if (z) {
                    if (this.f7329f.k != 0) {
                        this.f7329f.F0(this.f7328e, AddFriendActivityConfig.TYPE_FOCUS);
                    }
                    this.f7329f.J0();
                    return;
                }
                this.f7329f.F0(this.f7328e, "blur");
                this.f7329f.I0();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.p0.a.j2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f7330b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f7331c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f7332d;

        /* renamed from: c.a.p0.a.s.c.g.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0454a implements ShowConfirmBarLayout.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.p0.a.s.c.g.b a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f7333b;

            public C0454a(e eVar, c.a.p0.a.s.c.g.b bVar) {
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
                this.f7333b = eVar;
                this.a = bVar;
            }

            @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.b
            public void onClick(View view) {
                InputMethodManager inputMethodManager;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!this.a.b0 && (inputMethodManager = (InputMethodManager) this.f7333b.f7330b.getSystemService("input_method")) != null) {
                        inputMethodManager.hideSoftInputFromWindow(this.f7333b.a.getWindowToken(), 0);
                    }
                    c.a.p0.a.u.d.i("Component-TextArea", "send confirm change callback");
                    e eVar = this.f7333b;
                    eVar.f7332d.F0(eVar.a, "confirm");
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
            this.f7332d = aVar;
            this.a = swanEditText;
            this.f7330b = swanAppActivity;
            this.f7331c = view;
        }

        @Override // c.a.p0.a.j2.a
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (this.f7332d.k != 0) {
                    this.f7332d.k = 0;
                    if (this.f7332d.f7321j.r3().getScrollY() > 0) {
                        this.f7332d.f7321j.r3().setScrollY(0);
                        this.f7332d.p = false;
                    }
                    if (this.f7332d.o != null && this.f7332d.o.getVisibility() == 0) {
                        ((FrameLayout) this.f7331c.findViewById(16908290)).removeView(this.f7332d.o);
                        this.f7332d.o = null;
                    }
                }
                if (this.a.hasFocus()) {
                    this.a.clearFocus();
                    boolean unused = c.a.p0.a.s.b.a.f7271h;
                }
            }
        }

        @Override // c.a.p0.a.j2.a
        public void b(String str, int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
                c.a.p0.a.s.c.g.b bVar = (c.a.p0.a.s.c.g.b) this.f7332d.n();
                c.a.p0.a.f.e.c i4 = c.a.p0.a.w0.f.U().i();
                if (this.f7332d.k == i2 || !this.a.hasFocus() || i4 == null) {
                    return;
                }
                this.f7332d.k = i2;
                this.f7332d.n = this.a.getHeight();
                this.f7332d.F0(this.a, AddFriendActivityConfig.TYPE_FOCUS);
                boolean z = bVar.X;
                if (bVar.W) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    i3 = n0.g(38.0f);
                    if (this.f7332d.o == null) {
                        this.f7332d.o = new ShowConfirmBarLayout(this.f7330b);
                        this.f7332d.o.setOnConfirmButtonClickListener(new C0454a(this, bVar));
                        layoutParams.topMargin = ((this.f7331c.getHeight() - i2) - i3) - g0.c();
                        ((FrameLayout) this.f7331c.findViewById(16908290)).addView(this.f7332d.o, layoutParams);
                    }
                } else {
                    i3 = 0;
                }
                if (z) {
                    int webViewScrollY = !bVar.V ? i4.getWebViewScrollY() : 0;
                    c.a.p0.a.c1.e.a.a aVar = bVar.l;
                    int height = ((this.f7332d.f7321j.r3().getHeight() - (aVar != null ? aVar.f() : 0)) - this.a.getHeight()) + webViewScrollY;
                    int i5 = bVar.I;
                    if (height - i5 < i2) {
                        this.f7332d.p = true;
                        if (i5 > height) {
                            this.f7332d.f7321j.r3().setScrollY(i2 + i3);
                            return;
                        } else {
                            this.f7332d.f7321j.r3().setScrollY((i2 - height) + i5 + i3);
                            return;
                        }
                    }
                    this.f7332d.p = false;
                }
            }
        }

        @Override // c.a.p0.a.j2.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f7332d.q == this.a.getLineCount()) {
                return;
            }
            c.a.p0.a.u.d.i("Component-TextArea", "send line change callback");
            this.f7332d.F0(this.a, "linechange");
            this.f7332d.E0(this.a, str);
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f7334e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7335f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f7336g;

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
            this.f7336g = aVar;
            this.f7334e = swanEditText;
            this.f7335f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f7334e == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            String obj = this.f7334e.getTag().toString();
            if (!TextUtils.equals(obj, ((c.a.p0.a.s.c.g.b) this.f7336g.n()).f7283f)) {
                c.a.p0.a.s.g.a.a("Component-TextArea", "changeTextAreaStatus with different id");
            }
            int D0 = this.f7336g.D0(this.f7334e);
            try {
                jSONObject.put("eventName", this.f7335f);
                jSONObject.put("value", this.f7334e.getText().toString());
                jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, this.f7334e.getSelectionStart());
                jSONObject.put("selectionStart", this.f7334e.getSelectionStart());
                jSONObject.put("selectionEnd", this.f7334e.getSelectionEnd());
                jSONObject.put("lineCount", this.f7334e.getLineCount());
                jSONObject.put("height", "" + n0.P(D0));
                jSONObject.put("keyboardHeight", "" + n0.P((float) this.f7336g.k));
            } catch (JSONException e2) {
                if (c.a.p0.a.s.b.a.f7271h) {
                    e2.printStackTrace();
                }
            }
            if (c.a.p0.a.s.b.a.f7271h) {
                String str = "changeTextAreaStatus:" + jSONObject.toString();
            }
            this.f7336g.l.a(obj, this.f7336g.m, jSONObject);
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f7337e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7338f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7339g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f7340h;

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
            this.f7340h = aVar;
            this.f7337e = swanEditText;
            this.f7338f = str;
            this.f7339g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f7337e == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            String obj = this.f7337e.getTag().toString();
            if (!TextUtils.equals(obj, ((c.a.p0.a.s.c.g.b) this.f7340h.n()).f7283f)) {
                c.a.p0.a.s.g.a.a("Component-TextArea", "changeTextAreaStatus with different id");
            }
            int D0 = this.f7340h.D0(this.f7337e);
            try {
                jSONObject.put("eventName", this.f7338f);
                jSONObject.put("value", this.f7337e.getText().toString());
                jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, this.f7337e.getSelectionStart());
                jSONObject.put("selectionStart", this.f7337e.getSelectionStart());
                jSONObject.put("selectionEnd", this.f7337e.getSelectionEnd());
                jSONObject.put("lineCount", this.f7337e.getLineCount());
                jSONObject.put("height", "" + n0.P(D0));
                jSONObject.put("keyboardHeight", "" + n0.P((float) this.f7340h.k));
                jSONObject.put("keyCode", this.f7339g);
            } catch (JSONException e2) {
                if (c.a.p0.a.s.b.a.f7271h) {
                    e2.printStackTrace();
                }
            }
            if (c.a.p0.a.s.b.a.f7271h) {
                String str = "changeTextAreaStatus:" + jSONObject.toString();
            }
            this.f7340h.l.a(obj, this.f7340h.m, jSONObject);
        }
    }

    /* loaded from: classes.dex */
    public class h implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.s.c.g.b f7341b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f7342c;

        public h(a aVar, SwanEditText swanEditText, c.a.p0.a.s.c.g.b bVar) {
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
            this.f7342c = aVar;
            this.a = swanEditText;
            this.f7341b = bVar;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 >= 2 && i2 <= 7) {
                    this.f7342c.F0(this.a, "confirm");
                }
                return this.f7341b.b0;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void a(String str, String str2, JSONObject jSONObject);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@Nullable Context context, @NonNull c.a.p0.a.s.c.g.b bVar, @NonNull SwanAppActivity swanAppActivity, @NonNull c.a.p0.a.x.g.f fVar, @NonNull i iVar) {
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
                super((Context) objArr2[0], (c.a.p0.a.s.a.a.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = false;
        this.q = 1;
        this.f7320i = swanAppActivity;
        this.f7321j = fVar;
        this.l = iVar;
    }

    public final int D0(SwanEditText swanEditText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanEditText)) == null) {
            c.a.p0.a.s.c.g.b bVar = (c.a.p0.a.s.c.g.b) n();
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
            c.a.p0.a.s.c.g.b bVar = (c.a.p0.a.s.c.g.b) n();
            if (!TextUtils.equals(str, bVar.f7283f)) {
                c.a.p0.a.s.g.a.a("Component-TextArea", "keyBoardShow with different id");
            }
            boolean z = bVar.X;
            if (!swanEditText.hasFocus() || bVar.V) {
                return;
            }
            if (this.k > 0 && z && this.p) {
                int scrollY = this.f7321j.r3().getScrollY() + (swanEditText.getHeight() - this.n);
                if (scrollY > 0) {
                    this.f7321j.r3().setScrollY(scrollY);
                } else {
                    this.f7321j.r3().setScrollY(0);
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
                ((c.a.p0.a.s.c.g.b) n()).n(swanEditText.getHeight());
            } else if (c2 == 1) {
                ((c.a.p0.a.s.c.g.b) n()).k(swanEditText.getText().toString());
            } else if (c2 == 2) {
                ((c.a.p0.a.s.c.g.b) n()).r(true);
            } else if (c2 == 3) {
                ((c.a.p0.a.s.c.g.b) n()).r(false);
            } else if (c2 == 4) {
                ((c.a.p0.a.s.c.g.b) n()).m(swanEditText.getSelectionStart(), swanEditText.getSelectionEnd());
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
                ((c.a.p0.a.s.c.g.b) n()).n(swanEditText.getHeight());
            } else if (c2 == 1) {
                ((c.a.p0.a.s.c.g.b) n()).k(swanEditText.getText().toString());
            } else if (c2 == 2) {
                ((c.a.p0.a.s.c.g.b) n()).r(true);
            } else if (c2 == 3) {
                ((c.a.p0.a.s.c.g.b) n()).r(false);
            } else if (c2 == 4) {
                ((c.a.p0.a.s.c.g.b) n()).m(swanEditText.getSelectionStart(), swanEditText.getSelectionEnd());
            }
            q0.a0(new g(this, swanEditText, str, i2));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.s.a.a.a, c.a.p0.a.s.a.c.b, c.a.p0.a.s.a.d.a, c.a.p0.a.s.b.a
    @NonNull
    /* renamed from: H0 */
    public c.a.p0.a.s.f.b k(@NonNull c.a.p0.a.s.c.g.b bVar, @NonNull c.a.p0.a.s.c.g.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bVar, bVar2)) == null) {
            c.a.p0.a.s.f.b k = super.k(bVar, bVar2);
            if (!TextUtils.equals(bVar.P, bVar2.P)) {
                k.b(14);
            }
            if (bVar.Q != bVar2.Q) {
                k.b(14);
            }
            if (!TextUtils.equals(bVar.R, bVar2.R)) {
                k.b(14);
            }
            if (!TextUtils.equals(bVar.S, bVar2.S)) {
                k.b(14);
            }
            if (bVar.a0 != bVar2.a0) {
                k.b(15);
            }
            return k;
        }
        return (c.a.p0.a.s.f.b) invokeLL.objValue;
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SwanAppActivity activity = c.a.p0.a.w0.f.U().getActivity();
            if (activity == null) {
                c.a.p0.a.u.d.o("Component-TextArea", "activity is null when close input");
                return;
            }
            boolean z = c.a.p0.a.s.b.a.f7271h;
            x.a(activity, activity.getWindow().getDecorView().getWindowToken());
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SwanAppActivity activity = c.a.p0.a.w0.f.U().getActivity();
            if (activity == null) {
                c.a.p0.a.u.d.o("Component-TextArea", "activity is null when open input");
                return;
            }
            boolean z = c.a.p0.a.s.b.a.f7271h;
            x.b(activity, true);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.s.b.a
    @NonNull
    /* renamed from: K0 */
    public SwanEditText v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) ? new SwanEditText(context) : (SwanEditText) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.s.b.a
    /* renamed from: L0 */
    public void A(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, swanEditText) == null) {
            super.A(swanEditText);
            c.a.p0.a.s.c.g.b bVar = (c.a.p0.a.s.c.g.b) n();
            swanEditText.setTag(bVar.f7283f);
            swanEditText.setInputType(262144);
            swanEditText.setSingleLine(false);
            swanEditText.setHorizontallyScrolling(false);
            this.m = bVar.f7286i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.s.a.a.a
    /* renamed from: M0 */
    public void a0(@NonNull SwanEditText swanEditText, @NonNull c.a.p0.a.s.c.g.b bVar, @NonNull c.a.p0.a.s.f.b bVar2) {
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
            q0.a0(new RunnableC0453a(this, bVar, swanEditText));
            if (bVar2.a(15)) {
                P0(swanEditText, bVar);
            }
            if (z) {
                V0(swanEditText, this.f7320i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.s.a.a.a
    /* renamed from: N0 */
    public boolean c0(@NonNull SwanEditText swanEditText, @NonNull c.a.p0.a.s.c.g.b bVar) {
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
    @Override // c.a.p0.a.s.a.a.a
    /* renamed from: O0 */
    public void d0(@NonNull SwanEditText swanEditText, @NonNull c.a.p0.a.s.c.g.b bVar) {
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

    public final void P0(@NonNull SwanEditText swanEditText, @NonNull c.a.p0.a.s.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, swanEditText, bVar) == null) {
            boolean z = c.a.p0.a.s.b.a.f7271h;
            swanEditText.setEnabled(!bVar.a0);
        }
    }

    public final void Q0(@NonNull SwanEditText swanEditText, @NonNull c.a.p0.a.s.c.g.b bVar) {
        StyleSpan styleSpan;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, swanEditText, bVar) == null) {
            boolean z = c.a.p0.a.s.b.a.f7271h;
            SpannableString spannableString = new SpannableString(bVar.P);
            String str = bVar.R;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1039745817) {
                if (hashCode == 3029637 && str.equals("bold")) {
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
    @Override // c.a.p0.a.s.a.a.a
    /* renamed from: R0 */
    public void f0(@NonNull SwanEditText swanEditText, @NonNull c.a.p0.a.s.c.g.b bVar) {
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
    @Override // c.a.p0.a.s.a.c.b
    /* renamed from: S0 */
    public void U(@NonNull SwanEditText swanEditText, @NonNull c.a.p0.a.s.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, swanEditText, bVar) == null) {
            boolean z = c.a.p0.a.s.b.a.f7271h;
            if (TextUtils.equals(swanEditText.getText(), bVar.x)) {
                return;
            }
            swanEditText.setLineSpacing(bVar.C, 1.0f);
            swanEditText.setText(bVar.x);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.s.a.c.b
    /* renamed from: T0 */
    public void X(@NonNull SwanEditText swanEditText, @NonNull c.a.p0.a.s.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, swanEditText, bVar) == null) {
            super.Y(swanEditText, bVar, 48);
        }
    }

    public void U0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            if (!TextUtils.equals(((c.a.p0.a.s.c.g.b) n()).f7283f, str)) {
                c.a.p0.a.s.g.a.a("Component-TextArea", "sendLineChangeEvent with different id");
            }
            SwanEditText swanEditText = (SwanEditText) q();
            if (swanEditText == null) {
                c.a.p0.a.s.g.a.a("Component-TextArea", "sendLineChangeEvent with a null editText");
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
            c.a.p0.a.j2.b.g(((c.a.p0.a.s.c.g.b) n()).f7283f, swanAppActivity, new e(this, swanEditText, swanAppActivity, swanAppActivity.getWindow().getDecorView()));
        }
    }
}

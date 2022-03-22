package c.a.n0.a.s.c.g;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.g0;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.p2.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.ConstPath;
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
public final class a extends c.a.n0.a.s.a.a.a<SwanEditText, c.a.n0.a.s.c.g.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActivity i;
    public c.a.n0.a.x.g.f j;
    public int k;
    public i l;
    public String m;
    public int n;
    public ShowConfirmBarLayout o;
    public boolean p;
    public int q;

    /* renamed from: c.a.n0.a.s.c.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0441a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.s.c.g.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f6123b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f6124c;

        public RunnableC0441a(a aVar, c.a.n0.a.s.c.g.b bVar, SwanEditText swanEditText) {
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
            this.f6124c = aVar;
            this.a = bVar;
            this.f6123b = swanEditText;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f6124c.i != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) this.f6124c.i.getSystemService("input_method");
                    if (inputMethodManager == null || !this.a.P) {
                        return;
                    }
                    this.f6123b.setFocusable(true);
                    this.f6123b.setFocusableInTouchMode(true);
                    this.f6123b.requestFocus();
                    inputMethodManager.showSoftInput(this.f6123b, 0);
                    return;
                }
                c.a.n0.a.s.g.a.a("Component-TextArea", "activity is null, set textarea attr failed");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements SwanEditText.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f6125b;

        public b(a aVar, SwanEditText swanEditText) {
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
            this.f6125b = aVar;
            this.a = swanEditText;
        }

        @Override // com.baidu.swan.apps.component.components.textarea.SwanEditText.a
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.f6125b.F0(this.a, "selection");
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f6126b;

        public c(a aVar, SwanEditText swanEditText) {
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
            this.f6126b = aVar;
            this.a = swanEditText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.a.hasFocus()) {
                c.a.n0.a.u.d.i("Component-TextArea", "send input callback");
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) || this.a.getLineCount() <= 0) {
                return;
            }
            if (this.f6126b.q != this.a.getLineCount()) {
                c.a.n0.a.u.d.i("Component-TextArea", "send line change callback");
                this.f6126b.F0(this.a, "linechange");
            }
            int i4 = i3 - i2;
            if (i2 != i4) {
                this.f6126b.G0(this.a, "input", i2 > i4 ? '\b' : charSequence.charAt((i + i4) - 1));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f6127b;

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
            this.f6127b = aVar;
            this.a = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (c.a.n0.a.s.b.a.f6086h) {
                    Log.d("Component-TextArea", "onFocusChange:" + z);
                }
                if (z) {
                    if (this.f6127b.k != 0) {
                        this.f6127b.F0(this.a, AddFriendActivityConfig.TYPE_FOCUS);
                    }
                    this.f6127b.J0();
                    return;
                }
                this.f6127b.F0(this.a, ConstPath.KEY_BLUR);
                this.f6127b.I0();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.n0.a.j2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f6128b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f6129c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f6130d;

        /* renamed from: c.a.n0.a.s.c.g.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0442a implements ShowConfirmBarLayout.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.s.c.g.b a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f6131b;

            public C0442a(e eVar, c.a.n0.a.s.c.g.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6131b = eVar;
                this.a = bVar;
            }

            @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.b
            public void onClick(View view) {
                InputMethodManager inputMethodManager;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!this.a.X && (inputMethodManager = (InputMethodManager) this.f6131b.f6128b.getSystemService("input_method")) != null) {
                        inputMethodManager.hideSoftInputFromWindow(this.f6131b.a.getWindowToken(), 0);
                    }
                    c.a.n0.a.u.d.i("Component-TextArea", "send confirm change callback");
                    e eVar = this.f6131b;
                    eVar.f6130d.F0(eVar.a, "confirm");
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6130d = aVar;
            this.a = swanEditText;
            this.f6128b = swanAppActivity;
            this.f6129c = view;
        }

        @Override // c.a.n0.a.j2.a
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (this.f6130d.k != 0) {
                    this.f6130d.k = 0;
                    if (this.f6130d.j.v3().getScrollY() > 0) {
                        this.f6130d.j.v3().setScrollY(0);
                        this.f6130d.p = false;
                    }
                    if (this.f6130d.o != null && this.f6130d.o.getVisibility() == 0) {
                        ((FrameLayout) this.f6129c.findViewById(16908290)).removeView(this.f6130d.o);
                        this.f6130d.o = null;
                    }
                }
                if (this.a.hasFocus()) {
                    this.a.clearFocus();
                    if (c.a.n0.a.s.b.a.f6086h) {
                        Log.d("Component-TextArea", "clearFocus");
                    }
                }
            }
        }

        @Override // c.a.n0.a.j2.a
        public void b(String str, int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
                c.a.n0.a.s.c.g.b bVar = (c.a.n0.a.s.c.g.b) this.f6130d.n();
                c.a.n0.a.f.e.c i3 = c.a.n0.a.w0.f.U().i();
                if (this.f6130d.k == i || !this.a.hasFocus() || i3 == null) {
                    return;
                }
                this.f6130d.k = i;
                this.f6130d.n = this.a.getHeight();
                this.f6130d.F0(this.a, AddFriendActivityConfig.TYPE_FOCUS);
                boolean z = bVar.T;
                if (bVar.S) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    i2 = n0.g(38.0f);
                    if (this.f6130d.o == null) {
                        this.f6130d.o = new ShowConfirmBarLayout(this.f6128b);
                        this.f6130d.o.setOnConfirmButtonClickListener(new C0442a(this, bVar));
                        layoutParams.topMargin = ((this.f6129c.getHeight() - i) - i2) - g0.c();
                        ((FrameLayout) this.f6129c.findViewById(16908290)).addView(this.f6130d.o, layoutParams);
                    }
                } else {
                    i2 = 0;
                }
                if (z) {
                    int webViewScrollY = !bVar.R ? i3.getWebViewScrollY() : 0;
                    c.a.n0.a.c1.e.a.a aVar = bVar.f6102h;
                    int height = ((this.f6130d.j.v3().getHeight() - (aVar != null ? aVar.e() : 0)) - this.a.getHeight()) + webViewScrollY;
                    int i4 = bVar.E;
                    if (height - i4 < i) {
                        this.f6130d.p = true;
                        if (i4 > height) {
                            this.f6130d.j.v3().setScrollY(i + i2);
                            return;
                        } else {
                            this.f6130d.j.v3().setScrollY((i - height) + i4 + i2);
                            return;
                        }
                    }
                    this.f6130d.p = false;
                }
            }
        }

        @Override // c.a.n0.a.j2.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f6130d.q == this.a.getLineCount()) {
                return;
            }
            c.a.n0.a.u.d.i("Component-TextArea", "send line change callback");
            this.f6130d.F0(this.a, "linechange");
            this.f6130d.E0(this.a, str);
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6132b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f6133c;

        public f(a aVar, SwanEditText swanEditText, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6133c = aVar;
            this.a = swanEditText;
            this.f6132b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            String obj = this.a.getTag().toString();
            if (!TextUtils.equals(obj, ((c.a.n0.a.s.c.g.b) this.f6133c.n()).f6096b)) {
                c.a.n0.a.s.g.a.a("Component-TextArea", "changeTextAreaStatus with different id");
            }
            int D0 = this.f6133c.D0(this.a);
            try {
                jSONObject.put("eventName", this.f6132b);
                jSONObject.put("value", this.a.getText().toString());
                jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, this.a.getSelectionStart());
                jSONObject.put("selectionStart", this.a.getSelectionStart());
                jSONObject.put("selectionEnd", this.a.getSelectionEnd());
                jSONObject.put("lineCount", this.a.getLineCount());
                jSONObject.put("height", "" + n0.O(D0));
                jSONObject.put("keyboardHeight", "" + n0.O((float) this.f6133c.k));
            } catch (JSONException e2) {
                if (c.a.n0.a.s.b.a.f6086h) {
                    e2.printStackTrace();
                }
            }
            if (c.a.n0.a.s.b.a.f6086h) {
                Log.d("Component-TextArea", "changeTextAreaStatus:" + jSONObject.toString());
            }
            this.f6133c.l.a(obj, this.f6133c.m, jSONObject);
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6134b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f6135c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f6136d;

        public g(a aVar, SwanEditText swanEditText, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6136d = aVar;
            this.a = swanEditText;
            this.f6134b = str;
            this.f6135c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            String obj = this.a.getTag().toString();
            if (!TextUtils.equals(obj, ((c.a.n0.a.s.c.g.b) this.f6136d.n()).f6096b)) {
                c.a.n0.a.s.g.a.a("Component-TextArea", "changeTextAreaStatus with different id");
            }
            int D0 = this.f6136d.D0(this.a);
            try {
                jSONObject.put("eventName", this.f6134b);
                jSONObject.put("value", this.a.getText().toString());
                jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, this.a.getSelectionStart());
                jSONObject.put("selectionStart", this.a.getSelectionStart());
                jSONObject.put("selectionEnd", this.a.getSelectionEnd());
                jSONObject.put("lineCount", this.a.getLineCount());
                jSONObject.put("height", "" + n0.O(D0));
                jSONObject.put("keyboardHeight", "" + n0.O((float) this.f6136d.k));
                jSONObject.put("keyCode", this.f6135c);
            } catch (JSONException e2) {
                if (c.a.n0.a.s.b.a.f6086h) {
                    e2.printStackTrace();
                }
            }
            if (c.a.n0.a.s.b.a.f6086h) {
                Log.d("Component-TextArea", "changeTextAreaStatus:" + jSONObject.toString());
            }
            this.f6136d.l.a(obj, this.f6136d.m, jSONObject);
        }
    }

    /* loaded from: classes.dex */
    public class h implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.s.c.g.b f6137b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f6138c;

        public h(a aVar, SwanEditText swanEditText, c.a.n0.a.s.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanEditText, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6138c = aVar;
            this.a = swanEditText;
            this.f6137b = bVar;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                if (i >= 2 && i <= 7) {
                    this.f6138c.F0(this.a, "confirm");
                }
                return this.f6137b.X;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void a(String str, String str2, JSONObject jSONObject);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@Nullable Context context, @NonNull c.a.n0.a.s.c.g.b bVar, @NonNull SwanAppActivity swanAppActivity, @NonNull c.a.n0.a.x.g.f fVar, @NonNull i iVar) {
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
                super((Context) objArr2[0], (c.a.n0.a.s.a.a.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = false;
        this.q = 1;
        this.i = swanAppActivity;
        this.j = fVar;
        this.l = iVar;
    }

    public final int D0(SwanEditText swanEditText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanEditText)) == null) {
            c.a.n0.a.s.c.g.b bVar = (c.a.n0.a.s.c.g.b) n();
            int lineCount = swanEditText.getLineCount();
            int lineHeight = swanEditText.getLineHeight();
            int i2 = bVar.U;
            int i3 = bVar.V;
            int height = swanEditText.getHeight();
            if (bVar.Q) {
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
            c.a.n0.a.s.c.g.b bVar = (c.a.n0.a.s.c.g.b) n();
            if (!TextUtils.equals(str, bVar.f6096b)) {
                c.a.n0.a.s.g.a.a("Component-TextArea", "keyBoardShow with different id");
            }
            boolean z = bVar.T;
            if (!swanEditText.hasFocus() || bVar.R) {
                return;
            }
            if (this.k > 0 && z && this.p) {
                int scrollY = this.j.v3().getScrollY() + (swanEditText.getHeight() - this.n);
                if (scrollY > 0) {
                    this.j.v3().setScrollY(scrollY);
                } else {
                    this.j.v3().setScrollY(0);
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
                    if (str.equals(ConstPath.KEY_BLUR)) {
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
                ((c.a.n0.a.s.c.g.b) n()).m(swanEditText.getHeight());
            } else if (c2 == 1) {
                ((c.a.n0.a.s.c.g.b) n()).j(swanEditText.getText().toString());
            } else if (c2 == 2) {
                ((c.a.n0.a.s.c.g.b) n()).q(true);
            } else if (c2 == 3) {
                ((c.a.n0.a.s.c.g.b) n()).q(false);
            } else if (c2 == 4) {
                ((c.a.n0.a.s.c.g.b) n()).l(swanEditText.getSelectionStart(), swanEditText.getSelectionEnd());
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
                    if (str.equals(ConstPath.KEY_BLUR)) {
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
                ((c.a.n0.a.s.c.g.b) n()).m(swanEditText.getHeight());
            } else if (c2 == 1) {
                ((c.a.n0.a.s.c.g.b) n()).j(swanEditText.getText().toString());
            } else if (c2 == 2) {
                ((c.a.n0.a.s.c.g.b) n()).q(true);
            } else if (c2 == 3) {
                ((c.a.n0.a.s.c.g.b) n()).q(false);
            } else if (c2 == 4) {
                ((c.a.n0.a.s.c.g.b) n()).l(swanEditText.getSelectionStart(), swanEditText.getSelectionEnd());
            }
            q0.a0(new g(this, swanEditText, str, i2));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.s.a.a.a, c.a.n0.a.s.a.c.b, c.a.n0.a.s.a.d.a, c.a.n0.a.s.b.a
    @NonNull
    /* renamed from: H0 */
    public c.a.n0.a.s.f.b k(@NonNull c.a.n0.a.s.c.g.b bVar, @NonNull c.a.n0.a.s.c.g.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bVar, bVar2)) == null) {
            c.a.n0.a.s.f.b k = super.k(bVar, bVar2);
            if (!TextUtils.equals(bVar.L, bVar2.L)) {
                k.b(14);
            }
            if (bVar.M != bVar2.M) {
                k.b(14);
            }
            if (!TextUtils.equals(bVar.N, bVar2.N)) {
                k.b(14);
            }
            if (!TextUtils.equals(bVar.O, bVar2.O)) {
                k.b(14);
            }
            if (bVar.W != bVar2.W) {
                k.b(15);
            }
            return k;
        }
        return (c.a.n0.a.s.f.b) invokeLL.objValue;
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SwanAppActivity activity = c.a.n0.a.w0.f.U().getActivity();
            if (activity == null) {
                c.a.n0.a.u.d.o("Component-TextArea", "activity is null when close input");
                return;
            }
            if (c.a.n0.a.s.b.a.f6086h) {
                Log.d("Component-TextArea", "forceCloseKeyboard");
            }
            x.a(activity, activity.getWindow().getDecorView().getWindowToken());
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SwanAppActivity activity = c.a.n0.a.w0.f.U().getActivity();
            if (activity == null) {
                c.a.n0.a.u.d.o("Component-TextArea", "activity is null when open input");
                return;
            }
            if (c.a.n0.a.s.b.a.f6086h) {
                Log.d("Component-TextArea", "forceOpenKeyboard");
            }
            x.b(activity, true);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.s.b.a
    @NonNull
    /* renamed from: K0 */
    public SwanEditText v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) ? new SwanEditText(context) : (SwanEditText) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.s.b.a
    /* renamed from: L0 */
    public void A(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, swanEditText) == null) {
            super.A(swanEditText);
            c.a.n0.a.s.c.g.b bVar = (c.a.n0.a.s.c.g.b) n();
            swanEditText.setTag(bVar.f6096b);
            swanEditText.setInputType(262144);
            swanEditText.setSingleLine(false);
            swanEditText.setHorizontallyScrolling(false);
            this.m = bVar.f6099e;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.s.a.a.a
    /* renamed from: M0 */
    public void a0(@NonNull SwanEditText swanEditText, @NonNull c.a.n0.a.s.c.g.b bVar, @NonNull c.a.n0.a.s.f.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, swanEditText, bVar, bVar2) == null) {
            super.T(swanEditText, bVar, bVar2);
            if (bVar2.a(14)) {
                Q0(swanEditText, bVar);
            }
            boolean z = !t();
            if (z) {
                swanEditText.setMinHeight(bVar.U);
                swanEditText.setMaxHeight(bVar.V);
            }
            q0.a0(new RunnableC0441a(this, bVar, swanEditText));
            if (bVar2.a(15)) {
                P0(swanEditText, bVar);
            }
            if (z) {
                V0(swanEditText, this.i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.s.a.a.a
    /* renamed from: N0 */
    public boolean c0(@NonNull SwanEditText swanEditText, @NonNull c.a.n0.a.s.c.g.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, swanEditText, bVar)) == null) {
            if (TextUtils.isEmpty(bVar.I) || "default".equals(bVar.I)) {
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
    @Override // c.a.n0.a.s.a.a.a
    /* renamed from: O0 */
    public void d0(@NonNull SwanEditText swanEditText, @NonNull c.a.n0.a.s.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, swanEditText, bVar) == null) {
            Editable text = swanEditText.getText();
            int length = text != null ? text.length() : 0;
            if (bVar.P) {
                int i2 = bVar.F;
                if (i2 <= length && i2 >= 0) {
                    swanEditText.setSelection(i2);
                } else {
                    swanEditText.setSelection(length);
                }
            }
        }
    }

    public final void P0(@NonNull SwanEditText swanEditText, @NonNull c.a.n0.a.s.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, swanEditText, bVar) == null) {
            if (c.a.n0.a.s.b.a.f6086h) {
                Log.d("Component-TextArea", "renderDisable");
            }
            swanEditText.setEnabled(!bVar.W);
        }
    }

    public final void Q0(@NonNull SwanEditText swanEditText, @NonNull c.a.n0.a.s.c.g.b bVar) {
        StyleSpan styleSpan;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, swanEditText, bVar) == null) {
            if (c.a.n0.a.s.b.a.f6086h) {
                Log.d("Component-TextArea", "renderPlaceHolder");
            }
            SpannableString spannableString = new SpannableString(bVar.L);
            String str = bVar.N;
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
            spannableString.setSpan(styleSpan, 0, bVar.L.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(SwanAppConfigData.t(bVar.O)), 0, bVar.L.length(), 33);
            spannableString.setSpan(new AbsoluteSizeSpan(bVar.M, true), 0, bVar.L.length(), 33);
            swanEditText.setHint(spannableString);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.s.a.a.a
    /* renamed from: R0 */
    public void f0(@NonNull SwanEditText swanEditText, @NonNull c.a.n0.a.s.c.g.b bVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, swanEditText, bVar) == null) {
            Editable text = swanEditText.getText();
            int length = text != null ? text.length() : 0;
            int i3 = bVar.H;
            if (i3 > length || i3 <= 0 || (i2 = bVar.G) > i3 || i2 <= 0 || !bVar.P || swanEditText.hasFocus()) {
                return;
            }
            swanEditText.setSelection(bVar.G, bVar.H);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.s.a.c.b
    /* renamed from: S0 */
    public void U(@NonNull SwanEditText swanEditText, @NonNull c.a.n0.a.s.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, swanEditText, bVar) == null) {
            if (c.a.n0.a.s.b.a.f6086h) {
                Log.d("Component-TextArea", "renderText");
            }
            if (TextUtils.equals(swanEditText.getText(), bVar.t)) {
                return;
            }
            swanEditText.setLineSpacing(bVar.y, 1.0f);
            swanEditText.setText(bVar.t);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.s.a.c.b
    /* renamed from: T0 */
    public void X(@NonNull SwanEditText swanEditText, @NonNull c.a.n0.a.s.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, swanEditText, bVar) == null) {
            super.Y(swanEditText, bVar, 48);
        }
    }

    public void U0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            if (!TextUtils.equals(((c.a.n0.a.s.c.g.b) n()).f6096b, str)) {
                c.a.n0.a.s.g.a.a("Component-TextArea", "sendLineChangeEvent with different id");
            }
            SwanEditText swanEditText = (SwanEditText) q();
            if (swanEditText == null) {
                c.a.n0.a.s.g.a.a("Component-TextArea", "sendLineChangeEvent with a null editText");
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
            c.a.n0.a.j2.b.g(((c.a.n0.a.s.c.g.b) n()).f6096b, swanAppActivity, new e(this, swanEditText, swanAppActivity, swanAppActivity.getWindow().getDecorView()));
        }
    }
}

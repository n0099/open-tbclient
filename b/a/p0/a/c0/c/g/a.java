package b.a.p0.a.c0.c.g;

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
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.q0;
import b.a.p0.a.v2.x;
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
public final class a extends b.a.p0.a.c0.a.a.a<SwanEditText, b.a.p0.a.c0.c.g.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public SwanAppActivity f4096i;
    public b.a.p0.a.h0.g.f j;
    public int k;
    public h l;
    public String m;
    public int n;
    public ShowConfirmBarLayout o;
    public boolean p;
    public int q;

    /* renamed from: b.a.p0.a.c0.c.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0122a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.c0.c.g.b f4097e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f4098f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f4099g;

        public RunnableC0122a(a aVar, b.a.p0.a.c0.c.g.b bVar, SwanEditText swanEditText) {
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
            this.f4099g = aVar;
            this.f4097e = bVar;
            this.f4098f = swanEditText;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f4099g.f4096i != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) this.f4099g.f4096i.getSystemService("input_method");
                    if (inputMethodManager == null || !this.f4097e.S) {
                        return;
                    }
                    this.f4098f.setFocusable(true);
                    this.f4098f.setFocusableInTouchMode(true);
                    this.f4098f.requestFocus();
                    inputMethodManager.showSoftInput(this.f4098f, 0);
                    return;
                }
                b.a.p0.a.c0.g.a.a("Component-TextArea", "activity is null, set textarea attr failed");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements SwanEditText.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f4100a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f4101b;

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
            this.f4101b = aVar;
            this.f4100a = swanEditText;
        }

        @Override // com.baidu.swan.apps.component.components.textarea.SwanEditText.a
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f4101b.C0(this.f4100a, "selection");
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f4102e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f4103f;

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
            this.f4103f = aVar;
            this.f4102e = swanEditText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.f4102e.hasFocus()) {
                b.a.p0.a.e0.d.g("Component-TextArea", "send input callback");
                this.f4103f.C0(this.f4102e, "input");
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f4102e.getLineCount() <= 0 || this.f4103f.q == this.f4102e.getLineCount()) {
                return;
            }
            b.a.p0.a.e0.d.g("Component-TextArea", "send line change callback");
            this.f4103f.C0(this.f4102e, "linechange");
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f4104e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f4105f;

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
            this.f4105f = aVar;
            this.f4104e = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (b.a.p0.a.c0.b.a.f4044h) {
                    String str = "onFocusChange:" + z;
                }
                if (z) {
                    if (this.f4105f.k != 0) {
                        this.f4105f.C0(this.f4104e, AddFriendActivityConfig.TYPE_FOCUS);
                    }
                    this.f4105f.F0();
                    return;
                }
                this.f4105f.C0(this.f4104e, "blur");
                this.f4105f.E0();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.a.p0.a.p2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f4106a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f4107b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f4108c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f4109d;

        /* renamed from: b.a.p0.a.c0.c.g.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0123a implements ShowConfirmBarLayout.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.c0.c.g.b f4110a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f4111b;

            public C0123a(e eVar, b.a.p0.a.c0.c.g.b bVar) {
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
                this.f4111b = eVar;
                this.f4110a = bVar;
            }

            @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.b
            public void onClick(View view) {
                InputMethodManager inputMethodManager;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!this.f4110a.a0 && (inputMethodManager = (InputMethodManager) this.f4111b.f4107b.getSystemService("input_method")) != null) {
                        inputMethodManager.hideSoftInputFromWindow(this.f4111b.f4106a.getWindowToken(), 0);
                    }
                    b.a.p0.a.e0.d.g("Component-TextArea", "send confirm change callback");
                    e eVar = this.f4111b;
                    eVar.f4109d.C0(eVar.f4106a, "confirm");
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
            this.f4109d = aVar;
            this.f4106a = swanEditText;
            this.f4107b = swanAppActivity;
            this.f4108c = view;
        }

        @Override // b.a.p0.a.p2.a
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (this.f4109d.k != 0) {
                    this.f4109d.k = 0;
                    if (this.f4109d.j.e3().getScrollY() > 0) {
                        this.f4109d.j.e3().setScrollY(0);
                        this.f4109d.p = false;
                    }
                    if (this.f4109d.o != null && this.f4109d.o.getVisibility() == 0) {
                        ((FrameLayout) this.f4108c.findViewById(16908290)).removeView(this.f4109d.o);
                        this.f4109d.o = null;
                    }
                }
                if (this.f4106a.hasFocus()) {
                    this.f4106a.clearFocus();
                    boolean unused = b.a.p0.a.c0.b.a.f4044h;
                }
            }
        }

        @Override // b.a.p0.a.p2.a
        public void b(String str, int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
                b.a.p0.a.c0.c.g.b bVar = (b.a.p0.a.c0.c.g.b) this.f4109d.n();
                b.a.p0.a.p.e.c h2 = b.a.p0.a.g1.f.T().h();
                if (this.f4109d.k == i2 || !this.f4106a.hasFocus() || h2 == null) {
                    return;
                }
                this.f4109d.k = i2;
                this.f4109d.n = this.f4106a.getHeight();
                this.f4109d.C0(this.f4106a, AddFriendActivityConfig.TYPE_FOCUS);
                boolean z = bVar.W;
                if (bVar.V) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    i3 = n0.g(38.0f);
                    if (this.f4109d.o == null) {
                        this.f4109d.o = new ShowConfirmBarLayout(this.f4107b);
                        this.f4109d.o.setOnConfirmButtonClickListener(new C0123a(this, bVar));
                        layoutParams.topMargin = ((this.f4108c.getHeight() - i2) - i3) - n0.s();
                        ((FrameLayout) this.f4108c.findViewById(16908290)).addView(this.f4109d.o, layoutParams);
                    }
                } else {
                    i3 = 0;
                }
                if (z) {
                    int webViewScrollY = !bVar.U ? h2.getWebViewScrollY() : 0;
                    b.a.p0.a.l1.e.a.a aVar = bVar.l;
                    int height = ((this.f4109d.j.e3().getHeight() - (aVar != null ? aVar.f() : 0)) - this.f4106a.getHeight()) + webViewScrollY;
                    int i4 = bVar.H;
                    if (height - i4 < i2) {
                        this.f4109d.p = true;
                        if (i4 > height) {
                            this.f4109d.j.e3().setScrollY(i2 + i3);
                            return;
                        } else {
                            this.f4109d.j.e3().setScrollY((i2 - height) + i4 + i3);
                            return;
                        }
                    }
                    this.f4109d.p = false;
                }
            }
        }

        @Override // b.a.p0.a.p2.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f4109d.q == this.f4106a.getLineCount()) {
                return;
            }
            b.a.p0.a.e0.d.g("Component-TextArea", "send line change callback");
            this.f4109d.C0(this.f4106a, "linechange");
            this.f4109d.B0(this.f4106a, str);
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f4112e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4113f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f4114g;

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
            this.f4114g = aVar;
            this.f4112e = swanEditText;
            this.f4113f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f4112e == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            String obj = this.f4112e.getTag().toString();
            if (!TextUtils.equals(obj, ((b.a.p0.a.c0.c.g.b) this.f4114g.n()).f4056f)) {
                b.a.p0.a.c0.g.a.a("Component-TextArea", "changeTextAreaStatus with different id");
            }
            int A0 = this.f4114g.A0(this.f4112e);
            try {
                jSONObject.put("eventName", this.f4113f);
                jSONObject.put("value", this.f4112e.getText().toString());
                jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, this.f4112e.getSelectionStart());
                jSONObject.put("selectionStart", this.f4112e.getSelectionStart());
                jSONObject.put("selectionEnd", this.f4112e.getSelectionEnd());
                jSONObject.put("lineCount", this.f4112e.getLineCount());
                jSONObject.put("height", n0.L(A0));
                jSONObject.put("keyboardHeight", n0.L(this.f4114g.k));
            } catch (JSONException e2) {
                if (b.a.p0.a.c0.b.a.f4044h) {
                    e2.printStackTrace();
                }
            }
            if (b.a.p0.a.c0.b.a.f4044h) {
                String str = "changeTextAreaStatus:" + jSONObject.toString();
            }
            this.f4114g.l.a(obj, this.f4114g.m, jSONObject);
        }
    }

    /* loaded from: classes.dex */
    public class g implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f4115a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.c0.c.g.b f4116b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f4117c;

        public g(a aVar, SwanEditText swanEditText, b.a.p0.a.c0.c.g.b bVar) {
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
            this.f4117c = aVar;
            this.f4115a = swanEditText;
            this.f4116b = bVar;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 >= 2 && i2 <= 7) {
                    this.f4117c.C0(this.f4115a, "confirm");
                }
                return this.f4116b.a0;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public interface h {
        void a(String str, String str2, JSONObject jSONObject);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@Nullable Context context, @NonNull b.a.p0.a.c0.c.g.b bVar, @NonNull SwanAppActivity swanAppActivity, @NonNull b.a.p0.a.h0.g.f fVar, @NonNull h hVar) {
        super(context, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar, swanAppActivity, fVar, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (b.a.p0.a.c0.a.a.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = false;
        this.q = 1;
        this.f4096i = swanAppActivity;
        this.j = fVar;
        this.l = hVar;
    }

    public final int A0(SwanEditText swanEditText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanEditText)) == null) {
            b.a.p0.a.c0.c.g.b bVar = (b.a.p0.a.c0.c.g.b) n();
            int lineCount = swanEditText.getLineCount();
            int lineHeight = swanEditText.getLineHeight();
            int i2 = bVar.X;
            int i3 = bVar.Y;
            int height = swanEditText.getHeight();
            if (bVar.T) {
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

    public final void B0(SwanEditText swanEditText, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, swanEditText, str) == null) {
            b.a.p0.a.c0.c.g.b bVar = (b.a.p0.a.c0.c.g.b) n();
            if (!TextUtils.equals(str, bVar.f4056f)) {
                b.a.p0.a.c0.g.a.a("Component-TextArea", "keyBoardShow with different id");
            }
            boolean z = bVar.W;
            if (!swanEditText.hasFocus() || bVar.U) {
                return;
            }
            if (this.k > 0 && z && this.p) {
                int scrollY = this.j.e3().getScrollY() + (swanEditText.getHeight() - this.n);
                if (scrollY > 0) {
                    this.j.e3().setScrollY(scrollY);
                } else {
                    this.j.e3().setScrollY(0);
                }
            }
            this.n = swanEditText.getHeight();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void C0(SwanEditText swanEditText, String str) {
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
                ((b.a.p0.a.c0.c.g.b) n()).n(swanEditText.getHeight());
            } else if (c2 == 1) {
                ((b.a.p0.a.c0.c.g.b) n()).k(swanEditText.getText().toString());
            } else if (c2 == 2) {
                ((b.a.p0.a.c0.c.g.b) n()).r(true);
            } else if (c2 == 3) {
                ((b.a.p0.a.c0.c.g.b) n()).r(false);
            } else if (c2 == 4) {
                ((b.a.p0.a.c0.c.g.b) n()).m(swanEditText.getSelectionStart(), swanEditText.getSelectionEnd());
            }
            q0.X(new f(this, swanEditText, str));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.c0.a.a.a, b.a.p0.a.c0.a.c.b, b.a.p0.a.c0.a.d.a, b.a.p0.a.c0.b.a
    @NonNull
    /* renamed from: D0 */
    public b.a.p0.a.c0.f.b k(@NonNull b.a.p0.a.c0.c.g.b bVar, @NonNull b.a.p0.a.c0.c.g.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, bVar2)) == null) {
            b.a.p0.a.c0.f.b k = super.k(bVar, bVar2);
            if (!TextUtils.equals(bVar.O, bVar2.O)) {
                k.b(14);
            }
            if (bVar.P != bVar2.P) {
                k.b(14);
            }
            if (!TextUtils.equals(bVar.Q, bVar2.Q)) {
                k.b(14);
            }
            if (!TextUtils.equals(bVar.R, bVar2.R)) {
                k.b(14);
            }
            if (bVar.Z != bVar2.Z) {
                k.b(15);
            }
            return k;
        }
        return (b.a.p0.a.c0.f.b) invokeLL.objValue;
    }

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SwanAppActivity activity = b.a.p0.a.g1.f.T().getActivity();
            if (activity == null) {
                b.a.p0.a.e0.d.l("Component-TextArea", "activity is null when close input");
                return;
            }
            boolean z = b.a.p0.a.c0.b.a.f4044h;
            x.a(activity, activity.getWindow().getDecorView().getWindowToken());
        }
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SwanAppActivity activity = b.a.p0.a.g1.f.T().getActivity();
            if (activity == null) {
                b.a.p0.a.e0.d.l("Component-TextArea", "activity is null when open input");
                return;
            }
            boolean z = b.a.p0.a.c0.b.a.f4044h;
            x.b(activity, true);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.c0.b.a
    @NonNull
    /* renamed from: G0 */
    public SwanEditText v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) ? new SwanEditText(context) : (SwanEditText) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.c0.b.a
    /* renamed from: H0 */
    public void A(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, swanEditText) == null) {
            super.A(swanEditText);
            b.a.p0.a.c0.c.g.b bVar = (b.a.p0.a.c0.c.g.b) n();
            swanEditText.setTag(bVar.f4056f);
            swanEditText.setInputType(262144);
            swanEditText.setSingleLine(false);
            swanEditText.setHorizontallyScrolling(false);
            this.m = bVar.f4059i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.c0.a.a.a
    /* renamed from: I0 */
    public void a0(@NonNull SwanEditText swanEditText, @NonNull b.a.p0.a.c0.c.g.b bVar, @NonNull b.a.p0.a.c0.f.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, swanEditText, bVar, bVar2) == null) {
            super.T(swanEditText, bVar, bVar2);
            if (bVar2.a(14)) {
                M0(swanEditText, bVar);
            }
            boolean z = !t();
            if (z) {
                swanEditText.setMinHeight(bVar.X);
                swanEditText.setMaxHeight(bVar.Y);
            }
            q0.X(new RunnableC0122a(this, bVar, swanEditText));
            if (bVar2.a(15)) {
                L0(swanEditText, bVar);
            }
            if (z) {
                R0(swanEditText, this.f4096i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.c0.a.a.a
    /* renamed from: J0 */
    public boolean c0(@NonNull SwanEditText swanEditText, @NonNull b.a.p0.a.c0.c.g.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, swanEditText, bVar)) == null) {
            if (TextUtils.isEmpty(bVar.L) || "default".equals(bVar.L)) {
                return false;
            }
            boolean c0 = super.c0(swanEditText, bVar);
            if (c0) {
                swanEditText.setOnEditorActionListener(new g(this, swanEditText, bVar));
            }
            return c0;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.c0.a.a.a
    /* renamed from: K0 */
    public void d0(@NonNull SwanEditText swanEditText, @NonNull b.a.p0.a.c0.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, swanEditText, bVar) == null) {
            Editable text = swanEditText.getText();
            int length = text != null ? text.length() : 0;
            if (bVar.S) {
                int i2 = bVar.I;
                if (i2 <= length && i2 >= 0) {
                    swanEditText.setSelection(i2);
                } else {
                    swanEditText.setSelection(length);
                }
            }
        }
    }

    public final void L0(@NonNull SwanEditText swanEditText, @NonNull b.a.p0.a.c0.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, swanEditText, bVar) == null) {
            boolean z = b.a.p0.a.c0.b.a.f4044h;
            swanEditText.setEnabled(!bVar.Z);
        }
    }

    public final void M0(@NonNull SwanEditText swanEditText, @NonNull b.a.p0.a.c0.c.g.b bVar) {
        StyleSpan styleSpan;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, swanEditText, bVar) == null) {
            boolean z = b.a.p0.a.c0.b.a.f4044h;
            SpannableString spannableString = new SpannableString(bVar.O);
            String str = bVar.Q;
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
            spannableString.setSpan(styleSpan, 0, bVar.O.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(SwanAppConfigData.s(bVar.R)), 0, bVar.O.length(), 33);
            spannableString.setSpan(new AbsoluteSizeSpan(bVar.P, true), 0, bVar.O.length(), 33);
            swanEditText.setHint(spannableString);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.c0.a.a.a
    /* renamed from: N0 */
    public void f0(@NonNull SwanEditText swanEditText, @NonNull b.a.p0.a.c0.c.g.b bVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, swanEditText, bVar) == null) {
            Editable text = swanEditText.getText();
            int length = text != null ? text.length() : 0;
            int i3 = bVar.K;
            if (i3 > length || i3 <= 0 || (i2 = bVar.J) > i3 || i2 <= 0 || !bVar.S || swanEditText.hasFocus()) {
                return;
            }
            swanEditText.setSelection(bVar.J, bVar.K);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.c0.a.c.b
    /* renamed from: O0 */
    public void U(@NonNull SwanEditText swanEditText, @NonNull b.a.p0.a.c0.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, swanEditText, bVar) == null) {
            boolean z = b.a.p0.a.c0.b.a.f4044h;
            if (TextUtils.equals(swanEditText.getText(), bVar.x)) {
                return;
            }
            swanEditText.setText(bVar.x);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.c0.a.c.b
    /* renamed from: P0 */
    public void X(@NonNull SwanEditText swanEditText, @NonNull b.a.p0.a.c0.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, swanEditText, bVar) == null) {
            super.Y(swanEditText, bVar, 48);
        }
    }

    public void Q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            if (!TextUtils.equals(((b.a.p0.a.c0.c.g.b) n()).f4056f, str)) {
                b.a.p0.a.c0.g.a.a("Component-TextArea", "sendLineChangeEvent with different id");
            }
            SwanEditText swanEditText = (SwanEditText) q();
            if (swanEditText == null) {
                b.a.p0.a.c0.g.a.a("Component-TextArea", "sendLineChangeEvent with a null editText");
            } else {
                C0(swanEditText, "linechange");
            }
        }
    }

    public final void R0(SwanEditText swanEditText, @NonNull SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, swanEditText, swanAppActivity) == null) {
            swanEditText.setSelectListener(new b(this, swanEditText));
            swanEditText.addTextChangedListener(new c(this, swanEditText));
            swanEditText.setOnFocusChangeListener(new d(this, swanEditText));
            b.a.p0.a.p2.b.g(((b.a.p0.a.c0.c.g.b) n()).f4056f, swanAppActivity, new e(this, swanEditText, swanAppActivity, swanAppActivity.getWindow().getDecorView()));
        }
    }
}

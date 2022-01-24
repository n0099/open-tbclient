package c.a.r0.j.p0.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.r0.a.k;
import c.a.r0.j.v.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f11298b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f11299c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f11300d;

    /* renamed from: e  reason: collision with root package name */
    public Button f11301e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11302f;

    /* renamed from: g  reason: collision with root package name */
    public a.f f11303g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.j.v.c f11304h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f11305i;

    /* renamed from: j  reason: collision with root package name */
    public TextWatcher f11306j;
    public TextView.OnEditorActionListener k;

    /* renamed from: c.a.r0.j.p0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0774a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11307e;

        public View$OnClickListenerC0774a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11307e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f11307e.f11299c != null && this.f11307e.f11302f) {
                if (this.f11307e.f11303g != null) {
                    this.f11307e.f11303g.c(this.f11307e.f11299c.getText().toString());
                }
                if (this.f11307e.f11304h == null || this.f11307e.f11304h.f11414d || this.f11307e.f11303g == null) {
                    return;
                }
                this.f11307e.f11303g.a();
                this.f11307e.m("");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11308e;

        /* renamed from: c.a.r0.j.p0.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0775a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Editable f11309e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f11310f;

            public RunnableC0775a(b bVar, Editable editable) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, editable};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11310f = bVar;
                this.f11309e = editable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (TextUtils.isEmpty(this.f11309e.toString())) {
                        this.f11310f.f11308e.f11301e.setEnabled(false);
                    } else if (this.f11310f.f11308e.f11301e.isEnabled()) {
                    } else {
                        this.f11310f.f11308e.f11301e.setEnabled(true);
                    }
                }
            }
        }

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11308e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (this.f11308e.f11303g != null) {
                    this.f11308e.f11303g.e(editable.toString());
                }
                this.f11308e.f11301e.post(new RunnableC0775a(this, editable));
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
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (this.a.f11304h == null || this.a.f11304h.f11415e != i2 || this.a.f11299c == null || !this.a.f11302f) {
                    return false;
                }
                if (this.a.f11303g != null) {
                    this.a.f11303g.c(this.a.f11299c.getText().toString());
                }
                if (this.a.f11304h.f11414d || this.a.f11303g == null) {
                    return true;
                }
                this.a.f11303g.a();
                this.a.m("");
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11311e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11311e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11311e.f11301e.setEnabled(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.j.v.c f11312e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11313f;

        public e(a aVar, c.a.r0.j.v.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11313f = aVar;
            this.f11312e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f11313f.f11299c.getText().length() <= this.f11312e.a.length()) {
                        length = this.f11313f.f11299c.getText().length();
                    } else {
                        length = this.f11312e.a.length();
                    }
                    this.f11313f.f11299c.setSelection(length);
                } catch (Exception e2) {
                    if (k.a) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11314e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11315f;

        public f(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11315f = aVar;
            this.f11314e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11315f.f11299c.setSelection(this.f11314e.length());
            }
        }
    }

    @SuppressLint({"InflateParams"})
    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11302f = false;
        this.f11305i = new View$OnClickListenerC0774a(this);
        this.f11306j = new b(this);
        this.k = new c(this);
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(c.a.r0.h.f.aiapps_ai_games_input_view, (ViewGroup) null);
        this.a = relativeLayout;
        this.f11298b = (EditText) relativeLayout.findViewById(c.a.r0.h.e.ai_games_virtual_input_et);
        this.f11300d = (RelativeLayout) this.a.findViewById(c.a.r0.h.e.ai_games_real_input_container);
        this.f11299c = (EditText) this.a.findViewById(c.a.r0.h.e.ai_games_real_input_et);
        Button button = (Button) this.a.findViewById(c.a.r0.h.e.ai_games_input_send_btn);
        this.f11301e = button;
        button.setOnClickListener(this.f11305i);
        this.f11299c.addTextChangedListener(this.f11306j);
        this.f11299c.setOnEditorActionListener(this.k);
        this.f11301e.post(new d(this));
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11302f : invokeV.booleanValue;
    }

    public void h() {
        EditText editText;
        EditText editText2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
            if (!inputMethodManager.isActive() || (editText = this.f11299c) == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
            this.f11302f = false;
            this.f11298b.setVisibility(8);
            this.f11300d.setVisibility(8);
            a.f fVar = this.f11303g;
            if (fVar == null || (editText2 = this.f11299c) == null) {
                return;
            }
            fVar.d(editText2.getText().toString());
        }
    }

    public void i(a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f11303g = fVar;
        }
    }

    public void j(c.a.r0.j.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f11304h = cVar;
            if (this.f11299c == null || cVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(cVar.a)) {
                this.f11299c.setText(cVar.a);
                if (cVar.f11412b > 0) {
                    if (!TextUtils.isEmpty(cVar.a) && cVar.a.length() > cVar.f11412b) {
                        cVar.f11412b = cVar.a.length();
                    }
                    this.f11299c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.f11412b)});
                }
                this.f11299c.postDelayed(new e(this, cVar), 300L);
            } else {
                this.f11299c.setText("");
            }
            this.f11301e.setEnabled(!TextUtils.isEmpty(cVar.a));
            if (cVar.f11413c) {
                this.f11299c.setMinLines(1);
                this.f11299c.setInputType(131073);
                this.f11301e.setText(cVar.f11416f);
                return;
            }
            this.f11299c.setMaxLines(1);
            this.f11299c.setInputType(1);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f11300d.setVisibility(0);
            this.f11299c.setFocusableInTouchMode(true);
            this.f11299c.requestFocus();
            this.f11298b.setVisibility(8);
            this.f11302f = true;
            a.f fVar = this.f11303g;
            if (fVar != null) {
                fVar.b(i2);
            }
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f11302f) {
                return false;
            }
            this.f11298b.setVisibility(0);
            this.f11300d.setVisibility(8);
            this.f11298b.setFocusableInTouchMode(true);
            this.f11298b.requestFocus();
            ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.f11298b, 0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (!this.f11302f || (editText = this.f11299c) == null) {
                return false;
            }
            editText.setText(str);
            this.f11299c.postDelayed(new f(this, str), 300L);
            return true;
        }
        return invokeL.booleanValue;
    }
}

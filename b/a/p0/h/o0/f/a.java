package b.a.p0.h.o0.f;

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
import b.a.p0.a.k;
import b.a.p0.h.u.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f10628a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f10629b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f10630c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f10631d;

    /* renamed from: e  reason: collision with root package name */
    public Button f10632e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10633f;

    /* renamed from: g  reason: collision with root package name */
    public a.f f10634g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.p0.h.u.c f10635h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f10636i;
    public TextWatcher j;
    public TextView.OnEditorActionListener k;

    /* renamed from: b.a.p0.h.o0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC0581a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10637e;

        public View$OnClickListenerC0581a(a aVar) {
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
            this.f10637e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f10637e.f10630c != null && this.f10637e.f10633f) {
                if (this.f10637e.f10634g != null) {
                    this.f10637e.f10634g.c(this.f10637e.f10630c.getText().toString());
                }
                if (this.f10637e.f10635h == null || this.f10637e.f10635h.f10766d || this.f10637e.f10634g == null) {
                    return;
                }
                this.f10637e.f10634g.a();
                this.f10637e.m("");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10638e;

        /* renamed from: b.a.p0.h.o0.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0582a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Editable f10639e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f10640f;

            public RunnableC0582a(b bVar, Editable editable) {
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
                this.f10640f = bVar;
                this.f10639e = editable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (TextUtils.isEmpty(this.f10639e.toString())) {
                        this.f10640f.f10638e.f10632e.setEnabled(false);
                    } else if (this.f10640f.f10638e.f10632e.isEnabled()) {
                    } else {
                        this.f10640f.f10638e.f10632e.setEnabled(true);
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
            this.f10638e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (this.f10638e.f10634g != null) {
                    this.f10638e.f10634g.e(editable.toString());
                }
                this.f10638e.f10632e.post(new RunnableC0582a(this, editable));
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

    /* loaded from: classes4.dex */
    public class c implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f10641a;

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
            this.f10641a = aVar;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (this.f10641a.f10635h == null || this.f10641a.f10635h.f10767e != i2 || this.f10641a.f10630c == null || !this.f10641a.f10633f) {
                    return false;
                }
                if (this.f10641a.f10634g != null) {
                    this.f10641a.f10634g.c(this.f10641a.f10630c.getText().toString());
                }
                if (this.f10641a.f10635h.f10766d || this.f10641a.f10634g == null) {
                    return true;
                }
                this.f10641a.f10634g.a();
                this.f10641a.m("");
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10642e;

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
            this.f10642e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10642e.f10632e.setEnabled(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.h.u.c f10643e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10644f;

        public e(a aVar, b.a.p0.h.u.c cVar) {
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
            this.f10644f = aVar;
            this.f10643e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f10644f.f10630c.getText().length() <= this.f10643e.f10763a.length()) {
                        length = this.f10644f.f10630c.getText().length();
                    } else {
                        length = this.f10643e.f10763a.length();
                    }
                    this.f10644f.f10630c.setSelection(length);
                } catch (Exception e2) {
                    if (k.f6397a) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10645e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10646f;

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
            this.f10646f = aVar;
            this.f10645e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10646f.f10630c.setSelection(this.f10645e.length());
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
        this.f10633f = false;
        this.f10636i = new View$OnClickListenerC0581a(this);
        this.j = new b(this);
        this.k = new c(this);
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(b.a.p0.f.f.aiapps_ai_games_input_view, (ViewGroup) null);
        this.f10628a = relativeLayout;
        this.f10629b = (EditText) relativeLayout.findViewById(b.a.p0.f.e.ai_games_virtual_input_et);
        this.f10631d = (RelativeLayout) this.f10628a.findViewById(b.a.p0.f.e.ai_games_real_input_container);
        this.f10630c = (EditText) this.f10628a.findViewById(b.a.p0.f.e.ai_games_real_input_et);
        Button button = (Button) this.f10628a.findViewById(b.a.p0.f.e.ai_games_input_send_btn);
        this.f10632e = button;
        button.setOnClickListener(this.f10636i);
        this.f10630c.addTextChangedListener(this.j);
        this.f10630c.setOnEditorActionListener(this.k);
        this.f10632e.post(new d(this));
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f10628a : (View) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f10633f : invokeV.booleanValue;
    }

    public void h() {
        EditText editText;
        EditText editText2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
            if (!inputMethodManager.isActive() || (editText = this.f10630c) == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
            this.f10633f = false;
            this.f10629b.setVisibility(8);
            this.f10631d.setVisibility(8);
            a.f fVar = this.f10634g;
            if (fVar == null || (editText2 = this.f10630c) == null) {
                return;
            }
            fVar.d(editText2.getText().toString());
        }
    }

    public void i(a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f10634g = fVar;
        }
    }

    public void j(b.a.p0.h.u.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f10635h = cVar;
            if (this.f10630c == null || cVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(cVar.f10763a)) {
                this.f10630c.setText(cVar.f10763a);
                if (cVar.f10764b > 0) {
                    if (!TextUtils.isEmpty(cVar.f10763a) && cVar.f10763a.length() > cVar.f10764b) {
                        cVar.f10764b = cVar.f10763a.length();
                    }
                    this.f10630c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.f10764b)});
                }
                this.f10630c.postDelayed(new e(this, cVar), 300L);
            } else {
                this.f10630c.setText("");
            }
            this.f10632e.setEnabled(!TextUtils.isEmpty(cVar.f10763a));
            if (cVar.f10765c) {
                this.f10630c.setMinLines(1);
                this.f10630c.setInputType(131073);
                this.f10632e.setText(cVar.f10768f);
                return;
            }
            this.f10630c.setMaxLines(1);
            this.f10630c.setInputType(1);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f10631d.setVisibility(0);
            this.f10630c.setFocusableInTouchMode(true);
            this.f10630c.requestFocus();
            this.f10629b.setVisibility(8);
            this.f10633f = true;
            a.f fVar = this.f10634g;
            if (fVar != null) {
                fVar.b(i2);
            }
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f10633f) {
                return false;
            }
            this.f10629b.setVisibility(0);
            this.f10631d.setVisibility(8);
            this.f10629b.setFocusableInTouchMode(true);
            this.f10629b.requestFocus();
            ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.f10629b, 0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (!this.f10633f || (editText = this.f10630c) == null) {
                return false;
            }
            editText.setText(str);
            this.f10630c.postDelayed(new f(this, str), 300L);
            return true;
        }
        return invokeL.booleanValue;
    }
}

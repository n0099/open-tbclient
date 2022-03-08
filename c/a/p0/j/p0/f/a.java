package c.a.p0.j.p0.f;

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
import c.a.p0.j.v.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f10623b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f10624c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f10625d;

    /* renamed from: e  reason: collision with root package name */
    public Button f10626e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10627f;

    /* renamed from: g  reason: collision with root package name */
    public a.f f10628g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.j.v.c f10629h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f10630i;

    /* renamed from: j  reason: collision with root package name */
    public TextWatcher f10631j;
    public TextView.OnEditorActionListener k;

    /* renamed from: c.a.p0.j.p0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0730a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10632e;

        public View$OnClickListenerC0730a(a aVar) {
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
            this.f10632e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f10632e.f10624c != null && this.f10632e.f10627f) {
                if (this.f10632e.f10628g != null) {
                    this.f10632e.f10628g.c(this.f10632e.f10624c.getText().toString());
                }
                if (this.f10632e.f10629h == null || this.f10632e.f10629h.f10739d || this.f10632e.f10628g == null) {
                    return;
                }
                this.f10632e.f10628g.a();
                this.f10632e.m("");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10633e;

        /* renamed from: c.a.p0.j.p0.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0731a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Editable f10634e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f10635f;

            public RunnableC0731a(b bVar, Editable editable) {
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
                this.f10635f = bVar;
                this.f10634e = editable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (TextUtils.isEmpty(this.f10634e.toString())) {
                        this.f10635f.f10633e.f10626e.setEnabled(false);
                    } else if (this.f10635f.f10633e.f10626e.isEnabled()) {
                    } else {
                        this.f10635f.f10633e.f10626e.setEnabled(true);
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
            this.f10633e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (this.f10633e.f10628g != null) {
                    this.f10633e.f10628g.e(editable.toString());
                }
                this.f10633e.f10626e.post(new RunnableC0731a(this, editable));
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

    /* loaded from: classes2.dex */
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
                if (this.a.f10629h == null || this.a.f10629h.f10740e != i2 || this.a.f10624c == null || !this.a.f10627f) {
                    return false;
                }
                if (this.a.f10628g != null) {
                    this.a.f10628g.c(this.a.f10624c.getText().toString());
                }
                if (this.a.f10629h.f10739d || this.a.f10628g == null) {
                    return true;
                }
                this.a.f10628g.a();
                this.a.m("");
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10636e;

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
            this.f10636e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10636e.f10626e.setEnabled(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.j.v.c f10637e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10638f;

        public e(a aVar, c.a.p0.j.v.c cVar) {
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
            this.f10638f = aVar;
            this.f10637e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f10638f.f10624c.getText().length() <= this.f10637e.a.length()) {
                        length = this.f10638f.f10624c.getText().length();
                    } else {
                        length = this.f10637e.a.length();
                    }
                    this.f10638f.f10624c.setSelection(length);
                } catch (Exception e2) {
                    if (c.a.p0.a.a.a) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10639e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10640f;

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
            this.f10640f = aVar;
            this.f10639e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10640f.f10624c.setSelection(this.f10639e.length());
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
        this.f10627f = false;
        this.f10630i = new View$OnClickListenerC0730a(this);
        this.f10631j = new b(this);
        this.k = new c(this);
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.aiapps_ai_games_input_view, (ViewGroup) null);
        this.a = relativeLayout;
        this.f10623b = (EditText) relativeLayout.findViewById(R.id.ai_games_virtual_input_et);
        this.f10625d = (RelativeLayout) this.a.findViewById(R.id.ai_games_real_input_container);
        this.f10624c = (EditText) this.a.findViewById(R.id.ai_games_real_input_et);
        Button button = (Button) this.a.findViewById(R.id.ai_games_input_send_btn);
        this.f10626e = button;
        button.setOnClickListener(this.f10630i);
        this.f10624c.addTextChangedListener(this.f10631j);
        this.f10624c.setOnEditorActionListener(this.k);
        this.f10626e.post(new d(this));
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f10627f : invokeV.booleanValue;
    }

    public void h() {
        EditText editText;
        EditText editText2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
            if (!inputMethodManager.isActive() || (editText = this.f10624c) == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
            this.f10627f = false;
            this.f10623b.setVisibility(8);
            this.f10625d.setVisibility(8);
            a.f fVar = this.f10628g;
            if (fVar == null || (editText2 = this.f10624c) == null) {
                return;
            }
            fVar.d(editText2.getText().toString());
        }
    }

    public void i(a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f10628g = fVar;
        }
    }

    public void j(c.a.p0.j.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f10629h = cVar;
            if (this.f10624c == null || cVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(cVar.a)) {
                this.f10624c.setText(cVar.a);
                if (cVar.f10737b > 0) {
                    if (!TextUtils.isEmpty(cVar.a) && cVar.a.length() > cVar.f10737b) {
                        cVar.f10737b = cVar.a.length();
                    }
                    this.f10624c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.f10737b)});
                }
                this.f10624c.postDelayed(new e(this, cVar), 300L);
            } else {
                this.f10624c.setText("");
            }
            this.f10626e.setEnabled(!TextUtils.isEmpty(cVar.a));
            if (cVar.f10738c) {
                this.f10624c.setMinLines(1);
                this.f10624c.setInputType(131073);
                this.f10626e.setText(cVar.f10741f);
                return;
            }
            this.f10624c.setMaxLines(1);
            this.f10624c.setInputType(1);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f10625d.setVisibility(0);
            this.f10624c.setFocusableInTouchMode(true);
            this.f10624c.requestFocus();
            this.f10623b.setVisibility(8);
            this.f10627f = true;
            a.f fVar = this.f10628g;
            if (fVar != null) {
                fVar.b(i2);
            }
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f10627f) {
                return false;
            }
            this.f10623b.setVisibility(0);
            this.f10625d.setVisibility(8);
            this.f10623b.setFocusableInTouchMode(true);
            this.f10623b.requestFocus();
            ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.f10623b, 0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (!this.f10627f || (editText = this.f10624c) == null) {
                return false;
            }
            editText.setText(str);
            this.f10624c.postDelayed(new f(this, str), 300L);
            return true;
        }
        return invokeL.booleanValue;
    }
}

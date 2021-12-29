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
    public EditText f11411b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f11412c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f11413d;

    /* renamed from: e  reason: collision with root package name */
    public Button f11414e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11415f;

    /* renamed from: g  reason: collision with root package name */
    public a.f f11416g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.j.v.c f11417h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f11418i;

    /* renamed from: j  reason: collision with root package name */
    public TextWatcher f11419j;

    /* renamed from: k  reason: collision with root package name */
    public TextView.OnEditorActionListener f11420k;

    /* renamed from: c.a.r0.j.p0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0756a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11421e;

        public View$OnClickListenerC0756a(a aVar) {
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
            this.f11421e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f11421e.f11412c != null && this.f11421e.f11415f) {
                if (this.f11421e.f11416g != null) {
                    this.f11421e.f11416g.c(this.f11421e.f11412c.getText().toString());
                }
                if (this.f11421e.f11417h == null || this.f11421e.f11417h.f11530d || this.f11421e.f11416g == null) {
                    return;
                }
                this.f11421e.f11416g.a();
                this.f11421e.m("");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11422e;

        /* renamed from: c.a.r0.j.p0.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0757a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Editable f11423e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f11424f;

            public RunnableC0757a(b bVar, Editable editable) {
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
                this.f11424f = bVar;
                this.f11423e = editable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (TextUtils.isEmpty(this.f11423e.toString())) {
                        this.f11424f.f11422e.f11414e.setEnabled(false);
                    } else if (this.f11424f.f11422e.f11414e.isEnabled()) {
                    } else {
                        this.f11424f.f11422e.f11414e.setEnabled(true);
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
            this.f11422e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (this.f11422e.f11416g != null) {
                    this.f11422e.f11416g.e(editable.toString());
                }
                this.f11422e.f11414e.post(new RunnableC0757a(this, editable));
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
                if (this.a.f11417h == null || this.a.f11417h.f11531e != i2 || this.a.f11412c == null || !this.a.f11415f) {
                    return false;
                }
                if (this.a.f11416g != null) {
                    this.a.f11416g.c(this.a.f11412c.getText().toString());
                }
                if (this.a.f11417h.f11530d || this.a.f11416g == null) {
                    return true;
                }
                this.a.f11416g.a();
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
        public final /* synthetic */ a f11425e;

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
            this.f11425e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11425e.f11414e.setEnabled(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.j.v.c f11426e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11427f;

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
            this.f11427f = aVar;
            this.f11426e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f11427f.f11412c.getText().length() <= this.f11426e.a.length()) {
                        length = this.f11427f.f11412c.getText().length();
                    } else {
                        length = this.f11426e.a.length();
                    }
                    this.f11427f.f11412c.setSelection(length);
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
        public final /* synthetic */ String f11428e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11429f;

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
            this.f11429f = aVar;
            this.f11428e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11429f.f11412c.setSelection(this.f11428e.length());
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
        this.f11415f = false;
        this.f11418i = new View$OnClickListenerC0756a(this);
        this.f11419j = new b(this);
        this.f11420k = new c(this);
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(c.a.r0.h.f.aiapps_ai_games_input_view, (ViewGroup) null);
        this.a = relativeLayout;
        this.f11411b = (EditText) relativeLayout.findViewById(c.a.r0.h.e.ai_games_virtual_input_et);
        this.f11413d = (RelativeLayout) this.a.findViewById(c.a.r0.h.e.ai_games_real_input_container);
        this.f11412c = (EditText) this.a.findViewById(c.a.r0.h.e.ai_games_real_input_et);
        Button button = (Button) this.a.findViewById(c.a.r0.h.e.ai_games_input_send_btn);
        this.f11414e = button;
        button.setOnClickListener(this.f11418i);
        this.f11412c.addTextChangedListener(this.f11419j);
        this.f11412c.setOnEditorActionListener(this.f11420k);
        this.f11414e.post(new d(this));
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11415f : invokeV.booleanValue;
    }

    public void h() {
        EditText editText;
        EditText editText2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
            if (!inputMethodManager.isActive() || (editText = this.f11412c) == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
            this.f11415f = false;
            this.f11411b.setVisibility(8);
            this.f11413d.setVisibility(8);
            a.f fVar = this.f11416g;
            if (fVar == null || (editText2 = this.f11412c) == null) {
                return;
            }
            fVar.d(editText2.getText().toString());
        }
    }

    public void i(a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f11416g = fVar;
        }
    }

    public void j(c.a.r0.j.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f11417h = cVar;
            if (this.f11412c == null || cVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(cVar.a)) {
                this.f11412c.setText(cVar.a);
                if (cVar.f11528b > 0) {
                    if (!TextUtils.isEmpty(cVar.a) && cVar.a.length() > cVar.f11528b) {
                        cVar.f11528b = cVar.a.length();
                    }
                    this.f11412c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.f11528b)});
                }
                this.f11412c.postDelayed(new e(this, cVar), 300L);
            } else {
                this.f11412c.setText("");
            }
            this.f11414e.setEnabled(!TextUtils.isEmpty(cVar.a));
            if (cVar.f11529c) {
                this.f11412c.setMinLines(1);
                this.f11412c.setInputType(131073);
                this.f11414e.setText(cVar.f11532f);
                return;
            }
            this.f11412c.setMaxLines(1);
            this.f11412c.setInputType(1);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f11413d.setVisibility(0);
            this.f11412c.setFocusableInTouchMode(true);
            this.f11412c.requestFocus();
            this.f11411b.setVisibility(8);
            this.f11415f = true;
            a.f fVar = this.f11416g;
            if (fVar != null) {
                fVar.b(i2);
            }
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f11415f) {
                return false;
            }
            this.f11411b.setVisibility(0);
            this.f11413d.setVisibility(8);
            this.f11411b.setFocusableInTouchMode(true);
            this.f11411b.requestFocus();
            ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.f11411b, 0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (!this.f11415f || (editText = this.f11412c) == null) {
                return false;
            }
            editText.setText(str);
            this.f11412c.postDelayed(new f(this, str), 300L);
            return true;
        }
        return invokeL.booleanValue;
    }
}

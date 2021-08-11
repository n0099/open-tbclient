package c.a.n0.h.o0.f;

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
import c.a.n0.a.k;
import c.a.n0.h.u.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f11153a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f11154b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f11155c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f11156d;

    /* renamed from: e  reason: collision with root package name */
    public Button f11157e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11158f;

    /* renamed from: g  reason: collision with root package name */
    public a.f f11159g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.n0.h.u.c f11160h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f11161i;

    /* renamed from: j  reason: collision with root package name */
    public TextWatcher f11162j;
    public TextView.OnEditorActionListener k;

    /* renamed from: c.a.n0.h.o0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0576a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11163e;

        public View$OnClickListenerC0576a(a aVar) {
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
            this.f11163e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f11163e.f11155c != null && this.f11163e.f11158f) {
                if (this.f11163e.f11159g != null) {
                    this.f11163e.f11159g.c(this.f11163e.f11155c.getText().toString());
                }
                if (this.f11163e.f11160h == null || this.f11163e.f11160h.f11293d || this.f11163e.f11159g == null) {
                    return;
                }
                this.f11163e.f11159g.a();
                this.f11163e.m("");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11164e;

        /* renamed from: c.a.n0.h.o0.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0577a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Editable f11165e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f11166f;

            public RunnableC0577a(b bVar, Editable editable) {
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
                this.f11166f = bVar;
                this.f11165e = editable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (TextUtils.isEmpty(this.f11165e.toString())) {
                        this.f11166f.f11164e.f11157e.setEnabled(false);
                    } else if (this.f11166f.f11164e.f11157e.isEnabled()) {
                    } else {
                        this.f11166f.f11164e.f11157e.setEnabled(true);
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
            this.f11164e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (this.f11164e.f11159g != null) {
                    this.f11164e.f11159g.e(editable.toString());
                }
                this.f11164e.f11157e.post(new RunnableC0577a(this, editable));
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

    /* loaded from: classes3.dex */
    public class c implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11167a;

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
            this.f11167a = aVar;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (this.f11167a.f11160h == null || this.f11167a.f11160h.f11294e != i2 || this.f11167a.f11155c == null || !this.f11167a.f11158f) {
                    return false;
                }
                if (this.f11167a.f11159g != null) {
                    this.f11167a.f11159g.c(this.f11167a.f11155c.getText().toString());
                }
                if (this.f11167a.f11160h.f11293d || this.f11167a.f11159g == null) {
                    return true;
                }
                this.f11167a.f11159g.a();
                this.f11167a.m("");
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11168e;

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
            this.f11168e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11168e.f11157e.setEnabled(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.h.u.c f11169e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11170f;

        public e(a aVar, c.a.n0.h.u.c cVar) {
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
            this.f11170f = aVar;
            this.f11169e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f11170f.f11155c.getText().length() <= this.f11169e.f11290a.length()) {
                        length = this.f11170f.f11155c.getText().length();
                    } else {
                        length = this.f11169e.f11290a.length();
                    }
                    this.f11170f.f11155c.setSelection(length);
                } catch (Exception e2) {
                    if (k.f6803a) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11171e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11172f;

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
            this.f11172f = aVar;
            this.f11171e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11172f.f11155c.setSelection(this.f11171e.length());
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
        this.f11158f = false;
        this.f11161i = new View$OnClickListenerC0576a(this);
        this.f11162j = new b(this);
        this.k = new c(this);
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(c.a.n0.f.f.aiapps_ai_games_input_view, (ViewGroup) null);
        this.f11153a = relativeLayout;
        this.f11154b = (EditText) relativeLayout.findViewById(c.a.n0.f.e.ai_games_virtual_input_et);
        this.f11156d = (RelativeLayout) this.f11153a.findViewById(c.a.n0.f.e.ai_games_real_input_container);
        this.f11155c = (EditText) this.f11153a.findViewById(c.a.n0.f.e.ai_games_real_input_et);
        Button button = (Button) this.f11153a.findViewById(c.a.n0.f.e.ai_games_input_send_btn);
        this.f11157e = button;
        button.setOnClickListener(this.f11161i);
        this.f11155c.addTextChangedListener(this.f11162j);
        this.f11155c.setOnEditorActionListener(this.k);
        this.f11157e.post(new d(this));
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11153a : (View) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11158f : invokeV.booleanValue;
    }

    public void h() {
        EditText editText;
        EditText editText2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
            if (!inputMethodManager.isActive() || (editText = this.f11155c) == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
            this.f11158f = false;
            this.f11154b.setVisibility(8);
            this.f11156d.setVisibility(8);
            a.f fVar = this.f11159g;
            if (fVar == null || (editText2 = this.f11155c) == null) {
                return;
            }
            fVar.d(editText2.getText().toString());
        }
    }

    public void i(a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f11159g = fVar;
        }
    }

    public void j(c.a.n0.h.u.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f11160h = cVar;
            if (this.f11155c == null || cVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(cVar.f11290a)) {
                this.f11155c.setText(cVar.f11290a);
                if (cVar.f11291b > 0) {
                    if (!TextUtils.isEmpty(cVar.f11290a) && cVar.f11290a.length() > cVar.f11291b) {
                        cVar.f11291b = cVar.f11290a.length();
                    }
                    this.f11155c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.f11291b)});
                }
                this.f11155c.postDelayed(new e(this, cVar), 300L);
            } else {
                this.f11155c.setText("");
            }
            this.f11157e.setEnabled(!TextUtils.isEmpty(cVar.f11290a));
            if (cVar.f11292c) {
                this.f11155c.setMinLines(1);
                this.f11155c.setInputType(131073);
                this.f11157e.setText(cVar.f11295f);
                return;
            }
            this.f11155c.setMaxLines(1);
            this.f11155c.setInputType(1);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f11156d.setVisibility(0);
            this.f11155c.setFocusableInTouchMode(true);
            this.f11155c.requestFocus();
            this.f11154b.setVisibility(8);
            this.f11158f = true;
            a.f fVar = this.f11159g;
            if (fVar != null) {
                fVar.b(i2);
            }
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f11158f) {
                return false;
            }
            this.f11154b.setVisibility(0);
            this.f11156d.setVisibility(8);
            this.f11154b.setFocusableInTouchMode(true);
            this.f11154b.requestFocus();
            ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.f11154b, 0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (!this.f11158f || (editText = this.f11155c) == null) {
                return false;
            }
            editText.setText(str);
            this.f11155c.postDelayed(new f(this, str), 300L);
            return true;
        }
        return invokeL.booleanValue;
    }
}

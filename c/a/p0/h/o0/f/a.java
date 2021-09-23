package c.a.p0.h.o0.f;

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
import c.a.p0.a.k;
import c.a.p0.h.u.a;
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
    public RelativeLayout f11435a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f11436b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f11437c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f11438d;

    /* renamed from: e  reason: collision with root package name */
    public Button f11439e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11440f;

    /* renamed from: g  reason: collision with root package name */
    public a.f f11441g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.h.u.c f11442h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f11443i;

    /* renamed from: j  reason: collision with root package name */
    public TextWatcher f11444j;
    public TextView.OnEditorActionListener k;

    /* renamed from: c.a.p0.h.o0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0586a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11445e;

        public View$OnClickListenerC0586a(a aVar) {
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
            this.f11445e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f11445e.f11437c != null && this.f11445e.f11440f) {
                if (this.f11445e.f11441g != null) {
                    this.f11445e.f11441g.c(this.f11445e.f11437c.getText().toString());
                }
                if (this.f11445e.f11442h == null || this.f11445e.f11442h.f11575d || this.f11445e.f11441g == null) {
                    return;
                }
                this.f11445e.f11441g.a();
                this.f11445e.m("");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11446e;

        /* renamed from: c.a.p0.h.o0.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0587a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Editable f11447e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f11448f;

            public RunnableC0587a(b bVar, Editable editable) {
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
                this.f11448f = bVar;
                this.f11447e = editable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (TextUtils.isEmpty(this.f11447e.toString())) {
                        this.f11448f.f11446e.f11439e.setEnabled(false);
                    } else if (this.f11448f.f11446e.f11439e.isEnabled()) {
                    } else {
                        this.f11448f.f11446e.f11439e.setEnabled(true);
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
            this.f11446e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (this.f11446e.f11441g != null) {
                    this.f11446e.f11441g.e(editable.toString());
                }
                this.f11446e.f11439e.post(new RunnableC0587a(this, editable));
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
        public final /* synthetic */ a f11449a;

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
            this.f11449a = aVar;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (this.f11449a.f11442h == null || this.f11449a.f11442h.f11576e != i2 || this.f11449a.f11437c == null || !this.f11449a.f11440f) {
                    return false;
                }
                if (this.f11449a.f11441g != null) {
                    this.f11449a.f11441g.c(this.f11449a.f11437c.getText().toString());
                }
                if (this.f11449a.f11442h.f11575d || this.f11449a.f11441g == null) {
                    return true;
                }
                this.f11449a.f11441g.a();
                this.f11449a.m("");
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
        public final /* synthetic */ a f11450e;

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
            this.f11450e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11450e.f11439e.setEnabled(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.h.u.c f11451e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11452f;

        public e(a aVar, c.a.p0.h.u.c cVar) {
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
            this.f11452f = aVar;
            this.f11451e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f11452f.f11437c.getText().length() <= this.f11451e.f11572a.length()) {
                        length = this.f11452f.f11437c.getText().length();
                    } else {
                        length = this.f11451e.f11572a.length();
                    }
                    this.f11452f.f11437c.setSelection(length);
                } catch (Exception e2) {
                    if (k.f7085a) {
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
        public final /* synthetic */ String f11453e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11454f;

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
            this.f11454f = aVar;
            this.f11453e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11454f.f11437c.setSelection(this.f11453e.length());
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
        this.f11440f = false;
        this.f11443i = new View$OnClickListenerC0586a(this);
        this.f11444j = new b(this);
        this.k = new c(this);
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(c.a.p0.f.f.aiapps_ai_games_input_view, (ViewGroup) null);
        this.f11435a = relativeLayout;
        this.f11436b = (EditText) relativeLayout.findViewById(c.a.p0.f.e.ai_games_virtual_input_et);
        this.f11438d = (RelativeLayout) this.f11435a.findViewById(c.a.p0.f.e.ai_games_real_input_container);
        this.f11437c = (EditText) this.f11435a.findViewById(c.a.p0.f.e.ai_games_real_input_et);
        Button button = (Button) this.f11435a.findViewById(c.a.p0.f.e.ai_games_input_send_btn);
        this.f11439e = button;
        button.setOnClickListener(this.f11443i);
        this.f11437c.addTextChangedListener(this.f11444j);
        this.f11437c.setOnEditorActionListener(this.k);
        this.f11439e.post(new d(this));
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11435a : (View) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11440f : invokeV.booleanValue;
    }

    public void h() {
        EditText editText;
        EditText editText2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
            if (!inputMethodManager.isActive() || (editText = this.f11437c) == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
            this.f11440f = false;
            this.f11436b.setVisibility(8);
            this.f11438d.setVisibility(8);
            a.f fVar = this.f11441g;
            if (fVar == null || (editText2 = this.f11437c) == null) {
                return;
            }
            fVar.d(editText2.getText().toString());
        }
    }

    public void i(a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f11441g = fVar;
        }
    }

    public void j(c.a.p0.h.u.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f11442h = cVar;
            if (this.f11437c == null || cVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(cVar.f11572a)) {
                this.f11437c.setText(cVar.f11572a);
                if (cVar.f11573b > 0) {
                    if (!TextUtils.isEmpty(cVar.f11572a) && cVar.f11572a.length() > cVar.f11573b) {
                        cVar.f11573b = cVar.f11572a.length();
                    }
                    this.f11437c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.f11573b)});
                }
                this.f11437c.postDelayed(new e(this, cVar), 300L);
            } else {
                this.f11437c.setText("");
            }
            this.f11439e.setEnabled(!TextUtils.isEmpty(cVar.f11572a));
            if (cVar.f11574c) {
                this.f11437c.setMinLines(1);
                this.f11437c.setInputType(131073);
                this.f11439e.setText(cVar.f11577f);
                return;
            }
            this.f11437c.setMaxLines(1);
            this.f11437c.setInputType(1);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f11438d.setVisibility(0);
            this.f11437c.setFocusableInTouchMode(true);
            this.f11437c.requestFocus();
            this.f11436b.setVisibility(8);
            this.f11440f = true;
            a.f fVar = this.f11441g;
            if (fVar != null) {
                fVar.b(i2);
            }
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f11440f) {
                return false;
            }
            this.f11436b.setVisibility(0);
            this.f11438d.setVisibility(8);
            this.f11436b.setFocusableInTouchMode(true);
            this.f11436b.requestFocus();
            ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.f11436b, 0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (!this.f11440f || (editText = this.f11437c) == null) {
                return false;
            }
            editText.setText(str);
            this.f11437c.postDelayed(new f(this, str), 300L);
            return true;
        }
        return invokeL.booleanValue;
    }
}

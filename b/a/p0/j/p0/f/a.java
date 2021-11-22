package b.a.p0.j.p0.f;

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
import b.a.p0.j.v.a;
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
    public RelativeLayout f11345a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f11346b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f11347c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f11348d;

    /* renamed from: e  reason: collision with root package name */
    public Button f11349e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11350f;

    /* renamed from: g  reason: collision with root package name */
    public a.f f11351g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.p0.j.v.c f11352h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f11353i;
    public TextWatcher j;
    public TextView.OnEditorActionListener k;

    /* renamed from: b.a.p0.j.p0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC0616a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11354e;

        public View$OnClickListenerC0616a(a aVar) {
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
            this.f11354e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f11354e.f11347c != null && this.f11354e.f11350f) {
                if (this.f11354e.f11351g != null) {
                    this.f11354e.f11351g.c(this.f11354e.f11347c.getText().toString());
                }
                if (this.f11354e.f11352h == null || this.f11354e.f11352h.f11488d || this.f11354e.f11351g == null) {
                    return;
                }
                this.f11354e.f11351g.a();
                this.f11354e.m("");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11355e;

        /* renamed from: b.a.p0.j.p0.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0617a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Editable f11356e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f11357f;

            public RunnableC0617a(b bVar, Editable editable) {
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
                this.f11357f = bVar;
                this.f11356e = editable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (TextUtils.isEmpty(this.f11356e.toString())) {
                        this.f11357f.f11355e.f11349e.setEnabled(false);
                    } else if (this.f11357f.f11355e.f11349e.isEnabled()) {
                    } else {
                        this.f11357f.f11355e.f11349e.setEnabled(true);
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
            this.f11355e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (this.f11355e.f11351g != null) {
                    this.f11355e.f11351g.e(editable.toString());
                }
                this.f11355e.f11349e.post(new RunnableC0617a(this, editable));
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
        public final /* synthetic */ a f11358a;

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
            this.f11358a = aVar;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (this.f11358a.f11352h == null || this.f11358a.f11352h.f11489e != i2 || this.f11358a.f11347c == null || !this.f11358a.f11350f) {
                    return false;
                }
                if (this.f11358a.f11351g != null) {
                    this.f11358a.f11351g.c(this.f11358a.f11347c.getText().toString());
                }
                if (this.f11358a.f11352h.f11488d || this.f11358a.f11351g == null) {
                    return true;
                }
                this.f11358a.f11351g.a();
                this.f11358a.m("");
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
        public final /* synthetic */ a f11359e;

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
            this.f11359e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11359e.f11349e.setEnabled(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.j.v.c f11360e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11361f;

        public e(a aVar, b.a.p0.j.v.c cVar) {
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
            this.f11361f = aVar;
            this.f11360e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f11361f.f11347c.getText().length() <= this.f11360e.f11485a.length()) {
                        length = this.f11361f.f11347c.getText().length();
                    } else {
                        length = this.f11360e.f11485a.length();
                    }
                    this.f11361f.f11347c.setSelection(length);
                } catch (Exception e2) {
                    if (k.f6863a) {
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
        public final /* synthetic */ String f11362e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11363f;

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
            this.f11363f = aVar;
            this.f11362e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11363f.f11347c.setSelection(this.f11362e.length());
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
        this.f11350f = false;
        this.f11353i = new View$OnClickListenerC0616a(this);
        this.j = new b(this);
        this.k = new c(this);
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(b.a.p0.h.f.aiapps_ai_games_input_view, (ViewGroup) null);
        this.f11345a = relativeLayout;
        this.f11346b = (EditText) relativeLayout.findViewById(b.a.p0.h.e.ai_games_virtual_input_et);
        this.f11348d = (RelativeLayout) this.f11345a.findViewById(b.a.p0.h.e.ai_games_real_input_container);
        this.f11347c = (EditText) this.f11345a.findViewById(b.a.p0.h.e.ai_games_real_input_et);
        Button button = (Button) this.f11345a.findViewById(b.a.p0.h.e.ai_games_input_send_btn);
        this.f11349e = button;
        button.setOnClickListener(this.f11353i);
        this.f11347c.addTextChangedListener(this.j);
        this.f11347c.setOnEditorActionListener(this.k);
        this.f11349e.post(new d(this));
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11345a : (View) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11350f : invokeV.booleanValue;
    }

    public void h() {
        EditText editText;
        EditText editText2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
            if (!inputMethodManager.isActive() || (editText = this.f11347c) == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
            this.f11350f = false;
            this.f11346b.setVisibility(8);
            this.f11348d.setVisibility(8);
            a.f fVar = this.f11351g;
            if (fVar == null || (editText2 = this.f11347c) == null) {
                return;
            }
            fVar.d(editText2.getText().toString());
        }
    }

    public void i(a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f11351g = fVar;
        }
    }

    public void j(b.a.p0.j.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f11352h = cVar;
            if (this.f11347c == null || cVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(cVar.f11485a)) {
                this.f11347c.setText(cVar.f11485a);
                if (cVar.f11486b > 0) {
                    if (!TextUtils.isEmpty(cVar.f11485a) && cVar.f11485a.length() > cVar.f11486b) {
                        cVar.f11486b = cVar.f11485a.length();
                    }
                    this.f11347c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.f11486b)});
                }
                this.f11347c.postDelayed(new e(this, cVar), 300L);
            } else {
                this.f11347c.setText("");
            }
            this.f11349e.setEnabled(!TextUtils.isEmpty(cVar.f11485a));
            if (cVar.f11487c) {
                this.f11347c.setMinLines(1);
                this.f11347c.setInputType(131073);
                this.f11349e.setText(cVar.f11490f);
                return;
            }
            this.f11347c.setMaxLines(1);
            this.f11347c.setInputType(1);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f11348d.setVisibility(0);
            this.f11347c.setFocusableInTouchMode(true);
            this.f11347c.requestFocus();
            this.f11346b.setVisibility(8);
            this.f11350f = true;
            a.f fVar = this.f11351g;
            if (fVar != null) {
                fVar.b(i2);
            }
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f11350f) {
                return false;
            }
            this.f11346b.setVisibility(0);
            this.f11348d.setVisibility(8);
            this.f11346b.setFocusableInTouchMode(true);
            this.f11346b.requestFocus();
            ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.f11346b, 0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (!this.f11350f || (editText = this.f11347c) == null) {
                return false;
            }
            editText.setText(str);
            this.f11347c.postDelayed(new f(this, str), 300L);
            return true;
        }
        return invokeL.booleanValue;
    }
}

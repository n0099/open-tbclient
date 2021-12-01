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
import c.a.p0.a.k;
import c.a.p0.j.v.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f10367b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f10368c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f10369d;

    /* renamed from: e  reason: collision with root package name */
    public Button f10370e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10371f;

    /* renamed from: g  reason: collision with root package name */
    public a.f f10372g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.j.v.c f10373h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f10374i;

    /* renamed from: j  reason: collision with root package name */
    public TextWatcher f10375j;

    /* renamed from: k  reason: collision with root package name */
    public TextView.OnEditorActionListener f10376k;

    /* renamed from: c.a.p0.j.p0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC0672a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10377e;

        public View$OnClickListenerC0672a(a aVar) {
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
            this.f10377e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f10377e.f10368c != null && this.f10377e.f10371f) {
                if (this.f10377e.f10372g != null) {
                    this.f10377e.f10372g.c(this.f10377e.f10368c.getText().toString());
                }
                if (this.f10377e.f10373h == null || this.f10377e.f10373h.f10486d || this.f10377e.f10372g == null) {
                    return;
                }
                this.f10377e.f10372g.a();
                this.f10377e.m("");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10378e;

        /* renamed from: c.a.p0.j.p0.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0673a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Editable f10379e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f10380f;

            public RunnableC0673a(b bVar, Editable editable) {
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
                this.f10380f = bVar;
                this.f10379e = editable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (TextUtils.isEmpty(this.f10379e.toString())) {
                        this.f10380f.f10378e.f10370e.setEnabled(false);
                    } else if (this.f10380f.f10378e.f10370e.isEnabled()) {
                    } else {
                        this.f10380f.f10378e.f10370e.setEnabled(true);
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
            this.f10378e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (this.f10378e.f10372g != null) {
                    this.f10378e.f10372g.e(editable.toString());
                }
                this.f10378e.f10370e.post(new RunnableC0673a(this, editable));
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

    /* loaded from: classes5.dex */
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
                if (this.a.f10373h == null || this.a.f10373h.f10487e != i2 || this.a.f10368c == null || !this.a.f10371f) {
                    return false;
                }
                if (this.a.f10372g != null) {
                    this.a.f10372g.c(this.a.f10368c.getText().toString());
                }
                if (this.a.f10373h.f10486d || this.a.f10372g == null) {
                    return true;
                }
                this.a.f10372g.a();
                this.a.m("");
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10381e;

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
            this.f10381e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10381e.f10370e.setEnabled(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.j.v.c f10382e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10383f;

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
            this.f10383f = aVar;
            this.f10382e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f10383f.f10368c.getText().length() <= this.f10382e.a.length()) {
                        length = this.f10383f.f10368c.getText().length();
                    } else {
                        length = this.f10382e.a.length();
                    }
                    this.f10383f.f10368c.setSelection(length);
                } catch (Exception e2) {
                    if (k.a) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10384e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10385f;

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
            this.f10385f = aVar;
            this.f10384e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10385f.f10368c.setSelection(this.f10384e.length());
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
        this.f10371f = false;
        this.f10374i = new View$OnClickListenerC0672a(this);
        this.f10375j = new b(this);
        this.f10376k = new c(this);
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(c.a.p0.h.f.aiapps_ai_games_input_view, (ViewGroup) null);
        this.a = relativeLayout;
        this.f10367b = (EditText) relativeLayout.findViewById(c.a.p0.h.e.ai_games_virtual_input_et);
        this.f10369d = (RelativeLayout) this.a.findViewById(c.a.p0.h.e.ai_games_real_input_container);
        this.f10368c = (EditText) this.a.findViewById(c.a.p0.h.e.ai_games_real_input_et);
        Button button = (Button) this.a.findViewById(c.a.p0.h.e.ai_games_input_send_btn);
        this.f10370e = button;
        button.setOnClickListener(this.f10374i);
        this.f10368c.addTextChangedListener(this.f10375j);
        this.f10368c.setOnEditorActionListener(this.f10376k);
        this.f10370e.post(new d(this));
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f10371f : invokeV.booleanValue;
    }

    public void h() {
        EditText editText;
        EditText editText2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
            if (!inputMethodManager.isActive() || (editText = this.f10368c) == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
            this.f10371f = false;
            this.f10367b.setVisibility(8);
            this.f10369d.setVisibility(8);
            a.f fVar = this.f10372g;
            if (fVar == null || (editText2 = this.f10368c) == null) {
                return;
            }
            fVar.d(editText2.getText().toString());
        }
    }

    public void i(a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f10372g = fVar;
        }
    }

    public void j(c.a.p0.j.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f10373h = cVar;
            if (this.f10368c == null || cVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(cVar.a)) {
                this.f10368c.setText(cVar.a);
                if (cVar.f10484b > 0) {
                    if (!TextUtils.isEmpty(cVar.a) && cVar.a.length() > cVar.f10484b) {
                        cVar.f10484b = cVar.a.length();
                    }
                    this.f10368c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.f10484b)});
                }
                this.f10368c.postDelayed(new e(this, cVar), 300L);
            } else {
                this.f10368c.setText("");
            }
            this.f10370e.setEnabled(!TextUtils.isEmpty(cVar.a));
            if (cVar.f10485c) {
                this.f10368c.setMinLines(1);
                this.f10368c.setInputType(131073);
                this.f10370e.setText(cVar.f10488f);
                return;
            }
            this.f10368c.setMaxLines(1);
            this.f10368c.setInputType(1);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f10369d.setVisibility(0);
            this.f10368c.setFocusableInTouchMode(true);
            this.f10368c.requestFocus();
            this.f10367b.setVisibility(8);
            this.f10371f = true;
            a.f fVar = this.f10372g;
            if (fVar != null) {
                fVar.b(i2);
            }
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f10371f) {
                return false;
            }
            this.f10367b.setVisibility(0);
            this.f10369d.setVisibility(8);
            this.f10367b.setFocusableInTouchMode(true);
            this.f10367b.requestFocus();
            ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.f10367b, 0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (!this.f10371f || (editText = this.f10368c) == null) {
                return false;
            }
            editText.setText(str);
            this.f10368c.postDelayed(new f(this, str), 300L);
            return true;
        }
        return invokeL.booleanValue;
    }
}

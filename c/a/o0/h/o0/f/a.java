package c.a.o0.h.o0.f;

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
import c.a.o0.a.k;
import c.a.o0.h.u.a;
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
    public RelativeLayout f11399a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f11400b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f11401c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f11402d;

    /* renamed from: e  reason: collision with root package name */
    public Button f11403e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11404f;

    /* renamed from: g  reason: collision with root package name */
    public a.f f11405g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.o0.h.u.c f11406h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f11407i;

    /* renamed from: j  reason: collision with root package name */
    public TextWatcher f11408j;
    public TextView.OnEditorActionListener k;

    /* renamed from: c.a.o0.h.o0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0584a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11409e;

        public View$OnClickListenerC0584a(a aVar) {
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
            this.f11409e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f11409e.f11401c != null && this.f11409e.f11404f) {
                if (this.f11409e.f11405g != null) {
                    this.f11409e.f11405g.c(this.f11409e.f11401c.getText().toString());
                }
                if (this.f11409e.f11406h == null || this.f11409e.f11406h.f11539d || this.f11409e.f11405g == null) {
                    return;
                }
                this.f11409e.f11405g.a();
                this.f11409e.m("");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11410e;

        /* renamed from: c.a.o0.h.o0.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0585a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Editable f11411e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f11412f;

            public RunnableC0585a(b bVar, Editable editable) {
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
                this.f11412f = bVar;
                this.f11411e = editable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (TextUtils.isEmpty(this.f11411e.toString())) {
                        this.f11412f.f11410e.f11403e.setEnabled(false);
                    } else if (this.f11412f.f11410e.f11403e.isEnabled()) {
                    } else {
                        this.f11412f.f11410e.f11403e.setEnabled(true);
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
            this.f11410e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (this.f11410e.f11405g != null) {
                    this.f11410e.f11405g.e(editable.toString());
                }
                this.f11410e.f11403e.post(new RunnableC0585a(this, editable));
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
        public final /* synthetic */ a f11413a;

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
            this.f11413a = aVar;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (this.f11413a.f11406h == null || this.f11413a.f11406h.f11540e != i2 || this.f11413a.f11401c == null || !this.f11413a.f11404f) {
                    return false;
                }
                if (this.f11413a.f11405g != null) {
                    this.f11413a.f11405g.c(this.f11413a.f11401c.getText().toString());
                }
                if (this.f11413a.f11406h.f11539d || this.f11413a.f11405g == null) {
                    return true;
                }
                this.f11413a.f11405g.a();
                this.f11413a.m("");
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
        public final /* synthetic */ a f11414e;

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
            this.f11414e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11414e.f11403e.setEnabled(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.h.u.c f11415e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11416f;

        public e(a aVar, c.a.o0.h.u.c cVar) {
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
            this.f11416f = aVar;
            this.f11415e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f11416f.f11401c.getText().length() <= this.f11415e.f11536a.length()) {
                        length = this.f11416f.f11401c.getText().length();
                    } else {
                        length = this.f11415e.f11536a.length();
                    }
                    this.f11416f.f11401c.setSelection(length);
                } catch (Exception e2) {
                    if (k.f7049a) {
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
        public final /* synthetic */ String f11417e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11418f;

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
            this.f11418f = aVar;
            this.f11417e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11418f.f11401c.setSelection(this.f11417e.length());
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
        this.f11404f = false;
        this.f11407i = new View$OnClickListenerC0584a(this);
        this.f11408j = new b(this);
        this.k = new c(this);
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(c.a.o0.f.f.aiapps_ai_games_input_view, (ViewGroup) null);
        this.f11399a = relativeLayout;
        this.f11400b = (EditText) relativeLayout.findViewById(c.a.o0.f.e.ai_games_virtual_input_et);
        this.f11402d = (RelativeLayout) this.f11399a.findViewById(c.a.o0.f.e.ai_games_real_input_container);
        this.f11401c = (EditText) this.f11399a.findViewById(c.a.o0.f.e.ai_games_real_input_et);
        Button button = (Button) this.f11399a.findViewById(c.a.o0.f.e.ai_games_input_send_btn);
        this.f11403e = button;
        button.setOnClickListener(this.f11407i);
        this.f11401c.addTextChangedListener(this.f11408j);
        this.f11401c.setOnEditorActionListener(this.k);
        this.f11403e.post(new d(this));
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11399a : (View) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11404f : invokeV.booleanValue;
    }

    public void h() {
        EditText editText;
        EditText editText2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
            if (!inputMethodManager.isActive() || (editText = this.f11401c) == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
            this.f11404f = false;
            this.f11400b.setVisibility(8);
            this.f11402d.setVisibility(8);
            a.f fVar = this.f11405g;
            if (fVar == null || (editText2 = this.f11401c) == null) {
                return;
            }
            fVar.d(editText2.getText().toString());
        }
    }

    public void i(a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f11405g = fVar;
        }
    }

    public void j(c.a.o0.h.u.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f11406h = cVar;
            if (this.f11401c == null || cVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(cVar.f11536a)) {
                this.f11401c.setText(cVar.f11536a);
                if (cVar.f11537b > 0) {
                    if (!TextUtils.isEmpty(cVar.f11536a) && cVar.f11536a.length() > cVar.f11537b) {
                        cVar.f11537b = cVar.f11536a.length();
                    }
                    this.f11401c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.f11537b)});
                }
                this.f11401c.postDelayed(new e(this, cVar), 300L);
            } else {
                this.f11401c.setText("");
            }
            this.f11403e.setEnabled(!TextUtils.isEmpty(cVar.f11536a));
            if (cVar.f11538c) {
                this.f11401c.setMinLines(1);
                this.f11401c.setInputType(131073);
                this.f11403e.setText(cVar.f11541f);
                return;
            }
            this.f11401c.setMaxLines(1);
            this.f11401c.setInputType(1);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f11402d.setVisibility(0);
            this.f11401c.setFocusableInTouchMode(true);
            this.f11401c.requestFocus();
            this.f11400b.setVisibility(8);
            this.f11404f = true;
            a.f fVar = this.f11405g;
            if (fVar != null) {
                fVar.b(i2);
            }
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f11404f) {
                return false;
            }
            this.f11400b.setVisibility(0);
            this.f11402d.setVisibility(8);
            this.f11400b.setFocusableInTouchMode(true);
            this.f11400b.requestFocus();
            ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.f11400b, 0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (!this.f11404f || (editText = this.f11401c) == null) {
                return false;
            }
            editText.setText(str);
            this.f11401c.postDelayed(new f(this, str), 300L);
            return true;
        }
        return invokeL.booleanValue;
    }
}

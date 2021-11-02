package b.a.r0.x0.a2.f;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.r0.d4.i;
import b.a.r0.x0.b1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.h1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f25489a;

    /* renamed from: b  reason: collision with root package name */
    public View f25490b;

    /* renamed from: c  reason: collision with root package name */
    public View f25491c;

    /* renamed from: d  reason: collision with root package name */
    public View f25492d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f25493e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25494f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25495g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f25496h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f25497i;
    public SpanGroupEditText j;
    public View.OnClickListener k;
    public e l;
    public boolean m;

    /* loaded from: classes5.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25498e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25498e = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                b.a.r0.x0.a2.f.a.V(this.f25498e.f25493e, editable.toString().length(), 30);
                if (this.f25498e.l != null) {
                    this.f25498e.l.a();
                }
                if (this.f25498e.m) {
                    b.a.q0.s.u.c.d(this.f25498e.f25497i).v(b1.CAM_X0105);
                    b.a.q0.s.u.c.d(this.f25498e.j).v(b1.CAM_X0105);
                    this.f25498e.m = false;
                }
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

    /* renamed from: b.a.r0.x0.a2.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1254b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25499e;

        /* renamed from: b.a.r0.x0.a2.f.b$b$a */
        /* loaded from: classes5.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(C1254b c1254b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1254b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                    if (motionEvent.getAction() == 0) {
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                    } else if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    } else if (motionEvent.getAction() == 3) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    return false;
                }
                return invokeLL.booleanValue;
            }
        }

        public C1254b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25499e = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                b.a.r0.x0.a2.f.a.V(this.f25499e.f25495g, editable.toString().length(), 1000);
                if (this.f25499e.l != null) {
                    this.f25499e.l.a();
                }
                if (this.f25499e.m) {
                    b.a.q0.s.u.c.d(this.f25499e.f25497i).v(b1.CAM_X0105);
                    b.a.q0.s.u.c.d(this.f25499e.j).v(b1.CAM_X0105);
                    this.f25499e.m = false;
                }
                if (this.f25499e.j.getLineCount() > 6) {
                    this.f25499e.j.setOnTouchListener(new a(this));
                } else {
                    this.f25499e.j.setOnTouchListener(null);
                }
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
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25500e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25500e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                l.K(this.f25500e.f25489a, this.f25500e.f25497i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25501e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25501e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                l.K(this.f25501e.f25489a, this.f25501e.j);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a();
    }

    public b(Context context) {
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
        this.f25489a = context;
        n();
    }

    public final String i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? b.a.r0.x0.a2.e.a.d(i2 + 1) : (String) invokeI.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f25490b == null) {
            return;
        }
        b.a.q0.s.u.c.d(this.f25491c).f(b1.CAM_X0204);
        b.a.q0.s.u.c.d(this.f25492d).f(b1.CAM_X0210);
        b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.f25494f);
        d2.v(b1.CAM_X0107);
        d2.A(h1.F_X02);
        b.a.q0.s.u.c.d(this.f25493e).v(b1.CAM_X0111);
        this.f25496h.setImageDrawable(WebPManager.getPureDrawable(d1.icon_pure_edit_delete16, SkinManager.getColor(b1.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.j.setHintTextColor(SkinManager.getColor(b1.CAM_X0111));
        this.j.setTextColor(SkinManager.getColor(b1.CAM_X0105));
        this.f25497i.setTextColor(SkinManager.getColor(b1.CAM_X0105));
        this.f25497i.setHintTextColor(SkinManager.getColor(b1.CAM_X0111));
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            i.o(this.f25497i, d1.edittext_cursor);
            i.o(this.j, d1.edittext_cursor);
            return;
        }
        i.o(this.f25497i, d1.edittext_cursor_1);
        i.o(this.j, d1.edittext_cursor_1);
    }

    public SpanGroupEditText k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : (SpanGroupEditText) invokeV.objValue;
    }

    public EditText l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f25497i : (EditText) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f25490b : (View) invokeV.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View inflate = LayoutInflater.from(this.f25489a).inflate(f1.forum_rule_edit_item, (ViewGroup) null);
            this.f25490b = inflate;
            this.f25491c = inflate.findViewById(e1.item_divider);
            this.f25494f = (TextView) this.f25490b.findViewById(e1.item_title_index);
            this.f25496h = (ImageView) this.f25490b.findViewById(e1.item_del);
            this.f25497i = (EditText) this.f25490b.findViewById(e1.item_title);
            this.f25493e = (TextView) this.f25490b.findViewById(e1.item_title_number);
            this.f25492d = this.f25490b.findViewById(e1.titile_divider);
            this.j = (SpanGroupEditText) this.f25490b.findViewById(e1.item_content);
            this.f25495g = (TextView) this.f25490b.findViewById(e1.item_content_number);
            b.a.r0.x0.a2.f.a.V(this.f25493e, 0, 30);
            b.a.r0.x0.a2.f.a.V(this.f25495g, 0, 1000);
            this.f25497i.addTextChangedListener(new a(this));
            this.j.addTextChangedListener(new C1254b(this));
            this.f25497i.setOnClickListener(new c(this));
            this.j.setOnClickListener(new d(this));
            j();
        }
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.k = onClickListener;
            this.f25496h.setOnClickListener(onClickListener);
        }
    }

    public void p(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.l = eVar;
        }
    }

    public void q(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (imageView = this.f25496h) == null) {
            return;
        }
        if (z) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.m = z;
        }
    }

    public void s(int i2) {
        EditText editText;
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (editText = this.f25497i) == null || (context = this.f25489a) == null) {
            return;
        }
        editText.setHint(String.format(context.getString(h1.forum_rule_item_title_hint), i(i2)));
    }

    public void t(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (textView = this.f25494f) == null) {
            return;
        }
        textView.setText(String.format(this.f25489a.getString(h1.forum_rule_title_index), i(i2)));
    }
}

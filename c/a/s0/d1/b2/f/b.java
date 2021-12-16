package c.a.s0.d1.b2.f;

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
import c.a.d.f.p.m;
import c.a.s0.d1.c1;
import c.a.s0.d1.e1;
import c.a.s0.d1.f1;
import c.a.s0.d1.g1;
import c.a.s0.d1.i1;
import c.a.s0.n4.s;
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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f15678b;

    /* renamed from: c  reason: collision with root package name */
    public View f15679c;

    /* renamed from: d  reason: collision with root package name */
    public View f15680d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f15681e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15682f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15683g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f15684h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f15685i;

    /* renamed from: j  reason: collision with root package name */
    public SpanGroupEditText f15686j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f15687k;
    public e l;
    public boolean m;

    /* loaded from: classes7.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15688e;

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
            this.f15688e = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                c.a.s0.d1.b2.f.a.V(this.f15688e.f15681e, editable.toString().length(), 30);
                if (this.f15688e.l != null) {
                    this.f15688e.l.a();
                }
                if (this.f15688e.m) {
                    c.a.r0.s.v.c.d(this.f15688e.f15685i).v(c1.CAM_X0105);
                    c.a.r0.s.v.c.d(this.f15688e.f15686j).v(c1.CAM_X0105);
                    this.f15688e.m = false;
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

    /* renamed from: c.a.s0.d1.b2.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0972b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15689e;

        /* renamed from: c.a.s0.d1.b2.f.b$b$a */
        /* loaded from: classes7.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(C0972b c0972b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0972b};
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

        public C0972b(b bVar) {
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
            this.f15689e = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                c.a.s0.d1.b2.f.a.V(this.f15689e.f15683g, editable.toString().length(), 1000);
                if (this.f15689e.l != null) {
                    this.f15689e.l.a();
                }
                if (this.f15689e.m) {
                    c.a.r0.s.v.c.d(this.f15689e.f15685i).v(c1.CAM_X0105);
                    c.a.r0.s.v.c.d(this.f15689e.f15686j).v(c1.CAM_X0105);
                    this.f15689e.m = false;
                }
                if (this.f15689e.f15686j.getLineCount() > 6) {
                    this.f15689e.f15686j.setOnTouchListener(new a(this));
                } else {
                    this.f15689e.f15686j.setOnTouchListener(null);
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

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15690e;

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
            this.f15690e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                m.K(this.f15690e.a, this.f15690e.f15685i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15691e;

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
            this.f15691e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                m.K(this.f15691e.a, this.f15691e.f15686j);
            }
        }
    }

    /* loaded from: classes7.dex */
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
        this.a = context;
        n();
    }

    public final String i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? c.a.s0.d1.b2.e.a.d(i2 + 1) : (String) invokeI.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f15678b == null) {
            return;
        }
        c.a.r0.s.v.c.d(this.f15679c).f(c1.CAM_X0204);
        c.a.r0.s.v.c.d(this.f15680d).f(c1.CAM_X0210);
        c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(this.f15682f);
        d2.v(c1.CAM_X0107);
        d2.A(i1.F_X02);
        c.a.r0.s.v.c.d(this.f15681e).v(c1.CAM_X0111);
        this.f15684h.setImageDrawable(WebPManager.getPureDrawable(e1.icon_pure_edit_delete16, SkinManager.getColor(c1.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f15686j.setHintTextColor(SkinManager.getColor(c1.CAM_X0111));
        this.f15686j.setTextColor(SkinManager.getColor(c1.CAM_X0105));
        this.f15685i.setTextColor(SkinManager.getColor(c1.CAM_X0105));
        this.f15685i.setHintTextColor(SkinManager.getColor(c1.CAM_X0111));
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            s.n(this.f15685i, e1.edittext_cursor);
            s.n(this.f15686j, e1.edittext_cursor);
            return;
        }
        s.n(this.f15685i, e1.edittext_cursor_1);
        s.n(this.f15686j, e1.edittext_cursor_1);
    }

    public SpanGroupEditText k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15686j : (SpanGroupEditText) invokeV.objValue;
    }

    public EditText l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15685i : (EditText) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15678b : (View) invokeV.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(g1.forum_rule_edit_item, (ViewGroup) null);
            this.f15678b = inflate;
            this.f15679c = inflate.findViewById(f1.item_divider);
            this.f15682f = (TextView) this.f15678b.findViewById(f1.item_title_index);
            this.f15684h = (ImageView) this.f15678b.findViewById(f1.item_del);
            this.f15685i = (EditText) this.f15678b.findViewById(f1.item_title);
            this.f15681e = (TextView) this.f15678b.findViewById(f1.item_title_number);
            this.f15680d = this.f15678b.findViewById(f1.titile_divider);
            this.f15686j = (SpanGroupEditText) this.f15678b.findViewById(f1.item_content);
            this.f15683g = (TextView) this.f15678b.findViewById(f1.item_content_number);
            c.a.s0.d1.b2.f.a.V(this.f15681e, 0, 30);
            c.a.s0.d1.b2.f.a.V(this.f15683g, 0, 1000);
            this.f15685i.addTextChangedListener(new a(this));
            this.f15686j.addTextChangedListener(new C0972b(this));
            this.f15685i.setOnClickListener(new c(this));
            this.f15686j.setOnClickListener(new d(this));
            j();
        }
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.f15687k = onClickListener;
            this.f15684h.setOnClickListener(onClickListener);
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
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (imageView = this.f15684h) == null) {
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
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (editText = this.f15685i) == null || (context = this.a) == null) {
            return;
        }
        editText.setHint(String.format(context.getString(i1.forum_rule_item_title_hint), i(i2)));
    }

    public void t(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (textView = this.f15682f) == null) {
            return;
        }
        textView.setText(String.format(this.a.getString(i1.forum_rule_title_index), i(i2)));
    }
}

package c.a.t0.d1.b2.f;

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
import c.a.d.f.p.n;
import c.a.t0.d1.c1;
import c.a.t0.d1.e1;
import c.a.t0.d1.f1;
import c.a.t0.d1.g1;
import c.a.t0.d1.i1;
import c.a.t0.o4.s;
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
    public View f16173b;

    /* renamed from: c  reason: collision with root package name */
    public View f16174c;

    /* renamed from: d  reason: collision with root package name */
    public View f16175d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16176e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16177f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16178g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f16179h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f16180i;

    /* renamed from: j  reason: collision with root package name */
    public SpanGroupEditText f16181j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f16182k;
    public e l;
    public boolean m;

    /* loaded from: classes7.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16183e;

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
            this.f16183e = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                c.a.t0.d1.b2.f.a.O(this.f16183e.f16176e, editable.toString().length(), 30);
                if (this.f16183e.l != null) {
                    this.f16183e.l.a();
                }
                if (this.f16183e.m) {
                    c.a.s0.s.u.c.d(this.f16183e.f16180i).v(c1.CAM_X0105);
                    c.a.s0.s.u.c.d(this.f16183e.f16181j).v(c1.CAM_X0105);
                    this.f16183e.m = false;
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

    /* renamed from: c.a.t0.d1.b2.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0999b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16184e;

        /* renamed from: c.a.t0.d1.b2.f.b$b$a */
        /* loaded from: classes7.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(C0999b c0999b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0999b};
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

        public C0999b(b bVar) {
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
            this.f16184e = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                c.a.t0.d1.b2.f.a.O(this.f16184e.f16178g, editable.toString().length(), 1000);
                if (this.f16184e.l != null) {
                    this.f16184e.l.a();
                }
                if (this.f16184e.m) {
                    c.a.s0.s.u.c.d(this.f16184e.f16180i).v(c1.CAM_X0105);
                    c.a.s0.s.u.c.d(this.f16184e.f16181j).v(c1.CAM_X0105);
                    this.f16184e.m = false;
                }
                if (this.f16184e.f16181j.getLineCount() > 6) {
                    this.f16184e.f16181j.setOnTouchListener(new a(this));
                } else {
                    this.f16184e.f16181j.setOnTouchListener(null);
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
        public final /* synthetic */ b f16185e;

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
            this.f16185e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                n.K(this.f16185e.a, this.f16185e.f16180i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16186e;

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
            this.f16186e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                n.K(this.f16186e.a, this.f16186e.f16181j);
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? c.a.t0.d1.b2.e.a.d(i2 + 1) : (String) invokeI.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f16173b == null) {
            return;
        }
        c.a.s0.s.u.c.d(this.f16174c).f(c1.CAM_X0204);
        c.a.s0.s.u.c.d(this.f16175d).f(c1.CAM_X0210);
        c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.f16177f);
        d2.v(c1.CAM_X0107);
        d2.A(i1.F_X02);
        c.a.s0.s.u.c.d(this.f16176e).v(c1.CAM_X0111);
        this.f16179h.setImageDrawable(WebPManager.getPureDrawable(e1.icon_pure_edit_delete16, SkinManager.getColor(c1.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f16181j.setHintTextColor(SkinManager.getColor(c1.CAM_X0111));
        this.f16181j.setTextColor(SkinManager.getColor(c1.CAM_X0105));
        this.f16180i.setTextColor(SkinManager.getColor(c1.CAM_X0105));
        this.f16180i.setHintTextColor(SkinManager.getColor(c1.CAM_X0111));
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            s.n(this.f16180i, e1.edittext_cursor);
            s.n(this.f16181j, e1.edittext_cursor);
            return;
        }
        s.n(this.f16180i, e1.edittext_cursor_1);
        s.n(this.f16181j, e1.edittext_cursor_1);
    }

    public SpanGroupEditText k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16181j : (SpanGroupEditText) invokeV.objValue;
    }

    public EditText l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16180i : (EditText) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16173b : (View) invokeV.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(g1.forum_rule_edit_item, (ViewGroup) null);
            this.f16173b = inflate;
            this.f16174c = inflate.findViewById(f1.item_divider);
            this.f16177f = (TextView) this.f16173b.findViewById(f1.item_title_index);
            this.f16179h = (ImageView) this.f16173b.findViewById(f1.item_del);
            this.f16180i = (EditText) this.f16173b.findViewById(f1.item_title);
            this.f16176e = (TextView) this.f16173b.findViewById(f1.item_title_number);
            this.f16175d = this.f16173b.findViewById(f1.titile_divider);
            this.f16181j = (SpanGroupEditText) this.f16173b.findViewById(f1.item_content);
            this.f16178g = (TextView) this.f16173b.findViewById(f1.item_content_number);
            c.a.t0.d1.b2.f.a.O(this.f16176e, 0, 30);
            c.a.t0.d1.b2.f.a.O(this.f16178g, 0, 1000);
            this.f16180i.addTextChangedListener(new a(this));
            this.f16181j.addTextChangedListener(new C0999b(this));
            this.f16180i.setOnClickListener(new c(this));
            this.f16181j.setOnClickListener(new d(this));
            j();
        }
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.f16182k = onClickListener;
            this.f16179h.setOnClickListener(onClickListener);
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
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (imageView = this.f16179h) == null) {
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
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (editText = this.f16180i) == null || (context = this.a) == null) {
            return;
        }
        editText.setHint(String.format(context.getString(i1.forum_rule_item_title_hint), i(i2)));
    }

    public void t(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (textView = this.f16177f) == null) {
            return;
        }
        textView.setText(String.format(this.a.getString(i1.forum_rule_title_index), i(i2)));
    }
}

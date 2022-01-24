package c.a.t0.e1.c2.f;

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
import c.a.t0.e1.c1;
import c.a.t0.e1.e1;
import c.a.t0.e1.f1;
import c.a.t0.e1.g1;
import c.a.t0.e1.i1;
import c.a.t0.p4.s;
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
    public View f16224b;

    /* renamed from: c  reason: collision with root package name */
    public View f16225c;

    /* renamed from: d  reason: collision with root package name */
    public View f16226d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16227e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16228f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16229g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f16230h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f16231i;

    /* renamed from: j  reason: collision with root package name */
    public SpanGroupEditText f16232j;
    public View.OnClickListener k;
    public e l;
    public boolean m;

    /* loaded from: classes7.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16233e;

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
            this.f16233e = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                c.a.t0.e1.c2.f.a.O(this.f16233e.f16227e, editable.toString().length(), 30);
                if (this.f16233e.l != null) {
                    this.f16233e.l.a();
                }
                if (this.f16233e.m) {
                    c.a.s0.s.u.c.d(this.f16233e.f16231i).v(c1.CAM_X0105);
                    c.a.s0.s.u.c.d(this.f16233e.f16232j).v(c1.CAM_X0105);
                    this.f16233e.m = false;
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

    /* renamed from: c.a.t0.e1.c2.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1036b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16234e;

        /* renamed from: c.a.t0.e1.c2.f.b$b$a */
        /* loaded from: classes7.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(C1036b c1036b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1036b};
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

        public C1036b(b bVar) {
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
            this.f16234e = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                c.a.t0.e1.c2.f.a.O(this.f16234e.f16229g, editable.toString().length(), 1000);
                if (this.f16234e.l != null) {
                    this.f16234e.l.a();
                }
                if (this.f16234e.m) {
                    c.a.s0.s.u.c.d(this.f16234e.f16231i).v(c1.CAM_X0105);
                    c.a.s0.s.u.c.d(this.f16234e.f16232j).v(c1.CAM_X0105);
                    this.f16234e.m = false;
                }
                if (this.f16234e.f16232j.getLineCount() > 6) {
                    this.f16234e.f16232j.setOnTouchListener(new a(this));
                } else {
                    this.f16234e.f16232j.setOnTouchListener(null);
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
        public final /* synthetic */ b f16235e;

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
            this.f16235e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                n.L(this.f16235e.a, this.f16235e.f16231i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16236e;

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
            this.f16236e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                n.L(this.f16236e.a, this.f16236e.f16232j);
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? c.a.t0.e1.c2.e.a.d(i2 + 1) : (String) invokeI.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f16224b == null) {
            return;
        }
        c.a.s0.s.u.c.d(this.f16225c).f(c1.CAM_X0204);
        c.a.s0.s.u.c.d(this.f16226d).f(c1.CAM_X0210);
        c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.f16228f);
        d2.v(c1.CAM_X0107);
        d2.A(i1.F_X02);
        c.a.s0.s.u.c.d(this.f16227e).v(c1.CAM_X0111);
        this.f16230h.setImageDrawable(WebPManager.getPureDrawable(e1.icon_pure_edit_delete16, SkinManager.getColor(c1.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f16232j.setHintTextColor(SkinManager.getColor(c1.CAM_X0111));
        this.f16232j.setTextColor(SkinManager.getColor(c1.CAM_X0105));
        this.f16231i.setTextColor(SkinManager.getColor(c1.CAM_X0105));
        this.f16231i.setHintTextColor(SkinManager.getColor(c1.CAM_X0111));
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            s.l(this.f16231i, e1.edittext_cursor);
            s.l(this.f16232j, e1.edittext_cursor);
            return;
        }
        s.l(this.f16231i, e1.edittext_cursor_1);
        s.l(this.f16232j, e1.edittext_cursor_1);
    }

    public SpanGroupEditText k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16232j : (SpanGroupEditText) invokeV.objValue;
    }

    public EditText l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16231i : (EditText) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16224b : (View) invokeV.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(g1.forum_rule_edit_item, (ViewGroup) null);
            this.f16224b = inflate;
            this.f16225c = inflate.findViewById(f1.item_divider);
            this.f16228f = (TextView) this.f16224b.findViewById(f1.item_title_index);
            this.f16230h = (ImageView) this.f16224b.findViewById(f1.item_del);
            this.f16231i = (EditText) this.f16224b.findViewById(f1.item_title);
            this.f16227e = (TextView) this.f16224b.findViewById(f1.item_title_number);
            this.f16226d = this.f16224b.findViewById(f1.titile_divider);
            this.f16232j = (SpanGroupEditText) this.f16224b.findViewById(f1.item_content);
            this.f16229g = (TextView) this.f16224b.findViewById(f1.item_content_number);
            c.a.t0.e1.c2.f.a.O(this.f16227e, 0, 30);
            c.a.t0.e1.c2.f.a.O(this.f16229g, 0, 1000);
            this.f16231i.addTextChangedListener(new a(this));
            this.f16232j.addTextChangedListener(new C1036b(this));
            this.f16231i.setOnClickListener(new c(this));
            this.f16232j.setOnClickListener(new d(this));
            j();
        }
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.k = onClickListener;
            this.f16230h.setOnClickListener(onClickListener);
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
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (imageView = this.f16230h) == null) {
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
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (editText = this.f16231i) == null || (context = this.a) == null) {
            return;
        }
        editText.setHint(String.format(context.getString(i1.forum_rule_item_title_hint), i(i2)));
    }

    public void t(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (textView = this.f16228f) == null) {
            return;
        }
        textView.setText(String.format(this.a.getString(i1.forum_rule_title_index), i(i2)));
    }
}

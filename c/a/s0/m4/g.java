package c.a.s0.m4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f19639b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f19640c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19641d;

    /* renamed from: e  reason: collision with root package name */
    public View f19642e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19643f;

    /* renamed from: g  reason: collision with root package name */
    public String f19644g;

    /* renamed from: h  reason: collision with root package name */
    public List<c> f19645h;

    /* renamed from: i  reason: collision with root package name */
    public f f19646i;

    /* renamed from: j  reason: collision with root package name */
    public d f19647j;

    /* renamed from: k  reason: collision with root package name */
    public InterfaceC1183g f19648k;
    public RadioButton l;
    public RadioButton m;
    public RadioButton n;
    public RadioButton o;
    public RadioButton p;
    public LinearLayout q;
    public int r;
    public View.OnClickListener s;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f19649e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19649e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f19649e.l) {
                    this.f19649e.m.setChecked(false);
                    this.f19649e.n.setChecked(false);
                    this.f19649e.o.setChecked(false);
                    this.f19649e.p.setChecked(false);
                    this.f19649e.r = 1;
                } else if (view == this.f19649e.m) {
                    this.f19649e.l.setChecked(true);
                    this.f19649e.n.setChecked(false);
                    this.f19649e.o.setChecked(false);
                    this.f19649e.p.setChecked(false);
                    this.f19649e.r = 2;
                } else if (view == this.f19649e.n) {
                    this.f19649e.l.setChecked(true);
                    this.f19649e.m.setChecked(true);
                    this.f19649e.o.setChecked(false);
                    this.f19649e.p.setChecked(false);
                    this.f19649e.r = 3;
                } else if (view == this.f19649e.o) {
                    this.f19649e.l.setChecked(true);
                    this.f19649e.m.setChecked(true);
                    this.f19649e.n.setChecked(true);
                    this.f19649e.p.setChecked(false);
                    this.f19649e.r = 4;
                } else if (view == this.f19649e.p) {
                    this.f19649e.l.setChecked(true);
                    this.f19649e.m.setChecked(true);
                    this.f19649e.n.setChecked(true);
                    this.f19649e.o.setChecked(true);
                    this.f19649e.r = 5;
                }
                if (this.f19649e.f19648k != null) {
                    this.f19649e.f19648k.onClick(this.f19649e.r);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f19650e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19650e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19650e.f19647j.onClick();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public g f19651b;

        /* renamed from: c  reason: collision with root package name */
        public View f19652c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f19653d;

        /* renamed from: e  reason: collision with root package name */
        public View f19654e;

        /* renamed from: f  reason: collision with root package name */
        public String f19655f;

        /* renamed from: g  reason: collision with root package name */
        public int f19656g;

        /* renamed from: h  reason: collision with root package name */
        public e f19657h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f19658i;

        /* renamed from: j  reason: collision with root package name */
        public final View.OnClickListener f19659j;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f19660e;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19660e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f19660e.f19657h != null) {
                        this.f19660e.f19657h.onClick();
                    }
                    if (this.f19660e.f19651b == null || this.f19660e.f19651b.k() == null) {
                        return;
                    }
                    this.f19660e.f19651b.k().onItemClick(this.f19660e.a);
                }
            }
        }

        public c(String str, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19656g = 17;
            this.f19658i = true;
            this.f19659j = new a(this);
            this.f19655f = str;
            this.f19651b = gVar;
            this.a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19652c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f19653d) == null) {
                return;
            }
            textView.setOnClickListener(this.f19659j);
        }

        public final void f() {
            g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.f19651b) == null || gVar.getContext() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f19651b.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.f19651b.l(), false);
            this.f19652c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f19653d = textView;
            textView.setText(this.f19655f);
            this.f19653d.setGravity(this.f19656g);
            View findViewById = this.f19652c.findViewById(R.id.divider_line);
            this.f19654e = findViewById;
            if (this.f19658i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SkinManager.setBackgroundResource(this.f19653d, R.drawable.bg_bottom_up_list_dialog_item);
                SkinManager.setViewTextColor(this.f19653d, R.color.CAM_X0106);
                SkinManager.setBackgroundColor(this.f19654e, R.color.CAM_X0204);
            }
        }

        public void h(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
                this.f19657h = eVar;
                e();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes7.dex */
    public interface e {
        void onClick();
    }

    /* loaded from: classes7.dex */
    public interface f {
        void onItemClick(int i2);
    }

    /* renamed from: c.a.s0.m4.g$g  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1183g {
        void onClick(int i2);
    }

    public g(Context context) {
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
        this.s = new a(this);
        if (context == null) {
            return;
        }
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
        this.f19639b = inflate;
        this.f19640c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f19641d = (TextView) this.f19639b.findViewById(R.id.title);
        this.f19642e = this.f19639b.findViewById(R.id.title_divide_line);
        this.f19645h = new ArrayList();
        this.f19643f = (TextView) this.f19639b.findViewById(R.id.dialog_bottom_cancel_button);
        RadioButton radioButton = (RadioButton) this.f19639b.findViewById(R.id.comment_grade_1);
        this.l = radioButton;
        radioButton.setOnClickListener(this.s);
        RadioButton radioButton2 = (RadioButton) this.f19639b.findViewById(R.id.comment_grade_2);
        this.m = radioButton2;
        radioButton2.setOnClickListener(this.s);
        RadioButton radioButton3 = (RadioButton) this.f19639b.findViewById(R.id.comment_grade_3);
        this.n = radioButton3;
        radioButton3.setOnClickListener(this.s);
        RadioButton radioButton4 = (RadioButton) this.f19639b.findViewById(R.id.comment_grade_4);
        this.o = radioButton4;
        radioButton4.setOnClickListener(this.s);
        RadioButton radioButton5 = (RadioButton) this.f19639b.findViewById(R.id.comment_grade_5);
        this.p = radioButton5;
        radioButton5.setOnClickListener(this.s);
        this.q = (LinearLayout) this.f19639b.findViewById(R.id.comment_grade);
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (Context) invokeV.objValue;
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!StringUtils.isNull(this.f19644g)) {
                this.f19641d.setText(this.f19644g);
            } else {
                this.f19641d.setVisibility(8);
            }
            if (this.f19647j != null) {
                this.f19643f.setOnClickListener(new b(this));
            }
            m();
            return this.f19639b;
        }
        return (View) invokeV.objValue;
    }

    public f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19646i : (f) invokeV.objValue;
    }

    public ViewGroup l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19640c : (ViewGroup) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundColor(this.f19641d, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f19641d, R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.f19642e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f19643f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f19643f, R.color.CAM_X0106);
            SkinManager.setBackgroundResource(this.q, R.drawable.bg_bottom_up_list_dialog_item);
            List<c> list = this.f19645h;
            if (list != null) {
                for (c cVar : list) {
                    cVar.g();
                }
            }
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f19643f.setVisibility(i2);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.l.setEnabled(z);
            this.m.setEnabled(z);
            this.n.setEnabled(z);
            this.o.setEnabled(z);
            this.p.setEnabled(z);
        }
    }

    public void p(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i2, i3, i4, i5) == null) {
            this.q.setPadding(i2, i3, i4, i5);
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            if (i2 == 1) {
                this.l.setChecked(true);
                this.m.setChecked(false);
                this.n.setChecked(false);
                this.o.setChecked(false);
                this.p.setChecked(false);
            } else if (i2 == 2) {
                this.l.setChecked(true);
                this.m.setChecked(true);
                this.n.setChecked(false);
                this.o.setChecked(false);
                this.p.setChecked(false);
            } else if (i2 == 3) {
                this.l.setChecked(true);
                this.m.setChecked(true);
                this.n.setChecked(true);
                this.o.setChecked(false);
                this.p.setChecked(false);
            } else if (i2 == 4) {
                this.l.setChecked(true);
                this.m.setChecked(true);
                this.n.setChecked(true);
                this.o.setChecked(true);
                this.p.setChecked(false);
            } else if (i2 != 5) {
            } else {
                this.l.setChecked(true);
                this.m.setChecked(true);
                this.n.setChecked(true);
                this.o.setChecked(true);
                this.p.setChecked(true);
            }
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.q.setVisibility(i2);
        }
    }

    public void s(List<c> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, list) == null) || list == null) {
            return;
        }
        this.f19645h = list;
        this.f19640c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar != null) {
                this.f19640c.addView(cVar.d());
            }
        }
    }

    public void t(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.f19647j = dVar;
        }
    }

    public void u(InterfaceC1183g interfaceC1183g) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, interfaceC1183g) == null) {
            this.f19648k = interfaceC1183g;
        }
    }

    public void v(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048589, this, i2, i3, i4, i5) == null) {
            this.f19641d.setPadding(i2, i3, i4, i5);
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f19641d.setTextSize(0, m.f(this.a, i2));
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f19644g = str;
        }
    }
}

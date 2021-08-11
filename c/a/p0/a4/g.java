package c.a.p0.a4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
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
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f15377a;

    /* renamed from: b  reason: collision with root package name */
    public View f15378b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f15379c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15380d;

    /* renamed from: e  reason: collision with root package name */
    public View f15381e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15382f;

    /* renamed from: g  reason: collision with root package name */
    public String f15383g;

    /* renamed from: h  reason: collision with root package name */
    public List<c> f15384h;

    /* renamed from: i  reason: collision with root package name */
    public f f15385i;

    /* renamed from: j  reason: collision with root package name */
    public d f15386j;
    public InterfaceC0728g k;
    public RadioButton l;
    public RadioButton m;
    public RadioButton n;
    public RadioButton o;
    public RadioButton p;
    public LinearLayout q;
    public int r;
    public View.OnClickListener s;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f15387e;

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
            this.f15387e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f15387e.l) {
                    this.f15387e.m.setChecked(false);
                    this.f15387e.n.setChecked(false);
                    this.f15387e.o.setChecked(false);
                    this.f15387e.p.setChecked(false);
                    this.f15387e.r = 1;
                } else if (view == this.f15387e.m) {
                    this.f15387e.l.setChecked(true);
                    this.f15387e.n.setChecked(false);
                    this.f15387e.o.setChecked(false);
                    this.f15387e.p.setChecked(false);
                    this.f15387e.r = 2;
                } else if (view == this.f15387e.n) {
                    this.f15387e.l.setChecked(true);
                    this.f15387e.m.setChecked(true);
                    this.f15387e.o.setChecked(false);
                    this.f15387e.p.setChecked(false);
                    this.f15387e.r = 3;
                } else if (view == this.f15387e.o) {
                    this.f15387e.l.setChecked(true);
                    this.f15387e.m.setChecked(true);
                    this.f15387e.n.setChecked(true);
                    this.f15387e.p.setChecked(false);
                    this.f15387e.r = 4;
                } else if (view == this.f15387e.p) {
                    this.f15387e.l.setChecked(true);
                    this.f15387e.m.setChecked(true);
                    this.f15387e.n.setChecked(true);
                    this.f15387e.o.setChecked(true);
                    this.f15387e.r = 5;
                }
                if (this.f15387e.k != null) {
                    this.f15387e.k.onClick(this.f15387e.r);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f15388e;

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
            this.f15388e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15388e.f15386j.onClick();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f15389a;

        /* renamed from: b  reason: collision with root package name */
        public g f15390b;

        /* renamed from: c  reason: collision with root package name */
        public View f15391c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15392d;

        /* renamed from: e  reason: collision with root package name */
        public View f15393e;

        /* renamed from: f  reason: collision with root package name */
        public String f15394f;

        /* renamed from: g  reason: collision with root package name */
        public int f15395g;

        /* renamed from: h  reason: collision with root package name */
        public e f15396h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f15397i;

        /* renamed from: j  reason: collision with root package name */
        public final View.OnClickListener f15398j;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f15399e;

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
                this.f15399e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f15399e.f15396h != null) {
                        this.f15399e.f15396h.onClick();
                    }
                    if (this.f15399e.f15390b == null || this.f15399e.f15390b.l() == null) {
                        return;
                    }
                    this.f15399e.f15390b.l().onItemClick(this.f15399e.f15389a);
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
            this.f15395g = 17;
            this.f15397i = true;
            this.f15398j = new a(this);
            this.f15394f = str;
            this.f15390b = gVar;
            this.f15389a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15391c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f15392d) == null) {
                return;
            }
            textView.setOnClickListener(this.f15398j);
        }

        public final void f() {
            g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.f15390b) == null || gVar.k() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f15390b.k()).inflate(R.layout.bottom_up_list_dialog_item, this.f15390b.m(), false);
            this.f15391c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f15392d = textView;
            textView.setText(this.f15394f);
            this.f15392d.setGravity(this.f15395g);
            View findViewById = this.f15391c.findViewById(R.id.divider_line);
            this.f15393e = findViewById;
            if (this.f15397i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SkinManager.setBackgroundResource(this.f15392d, R.drawable.bg_bottom_up_list_dialog_item);
                SkinManager.setViewTextColor(this.f15392d, R.color.CAM_X0106);
                SkinManager.setBackgroundColor(this.f15393e, R.color.CAM_X0204);
            }
        }

        public void h(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
                this.f15396h = eVar;
                e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes3.dex */
    public interface e {
        void onClick();
    }

    /* loaded from: classes3.dex */
    public interface f {
        void onItemClick(int i2);
    }

    /* renamed from: c.a.p0.a4.g$g  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0728g {
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
        this.f15377a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
        this.f15378b = inflate;
        this.f15379c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f15380d = (TextView) this.f15378b.findViewById(R.id.title);
        this.f15381e = this.f15378b.findViewById(R.id.title_divide_line);
        this.f15384h = new ArrayList();
        this.f15382f = (TextView) this.f15378b.findViewById(R.id.dialog_bottom_cancel_button);
        RadioButton radioButton = (RadioButton) this.f15378b.findViewById(R.id.comment_grade_1);
        this.l = radioButton;
        radioButton.setOnClickListener(this.s);
        RadioButton radioButton2 = (RadioButton) this.f15378b.findViewById(R.id.comment_grade_2);
        this.m = radioButton2;
        radioButton2.setOnClickListener(this.s);
        RadioButton radioButton3 = (RadioButton) this.f15378b.findViewById(R.id.comment_grade_3);
        this.n = radioButton3;
        radioButton3.setOnClickListener(this.s);
        RadioButton radioButton4 = (RadioButton) this.f15378b.findViewById(R.id.comment_grade_4);
        this.o = radioButton4;
        radioButton4.setOnClickListener(this.s);
        RadioButton radioButton5 = (RadioButton) this.f15378b.findViewById(R.id.comment_grade_5);
        this.p = radioButton5;
        radioButton5.setOnClickListener(this.s);
        this.q = (LinearLayout) this.f15378b.findViewById(R.id.comment_grade);
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.f15383g)) {
                this.f15380d.setText(this.f15383g);
            } else {
                this.f15380d.setVisibility(8);
            }
            if (this.f15386j != null) {
                this.f15382f.setOnClickListener(new b(this));
            }
            n();
            return this.f15378b;
        }
        return (View) invokeV.objValue;
    }

    public Context k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15377a : (Context) invokeV.objValue;
    }

    public f l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15385i : (f) invokeV.objValue;
    }

    public ViewGroup m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15379c : (ViewGroup) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundColor(this.f15380d, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f15380d, R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.f15381e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f15382f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f15382f, R.color.CAM_X0106);
            SkinManager.setBackgroundResource(this.q, R.drawable.bg_bottom_up_list_dialog_item);
            List<c> list = this.f15384h;
            if (list != null) {
                for (c cVar : list) {
                    cVar.g();
                }
            }
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f15382f.setVisibility(i2);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.l.setEnabled(z);
            this.m.setEnabled(z);
            this.n.setEnabled(z);
            this.o.setEnabled(z);
            this.p.setEnabled(z);
        }
    }

    public void q(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i2, i3, i4, i5) == null) {
            this.q.setPadding(i2, i3, i4, i5);
        }
    }

    public void r(int i2) {
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

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.q.setVisibility(i2);
        }
    }

    public void t(List<c> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, list) == null) || list == null) {
            return;
        }
        this.f15384h = list;
        this.f15379c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar != null) {
                this.f15379c.addView(cVar.d());
            }
        }
    }

    public void u(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.f15386j = dVar;
        }
    }

    public void v(InterfaceC0728g interfaceC0728g) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, interfaceC0728g) == null) {
            this.k = interfaceC0728g;
        }
    }

    public void w(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048589, this, i2, i3, i4, i5) == null) {
            this.f15380d.setPadding(i2, i3, i4, i5);
        }
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f15380d.setTextSize(0, l.g(this.f15377a, i2));
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f15383g = str;
        }
    }
}

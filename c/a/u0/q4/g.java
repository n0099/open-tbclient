package c.a.u0.q4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f21500b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f21501c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21502d;

    /* renamed from: e  reason: collision with root package name */
    public View f21503e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21504f;

    /* renamed from: g  reason: collision with root package name */
    public String f21505g;

    /* renamed from: h  reason: collision with root package name */
    public List<c> f21506h;

    /* renamed from: i  reason: collision with root package name */
    public f f21507i;

    /* renamed from: j  reason: collision with root package name */
    public d f21508j;
    public InterfaceC1324g k;
    public RadioButton l;
    public RadioButton m;
    public RadioButton n;
    public RadioButton o;
    public RadioButton p;
    public LinearLayout q;
    public int r;
    public View.OnClickListener s;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f21509e;

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
            this.f21509e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f21509e.l) {
                    this.f21509e.m.setChecked(false);
                    this.f21509e.n.setChecked(false);
                    this.f21509e.o.setChecked(false);
                    this.f21509e.p.setChecked(false);
                    this.f21509e.r = 1;
                } else if (view == this.f21509e.m) {
                    this.f21509e.l.setChecked(true);
                    this.f21509e.n.setChecked(false);
                    this.f21509e.o.setChecked(false);
                    this.f21509e.p.setChecked(false);
                    this.f21509e.r = 2;
                } else if (view == this.f21509e.n) {
                    this.f21509e.l.setChecked(true);
                    this.f21509e.m.setChecked(true);
                    this.f21509e.o.setChecked(false);
                    this.f21509e.p.setChecked(false);
                    this.f21509e.r = 3;
                } else if (view == this.f21509e.o) {
                    this.f21509e.l.setChecked(true);
                    this.f21509e.m.setChecked(true);
                    this.f21509e.n.setChecked(true);
                    this.f21509e.p.setChecked(false);
                    this.f21509e.r = 4;
                } else if (view == this.f21509e.p) {
                    this.f21509e.l.setChecked(true);
                    this.f21509e.m.setChecked(true);
                    this.f21509e.n.setChecked(true);
                    this.f21509e.o.setChecked(true);
                    this.f21509e.r = 5;
                }
                if (this.f21509e.k != null) {
                    this.f21509e.k.onClick(this.f21509e.r);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f21510e;

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
            this.f21510e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21510e.f21508j.onClick();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public g f21511b;

        /* renamed from: c  reason: collision with root package name */
        public View f21512c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f21513d;

        /* renamed from: e  reason: collision with root package name */
        public View f21514e;

        /* renamed from: f  reason: collision with root package name */
        public String f21515f;

        /* renamed from: g  reason: collision with root package name */
        public int f21516g;

        /* renamed from: h  reason: collision with root package name */
        public e f21517h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f21518i;

        /* renamed from: j  reason: collision with root package name */
        public final View.OnClickListener f21519j;

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f21520e;

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
                this.f21520e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f21520e.f21517h != null) {
                        this.f21520e.f21517h.onClick();
                    }
                    if (this.f21520e.f21511b == null || this.f21520e.f21511b.k() == null) {
                        return;
                    }
                    this.f21520e.f21511b.k().onItemClick(this.f21520e.a);
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
            this.f21516g = 17;
            this.f21518i = true;
            this.f21519j = new a(this);
            this.f21515f = str;
            this.f21511b = gVar;
            this.a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21512c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f21513d) == null) {
                return;
            }
            textView.setOnClickListener(this.f21519j);
        }

        public final void f() {
            g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.f21511b) == null || gVar.getContext() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f21511b.getContext()).inflate(c.a.u0.a4.h.bottom_up_list_dialog_item, this.f21511b.l(), false);
            this.f21512c = inflate;
            TextView textView = (TextView) inflate.findViewById(c.a.u0.a4.g.item_view);
            this.f21513d = textView;
            textView.setText(this.f21515f);
            this.f21513d.setGravity(this.f21516g);
            View findViewById = this.f21512c.findViewById(c.a.u0.a4.g.divider_line);
            this.f21514e = findViewById;
            if (this.f21518i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SkinManager.setBackgroundResource(this.f21513d, c.a.u0.a4.f.bg_bottom_up_list_dialog_item);
                SkinManager.setViewTextColor(this.f21513d, c.a.u0.a4.d.CAM_X0106);
                SkinManager.setBackgroundColor(this.f21514e, c.a.u0.a4.d.CAM_X0204);
            }
        }

        public void h(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
                this.f21517h = eVar;
                e();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes8.dex */
    public interface e {
        void onClick();
    }

    /* loaded from: classes8.dex */
    public interface f {
        void onItemClick(int i2);
    }

    /* renamed from: c.a.u0.q4.g$g  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1324g {
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
        View inflate = LayoutInflater.from(context).inflate(c.a.u0.a4.h.rate_list_dialog_view, (ViewGroup) null);
        this.f21500b = inflate;
        this.f21501c = (LinearLayout) inflate.findViewById(c.a.u0.a4.g.content_view);
        this.f21502d = (TextView) this.f21500b.findViewById(c.a.u0.a4.g.title);
        this.f21503e = this.f21500b.findViewById(c.a.u0.a4.g.title_divide_line);
        this.f21506h = new ArrayList();
        this.f21504f = (TextView) this.f21500b.findViewById(c.a.u0.a4.g.dialog_bottom_cancel_button);
        RadioButton radioButton = (RadioButton) this.f21500b.findViewById(c.a.u0.a4.g.comment_grade_1);
        this.l = radioButton;
        radioButton.setOnClickListener(this.s);
        RadioButton radioButton2 = (RadioButton) this.f21500b.findViewById(c.a.u0.a4.g.comment_grade_2);
        this.m = radioButton2;
        radioButton2.setOnClickListener(this.s);
        RadioButton radioButton3 = (RadioButton) this.f21500b.findViewById(c.a.u0.a4.g.comment_grade_3);
        this.n = radioButton3;
        radioButton3.setOnClickListener(this.s);
        RadioButton radioButton4 = (RadioButton) this.f21500b.findViewById(c.a.u0.a4.g.comment_grade_4);
        this.o = radioButton4;
        radioButton4.setOnClickListener(this.s);
        RadioButton radioButton5 = (RadioButton) this.f21500b.findViewById(c.a.u0.a4.g.comment_grade_5);
        this.p = radioButton5;
        radioButton5.setOnClickListener(this.s);
        this.q = (LinearLayout) this.f21500b.findViewById(c.a.u0.a4.g.comment_grade);
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
            if (!StringUtils.isNull(this.f21505g)) {
                this.f21502d.setText(this.f21505g);
            } else {
                this.f21502d.setVisibility(8);
            }
            if (this.f21508j != null) {
                this.f21504f.setOnClickListener(new b(this));
            }
            m();
            return this.f21500b;
        }
        return (View) invokeV.objValue;
    }

    public f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21507i : (f) invokeV.objValue;
    }

    public ViewGroup l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21501c : (ViewGroup) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundColor(this.f21502d, c.a.u0.a4.d.CAM_X0201);
            SkinManager.setViewTextColor(this.f21502d, c.a.u0.a4.d.CAM_X0107);
            SkinManager.setBackgroundColor(this.f21503e, c.a.u0.a4.d.CAM_X0204);
            SkinManager.setBackgroundResource(this.f21504f, c.a.u0.a4.f.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f21504f, c.a.u0.a4.d.CAM_X0106);
            SkinManager.setBackgroundResource(this.q, c.a.u0.a4.f.bg_bottom_up_list_dialog_item);
            List<c> list = this.f21506h;
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
            this.f21504f.setVisibility(i2);
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
        this.f21506h = list;
        this.f21501c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar != null) {
                this.f21501c.addView(cVar.d());
            }
        }
    }

    public void t(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.f21508j = dVar;
        }
    }

    public void u(InterfaceC1324g interfaceC1324g) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, interfaceC1324g) == null) {
            this.k = interfaceC1324g;
        }
    }

    public void v(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048589, this, i2, i3, i4, i5) == null) {
            this.f21502d.setPadding(i2, i3, i4, i5);
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f21502d.setTextSize(0, n.f(this.a, i2));
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f21505g = str;
        }
    }
}

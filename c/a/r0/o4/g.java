package c.a.r0.o4;

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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f20452b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f20453c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f20454d;

    /* renamed from: e  reason: collision with root package name */
    public View f20455e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20456f;

    /* renamed from: g  reason: collision with root package name */
    public String f20457g;

    /* renamed from: h  reason: collision with root package name */
    public List<c> f20458h;

    /* renamed from: i  reason: collision with root package name */
    public f f20459i;

    /* renamed from: j  reason: collision with root package name */
    public d f20460j;
    public InterfaceC1279g k;
    public RadioButton l;
    public RadioButton m;
    public RadioButton n;
    public RadioButton o;
    public RadioButton p;
    public LinearLayout q;
    public int r;
    public View.OnClickListener s;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f20461e;

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
            this.f20461e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f20461e.l) {
                    this.f20461e.m.setChecked(false);
                    this.f20461e.n.setChecked(false);
                    this.f20461e.o.setChecked(false);
                    this.f20461e.p.setChecked(false);
                    this.f20461e.r = 1;
                } else if (view == this.f20461e.m) {
                    this.f20461e.l.setChecked(true);
                    this.f20461e.n.setChecked(false);
                    this.f20461e.o.setChecked(false);
                    this.f20461e.p.setChecked(false);
                    this.f20461e.r = 2;
                } else if (view == this.f20461e.n) {
                    this.f20461e.l.setChecked(true);
                    this.f20461e.m.setChecked(true);
                    this.f20461e.o.setChecked(false);
                    this.f20461e.p.setChecked(false);
                    this.f20461e.r = 3;
                } else if (view == this.f20461e.o) {
                    this.f20461e.l.setChecked(true);
                    this.f20461e.m.setChecked(true);
                    this.f20461e.n.setChecked(true);
                    this.f20461e.p.setChecked(false);
                    this.f20461e.r = 4;
                } else if (view == this.f20461e.p) {
                    this.f20461e.l.setChecked(true);
                    this.f20461e.m.setChecked(true);
                    this.f20461e.n.setChecked(true);
                    this.f20461e.o.setChecked(true);
                    this.f20461e.r = 5;
                }
                if (this.f20461e.k != null) {
                    this.f20461e.k.onClick(this.f20461e.r);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f20462e;

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
            this.f20462e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20462e.f20460j.onClick();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public g f20463b;

        /* renamed from: c  reason: collision with root package name */
        public View f20464c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f20465d;

        /* renamed from: e  reason: collision with root package name */
        public View f20466e;

        /* renamed from: f  reason: collision with root package name */
        public String f20467f;

        /* renamed from: g  reason: collision with root package name */
        public int f20468g;

        /* renamed from: h  reason: collision with root package name */
        public e f20469h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f20470i;

        /* renamed from: j  reason: collision with root package name */
        public final View.OnClickListener f20471j;

        /* loaded from: classes2.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f20472e;

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
                this.f20472e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f20472e.f20469h != null) {
                        this.f20472e.f20469h.onClick();
                    }
                    if (this.f20472e.f20463b == null || this.f20472e.f20463b.k() == null) {
                        return;
                    }
                    this.f20472e.f20463b.k().onItemClick(this.f20472e.a);
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
            this.f20468g = 17;
            this.f20470i = true;
            this.f20471j = new a(this);
            this.f20467f = str;
            this.f20463b = gVar;
            this.a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20464c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f20465d) == null) {
                return;
            }
            textView.setOnClickListener(this.f20471j);
        }

        public final void f() {
            g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.f20463b) == null || gVar.getContext() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f20463b.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.f20463b.l(), false);
            this.f20464c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f20465d = textView;
            textView.setText(this.f20467f);
            this.f20465d.setGravity(this.f20468g);
            View findViewById = this.f20464c.findViewById(R.id.divider_line);
            this.f20466e = findViewById;
            if (this.f20470i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SkinManager.setBackgroundResource(this.f20465d, R.drawable.bg_bottom_up_list_dialog_item);
                SkinManager.setViewTextColor(this.f20465d, (int) R.color.CAM_X0106);
                SkinManager.setBackgroundColor(this.f20466e, R.color.CAM_X0204);
            }
        }

        public void h(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
                this.f20469h = eVar;
                e();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes2.dex */
    public interface e {
        void onClick();
    }

    /* loaded from: classes2.dex */
    public interface f {
        void onItemClick(int i2);
    }

    /* renamed from: c.a.r0.o4.g$g  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC1279g {
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
        this.f20452b = inflate;
        this.f20453c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f20454d = (TextView) this.f20452b.findViewById(R.id.title);
        this.f20455e = this.f20452b.findViewById(R.id.title_divide_line);
        this.f20458h = new ArrayList();
        this.f20456f = (TextView) this.f20452b.findViewById(R.id.dialog_bottom_cancel_button);
        RadioButton radioButton = (RadioButton) this.f20452b.findViewById(R.id.comment_grade_1);
        this.l = radioButton;
        radioButton.setOnClickListener(this.s);
        RadioButton radioButton2 = (RadioButton) this.f20452b.findViewById(R.id.comment_grade_2);
        this.m = radioButton2;
        radioButton2.setOnClickListener(this.s);
        RadioButton radioButton3 = (RadioButton) this.f20452b.findViewById(R.id.comment_grade_3);
        this.n = radioButton3;
        radioButton3.setOnClickListener(this.s);
        RadioButton radioButton4 = (RadioButton) this.f20452b.findViewById(R.id.comment_grade_4);
        this.o = radioButton4;
        radioButton4.setOnClickListener(this.s);
        RadioButton radioButton5 = (RadioButton) this.f20452b.findViewById(R.id.comment_grade_5);
        this.p = radioButton5;
        radioButton5.setOnClickListener(this.s);
        this.q = (LinearLayout) this.f20452b.findViewById(R.id.comment_grade);
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
            if (!StringUtils.isNull(this.f20457g)) {
                this.f20454d.setText(this.f20457g);
            } else {
                this.f20454d.setVisibility(8);
            }
            if (this.f20460j != null) {
                this.f20456f.setOnClickListener(new b(this));
            }
            m();
            return this.f20452b;
        }
        return (View) invokeV.objValue;
    }

    public f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20459i : (f) invokeV.objValue;
    }

    public ViewGroup l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20453c : (ViewGroup) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundColor(this.f20454d, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f20454d, (int) R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.f20455e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f20456f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f20456f, (int) R.color.CAM_X0106);
            SkinManager.setBackgroundResource(this.q, R.drawable.bg_bottom_up_list_dialog_item);
            List<c> list = this.f20458h;
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
            this.f20456f.setVisibility(i2);
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
        this.f20458h = list;
        this.f20453c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar != null) {
                this.f20453c.addView(cVar.d());
            }
        }
    }

    public void t(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.f20460j = dVar;
        }
    }

    public void u(InterfaceC1279g interfaceC1279g) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, interfaceC1279g) == null) {
            this.k = interfaceC1279g;
        }
    }

    public void v(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048589, this, i2, i3, i4, i5) == null) {
            this.f20454d.setPadding(i2, i3, i4, i5);
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f20454d.setTextSize(0, n.f(this.a, i2));
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f20457g = str;
        }
    }
}

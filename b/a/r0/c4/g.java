package b.a.r0.c4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
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
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f15385a;

    /* renamed from: b  reason: collision with root package name */
    public View f15386b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f15387c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15388d;

    /* renamed from: e  reason: collision with root package name */
    public View f15389e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15390f;

    /* renamed from: g  reason: collision with root package name */
    public String f15391g;

    /* renamed from: h  reason: collision with root package name */
    public List<c> f15392h;

    /* renamed from: i  reason: collision with root package name */
    public f f15393i;
    public d j;
    public InterfaceC0775g k;
    public RadioButton l;
    public RadioButton m;
    public RadioButton n;
    public RadioButton o;
    public RadioButton p;
    public LinearLayout q;
    public int r;
    public View.OnClickListener s;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f15394e;

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
            this.f15394e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f15394e.l) {
                    this.f15394e.m.setChecked(false);
                    this.f15394e.n.setChecked(false);
                    this.f15394e.o.setChecked(false);
                    this.f15394e.p.setChecked(false);
                    this.f15394e.r = 1;
                } else if (view == this.f15394e.m) {
                    this.f15394e.l.setChecked(true);
                    this.f15394e.n.setChecked(false);
                    this.f15394e.o.setChecked(false);
                    this.f15394e.p.setChecked(false);
                    this.f15394e.r = 2;
                } else if (view == this.f15394e.n) {
                    this.f15394e.l.setChecked(true);
                    this.f15394e.m.setChecked(true);
                    this.f15394e.o.setChecked(false);
                    this.f15394e.p.setChecked(false);
                    this.f15394e.r = 3;
                } else if (view == this.f15394e.o) {
                    this.f15394e.l.setChecked(true);
                    this.f15394e.m.setChecked(true);
                    this.f15394e.n.setChecked(true);
                    this.f15394e.p.setChecked(false);
                    this.f15394e.r = 4;
                } else if (view == this.f15394e.p) {
                    this.f15394e.l.setChecked(true);
                    this.f15394e.m.setChecked(true);
                    this.f15394e.n.setChecked(true);
                    this.f15394e.o.setChecked(true);
                    this.f15394e.r = 5;
                }
                if (this.f15394e.k != null) {
                    this.f15394e.k.onClick(this.f15394e.r);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f15395e;

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
            this.f15395e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15395e.j.onClick();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f15396a;

        /* renamed from: b  reason: collision with root package name */
        public g f15397b;

        /* renamed from: c  reason: collision with root package name */
        public View f15398c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15399d;

        /* renamed from: e  reason: collision with root package name */
        public View f15400e;

        /* renamed from: f  reason: collision with root package name */
        public String f15401f;

        /* renamed from: g  reason: collision with root package name */
        public int f15402g;

        /* renamed from: h  reason: collision with root package name */
        public e f15403h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f15404i;
        public final View.OnClickListener j;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f15405e;

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
                this.f15405e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f15405e.f15403h != null) {
                        this.f15405e.f15403h.onClick();
                    }
                    if (this.f15405e.f15397b == null || this.f15405e.f15397b.k() == null) {
                        return;
                    }
                    this.f15405e.f15397b.k().onItemClick(this.f15405e.f15396a);
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
            this.f15402g = 17;
            this.f15404i = true;
            this.j = new a(this);
            this.f15401f = str;
            this.f15397b = gVar;
            this.f15396a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15398c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f15399d) == null) {
                return;
            }
            textView.setOnClickListener(this.j);
        }

        public final void f() {
            g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.f15397b) == null || gVar.getContext() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f15397b.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.f15397b.l(), false);
            this.f15398c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f15399d = textView;
            textView.setText(this.f15401f);
            this.f15399d.setGravity(this.f15402g);
            View findViewById = this.f15398c.findViewById(R.id.divider_line);
            this.f15400e = findViewById;
            if (this.f15404i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SkinManager.setBackgroundResource(this.f15399d, R.drawable.bg_bottom_up_list_dialog_item);
                SkinManager.setViewTextColor(this.f15399d, R.color.CAM_X0106);
                SkinManager.setBackgroundColor(this.f15400e, R.color.CAM_X0204);
            }
        }

        public void h(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
                this.f15403h = eVar;
                e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes4.dex */
    public interface e {
        void onClick();
    }

    /* loaded from: classes4.dex */
    public interface f {
        void onItemClick(int i2);
    }

    /* renamed from: b.a.r0.c4.g$g  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0775g {
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
        this.f15385a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
        this.f15386b = inflate;
        this.f15387c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f15388d = (TextView) this.f15386b.findViewById(R.id.title);
        this.f15389e = this.f15386b.findViewById(R.id.title_divide_line);
        this.f15392h = new ArrayList();
        this.f15390f = (TextView) this.f15386b.findViewById(R.id.dialog_bottom_cancel_button);
        RadioButton radioButton = (RadioButton) this.f15386b.findViewById(R.id.comment_grade_1);
        this.l = radioButton;
        radioButton.setOnClickListener(this.s);
        RadioButton radioButton2 = (RadioButton) this.f15386b.findViewById(R.id.comment_grade_2);
        this.m = radioButton2;
        radioButton2.setOnClickListener(this.s);
        RadioButton radioButton3 = (RadioButton) this.f15386b.findViewById(R.id.comment_grade_3);
        this.n = radioButton3;
        radioButton3.setOnClickListener(this.s);
        RadioButton radioButton4 = (RadioButton) this.f15386b.findViewById(R.id.comment_grade_4);
        this.o = radioButton4;
        radioButton4.setOnClickListener(this.s);
        RadioButton radioButton5 = (RadioButton) this.f15386b.findViewById(R.id.comment_grade_5);
        this.p = radioButton5;
        radioButton5.setOnClickListener(this.s);
        this.q = (LinearLayout) this.f15386b.findViewById(R.id.comment_grade);
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15385a : (Context) invokeV.objValue;
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!StringUtils.isNull(this.f15391g)) {
                this.f15388d.setText(this.f15391g);
            } else {
                this.f15388d.setVisibility(8);
            }
            if (this.j != null) {
                this.f15390f.setOnClickListener(new b(this));
            }
            m();
            return this.f15386b;
        }
        return (View) invokeV.objValue;
    }

    public f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15393i : (f) invokeV.objValue;
    }

    public ViewGroup l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15387c : (ViewGroup) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundColor(this.f15388d, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f15388d, R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.f15389e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f15390f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f15390f, R.color.CAM_X0106);
            SkinManager.setBackgroundResource(this.q, R.drawable.bg_bottom_up_list_dialog_item);
            List<c> list = this.f15392h;
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
            this.f15390f.setVisibility(i2);
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
        this.f15392h = list;
        this.f15387c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar != null) {
                this.f15387c.addView(cVar.d());
            }
        }
    }

    public void t(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.j = dVar;
        }
    }

    public void u(InterfaceC0775g interfaceC0775g) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, interfaceC0775g) == null) {
            this.k = interfaceC0775g;
        }
    }

    public void v(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048589, this, i2, i3, i4, i5) == null) {
            this.f15388d.setPadding(i2, i3, i4, i5);
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f15388d.setTextSize(0, l.g(this.f15385a, i2));
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f15391g = str;
        }
    }
}

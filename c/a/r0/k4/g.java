package c.a.r0.k4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
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
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f18855b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f18856c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f18857d;

    /* renamed from: e  reason: collision with root package name */
    public View f18858e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18859f;

    /* renamed from: g  reason: collision with root package name */
    public String f18860g;

    /* renamed from: h  reason: collision with root package name */
    public List<c> f18861h;

    /* renamed from: i  reason: collision with root package name */
    public f f18862i;

    /* renamed from: j  reason: collision with root package name */
    public d f18863j;

    /* renamed from: k  reason: collision with root package name */
    public InterfaceC1112g f18864k;
    public RadioButton l;
    public RadioButton m;
    public RadioButton n;
    public RadioButton o;
    public RadioButton p;
    public LinearLayout q;
    public int r;
    public View.OnClickListener s;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f18865e;

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
            this.f18865e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f18865e.l) {
                    this.f18865e.m.setChecked(false);
                    this.f18865e.n.setChecked(false);
                    this.f18865e.o.setChecked(false);
                    this.f18865e.p.setChecked(false);
                    this.f18865e.r = 1;
                } else if (view == this.f18865e.m) {
                    this.f18865e.l.setChecked(true);
                    this.f18865e.n.setChecked(false);
                    this.f18865e.o.setChecked(false);
                    this.f18865e.p.setChecked(false);
                    this.f18865e.r = 2;
                } else if (view == this.f18865e.n) {
                    this.f18865e.l.setChecked(true);
                    this.f18865e.m.setChecked(true);
                    this.f18865e.o.setChecked(false);
                    this.f18865e.p.setChecked(false);
                    this.f18865e.r = 3;
                } else if (view == this.f18865e.o) {
                    this.f18865e.l.setChecked(true);
                    this.f18865e.m.setChecked(true);
                    this.f18865e.n.setChecked(true);
                    this.f18865e.p.setChecked(false);
                    this.f18865e.r = 4;
                } else if (view == this.f18865e.p) {
                    this.f18865e.l.setChecked(true);
                    this.f18865e.m.setChecked(true);
                    this.f18865e.n.setChecked(true);
                    this.f18865e.o.setChecked(true);
                    this.f18865e.r = 5;
                }
                if (this.f18865e.f18864k != null) {
                    this.f18865e.f18864k.onClick(this.f18865e.r);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f18866e;

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
            this.f18866e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18866e.f18863j.onClick();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public g f18867b;

        /* renamed from: c  reason: collision with root package name */
        public View f18868c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f18869d;

        /* renamed from: e  reason: collision with root package name */
        public View f18870e;

        /* renamed from: f  reason: collision with root package name */
        public String f18871f;

        /* renamed from: g  reason: collision with root package name */
        public int f18872g;

        /* renamed from: h  reason: collision with root package name */
        public e f18873h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f18874i;

        /* renamed from: j  reason: collision with root package name */
        public final View.OnClickListener f18875j;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f18876e;

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
                this.f18876e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f18876e.f18873h != null) {
                        this.f18876e.f18873h.onClick();
                    }
                    if (this.f18876e.f18867b == null || this.f18876e.f18867b.k() == null) {
                        return;
                    }
                    this.f18876e.f18867b.k().onItemClick(this.f18876e.a);
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
            this.f18872g = 17;
            this.f18874i = true;
            this.f18875j = new a(this);
            this.f18871f = str;
            this.f18867b = gVar;
            this.a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18868c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f18869d) == null) {
                return;
            }
            textView.setOnClickListener(this.f18875j);
        }

        public final void f() {
            g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.f18867b) == null || gVar.getContext() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f18867b.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.f18867b.l(), false);
            this.f18868c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f18869d = textView;
            textView.setText(this.f18871f);
            this.f18869d.setGravity(this.f18872g);
            View findViewById = this.f18868c.findViewById(R.id.divider_line);
            this.f18870e = findViewById;
            if (this.f18874i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SkinManager.setBackgroundResource(this.f18869d, R.drawable.bg_bottom_up_list_dialog_item);
                SkinManager.setViewTextColor(this.f18869d, R.color.CAM_X0106);
                SkinManager.setBackgroundColor(this.f18870e, R.color.CAM_X0204);
            }
        }

        public void h(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
                this.f18873h = eVar;
                e();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes6.dex */
    public interface e {
        void onClick();
    }

    /* loaded from: classes6.dex */
    public interface f {
        void onItemClick(int i2);
    }

    /* renamed from: c.a.r0.k4.g$g  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1112g {
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
        this.f18855b = inflate;
        this.f18856c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f18857d = (TextView) this.f18855b.findViewById(R.id.title);
        this.f18858e = this.f18855b.findViewById(R.id.title_divide_line);
        this.f18861h = new ArrayList();
        this.f18859f = (TextView) this.f18855b.findViewById(R.id.dialog_bottom_cancel_button);
        RadioButton radioButton = (RadioButton) this.f18855b.findViewById(R.id.comment_grade_1);
        this.l = radioButton;
        radioButton.setOnClickListener(this.s);
        RadioButton radioButton2 = (RadioButton) this.f18855b.findViewById(R.id.comment_grade_2);
        this.m = radioButton2;
        radioButton2.setOnClickListener(this.s);
        RadioButton radioButton3 = (RadioButton) this.f18855b.findViewById(R.id.comment_grade_3);
        this.n = radioButton3;
        radioButton3.setOnClickListener(this.s);
        RadioButton radioButton4 = (RadioButton) this.f18855b.findViewById(R.id.comment_grade_4);
        this.o = radioButton4;
        radioButton4.setOnClickListener(this.s);
        RadioButton radioButton5 = (RadioButton) this.f18855b.findViewById(R.id.comment_grade_5);
        this.p = radioButton5;
        radioButton5.setOnClickListener(this.s);
        this.q = (LinearLayout) this.f18855b.findViewById(R.id.comment_grade);
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
            if (!StringUtils.isNull(this.f18860g)) {
                this.f18857d.setText(this.f18860g);
            } else {
                this.f18857d.setVisibility(8);
            }
            if (this.f18863j != null) {
                this.f18859f.setOnClickListener(new b(this));
            }
            m();
            return this.f18855b;
        }
        return (View) invokeV.objValue;
    }

    public f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18862i : (f) invokeV.objValue;
    }

    public ViewGroup l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18856c : (ViewGroup) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundColor(this.f18857d, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f18857d, R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.f18858e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f18859f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f18859f, R.color.CAM_X0106);
            SkinManager.setBackgroundResource(this.q, R.drawable.bg_bottom_up_list_dialog_item);
            List<c> list = this.f18861h;
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
            this.f18859f.setVisibility(i2);
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
        this.f18861h = list;
        this.f18856c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar != null) {
                this.f18856c.addView(cVar.d());
            }
        }
    }

    public void t(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.f18863j = dVar;
        }
    }

    public void u(InterfaceC1112g interfaceC1112g) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, interfaceC1112g) == null) {
            this.f18864k = interfaceC1112g;
        }
    }

    public void v(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048589, this, i2, i3, i4, i5) == null) {
            this.f18857d.setPadding(i2, i3, i4, i5);
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f18857d.setTextSize(0, l.f(this.a, i2));
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f18860g = str;
        }
    }
}

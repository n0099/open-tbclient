package c.a.q0.a4;

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
    public Context f15663a;

    /* renamed from: b  reason: collision with root package name */
    public View f15664b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f15665c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15666d;

    /* renamed from: e  reason: collision with root package name */
    public View f15667e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15668f;

    /* renamed from: g  reason: collision with root package name */
    public String f15669g;

    /* renamed from: h  reason: collision with root package name */
    public List<c> f15670h;

    /* renamed from: i  reason: collision with root package name */
    public f f15671i;

    /* renamed from: j  reason: collision with root package name */
    public d f15672j;
    public InterfaceC0738g k;
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
        public final /* synthetic */ g f15673e;

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
            this.f15673e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f15673e.l) {
                    this.f15673e.m.setChecked(false);
                    this.f15673e.n.setChecked(false);
                    this.f15673e.o.setChecked(false);
                    this.f15673e.p.setChecked(false);
                    this.f15673e.r = 1;
                } else if (view == this.f15673e.m) {
                    this.f15673e.l.setChecked(true);
                    this.f15673e.n.setChecked(false);
                    this.f15673e.o.setChecked(false);
                    this.f15673e.p.setChecked(false);
                    this.f15673e.r = 2;
                } else if (view == this.f15673e.n) {
                    this.f15673e.l.setChecked(true);
                    this.f15673e.m.setChecked(true);
                    this.f15673e.o.setChecked(false);
                    this.f15673e.p.setChecked(false);
                    this.f15673e.r = 3;
                } else if (view == this.f15673e.o) {
                    this.f15673e.l.setChecked(true);
                    this.f15673e.m.setChecked(true);
                    this.f15673e.n.setChecked(true);
                    this.f15673e.p.setChecked(false);
                    this.f15673e.r = 4;
                } else if (view == this.f15673e.p) {
                    this.f15673e.l.setChecked(true);
                    this.f15673e.m.setChecked(true);
                    this.f15673e.n.setChecked(true);
                    this.f15673e.o.setChecked(true);
                    this.f15673e.r = 5;
                }
                if (this.f15673e.k != null) {
                    this.f15673e.k.onClick(this.f15673e.r);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f15674e;

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
            this.f15674e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15674e.f15672j.onClick();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f15675a;

        /* renamed from: b  reason: collision with root package name */
        public g f15676b;

        /* renamed from: c  reason: collision with root package name */
        public View f15677c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15678d;

        /* renamed from: e  reason: collision with root package name */
        public View f15679e;

        /* renamed from: f  reason: collision with root package name */
        public String f15680f;

        /* renamed from: g  reason: collision with root package name */
        public int f15681g;

        /* renamed from: h  reason: collision with root package name */
        public e f15682h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f15683i;

        /* renamed from: j  reason: collision with root package name */
        public final View.OnClickListener f15684j;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f15685e;

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
                this.f15685e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f15685e.f15682h != null) {
                        this.f15685e.f15682h.onClick();
                    }
                    if (this.f15685e.f15676b == null || this.f15685e.f15676b.l() == null) {
                        return;
                    }
                    this.f15685e.f15676b.l().onItemClick(this.f15685e.f15675a);
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
            this.f15681g = 17;
            this.f15683i = true;
            this.f15684j = new a(this);
            this.f15680f = str;
            this.f15676b = gVar;
            this.f15675a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15677c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f15678d) == null) {
                return;
            }
            textView.setOnClickListener(this.f15684j);
        }

        public final void f() {
            g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.f15676b) == null || gVar.k() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f15676b.k()).inflate(R.layout.bottom_up_list_dialog_item, this.f15676b.m(), false);
            this.f15677c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f15678d = textView;
            textView.setText(this.f15680f);
            this.f15678d.setGravity(this.f15681g);
            View findViewById = this.f15677c.findViewById(R.id.divider_line);
            this.f15679e = findViewById;
            if (this.f15683i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SkinManager.setBackgroundResource(this.f15678d, R.drawable.bg_bottom_up_list_dialog_item);
                SkinManager.setViewTextColor(this.f15678d, R.color.CAM_X0106);
                SkinManager.setBackgroundColor(this.f15679e, R.color.CAM_X0204);
            }
        }

        public void h(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
                this.f15682h = eVar;
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

    /* renamed from: c.a.q0.a4.g$g  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0738g {
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
        this.f15663a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
        this.f15664b = inflate;
        this.f15665c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f15666d = (TextView) this.f15664b.findViewById(R.id.title);
        this.f15667e = this.f15664b.findViewById(R.id.title_divide_line);
        this.f15670h = new ArrayList();
        this.f15668f = (TextView) this.f15664b.findViewById(R.id.dialog_bottom_cancel_button);
        RadioButton radioButton = (RadioButton) this.f15664b.findViewById(R.id.comment_grade_1);
        this.l = radioButton;
        radioButton.setOnClickListener(this.s);
        RadioButton radioButton2 = (RadioButton) this.f15664b.findViewById(R.id.comment_grade_2);
        this.m = radioButton2;
        radioButton2.setOnClickListener(this.s);
        RadioButton radioButton3 = (RadioButton) this.f15664b.findViewById(R.id.comment_grade_3);
        this.n = radioButton3;
        radioButton3.setOnClickListener(this.s);
        RadioButton radioButton4 = (RadioButton) this.f15664b.findViewById(R.id.comment_grade_4);
        this.o = radioButton4;
        radioButton4.setOnClickListener(this.s);
        RadioButton radioButton5 = (RadioButton) this.f15664b.findViewById(R.id.comment_grade_5);
        this.p = radioButton5;
        radioButton5.setOnClickListener(this.s);
        this.q = (LinearLayout) this.f15664b.findViewById(R.id.comment_grade);
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.f15669g)) {
                this.f15666d.setText(this.f15669g);
            } else {
                this.f15666d.setVisibility(8);
            }
            if (this.f15672j != null) {
                this.f15668f.setOnClickListener(new b(this));
            }
            n();
            return this.f15664b;
        }
        return (View) invokeV.objValue;
    }

    public Context k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15663a : (Context) invokeV.objValue;
    }

    public f l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15671i : (f) invokeV.objValue;
    }

    public ViewGroup m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15665c : (ViewGroup) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundColor(this.f15666d, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f15666d, R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.f15667e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f15668f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f15668f, R.color.CAM_X0106);
            SkinManager.setBackgroundResource(this.q, R.drawable.bg_bottom_up_list_dialog_item);
            List<c> list = this.f15670h;
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
            this.f15668f.setVisibility(i2);
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
        this.f15670h = list;
        this.f15665c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar != null) {
                this.f15665c.addView(cVar.d());
            }
        }
    }

    public void u(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.f15672j = dVar;
        }
    }

    public void v(InterfaceC0738g interfaceC0738g) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, interfaceC0738g) == null) {
            this.k = interfaceC0738g;
        }
    }

    public void w(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048589, this, i2, i3, i4, i5) == null) {
            this.f15666d.setPadding(i2, i3, i4, i5);
        }
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f15666d.setTextSize(0, l.g(this.f15663a, i2));
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f15669g = str;
        }
    }
}

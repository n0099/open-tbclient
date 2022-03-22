package c.a.p0.q4;

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
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f17723b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f17724c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17725d;

    /* renamed from: e  reason: collision with root package name */
    public View f17726e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17727f;

    /* renamed from: g  reason: collision with root package name */
    public String f17728g;

    /* renamed from: h  reason: collision with root package name */
    public List<c> f17729h;
    public f i;
    public d j;
    public g k;
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
        public final /* synthetic */ h a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.a.l) {
                    this.a.m.setChecked(false);
                    this.a.n.setChecked(false);
                    this.a.o.setChecked(false);
                    this.a.p.setChecked(false);
                    this.a.r = 1;
                } else if (view == this.a.m) {
                    this.a.l.setChecked(true);
                    this.a.n.setChecked(false);
                    this.a.o.setChecked(false);
                    this.a.p.setChecked(false);
                    this.a.r = 2;
                } else if (view == this.a.n) {
                    this.a.l.setChecked(true);
                    this.a.m.setChecked(true);
                    this.a.o.setChecked(false);
                    this.a.p.setChecked(false);
                    this.a.r = 3;
                } else if (view == this.a.o) {
                    this.a.l.setChecked(true);
                    this.a.m.setChecked(true);
                    this.a.n.setChecked(true);
                    this.a.p.setChecked(false);
                    this.a.r = 4;
                } else if (view == this.a.p) {
                    this.a.l.setChecked(true);
                    this.a.m.setChecked(true);
                    this.a.n.setChecked(true);
                    this.a.o.setChecked(true);
                    this.a.r = 5;
                }
                if (this.a.k != null) {
                    this.a.k.onClick(this.a.r);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.j.onClick();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public h f17730b;

        /* renamed from: c  reason: collision with root package name */
        public View f17731c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17732d;

        /* renamed from: e  reason: collision with root package name */
        public View f17733e;

        /* renamed from: f  reason: collision with root package name */
        public String f17734f;

        /* renamed from: g  reason: collision with root package name */
        public int f17735g;

        /* renamed from: h  reason: collision with root package name */
        public e f17736h;
        public boolean i;
        public final View.OnClickListener j;

        /* loaded from: classes2.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.a.f17736h != null) {
                        this.a.f17736h.onClick();
                    }
                    if (this.a.f17730b == null || this.a.f17730b.k() == null) {
                        return;
                    }
                    this.a.f17730b.k().onItemClick(this.a.a);
                }
            }
        }

        public c(String str, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17735g = 17;
            this.i = true;
            this.j = new a(this);
            this.f17734f = str;
            this.f17730b = hVar;
            this.a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17731c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f17732d) == null) {
                return;
            }
            textView.setOnClickListener(this.j);
        }

        public final void f() {
            h hVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (hVar = this.f17730b) == null || hVar.getContext() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f17730b.getContext()).inflate(R.layout.obfuscated_res_0x7f0d015f, this.f17730b.l(), false);
            this.f17731c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090fb2);
            this.f17732d = textView;
            textView.setText(this.f17734f);
            this.f17732d.setGravity(this.f17735g);
            View findViewById = this.f17731c.findViewById(R.id.obfuscated_res_0x7f0907f4);
            this.f17733e = findViewById;
            if (this.i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SkinManager.setBackgroundResource(this.f17732d, R.drawable.bg_bottom_up_list_dialog_item);
                SkinManager.setViewTextColor(this.f17732d, (int) R.color.CAM_X0106);
                SkinManager.setBackgroundColor(this.f17733e, R.color.CAM_X0204);
            }
        }

        public void h(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
                this.f17736h = eVar;
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
        void onItemClick(int i);
    }

    /* loaded from: classes2.dex */
    public interface g {
        void onClick(int i);
    }

    public h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0716, (ViewGroup) null);
        this.f17723b = inflate;
        this.f17724c = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0906e9);
        this.f17725d = (TextView) this.f17723b.findViewById(R.id.obfuscated_res_0x7f09202b);
        this.f17726e = this.f17723b.findViewById(R.id.obfuscated_res_0x7f09203f);
        this.f17729h = new ArrayList();
        this.f17727f = (TextView) this.f17723b.findViewById(R.id.obfuscated_res_0x7f090794);
        RadioButton radioButton = (RadioButton) this.f17723b.findViewById(R.id.obfuscated_res_0x7f090686);
        this.l = radioButton;
        radioButton.setOnClickListener(this.s);
        RadioButton radioButton2 = (RadioButton) this.f17723b.findViewById(R.id.obfuscated_res_0x7f090687);
        this.m = radioButton2;
        radioButton2.setOnClickListener(this.s);
        RadioButton radioButton3 = (RadioButton) this.f17723b.findViewById(R.id.obfuscated_res_0x7f090688);
        this.n = radioButton3;
        radioButton3.setOnClickListener(this.s);
        RadioButton radioButton4 = (RadioButton) this.f17723b.findViewById(R.id.obfuscated_res_0x7f090689);
        this.o = radioButton4;
        radioButton4.setOnClickListener(this.s);
        RadioButton radioButton5 = (RadioButton) this.f17723b.findViewById(R.id.obfuscated_res_0x7f09068a);
        this.p = radioButton5;
        radioButton5.setOnClickListener(this.s);
        this.q = (LinearLayout) this.f17723b.findViewById(R.id.obfuscated_res_0x7f090685);
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
            if (!StringUtils.isNull(this.f17728g)) {
                this.f17725d.setText(this.f17728g);
            } else {
                this.f17725d.setVisibility(8);
            }
            if (this.j != null) {
                this.f17727f.setOnClickListener(new b(this));
            }
            m();
            return this.f17723b;
        }
        return (View) invokeV.objValue;
    }

    public f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.i : (f) invokeV.objValue;
    }

    public ViewGroup l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17724c : (ViewGroup) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundColor(this.f17725d, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f17725d, (int) R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.f17726e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f17727f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f17727f, (int) R.color.CAM_X0106);
            SkinManager.setBackgroundResource(this.q, R.drawable.bg_bottom_up_list_dialog_item);
            List<c> list = this.f17729h;
            if (list != null) {
                for (c cVar : list) {
                    cVar.g();
                }
            }
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f17727f.setVisibility(i);
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

    public void p(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i, i2, i3, i4) == null) {
            this.q.setPadding(i, i2, i3, i4);
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            if (i == 1) {
                this.l.setChecked(true);
                this.m.setChecked(false);
                this.n.setChecked(false);
                this.o.setChecked(false);
                this.p.setChecked(false);
            } else if (i == 2) {
                this.l.setChecked(true);
                this.m.setChecked(true);
                this.n.setChecked(false);
                this.o.setChecked(false);
                this.p.setChecked(false);
            } else if (i == 3) {
                this.l.setChecked(true);
                this.m.setChecked(true);
                this.n.setChecked(true);
                this.o.setChecked(false);
                this.p.setChecked(false);
            } else if (i == 4) {
                this.l.setChecked(true);
                this.m.setChecked(true);
                this.n.setChecked(true);
                this.o.setChecked(true);
                this.p.setChecked(false);
            } else if (i != 5) {
            } else {
                this.l.setChecked(true);
                this.m.setChecked(true);
                this.n.setChecked(true);
                this.o.setChecked(true);
                this.p.setChecked(true);
            }
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.q.setVisibility(i);
        }
    }

    public void s(List<c> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, list) == null) || list == null) {
            return;
        }
        this.f17729h = list;
        this.f17724c.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            c cVar = list.get(i);
            if (cVar != null) {
                this.f17724c.addView(cVar.d());
            }
        }
    }

    public void t(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.j = dVar;
        }
    }

    public void u(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) {
            this.k = gVar;
        }
    }

    public void v(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048589, this, i, i2, i3, i4) == null) {
            this.f17725d.setPadding(i, i2, i3, i4);
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.f17725d.setTextSize(0, n.f(this.a, i));
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f17728g = str;
        }
    }
}

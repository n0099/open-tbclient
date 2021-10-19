package c.a.q0.s.s;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
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
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f14463a;

    /* renamed from: b  reason: collision with root package name */
    public RoundLinearLayout f14464b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f14465c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f14466d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f14467e;

    /* renamed from: f  reason: collision with root package name */
    public View f14468f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14469g;

    /* renamed from: h  reason: collision with root package name */
    public View f14470h;

    /* renamed from: i  reason: collision with root package name */
    public String f14471i;

    /* renamed from: j  reason: collision with root package name */
    public SpannableStringBuilder f14472j;
    public List<? extends h> k;
    public e l;
    public c m;
    public boolean n;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f14473e;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14473e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14473e.m.onClick();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f14474e;

        public b(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14474e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14474e.m.onClick();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes3.dex */
    public interface e {
        void onItemClick(i iVar, int i2, View view);
    }

    public i(Context context) {
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
        this.n = false;
        if (context == null) {
            return;
        }
        this.f14463a = context;
        h();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(List<? extends h> list) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        i();
        this.k = list;
        this.f14465c.removeAllViews();
        this.f14466d.removeAllViews();
        if (list.size() < 2) {
            z = false;
        } else {
            z = ((f) list.get(0)).e() == -1;
            if (((f) list.get(1)).e() == -2) {
                z2 = true;
                this.f14468f.setVisibility(!z ? 0 : 8);
                int i2 = z ? 0 : z2 ? 4 : 3;
                boolean z3 = list.size() - i2 > 4;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    f fVar = (f) list.get(i3);
                    fVar.j(z3);
                    fVar.d();
                    if (fVar != null) {
                        if (i3 < i2) {
                            this.f14465c.addView(fVar.getView());
                        } else {
                            this.f14466d.addView(fVar.getView());
                        }
                    }
                }
            }
        }
        z2 = false;
        this.f14468f.setVisibility(!z ? 0 : 8);
        if (z) {
        }
        if (list.size() - i2 > 4) {
        }
        while (i3 < list.size()) {
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            p();
            if (this.m != null) {
                this.f14469g.setOnClickListener(new b(this));
            }
            j();
            return this.f14464b;
        }
        return (View) invokeV.objValue;
    }

    public Context d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14463a : (Context) invokeV.objValue;
    }

    public e e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (e) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14464b : (View) invokeV.objValue;
    }

    public ViewGroup g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14465c : (ViewGroup) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(this.f14463a).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.f14464b = roundLinearLayout;
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(roundLinearLayout);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            this.f14465c = (LinearLayout) this.f14464b.findViewById(R.id.content_view);
            this.f14467e = (EMTextView) this.f14464b.findViewById(R.id.title);
            View findViewById = this.f14464b.findViewById(R.id.title_divide_line);
            this.f14468f = findViewById;
            findViewById.setVisibility(8);
            this.f14470h = this.f14464b.findViewById(R.id.dialog_header);
            this.k = new ArrayList();
            this.f14469g = (TextView) this.f14464b.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.n = true;
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(this.f14463a).inflate(R.layout.popup_dialog_view_horizal, (ViewGroup) null);
            this.f14464b = roundLinearLayout;
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(roundLinearLayout);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            this.f14465c = (LinearLayout) this.f14464b.findViewById(R.id.content_view);
            this.f14466d = (LinearLayout) this.f14464b.findViewById(R.id.content_view_second);
            this.f14467e = (EMTextView) this.f14464b.findViewById(R.id.title);
            View findViewById = this.f14464b.findViewById(R.id.title_divide_line);
            this.f14468f = findViewById;
            findViewById.setVisibility(8);
            this.f14470h = this.f14464b.findViewById(R.id.dialog_header);
            this.k = new ArrayList();
            this.f14469g = (TextView) this.f14464b.findViewById(R.id.dialog_bottom_cancel_button);
            int k = (c.a.e.e.p.l.k(this.f14463a) - (f.q * 4)) / 2;
            ((LinearLayout.LayoutParams) this.f14465c.getLayoutParams()).leftMargin = k;
            ((LinearLayout.LayoutParams) this.f14465c.getLayoutParams()).rightMargin = k;
            ((FrameLayout.LayoutParams) this.f14466d.getLayoutParams()).leftMargin = k;
            ((FrameLayout.LayoutParams) this.f14466d.getLayoutParams()).rightMargin = k;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.n) {
                SkinManager.setBackgroundColor(this.f14468f, R.color.CAM_X0203);
            } else {
                SkinManager.setViewTextColor(this.f14467e, R.color.CAM_X0109);
                SkinManager.setBackgroundColor(this.f14468f, R.color.CAM_X0204);
            }
            SkinManager.setBackgroundColor(this.f14467e, R.color.CAM_X0206);
            SkinManager.setBackgroundColor(this.f14470h, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f14469g, R.color.CAM_X0204);
            SkinManager.setViewTextColorSelector(this.f14469g, R.color.CAM_X0107);
            List<? extends h> list = this.k;
            if (list != null) {
                for (h hVar : list) {
                    hVar.onChangeSkinType();
                }
            }
        }
    }

    public void k(List<? extends h> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || list == null) {
            return;
        }
        this.k = list;
        this.f14465c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            h hVar = list.get(i2);
            if (hVar != null) {
                this.f14465c.addView(hVar.getView());
            }
        }
    }

    public void l(List<? extends h> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, list, z) == null) {
            if (z) {
                b(list);
            } else {
                k(list);
            }
        }
    }

    public void m(c cVar) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.m = cVar;
            if (cVar == null || (textView = this.f14469g) == null) {
                return;
            }
            textView.setOnClickListener(new a(this));
        }
    }

    public void n(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) {
            this.l = eVar;
        }
    }

    public void o(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, spannableStringBuilder) == null) {
            this.f14472j = spannableStringBuilder;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!StringUtils.isNull(this.f14471i)) {
                this.f14467e.setVisibility(0);
                this.f14467e.setText(this.f14471i);
            } else if (this.f14472j != null) {
                this.f14467e.setVisibility(0);
                this.f14467e.setText(this.f14472j);
            }
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f14471i = str;
        }
    }
}

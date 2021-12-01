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
/* loaded from: classes5.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public RoundLinearLayout f13176b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f13177c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f13178d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f13179e;

    /* renamed from: f  reason: collision with root package name */
    public View f13180f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13181g;

    /* renamed from: h  reason: collision with root package name */
    public View f13182h;

    /* renamed from: i  reason: collision with root package name */
    public String f13183i;

    /* renamed from: j  reason: collision with root package name */
    public SpannableStringBuilder f13184j;

    /* renamed from: k  reason: collision with root package name */
    public List<? extends h> f13185k;
    public e l;
    public c m;
    public boolean n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f13186e;

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
            this.f13186e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f13186e.m.onClick();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f13187e;

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
            this.f13187e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f13187e.m.onClick();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes5.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes5.dex */
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
        this.a = context;
        g();
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
        h();
        this.f13185k = list;
        this.f13177c.removeAllViews();
        this.f13178d.removeAllViews();
        if (list.size() < 2) {
            z = false;
        } else {
            z = ((f) list.get(0)).e() == -1;
            if (((f) list.get(1)).e() == -2) {
                z2 = true;
                this.f13180f.setVisibility(!z ? 0 : 8);
                int i2 = z ? 0 : z2 ? 4 : 3;
                boolean z3 = list.size() - i2 > 4;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    f fVar = (f) list.get(i3);
                    fVar.j(z3);
                    fVar.d();
                    if (fVar != null) {
                        if (i3 < i2) {
                            this.f13177c.addView(fVar.getView());
                        } else {
                            this.f13178d.addView(fVar.getView());
                        }
                    }
                }
            }
        }
        z2 = false;
        this.f13180f.setVisibility(!z ? 0 : 8);
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
            o();
            if (this.m != null) {
                this.f13181g.setOnClickListener(new b(this));
            }
            i();
            return this.f13176b;
        }
        return (View) invokeV.objValue;
    }

    public e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : (e) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13176b : (View) invokeV.objValue;
    }

    public ViewGroup f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13177c : (ViewGroup) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(this.a).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.f13176b = roundLinearLayout;
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(roundLinearLayout);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            this.f13177c = (LinearLayout) this.f13176b.findViewById(R.id.content_view);
            this.f13179e = (EMTextView) this.f13176b.findViewById(R.id.title);
            View findViewById = this.f13176b.findViewById(R.id.title_divide_line);
            this.f13180f = findViewById;
            findViewById.setVisibility(8);
            this.f13182h = this.f13176b.findViewById(R.id.dialog_header);
            this.f13185k = new ArrayList();
            this.f13181g = (TextView) this.f13176b.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (Context) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.n = true;
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(this.a).inflate(R.layout.popup_dialog_view_horizal, (ViewGroup) null);
            this.f13176b = roundLinearLayout;
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(roundLinearLayout);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            this.f13177c = (LinearLayout) this.f13176b.findViewById(R.id.content_view);
            this.f13178d = (LinearLayout) this.f13176b.findViewById(R.id.content_view_second);
            this.f13179e = (EMTextView) this.f13176b.findViewById(R.id.title);
            View findViewById = this.f13176b.findViewById(R.id.title_divide_line);
            this.f13180f = findViewById;
            findViewById.setVisibility(8);
            this.f13182h = this.f13176b.findViewById(R.id.dialog_header);
            this.f13185k = new ArrayList();
            this.f13181g = (TextView) this.f13176b.findViewById(R.id.dialog_bottom_cancel_button);
            int k2 = (c.a.d.f.p.l.k(this.a) - (f.q * 4)) / 2;
            ((LinearLayout.LayoutParams) this.f13177c.getLayoutParams()).leftMargin = k2;
            ((LinearLayout.LayoutParams) this.f13177c.getLayoutParams()).rightMargin = k2;
            ((FrameLayout.LayoutParams) this.f13178d.getLayoutParams()).leftMargin = k2;
            ((FrameLayout.LayoutParams) this.f13178d.getLayoutParams()).rightMargin = k2;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.n) {
                SkinManager.setBackgroundColor(this.f13180f, R.color.CAM_X0203);
            } else {
                SkinManager.setViewTextColor(this.f13179e, R.color.CAM_X0109);
                SkinManager.setBackgroundColor(this.f13180f, R.color.CAM_X0204);
            }
            SkinManager.setBackgroundColor(this.f13179e, R.color.CAM_X0206);
            SkinManager.setBackgroundColor(this.f13182h, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f13181g, R.color.CAM_X0204);
            SkinManager.setViewTextColorSelector(this.f13181g, R.color.CAM_X0107);
            List<? extends h> list = this.f13185k;
            if (list != null) {
                for (h hVar : list) {
                    hVar.onChangeSkinType();
                }
            }
        }
    }

    public void j(List<? extends h> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || list == null) {
            return;
        }
        this.f13185k = list;
        this.f13177c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            h hVar = list.get(i2);
            if (hVar != null) {
                this.f13177c.addView(hVar.getView());
            }
        }
    }

    public void k(List<? extends h> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, list, z) == null) {
            if (z) {
                b(list);
            } else {
                j(list);
            }
        }
    }

    public void l(c cVar) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.m = cVar;
            if (cVar == null || (textView = this.f13181g) == null) {
                return;
            }
            textView.setOnClickListener(new a(this));
        }
    }

    public void m(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) {
            this.l = eVar;
        }
    }

    public void n(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, spannableStringBuilder) == null) {
            this.f13184j = spannableStringBuilder;
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!StringUtils.isNull(this.f13183i)) {
                this.f13179e.setVisibility(0);
                this.f13179e.setText(this.f13183i);
            } else if (this.f13184j != null) {
                this.f13179e.setVisibility(0);
                this.f13179e.setText(this.f13184j);
            }
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f13183i = str;
        }
    }
}

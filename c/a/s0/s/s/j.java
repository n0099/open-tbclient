package c.a.s0.s.s;

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
import com.baidu.tbadk.widget.MaxHeightScrollView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public RoundLinearLayout f13798b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f13799c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f13800d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f13801e;

    /* renamed from: f  reason: collision with root package name */
    public View f13802f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13803g;

    /* renamed from: h  reason: collision with root package name */
    public View f13804h;

    /* renamed from: i  reason: collision with root package name */
    public MaxHeightScrollView f13805i;

    /* renamed from: j  reason: collision with root package name */
    public String f13806j;
    public SpannableStringBuilder k;
    public List<? extends i> l;
    public e m;
    public c n;
    public boolean o;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f13807e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13807e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f13807e.n.onClick();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f13808e;

        public b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13808e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f13808e.n.onClick();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes6.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes6.dex */
    public interface e {
        void onItemClick(j jVar, int i2, View view);
    }

    public j(Context context) {
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
        this.o = false;
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
    public final void b(List<? extends i> list) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        h();
        this.l = list;
        this.f13799c.removeAllViews();
        this.f13800d.removeAllViews();
        if (list.size() < 2) {
            z = false;
        } else {
            z = ((g) list.get(0)).e() == -1;
            if (((g) list.get(1)).e() == -2) {
                z2 = true;
                this.f13802f.setVisibility(!z ? 0 : 8);
                int i2 = z ? 0 : z2 ? 4 : 3;
                boolean z3 = list.size() - i2 > 4;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    g gVar = (g) list.get(i3);
                    gVar.j(z3);
                    gVar.d();
                    if (gVar != null) {
                        if (i3 < i2) {
                            this.f13799c.addView(gVar.getView());
                        } else {
                            this.f13800d.addView(gVar.getView());
                        }
                    }
                }
            }
        }
        z2 = false;
        this.f13802f.setVisibility(!z ? 0 : 8);
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
            if (this.n != null) {
                this.f13803g.setOnClickListener(new b(this));
            }
            i();
            return this.f13798b;
        }
        return (View) invokeV.objValue;
    }

    public e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m : (e) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13798b : (View) invokeV.objValue;
    }

    public ViewGroup f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13799c : (ViewGroup) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(this.a).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.f13798b = roundLinearLayout;
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(roundLinearLayout);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            this.f13799c = (LinearLayout) this.f13798b.findViewById(R.id.content_view);
            this.f13801e = (EMTextView) this.f13798b.findViewById(R.id.title);
            View findViewById = this.f13798b.findViewById(R.id.title_divide_line);
            this.f13802f = findViewById;
            findViewById.setVisibility(8);
            this.f13804h = this.f13798b.findViewById(R.id.dialog_header);
            this.l = new ArrayList();
            this.f13803g = (TextView) this.f13798b.findViewById(R.id.dialog_bottom_cancel_button);
            this.f13805i = (MaxHeightScrollView) this.f13798b.findViewById(R.id.max_height_scroll_view);
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
            this.o = true;
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(this.a).inflate(R.layout.popup_dialog_view_horizal, (ViewGroup) null);
            this.f13798b = roundLinearLayout;
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(roundLinearLayout);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            this.f13799c = (LinearLayout) this.f13798b.findViewById(R.id.content_view);
            this.f13800d = (LinearLayout) this.f13798b.findViewById(R.id.content_view_second);
            this.f13801e = (EMTextView) this.f13798b.findViewById(R.id.title);
            View findViewById = this.f13798b.findViewById(R.id.title_divide_line);
            this.f13802f = findViewById;
            findViewById.setVisibility(8);
            this.f13804h = this.f13798b.findViewById(R.id.dialog_header);
            this.l = new ArrayList();
            this.f13803g = (TextView) this.f13798b.findViewById(R.id.dialog_bottom_cancel_button);
            int k = (c.a.d.f.p.n.k(this.a) - (g.q * 4)) / 2;
            ((LinearLayout.LayoutParams) this.f13799c.getLayoutParams()).leftMargin = k;
            ((LinearLayout.LayoutParams) this.f13799c.getLayoutParams()).rightMargin = k;
            ((FrameLayout.LayoutParams) this.f13800d.getLayoutParams()).leftMargin = k;
            ((FrameLayout.LayoutParams) this.f13800d.getLayoutParams()).rightMargin = k;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.o) {
                SkinManager.setBackgroundColor(this.f13802f, R.color.CAM_X0203);
            } else {
                SkinManager.setViewTextColor(this.f13801e, R.color.CAM_X0109);
                SkinManager.setBackgroundColor(this.f13802f, R.color.CAM_X0204);
            }
            SkinManager.setBackgroundColor(this.f13801e, R.color.CAM_X0206);
            SkinManager.setBackgroundColor(this.f13804h, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f13803g, R.color.CAM_X0204);
            SkinManager.setViewTextColorSelector(this.f13803g, R.color.CAM_X0107);
            List<? extends i> list = this.l;
            if (list != null) {
                for (i iVar : list) {
                    iVar.onChangeSkinType();
                }
            }
        }
    }

    public void j(List<? extends i> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || list == null) {
            return;
        }
        this.l = list;
        this.f13799c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            i iVar = list.get(i2);
            if (iVar != null) {
                this.f13799c.addView(iVar.getView());
            }
        }
    }

    public void k(List<? extends i> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, list, z) == null) {
            if (z) {
                b(list);
            } else {
                j(list);
            }
        }
    }

    public void l(int i2) {
        MaxHeightScrollView maxHeightScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (maxHeightScrollView = this.f13805i) == null) {
            return;
        }
        maxHeightScrollView.setMaxHeight(i2);
        this.f13805i.setVerticalScrollBarEnabled(true);
    }

    public void m(c cVar) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.n = cVar;
            if (cVar == null || (textView = this.f13803g) == null) {
                return;
            }
            textView.setOnClickListener(new a(this));
        }
    }

    public void n(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.m = eVar;
        }
    }

    public void o(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, spannableStringBuilder) == null) {
            this.k = spannableStringBuilder;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (!StringUtils.isNull(this.f13806j)) {
                this.f13801e.setVisibility(0);
                this.f13801e.setText(this.f13806j);
            } else if (this.k != null) {
                this.f13801e.setVisibility(0);
                this.f13801e.setText(this.k);
            }
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f13806j = str;
        }
    }
}

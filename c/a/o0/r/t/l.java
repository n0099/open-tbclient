package c.a.o0.r.t;

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
/* loaded from: classes2.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public RoundLinearLayout f11072b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f11073c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f11074d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f11075e;

    /* renamed from: f  reason: collision with root package name */
    public View f11076f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f11077g;

    /* renamed from: h  reason: collision with root package name */
    public View f11078h;
    public MaxHeightScrollView i;
    public String j;
    public SpannableStringBuilder k;
    public List<? extends k> l;
    public e m;
    public c n;
    public boolean o;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.n.onClick();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.n.onClick();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes2.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes2.dex */
    public interface e {
        void onItemClick(l lVar, int i, View view);
    }

    public l(Context context) {
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
    public final void b(List<? extends k> list) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        h();
        this.l = list;
        this.f11073c.removeAllViews();
        this.f11074d.removeAllViews();
        if (list.size() < 2) {
            z = false;
        } else {
            z = ((h) list.get(0)).f() == -1;
            if (((h) list.get(1)).f() == -2) {
                z2 = true;
                this.f11076f.setVisibility(!z ? 0 : 8);
                int i = z ? 0 : z2 ? 4 : 3;
                boolean z3 = list.size() - i > 4;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    h hVar = (h) list.get(i2);
                    hVar.k(z3);
                    hVar.e();
                    if (hVar != null) {
                        if (i2 < i) {
                            this.f11073c.addView(hVar.getView());
                        } else {
                            this.f11074d.addView(hVar.getView());
                        }
                    }
                }
            }
        }
        z2 = false;
        this.f11076f.setVisibility(!z ? 0 : 8);
        if (z) {
        }
        if (list.size() - i > 4) {
        }
        while (i2 < list.size()) {
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            p();
            if (this.n != null) {
                this.f11077g.setOnClickListener(new b(this));
            }
            i();
            return this.f11072b;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f11072b : (View) invokeV.objValue;
    }

    public ViewGroup f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f11073c : (ViewGroup) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d06f7, (ViewGroup) null);
            this.f11072b = roundLinearLayout;
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(roundLinearLayout);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            this.f11073c = (LinearLayout) this.f11072b.findViewById(R.id.obfuscated_res_0x7f0906e9);
            this.f11075e = (EMTextView) this.f11072b.findViewById(R.id.obfuscated_res_0x7f09202b);
            View findViewById = this.f11072b.findViewById(R.id.obfuscated_res_0x7f09203f);
            this.f11076f = findViewById;
            findViewById.setVisibility(8);
            this.f11078h = this.f11072b.findViewById(R.id.obfuscated_res_0x7f0907a5);
            this.l = new ArrayList();
            this.f11077g = (TextView) this.f11072b.findViewById(R.id.obfuscated_res_0x7f090794);
            this.i = (MaxHeightScrollView) this.f11072b.findViewById(R.id.obfuscated_res_0x7f0913bc);
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
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d06f8, (ViewGroup) null);
            this.f11072b = roundLinearLayout;
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(roundLinearLayout);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            this.f11073c = (LinearLayout) this.f11072b.findViewById(R.id.obfuscated_res_0x7f0906e9);
            this.f11074d = (LinearLayout) this.f11072b.findViewById(R.id.obfuscated_res_0x7f0906ea);
            this.f11075e = (EMTextView) this.f11072b.findViewById(R.id.obfuscated_res_0x7f09202b);
            View findViewById = this.f11072b.findViewById(R.id.obfuscated_res_0x7f09203f);
            this.f11076f = findViewById;
            findViewById.setVisibility(8);
            this.f11078h = this.f11072b.findViewById(R.id.obfuscated_res_0x7f0907a5);
            this.l = new ArrayList();
            this.f11077g = (TextView) this.f11072b.findViewById(R.id.obfuscated_res_0x7f090794);
            int k = (c.a.d.f.p.n.k(this.a) - (h.q * 4)) / 2;
            ((LinearLayout.LayoutParams) this.f11073c.getLayoutParams()).leftMargin = k;
            ((LinearLayout.LayoutParams) this.f11073c.getLayoutParams()).rightMargin = k;
            ((FrameLayout.LayoutParams) this.f11074d.getLayoutParams()).leftMargin = k;
            ((FrameLayout.LayoutParams) this.f11074d.getLayoutParams()).rightMargin = k;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.o) {
                SkinManager.setBackgroundColor(this.f11076f, R.color.CAM_X0203);
            } else {
                SkinManager.setViewTextColor(this.f11075e, (int) R.color.CAM_X0109);
                SkinManager.setBackgroundColor(this.f11076f, R.color.CAM_X0204);
            }
            SkinManager.setBackgroundColor(this.f11075e, R.color.CAM_X0206);
            SkinManager.setBackgroundColor(this.f11078h, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f11077g, R.color.CAM_X0204);
            SkinManager.setViewTextColorSelector(this.f11077g, R.color.CAM_X0107);
            List<? extends k> list = this.l;
            if (list != null) {
                for (k kVar : list) {
                    kVar.a();
                }
            }
        }
    }

    public void j(List<? extends k> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || list == null) {
            return;
        }
        this.l = list;
        this.f11073c.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            k kVar = list.get(i);
            if (kVar != null) {
                this.f11073c.addView(kVar.getView());
            }
        }
    }

    public void k(List<? extends k> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, list, z) == null) {
            if (z) {
                b(list);
            } else {
                j(list);
            }
        }
    }

    public void l(int i) {
        MaxHeightScrollView maxHeightScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || (maxHeightScrollView = this.i) == null) {
            return;
        }
        maxHeightScrollView.setMaxHeight(i);
        this.i.setVerticalScrollBarEnabled(true);
    }

    public void m(c cVar) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.n = cVar;
            if (cVar == null || (textView = this.f11077g) == null) {
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
            if (!StringUtils.isNull(this.j)) {
                this.f11075e.setVisibility(0);
                this.f11075e.setText(this.j);
            } else if (this.k != null) {
                this.f11075e.setVisibility(0);
                this.f11075e.setText(this.k);
            }
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.j = str;
        }
    }
}

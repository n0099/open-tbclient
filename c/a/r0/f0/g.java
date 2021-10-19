package c.a.r0.f0;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.q0.s.q.d2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f17385a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.t.e.a f17386b;

    /* renamed from: c  reason: collision with root package name */
    public d2 f17387c;

    /* renamed from: d  reason: collision with root package name */
    public PopupWindow f17388d;

    /* renamed from: e  reason: collision with root package name */
    public PopupWindow f17389e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f17390f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17391g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f17392h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.s.f0.n.b f17393i;

    /* renamed from: j  reason: collision with root package name */
    public int f17394j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public View q;
    public int r;
    public PopupWindow.OnDismissListener s;
    public View.OnClickListener t;

    /* loaded from: classes3.dex */
    public class a implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f17395e;

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
            this.f17395e = gVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17395e.f17389e == null) {
                return;
            }
            this.f17395e.f17389e.dismiss();
            this.f17395e.f17389e = null;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f17396e;

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
            this.f17396e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!j.A()) {
                    this.f17396e.f17385a.showToast(R.string.network_ungeilivable);
                }
                if (ViewHelper.checkUpIsLogin(this.f17396e.f17385a.getPageActivity())) {
                    if (this.f17396e.f17387c == null) {
                        return;
                    }
                    this.f17396e.f17386b.m(false, this.f17396e.f17387c.J().getPortrait(), this.f17396e.f17387c.J().getUserId(), this.f17396e.f17387c.J().isGod(), "0", this.f17396e.f17385a.getUniqueId(), null, "0");
                    TiebaStatic.log(new StatisticItem("c13571"));
                }
                if (this.f17396e.f17389e == null || this.f17396e.f17388d == null) {
                    return;
                }
                this.f17396e.f17389e.dismiss();
                this.f17396e.f17388d.dismiss();
                this.f17396e.f17388d = null;
                this.f17396e.f17389e = null;
            }
        }
    }

    public g(TbPageContext tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = 3;
        this.s = new a(this);
        this.t = new b(this);
        this.f17385a = tbPageContext;
        this.f17386b = new c.a.q0.t.e.a(tbPageContext);
        this.q = view;
        m();
    }

    public void h(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) {
            this.f17387c = d2Var;
        }
    }

    public final boolean i(Context context, View view, int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) {
            if (context == null || view == null || iArr == null || iArr.length != 2) {
                return false;
            }
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            int height = view.getHeight();
            int i6 = l.i(context);
            int k = l.k(context);
            boolean z = ((i6 - iArr2[1]) - height) - i4 < i2;
            iArr[0] = k - i3;
            if (z) {
                iArr[1] = (iArr2[1] - i2) - i5;
                iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            } else {
                iArr[1] = iArr2[1] + height + i5;
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public final void j() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.r) {
            return;
        }
        SkinManager.setViewTextColor(this.f17391g, R.color.CAM_X0105, 1);
        this.r = skinType;
    }

    public final View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f17385a.getContext() == null) {
                return null;
            }
            if (this.f17390f == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f17385a.getContext()).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
                this.f17390f = viewGroup;
                TextView textView = (TextView) viewGroup.findViewById(R.id.head_text);
                this.f17391g = textView;
                textView.setText(this.f17385a.getString(R.string.confirm_unlike));
                SkinManager.setViewTextColor(this.f17391g, R.color.CAM_X0105, 1);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f17390f.findViewById(R.id.uninterested_btn);
                this.f17392h = tBSpecificationBtn;
                tBSpecificationBtn.setText(this.f17385a.getString(R.string.confirm_unlike_confirm));
                this.f17392h.setTextSize(R.dimen.T_X08);
                this.f17392h.setOnClickListener(this.t);
                c.a.q0.s.f0.n.b bVar = new c.a.q0.s.f0.n.b();
                this.f17393i = bVar;
                bVar.r(R.color.CAM_X0304);
                this.f17392h.setConfig(this.f17393i);
                ViewGroup viewGroup2 = this.f17390f;
                int i2 = this.f17394j;
                viewGroup2.setPadding(i2, 0, i2, 0);
            }
            j();
            return this.f17390f;
        }
        return (View) invokeV.objValue;
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ViewGroup viewGroup = this.f17390f;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.f17390f.getMeasuredHeight();
            this.o = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f17394j = l.g(this.f17385a.getContext(), R.dimen.M_W_X005);
            this.k = l.g(this.f17385a.getContext(), R.dimen.M_W_X004);
            this.l = l.g(this.f17385a.getContext(), R.dimen.tbds14);
            this.p = l.g(this.f17385a.getContext(), R.dimen.tbds160);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f17385a.getContext() == null) {
            return;
        }
        View k = k();
        this.n = l.k(this.f17385a.getContext()) - (this.k * 2);
        this.m = l();
        int[] iArr = new int[2];
        boolean i2 = i(this.f17385a.getContext(), this.q, this.m, this.n, this.p, this.l, iArr);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0204));
        gradientDrawable.setCornerRadius(l.g(this.f17385a.getContext(), R.dimen.tbds31));
        k.setBackgroundDrawable(gradientDrawable);
        PopupWindow popupWindow = new PopupWindow(k, this.n, l());
        this.f17388d = popupWindow;
        popupWindow.setFocusable(true);
        this.f17388d.setTouchable(true);
        this.f17388d.setOnDismissListener(this.s);
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.f17385a.getPageActivity()).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.f17389e = popupWindow2;
        if (Build.VERSION.SDK_INT >= 22) {
            popupWindow2.setAttachedInDecor(false);
        }
        this.f17389e.showAtLocation(this.q, 0, 0, 0);
        if (iArr[0] == 0 && iArr[1] == 0) {
            return;
        }
        this.f17388d.setBackgroundDrawable(new ColorDrawable(0));
        if (i2) {
            this.f17388d.setAnimationStyle(R.style.scale_rb2lt_anim);
        } else {
            this.f17388d.setAnimationStyle(R.style.scale_rt2lb_anim);
        }
        this.f17388d.showAtLocation(this.q, 0, iArr[0] - this.k, iArr[1]);
    }
}

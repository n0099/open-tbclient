package c.a.t0.k0;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.s.q.d2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
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
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.s0.t.e.a f19175b;

    /* renamed from: c  reason: collision with root package name */
    public d2 f19176c;

    /* renamed from: d  reason: collision with root package name */
    public PopupWindow f19177d;

    /* renamed from: e  reason: collision with root package name */
    public PopupWindow f19178e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f19179f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19180g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f19181h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.s0.s.i0.n.b f19182i;

    /* renamed from: j  reason: collision with root package name */
    public int f19183j;

    /* renamed from: k  reason: collision with root package name */
    public int f19184k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public View q;
    public int r;
    public PopupWindow.OnDismissListener s;
    public View.OnClickListener t;

    /* loaded from: classes7.dex */
    public class a implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f19185e;

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
            this.f19185e = iVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19185e.f19178e == null) {
                return;
            }
            this.f19185e.f19178e.dismiss();
            this.f19185e.f19178e = null;
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f19186e;

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
            this.f19186e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!l.A()) {
                    this.f19186e.a.showToast(R.string.network_ungeilivable);
                }
                if (ViewHelper.checkUpIsLogin(this.f19186e.a.getPageActivity())) {
                    if (this.f19186e.f19176c == null) {
                        return;
                    }
                    this.f19186e.f19175b.l(false, this.f19186e.f19176c.J().getPortrait(), this.f19186e.f19176c.J().getUserId(), this.f19186e.f19176c.J().isGod(), "0", this.f19186e.a.getUniqueId(), null, "0");
                    TiebaStatic.log(new StatisticItem("c13571"));
                }
                if (this.f19186e.f19178e == null || this.f19186e.f19177d == null) {
                    return;
                }
                this.f19186e.f19178e.dismiss();
                this.f19186e.f19177d.dismiss();
                this.f19186e.f19177d = null;
                this.f19186e.f19178e = null;
            }
        }
    }

    public i(TbPageContext tbPageContext, View view) {
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
        this.a = tbPageContext;
        this.f19175b = new c.a.s0.t.e.a(tbPageContext);
        this.q = view;
        m();
    }

    public void h(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) {
            this.f19176c = d2Var;
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
            int i6 = n.i(context);
            int k2 = n.k(context);
            boolean z = ((i6 - iArr2[1]) - height) - i4 < i2;
            iArr[0] = k2 - i3;
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
        SkinManager.setViewTextColor(this.f19180g, R.color.CAM_X0105, 1);
        this.r = skinType;
    }

    public final View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.getContext() == null) {
                return null;
            }
            if (this.f19179f == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.a.getContext()).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
                this.f19179f = viewGroup;
                TextView textView = (TextView) viewGroup.findViewById(R.id.head_text);
                this.f19180g = textView;
                textView.setText(this.a.getString(R.string.confirm_unlike));
                SkinManager.setViewTextColor(this.f19180g, R.color.CAM_X0105, 1);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f19179f.findViewById(R.id.uninterested_btn);
                this.f19181h = tBSpecificationBtn;
                tBSpecificationBtn.setText(this.a.getString(R.string.confirm_unlike_confirm));
                this.f19181h.setTextSize(R.dimen.T_X08);
                this.f19181h.setOnClickListener(this.t);
                c.a.s0.s.i0.n.b bVar = new c.a.s0.s.i0.n.b();
                this.f19182i = bVar;
                bVar.r(R.color.CAM_X0304);
                this.f19181h.setConfig(this.f19182i);
                ViewGroup viewGroup2 = this.f19179f;
                int i2 = this.f19183j;
                viewGroup2.setPadding(i2, 0, i2, 0);
            }
            j();
            return this.f19179f;
        }
        return (View) invokeV.objValue;
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ViewGroup viewGroup = this.f19179f;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.f19179f.getMeasuredHeight();
            this.o = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f19183j = n.f(this.a.getContext(), R.dimen.M_W_X005);
            this.f19184k = n.f(this.a.getContext(), R.dimen.M_W_X004);
            this.l = n.f(this.a.getContext(), R.dimen.tbds14);
            this.p = n.f(this.a.getContext(), R.dimen.tbds160);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.a.getContext() == null) {
            return;
        }
        View k2 = k();
        this.n = n.k(this.a.getContext()) - (this.f19184k * 2);
        this.m = l();
        int[] iArr = new int[2];
        boolean i2 = i(this.a.getContext(), this.q, this.m, this.n, this.p, this.l, iArr);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0204));
        gradientDrawable.setCornerRadius(n.f(this.a.getContext(), R.dimen.tbds31));
        k2.setBackgroundDrawable(gradientDrawable);
        PopupWindow popupWindow = new PopupWindow(k2, this.n, l());
        this.f19177d = popupWindow;
        popupWindow.setFocusable(true);
        this.f19177d.setTouchable(true);
        this.f19177d.setOnDismissListener(this.s);
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.f19178e = popupWindow2;
        if (Build.VERSION.SDK_INT >= 22) {
            popupWindow2.setAttachedInDecor(false);
        }
        this.f19178e.showAtLocation(this.q, 0, 0, 0);
        if (iArr[0] == 0 && iArr[1] == 0) {
            return;
        }
        this.f19177d.setBackgroundDrawable(new ColorDrawable(0));
        if (i2) {
            this.f19177d.setAnimationStyle(R.style.scale_rb2lt_anim);
        } else {
            this.f19177d.setAnimationStyle(R.style.scale_rt2lb_anim);
        }
        this.f19177d.showAtLocation(this.q, 0, iArr[0] - this.f19184k, iArr[1]);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
    }
}

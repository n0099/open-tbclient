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
import c.a.s0.s.q.e2;
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
    public c.a.s0.t.e.a f18669b;

    /* renamed from: c  reason: collision with root package name */
    public e2 f18670c;

    /* renamed from: d  reason: collision with root package name */
    public PopupWindow f18671d;

    /* renamed from: e  reason: collision with root package name */
    public PopupWindow f18672e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f18673f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18674g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f18675h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.s0.s.k0.n.b f18676i;

    /* renamed from: j  reason: collision with root package name */
    public int f18677j;
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

    /* loaded from: classes7.dex */
    public class a implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f18678e;

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
            this.f18678e = iVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18678e.f18672e == null) {
                return;
            }
            this.f18678e.f18672e.dismiss();
            this.f18678e.f18672e = null;
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f18679e;

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
            this.f18679e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!l.A()) {
                    this.f18679e.a.showToast(R.string.network_ungeilivable);
                }
                if (ViewHelper.checkUpIsLogin(this.f18679e.a.getPageActivity())) {
                    if (this.f18679e.f18670c == null) {
                        return;
                    }
                    this.f18679e.f18669b.l(false, this.f18679e.f18670c.J().getPortrait(), this.f18679e.f18670c.J().getUserId(), this.f18679e.f18670c.J().isGod(), "0", this.f18679e.a.getUniqueId(), null, "0");
                    TiebaStatic.log(new StatisticItem("c13571"));
                }
                if (this.f18679e.f18672e == null || this.f18679e.f18671d == null) {
                    return;
                }
                this.f18679e.f18672e.dismiss();
                this.f18679e.f18671d.dismiss();
                this.f18679e.f18671d = null;
                this.f18679e.f18672e = null;
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
        this.f18669b = new c.a.s0.t.e.a(tbPageContext);
        this.q = view;
        m();
    }

    public void h(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, e2Var) == null) {
            this.f18670c = e2Var;
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
            int k = n.k(context);
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
        SkinManager.setViewTextColor(this.f18674g, R.color.CAM_X0105, 1);
        this.r = skinType;
    }

    public final View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.getContext() == null) {
                return null;
            }
            if (this.f18673f == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.a.getContext()).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
                this.f18673f = viewGroup;
                TextView textView = (TextView) viewGroup.findViewById(R.id.head_text);
                this.f18674g = textView;
                textView.setText(this.a.getString(R.string.confirm_unlike));
                SkinManager.setViewTextColor(this.f18674g, R.color.CAM_X0105, 1);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f18673f.findViewById(R.id.uninterested_btn);
                this.f18675h = tBSpecificationBtn;
                tBSpecificationBtn.setText(this.a.getString(R.string.confirm_unlike_confirm));
                this.f18675h.setTextSize(R.dimen.T_X08);
                this.f18675h.setOnClickListener(this.t);
                c.a.s0.s.k0.n.b bVar = new c.a.s0.s.k0.n.b();
                this.f18676i = bVar;
                bVar.r(R.color.CAM_X0304);
                this.f18675h.setConfig(this.f18676i);
                ViewGroup viewGroup2 = this.f18673f;
                int i2 = this.f18677j;
                viewGroup2.setPadding(i2, 0, i2, 0);
            }
            j();
            return this.f18673f;
        }
        return (View) invokeV.objValue;
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ViewGroup viewGroup = this.f18673f;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.f18673f.getMeasuredHeight();
            this.o = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f18677j = n.f(this.a.getContext(), R.dimen.M_W_X005);
            this.k = n.f(this.a.getContext(), R.dimen.M_W_X004);
            this.l = n.f(this.a.getContext(), R.dimen.tbds14);
            this.p = n.f(this.a.getContext(), R.dimen.tbds160);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.a.getContext() == null) {
            return;
        }
        View k = k();
        this.n = n.k(this.a.getContext()) - (this.k * 2);
        this.m = l();
        int[] iArr = new int[2];
        boolean i2 = i(this.a.getContext(), this.q, this.m, this.n, this.p, this.l, iArr);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0204));
        gradientDrawable.setCornerRadius(n.f(this.a.getContext(), R.dimen.tbds31));
        k.setBackgroundDrawable(gradientDrawable);
        PopupWindow popupWindow = new PopupWindow(k, this.n, l());
        this.f18671d = popupWindow;
        popupWindow.setFocusable(true);
        this.f18671d.setTouchable(true);
        this.f18671d.setOnDismissListener(this.s);
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.f18672e = popupWindow2;
        if (Build.VERSION.SDK_INT >= 22) {
            popupWindow2.setAttachedInDecor(false);
        }
        this.f18672e.showAtLocation(this.q, 0, 0, 0);
        if (iArr[0] == 0 && iArr[1] == 0) {
            return;
        }
        this.f18671d.setBackgroundDrawable(new ColorDrawable(0));
        if (i2) {
            this.f18671d.setAnimationStyle(R.style.scale_rb2lt_anim);
        } else {
            this.f18671d.setAnimationStyle(R.style.scale_rt2lb_anim);
        }
        this.f18671d.showAtLocation(this.q, 0, iArr[0] - this.k, iArr[1]);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
    }
}

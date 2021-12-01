package c.a.r0.v3;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.j;
import c.a.d.f.p.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbean.BuyTBeanActivity;
import com.baidu.tieba.tbean.view.BuyTBeanGiftBagView;
import com.baidu.tieba.tbean.view.RoundRelativeLayout;
import com.baidu.tieba.view.NoScrollGridView;
import com.baidu.tieba.view.bubbleView.BubbleLayout;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.GetIconList.Custom;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.Setting;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public RelativeLayout D;
    public BubbleLayout E;
    public boolean F;
    public View.OnClickListener G;
    public View.OnClickListener H;
    public AdapterView.OnItemClickListener I;
    public BuyTBeanGiftBagView.b J;
    public Runnable K;
    public TextWatcher L;
    public BuyTBeanActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f24925b;

    /* renamed from: c  reason: collision with root package name */
    public RoundRelativeLayout f24926c;

    /* renamed from: d  reason: collision with root package name */
    public NoScrollGridView f24927d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.v3.d.a f24928e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24929f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24930g;

    /* renamed from: h  reason: collision with root package name */
    public EditText f24931h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f24932i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.v3.e.c f24933j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f24934k;
    public LinearLayout l;
    public TextView m;
    public boolean n;
    public TextView o;
    public LinearLayout p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public SpannableString u;
    public ImageView v;
    public TextView w;
    public BuyTBeanGiftBagView x;
    public UserInfo y;
    public RelativeLayout z;

    /* renamed from: c.a.r0.v3.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1424a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24935e;

        public View$OnClickListenerC1424a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24935e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f24935e.f24931h.requestFocus();
                l.K(this.f24935e.a, this.f24935e.f24931h);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24936e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24936e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f24936e.u();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24937e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24937e = aVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            c.a.r0.v3.e.b item;
            IconInfo iconInfo;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (item = this.f24937e.f24928e.getItem(i2)) == null || (iconInfo = item.f24949f) == null) {
                return;
            }
            this.f24937e.E(item.f24949f.iconId, c.a.r0.v3.b.d(iconInfo.dubi.intValue()) * 1, 1, c.a.r0.v3.b.c(this.f24937e.y, item.f24949f.non_member_t.intValue(), item.f24948e) * 1);
            StatisticItem statisticItem = new StatisticItem("c13147");
            statisticItem.param("obj_param1", item.f24949f.iconId);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements BuyTBeanGiftBagView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.tieba.tbean.view.BuyTBeanGiftBagView.b
        public void a(c.a.r0.v3.e.a aVar) {
            Custom custom;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || (custom = aVar.f24945e) == null) {
                return;
            }
            this.a.E(aVar.f24945e.icon_id, c.a.r0.v3.b.d(custom.dubi.intValue()) * 1, 1, aVar.f24945e.non_member_t.intValue() * 1);
            TiebaStatic.log("c13144");
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24938e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24938e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f24938e.E == null) {
                return;
            }
            this.f24938e.E.setVisibility(8);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24939e;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24939e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                String obj = this.f24939e.f24931h.getText().toString();
                if (StringUtils.isNull(obj)) {
                    if (this.f24939e.n) {
                        this.f24939e.f24934k.setVisibility(8);
                        this.f24939e.m.setText(String.format(this.f24939e.a.getString(R.string.user_define_member_tbean_extra), this.f24939e.f24933j.f24953g.vip_extra_percent));
                    }
                    this.f24939e.o.setEnabled(false);
                    this.f24939e.f24931h.setHint(this.f24939e.u);
                } else if (obj.startsWith("0")) {
                    if (this.f24939e.n) {
                        this.f24939e.f24934k.setVisibility(8);
                        this.f24939e.m.setText(String.format(this.f24939e.a.getString(R.string.user_define_member_tbean_extra), this.f24939e.f24933j.f24953g.vip_extra_percent));
                    }
                    this.f24939e.f24931h.setText("");
                } else {
                    this.f24939e.o.setEnabled(true);
                    if (!StringUtils.isNull(obj) && obj.length() >= 7) {
                        this.f24939e.a.showToast(R.string.buy_tbean_custom_price_max);
                        String substring = obj.substring(0, 6);
                        this.f24939e.f24931h.setText(substring);
                        this.f24939e.f24931h.setSelection(substring.length());
                        return;
                    }
                    long g2 = c.a.d.f.m.b.g(obj, 0L);
                    if (g2 > 200000) {
                        this.f24939e.a.showToast(R.string.buy_tbean_custom_price_max);
                    }
                    if (g2 <= 0) {
                        this.f24939e.f24932i.setText(R.string.user_define_init_value);
                        return;
                    }
                    this.f24939e.f24931h.setHint("");
                    long j2 = g2 * 1000;
                    this.f24939e.f24932i.setText(StringHelper.formatTosepara(j2));
                    if (!this.f24939e.n || this.f24939e.f24933j == null || this.f24939e.f24933j.f24953g == null) {
                        return;
                    }
                    this.f24939e.f24934k.setVisibility(0);
                    this.f24939e.f24934k.setText(c.a.r0.v3.b.b((j2 * this.f24939e.f24933j.f24953g.vip_extra_percent.intValue()) / 100));
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24940e;

        public g(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24940e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredHeight = this.f24940e.f24925b.getMeasuredHeight();
                int measuredHeight2 = this.f24940e.p.getMeasuredHeight();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f24940e.p.getLayoutParams();
                if (layoutParams != null) {
                    this.f24940e.C = measuredHeight - measuredHeight2;
                    layoutParams.topMargin = this.f24940e.C;
                    this.f24940e.p.setLayoutParams(layoutParams);
                }
                a aVar = this.f24940e;
                aVar.A = aVar.z.getHeight();
            }
        }
    }

    public a(BuyTBeanActivity buyTBeanActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {buyTBeanActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.G = new View$OnClickListenerC1424a(this);
        this.H = new b(this);
        this.I = new c(this);
        this.J = new d(this);
        this.K = new e(this);
        this.L = new f(this);
        this.a = buyTBeanActivity;
        z();
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.F : invokeV.booleanValue;
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.p);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f24930g, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.f24929f, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.s, R.color.common_color_10191, 1, i2);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0107, 1, i2);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1, i2);
            if (i2 != 1 && i2 != 4) {
                this.f24926c.setBgColorRes(R.color.CAM_X0201);
            } else {
                this.f24926c.setBgColorRes(R.color.CAM_X0201_1);
            }
            SkinManager.setViewTextColor(this.f24932i, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0107, 1, i2);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1, i2);
            SkinManager.setViewTextColor(this.f24934k, R.color.CAM_X0107, 1, i2);
            SkinManager.setViewTextColor(this.f24931h, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor((TextView) this.f24925b.findViewById(R.id.buy_tbean_custom_price_prefix), R.color.CAM_X0105, 1, i2);
            c.a.r0.v3.d.a aVar = this.f24928e;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.K);
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.F = true;
                if (this.B <= 0) {
                    this.B = (l.i(this.a) - this.f24925b.getHeight()) - l.r(this.a);
                }
                int height = ((this.B + this.f24926c.getHeight()) + this.D.getHeight()) - this.A;
                if (height > 0) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.p.getLayoutParams();
                    layoutParams.topMargin -= height;
                    this.p.setLayoutParams(layoutParams);
                    this.z.scrollTo(0, this.B - height);
                } else {
                    this.z.scrollTo(0, this.B);
                }
                EditText editText = this.f24931h;
                editText.setSelection(editText.getText().length());
                TiebaStatic.log("c13145");
                return;
            }
            this.F = false;
            this.z.scrollTo(0, 0);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.p.getLayoutParams();
            layoutParams2.topMargin = this.C;
            this.p.setLayoutParams(layoutParams2);
            this.f24931h.clearFocus();
        }
    }

    public final void E(String str, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048580, this, str, i2, i3, i4) == null) || StringUtils.isNull(str) || i2 < 0 || i3 < 0 || i4 < 0) {
            return;
        }
        if (!j.z()) {
            BuyTBeanActivity buyTBeanActivity = this.a;
            buyTBeanActivity.showToast(buyTBeanActivity.getResources().getString(R.string.network_not_available));
            return;
        }
        c.a.r0.v3.c.a("c10296");
        PayConfig payConfig = new PayConfig(2, "0", str, String.valueOf(i2), String.valueOf(i3), true, String.valueOf(i4), this.a.isPayDialog(), PageDialogHelper.PayForm.NOT_SET, this.a.getReferPage(), this.a.getClickZone());
        payConfig.setFromDecreaseGiftStepStrategy(this.a.isFromDecreaseGiftStepStrategy());
        c.a.q0.q0.d.c().a(payConfig, this.a);
    }

    public final void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                this.o.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(0, R.id.buy_tbean_recharge);
                layoutParams.addRule(15);
                layoutParams.rightMargin = this.a.getResources().getDimensionPixelSize(R.dimen.ds34);
                this.f24931h.setLayoutParams(layoutParams);
                return;
            }
            this.o.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f24931h.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.addRule(11);
                layoutParams2.rightMargin = this.a.getResources().getDimensionPixelSize(R.dimen.ds42);
            }
        }
    }

    public void G(List<c.a.r0.v3.e.b> list, c.a.r0.v3.e.c cVar, List<c.a.r0.v3.e.a> list2, UserInfo userInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, list, cVar, list2, userInfo) == null) {
            if (userInfo != null) {
                this.y = userInfo;
            }
            if (!ListUtils.isEmpty(list)) {
                int i2 = ListUtils.getCount(list) == 6 ? 3 : 2;
                this.f24927d.setNumColumns(i2);
                this.f24928e.b(i2);
                this.f24928e.c(list);
            }
            if (cVar != null) {
                this.f24933j = cVar;
                Setting setting = cVar.f24953g;
                if (setting != null && setting.vip_extra_switch.intValue() == 1 && this.f24933j.f24953g.vip_extra_percent.intValue() > 0) {
                    this.n = true;
                    this.l.setVisibility(0);
                    this.f24934k.setVisibility(8);
                    this.m.setText(String.format(this.a.getString(R.string.user_define_member_tbean_extra), this.f24933j.f24953g.vip_extra_percent));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24926c.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = this.a.getResources().getDimensionPixelSize(R.dimen.tbds208);
                        this.f24926c.setLayoutParams(layoutParams);
                    }
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.width = this.a.getResources().getDimensionPixelSize(R.dimen.tbds203);
                        this.o.setLayoutParams(layoutParams2);
                    }
                } else {
                    this.l.setVisibility(8);
                    this.n = false;
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f24926c.getLayoutParams();
                    if (layoutParams3 != null) {
                        layoutParams3.height = this.a.getResources().getDimensionPixelSize(R.dimen.tbds174);
                        this.f24926c.setLayoutParams(layoutParams3);
                    }
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
                    if (layoutParams4 != null) {
                        layoutParams4.width = this.a.getResources().getDimensionPixelSize(R.dimen.tbds176);
                        this.o.setLayoutParams(layoutParams4);
                    }
                }
                Custom custom = this.f24933j.f24951e;
                if (custom != null) {
                    Integer num = custom.duration;
                    this.w.setText(this.a.getString(R.string.icon_name_valid_day, new Object[]{this.f24933j.f24951e.name, Integer.valueOf(num == null ? 0 : num.intValue())}));
                }
            }
            if (!ListUtils.isEmpty(list2)) {
                this.x.onBindData(list2);
            }
            this.p.post(new g(this));
        }
    }

    public void H(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            if (f2 > 0.0f) {
                EditText editText = this.f24931h;
                StringBuilder sb = new StringBuilder();
                float f3 = f2 / 1000.0f;
                sb.append(f3);
                sb.append("");
                editText.setText(sb.toString());
                EditText editText2 = this.f24931h;
                editText2.setSelection(editText2.getText().length());
                TextView textView = this.s;
                textView.setText((f3 * 1000.0f) + "");
                this.s.setVisibility(0);
                this.t.setVisibility(0);
                if (c.a.q0.s.e0.b.j().g("key_tbean_buy_bubble_show", false)) {
                    return;
                }
                BubbleLayout bubbleLayout = this.E;
                if (bubbleLayout != null) {
                    bubbleLayout.setVisibility(0);
                    c.a.q0.s.e0.b.j().t("key_tbean_buy_bubble_show", true);
                }
                c.a.d.f.m.e.a().removeCallbacks(this.K);
                c.a.d.f.m.e.a().postDelayed(this.K, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
                return;
            }
            this.f24931h.setText("");
            this.E.setVisibility(8);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.p.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin = this.a.getResources().getDimensionPixelSize(R.dimen.ds500);
                this.p.setLayoutParams(layoutParams);
            }
            BuyTBeanActivity buyTBeanActivity = this.a;
            buyTBeanActivity.setNetRefreshViewTopMargin(buyTBeanActivity.getResources().getDimensionPixelSize(R.dimen.ds50));
            BuyTBeanActivity buyTBeanActivity2 = this.a;
            buyTBeanActivity2.showNetRefreshView(this.z, buyTBeanActivity2.getResources().getString(R.string.neterror));
        }
    }

    public void J() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (view = this.f24925b) == null) {
            return;
        }
        view.setVisibility(0);
    }

    public final void u() {
        c.a.r0.v3.e.c cVar;
        UserInfo userInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int e2 = c.a.d.f.m.b.e(this.f24931h.getText().toString(), 0);
            int i2 = e2 * 1;
            if (i2 > 200000) {
                this.a.showToast(R.string.buy_tbean_custom_price_max);
            } else if (i2 <= 0 || i2 <= 0 || (cVar = this.f24933j) == null || (userInfo = cVar.f24952f) == null || cVar.f24951e == null) {
            } else {
                E(this.f24933j.f24951e.icon_id, i2, e2, c.a.r0.v3.b.c(userInfo, i2 * 1000, cVar.f24953g) * 1);
                TiebaStatic.log("c13141");
            }
        }
    }

    public View v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f24925b : (View) invokeV.objValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.a.hideNetRefreshView(this.z);
        }
    }

    public void x() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (view = this.f24925b) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f24931h.clearFocus();
            l.w(this.a, this.f24931h);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.buy_tbean_view_layout, (ViewGroup) null);
            this.f24925b = inflate;
            inflate.setFocusable(true);
            this.f24925b.setOnClickListener(this.a);
            this.p = (LinearLayout) this.f24925b.findViewById(R.id.buy_tbean_panel_layout);
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) this.f24925b.findViewById(R.id.buy_tbean_custom_t_dou_layout);
            this.f24926c = roundRelativeLayout;
            roundRelativeLayout.setRadius(this.a.getResources().getDimensionPixelSize(R.dimen.ds6));
            this.f24926c.setOnClickListener(this.G);
            this.z = (RelativeLayout) this.f24925b.findViewById(R.id.buy_tbean_content_layout);
            this.r = (TextView) this.f24925b.findViewById(R.id.buy_tbean_title);
            this.f24927d = (NoScrollGridView) this.f24925b.findViewById(R.id.buy_tbean_gridview);
            c.a.r0.v3.d.a aVar = new c.a.r0.v3.d.a(this.a.getPageContext());
            this.f24928e = aVar;
            this.f24927d.setAdapter((ListAdapter) aVar);
            this.f24927d.setOnItemClickListener(this.I);
            this.D = (RelativeLayout) this.f24925b.findViewById(R.id.buy_tbean_balance_layout);
            this.f24930g = (TextView) this.f24925b.findViewById(R.id.buy_tbean_balance_tip);
            TextView textView = (TextView) this.f24925b.findViewById(R.id.buy_tbean_balance);
            this.f24929f = textView;
            textView.setText(String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum));
            Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.tbds46);
            normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.f24929f.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.tbds12));
            this.f24929f.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
            this.f24931h = (EditText) this.f24925b.findViewById(R.id.buy_tbean_custom_price_edit);
            this.u = new SpannableString(this.a.getString(R.string.buy_tbean_user_define_hint));
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(this.a.getResources().getDimensionPixelSize(R.dimen.tbds42), false);
            SpannableString spannableString = this.u;
            spannableString.setSpan(absoluteSizeSpan, 0, spannableString.length(), 33);
            this.f24931h.setHint(this.u);
            this.f24931h.addTextChangedListener(this.L);
            TextView textView2 = (TextView) this.f24925b.findViewById(R.id.buy_tbean_custom_t_dou_num);
            this.f24932i = textView2;
            textView2.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.ds8));
            this.f24932i.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
            this.l = (LinearLayout) this.f24925b.findViewById(R.id.buy_tbean_member_layout);
            this.f24934k = (TextView) this.f24925b.findViewById(R.id.buy_tbean_member_privilege);
            Drawable normalSkinMoneyIcon2 = CurrencySwitchUtil.getNormalSkinMoneyIcon();
            int dimensionPixelSize2 = this.a.getResources().getDimensionPixelSize(R.dimen.ds20);
            normalSkinMoneyIcon2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
            this.f24934k.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.ds6));
            this.f24934k.setCompoundDrawables(normalSkinMoneyIcon2, null, null, null);
            this.m = (TextView) this.f24925b.findViewById(R.id.buy_tbean_member_prefix);
            TextView textView3 = (TextView) this.f24925b.findViewById(R.id.buy_tbean_recharge);
            this.o = textView3;
            textView3.setOnClickListener(this.H);
            TextView textView4 = (TextView) this.f24925b.findViewById(R.id.buy_tbean_use_rule);
            this.q = textView4;
            textView4.setOnClickListener(this.a);
            TextView textView5 = (TextView) this.f24925b.findViewById(R.id.buy_tbean_diff_value);
            this.s = textView5;
            textView5.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.ds8));
            this.s.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
            this.t = (TextView) this.f24925b.findViewById(R.id.buy_tbean_diff_value_tip);
            ImageView imageView = (ImageView) this.f24925b.findViewById(R.id.buy_tbean_close_image);
            this.v = imageView;
            imageView.setOnClickListener(this.a);
            this.w = (TextView) this.f24925b.findViewById(R.id.buy_tbean_yinji_time);
            BuyTBeanGiftBagView buyTBeanGiftBagView = (BuyTBeanGiftBagView) this.f24925b.findViewById(R.id.buy_tbean_gift_bag_layout);
            this.x = buyTBeanGiftBagView;
            buyTBeanGiftBagView.setClickListener(this.J);
            this.E = (BubbleLayout) this.f24925b.findViewById(R.id.buy_tbean_pop_view);
            F(true);
        }
    }
}

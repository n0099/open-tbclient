package c.a.p0.b4;

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
import c.a.d.f.p.l;
import c.a.d.f.p.n;
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
import com.baidu.tbadk.util.PageDialogHelper$PayForm;
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
/* loaded from: classes2.dex */
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
    public View f12823b;

    /* renamed from: c  reason: collision with root package name */
    public RoundRelativeLayout f12824c;

    /* renamed from: d  reason: collision with root package name */
    public NoScrollGridView f12825d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.b4.d.a f12826e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12827f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12828g;

    /* renamed from: h  reason: collision with root package name */
    public EditText f12829h;
    public TextView i;
    public c.a.p0.b4.e.c j;
    public TextView k;
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

    /* renamed from: c.a.p0.b4.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0967a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC0967a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.f12829h.requestFocus();
                n.L(this.a.a, this.a.f12829h);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.u();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            c.a.p0.b4.e.b item;
            IconInfo iconInfo;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) || (item = this.a.f12826e.getItem(i)) == null || (iconInfo = item.f12835b) == null) {
                return;
            }
            this.a.E(item.f12835b.iconId, c.a.p0.b4.b.d(iconInfo.dubi.intValue()) * 1, 1, c.a.p0.b4.b.c(this.a.y, item.f12835b.non_member_t.intValue(), item.a) * 1);
            StatisticItem statisticItem = new StatisticItem("c13147");
            statisticItem.param("obj_param1", item.f12835b.iconId);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.tieba.tbean.view.BuyTBeanGiftBagView.b
        public void a(c.a.p0.b4.e.a aVar) {
            Custom custom;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || (custom = aVar.a) == null) {
                return;
            }
            this.a.E(aVar.a.icon_id, c.a.p0.b4.b.d(custom.dubi.intValue()) * 1, 1, aVar.a.non_member_t.intValue() * 1);
            TiebaStatic.log("c13144");
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.E == null) {
                return;
            }
            this.a.E.setVisibility(8);
        }
    }

    /* loaded from: classes2.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                String obj = this.a.f12829h.getText().toString();
                if (StringUtils.isNull(obj)) {
                    if (this.a.n) {
                        this.a.k.setVisibility(8);
                        this.a.m.setText(String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f14a3), this.a.j.f12838c.vip_extra_percent));
                    }
                    this.a.o.setEnabled(false);
                    this.a.f12829h.setHint(this.a.u);
                } else if (obj.startsWith("0")) {
                    if (this.a.n) {
                        this.a.k.setVisibility(8);
                        this.a.m.setText(String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f14a3), this.a.j.f12838c.vip_extra_percent));
                    }
                    this.a.f12829h.setText("");
                } else {
                    this.a.o.setEnabled(true);
                    if (!StringUtils.isNull(obj) && obj.length() >= 7) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f034a);
                        String substring = obj.substring(0, 6);
                        this.a.f12829h.setText(substring);
                        this.a.f12829h.setSelection(substring.length());
                        return;
                    }
                    long g2 = c.a.d.f.m.b.g(obj, 0L);
                    if (g2 > 200000) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f034a);
                    }
                    if (g2 <= 0) {
                        this.a.i.setText(R.string.obfuscated_res_0x7f0f14a1);
                        return;
                    }
                    this.a.f12829h.setHint("");
                    long j = g2 * 1000;
                    this.a.i.setText(StringHelper.formatTosepara(j));
                    if (!this.a.n || this.a.j == null || this.a.j.f12838c == null) {
                        return;
                    }
                    this.a.k.setVisibility(0);
                    this.a.k.setText(c.a.p0.b4.b.b((j * this.a.j.f12838c.vip_extra_percent.intValue()) / 100));
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public g(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredHeight = this.a.f12823b.getMeasuredHeight();
                int measuredHeight2 = this.a.p.getMeasuredHeight();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.p.getLayoutParams();
                if (layoutParams != null) {
                    this.a.C = measuredHeight - measuredHeight2;
                    layoutParams.topMargin = this.a.C;
                    this.a.p.setLayoutParams(layoutParams);
                }
                a aVar = this.a;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.G = new View$OnClickListenerC0967a(this);
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

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.p);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f12828g, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.f12827f, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.s, R.color.common_color_10191, 1, i);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0107, 1, i);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1, i);
            if (i != 1 && i != 4) {
                this.f12824c.setBgColorRes(R.color.CAM_X0201);
            } else {
                this.f12824c.setBgColorRes(R.color.CAM_X0201_1);
            }
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0107, 1, i);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1, i);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1, i);
            SkinManager.setViewTextColor(this.f12829h, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor((TextView) this.f12823b.findViewById(R.id.obfuscated_res_0x7f090468), R.color.CAM_X0105, 1, i);
            c.a.p0.b4.d.a aVar = this.f12826e;
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
                    this.B = (n.i(this.a) - this.f12823b.getHeight()) - n.r(this.a);
                }
                int height = ((this.B + this.f12824c.getHeight()) + this.D.getHeight()) - this.A;
                if (height > 0) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.p.getLayoutParams();
                    layoutParams.topMargin -= height;
                    this.p.setLayoutParams(layoutParams);
                    this.z.scrollTo(0, this.B - height);
                } else {
                    this.z.scrollTo(0, this.B);
                }
                EditText editText = this.f12829h;
                editText.setSelection(editText.getText().length());
                TiebaStatic.log("c13145");
                return;
            }
            this.F = false;
            this.z.scrollTo(0, 0);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.p.getLayoutParams();
            layoutParams2.topMargin = this.C;
            this.p.setLayoutParams(layoutParams2);
            this.f12829h.clearFocus();
        }
    }

    public final void E(String str, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048580, this, str, i, i2, i3) == null) || StringUtils.isNull(str) || i < 0 || i2 < 0 || i3 < 0) {
            return;
        }
        if (!l.z()) {
            BuyTBeanActivity buyTBeanActivity = this.a;
            buyTBeanActivity.showToast(buyTBeanActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0c16));
            return;
        }
        c.a.p0.b4.c.a("c10296");
        PayConfig payConfig = new PayConfig(2, "0", str, String.valueOf(i), String.valueOf(i2), true, String.valueOf(i3), this.a.isPayDialog(), PageDialogHelper$PayForm.NOT_SET, this.a.getReferPage(), this.a.getClickZone());
        payConfig.setFromDecreaseGiftStepStrategy(this.a.isFromDecreaseGiftStepStrategy());
        c.a.o0.q0.e.c().a(payConfig, this.a);
    }

    public final void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                this.o.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(0, R.id.obfuscated_res_0x7f090477);
                layoutParams.addRule(15);
                layoutParams.rightMargin = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07020f);
                this.f12829h.setLayoutParams(layoutParams);
                return;
            }
            this.o.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f12829h.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.addRule(11);
                layoutParams2.rightMargin = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b4);
            }
        }
    }

    public void G(List<c.a.p0.b4.e.b> list, c.a.p0.b4.e.c cVar, List<c.a.p0.b4.e.a> list2, UserInfo userInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, list, cVar, list2, userInfo) == null) {
            if (userInfo != null) {
                this.y = userInfo;
            }
            if (!ListUtils.isEmpty(list)) {
                int i = ListUtils.getCount(list) == 6 ? 3 : 2;
                this.f12825d.setNumColumns(i);
                this.f12826e.b(i);
                this.f12826e.c(list);
            }
            if (cVar != null) {
                this.j = cVar;
                Setting setting = cVar.f12838c;
                if (setting != null && setting.vip_extra_switch.intValue() == 1 && this.j.f12838c.vip_extra_percent.intValue() > 0) {
                    this.n = true;
                    this.l.setVisibility(0);
                    this.k.setVisibility(8);
                    this.m.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f14a3), this.j.f12838c.vip_extra_percent));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f12824c.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = this.a.getResources().getDimensionPixelSize(R.dimen.tbds208);
                        this.f12824c.setLayoutParams(layoutParams);
                    }
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.width = this.a.getResources().getDimensionPixelSize(R.dimen.tbds203);
                        this.o.setLayoutParams(layoutParams2);
                    }
                } else {
                    this.l.setVisibility(8);
                    this.n = false;
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f12824c.getLayoutParams();
                    if (layoutParams3 != null) {
                        layoutParams3.height = this.a.getResources().getDimensionPixelSize(R.dimen.tbds174);
                        this.f12824c.setLayoutParams(layoutParams3);
                    }
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
                    if (layoutParams4 != null) {
                        layoutParams4.width = this.a.getResources().getDimensionPixelSize(R.dimen.tbds176);
                        this.o.setLayoutParams(layoutParams4);
                    }
                }
                Custom custom = this.j.a;
                if (custom != null) {
                    Integer num = custom.duration;
                    this.w.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0896, new Object[]{this.j.a.name, Integer.valueOf(num == null ? 0 : num.intValue())}));
                }
            }
            if (!ListUtils.isEmpty(list2)) {
                this.x.d(list2);
            }
            this.p.post(new g(this));
        }
    }

    public void H(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            if (f2 > 0.0f) {
                EditText editText = this.f12829h;
                StringBuilder sb = new StringBuilder();
                float f3 = f2 / 1000.0f;
                sb.append(f3);
                sb.append("");
                editText.setText(sb.toString());
                EditText editText2 = this.f12829h;
                editText2.setSelection(editText2.getText().length());
                TextView textView = this.s;
                textView.setText((f3 * 1000.0f) + "");
                this.s.setVisibility(0);
                this.t.setVisibility(0);
                if (c.a.o0.r.j0.b.k().h("key_tbean_buy_bubble_show", false)) {
                    return;
                }
                BubbleLayout bubbleLayout = this.E;
                if (bubbleLayout != null) {
                    bubbleLayout.setVisibility(0);
                    c.a.o0.r.j0.b.k().u("key_tbean_buy_bubble_show", true);
                }
                c.a.d.f.m.e.a().removeCallbacks(this.K);
                c.a.d.f.m.e.a().postDelayed(this.K, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
                return;
            }
            this.f12829h.setText("");
            this.E.setVisibility(8);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.p.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702cc);
                this.p.setLayoutParams(layoutParams);
            }
            BuyTBeanActivity buyTBeanActivity = this.a;
            buyTBeanActivity.setNetRefreshViewTopMargin(buyTBeanActivity.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702cb));
            BuyTBeanActivity buyTBeanActivity2 = this.a;
            buyTBeanActivity2.showNetRefreshView(this.z, buyTBeanActivity2.getResources().getString(R.string.obfuscated_res_0x7f0f0c15));
        }
    }

    public void J() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (view = this.f12823b) == null) {
            return;
        }
        view.setVisibility(0);
    }

    public final void u() {
        c.a.p0.b4.e.c cVar;
        UserInfo userInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int e2 = c.a.d.f.m.b.e(this.f12829h.getText().toString(), 0);
            int i = e2 * 1;
            if (i > 200000) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f034a);
            } else if (i <= 0 || i <= 0 || (cVar = this.j) == null || (userInfo = cVar.f12837b) == null || cVar.a == null) {
            } else {
                E(this.j.a.icon_id, i, e2, c.a.p0.b4.b.c(userInfo, i * 1000, cVar.f12838c) * 1);
                TiebaStatic.log("c13141");
            }
        }
    }

    public View v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f12823b : (View) invokeV.objValue;
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
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (view = this.f12823b) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f12829h.clearFocus();
            n.w(this.a, this.f12829h);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d016f, (ViewGroup) null);
            this.f12823b = inflate;
            inflate.setFocusable(true);
            this.f12823b.setOnClickListener(this.a);
            this.p = (LinearLayout) this.f12823b.findViewById(R.id.obfuscated_res_0x7f090473);
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) this.f12823b.findViewById(R.id.obfuscated_res_0x7f090469);
            this.f12824c = roundRelativeLayout;
            roundRelativeLayout.setRadius(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702df));
            this.f12824c.setOnClickListener(this.G);
            this.z = (RelativeLayout) this.f12823b.findViewById(R.id.obfuscated_res_0x7f090466);
            this.r = (TextView) this.f12823b.findViewById(R.id.obfuscated_res_0x7f09047a);
            this.f12825d = (NoScrollGridView) this.f12823b.findViewById(R.id.obfuscated_res_0x7f09046e);
            c.a.p0.b4.d.a aVar = new c.a.p0.b4.d.a(this.a.getPageContext());
            this.f12826e = aVar;
            this.f12825d.setAdapter((ListAdapter) aVar);
            this.f12825d.setOnItemClickListener(this.I);
            this.D = (RelativeLayout) this.f12823b.findViewById(R.id.obfuscated_res_0x7f090463);
            this.f12828g = (TextView) this.f12823b.findViewById(R.id.obfuscated_res_0x7f090464);
            TextView textView = (TextView) this.f12823b.findViewById(R.id.obfuscated_res_0x7f090462);
            this.f12827f = textView;
            textView.setText(String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum));
            Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.tbds46);
            normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.f12827f.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.tbds12));
            this.f12827f.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
            this.f12829h = (EditText) this.f12823b.findViewById(R.id.obfuscated_res_0x7f090467);
            this.u = new SpannableString(this.a.getString(R.string.obfuscated_res_0x7f0f0356));
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(this.a.getResources().getDimensionPixelSize(R.dimen.tbds42), false);
            SpannableString spannableString = this.u;
            spannableString.setSpan(absoluteSizeSpan, 0, spannableString.length(), 33);
            this.f12829h.setHint(this.u);
            this.f12829h.addTextChangedListener(this.L);
            TextView textView2 = (TextView) this.f12823b.findViewById(R.id.obfuscated_res_0x7f09046a);
            this.i = textView2;
            textView2.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702fb));
            this.i.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
            this.l = (LinearLayout) this.f12823b.findViewById(R.id.obfuscated_res_0x7f09046f);
            this.k = (TextView) this.f12823b.findViewById(R.id.obfuscated_res_0x7f090471);
            Drawable normalSkinMoneyIcon2 = CurrencySwitchUtil.getNormalSkinMoneyIcon();
            int dimensionPixelSize2 = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
            normalSkinMoneyIcon2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
            this.k.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702df));
            this.k.setCompoundDrawables(normalSkinMoneyIcon2, null, null, null);
            this.m = (TextView) this.f12823b.findViewById(R.id.obfuscated_res_0x7f090470);
            TextView textView3 = (TextView) this.f12823b.findViewById(R.id.obfuscated_res_0x7f090477);
            this.o = textView3;
            textView3.setOnClickListener(this.H);
            TextView textView4 = (TextView) this.f12823b.findViewById(R.id.obfuscated_res_0x7f09047b);
            this.q = textView4;
            textView4.setOnClickListener(this.a);
            TextView textView5 = (TextView) this.f12823b.findViewById(R.id.obfuscated_res_0x7f09046b);
            this.s = textView5;
            textView5.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702fb));
            this.s.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
            this.t = (TextView) this.f12823b.findViewById(R.id.obfuscated_res_0x7f09046c);
            ImageView imageView = (ImageView) this.f12823b.findViewById(R.id.obfuscated_res_0x7f090465);
            this.v = imageView;
            imageView.setOnClickListener(this.a);
            this.w = (TextView) this.f12823b.findViewById(R.id.obfuscated_res_0x7f09047c);
            BuyTBeanGiftBagView buyTBeanGiftBagView = (BuyTBeanGiftBagView) this.f12823b.findViewById(R.id.obfuscated_res_0x7f09046d);
            this.x = buyTBeanGiftBagView;
            buyTBeanGiftBagView.setClickListener(this.J);
            this.E = (BubbleLayout) this.f12823b.findViewById(R.id.obfuscated_res_0x7f090474);
            F(true);
        }
    }
}

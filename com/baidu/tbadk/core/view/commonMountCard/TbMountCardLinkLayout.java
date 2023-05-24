package com.baidu.tbadk.core.view.commonMountCard;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbMountCardLinkHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.data.CardLinkInfoData;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.in5;
import com.baidu.tieba.o75;
import com.baidu.tieba.p45;
import com.baidu.tieba.q75;
import com.baidu.tieba.ri;
import com.baidu.tieba.t65;
import com.baidu.tieba.xp9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TbMountCardLinkLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public CardLinkInfoData b;
    public q75 c;
    public View d;
    public TbImageView e;
    public View f;
    public TextView g;
    public TextView h;
    public TextView i;
    public FrameLayout j;
    public TBSpecificationBtn k;
    public ImageView l;
    public ImageView m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1742149398, "Lcom/baidu/tbadk/core/view/commonMountCard/TbMountCardLinkLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1742149398, "Lcom/baidu/tbadk/core/view/commonMountCard/TbMountCardLinkLayout;");
                return;
            }
        }
        n = ri.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
        o = ri.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        p = ri.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
        q = ri.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
        r = ri.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
        s = ri.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
        t = ri.g(TbadkCoreApplication.getInst(), R.dimen.tbds38);
    }

    public final void b() {
        CardLinkInfoData cardLinkInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (cardLinkInfoData = this.b) == null) {
            return;
        }
        if (!StringUtils.isNull(cardLinkInfoData.getImageUrl())) {
            this.e.N(this.b.getImageUrl(), 10, false);
        }
        if (StringUtils.isNull(this.b.getContent1())) {
            this.h.setVisibility(8);
        } else {
            this.h.setVisibility(0);
            this.h.setText(this.b.getContent1());
        }
        if (StringUtils.isNull(this.b.getContent2())) {
            this.i.setVisibility(8);
        } else {
            this.i.setVisibility(0);
            this.i.setText(this.b.getContent2());
        }
        e();
    }

    public final void f() {
        CardLinkInfoData cardLinkInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || (cardLinkInfoData = this.b) == null) {
            return;
        }
        String tagText = cardLinkInfoData.getTagText();
        if (!StringUtils.isNull(tagText)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) tagText);
            int tagColorId = getTagColorId();
            t65 t65Var = new t65(n, -1, tagColorId, p, tagColorId, q, t);
            t65Var.b(o);
            t65Var.h(r);
            t65Var.i(s);
            spannableStringBuilder.setSpan(t65Var, 0, tagText.length(), 17);
            spannableStringBuilder.append((CharSequence) this.b.getTitle());
            this.g.setText(spannableStringBuilder);
        } else {
            this.g.setText(this.b.getTitle());
        }
        if (!StringUtils.isNull(this.b.getContent1()) && !StringUtils.isNull(this.b.getContent2())) {
            this.g.setMaxLines(1);
        } else {
            this.g.setMaxLines(2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbMountCardLinkLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbMountCardLinkLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbMountCardLinkLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = context;
        c();
    }

    private int getTagColorId() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            CardLinkInfoData cardLinkInfoData = this.b;
            if (cardLinkInfoData != null && !StringUtils.isNull(cardLinkInfoData.getTagColor()) && this.b.getTagColor().startsWith("CAM_")) {
                i = xp9.d(this.a, this.b.getTagColor());
            } else {
                i = 0;
            }
            if (i == 0) {
                return R.color.CAM_X0304;
            }
            return i;
        }
        return invokeV.intValue;
    }

    private void setTextBtnInfo(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, this, str) != null) || this.k == null) {
            return;
        }
        if (StringUtils.isNull(str)) {
            str = TbadkCoreApplication.getInst().getResources().getString(R.string.item_browse);
        }
        this.k.setText(str);
    }

    public final void a(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            CardLinkInfoData cardLinkInfoData = this.b;
            if (cardLinkInfoData != null) {
                str2 = cardLinkInfoData.getType();
            } else {
                str2 = "";
            }
            TbMountCardLinkHelper.tbCardLinkClickStatistic(str2, getUseSource(), str);
        }
    }

    public void setClickListener(q75 q75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, q75Var) == null) {
            this.c = q75Var;
        }
    }

    public void setData(CardLinkInfoData cardLinkInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cardLinkInfoData) == null) {
            this.b = cardLinkInfoData;
            b();
            d();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d = LayoutInflater.from(getContext()).inflate(R.layout.tb_mount_card_layout, (ViewGroup) this, true);
            this.e = (TbImageView) findViewById(R.id.tb_mount_card_icon);
            this.f = findViewById(R.id.tb_mount_card_icon_border);
            this.e.setDrawCorner(true);
            this.e.setDefaultBgResource(R.drawable.icon_pure_mount_card_link_default);
            this.e.setRadiusById(R.string.J_X04);
            this.e.setConrers(15);
            this.g = (TextView) findViewById(R.id.tb_mount_card_title);
            this.h = (TextView) findViewById(R.id.tb_mount_card_content1);
            this.i = (TextView) findViewById(R.id.tb_mount_card_content2);
            this.j = (FrameLayout) findViewById(R.id.tb_mount_right_layout);
            this.k = (TBSpecificationBtn) findViewById(R.id.tb_mount_card_text_btn);
            this.l = (ImageView) findViewById(R.id.tb_mount_card_arrow_btn);
            this.m = (ImageView) findViewById(R.id.tb_mount_card_del_btn);
            this.d.setOnClickListener(this);
            this.e.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            setPadding(ri.g(getContext(), R.dimen.M_W_X003), ri.g(getContext(), R.dimen.M_H_X002), ri.g(getContext(), R.dimen.M_W_X006), ri.g(getContext(), R.dimen.M_H_X002));
        }
    }

    public final void e() {
        CardLinkInfoData cardLinkInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (cardLinkInfoData = this.b) != null) {
            String btnStyle = cardLinkInfoData.getBtnStyle();
            if ("0".equals(btnStyle)) {
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.m.setVisibility(8);
            } else if ("1".equals(btnStyle)) {
                this.k.setVisibility(0);
                this.l.setVisibility(8);
                this.m.setVisibility(8);
                setTextBtnInfo(this.b.getBtnText());
                String textBtnStatus = this.b.getTextBtnStatus();
                if ("1".equals(textBtnStatus)) {
                    this.k.setConfig(new o75());
                    this.k.setUseDisableState(true);
                } else if ("2".equals(textBtnStatus)) {
                    o75 o75Var = new o75();
                    o75Var.s(R.color.CAM_X0110);
                    this.k.setConfig(o75Var);
                } else {
                    this.k.setConfig(new o75());
                }
            } else if ("2".equals(btnStyle)) {
                this.k.setVisibility(8);
                this.l.setVisibility(0);
                this.m.setVisibility(8);
            } else if ("3".equals(btnStyle)) {
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.m.setVisibility(0);
            } else {
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.m.setVisibility(8);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            p45 d = p45.d(this);
            d.o(R.string.J_X05);
            d.f(R.color.CAM_X0206);
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
            }
            p45 d2 = p45.d(this.f);
            d2.o(R.string.J_X04);
            d2.m(R.dimen.L_X01);
            d2.l(R.color.CAM_X0203);
            f();
            TextView textView = this.g;
            if (textView != null) {
                p45 d3 = p45.d(textView);
                d3.C(R.string.F_X01);
                d3.w(R.color.CAM_X0107);
            }
            TextView textView2 = this.h;
            if (textView2 != null) {
                p45 d4 = p45.d(textView2);
                d4.C(R.string.F_X01);
                d4.w(R.color.CAM_X0109);
            }
            TextView textView3 = this.i;
            if (textView3 != null) {
                p45 d5 = p45.d(textView3);
                d5.C(R.string.F_X01);
                d5.w(R.color.CAM_X0109);
            }
            WebPManager.setPureDrawable(this.l, R.drawable.icon_pure_mount_card_link_right_arrow, R.color.CAM_X0110, null);
            WebPManager.setPureDrawable(this.m, R.drawable.icon_pure_mount_card_link_right_del, R.color.CAM_X0110, null);
        }
    }

    public String getUseSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            in5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this.a);
            if (currentVisiblePageExtra != null) {
                return currentVisiblePageExtra.a();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onAttachedToWindow();
            CardLinkInfoData cardLinkInfoData = this.b;
            if (cardLinkInfoData != null) {
                str = cardLinkInfoData.getType();
            } else {
                str = "";
            }
            TbMountCardLinkHelper.tbCardLinkShowStatistic(str, getUseSource());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            if (view2.getId() == R.id.tb_mount_card_icon) {
                q75 q75Var = this.c;
                if (q75Var != null) {
                    q75Var.a("2");
                }
                a("2");
            } else if (view2.getId() == R.id.tb_mount_card_text_btn) {
                q75 q75Var2 = this.c;
                if (q75Var2 != null) {
                    q75Var2.a("3");
                }
                a("3");
            } else if (view2.getId() == R.id.tb_mount_card_arrow_btn) {
                q75 q75Var3 = this.c;
                if (q75Var3 != null) {
                    q75Var3.a("5");
                }
                a("5");
            } else if (view2.getId() == R.id.tb_mount_card_del_btn) {
                q75 q75Var4 = this.c;
                if (q75Var4 != null) {
                    q75Var4.a("4");
                }
                a("4");
            } else {
                q75 q75Var5 = this.c;
                if (q75Var5 != null) {
                    q75Var5.a("1");
                }
                a("1");
            }
        }
    }
}

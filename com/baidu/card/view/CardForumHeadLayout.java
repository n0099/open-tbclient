package com.baidu.card.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.r.x1;
import c.a.o0.r.v.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.SingleLineEllipsizeTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BarImageView a;

    /* renamed from: b  reason: collision with root package name */
    public SingleLineEllipsizeTextView f25043b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f25044c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f25045d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f25046e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f25047f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25048g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25049h;
    public TextView i;
    public String j;
    public View.OnClickListener k;
    public int l;
    public ThreadData m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardForumHeadLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 3;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0187, (ViewGroup) this, true);
            this.a = (BarImageView) findViewById(R.id.obfuscated_res_0x7f090a44);
            this.f25043b = (SingleLineEllipsizeTextView) findViewById(R.id.obfuscated_res_0x7f090a43);
            this.f25044c = (TextView) findViewById(R.id.obfuscated_res_0x7f090a45);
            this.f25045d = (TextView) findViewById(R.id.obfuscated_res_0x7f090a46);
            this.f25046e = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090a42);
            this.f25047f = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090a6d);
            this.f25048g = (TextView) findViewById(R.id.obfuscated_res_0x7f090dc0);
            this.f25049h = (TextView) findViewById(R.id.obfuscated_res_0x7f090dc1);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091fa7);
            this.a.setShowOval(true);
            this.a.setAutoChangeStyle(true);
            this.a.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.a.setStrokeColorResId(R.color.CAM_X0401);
            this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f25043b.setOnClickListener(this);
            this.f25044c.setOnClickListener(this);
            this.f25045d.setOnClickListener(this);
            this.f25043b.setEllipsisSuffix(getResources().getString(R.string.obfuscated_res_0x7f0f0526));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
            this.f25043b.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize, 0, 0);
            d();
        }
    }

    public final void b(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) || threadData == null || threadData.getForumRecTip() == null || !threadData.isFromHomPage) {
            return;
        }
        String attentionStatus = threadData.getForumRecTip().getAttentionStatus();
        String recReason = threadData.getForumRecTip().getRecReason();
        if (UbsABTestHelper.isForumRecReasonAndStatusUbsABTestA() && !StringUtils.isNull(attentionStatus)) {
            this.f25047f.setVisibility(8);
            this.f25046e.setVisibility(0);
            this.f25046e.setText(attentionStatus);
        } else if (UbsABTestHelper.isForumRecReasonAndStatusUbsABTestB() && !StringUtils.isNull(recReason)) {
            this.f25044c.setVisibility(8);
            this.f25045d.setVisibility(8);
            this.f25046e.setVisibility(8);
            this.f25047f.setVisibility(0);
            this.f25047f.setText(recReason);
        } else if (UbsABTestHelper.isForumRecReasonAndStatusUbsABTestC()) {
            if (!StringUtils.isNull(attentionStatus)) {
                this.f25046e.setVisibility(0);
                this.f25046e.setText(attentionStatus);
            } else {
                this.f25046e.setVisibility(8);
            }
            if (!StringUtils.isNull(recReason)) {
                this.f25044c.setVisibility(8);
                this.f25045d.setVisibility(8);
                this.f25047f.setVisibility(0);
                this.f25047f.setText(recReason);
            } else {
                this.f25047f.setVisibility(8);
            }
        } else {
            this.f25047f.setVisibility(8);
            this.f25046e.setVisibility(8);
            return;
        }
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c d2 = c.d(this.f25046e);
            d2.n(R.string.J_X04);
            d2.v(R.color.CAM_X0108);
            d2.f(R.color.CAM_X0206);
            if (UbsABTestHelper.isfForumRecReasonColorTestA()) {
                if (this.f25047f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f25047f.getLayoutParams();
                    marginLayoutParams.topMargin = n.f(getContext(), R.dimen.tbds8);
                    this.f25047f.setLayoutParams(marginLayoutParams);
                }
                this.f25047f.setPadding(0, 0, 0, 0);
                c d3 = c.d(this.f25047f);
                d3.v(R.color.CAM_X0316);
                d3.z(R.dimen.T_X09);
                d3.f(0);
                return;
            }
            if (this.f25047f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f25047f.getLayoutParams();
                marginLayoutParams2.topMargin = n.f(getContext(), R.dimen.tbds14);
                this.f25047f.setLayoutParams(marginLayoutParams2);
            }
            int f2 = n.f(getContext(), R.dimen.M_W_X002);
            this.f25047f.setPadding(f2, 0, f2, 0);
            c d4 = c.d(this.f25047f);
            d4.n(R.string.J_X04);
            d4.v(R.color.CAM_X0304);
            d4.z(R.dimen.T_X10);
            d4.f(R.color.CAM_X0905);
        }
    }

    public void d() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.l) {
            return;
        }
        this.l = skinType;
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_ba16, SkinManager.getColor(R.color.CAM_X0105), null);
        int f2 = n.f(getContext(), R.dimen.tbds42);
        pureDrawable.setBounds(0, 0, f2, f2);
        this.f25043b.setCompoundDrawables(null, null, pureDrawable, null);
        this.f25043b.setCompoundDrawablePadding(n.f(getContext(), R.dimen.M_W_X002));
        SkinManager.setViewTextColor(this.f25043b, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f25044c, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f25045d, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0109);
        c();
        e();
        f();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            HomeGroupUbsUIHelper.handleHeadSegmentTitleViewColor(this.f25043b);
        }
    }

    public final void f() {
        ThreadData threadData;
        Drawable mutate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (threadData = this.m) == null) {
            return;
        }
        int indexTextColorRes = TagTextHelper.getIndexTextColorRes(threadData.position + 1);
        this.f25048g.setCompoundDrawablePadding(n.f(getContext(), R.dimen.M_W_X002));
        int color = SkinManager.getColor(indexTextColorRes);
        ThreadData threadData2 = this.m;
        if (threadData2.isFromLowFlowsPage) {
            if ("agree_num".equals(threadData2.mTabCode)) {
                mutate = SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f08099d).mutate();
            } else if ("comment_num".equals(this.m.mTabCode)) {
                mutate = SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f08099c).mutate();
            } else {
                mutate = "share_num".equals(this.m.mTabCode) ? SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f08099e).mutate() : null;
            }
        } else {
            mutate = SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0809c8).mutate();
        }
        int f2 = n.f(getContext(), R.dimen.tbds42);
        if (mutate == null) {
            return;
        }
        mutate.setBounds(0, 0, f2, f2);
        DrawableCompat.setTint(mutate, color);
        this.f25048g.setCompoundDrawables(mutate, null, null, null);
        this.f25048g.setBackgroundDrawable(null);
        SkinManager.setViewTextColor(this.f25048g, indexTextColorRes);
        SkinManager.setViewTextColor(this.f25049h, indexTextColorRes);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.setVisibility(8);
            this.f25043b.setVisibility(8);
            this.f25045d.setVisibility(8);
            this.f25044c.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || StringUtils.isNull(this.j)) {
            return;
        }
        ThreadData threadData = this.m;
        if (threadData != null && threadData.isFromHomPage) {
            TbSingleton.getInstance().saveHomeRecommendItemClickTime();
        }
        FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.j, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
        createNormalCfg.setCallFrom(14);
        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        View.OnClickListener onClickListener = this.k;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.k = onClickListener;
        }
    }

    public void setData(String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048586, this, str, str2, i, i2) == null) {
            if (StringUtils.isNull(str)) {
                g();
                return;
            }
            this.a.setPlaceHolder(1);
            this.a.setVisibility(0);
            this.f25043b.setVisibility(0);
            this.j = str;
            this.f25043b.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f03c0), this.j));
            this.a.J(str2, 10, false);
            this.f25045d.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f06a6), StringHelper.numberUniformFormatExtra(i)));
            this.f25044c.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f040e), StringHelper.numberUniformFormatExtra(i2)));
            HomeGroupUbsUIHelper.handleHeadSegmentTitleView(this.f25043b);
        }
    }

    public void setOnClickListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.a.setOnClickListener(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = 3;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.l = 3;
        a(context);
    }

    public void setData(ThreadData threadData) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, threadData) == null) {
            this.m = threadData;
            if (threadData != null && threadData.getForumData() != null) {
                if (threadData.isFromHotRankTab) {
                    this.f25045d.setVisibility(8);
                    this.f25044c.setVisibility(8);
                    this.f25048g.setVisibility(0);
                    this.f25049h.setVisibility(0);
                    this.i.setVisibility(0);
                    this.i.setText(threadData.getThreadExtendInfo());
                    int i = threadData.hotNum;
                    if (i < 1000) {
                        i = 1000;
                    }
                    this.f25049h.setVisibility(0);
                    String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(i);
                    TextView textView = this.f25049h;
                    textView.setText(textView.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f139d, numberUniformFormatExtraWithRoundInt));
                    int i2 = threadData.position + 1;
                    TextView textView2 = this.f25048g;
                    if (i2 >= 10) {
                        str2 = String.valueOf(i2);
                    } else {
                        str2 = "0" + i2;
                    }
                    textView2.setText(str2);
                    f();
                    x1 forumData = threadData.getForumData();
                    this.a.setPlaceHolder(1);
                    this.a.setVisibility(0);
                    this.a.J(forumData.b(), 10, false);
                    this.f25043b.setVisibility(0);
                    this.j = forumData.f10991b;
                    this.f25043b.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f03c0), this.j));
                    HomeGroupUbsUIHelper.handleHeadSegmentTitleView(this.f25043b);
                } else if (threadData.isFromLowFlowsPage) {
                    this.i.setVisibility(8);
                    if (!"agree_num".equals(threadData.mTabCode) && !"comment_num".equals(threadData.mTabCode) && !"share_num".equals(threadData.mTabCode)) {
                        this.f25048g.setVisibility(8);
                        this.f25049h.setVisibility(8);
                    } else {
                        this.f25048g.setVisibility(0);
                        this.f25049h.setVisibility(0);
                        if ("agree_num".equals(threadData.mTabCode)) {
                            String numberUniformFormatExtraWithRoundInt2 = StringHelper.numberUniformFormatExtraWithRoundInt(threadData.getAgreeData() != null ? threadData.getAgreeData().agreeNum : 0L);
                            TextView textView3 = this.f25049h;
                            textView3.setText(textView3.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f139b, numberUniformFormatExtraWithRoundInt2));
                        } else if ("comment_num".equals(threadData.mTabCode)) {
                            String numberUniformFormatExtraWithRoundInt3 = StringHelper.numberUniformFormatExtraWithRoundInt(threadData.getReply_num());
                            TextView textView4 = this.f25049h;
                            textView4.setText(textView4.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f1395, numberUniformFormatExtraWithRoundInt3));
                        } else if ("share_num".equals(threadData.mTabCode)) {
                            String numberUniformFormatExtraWithRoundInt4 = StringHelper.numberUniformFormatExtraWithRoundInt(threadData.getShareNum());
                            TextView textView5 = this.f25049h;
                            textView5.setText(textView5.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f13a0, numberUniformFormatExtraWithRoundInt4));
                        }
                        int i3 = threadData.position + 1;
                        TextView textView6 = this.f25048g;
                        if (i3 >= 10) {
                            str = String.valueOf(i3);
                        } else {
                            str = "0" + i3;
                        }
                        textView6.setText(str);
                        f();
                    }
                    setData(threadData.getForumData().f10991b, threadData.getForumData().b(), threadData.getForumData().f10997h, threadData.getForumData().i);
                } else {
                    if (threadData.isFromConcern()) {
                        this.f25045d.setVisibility(8);
                        this.f25044c.setVisibility(8);
                        this.f25048g.setVisibility(8);
                        this.f25049h.setVisibility(8);
                        this.i.setVisibility(0);
                        this.i.setText(threadData.getThreadExtendInfo());
                    } else {
                        this.i.setVisibility(8);
                        this.f25048g.setVisibility(8);
                        this.f25049h.setVisibility(8);
                        this.f25045d.setVisibility(0);
                        this.f25044c.setVisibility(0);
                    }
                    setData(threadData.getForumData().f10991b, threadData.getForumData().b(), threadData.getForumData().f10997h, threadData.getForumData().i);
                    if (threadData.showWeakenName()) {
                        if (threadData.getAuthor() != null && !StringUtils.isNull(threadData.getAuthor().getName_show())) {
                            this.f25044c.setText(threadData.getAuthor().getName_show());
                        } else {
                            this.f25044c.setText(R.string.obfuscated_res_0x7f0f14ac);
                        }
                        this.f25045d.setText(threadData.getThreadExtendInfo());
                    }
                }
                b(threadData);
                return;
            }
            g();
        }
    }
}

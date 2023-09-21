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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.SingleLineEllipsizeTextView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.d45;
import com.baidu.tieba.di;
import com.baidu.tieba.fia;
import com.baidu.tieba.jta;
import com.baidu.tieba.k25;
import com.baidu.tieba.sa5;
import com.baidu.tieba.view.TbLayerImageView;
import com.baidu.tieba.yn6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int s;
    public static final int t;
    public static final int u;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public BarImageView b;
    public TbLayerImageView c;
    public SingleLineEllipsizeTextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public String k;
    public View.OnClickListener l;
    public int m;
    public ThreadData n;
    public boolean o;
    public k25 p;
    public TBSpecificationBtn q;
    public int r;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardForumHeadLayout a;

        public a(CardForumHeadLayout cardForumHeadLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardForumHeadLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardForumHeadLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((RelativeLayout.LayoutParams) this.a.g.getLayoutParams()).width = (int) ((this.a.a.getWidth() * 0.75f) - this.a.b.getWidth());
                this.a.g.requestLayout();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(852760889, "Lcom/baidu/card/view/CardForumHeadLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(852760889, "Lcom/baidu/card/view/CardForumHeadLayout;");
                return;
            }
        }
        s = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
        t = UtilHelper.getDimenPixelSize(R.dimen.tbds3);
        u = UtilHelper.getDimenPixelSize(R.dimen.tbds23);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardForumHeadLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = 3;
        this.o = true;
        this.r = 14;
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = 3;
        this.o = true;
        this.r = 14;
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
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
        this.m = 3;
        this.o = true;
        this.r = 14;
        d(context);
    }

    public final boolean f(k25 k25Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k25Var)) == null) {
            if (k25Var != null && k25Var.d()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    public void setAttentionLineSpace(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && (textView = this.e) != null && (textView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
            marginLayoutParams.topMargin = i;
            this.e.setLayoutParams(marginLayoutParams);
        }
    }

    public void setBarNameIncludePadding(boolean z) {
        SingleLineEllipsizeTextView singleLineEllipsizeTextView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (singleLineEllipsizeTextView = this.d) != null) {
            singleLineEllipsizeTextView.setIncludeFontPadding(z);
        }
    }

    public void setBarThreadLineSpace(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (textView = this.f) != null && (textView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f.getLayoutParams();
            marginLayoutParams.topMargin = i;
            this.f.setLayoutParams(marginLayoutParams);
        }
    }

    public void setJumpCallFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.r = i;
        }
    }

    public void setNeedShowForumlable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.o = z;
            this.d.setCompoundDrawables(null, null, null, null);
            this.d.setCompoundDrawablePadding(0);
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.a = LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
            this.b = (BarImageView) findViewById(R.id.forum_head_image);
            this.d = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
            this.c = (TbLayerImageView) findViewById(R.id.forum_head_layer);
            this.e = (TextView) findViewById(R.id.forum_head_info_attention);
            this.q = (TBSpecificationBtn) findViewById(R.id.tip_btn);
            this.f = (TextView) findViewById(R.id.forum_head_info_thread);
            this.g = (TextView) findViewById(R.id.forum_recommend_reason);
            post(new a(this));
            this.h = (TextView) findViewById(R.id.hot_rank_index);
            this.i = (TextView) findViewById(R.id.hot_rank_num);
            this.j = (TextView) findViewById(R.id.thread_extend_info);
            this.b.setShowOval(true);
            this.b.setAutoChangeStyle(true);
            this.b.setStrokeWith(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.b.setStrokeColorResId(R.color.CAM_X0401);
            this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.d.setOnClickListener(this);
            this.e.setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.g.setOnClickListener(this);
            setOnClickListener(this);
            this.d.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
            this.d.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize, 0, 0);
            setClipChildren(false);
            g();
        }
    }

    public final void e(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) && threadData != null && threadData.getForumData() != null && threadData.isFromHomPage) {
            String i = threadData.getForumData().i();
            if (!StringUtils.isNull(i)) {
                this.e.setVisibility(8);
                this.f.setVisibility(8);
                this.g.setVisibility(0);
                this.g.setText(i);
                return;
            }
            this.e.setVisibility(0);
            this.f.setVisibility(0);
            this.g.setVisibility(8);
        }
    }

    public void g() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.m) {
            return;
        }
        this.m = skinType;
        if (this.o) {
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_ba16, SkinManager.getColor(R.color.CAM_X0105), null);
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds42);
            pureDrawable.setBounds(0, 0, dimens, dimens);
            this.d.setCompoundDrawables(null, null, pureDrawable, null);
            this.d.setCompoundDrawablePadding(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002));
        } else {
            this.d.setCompoundDrawables(null, null, null, null);
            this.d.setCompoundDrawablePadding(0);
        }
        SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
        if (f(this.p) && this.p.b() != null) {
            this.e.setTextColor(fia.f(jta.c(this.p.b().c())));
            EMManager.from(this.e).setTextSize(R.dimen.T_X10).setCorner(R.string.J_X04).setBackGroundRealColor(fia.f(jta.c(this.p.b().a())));
        } else {
            EMManager.from(this.e).setTextSize(R.dimen.T_X09).setCorner(R.string.J_X02).setTextColor(R.color.CAM_X0109);
            this.e.setBackgroundDrawable(null);
        }
        EMManager.from(this.q).setTextSize(R.dimen.T_X08);
        sa5 sa5Var = new sa5();
        sa5Var.r(fia.a(SkinManager.getColor(R.color.CAM_X0341), 0.75f), SkinManager.getColor(R.color.CAM_X0101));
        this.q.setConfig(sa5Var);
        SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0109);
        h();
        i();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            HomeGroupUbsUIHelper.handleHeadSegmentTitleViewColor(this.d);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b.setVisibility(8);
            this.d.setVisibility(8);
            this.f.setVisibility(8);
            this.e.setVisibility(8);
        }
    }

    public void setOnClickListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.b.setOnClickListener(this);
        }
    }

    public final void i() {
        ThreadData threadData;
        Drawable mutate;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (threadData = this.n) != null) {
            int indexTextColorRes = TagTextHelper.getIndexTextColorRes(threadData.position + 1);
            this.h.setCompoundDrawablePadding(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002));
            int color = SkinManager.getColor(indexTextColorRes);
            ThreadData threadData2 = this.n;
            if (threadData2.isFromLowFlowsPage) {
                if ("agree_num".equals(threadData2.mTabCode)) {
                    mutate = SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_like).mutate();
                } else if ("comment_num".equals(this.n.mTabCode)) {
                    mutate = SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_discuss).mutate();
                } else if ("share_num".equals(this.n.mTabCode)) {
                    mutate = SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_spread).mutate();
                } else {
                    mutate = null;
                }
            } else {
                mutate = SkinManager.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            }
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds42);
            if (mutate == null) {
                return;
            }
            mutate.setBounds(0, 0, dimens, dimens);
            DrawableCompat.setTint(mutate, color);
            this.h.setCompoundDrawables(mutate, null, null, null);
            this.h.setBackgroundDrawable(null);
            SkinManager.setViewTextColor(this.h, indexTextColorRes);
            SkinManager.setViewTextColor(this.i, indexTextColorRes);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, view2) != null) || StringUtils.isNull(this.k)) {
            return;
        }
        ThreadData threadData = this.n;
        if (threadData != null && threadData.isFromHomPage) {
            TbSingleton.getInstance().saveHomeRecommendItemClickTime();
        }
        ThreadData threadData2 = this.n;
        if (threadData2 != null && threadData2.getForumData() != null && !di.isEmpty(this.n.getForumData().j())) {
            UrlManager.getInstance().dealOneLink(this.n.getForumData().j());
        } else {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.k, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(this.r);
            createNormalCfg.getIntent().putExtra("transition_type", 0);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        }
        View.OnClickListener onClickListener = this.l;
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
    }

    public void setData(ThreadData threadData) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, threadData) == null) {
            this.n = threadData;
            if (threadData != null && threadData.getForumData() != null) {
                if (threadData.isFromHotRankTab) {
                    this.f.setVisibility(8);
                    this.e.setVisibility(8);
                    this.h.setVisibility(8);
                    this.i.setVisibility(8);
                    this.j.setVisibility(0);
                    this.j.setText(threadData.getThreadExtendInfo());
                    int i = threadData.hotNum;
                    if (i < 1000) {
                        i = 1000;
                    }
                    String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(i);
                    TextView textView = this.i;
                    textView.setText(textView.getContext().getResources().getString(R.string.thread_rank_tag, numberUniformFormatExtraWithRoundInt));
                    int i2 = threadData.position + 1;
                    TextView textView2 = this.h;
                    if (i2 >= 10) {
                        str2 = String.valueOf(i2);
                    } else {
                        str2 = "0" + i2;
                    }
                    textView2.setText(str2);
                    i();
                    d45 forumData = threadData.getForumData();
                    this.b.setPlaceHolder(1);
                    this.b.setVisibility(0);
                    this.b.startLoad(forumData.a(), 10, false);
                    this.d.setVisibility(0);
                    this.k = forumData.b;
                    this.d.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.k));
                    HomeGroupUbsUIHelper.handleHeadSegmentTitleView(this.d);
                } else if (threadData.isFromLowFlowsPage) {
                    this.j.setVisibility(8);
                    if (!"agree_num".equals(threadData.mTabCode) && !"comment_num".equals(threadData.mTabCode) && !"share_num".equals(threadData.mTabCode)) {
                        this.h.setVisibility(8);
                        this.i.setVisibility(8);
                    } else {
                        this.h.setVisibility(0);
                        this.i.setVisibility(0);
                        if ("agree_num".equals(threadData.mTabCode)) {
                            long j = 0;
                            if (threadData.getAgreeData() != null) {
                                j = threadData.getAgreeData().agreeNum;
                            }
                            String numberUniformFormatExtraWithRoundInt2 = StringHelper.numberUniformFormatExtraWithRoundInt(j);
                            TextView textView3 = this.i;
                            textView3.setText(textView3.getContext().getResources().getString(R.string.thread_like_rank_tag, numberUniformFormatExtraWithRoundInt2));
                        } else if ("comment_num".equals(threadData.mTabCode)) {
                            String numberUniformFormatExtraWithRoundInt3 = StringHelper.numberUniformFormatExtraWithRoundInt(threadData.getReply_num());
                            TextView textView4 = this.i;
                            textView4.setText(textView4.getContext().getResources().getString(R.string.thread_discuss_rank_tag, numberUniformFormatExtraWithRoundInt3));
                        } else if ("share_num".equals(threadData.mTabCode)) {
                            String numberUniformFormatExtraWithRoundInt4 = StringHelper.numberUniformFormatExtraWithRoundInt(threadData.getShareNum());
                            TextView textView5 = this.i;
                            textView5.setText(textView5.getContext().getResources().getString(R.string.thread_spread_rank_tag, numberUniformFormatExtraWithRoundInt4));
                        }
                        int i3 = threadData.position + 1;
                        TextView textView6 = this.h;
                        if (i3 >= 10) {
                            str = String.valueOf(i3);
                        } else {
                            str = "0" + i3;
                        }
                        textView6.setText(str);
                        i();
                    }
                    setData(threadData.getForumData().b, threadData.getForumData().a(), threadData.getForumData().j, threadData.getForumData().k, threadData.getForumData().h(), threadData.getForumData().e());
                } else {
                    if (threadData.isFromConcern()) {
                        this.f.setVisibility(8);
                        this.e.setVisibility(8);
                        this.h.setVisibility(8);
                        this.i.setVisibility(8);
                        this.j.setVisibility(0);
                        this.j.setText(threadData.getThreadExtendInfo());
                    } else {
                        this.j.setVisibility(8);
                        this.h.setVisibility(8);
                        this.i.setVisibility(8);
                        this.f.setVisibility(0);
                        this.e.setVisibility(0);
                    }
                    setData(threadData.getForumData().b, threadData.getForumData().a(), threadData.getForumData().j, threadData.getForumData().k, threadData.getForumData().h(), threadData.getForumData().e());
                    if (threadData.showWeakenName()) {
                        if (threadData.getAuthor() != null && !StringUtils.isNull(threadData.getAuthor().getName_show())) {
                            this.e.setText(threadData.getAuthor().getName_show());
                        } else {
                            this.e.setText(R.string.user_name_default_txt);
                        }
                        this.f.setText(threadData.getThreadExtendInfo());
                    }
                }
                e(threadData);
                return;
            }
            j();
        }
    }

    public void setData(String str, String str2, int i, int i2, List<String> list, k25 k25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), list, k25Var}) == null) {
            if (StringUtils.isNull(str)) {
                j();
                return;
            }
            this.b.setPlaceHolder(1);
            this.b.setVisibility(0);
            this.d.setVisibility(0);
            this.k = str;
            this.d.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.k));
            this.b.startLoad(str2, 10, false);
            if (f(k25Var)) {
                this.p = k25Var;
                this.f.setText(k25Var.a());
                if (k25Var.b() != null && !di.isEmpty(k25Var.b().b())) {
                    this.e.setText(k25Var.b().b());
                    TextView textView = this.e;
                    int i3 = s;
                    int i4 = t;
                    textView.setPadding(i3, i4, i3, i4);
                    this.e.setTextColor(fia.f(jta.c(this.p.b().c())));
                    setAttentionLineSpace(u);
                    EMManager.from(this.e).setTextSize(R.dimen.T_X10).setCorner(R.string.J_X04).setBackGroundRealColor(fia.f(jta.c(this.p.b().a())));
                } else {
                    yn6.f(this.e, 8);
                    this.e.setPadding(0, 0, 0, 0);
                    EMManager.from(this.e).setTextSize(R.dimen.T_X09).setCorner(R.string.J_X02).setTextColor(R.color.CAM_X0109);
                    this.e.setBackgroundDrawable(null);
                }
                if (!di.isEmpty(this.p.c())) {
                    yn6.f(this.q, 0);
                    this.q.setText(this.p.c());
                } else {
                    yn6.f(this.q, 8);
                }
            } else {
                yn6.f(this.q, 8);
                this.f.setText(String.format(getContext().getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtra(i)));
                this.e.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f04b8), StringHelper.numberUniformFormatExtra(i2)));
            }
            HomeGroupUbsUIHelper.handleHeadSegmentTitleView(this.d);
            if (ListUtils.isEmpty(list)) {
                this.c.setVisibility(8);
                return;
            }
            this.c.setVisibility(0);
            this.c.a(list);
        }
    }
}

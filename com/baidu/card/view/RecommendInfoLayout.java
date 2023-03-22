package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.switchs.NewWebHotTopicPageSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.hw4;
import com.baidu.tieba.mp5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class RecommendInfoLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public BarImageView b;
    public TextView c;
    public int d;
    public int e;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ StatisticItem b;
        public final /* synthetic */ RecommendInfoLayout c;

        public a(RecommendInfoLayout recommendInfoLayout, long j, StatisticItem statisticItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendInfoLayout, Long.valueOf(j), statisticItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = recommendInfoLayout;
            this.a = j;
            this.b = statisticItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a == 0) {
                return;
            }
            if (NewWebHotTopicPageSwitch.isOn()) {
                if (view2.getContext() instanceof BaseActivity) {
                    mp5.e(((BaseActivity) view2.getContext()).getPageContext(), String.valueOf(this.a), null);
                } else {
                    new HotTopicActivityConfig(this.c.getContext()).createNormalConfig(String.valueOf(this.a), null, null, "2").start();
                }
            } else {
                new HotTopicActivityConfig(this.c.getContext()).createNormalConfig(String.valueOf(this.a), null, null, "2").start();
            }
            this.b.param("obj_type", 2);
            this.b.param("obj_locate", 1);
            TiebaStatic.log(this.b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendInfoLayout(Context context) {
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
        this.d = 24;
        this.e = 16;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.thread_recommend_info_layout, (ViewGroup) this, true);
            this.a = (LinearLayout) inflate.findViewById(R.id.recommend_layout);
            this.b = (BarImageView) inflate.findViewById(R.id.recommend_forum_avatar);
            this.c = (TextView) inflate.findViewById(R.id.recommend_info_view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendInfoLayout(Context context, AttributeSet attributeSet) {
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
        this.d = 24;
        this.e = 16;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendInfoLayout(Context context, AttributeSet attributeSet, int i) {
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
        this.d = 24;
        this.e = 16;
        a(context);
    }

    public void setData(hw4 hw4Var) {
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hw4Var) != null) || hw4Var == null || hw4Var.getThreadData() == null || (threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(hw4Var.getThreadData().getThreadRecommendInfoDataList(), 0)) == null) {
            return;
        }
        String str = threadRecommendInfoData.forumAvatar;
        if (!TextUtils.isEmpty(str)) {
            this.b.setVisibility(0);
            this.b.M(str, 10, false);
        } else {
            this.b.setVisibility(8);
        }
        String str2 = threadRecommendInfoData.forumName;
        String str3 = threadRecommendInfoData.recommendReason;
        long j = threadRecommendInfoData.recommendTopicId;
        StatisticItem statisticItem = new StatisticItem("c14686");
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            this.c.setText(StringHelper.cutChineseAndEnglishWithSuffix(str2, this.e, StringHelper.STRING_MORE) + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06bd) + StringHelper.cutChineseAndEnglishWithSuffix(str3, this.d, StringHelper.STRING_MORE));
        } else if (!TextUtils.isEmpty(str3)) {
            this.c.setText(StringHelper.cutChineseAndEnglishWithSuffix(str3, this.d, StringHelper.STRING_MORE));
        }
        this.a.setOnClickListener(new a(this, j, statisticItem));
    }
}

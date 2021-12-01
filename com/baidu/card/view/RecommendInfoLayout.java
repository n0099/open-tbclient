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
import c.a.q0.s.q.a;
import c.a.q0.s.u.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class RecommendInfoLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f33739e;

    /* renamed from: f  reason: collision with root package name */
    public BarImageView f33740f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33741g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendInfoLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.thread_recommend_info_layout, (ViewGroup) this, true);
            this.f33739e = (LinearLayout) inflate.findViewById(R.id.recommend_layout);
            this.f33740f = (BarImageView) inflate.findViewById(R.id.recommend_forum_avatar);
            this.f33741g = (TextView) inflate.findViewById(R.id.recommend_info_view);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c d2 = c.d(this.f33739e);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0209);
            c d3 = c.d(this.f33741g);
            d3.A(R.string.F_X01);
            d3.z(R.dimen.T_X09);
            d3.v(R.color.CAM_X0107);
        }
    }

    public void setData(a aVar) {
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || (threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(aVar.getThreadData().q1(), 0)) == null) {
            return;
        }
        String str = threadRecommendInfoData.forumAvatar;
        if (!TextUtils.isEmpty(str)) {
            this.f33740f.setVisibility(0);
            this.f33740f.startLoad(str, 10, false);
        } else {
            this.f33740f.setVisibility(8);
        }
        String str2 = threadRecommendInfoData.forumName;
        String str3 = threadRecommendInfoData.recommendReason;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            this.f33741g.setText(StringHelper.cutChineseAndEnglishWithSuffix(str2, 12, "...") + TbadkCoreApplication.getInst().getString(R.string.forum) + str3);
        } else if (TextUtils.isEmpty(str3)) {
        } else {
            this.f33741g.setText(str3);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendInfoLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context);
    }
}

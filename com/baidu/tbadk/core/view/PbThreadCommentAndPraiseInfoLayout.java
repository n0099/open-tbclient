package com.baidu.tbadk.core.view;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import com.baidu.tieba.pw4;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.yi;
import com.baidu.tieba.yr4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class PbThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener s0;
    public TextView t0;
    public TextView u0;
    public LinearLayout v0;
    public String w0;
    public String x0;

    public void setPostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateReplyStateUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateShareStateUI(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, threadData) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbThreadCommentAndPraiseInfoLayout(Context context) {
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
        P();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void I(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            super.I(threadData);
            if (threadData != null && this.h != null && threadData.isVideoWorksInfo()) {
                if (threadData.getReply_num() == 0) {
                    this.h.setVisibility(0);
                } else {
                    this.h.setVisibility(8);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
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
        P();
    }

    public void O(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) && this.D != null && !TextUtils.isEmpty(str) && str.equals(this.D.getTid())) {
            yr4 yr4Var = new yr4();
            yr4Var.b = 4;
            yr4Var.d = 2;
            yr4Var.j = str2;
            this.e.setStatisticData(yr4Var);
            this.e.K();
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void B(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (onClickListener = this.s0) != null) {
            onClickListener.onClick(view2);
        }
    }

    public void T(Animator.AnimatorListener animatorListener) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, animatorListener) == null) && (agreeView = this.e) != null && agreeView.getImgAgree() != null) {
            this.e.setAgreeAnimationListenOnce(true);
            this.e.setAgreeAnimationListener(animatorListener);
            this.e.getImgAgree().performClick();
        }
    }

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            this.s0 = onClickListener;
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.w0 = str;
        }
    }

    public void setTopicSubjectName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.x0 = str;
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void u(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, view2) == null) && (onClickListener = this.s0) != null) {
            onClickListener.onClick(view2);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void v(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, view2) == null) && (onClickListener = this.s0) != null) {
            onClickListener.onClick(view2);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void z(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, view2) == null) && (onClickListener = this.s0) != null) {
            onClickListener.onClick(view2);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(0);
            N();
            onChangeSkinType();
        }
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ThreadData threadData = this.D;
            if (threadData != null && threadData.getCustomFigure() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ThreadData threadData = this.D;
            if (threadData != null && threadData.isVideoThreadType() && this.D.getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean S() {
        InterceptResult invokeV;
        ThreadData threadData;
        WorksInfoData worksInfoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (R() && (threadData = this.D) != null && (worksInfoData = threadData.worksInfoData) != null && worksInfoData.isWorks) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setUseDynamicLikeRes() {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (agreeView = this.e) != null) {
            agreeView.setUseDynamicLikeResForPbFirstFloor();
        }
    }

    public final void N() {
        float f;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0921e4);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = -1;
            findViewById.setLayoutParams(layoutParams);
            int g = yi.g(getContext(), R.dimen.tbds68);
            int g2 = yi.g(getContext(), R.dimen.T_X09);
            int g3 = yi.g(getContext(), R.dimen.tbds15);
            int g4 = yi.g(getContext(), R.dimen.tbds10);
            yi.g(getContext(), R.dimen.tbds32);
            yi.g(getContext(), R.dimen.tbds16);
            this.v0 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091ee9);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
            if (Q()) {
                f = 0.25f;
            } else {
                f = 0.5f;
            }
            layoutParams2.weight = f;
            if (S()) {
                layoutParams2.weight = 0.2f;
            }
            this.v0.setLayoutParams(layoutParams2);
            this.v0.setOrientation(1);
            this.v0.setVisibility(0);
            this.v0.setOnClickListener(this.s0);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091eea);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g, g);
            layoutParams3.topMargin = g3;
            imageView.setLayoutParams(layoutParams3);
            WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f08099f, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091eeb);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.topMargin = g4;
            textView.setLayoutParams(layoutParams4);
            float f3 = g2;
            textView.setTextSize(0, f3);
            textView.setText(this.E.getString(R.string.obfuscated_res_0x7f0f117f));
            if (S()) {
                this.K = true;
                setNeedAddReplyIcon(true);
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0921f1);
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -1);
                layoutParams5.weight = 0.2f;
                linearLayout.setLayoutParams(layoutParams5);
                linearLayout.setOrientation(1);
                ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0921f3);
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(g, g);
                layoutParams6.topMargin = yi.g(getContext(), R.dimen.tbds25);
                layoutParams6.addRule(13, -1);
                imageView2.setLayoutParams(layoutParams6);
                WebPManager.setPureDrawable(imageView2, R.drawable.obfuscated_res_0x7f08094d, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
                this.t0 = (TextView) findViewById(R.id.obfuscated_res_0x7f0921f4);
                this.t0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                this.t0.setTextSize(0, f3);
            } else {
                this.K = false;
                setNeedAddReplyIcon(false);
            }
            if (S()) {
                setCollectVisible(true);
                LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090688);
                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -1);
                layoutParams7.weight = 0.2f;
                linearLayout2.setLayoutParams(layoutParams7);
                linearLayout2.setOrientation(1);
                LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(g, g);
                layoutParams8.topMargin = g3;
                ((ImageView) findViewById(R.id.obfuscated_res_0x7f090689)).setLayoutParams(layoutParams8);
                this.u0 = (TextView) findViewById(R.id.obfuscated_res_0x7f09068a);
                LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams9.topMargin = g4;
                this.u0.setLayoutParams(layoutParams9);
                this.u0.setTextSize(0, f3);
            } else {
                setCollectVisible(false);
            }
            AgreeView agreeView = (AgreeView) findViewById(R.id.obfuscated_res_0x7f0916be);
            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(0, -1);
            layoutParams10.topMargin = yi.g(getContext(), R.dimen.tbds18);
            if (Q()) {
                f2 = 0.25f;
            } else {
                f2 = 0.5f;
            }
            layoutParams10.weight = f2;
            agreeView.setLayoutParams(layoutParams10);
            agreeView.u();
            agreeView.setTopicId(this.w0);
            agreeView.setTopicSubjectName(this.x0);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setVisibility(8);
            setReplyTimeVisible(false);
            setIsBarViewVisible(false);
            setManageVisible(false);
            setInFrsAllThread(false);
            this.K = false;
            setNeedAddReplyIcon(false);
            setShowPraiseNum(true);
            setNeedAddPraiseIcon(true);
            setShareVisible(true);
            setWeiXinShareGone(true);
        }
    }

    public boolean U(ThreadData threadData, AntiData antiData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, threadData, antiData)) == null) {
            return setData(threadData);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onChangeSkinType();
            WebPManager.setPureDrawable(this.g, R.drawable.obfuscated_res_0x7f0809a5, R.color.CAM_X0107, null);
            EMTextView eMTextView = this.h;
            if (eMTextView != null) {
                pw4 d = pw4.d(eMTextView);
                d.A(R.string.F_X02);
                d.v(R.color.CAM_X0107);
                SkinManager.setBackgroundShapeDrawable(this.h, yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            }
            SkinManager.setViewTextColor(this.t0, (int) R.drawable.selector_comment_and_prise_item_text_color);
            SkinManager.setViewTextColor(this.u0, (int) R.drawable.selector_comment_and_prise_item_text_color);
            ThreadData threadData = this.D;
            if (threadData != null) {
                MaskView.c(this.v0, threadData.isNovelThread());
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setAgreeViewType(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, threadData) == null) {
            if (threadData != null) {
                this.e.setDisagreeShow(threadData.isUgcThreadType());
            }
            if (threadData != null && threadData.isVideoWorksInfo()) {
                this.e.setDisagreeShow(true);
            }
            if (threadData != null && threadData.getCustomFigure() != null) {
                this.e.U(threadData.getCustomFigure(), threadData.getAuthor());
            } else {
                this.e.setDisagreeShow(true);
            }
            if (threadData != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.getLayoutParams();
                if (threadData.isVideoWorksInfo()) {
                    layoutParams.weight = 0.2f;
                } else if (threadData.isUgcThreadType()) {
                    layoutParams.weight = 0.25f;
                } else {
                    layoutParams.weight = 0.5f;
                }
                this.e.setLayoutParams(layoutParams);
            }
        }
    }
}

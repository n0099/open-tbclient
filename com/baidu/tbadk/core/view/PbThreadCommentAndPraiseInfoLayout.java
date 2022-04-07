package com.baidu.tbadk.core.view;

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
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oi;
import com.repackage.wn4;
import com.repackage.wr4;
/* loaded from: classes3.dex */
public class PbThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener m0;
    public TextView n0;
    public TextView o0;
    public TextView p0;
    public TextView q0;
    public LinearLayout r0;
    public LinearLayout s0;
    public String t0;
    public String u0;

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
    public void B(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (onClickListener = this.m0) == null) {
            return;
        }
        onClickListener.onClick(view2);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(0);
            N();
            onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void J(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            super.J(threadData);
            if (threadData == null || this.g == null || !threadData.isVideoWorksInfo()) {
                return;
            }
            if (threadData.getReply_num() == 0) {
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void M(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) {
            super.M(threadData);
            View view2 = this.k;
            if (view2 == null || this.i == null || threadData == null) {
                return;
            }
            view2.setVisibility(0);
            this.i.setVisibility(0);
            this.i.setText(this.B.getString(R.string.obfuscated_res_0x7f0f1154));
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091f8d);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = -1;
            findViewById.setLayoutParams(layoutParams);
            int f = oi.f(getContext(), R.dimen.tbds68);
            int f2 = oi.f(getContext(), R.dimen.T_X09);
            int f3 = oi.f(getContext(), R.dimen.tbds15);
            int f4 = oi.f(getContext(), R.dimen.tbds10);
            this.s0 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091cb9);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
            layoutParams2.weight = R() ? 0.2f : 0.25f;
            this.s0.setLayoutParams(layoutParams2);
            this.s0.setOrientation(1);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091cba);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(f, f);
            layoutParams3.topMargin = f3;
            imageView.setLayoutParams(layoutParams3);
            imageView.setImageResource(R.drawable.icon_share_wechat_n);
            this.o0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091cb8);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.topMargin = f4;
            this.o0.setLayoutParams(layoutParams4);
            float f5 = f2;
            this.o0.setTextSize(0, f5);
            this.o0.setText(this.B.getString(R.string.obfuscated_res_0x7f0f1154));
            this.r0 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091982);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -1);
            layoutParams5.weight = R() ? 0.2f : 0.25f;
            this.r0.setLayoutParams(layoutParams5);
            this.r0.setOrientation(1);
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f091983);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(f, f);
            layoutParams6.topMargin = f3;
            imageView2.setLayoutParams(layoutParams6);
            imageView2.setImageResource(R.drawable.icon_share_qq_n);
            this.p0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091984);
            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams7.topMargin = f4;
            this.p0.setLayoutParams(layoutParams7);
            this.p0.setTextSize(0, f5);
            this.p0.setText(this.B.getString(R.string.obfuscated_res_0x7f0f112f));
            if (R()) {
                this.H = true;
                setNeedAddReplyIcon(true);
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091f98);
                LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, -1);
                layoutParams8.weight = 0.2f;
                linearLayout.setLayoutParams(layoutParams8);
                linearLayout.setOrientation(1);
                ImageView imageView3 = (ImageView) findViewById(R.id.obfuscated_res_0x7f091f9a);
                RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(f, f);
                layoutParams9.topMargin = oi.f(getContext(), R.dimen.tbds25);
                layoutParams9.addRule(13, -1);
                imageView3.setLayoutParams(layoutParams9);
                WebPManager.setPureDrawable(imageView3, R.drawable.obfuscated_res_0x7f0808ee, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
                this.n0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091f9b);
                this.n0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                this.n0.setTextSize(0, f5);
            } else {
                this.H = false;
                setNeedAddReplyIcon(false);
            }
            if (R()) {
                setCollectVisible(true);
                LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090682);
                LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(0, -1);
                layoutParams10.weight = 0.2f;
                linearLayout2.setLayoutParams(layoutParams10);
                linearLayout2.setOrientation(1);
                LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(f, f);
                layoutParams11.topMargin = f3;
                ((ImageView) findViewById(R.id.obfuscated_res_0x7f090683)).setLayoutParams(layoutParams11);
                this.q0 = (TextView) findViewById(R.id.obfuscated_res_0x7f090684);
                LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams12.topMargin = f4;
                this.q0.setLayoutParams(layoutParams12);
                this.q0.setTextSize(0, f5);
            } else {
                setCollectVisible(false);
            }
            AgreeView agreeView = (AgreeView) findViewById(R.id.obfuscated_res_0x7f091540);
            LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(0, -1);
            layoutParams13.topMargin = oi.f(getContext(), R.dimen.tbds18);
            layoutParams2.weight = R() ? 0.2f : 0.25f;
            agreeView.setLayoutParams(layoutParams13);
            agreeView.n();
            agreeView.setTopicId(this.t0);
            agreeView.setTopicSubjectName(this.u0);
        }
    }

    public void O(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) || this.A == null || TextUtils.isEmpty(str) || !str.equals(this.A.getTid())) {
            return;
        }
        wn4 wn4Var = new wn4();
        wn4Var.b = 4;
        wn4Var.d = 2;
        wn4Var.j = str2;
        this.d.setStatisticData(wn4Var);
        this.d.A();
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setVisibility(8);
            setReplyTimeVisible(false);
            setIsBarViewVisible(false);
            setManageVisible(false);
            setInFrsAllThread(false);
            this.H = false;
            setNeedAddReplyIcon(false);
            setShowPraiseNum(true);
            setNeedAddPraiseIcon(true);
            setShareVisible(true);
            setQQShareVisible(true);
        }
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ThreadData threadData = this.A;
            return (threadData == null || !threadData.isVideoThreadType() || this.A.getThreadVideoInfo() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        ThreadData threadData;
        WorksInfoData worksInfoData;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Q() && (threadData = this.A) != null && (worksInfoData = threadData.worksInfoData) != null && worksInfoData.isWorks : invokeV.booleanValue;
    }

    public boolean S(ThreadData threadData, AntiData antiData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, threadData, antiData)) == null) ? setData(threadData) : invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onChangeSkinType();
            if (R()) {
                WebPManager.setMaskDrawable(this.j, R.drawable.obfuscated_res_0x7f0807c7, null);
                WebPManager.setMaskDrawable(this.s, R.drawable.obfuscated_res_0x7f0807c6, null);
            } else {
                WebPManager.setMaskDrawable(this.j, R.drawable.obfuscated_res_0x7f0807c9, null);
                WebPManager.setMaskDrawable(this.s, R.drawable.obfuscated_res_0x7f0807c8, null);
            }
            WebPManager.setPureDrawable(this.f, R.drawable.obfuscated_res_0x7f080930, R.color.CAM_X0107, null);
            EMTextView eMTextView = this.g;
            if (eMTextView != null) {
                wr4 d = wr4.d(eMTextView);
                d.A(R.string.F_X02);
                d.v(R.color.CAM_X0107);
                SkinManager.setBackgroundShapeDrawable(this.g, oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            }
            SkinManager.setViewTextColor(this.o0, (int) R.drawable.selector_comment_and_prise_item_text_color);
            SkinManager.setViewTextColor(this.p0, (int) R.drawable.selector_comment_and_prise_item_text_color);
            SkinManager.setViewTextColor(this.n0, (int) R.drawable.selector_comment_and_prise_item_text_color);
            SkinManager.setViewTextColor(this.q0, (int) R.drawable.selector_comment_and_prise_item_text_color);
            ThreadData threadData = this.A;
            if (threadData != null) {
                MaskView.c(this.s0, threadData.isNovelThread());
                MaskView.c(this.r0, this.A.isNovelThread());
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setAgreeViewType(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, threadData) == null) {
            if (threadData != null) {
                this.d.setDisagreeShow(threadData.isUgcThreadType());
            }
            if (threadData != null && threadData.isVideoWorksInfo()) {
                this.d.setDisagreeShow(true);
            }
            if (threadData != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
                if (threadData.isVideoWorksInfo()) {
                    layoutParams.weight = 0.2f;
                } else if (threadData.isUgcThreadType()) {
                    layoutParams.weight = 0.25f;
                } else {
                    layoutParams.weight = 0.5f;
                }
                this.d.setLayoutParams(layoutParams);
            }
        }
    }

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.m0 = onClickListener;
        }
    }

    public void setPostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.t0 = str;
        }
    }

    public void setTopicSubjectName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.u0 = str;
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setUseDynamicLikeRes() {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (agreeView = this.d) == null) {
            return;
        }
        agreeView.setUseDynamicLikeResForPbFirstFloor();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void u(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, view2) == null) || (onClickListener = this.m0) == null) {
            return;
        }
        onClickListener.onClick(view2);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateReplyStateUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateShareStateUI(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, threadData) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void v(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, view2) == null) || (onClickListener = this.m0) == null) {
            return;
        }
        onClickListener.onClick(view2);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void z(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, view2) == null) || (onClickListener = this.m0) == null) {
            return;
        }
        onClickListener.onClick(view2);
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
}

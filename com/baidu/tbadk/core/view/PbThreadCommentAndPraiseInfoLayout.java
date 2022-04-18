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
import com.repackage.vn4;
import com.repackage.vr4;
/* loaded from: classes3.dex */
public class PbThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener p0;
    public TextView q0;
    public TextView r0;
    public TextView s0;
    public TextView t0;
    public LinearLayout u0;
    public LinearLayout v0;
    public String w0;
    public String x0;

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
        Q();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void A(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (onClickListener = this.p0) == null) {
            return;
        }
        onClickListener.onClick(view2);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void C(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) || (onClickListener = this.p0) == null) {
            return;
        }
        onClickListener.onClick(view2);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setVisibility(0);
            O();
            onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void K(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) {
            super.K(threadData);
            if (threadData == null || this.h == null || !threadData.isVideoWorksInfo()) {
                return;
            }
            if (threadData.getReply_num() == 0) {
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void N(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            super.N(threadData);
            View view2 = this.l;
            if (view2 == null || this.j == null || threadData == null) {
                return;
            }
            view2.setVisibility(0);
            this.j.setVisibility(0);
            this.j.setText(this.C.getString(R.string.obfuscated_res_0x7f0f1153));
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091f8e);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = -1;
            findViewById.setLayoutParams(layoutParams);
            int f = oi.f(getContext(), R.dimen.tbds68);
            int f2 = oi.f(getContext(), R.dimen.T_X09);
            int f3 = oi.f(getContext(), R.dimen.tbds15);
            int f4 = oi.f(getContext(), R.dimen.tbds10);
            this.v0 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091cba);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
            layoutParams2.weight = S() ? 0.2f : 0.25f;
            this.v0.setLayoutParams(layoutParams2);
            this.v0.setOrientation(1);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091cbb);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(f, f);
            layoutParams3.topMargin = f3;
            imageView.setLayoutParams(layoutParams3);
            imageView.setImageResource(R.drawable.icon_share_wechat_n);
            this.r0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091cb9);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.topMargin = f4;
            this.r0.setLayoutParams(layoutParams4);
            float f5 = f2;
            this.r0.setTextSize(0, f5);
            this.r0.setText(this.C.getString(R.string.obfuscated_res_0x7f0f1153));
            this.u0 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091983);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -1);
            layoutParams5.weight = S() ? 0.2f : 0.25f;
            this.u0.setLayoutParams(layoutParams5);
            this.u0.setOrientation(1);
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f091984);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(f, f);
            layoutParams6.topMargin = f3;
            imageView2.setLayoutParams(layoutParams6);
            imageView2.setImageResource(R.drawable.icon_share_qq_n);
            this.s0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091985);
            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams7.topMargin = f4;
            this.s0.setLayoutParams(layoutParams7);
            this.s0.setTextSize(0, f5);
            this.s0.setText(this.C.getString(R.string.obfuscated_res_0x7f0f112e));
            if (S()) {
                this.I = true;
                setNeedAddReplyIcon(true);
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091f99);
                LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, -1);
                layoutParams8.weight = 0.2f;
                linearLayout.setLayoutParams(layoutParams8);
                linearLayout.setOrientation(1);
                ImageView imageView3 = (ImageView) findViewById(R.id.obfuscated_res_0x7f091f9b);
                RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(f, f);
                layoutParams9.topMargin = oi.f(getContext(), R.dimen.tbds25);
                layoutParams9.addRule(13, -1);
                imageView3.setLayoutParams(layoutParams9);
                WebPManager.setPureDrawable(imageView3, R.drawable.obfuscated_res_0x7f0808f2, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
                this.q0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091f9c);
                this.q0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                this.q0.setTextSize(0, f5);
            } else {
                this.I = false;
                setNeedAddReplyIcon(false);
            }
            if (S()) {
                setCollectVisible(true);
                LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090682);
                LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(0, -1);
                layoutParams10.weight = 0.2f;
                linearLayout2.setLayoutParams(layoutParams10);
                linearLayout2.setOrientation(1);
                LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(f, f);
                layoutParams11.topMargin = f3;
                ((ImageView) findViewById(R.id.obfuscated_res_0x7f090683)).setLayoutParams(layoutParams11);
                this.t0 = (TextView) findViewById(R.id.obfuscated_res_0x7f090684);
                LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams12.topMargin = f4;
                this.t0.setLayoutParams(layoutParams12);
                this.t0.setTextSize(0, f5);
            } else {
                setCollectVisible(false);
            }
            AgreeView agreeView = (AgreeView) findViewById(R.id.obfuscated_res_0x7f091541);
            LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(0, -1);
            layoutParams13.topMargin = oi.f(getContext(), R.dimen.tbds18);
            layoutParams2.weight = S() ? 0.2f : 0.25f;
            agreeView.setLayoutParams(layoutParams13);
            agreeView.s();
            agreeView.setTopicId(this.w0);
            agreeView.setTopicSubjectName(this.x0);
        }
    }

    public void P(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || this.B == null || TextUtils.isEmpty(str) || !str.equals(this.B.getTid())) {
            return;
        }
        vn4 vn4Var = new vn4();
        vn4Var.b = 4;
        vn4Var.d = 2;
        vn4Var.j = str2;
        this.e.setStatisticData(vn4Var);
        this.e.H();
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setVisibility(8);
            setReplyTimeVisible(false);
            setIsBarViewVisible(false);
            setManageVisible(false);
            setInFrsAllThread(false);
            this.I = false;
            setNeedAddReplyIcon(false);
            setShowPraiseNum(true);
            setNeedAddPraiseIcon(true);
            setShareVisible(true);
            setQQShareVisible(true);
        }
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ThreadData threadData = this.B;
            return (threadData == null || !threadData.isVideoThreadType() || this.B.getThreadVideoInfo() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean S() {
        InterceptResult invokeV;
        ThreadData threadData;
        WorksInfoData worksInfoData;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? R() && (threadData = this.B) != null && (worksInfoData = threadData.worksInfoData) != null && worksInfoData.isWorks : invokeV.booleanValue;
    }

    public boolean T(ThreadData threadData, AntiData antiData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, threadData, antiData)) == null) ? setData(threadData) : invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onChangeSkinType();
            if (S()) {
                WebPManager.setMaskDrawable(this.k, R.drawable.obfuscated_res_0x7f0807c6, null);
                WebPManager.setMaskDrawable(this.t, R.drawable.obfuscated_res_0x7f0807c5, null);
            } else {
                WebPManager.setMaskDrawable(this.k, R.drawable.obfuscated_res_0x7f0807c8, null);
                WebPManager.setMaskDrawable(this.t, R.drawable.obfuscated_res_0x7f0807c7, null);
            }
            WebPManager.setPureDrawable(this.g, R.drawable.obfuscated_res_0x7f080934, R.color.CAM_X0107, null);
            EMTextView eMTextView = this.h;
            if (eMTextView != null) {
                vr4 d = vr4.d(eMTextView);
                d.A(R.string.F_X02);
                d.v(R.color.CAM_X0107);
                SkinManager.setBackgroundShapeDrawable(this.h, oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            }
            SkinManager.setViewTextColor(this.r0, (int) R.drawable.selector_comment_and_prise_item_text_color);
            SkinManager.setViewTextColor(this.s0, (int) R.drawable.selector_comment_and_prise_item_text_color);
            SkinManager.setViewTextColor(this.q0, (int) R.drawable.selector_comment_and_prise_item_text_color);
            SkinManager.setViewTextColor(this.t0, (int) R.drawable.selector_comment_and_prise_item_text_color);
            ThreadData threadData = this.B;
            if (threadData != null) {
                MaskView.c(this.v0, threadData.isNovelThread());
                MaskView.c(this.u0, this.B.isNovelThread());
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

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            this.p0 = onClickListener;
        }
    }

    public void setPostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
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
    public void setUseDynamicLikeRes() {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (agreeView = this.e) == null) {
            return;
        }
        agreeView.setUseDynamicLikeResForPbFirstFloor();
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
        if (!(interceptable == null || interceptable.invokeL(1048596, this, view2) == null) || (onClickListener = this.p0) == null) {
            return;
        }
        onClickListener.onClick(view2);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void w(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, view2) == null) || (onClickListener = this.p0) == null) {
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
        Q();
    }
}

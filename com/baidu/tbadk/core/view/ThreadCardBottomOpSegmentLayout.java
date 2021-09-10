package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ThreadCardBottomOpSegmentLayout extends ThreadCommentAndPraiseInfoLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AgreeView.d v;

    /* loaded from: classes6.dex */
    public class a implements AgreeView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadCardBottomOpSegmentLayout f47791a;

        public a(ThreadCardBottomOpSegmentLayout threadCardBottomOpSegmentLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCardBottomOpSegmentLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47791a = threadCardBottomOpSegmentLayout;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.d
        public void a(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                this.f47791a.x(this.f47791a.D(), z);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCardBottomOpSegmentLayout(Context context) {
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
        this.v = new a(this);
    }

    public final boolean A(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            boolean isAgreeAlone = this.mAgreeView.isAgreeAlone();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mAgreeView.getLayoutParams();
            int i2 = layoutParams.width;
            float f2 = layoutParams.weight;
            if (z) {
                return (f2 == (isAgreeAlone ? 1.0f : 2.0f) && i2 == 0) ? false : true;
            }
            return (f2 == 0.0f && i2 == -2) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public final boolean B(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mShareContainer.getLayoutParams();
            float f2 = layoutParams.weight;
            int i2 = layoutParams.width;
            return z ? (f2 == 1.0f && i2 == 0) ? false : true : (f2 == 0.0f && i2 == -2) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mData != null : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getRootView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true) : (View) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void initView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            super.initView(view);
            this.mAgreeView.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
            this.mAgreeView.isUseHomePageStyleAb(true);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onDataAfterLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            x(D(), this.mAgreeView.isAgreeAlone());
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.updateLayout();
            this.mAgreeView.setVisibilityListener(this.v);
            boolean D = D();
            if (B(D) || A(D)) {
                this.mAgreeView.adjustLayoutForWeight(D);
                y(D());
            }
        }
    }

    public final void x(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mAgreeView.getLayoutParams();
            int i2 = layoutParams.width;
            float f2 = layoutParams.weight;
            if (!z) {
                if (f2 == 0.0f && i2 == -2) {
                    return;
                }
                layoutParams.width = -2;
                layoutParams.weight = 0.0f;
                layoutParams.leftMargin = l.g(this.mContext, R.dimen.tbds50);
                layoutParams.rightMargin = 0;
                this.mAgreeView.setLayoutParams(layoutParams);
                return;
            }
            float f3 = z2 ? 1.0f : 2.0f;
            if (f2 == f3 && i2 == 0) {
                return;
            }
            layoutParams.width = 0;
            layoutParams.weight = f3;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.mAgreeView.setLayoutParams(layoutParams);
        }
    }

    public final void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                z(0, -1, 0, 1.0f, true, this.mAgreeView.isAgreeAlone());
                return;
            }
            z(-2, -1, l.g(getContext(), R.dimen.tbds78), 0.0f, false, this.mAgreeView.isAgreeAlone());
        }
    }

    public final void z(int i2, int i3, int i4, float f2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.mShareContainer.setLayoutParams(new LinearLayout.LayoutParams(i2, i3, f2));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mSelectText.getLayoutParams();
            layoutParams.leftMargin = 0;
            this.mSelectText.setLayoutParams(layoutParams);
            this.mCommentContainer.setLayoutParams(new LinearLayout.LayoutParams(i2, i3, f2));
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mCommentImageView.getLayoutParams();
            layoutParams2.leftMargin = i4;
            this.mCommentImageView.setLayoutParams(layoutParams2);
            this.mManageViewContainer.setLayoutParams(new LinearLayout.LayoutParams(i2, i3, f2));
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mManageImageView.getLayoutParams();
            layoutParams3.leftMargin = i4;
            this.mManageImageView.setLayoutParams(layoutParams3);
            this.mSelectContainer.setLayoutParams(new LinearLayout.LayoutParams(i2, i3, f2));
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.mSelectImg.getLayoutParams();
            layoutParams4.leftMargin = i4;
            this.mSelectImg.setLayoutParams(layoutParams4);
            x(z, z2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCardBottomOpSegmentLayout(Context context, AttributeSet attributeSet) {
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
        this.v = new a(this);
    }
}

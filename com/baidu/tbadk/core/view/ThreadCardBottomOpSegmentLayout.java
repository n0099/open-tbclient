package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oi;
/* loaded from: classes3.dex */
public class ThreadCardBottomOpSegmentLayout extends ThreadCommentAndPraiseInfoLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AgreeView.e m0;

    /* loaded from: classes3.dex */
    public class a implements AgreeView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCardBottomOpSegmentLayout a;

        public a(ThreadCardBottomOpSegmentLayout threadCardBottomOpSegmentLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCardBottomOpSegmentLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadCardBottomOpSegmentLayout;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.e
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                this.a.P(this.a.U(), z);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m0 = new a(this);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.G();
            this.d.setVisibilityListener(this.m0);
            boolean U = U();
            if (T(U) || S(U)) {
                this.d.q(U);
                Q(U());
            }
        }
    }

    public final void P(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
            int i = layoutParams.width;
            float f = layoutParams.weight;
            if (!z) {
                if (f == 0.0f && i == -2) {
                    return;
                }
                layoutParams.width = -2;
                layoutParams.weight = 0.0f;
                layoutParams.leftMargin = oi.f(this.B, R.dimen.tbds50);
                layoutParams.rightMargin = 0;
                this.d.setLayoutParams(layoutParams);
                return;
            }
            float f2 = z2 ? 1.0f : 2.0f;
            if (f == f2 && i == 0) {
                return;
            }
            layoutParams.width = 0;
            layoutParams.weight = f2;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.d.setLayoutParams(layoutParams);
        }
    }

    public final void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                R(0, -1, 0, 1.0f, true, this.d.x());
                return;
            }
            R(-2, -1, oi.f(getContext(), R.dimen.tbds78), 0.0f, false, this.d.x());
        }
    }

    public final void R(int i, int i2, int i3, float f, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.k.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.y.getLayoutParams();
            layoutParams.leftMargin = 0;
            this.y.setLayoutParams(layoutParams);
            this.h.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams2.leftMargin = i3;
            this.f.setLayoutParams(layoutParams2);
            this.p.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams3.leftMargin = i3;
            this.o.setLayoutParams(layoutParams3);
            this.z.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.x.getLayoutParams();
            layoutParams4.leftMargin = i3;
            this.x.setLayoutParams(layoutParams4);
            P(z, z2);
        }
    }

    public final boolean S(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            boolean x = this.d.x();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
            int i = layoutParams.width;
            float f = layoutParams.weight;
            if (z) {
                return (f == (x ? 1.0f : 2.0f) && i == 0) ? false : true;
            }
            return (f == 0.0f && i == -2) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public final boolean T(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            float f = layoutParams.weight;
            int i = layoutParams.width;
            return z ? (f == 1.0f && i == 0) ? false : true : (f == 0.0f && i == -2) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public final boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.A != null : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) ? LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d060e, (ViewGroup) this, true) : (View) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void p(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            super.p(view2);
            this.d.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
            this.d.z(true);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            P(U(), this.d.x());
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
        this.m0 = new a(this);
    }
}

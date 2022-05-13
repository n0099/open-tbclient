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
import com.repackage.mi;
/* loaded from: classes3.dex */
public class ThreadCardBottomOpSegmentLayout extends ThreadCommentAndPraiseInfoLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AgreeView.g p0;

    /* loaded from: classes3.dex */
    public class a implements AgreeView.g {
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

        @Override // com.baidu.tbadk.core.view.AgreeView.g
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                this.a.Q(this.a.V(), z);
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
        this.p0 = new a(this);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.H();
            this.e.setVisibilityListener(this.p0);
            boolean V = V();
            if (U(V) || T(V)) {
                this.e.v(V);
                R(V());
            }
        }
    }

    public final void Q(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.getLayoutParams();
            int i = layoutParams.width;
            float f = layoutParams.weight;
            if (!z) {
                if (f == 0.0f && i == -2) {
                    return;
                }
                layoutParams.width = -2;
                layoutParams.weight = 0.0f;
                layoutParams.leftMargin = mi.f(this.C, R.dimen.tbds50);
                layoutParams.rightMargin = 0;
                this.e.setLayoutParams(layoutParams);
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
            this.e.setLayoutParams(layoutParams);
        }
    }

    public final void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                S(0, -1, 0, 1.0f, true, this.e.C());
                return;
            }
            S(-2, -1, mi.f(getContext(), R.dimen.tbds78), 0.0f, false, this.e.C());
        }
    }

    public final void S(int i, int i2, int i3, float f, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.l.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.z.getLayoutParams();
            layoutParams.leftMargin = 0;
            this.z.setLayoutParams(layoutParams);
            this.i.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams2.leftMargin = i3;
            this.g.setLayoutParams(layoutParams2);
            this.q.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.p.getLayoutParams();
            layoutParams3.leftMargin = i3;
            this.p.setLayoutParams(layoutParams3);
            this.A.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.y.getLayoutParams();
            layoutParams4.leftMargin = i3;
            this.y.setLayoutParams(layoutParams4);
            Q(z, z2);
        }
    }

    public final boolean T(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            boolean C = this.e.C();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.getLayoutParams();
            int i = layoutParams.width;
            float f = layoutParams.weight;
            if (z) {
                return (f == (C ? 1.0f : 2.0f) && i == 0) ? false : true;
            }
            return (f == 0.0f && i == -2) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public final boolean U(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.l.getLayoutParams();
            float f = layoutParams.weight;
            int i = layoutParams.width;
            return z ? (f == 1.0f && i == 0) ? false : true : (f == 0.0f && i == -2) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public final boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.B != null : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) ? LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0602, (ViewGroup) this, true) : (View) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void r(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            super.r(view2);
            this.e.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
            this.e.G(true);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Q(V(), this.e.C());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCardBottomOpSegmentLayout(Context context, boolean z) {
        super(context, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.p0 = new a(this);
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
        this.p0 = new a(this);
    }
}

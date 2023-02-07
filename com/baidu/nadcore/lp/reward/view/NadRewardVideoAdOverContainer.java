package com.baidu.nadcore.lp.reward.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.slidingtag.NadRewardSlidingTagView;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.R;
import com.baidu.tieba.lr0;
import com.baidu.tieba.nd1;
import com.baidu.tieba.or0;
import com.baidu.tieba.xq0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class NadRewardVideoAdOverContainer extends NadVideoAdOverContainer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public LottieAnimationView B;
    public LottieAnimationView C;
    public NadRewardSlidingTagView y;
    public View.OnClickListener z;

    @Override // com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.nad_reward_video_ad_over_layout : invokeV.intValue;
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ NadRewardVideoAdOverContainer b;

        public a(NadRewardVideoAdOverContainer nadRewardVideoAdOverContainer, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoAdOverContainer, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nadRewardVideoAdOverContainer;
            this.a = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.z != null) {
                    this.b.z.onClick(view2);
                }
                this.b.C.setVisibility(8);
                this.b.z(ClogBuilder.LogType.FREE_CLICK, "packet", this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements LottieListener<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LottieAnimationView a;
        public final /* synthetic */ NadRewardVideoAdOverContainer b;

        public b(NadRewardVideoAdOverContainer nadRewardVideoAdOverContainer, LottieAnimationView lottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoAdOverContainer, lottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nadRewardVideoAdOverContainer;
            this.a = lottieAnimationView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.a.setVisibility(8);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements LottieListener<LottieComposition> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LottieAnimationView a;
        public final /* synthetic */ NadRewardVideoAdOverContainer b;

        public c(NadRewardVideoAdOverContainer nadRewardVideoAdOverContainer, LottieAnimationView lottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoAdOverContainer, lottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nadRewardVideoAdOverContainer;
            this.a = lottieAnimationView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                this.a.setComposition(lottieComposition);
                this.a.setRepeatCount(-1);
                this.a.playAnimation();
                this.a.setVisibility(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadRewardVideoAdOverContainer(Context context) {
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
        this.z = null;
    }

    public final void H(@NonNull AdBaseModel adBaseModel) {
        lr0 lr0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel) == null) {
            if (adBaseModel instanceof xq0) {
                lr0Var = ((xq0) adBaseModel).h();
            } else {
                lr0Var = null;
            }
            if (lr0Var == null) {
                this.y.setVisibility(8);
                return;
            }
            this.y.setVisibility(0);
            this.y.F(lr0Var);
            this.y.setOnClickListener(s(adBaseModel, ClogBuilder.Area.REWARD_SLIDING_TAG.type));
        }
    }

    @Override // com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer
    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            super.n(context);
            this.y = (NadRewardSlidingTagView) findViewById(R.id.ad_sliding_tag);
            this.A = (LinearLayout) findViewById(R.id.festival_entrance_container);
            this.C = (LottieAnimationView) findViewById(R.id.festival_bubble_lottie);
            this.B = (LottieAnimationView) findViewById(R.id.festival_entrance_lottie);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadRewardVideoAdOverContainer(Context context, AttributeSet attributeSet) {
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
        this.z = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadRewardVideoAdOverContainer(Context context, AttributeSet attributeSet, int i) {
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
        this.z = null;
    }

    @Override // com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer
    public void setData(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adBaseModel) == null) {
            super.setData(adBaseModel);
            H(adBaseModel);
            G(adBaseModel);
        }
    }

    public void setFestivalClickCallback(@NonNull View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.z = onClickListener;
        }
    }

    public final void G(@NonNull AdBaseModel adBaseModel) {
        or0 or0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adBaseModel) == null) {
            if (adBaseModel instanceof xq0) {
                or0Var = ((xq0) adBaseModel).f().m();
            } else {
                or0Var = null;
            }
            if (or0Var == null) {
                this.A.setVisibility(8);
                return;
            }
            I(getContext(), this.C, or0Var.b);
            I(getContext(), this.B, or0Var.a);
            this.A.setVisibility(0);
            z(ClogBuilder.LogType.FREE_SHOW, "packet", adBaseModel);
            this.A.setOnClickListener(new a(this, adBaseModel));
        }
    }

    public final void I(@NonNull Context context, @NonNull LottieAnimationView lottieAnimationView, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, lottieAnimationView, str) == null) {
            if (TextUtils.isEmpty(str)) {
                lottieAnimationView.setVisibility(8);
            } else {
                LottieCompositionFactory.fromUrl(context, str, String.valueOf(str.hashCode())).addListener(new c(this, lottieAnimationView)).addFailureListener(new b(this, lottieAnimationView));
            }
        }
    }

    @NonNull
    public nd1<View> getTransitionButtonView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return (nd1) invokeV.objValue;
    }

    public void setFestivalEntranceContainerInvisible() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.A.setVisibility(8);
        }
    }

    @Override // com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.y();
            this.y.x();
            this.C.cancelAnimation();
            this.B.cancelAnimation();
        }
    }
}

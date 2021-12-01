package com.baidu.nadcore.widget.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import c.a.b0.b.e;
import c.a.b0.b.g;
import c.a.b0.p.o;
import c.a.b0.p.p;
import c.a.b0.u.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.uitemplate.HorizontalVideoTailView;
import com.baidu.nadcore.widget.uitemplate.NadRewardOperateView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class NadRewardHorizontalVideoView extends NadRewardVideoView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: k  reason: collision with root package name */
    public HorizontalVideoTailView f38014k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadRewardHorizontalVideoView(Context context) {
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
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardVideoView
    public void hideTailFrame() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f38014k != null && isShowingTailFrame()) {
            NadRewardOperateView nadRewardOperateView = this.mOperateBar;
            if (nadRewardOperateView != null) {
                nadRewardOperateView.setVisibility(0);
            }
            this.f38014k.hideTailFrame();
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardVideoView, com.baidu.nadcore.widget.view.NadRewardBaseView
    public void initInflate(LayoutInflater layoutInflater, o oVar) {
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutInflater, oVar) == null) {
            int i2 = g.nad_reward_horizontal_video_view;
            if (oVar != null && (num = (Integer) c.b(oVar.a, AdBaseModel.STYLE.VIDEO)) != null) {
                i2 = num.intValue();
            }
            layoutInflater.inflate(i2, this);
        }
    }

    public boolean isShowingTailFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HorizontalVideoTailView horizontalVideoTailView = this.f38014k;
            return horizontalVideoTailView != null && horizontalVideoTailView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardVideoView
    public void showTailFrame() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f38014k == null || isShowingTailFrame() || !(getTag() instanceof AdBaseModel)) {
            return;
        }
        NadRewardOperateView nadRewardOperateView = this.mOperateBar;
        if (nadRewardOperateView != null) {
            nadRewardOperateView.setVisibility(8);
        }
        this.f38014k.showTailFrame((AdBaseModel) getTag());
        this.f38014k.bringToFront();
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void updateOrientationState() {
        WeakReference<Activity> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (weakReference = this.mActivityRef) == null || weakReference.get() == null) {
            return;
        }
        this.mActivityRef.get().setRequestedOrientation(8);
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardVideoView, com.baidu.nadcore.widget.view.NadRewardBaseView
    public void updateSubViewData(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adBaseModel) == null) {
            super.updateSubViewData(adBaseModel);
            v(adBaseModel);
        }
    }

    public final void v(AdBaseModel adBaseModel) {
        HorizontalVideoTailView horizontalVideoTailView;
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, adBaseModel) == null) || (horizontalVideoTailView = this.f38014k) == null || adBaseModel == null || (pVar = adBaseModel.f37577g) == null || !pVar.f1820k) {
            return;
        }
        horizontalVideoTailView.setAdInfo(pVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadRewardHorizontalVideoView(Context context, AttributeSet attributeSet) {
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
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadRewardHorizontalVideoView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (o) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadRewardHorizontalVideoView(Context context, AttributeSet attributeSet, int i2, o oVar) {
        super(context, attributeSet, i2, oVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), oVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (o) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f38014k = (HorizontalVideoTailView) findViewById(e.nad_horizontal_video_tail_frame_view);
    }
}

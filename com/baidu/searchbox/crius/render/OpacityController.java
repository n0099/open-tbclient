package com.baidu.searchbox.crius.render;

import android.view.View;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.crius.data.RenderData;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0002\u0010\fR\u0016\u0010\r\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/crius/render/OpacityController;", "", NativeConstants.OPACITY, "", "isOpacityValid", "(D)Z", "Landroid/view/View;", NativeConstants.TYPE_VIEW, "pressed", "", "updateOpacity", "(Landroid/view/View;Z)V", "D", "opacityActive", SpeedStatsUtils.IS_NIGHT_MODE, "isVisited", "Lcom/baidu/searchbox/crius/data/RenderData$Opacities;", "opacities", "<init>", "(ZZLcom/baidu/searchbox/crius/data/RenderData$Opacities;)V", "lib-crius_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class OpacityController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public double opacity;
    public double opacityActive;

    private final boolean isOpacityValid(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Double.valueOf(d)})) == null) ? d >= 0.0d && d <= 1.0d : invokeCommon.booleanValue;
    }

    public OpacityController(boolean z, boolean z2, RenderData.Opacities opacities) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), opacities};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(opacities, "opacities");
        this.opacity = -10000.0d;
        this.opacityActive = -10000.0d;
        if (z & z2) {
            if (isOpacityValid(opacities.opacityNightVisitedActive)) {
                this.opacityActive = opacities.opacityNightVisitedActive;
            } else if (isOpacityValid(opacities.opacityNightActive)) {
                this.opacityActive = opacities.opacityNightActive;
            } else {
                this.opacityActive = opacities.opacityActive;
            }
            if (isOpacityValid(opacities.opacityNightVisited)) {
                this.opacity = opacities.opacityNightVisited;
            } else if (isOpacityValid(opacities.opacityNight)) {
                this.opacity = opacities.opacityNight;
            } else {
                this.opacity = opacities.opacity;
            }
        } else if ((!z2) & z) {
            if (isOpacityValid(opacities.opacityNightActive)) {
                this.opacityActive = opacities.opacityNightActive;
            } else {
                this.opacityActive = opacities.opacityActive;
            }
            if (isOpacityValid(opacities.opacityNight)) {
                this.opacity = opacities.opacityNight;
            } else {
                this.opacity = opacities.opacity;
            }
        } else if ((!z) & z2) {
            if (isOpacityValid(opacities.opacityVisitedActive)) {
                this.opacityActive = opacities.opacityVisitedActive;
            } else {
                this.opacityActive = opacities.opacityActive;
            }
            if (isOpacityValid(opacities.opacityVisited)) {
                this.opacity = opacities.opacityVisited;
            } else {
                this.opacity = opacities.opacity;
            }
        } else if ((!z) & (!z2)) {
            this.opacityActive = opacities.opacityActive;
            this.opacity = opacities.opacity;
        }
    }

    public final void updateOpacity(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            if (z && isOpacityValid(this.opacityActive)) {
                view2.setAlpha((float) this.opacityActive);
            }
            if (!z) {
                if (isOpacityValid(this.opacity)) {
                    view2.setAlpha((float) this.opacity);
                } else {
                    view2.setAlpha(1.0f);
                }
            }
        }
    }
}

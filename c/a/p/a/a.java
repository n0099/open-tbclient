package c.a.p.a;

import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] GenericDraweeHierarchy;
    public static final int GenericDraweeHierarchy_actualImageScaleType = 0;
    public static final int GenericDraweeHierarchy_backgroundImage = 1;
    public static final int GenericDraweeHierarchy_fadeDuration = 2;
    public static final int GenericDraweeHierarchy_failureImage = 3;
    public static final int GenericDraweeHierarchy_failureImageScaleType = 4;
    public static final int GenericDraweeHierarchy_overlayImage = 5;
    public static final int GenericDraweeHierarchy_placeholderImage = 6;
    public static final int GenericDraweeHierarchy_placeholderImageScaleType = 7;
    public static final int GenericDraweeHierarchy_pressedStateOverlayImage = 8;
    public static final int GenericDraweeHierarchy_progressBarAutoRotateInterval = 9;
    public static final int GenericDraweeHierarchy_progressBarImage = 10;
    public static final int GenericDraweeHierarchy_progressBarImageScaleType = 11;
    public static final int GenericDraweeHierarchy_retryImage = 12;
    public static final int GenericDraweeHierarchy_retryImageScaleType = 13;
    public static final int GenericDraweeHierarchy_roundAsCircle = 14;
    public static final int GenericDraweeHierarchy_roundBottomEnd = 15;
    public static final int GenericDraweeHierarchy_roundBottomLeft = 16;
    public static final int GenericDraweeHierarchy_roundBottomRight = 17;
    public static final int GenericDraweeHierarchy_roundBottomStart = 18;
    public static final int GenericDraweeHierarchy_roundTopEnd = 19;
    public static final int GenericDraweeHierarchy_roundTopLeft = 20;
    public static final int GenericDraweeHierarchy_roundTopRight = 21;
    public static final int GenericDraweeHierarchy_roundTopStart = 22;
    public static final int GenericDraweeHierarchy_roundWithOverlayColor = 23;
    public static final int GenericDraweeHierarchy_roundedCornerRadius = 24;
    public static final int GenericDraweeHierarchy_roundingBorderColor = 25;
    public static final int GenericDraweeHierarchy_roundingBorderPadding = 26;
    public static final int GenericDraweeHierarchy_roundingBorderWidth = 27;
    public static final int GenericDraweeHierarchy_viewAspectRatio = 28;
    public static final int[] SVGImageView;
    public static final int SVGImageView_svg = 0;
    public static final int[] SimpleDraweeView;
    public static final int SimpleDraweeView_actualImageResource = 0;
    public static final int SimpleDraweeView_actualImageScaleType = 1;
    public static final int SimpleDraweeView_actualImageUri = 2;
    public static final int SimpleDraweeView_backgroundImage = 3;
    public static final int SimpleDraweeView_fadeDuration = 4;
    public static final int SimpleDraweeView_failureImage = 5;
    public static final int SimpleDraweeView_failureImageScaleType = 6;
    public static final int SimpleDraweeView_overlayImage = 7;
    public static final int SimpleDraweeView_placeholderImage = 8;
    public static final int SimpleDraweeView_placeholderImageScaleType = 9;
    public static final int SimpleDraweeView_pressedStateOverlayImage = 10;
    public static final int SimpleDraweeView_progressBarAutoRotateInterval = 11;
    public static final int SimpleDraweeView_progressBarImage = 12;
    public static final int SimpleDraweeView_progressBarImageScaleType = 13;
    public static final int SimpleDraweeView_retryImage = 14;
    public static final int SimpleDraweeView_retryImageScaleType = 15;
    public static final int SimpleDraweeView_roundAsCircle = 16;
    public static final int SimpleDraweeView_roundBottomEnd = 17;
    public static final int SimpleDraweeView_roundBottomLeft = 18;
    public static final int SimpleDraweeView_roundBottomRight = 19;
    public static final int SimpleDraweeView_roundBottomStart = 20;
    public static final int SimpleDraweeView_roundTopEnd = 21;
    public static final int SimpleDraweeView_roundTopLeft = 22;
    public static final int SimpleDraweeView_roundTopRight = 23;
    public static final int SimpleDraweeView_roundTopStart = 24;
    public static final int SimpleDraweeView_roundWithOverlayColor = 25;
    public static final int SimpleDraweeView_roundedCornerRadius = 26;
    public static final int SimpleDraweeView_roundingBorderColor = 27;
    public static final int SimpleDraweeView_roundingBorderPadding = 28;
    public static final int SimpleDraweeView_roundingBorderWidth = 29;
    public static final int SimpleDraweeView_svgImage = 31;
    public static final int SimpleDraweeView_viewAspectRatio = 30;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1185612403, "Lc/a/p/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1185612403, "Lc/a/p/a/a;");
                return;
            }
        }
        GenericDraweeHierarchy = new int[]{R.attr.actualImageScaleType, R.attr.backgroundImage, R.attr.fadeDuration, R.attr.failureImage, R.attr.failureImageScaleType, R.attr.overlayImage, R.attr.placeholderImage, R.attr.placeholderImageScaleType, R.attr.pressedStateOverlayImage, R.attr.progressBarAutoRotateInterval, R.attr.progressBarImage, R.attr.progressBarImageScaleType, R.attr.retryImage, R.attr.retryImageScaleType, R.attr.roundAsCircle, R.attr.roundBottomEnd, R.attr.roundBottomLeft, R.attr.roundBottomRight, R.attr.roundBottomStart, R.attr.roundTopEnd, R.attr.roundTopLeft, R.attr.roundTopRight, R.attr.roundTopStart, R.attr.roundWithOverlayColor, R.attr.roundedCornerRadius, R.attr.roundingBorderColor, R.attr.roundingBorderPadding, R.attr.roundingBorderWidth, R.attr.viewAspectRatio};
        SVGImageView = new int[]{R.attr.svg};
        SimpleDraweeView = new int[]{R.attr.actualImageResource, R.attr.actualImageScaleType, R.attr.actualImageUri, R.attr.backgroundImage, R.attr.fadeDuration, R.attr.failureImage, R.attr.failureImageScaleType, R.attr.overlayImage, R.attr.placeholderImage, R.attr.placeholderImageScaleType, R.attr.pressedStateOverlayImage, R.attr.progressBarAutoRotateInterval, R.attr.progressBarImage, R.attr.progressBarImageScaleType, R.attr.retryImage, R.attr.retryImageScaleType, R.attr.roundAsCircle, R.attr.roundBottomEnd, R.attr.roundBottomLeft, R.attr.roundBottomRight, R.attr.roundBottomStart, R.attr.roundTopEnd, R.attr.roundTopLeft, R.attr.roundTopRight, R.attr.roundTopStart, R.attr.roundWithOverlayColor, R.attr.roundedCornerRadius, R.attr.roundingBorderColor, R.attr.roundingBorderPadding, R.attr.roundingBorderWidth, R.attr.viewAspectRatio, R.attr.svgImage};
    }
}

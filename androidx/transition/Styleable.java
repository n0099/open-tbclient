package androidx.transition;

import android.annotation.SuppressLint;
import androidx.annotation.StyleableRes;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"InlinedApi"})
/* loaded from: classes.dex */
public class Styleable {
    public static /* synthetic */ Interceptable $ic;
    @StyleableRes
    public static final int[] ARC_MOTION;
    @StyleableRes
    public static final int[] CHANGE_BOUNDS;
    @StyleableRes
    public static final int[] CHANGE_TRANSFORM;
    @StyleableRes
    public static final int[] FADE;
    @StyleableRes
    public static final int[] PATTERN_PATH_MOTION;
    @StyleableRes
    public static final int[] SLIDE;
    @StyleableRes
    public static final int[] TRANSITION;
    @StyleableRes
    public static final int[] TRANSITION_MANAGER;
    @StyleableRes
    public static final int[] TRANSITION_SET;
    @StyleableRes
    public static final int[] TRANSITION_TARGET;
    @StyleableRes
    public static final int[] VISIBILITY_TRANSITION;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface ArcMotion {
        @StyleableRes
        public static final int MAXIMUM_ANGLE = 2;
        @StyleableRes
        public static final int MINIMUM_HORIZONTAL_ANGLE = 0;
        @StyleableRes
        public static final int MINIMUM_VERTICAL_ANGLE = 1;
    }

    /* loaded from: classes.dex */
    public interface ChangeBounds {
        @StyleableRes
        public static final int RESIZE_CLIP = 0;
    }

    /* loaded from: classes.dex */
    public interface ChangeTransform {
        @StyleableRes
        public static final int REPARENT = 0;
        @StyleableRes
        public static final int REPARENT_WITH_OVERLAY = 1;
    }

    /* loaded from: classes.dex */
    public interface Fade {
        @StyleableRes
        public static final int FADING_MODE = 0;
    }

    /* loaded from: classes.dex */
    public interface PatternPathMotion {
        @StyleableRes
        public static final int PATTERN_PATH_DATA = 0;
    }

    /* loaded from: classes.dex */
    public interface Slide {
        @StyleableRes
        public static final int SLIDE_EDGE = 0;
    }

    /* loaded from: classes.dex */
    public interface Transition {
        @StyleableRes
        public static final int DURATION = 1;
        @StyleableRes
        public static final int INTERPOLATOR = 0;
        @StyleableRes
        public static final int MATCH_ORDER = 3;
        @StyleableRes
        public static final int START_DELAY = 2;
    }

    /* loaded from: classes.dex */
    public interface TransitionManager {
        @StyleableRes
        public static final int FROM_SCENE = 0;
        @StyleableRes
        public static final int TO_SCENE = 1;
        @StyleableRes
        public static final int TRANSITION = 2;
    }

    /* loaded from: classes.dex */
    public interface TransitionSet {
        @StyleableRes
        public static final int TRANSITION_ORDERING = 0;
    }

    /* loaded from: classes.dex */
    public interface TransitionTarget {
        @StyleableRes
        public static final int EXCLUDE_CLASS = 3;
        @StyleableRes
        public static final int EXCLUDE_ID = 2;
        @StyleableRes
        public static final int EXCLUDE_NAME = 5;
        @StyleableRes
        public static final int TARGET_CLASS = 0;
        @StyleableRes
        public static final int TARGET_ID = 1;
        @StyleableRes
        public static final int TARGET_NAME = 4;
    }

    /* loaded from: classes.dex */
    public interface VisibilityTransition {
        @StyleableRes
        public static final int TRANSITION_VISIBILITY_MODE = 0;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1466469936, "Landroidx/transition/Styleable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1466469936, "Landroidx/transition/Styleable;");
                return;
            }
        }
        TRANSITION_TARGET = new int[]{16842799, 16843740, 16843841, 16843842, 16843853, 16843854};
        TRANSITION_MANAGER = new int[]{16843741, 16843742, 16843743};
        TRANSITION = new int[]{16843073, 16843160, 16843746, 16843855};
        CHANGE_BOUNDS = new int[]{16843983};
        VISIBILITY_TRANSITION = new int[]{16843900};
        FADE = new int[]{16843745};
        CHANGE_TRANSFORM = new int[]{16843964, 16843965};
        SLIDE = new int[]{16843824};
        TRANSITION_SET = new int[]{16843744};
        ARC_MOTION = new int[]{16843901, 16843902, 16843903};
        PATTERN_PATH_MOTION = new int[]{16843978};
    }

    public Styleable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}

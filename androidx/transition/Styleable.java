package androidx.transition;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class Styleable {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] ARC_MOTION;
    public static final int[] CHANGE_BOUNDS;
    public static final int[] CHANGE_TRANSFORM;
    public static final int[] FADE;
    public static final int[] PATTERN_PATH_MOTION;
    public static final int[] SLIDE;
    public static final int[] TRANSITION;
    public static final int[] TRANSITION_MANAGER;
    public static final int[] TRANSITION_SET;
    public static final int[] TRANSITION_TARGET;
    public static final int[] VISIBILITY_TRANSITION;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface ArcMotion {
        public static final int MAXIMUM_ANGLE = 2;
        public static final int MINIMUM_HORIZONTAL_ANGLE = 0;
        public static final int MINIMUM_VERTICAL_ANGLE = 1;
    }

    /* loaded from: classes.dex */
    public interface ChangeBounds {
        public static final int RESIZE_CLIP = 0;
    }

    /* loaded from: classes.dex */
    public interface ChangeTransform {
        public static final int REPARENT = 0;
        public static final int REPARENT_WITH_OVERLAY = 1;
    }

    /* loaded from: classes.dex */
    public interface Fade {
        public static final int FADING_MODE = 0;
    }

    /* loaded from: classes.dex */
    public interface PatternPathMotion {
        public static final int PATTERN_PATH_DATA = 0;
    }

    /* loaded from: classes.dex */
    public interface Slide {
        public static final int SLIDE_EDGE = 0;
    }

    /* loaded from: classes.dex */
    public interface Transition {
        public static final int DURATION = 1;
        public static final int INTERPOLATOR = 0;
        public static final int MATCH_ORDER = 3;
        public static final int START_DELAY = 2;
    }

    /* loaded from: classes.dex */
    public interface TransitionManager {
        public static final int FROM_SCENE = 0;
        public static final int TO_SCENE = 1;
        public static final int TRANSITION = 2;
    }

    /* loaded from: classes.dex */
    public interface TransitionSet {
        public static final int TRANSITION_ORDERING = 0;
    }

    /* loaded from: classes.dex */
    public interface TransitionTarget {
        public static final int EXCLUDE_CLASS = 3;
        public static final int EXCLUDE_ID = 2;
        public static final int EXCLUDE_NAME = 5;
        public static final int TARGET_CLASS = 0;
        public static final int TARGET_ID = 1;
        public static final int TARGET_NAME = 4;
    }

    /* loaded from: classes.dex */
    public interface VisibilityTransition {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}

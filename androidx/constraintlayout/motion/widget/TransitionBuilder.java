package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class TransitionBuilder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "TransitionBuilder";
    public transient /* synthetic */ FieldHolder $fh;

    public TransitionBuilder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static MotionScene.Transition buildTransition(MotionScene motionScene, int i, int i2, ConstraintSet constraintSet, int i3, ConstraintSet constraintSet2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{motionScene, Integer.valueOf(i), Integer.valueOf(i2), constraintSet, Integer.valueOf(i3), constraintSet2})) == null) {
            MotionScene.Transition transition = new MotionScene.Transition(i, motionScene, i2, i3);
            updateConstraintSetInMotionScene(motionScene, transition, constraintSet, constraintSet2);
            return transition;
        }
        return (MotionScene.Transition) invokeCommon.objValue;
    }

    public static void updateConstraintSetInMotionScene(MotionScene motionScene, MotionScene.Transition transition, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, motionScene, transition, constraintSet, constraintSet2) == null) {
            int startConstraintSetId = transition.getStartConstraintSetId();
            int endConstraintSetId = transition.getEndConstraintSetId();
            motionScene.setConstraintSet(startConstraintSetId, constraintSet);
            motionScene.setConstraintSet(endConstraintSetId, constraintSet2);
        }
    }

    public static void validate(MotionLayout motionLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, motionLayout) == null) {
            MotionScene motionScene = motionLayout.mScene;
            if (motionScene != null) {
                if (motionScene.validateLayout(motionLayout)) {
                    if (motionScene.mCurrentTransition == null || motionScene.getDefinedTransitions().isEmpty()) {
                        throw new RuntimeException("Invalid motion layout. Motion Scene doesn't have any transition.");
                    }
                    return;
                }
                throw new RuntimeException("MotionLayout doesn't have the right motion scene.");
            }
            throw new RuntimeException("Invalid motion layout. Layout missing Motion Scene.");
        }
    }
}

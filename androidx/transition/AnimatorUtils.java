package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AnimatorUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface AnimatorPauseListenerCompat {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    public AnimatorUtils() {
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

    public static void addPauseListener(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, animator, animatorListenerAdapter) == null) && Build.VERSION.SDK_INT >= 19) {
            animator.addPauseListener(animatorListenerAdapter);
        }
    }

    public static void pause(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, animator) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                animator.pause();
                return;
            }
            ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
            if (listeners != null) {
                int size = listeners.size();
                for (int i = 0; i < size; i++) {
                    Animator.AnimatorListener animatorListener = listeners.get(i);
                    if (animatorListener instanceof AnimatorPauseListenerCompat) {
                        ((AnimatorPauseListenerCompat) animatorListener).onAnimationPause(animator);
                    }
                }
            }
        }
    }

    public static void resume(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, animator) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                animator.resume();
                return;
            }
            ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
            if (listeners != null) {
                int size = listeners.size();
                for (int i = 0; i < size; i++) {
                    Animator.AnimatorListener animatorListener = listeners.get(i);
                    if (animatorListener instanceof AnimatorPauseListenerCompat) {
                        ((AnimatorPauseListenerCompat) animatorListener).onAnimationResume(animator);
                    }
                }
            }
        }
    }
}

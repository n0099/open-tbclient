package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class Slide extends Visibility {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROPNAME_SCREEN_POSITION = "android:slide:screenPosition";
    public static final TimeInterpolator sAccelerate;
    public static final CalculateSlide sCalculateBottom;
    public static final CalculateSlide sCalculateEnd;
    public static final CalculateSlide sCalculateLeft;
    public static final CalculateSlide sCalculateRight;
    public static final CalculateSlide sCalculateStart;
    public static final CalculateSlide sCalculateTop;
    public static final TimeInterpolator sDecelerate;
    public transient /* synthetic */ FieldHolder $fh;
    public CalculateSlide mSlideCalculator;
    public int mSlideEdge;

    /* loaded from: classes.dex */
    public interface CalculateSlide {
        float getGoneX(ViewGroup viewGroup, View view2);

        float getGoneY(ViewGroup viewGroup, View view2);
    }

    /* loaded from: classes.dex */
    public static abstract class CalculateSlideHorizontal implements CalculateSlide {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public CalculateSlideHorizontal() {
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

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneY(ViewGroup viewGroup, View view2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, viewGroup, view2)) == null) ? view2.getTranslationY() : invokeLL.floatValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class CalculateSlideVertical implements CalculateSlide {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public CalculateSlideVertical() {
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

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup viewGroup, View view2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, viewGroup, view2)) == null) ? view2.getTranslationX() : invokeLL.floatValue;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface GravityFlag {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1111397526, "Landroidx/transition/Slide;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1111397526, "Landroidx/transition/Slide;");
                return;
            }
        }
        sDecelerate = new DecelerateInterpolator();
        sAccelerate = new AccelerateInterpolator();
        sCalculateLeft = new CalculateSlideHorizontal() { // from class: androidx.transition.Slide.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        AnonymousClass1 anonymousClass1 = (AnonymousClass1) newInitContext.callArgs[0];
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // androidx.transition.Slide.CalculateSlide
            public float getGoneX(ViewGroup viewGroup, View view2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, viewGroup, view2)) == null) ? view2.getTranslationX() - viewGroup.getWidth() : invokeLL.floatValue;
            }
        };
        sCalculateStart = new CalculateSlideHorizontal() { // from class: androidx.transition.Slide.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        AnonymousClass1 anonymousClass1 = (AnonymousClass1) newInitContext.callArgs[0];
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // androidx.transition.Slide.CalculateSlide
            public float getGoneX(ViewGroup viewGroup, View view2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, viewGroup, view2)) == null) {
                    if (ViewCompat.getLayoutDirection(viewGroup) == 1) {
                        return view2.getTranslationX() + viewGroup.getWidth();
                    }
                    return view2.getTranslationX() - viewGroup.getWidth();
                }
                return invokeLL.floatValue;
            }
        };
        sCalculateTop = new CalculateSlideVertical() { // from class: androidx.transition.Slide.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        AnonymousClass1 anonymousClass1 = (AnonymousClass1) newInitContext.callArgs[0];
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // androidx.transition.Slide.CalculateSlide
            public float getGoneY(ViewGroup viewGroup, View view2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, viewGroup, view2)) == null) ? view2.getTranslationY() - viewGroup.getHeight() : invokeLL.floatValue;
            }
        };
        sCalculateRight = new CalculateSlideHorizontal() { // from class: androidx.transition.Slide.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        AnonymousClass1 anonymousClass1 = (AnonymousClass1) newInitContext.callArgs[0];
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // androidx.transition.Slide.CalculateSlide
            public float getGoneX(ViewGroup viewGroup, View view2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, viewGroup, view2)) == null) ? view2.getTranslationX() + viewGroup.getWidth() : invokeLL.floatValue;
            }
        };
        sCalculateEnd = new CalculateSlideHorizontal() { // from class: androidx.transition.Slide.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        AnonymousClass1 anonymousClass1 = (AnonymousClass1) newInitContext.callArgs[0];
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // androidx.transition.Slide.CalculateSlide
            public float getGoneX(ViewGroup viewGroup, View view2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, viewGroup, view2)) == null) {
                    if (ViewCompat.getLayoutDirection(viewGroup) == 1) {
                        return view2.getTranslationX() - viewGroup.getWidth();
                    }
                    return view2.getTranslationX() + viewGroup.getWidth();
                }
                return invokeLL.floatValue;
            }
        };
        sCalculateBottom = new CalculateSlideVertical() { // from class: androidx.transition.Slide.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        AnonymousClass1 anonymousClass1 = (AnonymousClass1) newInitContext.callArgs[0];
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // androidx.transition.Slide.CalculateSlide
            public float getGoneY(ViewGroup viewGroup, View view2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, viewGroup, view2)) == null) ? view2.getTranslationY() + viewGroup.getHeight() : invokeLL.floatValue;
            }
        };
    }

    public Slide() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSlideCalculator = sCalculateBottom;
        this.mSlideEdge = 80;
        setSlideEdge(80);
    }

    private void captureValues(TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, transitionValues) == null) {
            int[] iArr = new int[2];
            transitionValues.f1020view.getLocationOnScreen(iArr);
            transitionValues.values.put(PROPNAME_SCREEN_POSITION, iArr);
        }
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, transitionValues) == null) {
            super.captureEndValues(transitionValues);
            captureValues(transitionValues);
        }
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transitionValues) == null) {
            super.captureStartValues(transitionValues);
            captureValues(transitionValues);
        }
    }

    public int getSlideEdge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSlideEdge : invokeV.intValue;
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view2, TransitionValues transitionValues, TransitionValues transitionValues2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, viewGroup, view2, transitionValues, transitionValues2)) == null) {
            if (transitionValues2 == null) {
                return null;
            }
            int[] iArr = (int[]) transitionValues2.values.get(PROPNAME_SCREEN_POSITION);
            return TranslationAnimationCreator.createAnimation(view2, transitionValues2, iArr[0], iArr[1], this.mSlideCalculator.getGoneX(viewGroup, view2), this.mSlideCalculator.getGoneY(viewGroup, view2), view2.getTranslationX(), view2.getTranslationY(), sDecelerate, this);
        }
        return (Animator) invokeLLLL.objValue;
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view2, TransitionValues transitionValues, TransitionValues transitionValues2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, viewGroup, view2, transitionValues, transitionValues2)) == null) {
            if (transitionValues == null) {
                return null;
            }
            int[] iArr = (int[]) transitionValues.values.get(PROPNAME_SCREEN_POSITION);
            return TranslationAnimationCreator.createAnimation(view2, transitionValues, iArr[0], iArr[1], view2.getTranslationX(), view2.getTranslationY(), this.mSlideCalculator.getGoneX(viewGroup, view2), this.mSlideCalculator.getGoneY(viewGroup, view2), sAccelerate, this);
        }
        return (Animator) invokeLLLL.objValue;
    }

    public void setSlideEdge(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            if (i == 3) {
                this.mSlideCalculator = sCalculateLeft;
            } else if (i == 5) {
                this.mSlideCalculator = sCalculateRight;
            } else if (i == 48) {
                this.mSlideCalculator = sCalculateTop;
            } else if (i == 80) {
                this.mSlideCalculator = sCalculateBottom;
            } else if (i == 8388611) {
                this.mSlideCalculator = sCalculateStart;
            } else if (i == 8388613) {
                this.mSlideCalculator = sCalculateEnd;
            } else {
                throw new IllegalArgumentException("Invalid slide direction");
            }
            this.mSlideEdge = i;
            SidePropagation sidePropagation = new SidePropagation();
            sidePropagation.setSide(i);
            setPropagation(sidePropagation);
        }
    }

    public Slide(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mSlideCalculator = sCalculateBottom;
        this.mSlideEdge = 80;
        setSlideEdge(i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"RestrictedApi"})
    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mSlideCalculator = sCalculateBottom;
        this.mSlideEdge = 80;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.SLIDE);
        int namedInt = TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        setSlideEdge(namedInt);
    }
}

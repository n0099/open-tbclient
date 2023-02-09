package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.transition.AnimatorUtils;
import androidx.transition.Transition;
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
/* loaded from: classes.dex */
public abstract class Visibility extends Transition {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    public static final String PROPNAME_PARENT = "android:visibility:parent";
    public static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    public static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    public static final String[] sTransitionProperties;
    public transient /* synthetic */ FieldHolder $fh;
    public int mMode;

    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface Mode {
    }

    public Animator onAppear(ViewGroup viewGroup, View view2, TransitionValues transitionValues, TransitionValues transitionValues2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, viewGroup, view2, transitionValues, transitionValues2)) == null) {
            return null;
        }
        return (Animator) invokeLLLL.objValue;
    }

    public Animator onDisappear(ViewGroup viewGroup, View view2, TransitionValues transitionValues, TransitionValues transitionValues2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, viewGroup, view2, transitionValues, transitionValues2)) == null) {
            return null;
        }
        return (Animator) invokeLLLL.objValue;
    }

    /* loaded from: classes.dex */
    public static class DisappearListener extends AnimatorListenerAdapter implements Transition.TransitionListener, AnimatorUtils.AnimatorPauseListenerCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mCanceled;
        public final int mFinalVisibility;
        public boolean mLayoutSuppressed;
        public final ViewGroup mParent;
        public final boolean mSuppressLayout;
        public final View mView;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, animator) == null) {
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, transition) == null) {
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, transition) == null) {
            }
        }

        public DisappearListener(View view2, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCanceled = false;
            this.mView = view2;
            this.mFinalVisibility = i;
            this.mParent = (ViewGroup) view2.getParent();
            this.mSuppressLayout = z;
            suppressLayout(true);
        }

        private void hideViewWhenNotCanceled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                if (!this.mCanceled) {
                    ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
                    ViewGroup viewGroup = this.mParent;
                    if (viewGroup != null) {
                        viewGroup.invalidate();
                    }
                }
                suppressLayout(false);
            }
        }

        private void suppressLayout(boolean z) {
            ViewGroup viewGroup;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(65538, this, z) == null) && this.mSuppressLayout && this.mLayoutSuppressed != z && (viewGroup = this.mParent) != null) {
                this.mLayoutSuppressed = z;
                ViewGroupUtils.suppressLayout(viewGroup, z);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.mCanceled = true;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                hideViewWhenNotCanceled();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat
        public void onAnimationPause(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) && !this.mCanceled) {
                ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat
        public void onAnimationResume(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, animator) == null) && !this.mCanceled) {
                ViewUtils.setTransitionVisibility(this.mView, 0);
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, transition) == null) {
                hideViewWhenNotCanceled();
                transition.removeListener(this);
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, transition) == null) {
                suppressLayout(false);
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, transition) == null) {
                suppressLayout(true);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class VisibilityInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup mEndParent;
        public int mEndVisibility;
        public boolean mFadeIn;
        public ViewGroup mStartParent;
        public int mStartVisibility;
        public boolean mVisibilityChange;

        public VisibilityInfo() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1746846889, "Landroidx/transition/Visibility;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1746846889, "Landroidx/transition/Visibility;");
                return;
            }
        }
        sTransitionProperties = new String[]{PROPNAME_VISIBILITY, PROPNAME_PARENT};
    }

    public Visibility() {
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
        this.mMode = 3;
    }

    public int getMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mMode;
        }
        return invokeV.intValue;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return sTransitionProperties;
        }
        return (String[]) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"RestrictedApi"})
    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mMode = 3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.VISIBILITY_TRANSITION);
        int namedInt = TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (namedInt != 0) {
            setMode(namedInt);
        }
    }

    private void captureValues(TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, transitionValues) == null) {
            transitionValues.values.put(PROPNAME_VISIBILITY, Integer.valueOf(transitionValues.f1051view.getVisibility()));
            transitionValues.values.put(PROPNAME_PARENT, transitionValues.f1051view.getParent());
            int[] iArr = new int[2];
            transitionValues.f1051view.getLocationOnScreen(iArr);
            transitionValues.values.put(PROPNAME_SCREEN_LOCATION, iArr);
        }
    }

    public boolean isVisible(TransitionValues transitionValues) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, transitionValues)) == null) {
            if (transitionValues == null) {
                return false;
            }
            int intValue = ((Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue();
            View view2 = (View) transitionValues.values.get(PROPNAME_PARENT);
            if (intValue != 0 || view2 == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private VisibilityInfo getVisibilityChangeInfo(TransitionValues transitionValues, TransitionValues transitionValues2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, transitionValues, transitionValues2)) == null) {
            VisibilityInfo visibilityInfo = new VisibilityInfo();
            visibilityInfo.mVisibilityChange = false;
            visibilityInfo.mFadeIn = false;
            if (transitionValues != null && transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
                visibilityInfo.mStartVisibility = ((Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue();
                visibilityInfo.mStartParent = (ViewGroup) transitionValues.values.get(PROPNAME_PARENT);
            } else {
                visibilityInfo.mStartVisibility = -1;
                visibilityInfo.mStartParent = null;
            }
            if (transitionValues2 != null && transitionValues2.values.containsKey(PROPNAME_VISIBILITY)) {
                visibilityInfo.mEndVisibility = ((Integer) transitionValues2.values.get(PROPNAME_VISIBILITY)).intValue();
                visibilityInfo.mEndParent = (ViewGroup) transitionValues2.values.get(PROPNAME_PARENT);
            } else {
                visibilityInfo.mEndVisibility = -1;
                visibilityInfo.mEndParent = null;
            }
            if (transitionValues != null && transitionValues2 != null) {
                if (visibilityInfo.mStartVisibility == visibilityInfo.mEndVisibility && visibilityInfo.mStartParent == visibilityInfo.mEndParent) {
                    return visibilityInfo;
                }
                int i = visibilityInfo.mStartVisibility;
                int i2 = visibilityInfo.mEndVisibility;
                if (i != i2) {
                    if (i == 0) {
                        visibilityInfo.mFadeIn = false;
                        visibilityInfo.mVisibilityChange = true;
                    } else if (i2 == 0) {
                        visibilityInfo.mFadeIn = true;
                        visibilityInfo.mVisibilityChange = true;
                    }
                } else if (visibilityInfo.mEndParent == null) {
                    visibilityInfo.mFadeIn = false;
                    visibilityInfo.mVisibilityChange = true;
                } else if (visibilityInfo.mStartParent == null) {
                    visibilityInfo.mFadeIn = true;
                    visibilityInfo.mVisibilityChange = true;
                }
            } else if (transitionValues == null && visibilityInfo.mEndVisibility == 0) {
                visibilityInfo.mFadeIn = true;
                visibilityInfo.mVisibilityChange = true;
            } else if (transitionValues2 == null && visibilityInfo.mStartVisibility == 0) {
                visibilityInfo.mFadeIn = false;
                visibilityInfo.mVisibilityChange = true;
            }
            return visibilityInfo;
        }
        return (VisibilityInfo) invokeLL.objValue;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, transitionValues) == null) {
            captureValues(transitionValues);
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transitionValues) == null) {
            captureValues(transitionValues);
        }
    }

    public void setMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if ((i & (-4)) == 0) {
                this.mMode = i;
                return;
            }
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, transitionValues, transitionValues2)) == null) {
            VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
            if (visibilityChangeInfo.mVisibilityChange) {
                if (visibilityChangeInfo.mStartParent != null || visibilityChangeInfo.mEndParent != null) {
                    if (visibilityChangeInfo.mFadeIn) {
                        return onAppear(viewGroup, transitionValues, visibilityChangeInfo.mStartVisibility, transitionValues2, visibilityChangeInfo.mEndVisibility);
                    }
                    return onDisappear(viewGroup, transitionValues, visibilityChangeInfo.mStartVisibility, transitionValues2, visibilityChangeInfo.mEndVisibility);
                }
                return null;
            }
            return null;
        }
        return (Animator) invokeLLL.objValue;
    }

    @Override // androidx.transition.Transition
    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, transitionValues, transitionValues2)) == null) {
            if (transitionValues == null && transitionValues2 == null) {
                return false;
            }
            if (transitionValues != null && transitionValues2 != null && transitionValues2.values.containsKey(PROPNAME_VISIBILITY) != transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
                return false;
            }
            VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
            if (!visibilityChangeInfo.mVisibilityChange) {
                return false;
            }
            if (visibilityChangeInfo.mStartVisibility != 0 && visibilityChangeInfo.mEndVisibility != 0) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{viewGroup, transitionValues, Integer.valueOf(i), transitionValues2, Integer.valueOf(i2)})) == null) {
            if ((this.mMode & 1) != 1 || transitionValues2 == null) {
                return null;
            }
            if (transitionValues == null) {
                View view2 = (View) transitionValues2.f1051view.getParent();
                if (getVisibilityChangeInfo(getMatchedTransitionValues(view2, false), getTransitionValues(view2, false)).mVisibilityChange) {
                    return null;
                }
            }
            return onAppear(viewGroup, transitionValues2.f1051view, transitionValues, transitionValues2);
        }
        return (Animator) invokeCommon.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
        if (r17.mCanRemoveViews != false) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Animator onDisappear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        InterceptResult invokeCommon;
        View view2;
        View view3;
        boolean z;
        boolean z2;
        View view4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{viewGroup, transitionValues, Integer.valueOf(i), transitionValues2, Integer.valueOf(i2)})) == null) {
            if ((this.mMode & 2) != 2 || transitionValues == null) {
                return null;
            }
            View view5 = transitionValues.f1051view;
            if (transitionValues2 != null) {
                view2 = transitionValues2.f1051view;
            } else {
                view2 = null;
            }
            View view6 = (View) view5.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f091ee7);
            if (view6 != null) {
                view4 = null;
                z2 = true;
            } else if (view2 != null && view2.getParent() != null) {
                if (i2 == 4 || view5 == view2) {
                    view3 = view2;
                    z = false;
                    view2 = null;
                    if (z) {
                    }
                    z2 = false;
                    View view7 = view3;
                    view6 = view2;
                    view4 = view7;
                }
                view2 = null;
                view3 = null;
                z = true;
                if (z) {
                }
                z2 = false;
                View view72 = view3;
                view6 = view2;
                view4 = view72;
            } else {
                if (view2 != null) {
                    view3 = null;
                    z = false;
                    if (z) {
                        if (view5.getParent() != null) {
                            if (view5.getParent() instanceof View) {
                                View view8 = (View) view5.getParent();
                                if (!getVisibilityChangeInfo(getTransitionValues(view8, true), getMatchedTransitionValues(view8, true)).mVisibilityChange) {
                                    view2 = TransitionUtils.copyViewImage(viewGroup, view5, view8);
                                } else {
                                    int id = view8.getId();
                                    if (view8.getParent() == null) {
                                        if (id != -1) {
                                            if (viewGroup.findViewById(id) != null) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        view4 = view3;
                        z2 = false;
                        view6 = view5;
                    }
                    z2 = false;
                    View view722 = view3;
                    view6 = view2;
                    view4 = view722;
                }
                view2 = null;
                view3 = null;
                z = true;
                if (z) {
                }
                z2 = false;
                View view7222 = view3;
                view6 = view2;
                view4 = view7222;
            }
            if (view6 != null) {
                if (!z2) {
                    int[] iArr = (int[]) transitionValues.values.get(PROPNAME_SCREEN_LOCATION);
                    int i3 = iArr[0];
                    int i4 = iArr[1];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr2);
                    view6.offsetLeftAndRight((i3 - iArr2[0]) - view6.getLeft());
                    view6.offsetTopAndBottom((i4 - iArr2[1]) - view6.getTop());
                    ViewGroupUtils.getOverlay(viewGroup).add(view6);
                }
                Animator onDisappear = onDisappear(viewGroup, view6, transitionValues, transitionValues2);
                if (!z2) {
                    if (onDisappear == null) {
                        ViewGroupUtils.getOverlay(viewGroup).remove(view6);
                    } else {
                        view5.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f091ee7, view6);
                        addListener(new TransitionListenerAdapter(this, viewGroup, view6, view5) { // from class: androidx.transition.Visibility.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Visibility this$0;
                            public final /* synthetic */ View val$finalOverlayView;
                            public final /* synthetic */ ViewGroup val$overlayHost;
                            public final /* synthetic */ View val$startView;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, viewGroup, view6, view5};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i5 = newInitContext.flag;
                                    if ((i5 & 1) != 0) {
                                        int i6 = i5 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$overlayHost = viewGroup;
                                this.val$finalOverlayView = view6;
                                this.val$startView = view5;
                            }

                            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                            public void onTransitionEnd(@NonNull Transition transition) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, transition) == null) {
                                    this.val$startView.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f091ee7, null);
                                    ViewGroupUtils.getOverlay(this.val$overlayHost).remove(this.val$finalOverlayView);
                                    transition.removeListener(this);
                                }
                            }

                            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                            public void onTransitionPause(@NonNull Transition transition) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transition) == null) {
                                    ViewGroupUtils.getOverlay(this.val$overlayHost).remove(this.val$finalOverlayView);
                                }
                            }

                            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                            public void onTransitionResume(@NonNull Transition transition) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, transition) == null) {
                                    if (this.val$finalOverlayView.getParent() == null) {
                                        ViewGroupUtils.getOverlay(this.val$overlayHost).add(this.val$finalOverlayView);
                                    } else {
                                        this.this$0.cancel();
                                    }
                                }
                            }
                        });
                    }
                }
                return onDisappear;
            } else if (view4 == null) {
                return null;
            } else {
                int visibility = view4.getVisibility();
                ViewUtils.setTransitionVisibility(view4, 0);
                Animator onDisappear2 = onDisappear(viewGroup, view4, transitionValues, transitionValues2);
                if (onDisappear2 != null) {
                    DisappearListener disappearListener = new DisappearListener(view4, i2, true);
                    onDisappear2.addListener(disappearListener);
                    AnimatorUtils.addPauseListener(onDisappear2, disappearListener);
                    addListener(disappearListener);
                } else {
                    ViewUtils.setTransitionVisibility(view4, visibility);
                }
                return onDisappear2;
            }
        }
        return (Animator) invokeCommon.objValue;
    }
}

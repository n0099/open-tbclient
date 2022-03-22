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

        public DisappearListener(View view, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, Integer.valueOf(i), Boolean.valueOf(z)};
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
            this.mView = view;
            this.mFinalVisibility = i;
            this.mParent = (ViewGroup) view.getParent();
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
            if (!(interceptable == null || interceptable.invokeZ(65538, this, z) == null) || !this.mSuppressLayout || this.mLayoutSuppressed == z || (viewGroup = this.mParent) == null) {
                return;
            }
            this.mLayoutSuppressed = z;
            ViewGroupUtils.suppressLayout(viewGroup, z);
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) || this.mCanceled) {
                return;
            }
            ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat
        public void onAnimationResume(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, animator) == null) || this.mCanceled) {
                return;
            }
            ViewUtils.setTransitionVisibility(this.mView, 0);
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

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, transition) == null) {
            }
        }
    }

    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface Mode {
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

    private void captureValues(TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, transitionValues) == null) {
            transitionValues.values.put(PROPNAME_VISIBILITY, Integer.valueOf(transitionValues.view.getVisibility()));
            transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
            int[] iArr = new int[2];
            transitionValues.view.getLocationOnScreen(iArr);
            transitionValues.values.put(PROPNAME_SCREEN_LOCATION, iArr);
        }
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

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, transitionValues, transitionValues2)) == null) {
            VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
            if (visibilityChangeInfo.mVisibilityChange) {
                if (visibilityChangeInfo.mStartParent == null && visibilityChangeInfo.mEndParent == null) {
                    return null;
                }
                if (visibilityChangeInfo.mFadeIn) {
                    return onAppear(viewGroup, transitionValues, visibilityChangeInfo.mStartVisibility, transitionValues2, visibilityChangeInfo.mEndVisibility);
                }
                return onDisappear(viewGroup, transitionValues, visibilityChangeInfo.mStartVisibility, transitionValues2, visibilityChangeInfo.mEndVisibility);
            }
            return null;
        }
        return (Animator) invokeLLL.objValue;
    }

    public int getMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mMode : invokeV.intValue;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? sTransitionProperties : (String[]) invokeV.objValue;
    }

    @Override // androidx.transition.Transition
    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, transitionValues, transitionValues2)) == null) {
            if (transitionValues == null && transitionValues2 == null) {
                return false;
            }
            if (transitionValues == null || transitionValues2 == null || transitionValues2.values.containsKey(PROPNAME_VISIBILITY) == transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
                VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
                if (visibilityChangeInfo.mVisibilityChange) {
                    return visibilityChangeInfo.mStartVisibility == 0 || visibilityChangeInfo.mEndVisibility == 0;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean isVisible(TransitionValues transitionValues) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, transitionValues)) == null) {
            if (transitionValues == null) {
                return false;
            }
            return ((Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue() == 0 && ((View) transitionValues.values.get(PROPNAME_PARENT)) != null;
        }
        return invokeL.booleanValue;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, viewGroup, view, transitionValues, transitionValues2)) == null) {
            return null;
        }
        return (Animator) invokeLLLL.objValue;
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{viewGroup, transitionValues, Integer.valueOf(i), transitionValues2, Integer.valueOf(i2)})) == null) {
            if ((this.mMode & 1) != 1 || transitionValues2 == null) {
                return null;
            }
            if (transitionValues == null) {
                View view = (View) transitionValues2.view.getParent();
                if (getVisibilityChangeInfo(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).mVisibilityChange) {
                    return null;
                }
            }
            return onAppear(viewGroup, transitionValues2.view, transitionValues, transitionValues2);
        }
        return (Animator) invokeCommon.objValue;
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, viewGroup, view, transitionValues, transitionValues2)) == null) {
            return null;
        }
        return (Animator) invokeLLLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
        if (r10.mCanRemoveViews != false) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Animator onDisappear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        InterceptResult invokeCommon;
        View view;
        boolean z;
        boolean z2;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{viewGroup, transitionValues, Integer.valueOf(i), transitionValues2, Integer.valueOf(i2)})) == null) {
            if ((this.mMode & 2) == 2 && transitionValues != null) {
                View view3 = transitionValues.view;
                View view4 = transitionValues2 != null ? transitionValues2.view : null;
                View view5 = (View) view3.getTag(R$id.save_overlay_view);
                if (view5 != null) {
                    view2 = null;
                    z2 = true;
                } else if (view4 == null || view4.getParent() == null) {
                    if (view4 != null) {
                        view = null;
                        z = false;
                        if (z) {
                            if (view3.getParent() != null) {
                                if (view3.getParent() instanceof View) {
                                    View view6 = (View) view3.getParent();
                                    if (!getVisibilityChangeInfo(getTransitionValues(view6, true), getMatchedTransitionValues(view6, true)).mVisibilityChange) {
                                        view4 = TransitionUtils.copyViewImage(viewGroup, view3, view6);
                                    } else {
                                        int id = view6.getId();
                                        if (view6.getParent() == null) {
                                            if (id != -1) {
                                                if (viewGroup.findViewById(id) != null) {
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            view2 = view;
                            z2 = false;
                            view5 = view3;
                        }
                        z2 = false;
                        View view7 = view;
                        view5 = view4;
                        view2 = view7;
                    }
                    view4 = null;
                    view = null;
                    z = true;
                    if (z) {
                    }
                    z2 = false;
                    View view72 = view;
                    view5 = view4;
                    view2 = view72;
                } else {
                    if (i2 == 4 || view3 == view4) {
                        view = view4;
                        z = false;
                        view4 = null;
                        if (z) {
                        }
                        z2 = false;
                        View view722 = view;
                        view5 = view4;
                        view2 = view722;
                    }
                    view4 = null;
                    view = null;
                    z = true;
                    if (z) {
                    }
                    z2 = false;
                    View view7222 = view;
                    view5 = view4;
                    view2 = view7222;
                }
                if (view5 == null) {
                    if (view2 != null) {
                        int visibility = view2.getVisibility();
                        ViewUtils.setTransitionVisibility(view2, 0);
                        Animator onDisappear = onDisappear(viewGroup, view2, transitionValues, transitionValues2);
                        if (onDisappear != null) {
                            DisappearListener disappearListener = new DisappearListener(view2, i2, true);
                            onDisappear.addListener(disappearListener);
                            AnimatorUtils.addPauseListener(onDisappear, disappearListener);
                            addListener(disappearListener);
                        } else {
                            ViewUtils.setTransitionVisibility(view2, visibility);
                        }
                        return onDisappear;
                    }
                    return null;
                }
                if (!z2) {
                    int[] iArr = (int[]) transitionValues.values.get(PROPNAME_SCREEN_LOCATION);
                    int i3 = iArr[0];
                    int i4 = iArr[1];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr2);
                    view5.offsetLeftAndRight((i3 - iArr2[0]) - view5.getLeft());
                    view5.offsetTopAndBottom((i4 - iArr2[1]) - view5.getTop());
                    ViewGroupUtils.getOverlay(viewGroup).add(view5);
                }
                Animator onDisappear2 = onDisappear(viewGroup, view5, transitionValues, transitionValues2);
                if (!z2) {
                    if (onDisappear2 == null) {
                        ViewGroupUtils.getOverlay(viewGroup).remove(view5);
                    } else {
                        view3.setTag(R$id.save_overlay_view, view5);
                        addListener(new TransitionListenerAdapter(this, viewGroup, view5, view3) { // from class: androidx.transition.Visibility.1
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
                                    Object[] objArr = {this, viewGroup, view5, view3};
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
                                this.val$finalOverlayView = view5;
                                this.val$startView = view3;
                            }

                            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                            public void onTransitionEnd(@NonNull Transition transition) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, transition) == null) {
                                    this.val$startView.setTag(R$id.save_overlay_view, null);
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
                return onDisappear2;
            }
            return null;
        }
        return (Animator) invokeCommon.objValue;
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
}

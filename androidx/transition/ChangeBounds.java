package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes.dex */
public class ChangeBounds extends Transition {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY;
    public static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY;
    public static final Property<Drawable, PointF> DRAWABLE_ORIGIN_PROPERTY;
    public static final Property<View, PointF> POSITION_PROPERTY;
    public static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    public static final String PROPNAME_CLIP = "android:changeBounds:clip";
    public static final String PROPNAME_PARENT = "android:changeBounds:parent";
    public static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    public static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    public static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY;
    public static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY;
    public static RectEvaluator sRectEvaluator;
    public static final String[] sTransitionProperties;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mReparent;
    public boolean mResizeClip;
    public int[] mTempLocation;

    /* loaded from: classes.dex */
    public static class ViewBounds {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mBottom;
        public int mBottomRightCalls;
        public int mLeft;
        public int mRight;
        public int mTop;
        public int mTopLeftCalls;
        public View mView;

        public ViewBounds(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mView = view2;
        }

        public void setBottomRight(PointF pointF) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pointF) == null) {
                this.mRight = Math.round(pointF.x);
                this.mBottom = Math.round(pointF.y);
                int i = this.mBottomRightCalls + 1;
                this.mBottomRightCalls = i;
                if (this.mTopLeftCalls == i) {
                    setLeftTopRightBottom();
                }
            }
        }

        public void setTopLeft(PointF pointF) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pointF) == null) {
                this.mLeft = Math.round(pointF.x);
                this.mTop = Math.round(pointF.y);
                int i = this.mTopLeftCalls + 1;
                this.mTopLeftCalls = i;
                if (i == this.mBottomRightCalls) {
                    setLeftTopRightBottom();
                }
            }
        }

        private void setLeftTopRightBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
                this.mTopLeftCalls = 0;
                this.mBottomRightCalls = 0;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(264393622, "Landroidx/transition/ChangeBounds;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(264393622, "Landroidx/transition/ChangeBounds;");
                return;
            }
        }
        sTransitionProperties = new String[]{PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
        DRAWABLE_ORIGIN_PROPERTY = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") { // from class: androidx.transition.ChangeBounds.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public Rect mBounds;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8, r9);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r8, r9};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((Class) objArr2[0], (String) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mBounds = new Rect();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public PointF get(Drawable drawable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, drawable)) == null) {
                    drawable.copyBounds(this.mBounds);
                    Rect rect = this.mBounds;
                    return new PointF(rect.left, rect.top);
                }
                return (PointF) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public void set(Drawable drawable, PointF pointF) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, drawable, pointF) == null) {
                    drawable.copyBounds(this.mBounds);
                    this.mBounds.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
                    drawable.setBounds(this.mBounds);
                }
            }
        };
        TOP_LEFT_PROPERTY = new Property<ViewBounds, PointF>(PointF.class, "topLeft") { // from class: androidx.transition.ChangeBounds.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public PointF get(ViewBounds viewBounds) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, viewBounds)) == null) {
                    return null;
                }
                return (PointF) invokeL.objValue;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8, r9);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r8, r9};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((Class) objArr2[0], (String) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public void set(ViewBounds viewBounds, PointF pointF) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewBounds, pointF) == null) {
                    viewBounds.setTopLeft(pointF);
                }
            }
        };
        BOTTOM_RIGHT_PROPERTY = new Property<ViewBounds, PointF>(PointF.class, "bottomRight") { // from class: androidx.transition.ChangeBounds.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public PointF get(ViewBounds viewBounds) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, viewBounds)) == null) {
                    return null;
                }
                return (PointF) invokeL.objValue;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8, r9);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r8, r9};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((Class) objArr2[0], (String) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public void set(ViewBounds viewBounds, PointF pointF) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewBounds, pointF) == null) {
                    viewBounds.setBottomRight(pointF);
                }
            }
        };
        BOTTOM_RIGHT_ONLY_PROPERTY = new Property<View, PointF>(PointF.class, "bottomRight") { // from class: androidx.transition.ChangeBounds.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public PointF get(View view2) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view2)) == null) {
                    return null;
                }
                return (PointF) invokeL.objValue;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8, r9);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r8, r9};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((Class) objArr2[0], (String) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public void set(View view2, PointF pointF) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, pointF) == null) {
                    ViewUtils.setLeftTopRightBottom(view2, view2.getLeft(), view2.getTop(), Math.round(pointF.x), Math.round(pointF.y));
                }
            }
        };
        TOP_LEFT_ONLY_PROPERTY = new Property<View, PointF>(PointF.class, "topLeft") { // from class: androidx.transition.ChangeBounds.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public PointF get(View view2) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view2)) == null) {
                    return null;
                }
                return (PointF) invokeL.objValue;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8, r9);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r8, r9};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((Class) objArr2[0], (String) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public void set(View view2, PointF pointF) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, pointF) == null) {
                    ViewUtils.setLeftTopRightBottom(view2, Math.round(pointF.x), Math.round(pointF.y), view2.getRight(), view2.getBottom());
                }
            }
        };
        POSITION_PROPERTY = new Property<View, PointF>(PointF.class, CriusAttrConstants.POSITION) { // from class: androidx.transition.ChangeBounds.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public PointF get(View view2) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view2)) == null) {
                    return null;
                }
                return (PointF) invokeL.objValue;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8, r9);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r8, r9};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((Class) objArr2[0], (String) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public void set(View view2, PointF pointF) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, pointF) == null) {
                    int round = Math.round(pointF.x);
                    int round2 = Math.round(pointF.y);
                    ViewUtils.setLeftTopRightBottom(view2, round, round2, view2.getWidth() + round, view2.getHeight() + round2);
                }
            }
        };
        sRectEvaluator = new RectEvaluator();
    }

    public ChangeBounds() {
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
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
    }

    public boolean getResizeClip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mResizeClip;
        }
        return invokeV.booleanValue;
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
    public ChangeBounds(Context context, AttributeSet attributeSet) {
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
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.CHANGE_BOUNDS);
        boolean namedBoolean = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        setResizeClip(namedBoolean);
    }

    private void captureValues(TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, transitionValues) == null) {
            View view2 = transitionValues.f1028view;
            if (ViewCompat.isLaidOut(view2) || view2.getWidth() != 0 || view2.getHeight() != 0) {
                transitionValues.values.put(PROPNAME_BOUNDS, new Rect(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom()));
                transitionValues.values.put(PROPNAME_PARENT, transitionValues.f1028view.getParent());
                if (this.mReparent) {
                    transitionValues.f1028view.getLocationInWindow(this.mTempLocation);
                    transitionValues.values.put(PROPNAME_WINDOW_X, Integer.valueOf(this.mTempLocation[0]));
                    transitionValues.values.put(PROPNAME_WINDOW_Y, Integer.valueOf(this.mTempLocation[1]));
                }
                if (this.mResizeClip) {
                    transitionValues.values.put(PROPNAME_CLIP, ViewCompat.getClipBounds(view2));
                }
            }
        }
    }

    private boolean parentMatches(View view2, View view3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, view2, view3)) == null) {
            if (!this.mReparent) {
                return true;
            }
            TransitionValues matchedTransitionValues = getMatchedTransitionValues(view2, true);
            if (matchedTransitionValues == null) {
                if (view2 == view3) {
                    return true;
                }
            } else if (view3 == matchedTransitionValues.f1028view) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
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

    public void setResizeClip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.mResizeClip = z;
        }
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        InterceptResult invokeLLL;
        int i;
        View view2;
        ObjectAnimator ofPointF;
        int i2;
        Rect rect;
        Rect rect2;
        ObjectAnimator objectAnimator;
        Animator mergeAnimators;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, transitionValues, transitionValues2)) == null) {
            if (transitionValues != null && transitionValues2 != null) {
                Map<String, Object> map = transitionValues.values;
                Map<String, Object> map2 = transitionValues2.values;
                ViewGroup viewGroup2 = (ViewGroup) map.get(PROPNAME_PARENT);
                ViewGroup viewGroup3 = (ViewGroup) map2.get(PROPNAME_PARENT);
                if (viewGroup2 != null && viewGroup3 != null) {
                    View view3 = transitionValues2.f1028view;
                    if (parentMatches(viewGroup2, viewGroup3)) {
                        Rect rect3 = (Rect) transitionValues.values.get(PROPNAME_BOUNDS);
                        Rect rect4 = (Rect) transitionValues2.values.get(PROPNAME_BOUNDS);
                        int i3 = rect3.left;
                        int i4 = rect4.left;
                        int i5 = rect3.top;
                        int i6 = rect4.top;
                        int i7 = rect3.right;
                        int i8 = rect4.right;
                        int i9 = rect3.bottom;
                        int i10 = rect4.bottom;
                        int i11 = i7 - i3;
                        int i12 = i9 - i5;
                        int i13 = i8 - i4;
                        int i14 = i10 - i6;
                        Rect rect5 = (Rect) transitionValues.values.get(PROPNAME_CLIP);
                        Rect rect6 = (Rect) transitionValues2.values.get(PROPNAME_CLIP);
                        if ((i11 != 0 && i12 != 0) || (i13 != 0 && i14 != 0)) {
                            if (i3 == i4 && i5 == i6) {
                                i = 0;
                            } else {
                                i = 1;
                            }
                            if (i7 != i8 || i9 != i10) {
                                i++;
                            }
                        } else {
                            i = 0;
                        }
                        if ((rect5 != null && !rect5.equals(rect6)) || (rect5 == null && rect6 != null)) {
                            i++;
                        }
                        if (i > 0) {
                            if (!this.mResizeClip) {
                                view2 = view3;
                                ViewUtils.setLeftTopRightBottom(view2, i3, i5, i7, i9);
                                if (i == 2) {
                                    if (i11 == i13 && i12 == i14) {
                                        mergeAnimators = ObjectAnimatorUtils.ofPointF(view2, POSITION_PROPERTY, getPathMotion().getPath(i3, i5, i4, i6));
                                    } else {
                                        ViewBounds viewBounds = new ViewBounds(view2);
                                        ObjectAnimator ofPointF2 = ObjectAnimatorUtils.ofPointF(viewBounds, TOP_LEFT_PROPERTY, getPathMotion().getPath(i3, i5, i4, i6));
                                        ObjectAnimator ofPointF3 = ObjectAnimatorUtils.ofPointF(viewBounds, BOTTOM_RIGHT_PROPERTY, getPathMotion().getPath(i7, i9, i8, i10));
                                        AnimatorSet animatorSet = new AnimatorSet();
                                        animatorSet.playTogether(ofPointF2, ofPointF3);
                                        animatorSet.addListener(new AnimatorListenerAdapter(this, viewBounds) { // from class: androidx.transition.ChangeBounds.7
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public ViewBounds mViewBounds;
                                            public final /* synthetic */ ChangeBounds this$0;
                                            public final /* synthetic */ ViewBounds val$viewBounds;

                                            {
                                                Interceptable interceptable2 = $ic;
                                                if (interceptable2 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this, viewBounds};
                                                    interceptable2.invokeUnInit(65536, newInitContext);
                                                    int i15 = newInitContext.flag;
                                                    if ((i15 & 1) != 0) {
                                                        int i16 = i15 & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable2.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.this$0 = this;
                                                this.val$viewBounds = viewBounds;
                                                this.mViewBounds = this.val$viewBounds;
                                            }
                                        });
                                        mergeAnimators = animatorSet;
                                    }
                                } else if (i3 == i4 && i5 == i6) {
                                    mergeAnimators = ObjectAnimatorUtils.ofPointF(view2, BOTTOM_RIGHT_ONLY_PROPERTY, getPathMotion().getPath(i7, i9, i8, i10));
                                } else {
                                    mergeAnimators = ObjectAnimatorUtils.ofPointF(view2, TOP_LEFT_ONLY_PROPERTY, getPathMotion().getPath(i3, i5, i4, i6));
                                }
                            } else {
                                view2 = view3;
                                ViewUtils.setLeftTopRightBottom(view2, i3, i5, Math.max(i11, i13) + i3, Math.max(i12, i14) + i5);
                                if (i3 == i4 && i5 == i6) {
                                    ofPointF = null;
                                } else {
                                    ofPointF = ObjectAnimatorUtils.ofPointF(view2, POSITION_PROPERTY, getPathMotion().getPath(i3, i5, i4, i6));
                                }
                                if (rect5 == null) {
                                    i2 = 0;
                                    rect = new Rect(0, 0, i11, i12);
                                } else {
                                    i2 = 0;
                                    rect = rect5;
                                }
                                if (rect6 == null) {
                                    rect2 = new Rect(i2, i2, i13, i14);
                                } else {
                                    rect2 = rect6;
                                }
                                if (!rect.equals(rect2)) {
                                    ViewCompat.setClipBounds(view2, rect);
                                    RectEvaluator rectEvaluator = sRectEvaluator;
                                    Object[] objArr = new Object[2];
                                    objArr[i2] = rect;
                                    objArr[1] = rect2;
                                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view2, "clipBounds", rectEvaluator, objArr);
                                    ofObject.addListener(new AnimatorListenerAdapter(this, view2, rect6, i4, i6, i8, i10) { // from class: androidx.transition.ChangeBounds.8
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public boolean mIsCanceled;
                                        public final /* synthetic */ ChangeBounds this$0;
                                        public final /* synthetic */ int val$endBottom;
                                        public final /* synthetic */ int val$endLeft;
                                        public final /* synthetic */ int val$endRight;
                                        public final /* synthetic */ int val$endTop;
                                        public final /* synthetic */ Rect val$finalClip;
                                        public final /* synthetic */ View val$view;

                                        {
                                            Interceptable interceptable2 = $ic;
                                            if (interceptable2 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr2 = {this, view2, rect6, Integer.valueOf(i4), Integer.valueOf(i6), Integer.valueOf(i8), Integer.valueOf(i10)};
                                                interceptable2.invokeUnInit(65536, newInitContext);
                                                int i15 = newInitContext.flag;
                                                if ((i15 & 1) != 0) {
                                                    int i16 = i15 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable2.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$0 = this;
                                            this.val$view = view2;
                                            this.val$finalClip = rect6;
                                            this.val$endLeft = i4;
                                            this.val$endTop = i6;
                                            this.val$endRight = i8;
                                            this.val$endBottom = i10;
                                        }

                                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                        public void onAnimationCancel(Animator animator) {
                                            Interceptable interceptable2 = $ic;
                                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                                                this.mIsCanceled = true;
                                            }
                                        }

                                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                        public void onAnimationEnd(Animator animator) {
                                            Interceptable interceptable2 = $ic;
                                            if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) && !this.mIsCanceled) {
                                                ViewCompat.setClipBounds(this.val$view, this.val$finalClip);
                                                ViewUtils.setLeftTopRightBottom(this.val$view, this.val$endLeft, this.val$endTop, this.val$endRight, this.val$endBottom);
                                            }
                                        }
                                    });
                                    objectAnimator = ofObject;
                                } else {
                                    objectAnimator = null;
                                }
                                mergeAnimators = TransitionUtils.mergeAnimators(ofPointF, objectAnimator);
                            }
                            if (view2.getParent() instanceof ViewGroup) {
                                ViewGroup viewGroup4 = (ViewGroup) view2.getParent();
                                ViewGroupUtils.suppressLayout(viewGroup4, true);
                                addListener(new TransitionListenerAdapter(this, viewGroup4) { // from class: androidx.transition.ChangeBounds.9
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public boolean mCanceled;
                                    public final /* synthetic */ ChangeBounds this$0;
                                    public final /* synthetic */ ViewGroup val$parent;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr2 = {this, viewGroup4};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i15 = newInitContext.flag;
                                            if ((i15 & 1) != 0) {
                                                int i16 = i15 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$0 = this;
                                        this.val$parent = viewGroup4;
                                        this.mCanceled = false;
                                    }

                                    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                                    public void onTransitionCancel(@NonNull Transition transition) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, transition) == null) {
                                            ViewGroupUtils.suppressLayout(this.val$parent, false);
                                            this.mCanceled = true;
                                        }
                                    }

                                    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                                    public void onTransitionEnd(@NonNull Transition transition) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transition) == null) {
                                            if (!this.mCanceled) {
                                                ViewGroupUtils.suppressLayout(this.val$parent, false);
                                            }
                                            transition.removeListener(this);
                                        }
                                    }

                                    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                                    public void onTransitionPause(@NonNull Transition transition) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, transition) == null) {
                                            ViewGroupUtils.suppressLayout(this.val$parent, false);
                                        }
                                    }

                                    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                                    public void onTransitionResume(@NonNull Transition transition) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048579, this, transition) == null) {
                                            ViewGroupUtils.suppressLayout(this.val$parent, true);
                                        }
                                    }
                                });
                            }
                            return mergeAnimators;
                        }
                        return null;
                    }
                    int intValue = ((Integer) transitionValues.values.get(PROPNAME_WINDOW_X)).intValue();
                    int intValue2 = ((Integer) transitionValues.values.get(PROPNAME_WINDOW_Y)).intValue();
                    int intValue3 = ((Integer) transitionValues2.values.get(PROPNAME_WINDOW_X)).intValue();
                    int intValue4 = ((Integer) transitionValues2.values.get(PROPNAME_WINDOW_Y)).intValue();
                    if (intValue == intValue3 && intValue2 == intValue4) {
                        return null;
                    }
                    viewGroup.getLocationInWindow(this.mTempLocation);
                    Bitmap createBitmap = Bitmap.createBitmap(view3.getWidth(), view3.getHeight(), Bitmap.Config.ARGB_8888);
                    view3.draw(new Canvas(createBitmap));
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
                    float transitionAlpha = ViewUtils.getTransitionAlpha(view3);
                    ViewUtils.setTransitionAlpha(view3, 0.0f);
                    ViewUtils.getOverlay(viewGroup).add(bitmapDrawable);
                    PathMotion pathMotion = getPathMotion();
                    int[] iArr = this.mTempLocation;
                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, PropertyValuesHolderUtils.ofPointF(DRAWABLE_ORIGIN_PROPERTY, pathMotion.getPath(intValue - iArr[0], intValue2 - iArr[1], intValue3 - iArr[0], intValue4 - iArr[1])));
                    ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter(this, viewGroup, bitmapDrawable, view3, transitionAlpha) { // from class: androidx.transition.ChangeBounds.10
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ChangeBounds this$0;
                        public final /* synthetic */ BitmapDrawable val$drawable;
                        public final /* synthetic */ ViewGroup val$sceneRoot;
                        public final /* synthetic */ float val$transitionAlpha;
                        public final /* synthetic */ View val$view;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr2 = {this, viewGroup, bitmapDrawable, view3, Float.valueOf(transitionAlpha)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i15 = newInitContext.flag;
                                if ((i15 & 1) != 0) {
                                    int i16 = i15 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$sceneRoot = viewGroup;
                            this.val$drawable = bitmapDrawable;
                            this.val$view = view3;
                            this.val$transitionAlpha = transitionAlpha;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                                ViewUtils.getOverlay(this.val$sceneRoot).remove(this.val$drawable);
                                ViewUtils.setTransitionAlpha(this.val$view, this.val$transitionAlpha);
                            }
                        }
                    });
                    return ofPropertyValuesHolder;
                }
                return null;
            }
            return null;
        }
        return (Animator) invokeLLL.objValue;
    }
}

package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable2Compat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ANIMATED_VECTOR = "animated-vector";
    public static final boolean DBG_ANIMATION_VECTOR_DRAWABLE = false;
    public static final String LOGTAG = "AnimatedVDCompat";
    public static final String TARGET = "target";
    public transient /* synthetic */ FieldHolder $fh;
    public AnimatedVectorDrawableCompatState mAnimatedVectorState;
    public ArrayList<Animatable2Compat.AnimationCallback> mAnimationCallbacks;
    public Animator.AnimatorListener mAnimatorListener;
    public android.animation.ArgbEvaluator mArgbEvaluator;
    public AnimatedVectorDrawableDelegateState mCachedConstantStateDelegate;
    public final Drawable.Callback mCallback;
    public Context mContext;

    /* loaded from: classes.dex */
    public static class AnimatedVectorDrawableCompatState extends Drawable.ConstantState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AnimatorSet mAnimatorSet;
        public ArrayList<Animator> mAnimators;
        public int mChangingConfigurations;
        public ArrayMap<Animator, String> mTargetNameMap;
        public VectorDrawableCompat mVectorDrawable;

        public AnimatedVectorDrawableCompatState(Context context, AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Drawable.Callback callback, Resources resources) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, animatedVectorDrawableCompatState, callback, resources};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (animatedVectorDrawableCompatState != null) {
                this.mChangingConfigurations = animatedVectorDrawableCompatState.mChangingConfigurations;
                VectorDrawableCompat vectorDrawableCompat = animatedVectorDrawableCompatState.mVectorDrawable;
                if (vectorDrawableCompat != null) {
                    Drawable.ConstantState constantState = vectorDrawableCompat.getConstantState();
                    if (resources != null) {
                        this.mVectorDrawable = (VectorDrawableCompat) constantState.newDrawable(resources);
                    } else {
                        this.mVectorDrawable = (VectorDrawableCompat) constantState.newDrawable();
                    }
                    VectorDrawableCompat vectorDrawableCompat2 = (VectorDrawableCompat) this.mVectorDrawable.mutate();
                    this.mVectorDrawable = vectorDrawableCompat2;
                    vectorDrawableCompat2.setCallback(callback);
                    this.mVectorDrawable.setBounds(animatedVectorDrawableCompatState.mVectorDrawable.getBounds());
                    this.mVectorDrawable.setAllowCaching(false);
                }
                ArrayList<Animator> arrayList = animatedVectorDrawableCompatState.mAnimators;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.mAnimators = new ArrayList<>(size);
                    this.mTargetNameMap = new ArrayMap<>(size);
                    for (int i3 = 0; i3 < size; i3++) {
                        Animator animator = animatedVectorDrawableCompatState.mAnimators.get(i3);
                        Animator clone = animator.clone();
                        String str = animatedVectorDrawableCompatState.mTargetNameMap.get(animator);
                        clone.setTarget(this.mVectorDrawable.getTargetByName(str));
                        this.mAnimators.add(clone);
                        this.mTargetNameMap.put(clone, str);
                    }
                    setupAnimatorSet();
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mChangingConfigurations : invokeV.intValue;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                throw new IllegalStateException("No constant state support for SDK < 24.");
            }
            return (Drawable) invokeV.objValue;
        }

        public void setupAnimatorSet() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.mAnimatorSet == null) {
                    this.mAnimatorSet = new AnimatorSet();
                }
                this.mAnimatorSet.playTogether(this.mAnimators);
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resources)) == null) {
                throw new IllegalStateException("No constant state support for SDK < 24.");
            }
            return (Drawable) invokeL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnimatedVectorDrawableCompat() {
        this(null, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((Context) objArr[0], (AnimatedVectorDrawableCompatState) objArr[1], (Resources) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Nullable
    public static AnimatedVectorDrawableCompat create(@NonNull Context context, @DrawableRes int i) {
        InterceptResult invokeLI;
        int next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
                Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), i, context.getTheme());
                animatedVectorDrawableCompat.mDelegateDrawable = drawable;
                drawable.setCallback(animatedVectorDrawableCompat.mCallback);
                animatedVectorDrawableCompat.mCachedConstantStateDelegate = new AnimatedVectorDrawableDelegateState(animatedVectorDrawableCompat.mDelegateDrawable.getConstantState());
                return animatedVectorDrawableCompat;
            }
            try {
                XmlResourceParser xml = context.getResources().getXml(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                }
                if (next == 2) {
                    return createFromXmlInner(context, context.getResources(), xml, asAttributeSet, context.getTheme());
                }
                throw new XmlPullParserException("No start tag found");
            } catch (IOException e) {
                Log.e(LOGTAG, "parser error", e);
                return null;
            } catch (XmlPullParserException e2) {
                Log.e(LOGTAG, "parser error", e2);
                return null;
            }
        }
        return (AnimatedVectorDrawableCompat) invokeLI.objValue;
    }

    public static AnimatedVectorDrawableCompat createFromXmlInner(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65541, null, context, resources, xmlPullParser, attributeSet, theme)) == null) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
            animatedVectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
            return animatedVectorDrawableCompat;
        }
        return (AnimatedVectorDrawableCompat) invokeLLLLL.objValue;
    }

    @RequiresApi(23)
    public static void registerPlatformCallback(@NonNull AnimatedVectorDrawable animatedVectorDrawable, @NonNull Animatable2Compat.AnimationCallback animationCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, animatedVectorDrawable, animationCallback) == null) {
            animatedVectorDrawable.registerAnimationCallback(animationCallback.getPlatformCallback());
        }
    }

    private void removeAnimatorSetListener() {
        Animator.AnimatorListener animatorListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (animatorListener = this.mAnimatorListener) == null) {
            return;
        }
        this.mAnimatedVectorState.mAnimatorSet.removeListener(animatorListener);
        this.mAnimatorListener = null;
    }

    private void setupAnimatorsForTarget(String str, Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, str, animator) == null) {
            animator.setTarget(this.mAnimatedVectorState.mVectorDrawable.getTargetByName(str));
            if (Build.VERSION.SDK_INT < 21) {
                setupColorAnimator(animator);
            }
            AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState = this.mAnimatedVectorState;
            if (animatedVectorDrawableCompatState.mAnimators == null) {
                animatedVectorDrawableCompatState.mAnimators = new ArrayList<>();
                this.mAnimatedVectorState.mTargetNameMap = new ArrayMap<>();
            }
            this.mAnimatedVectorState.mAnimators.add(animator);
            this.mAnimatedVectorState.mTargetNameMap.put(animator, str);
        }
    }

    private void setupColorAnimator(Animator animator) {
        ArrayList<Animator> childAnimations;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, animator) == null) {
            if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    setupColorAnimator(childAnimations.get(i));
                }
            }
            if (animator instanceof ObjectAnimator) {
                ObjectAnimator objectAnimator = (ObjectAnimator) animator;
                String propertyName = objectAnimator.getPropertyName();
                if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                    if (this.mArgbEvaluator == null) {
                        this.mArgbEvaluator = new android.animation.ArgbEvaluator();
                    }
                    objectAnimator.setEvaluator(this.mArgbEvaluator);
                }
            }
        }
    }

    @RequiresApi(23)
    public static boolean unregisterPlatformCallback(AnimatedVectorDrawable animatedVectorDrawable, Animatable2Compat.AnimationCallback animationCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, animatedVectorDrawable, animationCallback)) == null) ? animatedVectorDrawable.unregisterAnimationCallback(animationCallback.getPlatformCallback()) : invokeLL.booleanValue;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, theme) == null) || (drawable = this.mDelegateDrawable) == null) {
            return;
        }
        DrawableCompat.applyTheme(drawable, theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return DrawableCompat.canApplyTheme(drawable);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                ((AnimatedVectorDrawable) drawable).clearAnimationCallbacks();
                return;
            }
            removeAnimatorSetListener();
            ArrayList<Animatable2Compat.AnimationCallback> arrayList = this.mAnimationCallbacks;
            if (arrayList == null) {
                return;
            }
            arrayList.clear();
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            this.mAnimatedVectorState.mVectorDrawable.draw(canvas);
            if (this.mAnimatedVectorState.mAnimatorSet.isStarted()) {
                invalidateSelf();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return DrawableCompat.getAlpha(drawable);
            }
            return this.mAnimatedVectorState.mVectorDrawable.getAlpha();
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.getChangingConfigurations();
            }
            return super.getChangingConfigurations() | this.mAnimatedVectorState.mChangingConfigurations;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return DrawableCompat.getColorFilter(drawable);
            }
            return this.mAnimatedVectorState.mVectorDrawable.getColorFilter();
        }
        return (ColorFilter) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.mDelegateDrawable == null || Build.VERSION.SDK_INT < 24) {
                return null;
            }
            return new AnimatedVectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
        }
        return (Drawable.ConstantState) invokeV.objValue;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.getIntrinsicHeight();
            }
            return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.getIntrinsicWidth();
            }
            return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
        }
        return invokeV.intValue;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.getOpacity();
            }
            return this.mAnimatedVectorState.mVectorDrawable.getOpacity();
        }
        return invokeV.intValue;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048595, this, resources, xmlPullParser, attributeSet, theme) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                DrawableCompat.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
                return;
            }
            int eventType = xmlPullParser.getEventType();
            int depth = xmlPullParser.getDepth() + 1;
            while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (ANIMATED_VECTOR.equals(name)) {
                        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE);
                        int resourceId = obtainAttributes.getResourceId(0, 0);
                        if (resourceId != 0) {
                            VectorDrawableCompat create = VectorDrawableCompat.create(resources, resourceId, theme);
                            create.setAllowCaching(false);
                            create.setCallback(this.mCallback);
                            VectorDrawableCompat vectorDrawableCompat = this.mAnimatedVectorState.mVectorDrawable;
                            if (vectorDrawableCompat != null) {
                                vectorDrawableCompat.setCallback(null);
                            }
                            this.mAnimatedVectorState.mVectorDrawable = create;
                        }
                        obtainAttributes.recycle();
                    } else if ("target".equals(name)) {
                        TypedArray obtainAttributes2 = resources.obtainAttributes(attributeSet, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE_TARGET);
                        String string = obtainAttributes2.getString(0);
                        int resourceId2 = obtainAttributes2.getResourceId(1, 0);
                        if (resourceId2 != 0) {
                            Context context = this.mContext;
                            if (context != null) {
                                setupAnimatorsForTarget(string, AnimatorInflaterCompat.loadAnimator(context, resourceId2));
                            } else {
                                obtainAttributes2.recycle();
                                throw new IllegalStateException("Context can't be null when inflating animators");
                            }
                        }
                        obtainAttributes2.recycle();
                    } else {
                        continue;
                    }
                }
                eventType = xmlPullParser.next();
            }
            this.mAnimatedVectorState.setupAnimatorSet();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return DrawableCompat.isAutoMirrored(drawable);
            }
            return this.mAnimatedVectorState.mVectorDrawable.isAutoMirrored();
        }
        return invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return ((AnimatedVectorDrawable) drawable).isRunning();
            }
            return this.mAnimatedVectorState.mAnimatorSet.isRunning();
        }
        return invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.isStateful();
            }
            return this.mAnimatedVectorState.mVectorDrawable.isStateful();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                drawable.mutate();
            }
            return this;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, rect) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                drawable.setBounds(rect);
            } else {
                this.mAnimatedVectorState.mVectorDrawable.setBounds(rect);
            }
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.setLevel(i);
            }
            return this.mAnimatedVectorState.mVectorDrawable.setLevel(i);
        }
        return invokeI.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, iArr)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.setState(iArr);
            }
            return this.mAnimatedVectorState.mVectorDrawable.setState(iArr);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, animationCallback) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                registerPlatformCallback((AnimatedVectorDrawable) drawable, animationCallback);
            } else if (animationCallback == null) {
            } else {
                if (this.mAnimationCallbacks == null) {
                    this.mAnimationCallbacks = new ArrayList<>();
                }
                if (this.mAnimationCallbacks.contains(animationCallback)) {
                    return;
                }
                this.mAnimationCallbacks.add(animationCallback);
                if (this.mAnimatorListener == null) {
                    this.mAnimatorListener = new AnimatorListenerAdapter(this) { // from class: androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnimatedVectorDrawableCompat this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                                ArrayList arrayList = new ArrayList(this.this$0.mAnimationCallbacks);
                                int size = arrayList.size();
                                for (int i = 0; i < size; i++) {
                                    ((Animatable2Compat.AnimationCallback) arrayList.get(i)).onAnimationEnd(this.this$0);
                                }
                            }
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                                ArrayList arrayList = new ArrayList(this.this$0.mAnimationCallbacks);
                                int size = arrayList.size();
                                for (int i = 0; i < size; i++) {
                                    ((Animatable2Compat.AnimationCallback) arrayList.get(i)).onAnimationStart(this.this$0);
                                }
                            }
                        }
                    };
                }
                this.mAnimatedVectorState.mAnimatorSet.addListener(this.mAnimatorListener);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                drawable.setAlpha(i);
            } else {
                this.mAnimatedVectorState.mVectorDrawable.setAlpha(i);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                DrawableCompat.setAutoMirrored(drawable, z);
            } else {
                this.mAnimatedVectorState.mVectorDrawable.setAutoMirrored(z);
            }
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                DrawableCompat.setTint(drawable, i);
            } else {
                this.mAnimatedVectorState.mVectorDrawable.setTint(i);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, colorStateList) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                DrawableCompat.setTintList(drawable, colorStateList);
            } else {
                this.mAnimatedVectorState.mVectorDrawable.setTintList(colorStateList);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, mode) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                DrawableCompat.setTintMode(drawable, mode);
            } else {
                this.mAnimatedVectorState.mVectorDrawable.setTintMode(mode);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048617, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.setVisible(z, z2);
            }
            this.mAnimatedVectorState.mVectorDrawable.setVisible(z, z2);
            return super.setVisible(z, z2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                ((AnimatedVectorDrawable) drawable).start();
            } else if (this.mAnimatedVectorState.mAnimatorSet.isStarted()) {
            } else {
                this.mAnimatedVectorState.mAnimatorSet.start();
                invalidateSelf();
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                ((AnimatedVectorDrawable) drawable).stop();
            } else {
                this.mAnimatedVectorState.mAnimatorSet.end();
            }
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, animationCallback)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                unregisterPlatformCallback((AnimatedVectorDrawable) drawable, animationCallback);
            }
            ArrayList<Animatable2Compat.AnimationCallback> arrayList = this.mAnimationCallbacks;
            if (arrayList == null || animationCallback == null) {
                return false;
            }
            boolean remove = arrayList.remove(animationCallback);
            if (this.mAnimationCallbacks.size() == 0) {
                removeAnimatorSetListener();
            }
            return remove;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnimatedVectorDrawableCompat(@Nullable Context context) {
        this(context, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AnimatedVectorDrawableCompatState) objArr2[1], (Resources) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, colorFilter) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            } else {
                this.mAnimatedVectorState.mVectorDrawable.setColorFilter(colorFilter);
            }
        }
    }

    @RequiresApi(24)
    /* loaded from: classes.dex */
    public static class AnimatedVectorDrawableDelegateState extends Drawable.ConstantState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Drawable.ConstantState mDelegateState;

        public AnimatedVectorDrawableDelegateState(Drawable.ConstantState constantState) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {constantState};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDelegateState = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDelegateState.canApplyTheme() : invokeV.booleanValue;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDelegateState.getChangingConfigurations() : invokeV.intValue;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
                Drawable newDrawable = this.mDelegateState.newDrawable();
                animatedVectorDrawableCompat.mDelegateDrawable = newDrawable;
                newDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
                return animatedVectorDrawableCompat;
            }
            return (Drawable) invokeV.objValue;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, resources)) == null) {
                AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
                Drawable newDrawable = this.mDelegateState.newDrawable(resources);
                animatedVectorDrawableCompat.mDelegateDrawable = newDrawable;
                newDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
                return animatedVectorDrawableCompat;
            }
            return (Drawable) invokeL.objValue;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, resources, theme)) == null) {
                AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
                Drawable newDrawable = this.mDelegateState.newDrawable(resources, theme);
                animatedVectorDrawableCompat.mDelegateDrawable = newDrawable;
                newDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
                return animatedVectorDrawableCompat;
            }
            return (Drawable) invokeLL.objValue;
        }
    }

    public AnimatedVectorDrawableCompat(@Nullable Context context, @Nullable AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, @Nullable Resources resources) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, animatedVectorDrawableCompatState, resources};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mArgbEvaluator = null;
        this.mAnimatorListener = null;
        this.mAnimationCallbacks = null;
        this.mCallback = new Drawable.Callback(this) { // from class: androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AnimatedVectorDrawableCompat this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, drawable) == null) {
                    this.this$0.invalidateSelf();
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{drawable, runnable, Long.valueOf(j)}) == null) {
                    this.this$0.scheduleSelf(runnable, j);
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, drawable, runnable) == null) {
                    this.this$0.unscheduleSelf(runnable);
                }
            }
        };
        this.mContext = context;
        if (animatedVectorDrawableCompatState != null) {
            this.mAnimatedVectorState = animatedVectorDrawableCompatState;
        } else {
            this.mAnimatedVectorState = new AnimatedVectorDrawableCompatState(context, animatedVectorDrawableCompatState, this.mCallback, resources);
        }
    }

    public static void clearAnimationCallbacks(Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, drawable) == null) && (drawable instanceof Animatable)) {
            if (Build.VERSION.SDK_INT >= 24) {
                ((AnimatedVectorDrawable) drawable).clearAnimationCallbacks();
            } else {
                ((AnimatedVectorDrawableCompat) drawable).clearAnimationCallbacks();
            }
        }
    }

    public static boolean unregisterAnimationCallback(Drawable drawable, Animatable2Compat.AnimationCallback animationCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, drawable, animationCallback)) == null) {
            if (drawable == null || animationCallback == null || !(drawable instanceof Animatable)) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                return unregisterPlatformCallback((AnimatedVectorDrawable) drawable, animationCallback);
            }
            return ((AnimatedVectorDrawableCompat) drawable).unregisterAnimationCallback(animationCallback);
        }
        return invokeLL.booleanValue;
    }

    public static void registerAnimationCallback(Drawable drawable, Animatable2Compat.AnimationCallback animationCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, drawable, animationCallback) == null) || drawable == null || animationCallback == null || !(drawable instanceof Animatable)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            registerPlatformCallback((AnimatedVectorDrawable) drawable, animationCallback);
        } else {
            ((AnimatedVectorDrawableCompat) drawable).registerAnimationCallback(animationCallback);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, resources, xmlPullParser, attributeSet) == null) {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }
}

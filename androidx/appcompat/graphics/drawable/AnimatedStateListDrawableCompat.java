package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.graphics.drawable.DrawableContainer;
import androidx.appcompat.graphics.drawable.StateListDrawable;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.view.InputDeviceCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public class AnimatedStateListDrawableCompat extends StateListDrawable implements TintAwareDrawable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ELEMENT_ITEM = "item";
    public static final String ELEMENT_TRANSITION = "transition";
    public static final String ITEM_MISSING_DRAWABLE_ERROR = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable";
    public static final String LOGTAG;
    public static final String TRANSITION_MISSING_DRAWABLE_ERROR = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable";
    public static final String TRANSITION_MISSING_FROM_TO_ID = ": <transition> tag requires 'fromId' & 'toId' attributes";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mMutated;
    public AnimatedStateListState mState;
    public Transition mTransition;
    public int mTransitionFromIndex;
    public int mTransitionToIndex;

    /* renamed from: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class AnimatableTransition extends Transition {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Animatable mA;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimatableTransition(Animatable animatable) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {animatable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mA = animatable;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void start() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.mA.start();
            }
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void stop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.mA.stop();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class AnimatedStateListState extends StateListDrawable.StateListState {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long REVERSED_BIT = 4294967296L;
        public static final long REVERSIBLE_FLAG_BIT = 8589934592L;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseArrayCompat<Integer> mStateIds;
        public LongSparseArray<Long> mTransitions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimatedStateListState(@Nullable AnimatedStateListState animatedStateListState, @NonNull AnimatedStateListDrawableCompat animatedStateListDrawableCompat, @Nullable Resources resources) {
            super(animatedStateListState, animatedStateListDrawableCompat, resources);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {animatedStateListState, animatedStateListDrawableCompat, resources};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((StateListDrawable.StateListState) objArr2[0], (StateListDrawable) objArr2[1], (Resources) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (animatedStateListState != null) {
                this.mTransitions = animatedStateListState.mTransitions;
                this.mStateIds = animatedStateListState.mStateIds;
                return;
            }
            this.mTransitions = new LongSparseArray<>();
            this.mStateIds = new SparseArrayCompat<>();
        }

        public static long generateTransitionKey(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i2, i3)) == null) ? i3 | (i2 << 32) : invokeII.longValue;
        }

        public int addStateSet(@NonNull int[] iArr, @NonNull Drawable drawable, int i2) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, iArr, drawable, i2)) == null) {
                int addStateSet = super.addStateSet(iArr, drawable);
                this.mStateIds.put(addStateSet, Integer.valueOf(i2));
                return addStateSet;
            }
            return invokeLLI.intValue;
        }

        public int addTransition(int i2, int i3, @NonNull Drawable drawable, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), drawable, Boolean.valueOf(z)})) == null) {
                int addChild = super.addChild(drawable);
                long generateTransitionKey = generateTransitionKey(i2, i3);
                long j = z ? REVERSIBLE_FLAG_BIT : 0L;
                long j2 = addChild;
                this.mTransitions.append(generateTransitionKey, Long.valueOf(j2 | j));
                if (z) {
                    this.mTransitions.append(generateTransitionKey(i3, i2), Long.valueOf(4294967296L | j2 | j));
                }
                return addChild;
            }
            return invokeCommon.intValue;
        }

        public int getKeyframeIdAt(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                if (i2 < 0) {
                    return 0;
                }
                return this.mStateIds.get(i2, 0).intValue();
            }
            return invokeI.intValue;
        }

        public int indexOfKeyframe(@NonNull int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iArr)) == null) {
                int indexOfStateSet = super.indexOfStateSet(iArr);
                return indexOfStateSet >= 0 ? indexOfStateSet : super.indexOfStateSet(StateSet.WILD_CARD);
            }
            return invokeL.intValue;
        }

        public int indexOfTransition(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i2, i3)) == null) ? (int) this.mTransitions.get(generateTransitionKey(i2, i3), -1L).longValue() : invokeII.intValue;
        }

        public boolean isTransitionReversed(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) ? (this.mTransitions.get(generateTransitionKey(i2, i3), -1L).longValue() & 4294967296L) != 0 : invokeII.booleanValue;
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawable.StateListState, androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState
        public void mutate() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.mTransitions = this.mTransitions.m0clone();
                this.mStateIds = this.mStateIds.m1clone();
            }
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawable.StateListState, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new AnimatedStateListDrawableCompat(this, null) : (Drawable) invokeV.objValue;
        }

        public boolean transitionHasReversibleFlag(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i2, i3)) == null) ? (this.mTransitions.get(generateTransitionKey(i2, i3), -1L).longValue() & REVERSIBLE_FLAG_BIT) != 0 : invokeII.booleanValue;
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawable.StateListState, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, resources)) == null) ? new AnimatedStateListDrawableCompat(this, resources) : (Drawable) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class AnimatedVectorDrawableTransition extends Transition {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AnimatedVectorDrawableCompat mAvd;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {animatedVectorDrawableCompat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mAvd = animatedVectorDrawableCompat;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void start() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.mAvd.start();
            }
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void stop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.mAvd.stop();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class AnimationDrawableTransition extends Transition {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ObjectAnimator mAnim;
        public final boolean mHasReversibleFlag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimationDrawableTransition(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {animationDrawable, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i4 = z ? numberOfFrames - 1 : 0;
            int i5 = z ? 0 : numberOfFrames - 1;
            FrameInterpolator frameInterpolator = new FrameInterpolator(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i4, i5);
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration(frameInterpolator.getTotalDuration());
            ofInt.setInterpolator(frameInterpolator);
            this.mHasReversibleFlag = z2;
            this.mAnim = ofInt;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public boolean canReverse() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mHasReversibleFlag : invokeV.booleanValue;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void reverse() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.mAnim.reverse();
            }
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void start() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.mAnim.start();
            }
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void stop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.mAnim.cancel();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FrameInterpolator implements TimeInterpolator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int[] mFrameTimes;
        public int mFrames;
        public int mTotalDuration;

        public FrameInterpolator(AnimationDrawable animationDrawable, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {animationDrawable, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            updateFrames(animationDrawable, z);
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                int i2 = (int) ((f2 * this.mTotalDuration) + 0.5f);
                int i3 = this.mFrames;
                int[] iArr = this.mFrameTimes;
                int i4 = 0;
                while (i4 < i3 && i2 >= iArr[i4]) {
                    i2 -= iArr[i4];
                    i4++;
                }
                return (i4 / i3) + (i4 < i3 ? i2 / this.mTotalDuration : 0.0f);
            }
            return invokeF.floatValue;
        }

        public int getTotalDuration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mTotalDuration : invokeV.intValue;
        }

        public int updateFrames(AnimationDrawable animationDrawable, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, animationDrawable, z)) == null) {
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                this.mFrames = numberOfFrames;
                int[] iArr = this.mFrameTimes;
                if (iArr == null || iArr.length < numberOfFrames) {
                    this.mFrameTimes = new int[numberOfFrames];
                }
                int[] iArr2 = this.mFrameTimes;
                int i2 = 0;
                for (int i3 = 0; i3 < numberOfFrames; i3++) {
                    int duration = animationDrawable.getDuration(z ? (numberOfFrames - i3) - 1 : i3);
                    iArr2[i3] = duration;
                    i2 += duration;
                }
                this.mTotalDuration = i2;
                return i2;
            }
            return invokeLZ.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Transition {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Transition() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public boolean canReverse() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public void reverse() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public abstract void start();

        public abstract void stop();

        public /* synthetic */ Transition(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1774488670, "Landroidx/appcompat/graphics/drawable/AnimatedStateListDrawableCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1774488670, "Landroidx/appcompat/graphics/drawable/AnimatedStateListDrawableCompat;");
                return;
            }
        }
        LOGTAG = AnimatedStateListDrawableCompat.class.getSimpleName();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnimatedStateListDrawableCompat() {
        this(null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((AnimatedStateListState) objArr[0], (Resources) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Nullable
    public static AnimatedStateListDrawableCompat create(@NonNull Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        int next;
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, context, i2, theme)) == null) {
            try {
                Resources resources = context.getResources();
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                }
                if (next == 2) {
                    return createFromXmlInner(context, resources, xml, asAttributeSet, theme);
                }
                throw new XmlPullParserException("No start tag found");
            } catch (IOException | XmlPullParserException unused) {
                return null;
            }
        }
        return (AnimatedStateListDrawableCompat) invokeLIL.objValue;
    }

    public static AnimatedStateListDrawableCompat createFromXmlInner(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws IOException, XmlPullParserException {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, resources, xmlPullParser, attributeSet, theme)) == null) {
            String name = xmlPullParser.getName();
            if (name.equals("animated-selector")) {
                AnimatedStateListDrawableCompat animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat();
                animatedStateListDrawableCompat.inflate(context, resources, xmlPullParser, attributeSet, theme);
                return animatedStateListDrawableCompat;
            }
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
        }
        return (AnimatedStateListDrawableCompat) invokeLLLLL.objValue;
    }

    private void inflateChildElements(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLLLL(AdIconUtil.AD_TEXT_ID, this, context, resources, xmlPullParser, attributeSet, theme) != null) {
            return;
        }
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    parseItem(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals(ELEMENT_TRANSITION)) {
                    parseTransition(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            onStateChange(getState());
        }
    }

    private int parseItem(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        InterceptResult invokeLLLLL;
        int next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65543, this, context, resources, xmlPullParser, attributeSet, theme)) == null) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableItem);
            int resourceId = obtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
            int resourceId2 = obtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
            Drawable drawable = resourceId2 > 0 ? ResourceManagerInternal.get().getDrawable(context, resourceId2) : null;
            obtainAttributes.recycle();
            int[] extractStateSet = extractStateSet(attributeSet);
            if (drawable == null) {
                do {
                    next = xmlPullParser.next();
                } while (next == 4);
                if (next == 2) {
                    if (xmlPullParser.getName().equals(VectorDrawableCompat.SHAPE_VECTOR)) {
                        drawable = VectorDrawableCompat.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                    } else {
                        drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                    }
                } else {
                    throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ITEM_MISSING_DRAWABLE_ERROR);
                }
            }
            if (drawable != null) {
                return this.mState.addStateSet(extractStateSet, drawable, resourceId);
            }
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ITEM_MISSING_DRAWABLE_ERROR);
        }
        return invokeLLLLL.intValue;
    }

    private int parseTransition(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        InterceptResult invokeLLLLL;
        int next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65544, this, context, resources, xmlPullParser, attributeSet, theme)) == null) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableTransition);
            int resourceId = obtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
            int resourceId2 = obtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
            int resourceId3 = obtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
            Drawable drawable = resourceId3 > 0 ? ResourceManagerInternal.get().getDrawable(context, resourceId3) : null;
            boolean z = obtainAttributes.getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
            obtainAttributes.recycle();
            if (drawable == null) {
                do {
                    next = xmlPullParser.next();
                } while (next == 4);
                if (next == 2) {
                    if (xmlPullParser.getName().equals(AnimatedVectorDrawableCompat.ANIMATED_VECTOR)) {
                        drawable = AnimatedVectorDrawableCompat.createFromXmlInner(context, resources, xmlPullParser, attributeSet, theme);
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                    } else {
                        drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                    }
                } else {
                    throw new XmlPullParserException(xmlPullParser.getPositionDescription() + TRANSITION_MISSING_DRAWABLE_ERROR);
                }
            }
            if (drawable == null) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + TRANSITION_MISSING_DRAWABLE_ERROR);
            } else if (resourceId != -1 && resourceId2 != -1) {
                return this.mState.addTransition(resourceId, resourceId2, drawable, z);
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + TRANSITION_MISSING_FROM_TO_ID);
            }
        }
        return invokeLLLLL.intValue;
    }

    private boolean selectTransition(int i2) {
        InterceptResult invokeI;
        int currentIndex;
        int indexOfTransition;
        Transition animatableTransition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, this, i2)) == null) {
            Transition transition = this.mTransition;
            if (transition != null) {
                if (i2 == this.mTransitionToIndex) {
                    return true;
                }
                if (i2 == this.mTransitionFromIndex && transition.canReverse()) {
                    transition.reverse();
                    this.mTransitionToIndex = this.mTransitionFromIndex;
                    this.mTransitionFromIndex = i2;
                    return true;
                }
                currentIndex = this.mTransitionToIndex;
                transition.stop();
            } else {
                currentIndex = getCurrentIndex();
            }
            this.mTransition = null;
            this.mTransitionFromIndex = -1;
            this.mTransitionToIndex = -1;
            AnimatedStateListState animatedStateListState = this.mState;
            int keyframeIdAt = animatedStateListState.getKeyframeIdAt(currentIndex);
            int keyframeIdAt2 = animatedStateListState.getKeyframeIdAt(i2);
            if (keyframeIdAt2 == 0 || keyframeIdAt == 0 || (indexOfTransition = animatedStateListState.indexOfTransition(keyframeIdAt, keyframeIdAt2)) < 0) {
                return false;
            }
            boolean transitionHasReversibleFlag = animatedStateListState.transitionHasReversibleFlag(keyframeIdAt, keyframeIdAt2);
            selectDrawable(indexOfTransition);
            Drawable current = getCurrent();
            if (current instanceof AnimationDrawable) {
                animatableTransition = new AnimationDrawableTransition((AnimationDrawable) current, animatedStateListState.isTransitionReversed(keyframeIdAt, keyframeIdAt2), transitionHasReversibleFlag);
            } else if (current instanceof AnimatedVectorDrawableCompat) {
                animatableTransition = new AnimatedVectorDrawableTransition((AnimatedVectorDrawableCompat) current);
            } else {
                if (current instanceof Animatable) {
                    animatableTransition = new AnimatableTransition((Animatable) current);
                }
                return false;
            }
            animatableTransition.start();
            this.mTransition = animatableTransition;
            this.mTransitionFromIndex = currentIndex;
            this.mTransitionToIndex = i2;
            return true;
        }
        return invokeI.booleanValue;
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, typedArray) == null) {
            AnimatedStateListState animatedStateListState = this.mState;
            if (Build.VERSION.SDK_INT >= 21) {
                animatedStateListState.mChangingConfigurations |= typedArray.getChangingConfigurations();
            }
            animatedStateListState.setVariablePadding(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, animatedStateListState.mVariablePadding));
            animatedStateListState.setConstantSize(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, animatedStateListState.mConstantSize));
            animatedStateListState.setEnterFadeDuration(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, animatedStateListState.mEnterFadeDuration));
            animatedStateListState.setExitFadeDuration(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, animatedStateListState.mExitFadeDuration));
            setDither(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, animatedStateListState.mDither));
        }
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable
    public /* bridge */ /* synthetic */ void addState(int[] iArr, Drawable drawable) {
        super.addState(iArr, drawable);
    }

    public <T extends Drawable & Animatable> void addTransition(int i2, int i3, @NonNull T t, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), t, Boolean.valueOf(z)}) == null) {
            if (t != null) {
                this.mState.addTransition(i2, i3, t, z);
                return;
            }
            throw new IllegalArgumentException("Transition drawable must not be null");
        }
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    @RequiresApi(21)
    public /* bridge */ /* synthetic */ void applyTheme(@NonNull Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    @RequiresApi(21)
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer
    public void clearMutated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.clearMutated();
            this.mMutated = false;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    @NonNull
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(@NonNull Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    @RequiresApi(21)
    public /* bridge */ /* synthetic */ void getOutline(@NonNull Outline outline) {
        super.getOutline(outline);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(@NonNull Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable
    public void inflate(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048597, this, context, resources, xmlPullParser, attributeSet, theme) == null) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableCompat);
            setVisible(obtainAttributes.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
            updateStateFromTypedArray(obtainAttributes);
            updateDensity(resources);
            obtainAttributes.recycle();
            inflateChildElements(context, resources, xmlPullParser, attributeSet, theme);
            init();
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(@NonNull Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.jumpToCurrentState();
            Transition transition = this.mTransition;
            if (transition != null) {
                transition.stop();
                this.mTransition = null;
                selectDrawable(this.mTransitionToIndex);
                this.mTransitionToIndex = -1;
                this.mTransitionFromIndex = -1;
            }
        }
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public Drawable mutate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (!this.mMutated && super.mutate() == this) {
                this.mState.mutate();
                this.mMutated = true;
            }
            return this;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i2) {
        return super.onLayoutDirectionChanged(i2);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, iArr)) == null) {
            int indexOfKeyframe = this.mState.indexOfKeyframe(iArr);
            boolean z = indexOfKeyframe != getCurrentIndex() && (selectTransition(indexOfKeyframe) || selectDrawable(indexOfKeyframe));
            Drawable current = getCurrent();
            return current != null ? z | current.setState(iArr) : z;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i2) {
        super.setAlpha(i2);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer
    public void setConstantState(@NonNull DrawableContainer.DrawableContainerState drawableContainerState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, drawableContainerState) == null) {
            super.setConstantState(drawableContainerState);
            if (drawableContainerState instanceof AnimatedStateListState) {
                this.mState = (AnimatedStateListState) drawableContainerState;
            }
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public /* bridge */ /* synthetic */ void setEnterFadeDuration(int i2) {
        super.setEnterFadeDuration(i2);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public /* bridge */ /* synthetic */ void setExitFadeDuration(int i2) {
        super.setExitFadeDuration(i2);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public /* bridge */ /* synthetic */ void setTintMode(@NonNull PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048617, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            boolean visible = super.setVisible(z, z2);
            if (this.mTransition != null && (visible || z2)) {
                if (z) {
                    this.mTransition.start();
                } else {
                    jumpToCurrentState();
                }
            }
            return visible;
        }
        return invokeCommon.booleanValue;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimatedStateListDrawableCompat(@Nullable AnimatedStateListState animatedStateListState, @Nullable Resources resources) {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animatedStateListState, resources};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((StateListDrawable.StateListState) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mTransitionToIndex = -1;
        this.mTransitionFromIndex = -1;
        setConstantState(new AnimatedStateListState(animatedStateListState, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public void addState(@NonNull int[] iArr, @NonNull Drawable drawable, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr, drawable, i2) == null) {
            if (drawable != null) {
                this.mState.addStateSet(iArr, drawable, i2);
                onStateChange(getState());
                return;
            }
            throw new IllegalArgumentException("Drawable must not be null");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer
    public AnimatedStateListState cloneConstantState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new AnimatedStateListState(this.mState, this, null) : (AnimatedStateListState) invokeV.objValue;
    }
}

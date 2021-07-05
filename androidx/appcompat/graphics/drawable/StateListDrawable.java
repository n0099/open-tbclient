package androidx.appcompat.graphics.drawable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.DrawableContainer;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
@SuppressLint({"RestrictedAPI"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class StateListDrawable extends DrawableContainer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "StateListDrawable";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mMutated;
    public StateListState mStateListState;

    /* loaded from: classes.dex */
    public static class StateListState extends DrawableContainer.DrawableContainerState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int[][] mStateSets;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StateListState(StateListState stateListState, StateListDrawable stateListDrawable, Resources resources) {
            super(stateListState, stateListDrawable, resources);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {stateListState, stateListDrawable, resources};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((DrawableContainer.DrawableContainerState) objArr2[0], (DrawableContainer) objArr2[1], (Resources) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (stateListState != null) {
                this.mStateSets = stateListState.mStateSets;
            } else {
                this.mStateSets = new int[getCapacity()];
            }
        }

        public int addStateSet(int[] iArr, Drawable drawable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, iArr, drawable)) == null) {
                int addChild = addChild(drawable);
                this.mStateSets[addChild] = iArr;
                return addChild;
            }
            return invokeLL.intValue;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState
        public void growArray(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                super.growArray(i2, i3);
                int[][] iArr = new int[i3];
                System.arraycopy(this.mStateSets, 0, iArr, 0, i2);
                this.mStateSets = iArr;
            }
        }

        public int indexOfStateSet(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iArr)) == null) {
                int[][] iArr2 = this.mStateSets;
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                        return i2;
                    }
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState
        public void mutate() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                int[][] iArr = this.mStateSets;
                int[][] iArr2 = new int[iArr.length];
                for (int length = iArr.length - 1; length >= 0; length--) {
                    int[][] iArr3 = this.mStateSets;
                    iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
                }
                this.mStateSets = iArr2;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new StateListDrawable(this, null) : (Drawable) invokeV.objValue;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, resources)) == null) ? new StateListDrawable(this, resources) : (Drawable) invokeL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StateListDrawable() {
        this(null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((StateListState) objArr[0], (Resources) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void inflateChildElements(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLLLL(65539, this, context, resources, xmlPullParser, attributeSet, theme) != null) {
            return;
        }
        StateListState stateListState = this.mStateListState;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next2 == 3) {
                return;
            }
            if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.StateListDrawableItem);
                int resourceId = obtainAttributes.getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
                Drawable drawable = resourceId > 0 ? ResourceManagerInternal.get().getDrawable(context, resourceId) : null;
                obtainAttributes.recycle();
                int[] extractStateSet = extractStateSet(attributeSet);
                if (drawable == null) {
                    do {
                        next = xmlPullParser.next();
                    } while (next == 4);
                    if (next == 2) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                        } else {
                            drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                        }
                    } else {
                        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + AnimatedStateListDrawableCompat.ITEM_MISSING_DRAWABLE_ERROR);
                    }
                }
                stateListState.addStateSet(extractStateSet, drawable);
            }
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, typedArray) == null) {
            StateListState stateListState = this.mStateListState;
            if (Build.VERSION.SDK_INT >= 21) {
                stateListState.mChangingConfigurations |= typedArray.getChangingConfigurations();
            }
            stateListState.mVariablePadding = typedArray.getBoolean(R.styleable.StateListDrawable_android_variablePadding, stateListState.mVariablePadding);
            stateListState.mConstantSize = typedArray.getBoolean(R.styleable.StateListDrawable_android_constantSize, stateListState.mConstantSize);
            stateListState.mEnterFadeDuration = typedArray.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, stateListState.mEnterFadeDuration);
            stateListState.mExitFadeDuration = typedArray.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, stateListState.mExitFadeDuration);
            stateListState.mDither = typedArray.getBoolean(R.styleable.StateListDrawable_android_dither, stateListState.mDither);
        }
    }

    public void addState(int[] iArr, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, iArr, drawable) == null) || drawable == null) {
            return;
        }
        this.mStateListState.addStateSet(iArr, drawable);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, theme) == null) {
            super.applyTheme(theme);
            onStateChange(getState());
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public void clearMutated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.clearMutated();
            this.mMutated = false;
        }
    }

    public int[] extractStateSet(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, attributeSet)) == null) {
            int attributeCount = attributeSet.getAttributeCount();
            int[] iArr = new int[attributeCount];
            int i2 = 0;
            for (int i3 = 0; i3 < attributeCount; i3++) {
                int attributeNameResource = attributeSet.getAttributeNameResource(i3);
                if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                    int i4 = i2 + 1;
                    if (!attributeSet.getAttributeBooleanValue(i3, false)) {
                        attributeNameResource = -attributeNameResource;
                    }
                    iArr[i2] = attributeNameResource;
                    i2 = i4;
                }
            }
            return StateSet.trimStateSet(iArr, i2);
        }
        return (int[]) invokeL.objValue;
    }

    public int getStateCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mStateListState.getChildCount() : invokeV.intValue;
    }

    public Drawable getStateDrawable(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? this.mStateListState.getChild(i2) : (Drawable) invokeI.objValue;
    }

    public int getStateDrawableIndex(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iArr)) == null) ? this.mStateListState.indexOfStateSet(iArr) : invokeL.intValue;
    }

    public StateListState getStateListState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mStateListState : (StateListState) invokeV.objValue;
    }

    public int[] getStateSet(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? this.mStateListState.mStateSets[i2] : (int[]) invokeI.objValue;
    }

    public void inflate(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048587, this, context, resources, xmlPullParser, attributeSet, theme) == null) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.StateListDrawable);
            setVisible(obtainAttributes.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
            updateStateFromTypedArray(obtainAttributes);
            updateDensity(resources);
            obtainAttributes.recycle();
            inflateChildElements(context, resources, xmlPullParser, attributeSet, theme);
            onStateChange(getState());
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!this.mMutated && super.mutate() == this) {
                this.mStateListState.mutate();
                this.mMutated = true;
            }
            return this;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, iArr)) == null) {
            boolean onStateChange = super.onStateChange(iArr);
            int indexOfStateSet = this.mStateListState.indexOfStateSet(iArr);
            if (indexOfStateSet < 0) {
                indexOfStateSet = this.mStateListState.indexOfStateSet(StateSet.WILD_CARD);
            }
            return selectDrawable(indexOfStateSet) || onStateChange;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public void setConstantState(@NonNull DrawableContainer.DrawableContainerState drawableContainerState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, drawableContainerState) == null) {
            super.setConstantState(drawableContainerState);
            if (drawableContainerState instanceof StateListState) {
                this.mStateListState = (StateListState) drawableContainerState;
            }
        }
    }

    public StateListDrawable(StateListState stateListState, Resources resources) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {stateListState, resources};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        setConstantState(new StateListState(stateListState, this, resources));
        onStateChange(getState());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public StateListState cloneConstantState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new StateListState(this.mStateListState, this, null) : (StateListState) invokeV.objValue;
    }

    public StateListDrawable(@Nullable StateListState stateListState) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {stateListState};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (stateListState != null) {
            setConstantState(stateListState);
        }
    }
}

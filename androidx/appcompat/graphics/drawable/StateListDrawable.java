package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
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
/* loaded from: classes.dex */
public class StateListDrawable extends DrawableContainer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "StateListDrawable";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mMutated;
    public StateListState mStateListState;

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public void growArray(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                super.growArray(i, i2);
                int[][] iArr = new int[i2];
                System.arraycopy(this.mStateSets, 0, iArr, 0, i);
                this.mStateSets = iArr;
            }
        }

        public int indexOfStateSet(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iArr)) == null) {
                int[][] iArr2 = this.mStateSets;
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                        return i;
                    }
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, resources)) == null) {
                return new StateListDrawable(this, resources);
            }
            return (Drawable) invokeL.objValue;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState
        public void mutate() {
            int[] iArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                int[][] iArr2 = this.mStateSets;
                int[][] iArr3 = new int[iArr2.length];
                for (int length = iArr2.length - 1; length >= 0; length--) {
                    int[][] iArr4 = this.mStateSets;
                    if (iArr4[length] != null) {
                        iArr = (int[]) iArr4[length].clone();
                    } else {
                        iArr = null;
                    }
                    iArr3[length] = iArr;
                }
                this.mStateSets = iArr3;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return new StateListDrawable(this, null);
            }
            return (Drawable) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StateListDrawable() {
        this(null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((StateListState) objArr[0], (Resources) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
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

    public int getStateCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mStateListState.getChildCount();
        }
        return invokeV.intValue;
    }

    public StateListState getStateListState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mStateListState;
        }
        return (StateListState) invokeV.objValue;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
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

    public StateListDrawable(StateListState stateListState) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {stateListState};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (stateListState != null) {
            setConstantState(stateListState);
        }
    }

    public int[] extractStateSet(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, attributeSet)) == null) {
            int attributeCount = attributeSet.getAttributeCount();
            int[] iArr = new int[attributeCount];
            int i = 0;
            for (int i2 = 0; i2 < attributeCount; i2++) {
                int attributeNameResource = attributeSet.getAttributeNameResource(i2);
                if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                    int i3 = i + 1;
                    if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                        attributeNameResource = -attributeNameResource;
                    }
                    iArr[i] = attributeNameResource;
                    i = i3;
                }
            }
            return StateSet.trimStateSet(iArr, i);
        }
        return (int[]) invokeL.objValue;
    }

    public StateListDrawable(StateListState stateListState, Resources resources) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {stateListState, resources};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        setConstantState(new StateListState(stateListState, this, resources));
        onStateChange(getState());
    }

    private void inflateChildElements(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, this, context, resources, xmlPullParser, attributeSet, theme) == null) {
            StateListState stateListState = this.mStateListState;
            int depth = xmlPullParser.getDepth() + 1;
            while (true) {
                int next2 = xmlPullParser.next();
                if (next2 != 1) {
                    int depth2 = xmlPullParser.getDepth();
                    if (depth2 >= depth || next2 != 3) {
                        if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.StateListDrawableItem);
                            Drawable drawable = null;
                            int resourceId = obtainAttributes.getResourceId(0, -1);
                            if (resourceId > 0) {
                                drawable = ResourceManagerInternal.get().getDrawable(context, resourceId);
                            }
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
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, typedArray) == null) {
            StateListState stateListState = this.mStateListState;
            if (Build.VERSION.SDK_INT >= 21) {
                stateListState.mChangingConfigurations |= typedArray.getChangingConfigurations();
            }
            stateListState.mVariablePadding = typedArray.getBoolean(2, stateListState.mVariablePadding);
            stateListState.mConstantSize = typedArray.getBoolean(3, stateListState.mConstantSize);
            stateListState.mEnterFadeDuration = typedArray.getInt(4, stateListState.mEnterFadeDuration);
            stateListState.mExitFadeDuration = typedArray.getInt(5, stateListState.mExitFadeDuration);
            stateListState.mDither = typedArray.getBoolean(0, stateListState.mDither);
        }
    }

    public void addState(int[] iArr, Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, iArr, drawable) == null) && drawable != null) {
            this.mStateListState.addStateSet(iArr, drawable);
            onStateChange(getState());
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, theme) == null) {
            super.applyTheme(theme);
            onStateChange(getState());
        }
    }

    public Drawable getStateDrawable(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return this.mStateListState.getChild(i);
        }
        return (Drawable) invokeI.objValue;
    }

    public int getStateDrawableIndex(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iArr)) == null) {
            return this.mStateListState.indexOfStateSet(iArr);
        }
        return invokeL.intValue;
    }

    public int[] getStateSet(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            return this.mStateListState.mStateSets[i];
        }
        return (int[]) invokeI.objValue;
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
            if (!selectDrawable(indexOfStateSet) && !onStateChange) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public void setConstantState(DrawableContainer.DrawableContainerState drawableContainerState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, drawableContainerState) == null) {
            super.setConstantState(drawableContainerState);
            if (drawableContainerState instanceof StateListState) {
                this.mStateListState = (StateListState) drawableContainerState;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public StateListState cloneConstantState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new StateListState(this.mStateListState, this, null);
        }
        return (StateListState) invokeV.objValue;
    }

    public void inflate(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048587, this, context, resources, xmlPullParser, attributeSet, theme) == null) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.StateListDrawable);
            setVisible(obtainAttributes.getBoolean(1, true), true);
            updateStateFromTypedArray(obtainAttributes);
            updateDensity(resources);
            obtainAttributes.recycle();
            inflateChildElements(context, resources, xmlPullParser, attributeSet, theme);
            onStateChange(getState());
        }
    }
}

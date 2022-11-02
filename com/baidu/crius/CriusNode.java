package com.baidu.crius;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.crius.annotations.DoNotStrip;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@DoNotStrip
/* loaded from: classes.dex */
public class CriusNode {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BORDER = 4;
    public static final int MARGIN = 1;
    public static final int PADDING = 2;
    public transient /* synthetic */ FieldHolder $fh;
    @DoNotStrip
    public float mBorderBottom;
    @DoNotStrip
    public float mBorderLeft;
    @DoNotStrip
    public float mBorderRight;
    @DoNotStrip
    public float mBorderTop;
    public List<CriusNode> mChildren;
    public Object mData;
    @DoNotStrip
    public int mEdgeSetFlag;
    @DoNotStrip
    public boolean mHasNewLayout;
    public boolean mHasSetPosition;
    @DoNotStrip
    public float mHeight;
    @DoNotStrip
    public float mLeft;
    @DoNotStrip
    public float mMarginBottom;
    @DoNotStrip
    public float mMarginLeft;
    @DoNotStrip
    public float mMarginRight;
    @DoNotStrip
    public float mMarginTop;
    public CriusMeasureFunction mMeasureFunction;
    public long mNativePointer;
    @DoNotStrip
    public float mPaddingBottom;
    @DoNotStrip
    public float mPaddingLeft;
    @DoNotStrip
    public float mPaddingRight;
    @DoNotStrip
    public float mPaddingTop;
    public CriusNode mParent;
    @DoNotStrip
    public float mTop;
    @DoNotStrip
    public float mWidth;

    private native void jni_CSNodeCalculateLayout(long j, float f, float f2);

    private native void jni_CSNodeCopyStyle(long j, long j2);

    private native void jni_CSNodeFree(long j);

    private native void jni_CSNodeInsertChild(long j, long j2, int i);

    private native boolean jni_CSNodeIsDirty(long j);

    private native void jni_CSNodeMarkDirty(long j);

    private native long jni_CSNodeNew();

    private native long jni_CSNodeNewWithConfig(long j);

    private native void jni_CSNodeRemoveChild(long j, long j2);

    private native void jni_CSNodeReset(long j);

    private native void jni_CSNodeSetHasMeasureFunc(long j, boolean z);

    private native int jni_CSNodeStyleGetAlignContent(long j);

    private native int jni_CSNodeStyleGetAlignItems(long j);

    private native int jni_CSNodeStyleGetAlignSelf(long j);

    private native float jni_CSNodeStyleGetAspectRatio(long j);

    private native float jni_CSNodeStyleGetBorder(long j, int i);

    private native int jni_CSNodeStyleGetDisplay(long j);

    private native Object jni_CSNodeStyleGetFlexBasis(long j);

    private native int jni_CSNodeStyleGetFlexDirection(long j);

    private native float jni_CSNodeStyleGetFlexGrow(long j);

    private native float jni_CSNodeStyleGetFlexShrink(long j);

    private native Object jni_CSNodeStyleGetHeight(long j);

    private native int jni_CSNodeStyleGetJustifyContent(long j);

    private native Object jni_CSNodeStyleGetMargin(long j, int i);

    private native Object jni_CSNodeStyleGetMaxHeight(long j);

    private native Object jni_CSNodeStyleGetMaxWidth(long j);

    private native Object jni_CSNodeStyleGetMinHeight(long j);

    private native Object jni_CSNodeStyleGetMinWidth(long j);

    private native int jni_CSNodeStyleGetOverflow(long j);

    private native Object jni_CSNodeStyleGetPadding(long j, int i);

    private native Object jni_CSNodeStyleGetPosition(long j, int i);

    private native int jni_CSNodeStyleGetPositionType(long j);

    private native Object jni_CSNodeStyleGetWidth(long j);

    private native void jni_CSNodeStyleSetAlignContent(long j, int i);

    private native void jni_CSNodeStyleSetAlignItems(long j, int i);

    private native void jni_CSNodeStyleSetAlignSelf(long j, int i);

    private native void jni_CSNodeStyleSetAspectRatio(long j, float f);

    private native void jni_CSNodeStyleSetBorder(long j, int i, float f);

    private native void jni_CSNodeStyleSetDisplay(long j, int i);

    private native void jni_CSNodeStyleSetFlex(long j, float f);

    private native void jni_CSNodeStyleSetFlexBasis(long j, float f);

    private native void jni_CSNodeStyleSetFlexBasisAuto(long j);

    private native void jni_CSNodeStyleSetFlexBasisPercent(long j, float f);

    private native void jni_CSNodeStyleSetFlexDirection(long j, int i);

    private native void jni_CSNodeStyleSetFlexGrow(long j, float f);

    private native void jni_CSNodeStyleSetFlexShrink(long j, float f);

    private native void jni_CSNodeStyleSetFlexWrap(long j, int i);

    private native void jni_CSNodeStyleSetHeight(long j, float f);

    private native void jni_CSNodeStyleSetHeightAuto(long j);

    private native void jni_CSNodeStyleSetHeightPercent(long j, float f);

    private native void jni_CSNodeStyleSetJustifyContent(long j, int i);

    private native void jni_CSNodeStyleSetMargin(long j, int i, float f);

    private native void jni_CSNodeStyleSetMarginAuto(long j, int i);

    private native void jni_CSNodeStyleSetMarginPercent(long j, int i, float f);

    private native void jni_CSNodeStyleSetMaxHeight(long j, float f);

    private native void jni_CSNodeStyleSetMaxHeightPercent(long j, float f);

    private native void jni_CSNodeStyleSetMaxWidth(long j, float f);

    private native void jni_CSNodeStyleSetMaxWidthPercent(long j, float f);

    private native void jni_CSNodeStyleSetMinHeight(long j, float f);

    private native void jni_CSNodeStyleSetMinHeightPercent(long j, float f);

    private native void jni_CSNodeStyleSetMinWidth(long j, float f);

    private native void jni_CSNodeStyleSetMinWidthPercent(long j, float f);

    private native void jni_CSNodeStyleSetOverflow(long j, int i);

    private native void jni_CSNodeStyleSetPadding(long j, int i, float f);

    private native void jni_CSNodeStyleSetPaddingPercent(long j, int i, float f);

    private native void jni_CSNodeStyleSetPosition(long j, int i, float f);

    private native void jni_CSNodeStyleSetPositionPercent(long j, int i, float f);

    private native void jni_CSNodeStyleSetPositionType(long j, int i);

    private native void jni_CSNodeStyleSetWidth(long j, float f);

    private native void jni_CSNodeStyleSetWidthAuto(long j);

    private native void jni_CSNodeStyleSetWidthPercent(long j, float f);

    public void setDirection(CriusDirection criusDirection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, criusDirection) == null) {
        }
    }

    /* renamed from: com.baidu.crius.CriusNode$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$crius$CriusEdge;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(861145433, "Lcom/baidu/crius/CriusNode$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(861145433, "Lcom/baidu/crius/CriusNode$1;");
                    return;
                }
            }
            int[] iArr = new int[CriusEdge.values().length];
            $SwitchMap$com$baidu$crius$CriusEdge = iArr;
            try {
                iArr[CriusEdge.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$crius$CriusEdge[CriusEdge.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$crius$CriusEdge[CriusEdge.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$crius$CriusEdge[CriusEdge.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public CriusNode() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mEdgeSetFlag = 0;
        this.mHasSetPosition = false;
        this.mWidth = Float.NaN;
        this.mHeight = Float.NaN;
        this.mTop = Float.NaN;
        this.mLeft = Float.NaN;
        this.mMarginLeft = 0.0f;
        this.mMarginTop = 0.0f;
        this.mMarginRight = 0.0f;
        this.mMarginBottom = 0.0f;
        this.mPaddingLeft = 0.0f;
        this.mPaddingTop = 0.0f;
        this.mPaddingRight = 0.0f;
        this.mPaddingBottom = 0.0f;
        this.mBorderLeft = 0.0f;
        this.mBorderTop = 0.0f;
        this.mBorderRight = 0.0f;
        this.mBorderBottom = 0.0f;
        this.mHasNewLayout = true;
        long jni_CSNodeNew = jni_CSNodeNew();
        this.mNativePointer = jni_CSNodeNew;
        if (jni_CSNodeNew == 0 && CriusConstants.DEBUG) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
    }

    public CriusNode(CriusConfig criusConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {criusConfig};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mEdgeSetFlag = 0;
        this.mHasSetPosition = false;
        this.mWidth = Float.NaN;
        this.mHeight = Float.NaN;
        this.mTop = Float.NaN;
        this.mLeft = Float.NaN;
        this.mMarginLeft = 0.0f;
        this.mMarginTop = 0.0f;
        this.mMarginRight = 0.0f;
        this.mMarginBottom = 0.0f;
        this.mPaddingLeft = 0.0f;
        this.mPaddingTop = 0.0f;
        this.mPaddingRight = 0.0f;
        this.mPaddingBottom = 0.0f;
        this.mBorderLeft = 0.0f;
        this.mBorderTop = 0.0f;
        this.mBorderRight = 0.0f;
        this.mBorderBottom = 0.0f;
        this.mHasNewLayout = true;
        long jni_CSNodeNewWithConfig = jni_CSNodeNewWithConfig(criusConfig.mNativePointer);
        this.mNativePointer = jni_CSNodeNewWithConfig;
        if (jni_CSNodeNewWithConfig == 0 && CriusConstants.DEBUG) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
    }

    public void addChildAt(CriusNode criusNode, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, criusNode, i) == null) {
            if (criusNode.mParent != null && CriusConstants.DEBUG) {
                throw new IllegalStateException("Child already has a parent, it must be removed first.");
            }
            if (this.mChildren == null) {
                this.mChildren = new ArrayList(4);
            }
            this.mChildren.add(i, criusNode);
            criusNode.mParent = this;
            jni_CSNodeInsertChild(this.mNativePointer, criusNode.mNativePointer, i);
        }
    }

    public void calculateLayout(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            jni_CSNodeCalculateLayout(this.mNativePointer, f, f2);
        }
    }

    public void setBorder(CriusEdge criusEdge, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048626, this, criusEdge, f) == null) {
            this.mEdgeSetFlag |= 4;
            jni_CSNodeStyleSetBorder(this.mNativePointer, criusEdge.intValue(), f);
        }
    }

    public void setMargin(CriusEdge criusEdge, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048641, this, criusEdge, f) == null) {
            this.mEdgeSetFlag |= 1;
            jni_CSNodeStyleSetMargin(this.mNativePointer, criusEdge.intValue(), f);
        }
    }

    public void setMarginPercent(CriusEdge criusEdge, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048643, this, criusEdge, f) == null) {
            this.mEdgeSetFlag |= 1;
            jni_CSNodeStyleSetMarginPercent(this.mNativePointer, criusEdge.intValue(), f);
        }
    }

    public void setPadding(CriusEdge criusEdge, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048654, this, criusEdge, f) == null) {
            this.mEdgeSetFlag |= 2;
            jni_CSNodeStyleSetPadding(this.mNativePointer, criusEdge.intValue(), f);
        }
    }

    public void setPaddingPercent(CriusEdge criusEdge, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048655, this, criusEdge, f) == null) {
            this.mEdgeSetFlag |= 2;
            jni_CSNodeStyleSetPaddingPercent(this.mNativePointer, criusEdge.intValue(), f);
        }
    }

    public void setPosition(CriusEdge criusEdge, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048656, this, criusEdge, f) == null) {
            this.mHasSetPosition = true;
            jni_CSNodeStyleSetPosition(this.mNativePointer, criusEdge.intValue(), f);
        }
    }

    public void setPositionPercent(CriusEdge criusEdge, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048657, this, criusEdge, f) == null) {
            this.mHasSetPosition = true;
            jni_CSNodeStyleSetPositionPercent(this.mNativePointer, criusEdge.intValue(), f);
        }
    }

    public void copyStyle(CriusNode criusNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, criusNode) == null) {
            jni_CSNodeCopyStyle(this.mNativePointer, criusNode.mNativePointer);
        }
    }

    public float getBorder(CriusEdge criusEdge) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, criusEdge)) == null) {
            if ((this.mEdgeSetFlag & 4) != 4) {
                return Float.NaN;
            }
            return jni_CSNodeStyleGetBorder(this.mNativePointer, criusEdge.intValue());
        }
        return invokeL.floatValue;
    }

    public CriusNode getChildAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            return this.mChildren.get(i);
        }
        return (CriusNode) invokeI.objValue;
    }

    public CriusValue getMargin(CriusEdge criusEdge) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, criusEdge)) == null) {
            if ((this.mEdgeSetFlag & 1) != 1) {
                return CriusValue.UNDEFINED;
            }
            return (CriusValue) jni_CSNodeStyleGetMargin(this.mNativePointer, criusEdge.intValue());
        }
        return (CriusValue) invokeL.objValue;
    }

    public CriusValue getPadding(CriusEdge criusEdge) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, criusEdge)) == null) {
            if ((this.mEdgeSetFlag & 2) != 2) {
                return CriusValue.UNDEFINED;
            }
            return (CriusValue) jni_CSNodeStyleGetPadding(this.mNativePointer, criusEdge.intValue());
        }
        return (CriusValue) invokeL.objValue;
    }

    public CriusValue getPosition(CriusEdge criusEdge) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, criusEdge)) == null) {
            if (!this.mHasSetPosition) {
                return CriusValue.UNDEFINED;
            }
            return (CriusValue) jni_CSNodeStyleGetPosition(this.mNativePointer, criusEdge.intValue());
        }
        return (CriusValue) invokeL.objValue;
    }

    public int indexOf(CriusNode criusNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, criusNode)) == null) {
            List<CriusNode> list = this.mChildren;
            if (list == null) {
                return -1;
            }
            return list.indexOf(criusNode);
        }
        return invokeL.intValue;
    }

    public CriusNode removeChildAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i)) == null) {
            List<CriusNode> list = this.mChildren;
            if (list == null) {
                return null;
            }
            CriusNode remove = list.remove(i);
            remove.mParent = null;
            jni_CSNodeRemoveChild(this.mNativePointer, remove.mNativePointer);
            return remove;
        }
        return (CriusNode) invokeI.objValue;
    }

    public void setAlignContent(CriusAlign criusAlign) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, criusAlign) == null) {
            jni_CSNodeStyleSetAlignContent(this.mNativePointer, criusAlign.intValue());
        }
    }

    public void setAlignItems(CriusAlign criusAlign) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, criusAlign) == null) {
            jni_CSNodeStyleSetAlignItems(this.mNativePointer, criusAlign.intValue());
        }
    }

    public void setAlignSelf(CriusAlign criusAlign) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, criusAlign) == null) {
            jni_CSNodeStyleSetAlignSelf(this.mNativePointer, criusAlign.intValue());
        }
    }

    public void setAspectRatio(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048625, this, f) == null) {
            jni_CSNodeStyleSetAspectRatio(this.mNativePointer, f);
        }
    }

    public void setData(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, obj) == null) {
            this.mData = obj;
        }
    }

    public void setDisplay(CriusDisplay criusDisplay) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, criusDisplay) == null) {
            jni_CSNodeStyleSetDisplay(this.mNativePointer, criusDisplay.intValue());
        }
    }

    public void setFlex(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048630, this, f) == null) {
            jni_CSNodeStyleSetFlex(this.mNativePointer, f);
        }
    }

    public void setFlexBasis(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048631, this, f) == null) {
            jni_CSNodeStyleSetFlexBasis(this.mNativePointer, f);
        }
    }

    public void setFlexBasisPercent(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048633, this, f) == null) {
            jni_CSNodeStyleSetFlexBasisPercent(this.mNativePointer, f);
        }
    }

    public void setFlexDirection(CriusFlexDirection criusFlexDirection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, criusFlexDirection) == null) {
            jni_CSNodeStyleSetFlexDirection(this.mNativePointer, criusFlexDirection.intValue());
        }
    }

    public void setFlexGrow(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048635, this, f) == null) {
            jni_CSNodeStyleSetFlexGrow(this.mNativePointer, f);
        }
    }

    public void setFlexShrink(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048636, this, f) == null) {
            jni_CSNodeStyleSetFlexShrink(this.mNativePointer, f);
        }
    }

    public void setHeight(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048637, this, f) == null) {
            jni_CSNodeStyleSetHeight(this.mNativePointer, f);
        }
    }

    public void setHeightPercent(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048639, this, f) == null) {
            jni_CSNodeStyleSetHeightPercent(this.mNativePointer, f);
        }
    }

    public void setJustifyContent(CriusJustify criusJustify) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, criusJustify) == null) {
            jni_CSNodeStyleSetJustifyContent(this.mNativePointer, criusJustify.intValue());
        }
    }

    public void setMarginAuto(CriusEdge criusEdge) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, criusEdge) == null) {
            this.mEdgeSetFlag |= 1;
            jni_CSNodeStyleSetMarginAuto(this.mNativePointer, criusEdge.intValue());
        }
    }

    public void setMaxHeight(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048644, this, f) == null) {
            jni_CSNodeStyleSetMaxHeight(this.mNativePointer, f);
        }
    }

    public void setMaxHeightPercent(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048645, this, f) == null) {
            jni_CSNodeStyleSetMaxHeightPercent(this.mNativePointer, f);
        }
    }

    public void setMaxWidth(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048646, this, f) == null) {
            jni_CSNodeStyleSetMaxWidth(this.mNativePointer, f);
        }
    }

    public void setMaxWidthPercent(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048647, this, f) == null) {
            jni_CSNodeStyleSetMaxWidthPercent(this.mNativePointer, f);
        }
    }

    public void setMeasureFunction(CriusMeasureFunction criusMeasureFunction) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, criusMeasureFunction) == null) {
            this.mMeasureFunction = criusMeasureFunction;
            long j = this.mNativePointer;
            if (criusMeasureFunction != null) {
                z = true;
            } else {
                z = false;
            }
            jni_CSNodeSetHasMeasureFunc(j, z);
        }
    }

    public void setMinHeight(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048649, this, f) == null) {
            jni_CSNodeStyleSetMinHeight(this.mNativePointer, f);
        }
    }

    public void setMinHeightPercent(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048650, this, f) == null) {
            jni_CSNodeStyleSetMinHeightPercent(this.mNativePointer, f);
        }
    }

    public void setMinWidth(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048651, this, f) == null) {
            jni_CSNodeStyleSetMinWidth(this.mNativePointer, f);
        }
    }

    public void setMinWidthPercent(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048652, this, f) == null) {
            jni_CSNodeStyleSetMinWidthPercent(this.mNativePointer, f);
        }
    }

    public void setOverflow(CriusOverflow criusOverflow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, criusOverflow) == null) {
            jni_CSNodeStyleSetOverflow(this.mNativePointer, criusOverflow.intValue());
        }
    }

    public void setPositionType(CriusPositionType criusPositionType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, criusPositionType) == null) {
            jni_CSNodeStyleSetPositionType(this.mNativePointer, criusPositionType.intValue());
        }
    }

    public void setWidth(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048659, this, f) == null) {
            jni_CSNodeStyleSetWidth(this.mNativePointer, f);
        }
    }

    public void setWidthPercent(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048661, this, f) == null) {
            jni_CSNodeStyleSetWidthPercent(this.mNativePointer, f);
        }
    }

    public void setWrap(CriusWrap criusWrap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, criusWrap) == null) {
            jni_CSNodeStyleSetFlexWrap(this.mNativePointer, criusWrap.intValue());
        }
    }

    public void dirty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            jni_CSNodeMarkDirty(this.mNativePointer);
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                jni_CSNodeFree(this.mNativePointer);
            } finally {
                super.finalize();
            }
        }
    }

    public CriusAlign getAlignContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return CriusAlign.fromInt(jni_CSNodeStyleGetAlignContent(this.mNativePointer));
        }
        return (CriusAlign) invokeV.objValue;
    }

    public CriusAlign getAlignItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return CriusAlign.fromInt(jni_CSNodeStyleGetAlignItems(this.mNativePointer));
        }
        return (CriusAlign) invokeV.objValue;
    }

    public CriusAlign getAlignSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return CriusAlign.fromInt(jni_CSNodeStyleGetAlignSelf(this.mNativePointer));
        }
        return (CriusAlign) invokeV.objValue;
    }

    public float getAspectRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return jni_CSNodeStyleGetAspectRatio(this.mNativePointer);
        }
        return invokeV.floatValue;
    }

    public int getChildCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            List<CriusNode> list = this.mChildren;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public Object getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mData;
        }
        return invokeV.objValue;
    }

    public CriusDisplay getDisplay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return CriusDisplay.fromInt(jni_CSNodeStyleGetDisplay(this.mNativePointer));
        }
        return (CriusDisplay) invokeV.objValue;
    }

    public CriusValue getFlexBasis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return (CriusValue) jni_CSNodeStyleGetFlexBasis(this.mNativePointer);
        }
        return (CriusValue) invokeV.objValue;
    }

    public CriusFlexDirection getFlexDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return CriusFlexDirection.fromInt(jni_CSNodeStyleGetFlexDirection(this.mNativePointer));
        }
        return (CriusFlexDirection) invokeV.objValue;
    }

    public float getFlexGrow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return jni_CSNodeStyleGetFlexGrow(this.mNativePointer);
        }
        return invokeV.floatValue;
    }

    public float getFlexShrink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return jni_CSNodeStyleGetFlexShrink(this.mNativePointer);
        }
        return invokeV.floatValue;
    }

    public CriusValue getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return (CriusValue) jni_CSNodeStyleGetHeight(this.mNativePointer);
        }
        return (CriusValue) invokeV.objValue;
    }

    public CriusJustify getJustifyContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return CriusJustify.fromInt(jni_CSNodeStyleGetJustifyContent(this.mNativePointer));
        }
        return (CriusJustify) invokeV.objValue;
    }

    public float getLayoutHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mHeight;
        }
        return invokeV.floatValue;
    }

    public float getLayoutWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mWidth;
        }
        return invokeV.floatValue;
    }

    public float getLayoutX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.mLeft;
        }
        return invokeV.floatValue;
    }

    public float getLayoutY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mTop;
        }
        return invokeV.floatValue;
    }

    public CriusValue getMaxHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return (CriusValue) jni_CSNodeStyleGetMaxHeight(this.mNativePointer);
        }
        return (CriusValue) invokeV.objValue;
    }

    public CriusValue getMaxWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return (CriusValue) jni_CSNodeStyleGetMaxWidth(this.mNativePointer);
        }
        return (CriusValue) invokeV.objValue;
    }

    public CriusValue getMinHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return (CriusValue) jni_CSNodeStyleGetMinHeight(this.mNativePointer);
        }
        return (CriusValue) invokeV.objValue;
    }

    public CriusValue getMinWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return (CriusValue) jni_CSNodeStyleGetMinWidth(this.mNativePointer);
        }
        return (CriusValue) invokeV.objValue;
    }

    public CriusOverflow getOverflow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return CriusOverflow.fromInt(jni_CSNodeStyleGetOverflow(this.mNativePointer));
        }
        return (CriusOverflow) invokeV.objValue;
    }

    public CriusNode getParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.mParent;
        }
        return (CriusNode) invokeV.objValue;
    }

    public CriusPositionType getPositionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return CriusPositionType.fromInt(jni_CSNodeStyleGetPositionType(this.mNativePointer));
        }
        return (CriusPositionType) invokeV.objValue;
    }

    public CriusValue getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return (CriusValue) jni_CSNodeStyleGetWidth(this.mNativePointer);
        }
        return (CriusValue) invokeV.objValue;
    }

    public boolean hasNewLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.mHasNewLayout;
        }
        return invokeV.booleanValue;
    }

    public boolean isDirty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return jni_CSNodeIsDirty(this.mNativePointer);
        }
        return invokeV.booleanValue;
    }

    public boolean isMeasureDefined() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.mMeasureFunction != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void markLayoutSeen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.mHasNewLayout = false;
        }
    }

    public void setFlexBasisAuto() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            jni_CSNodeStyleSetFlexBasisAuto(this.mNativePointer);
        }
    }

    public void setHeightAuto() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            jni_CSNodeStyleSetHeightAuto(this.mNativePointer);
        }
    }

    public void setWidthAuto() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            jni_CSNodeStyleSetWidthAuto(this.mNativePointer);
        }
    }

    public float getLayoutBorder(CriusEdge criusEdge) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, criusEdge)) == null) {
            int i = AnonymousClass1.$SwitchMap$com$baidu$crius$CriusEdge[criusEdge.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (!CriusConstants.DEBUG) {
                                return this.mBorderLeft;
                            }
                            throw new IllegalArgumentException("Cannot get layout border of multi-edge shorthands");
                        }
                        return this.mBorderBottom;
                    }
                    return this.mBorderRight;
                }
                return this.mBorderTop;
            }
            return this.mBorderLeft;
        }
        return invokeL.floatValue;
    }

    public float getLayoutMargin(CriusEdge criusEdge) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, criusEdge)) == null) {
            int i = AnonymousClass1.$SwitchMap$com$baidu$crius$CriusEdge[criusEdge.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (!CriusConstants.DEBUG) {
                                return this.mMarginLeft;
                            }
                            throw new IllegalArgumentException("Cannot get layout margins of multi-edge shorthands");
                        }
                        return this.mMarginBottom;
                    }
                    return this.mMarginRight;
                }
                return this.mMarginTop;
            }
            return this.mMarginLeft;
        }
        return invokeL.floatValue;
    }

    public float getLayoutPadding(CriusEdge criusEdge) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, criusEdge)) == null) {
            int i = AnonymousClass1.$SwitchMap$com$baidu$crius$CriusEdge[criusEdge.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (!CriusConstants.DEBUG) {
                                return this.mPaddingLeft;
                            }
                            throw new IllegalArgumentException("Cannot get layout paddings of multi-edge shorthands");
                        }
                        return this.mPaddingBottom;
                    }
                    return this.mPaddingRight;
                }
                return this.mPaddingTop;
            }
            return this.mPaddingLeft;
        }
        return invokeL.floatValue;
    }

    @DoNotStrip
    public final long measure(float f, int i, float f2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048619, this, new Object[]{Float.valueOf(f), Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)})) == null) {
            if (!isMeasureDefined() && CriusConstants.DEBUG) {
                throw new RuntimeException("Measure function isn't defined!");
            }
            return this.mMeasureFunction.measure(this, f, CriusMeasureMode.fromInt(i), f2, CriusMeasureMode.fromInt(i2));
        }
        return invokeCommon.longValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.mEdgeSetFlag = 0;
            this.mHasSetPosition = false;
            this.mHasNewLayout = true;
            this.mWidth = Float.NaN;
            this.mHeight = Float.NaN;
            this.mTop = Float.NaN;
            this.mLeft = Float.NaN;
            this.mMarginLeft = 0.0f;
            this.mMarginTop = 0.0f;
            this.mMarginRight = 0.0f;
            this.mMarginBottom = 0.0f;
            this.mPaddingLeft = 0.0f;
            this.mPaddingTop = 0.0f;
            this.mPaddingRight = 0.0f;
            this.mPaddingBottom = 0.0f;
            this.mBorderLeft = 0.0f;
            this.mBorderTop = 0.0f;
            this.mBorderRight = 0.0f;
            this.mBorderBottom = 0.0f;
            this.mMeasureFunction = null;
            this.mData = null;
            jni_CSNodeReset(this.mNativePointer);
        }
    }
}

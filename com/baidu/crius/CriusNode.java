package com.baidu.crius;

import com.baidu.crius.proguard.annotations.DoNotStrip;
import java.util.ArrayList;
import java.util.List;
@DoNotStrip
/* loaded from: classes13.dex */
public class CriusNode {
    private static final int BORDER = 4;
    private static final int MARGIN = 1;
    private static final int PADDING = 2;
    @DoNotStrip
    private float mBorderBottom;
    @DoNotStrip
    private float mBorderLeft;
    @DoNotStrip
    private float mBorderRight;
    @DoNotStrip
    private float mBorderTop;
    private List<CriusNode> mChildren;
    private Object mData;
    @DoNotStrip
    private int mEdgeSetFlag;
    @DoNotStrip
    private boolean mHasNewLayout;
    private boolean mHasSetPosition;
    @DoNotStrip
    private float mHeight;
    @DoNotStrip
    private float mLeft;
    @DoNotStrip
    private float mMarginBottom;
    @DoNotStrip
    private float mMarginLeft;
    @DoNotStrip
    private float mMarginRight;
    @DoNotStrip
    private float mMarginTop;
    private CriusMeasureFunction mMeasureFunction;
    private long mNativePointer;
    @DoNotStrip
    private float mPaddingBottom;
    @DoNotStrip
    private float mPaddingLeft;
    @DoNotStrip
    private float mPaddingRight;
    @DoNotStrip
    private float mPaddingTop;
    private CriusNode mParent;
    @DoNotStrip
    private float mTop;
    @DoNotStrip
    private float mWidth;

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

    static {
        System.loadLibrary("criusbase");
        System.loadLibrary("crius");
    }

    public CriusNode() {
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
        this.mNativePointer = jni_CSNodeNew();
        if (this.mNativePointer == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
    }

    public CriusNode(CriusConfig criusConfig) {
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
        this.mNativePointer = jni_CSNodeNewWithConfig(criusConfig.mNativePointer);
        if (this.mNativePointer == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
    }

    protected void finalize() throws Throwable {
        try {
            jni_CSNodeFree(this.mNativePointer);
        } finally {
            super.finalize();
        }
    }

    public void reset() {
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

    public int getChildCount() {
        if (this.mChildren == null) {
            return 0;
        }
        return this.mChildren.size();
    }

    public CriusNode getChildAt(int i) {
        return this.mChildren.get(i);
    }

    public void addChildAt(CriusNode criusNode, int i) {
        if (criusNode.mParent != null) {
            throw new IllegalStateException("Child already has a parent, it must be removed first.");
        }
        if (this.mChildren == null) {
            this.mChildren = new ArrayList(4);
        }
        this.mChildren.add(i, criusNode);
        criusNode.mParent = this;
        jni_CSNodeInsertChild(this.mNativePointer, criusNode.mNativePointer, i);
    }

    public CriusNode removeChildAt(int i) {
        CriusNode remove = this.mChildren.remove(i);
        remove.mParent = null;
        jni_CSNodeRemoveChild(this.mNativePointer, remove.mNativePointer);
        return remove;
    }

    CriusNode getParent() {
        return this.mParent;
    }

    public int indexOf(CriusNode criusNode) {
        if (this.mChildren == null) {
            return -1;
        }
        return this.mChildren.indexOf(criusNode);
    }

    public void calculateLayout(float f, float f2) {
        jni_CSNodeCalculateLayout(this.mNativePointer, f, f2);
    }

    public boolean hasNewLayout() {
        return this.mHasNewLayout;
    }

    public void dirty() {
        jni_CSNodeMarkDirty(this.mNativePointer);
    }

    public boolean isDirty() {
        return jni_CSNodeIsDirty(this.mNativePointer);
    }

    public void copyStyle(CriusNode criusNode) {
        jni_CSNodeCopyStyle(this.mNativePointer, criusNode.mNativePointer);
    }

    public void markLayoutSeen() {
        this.mHasNewLayout = false;
    }

    public void setDirection(CriusDirection criusDirection) {
    }

    public CriusFlexDirection getFlexDirection() {
        return CriusFlexDirection.fromInt(jni_CSNodeStyleGetFlexDirection(this.mNativePointer));
    }

    public void setFlexDirection(CriusFlexDirection criusFlexDirection) {
        jni_CSNodeStyleSetFlexDirection(this.mNativePointer, criusFlexDirection.intValue());
    }

    public CriusJustify getJustifyContent() {
        return CriusJustify.fromInt(jni_CSNodeStyleGetJustifyContent(this.mNativePointer));
    }

    public void setJustifyContent(CriusJustify criusJustify) {
        jni_CSNodeStyleSetJustifyContent(this.mNativePointer, criusJustify.intValue());
    }

    public CriusAlign getAlignItems() {
        return CriusAlign.fromInt(jni_CSNodeStyleGetAlignItems(this.mNativePointer));
    }

    public void setAlignItems(CriusAlign criusAlign) {
        jni_CSNodeStyleSetAlignItems(this.mNativePointer, criusAlign.intValue());
    }

    public CriusAlign getAlignSelf() {
        return CriusAlign.fromInt(jni_CSNodeStyleGetAlignSelf(this.mNativePointer));
    }

    public void setAlignSelf(CriusAlign criusAlign) {
        jni_CSNodeStyleSetAlignSelf(this.mNativePointer, criusAlign.intValue());
    }

    public CriusAlign getAlignContent() {
        return CriusAlign.fromInt(jni_CSNodeStyleGetAlignContent(this.mNativePointer));
    }

    public void setAlignContent(CriusAlign criusAlign) {
        jni_CSNodeStyleSetAlignContent(this.mNativePointer, criusAlign.intValue());
    }

    public CriusPositionType getPositionType() {
        return CriusPositionType.fromInt(jni_CSNodeStyleGetPositionType(this.mNativePointer));
    }

    public void setPositionType(CriusPositionType criusPositionType) {
        jni_CSNodeStyleSetPositionType(this.mNativePointer, criusPositionType.intValue());
    }

    public void setWrap(CriusWrap criusWrap) {
        jni_CSNodeStyleSetFlexWrap(this.mNativePointer, criusWrap.intValue());
    }

    public CriusOverflow getOverflow() {
        return CriusOverflow.fromInt(jni_CSNodeStyleGetOverflow(this.mNativePointer));
    }

    public void setOverflow(CriusOverflow criusOverflow) {
        jni_CSNodeStyleSetOverflow(this.mNativePointer, criusOverflow.intValue());
    }

    public CriusDisplay getDisplay() {
        return CriusDisplay.fromInt(jni_CSNodeStyleGetDisplay(this.mNativePointer));
    }

    public void setDisplay(CriusDisplay criusDisplay) {
        jni_CSNodeStyleSetDisplay(this.mNativePointer, criusDisplay.intValue());
    }

    public void setFlex(float f) {
        jni_CSNodeStyleSetFlex(this.mNativePointer, f);
    }

    public float getFlexGrow() {
        return jni_CSNodeStyleGetFlexGrow(this.mNativePointer);
    }

    public void setFlexGrow(float f) {
        jni_CSNodeStyleSetFlexGrow(this.mNativePointer, f);
    }

    public float getFlexShrink() {
        return jni_CSNodeStyleGetFlexShrink(this.mNativePointer);
    }

    public void setFlexShrink(float f) {
        jni_CSNodeStyleSetFlexShrink(this.mNativePointer, f);
    }

    public CriusValue getFlexBasis() {
        return (CriusValue) jni_CSNodeStyleGetFlexBasis(this.mNativePointer);
    }

    public void setFlexBasis(float f) {
        jni_CSNodeStyleSetFlexBasis(this.mNativePointer, f);
    }

    public void setFlexBasisPercent(float f) {
        jni_CSNodeStyleSetFlexBasisPercent(this.mNativePointer, f);
    }

    public void setFlexBasisAuto() {
        jni_CSNodeStyleSetFlexBasisAuto(this.mNativePointer);
    }

    public CriusValue getMargin(CriusEdge criusEdge) {
        return (this.mEdgeSetFlag & 1) != 1 ? CriusValue.UNDEFINED : (CriusValue) jni_CSNodeStyleGetMargin(this.mNativePointer, criusEdge.intValue());
    }

    public void setMargin(CriusEdge criusEdge, float f) {
        this.mEdgeSetFlag |= 1;
        jni_CSNodeStyleSetMargin(this.mNativePointer, criusEdge.intValue(), f);
    }

    public void setMarginPercent(CriusEdge criusEdge, float f) {
        this.mEdgeSetFlag |= 1;
        jni_CSNodeStyleSetMarginPercent(this.mNativePointer, criusEdge.intValue(), f);
    }

    public void setMarginAuto(CriusEdge criusEdge) {
        this.mEdgeSetFlag |= 1;
        jni_CSNodeStyleSetMarginAuto(this.mNativePointer, criusEdge.intValue());
    }

    public CriusValue getPadding(CriusEdge criusEdge) {
        return (this.mEdgeSetFlag & 2) != 2 ? CriusValue.UNDEFINED : (CriusValue) jni_CSNodeStyleGetPadding(this.mNativePointer, criusEdge.intValue());
    }

    public void setPadding(CriusEdge criusEdge, float f) {
        this.mEdgeSetFlag |= 2;
        jni_CSNodeStyleSetPadding(this.mNativePointer, criusEdge.intValue(), f);
    }

    public void setPaddingPercent(CriusEdge criusEdge, float f) {
        this.mEdgeSetFlag |= 2;
        jni_CSNodeStyleSetPaddingPercent(this.mNativePointer, criusEdge.intValue(), f);
    }

    public float getBorder(CriusEdge criusEdge) {
        if ((this.mEdgeSetFlag & 4) != 4) {
            return Float.NaN;
        }
        return jni_CSNodeStyleGetBorder(this.mNativePointer, criusEdge.intValue());
    }

    public void setBorder(CriusEdge criusEdge, float f) {
        this.mEdgeSetFlag |= 4;
        jni_CSNodeStyleSetBorder(this.mNativePointer, criusEdge.intValue(), f);
    }

    public CriusValue getPosition(CriusEdge criusEdge) {
        return !this.mHasSetPosition ? CriusValue.UNDEFINED : (CriusValue) jni_CSNodeStyleGetPosition(this.mNativePointer, criusEdge.intValue());
    }

    public void setPosition(CriusEdge criusEdge, float f) {
        this.mHasSetPosition = true;
        jni_CSNodeStyleSetPosition(this.mNativePointer, criusEdge.intValue(), f);
    }

    public void setPositionPercent(CriusEdge criusEdge, float f) {
        this.mHasSetPosition = true;
        jni_CSNodeStyleSetPositionPercent(this.mNativePointer, criusEdge.intValue(), f);
    }

    public CriusValue getWidth() {
        return (CriusValue) jni_CSNodeStyleGetWidth(this.mNativePointer);
    }

    public void setWidth(float f) {
        jni_CSNodeStyleSetWidth(this.mNativePointer, f);
    }

    public void setWidthPercent(float f) {
        jni_CSNodeStyleSetWidthPercent(this.mNativePointer, f);
    }

    public void setWidthAuto() {
        jni_CSNodeStyleSetWidthAuto(this.mNativePointer);
    }

    public CriusValue getHeight() {
        return (CriusValue) jni_CSNodeStyleGetHeight(this.mNativePointer);
    }

    public void setHeight(float f) {
        jni_CSNodeStyleSetHeight(this.mNativePointer, f);
    }

    public void setHeightPercent(float f) {
        jni_CSNodeStyleSetHeightPercent(this.mNativePointer, f);
    }

    public void setHeightAuto() {
        jni_CSNodeStyleSetHeightAuto(this.mNativePointer);
    }

    public CriusValue getMinWidth() {
        return (CriusValue) jni_CSNodeStyleGetMinWidth(this.mNativePointer);
    }

    public void setMinWidth(float f) {
        jni_CSNodeStyleSetMinWidth(this.mNativePointer, f);
    }

    public void setMinWidthPercent(float f) {
        jni_CSNodeStyleSetMinWidthPercent(this.mNativePointer, f);
    }

    public CriusValue getMinHeight() {
        return (CriusValue) jni_CSNodeStyleGetMinHeight(this.mNativePointer);
    }

    public void setMinHeight(float f) {
        jni_CSNodeStyleSetMinHeight(this.mNativePointer, f);
    }

    public void setMinHeightPercent(float f) {
        jni_CSNodeStyleSetMinHeightPercent(this.mNativePointer, f);
    }

    public CriusValue getMaxWidth() {
        return (CriusValue) jni_CSNodeStyleGetMaxWidth(this.mNativePointer);
    }

    public void setMaxWidth(float f) {
        jni_CSNodeStyleSetMaxWidth(this.mNativePointer, f);
    }

    public void setMaxWidthPercent(float f) {
        jni_CSNodeStyleSetMaxWidthPercent(this.mNativePointer, f);
    }

    public CriusValue getMaxHeight() {
        return (CriusValue) jni_CSNodeStyleGetMaxHeight(this.mNativePointer);
    }

    public void setMaxHeight(float f) {
        jni_CSNodeStyleSetMaxHeight(this.mNativePointer, f);
    }

    public void setMaxHeightPercent(float f) {
        jni_CSNodeStyleSetMaxHeightPercent(this.mNativePointer, f);
    }

    public float getAspectRatio() {
        return jni_CSNodeStyleGetAspectRatio(this.mNativePointer);
    }

    public void setAspectRatio(float f) {
        jni_CSNodeStyleSetAspectRatio(this.mNativePointer, f);
    }

    public float getLayoutX() {
        return this.mLeft;
    }

    public float getLayoutY() {
        return this.mTop;
    }

    public float getLayoutWidth() {
        return this.mWidth;
    }

    public float getLayoutHeight() {
        return this.mHeight;
    }

    public float getLayoutMargin(CriusEdge criusEdge) {
        switch (criusEdge) {
            case LEFT:
                return this.mMarginLeft;
            case TOP:
                return this.mMarginTop;
            case RIGHT:
                return this.mMarginRight;
            case BOTTOM:
                return this.mMarginBottom;
            default:
                throw new IllegalArgumentException("Cannot get layout margins of multi-edge shorthands");
        }
    }

    public float getLayoutPadding(CriusEdge criusEdge) {
        switch (criusEdge) {
            case LEFT:
                return this.mPaddingLeft;
            case TOP:
                return this.mPaddingTop;
            case RIGHT:
                return this.mPaddingRight;
            case BOTTOM:
                return this.mPaddingBottom;
            default:
                throw new IllegalArgumentException("Cannot get layout paddings of multi-edge shorthands");
        }
    }

    public float getLayoutBorder(CriusEdge criusEdge) {
        switch (criusEdge) {
            case LEFT:
                return this.mBorderLeft;
            case TOP:
                return this.mBorderTop;
            case RIGHT:
                return this.mBorderRight;
            case BOTTOM:
                return this.mBorderBottom;
            default:
                throw new IllegalArgumentException("Cannot get layout border of multi-edge shorthands");
        }
    }

    public void setMeasureFunction(CriusMeasureFunction criusMeasureFunction) {
        this.mMeasureFunction = criusMeasureFunction;
        jni_CSNodeSetHasMeasureFunc(this.mNativePointer, criusMeasureFunction != null);
    }

    @DoNotStrip
    public final long measure(float f, int i, float f2, int i2) {
        if (!isMeasureDefined()) {
            throw new RuntimeException("Measure function isn't defined!");
        }
        return this.mMeasureFunction.measure(this, f, CriusMeasureMode.fromInt(i), f2, CriusMeasureMode.fromInt(i2));
    }

    public boolean isMeasureDefined() {
        return this.mMeasureFunction != null;
    }

    public void setData(Object obj) {
        this.mData = obj;
    }

    public Object getData() {
        return this.mData;
    }
}

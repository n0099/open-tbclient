package com.baidu.searchbox.crius.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.crius.CriusAlign;
import com.baidu.crius.CriusDirection;
import com.baidu.crius.CriusDisplay;
import com.baidu.crius.CriusEdge;
import com.baidu.crius.CriusFlexDirection;
import com.baidu.crius.CriusJustify;
import com.baidu.crius.CriusMeasureFunction;
import com.baidu.crius.CriusMeasureMode;
import com.baidu.crius.CriusMeasureOutput;
import com.baidu.crius.CriusNode;
import com.baidu.crius.CriusOverflow;
import com.baidu.crius.CriusPositionType;
import com.baidu.crius.CriusWrap;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.crius.R;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.parser.CriusDataFactory;
import com.baidu.searchbox.crius.render.OpacityController;
import com.baidu.searchbox.crius.ui.IOpacitySupport;
import com.baidu.searchbox.crius.ui.recycler.CriusRecyclerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class CriusLayout extends ViewGroup implements IOpacitySupport {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CriusLayout";
    public transient /* synthetic */ FieldHolder $fh;
    public CriusData mCriusData;
    public Map mCriusDatas;
    public OpacityController mOpacityController;

    /* loaded from: classes2.dex */
    public class LayoutParams extends ViewGroup.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseArray numericAttributes;
        public SparseArray stringAttributes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.numericAttributes = new SparseArray();
            this.stringAttributes = new SparseArray();
            if (i >= 0) {
                this.numericAttributes.put(55, Float.valueOf(i));
            }
            if (i2 >= 0) {
                this.numericAttributes.put(20, Float.valueOf(i2));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.numericAttributes = new SparseArray();
            this.stringAttributes = new SparseArray();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.crius);
            int i3 = ((ViewGroup.LayoutParams) this).width;
            if (i3 >= 0) {
                this.numericAttributes.put(55, Float.valueOf(i3));
            }
            int i4 = ((ViewGroup.LayoutParams) this).height;
            if (i4 >= 0) {
                this.numericAttributes.put(20, Float.valueOf(i4));
            }
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                TypedValue typedValue = new TypedValue();
                obtainStyledAttributes.getValue(index, typedValue);
                int i6 = typedValue.type;
                if (i6 == 5) {
                    this.numericAttributes.put(index, Float.valueOf(obtainStyledAttributes.getDimensionPixelSize(index, 0)));
                } else if (i6 == 3) {
                    this.stringAttributes.put(index, obtainStyledAttributes.getString(index));
                } else {
                    this.numericAttributes.put(index, Float.valueOf(obtainStyledAttributes.getFloat(index, 0.0f)));
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                this.numericAttributes = layoutParams2.numericAttributes.clone();
                this.stringAttributes = layoutParams2.stringAttributes.clone();
            } else {
                this.numericAttributes = new SparseArray();
                this.stringAttributes = new SparseArray();
            }
            if (layoutParams.width >= 0) {
                this.numericAttributes.put(55, Float.valueOf(((ViewGroup.LayoutParams) this).width));
            }
            if (layoutParams.height >= 0) {
                this.numericAttributes.put(20, Float.valueOf(((ViewGroup.LayoutParams) this).height));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class ViewMeasureFunction implements CriusMeasureFunction {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ViewMeasureFunction() {
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

        private int viewMeasureSpecFromCriusMeasureMode(CriusMeasureMode criusMeasureMode) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, criusMeasureMode)) == null) {
                if (criusMeasureMode == CriusMeasureMode.AT_MOST) {
                    return Integer.MIN_VALUE;
                }
                if (criusMeasureMode == CriusMeasureMode.EXACTLY) {
                    return 1073741824;
                }
                return 0;
            }
            return invokeL.intValue;
        }

        @Override // com.baidu.crius.CriusMeasureFunction
        public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{criusNode, Float.valueOf(f), criusMeasureMode, Float.valueOf(f2), criusMeasureMode2})) == null) {
                View view2 = (View) criusNode.getData();
                if (AppConfig.isDebug()) {
                    Log.d(CriusLayout.TAG, "#ViewMeasureFunction# view: " + view2 + ", width=" + f + " height=" + f2);
                }
                if (view2 != null && !(view2 instanceof CriusLayout)) {
                    view2.measure(View.MeasureSpec.makeMeasureSpec((int) f, viewMeasureSpecFromCriusMeasureMode(criusMeasureMode)), View.MeasureSpec.makeMeasureSpec((int) f2, viewMeasureSpecFromCriusMeasureMode(criusMeasureMode2)));
                    int measuredWidth = view2.getMeasuredWidth();
                    int measuredHeight = view2.getMeasuredHeight();
                    if (AppConfig.isDebug()) {
                        Log.d(CriusLayout.TAG, "#ViewMeasureFunction# measuredWidth=" + measuredWidth + ", measuredHeight=" + measuredHeight);
                    }
                    return CriusMeasureOutput.make(measuredWidth, measuredHeight);
                }
                return CriusMeasureOutput.make(0, 0);
            }
            return invokeCommon.longValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CriusLayout(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void invalidate(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            if (this.mCriusDatas.containsKey(view2)) {
                ((CriusData) this.mCriusDatas.get(view2)).criusNode.dirty();
                return;
            }
            int childCount = this.mCriusData.getChildCount();
            for (int i = 0; i < childCount; i++) {
                CriusData childAt = this.mCriusData.getChildAt(i);
                if (childAt.criusNode.getData() instanceof CriusLayout) {
                    ((CriusLayout) childAt.criusNode.getData()).invalidate(view2);
                }
            }
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CriusLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void calculateLayout(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65542, this, i, i2) == null) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == 1073741824) {
                this.mCriusData.criusNode.setHeight(size2);
            }
            if (mode == 1073741824) {
                this.mCriusData.criusNode.setWidth(size);
            }
            if (mode2 == Integer.MIN_VALUE) {
                this.mCriusData.criusNode.setMaxHeight(size2);
            }
            if (mode == Integer.MIN_VALUE) {
                this.mCriusData.criusNode.setMaxWidth(size);
            }
            this.mCriusData.criusNode.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CriusLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        CriusData create = CriusDataFactory.create(context, this);
        this.mCriusData = create;
        create.criusNode.setData(this);
        this.mCriusData.criusNode.setMeasureFunction(new ViewMeasureFunction());
        this.mCriusDatas = new HashMap();
        if (attributeSet != null) {
            layoutParams = new LayoutParams(context, attributeSet);
        } else {
            layoutParams = (LayoutParams) generateDefaultLayoutParams();
        }
        applyLayoutParams(layoutParams, this.mCriusData.criusNode, this);
    }

    private void applyLayoutRecursive(CriusData criusData, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{criusData, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            CriusNode criusNode = criusData.criusNode;
            View view2 = (View) criusNode.getData();
            if (view2 != null && view2 != this) {
                criusData.getUI().layout(f, f2);
            }
            int childCount = criusData.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (equals(view2)) {
                    applyLayoutRecursive(criusData.getChildAt(i), f, f2);
                } else if (!(view2 instanceof CriusLayout)) {
                    applyLayoutRecursive(criusData.getChildAt(i), criusNode.getLayoutX() + f, criusNode.getLayoutY() + f2);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CriusLayout(Context context, CriusData criusData) {
        super(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, criusData};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mCriusData = criusData;
        criusData.criusNode.setData(this);
        this.mCriusData.criusNode.setMeasureFunction(new ViewMeasureFunction());
        this.mCriusDatas = new HashMap();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            if (!(getParent() instanceof CriusLayout) && !(getParent() instanceof CriusRecyclerView)) {
                calculateLayout(i, i2);
            }
            setMeasuredDimension(Math.round(this.mCriusData.criusNode.getLayoutWidth()), Math.round(this.mCriusData.criusNode.getLayoutHeight()));
            if (AppConfig.isDebug()) {
                Log.d(TAG, "CriusLayout#onMeasure, width=" + getMeasuredWidth() + ", height=" + getMeasuredHeight() + StringUtil.ARRAY_ELEMENT_SEPARATOR + this);
            }
        }
    }

    public static void applyLayoutParams(LayoutParams layoutParams, CriusNode criusNode, View view2) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, layoutParams, criusNode, view2) == null) {
            Drawable background = view2.getBackground();
            if (background != null) {
                Rect rect = new Rect();
                if (background.getPadding(rect)) {
                    criusNode.setPadding(CriusEdge.LEFT, rect.left);
                    criusNode.setPadding(CriusEdge.TOP, rect.top);
                    criusNode.setPadding(CriusEdge.RIGHT, rect.right);
                    criusNode.setPadding(CriusEdge.BOTTOM, rect.bottom);
                }
            }
            if (layoutParams == null) {
                return;
            }
            int i3 = 0;
            while (true) {
                i = 20;
                i2 = 1;
                if (i3 >= layoutParams.numericAttributes.size()) {
                    break;
                }
                int keyAt = layoutParams.numericAttributes.keyAt(i3);
                float floatValue = ((Float) layoutParams.numericAttributes.valueAt(i3)).floatValue();
                if (keyAt == 0) {
                    criusNode.setAlignContent(CriusAlign.fromInt(Math.round(floatValue)));
                } else if (keyAt == 1) {
                    criusNode.setAlignItems(CriusAlign.fromInt(Math.round(floatValue)));
                } else if (keyAt == 2) {
                    criusNode.setAlignSelf(CriusAlign.fromInt(Math.round(floatValue)));
                } else if (keyAt == 3) {
                    criusNode.setAspectRatio(floatValue);
                } else if (keyAt == 8) {
                    criusNode.setBorder(CriusEdge.LEFT, floatValue);
                } else if (keyAt == 11) {
                    criusNode.setBorder(CriusEdge.TOP, floatValue);
                } else if (keyAt == 9) {
                    criusNode.setBorder(CriusEdge.RIGHT, floatValue);
                } else if (keyAt == 5) {
                    criusNode.setBorder(CriusEdge.BOTTOM, floatValue);
                } else if (keyAt == 7) {
                    criusNode.setBorder(CriusEdge.HORIZONTAL, floatValue);
                } else if (keyAt == 12) {
                    criusNode.setBorder(CriusEdge.VERTICAL, floatValue);
                } else if (keyAt == 4) {
                    criusNode.setBorder(CriusEdge.ALL, floatValue);
                } else if (keyAt == 13) {
                    criusNode.setDirection(CriusDirection.fromInt(Math.round(floatValue)));
                } else if (keyAt == 14) {
                    criusNode.setDisplay(CriusDisplay.fromInt(Math.round(floatValue)));
                } else if (keyAt == 15) {
                    criusNode.setFlex(floatValue);
                } else if (keyAt == 16) {
                    criusNode.setFlexBasis(floatValue);
                } else if (keyAt == 17) {
                    criusNode.setFlexDirection(CriusFlexDirection.fromInt(Math.round(floatValue)));
                } else if (keyAt == 18) {
                    criusNode.setFlexGrow(floatValue);
                } else if (keyAt == 19) {
                    criusNode.setFlexShrink(floatValue);
                } else if (keyAt == 20) {
                    criusNode.setHeight(floatValue);
                } else if (keyAt == 26) {
                    criusNode.setMargin(CriusEdge.LEFT, floatValue);
                } else if (keyAt == 21) {
                    criusNode.setJustifyContent(CriusJustify.fromInt(Math.round(floatValue)));
                } else if (keyAt == 29) {
                    criusNode.setMargin(CriusEdge.TOP, floatValue);
                } else if (keyAt == 27) {
                    criusNode.setMargin(CriusEdge.RIGHT, floatValue);
                } else if (keyAt == 23) {
                    criusNode.setMargin(CriusEdge.BOTTOM, floatValue);
                } else if (keyAt == 25) {
                    criusNode.setMargin(CriusEdge.HORIZONTAL, floatValue);
                } else if (keyAt == 30) {
                    criusNode.setMargin(CriusEdge.VERTICAL, floatValue);
                } else if (keyAt == 22) {
                    criusNode.setMargin(CriusEdge.ALL, floatValue);
                } else if (keyAt == 31) {
                    criusNode.setMaxHeight(floatValue);
                } else if (keyAt == 32) {
                    criusNode.setMaxWidth(floatValue);
                } else if (keyAt == 33) {
                    criusNode.setMinHeight(floatValue);
                } else if (keyAt == 34) {
                    criusNode.setMinWidth(floatValue);
                } else if (keyAt == 35) {
                    criusNode.setOverflow(CriusOverflow.fromInt(Math.round(floatValue)));
                } else if (keyAt == 40) {
                    criusNode.setPadding(CriusEdge.LEFT, floatValue);
                } else if (keyAt == 43) {
                    criusNode.setPadding(CriusEdge.TOP, floatValue);
                } else if (keyAt == 41) {
                    criusNode.setPadding(CriusEdge.RIGHT, floatValue);
                } else if (keyAt == 37) {
                    criusNode.setPadding(CriusEdge.BOTTOM, floatValue);
                } else if (keyAt == 39) {
                    criusNode.setPadding(CriusEdge.HORIZONTAL, floatValue);
                } else if (keyAt == 44) {
                    criusNode.setPadding(CriusEdge.VERTICAL, floatValue);
                } else if (keyAt == 36) {
                    criusNode.setPadding(CriusEdge.ALL, floatValue);
                } else if (keyAt == 49) {
                    criusNode.setPosition(CriusEdge.LEFT, floatValue);
                } else if (keyAt == 52) {
                    criusNode.setPosition(CriusEdge.TOP, floatValue);
                } else if (keyAt == 50) {
                    criusNode.setPosition(CriusEdge.RIGHT, floatValue);
                } else if (keyAt == 46) {
                    criusNode.setPosition(CriusEdge.BOTTOM, floatValue);
                } else if (keyAt == 48) {
                    criusNode.setPosition(CriusEdge.HORIZONTAL, floatValue);
                } else if (keyAt == 54) {
                    criusNode.setPosition(CriusEdge.VERTICAL, floatValue);
                } else if (keyAt == 45) {
                    criusNode.setPosition(CriusEdge.ALL, floatValue);
                } else if (keyAt == 53) {
                    criusNode.setPositionType(CriusPositionType.fromInt(Math.round(floatValue)));
                } else if (keyAt == 55) {
                    criusNode.setWidth(floatValue);
                } else if (keyAt == 56) {
                    criusNode.setWrap(CriusWrap.fromInt(Math.round(floatValue)));
                }
                i3++;
            }
            int i4 = 0;
            while (i4 < layoutParams.stringAttributes.size()) {
                int keyAt2 = layoutParams.stringAttributes.keyAt(i4);
                String str = (String) layoutParams.stringAttributes.valueAt(i4);
                if ("auto".equals(str)) {
                    if (keyAt2 == 26) {
                        criusNode.setMarginAuto(CriusEdge.LEFT);
                    } else if (keyAt2 == 29) {
                        criusNode.setMarginAuto(CriusEdge.TOP);
                    } else if (keyAt2 == 27) {
                        criusNode.setMarginAuto(CriusEdge.RIGHT);
                    } else if (keyAt2 == 23) {
                        criusNode.setMarginAuto(CriusEdge.BOTTOM);
                    } else if (keyAt2 == 25) {
                        criusNode.setMarginAuto(CriusEdge.HORIZONTAL);
                    } else if (keyAt2 == 30) {
                        criusNode.setMarginAuto(CriusEdge.VERTICAL);
                    } else if (keyAt2 == 22) {
                        criusNode.setMarginAuto(CriusEdge.ALL);
                    }
                }
                if (str.endsWith("%")) {
                    float parseFloat = Float.parseFloat(str.substring(0, str.length() - i2));
                    if (keyAt2 == 16) {
                        criusNode.setFlexBasisPercent(parseFloat);
                    } else if (keyAt2 == i) {
                        criusNode.setHeightPercent(parseFloat);
                    } else if (keyAt2 == 26) {
                        criusNode.setMarginPercent(CriusEdge.LEFT, parseFloat);
                    } else if (keyAt2 == 29) {
                        criusNode.setMarginPercent(CriusEdge.TOP, parseFloat);
                    } else if (keyAt2 == 27) {
                        criusNode.setMarginPercent(CriusEdge.RIGHT, parseFloat);
                    } else if (keyAt2 == 23) {
                        criusNode.setMarginPercent(CriusEdge.BOTTOM, parseFloat);
                    } else if (keyAt2 == 25) {
                        criusNode.setMarginPercent(CriusEdge.HORIZONTAL, parseFloat);
                    } else if (keyAt2 == 30) {
                        criusNode.setMarginPercent(CriusEdge.VERTICAL, parseFloat);
                    } else if (keyAt2 == 22) {
                        criusNode.setMarginPercent(CriusEdge.ALL, parseFloat);
                    } else {
                        if (keyAt2 == 31) {
                            criusNode.setMaxHeightPercent(parseFloat);
                        } else if (keyAt2 == 32) {
                            criusNode.setMaxWidthPercent(parseFloat);
                        } else if (keyAt2 == 33) {
                            criusNode.setMinHeightPercent(parseFloat);
                        } else if (keyAt2 == 34) {
                            criusNode.setMinWidthPercent(parseFloat);
                        } else if (keyAt2 == 40) {
                            criusNode.setPaddingPercent(CriusEdge.LEFT, parseFloat);
                        } else if (keyAt2 == 43) {
                            criusNode.setPaddingPercent(CriusEdge.TOP, parseFloat);
                        } else if (keyAt2 == 41) {
                            criusNode.setPaddingPercent(CriusEdge.RIGHT, parseFloat);
                        } else if (keyAt2 == 37) {
                            criusNode.setPaddingPercent(CriusEdge.BOTTOM, parseFloat);
                        } else if (keyAt2 == 39) {
                            criusNode.setPaddingPercent(CriusEdge.HORIZONTAL, parseFloat);
                        } else if (keyAt2 == 44) {
                            criusNode.setPaddingPercent(CriusEdge.VERTICAL, parseFloat);
                        } else if (keyAt2 == 36) {
                            criusNode.setPaddingPercent(CriusEdge.ALL, parseFloat);
                        } else if (keyAt2 == 49) {
                            criusNode.setPositionPercent(CriusEdge.LEFT, parseFloat);
                        } else if (keyAt2 == 52) {
                            criusNode.setPositionPercent(CriusEdge.TOP, parseFloat);
                        } else if (keyAt2 == 50) {
                            criusNode.setPositionPercent(CriusEdge.RIGHT, parseFloat);
                        } else if (keyAt2 == 46) {
                            criusNode.setPositionPercent(CriusEdge.BOTTOM, parseFloat);
                        } else if (keyAt2 == 48) {
                            criusNode.setPositionPercent(CriusEdge.HORIZONTAL, parseFloat);
                        } else if (keyAt2 == 54) {
                            criusNode.setPositionPercent(CriusEdge.VERTICAL, parseFloat);
                        } else if (keyAt2 == 45) {
                            criusNode.setPositionPercent(CriusEdge.ALL, parseFloat);
                        } else if (keyAt2 == 55) {
                            criusNode.setWidthPercent(parseFloat);
                        }
                        i4++;
                        i = 20;
                        i2 = 1;
                    }
                }
                i4++;
                i = 20;
                i2 = 1;
            }
        }
    }

    private void removeViewFromCriusTree(View view2, boolean z) {
        CriusData criusData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65543, this, view2, z) != null) || (criusData = (CriusData) this.mCriusDatas.get(view2)) == null) {
            return;
        }
        criusData.criusNode.setData(null);
        this.mCriusDatas.remove(view2);
        if (z) {
            this.mCriusData.criusNode.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    public void addView(View view2, CriusData criusData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, criusData) == null) {
            this.mCriusDatas.put(view2, criusData);
            addView(view2);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) {
            for (int i3 = i; i3 < i + i2; i3++) {
                removeViewFromCriusTree(getChildAt(i3), false);
            }
            super.removeViews(i, i2);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048594, this, i, i2) == null) {
            for (int i3 = i; i3 < i + i2; i3++) {
                removeViewFromCriusTree(getChildAt(i3), true);
            }
            super.removeViewsInLayout(i, i2);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        CriusData create;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, view2, i, layoutParams) == null) {
            this.mCriusData.criusNode.setMeasureFunction(null);
            if (view2 instanceof VirtualCriusLayout) {
                VirtualCriusLayout virtualCriusLayout = (VirtualCriusLayout) view2;
                virtualCriusLayout.transferChildren(this);
                if (!this.mCriusDatas.containsKey(view2)) {
                    CriusData criusData = virtualCriusLayout.getCriusData();
                    CriusData criusData2 = this.mCriusData;
                    criusData2.addChildAt(criusData, criusData2.getChildCount());
                    return;
                }
                return;
            }
            super.addView(view2, i, layoutParams);
            if (this.mCriusDatas.containsKey(view2)) {
                CriusData criusData3 = (CriusData) this.mCriusDatas.get(view2);
                applyLayoutParams((LayoutParams) view2.getLayoutParams(), criusData3.criusNode, view2);
                if (!(view2 instanceof CriusLayout) && !(view2 instanceof CriusRecyclerView)) {
                    if (AppConfig.isDebug()) {
                        Log.d(TAG, "CriusLayout, addView child setMeasureFunction : " + view2);
                    }
                    criusData3.criusNode.setData(view2);
                    criusData3.criusNode.setMeasureFunction(new ViewMeasureFunction());
                    return;
                }
                return;
            }
            if (view2 instanceof CriusLayout) {
                create = ((CriusLayout) view2).getCriusData();
            } else {
                if (this.mCriusDatas.containsKey(view2)) {
                    create = (CriusData) this.mCriusDatas.get(view2);
                } else {
                    create = CriusDataFactory.create(getContext(), view2);
                }
                create.criusNode.setData(view2);
                create.criusNode.setMeasureFunction(new ViewMeasureFunction());
            }
            applyLayoutParams((LayoutParams) view2.getLayoutParams(), create.criusNode, view2);
            this.mCriusDatas.put(view2, create);
            CriusData criusData4 = this.mCriusData;
            criusData4.addChildAt(create, criusData4.getChildCount());
        }
    }

    public void addView(View view2, int i, CriusData criusData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i, criusData) == null) {
            this.mCriusDatas.put(view2, criusData);
            addView(view2, i);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, layoutParams)) == null) {
            return layoutParams instanceof LayoutParams;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            super.dispatchSetPressed(z);
            OpacityController opacityController = this.mOpacityController;
            if (opacityController != null) {
                opacityController.updateOpacity(this, z);
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, attributeSet)) == null) {
            return new LayoutParams(getContext(), attributeSet);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            removeViewFromCriusTree(view2, false);
            super.removeView(view2);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            removeViewFromCriusTree(getChildAt(i), false);
            super.removeViewAt(i);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view2) == null) {
            removeViewFromCriusTree(view2, true);
            super.removeViewInLayout(view2);
        }
    }

    @Override // com.baidu.searchbox.crius.ui.IOpacitySupport
    public void setOpacityController(OpacityController opacityController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, opacityController) == null) {
            this.mOpacityController = opacityController;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new LayoutParams(-1, -1);
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    public CriusData getCriusData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mCriusData;
        }
        return (CriusData) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                removeViewFromCriusTree(getChildAt(i), false);
            }
            super.removeAllViews();
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                removeViewFromCriusTree(getChildAt(i), true);
            }
            super.removeAllViewsInLayout();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, layoutParams)) == null) {
            return new LayoutParams(layoutParams);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (!(getParent() instanceof CriusLayout) && !(getParent() instanceof CriusRecyclerView)) {
                this.mCriusData.criusNode.calculateLayout(Float.NaN, Float.NaN);
            }
            applyLayoutRecursive(this.mCriusData, 0.0f, 0.0f);
        }
    }
}

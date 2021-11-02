package androidx.constraintlayout.motion.widget;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Oscillator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.lang3.CharUtils;
/* loaded from: classes.dex */
public abstract class KeyCycleOscillator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "KeyCycleOscillator";
    public transient /* synthetic */ FieldHolder $fh;
    public CurveFit mCurveFit;
    public ConstraintAttribute mCustom;
    public CycleOscillator mCycleOscillator;
    public String mType;
    public int mVariesBy;
    public ArrayList<WavePoint> mWavePoints;
    public int mWaveShape;

    /* loaded from: classes.dex */
    public static class AlphaSet extends KeyCycleOscillator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public AlphaSet() {
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

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
                view.setAlpha(get(f2));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomSet extends KeyCycleOscillator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float[] value;

        public CustomSet() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = new float[1];
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
                this.value[0] = get(f2);
                this.mCustom.setInterpolatedValue(view, this.value);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CycleOscillator {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TAG = "CycleOscillator";
        public static final int UNSET = -1;
        public transient /* synthetic */ FieldHolder $fh;
        public CurveFit mCurveFit;
        public HashMap<String, ConstraintAttribute> mCustomConstraints;
        public float[] mOffset;
        public Oscillator mOscillator;
        public float mPathLength;
        public float[] mPeriod;
        public double[] mPosition;
        public float[] mScale;
        public double[] mSplineSlopeCache;
        public double[] mSplineValueCache;
        public float[] mValues;
        public final int mVariesBy;
        public int mWaveShape;

        public CycleOscillator(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mOscillator = new Oscillator();
            this.mCustomConstraints = new HashMap<>();
            this.mWaveShape = i2;
            this.mVariesBy = i3;
            this.mOscillator.setType(i2);
            this.mValues = new float[i4];
            this.mPosition = new double[i4];
            this.mPeriod = new float[i4];
            this.mOffset = new float[i4];
            this.mScale = new float[i4];
        }

        private ConstraintAttribute get(String str, ConstraintAttribute.AttributeType attributeType) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, attributeType)) == null) {
                if (this.mCustomConstraints.containsKey(str)) {
                    ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(str);
                    if (constraintAttribute.getType() == attributeType) {
                        return constraintAttribute;
                    }
                    throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute.getType().name());
                }
                ConstraintAttribute constraintAttribute2 = new ConstraintAttribute(str, attributeType);
                this.mCustomConstraints.put(str, constraintAttribute2);
                return constraintAttribute2;
            }
            return (ConstraintAttribute) invokeLL.objValue;
        }

        public double getSlope(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                CurveFit curveFit = this.mCurveFit;
                if (curveFit != null) {
                    double d2 = f2;
                    curveFit.getSlope(d2, this.mSplineSlopeCache);
                    this.mCurveFit.getPos(d2, this.mSplineValueCache);
                } else {
                    double[] dArr = this.mSplineSlopeCache;
                    dArr[0] = 0.0d;
                    dArr[1] = 0.0d;
                }
                double d3 = f2;
                double value = this.mOscillator.getValue(d3);
                double slope = this.mOscillator.getSlope(d3);
                double[] dArr2 = this.mSplineSlopeCache;
                return dArr2[0] + (value * dArr2[1]) + (slope * this.mSplineValueCache[1]);
            }
            return invokeF.doubleValue;
        }

        public double getValues(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) {
                CurveFit curveFit = this.mCurveFit;
                if (curveFit != null) {
                    curveFit.getPos(f2, this.mSplineValueCache);
                } else {
                    double[] dArr = this.mSplineValueCache;
                    dArr[0] = this.mOffset[0];
                    dArr[1] = this.mValues[0];
                }
                return this.mSplineValueCache[0] + (this.mOscillator.getValue(f2) * this.mSplineValueCache[1]);
            }
            return invokeF.doubleValue;
        }

        public void setPoint(int i2, int i3, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                this.mPosition[i2] = i3 / 100.0d;
                this.mPeriod[i2] = f2;
                this.mOffset[i2] = f3;
                this.mValues[i2] = f4;
            }
        }

        public void setup(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
                this.mPathLength = f2;
                double[][] dArr = (double[][]) Array.newInstance(double.class, this.mPosition.length, 2);
                float[] fArr = this.mValues;
                this.mSplineValueCache = new double[fArr.length + 1];
                this.mSplineSlopeCache = new double[fArr.length + 1];
                if (this.mPosition[0] > 0.0d) {
                    this.mOscillator.addPoint(0.0d, this.mPeriod[0]);
                }
                double[] dArr2 = this.mPosition;
                int length = dArr2.length - 1;
                if (dArr2[length] < 1.0d) {
                    this.mOscillator.addPoint(1.0d, this.mPeriod[length]);
                }
                for (int i2 = 0; i2 < dArr.length; i2++) {
                    dArr[i2][0] = this.mOffset[i2];
                    int i3 = 0;
                    while (true) {
                        float[] fArr2 = this.mValues;
                        if (i3 < fArr2.length) {
                            dArr[i3][1] = fArr2[i3];
                            i3++;
                        }
                    }
                    this.mOscillator.addPoint(this.mPosition[i2], this.mPeriod[i2]);
                }
                this.mOscillator.normalize();
                double[] dArr3 = this.mPosition;
                if (dArr3.length > 1) {
                    this.mCurveFit = CurveFit.get(0, dArr3, dArr);
                } else {
                    this.mCurveFit = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ElevationSet extends KeyCycleOscillator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ElevationSet() {
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

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) || Build.VERSION.SDK_INT < 21) {
                return;
            }
            view.setElevation(get(f2));
        }
    }

    /* loaded from: classes.dex */
    public static class IntDoubleSort {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public IntDoubleSort() {
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

        public static int partition(int[] iArr, float[] fArr, int i2, int i3) {
            InterceptResult invokeLLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65537, null, iArr, fArr, i2, i3)) == null) {
                int i4 = iArr[i3];
                int i5 = i2;
                while (i2 < i3) {
                    if (iArr[i2] <= i4) {
                        swap(iArr, fArr, i5, i2);
                        i5++;
                    }
                    i2++;
                }
                swap(iArr, fArr, i5, i3);
                return i5;
            }
            return invokeLLII.intValue;
        }

        public static void sort(int[] iArr, float[] fArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(65538, null, iArr, fArr, i2, i3) == null) {
                int[] iArr2 = new int[iArr.length + 10];
                iArr2[0] = i3;
                iArr2[1] = i2;
                int i4 = 2;
                while (i4 > 0) {
                    int i5 = i4 - 1;
                    int i6 = iArr2[i5];
                    i4 = i5 - 1;
                    int i7 = iArr2[i4];
                    if (i6 < i7) {
                        int partition = partition(iArr, fArr, i6, i7);
                        int i8 = i4 + 1;
                        iArr2[i4] = partition - 1;
                        int i9 = i8 + 1;
                        iArr2[i8] = i6;
                        int i10 = i9 + 1;
                        iArr2[i9] = i7;
                        i4 = i10 + 1;
                        iArr2[i10] = partition + 1;
                    }
                }
            }
        }

        public static void swap(int[] iArr, float[] fArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(65539, null, iArr, fArr, i2, i3) == null) {
                int i4 = iArr[i2];
                iArr[i2] = iArr[i3];
                iArr[i3] = i4;
                float f2 = fArr[i2];
                fArr[i2] = fArr[i3];
                fArr[i3] = f2;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class IntFloatFloatSort {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public IntFloatFloatSort() {
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

        public static int partition(int[] iArr, float[] fArr, float[] fArr2, int i2, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{iArr, fArr, fArr2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
                int i4 = iArr[i3];
                int i5 = i2;
                while (i2 < i3) {
                    if (iArr[i2] <= i4) {
                        swap(iArr, fArr, fArr2, i5, i2);
                        i5++;
                    }
                    i2++;
                }
                swap(iArr, fArr, fArr2, i5, i3);
                return i5;
            }
            return invokeCommon.intValue;
        }

        public static void sort(int[] iArr, float[] fArr, float[] fArr2, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{iArr, fArr, fArr2, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                int[] iArr2 = new int[iArr.length + 10];
                iArr2[0] = i3;
                iArr2[1] = i2;
                int i4 = 2;
                while (i4 > 0) {
                    int i5 = i4 - 1;
                    int i6 = iArr2[i5];
                    i4 = i5 - 1;
                    int i7 = iArr2[i4];
                    if (i6 < i7) {
                        int partition = partition(iArr, fArr, fArr2, i6, i7);
                        int i8 = i4 + 1;
                        iArr2[i4] = partition - 1;
                        int i9 = i8 + 1;
                        iArr2[i8] = i6;
                        int i10 = i9 + 1;
                        iArr2[i9] = i7;
                        i4 = i10 + 1;
                        iArr2[i10] = partition + 1;
                    }
                }
            }
        }

        public static void swap(int[] iArr, float[] fArr, float[] fArr2, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{iArr, fArr, fArr2, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                int i4 = iArr[i2];
                iArr[i2] = iArr[i3];
                iArr[i3] = i4;
                float f2 = fArr[i2];
                fArr[i2] = fArr[i3];
                fArr[i3] = f2;
                float f3 = fArr2[i2];
                fArr2[i2] = fArr2[i3];
                fArr2[i3] = f3;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class PathRotateSet extends KeyCycleOscillator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public PathRotateSet() {
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

        public void setPathRotate(View view, float f2, double d2, double d3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Float.valueOf(f2), Double.valueOf(d2), Double.valueOf(d3)}) == null) {
                view.setRotation(get(f2) + ((float) Math.toDegrees(Math.atan2(d3, d2))));
            }
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, f2) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ProgressSet extends KeyCycleOscillator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mNoMethod;

        public ProgressSet() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mNoMethod = false;
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
                if (view instanceof MotionLayout) {
                    ((MotionLayout) view).setProgress(get(f2));
                } else if (this.mNoMethod) {
                } else {
                    Method method = null;
                    try {
                        method = view.getClass().getMethod("setProgress", Float.TYPE);
                    } catch (NoSuchMethodException unused) {
                        this.mNoMethod = true;
                    }
                    if (method != null) {
                        try {
                            method.invoke(view, Float.valueOf(get(f2)));
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class RotationSet extends KeyCycleOscillator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RotationSet() {
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

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
                view.setRotation(get(f2));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class RotationXset extends KeyCycleOscillator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RotationXset() {
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

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
                view.setRotationX(get(f2));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class RotationYset extends KeyCycleOscillator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RotationYset() {
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

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
                view.setRotationY(get(f2));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ScaleXset extends KeyCycleOscillator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ScaleXset() {
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

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
                view.setScaleX(get(f2));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ScaleYset extends KeyCycleOscillator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ScaleYset() {
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

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
                view.setScaleY(get(f2));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class TranslationXset extends KeyCycleOscillator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public TranslationXset() {
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

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
                view.setTranslationX(get(f2));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class TranslationYset extends KeyCycleOscillator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public TranslationYset() {
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

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
                view.setTranslationY(get(f2));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class TranslationZset extends KeyCycleOscillator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public TranslationZset() {
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

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) || Build.VERSION.SDK_INT < 21) {
                return;
            }
            view.setTranslationZ(get(f2));
        }
    }

    /* loaded from: classes.dex */
    public static class WavePoint {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float mOffset;
        public float mPeriod;
        public int mPosition;
        public float mValue;

        public WavePoint(int i2, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPosition = i2;
            this.mValue = f4;
            this.mOffset = f3;
            this.mPeriod = f2;
        }
    }

    public KeyCycleOscillator() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mWaveShape = 0;
        this.mVariesBy = 0;
        this.mWavePoints = new ArrayList<>();
    }

    public static KeyCycleOscillator makeSpline(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str.startsWith(Key.CUSTOM)) {
                return new CustomSet();
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals(Key.ROTATION_X)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1249320805:
                    if (str.equals(Key.ROTATION_Y)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1225497657:
                    if (str.equals(Key.TRANSLATION_X)) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case -1225497656:
                    if (str.equals(Key.TRANSLATION_Y)) {
                        c2 = 11;
                        break;
                    }
                    break;
                case -1225497655:
                    if (str.equals(Key.TRANSLATION_Z)) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        c2 = CharUtils.CR;
                        break;
                    }
                    break;
                case -908189618:
                    if (str.equals(Key.SCALE_X)) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -908189617:
                    if (str.equals(Key.SCALE_Y)) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -797520672:
                    if (str.equals(Key.WAVE_VARIES_BY)) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals(Key.ROTATION)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals(Key.ELEVATION)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 37232917:
                    if (str.equals(Key.TRANSITION_PATH_ROTATE)) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals(Key.ALPHA)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 156108012:
                    if (str.equals(Key.WAVE_OFFSET)) {
                        c2 = '\b';
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return new AlphaSet();
                case 1:
                    return new ElevationSet();
                case 2:
                    return new RotationSet();
                case 3:
                    return new RotationXset();
                case 4:
                    return new RotationYset();
                case 5:
                    return new PathRotateSet();
                case 6:
                    return new ScaleXset();
                case 7:
                    return new ScaleYset();
                case '\b':
                    return new AlphaSet();
                case '\t':
                    return new AlphaSet();
                case '\n':
                    return new TranslationXset();
                case 11:
                    return new TranslationYset();
                case '\f':
                    return new TranslationZset();
                case '\r':
                    return new ProgressSet();
                default:
                    return null;
            }
        }
        return (KeyCycleOscillator) invokeL.objValue;
    }

    public float get(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? (float) this.mCycleOscillator.getValues(f2) : invokeF.floatValue;
    }

    public CurveFit getCurveFit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCurveFit : (CurveFit) invokeV.objValue;
    }

    public float getSlope(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2)) == null) ? (float) this.mCycleOscillator.getSlope(f2) : invokeF.floatValue;
    }

    public void setPoint(int i2, int i3, int i4, float f2, float f3, float f4, ConstraintAttribute constraintAttribute) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), constraintAttribute}) == null) {
            this.mWavePoints.add(new WavePoint(i2, f2, f3, f4));
            if (i4 != -1) {
                this.mVariesBy = i4;
            }
            this.mWaveShape = i3;
            this.mCustom = constraintAttribute;
        }
    }

    public abstract void setProperty(View view, float f2);

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.mType = str;
        }
    }

    @TargetApi(19)
    public void setup(float f2) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048583, this, f2) == null) || (size = this.mWavePoints.size()) == 0) {
            return;
        }
        Collections.sort(this.mWavePoints, new Comparator<WavePoint>(this) { // from class: androidx.constraintlayout.motion.widget.KeyCycleOscillator.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KeyCycleOscillator this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, wavePoint, wavePoint2)) == null) ? Integer.compare(wavePoint.mPosition, wavePoint2.mPosition) : invokeLL.intValue;
            }
        });
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, 2);
        this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mVariesBy, size);
        Iterator<WavePoint> it = this.mWavePoints.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            WavePoint next = it.next();
            float f3 = next.mPeriod;
            dArr[i2] = f3 * 0.01d;
            double[] dArr3 = dArr2[i2];
            float f4 = next.mValue;
            dArr3[0] = f4;
            double[] dArr4 = dArr2[i2];
            float f5 = next.mOffset;
            dArr4[1] = f5;
            this.mCycleOscillator.setPoint(i2, next.mPosition, f3, f5, f4);
            i2++;
        }
        this.mCycleOscillator.setup(f2);
        this.mCurveFit = CurveFit.get(0, dArr, dArr2);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String str = this.mType;
            DecimalFormat decimalFormat = new DecimalFormat("##.##");
            Iterator<WavePoint> it = this.mWavePoints.iterator();
            while (it.hasNext()) {
                WavePoint next = it.next();
                str = str + PreferencesUtil.LEFT_MOUNT + next.mPosition + " , " + decimalFormat.format(next.mValue) + "] ";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public boolean variesByPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mVariesBy == 1 : invokeV.booleanValue;
    }

    public void setPoint(int i2, int i3, int i4, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.mWavePoints.add(new WavePoint(i2, f2, f3, f4));
            if (i4 != -1) {
                this.mVariesBy = i4;
            }
            this.mWaveShape = i3;
        }
    }
}

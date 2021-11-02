package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
/* loaded from: classes.dex */
public abstract class TimeCycleSplineSet {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CURVE_OFFSET = 2;
    public static final int CURVE_PERIOD = 1;
    public static final int CURVE_VALUE = 0;
    public static final String TAG = "SplineSet";
    public static float VAL_2PI = 6.2831855f;
    public transient /* synthetic */ FieldHolder $fh;
    public int count;
    public float last_cycle;
    public long last_time;
    public float[] mCache;
    public boolean mContinue;
    public CurveFit mCurveFit;
    public int[] mTimePoints;
    public String mType;
    public float[][] mValues;
    public int mWaveShape;

    /* loaded from: classes.dex */
    public static class AlphaSet extends TimeCycleSplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view, Float.valueOf(f2), Long.valueOf(j), keyCache})) == null) {
                view.setAlpha(get(f2, j, view, keyCache));
                return this.mContinue;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class CustomSet extends TimeCycleSplineSet {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mAttributeName;
        public float[] mCache;
        public SparseArray<ConstraintAttribute> mConstraintAttributeList;
        public float[] mTempValues;
        public SparseArray<float[]> mWaveProperties;

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mWaveProperties = new SparseArray<>();
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setPoint(int i2, float f2, float f3, int i3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i3), Float.valueOf(f4)}) == null) {
                throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
            }
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view, Float.valueOf(f2), Long.valueOf(j), keyCache})) == null) {
                this.mCurveFit.getPos(f2, this.mTempValues);
                float[] fArr = this.mTempValues;
                float f3 = fArr[fArr.length - 2];
                float f4 = fArr[fArr.length - 1];
                long j2 = j - this.last_time;
                if (Float.isNaN(this.last_cycle)) {
                    float floatValue = keyCache.getFloatValue(view, this.mAttributeName, 0);
                    this.last_cycle = floatValue;
                    if (Float.isNaN(floatValue)) {
                        this.last_cycle = 0.0f;
                    }
                }
                float f5 = (float) ((this.last_cycle + ((j2 * 1.0E-9d) * f3)) % 1.0d);
                this.last_cycle = f5;
                this.last_time = j;
                float calcWave = calcWave(f5);
                this.mContinue = false;
                for (int i2 = 0; i2 < this.mCache.length; i2++) {
                    this.mContinue |= ((double) this.mTempValues[i2]) != 0.0d;
                    this.mCache[i2] = (this.mTempValues[i2] * calcWave) + f4;
                }
                this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mCache);
                if (f3 != 0.0f) {
                    this.mContinue = true;
                }
                return this.mContinue;
            }
            return invokeCommon.booleanValue;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setup(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                int size = this.mConstraintAttributeList.size();
                int noOfInterpValues = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
                double[] dArr = new double[size];
                int i3 = noOfInterpValues + 2;
                this.mTempValues = new float[i3];
                this.mCache = new float[noOfInterpValues];
                double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, i3);
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = this.mConstraintAttributeList.keyAt(i4);
                    float[] valueAt = this.mWaveProperties.valueAt(i4);
                    dArr[i4] = keyAt * 0.01d;
                    this.mConstraintAttributeList.valueAt(i4).getValuesToInterpolate(this.mTempValues);
                    int i5 = 0;
                    while (true) {
                        float[] fArr = this.mTempValues;
                        if (i5 < fArr.length) {
                            dArr2[i4][i5] = fArr[i5];
                            i5++;
                        }
                    }
                    dArr2[i4][noOfInterpValues] = valueAt[0];
                    dArr2[i4][noOfInterpValues + 1] = valueAt[1];
                }
                this.mCurveFit = CurveFit.get(i2, dArr, dArr2);
            }
        }

        public void setPoint(int i2, ConstraintAttribute constraintAttribute, float f2, int i3, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), constraintAttribute, Float.valueOf(f2), Integer.valueOf(i3), Float.valueOf(f3)}) == null) {
                this.mConstraintAttributeList.append(i2, constraintAttribute);
                this.mWaveProperties.append(i2, new float[]{f2, f3});
                this.mWaveShape = Math.max(this.mWaveShape, i3);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ElevationSet extends TimeCycleSplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view, Float.valueOf(f2), Long.valueOf(j), keyCache})) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    view.setElevation(get(f2, j, view, keyCache));
                }
                return this.mContinue;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class PathRotate extends TimeCycleSplineSet {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public PathRotate() {
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

        public boolean setPathRotate(View view, KeyCache keyCache, float f2, long j, double d2, double d3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view, keyCache, Float.valueOf(f2), Long.valueOf(j), Double.valueOf(d2), Double.valueOf(d3)})) == null) {
                view.setRotation(get(f2, j, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d3, d2))));
                return this.mContinue;
            }
            return invokeCommon.booleanValue;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, Float.valueOf(f2), Long.valueOf(j), keyCache})) == null) ? this.mContinue : invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class ProgressSet extends TimeCycleSplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view, Float.valueOf(f2), Long.valueOf(j), keyCache})) == null) {
                if (view instanceof MotionLayout) {
                    ((MotionLayout) view).setProgress(get(f2, j, view, keyCache));
                } else if (this.mNoMethod) {
                    return false;
                } else {
                    Method method = null;
                    try {
                        method = view.getClass().getMethod("setProgress", Float.TYPE);
                    } catch (NoSuchMethodException unused) {
                        this.mNoMethod = true;
                    }
                    if (method != null) {
                        try {
                            method.invoke(view, Float.valueOf(get(f2, j, view, keyCache)));
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                        }
                    }
                }
                return this.mContinue;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class RotationSet extends TimeCycleSplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view, Float.valueOf(f2), Long.valueOf(j), keyCache})) == null) {
                view.setRotation(get(f2, j, view, keyCache));
                return this.mContinue;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class RotationXset extends TimeCycleSplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view, Float.valueOf(f2), Long.valueOf(j), keyCache})) == null) {
                view.setRotationX(get(f2, j, view, keyCache));
                return this.mContinue;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class RotationYset extends TimeCycleSplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view, Float.valueOf(f2), Long.valueOf(j), keyCache})) == null) {
                view.setRotationY(get(f2, j, view, keyCache));
                return this.mContinue;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class ScaleXset extends TimeCycleSplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view, Float.valueOf(f2), Long.valueOf(j), keyCache})) == null) {
                view.setScaleX(get(f2, j, view, keyCache));
                return this.mContinue;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class ScaleYset extends TimeCycleSplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view, Float.valueOf(f2), Long.valueOf(j), keyCache})) == null) {
                view.setScaleY(get(f2, j, view, keyCache));
                return this.mContinue;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class Sort {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Sort() {
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

        public static void doubleQuickSort(int[] iArr, float[][] fArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(65537, null, iArr, fArr, i2, i3) == null) {
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

        public static int partition(int[] iArr, float[][] fArr, int i2, int i3) {
            InterceptResult invokeLLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65538, null, iArr, fArr, i2, i3)) == null) {
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

        public static void swap(int[] iArr, float[][] fArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(65539, null, iArr, fArr, i2, i3) == null) {
                int i4 = iArr[i2];
                iArr[i2] = iArr[i3];
                iArr[i3] = i4;
                float[] fArr2 = fArr[i2];
                fArr[i2] = fArr[i3];
                fArr[i3] = fArr2;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class TranslationXset extends TimeCycleSplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view, Float.valueOf(f2), Long.valueOf(j), keyCache})) == null) {
                view.setTranslationX(get(f2, j, view, keyCache));
                return this.mContinue;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class TranslationYset extends TimeCycleSplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view, Float.valueOf(f2), Long.valueOf(j), keyCache})) == null) {
                view.setTranslationY(get(f2, j, view, keyCache));
                return this.mContinue;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class TranslationZset extends TimeCycleSplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view, Float.valueOf(f2), Long.valueOf(j), keyCache})) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    view.setTranslationZ(get(f2, j, view, keyCache));
                }
                return this.mContinue;
            }
            return invokeCommon.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-958642333, "Landroidx/constraintlayout/motion/widget/TimeCycleSplineSet;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-958642333, "Landroidx/constraintlayout/motion/widget/TimeCycleSplineSet;");
        }
    }

    public TimeCycleSplineSet() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mWaveShape = 0;
        this.mTimePoints = new int[10];
        this.mValues = (float[][]) Array.newInstance(float.class, 10, 3);
        this.mCache = new float[3];
        this.mContinue = false;
        this.last_cycle = Float.NaN;
    }

    public static TimeCycleSplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, sparseArray)) == null) ? new CustomSet(str, sparseArray) : (TimeCycleSplineSet) invokeLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static TimeCycleSplineSet makeSpline(String str, long j) {
        InterceptResult invokeLJ;
        char c2;
        TimeCycleSplineSet alphaSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, str, j)) == null) {
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals(Key.ROTATION_X)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1249320805:
                    if (str.equals(Key.ROTATION_Y)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1225497657:
                    if (str.equals(Key.TRANSLATION_X)) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1225497656:
                    if (str.equals(Key.TRANSLATION_Y)) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1225497655:
                    if (str.equals(Key.TRANSLATION_Z)) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -908189618:
                    if (str.equals(Key.SCALE_X)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -908189617:
                    if (str.equals(Key.SCALE_Y)) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -40300674:
                    if (str.equals(Key.ROTATION)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -4379043:
                    if (str.equals(Key.ELEVATION)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 37232917:
                    if (str.equals(Key.TRANSITION_PATH_ROTATE)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 92909918:
                    if (str.equals(Key.ALPHA)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    alphaSet = new AlphaSet();
                    break;
                case 1:
                    alphaSet = new ElevationSet();
                    break;
                case 2:
                    alphaSet = new RotationSet();
                    break;
                case 3:
                    alphaSet = new RotationXset();
                    break;
                case 4:
                    alphaSet = new RotationYset();
                    break;
                case 5:
                    alphaSet = new PathRotate();
                    break;
                case 6:
                    alphaSet = new ScaleXset();
                    break;
                case 7:
                    alphaSet = new ScaleYset();
                    break;
                case '\b':
                    alphaSet = new TranslationXset();
                    break;
                case '\t':
                    alphaSet = new TranslationYset();
                    break;
                case '\n':
                    alphaSet = new TranslationZset();
                    break;
                case 11:
                    alphaSet = new ProgressSet();
                    break;
                default:
                    return null;
            }
            alphaSet.setStartTime(j);
            return alphaSet;
        }
        return (TimeCycleSplineSet) invokeLJ.objValue;
    }

    public float calcWave(float f2) {
        InterceptResult invokeF;
        float abs;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
            switch (this.mWaveShape) {
                case 1:
                    return Math.signum(f2 * VAL_2PI);
                case 2:
                    abs = Math.abs(f2);
                    break;
                case 3:
                    return (((f2 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
                case 4:
                    abs = ((f2 * 2.0f) + 1.0f) % 2.0f;
                    break;
                case 5:
                    return (float) Math.cos(f2 * VAL_2PI);
                case 6:
                    float abs2 = 1.0f - Math.abs(((f2 * 4.0f) % 4.0f) - 2.0f);
                    abs = abs2 * abs2;
                    break;
                default:
                    return (float) Math.sin(f2 * VAL_2PI);
            }
            return 1.0f - abs;
        }
        return invokeF.floatValue;
    }

    public float get(float f2, long j, View view, KeyCache keyCache) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Long.valueOf(j), view, keyCache})) == null) {
            this.mCurveFit.getPos(f2, this.mCache);
            float[] fArr = this.mCache;
            float f3 = fArr[1];
            int i2 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
            if (i2 == 0) {
                this.mContinue = false;
                return fArr[2];
            }
            if (Float.isNaN(this.last_cycle)) {
                float floatValue = keyCache.getFloatValue(view, this.mType, 0);
                this.last_cycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.last_cycle = 0.0f;
                }
            }
            float f4 = (float) ((this.last_cycle + (((j - this.last_time) * 1.0E-9d) * f3)) % 1.0d);
            this.last_cycle = f4;
            keyCache.setFloatValue(view, this.mType, 0, f4);
            this.last_time = j;
            float f5 = this.mCache[0];
            float calcWave = (calcWave(this.last_cycle) * f5) + this.mCache[2];
            this.mContinue = (f5 == 0.0f && i2 == 0) ? false : true;
            return calcWave;
        }
        return invokeCommon.floatValue;
    }

    public CurveFit getCurveFit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCurveFit : (CurveFit) invokeV.objValue;
    }

    public void setPoint(int i2, float f2, float f3, int i3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i3), Float.valueOf(f4)}) == null) {
            int[] iArr = this.mTimePoints;
            int i4 = this.count;
            iArr[i4] = i2;
            float[][] fArr = this.mValues;
            fArr[i4][0] = f2;
            fArr[i4][1] = f3;
            fArr[i4][2] = f4;
            this.mWaveShape = Math.max(this.mWaveShape, i3);
            this.count++;
        }
    }

    public abstract boolean setProperty(View view, float f2, long j, KeyCache keyCache);

    public void setStartTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.last_time = j;
        }
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.mType = str;
        }
    }

    public void setup(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            int i4 = this.count;
            if (i4 == 0) {
                String str = "Error no points added to " + this.mType;
                return;
            }
            Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i4 - 1);
            int i5 = 1;
            int i6 = 0;
            while (true) {
                int[] iArr = this.mTimePoints;
                if (i5 >= iArr.length) {
                    break;
                }
                if (iArr[i5] != iArr[i5 - 1]) {
                    i6++;
                }
                i5++;
            }
            if (i6 == 0) {
                i6 = 1;
            }
            double[] dArr = new double[i6];
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, i6, 3);
            int i7 = 0;
            while (i3 < this.count) {
                if (i3 > 0) {
                    int[] iArr2 = this.mTimePoints;
                    i3 = iArr2[i3] == iArr2[i3 + (-1)] ? i3 + 1 : 0;
                }
                dArr[i7] = this.mTimePoints[i3] * 0.01d;
                double[] dArr3 = dArr2[i7];
                float[][] fArr = this.mValues;
                dArr3[0] = fArr[i3][0];
                dArr2[i7][1] = fArr[i3][1];
                dArr2[i7][2] = fArr[i3][2];
                i7++;
            }
            this.mCurveFit = CurveFit.get(i2, dArr, dArr2);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String str = this.mType;
            DecimalFormat decimalFormat = new DecimalFormat("##.##");
            for (int i2 = 0; i2 < this.count; i2++) {
                str = str + PreferencesUtil.LEFT_MOUNT + this.mTimePoints[i2] + " , " + decimalFormat.format(this.mValues[i2]) + "] ";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}

package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.util.Log;
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

    public abstract boolean setProperty(View view2, float f, long j, KeyCache keyCache);

    /* loaded from: classes.dex */
    public static class AlphaSet extends TimeCycleSplineSet {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public AlphaSet() {
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

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view2, float f, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view2, Float.valueOf(f), Long.valueOf(j), keyCache})) == null) {
                view2.setAlpha(get(f, j, view2, keyCache));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public void setPoint(int i, float f, float f2, int i2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2), Float.valueOf(f3)}) == null) {
                throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
            }
        }

        public void setPoint(int i, ConstraintAttribute constraintAttribute, float f, int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), constraintAttribute, Float.valueOf(f), Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
                this.mConstraintAttributeList.append(i, constraintAttribute);
                this.mWaveProperties.append(i, new float[]{f, f2});
                this.mWaveShape = Math.max(this.mWaveShape, i2);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view2, float f, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, Float.valueOf(f), Long.valueOf(j), keyCache})) == null) {
                this.mCurveFit.getPos(f, this.mTempValues);
                float[] fArr = this.mTempValues;
                float f2 = fArr[fArr.length - 2];
                float f3 = fArr[fArr.length - 1];
                long j2 = j - this.last_time;
                if (Float.isNaN(this.last_cycle)) {
                    float floatValue = keyCache.getFloatValue(view2, this.mAttributeName, 0);
                    this.last_cycle = floatValue;
                    if (Float.isNaN(floatValue)) {
                        this.last_cycle = 0.0f;
                    }
                }
                float f4 = (float) ((this.last_cycle + ((j2 * 1.0E-9d) * f2)) % 1.0d);
                this.last_cycle = f4;
                this.last_time = j;
                float calcWave = calcWave(f4);
                this.mContinue = false;
                for (int i = 0; i < this.mCache.length; i++) {
                    boolean z2 = this.mContinue;
                    if (this.mTempValues[i] != 0.0d) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.mContinue = z2 | z;
                    this.mCache[i] = (this.mTempValues[i] * calcWave) + f3;
                }
                this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view2, this.mCache);
                if (f2 != 0.0f) {
                    this.mContinue = true;
                }
                return this.mContinue;
            }
            return invokeCommon.booleanValue;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setup(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                int size = this.mConstraintAttributeList.size();
                int noOfInterpValues = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
                double[] dArr = new double[size];
                int i2 = noOfInterpValues + 2;
                this.mTempValues = new float[i2];
                this.mCache = new float[noOfInterpValues];
                double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, i2);
                for (int i3 = 0; i3 < size; i3++) {
                    int keyAt = this.mConstraintAttributeList.keyAt(i3);
                    float[] valueAt = this.mWaveProperties.valueAt(i3);
                    dArr[i3] = keyAt * 0.01d;
                    this.mConstraintAttributeList.valueAt(i3).getValuesToInterpolate(this.mTempValues);
                    int i4 = 0;
                    while (true) {
                        float[] fArr = this.mTempValues;
                        if (i4 < fArr.length) {
                            dArr2[i3][i4] = fArr[i4];
                            i4++;
                        }
                    }
                    dArr2[i3][noOfInterpValues] = valueAt[0];
                    dArr2[i3][noOfInterpValues + 1] = valueAt[1];
                }
                this.mCurveFit = CurveFit.get(i, dArr, dArr2);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view2, float f, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view2, Float.valueOf(f), Long.valueOf(j), keyCache})) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    view2.setElevation(get(f, j, view2, keyCache));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public boolean setPathRotate(View view2, KeyCache keyCache, float f, long j, double d, double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view2, keyCache, Float.valueOf(f), Long.valueOf(j), Double.valueOf(d), Double.valueOf(d2)})) == null) {
                view2.setRotation(get(f, j, view2, keyCache) + ((float) Math.toDegrees(Math.atan2(d2, d))));
                return this.mContinue;
            }
            return invokeCommon.booleanValue;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view2, float f, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, Float.valueOf(f), Long.valueOf(j), keyCache})) == null) {
                return this.mContinue;
            }
            return invokeCommon.booleanValue;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mNoMethod = false;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view2, float f, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view2, Float.valueOf(f), Long.valueOf(j), keyCache})) == null) {
                if (view2 instanceof MotionLayout) {
                    ((MotionLayout) view2).setProgress(get(f, j, view2, keyCache));
                } else if (this.mNoMethod) {
                    return false;
                } else {
                    Method method = null;
                    try {
                        method = view2.getClass().getMethod("setProgress", Float.TYPE);
                    } catch (NoSuchMethodException unused) {
                        this.mNoMethod = true;
                    }
                    Method method2 = method;
                    if (method2 != null) {
                        try {
                            method2.invoke(view2, Float.valueOf(get(f, j, view2, keyCache)));
                        } catch (IllegalAccessException e) {
                            Log.e("SplineSet", "unable to setProgress", e);
                        } catch (InvocationTargetException e2) {
                            Log.e("SplineSet", "unable to setProgress", e2);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view2, float f, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view2, Float.valueOf(f), Long.valueOf(j), keyCache})) == null) {
                view2.setRotation(get(f, j, view2, keyCache));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view2, float f, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view2, Float.valueOf(f), Long.valueOf(j), keyCache})) == null) {
                view2.setRotationX(get(f, j, view2, keyCache));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view2, float f, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view2, Float.valueOf(f), Long.valueOf(j), keyCache})) == null) {
                view2.setRotationY(get(f, j, view2, keyCache));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view2, float f, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view2, Float.valueOf(f), Long.valueOf(j), keyCache})) == null) {
                view2.setScaleX(get(f, j, view2, keyCache));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view2, float f, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view2, Float.valueOf(f), Long.valueOf(j), keyCache})) == null) {
                view2.setScaleY(get(f, j, view2, keyCache));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static void doubleQuickSort(int[] iArr, float[][] fArr, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(65537, null, iArr, fArr, i, i2) == null) {
                int[] iArr2 = new int[iArr.length + 10];
                iArr2[0] = i2;
                iArr2[1] = i;
                int i3 = 2;
                while (i3 > 0) {
                    int i4 = i3 - 1;
                    int i5 = iArr2[i4];
                    i3 = i4 - 1;
                    int i6 = iArr2[i3];
                    if (i5 < i6) {
                        int partition = partition(iArr, fArr, i5, i6);
                        int i7 = i3 + 1;
                        iArr2[i3] = partition - 1;
                        int i8 = i7 + 1;
                        iArr2[i7] = i5;
                        int i9 = i8 + 1;
                        iArr2[i8] = i6;
                        i3 = i9 + 1;
                        iArr2[i9] = partition + 1;
                    }
                }
            }
        }

        public static int partition(int[] iArr, float[][] fArr, int i, int i2) {
            InterceptResult invokeLLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65538, null, iArr, fArr, i, i2)) == null) {
                int i3 = iArr[i2];
                int i4 = i;
                while (i < i2) {
                    if (iArr[i] <= i3) {
                        swap(iArr, fArr, i4, i);
                        i4++;
                    }
                    i++;
                }
                swap(iArr, fArr, i4, i2);
                return i4;
            }
            return invokeLLII.intValue;
        }

        public static void swap(int[] iArr, float[][] fArr, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(65539, null, iArr, fArr, i, i2) == null) {
                int i3 = iArr[i];
                iArr[i] = iArr[i2];
                iArr[i2] = i3;
                float[] fArr2 = fArr[i];
                fArr[i] = fArr[i2];
                fArr[i2] = fArr2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view2, float f, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view2, Float.valueOf(f), Long.valueOf(j), keyCache})) == null) {
                view2.setTranslationX(get(f, j, view2, keyCache));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view2, float f, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view2, Float.valueOf(f), Long.valueOf(j), keyCache})) == null) {
                view2.setTranslationY(get(f, j, view2, keyCache));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view2, float f, long j, KeyCache keyCache) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view2, Float.valueOf(f), Long.valueOf(j), keyCache})) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    view2.setTranslationZ(get(f, j, view2, keyCache));
                }
                return this.mContinue;
            }
            return invokeCommon.booleanValue;
        }
    }

    public TimeCycleSplineSet() {
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
        this.mWaveShape = 0;
        this.mTimePoints = new int[10];
        this.mValues = (float[][]) Array.newInstance(float.class, 10, 3);
        this.mCache = new float[3];
        this.mContinue = false;
        this.last_cycle = Float.NaN;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String str = this.mType;
            DecimalFormat decimalFormat = new DecimalFormat("##.##");
            for (int i = 0; i < this.count; i++) {
                str = str + PreferencesUtil.LEFT_MOUNT + this.mTimePoints[i] + " , " + decimalFormat.format(this.mValues[i]) + "] ";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static TimeCycleSplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, sparseArray)) == null) {
            return new CustomSet(str, sparseArray);
        }
        return (TimeCycleSplineSet) invokeLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static TimeCycleSplineSet makeSpline(String str, long j) {
        InterceptResult invokeLJ;
        char c;
        TimeCycleSplineSet alphaSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, str, j)) == null) {
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals(Key.ROTATION_X)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1249320805:
                    if (str.equals(Key.ROTATION_Y)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1225497657:
                    if (str.equals(Key.TRANSLATION_X)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -1225497656:
                    if (str.equals(Key.TRANSLATION_Y)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -1225497655:
                    if (str.equals(Key.TRANSLATION_Z)) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -908189618:
                    if (str.equals(Key.SCALE_X)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -908189617:
                    if (str.equals(Key.SCALE_Y)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -40300674:
                    if (str.equals(Key.ROTATION)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -4379043:
                    if (str.equals(Key.ELEVATION)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 37232917:
                    if (str.equals(Key.TRANSITION_PATH_ROTATE)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 92909918:
                    if (str.equals(Key.ALPHA)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
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

    public float calcWave(float f) {
        InterceptResult invokeF;
        float abs;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
            switch (this.mWaveShape) {
                case 1:
                    return Math.signum(f * VAL_2PI);
                case 2:
                    abs = Math.abs(f);
                    break;
                case 3:
                    return (((f * 2.0f) + 1.0f) % 2.0f) - 1.0f;
                case 4:
                    abs = ((f * 2.0f) + 1.0f) % 2.0f;
                    break;
                case 5:
                    return (float) Math.cos(f * VAL_2PI);
                case 6:
                    float abs2 = 1.0f - Math.abs(((f * 4.0f) % 4.0f) - 2.0f);
                    abs = abs2 * abs2;
                    break;
                default:
                    return (float) Math.sin(f * VAL_2PI);
            }
            return 1.0f - abs;
        }
        return invokeF.floatValue;
    }

    public float get(float f, long j, View view2, KeyCache keyCache) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Long.valueOf(j), view2, keyCache})) == null) {
            this.mCurveFit.getPos(f, this.mCache);
            float[] fArr = this.mCache;
            float f2 = fArr[1];
            int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i == 0) {
                this.mContinue = false;
                return fArr[2];
            }
            if (Float.isNaN(this.last_cycle)) {
                float floatValue = keyCache.getFloatValue(view2, this.mType, 0);
                this.last_cycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.last_cycle = 0.0f;
                }
            }
            float f3 = (float) ((this.last_cycle + (((j - this.last_time) * 1.0E-9d) * f2)) % 1.0d);
            this.last_cycle = f3;
            keyCache.setFloatValue(view2, this.mType, 0, f3);
            this.last_time = j;
            float f4 = this.mCache[0];
            float calcWave = (calcWave(this.last_cycle) * f4) + this.mCache[2];
            if (f4 == 0.0f && i == 0) {
                z = false;
            } else {
                z = true;
            }
            this.mContinue = z;
            return calcWave;
        }
        return invokeCommon.floatValue;
    }

    public CurveFit getCurveFit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mCurveFit;
        }
        return (CurveFit) invokeV.objValue;
    }

    public void setPoint(int i, float f, float f2, int i2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2), Float.valueOf(f3)}) == null) {
            int[] iArr = this.mTimePoints;
            int i3 = this.count;
            iArr[i3] = i;
            float[][] fArr = this.mValues;
            fArr[i3][0] = f;
            fArr[i3][1] = f2;
            fArr[i3][2] = f3;
            this.mWaveShape = Math.max(this.mWaveShape, i2);
            this.count++;
        }
    }

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

    public void setup(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            int i2 = this.count;
            if (i2 == 0) {
                Log.e("SplineSet", "Error no points added to " + this.mType);
                return;
            }
            Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i2 - 1);
            int i3 = 1;
            int i4 = 0;
            while (true) {
                int[] iArr = this.mTimePoints;
                if (i3 >= iArr.length) {
                    break;
                }
                if (iArr[i3] != iArr[i3 - 1]) {
                    i4++;
                }
                i3++;
            }
            if (i4 == 0) {
                i4 = 1;
            }
            double[] dArr = new double[i4];
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, i4, 3);
            int i5 = 0;
            for (int i6 = 0; i6 < this.count; i6++) {
                if (i6 > 0) {
                    int[] iArr2 = this.mTimePoints;
                    if (iArr2[i6] == iArr2[i6 - 1]) {
                    }
                }
                dArr[i5] = this.mTimePoints[i6] * 0.01d;
                double[] dArr3 = dArr2[i5];
                float[][] fArr = this.mValues;
                dArr3[0] = fArr[i6][0];
                dArr2[i5][1] = fArr[i6][1];
                dArr2[i5][2] = fArr[i6][2];
                i5++;
            }
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }
    }
}

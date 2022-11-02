package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
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
import java.util.Arrays;
/* loaded from: classes.dex */
public abstract class SplineSet {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SplineSet";
    public transient /* synthetic */ FieldHolder $fh;
    public int count;
    public CurveFit mCurveFit;
    public int[] mTimePoints;
    public String mType;
    public float[] mValues;

    public abstract void setProperty(View view2, float f);

    /* loaded from: classes.dex */
    public static class AlphaSet extends SplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view2, f) == null) {
                view2.setAlpha(get(f));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomSet extends SplineSet {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mAttributeName;
        public SparseArray<ConstraintAttribute> mConstraintAttributeList;
        public float[] mTempValues;

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
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setPoint(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
                throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
            }
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view2, f) == null) {
                this.mCurveFit.getPos(f, this.mTempValues);
                this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view2, this.mTempValues);
            }
        }

        public void setPoint(int i, ConstraintAttribute constraintAttribute) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, constraintAttribute) == null) {
                this.mConstraintAttributeList.append(i, constraintAttribute);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setup(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                int size = this.mConstraintAttributeList.size();
                int noOfInterpValues = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
                double[] dArr = new double[size];
                this.mTempValues = new float[noOfInterpValues];
                double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, noOfInterpValues);
                for (int i2 = 0; i2 < size; i2++) {
                    dArr[i2] = this.mConstraintAttributeList.keyAt(i2) * 0.01d;
                    this.mConstraintAttributeList.valueAt(i2).getValuesToInterpolate(this.mTempValues);
                    int i3 = 0;
                    while (true) {
                        float[] fArr = this.mTempValues;
                        if (i3 < fArr.length) {
                            dArr2[i2][i3] = fArr[i3];
                            i3++;
                        }
                    }
                }
                this.mCurveFit = CurveFit.get(i, dArr, dArr2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ElevationSet extends SplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view2, float f) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLF(1048576, this, view2, f) == null) && Build.VERSION.SDK_INT >= 21) {
                view2.setElevation(get(f));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class PathRotate extends SplineSet {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, f) == null) {
            }
        }

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

        public void setPathRotate(View view2, float f, double d, double d2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Float.valueOf(f), Double.valueOf(d), Double.valueOf(d2)}) == null) {
                view2.setRotation(get(f) + ((float) Math.toDegrees(Math.atan2(d2, d))));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class PivotXset extends SplineSet {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public PivotXset() {
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

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view2, f) == null) {
                view2.setPivotX(get(f));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class PivotYset extends SplineSet {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public PivotYset() {
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

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view2, f) == null) {
                view2.setPivotY(get(f));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ProgressSet extends SplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view2, f) == null) {
                if (view2 instanceof MotionLayout) {
                    ((MotionLayout) view2).setProgress(get(f));
                } else if (this.mNoMethod) {
                } else {
                    Method method = null;
                    try {
                        method = view2.getClass().getMethod("setProgress", Float.TYPE);
                    } catch (NoSuchMethodException unused) {
                        this.mNoMethod = true;
                    }
                    if (method != null) {
                        try {
                            method.invoke(view2, Float.valueOf(get(f)));
                        } catch (IllegalAccessException e) {
                            Log.e("SplineSet", "unable to setProgress", e);
                        } catch (InvocationTargetException e2) {
                            Log.e("SplineSet", "unable to setProgress", e2);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class RotationSet extends SplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view2, f) == null) {
                view2.setRotation(get(f));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class RotationXset extends SplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view2, f) == null) {
                view2.setRotationX(get(f));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class RotationYset extends SplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view2, f) == null) {
                view2.setRotationY(get(f));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ScaleXset extends SplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view2, f) == null) {
                view2.setScaleX(get(f));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ScaleYset extends SplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view2, f) == null) {
                view2.setScaleY(get(f));
            }
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

        public static void doubleQuickSort(int[] iArr, float[] fArr, int i, int i2) {
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

        public static int partition(int[] iArr, float[] fArr, int i, int i2) {
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

        public static void swap(int[] iArr, float[] fArr, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(65539, null, iArr, fArr, i, i2) == null) {
                int i3 = iArr[i];
                iArr[i] = iArr[i2];
                iArr[i2] = i3;
                float f = fArr[i];
                fArr[i] = fArr[i2];
                fArr[i2] = f;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class TranslationXset extends SplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view2, f) == null) {
                view2.setTranslationX(get(f));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class TranslationYset extends SplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view2, f) == null) {
                view2.setTranslationY(get(f));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class TranslationZset extends SplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view2, float f) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLF(1048576, this, view2, f) == null) && Build.VERSION.SDK_INT >= 21) {
                view2.setTranslationZ(get(f));
            }
        }
    }

    public SplineSet() {
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
        this.mTimePoints = new int[10];
        this.mValues = new float[10];
    }

    public CurveFit getCurveFit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mCurveFit;
        }
        return (CurveFit) invokeV.objValue;
    }

    public static SplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, sparseArray)) == null) {
            return new CustomSet(str, sparseArray);
        }
        return (SplineSet) invokeLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static SplineSet makeSpline(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
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
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case -1225497656:
                    if (str.equals(Key.TRANSLATION_Y)) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case -1225497655:
                    if (str.equals(Key.TRANSLATION_Z)) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case -908189618:
                    if (str.equals(Key.SCALE_X)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -908189617:
                    if (str.equals(Key.SCALE_Y)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -797520672:
                    if (str.equals(Key.WAVE_VARIES_BY)) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -760884510:
                    if (str.equals(Key.PIVOT_X)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -760884509:
                    if (str.equals(Key.PIVOT_Y)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
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
                        c = 7;
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
                case 156108012:
                    if (str.equals(Key.WAVE_OFFSET)) {
                        c = '\n';
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
                    return new PivotXset();
                case 6:
                    return new PivotYset();
                case 7:
                    return new PathRotate();
                case '\b':
                    return new ScaleXset();
                case '\t':
                    return new ScaleYset();
                case '\n':
                    return new AlphaSet();
                case 11:
                    return new AlphaSet();
                case '\f':
                    return new TranslationXset();
                case '\r':
                    return new TranslationYset();
                case 14:
                    return new TranslationZset();
                case 15:
                    return new ProgressSet();
                default:
                    return null;
            }
        }
        return (SplineSet) invokeL.objValue;
    }

    public float get(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
            return (float) this.mCurveFit.getPos(f, 0);
        }
        return invokeF.floatValue;
    }

    public float getSlope(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f)) == null) {
            return (float) this.mCurveFit.getSlope(f, 0);
        }
        return invokeF.floatValue;
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.mType = str;
        }
    }

    public void setPoint(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            int[] iArr = this.mTimePoints;
            if (iArr.length < this.count + 1) {
                this.mTimePoints = Arrays.copyOf(iArr, iArr.length * 2);
                float[] fArr = this.mValues;
                this.mValues = Arrays.copyOf(fArr, fArr.length * 2);
            }
            int[] iArr2 = this.mTimePoints;
            int i2 = this.count;
            iArr2[i2] = i;
            this.mValues[i2] = f;
            this.count = i2 + 1;
        }
    }

    public void setup(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || (i2 = this.count) == 0) {
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i2 - 1);
        int i3 = 1;
        for (int i4 = 1; i4 < this.count; i4++) {
            int[] iArr = this.mTimePoints;
            if (iArr[i4 - 1] != iArr[i4]) {
                i3++;
            }
        }
        double[] dArr = new double[i3];
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, i3, 1);
        int i5 = 0;
        for (int i6 = 0; i6 < this.count; i6++) {
            if (i6 > 0) {
                int[] iArr2 = this.mTimePoints;
                if (iArr2[i6] == iArr2[i6 - 1]) {
                }
            }
            dArr[i5] = this.mTimePoints[i6] * 0.01d;
            dArr2[i5][0] = this.mValues[i6];
            i5++;
        }
        this.mCurveFit = CurveFit.get(i, dArr, dArr2);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String str = this.mType;
            DecimalFormat decimalFormat = new DecimalFormat("##.##");
            for (int i = 0; i < this.count; i++) {
                str = str + PreferencesUtil.LEFT_MOUNT + this.mTimePoints[i] + " , " + decimalFormat.format(this.mValues[i]) + "] ";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}

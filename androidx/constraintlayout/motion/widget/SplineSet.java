package androidx.constraintlayout.motion.widget;

import android.os.Build;
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
import org.apache.commons.lang3.CharUtils;
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

    /* loaded from: classes.dex */
    public static class AlphaSet extends SplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
                view.setAlpha(get(f2));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setPoint(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
                throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
            }
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view, f2) == null) {
                this.mCurveFit.getPos(f2, this.mTempValues);
                this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mTempValues);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setup(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                int size = this.mConstraintAttributeList.size();
                int noOfInterpValues = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
                double[] dArr = new double[size];
                this.mTempValues = new float[noOfInterpValues];
                double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, noOfInterpValues);
                for (int i3 = 0; i3 < size; i3++) {
                    dArr[i3] = this.mConstraintAttributeList.keyAt(i3) * 0.01d;
                    this.mConstraintAttributeList.valueAt(i3).getValuesToInterpolate(this.mTempValues);
                    int i4 = 0;
                    while (true) {
                        float[] fArr = this.mTempValues;
                        if (i4 < fArr.length) {
                            dArr2[i3][i4] = fArr[i4];
                            i4++;
                        }
                    }
                }
                this.mCurveFit = CurveFit.get(i2, dArr, dArr2);
            }
        }

        public void setPoint(int i2, ConstraintAttribute constraintAttribute) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, constraintAttribute) == null) {
                this.mConstraintAttributeList.append(i2, constraintAttribute);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) || Build.VERSION.SDK_INT < 21) {
                return;
            }
            view.setElevation(get(f2));
        }
    }

    /* loaded from: classes.dex */
    public static class PathRotate extends SplineSet {
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

        public void setPathRotate(View view, float f2, double d2, double d3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Float.valueOf(f2), Double.valueOf(d2), Double.valueOf(d3)}) == null) {
                view.setRotation(get(f2) + ((float) Math.toDegrees(Math.atan2(d3, d2))));
            }
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, f2) == null) {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
                view.setPivotX(get(f2));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
                view.setPivotY(get(f2));
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

        @Override // androidx.constraintlayout.motion.widget.SplineSet
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
    public static class RotationSet extends SplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
                view.setRotation(get(f2));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
                view.setRotationX(get(f2));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
                view.setRotationY(get(f2));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
                view.setScaleX(get(f2));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
                view.setScaleY(get(f2));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static void doubleQuickSort(int[] iArr, float[] fArr, int i2, int i3) {
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

        public static int partition(int[] iArr, float[] fArr, int i2, int i3) {
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
    public static class TranslationXset extends SplineSet {
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

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
                view.setTranslationX(get(f2));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
                view.setTranslationY(get(f2));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) || Build.VERSION.SDK_INT < 21) {
                return;
            }
            view.setTranslationZ(get(f2));
        }
    }

    public SplineSet() {
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
        this.mTimePoints = new int[10];
        this.mValues = new float[10];
    }

    public static SplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, sparseArray)) == null) ? new CustomSet(str, sparseArray) : (SplineSet) invokeLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static SplineSet makeSpline(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
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
                        c2 = '\f';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1225497656:
                    if (str.equals(Key.TRANSLATION_Y)) {
                        c2 = CharUtils.CR;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1225497655:
                    if (str.equals(Key.TRANSLATION_Z)) {
                        c2 = 14;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        c2 = 15;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -908189618:
                    if (str.equals(Key.SCALE_X)) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -908189617:
                    if (str.equals(Key.SCALE_Y)) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -797520672:
                    if (str.equals(Key.WAVE_VARIES_BY)) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -760884510:
                    if (str.equals(Key.PIVOT_X)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -760884509:
                    if (str.equals(Key.PIVOT_Y)) {
                        c2 = 6;
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
                        c2 = 7;
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
                case 156108012:
                    if (str.equals(Key.WAVE_OFFSET)) {
                        c2 = '\n';
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

    public float get(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? (float) this.mCurveFit.getPos(f2, 0) : invokeF.floatValue;
    }

    public CurveFit getCurveFit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCurveFit : (CurveFit) invokeV.objValue;
    }

    public float getSlope(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2)) == null) ? (float) this.mCurveFit.getSlope(f2, 0) : invokeF.floatValue;
    }

    public void setPoint(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            int[] iArr = this.mTimePoints;
            if (iArr.length < this.count + 1) {
                this.mTimePoints = Arrays.copyOf(iArr, iArr.length * 2);
                float[] fArr = this.mValues;
                this.mValues = Arrays.copyOf(fArr, fArr.length * 2);
            }
            int[] iArr2 = this.mTimePoints;
            int i3 = this.count;
            iArr2[i3] = i2;
            this.mValues[i3] = f2;
            this.count = i3 + 1;
        }
    }

    public abstract void setProperty(View view, float f2);

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.mType = str;
        }
    }

    public void setup(int i2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (i3 = this.count) == 0) {
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i3 - 1);
        int i5 = 1;
        for (int i6 = 1; i6 < this.count; i6++) {
            int[] iArr = this.mTimePoints;
            if (iArr[i6 - 1] != iArr[i6]) {
                i5++;
            }
        }
        double[] dArr = new double[i5];
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, i5, 1);
        int i7 = 0;
        while (i4 < this.count) {
            if (i4 > 0) {
                int[] iArr2 = this.mTimePoints;
                i4 = iArr2[i4] == iArr2[i4 + (-1)] ? i4 + 1 : 0;
            }
            dArr[i7] = this.mTimePoints[i4] * 0.01d;
            dArr2[i7][0] = this.mValues[i4];
            i7++;
        }
        this.mCurveFit = CurveFit.get(i2, dArr, dArr2);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
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

package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    public static final int OFF_HEIGHT = 4;
    public static final int OFF_PATH_ROTATE = 5;
    public static final int OFF_POSITION = 0;
    public static final int OFF_WIDTH = 3;
    public static final int OFF_X = 1;
    public static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 3;
    public static final String TAG = "MotionPaths";
    public static String[] names;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedHashMap<String, ConstraintAttribute> attributes;
    public float height;
    public int mDrawPath;
    public Easing mKeyFrameEasing;
    public int mMode;
    public int mPathMotionArc;
    public float mPathRotate;
    public float mProgress;
    public double[] mTempDelta;
    public double[] mTempValue;
    public float position;
    public float time;
    public float width;
    public float x;
    public float y;

    public static final float xRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) ? (((f5 - f3) * f2) - ((f6 - f4) * f)) + f3 : invokeCommon.floatValue;
    }

    public static final float yRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) ? ((f5 - f3) * f) + ((f6 - f4) * f2) + f4 : invokeCommon.floatValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2147293059, "Landroidx/constraintlayout/motion/widget/MotionPaths;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2147293059, "Landroidx/constraintlayout/motion/widget/MotionPaths;");
                return;
            }
        }
        names = new String[]{CriusAttrConstants.POSITION, "x", "y", "width", "height", "pathRotate"};
    }

    public MotionPaths() {
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
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    public MotionPaths(int i, int i2, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), keyPosition, motionPaths, motionPaths2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        int i5 = keyPosition.mPositionType;
        if (i5 != 1) {
            if (i5 != 2) {
                initCartesian(keyPosition, motionPaths, motionPaths2);
                return;
            } else {
                initScreen(i, i2, keyPosition, motionPaths, motionPaths2);
                return;
            }
        }
        initPath(keyPosition, motionPaths, motionPaths2);
    }

    private boolean diff(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (!Float.isNaN(f) && !Float.isNaN(f2)) {
                if (Math.abs(f - f2) > 1.0E-6f) {
                    return true;
                }
                return false;
            } else if (Float.isNaN(f) != Float.isNaN(f2)) {
                return true;
            } else {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, constraint) == null) {
            this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
            ConstraintSet.Motion motion = constraint.motion;
            this.mPathMotionArc = motion.mPathMotionArc;
            this.mPathRotate = motion.mPathRotate;
            this.mDrawPath = motion.mDrawPath;
            this.mProgress = constraint.propertySet.mProgress;
            for (String str : constraint.mCustomConstraints.keySet()) {
                ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(str);
                if (constraintAttribute.getType() != ConstraintAttribute.AttributeType.STRING_TYPE) {
                    this.attributes.put(str, constraintAttribute);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull MotionPaths motionPaths) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionPaths)) == null) {
            return Float.compare(this.position, motionPaths.position);
        }
        return invokeL.intValue;
    }

    public int getCustomDataCount(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            return this.attributes.get(str).noOfInterpValues();
        }
        return invokeL.intValue;
    }

    public boolean hasCustomData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            return this.attributes.containsKey(str);
        }
        return invokeL.booleanValue;
    }

    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{motionPaths, zArr, strArr, Boolean.valueOf(z)}) == null) {
            zArr[0] = zArr[0] | diff(this.position, motionPaths.position);
            zArr[1] = zArr[1] | diff(this.x, motionPaths.x) | z;
            zArr[2] = z | diff(this.y, motionPaths.y) | zArr[2];
            zArr[3] = zArr[3] | diff(this.width, motionPaths.width);
            zArr[4] = diff(this.height, motionPaths.height) | zArr[4];
        }
    }

    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048585, this, iArr, dArr, fArr, i) == null) {
            float f = this.x;
            float f2 = this.y;
            float f3 = this.width;
            float f4 = this.height;
            for (int i2 = 0; i2 < iArr.length; i2++) {
                float f5 = (float) dArr[i2];
                int i3 = iArr[i2];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                f4 = f5;
                            }
                        } else {
                            f3 = f5;
                        }
                    } else {
                        f2 = f5;
                    }
                } else {
                    f = f5;
                }
            }
            float f6 = f3 + f;
            float f7 = f4 + f2;
            Float.isNaN(Float.NaN);
            Float.isNaN(Float.NaN);
            int i4 = i + 1;
            fArr[i] = f + 0.0f;
            int i5 = i4 + 1;
            fArr[i4] = f2 + 0.0f;
            int i6 = i5 + 1;
            fArr[i5] = f6 + 0.0f;
            int i7 = i6 + 1;
            fArr[i6] = f2 + 0.0f;
            int i8 = i7 + 1;
            fArr[i7] = f6 + 0.0f;
            int i9 = i8 + 1;
            fArr[i8] = f7 + 0.0f;
            fArr[i9] = f + 0.0f;
            fArr[i9 + 1] = f7 + 0.0f;
        }
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, dArr, iArr) == null) {
            float[] fArr = {this.position, this.x, this.y, this.width, this.height, this.mPathRotate};
            int i = 0;
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (iArr[i2] < 6) {
                    dArr[i] = fArr[iArr[i2]];
                    i++;
                }
            }
        }
    }

    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048581, this, iArr, dArr, fArr, i) == null) {
            float f = this.width;
            float f2 = this.height;
            for (int i2 = 0; i2 < iArr.length; i2++) {
                float f3 = (float) dArr[i2];
                int i3 = iArr[i2];
                if (i3 != 3) {
                    if (i3 == 4) {
                        f2 = f3;
                    }
                } else {
                    f = f3;
                }
            }
            fArr[i] = f;
            fArr[i + 1] = f2;
        }
    }

    public void getCenter(int[] iArr, double[] dArr, float[] fArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048582, this, iArr, dArr, fArr, i) == null) {
            float f = this.x;
            float f2 = this.y;
            float f3 = this.width;
            float f4 = this.height;
            for (int i2 = 0; i2 < iArr.length; i2++) {
                float f5 = (float) dArr[i2];
                int i3 = iArr[i2];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                f4 = f5;
                            }
                        } else {
                            f3 = f5;
                        }
                    } else {
                        f2 = f5;
                    }
                } else {
                    f = f5;
                }
            }
            fArr[i] = f + (f3 / 2.0f) + 0.0f;
            fArr[i + 1] = f2 + (f4 / 2.0f) + 0.0f;
        }
    }

    public void setBounds(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.x = f;
            this.y = f2;
            this.width = f3;
            this.height = f4;
        }
    }

    public int getCustomData(String str, double[] dArr, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048583, this, str, dArr, i)) == null) {
            ConstraintAttribute constraintAttribute = this.attributes.get(str);
            if (constraintAttribute.noOfInterpValues() == 1) {
                dArr[i] = constraintAttribute.getValueToInterpolate();
                return 1;
            }
            int noOfInterpValues = constraintAttribute.noOfInterpValues();
            float[] fArr = new float[noOfInterpValues];
            constraintAttribute.getValuesToInterpolate(fArr);
            int i2 = 0;
            while (i2 < noOfInterpValues) {
                dArr[i] = fArr[i2];
                i2++;
                i++;
            }
            return noOfInterpValues;
        }
        return invokeLLI.intValue;
    }

    public void initCartesian(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, keyPosition, motionPaths, motionPaths2) == null) {
            float f5 = keyPosition.mFramePosition / 100.0f;
            this.time = f5;
            this.mDrawPath = keyPosition.mDrawPath;
            if (Float.isNaN(keyPosition.mPercentWidth)) {
                f = f5;
            } else {
                f = keyPosition.mPercentWidth;
            }
            if (Float.isNaN(keyPosition.mPercentHeight)) {
                f2 = f5;
            } else {
                f2 = keyPosition.mPercentHeight;
            }
            float f6 = motionPaths2.width;
            float f7 = motionPaths.width;
            float f8 = motionPaths2.height;
            float f9 = motionPaths.height;
            this.position = this.time;
            float f10 = motionPaths.x;
            float f11 = motionPaths.y;
            float f12 = motionPaths2.x + (f6 / 2.0f);
            float f13 = f12 - ((f7 / 2.0f) + f10);
            float f14 = (motionPaths2.y + (f8 / 2.0f)) - (f11 + (f9 / 2.0f));
            float f15 = (f6 - f7) * f;
            float f16 = f15 / 2.0f;
            this.x = (int) ((f10 + (f13 * f5)) - f16);
            float f17 = (f8 - f9) * f2;
            float f18 = f17 / 2.0f;
            this.y = (int) ((f11 + (f14 * f5)) - f18);
            this.width = (int) (f7 + f15);
            this.height = (int) (f9 + f17);
            if (Float.isNaN(keyPosition.mPercentX)) {
                f3 = f5;
            } else {
                f3 = keyPosition.mPercentX;
            }
            float f19 = 0.0f;
            if (Float.isNaN(keyPosition.mAltPercentY)) {
                f4 = 0.0f;
            } else {
                f4 = keyPosition.mAltPercentY;
            }
            if (!Float.isNaN(keyPosition.mPercentY)) {
                f5 = keyPosition.mPercentY;
            }
            if (!Float.isNaN(keyPosition.mAltPercentX)) {
                f19 = keyPosition.mAltPercentX;
            }
            this.mMode = 2;
            this.x = (int) (((motionPaths.x + (f3 * f13)) + (f19 * f14)) - f16);
            this.y = (int) (((motionPaths.y + (f13 * f4)) + (f14 * f5)) - f18);
            this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
            this.mPathMotionArc = keyPosition.mPathMotionArc;
        }
    }

    public void initPath(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, keyPosition, motionPaths, motionPaths2) == null) {
            float f6 = keyPosition.mFramePosition / 100.0f;
            this.time = f6;
            this.mDrawPath = keyPosition.mDrawPath;
            if (Float.isNaN(keyPosition.mPercentWidth)) {
                f = f6;
            } else {
                f = keyPosition.mPercentWidth;
            }
            if (Float.isNaN(keyPosition.mPercentHeight)) {
                f2 = f6;
            } else {
                f2 = keyPosition.mPercentHeight;
            }
            float f7 = motionPaths2.width - motionPaths.width;
            float f8 = motionPaths2.height - motionPaths.height;
            this.position = this.time;
            if (!Float.isNaN(keyPosition.mPercentX)) {
                f6 = keyPosition.mPercentX;
            }
            float f9 = motionPaths.x;
            float f10 = motionPaths.width;
            float f11 = motionPaths.y;
            float f12 = motionPaths.height;
            float f13 = (motionPaths2.x + (motionPaths2.width / 2.0f)) - ((f10 / 2.0f) + f9);
            float f14 = (motionPaths2.y + (motionPaths2.height / 2.0f)) - ((f12 / 2.0f) + f11);
            float f15 = f13 * f6;
            float f16 = (f7 * f) / 2.0f;
            this.x = (int) ((f9 + f15) - f16);
            float f17 = f6 * f14;
            float f18 = (f8 * f2) / 2.0f;
            this.y = (int) ((f11 + f17) - f18);
            this.width = (int) (f10 + f3);
            this.height = (int) (f12 + f4);
            if (Float.isNaN(keyPosition.mPercentY)) {
                f5 = 0.0f;
            } else {
                f5 = keyPosition.mPercentY;
            }
            this.mMode = 1;
            float f19 = (int) ((motionPaths.x + f15) - f16);
            this.x = f19;
            float f20 = (int) ((motionPaths.y + f17) - f18);
            this.y = f20;
            this.x = f19 + ((-f14) * f5);
            this.y = f20 + (f13 * f5);
            this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
            this.mPathMotionArc = keyPosition.mPathMotionArc;
        }
    }

    public void initScreen(int i, int i2, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), keyPosition, motionPaths, motionPaths2}) == null) {
            float f3 = keyPosition.mFramePosition / 100.0f;
            this.time = f3;
            this.mDrawPath = keyPosition.mDrawPath;
            if (Float.isNaN(keyPosition.mPercentWidth)) {
                f = f3;
            } else {
                f = keyPosition.mPercentWidth;
            }
            if (Float.isNaN(keyPosition.mPercentHeight)) {
                f2 = f3;
            } else {
                f2 = keyPosition.mPercentHeight;
            }
            float f4 = motionPaths2.width;
            float f5 = motionPaths.width;
            float f6 = motionPaths2.height;
            float f7 = motionPaths.height;
            this.position = this.time;
            float f8 = motionPaths.x;
            float f9 = motionPaths.y;
            float f10 = motionPaths2.x + (f4 / 2.0f);
            float f11 = motionPaths2.y + (f6 / 2.0f);
            float f12 = (f4 - f5) * f;
            this.x = (int) ((f8 + ((f10 - ((f5 / 2.0f) + f8)) * f3)) - (f12 / 2.0f));
            float f13 = (f6 - f7) * f2;
            this.y = (int) ((f9 + ((f11 - (f9 + (f7 / 2.0f))) * f3)) - (f13 / 2.0f));
            this.width = (int) (f5 + f12);
            this.height = (int) (f7 + f13);
            this.mMode = 3;
            if (!Float.isNaN(keyPosition.mPercentX)) {
                this.x = (int) (keyPosition.mPercentX * ((int) (i - this.width)));
            }
            if (!Float.isNaN(keyPosition.mPercentY)) {
                this.y = (int) (keyPosition.mPercentY * ((int) (i2 - this.height)));
            }
            this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
            this.mPathMotionArc = keyPosition.mPathMotionArc;
        }
    }

    public void setView(View view2, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        boolean z;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048592, this, view2, iArr, dArr, dArr2, dArr3) == null) {
            float f2 = this.x;
            float f3 = this.y;
            float f4 = this.width;
            float f5 = this.height;
            if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
                int i = iArr[iArr.length - 1] + 1;
                this.mTempValue = new double[i];
                this.mTempDelta = new double[i];
            }
            Arrays.fill(this.mTempValue, Double.NaN);
            for (int i2 = 0; i2 < iArr.length; i2++) {
                this.mTempValue[iArr[i2]] = dArr[i2];
                this.mTempDelta[iArr[i2]] = dArr2[i2];
            }
            int i3 = 0;
            float f6 = Float.NaN;
            float f7 = 0.0f;
            float f8 = 0.0f;
            float f9 = 0.0f;
            float f10 = 0.0f;
            while (true) {
                double[] dArr4 = this.mTempValue;
                if (i3 >= dArr4.length) {
                    break;
                }
                double d = 0.0d;
                if (Double.isNaN(dArr4[i3]) && (dArr3 == null || dArr3[i3] == 0.0d)) {
                    f = f2;
                } else {
                    if (dArr3 != null) {
                        d = dArr3[i3];
                    }
                    if (!Double.isNaN(this.mTempValue[i3])) {
                        d = this.mTempValue[i3] + d;
                    }
                    f = f2;
                    float f11 = (float) d;
                    float f12 = (float) this.mTempDelta[i3];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 != 4) {
                                    if (i3 == 5) {
                                        f2 = f;
                                        f6 = f11;
                                    }
                                } else {
                                    f5 = f11;
                                    f10 = f12;
                                }
                            } else {
                                f4 = f11;
                                f8 = f12;
                            }
                        } else {
                            f3 = f11;
                            f9 = f12;
                        }
                    } else {
                        f7 = f12;
                        f2 = f11;
                    }
                    i3++;
                }
                f2 = f;
                i3++;
            }
            float f13 = f2;
            if (Float.isNaN(f6)) {
                if (!Float.isNaN(Float.NaN)) {
                    view2.setRotation(Float.NaN);
                }
            } else {
                float f14 = Float.NaN;
                if (Float.isNaN(Float.NaN)) {
                    f14 = 0.0f;
                }
                view2.setRotation((float) (f14 + f6 + Math.toDegrees(Math.atan2(f9 + (f10 / 2.0f), f7 + (f8 / 2.0f)))));
            }
            float f15 = f13 + 0.5f;
            int i4 = (int) f15;
            float f16 = f3 + 0.5f;
            int i5 = (int) f16;
            int i6 = (int) (f15 + f4);
            int i7 = (int) (f16 + f5);
            int i8 = i6 - i4;
            int i9 = i7 - i5;
            if (i8 == view2.getMeasuredWidth() && i9 == view2.getMeasuredHeight()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i9, 1073741824));
            }
            view2.layout(i4, i5, i6, i7);
        }
    }

    public void setDpDt(float f, float f2, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), fArr, iArr, dArr, dArr2}) == null) {
            float f3 = 0.0f;
            float f4 = 0.0f;
            float f5 = 0.0f;
            float f6 = 0.0f;
            for (int i = 0; i < iArr.length; i++) {
                float f7 = (float) dArr[i];
                double d = dArr2[i];
                int i2 = iArr[i];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 == 4) {
                                f6 = f7;
                            }
                        } else {
                            f4 = f7;
                        }
                    } else {
                        f5 = f7;
                    }
                } else {
                    f3 = f7;
                }
            }
            float f8 = f3 - ((0.0f * f4) / 2.0f);
            float f9 = f5 - ((0.0f * f6) / 2.0f);
            fArr[0] = (f8 * (1.0f - f)) + (((f4 * 1.0f) + f8) * f) + 0.0f;
            fArr[1] = (f9 * (1.0f - f2)) + (((f6 * 1.0f) + f9) * f2) + 0.0f;
        }
    }
}

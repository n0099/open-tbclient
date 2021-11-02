package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
        names = new String[]{"position", "x", "y", "width", "height", "pathRotate"};
    }

    public MotionPaths() {
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
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? (Float.isNaN(f2) || Float.isNaN(f3)) ? Float.isNaN(f2) != Float.isNaN(f3) : Math.abs(f2 - f3) > 1.0E-6f : invokeCommon.booleanValue;
    }

    public static final float xRotate(float f2, float f3, float f4, float f5, float f6, float f7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)})) == null) ? (((f6 - f4) * f3) - ((f7 - f5) * f2)) + f4 : invokeCommon.floatValue;
    }

    public static final float yRotate(float f2, float f3, float f4, float f5, float f6, float f7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)})) == null) ? ((f6 - f4) * f2) + ((f7 - f5) * f3) + f5 : invokeCommon.floatValue;
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

    public void fillStandard(double[] dArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, dArr, iArr) == null) {
            float[] fArr = {this.position, this.x, this.y, this.width, this.height, this.mPathRotate};
            int i2 = 0;
            for (int i3 = 0; i3 < iArr.length; i3++) {
                if (iArr[i3] < 6) {
                    dArr[i2] = fArr[iArr[i3]];
                    i2++;
                }
            }
        }
    }

    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048581, this, iArr, dArr, fArr, i2) == null) {
            float f2 = this.width;
            float f3 = this.height;
            for (int i3 = 0; i3 < iArr.length; i3++) {
                float f4 = (float) dArr[i3];
                int i4 = iArr[i3];
                if (i4 == 3) {
                    f2 = f4;
                } else if (i4 == 4) {
                    f3 = f4;
                }
            }
            fArr[i2] = f2;
            fArr[i2 + 1] = f3;
        }
    }

    public void getCenter(int[] iArr, double[] dArr, float[] fArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048582, this, iArr, dArr, fArr, i2) == null) {
            float f2 = this.x;
            float f3 = this.y;
            float f4 = this.width;
            float f5 = this.height;
            for (int i3 = 0; i3 < iArr.length; i3++) {
                float f6 = (float) dArr[i3];
                int i4 = iArr[i3];
                if (i4 == 1) {
                    f2 = f6;
                } else if (i4 == 2) {
                    f3 = f6;
                } else if (i4 == 3) {
                    f4 = f6;
                } else if (i4 == 4) {
                    f5 = f6;
                }
            }
            fArr[i2] = f2 + (f4 / 2.0f) + 0.0f;
            fArr[i2 + 1] = f3 + (f5 / 2.0f) + 0.0f;
        }
    }

    public int getCustomData(String str, double[] dArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048583, this, str, dArr, i2)) == null) {
            ConstraintAttribute constraintAttribute = this.attributes.get(str);
            if (constraintAttribute.noOfInterpValues() == 1) {
                dArr[i2] = constraintAttribute.getValueToInterpolate();
                return 1;
            }
            int noOfInterpValues = constraintAttribute.noOfInterpValues();
            float[] fArr = new float[noOfInterpValues];
            constraintAttribute.getValuesToInterpolate(fArr);
            int i3 = 0;
            while (i3 < noOfInterpValues) {
                dArr[i2] = fArr[i3];
                i3++;
                i2++;
            }
            return noOfInterpValues;
        }
        return invokeLLI.intValue;
    }

    public int getCustomDataCount(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? this.attributes.get(str).noOfInterpValues() : invokeL.intValue;
    }

    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048585, this, iArr, dArr, fArr, i2) == null) {
            float f2 = this.x;
            float f3 = this.y;
            float f4 = this.width;
            float f5 = this.height;
            for (int i3 = 0; i3 < iArr.length; i3++) {
                float f6 = (float) dArr[i3];
                int i4 = iArr[i3];
                if (i4 == 1) {
                    f2 = f6;
                } else if (i4 == 2) {
                    f3 = f6;
                } else if (i4 == 3) {
                    f4 = f6;
                } else if (i4 == 4) {
                    f5 = f6;
                }
            }
            float f7 = f4 + f2;
            float f8 = f5 + f3;
            Float.isNaN(Float.NaN);
            Float.isNaN(Float.NaN);
            int i5 = i2 + 1;
            fArr[i2] = f2 + 0.0f;
            int i6 = i5 + 1;
            fArr[i5] = f3 + 0.0f;
            int i7 = i6 + 1;
            fArr[i6] = f7 + 0.0f;
            int i8 = i7 + 1;
            fArr[i7] = f3 + 0.0f;
            int i9 = i8 + 1;
            fArr[i8] = f7 + 0.0f;
            int i10 = i9 + 1;
            fArr[i9] = f8 + 0.0f;
            fArr[i10] = f2 + 0.0f;
            fArr[i10 + 1] = f8 + 0.0f;
        }
    }

    public boolean hasCustomData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? this.attributes.containsKey(str) : invokeL.booleanValue;
    }

    public void initCartesian(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, keyPosition, motionPaths, motionPaths2) == null) {
            float f2 = keyPosition.mFramePosition / 100.0f;
            this.time = f2;
            this.mDrawPath = keyPosition.mDrawPath;
            float f3 = Float.isNaN(keyPosition.mPercentWidth) ? f2 : keyPosition.mPercentWidth;
            float f4 = Float.isNaN(keyPosition.mPercentHeight) ? f2 : keyPosition.mPercentHeight;
            float f5 = motionPaths2.width;
            float f6 = motionPaths.width;
            float f7 = motionPaths2.height;
            float f8 = motionPaths.height;
            this.position = this.time;
            float f9 = motionPaths.x;
            float f10 = motionPaths.y;
            float f11 = (motionPaths2.x + (f5 / 2.0f)) - ((f6 / 2.0f) + f9);
            float f12 = (motionPaths2.y + (f7 / 2.0f)) - (f10 + (f8 / 2.0f));
            float f13 = (f5 - f6) * f3;
            float f14 = f13 / 2.0f;
            this.x = (int) ((f9 + (f11 * f2)) - f14);
            float f15 = (f7 - f8) * f4;
            float f16 = f15 / 2.0f;
            this.y = (int) ((f10 + (f12 * f2)) - f16);
            this.width = (int) (f6 + f13);
            this.height = (int) (f8 + f15);
            float f17 = Float.isNaN(keyPosition.mPercentX) ? f2 : keyPosition.mPercentX;
            float f18 = Float.isNaN(keyPosition.mAltPercentY) ? 0.0f : keyPosition.mAltPercentY;
            if (!Float.isNaN(keyPosition.mPercentY)) {
                f2 = keyPosition.mPercentY;
            }
            float f19 = Float.isNaN(keyPosition.mAltPercentX) ? 0.0f : keyPosition.mAltPercentX;
            this.mMode = 2;
            this.x = (int) (((motionPaths.x + (f17 * f11)) + (f19 * f12)) - f14);
            this.y = (int) (((motionPaths.y + (f11 * f18)) + (f12 * f2)) - f16);
            this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
            this.mPathMotionArc = keyPosition.mPathMotionArc;
        }
    }

    public void initPath(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, keyPosition, motionPaths, motionPaths2) == null) {
            float f4 = keyPosition.mFramePosition / 100.0f;
            this.time = f4;
            this.mDrawPath = keyPosition.mDrawPath;
            float f5 = Float.isNaN(keyPosition.mPercentWidth) ? f4 : keyPosition.mPercentWidth;
            float f6 = Float.isNaN(keyPosition.mPercentHeight) ? f4 : keyPosition.mPercentHeight;
            float f7 = motionPaths2.width - motionPaths.width;
            float f8 = motionPaths2.height - motionPaths.height;
            this.position = this.time;
            if (!Float.isNaN(keyPosition.mPercentX)) {
                f4 = keyPosition.mPercentX;
            }
            float f9 = motionPaths.x;
            float f10 = motionPaths.width;
            float f11 = motionPaths.y;
            float f12 = motionPaths.height;
            float f13 = (motionPaths2.x + (motionPaths2.width / 2.0f)) - ((f10 / 2.0f) + f9);
            float f14 = (motionPaths2.y + (motionPaths2.height / 2.0f)) - ((f12 / 2.0f) + f11);
            float f15 = f13 * f4;
            float f16 = (f7 * f5) / 2.0f;
            this.x = (int) ((f9 + f15) - f16);
            float f17 = f4 * f14;
            float f18 = (f8 * f6) / 2.0f;
            this.y = (int) ((f11 + f17) - f18);
            this.width = (int) (f10 + f2);
            this.height = (int) (f12 + f3);
            float f19 = Float.isNaN(keyPosition.mPercentY) ? 0.0f : keyPosition.mPercentY;
            this.mMode = 1;
            float f20 = (int) ((motionPaths.x + f15) - f16);
            this.x = f20;
            float f21 = (int) ((motionPaths.y + f17) - f18);
            this.y = f21;
            this.x = f20 + ((-f14) * f19);
            this.y = f21 + (f13 * f19);
            this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
            this.mPathMotionArc = keyPosition.mPathMotionArc;
        }
    }

    public void initScreen(int i2, int i3, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), keyPosition, motionPaths, motionPaths2}) == null) {
            float f2 = keyPosition.mFramePosition / 100.0f;
            this.time = f2;
            this.mDrawPath = keyPosition.mDrawPath;
            float f3 = Float.isNaN(keyPosition.mPercentWidth) ? f2 : keyPosition.mPercentWidth;
            float f4 = Float.isNaN(keyPosition.mPercentHeight) ? f2 : keyPosition.mPercentHeight;
            float f5 = motionPaths2.width;
            float f6 = motionPaths.width;
            float f7 = motionPaths2.height;
            float f8 = motionPaths.height;
            this.position = this.time;
            float f9 = motionPaths.x;
            float f10 = motionPaths.y;
            float f11 = motionPaths2.x + (f5 / 2.0f);
            float f12 = motionPaths2.y + (f7 / 2.0f);
            float f13 = (f5 - f6) * f3;
            this.x = (int) ((f9 + ((f11 - ((f6 / 2.0f) + f9)) * f2)) - (f13 / 2.0f));
            float f14 = (f7 - f8) * f4;
            this.y = (int) ((f10 + ((f12 - (f10 + (f8 / 2.0f))) * f2)) - (f14 / 2.0f));
            this.width = (int) (f6 + f13);
            this.height = (int) (f8 + f14);
            this.mMode = 3;
            if (!Float.isNaN(keyPosition.mPercentX)) {
                this.x = (int) (keyPosition.mPercentX * ((int) (i2 - this.width)));
            }
            if (!Float.isNaN(keyPosition.mPercentY)) {
                this.y = (int) (keyPosition.mPercentY * ((int) (i3 - this.height)));
            }
            this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
            this.mPathMotionArc = keyPosition.mPathMotionArc;
        }
    }

    public void setBounds(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            this.x = f2;
            this.y = f3;
            this.width = f4;
            this.height = f5;
        }
    }

    public void setDpDt(float f2, float f3, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), fArr, iArr, dArr, dArr2}) == null) {
            float f4 = 0.0f;
            float f5 = 0.0f;
            float f6 = 0.0f;
            float f7 = 0.0f;
            for (int i2 = 0; i2 < iArr.length; i2++) {
                float f8 = (float) dArr[i2];
                double d2 = dArr2[i2];
                int i3 = iArr[i2];
                if (i3 == 1) {
                    f4 = f8;
                } else if (i3 == 2) {
                    f6 = f8;
                } else if (i3 == 3) {
                    f5 = f8;
                } else if (i3 == 4) {
                    f7 = f8;
                }
            }
            float f9 = f4 - ((0.0f * f5) / 2.0f);
            float f10 = f6 - ((0.0f * f7) / 2.0f);
            fArr[0] = (f9 * (1.0f - f2)) + (((f5 * 1.0f) + f9) * f2) + 0.0f;
            fArr[1] = (f10 * (1.0f - f3)) + (((f7 * 1.0f) + f10) * f3) + 0.0f;
        }
    }

    public void setView(View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048592, this, view, iArr, dArr, dArr2, dArr3) == null) {
            float f3 = this.x;
            float f4 = this.y;
            float f5 = this.width;
            float f6 = this.height;
            if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
                int i2 = iArr[iArr.length - 1] + 1;
                this.mTempValue = new double[i2];
                this.mTempDelta = new double[i2];
            }
            Arrays.fill(this.mTempValue, Double.NaN);
            for (int i3 = 0; i3 < iArr.length; i3++) {
                this.mTempValue[iArr[i3]] = dArr[i3];
                this.mTempDelta[iArr[i3]] = dArr2[i3];
            }
            int i4 = 0;
            float f7 = Float.NaN;
            float f8 = 0.0f;
            float f9 = 0.0f;
            float f10 = 0.0f;
            float f11 = 0.0f;
            while (true) {
                double[] dArr4 = this.mTempValue;
                if (i4 >= dArr4.length) {
                    break;
                }
                if (Double.isNaN(dArr4[i4]) && (dArr3 == null || dArr3[i4] == 0.0d)) {
                    f2 = f3;
                } else {
                    double d2 = dArr3 != null ? dArr3[i4] : 0.0d;
                    if (!Double.isNaN(this.mTempValue[i4])) {
                        d2 = this.mTempValue[i4] + d2;
                    }
                    f2 = f3;
                    float f12 = (float) d2;
                    float f13 = (float) this.mTempDelta[i4];
                    if (i4 == 1) {
                        f8 = f13;
                        f3 = f12;
                    } else if (i4 == 2) {
                        f4 = f12;
                        f10 = f13;
                    } else if (i4 == 3) {
                        f5 = f12;
                        f9 = f13;
                    } else if (i4 == 4) {
                        f6 = f12;
                        f11 = f13;
                    } else if (i4 == 5) {
                        f3 = f2;
                        f7 = f12;
                    }
                    i4++;
                }
                f3 = f2;
                i4++;
            }
            float f14 = f3;
            if (Float.isNaN(f7)) {
                if (!Float.isNaN(Float.NaN)) {
                    view.setRotation(Float.NaN);
                }
            } else {
                view.setRotation((float) ((Float.isNaN(Float.NaN) ? 0.0f : Float.NaN) + f7 + Math.toDegrees(Math.atan2(f10 + (f11 / 2.0f), f8 + (f9 / 2.0f)))));
            }
            float f15 = f14 + 0.5f;
            int i5 = (int) f15;
            float f16 = f4 + 0.5f;
            int i6 = (int) f16;
            int i7 = (int) (f15 + f5);
            int i8 = (int) (f16 + f6);
            int i9 = i7 - i5;
            int i10 = i8 - i6;
            if ((i9 == view.getMeasuredWidth() && i10 == view.getMeasuredHeight()) ? false : true) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i9, 1073741824), View.MeasureSpec.makeMeasureSpec(i10, 1073741824));
            }
            view.layout(i5, i6, i7, i8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull MotionPaths motionPaths) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionPaths)) == null) ? Float.compare(this.position, motionPaths.position) : invokeL.intValue;
    }

    public MotionPaths(int i2, int i3, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), keyPosition, motionPaths, motionPaths2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
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
        int i6 = keyPosition.mPositionType;
        if (i6 == 1) {
            initPath(keyPosition, motionPaths, motionPaths2);
        } else if (i6 != 2) {
            initCartesian(keyPosition, motionPaths, motionPaths2);
        } else {
            initScreen(i2, i3, keyPosition, motionPaths, motionPaths2);
        }
    }
}

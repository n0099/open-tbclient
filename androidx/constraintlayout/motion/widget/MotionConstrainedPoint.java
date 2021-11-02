package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.view.View;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import org.apache.commons.lang3.CharUtils;
/* loaded from: classes.dex */
public class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    public static final int PERPENDICULAR = 1;
    public static final String TAG = "MotionPaths";
    public static String[] names;
    public transient /* synthetic */ FieldHolder $fh;
    public float alpha;
    public boolean applyElevation;
    public LinkedHashMap<String, ConstraintAttribute> attributes;
    public float elevation;
    public float height;
    public int mDrawPath;
    public Easing mKeyFrameEasing;
    public int mMode;
    public float mPathRotate;
    public float mPivotX;
    public float mPivotY;
    public float mProgress;
    public double[] mTempDelta;
    public double[] mTempValue;
    public int mVisibilityMode;
    public float position;
    public float rotation;
    public float rotationX;
    public float rotationY;
    public float scaleX;
    public float scaleY;
    public float translationX;
    public float translationY;
    public float translationZ;
    public int visibility;
    public float width;
    public float x;
    public float y;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1758901355, "Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1758901355, "Landroidx/constraintlayout/motion/widget/MotionConstrainedPoint;");
                return;
            }
        }
        names = new String[]{"position", "x", "y", "width", "height", "pathRotate"};
    }

    public MotionConstrainedPoint() {
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
        this.alpha = 1.0f;
        this.mVisibilityMode = 0;
        this.applyElevation = false;
        this.elevation = 0.0f;
        this.rotation = 0.0f;
        this.rotationX = 0.0f;
        this.rotationY = 0.0f;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        this.translationX = 0.0f;
        this.translationY = 0.0f;
        this.translationZ = 0.0f;
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? (Float.isNaN(f2) || Float.isNaN(f3)) ? Float.isNaN(f2) != Float.isNaN(f3) : Math.abs(f2 - f3) > 1.0E-6f : invokeCommon.booleanValue;
    }

    public void addValues(HashMap<String, SplineSet> hashMap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, hashMap, i2) == null) {
            for (String str : hashMap.keySet()) {
                SplineSet splineSet = hashMap.get(str);
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
                            c2 = 11;
                            break;
                        }
                        break;
                    case -1225497656:
                        if (str.equals(Key.TRANSLATION_Y)) {
                            c2 = '\f';
                            break;
                        }
                        break;
                    case -1225497655:
                        if (str.equals(Key.TRANSLATION_Z)) {
                            c2 = CharUtils.CR;
                            break;
                        }
                        break;
                    case -1001078227:
                        if (str.equals("progress")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case -908189618:
                        if (str.equals(Key.SCALE_X)) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case -908189617:
                        if (str.equals(Key.SCALE_Y)) {
                            c2 = '\n';
                            break;
                        }
                        break;
                    case -760884510:
                        if (str.equals(Key.PIVOT_X)) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case -760884509:
                        if (str.equals(Key.PIVOT_Y)) {
                            c2 = 6;
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
                            c2 = 7;
                            break;
                        }
                        break;
                    case 92909918:
                        if (str.equals(Key.ALPHA)) {
                            c2 = 0;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        splineSet.setPoint(i2, Float.isNaN(this.alpha) ? 1.0f : this.alpha);
                        break;
                    case 1:
                        splineSet.setPoint(i2, Float.isNaN(this.elevation) ? 0.0f : this.elevation);
                        break;
                    case 2:
                        splineSet.setPoint(i2, Float.isNaN(this.rotation) ? 0.0f : this.rotation);
                        break;
                    case 3:
                        splineSet.setPoint(i2, Float.isNaN(this.rotationX) ? 0.0f : this.rotationX);
                        break;
                    case 4:
                        splineSet.setPoint(i2, Float.isNaN(this.rotationY) ? 0.0f : this.rotationY);
                        break;
                    case 5:
                        splineSet.setPoint(i2, Float.isNaN(this.mPivotX) ? 0.0f : this.mPivotX);
                        break;
                    case 6:
                        splineSet.setPoint(i2, Float.isNaN(this.mPivotY) ? 0.0f : this.mPivotY);
                        break;
                    case 7:
                        splineSet.setPoint(i2, Float.isNaN(this.mPathRotate) ? 0.0f : this.mPathRotate);
                        break;
                    case '\b':
                        splineSet.setPoint(i2, Float.isNaN(this.mProgress) ? 0.0f : this.mProgress);
                        break;
                    case '\t':
                        splineSet.setPoint(i2, Float.isNaN(this.scaleX) ? 1.0f : this.scaleX);
                        break;
                    case '\n':
                        splineSet.setPoint(i2, Float.isNaN(this.scaleY) ? 1.0f : this.scaleY);
                        break;
                    case 11:
                        splineSet.setPoint(i2, Float.isNaN(this.translationX) ? 0.0f : this.translationX);
                        break;
                    case '\f':
                        splineSet.setPoint(i2, Float.isNaN(this.translationY) ? 0.0f : this.translationY);
                        break;
                    case '\r':
                        splineSet.setPoint(i2, Float.isNaN(this.translationZ) ? 0.0f : this.translationZ);
                        break;
                    default:
                        if (!str.startsWith(Key.CUSTOM)) {
                            String str2 = "UNKNOWN spline " + str;
                            break;
                        } else {
                            String str3 = str.split(",")[1];
                            if (!this.attributes.containsKey(str3)) {
                                String str4 = "UNKNOWN customName " + str3;
                                break;
                            } else {
                                ConstraintAttribute constraintAttribute = this.attributes.get(str3);
                                if (!(splineSet instanceof SplineSet.CustomSet)) {
                                    String str5 = str + " splineSet not a CustomSet frame = " + i2 + ", value" + constraintAttribute.getValueToInterpolate() + splineSet;
                                    break;
                                } else {
                                    ((SplineSet.CustomSet) splineSet).setPoint(i2, constraintAttribute);
                                    break;
                                }
                            }
                        }
                }
            }
        }
    }

    public void applyParameters(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.visibility = view.getVisibility();
            this.alpha = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
            this.applyElevation = false;
            if (Build.VERSION.SDK_INT >= 21) {
                this.elevation = view.getElevation();
            }
            this.rotation = view.getRotation();
            this.rotationX = view.getRotationX();
            this.rotationY = view.getRotationY();
            this.scaleX = view.getScaleX();
            this.scaleY = view.getScaleY();
            this.mPivotX = view.getPivotX();
            this.mPivotY = view.getPivotY();
            this.translationX = view.getTranslationX();
            this.translationY = view.getTranslationY();
            if (Build.VERSION.SDK_INT >= 21) {
                this.translationZ = view.getTranslationZ();
            }
        }
    }

    public void different(MotionConstrainedPoint motionConstrainedPoint, HashSet<String> hashSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, motionConstrainedPoint, hashSet) == null) {
            if (diff(this.alpha, motionConstrainedPoint.alpha)) {
                hashSet.add(Key.ALPHA);
            }
            if (diff(this.elevation, motionConstrainedPoint.elevation)) {
                hashSet.add(Key.ELEVATION);
            }
            int i2 = this.visibility;
            int i3 = motionConstrainedPoint.visibility;
            if (i2 != i3 && this.mVisibilityMode == 0 && (i2 == 0 || i3 == 0)) {
                hashSet.add(Key.ALPHA);
            }
            if (diff(this.rotation, motionConstrainedPoint.rotation)) {
                hashSet.add(Key.ROTATION);
            }
            if (!Float.isNaN(this.mPathRotate) || !Float.isNaN(motionConstrainedPoint.mPathRotate)) {
                hashSet.add(Key.TRANSITION_PATH_ROTATE);
            }
            if (!Float.isNaN(this.mProgress) || !Float.isNaN(motionConstrainedPoint.mProgress)) {
                hashSet.add("progress");
            }
            if (diff(this.rotationX, motionConstrainedPoint.rotationX)) {
                hashSet.add(Key.ROTATION_X);
            }
            if (diff(this.rotationY, motionConstrainedPoint.rotationY)) {
                hashSet.add(Key.ROTATION_Y);
            }
            if (diff(this.mPivotX, motionConstrainedPoint.mPivotX)) {
                hashSet.add(Key.PIVOT_X);
            }
            if (diff(this.mPivotY, motionConstrainedPoint.mPivotY)) {
                hashSet.add(Key.PIVOT_Y);
            }
            if (diff(this.scaleX, motionConstrainedPoint.scaleX)) {
                hashSet.add(Key.SCALE_X);
            }
            if (diff(this.scaleY, motionConstrainedPoint.scaleY)) {
                hashSet.add(Key.SCALE_Y);
            }
            if (diff(this.translationX, motionConstrainedPoint.translationX)) {
                hashSet.add(Key.TRANSLATION_X);
            }
            if (diff(this.translationY, motionConstrainedPoint.translationY)) {
                hashSet.add(Key.TRANSLATION_Y);
            }
            if (diff(this.translationZ, motionConstrainedPoint.translationZ)) {
                hashSet.add(Key.TRANSLATION_Z);
            }
        }
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, dArr, iArr) == null) {
            float[] fArr = {this.position, this.x, this.y, this.width, this.height, this.alpha, this.elevation, this.rotation, this.rotationX, this.rotationY, this.scaleX, this.scaleY, this.mPivotX, this.mPivotY, this.translationX, this.translationY, this.translationZ, this.mPathRotate};
            int i2 = 0;
            for (int i3 = 0; i3 < iArr.length; i3++) {
                if (iArr[i3] < 18) {
                    dArr[i2] = fArr[iArr[i3]];
                    i2++;
                }
            }
        }
    }

    public int getCustomData(String str, double[] dArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, dArr, i2)) == null) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? this.attributes.get(str).noOfInterpValues() : invokeL.intValue;
    }

    public boolean hasCustomData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? this.attributes.containsKey(str) : invokeL.booleanValue;
    }

    public void setBounds(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            this.x = f2;
            this.y = f3;
            this.width = f4;
            this.height = f5;
        }
    }

    public void setState(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
            applyParameters(view);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionConstrainedPoint)) == null) ? Float.compare(this.position, motionConstrainedPoint.position) : invokeL.intValue;
    }

    public void setState(ConstraintWidget constraintWidget, ConstraintSet constraintSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048589, this, constraintWidget, constraintSet, i2) == null) {
            setBounds(constraintWidget.getX(), constraintWidget.getY(), constraintWidget.getWidth(), constraintWidget.getHeight());
            applyParameters(constraintSet.getParameters(i2));
        }
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, constraint) == null) {
            ConstraintSet.PropertySet propertySet = constraint.propertySet;
            int i2 = propertySet.mVisibilityMode;
            this.mVisibilityMode = i2;
            int i3 = propertySet.visibility;
            this.visibility = i3;
            this.alpha = (i3 == 0 || i2 != 0) ? constraint.propertySet.alpha : 0.0f;
            ConstraintSet.Transform transform = constraint.transform;
            this.applyElevation = transform.applyElevation;
            this.elevation = transform.elevation;
            this.rotation = transform.rotation;
            this.rotationX = transform.rotationX;
            this.rotationY = transform.rotationY;
            this.scaleX = transform.scaleX;
            this.scaleY = transform.scaleY;
            this.mPivotX = transform.transformPivotX;
            this.mPivotY = transform.transformPivotY;
            this.translationX = transform.translationX;
            this.translationY = transform.translationY;
            this.translationZ = transform.translationZ;
            this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
            ConstraintSet.Motion motion = constraint.motion;
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

    public void different(MotionConstrainedPoint motionConstrainedPoint, boolean[] zArr, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, motionConstrainedPoint, zArr, strArr) == null) {
            zArr[0] = zArr[0] | diff(this.position, motionConstrainedPoint.position);
            zArr[1] = zArr[1] | diff(this.x, motionConstrainedPoint.x);
            zArr[2] = zArr[2] | diff(this.y, motionConstrainedPoint.y);
            zArr[3] = zArr[3] | diff(this.width, motionConstrainedPoint.width);
            zArr[4] = diff(this.height, motionConstrainedPoint.height) | zArr[4];
        }
    }
}

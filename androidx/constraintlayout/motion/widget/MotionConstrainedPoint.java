package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
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
        names = new String[]{CriusAttrConstants.POSITION, "x", "y", "width", "height", "pathRotate"};
    }

    public MotionConstrainedPoint() {
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

    private boolean diff(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
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

    public void addValues(HashMap<String, SplineSet> hashMap, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, hashMap, i) == null) {
            for (String str : hashMap.keySet()) {
                SplineSet splineSet = hashMap.get(str);
                char c = 65535;
                switch (str.hashCode()) {
                    case -1249320806:
                        if (str.equals(Key.ROTATION_X)) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1249320805:
                        if (str.equals(Key.ROTATION_Y)) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1225497657:
                        if (str.equals(Key.TRANSLATION_X)) {
                            c = 11;
                            break;
                        }
                        break;
                    case -1225497656:
                        if (str.equals(Key.TRANSLATION_Y)) {
                            c = '\f';
                            break;
                        }
                        break;
                    case -1225497655:
                        if (str.equals(Key.TRANSLATION_Z)) {
                            c = '\r';
                            break;
                        }
                        break;
                    case -1001078227:
                        if (str.equals("progress")) {
                            c = '\b';
                            break;
                        }
                        break;
                    case -908189618:
                        if (str.equals(Key.SCALE_X)) {
                            c = '\t';
                            break;
                        }
                        break;
                    case -908189617:
                        if (str.equals(Key.SCALE_Y)) {
                            c = '\n';
                            break;
                        }
                        break;
                    case -760884510:
                        if (str.equals(Key.PIVOT_X)) {
                            c = 5;
                            break;
                        }
                        break;
                    case -760884509:
                        if (str.equals(Key.PIVOT_Y)) {
                            c = 6;
                            break;
                        }
                        break;
                    case -40300674:
                        if (str.equals("rotation")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -4379043:
                        if (str.equals(Key.ELEVATION)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 37232917:
                        if (str.equals(Key.TRANSITION_PATH_ROTATE)) {
                            c = 7;
                            break;
                        }
                        break;
                    case 92909918:
                        if (str.equals(Key.ALPHA)) {
                            c = 0;
                            break;
                        }
                        break;
                }
                float f = 1.0f;
                float f2 = 0.0f;
                switch (c) {
                    case 0:
                        if (!Float.isNaN(this.alpha)) {
                            f = this.alpha;
                        }
                        splineSet.setPoint(i, f);
                        break;
                    case 1:
                        if (!Float.isNaN(this.elevation)) {
                            f2 = this.elevation;
                        }
                        splineSet.setPoint(i, f2);
                        break;
                    case 2:
                        if (!Float.isNaN(this.rotation)) {
                            f2 = this.rotation;
                        }
                        splineSet.setPoint(i, f2);
                        break;
                    case 3:
                        if (!Float.isNaN(this.rotationX)) {
                            f2 = this.rotationX;
                        }
                        splineSet.setPoint(i, f2);
                        break;
                    case 4:
                        if (!Float.isNaN(this.rotationY)) {
                            f2 = this.rotationY;
                        }
                        splineSet.setPoint(i, f2);
                        break;
                    case 5:
                        if (!Float.isNaN(this.mPivotX)) {
                            f2 = this.mPivotX;
                        }
                        splineSet.setPoint(i, f2);
                        break;
                    case 6:
                        if (!Float.isNaN(this.mPivotY)) {
                            f2 = this.mPivotY;
                        }
                        splineSet.setPoint(i, f2);
                        break;
                    case 7:
                        if (!Float.isNaN(this.mPathRotate)) {
                            f2 = this.mPathRotate;
                        }
                        splineSet.setPoint(i, f2);
                        break;
                    case '\b':
                        if (!Float.isNaN(this.mProgress)) {
                            f2 = this.mProgress;
                        }
                        splineSet.setPoint(i, f2);
                        break;
                    case '\t':
                        if (!Float.isNaN(this.scaleX)) {
                            f = this.scaleX;
                        }
                        splineSet.setPoint(i, f);
                        break;
                    case '\n':
                        if (!Float.isNaN(this.scaleY)) {
                            f = this.scaleY;
                        }
                        splineSet.setPoint(i, f);
                        break;
                    case 11:
                        if (!Float.isNaN(this.translationX)) {
                            f2 = this.translationX;
                        }
                        splineSet.setPoint(i, f2);
                        break;
                    case '\f':
                        if (!Float.isNaN(this.translationY)) {
                            f2 = this.translationY;
                        }
                        splineSet.setPoint(i, f2);
                        break;
                    case '\r':
                        if (!Float.isNaN(this.translationZ)) {
                            f2 = this.translationZ;
                        }
                        splineSet.setPoint(i, f2);
                        break;
                    default:
                        if (str.startsWith("CUSTOM")) {
                            String str2 = str.split(",")[1];
                            if (this.attributes.containsKey(str2)) {
                                ConstraintAttribute constraintAttribute = this.attributes.get(str2);
                                if (splineSet instanceof SplineSet.CustomSet) {
                                    ((SplineSet.CustomSet) splineSet).setPoint(i, constraintAttribute);
                                    break;
                                } else {
                                    Log.e("MotionPaths", str + " splineSet not a CustomSet frame = " + i + ", value" + constraintAttribute.getValueToInterpolate() + splineSet);
                                    break;
                                }
                            } else {
                                Log.e("MotionPaths", "UNKNOWN customName " + str2);
                                break;
                            }
                        } else {
                            Log.e("MotionPaths", "UNKNOWN spline " + str);
                            break;
                        }
                }
            }
        }
    }

    public void applyParameters(View view2) {
        float alpha;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            this.visibility = view2.getVisibility();
            if (view2.getVisibility() != 0) {
                alpha = 0.0f;
            } else {
                alpha = view2.getAlpha();
            }
            this.alpha = alpha;
            this.applyElevation = false;
            if (Build.VERSION.SDK_INT >= 21) {
                this.elevation = view2.getElevation();
            }
            this.rotation = view2.getRotation();
            this.rotationX = view2.getRotationX();
            this.rotationY = view2.getRotationY();
            this.scaleX = view2.getScaleX();
            this.scaleY = view2.getScaleY();
            this.mPivotX = view2.getPivotX();
            this.mPivotY = view2.getPivotY();
            this.translationX = view2.getTranslationX();
            this.translationY = view2.getTranslationY();
            if (Build.VERSION.SDK_INT >= 21) {
                this.translationZ = view2.getTranslationZ();
            }
        }
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, constraint) == null) {
            ConstraintSet.PropertySet propertySet = constraint.propertySet;
            int i = propertySet.mVisibilityMode;
            this.mVisibilityMode = i;
            int i2 = propertySet.visibility;
            this.visibility = i2;
            if (i2 != 0 && i == 0) {
                f = 0.0f;
            } else {
                f = constraint.propertySet.alpha;
            }
            this.alpha = f;
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionConstrainedPoint)) == null) {
            return Float.compare(this.position, motionConstrainedPoint.position);
        }
        return invokeL.intValue;
    }

    public int getCustomDataCount(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
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

    public void setState(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            setBounds(view2.getX(), view2.getY(), view2.getWidth(), view2.getHeight());
            applyParameters(view2);
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
            int i = this.visibility;
            int i2 = motionConstrainedPoint.visibility;
            if (i != i2 && this.mVisibilityMode == 0 && (i == 0 || i2 == 0)) {
                hashSet.add(Key.ALPHA);
            }
            if (diff(this.rotation, motionConstrainedPoint.rotation)) {
                hashSet.add("rotation");
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

    public void fillStandard(double[] dArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, dArr, iArr) == null) {
            float[] fArr = {this.position, this.x, this.y, this.width, this.height, this.alpha, this.elevation, this.rotation, this.rotationX, this.rotationY, this.scaleX, this.scaleY, this.mPivotX, this.mPivotY, this.translationX, this.translationY, this.translationZ, this.mPathRotate};
            int i = 0;
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (iArr[i2] < 18) {
                    dArr[i] = fArr[iArr[i2]];
                    i++;
                }
            }
        }
    }

    public int getCustomData(String str, double[] dArr, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, dArr, i)) == null) {
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

    public void setBounds(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.x = f;
            this.y = f2;
            this.width = f3;
            this.height = f4;
        }
    }

    public void setState(ConstraintWidget constraintWidget, ConstraintSet constraintSet, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048589, this, constraintWidget, constraintSet, i) == null) {
            setBounds(constraintWidget.getX(), constraintWidget.getY(), constraintWidget.getWidth(), constraintWidget.getHeight());
            applyParameters(constraintSet.getParameters(i));
        }
    }
}

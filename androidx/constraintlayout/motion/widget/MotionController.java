package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class MotionController {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    public static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public int MAX_DIMENSION;
    public String[] attributeTable;
    public CurveFit mArcSpline;
    public int[] mAttributeInterpCount;
    public String[] mAttributeNames;
    public HashMap<String, SplineSet> mAttributesMap;
    public String mConstraintTag;
    public int mCurveFitType;
    public HashMap<String, KeyCycleOscillator> mCycleMap;
    public MotionPaths mEndMotionPath;
    public MotionConstrainedPoint mEndPoint;
    public int mId;
    public double[] mInterpolateData;
    public int[] mInterpolateVariables;
    public double[] mInterpolateVelocity;
    public ArrayList<Key> mKeyList;
    public KeyTrigger[] mKeyTriggers;
    public ArrayList<MotionPaths> mMotionPaths;
    public float mMotionStagger;
    public int mPathMotionArc;
    public CurveFit[] mSpline;
    public float mStaggerOffset;
    public float mStaggerScale;
    public MotionPaths mStartMotionPath;
    public MotionConstrainedPoint mStartPoint;
    public HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    public float[] mValuesBuff;
    public float[] mVelocity;
    public View mView;

    public MotionController(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCurveFitType = -1;
        this.mStartMotionPath = new MotionPaths();
        this.mEndMotionPath = new MotionPaths();
        this.mStartPoint = new MotionConstrainedPoint();
        this.mEndPoint = new MotionConstrainedPoint();
        this.mMotionStagger = Float.NaN;
        this.mStaggerOffset = 0.0f;
        this.mStaggerScale = 1.0f;
        this.MAX_DIMENSION = 4;
        this.mValuesBuff = new float[4];
        this.mMotionPaths = new ArrayList<>();
        this.mVelocity = new float[1];
        this.mKeyList = new ArrayList<>();
        this.mPathMotionArc = Key.UNSET;
        setView(view2);
    }

    private float getAdjustedPosition(float f, float[] fArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Float.valueOf(f), fArr})) == null) {
            float f2 = 0.0f;
            float f3 = 1.0f;
            if (fArr != null) {
                fArr[0] = 1.0f;
            } else if (this.mStaggerScale != 1.0d) {
                if (f < this.mStaggerOffset) {
                    f = 0.0f;
                }
                float f4 = this.mStaggerOffset;
                if (f > f4 && f < 1.0d) {
                    f = (f - f4) * this.mStaggerScale;
                }
            }
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float f5 = Float.NaN;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.mKeyFrameEasing;
                if (easing2 != null) {
                    float f6 = next.time;
                    if (f6 < f) {
                        easing = easing2;
                        f2 = f6;
                    } else if (Float.isNaN(f5)) {
                        f5 = next.time;
                    }
                }
            }
            if (easing != null) {
                if (!Float.isNaN(f5)) {
                    f3 = f5;
                }
                float f7 = f3 - f2;
                double d = (f - f2) / f7;
                f = (((float) easing.get(d)) * f7) + f2;
                if (fArr != null) {
                    fArr[0] = (float) easing.getDiff(d);
                }
            }
            return f;
        }
        return invokeCommon.floatValue;
    }

    private float getPreCycleDistance() {
        InterceptResult invokeV;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            float[] fArr = new float[2];
            float f2 = 1.0f / 99;
            double d = 0.0d;
            double d2 = 0.0d;
            int i = 0;
            float f3 = 0.0f;
            while (i < 100) {
                float f4 = i * f2;
                double d3 = f4;
                Easing easing = this.mStartMotionPath.mKeyFrameEasing;
                float f5 = Float.NaN;
                Iterator<MotionPaths> it = this.mMotionPaths.iterator();
                float f6 = 0.0f;
                while (it.hasNext()) {
                    MotionPaths next = it.next();
                    Easing easing2 = next.mKeyFrameEasing;
                    float f7 = f2;
                    if (easing2 != null) {
                        float f8 = next.time;
                        if (f8 < f4) {
                            f6 = f8;
                            easing = easing2;
                        } else if (Float.isNaN(f5)) {
                            f5 = next.time;
                        }
                    }
                    f2 = f7;
                }
                float f9 = f2;
                if (easing != null) {
                    if (Float.isNaN(f5)) {
                        f5 = 1.0f;
                    }
                    d3 = (((float) easing.get((f4 - f6) / f)) * (f5 - f6)) + f6;
                }
                this.mSpline[0].getPos(d3, this.mInterpolateData);
                this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                if (i > 0) {
                    f3 = (float) (f3 + Math.hypot(d2 - fArr[1], d - fArr[0]));
                }
                d = fArr[0];
                d2 = fArr[1];
                i++;
                f2 = f9;
            }
            return f3;
        }
        return invokeV.floatValue;
    }

    private void insertKey(MotionPaths motionPaths) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, motionPaths) == null) {
            int binarySearch = Collections.binarySearch(this.mMotionPaths, motionPaths);
            if (binarySearch == 0) {
                Log.e(TAG, " KeyPath positon \"" + motionPaths.position + "\" outside of range");
            }
            this.mMotionPaths.add((-binarySearch) - 1, motionPaths);
        }
    }

    private void readView(MotionPaths motionPaths) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, motionPaths) == null) {
            motionPaths.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
        }
    }

    public void addKey(Key key) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, key) == null) {
            this.mKeyList.add(key);
        }
    }

    public void addKeys(ArrayList<Key> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.mKeyList.addAll(arrayList);
        }
    }

    public MotionPaths getKeyFrame(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            return this.mMotionPaths.get(i);
        }
        return (MotionPaths) invokeI.objValue;
    }

    public void setDrawPath(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.mStartMotionPath.mDrawPath = i;
        }
    }

    public void setPathMotionArc(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.mPathMotionArc = i;
        }
    }

    public void setStartCurrentState(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, view2) == null) {
            MotionPaths motionPaths = this.mStartMotionPath;
            motionPaths.time = 0.0f;
            motionPaths.position = 0.0f;
            motionPaths.setBounds(view2.getX(), view2.getY(), view2.getWidth(), view2.getHeight());
            this.mStartPoint.setState(view2);
        }
    }

    public void setView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, view2) == null) {
            this.mView = view2;
            this.mId = view2.getId();
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                this.mConstraintTag = ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
            }
        }
    }

    public void buildBounds(float[] fArr, int i) {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, fArr, i) == null) {
            float f2 = 1.0f / (i - 1);
            HashMap<String, SplineSet> hashMap = this.mAttributesMap;
            if (hashMap != null) {
                hashMap.get(Key.TRANSLATION_X);
            }
            HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
            if (hashMap2 != null) {
                hashMap2.get(Key.TRANSLATION_Y);
            }
            HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
            if (hashMap3 != null) {
                hashMap3.get(Key.TRANSLATION_X);
            }
            HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
            if (hashMap4 != null) {
                hashMap4.get(Key.TRANSLATION_Y);
            }
            for (int i2 = 0; i2 < i; i2++) {
                float f3 = i2 * f2;
                float f4 = 0.0f;
                if (this.mStaggerScale != 1.0f) {
                    if (f3 < this.mStaggerOffset) {
                        f3 = 0.0f;
                    }
                    float f5 = this.mStaggerOffset;
                    if (f3 > f5 && f3 < 1.0d) {
                        f3 = (f3 - f5) * this.mStaggerScale;
                    }
                }
                double d = f3;
                Easing easing = this.mStartMotionPath.mKeyFrameEasing;
                float f6 = Float.NaN;
                Iterator<MotionPaths> it = this.mMotionPaths.iterator();
                while (it.hasNext()) {
                    MotionPaths next = it.next();
                    Easing easing2 = next.mKeyFrameEasing;
                    if (easing2 != null) {
                        float f7 = next.time;
                        if (f7 < f3) {
                            easing = easing2;
                            f4 = f7;
                        } else if (Float.isNaN(f6)) {
                            f6 = next.time;
                        }
                    }
                }
                if (easing != null) {
                    if (Float.isNaN(f6)) {
                        f6 = 1.0f;
                    }
                    d = (((float) easing.get((f3 - f4) / f)) * (f6 - f4)) + f4;
                }
                this.mSpline[0].getPos(d, this.mInterpolateData);
                CurveFit curveFit = this.mArcSpline;
                if (curveFit != null) {
                    double[] dArr = this.mInterpolateData;
                    if (dArr.length > 0) {
                        curveFit.getPos(d, dArr);
                    }
                }
                this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i2 * 2);
            }
        }
    }

    public void buildPath(float[] fArr, int i) {
        SplineSet splineSet;
        SplineSet splineSet2;
        KeyCycleOscillator keyCycleOscillator;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, fArr, i) == null) {
            int i2 = i;
            float f2 = 1.0f;
            float f3 = 1.0f / (i2 - 1);
            HashMap<String, SplineSet> hashMap = this.mAttributesMap;
            KeyCycleOscillator keyCycleOscillator2 = null;
            if (hashMap == null) {
                splineSet = null;
            } else {
                splineSet = hashMap.get(Key.TRANSLATION_X);
            }
            HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
            if (hashMap2 == null) {
                splineSet2 = null;
            } else {
                splineSet2 = hashMap2.get(Key.TRANSLATION_Y);
            }
            HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
            if (hashMap3 == null) {
                keyCycleOscillator = null;
            } else {
                keyCycleOscillator = hashMap3.get(Key.TRANSLATION_X);
            }
            HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
            if (hashMap4 != null) {
                keyCycleOscillator2 = hashMap4.get(Key.TRANSLATION_Y);
            }
            int i3 = 0;
            while (i3 < i2) {
                float f4 = i3 * f3;
                float f5 = 0.0f;
                if (this.mStaggerScale != f2) {
                    if (f4 < this.mStaggerOffset) {
                        f4 = 0.0f;
                    }
                    float f6 = this.mStaggerOffset;
                    if (f4 > f6 && f4 < 1.0d) {
                        f4 = (f4 - f6) * this.mStaggerScale;
                    }
                }
                double d = f4;
                Easing easing = this.mStartMotionPath.mKeyFrameEasing;
                float f7 = Float.NaN;
                Iterator<MotionPaths> it = this.mMotionPaths.iterator();
                while (it.hasNext()) {
                    MotionPaths next = it.next();
                    Easing easing2 = next.mKeyFrameEasing;
                    if (easing2 != null) {
                        float f8 = next.time;
                        if (f8 < f4) {
                            f5 = f8;
                            easing = easing2;
                        } else if (Float.isNaN(f7)) {
                            f7 = next.time;
                        }
                    }
                }
                if (easing != null) {
                    if (Float.isNaN(f7)) {
                        f7 = 1.0f;
                    }
                    d = (((float) easing.get((f4 - f5) / f)) * (f7 - f5)) + f5;
                }
                this.mSpline[0].getPos(d, this.mInterpolateData);
                CurveFit curveFit = this.mArcSpline;
                if (curveFit != null) {
                    double[] dArr = this.mInterpolateData;
                    if (dArr.length > 0) {
                        curveFit.getPos(d, dArr);
                    }
                }
                int i4 = i3 * 2;
                this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i4);
                if (keyCycleOscillator != null) {
                    fArr[i4] = fArr[i4] + keyCycleOscillator.get(f4);
                } else if (splineSet != null) {
                    fArr[i4] = fArr[i4] + splineSet.get(f4);
                }
                if (keyCycleOscillator2 != null) {
                    int i5 = i4 + 1;
                    fArr[i5] = fArr[i5] + keyCycleOscillator2.get(f4);
                } else if (splineSet2 != null) {
                    int i6 = i4 + 1;
                    fArr[i6] = fArr[i6] + splineSet2.get(f4);
                }
                i3++;
                i2 = i;
                f2 = 1.0f;
            }
        }
    }

    public int buildKeyBounds(float[] fArr, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, fArr, iArr)) == null) {
            if (fArr == null) {
                return 0;
            }
            double[] timePoints = this.mSpline[0].getTimePoints();
            if (iArr != null) {
                Iterator<MotionPaths> it = this.mMotionPaths.iterator();
                int i = 0;
                while (it.hasNext()) {
                    iArr[i] = it.next().mMode;
                    i++;
                }
            }
            int i2 = 0;
            for (double d : timePoints) {
                this.mSpline[0].getPos(d, this.mInterpolateData);
                this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
                i2 += 2;
            }
            return i2 / 2;
        }
        return invokeLL.intValue;
    }

    public int buildKeyFrames(float[] fArr, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, fArr, iArr)) == null) {
            if (fArr == null) {
                return 0;
            }
            double[] timePoints = this.mSpline[0].getTimePoints();
            if (iArr != null) {
                Iterator<MotionPaths> it = this.mMotionPaths.iterator();
                int i = 0;
                while (it.hasNext()) {
                    iArr[i] = it.next().mMode;
                    i++;
                }
            }
            int i2 = 0;
            for (double d : timePoints) {
                this.mSpline[0].getPos(d, this.mInterpolateData);
                this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
                i2 += 2;
            }
            return i2 / 2;
        }
        return invokeLL.intValue;
    }

    public int getkeyFramePositions(int[] iArr, float[] fArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, iArr, fArr)) == null) {
            Iterator<Key> it = this.mKeyList.iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                Key next = it.next();
                int i3 = next.mFramePosition;
                iArr[i] = (next.mType * 1000) + i3;
                this.mSpline[0].getPos(i3 / 100.0f, this.mInterpolateData);
                this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
                i2 += 2;
                i++;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public void setStartState(ConstraintWidget constraintWidget, ConstraintSet constraintSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, constraintWidget, constraintSet) == null) {
            MotionPaths motionPaths = this.mStartMotionPath;
            motionPaths.time = 0.0f;
            motionPaths.position = 0.0f;
            readView(motionPaths);
            this.mStartMotionPath.setBounds(constraintWidget.getX(), constraintWidget.getY(), constraintWidget.getWidth(), constraintWidget.getHeight());
            ConstraintSet.Constraint parameters = constraintSet.getParameters(this.mId);
            this.mStartMotionPath.applyParameters(parameters);
            this.mMotionStagger = parameters.motion.mMotionStagger;
            this.mStartPoint.setState(constraintWidget, constraintSet, this.mId);
        }
    }

    public void buildRect(float f, float[] fArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f), fArr, Integer.valueOf(i)}) == null) {
            this.mSpline[0].getPos(getAdjustedPosition(f, null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i);
        }
    }

    public void buildRectangles(float[] fArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, fArr, i) == null) {
            float f = 1.0f / (i - 1);
            for (int i2 = 0; i2 < i; i2++) {
                this.mSpline[0].getPos(getAdjustedPosition(i2 * f, null), this.mInterpolateData);
                this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i2 * 8);
            }
        }
    }

    public void setEndState(ConstraintWidget constraintWidget, ConstraintSet constraintSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, constraintWidget, constraintSet) == null) {
            MotionPaths motionPaths = this.mEndMotionPath;
            motionPaths.time = 1.0f;
            motionPaths.position = 1.0f;
            readView(motionPaths);
            this.mEndMotionPath.setBounds(constraintWidget.getX(), constraintWidget.getY(), constraintWidget.getWidth(), constraintWidget.getHeight());
            this.mEndMotionPath.applyParameters(constraintSet.getParameters(this.mId));
            this.mEndPoint.setState(constraintWidget, constraintSet, this.mId);
        }
    }

    public int getAttributeValues(String str, float[] fArr, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, fArr, i)) == null) {
            SplineSet splineSet = this.mAttributesMap.get(str);
            if (splineSet == null) {
                return -1;
            }
            for (int i2 = 0; i2 < fArr.length; i2++) {
                fArr[i2] = splineSet.get(i2 / (fArr.length - 1));
            }
            return fArr.length;
        }
        return invokeLLI.intValue;
    }

    public void getDpDt(float f, float f2, float f3, float[] fArr) {
        double[] dArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), fArr}) == null) {
            float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
            CurveFit[] curveFitArr = this.mSpline;
            int i = 0;
            if (curveFitArr != null) {
                double d = adjustedPosition;
                curveFitArr[0].getSlope(d, this.mInterpolateVelocity);
                this.mSpline[0].getPos(d, this.mInterpolateData);
                float f4 = this.mVelocity[0];
                while (true) {
                    dArr = this.mInterpolateVelocity;
                    if (i >= dArr.length) {
                        break;
                    }
                    dArr[i] = dArr[i] * f4;
                    i++;
                }
                CurveFit curveFit = this.mArcSpline;
                if (curveFit != null) {
                    double[] dArr2 = this.mInterpolateData;
                    if (dArr2.length > 0) {
                        curveFit.getPos(d, dArr2);
                        this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
                        this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
                        return;
                    }
                    return;
                }
                this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
                return;
            }
            MotionPaths motionPaths = this.mEndMotionPath;
            float f5 = motionPaths.x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f6 = f5 - motionPaths2.x;
            float f7 = motionPaths.y - motionPaths2.y;
            float f8 = (motionPaths.width - motionPaths2.width) + f6;
            float f9 = (motionPaths.height - motionPaths2.height) + f7;
            fArr[0] = (f6 * (1.0f - f2)) + (f8 * f2);
            fArr[1] = (f7 * (1.0f - f3)) + (f9 * f3);
        }
    }

    public int getDrawPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.mStartMotionPath.mDrawPath;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            while (it.hasNext()) {
                i = Math.max(i, it.next().mDrawPath);
            }
            return Math.max(i, this.mEndMotionPath.mDrawPath);
        }
        return invokeV.intValue;
    }

    public float getFinalX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mEndMotionPath.x;
        }
        return invokeV.floatValue;
    }

    public float getFinalY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mEndMotionPath.y;
        }
        return invokeV.floatValue;
    }

    public float getStartX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mStartMotionPath.x;
        }
        return invokeV.floatValue;
    }

    public float getStartY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mStartMotionPath.y;
        }
        return invokeV.floatValue;
    }

    public String name() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
        }
        return (String) invokeV.objValue;
    }

    public int getKeyFrameInfo(int i, int[] iArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i, iArr)) == null) {
            float[] fArr = new float[2];
            Iterator<Key> it = this.mKeyList.iterator();
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                Key next = it.next();
                if (next.mType == i || i != -1) {
                    iArr[i3] = 0;
                    int i4 = i3 + 1;
                    iArr[i4] = next.mType;
                    int i5 = i4 + 1;
                    int i6 = next.mFramePosition;
                    iArr[i5] = i6;
                    this.mSpline[0].getPos(i6 / 100.0f, this.mInterpolateData);
                    this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                    int i7 = i5 + 1;
                    iArr[i7] = Float.floatToIntBits(fArr[0]);
                    int i8 = i7 + 1;
                    iArr[i8] = Float.floatToIntBits(fArr[1]);
                    if (next instanceof KeyPosition) {
                        KeyPosition keyPosition = (KeyPosition) next;
                        int i9 = i8 + 1;
                        iArr[i9] = keyPosition.mPositionType;
                        int i10 = i9 + 1;
                        iArr[i10] = Float.floatToIntBits(keyPosition.mPercentX);
                        i8 = i10 + 1;
                        iArr[i8] = Float.floatToIntBits(keyPosition.mPercentY);
                    }
                    int i11 = i8 + 1;
                    iArr[i3] = i11 - i3;
                    i2++;
                    i3 = i11;
                }
            }
            return i2;
        }
        return invokeIL.intValue;
    }

    public float getKeyFrameParameter(int i, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)})) == null) {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f3 = motionPaths.x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f4 = motionPaths2.x;
            float f5 = f3 - f4;
            float f6 = motionPaths.y;
            float f7 = motionPaths2.y;
            float f8 = f6 - f7;
            float f9 = f4 + (motionPaths2.width / 2.0f);
            float f10 = f7 + (motionPaths2.height / 2.0f);
            float hypot = (float) Math.hypot(f5, f8);
            if (hypot < 1.0E-7d) {
                return Float.NaN;
            }
            float f11 = f - f9;
            float f12 = f2 - f10;
            if (((float) Math.hypot(f11, f12)) == 0.0f) {
                return 0.0f;
            }
            float f13 = (f11 * f5) + (f12 * f8);
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    return 0.0f;
                                }
                                return f12 / f8;
                            }
                            return f11 / f8;
                        }
                        return f12 / f5;
                    }
                    return f11 / f5;
                }
                return (float) Math.sqrt((hypot * hypot) - (f13 * f13));
            }
            return f13 / hypot;
        }
        return invokeCommon.floatValue;
    }

    public KeyPositionBase getPositionKeyframe(int i, int i2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2)})) == null) {
            RectF rectF = new RectF();
            MotionPaths motionPaths = this.mStartMotionPath;
            float f3 = motionPaths.x;
            rectF.left = f3;
            float f4 = motionPaths.y;
            rectF.top = f4;
            rectF.right = f3 + motionPaths.width;
            rectF.bottom = f4 + motionPaths.height;
            RectF rectF2 = new RectF();
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float f5 = motionPaths2.x;
            rectF2.left = f5;
            float f6 = motionPaths2.y;
            rectF2.top = f6;
            rectF2.right = f5 + motionPaths2.width;
            rectF2.bottom = f6 + motionPaths2.height;
            Iterator<Key> it = this.mKeyList.iterator();
            while (it.hasNext()) {
                Key next = it.next();
                if (next instanceof KeyPositionBase) {
                    KeyPositionBase keyPositionBase = (KeyPositionBase) next;
                    if (keyPositionBase.intersects(i, i2, rectF, rectF2, f, f2)) {
                        return keyPositionBase;
                    }
                }
            }
            return null;
        }
        return (KeyPositionBase) invokeCommon.objValue;
    }

    public void getPostLayoutDvDp(float f, int i, int i2, float f2, float f3, float[] fArr) {
        SplineSet splineSet;
        SplineSet splineSet2;
        SplineSet splineSet3;
        SplineSet splineSet4;
        SplineSet splineSet5;
        KeyCycleOscillator keyCycleOscillator;
        KeyCycleOscillator keyCycleOscillator2;
        KeyCycleOscillator keyCycleOscillator3;
        KeyCycleOscillator keyCycleOscillator4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), fArr}) == null) {
            float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
            HashMap<String, SplineSet> hashMap = this.mAttributesMap;
            KeyCycleOscillator keyCycleOscillator5 = null;
            if (hashMap == null) {
                splineSet = null;
            } else {
                splineSet = hashMap.get(Key.TRANSLATION_X);
            }
            HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
            if (hashMap2 == null) {
                splineSet2 = null;
            } else {
                splineSet2 = hashMap2.get(Key.TRANSLATION_Y);
            }
            HashMap<String, SplineSet> hashMap3 = this.mAttributesMap;
            if (hashMap3 == null) {
                splineSet3 = null;
            } else {
                splineSet3 = hashMap3.get("rotation");
            }
            HashMap<String, SplineSet> hashMap4 = this.mAttributesMap;
            if (hashMap4 == null) {
                splineSet4 = null;
            } else {
                splineSet4 = hashMap4.get(Key.SCALE_X);
            }
            HashMap<String, SplineSet> hashMap5 = this.mAttributesMap;
            if (hashMap5 == null) {
                splineSet5 = null;
            } else {
                splineSet5 = hashMap5.get(Key.SCALE_Y);
            }
            HashMap<String, KeyCycleOscillator> hashMap6 = this.mCycleMap;
            if (hashMap6 == null) {
                keyCycleOscillator = null;
            } else {
                keyCycleOscillator = hashMap6.get(Key.TRANSLATION_X);
            }
            HashMap<String, KeyCycleOscillator> hashMap7 = this.mCycleMap;
            if (hashMap7 == null) {
                keyCycleOscillator2 = null;
            } else {
                keyCycleOscillator2 = hashMap7.get(Key.TRANSLATION_Y);
            }
            HashMap<String, KeyCycleOscillator> hashMap8 = this.mCycleMap;
            if (hashMap8 == null) {
                keyCycleOscillator3 = null;
            } else {
                keyCycleOscillator3 = hashMap8.get("rotation");
            }
            HashMap<String, KeyCycleOscillator> hashMap9 = this.mCycleMap;
            if (hashMap9 == null) {
                keyCycleOscillator4 = null;
            } else {
                keyCycleOscillator4 = hashMap9.get(Key.SCALE_X);
            }
            HashMap<String, KeyCycleOscillator> hashMap10 = this.mCycleMap;
            if (hashMap10 != null) {
                keyCycleOscillator5 = hashMap10.get(Key.SCALE_Y);
            }
            VelocityMatrix velocityMatrix = new VelocityMatrix();
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
            velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
            velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    double d = adjustedPosition;
                    curveFit.getPos(d, dArr);
                    this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
                    this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
                }
                velocityMatrix.applyTransform(f2, f3, i, i2, fArr);
                return;
            }
            int i3 = 0;
            if (this.mSpline != null) {
                double adjustedPosition2 = getAdjustedPosition(adjustedPosition, this.mVelocity);
                this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
                this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
                float f4 = this.mVelocity[0];
                while (true) {
                    double[] dArr2 = this.mInterpolateVelocity;
                    if (i3 < dArr2.length) {
                        dArr2[i3] = dArr2[i3] * f4;
                        i3++;
                    } else {
                        this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                        velocityMatrix.applyTransform(f2, f3, i, i2, fArr);
                        return;
                    }
                }
            } else {
                MotionPaths motionPaths = this.mEndMotionPath;
                float f5 = motionPaths.x;
                MotionPaths motionPaths2 = this.mStartMotionPath;
                float f6 = f5 - motionPaths2.x;
                float f7 = motionPaths.y - motionPaths2.y;
                KeyCycleOscillator keyCycleOscillator6 = keyCycleOscillator4;
                float f8 = (motionPaths.height - motionPaths2.height) + f7;
                fArr[0] = (f6 * (1.0f - f2)) + (((motionPaths.width - motionPaths2.width) + f6) * f2);
                fArr[1] = (f7 * (1.0f - f3)) + (f8 * f3);
                velocityMatrix.clear();
                velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
                velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
                velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
                velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
                velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
                velocityMatrix.setScaleVelocity(keyCycleOscillator6, keyCycleOscillator5, adjustedPosition);
                velocityMatrix.applyTransform(f2, f3, i, i2, fArr);
            }
        }
    }

    public boolean interpolate(View view2, float f, long j, KeyCache keyCache) {
        InterceptResult invokeCommon;
        TimeCycleSplineSet.PathRotate pathRotate;
        boolean z;
        double d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{view2, Float.valueOf(f), Long.valueOf(j), keyCache})) == null) {
            float adjustedPosition = getAdjustedPosition(f, null);
            HashMap<String, SplineSet> hashMap = this.mAttributesMap;
            if (hashMap != null) {
                for (SplineSet splineSet : hashMap.values()) {
                    splineSet.setProperty(view2, adjustedPosition);
                }
            }
            HashMap<String, TimeCycleSplineSet> hashMap2 = this.mTimeCycleAttributesMap;
            if (hashMap2 != null) {
                pathRotate = null;
                boolean z2 = false;
                for (TimeCycleSplineSet timeCycleSplineSet : hashMap2.values()) {
                    if (timeCycleSplineSet instanceof TimeCycleSplineSet.PathRotate) {
                        pathRotate = (TimeCycleSplineSet.PathRotate) timeCycleSplineSet;
                    } else {
                        z2 |= timeCycleSplineSet.setProperty(view2, adjustedPosition, j, keyCache);
                    }
                }
                z = z2;
            } else {
                pathRotate = null;
                z = false;
            }
            CurveFit[] curveFitArr = this.mSpline;
            if (curveFitArr != null) {
                double d2 = adjustedPosition;
                curveFitArr[0].getPos(d2, this.mInterpolateData);
                this.mSpline[0].getSlope(d2, this.mInterpolateVelocity);
                CurveFit curveFit = this.mArcSpline;
                if (curveFit != null) {
                    double[] dArr = this.mInterpolateData;
                    if (dArr.length > 0) {
                        curveFit.getPos(d2, dArr);
                        this.mArcSpline.getSlope(d2, this.mInterpolateVelocity);
                    }
                }
                this.mStartMotionPath.setView(view2, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
                HashMap<String, SplineSet> hashMap3 = this.mAttributesMap;
                if (hashMap3 != null) {
                    for (SplineSet splineSet2 : hashMap3.values()) {
                        if (splineSet2 instanceof SplineSet.PathRotate) {
                            double[] dArr2 = this.mInterpolateVelocity;
                            ((SplineSet.PathRotate) splineSet2).setPathRotate(view2, adjustedPosition, dArr2[0], dArr2[1]);
                        }
                    }
                }
                if (pathRotate != null) {
                    double[] dArr3 = this.mInterpolateVelocity;
                    d = d2;
                    z = pathRotate.setPathRotate(view2, keyCache, adjustedPosition, j, dArr3[0], dArr3[1]) | z;
                } else {
                    d = d2;
                }
                int i = 1;
                while (true) {
                    CurveFit[] curveFitArr2 = this.mSpline;
                    if (i >= curveFitArr2.length) {
                        break;
                    }
                    curveFitArr2[i].getPos(d, this.mValuesBuff);
                    this.mStartMotionPath.attributes.get(this.mAttributeNames[i - 1]).setInterpolatedValue(view2, this.mValuesBuff);
                    i++;
                }
                MotionConstrainedPoint motionConstrainedPoint = this.mStartPoint;
                if (motionConstrainedPoint.mVisibilityMode == 0) {
                    if (adjustedPosition <= 0.0f) {
                        view2.setVisibility(motionConstrainedPoint.visibility);
                    } else if (adjustedPosition >= 1.0f) {
                        view2.setVisibility(this.mEndPoint.visibility);
                    } else if (this.mEndPoint.visibility != motionConstrainedPoint.visibility) {
                        view2.setVisibility(0);
                    }
                }
                if (this.mKeyTriggers != null) {
                    int i2 = 0;
                    while (true) {
                        KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
                        if (i2 >= keyTriggerArr.length) {
                            break;
                        }
                        keyTriggerArr[i2].conditionallyFire(adjustedPosition, view2);
                        i2++;
                    }
                }
            } else {
                MotionPaths motionPaths = this.mStartMotionPath;
                float f2 = motionPaths.x;
                MotionPaths motionPaths2 = this.mEndMotionPath;
                float f3 = f2 + ((motionPaths2.x - f2) * adjustedPosition);
                float f4 = motionPaths.y;
                float f5 = f4 + ((motionPaths2.y - f4) * adjustedPosition);
                float f6 = motionPaths.width;
                float f7 = motionPaths2.width;
                float f8 = motionPaths.height;
                float f9 = motionPaths2.height;
                float f10 = f3 + 0.5f;
                int i3 = (int) f10;
                float f11 = f5 + 0.5f;
                int i4 = (int) f11;
                int i5 = (int) (f10 + ((f7 - f6) * adjustedPosition) + f6);
                int i6 = (int) (f11 + ((f9 - f8) * adjustedPosition) + f8);
                int i7 = i5 - i3;
                int i8 = i6 - i4;
                if (f7 != f6 || f9 != f8) {
                    view2.measure(View.MeasureSpec.makeMeasureSpec(i7, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                }
                view2.layout(i3, i4, i5, i6);
            }
            HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
            if (hashMap4 != null) {
                for (KeyCycleOscillator keyCycleOscillator : hashMap4.values()) {
                    if (keyCycleOscillator instanceof KeyCycleOscillator.PathRotateSet) {
                        double[] dArr4 = this.mInterpolateVelocity;
                        ((KeyCycleOscillator.PathRotateSet) keyCycleOscillator).setPathRotate(view2, adjustedPosition, dArr4[0], dArr4[1]);
                    } else {
                        keyCycleOscillator.setProperty(view2, adjustedPosition);
                    }
                }
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public void positionKeyframe(View view2, KeyPositionBase keyPositionBase, float f, float f2, String[] strArr, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{view2, keyPositionBase, Float.valueOf(f), Float.valueOf(f2), strArr, fArr}) == null) {
            RectF rectF = new RectF();
            MotionPaths motionPaths = this.mStartMotionPath;
            float f3 = motionPaths.x;
            rectF.left = f3;
            float f4 = motionPaths.y;
            rectF.top = f4;
            rectF.right = f3 + motionPaths.width;
            rectF.bottom = f4 + motionPaths.height;
            RectF rectF2 = new RectF();
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float f5 = motionPaths2.x;
            rectF2.left = f5;
            float f6 = motionPaths2.y;
            rectF2.top = f6;
            rectF2.right = f5 + motionPaths2.width;
            rectF2.bottom = f6 + motionPaths2.height;
            keyPositionBase.positionAttributes(view2, rectF, rectF2, f, f2, strArr, fArr);
        }
    }

    public void setup(int i, int i2, float f, long j) {
        ArrayList arrayList;
        boolean z;
        int i3;
        TimeCycleSplineSet makeSpline;
        ConstraintAttribute constraintAttribute;
        int i4;
        SplineSet makeSpline2;
        ConstraintAttribute constraintAttribute2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Long.valueOf(j)}) == null) {
            new HashSet();
            HashSet<String> hashSet = new HashSet<>();
            HashSet<String> hashSet2 = new HashSet<>();
            HashSet<String> hashSet3 = new HashSet<>();
            HashMap<String, Integer> hashMap = new HashMap<>();
            int i5 = this.mPathMotionArc;
            if (i5 != Key.UNSET) {
                this.mStartMotionPath.mPathMotionArc = i5;
            }
            this.mStartPoint.different(this.mEndPoint, hashSet2);
            ArrayList<Key> arrayList2 = this.mKeyList;
            if (arrayList2 != null) {
                Iterator<Key> it = arrayList2.iterator();
                arrayList = null;
                while (it.hasNext()) {
                    Key next = it.next();
                    if (next instanceof KeyPosition) {
                        KeyPosition keyPosition = (KeyPosition) next;
                        insertKey(new MotionPaths(i, i2, keyPosition, this.mStartMotionPath, this.mEndMotionPath));
                        int i6 = keyPosition.mCurveFit;
                        if (i6 != Key.UNSET) {
                            this.mCurveFitType = i6;
                        }
                    } else if (next instanceof KeyCycle) {
                        next.getAttributeNames(hashSet3);
                    } else if (next instanceof KeyTimeCycle) {
                        next.getAttributeNames(hashSet);
                    } else if (next instanceof KeyTrigger) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add((KeyTrigger) next);
                    } else {
                        next.setInterpolation(hashMap);
                        next.getAttributeNames(hashSet2);
                    }
                }
            } else {
                arrayList = null;
            }
            char c = 0;
            if (arrayList != null) {
                this.mKeyTriggers = (KeyTrigger[]) arrayList.toArray(new KeyTrigger[0]);
            }
            char c2 = 1;
            if (!hashSet2.isEmpty()) {
                this.mAttributesMap = new HashMap<>();
                Iterator<String> it2 = hashSet2.iterator();
                while (it2.hasNext()) {
                    String next2 = it2.next();
                    if (next2.startsWith("CUSTOM,")) {
                        SparseArray sparseArray = new SparseArray();
                        String str = next2.split(",")[c2];
                        Iterator<Key> it3 = this.mKeyList.iterator();
                        while (it3.hasNext()) {
                            Key next3 = it3.next();
                            HashMap<String, ConstraintAttribute> hashMap2 = next3.mCustomConstraints;
                            if (hashMap2 != null && (constraintAttribute2 = hashMap2.get(str)) != null) {
                                sparseArray.append(next3.mFramePosition, constraintAttribute2);
                            }
                        }
                        makeSpline2 = SplineSet.makeCustomSpline(next2, sparseArray);
                    } else {
                        makeSpline2 = SplineSet.makeSpline(next2);
                    }
                    if (makeSpline2 != null) {
                        makeSpline2.setType(next2);
                        this.mAttributesMap.put(next2, makeSpline2);
                    }
                    c2 = 1;
                }
                ArrayList<Key> arrayList3 = this.mKeyList;
                if (arrayList3 != null) {
                    Iterator<Key> it4 = arrayList3.iterator();
                    while (it4.hasNext()) {
                        Key next4 = it4.next();
                        if (next4 instanceof KeyAttributes) {
                            next4.addValues(this.mAttributesMap);
                        }
                    }
                }
                this.mStartPoint.addValues(this.mAttributesMap, 0);
                this.mEndPoint.addValues(this.mAttributesMap, 100);
                for (String str2 : this.mAttributesMap.keySet()) {
                    if (hashMap.containsKey(str2)) {
                        i4 = hashMap.get(str2).intValue();
                    } else {
                        i4 = 0;
                    }
                    this.mAttributesMap.get(str2).setup(i4);
                }
            }
            if (!hashSet.isEmpty()) {
                if (this.mTimeCycleAttributesMap == null) {
                    this.mTimeCycleAttributesMap = new HashMap<>();
                }
                Iterator<String> it5 = hashSet.iterator();
                while (it5.hasNext()) {
                    String next5 = it5.next();
                    if (!this.mTimeCycleAttributesMap.containsKey(next5)) {
                        if (next5.startsWith("CUSTOM,")) {
                            SparseArray sparseArray2 = new SparseArray();
                            String str3 = next5.split(",")[1];
                            Iterator<Key> it6 = this.mKeyList.iterator();
                            while (it6.hasNext()) {
                                Key next6 = it6.next();
                                HashMap<String, ConstraintAttribute> hashMap3 = next6.mCustomConstraints;
                                if (hashMap3 != null && (constraintAttribute = hashMap3.get(str3)) != null) {
                                    sparseArray2.append(next6.mFramePosition, constraintAttribute);
                                }
                            }
                            makeSpline = TimeCycleSplineSet.makeCustomSpline(next5, sparseArray2);
                        } else {
                            makeSpline = TimeCycleSplineSet.makeSpline(next5, j);
                        }
                        if (makeSpline != null) {
                            makeSpline.setType(next5);
                            this.mTimeCycleAttributesMap.put(next5, makeSpline);
                        }
                    }
                }
                ArrayList<Key> arrayList4 = this.mKeyList;
                if (arrayList4 != null) {
                    Iterator<Key> it7 = arrayList4.iterator();
                    while (it7.hasNext()) {
                        Key next7 = it7.next();
                        if (next7 instanceof KeyTimeCycle) {
                            ((KeyTimeCycle) next7).addTimeValues(this.mTimeCycleAttributesMap);
                        }
                    }
                }
                for (String str4 : this.mTimeCycleAttributesMap.keySet()) {
                    if (hashMap.containsKey(str4)) {
                        i3 = hashMap.get(str4).intValue();
                    } else {
                        i3 = 0;
                    }
                    this.mTimeCycleAttributesMap.get(str4).setup(i3);
                }
            }
            int i7 = 2;
            int size = this.mMotionPaths.size() + 2;
            MotionPaths[] motionPathsArr = new MotionPaths[size];
            motionPathsArr[0] = this.mStartMotionPath;
            motionPathsArr[size - 1] = this.mEndMotionPath;
            if (this.mMotionPaths.size() > 0 && this.mCurveFitType == -1) {
                this.mCurveFitType = 0;
            }
            Iterator<MotionPaths> it8 = this.mMotionPaths.iterator();
            int i8 = 1;
            while (it8.hasNext()) {
                motionPathsArr[i8] = it8.next();
                i8++;
            }
            HashSet hashSet4 = new HashSet();
            for (String str5 : this.mEndMotionPath.attributes.keySet()) {
                if (this.mStartMotionPath.attributes.containsKey(str5)) {
                    if (!hashSet2.contains("CUSTOM," + str5)) {
                        hashSet4.add(str5);
                    }
                }
            }
            String[] strArr = (String[]) hashSet4.toArray(new String[0]);
            this.mAttributeNames = strArr;
            this.mAttributeInterpCount = new int[strArr.length];
            int i9 = 0;
            while (true) {
                String[] strArr2 = this.mAttributeNames;
                if (i9 >= strArr2.length) {
                    break;
                }
                String str6 = strArr2[i9];
                this.mAttributeInterpCount[i9] = 0;
                int i10 = 0;
                while (true) {
                    if (i10 >= size) {
                        break;
                    } else if (motionPathsArr[i10].attributes.containsKey(str6)) {
                        int[] iArr = this.mAttributeInterpCount;
                        iArr[i9] = iArr[i9] + motionPathsArr[i10].attributes.get(str6).noOfInterpValues();
                        break;
                    } else {
                        i10++;
                    }
                }
                i9++;
            }
            if (motionPathsArr[0].mPathMotionArc != Key.UNSET) {
                z = true;
            } else {
                z = false;
            }
            int length = 18 + this.mAttributeNames.length;
            boolean[] zArr = new boolean[length];
            for (int i11 = 1; i11 < size; i11++) {
                motionPathsArr[i11].different(motionPathsArr[i11 - 1], zArr, this.mAttributeNames, z);
            }
            int i12 = 0;
            for (int i13 = 1; i13 < length; i13++) {
                if (zArr[i13]) {
                    i12++;
                }
            }
            int[] iArr2 = new int[i12];
            this.mInterpolateVariables = iArr2;
            this.mInterpolateData = new double[iArr2.length];
            this.mInterpolateVelocity = new double[iArr2.length];
            int i14 = 0;
            for (int i15 = 1; i15 < length; i15++) {
                if (zArr[i15]) {
                    this.mInterpolateVariables[i14] = i15;
                    i14++;
                }
            }
            double[][] dArr = (double[][]) Array.newInstance(double.class, size, this.mInterpolateVariables.length);
            double[] dArr2 = new double[size];
            for (int i16 = 0; i16 < size; i16++) {
                motionPathsArr[i16].fillStandard(dArr[i16], this.mInterpolateVariables);
                dArr2[i16] = motionPathsArr[i16].time;
            }
            int i17 = 0;
            while (true) {
                int[] iArr3 = this.mInterpolateVariables;
                if (i17 >= iArr3.length) {
                    break;
                }
                if (iArr3[i17] < MotionPaths.names.length) {
                    String str7 = MotionPaths.names[this.mInterpolateVariables[i17]] + " [";
                    for (int i18 = 0; i18 < size; i18++) {
                        str7 = str7 + dArr[i18][i17];
                    }
                }
                i17++;
            }
            this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
            int i19 = 0;
            while (true) {
                String[] strArr3 = this.mAttributeNames;
                if (i19 >= strArr3.length) {
                    break;
                }
                String str8 = strArr3[i19];
                int i20 = 0;
                double[] dArr3 = null;
                int i21 = 0;
                double[][] dArr4 = null;
                while (i20 < size) {
                    if (motionPathsArr[i20].hasCustomData(str8)) {
                        if (dArr4 == null) {
                            dArr3 = new double[size];
                            int[] iArr4 = new int[i7];
                            iArr4[1] = motionPathsArr[i20].getCustomDataCount(str8);
                            iArr4[c] = size;
                            dArr4 = (double[][]) Array.newInstance(double.class, iArr4);
                        }
                        dArr3[i21] = motionPathsArr[i20].time;
                        motionPathsArr[i20].getCustomData(str8, dArr4[i21], 0);
                        i21++;
                    }
                    i20++;
                    i7 = 2;
                    c = 0;
                }
                i19++;
                this.mSpline[i19] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i21), (double[][]) Arrays.copyOf(dArr4, i21));
                i7 = 2;
                c = 0;
            }
            this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
            if (motionPathsArr[0].mPathMotionArc != Key.UNSET) {
                int[] iArr5 = new int[size];
                double[] dArr5 = new double[size];
                double[][] dArr6 = (double[][]) Array.newInstance(double.class, size, 2);
                for (int i22 = 0; i22 < size; i22++) {
                    iArr5[i22] = motionPathsArr[i22].mPathMotionArc;
                    dArr5[i22] = motionPathsArr[i22].time;
                    dArr6[i22][0] = motionPathsArr[i22].x;
                    dArr6[i22][1] = motionPathsArr[i22].y;
                }
                this.mArcSpline = CurveFit.getArc(iArr5, dArr5, dArr6);
            }
            float f2 = Float.NaN;
            this.mCycleMap = new HashMap<>();
            if (this.mKeyList != null) {
                Iterator<String> it9 = hashSet3.iterator();
                while (it9.hasNext()) {
                    String next8 = it9.next();
                    KeyCycleOscillator makeSpline3 = KeyCycleOscillator.makeSpline(next8);
                    if (makeSpline3 != null) {
                        if (makeSpline3.variesByPath() && Float.isNaN(f2)) {
                            f2 = getPreCycleDistance();
                        }
                        makeSpline3.setType(next8);
                        this.mCycleMap.put(next8, makeSpline3);
                    }
                }
                Iterator<Key> it10 = this.mKeyList.iterator();
                while (it10.hasNext()) {
                    Key next9 = it10.next();
                    if (next9 instanceof KeyCycle) {
                        ((KeyCycle) next9).addCycleValues(this.mCycleMap);
                    }
                }
                for (KeyCycleOscillator keyCycleOscillator : this.mCycleMap.values()) {
                    keyCycleOscillator.setup(f2);
                }
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return " start: x: " + this.mStartMotionPath.x + " y: " + this.mStartMotionPath.y + " end: x: " + this.mEndMotionPath.x + " y: " + this.mEndMotionPath.y;
        }
        return (String) invokeV.objValue;
    }
}

package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
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

    public MotionController(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        setView(view);
    }

    private float getAdjustedPosition(float f2, float[] fArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Float.valueOf(f2), fArr})) == null) {
            float f3 = 0.0f;
            if (fArr != null) {
                fArr[0] = 1.0f;
            } else if (this.mStaggerScale != 1.0d) {
                if (f2 < this.mStaggerOffset) {
                    f2 = 0.0f;
                }
                float f4 = this.mStaggerOffset;
                if (f2 > f4 && f2 < 1.0d) {
                    f2 = (f2 - f4) * this.mStaggerScale;
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
                    if (f6 < f2) {
                        easing = easing2;
                        f3 = f6;
                    } else if (Float.isNaN(f5)) {
                        f5 = next.time;
                    }
                }
            }
            if (easing != null) {
                float f7 = (Float.isNaN(f5) ? 1.0f : f5) - f3;
                double d2 = (f2 - f3) / f7;
                f2 = (((float) easing.get(d2)) * f7) + f3;
                if (fArr != null) {
                    fArr[0] = (float) easing.getDiff(d2);
                }
            }
            return f2;
        }
        return invokeCommon.floatValue;
    }

    private float getPreCycleDistance() {
        InterceptResult invokeV;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            float[] fArr = new float[2];
            float f3 = 1.0f / 99;
            double d2 = 0.0d;
            double d3 = 0.0d;
            int i2 = 0;
            float f4 = 0.0f;
            while (i2 < 100) {
                float f5 = i2 * f3;
                double d4 = f5;
                Easing easing = this.mStartMotionPath.mKeyFrameEasing;
                float f6 = Float.NaN;
                Iterator<MotionPaths> it = this.mMotionPaths.iterator();
                float f7 = 0.0f;
                while (it.hasNext()) {
                    MotionPaths next = it.next();
                    Easing easing2 = next.mKeyFrameEasing;
                    float f8 = f3;
                    if (easing2 != null) {
                        float f9 = next.time;
                        if (f9 < f5) {
                            f7 = f9;
                            easing = easing2;
                        } else if (Float.isNaN(f6)) {
                            f6 = next.time;
                        }
                    }
                    f3 = f8;
                }
                float f10 = f3;
                if (easing != null) {
                    if (Float.isNaN(f6)) {
                        f6 = 1.0f;
                    }
                    d4 = (((float) easing.get((f5 - f7) / f2)) * (f6 - f7)) + f7;
                }
                this.mSpline[0].getPos(d4, this.mInterpolateData);
                this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                if (i2 > 0) {
                    f4 = (float) (f4 + Math.hypot(d3 - fArr[1], d2 - fArr[0]));
                }
                d2 = fArr[0];
                d3 = fArr[1];
                i2++;
                f3 = f10;
            }
            return f4;
        }
        return invokeV.floatValue;
    }

    private void insertKey(MotionPaths motionPaths) {
        int binarySearch;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, motionPaths) == null) {
            if (Collections.binarySearch(this.mMotionPaths, motionPaths) == 0) {
                r0 = " KeyPath positon \"" + motionPaths.position + "\" outside of range";
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

    public void buildBounds(float[] fArr, int i2) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, fArr, i2) == null) {
            float f3 = 1.0f / (i2 - 1);
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
            for (int i3 = 0; i3 < i2; i3++) {
                float f4 = i3 * f3;
                float f5 = 0.0f;
                if (this.mStaggerScale != 1.0f) {
                    if (f4 < this.mStaggerOffset) {
                        f4 = 0.0f;
                    }
                    float f6 = this.mStaggerOffset;
                    if (f4 > f6 && f4 < 1.0d) {
                        f4 = (f4 - f6) * this.mStaggerScale;
                    }
                }
                double d2 = f4;
                Easing easing = this.mStartMotionPath.mKeyFrameEasing;
                float f7 = Float.NaN;
                Iterator<MotionPaths> it = this.mMotionPaths.iterator();
                while (it.hasNext()) {
                    MotionPaths next = it.next();
                    Easing easing2 = next.mKeyFrameEasing;
                    if (easing2 != null) {
                        float f8 = next.time;
                        if (f8 < f4) {
                            easing = easing2;
                            f5 = f8;
                        } else if (Float.isNaN(f7)) {
                            f7 = next.time;
                        }
                    }
                }
                if (easing != null) {
                    if (Float.isNaN(f7)) {
                        f7 = 1.0f;
                    }
                    d2 = (((float) easing.get((f4 - f5) / f2)) * (f7 - f5)) + f5;
                }
                this.mSpline[0].getPos(d2, this.mInterpolateData);
                CurveFit curveFit = this.mArcSpline;
                if (curveFit != null) {
                    double[] dArr = this.mInterpolateData;
                    if (dArr.length > 0) {
                        curveFit.getPos(d2, dArr);
                    }
                }
                this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i3 * 2);
            }
        }
    }

    public int buildKeyBounds(float[] fArr, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, fArr, iArr)) == null) {
            if (fArr != null) {
                double[] timePoints = this.mSpline[0].getTimePoints();
                if (iArr != null) {
                    Iterator<MotionPaths> it = this.mMotionPaths.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        iArr[i2] = it.next().mMode;
                        i2++;
                    }
                }
                int i3 = 0;
                for (double d2 : timePoints) {
                    this.mSpline[0].getPos(d2, this.mInterpolateData);
                    this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i3);
                    i3 += 2;
                }
                return i3 / 2;
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public int buildKeyFrames(float[] fArr, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, fArr, iArr)) == null) {
            if (fArr != null) {
                double[] timePoints = this.mSpline[0].getTimePoints();
                if (iArr != null) {
                    Iterator<MotionPaths> it = this.mMotionPaths.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        iArr[i2] = it.next().mMode;
                        i2++;
                    }
                }
                int i3 = 0;
                for (double d2 : timePoints) {
                    this.mSpline[0].getPos(d2, this.mInterpolateData);
                    this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i3);
                    i3 += 2;
                }
                return i3 / 2;
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public void buildPath(float[] fArr, int i2) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, fArr, i2) == null) {
            int i3 = i2;
            float f3 = 1.0f;
            float f4 = 1.0f / (i3 - 1);
            HashMap<String, SplineSet> hashMap = this.mAttributesMap;
            SplineSet splineSet = hashMap == null ? null : hashMap.get(Key.TRANSLATION_X);
            HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
            SplineSet splineSet2 = hashMap2 == null ? null : hashMap2.get(Key.TRANSLATION_Y);
            HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
            KeyCycleOscillator keyCycleOscillator = hashMap3 == null ? null : hashMap3.get(Key.TRANSLATION_X);
            HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
            KeyCycleOscillator keyCycleOscillator2 = hashMap4 != null ? hashMap4.get(Key.TRANSLATION_Y) : null;
            int i4 = 0;
            while (i4 < i3) {
                float f5 = i4 * f4;
                float f6 = 0.0f;
                if (this.mStaggerScale != f3) {
                    if (f5 < this.mStaggerOffset) {
                        f5 = 0.0f;
                    }
                    float f7 = this.mStaggerOffset;
                    if (f5 > f7 && f5 < 1.0d) {
                        f5 = (f5 - f7) * this.mStaggerScale;
                    }
                }
                double d2 = f5;
                Easing easing = this.mStartMotionPath.mKeyFrameEasing;
                float f8 = Float.NaN;
                Iterator<MotionPaths> it = this.mMotionPaths.iterator();
                while (it.hasNext()) {
                    MotionPaths next = it.next();
                    Easing easing2 = next.mKeyFrameEasing;
                    if (easing2 != null) {
                        float f9 = next.time;
                        if (f9 < f5) {
                            f6 = f9;
                            easing = easing2;
                        } else if (Float.isNaN(f8)) {
                            f8 = next.time;
                        }
                    }
                }
                if (easing != null) {
                    if (Float.isNaN(f8)) {
                        f8 = 1.0f;
                    }
                    d2 = (((float) easing.get((f5 - f6) / f2)) * (f8 - f6)) + f6;
                }
                this.mSpline[0].getPos(d2, this.mInterpolateData);
                CurveFit curveFit = this.mArcSpline;
                if (curveFit != null) {
                    double[] dArr = this.mInterpolateData;
                    if (dArr.length > 0) {
                        curveFit.getPos(d2, dArr);
                    }
                }
                int i5 = i4 * 2;
                this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i5);
                if (keyCycleOscillator != null) {
                    fArr[i5] = fArr[i5] + keyCycleOscillator.get(f5);
                } else if (splineSet != null) {
                    fArr[i5] = fArr[i5] + splineSet.get(f5);
                }
                if (keyCycleOscillator2 != null) {
                    int i6 = i5 + 1;
                    fArr[i6] = fArr[i6] + keyCycleOscillator2.get(f5);
                } else if (splineSet2 != null) {
                    int i7 = i5 + 1;
                    fArr[i7] = fArr[i7] + splineSet2.get(f5);
                }
                i4++;
                i3 = i2;
                f3 = 1.0f;
            }
        }
    }

    public void buildRect(float f2, float[] fArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f2), fArr, Integer.valueOf(i2)}) == null) {
            this.mSpline[0].getPos(getAdjustedPosition(f2, null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
        }
    }

    public void buildRectangles(float[] fArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, fArr, i2) == null) {
            float f2 = 1.0f / (i2 - 1);
            for (int i3 = 0; i3 < i2; i3++) {
                this.mSpline[0].getPos(getAdjustedPosition(i3 * f2, null), this.mInterpolateData);
                this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i3 * 8);
            }
        }
    }

    public int getAttributeValues(String str, float[] fArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, fArr, i2)) == null) {
            SplineSet splineSet = this.mAttributesMap.get(str);
            if (splineSet == null) {
                return -1;
            }
            for (int i3 = 0; i3 < fArr.length; i3++) {
                fArr[i3] = splineSet.get(i3 / (fArr.length - 1));
            }
            return fArr.length;
        }
        return invokeLLI.intValue;
    }

    public void getDpDt(float f2, float f3, float f4, float[] fArr) {
        double[] dArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), fArr}) == null) {
            float adjustedPosition = getAdjustedPosition(f2, this.mVelocity);
            CurveFit[] curveFitArr = this.mSpline;
            int i2 = 0;
            if (curveFitArr != null) {
                double d2 = adjustedPosition;
                curveFitArr[0].getSlope(d2, this.mInterpolateVelocity);
                this.mSpline[0].getPos(d2, this.mInterpolateData);
                float f5 = this.mVelocity[0];
                while (true) {
                    dArr = this.mInterpolateVelocity;
                    if (i2 >= dArr.length) {
                        break;
                    }
                    dArr[i2] = dArr[i2] * f5;
                    i2++;
                }
                CurveFit curveFit = this.mArcSpline;
                if (curveFit != null) {
                    double[] dArr2 = this.mInterpolateData;
                    if (dArr2.length > 0) {
                        curveFit.getPos(d2, dArr2);
                        this.mArcSpline.getSlope(d2, this.mInterpolateVelocity);
                        this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
                        return;
                    }
                    return;
                }
                this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
                return;
            }
            MotionPaths motionPaths = this.mEndMotionPath;
            float f6 = motionPaths.x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f7 = f6 - motionPaths2.x;
            float f8 = motionPaths.y - motionPaths2.y;
            float f9 = (motionPaths.width - motionPaths2.width) + f7;
            float f10 = (motionPaths.height - motionPaths2.height) + f8;
            fArr[0] = (f7 * (1.0f - f3)) + (f9 * f3);
            fArr[1] = (f8 * (1.0f - f4)) + (f10 * f4);
        }
    }

    public int getDrawPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = this.mStartMotionPath.mDrawPath;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            while (it.hasNext()) {
                i2 = Math.max(i2, it.next().mDrawPath);
            }
            return Math.max(i2, this.mEndMotionPath.mDrawPath);
        }
        return invokeV.intValue;
    }

    public float getFinalX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mEndMotionPath.x : invokeV.floatValue;
    }

    public float getFinalY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mEndMotionPath.y : invokeV.floatValue;
    }

    public MotionPaths getKeyFrame(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) ? this.mMotionPaths.get(i2) : (MotionPaths) invokeI.objValue;
    }

    public int getKeyFrameInfo(int i2, int[] iArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i2, iArr)) == null) {
            float[] fArr = new float[2];
            Iterator<Key> it = this.mKeyList.iterator();
            int i3 = 0;
            int i4 = 0;
            while (it.hasNext()) {
                Key next = it.next();
                if (next.mType == i2 || i2 != -1) {
                    iArr[i4] = 0;
                    int i5 = i4 + 1;
                    iArr[i5] = next.mType;
                    int i6 = i5 + 1;
                    int i7 = next.mFramePosition;
                    iArr[i6] = i7;
                    this.mSpline[0].getPos(i7 / 100.0f, this.mInterpolateData);
                    this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                    int i8 = i6 + 1;
                    iArr[i8] = Float.floatToIntBits(fArr[0]);
                    int i9 = i8 + 1;
                    iArr[i9] = Float.floatToIntBits(fArr[1]);
                    if (next instanceof KeyPosition) {
                        KeyPosition keyPosition = (KeyPosition) next;
                        int i10 = i9 + 1;
                        iArr[i10] = keyPosition.mPositionType;
                        int i11 = i10 + 1;
                        iArr[i11] = Float.floatToIntBits(keyPosition.mPercentX);
                        i9 = i11 + 1;
                        iArr[i9] = Float.floatToIntBits(keyPosition.mPercentY);
                    }
                    int i12 = i9 + 1;
                    iArr[i4] = i12 - i4;
                    i3++;
                    i4 = i12;
                }
            }
            return i3;
        }
        return invokeIL.intValue;
    }

    public float getKeyFrameParameter(int i2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f4 = motionPaths.x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f5 = motionPaths2.x;
            float f6 = f4 - f5;
            float f7 = motionPaths.y;
            float f8 = motionPaths2.y;
            float f9 = f7 - f8;
            float f10 = f5 + (motionPaths2.width / 2.0f);
            float f11 = f8 + (motionPaths2.height / 2.0f);
            float hypot = (float) Math.hypot(f6, f9);
            if (hypot < 1.0E-7d) {
                return Float.NaN;
            }
            float f12 = f2 - f10;
            float f13 = f3 - f11;
            if (((float) Math.hypot(f12, f13)) == 0.0f) {
                return 0.0f;
            }
            float f14 = (f12 * f6) + (f13 * f9);
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 != 5) {
                                    return 0.0f;
                                }
                                return f13 / f9;
                            }
                            return f12 / f9;
                        }
                        return f13 / f6;
                    }
                    return f12 / f6;
                }
                return (float) Math.sqrt((hypot * hypot) - (f14 * f14));
            }
            return f14 / hypot;
        }
        return invokeCommon.floatValue;
    }

    public KeyPositionBase getPositionKeyframe(int i2, int i3, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            RectF rectF = new RectF();
            MotionPaths motionPaths = this.mStartMotionPath;
            float f4 = motionPaths.x;
            rectF.left = f4;
            float f5 = motionPaths.y;
            rectF.top = f5;
            rectF.right = f4 + motionPaths.width;
            rectF.bottom = f5 + motionPaths.height;
            RectF rectF2 = new RectF();
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float f6 = motionPaths2.x;
            rectF2.left = f6;
            float f7 = motionPaths2.y;
            rectF2.top = f7;
            rectF2.right = f6 + motionPaths2.width;
            rectF2.bottom = f7 + motionPaths2.height;
            Iterator<Key> it = this.mKeyList.iterator();
            while (it.hasNext()) {
                Key next = it.next();
                if (next instanceof KeyPositionBase) {
                    KeyPositionBase keyPositionBase = (KeyPositionBase) next;
                    if (keyPositionBase.intersects(i2, i3, rectF, rectF2, f2, f3)) {
                        return keyPositionBase;
                    }
                }
            }
            return null;
        }
        return (KeyPositionBase) invokeCommon.objValue;
    }

    public void getPostLayoutDvDp(float f2, int i2, int i3, float f3, float f4, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048593, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f3), Float.valueOf(f4), fArr}) != null) {
            return;
        }
        float adjustedPosition = getAdjustedPosition(f2, this.mVelocity);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        SplineSet splineSet = hashMap == null ? null : hashMap.get(Key.TRANSLATION_X);
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        SplineSet splineSet2 = hashMap2 == null ? null : hashMap2.get(Key.TRANSLATION_Y);
        HashMap<String, SplineSet> hashMap3 = this.mAttributesMap;
        SplineSet splineSet3 = hashMap3 == null ? null : hashMap3.get(Key.ROTATION);
        HashMap<String, SplineSet> hashMap4 = this.mAttributesMap;
        SplineSet splineSet4 = hashMap4 == null ? null : hashMap4.get(Key.SCALE_X);
        HashMap<String, SplineSet> hashMap5 = this.mAttributesMap;
        SplineSet splineSet5 = hashMap5 == null ? null : hashMap5.get(Key.SCALE_Y);
        HashMap<String, KeyCycleOscillator> hashMap6 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator = hashMap6 == null ? null : hashMap6.get(Key.TRANSLATION_X);
        HashMap<String, KeyCycleOscillator> hashMap7 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator2 = hashMap7 == null ? null : hashMap7.get(Key.TRANSLATION_Y);
        HashMap<String, KeyCycleOscillator> hashMap8 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator3 = hashMap8 == null ? null : hashMap8.get(Key.ROTATION);
        HashMap<String, KeyCycleOscillator> hashMap9 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator4 = hashMap9 == null ? null : hashMap9.get(Key.SCALE_X);
        HashMap<String, KeyCycleOscillator> hashMap10 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator5 = hashMap10 != null ? hashMap10.get(Key.SCALE_Y) : null;
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
                double d2 = adjustedPosition;
                curveFit.getPos(d2, dArr);
                this.mArcSpline.getSlope(d2, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f3, f4, i2, i3, fArr);
            return;
        }
        int i4 = 0;
        if (this.mSpline != null) {
            double adjustedPosition2 = getAdjustedPosition(adjustedPosition, this.mVelocity);
            this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
            this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
            float f5 = this.mVelocity[0];
            while (true) {
                double[] dArr2 = this.mInterpolateVelocity;
                if (i4 < dArr2.length) {
                    dArr2[i4] = dArr2[i4] * f5;
                    i4++;
                } else {
                    this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                    velocityMatrix.applyTransform(f3, f4, i2, i3, fArr);
                    return;
                }
            }
        } else {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f6 = motionPaths.x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f7 = f6 - motionPaths2.x;
            float f8 = motionPaths.y - motionPaths2.y;
            KeyCycleOscillator keyCycleOscillator6 = keyCycleOscillator4;
            float f9 = (motionPaths.height - motionPaths2.height) + f8;
            fArr[0] = (f7 * (1.0f - f3)) + (((motionPaths.width - motionPaths2.width) + f7) * f3);
            fArr[1] = (f8 * (1.0f - f4)) + (f9 * f4);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
            velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
            velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(keyCycleOscillator6, keyCycleOscillator5, adjustedPosition);
            velocityMatrix.applyTransform(f3, f4, i2, i3, fArr);
        }
    }

    public float getStartX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mStartMotionPath.x : invokeV.floatValue;
    }

    public float getStartY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mStartMotionPath.y : invokeV.floatValue;
    }

    public int getkeyFramePositions(int[] iArr, float[] fArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, iArr, fArr)) == null) {
            Iterator<Key> it = this.mKeyList.iterator();
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                Key next = it.next();
                int i4 = next.mFramePosition;
                iArr[i2] = (next.mType * 1000) + i4;
                this.mSpline[0].getPos(i4 / 100.0f, this.mInterpolateData);
                this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i3);
                i3 += 2;
                i2++;
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    public boolean interpolate(View view, float f2, long j, KeyCache keyCache) {
        InterceptResult invokeCommon;
        TimeCycleSplineSet.PathRotate pathRotate;
        boolean z;
        double d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{view, Float.valueOf(f2), Long.valueOf(j), keyCache})) == null) {
            float adjustedPosition = getAdjustedPosition(f2, null);
            HashMap<String, SplineSet> hashMap = this.mAttributesMap;
            if (hashMap != null) {
                for (SplineSet splineSet : hashMap.values()) {
                    splineSet.setProperty(view, adjustedPosition);
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
                        z2 |= timeCycleSplineSet.setProperty(view, adjustedPosition, j, keyCache);
                    }
                }
                z = z2;
            } else {
                pathRotate = null;
                z = false;
            }
            CurveFit[] curveFitArr = this.mSpline;
            if (curveFitArr != null) {
                double d3 = adjustedPosition;
                curveFitArr[0].getPos(d3, this.mInterpolateData);
                this.mSpline[0].getSlope(d3, this.mInterpolateVelocity);
                CurveFit curveFit = this.mArcSpline;
                if (curveFit != null) {
                    double[] dArr = this.mInterpolateData;
                    if (dArr.length > 0) {
                        curveFit.getPos(d3, dArr);
                        this.mArcSpline.getSlope(d3, this.mInterpolateVelocity);
                    }
                }
                this.mStartMotionPath.setView(view, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
                HashMap<String, SplineSet> hashMap3 = this.mAttributesMap;
                if (hashMap3 != null) {
                    for (SplineSet splineSet2 : hashMap3.values()) {
                        if (splineSet2 instanceof SplineSet.PathRotate) {
                            double[] dArr2 = this.mInterpolateVelocity;
                            ((SplineSet.PathRotate) splineSet2).setPathRotate(view, adjustedPosition, dArr2[0], dArr2[1]);
                        }
                    }
                }
                if (pathRotate != null) {
                    double[] dArr3 = this.mInterpolateVelocity;
                    d2 = d3;
                    z = pathRotate.setPathRotate(view, keyCache, adjustedPosition, j, dArr3[0], dArr3[1]) | z;
                } else {
                    d2 = d3;
                }
                int i2 = 1;
                while (true) {
                    CurveFit[] curveFitArr2 = this.mSpline;
                    if (i2 >= curveFitArr2.length) {
                        break;
                    }
                    curveFitArr2[i2].getPos(d2, this.mValuesBuff);
                    this.mStartMotionPath.attributes.get(this.mAttributeNames[i2 - 1]).setInterpolatedValue(view, this.mValuesBuff);
                    i2++;
                }
                MotionConstrainedPoint motionConstrainedPoint = this.mStartPoint;
                if (motionConstrainedPoint.mVisibilityMode == 0) {
                    if (adjustedPosition <= 0.0f) {
                        view.setVisibility(motionConstrainedPoint.visibility);
                    } else if (adjustedPosition >= 1.0f) {
                        view.setVisibility(this.mEndPoint.visibility);
                    } else if (this.mEndPoint.visibility != motionConstrainedPoint.visibility) {
                        view.setVisibility(0);
                    }
                }
                if (this.mKeyTriggers != null) {
                    int i3 = 0;
                    while (true) {
                        KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
                        if (i3 >= keyTriggerArr.length) {
                            break;
                        }
                        keyTriggerArr[i3].conditionallyFire(adjustedPosition, view);
                        i3++;
                    }
                }
            } else {
                MotionPaths motionPaths = this.mStartMotionPath;
                float f3 = motionPaths.x;
                MotionPaths motionPaths2 = this.mEndMotionPath;
                float f4 = f3 + ((motionPaths2.x - f3) * adjustedPosition);
                float f5 = motionPaths.y;
                float f6 = f5 + ((motionPaths2.y - f5) * adjustedPosition);
                float f7 = motionPaths.width;
                float f8 = motionPaths2.width;
                float f9 = motionPaths.height;
                float f10 = motionPaths2.height;
                float f11 = f4 + 0.5f;
                int i4 = (int) f11;
                float f12 = f6 + 0.5f;
                int i5 = (int) f12;
                int i6 = (int) (f11 + ((f8 - f7) * adjustedPosition) + f7);
                int i7 = (int) (f12 + ((f10 - f9) * adjustedPosition) + f9);
                int i8 = i6 - i4;
                int i9 = i7 - i5;
                if (f8 != f7 || f10 != f9) {
                    view.measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i9, 1073741824));
                }
                view.layout(i4, i5, i6, i7);
            }
            HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
            if (hashMap4 != null) {
                for (KeyCycleOscillator keyCycleOscillator : hashMap4.values()) {
                    if (keyCycleOscillator instanceof KeyCycleOscillator.PathRotateSet) {
                        double[] dArr4 = this.mInterpolateVelocity;
                        ((KeyCycleOscillator.PathRotateSet) keyCycleOscillator).setPathRotate(view, adjustedPosition, dArr4[0], dArr4[1]);
                    } else {
                        keyCycleOscillator.setProperty(view, adjustedPosition);
                    }
                }
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public String name() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mView.getContext().getResources().getResourceEntryName(this.mView.getId()) : (String) invokeV.objValue;
    }

    public void positionKeyframe(View view, KeyPositionBase keyPositionBase, float f2, float f3, String[] strArr, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{view, keyPositionBase, Float.valueOf(f2), Float.valueOf(f3), strArr, fArr}) == null) {
            RectF rectF = new RectF();
            MotionPaths motionPaths = this.mStartMotionPath;
            float f4 = motionPaths.x;
            rectF.left = f4;
            float f5 = motionPaths.y;
            rectF.top = f5;
            rectF.right = f4 + motionPaths.width;
            rectF.bottom = f5 + motionPaths.height;
            RectF rectF2 = new RectF();
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float f6 = motionPaths2.x;
            rectF2.left = f6;
            float f7 = motionPaths2.y;
            rectF2.top = f7;
            rectF2.right = f6 + motionPaths2.width;
            rectF2.bottom = f7 + motionPaths2.height;
            keyPositionBase.positionAttributes(view, rectF, rectF2, f2, f3, strArr, fArr);
        }
    }

    public void setDrawPath(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.mStartMotionPath.mDrawPath = i2;
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

    public void setPathMotionArc(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.mPathMotionArc = i2;
        }
    }

    public void setStartCurrentState(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, view) == null) {
            MotionPaths motionPaths = this.mStartMotionPath;
            motionPaths.time = 0.0f;
            motionPaths.position = 0.0f;
            motionPaths.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
            this.mStartPoint.setState(view);
        }
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

    public void setView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, view) == null) {
            this.mView = view;
            this.mId = view.getId();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                this.mConstraintTag = ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
            }
        }
    }

    public void setup(int i2, int i3, float f2, long j) {
        ArrayList arrayList;
        TimeCycleSplineSet makeSpline;
        ConstraintAttribute constraintAttribute;
        SplineSet makeSpline2;
        ConstraintAttribute constraintAttribute2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Long.valueOf(j)}) == null) {
            new HashSet();
            HashSet<String> hashSet = new HashSet<>();
            HashSet<String> hashSet2 = new HashSet<>();
            HashSet<String> hashSet3 = new HashSet<>();
            HashMap<String, Integer> hashMap = new HashMap<>();
            int i4 = this.mPathMotionArc;
            if (i4 != Key.UNSET) {
                this.mStartMotionPath.mPathMotionArc = i4;
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
                        insertKey(new MotionPaths(i2, i3, keyPosition, this.mStartMotionPath, this.mEndMotionPath));
                        int i5 = keyPosition.mCurveFit;
                        if (i5 != Key.UNSET) {
                            this.mCurveFitType = i5;
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
            char c2 = 0;
            if (arrayList != null) {
                this.mKeyTriggers = (KeyTrigger[]) arrayList.toArray(new KeyTrigger[0]);
            }
            char c3 = 1;
            if (!hashSet2.isEmpty()) {
                this.mAttributesMap = new HashMap<>();
                Iterator<String> it2 = hashSet2.iterator();
                while (it2.hasNext()) {
                    String next2 = it2.next();
                    if (next2.startsWith("CUSTOM,")) {
                        SparseArray sparseArray = new SparseArray();
                        String str = next2.split(",")[c3];
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
                    c3 = 1;
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
                    this.mAttributesMap.get(str2).setup(hashMap.containsKey(str2) ? hashMap.get(str2).intValue() : 0);
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
                    this.mTimeCycleAttributesMap.get(str4).setup(hashMap.containsKey(str4) ? hashMap.get(str4).intValue() : 0);
                }
            }
            int i6 = 2;
            int size = this.mMotionPaths.size() + 2;
            MotionPaths[] motionPathsArr = new MotionPaths[size];
            motionPathsArr[0] = this.mStartMotionPath;
            motionPathsArr[size - 1] = this.mEndMotionPath;
            if (this.mMotionPaths.size() > 0 && this.mCurveFitType == -1) {
                this.mCurveFitType = 0;
            }
            Iterator<MotionPaths> it8 = this.mMotionPaths.iterator();
            int i7 = 1;
            while (it8.hasNext()) {
                motionPathsArr[i7] = it8.next();
                i7++;
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
            int i8 = 0;
            while (true) {
                String[] strArr2 = this.mAttributeNames;
                if (i8 >= strArr2.length) {
                    break;
                }
                String str6 = strArr2[i8];
                this.mAttributeInterpCount[i8] = 0;
                int i9 = 0;
                while (true) {
                    if (i9 >= size) {
                        break;
                    } else if (motionPathsArr[i9].attributes.containsKey(str6)) {
                        int[] iArr = this.mAttributeInterpCount;
                        iArr[i8] = iArr[i8] + motionPathsArr[i9].attributes.get(str6).noOfInterpValues();
                        break;
                    } else {
                        i9++;
                    }
                }
                i8++;
            }
            boolean z = motionPathsArr[0].mPathMotionArc != Key.UNSET;
            int length = 18 + this.mAttributeNames.length;
            boolean[] zArr = new boolean[length];
            for (int i10 = 1; i10 < size; i10++) {
                motionPathsArr[i10].different(motionPathsArr[i10 - 1], zArr, this.mAttributeNames, z);
            }
            int i11 = 0;
            for (int i12 = 1; i12 < length; i12++) {
                if (zArr[i12]) {
                    i11++;
                }
            }
            int[] iArr2 = new int[i11];
            this.mInterpolateVariables = iArr2;
            this.mInterpolateData = new double[iArr2.length];
            this.mInterpolateVelocity = new double[iArr2.length];
            int i13 = 0;
            for (int i14 = 1; i14 < length; i14++) {
                if (zArr[i14]) {
                    this.mInterpolateVariables[i13] = i14;
                    i13++;
                }
            }
            double[][] dArr = (double[][]) Array.newInstance(double.class, size, this.mInterpolateVariables.length);
            double[] dArr2 = new double[size];
            for (int i15 = 0; i15 < size; i15++) {
                motionPathsArr[i15].fillStandard(dArr[i15], this.mInterpolateVariables);
                dArr2[i15] = motionPathsArr[i15].time;
            }
            int i16 = 0;
            while (true) {
                int[] iArr3 = this.mInterpolateVariables;
                if (i16 >= iArr3.length) {
                    break;
                }
                if (iArr3[i16] < MotionPaths.names.length) {
                    String str7 = MotionPaths.names[this.mInterpolateVariables[i16]] + " [";
                    for (int i17 = 0; i17 < size; i17++) {
                        str7 = str7 + dArr[i17][i16];
                    }
                }
                i16++;
            }
            this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
            int i18 = 0;
            while (true) {
                String[] strArr3 = this.mAttributeNames;
                if (i18 >= strArr3.length) {
                    break;
                }
                String str8 = strArr3[i18];
                int i19 = 0;
                double[] dArr3 = null;
                int i20 = 0;
                double[][] dArr4 = null;
                while (i19 < size) {
                    if (motionPathsArr[i19].hasCustomData(str8)) {
                        if (dArr4 == null) {
                            dArr3 = new double[size];
                            int[] iArr4 = new int[i6];
                            iArr4[1] = motionPathsArr[i19].getCustomDataCount(str8);
                            iArr4[c2] = size;
                            dArr4 = (double[][]) Array.newInstance(double.class, iArr4);
                        }
                        dArr3[i20] = motionPathsArr[i19].time;
                        motionPathsArr[i19].getCustomData(str8, dArr4[i20], 0);
                        i20++;
                    }
                    i19++;
                    i6 = 2;
                    c2 = 0;
                }
                i18++;
                this.mSpline[i18] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i20), (double[][]) Arrays.copyOf(dArr4, i20));
                i6 = 2;
                c2 = 0;
            }
            this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
            if (motionPathsArr[0].mPathMotionArc != Key.UNSET) {
                int[] iArr5 = new int[size];
                double[] dArr5 = new double[size];
                double[][] dArr6 = (double[][]) Array.newInstance(double.class, size, 2);
                for (int i21 = 0; i21 < size; i21++) {
                    iArr5[i21] = motionPathsArr[i21].mPathMotionArc;
                    dArr5[i21] = motionPathsArr[i21].time;
                    dArr6[i21][0] = motionPathsArr[i21].x;
                    dArr6[i21][1] = motionPathsArr[i21].y;
                }
                this.mArcSpline = CurveFit.getArc(iArr5, dArr5, dArr6);
            }
            float f3 = Float.NaN;
            this.mCycleMap = new HashMap<>();
            if (this.mKeyList != null) {
                Iterator<String> it9 = hashSet3.iterator();
                while (it9.hasNext()) {
                    String next8 = it9.next();
                    KeyCycleOscillator makeSpline3 = KeyCycleOscillator.makeSpline(next8);
                    if (makeSpline3 != null) {
                        if (makeSpline3.variesByPath() && Float.isNaN(f3)) {
                            f3 = getPreCycleDistance();
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
                    keyCycleOscillator.setup(f3);
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

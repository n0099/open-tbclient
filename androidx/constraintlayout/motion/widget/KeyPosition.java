package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.R;
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
/* loaded from: classes.dex */
public class KeyPosition extends KeyPositionBase {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int KEY_TYPE = 2;
    public static final String NAME = "KeyPosition";
    public static final String PERCENT_X = "percentX";
    public static final String PERCENT_Y = "percentY";
    public static final String TAG = "KeyPosition";
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public float mAltPercentX;
    public float mAltPercentY;
    public float mCalculatedPositionX;
    public float mCalculatedPositionY;
    public int mDrawPath;
    public int mPathMotionArc;
    public float mPercentHeight;
    public float mPercentWidth;
    public float mPercentX;
    public float mPercentY;
    public int mPositionType;
    public String mTransitionEasing;

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
        }
    }

    /* loaded from: classes.dex */
    public static class Loader {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int CURVE_FIT = 4;
        public static final int DRAW_PATH = 5;
        public static final int FRAME_POSITION = 2;
        public static final int PATH_MOTION_ARC = 10;
        public static final int PERCENT_HEIGHT = 12;
        public static final int PERCENT_WIDTH = 11;
        public static final int PERCENT_X = 6;
        public static final int PERCENT_Y = 7;
        public static final int SIZE_PERCENT = 8;
        public static final int TARGET_ID = 1;
        public static final int TRANSITION_EASING = 3;
        public static final int TYPE = 9;
        public static SparseIntArray mAttrMap;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1793493836, "Landroidx/constraintlayout/motion/widget/KeyPosition$Loader;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1793493836, "Landroidx/constraintlayout/motion/widget/KeyPosition$Loader;");
                    return;
                }
            }
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(4, 1);
            mAttrMap.append(2, 2);
            mAttrMap.append(11, 3);
            mAttrMap.append(0, 4);
            mAttrMap.append(1, 5);
            mAttrMap.append(8, 6);
            mAttrMap.append(9, 7);
            mAttrMap.append(3, 9);
            mAttrMap.append(10, 8);
            mAttrMap.append(7, 11);
            mAttrMap.append(6, 12);
            mAttrMap.append(5, 10);
        }

        public Loader() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static void read(KeyPosition keyPosition, TypedArray typedArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, keyPosition, typedArray) == null) {
                int indexCount = typedArray.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = typedArray.getIndex(i);
                    switch (mAttrMap.get(index)) {
                        case 1:
                            if (MotionLayout.IS_IN_EDIT_MODE) {
                                int resourceId = typedArray.getResourceId(index, keyPosition.mTargetId);
                                keyPosition.mTargetId = resourceId;
                                if (resourceId == -1) {
                                    keyPosition.mTargetString = typedArray.getString(index);
                                    break;
                                } else {
                                    break;
                                }
                            } else if (typedArray.peekValue(index).type == 3) {
                                keyPosition.mTargetString = typedArray.getString(index);
                                break;
                            } else {
                                keyPosition.mTargetId = typedArray.getResourceId(index, keyPosition.mTargetId);
                                break;
                            }
                        case 2:
                            keyPosition.mFramePosition = typedArray.getInt(index, keyPosition.mFramePosition);
                            break;
                        case 3:
                            if (typedArray.peekValue(index).type == 3) {
                                keyPosition.mTransitionEasing = typedArray.getString(index);
                                break;
                            } else {
                                keyPosition.mTransitionEasing = Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                                break;
                            }
                        case 4:
                            keyPosition.mCurveFit = typedArray.getInteger(index, keyPosition.mCurveFit);
                            break;
                        case 5:
                            keyPosition.mDrawPath = typedArray.getInt(index, keyPosition.mDrawPath);
                            break;
                        case 6:
                            keyPosition.mPercentX = typedArray.getFloat(index, keyPosition.mPercentX);
                            break;
                        case 7:
                            keyPosition.mPercentY = typedArray.getFloat(index, keyPosition.mPercentY);
                            break;
                        case 8:
                            float f = typedArray.getFloat(index, keyPosition.mPercentHeight);
                            keyPosition.mPercentWidth = f;
                            keyPosition.mPercentHeight = f;
                            break;
                        case 9:
                            keyPosition.mPositionType = typedArray.getInt(index, keyPosition.mPositionType);
                            break;
                        case 10:
                            keyPosition.mPathMotionArc = typedArray.getInt(index, keyPosition.mPathMotionArc);
                            break;
                        case 11:
                            keyPosition.mPercentWidth = typedArray.getFloat(index, keyPosition.mPercentWidth);
                            break;
                        case 12:
                            keyPosition.mPercentHeight = typedArray.getFloat(index, keyPosition.mPercentHeight);
                            break;
                        default:
                            Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index));
                            break;
                    }
                }
                if (keyPosition.mFramePosition == -1) {
                    Log.e("KeyPosition", "no frame position");
                }
            }
        }
    }

    public KeyPosition() {
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
        this.mTransitionEasing = null;
        this.mPathMotionArc = Key.UNSET;
        this.mDrawPath = 0;
        this.mPercentWidth = Float.NaN;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = Float.NaN;
        this.mPercentY = Float.NaN;
        this.mAltPercentX = Float.NaN;
        this.mAltPercentY = Float.NaN;
        this.mPositionType = 0;
        this.mCalculatedPositionX = Float.NaN;
        this.mCalculatedPositionY = Float.NaN;
        this.mType = 2;
    }

    private void calcCartesianPosition(float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        float f7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            float f8 = f3 - f;
            float f9 = f4 - f2;
            float f10 = 0.0f;
            if (Float.isNaN(this.mPercentX)) {
                f5 = 0.0f;
            } else {
                f5 = this.mPercentX;
            }
            if (Float.isNaN(this.mAltPercentY)) {
                f6 = 0.0f;
            } else {
                f6 = this.mAltPercentY;
            }
            if (Float.isNaN(this.mPercentY)) {
                f7 = 0.0f;
            } else {
                f7 = this.mPercentY;
            }
            if (!Float.isNaN(this.mAltPercentX)) {
                f10 = this.mAltPercentX;
            }
            this.mCalculatedPositionX = (int) (f + (f5 * f8) + (f10 * f9));
            this.mCalculatedPositionY = (int) (f2 + (f8 * f6) + (f9 * f7));
        }
    }

    private void calcPathPosition(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            float f5 = f3 - f;
            float f6 = f4 - f2;
            float f7 = this.mPercentX;
            float f8 = this.mPercentY;
            this.mCalculatedPositionX = f + (f5 * f7) + ((-f6) * f8);
            this.mCalculatedPositionY = f2 + (f6 * f7) + (f5 * f8);
        }
    }

    private void calcScreenPosition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65539, this, i, i2) == null) {
            float f = this.mPercentX;
            float f2 = 0;
            this.mCalculatedPositionX = ((i - 0) * f) + f2;
            this.mCalculatedPositionY = ((i2 - 0) * f) + f2;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, attributeSet) == null) {
            Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyPosition));
        }
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public void calcPosition(int i, int i2, float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            int i3 = this.mPositionType;
            if (i3 != 1) {
                if (i3 != 2) {
                    calcCartesianPosition(f, f2, f3, f4);
                    return;
                } else {
                    calcScreenPosition(i, i2);
                    return;
                }
            }
            calcPathPosition(f, f2, f3, f4);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public float getPositionX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mCalculatedPositionX;
        }
        return invokeV.floatValue;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public float getPositionY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mCalculatedPositionY;
        }
        return invokeV.floatValue;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public boolean intersects(int i, int i2, RectF rectF, RectF rectF2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), rectF, rectF2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            calcPosition(i, i2, rectF.centerX(), rectF.centerY(), rectF2.centerX(), rectF2.centerY());
            if (Math.abs(f - this.mCalculatedPositionX) < 20.0f && Math.abs(f2 - this.mCalculatedPositionY) < 20.0f) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void positionCartAttributes(RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{rectF, rectF2, Float.valueOf(f), Float.valueOf(f2), strArr, fArr}) == null) {
            float centerX = rectF.centerX();
            float centerY = rectF.centerY();
            float centerX2 = rectF2.centerX() - centerX;
            float centerY2 = rectF2.centerY() - centerY;
            if (strArr[0] != null) {
                if (PERCENT_X.equals(strArr[0])) {
                    fArr[0] = (f - centerX) / centerX2;
                    fArr[1] = (f2 - centerY) / centerY2;
                    return;
                }
                fArr[1] = (f - centerX) / centerX2;
                fArr[0] = (f2 - centerY) / centerY2;
                return;
            }
            strArr[0] = PERCENT_X;
            fArr[0] = (f - centerX) / centerX2;
            strArr[1] = PERCENT_Y;
            fArr[1] = (f2 - centerY) / centerY2;
        }
    }

    public void positionPathAttributes(RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{rectF, rectF2, Float.valueOf(f), Float.valueOf(f2), strArr, fArr}) == null) {
            float centerX = rectF.centerX();
            float centerY = rectF.centerY();
            float centerX2 = rectF2.centerX() - centerX;
            float centerY2 = rectF2.centerY() - centerY;
            float hypot = (float) Math.hypot(centerX2, centerY2);
            if (hypot < 1.0E-4d) {
                System.out.println("distance ~ 0");
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                return;
            }
            float f3 = centerX2 / hypot;
            float f4 = centerY2 / hypot;
            float f5 = f2 - centerY;
            float f6 = f - centerX;
            float f7 = ((f3 * f5) - (f6 * f4)) / hypot;
            float f8 = ((f3 * f6) + (f4 * f5)) / hypot;
            if (strArr[0] != null) {
                if (PERCENT_X.equals(strArr[0])) {
                    fArr[0] = f8;
                    fArr[1] = f7;
                    return;
                }
                return;
            }
            strArr[0] = PERCENT_X;
            strArr[1] = PERCENT_Y;
            fArr[0] = f8;
            fArr[1] = f7;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public void positionAttributes(View view2, RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view2, rectF, rectF2, Float.valueOf(f), Float.valueOf(f2), strArr, fArr}) == null) {
            int i = this.mPositionType;
            if (i != 1) {
                if (i != 2) {
                    positionCartAttributes(rectF, rectF2, f, f2, strArr, fArr);
                    return;
                } else {
                    positionScreenAttributes(view2, rectF, rectF2, f, f2, strArr, fArr);
                    return;
                }
            }
            positionPathAttributes(rectF, rectF2, f, f2, strArr, fArr);
        }
    }

    public void positionScreenAttributes(View view2, RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{view2, rectF, rectF2, Float.valueOf(f), Float.valueOf(f2), strArr, fArr}) == null) {
            rectF.centerX();
            rectF.centerY();
            rectF2.centerX();
            rectF2.centerY();
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int width = viewGroup.getWidth();
            int height = viewGroup.getHeight();
            if (strArr[0] != null) {
                if (PERCENT_X.equals(strArr[0])) {
                    fArr[0] = f / width;
                    fArr[1] = f2 / height;
                    return;
                }
                fArr[1] = f / width;
                fArr[0] = f2 / height;
                return;
            }
            strArr[0] = PERCENT_X;
            fArr[0] = f / width;
            strArr[1] = PERCENT_Y;
            fArr[1] = f2 / height;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, obj) == null) {
            switch (str.hashCode()) {
                case -1812823328:
                    if (str.equals("transitionEasing")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1127236479:
                    if (str.equals("percentWidth")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1017587252:
                    if (str.equals("percentHeight")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -827014263:
                    if (str.equals("drawPath")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -200259324:
                    if (str.equals("sizePercent")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 428090547:
                    if (str.equals(PERCENT_X)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 428090548:
                    if (str.equals(PERCENT_Y)) {
                        c = 6;
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
                    this.mTransitionEasing = obj.toString();
                    return;
                case 1:
                    this.mDrawPath = toInt(obj);
                    return;
                case 2:
                    this.mPercentWidth = toFloat(obj);
                    return;
                case 3:
                    this.mPercentHeight = toFloat(obj);
                    return;
                case 4:
                    float f = toFloat(obj);
                    this.mPercentWidth = f;
                    this.mPercentHeight = f;
                    return;
                case 5:
                    this.mPercentX = toFloat(obj);
                    return;
                case 6:
                    this.mPercentY = toFloat(obj);
                    return;
                default:
                    return;
            }
        }
    }
}

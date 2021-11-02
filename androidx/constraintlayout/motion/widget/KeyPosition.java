package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
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
            sparseIntArray.append(R.styleable.KeyPosition_motionTarget, 1);
            mAttrMap.append(R.styleable.KeyPosition_framePosition, 2);
            mAttrMap.append(R.styleable.KeyPosition_transitionEasing, 3);
            mAttrMap.append(R.styleable.KeyPosition_curveFit, 4);
            mAttrMap.append(R.styleable.KeyPosition_drawPath, 5);
            mAttrMap.append(R.styleable.KeyPosition_percentX, 6);
            mAttrMap.append(R.styleable.KeyPosition_percentY, 7);
            mAttrMap.append(R.styleable.KeyPosition_keyPositionType, 9);
            mAttrMap.append(R.styleable.KeyPosition_sizePercent, 8);
            mAttrMap.append(R.styleable.KeyPosition_percentWidth, 11);
            mAttrMap.append(R.styleable.KeyPosition_percentHeight, 12);
            mAttrMap.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }

        public Loader() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static void read(KeyPosition keyPosition, TypedArray typedArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, keyPosition, typedArray) == null) {
                int indexCount = typedArray.getIndexCount();
                for (int i2 = 0; i2 < indexCount; i2++) {
                    int index = typedArray.getIndex(i2);
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
                            float f2 = typedArray.getFloat(index, keyPosition.mPercentHeight);
                            keyPosition.mPercentWidth = f2;
                            keyPosition.mPercentHeight = f2;
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
                            String str = "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index);
                            break;
                    }
                }
                int i3 = keyPosition.mFramePosition;
            }
        }
    }

    public KeyPosition() {
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

    private void calcCartesianPosition(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            float f6 = f4 - f2;
            float f7 = f5 - f3;
            float f8 = Float.isNaN(this.mPercentX) ? 0.0f : this.mPercentX;
            float f9 = Float.isNaN(this.mAltPercentY) ? 0.0f : this.mAltPercentY;
            float f10 = Float.isNaN(this.mPercentY) ? 0.0f : this.mPercentY;
            this.mCalculatedPositionX = (int) (f2 + (f8 * f6) + ((Float.isNaN(this.mAltPercentX) ? 0.0f : this.mAltPercentX) * f7));
            this.mCalculatedPositionY = (int) (f3 + (f6 * f9) + (f7 * f10));
        }
    }

    private void calcPathPosition(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            float f6 = f4 - f2;
            float f7 = f5 - f3;
            float f8 = this.mPercentX;
            float f9 = this.mPercentY;
            this.mCalculatedPositionX = f2 + (f6 * f8) + ((-f7) * f9);
            this.mCalculatedPositionY = f3 + (f7 * f8) + (f6 * f9);
        }
    }

    private void calcScreenPosition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65539, this, i2, i3) == null) {
            float f2 = this.mPercentX;
            float f3 = 0;
            this.mCalculatedPositionX = ((i2 - 0) * f2) + f3;
            this.mCalculatedPositionY = ((i3 - 0) * f2) + f3;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
        }
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public void calcPosition(int i2, int i3, float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            int i4 = this.mPositionType;
            if (i4 == 1) {
                calcPathPosition(f2, f3, f4, f5);
            } else if (i4 != 2) {
                calcCartesianPosition(f2, f3, f4, f5);
            } else {
                calcScreenPosition(i2, i3);
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public float getPositionX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCalculatedPositionX : invokeV.floatValue;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public float getPositionY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCalculatedPositionY : invokeV.floatValue;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public boolean intersects(int i2, int i3, RectF rectF, RectF rectF2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), rectF, rectF2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            calcPosition(i2, i3, rectF.centerX(), rectF.centerY(), rectF2.centerX(), rectF2.centerY());
            return Math.abs(f2 - this.mCalculatedPositionX) < 20.0f && Math.abs(f3 - this.mCalculatedPositionY) < 20.0f;
        }
        return invokeCommon.booleanValue;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, attributeSet) == null) {
            Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyPosition));
        }
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public void positionAttributes(View view, RectF rectF, RectF rectF2, float f2, float f3, String[] strArr, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view, rectF, rectF2, Float.valueOf(f2), Float.valueOf(f3), strArr, fArr}) == null) {
            int i2 = this.mPositionType;
            if (i2 == 1) {
                positionPathAttributes(rectF, rectF2, f2, f3, strArr, fArr);
            } else if (i2 != 2) {
                positionCartAttributes(rectF, rectF2, f2, f3, strArr, fArr);
            } else {
                positionScreenAttributes(view, rectF, rectF2, f2, f3, strArr, fArr);
            }
        }
    }

    public void positionCartAttributes(RectF rectF, RectF rectF2, float f2, float f3, String[] strArr, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{rectF, rectF2, Float.valueOf(f2), Float.valueOf(f3), strArr, fArr}) == null) {
            float centerX = rectF.centerX();
            float centerY = rectF.centerY();
            float centerX2 = rectF2.centerX() - centerX;
            float centerY2 = rectF2.centerY() - centerY;
            if (strArr[0] != null) {
                if (PERCENT_X.equals(strArr[0])) {
                    fArr[0] = (f2 - centerX) / centerX2;
                    fArr[1] = (f3 - centerY) / centerY2;
                    return;
                }
                fArr[1] = (f2 - centerX) / centerX2;
                fArr[0] = (f3 - centerY) / centerY2;
                return;
            }
            strArr[0] = PERCENT_X;
            fArr[0] = (f2 - centerX) / centerX2;
            strArr[1] = PERCENT_Y;
            fArr[1] = (f3 - centerY) / centerY2;
        }
    }

    public void positionPathAttributes(RectF rectF, RectF rectF2, float f2, float f3, String[] strArr, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{rectF, rectF2, Float.valueOf(f2), Float.valueOf(f3), strArr, fArr}) == null) {
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
            float f4 = centerX2 / hypot;
            float f5 = centerY2 / hypot;
            float f6 = f3 - centerY;
            float f7 = f2 - centerX;
            float f8 = ((f4 * f6) - (f7 * f5)) / hypot;
            float f9 = ((f4 * f7) + (f5 * f6)) / hypot;
            if (strArr[0] != null) {
                if (PERCENT_X.equals(strArr[0])) {
                    fArr[0] = f9;
                    fArr[1] = f8;
                    return;
                }
                return;
            }
            strArr[0] = PERCENT_X;
            strArr[1] = PERCENT_Y;
            fArr[0] = f9;
            fArr[1] = f8;
        }
    }

    public void positionScreenAttributes(View view, RectF rectF, RectF rectF2, float f2, float f3, String[] strArr, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{view, rectF, rectF2, Float.valueOf(f2), Float.valueOf(f3), strArr, fArr}) == null) {
            rectF.centerX();
            rectF.centerY();
            rectF2.centerX();
            rectF2.centerY();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int width = viewGroup.getWidth();
            int height = viewGroup.getHeight();
            if (strArr[0] != null) {
                if (PERCENT_X.equals(strArr[0])) {
                    fArr[0] = f2 / width;
                    fArr[1] = f3 / height;
                    return;
                }
                fArr[1] = f2 / width;
                fArr[0] = f3 / height;
                return;
            }
            strArr[0] = PERCENT_X;
            fArr[0] = f2 / width;
            strArr[1] = PERCENT_Y;
            fArr[1] = f3 / height;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, obj) == null) {
            switch (str.hashCode()) {
                case -1812823328:
                    if (str.equals("transitionEasing")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1127236479:
                    if (str.equals("percentWidth")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1017587252:
                    if (str.equals("percentHeight")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -827014263:
                    if (str.equals("drawPath")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -200259324:
                    if (str.equals("sizePercent")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 428090547:
                    if (str.equals(PERCENT_X)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 428090548:
                    if (str.equals(PERCENT_Y)) {
                        c2 = 6;
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
                    float f2 = toFloat(obj);
                    this.mPercentWidth = f2;
                    this.mPercentHeight = f2;
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

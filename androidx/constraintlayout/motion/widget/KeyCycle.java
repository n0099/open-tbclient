package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
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
import java.util.Iterator;
import org.apache.commons.lang3.CharUtils;
/* loaded from: classes.dex */
public class KeyCycle extends Key {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int KEY_TYPE = 4;
    public static final String NAME = "KeyCycle";
    public static final String TAG = "KeyCycle";
    public transient /* synthetic */ FieldHolder $fh;
    public float mAlpha;
    public int mCurveFit;
    public float mElevation;
    public float mProgress;
    public float mRotation;
    public float mRotationX;
    public float mRotationY;
    public float mScaleX;
    public float mScaleY;
    public String mTransitionEasing;
    public float mTransitionPathRotate;
    public float mTranslationX;
    public float mTranslationY;
    public float mTranslationZ;
    public float mWaveOffset;
    public float mWavePeriod;
    public int mWaveShape;
    public int mWaveVariesBy;

    /* loaded from: classes.dex */
    public static class Loader {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ANDROID_ALPHA = 9;
        public static final int ANDROID_ELEVATION = 10;
        public static final int ANDROID_ROTATION = 11;
        public static final int ANDROID_ROTATION_X = 12;
        public static final int ANDROID_ROTATION_Y = 13;
        public static final int ANDROID_SCALE_X = 15;
        public static final int ANDROID_SCALE_Y = 16;
        public static final int ANDROID_TRANSLATION_X = 17;
        public static final int ANDROID_TRANSLATION_Y = 18;
        public static final int ANDROID_TRANSLATION_Z = 19;
        public static final int CURVE_FIT = 4;
        public static final int FRAME_POSITION = 2;
        public static final int PROGRESS = 20;
        public static final int TARGET_ID = 1;
        public static final int TRANSITION_EASING = 3;
        public static final int TRANSITION_PATH_ROTATE = 14;
        public static final int WAVE_OFFSET = 7;
        public static final int WAVE_PERIOD = 6;
        public static final int WAVE_SHAPE = 5;
        public static final int WAVE_VARIES_BY = 8;
        public static SparseIntArray mAttrMap;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-317116501, "Landroidx/constraintlayout/motion/widget/KeyCycle$Loader;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-317116501, "Landroidx/constraintlayout/motion/widget/KeyCycle$Loader;");
                    return;
                }
            }
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyCycle_motionTarget, 1);
            mAttrMap.append(R.styleable.KeyCycle_framePosition, 2);
            mAttrMap.append(R.styleable.KeyCycle_transitionEasing, 3);
            mAttrMap.append(R.styleable.KeyCycle_curveFit, 4);
            mAttrMap.append(R.styleable.KeyCycle_waveShape, 5);
            mAttrMap.append(R.styleable.KeyCycle_wavePeriod, 6);
            mAttrMap.append(R.styleable.KeyCycle_waveOffset, 7);
            mAttrMap.append(R.styleable.KeyCycle_waveVariesBy, 8);
            mAttrMap.append(R.styleable.KeyCycle_android_alpha, 9);
            mAttrMap.append(R.styleable.KeyCycle_android_elevation, 10);
            mAttrMap.append(R.styleable.KeyCycle_android_rotation, 11);
            mAttrMap.append(R.styleable.KeyCycle_android_rotationX, 12);
            mAttrMap.append(R.styleable.KeyCycle_android_rotationY, 13);
            mAttrMap.append(R.styleable.KeyCycle_transitionPathRotate, 14);
            mAttrMap.append(R.styleable.KeyCycle_android_scaleX, 15);
            mAttrMap.append(R.styleable.KeyCycle_android_scaleY, 16);
            mAttrMap.append(R.styleable.KeyCycle_android_translationX, 17);
            mAttrMap.append(R.styleable.KeyCycle_android_translationY, 18);
            mAttrMap.append(R.styleable.KeyCycle_android_translationZ, 19);
            mAttrMap.append(R.styleable.KeyCycle_motionProgress, 20);
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

        public static void read(KeyCycle keyCycle, TypedArray typedArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, keyCycle, typedArray) == null) {
                int indexCount = typedArray.getIndexCount();
                for (int i2 = 0; i2 < indexCount; i2++) {
                    int index = typedArray.getIndex(i2);
                    switch (mAttrMap.get(index)) {
                        case 1:
                            if (MotionLayout.IS_IN_EDIT_MODE) {
                                int resourceId = typedArray.getResourceId(index, keyCycle.mTargetId);
                                keyCycle.mTargetId = resourceId;
                                if (resourceId == -1) {
                                    keyCycle.mTargetString = typedArray.getString(index);
                                    break;
                                } else {
                                    break;
                                }
                            } else if (typedArray.peekValue(index).type == 3) {
                                keyCycle.mTargetString = typedArray.getString(index);
                                break;
                            } else {
                                keyCycle.mTargetId = typedArray.getResourceId(index, keyCycle.mTargetId);
                                break;
                            }
                        case 2:
                            keyCycle.mFramePosition = typedArray.getInt(index, keyCycle.mFramePosition);
                            break;
                        case 3:
                            keyCycle.mTransitionEasing = typedArray.getString(index);
                            break;
                        case 4:
                            keyCycle.mCurveFit = typedArray.getInteger(index, keyCycle.mCurveFit);
                            break;
                        case 5:
                            keyCycle.mWaveShape = typedArray.getInt(index, keyCycle.mWaveShape);
                            break;
                        case 6:
                            keyCycle.mWavePeriod = typedArray.getFloat(index, keyCycle.mWavePeriod);
                            break;
                        case 7:
                            if (typedArray.peekValue(index).type == 5) {
                                keyCycle.mWaveOffset = typedArray.getDimension(index, keyCycle.mWaveOffset);
                                break;
                            } else {
                                keyCycle.mWaveOffset = typedArray.getFloat(index, keyCycle.mWaveOffset);
                                break;
                            }
                        case 8:
                            keyCycle.mWaveVariesBy = typedArray.getInt(index, keyCycle.mWaveVariesBy);
                            break;
                        case 9:
                            keyCycle.mAlpha = typedArray.getFloat(index, keyCycle.mAlpha);
                            break;
                        case 10:
                            keyCycle.mElevation = typedArray.getDimension(index, keyCycle.mElevation);
                            break;
                        case 11:
                            keyCycle.mRotation = typedArray.getFloat(index, keyCycle.mRotation);
                            break;
                        case 12:
                            keyCycle.mRotationX = typedArray.getFloat(index, keyCycle.mRotationX);
                            break;
                        case 13:
                            keyCycle.mRotationY = typedArray.getFloat(index, keyCycle.mRotationY);
                            break;
                        case 14:
                            keyCycle.mTransitionPathRotate = typedArray.getFloat(index, keyCycle.mTransitionPathRotate);
                            break;
                        case 15:
                            keyCycle.mScaleX = typedArray.getFloat(index, keyCycle.mScaleX);
                            break;
                        case 16:
                            keyCycle.mScaleY = typedArray.getFloat(index, keyCycle.mScaleY);
                            break;
                        case 17:
                            keyCycle.mTranslationX = typedArray.getDimension(index, keyCycle.mTranslationX);
                            break;
                        case 18:
                            keyCycle.mTranslationY = typedArray.getDimension(index, keyCycle.mTranslationY);
                            break;
                        case 19:
                            if (Build.VERSION.SDK_INT >= 21) {
                                keyCycle.mTranslationZ = typedArray.getDimension(index, keyCycle.mTranslationZ);
                                break;
                            } else {
                                break;
                            }
                        case 20:
                            keyCycle.mProgress = typedArray.getFloat(index, keyCycle.mProgress);
                            break;
                        default:
                            String str = "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index);
                            break;
                    }
                }
            }
        }
    }

    public KeyCycle() {
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
        this.mCurveFit = 0;
        this.mWaveShape = -1;
        this.mWavePeriod = Float.NaN;
        this.mWaveOffset = 0.0f;
        this.mProgress = Float.NaN;
        this.mWaveVariesBy = -1;
        this.mAlpha = Float.NaN;
        this.mElevation = Float.NaN;
        this.mRotation = Float.NaN;
        this.mTransitionPathRotate = Float.NaN;
        this.mRotationX = Float.NaN;
        this.mRotationY = Float.NaN;
        this.mScaleX = Float.NaN;
        this.mScaleY = Float.NaN;
        this.mTranslationX = Float.NaN;
        this.mTranslationY = Float.NaN;
        this.mTranslationZ = Float.NaN;
        this.mType = 4;
        this.mCustomConstraints = new HashMap<>();
    }

    public void addCycleValues(HashMap<String, KeyCycleOscillator> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
            for (String str : hashMap.keySet()) {
                if (str.startsWith(Key.CUSTOM)) {
                    ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(str.substring(7));
                    if (constraintAttribute != null && constraintAttribute.getType() == ConstraintAttribute.AttributeType.FLOAT_TYPE) {
                        hashMap.get(str).setPoint(this.mFramePosition, this.mWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, constraintAttribute.getValueToInterpolate(), constraintAttribute);
                    }
                } else {
                    float value = getValue(str);
                    if (!Float.isNaN(value)) {
                        hashMap.get(str).setPoint(this.mFramePosition, this.mWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, value);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
            Debug.logStack("KeyCycle", "add " + hashMap.size() + " values", 2);
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
                            c2 = '\b';
                            break;
                        }
                        break;
                    case -1225497656:
                        if (str.equals(Key.TRANSLATION_Y)) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case -1225497655:
                        if (str.equals(Key.TRANSLATION_Z)) {
                            c2 = '\n';
                            break;
                        }
                        break;
                    case -1001078227:
                        if (str.equals("progress")) {
                            c2 = '\f';
                            break;
                        }
                        break;
                    case -908189618:
                        if (str.equals(Key.SCALE_X)) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case -908189617:
                        if (str.equals(Key.SCALE_Y)) {
                            c2 = 7;
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
                            c2 = 5;
                            break;
                        }
                        break;
                    case 92909918:
                        if (str.equals(Key.ALPHA)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 156108012:
                        if (str.equals(Key.WAVE_OFFSET)) {
                            c2 = 11;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        splineSet.setPoint(this.mFramePosition, this.mAlpha);
                        break;
                    case 1:
                        splineSet.setPoint(this.mFramePosition, this.mElevation);
                        break;
                    case 2:
                        splineSet.setPoint(this.mFramePosition, this.mRotation);
                        break;
                    case 3:
                        splineSet.setPoint(this.mFramePosition, this.mRotationX);
                        break;
                    case 4:
                        splineSet.setPoint(this.mFramePosition, this.mRotationY);
                        break;
                    case 5:
                        splineSet.setPoint(this.mFramePosition, this.mTransitionPathRotate);
                        break;
                    case 6:
                        splineSet.setPoint(this.mFramePosition, this.mScaleX);
                        break;
                    case 7:
                        splineSet.setPoint(this.mFramePosition, this.mScaleY);
                        break;
                    case '\b':
                        splineSet.setPoint(this.mFramePosition, this.mTranslationX);
                        break;
                    case '\t':
                        splineSet.setPoint(this.mFramePosition, this.mTranslationY);
                        break;
                    case '\n':
                        splineSet.setPoint(this.mFramePosition, this.mTranslationZ);
                        break;
                    case 11:
                        splineSet.setPoint(this.mFramePosition, this.mWaveOffset);
                        break;
                    case '\f':
                        splineSet.setPoint(this.mFramePosition, this.mProgress);
                        break;
                    default:
                        String str2 = "WARNING KeyCycle UNKNOWN  " + str;
                        break;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashSet) == null) {
            if (!Float.isNaN(this.mAlpha)) {
                hashSet.add(Key.ALPHA);
            }
            if (!Float.isNaN(this.mElevation)) {
                hashSet.add(Key.ELEVATION);
            }
            if (!Float.isNaN(this.mRotation)) {
                hashSet.add(Key.ROTATION);
            }
            if (!Float.isNaN(this.mRotationX)) {
                hashSet.add(Key.ROTATION_X);
            }
            if (!Float.isNaN(this.mRotationY)) {
                hashSet.add(Key.ROTATION_Y);
            }
            if (!Float.isNaN(this.mScaleX)) {
                hashSet.add(Key.SCALE_X);
            }
            if (!Float.isNaN(this.mScaleY)) {
                hashSet.add(Key.SCALE_Y);
            }
            if (!Float.isNaN(this.mTransitionPathRotate)) {
                hashSet.add(Key.TRANSITION_PATH_ROTATE);
            }
            if (!Float.isNaN(this.mTranslationX)) {
                hashSet.add(Key.TRANSLATION_X);
            }
            if (!Float.isNaN(this.mTranslationY)) {
                hashSet.add(Key.TRANSLATION_Y);
            }
            if (!Float.isNaN(this.mTranslationZ)) {
                hashSet.add(Key.TRANSLATION_Z);
            }
            if (this.mCustomConstraints.size() > 0) {
                Iterator<String> it = this.mCustomConstraints.keySet().iterator();
                while (it.hasNext()) {
                    hashSet.add("CUSTOM," + it.next());
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public float getValue(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
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
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1225497656:
                    if (str.equals(Key.TRANSLATION_Y)) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1225497655:
                    if (str.equals(Key.TRANSLATION_Z)) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        c2 = '\f';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -908189618:
                    if (str.equals(Key.SCALE_X)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -908189617:
                    if (str.equals(Key.SCALE_Y)) {
                        c2 = 7;
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
                        c2 = 5;
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
                        c2 = 11;
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
                    return this.mAlpha;
                case 1:
                    return this.mElevation;
                case 2:
                    return this.mRotation;
                case 3:
                    return this.mRotationX;
                case 4:
                    return this.mRotationY;
                case 5:
                    return this.mTransitionPathRotate;
                case 6:
                    return this.mScaleX;
                case 7:
                    return this.mScaleY;
                case '\b':
                    return this.mTranslationX;
                case '\t':
                    return this.mTranslationY;
                case '\n':
                    return this.mTranslationZ;
                case 11:
                    return this.mWaveOffset;
                case '\f':
                    return this.mProgress;
                default:
                    String str2 = "WARNING! KeyCycle UNKNOWN  " + str;
                    return Float.NaN;
            }
        }
        return invokeL.floatValue;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, attributeSet) == null) {
            Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyCycle));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, obj) == null) {
            switch (str.hashCode()) {
                case -1812823328:
                    if (str.equals("transitionEasing")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1249320806:
                    if (str.equals(Key.ROTATION_X)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1249320805:
                    if (str.equals(Key.ROTATION_Y)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1225497657:
                    if (str.equals(Key.TRANSLATION_X)) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1225497656:
                    if (str.equals(Key.TRANSLATION_Y)) {
                        c2 = '\f';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -908189618:
                    if (str.equals(Key.SCALE_X)) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -908189617:
                    if (str.equals(Key.SCALE_Y)) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -40300674:
                    if (str.equals(Key.ROTATION)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -4379043:
                    if (str.equals(Key.ELEVATION)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 37232917:
                    if (str.equals(Key.TRANSITION_PATH_ROTATE)) {
                        c2 = '\n';
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
                        c2 = 15;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 184161818:
                    if (str.equals(Key.WAVE_PERIOD)) {
                        c2 = 14;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 579057826:
                    if (str.equals("curveFit")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1317633238:
                    if (str.equals("mTranslationZ")) {
                        c2 = CharUtils.CR;
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
                    this.mAlpha = toFloat(obj);
                    return;
                case 1:
                    this.mCurveFit = toInt(obj);
                    return;
                case 2:
                    this.mElevation = toFloat(obj);
                    return;
                case 3:
                    this.mProgress = toFloat(obj);
                    return;
                case 4:
                    this.mRotation = toFloat(obj);
                    return;
                case 5:
                    this.mRotationX = toFloat(obj);
                    return;
                case 6:
                    this.mRotationY = toFloat(obj);
                    return;
                case 7:
                    this.mScaleX = toFloat(obj);
                    return;
                case '\b':
                    this.mScaleY = toFloat(obj);
                    return;
                case '\t':
                    this.mTransitionEasing = obj.toString();
                    return;
                case '\n':
                    this.mTransitionPathRotate = toFloat(obj);
                    return;
                case 11:
                    this.mTranslationX = toFloat(obj);
                    return;
                case '\f':
                    this.mTranslationY = toFloat(obj);
                    return;
                case '\r':
                    this.mTranslationZ = toFloat(obj);
                    return;
                case 14:
                    this.mWavePeriod = toFloat(obj);
                    return;
                case 15:
                    this.mWaveOffset = toFloat(obj);
                    return;
                default:
                    return;
            }
        }
    }
}

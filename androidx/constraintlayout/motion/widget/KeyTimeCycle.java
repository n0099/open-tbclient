package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;
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
/* loaded from: classes.dex */
public class KeyTimeCycle extends Key {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int KEY_TYPE = 3;
    public static final String NAME = "KeyTimeCycle";
    public static final String TAG = "KeyTimeCycle";
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

    /* loaded from: classes.dex */
    public static class Loader {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ANDROID_ALPHA = 1;
        public static final int ANDROID_ELEVATION = 2;
        public static final int ANDROID_ROTATION = 4;
        public static final int ANDROID_ROTATION_X = 5;
        public static final int ANDROID_ROTATION_Y = 6;
        public static final int ANDROID_SCALE_X = 7;
        public static final int ANDROID_SCALE_Y = 14;
        public static final int ANDROID_TRANSLATION_X = 15;
        public static final int ANDROID_TRANSLATION_Y = 16;
        public static final int ANDROID_TRANSLATION_Z = 17;
        public static final int CURVE_FIT = 13;
        public static final int FRAME_POSITION = 12;
        public static final int PROGRESS = 18;
        public static final int TARGET_ID = 10;
        public static final int TRANSITION_EASING = 9;
        public static final int TRANSITION_PATH_ROTATE = 8;
        public static final int WAVE_OFFSET = 21;
        public static final int WAVE_PERIOD = 20;
        public static final int WAVE_SHAPE = 19;
        public static SparseIntArray mAttrMap;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2142656862, "Landroidx/constraintlayout/motion/widget/KeyTimeCycle$Loader;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2142656862, "Landroidx/constraintlayout/motion/widget/KeyTimeCycle$Loader;");
                    return;
                }
            }
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(0, 1);
            mAttrMap.append(9, 2);
            mAttrMap.append(5, 4);
            mAttrMap.append(6, 5);
            mAttrMap.append(7, 6);
            mAttrMap.append(3, 7);
            mAttrMap.append(15, 8);
            mAttrMap.append(14, 9);
            mAttrMap.append(13, 10);
            mAttrMap.append(11, 12);
            mAttrMap.append(10, 13);
            mAttrMap.append(4, 14);
            mAttrMap.append(1, 15);
            mAttrMap.append(2, 16);
            mAttrMap.append(8, 17);
            mAttrMap.append(12, 18);
            mAttrMap.append(18, 20);
            mAttrMap.append(17, 21);
            mAttrMap.append(19, 19);
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

        public static void read(KeyTimeCycle keyTimeCycle, TypedArray typedArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, keyTimeCycle, typedArray) == null) {
                int indexCount = typedArray.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = typedArray.getIndex(i);
                    switch (mAttrMap.get(index)) {
                        case 1:
                            keyTimeCycle.mAlpha = typedArray.getFloat(index, keyTimeCycle.mAlpha);
                            break;
                        case 2:
                            keyTimeCycle.mElevation = typedArray.getDimension(index, keyTimeCycle.mElevation);
                            break;
                        case 3:
                        case 11:
                        default:
                            Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index));
                            break;
                        case 4:
                            keyTimeCycle.mRotation = typedArray.getFloat(index, keyTimeCycle.mRotation);
                            break;
                        case 5:
                            keyTimeCycle.mRotationX = typedArray.getFloat(index, keyTimeCycle.mRotationX);
                            break;
                        case 6:
                            keyTimeCycle.mRotationY = typedArray.getFloat(index, keyTimeCycle.mRotationY);
                            break;
                        case 7:
                            keyTimeCycle.mScaleX = typedArray.getFloat(index, keyTimeCycle.mScaleX);
                            break;
                        case 8:
                            keyTimeCycle.mTransitionPathRotate = typedArray.getFloat(index, keyTimeCycle.mTransitionPathRotate);
                            break;
                        case 9:
                            keyTimeCycle.mTransitionEasing = typedArray.getString(index);
                            break;
                        case 10:
                            if (MotionLayout.IS_IN_EDIT_MODE) {
                                int resourceId = typedArray.getResourceId(index, keyTimeCycle.mTargetId);
                                keyTimeCycle.mTargetId = resourceId;
                                if (resourceId == -1) {
                                    keyTimeCycle.mTargetString = typedArray.getString(index);
                                    break;
                                } else {
                                    break;
                                }
                            } else if (typedArray.peekValue(index).type == 3) {
                                keyTimeCycle.mTargetString = typedArray.getString(index);
                                break;
                            } else {
                                keyTimeCycle.mTargetId = typedArray.getResourceId(index, keyTimeCycle.mTargetId);
                                break;
                            }
                        case 12:
                            keyTimeCycle.mFramePosition = typedArray.getInt(index, keyTimeCycle.mFramePosition);
                            break;
                        case 13:
                            keyTimeCycle.mCurveFit = typedArray.getInteger(index, keyTimeCycle.mCurveFit);
                            break;
                        case 14:
                            keyTimeCycle.mScaleY = typedArray.getFloat(index, keyTimeCycle.mScaleY);
                            break;
                        case 15:
                            keyTimeCycle.mTranslationX = typedArray.getDimension(index, keyTimeCycle.mTranslationX);
                            break;
                        case 16:
                            keyTimeCycle.mTranslationY = typedArray.getDimension(index, keyTimeCycle.mTranslationY);
                            break;
                        case 17:
                            if (Build.VERSION.SDK_INT >= 21) {
                                keyTimeCycle.mTranslationZ = typedArray.getDimension(index, keyTimeCycle.mTranslationZ);
                                break;
                            } else {
                                break;
                            }
                        case 18:
                            keyTimeCycle.mProgress = typedArray.getFloat(index, keyTimeCycle.mProgress);
                            break;
                        case 19:
                            keyTimeCycle.mWaveShape = typedArray.getInt(index, keyTimeCycle.mWaveShape);
                            break;
                        case 20:
                            keyTimeCycle.mWavePeriod = typedArray.getFloat(index, keyTimeCycle.mWavePeriod);
                            break;
                        case 21:
                            if (typedArray.peekValue(index).type == 5) {
                                keyTimeCycle.mWaveOffset = typedArray.getDimension(index, keyTimeCycle.mWaveOffset);
                                break;
                            } else {
                                keyTimeCycle.mWaveOffset = typedArray.getFloat(index, keyTimeCycle.mWaveOffset);
                                break;
                            }
                    }
                }
            }
        }
    }

    public KeyTimeCycle() {
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
        this.mCurveFit = -1;
        this.mAlpha = Float.NaN;
        this.mElevation = Float.NaN;
        this.mRotation = Float.NaN;
        this.mRotationX = Float.NaN;
        this.mRotationY = Float.NaN;
        this.mTransitionPathRotate = Float.NaN;
        this.mScaleX = Float.NaN;
        this.mScaleY = Float.NaN;
        this.mTranslationX = Float.NaN;
        this.mTranslationY = Float.NaN;
        this.mTranslationZ = Float.NaN;
        this.mProgress = Float.NaN;
        this.mWaveShape = 0;
        this.mWavePeriod = Float.NaN;
        this.mWaveOffset = 0.0f;
        this.mType = 3;
        this.mCustomConstraints = new HashMap<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0080, code lost:
        if (r1.equals(androidx.constraintlayout.motion.widget.Key.SCALE_Y) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addTimeValues(HashMap<String, TimeCycleSplineSet> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
            Iterator<String> it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                TimeCycleSplineSet timeCycleSplineSet = hashMap.get(next);
                char c = 7;
                if (next.startsWith("CUSTOM")) {
                    ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(next.substring(7));
                    if (constraintAttribute != null) {
                        ((TimeCycleSplineSet.CustomSet) timeCycleSplineSet).setPoint(this.mFramePosition, constraintAttribute, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                    }
                } else {
                    switch (next.hashCode()) {
                        case -1249320806:
                            if (next.equals(Key.ROTATION_X)) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1249320805:
                            if (next.equals(Key.ROTATION_Y)) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1225497657:
                            if (next.equals(Key.TRANSLATION_X)) {
                                c = '\b';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1225497656:
                            if (next.equals(Key.TRANSLATION_Y)) {
                                c = '\t';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1225497655:
                            if (next.equals(Key.TRANSLATION_Z)) {
                                c = '\n';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1001078227:
                            if (next.equals("progress")) {
                                c = 11;
                                break;
                            }
                            c = 65535;
                            break;
                        case -908189618:
                            if (next.equals(Key.SCALE_X)) {
                                c = 6;
                                break;
                            }
                            c = 65535;
                            break;
                        case -908189617:
                            break;
                        case -40300674:
                            if (next.equals(Key.ROTATION)) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case -4379043:
                            if (next.equals(Key.ELEVATION)) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 37232917:
                            if (next.equals(Key.TRANSITION_PATH_ROTATE)) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case 92909918:
                            if (next.equals(Key.ALPHA)) {
                                c = 0;
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
                            if (!Float.isNaN(this.mAlpha)) {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mAlpha, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            } else {
                                continue;
                            }
                        case 1:
                            if (!Float.isNaN(this.mElevation)) {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mElevation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            } else {
                                continue;
                            }
                        case 2:
                            if (!Float.isNaN(this.mRotation)) {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mRotation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            } else {
                                continue;
                            }
                        case 3:
                            if (!Float.isNaN(this.mRotationX)) {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mRotationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            } else {
                                continue;
                            }
                        case 4:
                            if (!Float.isNaN(this.mRotationY)) {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mRotationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            } else {
                                continue;
                            }
                        case 5:
                            if (!Float.isNaN(this.mTransitionPathRotate)) {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mTransitionPathRotate, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            } else {
                                continue;
                            }
                        case 6:
                            if (!Float.isNaN(this.mScaleX)) {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mScaleX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            } else {
                                continue;
                            }
                        case 7:
                            if (!Float.isNaN(this.mScaleY)) {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mScaleY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            } else {
                                continue;
                            }
                        case '\b':
                            if (!Float.isNaN(this.mTranslationX)) {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mTranslationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            } else {
                                continue;
                            }
                        case '\t':
                            if (!Float.isNaN(this.mTranslationY)) {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mTranslationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            } else {
                                continue;
                            }
                        case '\n':
                            if (!Float.isNaN(this.mTranslationZ)) {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mTranslationZ, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            } else {
                                continue;
                            }
                        case 11:
                            if (!Float.isNaN(this.mProgress)) {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mProgress, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            } else {
                                continue;
                            }
                        default:
                            Log.e("KeyTimeCycles", "UNKNOWN addValues \"" + next + "\"");
                            continue;
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
            throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
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
            if (!Float.isNaN(this.mTranslationX)) {
                hashSet.add(Key.TRANSLATION_X);
            }
            if (!Float.isNaN(this.mTranslationY)) {
                hashSet.add(Key.TRANSLATION_Y);
            }
            if (!Float.isNaN(this.mTranslationZ)) {
                hashSet.add(Key.TRANSLATION_Z);
            }
            if (!Float.isNaN(this.mTransitionPathRotate)) {
                hashSet.add(Key.TRANSITION_PATH_ROTATE);
            }
            if (!Float.isNaN(this.mScaleX)) {
                hashSet.add(Key.SCALE_X);
            }
            if (!Float.isNaN(this.mScaleY)) {
                hashSet.add(Key.SCALE_Y);
            }
            if (!Float.isNaN(this.mProgress)) {
                hashSet.add("progress");
            }
            if (this.mCustomConstraints.size() > 0) {
                Iterator<String> it = this.mCustomConstraints.keySet().iterator();
                while (it.hasNext()) {
                    hashSet.add("CUSTOM," + it.next());
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, attributeSet) == null) {
            Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyTimeCycle));
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setInterpolation(HashMap<String, Integer> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, hashMap) == null) || this.mCurveFit == -1) {
            return;
        }
        if (!Float.isNaN(this.mAlpha)) {
            hashMap.put(Key.ALPHA, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mElevation)) {
            hashMap.put(Key.ELEVATION, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotation)) {
            hashMap.put(Key.ROTATION, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashMap.put(Key.ROTATION_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashMap.put(Key.ROTATION_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashMap.put(Key.TRANSLATION_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashMap.put(Key.TRANSLATION_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashMap.put(Key.TRANSLATION_Z, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashMap.put(Key.TRANSITION_PATH_ROTATE, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashMap.put(Key.SCALE_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashMap.put(Key.SCALE_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mProgress)) {
            hashMap.put("progress", Integer.valueOf(this.mCurveFit));
        }
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                hashMap.put("CUSTOM," + it.next(), Integer.valueOf(this.mCurveFit));
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, obj) == null) {
            switch (str.hashCode()) {
                case -1812823328:
                    if (str.equals("transitionEasing")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -1249320806:
                    if (str.equals(Key.ROTATION_X)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -1249320805:
                    if (str.equals(Key.ROTATION_Y)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -1225497657:
                    if (str.equals(Key.TRANSLATION_X)) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -1225497656:
                    if (str.equals(Key.TRANSLATION_Y)) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -908189618:
                    if (str.equals(Key.SCALE_X)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -908189617:
                    if (str.equals(Key.SCALE_Y)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -40300674:
                    if (str.equals(Key.ROTATION)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -4379043:
                    if (str.equals(Key.ELEVATION)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 37232917:
                    if (str.equals(Key.TRANSITION_PATH_ROTATE)) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 92909918:
                    if (str.equals(Key.ALPHA)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 579057826:
                    if (str.equals("curveFit")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1317633238:
                    if (str.equals("mTranslationZ")) {
                        c = '\r';
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
                default:
                    return;
            }
        }
    }
}

package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R$styleable;
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
public class KeyAttributes extends Key {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int KEY_TYPE = 1;
    public static final String NAME = "KeyAttribute";
    public static final String TAG = "KeyAttribute";
    public transient /* synthetic */ FieldHolder $fh;
    public float mAlpha;
    public int mCurveFit;
    public float mElevation;
    public float mPivotX;
    public float mPivotY;
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
    public boolean mVisibility;

    /* loaded from: classes.dex */
    public static class Loader {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ANDROID_ALPHA = 1;
        public static final int ANDROID_ELEVATION = 2;
        public static final int ANDROID_PIVOT_X = 19;
        public static final int ANDROID_PIVOT_Y = 20;
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
        public static SparseIntArray mAttrMap;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1079594566, "Landroidx/constraintlayout/motion/widget/KeyAttributes$Loader;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1079594566, "Landroidx/constraintlayout/motion/widget/KeyAttributes$Loader;");
                    return;
                }
            }
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyAttribute_android_alpha, 1);
            mAttrMap.append(R$styleable.KeyAttribute_android_elevation, 2);
            mAttrMap.append(R$styleable.KeyAttribute_android_rotation, 4);
            mAttrMap.append(R$styleable.KeyAttribute_android_rotationX, 5);
            mAttrMap.append(R$styleable.KeyAttribute_android_rotationY, 6);
            mAttrMap.append(R$styleable.KeyAttribute_android_transformPivotX, 19);
            mAttrMap.append(R$styleable.KeyAttribute_android_transformPivotY, 20);
            mAttrMap.append(R$styleable.KeyAttribute_android_scaleX, 7);
            mAttrMap.append(R$styleable.KeyAttribute_transitionPathRotate, 8);
            mAttrMap.append(R$styleable.KeyAttribute_transitionEasing, 9);
            mAttrMap.append(R$styleable.KeyAttribute_motionTarget, 10);
            mAttrMap.append(R$styleable.KeyAttribute_framePosition, 12);
            mAttrMap.append(R$styleable.KeyAttribute_curveFit, 13);
            mAttrMap.append(R$styleable.KeyAttribute_android_scaleY, 14);
            mAttrMap.append(R$styleable.KeyAttribute_android_translationX, 15);
            mAttrMap.append(R$styleable.KeyAttribute_android_translationY, 16);
            mAttrMap.append(R$styleable.KeyAttribute_android_translationZ, 17);
            mAttrMap.append(R$styleable.KeyAttribute_motionProgress, 18);
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

        public static void read(KeyAttributes keyAttributes, TypedArray typedArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, keyAttributes, typedArray) == null) {
                int indexCount = typedArray.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = typedArray.getIndex(i);
                    switch (mAttrMap.get(index)) {
                        case 1:
                            keyAttributes.mAlpha = typedArray.getFloat(index, keyAttributes.mAlpha);
                            break;
                        case 2:
                            keyAttributes.mElevation = typedArray.getDimension(index, keyAttributes.mElevation);
                            break;
                        case 3:
                        case 11:
                        default:
                            Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index));
                            break;
                        case 4:
                            keyAttributes.mRotation = typedArray.getFloat(index, keyAttributes.mRotation);
                            break;
                        case 5:
                            keyAttributes.mRotationX = typedArray.getFloat(index, keyAttributes.mRotationX);
                            break;
                        case 6:
                            keyAttributes.mRotationY = typedArray.getFloat(index, keyAttributes.mRotationY);
                            break;
                        case 7:
                            keyAttributes.mScaleX = typedArray.getFloat(index, keyAttributes.mScaleX);
                            break;
                        case 8:
                            keyAttributes.mTransitionPathRotate = typedArray.getFloat(index, keyAttributes.mTransitionPathRotate);
                            break;
                        case 9:
                            keyAttributes.mTransitionEasing = typedArray.getString(index);
                            break;
                        case 10:
                            if (MotionLayout.IS_IN_EDIT_MODE) {
                                int resourceId = typedArray.getResourceId(index, keyAttributes.mTargetId);
                                keyAttributes.mTargetId = resourceId;
                                if (resourceId == -1) {
                                    keyAttributes.mTargetString = typedArray.getString(index);
                                    break;
                                } else {
                                    break;
                                }
                            } else if (typedArray.peekValue(index).type == 3) {
                                keyAttributes.mTargetString = typedArray.getString(index);
                                break;
                            } else {
                                keyAttributes.mTargetId = typedArray.getResourceId(index, keyAttributes.mTargetId);
                                break;
                            }
                        case 12:
                            keyAttributes.mFramePosition = typedArray.getInt(index, keyAttributes.mFramePosition);
                            break;
                        case 13:
                            keyAttributes.mCurveFit = typedArray.getInteger(index, keyAttributes.mCurveFit);
                            break;
                        case 14:
                            keyAttributes.mScaleY = typedArray.getFloat(index, keyAttributes.mScaleY);
                            break;
                        case 15:
                            keyAttributes.mTranslationX = typedArray.getDimension(index, keyAttributes.mTranslationX);
                            break;
                        case 16:
                            keyAttributes.mTranslationY = typedArray.getDimension(index, keyAttributes.mTranslationY);
                            break;
                        case 17:
                            if (Build.VERSION.SDK_INT >= 21) {
                                keyAttributes.mTranslationZ = typedArray.getDimension(index, keyAttributes.mTranslationZ);
                                break;
                            } else {
                                break;
                            }
                        case 18:
                            keyAttributes.mProgress = typedArray.getFloat(index, keyAttributes.mProgress);
                            break;
                        case 19:
                            keyAttributes.mPivotX = typedArray.getDimension(index, keyAttributes.mPivotX);
                            break;
                        case 20:
                            keyAttributes.mPivotY = typedArray.getDimension(index, keyAttributes.mPivotY);
                            break;
                    }
                }
            }
        }
    }

    public KeyAttributes() {
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
        this.mVisibility = false;
        this.mAlpha = Float.NaN;
        this.mElevation = Float.NaN;
        this.mRotation = Float.NaN;
        this.mRotationX = Float.NaN;
        this.mRotationY = Float.NaN;
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        this.mTransitionPathRotate = Float.NaN;
        this.mScaleX = Float.NaN;
        this.mScaleY = Float.NaN;
        this.mTranslationX = Float.NaN;
        this.mTranslationY = Float.NaN;
        this.mTranslationZ = Float.NaN;
        this.mProgress = Float.NaN;
        this.mType = 1;
        this.mCustomConstraints = new HashMap<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0058, code lost:
        if (r1.equals(androidx.constraintlayout.motion.widget.Key.TRANSITION_PATH_ROTATE) != false) goto L14;
     */
    @Override // androidx.constraintlayout.motion.widget.Key
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addValues(HashMap<String, SplineSet> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
            Iterator<String> it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                SplineSet splineSet = hashMap.get(next);
                char c = 7;
                if (next.startsWith("CUSTOM")) {
                    ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(next.substring(7));
                    if (constraintAttribute != null) {
                        ((SplineSet.CustomSet) splineSet).setPoint(this.mFramePosition, constraintAttribute);
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
                                c = '\n';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1225497656:
                            if (next.equals(Key.TRANSLATION_Y)) {
                                c = 11;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1225497655:
                            if (next.equals(Key.TRANSLATION_Z)) {
                                c = '\f';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1001078227:
                            if (next.equals("progress")) {
                                c = '\r';
                                break;
                            }
                            c = 65535;
                            break;
                        case -908189618:
                            if (next.equals(Key.SCALE_X)) {
                                c = '\b';
                                break;
                            }
                            c = 65535;
                            break;
                        case -908189617:
                            if (next.equals(Key.SCALE_Y)) {
                                c = '\t';
                                break;
                            }
                            c = 65535;
                            break;
                        case -760884510:
                            if (next.equals(Key.PIVOT_X)) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case -760884509:
                            if (next.equals(Key.PIVOT_Y)) {
                                c = 6;
                                break;
                            }
                            c = 65535;
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
                                splineSet.setPoint(this.mFramePosition, this.mAlpha);
                                break;
                            } else {
                                continue;
                            }
                        case 1:
                            if (!Float.isNaN(this.mElevation)) {
                                splineSet.setPoint(this.mFramePosition, this.mElevation);
                                break;
                            } else {
                                continue;
                            }
                        case 2:
                            if (!Float.isNaN(this.mRotation)) {
                                splineSet.setPoint(this.mFramePosition, this.mRotation);
                                break;
                            } else {
                                continue;
                            }
                        case 3:
                            if (!Float.isNaN(this.mRotationX)) {
                                splineSet.setPoint(this.mFramePosition, this.mRotationX);
                                break;
                            } else {
                                continue;
                            }
                        case 4:
                            if (!Float.isNaN(this.mRotationY)) {
                                splineSet.setPoint(this.mFramePosition, this.mRotationY);
                                break;
                            } else {
                                continue;
                            }
                        case 5:
                            if (!Float.isNaN(this.mRotationX)) {
                                splineSet.setPoint(this.mFramePosition, this.mPivotX);
                                break;
                            } else {
                                continue;
                            }
                        case 6:
                            if (!Float.isNaN(this.mRotationY)) {
                                splineSet.setPoint(this.mFramePosition, this.mPivotY);
                                break;
                            } else {
                                continue;
                            }
                        case 7:
                            if (!Float.isNaN(this.mTransitionPathRotate)) {
                                splineSet.setPoint(this.mFramePosition, this.mTransitionPathRotate);
                                break;
                            } else {
                                continue;
                            }
                        case '\b':
                            if (!Float.isNaN(this.mScaleX)) {
                                splineSet.setPoint(this.mFramePosition, this.mScaleX);
                                break;
                            } else {
                                continue;
                            }
                        case '\t':
                            if (!Float.isNaN(this.mScaleY)) {
                                splineSet.setPoint(this.mFramePosition, this.mScaleY);
                                break;
                            } else {
                                continue;
                            }
                        case '\n':
                            if (!Float.isNaN(this.mTranslationX)) {
                                splineSet.setPoint(this.mFramePosition, this.mTranslationX);
                                break;
                            } else {
                                continue;
                            }
                        case 11:
                            if (!Float.isNaN(this.mTranslationY)) {
                                splineSet.setPoint(this.mFramePosition, this.mTranslationY);
                                break;
                            } else {
                                continue;
                            }
                        case '\f':
                            if (!Float.isNaN(this.mTranslationZ)) {
                                splineSet.setPoint(this.mFramePosition, this.mTranslationZ);
                                break;
                            } else {
                                continue;
                            }
                        case '\r':
                            if (!Float.isNaN(this.mProgress)) {
                                splineSet.setPoint(this.mFramePosition, this.mProgress);
                                break;
                            } else {
                                continue;
                            }
                        default:
                            Log.v("KeyAttributes", "UNKNOWN addValues \"" + next + "\"");
                            continue;
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashSet) == null) {
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
            if (!Float.isNaN(this.mPivotX)) {
                hashSet.add(Key.PIVOT_X);
            }
            if (!Float.isNaN(this.mPivotY)) {
                hashSet.add(Key.PIVOT_Y);
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

    public int getCurveFit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCurveFit : invokeV.intValue;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, attributeSet) == null) {
            Loader.read(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyAttribute));
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
        if (!Float.isNaN(this.mPivotX)) {
            hashMap.put(Key.PIVOT_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mPivotY)) {
            hashMap.put(Key.PIVOT_Y, Integer.valueOf(this.mCurveFit));
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
        if (!Float.isNaN(this.mScaleY)) {
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
                case -1913008125:
                    if (str.equals("motionProgress")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1812823328:
                    if (str.equals("transitionEasing")) {
                        c = 11;
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
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case -1225497656:
                    if (str.equals(Key.TRANSLATION_Y)) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case -987906986:
                    if (str.equals("pivotX")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -987906985:
                    if (str.equals("pivotY")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -908189618:
                    if (str.equals(Key.SCALE_X)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -908189617:
                    if (str.equals(Key.SCALE_Y)) {
                        c = '\n';
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
                        c = '\r';
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
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        c = '\f';
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
                    this.mPivotX = toFloat(obj);
                    return;
                case '\b':
                    this.mPivotY = toFloat(obj);
                    return;
                case '\t':
                    this.mScaleX = toFloat(obj);
                    return;
                case '\n':
                    this.mScaleY = toFloat(obj);
                    return;
                case 11:
                    this.mTransitionEasing = obj.toString();
                    return;
                case '\f':
                    this.mVisibility = toBoolean(obj);
                    return;
                case '\r':
                    this.mTransitionPathRotate = toFloat(obj);
                    return;
                case 14:
                    this.mTranslationX = toFloat(obj);
                    return;
                case 15:
                    this.mTranslationY = toFloat(obj);
                    return;
                case 16:
                    this.mTranslationZ = toFloat(obj);
                    return;
                default:
                    return;
            }
        }
    }
}

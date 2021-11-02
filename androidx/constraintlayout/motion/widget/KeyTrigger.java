package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes.dex */
public class KeyTrigger extends Key {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int KEY_TYPE = 5;
    public static final String NAME = "KeyTrigger";
    public static final String TAG = "KeyTrigger";
    public transient /* synthetic */ FieldHolder $fh;
    public RectF mCollisionRect;
    public String mCross;
    public int mCurveFit;
    public Method mFireCross;
    public boolean mFireCrossReset;
    public float mFireLastPos;
    public Method mFireNegativeCross;
    public boolean mFireNegativeReset;
    public Method mFirePositiveCross;
    public boolean mFirePositiveReset;
    public float mFireThreshold;
    public String mNegativeCross;
    public String mPositiveCross;
    public boolean mPostLayout;
    public RectF mTargetRect;
    public int mTriggerCollisionId;
    public View mTriggerCollisionView;
    public int mTriggerID;
    public int mTriggerReceiver;
    public float mTriggerSlack;

    /* loaded from: classes.dex */
    public static class Loader {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int COLLISION = 9;
        public static final int CROSS = 4;
        public static final int FRAME_POS = 8;
        public static final int NEGATIVE_CROSS = 1;
        public static final int POSITIVE_CROSS = 2;
        public static final int POST_LAYOUT = 10;
        public static final int TARGET_ID = 7;
        public static final int TRIGGER_ID = 6;
        public static final int TRIGGER_RECEIVER = 11;
        public static final int TRIGGER_SLACK = 5;
        public static SparseIntArray mAttrMap;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-974438851, "Landroidx/constraintlayout/motion/widget/KeyTrigger$Loader;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-974438851, "Landroidx/constraintlayout/motion/widget/KeyTrigger$Loader;");
                    return;
                }
            }
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTrigger_framePosition, 8);
            mAttrMap.append(R.styleable.KeyTrigger_onCross, 4);
            mAttrMap.append(R.styleable.KeyTrigger_onNegativeCross, 1);
            mAttrMap.append(R.styleable.KeyTrigger_onPositiveCross, 2);
            mAttrMap.append(R.styleable.KeyTrigger_motionTarget, 7);
            mAttrMap.append(R.styleable.KeyTrigger_triggerId, 6);
            mAttrMap.append(R.styleable.KeyTrigger_triggerSlack, 5);
            mAttrMap.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            mAttrMap.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            mAttrMap.append(R.styleable.KeyTrigger_triggerReceiver, 11);
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

        public static void read(KeyTrigger keyTrigger, TypedArray typedArray, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65538, null, keyTrigger, typedArray, context) == null) {
                int indexCount = typedArray.getIndexCount();
                for (int i2 = 0; i2 < indexCount; i2++) {
                    int index = typedArray.getIndex(i2);
                    switch (mAttrMap.get(index)) {
                        case 1:
                            keyTrigger.mNegativeCross = typedArray.getString(index);
                            continue;
                        case 2:
                            keyTrigger.mPositiveCross = typedArray.getString(index);
                            continue;
                        case 4:
                            keyTrigger.mCross = typedArray.getString(index);
                            continue;
                        case 5:
                            keyTrigger.mTriggerSlack = typedArray.getFloat(index, keyTrigger.mTriggerSlack);
                            continue;
                        case 6:
                            keyTrigger.mTriggerID = typedArray.getResourceId(index, keyTrigger.mTriggerID);
                            continue;
                        case 7:
                            if (MotionLayout.IS_IN_EDIT_MODE) {
                                int resourceId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                                keyTrigger.mTargetId = resourceId;
                                if (resourceId == -1) {
                                    keyTrigger.mTargetString = typedArray.getString(index);
                                } else {
                                    continue;
                                }
                            } else if (typedArray.peekValue(index).type == 3) {
                                keyTrigger.mTargetString = typedArray.getString(index);
                            } else {
                                keyTrigger.mTargetId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                            }
                        case 8:
                            int integer = typedArray.getInteger(index, keyTrigger.mFramePosition);
                            keyTrigger.mFramePosition = integer;
                            keyTrigger.mFireThreshold = (integer + 0.5f) / 100.0f;
                            continue;
                        case 9:
                            keyTrigger.mTriggerCollisionId = typedArray.getResourceId(index, keyTrigger.mTriggerCollisionId);
                            continue;
                        case 10:
                            keyTrigger.mPostLayout = typedArray.getBoolean(index, keyTrigger.mPostLayout);
                            continue;
                        case 11:
                            keyTrigger.mTriggerReceiver = typedArray.getResourceId(index, keyTrigger.mTriggerReceiver);
                            break;
                    }
                    String str = "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index);
                }
            }
        }
    }

    public KeyTrigger() {
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
        this.mCurveFit = -1;
        this.mCross = null;
        int i4 = Key.UNSET;
        this.mTriggerReceiver = i4;
        this.mNegativeCross = null;
        this.mPositiveCross = null;
        this.mTriggerID = i4;
        this.mTriggerCollisionId = i4;
        this.mTriggerCollisionView = null;
        this.mTriggerSlack = 0.1f;
        this.mFireCrossReset = true;
        this.mFireNegativeReset = true;
        this.mFirePositiveReset = true;
        this.mFireThreshold = Float.NaN;
        this.mPostLayout = false;
        this.mCollisionRect = new RectF();
        this.mTargetRect = new RectF();
        this.mType = 5;
        this.mCustomConstraints = new HashMap<>();
    }

    private void setUpRect(RectF rectF, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65549, this, rectF, view, z) == null) {
            rectF.top = view.getTop();
            rectF.bottom = view.getBottom();
            rectF.left = view.getLeft();
            rectF.right = view.getRight();
            if (z) {
                view.getMatrix().mapRect(rectF);
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void conditionallyFire(float f2, View view) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), view}) == null) {
            boolean z5 = true;
            if (this.mTriggerCollisionId != Key.UNSET) {
                if (this.mTriggerCollisionView == null) {
                    this.mTriggerCollisionView = ((ViewGroup) view.getParent()).findViewById(this.mTriggerCollisionId);
                }
                setUpRect(this.mCollisionRect, this.mTriggerCollisionView, this.mPostLayout);
                setUpRect(this.mTargetRect, view, this.mPostLayout);
                if (this.mCollisionRect.intersect(this.mTargetRect)) {
                    if (this.mFireCrossReset) {
                        this.mFireCrossReset = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.mFirePositiveReset) {
                        this.mFirePositiveReset = false;
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    this.mFireNegativeReset = true;
                    z5 = z4;
                    z3 = false;
                } else {
                    if (this.mFireCrossReset) {
                        z = false;
                    } else {
                        this.mFireCrossReset = true;
                        z = true;
                    }
                    if (this.mFireNegativeReset) {
                        this.mFireNegativeReset = false;
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    this.mFirePositiveReset = true;
                    z5 = false;
                }
            } else {
                if (this.mFireCrossReset) {
                    float f3 = this.mFireThreshold;
                    if ((f2 - f3) * (this.mFireLastPos - f3) < 0.0f) {
                        this.mFireCrossReset = false;
                        z = true;
                        if (!this.mFireNegativeReset) {
                            float f4 = this.mFireThreshold;
                            float f5 = f2 - f4;
                            if ((this.mFireLastPos - f4) * f5 < 0.0f && f5 < 0.0f) {
                                this.mFireNegativeReset = false;
                                z2 = true;
                                if (this.mFirePositiveReset) {
                                    float f6 = this.mFireThreshold;
                                    float f7 = f2 - f6;
                                    if ((this.mFireLastPos - f6) * f7 >= 0.0f || f7 <= 0.0f) {
                                        z5 = false;
                                    } else {
                                        this.mFirePositiveReset = false;
                                    }
                                    z3 = z2;
                                } else {
                                    if (Math.abs(f2 - this.mFireThreshold) > this.mTriggerSlack) {
                                        this.mFirePositiveReset = true;
                                    }
                                    z3 = z2;
                                    z5 = false;
                                }
                            }
                        } else if (Math.abs(f2 - this.mFireThreshold) > this.mTriggerSlack) {
                            this.mFireNegativeReset = true;
                        }
                        z2 = false;
                        if (this.mFirePositiveReset) {
                        }
                    }
                } else if (Math.abs(f2 - this.mFireThreshold) > this.mTriggerSlack) {
                    this.mFireCrossReset = true;
                }
                z = false;
                if (!this.mFireNegativeReset) {
                }
                z2 = false;
                if (this.mFirePositiveReset) {
                }
            }
            this.mFireLastPos = f2;
            if (z3 || z || z5) {
                ((MotionLayout) view.getParent()).fireTrigger(this.mTriggerID, z5, f2);
            }
            if (this.mTriggerReceiver != Key.UNSET) {
                view = ((MotionLayout) view.getParent()).findViewById(this.mTriggerReceiver);
            }
            if (z3 && this.mNegativeCross != null) {
                if (this.mFireNegativeCross == null) {
                    try {
                        this.mFireNegativeCross = view.getClass().getMethod(this.mNegativeCross, new Class[0]);
                    } catch (NoSuchMethodException unused) {
                        String str = "Could not find method \"" + this.mNegativeCross + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view);
                    }
                }
                try {
                    this.mFireNegativeCross.invoke(view, new Object[0]);
                } catch (Exception unused2) {
                    String str2 = "Exception in call \"" + this.mNegativeCross + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view);
                }
            }
            if (z5 && this.mPositiveCross != null) {
                if (this.mFirePositiveCross == null) {
                    try {
                        this.mFirePositiveCross = view.getClass().getMethod(this.mPositiveCross, new Class[0]);
                    } catch (NoSuchMethodException unused3) {
                        String str3 = "Could not find method \"" + this.mPositiveCross + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view);
                    }
                }
                try {
                    this.mFirePositiveCross.invoke(view, new Object[0]);
                } catch (Exception unused4) {
                    String str4 = "Exception in call \"" + this.mPositiveCross + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view);
                }
            }
            if (!z || this.mCross == null) {
                return;
            }
            if (this.mFireCross == null) {
                try {
                    this.mFireCross = view.getClass().getMethod(this.mCross, new Class[0]);
                } catch (NoSuchMethodException unused5) {
                    String str5 = "Could not find method \"" + this.mCross + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view);
                }
            }
            try {
                this.mFireCross.invoke(view, new Object[0]);
            } catch (Exception unused6) {
                String str6 = "Exception in call \"" + this.mCross + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view);
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashSet) == null) {
        }
    }

    public int getCurveFit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCurveFit : invokeV.intValue;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, attributeSet) == null) {
            Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyTrigger), context);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, obj) == null) {
        }
    }
}

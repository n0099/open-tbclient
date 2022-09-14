package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.view.InputDeviceCompat;
import androidx.core.widget.NestedScrollView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class TouchResponse {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int FLAG_DISABLE_POST_SCROLL = 1;
    public static final int FLAG_DISABLE_SCROLL = 2;
    public static final int SIDE_BOTTOM = 3;
    public static final int SIDE_END = 6;
    public static final int SIDE_LEFT = 1;
    public static final int SIDE_MIDDLE = 4;
    public static final int SIDE_RIGHT = 2;
    public static final int SIDE_START = 5;
    public static final int SIDE_TOP = 0;
    public static final String TAG = "TouchResponse";
    public static final float[][] TOUCH_DIRECTION;
    public static final int TOUCH_DOWN = 1;
    public static final int TOUCH_END = 5;
    public static final int TOUCH_LEFT = 2;
    public static final int TOUCH_RIGHT = 3;
    public static final float[][] TOUCH_SIDES;
    public static final int TOUCH_START = 4;
    public static final int TOUCH_UP = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] mAnchorDpDt;
    public float mDragScale;
    public boolean mDragStarted;
    public float mDragThreshold;
    public int mFlags;
    public float mLastTouchX;
    public float mLastTouchY;
    public int mLimitBoundsTo;
    public float mMaxAcceleration;
    public float mMaxVelocity;
    public final MotionLayout mMotionLayout;
    public boolean mMoveWhenScrollAtTop;
    public int mOnTouchUp;
    public int mTouchAnchorId;
    public int mTouchAnchorSide;
    public float mTouchAnchorX;
    public float mTouchAnchorY;
    public float mTouchDirectionX;
    public float mTouchDirectionY;
    public int mTouchRegionId;
    public int mTouchSide;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2117317307, "Landroidx/constraintlayout/motion/widget/TouchResponse;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2117317307, "Landroidx/constraintlayout/motion/widget/TouchResponse;");
                return;
            }
        }
        TOUCH_SIDES = new float[][]{new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
        TOUCH_DIRECTION = new float[][]{new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    }

    public TouchResponse(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, motionLayout, xmlPullParser};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTouchAnchorSide = 0;
        this.mTouchSide = 0;
        this.mOnTouchUp = 0;
        this.mTouchAnchorId = -1;
        this.mTouchRegionId = -1;
        this.mLimitBoundsTo = -1;
        this.mTouchAnchorY = 0.5f;
        this.mTouchAnchorX = 0.5f;
        this.mTouchDirectionX = 0.0f;
        this.mTouchDirectionY = 1.0f;
        this.mDragStarted = false;
        this.mAnchorDpDt = new float[2];
        this.mMaxVelocity = 4.0f;
        this.mMaxAcceleration = 1.2f;
        this.mMoveWhenScrollAtTop = true;
        this.mDragScale = 1.0f;
        this.mFlags = 0;
        this.mDragThreshold = 10.0f;
        this.mMotionLayout = motionLayout;
        fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
    }

    private void fill(TypedArray typedArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, typedArray) == null) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                if (index == 9) {
                    this.mTouchAnchorId = typedArray.getResourceId(index, this.mTouchAnchorId);
                } else if (index == 10) {
                    int i2 = typedArray.getInt(index, this.mTouchAnchorSide);
                    this.mTouchAnchorSide = i2;
                    float[][] fArr = TOUCH_SIDES;
                    this.mTouchAnchorX = fArr[i2][0];
                    this.mTouchAnchorY = fArr[i2][1];
                } else if (index == 0) {
                    int i3 = typedArray.getInt(index, this.mTouchSide);
                    this.mTouchSide = i3;
                    float[][] fArr2 = TOUCH_DIRECTION;
                    this.mTouchDirectionX = fArr2[i3][0];
                    this.mTouchDirectionY = fArr2[i3][1];
                } else if (index == 5) {
                    this.mMaxVelocity = typedArray.getFloat(index, this.mMaxVelocity);
                } else if (index == 4) {
                    this.mMaxAcceleration = typedArray.getFloat(index, this.mMaxAcceleration);
                } else if (index == 6) {
                    this.mMoveWhenScrollAtTop = typedArray.getBoolean(index, this.mMoveWhenScrollAtTop);
                } else if (index == 1) {
                    this.mDragScale = typedArray.getFloat(index, this.mDragScale);
                } else if (index == 2) {
                    this.mDragThreshold = typedArray.getFloat(index, this.mDragThreshold);
                } else if (index == 11) {
                    this.mTouchRegionId = typedArray.getResourceId(index, this.mTouchRegionId);
                } else if (index == 8) {
                    this.mOnTouchUp = typedArray.getInt(index, this.mOnTouchUp);
                } else if (index == 7) {
                    this.mFlags = typedArray.getInteger(index, 0);
                } else if (index == 3) {
                    this.mLimitBoundsTo = typedArray.getResourceId(index, 0);
                }
            }
        }
    }

    private void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OnSwipe);
            fill(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }
    }

    public float dot(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) ? (f * this.mTouchDirectionX) + (f2 * this.mTouchDirectionY) : invokeCommon.floatValue;
    }

    public int getAnchorId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mTouchAnchorId : invokeV.intValue;
    }

    public int getFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mFlags : invokeV.intValue;
    }

    public RectF getLimitBoundsTo(ViewGroup viewGroup, RectF rectF) {
        InterceptResult invokeLL;
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewGroup, rectF)) == null) {
            int i = this.mLimitBoundsTo;
            if (i == -1 || (findViewById = viewGroup.findViewById(i)) == null) {
                return null;
            }
            rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
            return rectF;
        }
        return (RectF) invokeLL.objValue;
    }

    public int getLimitBoundsToId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mLimitBoundsTo : invokeV.intValue;
    }

    public float getMaxAcceleration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mMaxAcceleration : invokeV.floatValue;
    }

    public float getMaxVelocity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mMaxVelocity : invokeV.floatValue;
    }

    public boolean getMoveWhenScrollAtTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mMoveWhenScrollAtTop : invokeV.booleanValue;
    }

    public float getProgressDirection(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, this.mMotionLayout.getProgress(), this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
            if (this.mTouchDirectionX != 0.0f) {
                float[] fArr = this.mAnchorDpDt;
                if (fArr[0] == 0.0f) {
                    fArr[0] = 1.0E-7f;
                }
                return (f * this.mTouchDirectionX) / this.mAnchorDpDt[0];
            }
            float[] fArr2 = this.mAnchorDpDt;
            if (fArr2[1] == 0.0f) {
                fArr2[1] = 1.0E-7f;
            }
            return (f2 * this.mTouchDirectionY) / this.mAnchorDpDt[1];
        }
        return invokeCommon.floatValue;
    }

    public RectF getTouchRegion(ViewGroup viewGroup, RectF rectF) {
        InterceptResult invokeLL;
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, viewGroup, rectF)) == null) {
            int i = this.mTouchRegionId;
            if (i == -1 || (findViewById = viewGroup.findViewById(i)) == null) {
                return null;
            }
            rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
            return rectF;
        }
        return (RectF) invokeLL.objValue;
    }

    public int getTouchRegionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mTouchRegionId : invokeV.intValue;
    }

    public void processTouchEvent(MotionEvent motionEvent, MotionLayout.MotionTracker motionTracker, int i, MotionScene motionScene) {
        float f;
        int i2;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048587, this, motionEvent, motionTracker, i, motionScene) == null) {
            motionTracker.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.mLastTouchX = motionEvent.getRawX();
                this.mLastTouchY = motionEvent.getRawY();
                this.mDragStarted = false;
            } else if (action == 1) {
                this.mDragStarted = false;
                motionTracker.computeCurrentVelocity(1000);
                float xVelocity = motionTracker.getXVelocity();
                float yVelocity = motionTracker.getYVelocity();
                float progress = this.mMotionLayout.getProgress();
                int i3 = this.mTouchAnchorId;
                if (i3 != -1) {
                    this.mMotionLayout.getAnchorDpDt(i3, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
                } else {
                    float min = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                    float[] fArr = this.mAnchorDpDt;
                    fArr[1] = this.mTouchDirectionY * min;
                    fArr[0] = min * this.mTouchDirectionX;
                }
                float f3 = this.mTouchDirectionX;
                float[] fArr2 = this.mAnchorDpDt;
                float f4 = fArr2[0];
                float f5 = fArr2[1];
                if (f3 != 0.0f) {
                    f = xVelocity / fArr2[0];
                } else {
                    f = yVelocity / fArr2[1];
                }
                float f6 = !Float.isNaN(f) ? (f / 3.0f) + progress : progress;
                if (f6 == 0.0f || f6 == 1.0f || (i2 = this.mOnTouchUp) == 3) {
                    if (0.0f >= f6 || 1.0f <= f6) {
                        this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
                        return;
                    }
                    return;
                }
                this.mMotionLayout.touchAnimateTo(i2, ((double) f6) < 0.5d ? 0.0f : 1.0f, f);
                if (0.0f >= progress || 1.0f <= progress) {
                    this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
                }
            } else if (action != 2) {
            } else {
                float rawY = motionEvent.getRawY() - this.mLastTouchY;
                float rawX = motionEvent.getRawX() - this.mLastTouchX;
                if (Math.abs((this.mTouchDirectionX * rawX) + (this.mTouchDirectionY * rawY)) > this.mDragThreshold || this.mDragStarted) {
                    float progress2 = this.mMotionLayout.getProgress();
                    if (!this.mDragStarted) {
                        this.mDragStarted = true;
                        this.mMotionLayout.setProgress(progress2);
                    }
                    int i4 = this.mTouchAnchorId;
                    if (i4 != -1) {
                        this.mMotionLayout.getAnchorDpDt(i4, progress2, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
                    } else {
                        float min2 = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                        float[] fArr3 = this.mAnchorDpDt;
                        fArr3[1] = this.mTouchDirectionY * min2;
                        fArr3[0] = min2 * this.mTouchDirectionX;
                    }
                    float f7 = this.mTouchDirectionX;
                    float[] fArr4 = this.mAnchorDpDt;
                    if (Math.abs(((f7 * fArr4[0]) + (this.mTouchDirectionY * fArr4[1])) * this.mDragScale) < 0.01d) {
                        float[] fArr5 = this.mAnchorDpDt;
                        fArr5[0] = 0.01f;
                        fArr5[1] = 0.01f;
                    }
                    if (this.mTouchDirectionX != 0.0f) {
                        f2 = rawX / this.mAnchorDpDt[0];
                    } else {
                        f2 = rawY / this.mAnchorDpDt[1];
                    }
                    float max = Math.max(Math.min(progress2 + f2, 1.0f), 0.0f);
                    if (max != this.mMotionLayout.getProgress()) {
                        this.mMotionLayout.setProgress(max);
                        motionTracker.computeCurrentVelocity(1000);
                        this.mMotionLayout.mLastVelocity = this.mTouchDirectionX != 0.0f ? motionTracker.getXVelocity() / this.mAnchorDpDt[0] : motionTracker.getYVelocity() / this.mAnchorDpDt[1];
                    } else {
                        this.mMotionLayout.mLastVelocity = 0.0f;
                    }
                    this.mLastTouchX = motionEvent.getRawX();
                    this.mLastTouchY = motionEvent.getRawY();
                }
            }
        }
    }

    public void scrollMove(float f, float f2) {
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            float progress = this.mMotionLayout.getProgress();
            if (!this.mDragStarted) {
                this.mDragStarted = true;
                this.mMotionLayout.setProgress(progress);
            }
            this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
            float f4 = this.mTouchDirectionX;
            float[] fArr = this.mAnchorDpDt;
            if (Math.abs((f4 * fArr[0]) + (this.mTouchDirectionY * fArr[1])) < 0.01d) {
                float[] fArr2 = this.mAnchorDpDt;
                fArr2[0] = 0.01f;
                fArr2[1] = 0.01f;
            }
            float f5 = this.mTouchDirectionX;
            if (f5 != 0.0f) {
                f3 = (f * f5) / this.mAnchorDpDt[0];
            } else {
                f3 = (f2 * this.mTouchDirectionY) / this.mAnchorDpDt[1];
            }
            float max = Math.max(Math.min(progress + f3, 1.0f), 0.0f);
            if (max != this.mMotionLayout.getProgress()) {
                this.mMotionLayout.setProgress(max);
            }
        }
    }

    public void scrollUp(float f, float f2) {
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.mDragStarted = false;
            float progress = this.mMotionLayout.getProgress();
            this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
            float f4 = this.mTouchDirectionX;
            float[] fArr = this.mAnchorDpDt;
            float f5 = fArr[0];
            float f6 = this.mTouchDirectionY;
            float f7 = fArr[1];
            if (f4 != 0.0f) {
                f3 = (f * f4) / fArr[0];
            } else {
                f3 = (f2 * f6) / fArr[1];
            }
            if (!Float.isNaN(f3)) {
                progress += f3 / 3.0f;
            }
            if (progress != 0.0f) {
                if ((this.mOnTouchUp != 3) && (progress != 1.0f)) {
                    this.mMotionLayout.touchAnimateTo(this.mOnTouchUp, ((double) progress) >= 0.5d ? 1.0f : 0.0f, f3);
                }
            }
        }
    }

    public void setAnchorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.mTouchAnchorId = i;
        }
    }

    public void setDown(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.mLastTouchX = f;
            this.mLastTouchY = f2;
        }
    }

    public void setMaxAcceleration(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f) == null) {
            this.mMaxAcceleration = f;
        }
    }

    public void setMaxVelocity(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f) == null) {
            this.mMaxVelocity = f;
        }
    }

    public void setRTL(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (z) {
                float[][] fArr = TOUCH_DIRECTION;
                fArr[4] = fArr[3];
                fArr[5] = fArr[2];
                float[][] fArr2 = TOUCH_SIDES;
                fArr2[5] = fArr2[2];
                fArr2[6] = fArr2[1];
            } else {
                float[][] fArr3 = TOUCH_DIRECTION;
                fArr3[4] = fArr3[2];
                fArr3[5] = fArr3[3];
                float[][] fArr4 = TOUCH_SIDES;
                fArr4[5] = fArr4[1];
                fArr4[6] = fArr4[2];
            }
            float[][] fArr5 = TOUCH_SIDES;
            int i = this.mTouchAnchorSide;
            this.mTouchAnchorX = fArr5[i][0];
            this.mTouchAnchorY = fArr5[i][1];
            float[][] fArr6 = TOUCH_DIRECTION;
            int i2 = this.mTouchSide;
            this.mTouchDirectionX = fArr6[i2][0];
            this.mTouchDirectionY = fArr6[i2][1];
        }
    }

    public void setTouchAnchorLocation(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.mTouchAnchorX = f;
            this.mTouchAnchorY = f2;
        }
    }

    public void setUpTouchEvent(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.mLastTouchX = f;
            this.mLastTouchY = f2;
            this.mDragStarted = false;
        }
    }

    public void setupTouch() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            int i = this.mTouchAnchorId;
            if (i != -1) {
                view2 = this.mMotionLayout.findViewById(i);
                if (view2 == null) {
                    Log.e(TAG, "cannot find TouchAnchorId @id/" + Debug.getName(this.mMotionLayout.getContext(), this.mTouchAnchorId));
                }
            } else {
                view2 = null;
            }
            if (view2 instanceof NestedScrollView) {
                NestedScrollView nestedScrollView = (NestedScrollView) view2;
                nestedScrollView.setOnTouchListener(new View.OnTouchListener(this) { // from class: androidx.constraintlayout.motion.widget.TouchResponse.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TouchResponse this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view3, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view3, motionEvent)) == null) {
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }
                });
                nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener(this) { // from class: androidx.constraintlayout.motion.widget.TouchResponse.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TouchResponse this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                    public void onScrollChange(NestedScrollView nestedScrollView2, int i2, int i3, int i4, int i5) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{nestedScrollView2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                        }
                    }
                });
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mTouchDirectionX + " , " + this.mTouchDirectionY;
        }
        return (String) invokeV.objValue;
    }
}

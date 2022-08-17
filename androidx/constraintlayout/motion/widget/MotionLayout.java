package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.NestedScrollingParent3;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    public static final float EPSILON = 1.0E-5f;
    public static boolean IS_IN_EDIT_MODE = false;
    public static final int MAX_KEY_FRAMES = 50;
    public static final String TAG = "MotionLayout";
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean firstDown;
    public float lastPos;
    public float lastY;
    public long mAnimationStartTime;
    public int mBeginState;
    public RectF mBoundsCheck;
    public int mCurrentState;
    public int mDebugPath;
    public DecelerateInterpolator mDecelerateLogic;
    public DesignTool mDesignTool;
    public DevModeDraw mDevModeDraw;
    public int mEndState;
    public int mEndWrapHeight;
    public int mEndWrapWidth;
    public HashMap<View, MotionController> mFrameArrayList;
    public int mFrames;
    public int mHeightMeasureMode;
    public boolean mInLayout;
    public boolean mInTransition;
    public boolean mIndirectTransition;
    public boolean mInteractionEnabled;
    public Interpolator mInterpolator;
    public boolean mIsAnimating;
    public boolean mKeepAnimating;
    public KeyCache mKeyCache;
    public long mLastDrawTime;
    public float mLastFps;
    public int mLastHeightMeasureSpec;
    public int mLastLayoutHeight;
    public int mLastLayoutWidth;
    public float mLastVelocity;
    public int mLastWidthMeasureSpec;
    public float mListenerPosition;
    public int mListenerState;
    public boolean mMeasureDuringTransition;
    public Model mModel;
    public boolean mNeedsFireTransitionCompleted;
    public int mOldHeight;
    public int mOldWidth;
    public ArrayList<MotionHelper> mOnHideHelpers;
    public ArrayList<MotionHelper> mOnShowHelpers;
    public float mPostInterpolationPosition;
    public View mRegionView;
    public MotionScene mScene;
    public float mScrollTargetDT;
    public float mScrollTargetDX;
    public float mScrollTargetDY;
    public long mScrollTargetTime;
    public int mStartWrapHeight;
    public int mStartWrapWidth;
    public StateCache mStateCache;
    public StopLogic mStopLogic;
    public boolean mTemporalInterpolator;
    public ArrayList<Integer> mTransitionCompleted;
    public float mTransitionDuration;
    public float mTransitionGoalPosition;
    public boolean mTransitionInstantly;
    public float mTransitionLastPosition;
    public long mTransitionLastTime;
    public TransitionListener mTransitionListener;
    public ArrayList<TransitionListener> mTransitionListeners;
    public float mTransitionPosition;
    public TransitionState mTransitionState;
    public boolean mUndergoingMotion;
    public int mWidthMeasureMode;

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-248966195, "Landroidx/constraintlayout/motion/widget/MotionLayout$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-248966195, "Landroidx/constraintlayout/motion/widget/MotionLayout$2;");
                    return;
                }
            }
            int[] iArr = new int[TransitionState.values().length];
            $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState = iArr;
            try {
                iArr[TransitionState.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.MOVING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class DecelerateInterpolator extends MotionInterpolator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float currentP;
        public float initalV;
        public float maxA;
        public final /* synthetic */ MotionLayout this$0;

        public DecelerateInterpolator(MotionLayout motionLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {motionLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = motionLayout;
            this.initalV = 0.0f;
            this.currentP = 0.0f;
        }

        public void config(float f, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.initalV = f;
                this.currentP = f2;
                this.maxA = f3;
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            InterceptResult invokeF;
            float f2;
            float f3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
                float f4 = this.initalV;
                if (f4 > 0.0f) {
                    float f5 = this.maxA;
                    if (f4 / f5 < f) {
                        f = f4 / f5;
                    }
                    MotionLayout motionLayout = this.this$0;
                    float f6 = this.initalV;
                    float f7 = this.maxA;
                    motionLayout.mLastVelocity = f6 - (f7 * f);
                    f2 = (f6 * f) - (((f7 * f) * f) / 2.0f);
                    f3 = this.currentP;
                } else {
                    float f8 = this.maxA;
                    if ((-f4) / f8 < f) {
                        f = (-f4) / f8;
                    }
                    MotionLayout motionLayout2 = this.this$0;
                    float f9 = this.initalV;
                    float f10 = this.maxA;
                    motionLayout2.mLastVelocity = (f10 * f) + f9;
                    f2 = (f9 * f) + (((f10 * f) * f) / 2.0f);
                    f3 = this.currentP;
                }
                return f2 + f3;
            }
            return invokeF.floatValue;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
        public float getVelocity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.mLastVelocity : invokeV.floatValue;
        }
    }

    /* loaded from: classes.dex */
    public class DevModeDraw {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DEBUG_PATH_TICKS_PER_MS = 16;
        public transient /* synthetic */ FieldHolder $fh;
        public final int DIAMOND_SIZE;
        public final int GRAPH_COLOR;
        public final int KEYFRAME_COLOR;
        public final int RED_COLOR;
        public final int SHADOW_COLOR;
        public Rect mBounds;
        public DashPathEffect mDashPathEffect;
        public Paint mFillPaint;
        public int mKeyFrameCount;
        public float[] mKeyFramePoints;
        public Paint mPaint;
        public Paint mPaintGraph;
        public Paint mPaintKeyframes;
        public Path mPath;
        public int[] mPathMode;
        public float[] mPoints;
        public boolean mPresentationMode;
        public float[] mRectangle;
        public int mShadowTranslate;
        public Paint mTextPaint;
        public final /* synthetic */ MotionLayout this$0;

        public DevModeDraw(MotionLayout motionLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {motionLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = motionLayout;
            this.RED_COLOR = -21965;
            this.KEYFRAME_COLOR = -2067046;
            this.GRAPH_COLOR = -13391360;
            this.SHADOW_COLOR = 1996488704;
            this.DIAMOND_SIZE = 10;
            this.mBounds = new Rect();
            this.mPresentationMode = false;
            this.mShadowTranslate = 1;
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setColor(-21965);
            this.mPaint.setStrokeWidth(2.0f);
            this.mPaint.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.mPaintKeyframes = paint2;
            paint2.setAntiAlias(true);
            this.mPaintKeyframes.setColor(-2067046);
            this.mPaintKeyframes.setStrokeWidth(2.0f);
            this.mPaintKeyframes.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint();
            this.mPaintGraph = paint3;
            paint3.setAntiAlias(true);
            this.mPaintGraph.setColor(-13391360);
            this.mPaintGraph.setStrokeWidth(2.0f);
            this.mPaintGraph.setStyle(Paint.Style.STROKE);
            Paint paint4 = new Paint();
            this.mTextPaint = paint4;
            paint4.setAntiAlias(true);
            this.mTextPaint.setColor(-13391360);
            this.mTextPaint.setTextSize(motionLayout.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.mRectangle = new float[8];
            Paint paint5 = new Paint();
            this.mFillPaint = paint5;
            paint5.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.mDashPathEffect = dashPathEffect;
            this.mPaintGraph.setPathEffect(dashPathEffect);
            this.mKeyFramePoints = new float[100];
            this.mPathMode = new int[50];
            if (this.mPresentationMode) {
                this.mPaint.setStrokeWidth(8.0f);
                this.mFillPaint.setStrokeWidth(8.0f);
                this.mPaintKeyframes.setStrokeWidth(8.0f);
                this.mShadowTranslate = 4;
            }
        }

        private void drawBasicPath(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, canvas) == null) {
                canvas.drawLines(this.mPoints, this.mPaint);
            }
        }

        private void drawPathAsConfigured(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, canvas) == null) {
                boolean z = false;
                boolean z2 = false;
                for (int i = 0; i < this.mKeyFrameCount; i++) {
                    if (this.mPathMode[i] == 1) {
                        z = true;
                    }
                    if (this.mPathMode[i] == 2) {
                        z2 = true;
                    }
                }
                if (z) {
                    drawPathRelative(canvas);
                }
                if (z2) {
                    drawPathCartesian(canvas);
                }
            }
        }

        private void drawPathCartesian(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, canvas) == null) {
                float[] fArr = this.mPoints;
                float f = fArr[0];
                float f2 = fArr[1];
                float f3 = fArr[fArr.length - 2];
                float f4 = fArr[fArr.length - 1];
                canvas.drawLine(Math.min(f, f3), Math.max(f2, f4), Math.max(f, f3), Math.max(f2, f4), this.mPaintGraph);
                canvas.drawLine(Math.min(f, f3), Math.min(f2, f4), Math.min(f, f3), Math.max(f2, f4), this.mPaintGraph);
            }
        }

        private void drawPathCartesianTicks(Canvas canvas, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{canvas, Float.valueOf(f), Float.valueOf(f2)}) == null) {
                float[] fArr = this.mPoints;
                float f3 = fArr[0];
                float f4 = fArr[1];
                float f5 = fArr[fArr.length - 2];
                float f6 = fArr[fArr.length - 1];
                float min = Math.min(f3, f5);
                float max = Math.max(f4, f6);
                float min2 = f - Math.min(f3, f5);
                float max2 = Math.max(f4, f6) - f2;
                String str = "" + (((int) (((min2 * 100.0f) / Math.abs(f5 - f3)) + 0.5d)) / 100.0f);
                getTextBounds(str, this.mTextPaint);
                canvas.drawText(str, ((min2 / 2.0f) - (this.mBounds.width() / 2)) + min, f2 - 20.0f, this.mTextPaint);
                canvas.drawLine(f, f2, Math.min(f3, f5), f2, this.mPaintGraph);
                String str2 = "" + (((int) (((max2 * 100.0f) / Math.abs(f6 - f4)) + 0.5d)) / 100.0f);
                getTextBounds(str2, this.mTextPaint);
                canvas.drawText(str2, f + 5.0f, max - ((max2 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
                canvas.drawLine(f, f2, f, Math.max(f4, f6), this.mPaintGraph);
            }
        }

        private void drawPathRelative(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65541, this, canvas) == null) {
                float[] fArr = this.mPoints;
                canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.mPaintGraph);
            }
        }

        private void drawPathRelativeTicks(Canvas canvas, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{canvas, Float.valueOf(f), Float.valueOf(f2)}) == null) {
                float[] fArr = this.mPoints;
                float f3 = fArr[0];
                float f4 = fArr[1];
                float f5 = fArr[fArr.length - 2];
                float f6 = fArr[fArr.length - 1];
                float hypot = (float) Math.hypot(f3 - f5, f4 - f6);
                float f7 = f5 - f3;
                float f8 = f6 - f4;
                float f9 = (((f - f3) * f7) + ((f2 - f4) * f8)) / (hypot * hypot);
                float f10 = f3 + (f7 * f9);
                float f11 = f4 + (f9 * f8);
                Path path = new Path();
                path.moveTo(f, f2);
                path.lineTo(f10, f11);
                float hypot2 = (float) Math.hypot(f10 - f, f11 - f2);
                String str = "" + (((int) ((hypot2 * 100.0f) / hypot)) / 100.0f);
                getTextBounds(str, this.mTextPaint);
                canvas.drawTextOnPath(str, path, (hypot2 / 2.0f) - (this.mBounds.width() / 2), -20.0f, this.mTextPaint);
                canvas.drawLine(f, f2, f10, f11, this.mPaintGraph);
            }
        }

        private void drawPathScreenTicks(Canvas canvas, float f, float f2, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{canvas, Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
                String str = "" + (((int) ((((f - (i / 2)) * 100.0f) / (this.this$0.getWidth() - i)) + 0.5d)) / 100.0f);
                getTextBounds(str, this.mTextPaint);
                canvas.drawText(str, ((f / 2.0f) - (this.mBounds.width() / 2)) + 0.0f, f2 - 20.0f, this.mTextPaint);
                canvas.drawLine(f, f2, Math.min(0.0f, 1.0f), f2, this.mPaintGraph);
                String str2 = "" + (((int) ((((f2 - (i2 / 2)) * 100.0f) / (this.this$0.getHeight() - i2)) + 0.5d)) / 100.0f);
                getTextBounds(str2, this.mTextPaint);
                canvas.drawText(str2, f + 5.0f, 0.0f - ((f2 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
                canvas.drawLine(f, f2, f, Math.max(0.0f, 1.0f), this.mPaintGraph);
            }
        }

        private void drawRectangle(Canvas canvas, MotionController motionController) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65544, this, canvas, motionController) == null) {
                this.mPath.reset();
                for (int i = 0; i <= 50; i++) {
                    motionController.buildRect(i / 50, this.mRectangle, 0);
                    Path path = this.mPath;
                    float[] fArr = this.mRectangle;
                    path.moveTo(fArr[0], fArr[1]);
                    Path path2 = this.mPath;
                    float[] fArr2 = this.mRectangle;
                    path2.lineTo(fArr2[2], fArr2[3]);
                    Path path3 = this.mPath;
                    float[] fArr3 = this.mRectangle;
                    path3.lineTo(fArr3[4], fArr3[5]);
                    Path path4 = this.mPath;
                    float[] fArr4 = this.mRectangle;
                    path4.lineTo(fArr4[6], fArr4[7]);
                    this.mPath.close();
                }
                this.mPaint.setColor(1140850688);
                canvas.translate(2.0f, 2.0f);
                canvas.drawPath(this.mPath, this.mPaint);
                canvas.translate(-2.0f, -2.0f);
                this.mPaint.setColor(-65536);
                canvas.drawPath(this.mPath, this.mPaint);
            }
        }

        private void drawTicks(Canvas canvas, int i, int i2, MotionController motionController) {
            int i3;
            int i4;
            float f;
            float f2;
            int i5;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{canvas, Integer.valueOf(i), Integer.valueOf(i2), motionController}) == null) {
                View view2 = motionController.mView;
                if (view2 != null) {
                    i3 = view2.getWidth();
                    i4 = motionController.mView.getHeight();
                } else {
                    i3 = 0;
                    i4 = 0;
                }
                for (int i6 = 1; i6 < i2 - 1; i6++) {
                    if (i != 4 || this.mPathMode[i6 - 1] != 0) {
                        float[] fArr = this.mKeyFramePoints;
                        int i7 = i6 * 2;
                        float f3 = fArr[i7];
                        float f4 = fArr[i7 + 1];
                        this.mPath.reset();
                        this.mPath.moveTo(f3, f4 + 10.0f);
                        this.mPath.lineTo(f3 + 10.0f, f4);
                        this.mPath.lineTo(f3, f4 - 10.0f);
                        this.mPath.lineTo(f3 - 10.0f, f4);
                        this.mPath.close();
                        int i8 = i6 - 1;
                        motionController.getKeyFrame(i8);
                        if (i == 4) {
                            int[] iArr = this.mPathMode;
                            if (iArr[i8] == 1) {
                                drawPathRelativeTicks(canvas, f3 - 0.0f, f4 - 0.0f);
                            } else if (iArr[i8] == 2) {
                                drawPathCartesianTicks(canvas, f3 - 0.0f, f4 - 0.0f);
                            } else if (iArr[i8] == 3) {
                                i5 = 3;
                                f = f4;
                                f2 = f3;
                                drawPathScreenTicks(canvas, f3 - 0.0f, f4 - 0.0f, i3, i4);
                                canvas.drawPath(this.mPath, this.mFillPaint);
                            }
                            f = f4;
                            f2 = f3;
                            i5 = 3;
                            canvas.drawPath(this.mPath, this.mFillPaint);
                        } else {
                            f = f4;
                            f2 = f3;
                            i5 = 3;
                        }
                        if (i == 2) {
                            drawPathRelativeTicks(canvas, f2 - 0.0f, f - 0.0f);
                        }
                        if (i == i5) {
                            drawPathCartesianTicks(canvas, f2 - 0.0f, f - 0.0f);
                        }
                        if (i == 6) {
                            drawPathScreenTicks(canvas, f2 - 0.0f, f - 0.0f, i3, i4);
                        }
                        canvas.drawPath(this.mPath, this.mFillPaint);
                    }
                }
                float[] fArr2 = this.mPoints;
                if (fArr2.length > 1) {
                    canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.mPaintKeyframes);
                    float[] fArr3 = this.mPoints;
                    canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.mPaintKeyframes);
                }
            }
        }

        private void drawTranslation(Canvas canvas, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{canvas, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                canvas.drawRect(f, f2, f3, f4, this.mPaintGraph);
                canvas.drawLine(f, f2, f3, f4, this.mPaintGraph);
            }
        }

        public void draw(Canvas canvas, HashMap<View, MotionController> hashMap, int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLII(1048576, this, canvas, hashMap, i, i2) == null) || hashMap == null || hashMap.size() == 0) {
                return;
            }
            canvas.save();
            if (!this.this$0.isInEditMode() && (i2 & 1) == 2) {
                String str = this.this$0.getContext().getResources().getResourceName(this.this$0.mEndState) + ":" + this.this$0.getProgress();
                canvas.drawText(str, 10.0f, this.this$0.getHeight() - 30, this.mTextPaint);
                canvas.drawText(str, 11.0f, this.this$0.getHeight() - 29, this.mPaint);
            }
            for (MotionController motionController : hashMap.values()) {
                int drawPath = motionController.getDrawPath();
                if (i2 > 0 && drawPath == 0) {
                    drawPath = 1;
                }
                if (drawPath != 0) {
                    this.mKeyFrameCount = motionController.buildKeyFrames(this.mKeyFramePoints, this.mPathMode);
                    if (drawPath >= 1) {
                        int i3 = i / 16;
                        float[] fArr = this.mPoints;
                        if (fArr == null || fArr.length != i3 * 2) {
                            this.mPoints = new float[i3 * 2];
                            this.mPath = new Path();
                        }
                        int i4 = this.mShadowTranslate;
                        canvas.translate(i4, i4);
                        this.mPaint.setColor(1996488704);
                        this.mFillPaint.setColor(1996488704);
                        this.mPaintKeyframes.setColor(1996488704);
                        this.mPaintGraph.setColor(1996488704);
                        motionController.buildPath(this.mPoints, i3);
                        drawAll(canvas, drawPath, this.mKeyFrameCount, motionController);
                        this.mPaint.setColor(-21965);
                        this.mPaintKeyframes.setColor(-2067046);
                        this.mFillPaint.setColor(-2067046);
                        this.mPaintGraph.setColor(-13391360);
                        int i5 = this.mShadowTranslate;
                        canvas.translate(-i5, -i5);
                        drawAll(canvas, drawPath, this.mKeyFrameCount, motionController);
                        if (drawPath == 5) {
                            drawRectangle(canvas, motionController);
                        }
                    }
                }
            }
            canvas.restore();
        }

        public void drawAll(Canvas canvas, int i, int i2, MotionController motionController) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, Integer.valueOf(i), Integer.valueOf(i2), motionController}) == null) {
                if (i == 4) {
                    drawPathAsConfigured(canvas);
                }
                if (i == 2) {
                    drawPathRelative(canvas);
                }
                if (i == 3) {
                    drawPathCartesian(canvas);
                }
                drawBasicPath(canvas);
                drawTicks(canvas, i, i2, motionController);
            }
        }

        public void getTextBounds(String str, Paint paint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, paint) == null) {
                paint.getTextBounds(str, 0, str.length(), this.mBounds);
            }
        }
    }

    /* loaded from: classes.dex */
    public class Model {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ConstraintSet mEnd;
        public int mEndId;
        public ConstraintWidgetContainer mLayoutEnd;
        public ConstraintWidgetContainer mLayoutStart;
        public ConstraintSet mStart;
        public int mStartId;
        public final /* synthetic */ MotionLayout this$0;

        public Model(MotionLayout motionLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {motionLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = motionLayout;
            this.mLayoutStart = new ConstraintWidgetContainer();
            this.mLayoutEnd = new ConstraintWidgetContainer();
            this.mStart = null;
            this.mEnd = null;
        }

        private void debugLayout(String str, ConstraintWidgetContainer constraintWidgetContainer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, this, str, constraintWidgetContainer) == null) {
                String str2 = str + " " + Debug.getName((View) constraintWidgetContainer.getCompanionWidget());
                Log.v(MotionLayout.TAG, str2 + "  ========= " + constraintWidgetContainer);
                int size = constraintWidgetContainer.getChildren().size();
                for (int i = 0; i < size; i++) {
                    String str3 = str2 + PreferencesUtil.LEFT_MOUNT + i + "] ";
                    ConstraintWidget constraintWidget = constraintWidgetContainer.getChildren().get(i);
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(constraintWidget.mTop.mTarget != null ? "T" : "_");
                    String sb2 = sb.toString();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(sb2);
                    sb3.append(constraintWidget.mBottom.mTarget != null ? "B" : "_");
                    String sb4 = sb3.toString();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(sb4);
                    sb5.append(constraintWidget.mLeft.mTarget != null ? "L" : "_");
                    String sb6 = sb5.toString();
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(sb6);
                    sb7.append(constraintWidget.mRight.mTarget != null ? "R" : "_");
                    String sb8 = sb7.toString();
                    View view2 = (View) constraintWidget.getCompanionWidget();
                    String name = Debug.getName(view2);
                    if (view2 instanceof TextView) {
                        name = name + "(" + ((Object) ((TextView) view2).getText()) + SmallTailInfo.EMOTION_SUFFIX;
                    }
                    Log.v(MotionLayout.TAG, str3 + GlideException.IndentedAppendable.INDENT + name + " " + constraintWidget + " " + sb8);
                }
                Log.v(MotionLayout.TAG, str2 + " done. ");
            }
        }

        private void debugLayoutParam(String str, ConstraintLayout.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, this, str, layoutParams) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(" ");
                sb.append(layoutParams.startToStart != -1 ? "SS" : "__");
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(sb2);
                sb3.append(layoutParams.startToEnd != -1 ? "|SE" : "|__");
                String sb4 = sb3.toString();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(sb4);
                sb5.append(layoutParams.endToStart != -1 ? "|ES" : "|__");
                String sb6 = sb5.toString();
                StringBuilder sb7 = new StringBuilder();
                sb7.append(sb6);
                sb7.append(layoutParams.endToEnd != -1 ? "|EE" : "|__");
                String sb8 = sb7.toString();
                StringBuilder sb9 = new StringBuilder();
                sb9.append(sb8);
                sb9.append(layoutParams.leftToLeft != -1 ? "|LL" : "|__");
                String sb10 = sb9.toString();
                StringBuilder sb11 = new StringBuilder();
                sb11.append(sb10);
                sb11.append(layoutParams.leftToRight != -1 ? "|LR" : "|__");
                String sb12 = sb11.toString();
                StringBuilder sb13 = new StringBuilder();
                sb13.append(sb12);
                sb13.append(layoutParams.rightToLeft != -1 ? "|RL" : "|__");
                String sb14 = sb13.toString();
                StringBuilder sb15 = new StringBuilder();
                sb15.append(sb14);
                sb15.append(layoutParams.rightToRight != -1 ? "|RR" : "|__");
                String sb16 = sb15.toString();
                StringBuilder sb17 = new StringBuilder();
                sb17.append(sb16);
                sb17.append(layoutParams.topToTop != -1 ? "|TT" : "|__");
                String sb18 = sb17.toString();
                StringBuilder sb19 = new StringBuilder();
                sb19.append(sb18);
                sb19.append(layoutParams.topToBottom != -1 ? "|TB" : "|__");
                String sb20 = sb19.toString();
                StringBuilder sb21 = new StringBuilder();
                sb21.append(sb20);
                sb21.append(layoutParams.bottomToTop != -1 ? "|BT" : "|__");
                String sb22 = sb21.toString();
                StringBuilder sb23 = new StringBuilder();
                sb23.append(sb22);
                sb23.append(layoutParams.bottomToBottom != -1 ? "|BB" : "|__");
                String sb24 = sb23.toString();
                Log.v(MotionLayout.TAG, str + sb24);
            }
        }

        private void debugWidget(String str, ConstraintWidget constraintWidget) {
            String str2;
            String str3;
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, this, str, constraintWidget) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(" ");
                String str5 = "__";
                if (constraintWidget.mTop.mTarget != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("T");
                    sb2.append(constraintWidget.mTop.mTarget.mType == ConstraintAnchor.Type.TOP ? "T" : "B");
                    str2 = sb2.toString();
                } else {
                    str2 = "__";
                }
                sb.append(str2);
                String sb3 = sb.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(sb3);
                if (constraintWidget.mBottom.mTarget != null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("B");
                    sb5.append(constraintWidget.mBottom.mTarget.mType == ConstraintAnchor.Type.TOP ? "T" : "B");
                    str3 = sb5.toString();
                } else {
                    str3 = "__";
                }
                sb4.append(str3);
                String sb6 = sb4.toString();
                StringBuilder sb7 = new StringBuilder();
                sb7.append(sb6);
                if (constraintWidget.mLeft.mTarget != null) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("L");
                    sb8.append(constraintWidget.mLeft.mTarget.mType == ConstraintAnchor.Type.LEFT ? "L" : "R");
                    str4 = sb8.toString();
                } else {
                    str4 = "__";
                }
                sb7.append(str4);
                String sb9 = sb7.toString();
                StringBuilder sb10 = new StringBuilder();
                sb10.append(sb9);
                if (constraintWidget.mRight.mTarget != null) {
                    StringBuilder sb11 = new StringBuilder();
                    sb11.append("R");
                    sb11.append(constraintWidget.mRight.mTarget.mType == ConstraintAnchor.Type.LEFT ? "L" : "R");
                    str5 = sb11.toString();
                }
                sb10.append(str5);
                String sb12 = sb10.toString();
                Log.v(MotionLayout.TAG, str + sb12 + " ---  " + constraintWidget);
            }
        }

        private void setupConstraintWidget(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, constraintWidgetContainer, constraintSet) == null) {
                SparseArray<ConstraintWidget> sparseArray = new SparseArray<>();
                Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
                sparseArray.clear();
                sparseArray.put(0, constraintWidgetContainer);
                sparseArray.put(this.this$0.getId(), constraintWidgetContainer);
                Iterator<ConstraintWidget> it = constraintWidgetContainer.getChildren().iterator();
                while (it.hasNext()) {
                    ConstraintWidget next = it.next();
                    sparseArray.put(((View) next.getCompanionWidget()).getId(), next);
                }
                Iterator<ConstraintWidget> it2 = constraintWidgetContainer.getChildren().iterator();
                while (it2.hasNext()) {
                    ConstraintWidget next2 = it2.next();
                    View view2 = (View) next2.getCompanionWidget();
                    constraintSet.applyToLayoutParams(view2.getId(), layoutParams);
                    next2.setWidth(constraintSet.getWidth(view2.getId()));
                    next2.setHeight(constraintSet.getHeight(view2.getId()));
                    if (view2 instanceof ConstraintHelper) {
                        constraintSet.applyToHelper((ConstraintHelper) view2, next2, layoutParams, sparseArray);
                        if (view2 instanceof Barrier) {
                            ((Barrier) view2).validateParams();
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        layoutParams.resolveLayoutDirection(this.this$0.getLayoutDirection());
                    } else {
                        layoutParams.resolveLayoutDirection(0);
                    }
                    this.this$0.applyConstraintsFromLayoutParams(false, view2, next2, layoutParams, sparseArray);
                    if (constraintSet.getVisibilityMode(view2.getId()) == 1) {
                        next2.setVisibility(view2.getVisibility());
                    } else {
                        next2.setVisibility(constraintSet.getVisibility(view2.getId()));
                    }
                }
                Iterator<ConstraintWidget> it3 = constraintWidgetContainer.getChildren().iterator();
                while (it3.hasNext()) {
                    ConstraintWidget next3 = it3.next();
                    if (next3 instanceof VirtualLayout) {
                        Helper helper = (Helper) next3;
                        ((ConstraintHelper) next3.getCompanionWidget()).updatePreLayout(constraintWidgetContainer, helper, sparseArray);
                        ((VirtualLayout) helper).captureWidgets();
                    }
                }
            }
        }

        public void build() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int childCount = this.this$0.getChildCount();
                this.this$0.mFrameArrayList.clear();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.this$0.getChildAt(i);
                    this.this$0.mFrameArrayList.put(childAt, new MotionController(childAt));
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt2 = this.this$0.getChildAt(i2);
                    MotionController motionController = this.this$0.mFrameArrayList.get(childAt2);
                    if (motionController != null) {
                        if (this.mStart != null) {
                            ConstraintWidget widget = getWidget(this.mLayoutStart, childAt2);
                            if (widget != null) {
                                motionController.setStartState(widget, this.mStart);
                            } else if (this.this$0.mDebugPath != 0) {
                                Log.e(MotionLayout.TAG, Debug.getLocation() + "no widget for  " + Debug.getName(childAt2) + " (" + childAt2.getClass().getName() + SmallTailInfo.EMOTION_SUFFIX);
                            }
                        }
                        if (this.mEnd != null) {
                            ConstraintWidget widget2 = getWidget(this.mLayoutEnd, childAt2);
                            if (widget2 != null) {
                                motionController.setEndState(widget2, this.mEnd);
                            } else if (this.this$0.mDebugPath != 0) {
                                Log.e(MotionLayout.TAG, Debug.getLocation() + "no widget for  " + Debug.getName(childAt2) + " (" + childAt2.getClass().getName() + SmallTailInfo.EMOTION_SUFFIX);
                            }
                        }
                    }
                }
            }
        }

        public void copy(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidgetContainer constraintWidgetContainer2) {
            ConstraintWidget constraintWidget;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, constraintWidgetContainer, constraintWidgetContainer2) == null) {
                ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
                HashMap<ConstraintWidget, ConstraintWidget> hashMap = new HashMap<>();
                hashMap.put(constraintWidgetContainer, constraintWidgetContainer2);
                constraintWidgetContainer2.getChildren().clear();
                constraintWidgetContainer2.copy(constraintWidgetContainer, hashMap);
                Iterator<ConstraintWidget> it = children.iterator();
                while (it.hasNext()) {
                    ConstraintWidget next = it.next();
                    if (next instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                        constraintWidget = new androidx.constraintlayout.solver.widgets.Barrier();
                    } else if (next instanceof Guideline) {
                        constraintWidget = new Guideline();
                    } else if (next instanceof Flow) {
                        constraintWidget = new Flow();
                    } else if (next instanceof Helper) {
                        constraintWidget = new HelperWidget();
                    } else {
                        constraintWidget = new ConstraintWidget();
                    }
                    constraintWidgetContainer2.add(constraintWidget);
                    hashMap.put(next, constraintWidget);
                }
                Iterator<ConstraintWidget> it2 = children.iterator();
                while (it2.hasNext()) {
                    ConstraintWidget next2 = it2.next();
                    hashMap.get(next2).copy(next2, hashMap);
                }
            }
        }

        public ConstraintWidget getWidget(ConstraintWidgetContainer constraintWidgetContainer, View view2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, constraintWidgetContainer, view2)) == null) {
                if (constraintWidgetContainer.getCompanionWidget() == view2) {
                    return constraintWidgetContainer;
                }
                ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
                int size = children.size();
                for (int i = 0; i < size; i++) {
                    ConstraintWidget constraintWidget = children.get(i);
                    if (constraintWidget.getCompanionWidget() == view2) {
                        return constraintWidget;
                    }
                }
                return null;
            }
            return (ConstraintWidget) invokeLL.objValue;
        }

        public void initFrom(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, constraintWidgetContainer, constraintSet, constraintSet2) == null) {
                this.mStart = constraintSet;
                this.mEnd = constraintSet2;
                this.mLayoutStart = new ConstraintWidgetContainer();
                this.mLayoutEnd = new ConstraintWidgetContainer();
                this.mLayoutStart.setMeasurer(this.this$0.mLayoutWidget.getMeasurer());
                this.mLayoutEnd.setMeasurer(this.this$0.mLayoutWidget.getMeasurer());
                this.mLayoutStart.removeAllChildren();
                this.mLayoutEnd.removeAllChildren();
                copy(this.this$0.mLayoutWidget, this.mLayoutStart);
                copy(this.this$0.mLayoutWidget, this.mLayoutEnd);
                if (this.this$0.mTransitionLastPosition > 0.5d) {
                    if (constraintSet != null) {
                        setupConstraintWidget(this.mLayoutStart, constraintSet);
                    }
                    setupConstraintWidget(this.mLayoutEnd, constraintSet2);
                } else {
                    setupConstraintWidget(this.mLayoutEnd, constraintSet2);
                    if (constraintSet != null) {
                        setupConstraintWidget(this.mLayoutStart, constraintSet);
                    }
                }
                this.mLayoutStart.setRtl(this.this$0.isRtl());
                this.mLayoutStart.updateHierarchy();
                this.mLayoutEnd.setRtl(this.this$0.isRtl());
                this.mLayoutEnd.updateHierarchy();
                ViewGroup.LayoutParams layoutParams = this.this$0.getLayoutParams();
                if (layoutParams != null) {
                    if (layoutParams.width == -2) {
                        this.mLayoutStart.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                        this.mLayoutEnd.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                    }
                    if (layoutParams.height == -2) {
                        this.mLayoutStart.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                        this.mLayoutEnd.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                    }
                }
            }
        }

        public boolean isNotConfiguredWith(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i, i2)) == null) ? (i == this.mStartId && i2 == this.mEndId) ? false : true : invokeII.booleanValue;
        }

        public void measure(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
                int mode = View.MeasureSpec.getMode(i);
                int mode2 = View.MeasureSpec.getMode(i2);
                MotionLayout motionLayout = this.this$0;
                motionLayout.mWidthMeasureMode = mode;
                motionLayout.mHeightMeasureMode = mode2;
                int optimizationLevel = motionLayout.getOptimizationLevel();
                MotionLayout motionLayout2 = this.this$0;
                if (motionLayout2.mCurrentState == motionLayout2.getStartState()) {
                    this.this$0.resolveSystem(this.mLayoutEnd, optimizationLevel, i, i2);
                    if (this.mStart != null) {
                        this.this$0.resolveSystem(this.mLayoutStart, optimizationLevel, i, i2);
                    }
                } else {
                    if (this.mStart != null) {
                        this.this$0.resolveSystem(this.mLayoutStart, optimizationLevel, i, i2);
                    }
                    this.this$0.resolveSystem(this.mLayoutEnd, optimizationLevel, i, i2);
                }
                if (((this.this$0.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824) ? false : true) {
                    MotionLayout motionLayout3 = this.this$0;
                    motionLayout3.mWidthMeasureMode = mode;
                    motionLayout3.mHeightMeasureMode = mode2;
                    if (motionLayout3.mCurrentState == motionLayout3.getStartState()) {
                        this.this$0.resolveSystem(this.mLayoutEnd, optimizationLevel, i, i2);
                        if (this.mStart != null) {
                            this.this$0.resolveSystem(this.mLayoutStart, optimizationLevel, i, i2);
                        }
                    } else {
                        if (this.mStart != null) {
                            this.this$0.resolveSystem(this.mLayoutStart, optimizationLevel, i, i2);
                        }
                        this.this$0.resolveSystem(this.mLayoutEnd, optimizationLevel, i, i2);
                    }
                    this.this$0.mStartWrapWidth = this.mLayoutStart.getWidth();
                    this.this$0.mStartWrapHeight = this.mLayoutStart.getHeight();
                    this.this$0.mEndWrapWidth = this.mLayoutEnd.getWidth();
                    this.this$0.mEndWrapHeight = this.mLayoutEnd.getHeight();
                    MotionLayout motionLayout4 = this.this$0;
                    motionLayout4.mMeasureDuringTransition = (motionLayout4.mStartWrapWidth == motionLayout4.mEndWrapWidth && motionLayout4.mStartWrapHeight == motionLayout4.mEndWrapHeight) ? false : true;
                }
                MotionLayout motionLayout5 = this.this$0;
                int i3 = motionLayout5.mStartWrapWidth;
                int i4 = motionLayout5.mStartWrapHeight;
                int i5 = motionLayout5.mWidthMeasureMode;
                if (i5 == Integer.MIN_VALUE || i5 == 0) {
                    MotionLayout motionLayout6 = this.this$0;
                    int i6 = motionLayout6.mStartWrapWidth;
                    i3 = (int) (i6 + (motionLayout6.mPostInterpolationPosition * (motionLayout6.mEndWrapWidth - i6)));
                }
                int i7 = i3;
                int i8 = this.this$0.mHeightMeasureMode;
                if (i8 == Integer.MIN_VALUE || i8 == 0) {
                    MotionLayout motionLayout7 = this.this$0;
                    int i9 = motionLayout7.mStartWrapHeight;
                    i4 = (int) (i9 + (motionLayout7.mPostInterpolationPosition * (motionLayout7.mEndWrapHeight - i9)));
                }
                this.this$0.resolveMeasuredDimension(i, i2, i7, i4, this.mLayoutStart.isWidthMeasuredTooSmall() || this.mLayoutEnd.isWidthMeasuredTooSmall(), this.mLayoutStart.isHeightMeasuredTooSmall() || this.mLayoutEnd.isHeightMeasuredTooSmall());
            }
        }

        public void reEvaluateState() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                measure(this.this$0.mLastWidthMeasureSpec, this.this$0.mLastHeightMeasureSpec);
                this.this$0.setupMotionViews();
            }
        }

        public void setMeasuredId(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
                this.mStartId = i;
                this.mEndId = i2;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface MotionTracker {
        void addMovement(MotionEvent motionEvent);

        void clear();

        void computeCurrentVelocity(int i);

        void computeCurrentVelocity(int i, float f);

        float getXVelocity();

        float getXVelocity(int i);

        float getYVelocity();

        float getYVelocity(int i);

        void recycle();
    }

    /* loaded from: classes.dex */
    public class StateCache {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String KeyEndState;
        public final String KeyProgress;
        public final String KeyStartState;
        public final String KeyVelocity;
        public int endState;
        public float mProgress;
        public float mVelocity;
        public int startState;
        public final /* synthetic */ MotionLayout this$0;

        public StateCache(MotionLayout motionLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {motionLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = motionLayout;
            this.mProgress = Float.NaN;
            this.mVelocity = Float.NaN;
            this.startState = -1;
            this.endState = -1;
            this.KeyProgress = "motion.progress";
            this.KeyVelocity = "motion.velocity";
            this.KeyStartState = "motion.StartState";
            this.KeyEndState = "motion.EndState";
        }

        public void apply() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.startState != -1 || this.endState != -1) {
                    int i = this.startState;
                    if (i == -1) {
                        this.this$0.transitionToState(this.endState);
                    } else {
                        int i2 = this.endState;
                        if (i2 == -1) {
                            this.this$0.setState(i, -1, -1);
                        } else {
                            this.this$0.setTransition(i, i2);
                        }
                    }
                    this.this$0.setState(TransitionState.SETUP);
                }
                if (Float.isNaN(this.mVelocity)) {
                    if (Float.isNaN(this.mProgress)) {
                        return;
                    }
                    this.this$0.setProgress(this.mProgress);
                    return;
                }
                this.this$0.setProgress(this.mProgress, this.mVelocity);
                this.mProgress = Float.NaN;
                this.mVelocity = Float.NaN;
                this.startState = -1;
                this.endState = -1;
            }
        }

        public Bundle getTransitionState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Bundle bundle = new Bundle();
                bundle.putFloat("motion.progress", this.mProgress);
                bundle.putFloat("motion.velocity", this.mVelocity);
                bundle.putInt("motion.StartState", this.startState);
                bundle.putInt("motion.EndState", this.endState);
                return bundle;
            }
            return (Bundle) invokeV.objValue;
        }

        public void recordState() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.endState = this.this$0.mEndState;
                this.startState = this.this$0.mBeginState;
                this.mVelocity = this.this$0.getVelocity();
                this.mProgress = this.this$0.getProgress();
            }
        }

        public void setEndState(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                this.endState = i;
            }
        }

        public void setProgress(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
                this.mProgress = f;
            }
        }

        public void setStartState(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                this.startState = i;
            }
        }

        public void setTransitionState(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
                this.mProgress = bundle.getFloat("motion.progress");
                this.mVelocity = bundle.getFloat("motion.velocity");
                this.startState = bundle.getInt("motion.StartState");
                this.endState = bundle.getInt("motion.EndState");
            }
        }

        public void setVelocity(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
                this.mVelocity = f;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface TransitionListener {
        void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f);

        void onTransitionCompleted(MotionLayout motionLayout, int i);

        void onTransitionStarted(MotionLayout motionLayout, int i, int i2);

        void onTransitionTrigger(MotionLayout motionLayout, int i, boolean z, float f);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class TransitionState {
        public static final /* synthetic */ TransitionState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TransitionState FINISHED;
        public static final TransitionState MOVING;
        public static final TransitionState SETUP;
        public static final TransitionState UNDEFINED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(697265699, "Landroidx/constraintlayout/motion/widget/MotionLayout$TransitionState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(697265699, "Landroidx/constraintlayout/motion/widget/MotionLayout$TransitionState;");
                    return;
                }
            }
            UNDEFINED = new TransitionState("UNDEFINED", 0);
            SETUP = new TransitionState("SETUP", 1);
            MOVING = new TransitionState("MOVING", 2);
            TransitionState transitionState = new TransitionState("FINISHED", 3);
            FINISHED = transitionState;
            $VALUES = new TransitionState[]{UNDEFINED, SETUP, MOVING, transitionState};
        }

        public TransitionState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static TransitionState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TransitionState) Enum.valueOf(TransitionState.class, str) : (TransitionState) invokeL.objValue;
        }

        public static TransitionState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TransitionState[]) $VALUES.clone() : (TransitionState[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MotionLayout(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator(this);
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new ArrayList<>();
        init(null);
    }

    private void checkStructure() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            MotionScene motionScene = this.mScene;
            if (motionScene == null) {
                Log.e(TAG, "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
                return;
            }
            int startId = motionScene.getStartId();
            MotionScene motionScene2 = this.mScene;
            checkStructure(startId, motionScene2.getConstraintSet(motionScene2.getStartId()));
            SparseIntArray sparseIntArray = new SparseIntArray();
            SparseIntArray sparseIntArray2 = new SparseIntArray();
            Iterator<MotionScene.Transition> it = this.mScene.getDefinedTransitions().iterator();
            while (it.hasNext()) {
                MotionScene.Transition next = it.next();
                if (next == this.mScene.mCurrentTransition) {
                    Log.v(TAG, "CHECK: CURRENT");
                }
                checkStructure(next);
                int startConstraintSetId = next.getStartConstraintSetId();
                int endConstraintSetId = next.getEndConstraintSetId();
                String name = Debug.getName(getContext(), startConstraintSetId);
                String name2 = Debug.getName(getContext(), endConstraintSetId);
                if (sparseIntArray.get(startConstraintSetId) == endConstraintSetId) {
                    Log.e(TAG, "CHECK: two transitions with the same start and end " + name + "->" + name2);
                }
                if (sparseIntArray2.get(endConstraintSetId) == startConstraintSetId) {
                    Log.e(TAG, "CHECK: you can't have reverse transitions" + name + "->" + name2);
                }
                sparseIntArray.put(startConstraintSetId, endConstraintSetId);
                sparseIntArray2.put(endConstraintSetId, startConstraintSetId);
                if (this.mScene.getConstraintSet(startConstraintSetId) == null) {
                    Log.e(TAG, " no such constraintSetStart " + name);
                }
                if (this.mScene.getConstraintSet(endConstraintSetId) == null) {
                    Log.e(TAG, " no such constraintSetEnd " + name);
                }
            }
        }
    }

    private void computeCurrentPositions() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                MotionController motionController = this.mFrameArrayList.get(childAt);
                if (motionController != null) {
                    motionController.setStartCurrentState(childAt);
                }
            }
        }
    }

    private void debugPos() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                Log.v(TAG, " " + Debug.getLocation() + " " + Debug.getName(this) + " " + Debug.getName(getContext(), this.mCurrentState) + " " + Debug.getName(childAt) + childAt.getLeft() + " " + childAt.getTop());
            }
        }
    }

    private void evaluateLayout() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            float signum = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
            long nanoTime = getNanoTime();
            float f = this.mTransitionLastPosition + (!(this.mInterpolator instanceof StopLogic) ? ((((float) (nanoTime - this.mTransitionLastTime)) * signum) * 1.0E-9f) / this.mTransitionDuration : 0.0f);
            if (this.mTransitionInstantly) {
                f = this.mTransitionGoalPosition;
            }
            int i = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
            if ((i <= 0 || f < this.mTransitionGoalPosition) && (signum > 0.0f || f > this.mTransitionGoalPosition)) {
                z = false;
            } else {
                f = this.mTransitionGoalPosition;
                z = true;
            }
            Interpolator interpolator = this.mInterpolator;
            if (interpolator != null && !z) {
                if (this.mTemporalInterpolator) {
                    f = interpolator.getInterpolation(((float) (nanoTime - this.mAnimationStartTime)) * 1.0E-9f);
                } else {
                    f = interpolator.getInterpolation(f);
                }
            }
            if ((i > 0 && f >= this.mTransitionGoalPosition) || (signum <= 0.0f && f <= this.mTransitionGoalPosition)) {
                f = this.mTransitionGoalPosition;
            }
            this.mPostInterpolationPosition = f;
            int childCount = getChildCount();
            long nanoTime2 = getNanoTime();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                MotionController motionController = this.mFrameArrayList.get(childAt);
                if (motionController != null) {
                    motionController.interpolate(childAt, f, nanoTime2, this.mKeyCache);
                }
            }
            if (this.mMeasureDuringTransition) {
                requestLayout();
            }
        }
    }

    private void fireTransitionChange() {
        ArrayList<TransitionListener> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            if ((this.mTransitionListener == null && ((arrayList = this.mTransitionListeners) == null || arrayList.isEmpty())) || this.mListenerPosition == this.mTransitionPosition) {
                return;
            }
            if (this.mListenerState != -1) {
                TransitionListener transitionListener = this.mTransitionListener;
                if (transitionListener != null) {
                    transitionListener.onTransitionStarted(this, this.mBeginState, this.mEndState);
                }
                ArrayList<TransitionListener> arrayList2 = this.mTransitionListeners;
                if (arrayList2 != null) {
                    Iterator<TransitionListener> it = arrayList2.iterator();
                    while (it.hasNext()) {
                        it.next().onTransitionStarted(this, this.mBeginState, this.mEndState);
                    }
                }
                this.mIsAnimating = true;
            }
            this.mListenerState = -1;
            float f = this.mTransitionPosition;
            this.mListenerPosition = f;
            TransitionListener transitionListener2 = this.mTransitionListener;
            if (transitionListener2 != null) {
                transitionListener2.onTransitionChange(this, this.mBeginState, this.mEndState, f);
            }
            ArrayList<TransitionListener> arrayList3 = this.mTransitionListeners;
            if (arrayList3 != null) {
                Iterator<TransitionListener> it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    it2.next().onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
                }
            }
            this.mIsAnimating = true;
        }
    }

    private void fireTransitionStarted(MotionLayout motionLayout, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65567, this, motionLayout, i, i2) == null) {
            TransitionListener transitionListener = this.mTransitionListener;
            if (transitionListener != null) {
                transitionListener.onTransitionStarted(this, i, i2);
            }
            ArrayList<TransitionListener> arrayList = this.mTransitionListeners;
            if (arrayList != null) {
                Iterator<TransitionListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().onTransitionStarted(motionLayout, i, i2);
                }
            }
        }
    }

    private boolean handlesTouchEvent(float f, float f2, View view2, MotionEvent motionEvent) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65568, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), view2, motionEvent})) == null) {
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (handlesTouchEvent(view2.getLeft() + f, view2.getTop() + f2, viewGroup.getChildAt(i), motionEvent)) {
                        return true;
                    }
                }
            }
            this.mBoundsCheck.set(view2.getLeft() + f, view2.getTop() + f2, f + view2.getRight(), f2 + view2.getBottom());
            if (motionEvent.getAction() == 0) {
                if (this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && view2.onTouchEvent(motionEvent)) {
                    return true;
                }
            } else if (view2.onTouchEvent(motionEvent)) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private void init(AttributeSet attributeSet) {
        MotionScene motionScene;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, this, attributeSet) == null) {
            IS_IN_EDIT_MODE = isInEditMode();
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionLayout);
                int indexCount = obtainStyledAttributes.getIndexCount();
                boolean z = true;
                for (int i = 0; i < indexCount; i++) {
                    int index = obtainStyledAttributes.getIndex(i);
                    if (index == R$styleable.MotionLayout_layoutDescription) {
                        this.mScene = new MotionScene(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                    } else if (index == R$styleable.MotionLayout_currentState) {
                        this.mCurrentState = obtainStyledAttributes.getResourceId(index, -1);
                    } else if (index == R$styleable.MotionLayout_motionProgress) {
                        this.mTransitionGoalPosition = obtainStyledAttributes.getFloat(index, 0.0f);
                        this.mInTransition = true;
                    } else if (index == R$styleable.MotionLayout_applyMotionScene) {
                        z = obtainStyledAttributes.getBoolean(index, z);
                    } else if (index == R$styleable.MotionLayout_showPaths) {
                        if (this.mDebugPath == 0) {
                            this.mDebugPath = obtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                        }
                    } else if (index == R$styleable.MotionLayout_motionDebug) {
                        this.mDebugPath = obtainStyledAttributes.getInt(index, 0);
                    }
                }
                obtainStyledAttributes.recycle();
                if (this.mScene == null) {
                    Log.e(TAG, "WARNING NO app:layoutDescription tag");
                }
                if (!z) {
                    this.mScene = null;
                }
            }
            if (this.mDebugPath != 0) {
                checkStructure();
            }
            if (this.mCurrentState != -1 || (motionScene = this.mScene) == null) {
                return;
            }
            this.mCurrentState = motionScene.getStartId();
            this.mBeginState = this.mScene.getStartId();
            this.mEndState = this.mScene.getEndId();
        }
    }

    private void processTransitionCompleted() {
        ArrayList<TransitionListener> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            if (this.mTransitionListener == null && ((arrayList = this.mTransitionListeners) == null || arrayList.isEmpty())) {
                return;
            }
            this.mIsAnimating = false;
            Iterator<Integer> it = this.mTransitionCompleted.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                TransitionListener transitionListener = this.mTransitionListener;
                if (transitionListener != null) {
                    transitionListener.onTransitionCompleted(this, next.intValue());
                }
                ArrayList<TransitionListener> arrayList2 = this.mTransitionListeners;
                if (arrayList2 != null) {
                    Iterator<TransitionListener> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        it2.next().onTransitionCompleted(this, next.intValue());
                    }
                }
            }
            this.mTransitionCompleted.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupMotionViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            int childCount = getChildCount();
            this.mModel.build();
            boolean z = true;
            this.mInTransition = true;
            int width = getWidth();
            int height = getHeight();
            int gatPathMotionArc = this.mScene.gatPathMotionArc();
            int i = 0;
            if (gatPathMotionArc != -1) {
                for (int i2 = 0; i2 < childCount; i2++) {
                    MotionController motionController = this.mFrameArrayList.get(getChildAt(i2));
                    if (motionController != null) {
                        motionController.setPathMotionArc(gatPathMotionArc);
                    }
                }
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                MotionController motionController2 = this.mFrameArrayList.get(getChildAt(i3));
                if (motionController2 != null) {
                    this.mScene.getKeyFrames(motionController2);
                    motionController2.setup(width, height, this.mTransitionDuration, getNanoTime());
                }
            }
            float staggered = this.mScene.getStaggered();
            if (staggered != 0.0f) {
                boolean z2 = ((double) staggered) < 0.0d;
                float abs = Math.abs(staggered);
                float f = -3.4028235E38f;
                float f2 = Float.MAX_VALUE;
                int i4 = 0;
                float f3 = Float.MAX_VALUE;
                float f4 = -3.4028235E38f;
                while (true) {
                    if (i4 >= childCount) {
                        z = false;
                        break;
                    }
                    MotionController motionController3 = this.mFrameArrayList.get(getChildAt(i4));
                    if (!Float.isNaN(motionController3.mMotionStagger)) {
                        break;
                    }
                    float finalX = motionController3.getFinalX();
                    float finalY = motionController3.getFinalY();
                    float f5 = z2 ? finalY - finalX : finalY + finalX;
                    f3 = Math.min(f3, f5);
                    f4 = Math.max(f4, f5);
                    i4++;
                }
                if (!z) {
                    while (i < childCount) {
                        MotionController motionController4 = this.mFrameArrayList.get(getChildAt(i));
                        float finalX2 = motionController4.getFinalX();
                        float finalY2 = motionController4.getFinalY();
                        float f6 = z2 ? finalY2 - finalX2 : finalY2 + finalX2;
                        motionController4.mStaggerScale = 1.0f / (1.0f - abs);
                        motionController4.mStaggerOffset = abs - (((f6 - f3) * abs) / (f4 - f3));
                        i++;
                    }
                    return;
                }
                for (int i5 = 0; i5 < childCount; i5++) {
                    MotionController motionController5 = this.mFrameArrayList.get(getChildAt(i5));
                    if (!Float.isNaN(motionController5.mMotionStagger)) {
                        f2 = Math.min(f2, motionController5.mMotionStagger);
                        f = Math.max(f, motionController5.mMotionStagger);
                    }
                }
                while (i < childCount) {
                    MotionController motionController6 = this.mFrameArrayList.get(getChildAt(i));
                    if (!Float.isNaN(motionController6.mMotionStagger)) {
                        motionController6.mStaggerScale = 1.0f / (1.0f - abs);
                        if (z2) {
                            motionController6.mStaggerOffset = abs - (((f - motionController6.mMotionStagger) / (f - f2)) * abs);
                        } else {
                            motionController6.mStaggerOffset = abs - (((motionController6.mMotionStagger - f2) * abs) / (f - f2));
                        }
                    }
                    i++;
                }
            }
        }
    }

    public static boolean willJump(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65572, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (f > 0.0f) {
                float f4 = f / f3;
                return f2 + ((f * f4) - (((f3 * f4) * f4) / 2.0f)) > 1.0f;
            }
            float f5 = (-f) / f3;
            return f2 + ((f * f5) + (((f3 * f5) * f5) / 2.0f)) < 0.0f;
        }
        return invokeCommon.booleanValue;
    }

    public void addTransitionListener(TransitionListener transitionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, transitionListener) == null) {
            if (this.mTransitionListeners == null) {
                this.mTransitionListeners = new ArrayList<>();
            }
            this.mTransitionListeners.add(transitionListener);
        }
    }

    public void animateTo(float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) || this.mScene == null) {
            return;
        }
        float f2 = this.mTransitionLastPosition;
        float f3 = this.mTransitionPosition;
        if (f2 != f3 && this.mTransitionInstantly) {
            this.mTransitionLastPosition = f3;
        }
        float f4 = this.mTransitionLastPosition;
        if (f4 == f) {
            return;
        }
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = f;
        this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
        setProgress(this.mTransitionGoalPosition);
        this.mInterpolator = this.mScene.getInterpolator();
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        this.mInTransition = true;
        this.mTransitionPosition = f4;
        this.mTransitionLastPosition = f4;
        invalidate();
    }

    public void disableAutoTransition(boolean z) {
        MotionScene motionScene;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (motionScene = this.mScene) == null) {
            return;
        }
        motionScene.disableAutoTransition(z);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            evaluate(false);
            super.dispatchDraw(canvas);
            if (this.mScene == null) {
                return;
            }
            if ((this.mDebugPath & 1) == 1 && !isInEditMode()) {
                this.mFrames++;
                long nanoTime = getNanoTime();
                long j2 = this.mLastDrawTime;
                if (j2 != -1) {
                    if (nanoTime - j2 > 200000000) {
                        this.mLastFps = ((int) ((this.mFrames / (((float) j) * 1.0E-9f)) * 100.0f)) / 100.0f;
                        this.mFrames = 0;
                        this.mLastDrawTime = nanoTime;
                    }
                } else {
                    this.mLastDrawTime = nanoTime;
                }
                Paint paint = new Paint();
                paint.setTextSize(42.0f);
                StringBuilder sb = new StringBuilder();
                sb.append(this.mLastFps + " fps " + Debug.getState(this, this.mBeginState) + LoadErrorCode.TOKEN_NEXT);
                sb.append(Debug.getState(this, this.mEndState));
                sb.append(" (progress: ");
                sb.append(((int) (getProgress() * 1000.0f)) / 10.0f);
                sb.append(" ) state=");
                int i = this.mCurrentState;
                sb.append(i == -1 ? SessionMonitorEngine.PUBLIC_DATA_UNDIFNED : Debug.getState(this, i));
                String sb2 = sb.toString();
                paint.setColor(-16777216);
                canvas.drawText(sb2, 11.0f, getHeight() - 29, paint);
                paint.setColor(-7864184);
                canvas.drawText(sb2, 10.0f, getHeight() - 30, paint);
            }
            if (this.mDebugPath > 1) {
                if (this.mDevModeDraw == null) {
                    this.mDevModeDraw = new DevModeDraw(this);
                }
                this.mDevModeDraw.draw(canvas, this.mFrameArrayList, this.mScene.getDuration(), this.mDebugPath);
            }
        }
    }

    public void enableTransition(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            MotionScene.Transition transition = getTransition(i);
            if (z) {
                transition.setEnable(true);
                return;
            }
            MotionScene motionScene = this.mScene;
            if (transition == motionScene.mCurrentTransition) {
                Iterator<MotionScene.Transition> it = motionScene.getTransitionsWithState(this.mCurrentState).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MotionScene.Transition next = it.next();
                    if (next.isEnabled()) {
                        this.mScene.mCurrentTransition = next;
                        break;
                    }
                }
            }
            transition.setEnable(false);
        }
    }

    public void evaluate(boolean z) {
        float f;
        boolean z2;
        int i;
        float interpolation;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (this.mTransitionLastTime == -1) {
                this.mTransitionLastTime = getNanoTime();
            }
            float f2 = this.mTransitionLastPosition;
            if (f2 > 0.0f && f2 < 1.0f) {
                this.mCurrentState = -1;
            }
            boolean z4 = false;
            if (this.mKeepAnimating || (this.mInTransition && (z || this.mTransitionGoalPosition != this.mTransitionLastPosition))) {
                float signum = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
                long nanoTime = getNanoTime();
                if (this.mInterpolator instanceof MotionInterpolator) {
                    f = 0.0f;
                } else {
                    f = ((((float) (nanoTime - this.mTransitionLastTime)) * signum) * 1.0E-9f) / this.mTransitionDuration;
                    this.mLastVelocity = f;
                }
                float f3 = this.mTransitionLastPosition + f;
                if (this.mTransitionInstantly) {
                    f3 = this.mTransitionGoalPosition;
                }
                int i2 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
                if ((i2 <= 0 || f3 < this.mTransitionGoalPosition) && (signum > 0.0f || f3 > this.mTransitionGoalPosition)) {
                    z2 = false;
                } else {
                    f3 = this.mTransitionGoalPosition;
                    this.mInTransition = false;
                    z2 = true;
                }
                this.mTransitionLastPosition = f3;
                this.mTransitionPosition = f3;
                this.mTransitionLastTime = nanoTime;
                Interpolator interpolator = this.mInterpolator;
                if (interpolator != null && !z2) {
                    if (this.mTemporalInterpolator) {
                        interpolation = interpolator.getInterpolation(((float) (nanoTime - this.mAnimationStartTime)) * 1.0E-9f);
                        this.mTransitionLastPosition = interpolation;
                        this.mTransitionLastTime = nanoTime;
                        Interpolator interpolator2 = this.mInterpolator;
                        if (interpolator2 instanceof MotionInterpolator) {
                            float velocity = ((MotionInterpolator) interpolator2).getVelocity();
                            this.mLastVelocity = velocity;
                            if (Math.abs(velocity) * this.mTransitionDuration <= 1.0E-5f) {
                                this.mInTransition = false;
                            }
                            if (velocity > 0.0f && interpolation >= 1.0f) {
                                this.mTransitionLastPosition = 1.0f;
                                this.mInTransition = false;
                                interpolation = 1.0f;
                            }
                            if (velocity < 0.0f && interpolation <= 0.0f) {
                                this.mTransitionLastPosition = 0.0f;
                                this.mInTransition = false;
                                f3 = 0.0f;
                            }
                        }
                    } else {
                        interpolation = interpolator.getInterpolation(f3);
                        Interpolator interpolator3 = this.mInterpolator;
                        if (interpolator3 instanceof MotionInterpolator) {
                            this.mLastVelocity = ((MotionInterpolator) interpolator3).getVelocity();
                        } else {
                            this.mLastVelocity = ((interpolator3.getInterpolation(f3 + f) - interpolation) * signum) / f;
                        }
                    }
                    f3 = interpolation;
                }
                if (Math.abs(this.mLastVelocity) > 1.0E-5f) {
                    setState(TransitionState.MOVING);
                }
                if ((i2 > 0 && f3 >= this.mTransitionGoalPosition) || (signum <= 0.0f && f3 <= this.mTransitionGoalPosition)) {
                    f3 = this.mTransitionGoalPosition;
                    this.mInTransition = false;
                }
                int i3 = (f3 > 1.0f ? 1 : (f3 == 1.0f ? 0 : -1));
                if (i3 >= 0 || f3 <= 0.0f) {
                    this.mInTransition = false;
                    setState(TransitionState.FINISHED);
                }
                int childCount = getChildCount();
                this.mKeepAnimating = false;
                long nanoTime2 = getNanoTime();
                this.mPostInterpolationPosition = f3;
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    MotionController motionController = this.mFrameArrayList.get(childAt);
                    if (motionController != null) {
                        this.mKeepAnimating = motionController.interpolate(childAt, f3, nanoTime2, this.mKeyCache) | this.mKeepAnimating;
                    }
                }
                boolean z5 = (i2 > 0 && f3 >= this.mTransitionGoalPosition) || (signum <= 0.0f && f3 <= this.mTransitionGoalPosition);
                if (!this.mKeepAnimating && !this.mInTransition && z5) {
                    setState(TransitionState.FINISHED);
                }
                if (this.mMeasureDuringTransition) {
                    requestLayout();
                }
                this.mKeepAnimating = (!z5) | this.mKeepAnimating;
                if (f3 <= 0.0f && (i = this.mBeginState) != -1 && this.mCurrentState != i) {
                    this.mCurrentState = i;
                    this.mScene.getConstraintSet(i).applyCustomAttributes(this);
                    setState(TransitionState.FINISHED);
                    z4 = true;
                }
                if (f3 >= 1.0d) {
                    int i5 = this.mCurrentState;
                    int i6 = this.mEndState;
                    if (i5 != i6) {
                        this.mCurrentState = i6;
                        this.mScene.getConstraintSet(i6).applyCustomAttributes(this);
                        setState(TransitionState.FINISHED);
                        z4 = true;
                    }
                }
                if (this.mKeepAnimating || this.mInTransition) {
                    invalidate();
                } else if ((i2 > 0 && i3 == 0) || (signum < 0.0f && f3 == 0.0f)) {
                    setState(TransitionState.FINISHED);
                }
                if ((!this.mKeepAnimating && this.mInTransition && i2 > 0 && i3 == 0) || (signum < 0.0f && f3 == 0.0f)) {
                    onNewStateAttachHandlers();
                }
            }
            float f4 = this.mTransitionLastPosition;
            if (f4 >= 1.0f) {
                z3 = this.mCurrentState == this.mEndState ? z4 : true;
                this.mCurrentState = this.mEndState;
            } else {
                if (f4 <= 0.0f) {
                    z3 = this.mCurrentState == this.mBeginState ? z4 : true;
                    this.mCurrentState = this.mBeginState;
                }
                this.mNeedsFireTransitionCompleted |= z4;
                if (z4 && !this.mInLayout) {
                    requestLayout();
                }
                this.mTransitionPosition = this.mTransitionLastPosition;
            }
            z4 = z3;
            this.mNeedsFireTransitionCompleted |= z4;
            if (z4) {
                requestLayout();
            }
            this.mTransitionPosition = this.mTransitionLastPosition;
        }
    }

    public void fireTransitionCompleted() {
        int i;
        ArrayList<TransitionListener> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if ((this.mTransitionListener != null || ((arrayList = this.mTransitionListeners) != null && !arrayList.isEmpty())) && this.mListenerState == -1) {
                this.mListenerState = this.mCurrentState;
                if (this.mTransitionCompleted.isEmpty()) {
                    i = -1;
                } else {
                    ArrayList<Integer> arrayList2 = this.mTransitionCompleted;
                    i = arrayList2.get(arrayList2.size() - 1).intValue();
                }
                int i2 = this.mCurrentState;
                if (i != i2 && i2 != -1) {
                    this.mTransitionCompleted.add(Integer.valueOf(i2));
                }
            }
            processTransitionCompleted();
        }
    }

    public void fireTrigger(int i, boolean z, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Float.valueOf(f)}) == null) {
            TransitionListener transitionListener = this.mTransitionListener;
            if (transitionListener != null) {
                transitionListener.onTransitionTrigger(this, i, z, f);
            }
            ArrayList<TransitionListener> arrayList = this.mTransitionListeners;
            if (arrayList != null) {
                Iterator<TransitionListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().onTransitionTrigger(this, i, z, f);
                }
            }
        }
    }

    public void getAnchorDpDt(int i, float f, float f2, float f3, float[] fArr) {
        String resourceName;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), fArr}) == null) {
            HashMap<View, MotionController> hashMap = this.mFrameArrayList;
            View viewById = getViewById(i);
            MotionController motionController = hashMap.get(viewById);
            if (motionController != null) {
                motionController.getDpDt(f, f2, f3, fArr);
                float y = viewById.getY();
                int i2 = ((f - this.lastPos) > 0.0f ? 1 : ((f - this.lastPos) == 0.0f ? 0 : -1));
                this.lastPos = f;
                this.lastY = y;
                return;
            }
            if (viewById == null) {
                resourceName = "" + i;
            } else {
                resourceName = viewById.getContext().getResources().getResourceName(i);
            }
            Log.w(TAG, "WARNING could not find view id " + resourceName);
        }
    }

    public ConstraintSet getConstraintSet(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            MotionScene motionScene = this.mScene;
            if (motionScene == null) {
                return null;
            }
            return motionScene.getConstraintSet(i);
        }
        return (ConstraintSet) invokeI.objValue;
    }

    public int[] getConstraintSetIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            MotionScene motionScene = this.mScene;
            if (motionScene == null) {
                return null;
            }
            return motionScene.getConstraintSetIds();
        }
        return (int[]) invokeV.objValue;
    }

    public String getConstraintSetNames(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            MotionScene motionScene = this.mScene;
            if (motionScene == null) {
                return null;
            }
            return motionScene.lookUpConstraintName(i);
        }
        return (String) invokeI.objValue;
    }

    public int getCurrentState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mCurrentState : invokeV.intValue;
    }

    public void getDebugMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mDebugPath = z ? 2 : 1;
            invalidate();
        }
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            MotionScene motionScene = this.mScene;
            if (motionScene == null) {
                return null;
            }
            return motionScene.getDefinedTransitions();
        }
        return (ArrayList) invokeV.objValue;
    }

    public DesignTool getDesignTool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.mDesignTool == null) {
                this.mDesignTool = new DesignTool(this);
            }
            return this.mDesignTool;
        }
        return (DesignTool) invokeV.objValue;
    }

    public int getEndState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mEndState : invokeV.intValue;
    }

    public long getNanoTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? System.nanoTime() : invokeV.longValue;
    }

    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mTransitionLastPosition : invokeV.floatValue;
    }

    public int getStartState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mBeginState : invokeV.intValue;
    }

    public float getTargetPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mTransitionGoalPosition : invokeV.floatValue;
    }

    public MotionScene.Transition getTransition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) ? this.mScene.getTransitionById(i) : (MotionScene.Transition) invokeI.objValue;
    }

    public Bundle getTransitionState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache(this);
            }
            this.mStateCache.recordState();
            return this.mStateCache.getTransitionState();
        }
        return (Bundle) invokeV.objValue;
    }

    public long getTransitionTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            MotionScene motionScene = this.mScene;
            if (motionScene != null) {
                this.mTransitionDuration = motionScene.getDuration() / 1000.0f;
            }
            return this.mTransitionDuration * 1000.0f;
        }
        return invokeV.longValue;
    }

    public float getVelocity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mLastVelocity : invokeV.floatValue;
    }

    public void getViewVelocity(View view2, float f, float f2, float[] fArr, int i) {
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2), fArr, Integer.valueOf(i)}) == null) {
            float f4 = this.mLastVelocity;
            float f5 = this.mTransitionLastPosition;
            if (this.mInterpolator != null) {
                float signum = Math.signum(this.mTransitionGoalPosition - f5);
                float interpolation = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + 1.0E-5f);
                float interpolation2 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
                f4 = (signum * ((interpolation - interpolation2) / 1.0E-5f)) / this.mTransitionDuration;
                f3 = interpolation2;
            } else {
                f3 = f5;
            }
            Interpolator interpolator = this.mInterpolator;
            if (interpolator instanceof MotionInterpolator) {
                f4 = ((MotionInterpolator) interpolator).getVelocity();
            }
            MotionController motionController = this.mFrameArrayList.get(view2);
            if ((i & 1) == 0) {
                motionController.getPostLayoutDvDp(f3, view2.getWidth(), view2.getHeight(), f, f2, fArr);
            } else {
                motionController.getDpDt(f3, f, f2, fArr);
            }
            if (i < 2) {
                fArr[0] = fArr[0] * f4;
                fArr[1] = fArr[1] * f4;
            }
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return super.isAttachedToWindow();
            }
            return getWindowToken() != null;
        }
        return invokeV.booleanValue;
    }

    public boolean isInteractionEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mInteractionEnabled : invokeV.booleanValue;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            if (i != 0) {
                try {
                    this.mScene = new MotionScene(getContext(), this, i);
                    if (Build.VERSION.SDK_INT < 19 || isAttachedToWindow()) {
                        this.mScene.readFallback(this);
                        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
                        rebuildScene();
                        this.mScene.setRtl(isRtl());
                        return;
                    }
                    return;
                } catch (Exception e) {
                    throw new IllegalArgumentException("unable to parse MotionScene file", e);
                }
            }
            this.mScene = null;
        }
    }

    public int lookUpConstraintId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            MotionScene motionScene = this.mScene;
            if (motionScene == null) {
                return 0;
            }
            return motionScene.lookUpConstraintId(str);
        }
        return invokeL.intValue;
    }

    public MotionTracker obtainVelocityTracker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? MyTracker.obtain() : (MotionTracker) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        MotionScene.Transition transition;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onAttachedToWindow();
            MotionScene motionScene = this.mScene;
            if (motionScene != null && (i = this.mCurrentState) != -1) {
                ConstraintSet constraintSet = motionScene.getConstraintSet(i);
                this.mScene.readFallback(this);
                if (constraintSet != null) {
                    constraintSet.applyTo(this);
                }
                this.mBeginState = this.mCurrentState;
            }
            onNewStateAttachHandlers();
            StateCache stateCache = this.mStateCache;
            if (stateCache != null) {
                stateCache.apply();
                return;
            }
            MotionScene motionScene2 = this.mScene;
            if (motionScene2 == null || (transition = motionScene2.mCurrentTransition) == null || transition.getAutoTransition() != 4) {
                return;
            }
            transitionToEnd();
            setState(TransitionState.SETUP);
            setState(TransitionState.MOVING);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        MotionScene.Transition transition;
        TouchResponse touchResponse;
        int touchRegionId;
        RectF touchRegion;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, motionEvent)) == null) {
            MotionScene motionScene = this.mScene;
            if (motionScene != null && this.mInteractionEnabled && (transition = motionScene.mCurrentTransition) != null && transition.isEnabled() && (touchResponse = transition.getTouchResponse()) != null && ((motionEvent.getAction() != 0 || (touchRegion = touchResponse.getTouchRegion(this, new RectF())) == null || touchRegion.contains(motionEvent.getX(), motionEvent.getY())) && (touchRegionId = touchResponse.getTouchRegionId()) != -1)) {
                View view2 = this.mRegionView;
                if (view2 == null || view2.getId() != touchRegionId) {
                    this.mRegionView = findViewById(touchRegionId);
                }
                View view3 = this.mRegionView;
                if (view3 != null) {
                    this.mBoundsCheck.set(view3.getLeft(), this.mRegionView.getTop(), this.mRegionView.getRight(), this.mRegionView.getBottom());
                    if (this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && !handlesTouchEvent(0.0f, 0.0f, this.mRegionView, motionEvent)) {
                        return onTouchEvent(motionEvent);
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.mInLayout = true;
            try {
                if (this.mScene == null) {
                    super.onLayout(z, i, i2, i3, i4);
                    return;
                }
                int i5 = i3 - i;
                int i6 = i4 - i2;
                if (this.mLastLayoutWidth != i5 || this.mLastLayoutHeight != i6) {
                    rebuildScene();
                    evaluate(true);
                }
                this.mLastLayoutWidth = i5;
                this.mLastLayoutHeight = i6;
                this.mOldWidth = i5;
                this.mOldHeight = i6;
            } finally {
                this.mInLayout = false;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048610, this, i, i2) == null) {
            if (this.mScene == null) {
                super.onMeasure(i, i2);
                return;
            }
            boolean z = false;
            boolean z2 = (this.mLastWidthMeasureSpec == i && this.mLastHeightMeasureSpec == i2) ? false : true;
            if (this.mNeedsFireTransitionCompleted) {
                this.mNeedsFireTransitionCompleted = false;
                onNewStateAttachHandlers();
                processTransitionCompleted();
                z2 = true;
            }
            if (this.mDirtyHierarchy) {
                z2 = true;
            }
            this.mLastWidthMeasureSpec = i;
            this.mLastHeightMeasureSpec = i2;
            int startId = this.mScene.getStartId();
            int endId = this.mScene.getEndId();
            if ((z2 || this.mModel.isNotConfiguredWith(startId, endId)) && this.mBeginState != -1) {
                super.onMeasure(i, i2);
                this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(startId), this.mScene.getConstraintSet(endId));
                this.mModel.reEvaluateState();
                this.mModel.setMeasuredId(startId, endId);
            } else {
                z = true;
            }
            if (this.mMeasureDuringTransition || z) {
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int width = this.mLayoutWidget.getWidth() + getPaddingLeft() + getPaddingRight();
                int height = this.mLayoutWidget.getHeight() + paddingTop;
                int i3 = this.mWidthMeasureMode;
                if (i3 == Integer.MIN_VALUE || i3 == 0) {
                    int i4 = this.mStartWrapWidth;
                    width = (int) (i4 + (this.mPostInterpolationPosition * (this.mEndWrapWidth - i4)));
                    requestLayout();
                }
                int i5 = this.mHeightMeasureMode;
                if (i5 == Integer.MIN_VALUE || i5 == 0) {
                    int i6 = this.mStartWrapHeight;
                    height = (int) (i6 + (this.mPostInterpolationPosition * (this.mEndWrapHeight - i6)));
                    requestLayout();
                }
                setMeasuredDimension(width, height);
            }
            evaluateLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view2, float f, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048612, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view2, int i, int i2, int[] iArr, int i3) {
        MotionScene motionScene;
        MotionScene.Transition transition;
        TouchResponse touchResponse;
        int touchRegionId;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), iArr, Integer.valueOf(i3)}) == null) || (motionScene = this.mScene) == null || (transition = motionScene.mCurrentTransition) == null || !transition.isEnabled()) {
            return;
        }
        MotionScene.Transition transition2 = this.mScene.mCurrentTransition;
        if (transition2 == null || !transition2.isEnabled() || (touchResponse = transition2.getTouchResponse()) == null || (touchRegionId = touchResponse.getTouchRegionId()) == -1 || view2.getId() == touchRegionId) {
            MotionScene motionScene2 = this.mScene;
            if (motionScene2 != null && motionScene2.getMoveWhenScrollAtTop()) {
                float f = this.mTransitionPosition;
                if ((f == 1.0f || f == 0.0f) && view2.canScrollVertically(-1)) {
                    return;
                }
            }
            if (transition2.getTouchResponse() != null && (this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 1) != 0) {
                float progressDirection = this.mScene.getProgressDirection(i, i2);
                if ((this.mTransitionLastPosition <= 0.0f && progressDirection < 0.0f) || (this.mTransitionLastPosition >= 1.0f && progressDirection > 0.0f)) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        view2.setNestedScrollingEnabled(false);
                        view2.post(new Runnable(this, view2) { // from class: androidx.constraintlayout.motion.widget.MotionLayout.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ MotionLayout this$0;
                            public final /* synthetic */ View val$target;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, view2};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$target = view2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.val$target.setNestedScrollingEnabled(true);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            float f2 = this.mTransitionPosition;
            long nanoTime = getNanoTime();
            float f3 = i;
            this.mScrollTargetDX = f3;
            float f4 = i2;
            this.mScrollTargetDY = f4;
            this.mScrollTargetDT = (float) ((nanoTime - this.mScrollTargetTime) * 1.0E-9d);
            this.mScrollTargetTime = nanoTime;
            this.mScene.processScrollMove(f3, f4);
            if (f2 != this.mTransitionPosition) {
                iArr[0] = i;
                iArr[1] = i2;
            }
            evaluate(false);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.mUndergoingMotion = true;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view2, int i, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr}) == null) {
            if (this.mUndergoingMotion || i != 0 || i2 != 0) {
                iArr[0] = iArr[0] + i3;
                iArr[1] = iArr[1] + i4;
            }
            this.mUndergoingMotion = false;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view2, View view3, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048616, this, view2, view3, i, i2) == null) {
        }
    }

    public void onNewStateAttachHandlers() {
        MotionScene motionScene;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (motionScene = this.mScene) == null) {
            return;
        }
        if (motionScene.autoTransition(this, this.mCurrentState)) {
            requestLayout();
            return;
        }
        int i = this.mCurrentState;
        if (i != -1) {
            this.mScene.addOnClickListeners(this, i);
        }
        if (this.mScene.supportTouch()) {
            this.mScene.setupTouch();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        MotionScene motionScene;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048618, this, i) == null) || (motionScene = this.mScene) == null) {
            return;
        }
        motionScene.setRtl(isRtl());
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view2, View view3, int i, int i2) {
        InterceptResult invokeLLII;
        MotionScene.Transition transition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048619, this, view2, view3, i, i2)) == null) {
            MotionScene motionScene = this.mScene;
            return (motionScene == null || (transition = motionScene.mCurrentTransition) == null || transition.getTouchResponse() == null || (this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 2) != 0) ? false : true;
        }
        return invokeLLII.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view2, int i) {
        MotionScene motionScene;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048620, this, view2, i) == null) || (motionScene = this.mScene) == null) {
            return;
        }
        float f = this.mScrollTargetDX;
        float f2 = this.mScrollTargetDT;
        motionScene.processScrollUp(f / f2, this.mScrollTargetDY / f2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, motionEvent)) == null) {
            MotionScene motionScene = this.mScene;
            if (motionScene != null && this.mInteractionEnabled && motionScene.supportTouch()) {
                MotionScene.Transition transition = this.mScene.mCurrentTransition;
                if (transition != null && !transition.isEnabled()) {
                    return super.onTouchEvent(motionEvent);
                }
                this.mScene.processTouchEvent(motionEvent, getCurrentState(), this);
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, view2) == null) {
            super.onViewAdded(view2);
            if (view2 instanceof MotionHelper) {
                MotionHelper motionHelper = (MotionHelper) view2;
                if (this.mTransitionListeners == null) {
                    this.mTransitionListeners = new ArrayList<>();
                }
                this.mTransitionListeners.add(motionHelper);
                if (motionHelper.isUsedOnShow()) {
                    if (this.mOnShowHelpers == null) {
                        this.mOnShowHelpers = new ArrayList<>();
                    }
                    this.mOnShowHelpers.add(motionHelper);
                }
                if (motionHelper.isUseOnHide()) {
                    if (this.mOnHideHelpers == null) {
                        this.mOnHideHelpers = new ArrayList<>();
                    }
                    this.mOnHideHelpers.add(motionHelper);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, view2) == null) {
            super.onViewRemoved(view2);
            ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
            if (arrayList != null) {
                arrayList.remove(view2);
            }
            ArrayList<MotionHelper> arrayList2 = this.mOnHideHelpers;
            if (arrayList2 != null) {
                arrayList2.remove(view2);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void parseLayoutDescription(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
            this.mConstraintLayoutSpec = null;
        }
    }

    @Deprecated
    public void rebuildMotion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            Log.e(TAG, "This method is deprecated. Please call rebuildScene() instead.");
            rebuildScene();
        }
    }

    public void rebuildScene() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.mModel.reEvaluateState();
            invalidate();
        }
    }

    public boolean removeTransitionListener(TransitionListener transitionListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, transitionListener)) == null) {
            ArrayList<TransitionListener> arrayList = this.mTransitionListeners;
            if (arrayList == null) {
                return false;
            }
            return arrayList.remove(transitionListener);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        MotionScene motionScene;
        MotionScene.Transition transition;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            if (this.mMeasureDuringTransition || this.mCurrentState != -1 || (motionScene = this.mScene) == null || (transition = motionScene.mCurrentTransition) == null || transition.getLayoutDuringTransition() != 0) {
                super.requestLayout();
            }
        }
    }

    public void setDebugMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
            this.mDebugPath = i;
            invalidate();
        }
    }

    public void setInteractionEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.mInteractionEnabled = z;
        }
    }

    public void setInterpolatedProgress(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048631, this, f) == null) {
            if (this.mScene != null) {
                setState(TransitionState.MOVING);
                Interpolator interpolator = this.mScene.getInterpolator();
                if (interpolator != null) {
                    setProgress(interpolator.getInterpolation(f));
                    return;
                }
            }
            setProgress(f);
        }
    }

    public void setOnHide(float f) {
        ArrayList<MotionHelper> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048632, this, f) == null) || (arrayList = this.mOnHideHelpers) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.mOnHideHelpers.get(i).setProgress(f);
        }
    }

    public void setOnShow(float f) {
        ArrayList<MotionHelper> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048633, this, f) == null) || (arrayList = this.mOnShowHelpers) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.mOnShowHelpers.get(i).setProgress(f);
        }
    }

    public void setProgress(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            if (!isAttachedToWindow()) {
                if (this.mStateCache == null) {
                    this.mStateCache = new StateCache(this);
                }
                this.mStateCache.setProgress(f);
                this.mStateCache.setVelocity(f2);
                return;
            }
            setProgress(f);
            setState(TransitionState.MOVING);
            this.mLastVelocity = f2;
            animateTo(1.0f);
        }
    }

    public void setScene(MotionScene motionScene) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, motionScene) == null) {
            this.mScene = motionScene;
            motionScene.setRtl(isRtl());
            rebuildScene();
        }
    }

    public void setState(TransitionState transitionState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, transitionState) == null) {
            if (transitionState == TransitionState.FINISHED && this.mCurrentState == -1) {
                return;
            }
            TransitionState transitionState2 = this.mTransitionState;
            this.mTransitionState = transitionState;
            TransitionState transitionState3 = TransitionState.MOVING;
            if (transitionState2 == transitionState3 && transitionState == transitionState3) {
                fireTransitionChange();
            }
            int i = AnonymousClass2.$SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[transitionState2.ordinal()];
            if (i != 1 && i != 2) {
                if (i == 3 && transitionState == TransitionState.FINISHED) {
                    fireTransitionCompleted();
                    return;
                }
                return;
            }
            if (transitionState == TransitionState.MOVING) {
                fireTransitionChange();
            }
            if (transitionState == TransitionState.FINISHED) {
                fireTransitionCompleted();
            }
        }
    }

    public void setTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048640, this, i, i2) == null) {
            if (!isAttachedToWindow()) {
                if (this.mStateCache == null) {
                    this.mStateCache = new StateCache(this);
                }
                this.mStateCache.setStartState(i);
                this.mStateCache.setEndState(i2);
                return;
            }
            MotionScene motionScene = this.mScene;
            if (motionScene != null) {
                this.mBeginState = i;
                this.mEndState = i2;
                motionScene.setTransition(i, i2);
                this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(i), this.mScene.getConstraintSet(i2));
                rebuildScene();
                this.mTransitionLastPosition = 0.0f;
                transitionToStart();
            }
        }
    }

    public void setTransitionDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i) == null) {
            MotionScene motionScene = this.mScene;
            if (motionScene == null) {
                Log.e(TAG, "MotionScene not defined");
            } else {
                motionScene.setDuration(i);
            }
        }
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, transitionListener) == null) {
            this.mTransitionListener = transitionListener;
        }
    }

    public void setTransitionState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, bundle) == null) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache(this);
            }
            this.mStateCache.setTransitionState(bundle);
            if (isAttachedToWindow()) {
                this.mStateCache.apply();
            }
        }
    }

    @Override // android.view.View
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            Context context = getContext();
            return Debug.getName(context, this.mBeginState) + "->" + Debug.getName(context, this.mEndState) + " (pos:" + this.mTransitionLastPosition + " Dpos/Dt:" + this.mLastVelocity;
        }
        return (String) invokeV.objValue;
    }

    public void touchAnimateTo(int i, float f, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)}) == null) || this.mScene == null || this.mTransitionLastPosition == f) {
            return;
        }
        this.mTemporalInterpolator = true;
        this.mAnimationStartTime = getNanoTime();
        this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
        this.mTransitionGoalPosition = f;
        this.mInTransition = true;
        if (i == 0 || i == 1 || i == 2) {
            if (i == 1) {
                f = 0.0f;
            } else if (i == 2) {
                f = 1.0f;
            }
            this.mStopLogic.config(this.mTransitionLastPosition, f, f2, this.mTransitionDuration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
            int i2 = this.mCurrentState;
            this.mTransitionGoalPosition = f;
            this.mCurrentState = i2;
            this.mInterpolator = this.mStopLogic;
        } else if (i == 4) {
            this.mDecelerateLogic.config(f2, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
            this.mInterpolator = this.mDecelerateLogic;
        } else if (i == 5) {
            if (willJump(f2, this.mTransitionLastPosition, this.mScene.getMaxAcceleration())) {
                this.mDecelerateLogic.config(f2, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
                this.mInterpolator = this.mDecelerateLogic;
            } else {
                this.mStopLogic.config(this.mTransitionLastPosition, f, f2, this.mTransitionDuration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
                this.mLastVelocity = 0.0f;
                int i3 = this.mCurrentState;
                this.mTransitionGoalPosition = f;
                this.mCurrentState = i3;
                this.mInterpolator = this.mStopLogic;
            }
        }
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        invalidate();
    }

    public void transitionToEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            animateTo(1.0f);
        }
    }

    public void transitionToStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            animateTo(0.0f);
        }
    }

    public void transitionToState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048649, this, i) == null) {
            if (!isAttachedToWindow()) {
                if (this.mStateCache == null) {
                    this.mStateCache = new StateCache(this);
                }
                this.mStateCache.setEndState(i);
                return;
            }
            transitionToState(i, -1, -1);
        }
    }

    public void updateState(int i, ConstraintSet constraintSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048652, this, i, constraintSet) == null) {
            MotionScene motionScene = this.mScene;
            if (motionScene != null) {
                motionScene.setConstraintSet(i, constraintSet);
            }
            updateState();
            if (this.mCurrentState == i) {
                constraintSet.applyTo(this);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class MyTracker implements MotionTracker {
        public static /* synthetic */ Interceptable $ic;
        public static MyTracker me;
        public transient /* synthetic */ FieldHolder $fh;
        public VelocityTracker tracker;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2095498381, "Landroidx/constraintlayout/motion/widget/MotionLayout$MyTracker;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2095498381, "Landroidx/constraintlayout/motion/widget/MotionLayout$MyTracker;");
                    return;
                }
            }
            me = new MyTracker();
        }

        public MyTracker() {
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

        public static MyTracker obtain() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                me.tracker = VelocityTracker.obtain();
                return me;
            }
            return (MyTracker) invokeV.objValue;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void addMovement(MotionEvent motionEvent) {
            VelocityTracker velocityTracker;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) || (velocityTracker = this.tracker) == null) {
                return;
            }
            velocityTracker.addMovement(motionEvent);
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void clear() {
            VelocityTracker velocityTracker;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.tracker) == null) {
                return;
            }
            velocityTracker.clear();
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int i) {
            VelocityTracker velocityTracker;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (velocityTracker = this.tracker) == null) {
                return;
            }
            velocityTracker.computeCurrentVelocity(i);
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                VelocityTracker velocityTracker = this.tracker;
                if (velocityTracker != null) {
                    return velocityTracker.getXVelocity();
                }
                return 0.0f;
            }
            return invokeV.floatValue;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                VelocityTracker velocityTracker = this.tracker;
                if (velocityTracker != null) {
                    return velocityTracker.getYVelocity();
                }
                return 0.0f;
            }
            return invokeV.floatValue;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void recycle() {
            VelocityTracker velocityTracker;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (velocityTracker = this.tracker) == null) {
                return;
            }
            velocityTracker.recycle();
            this.tracker = null;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int i, float f) {
            VelocityTracker velocityTracker;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) || (velocityTracker = this.tracker) == null) {
                return;
            }
            velocityTracker.computeCurrentVelocity(i, f);
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                VelocityTracker velocityTracker = this.tracker;
                if (velocityTracker != null) {
                    return velocityTracker.getXVelocity(i);
                }
                return 0.0f;
            }
            return invokeI.floatValue;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                if (this.tracker != null) {
                    return getYVelocity(i);
                }
                return 0.0f;
            }
            return invokeI.floatValue;
        }
    }

    public void transitionToState(int i, int i2, int i3) {
        StateSet stateSet;
        int convertToConstraintSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048650, this, i, i2, i3) == null) {
            MotionScene motionScene = this.mScene;
            if (motionScene != null && (stateSet = motionScene.mStateSet) != null && (convertToConstraintSet = stateSet.convertToConstraintSet(this.mCurrentState, i, i2, i3)) != -1) {
                i = convertToConstraintSet;
            }
            int i4 = this.mCurrentState;
            if (i4 == i) {
                return;
            }
            if (this.mBeginState == i) {
                animateTo(0.0f);
            } else if (this.mEndState == i) {
                animateTo(1.0f);
            } else {
                this.mEndState = i;
                if (i4 != -1) {
                    setTransition(i4, i);
                    animateTo(1.0f);
                    this.mTransitionLastPosition = 0.0f;
                    transitionToEnd();
                    return;
                }
                this.mTemporalInterpolator = false;
                this.mTransitionGoalPosition = 1.0f;
                this.mTransitionPosition = 0.0f;
                this.mTransitionLastPosition = 0.0f;
                this.mTransitionLastTime = getNanoTime();
                this.mAnimationStartTime = getNanoTime();
                this.mTransitionInstantly = false;
                this.mInterpolator = null;
                this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
                this.mBeginState = -1;
                this.mScene.setTransition(-1, this.mEndState);
                this.mScene.getStartId();
                int childCount = getChildCount();
                this.mFrameArrayList.clear();
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = getChildAt(i5);
                    this.mFrameArrayList.put(childAt, new MotionController(childAt));
                }
                this.mInTransition = true;
                this.mModel.initFrom(this.mLayoutWidget, null, this.mScene.getConstraintSet(i));
                rebuildScene();
                this.mModel.build();
                computeCurrentPositions();
                int width = getWidth();
                int height = getHeight();
                for (int i6 = 0; i6 < childCount; i6++) {
                    MotionController motionController = this.mFrameArrayList.get(getChildAt(i6));
                    this.mScene.getKeyFrames(motionController);
                    motionController.setup(width, height, this.mTransitionDuration, getNanoTime());
                }
                float staggered = this.mScene.getStaggered();
                if (staggered != 0.0f) {
                    float f = Float.MAX_VALUE;
                    float f2 = -3.4028235E38f;
                    for (int i7 = 0; i7 < childCount; i7++) {
                        MotionController motionController2 = this.mFrameArrayList.get(getChildAt(i7));
                        float finalY = motionController2.getFinalY() + motionController2.getFinalX();
                        f = Math.min(f, finalY);
                        f2 = Math.max(f2, finalY);
                    }
                    for (int i8 = 0; i8 < childCount; i8++) {
                        MotionController motionController3 = this.mFrameArrayList.get(getChildAt(i8));
                        float finalX = motionController3.getFinalX();
                        float finalY2 = motionController3.getFinalY();
                        motionController3.mStaggerScale = 1.0f / (1.0f - staggered);
                        motionController3.mStaggerOffset = staggered - ((((finalX + finalY2) - f) * staggered) / (f2 - f));
                    }
                }
                this.mTransitionPosition = 0.0f;
                this.mTransitionLastPosition = 0.0f;
                this.mInTransition = true;
                invalidate();
            }
        }
    }

    public void updateState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
            rebuildScene();
        }
    }

    public void setProgress(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048634, this, f) == null) {
            int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (i < 0 || f > 1.0f) {
                Log.w(TAG, "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
            }
            if (!isAttachedToWindow()) {
                if (this.mStateCache == null) {
                    this.mStateCache = new StateCache(this);
                }
                this.mStateCache.setProgress(f);
                return;
            }
            if (i <= 0) {
                this.mCurrentState = this.mBeginState;
                if (this.mTransitionLastPosition == 0.0f) {
                    setState(TransitionState.FINISHED);
                }
            } else if (f >= 1.0f) {
                this.mCurrentState = this.mEndState;
                if (this.mTransitionLastPosition == 1.0f) {
                    setState(TransitionState.FINISHED);
                }
            } else {
                this.mCurrentState = -1;
                setState(TransitionState.MOVING);
            }
            if (this.mScene == null) {
                return;
            }
            this.mTransitionInstantly = true;
            this.mTransitionGoalPosition = f;
            this.mTransitionPosition = f;
            this.mTransitionLastTime = -1L;
            this.mAnimationStartTime = -1L;
            this.mInterpolator = null;
            this.mInTransition = true;
            invalidate();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048637, this, i, i2, i3) == null) {
            setState(TransitionState.SETUP);
            this.mCurrentState = i;
            this.mBeginState = -1;
            this.mEndState = -1;
            ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
            if (constraintLayoutStates != null) {
                constraintLayoutStates.updateConstraints(i, i2, i3);
                return;
            }
            MotionScene motionScene = this.mScene;
            if (motionScene != null) {
                motionScene.getConstraintSet(i).applyTo(this);
            }
        }
    }

    public void setTransition(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048639, this, i) == null) || this.mScene == null) {
            return;
        }
        MotionScene.Transition transition = getTransition(i);
        this.mBeginState = transition.getStartConstraintSetId();
        this.mEndState = transition.getEndConstraintSetId();
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache(this);
            }
            this.mStateCache.setStartState(this.mBeginState);
            this.mStateCache.setEndState(this.mEndState);
            return;
        }
        float f = Float.NaN;
        int i2 = this.mCurrentState;
        if (i2 == this.mBeginState) {
            f = 0.0f;
        } else if (i2 == this.mEndState) {
            f = 1.0f;
        }
        this.mScene.setTransition(transition);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        rebuildScene();
        this.mTransitionLastPosition = Float.isNaN(f) ? 0.0f : f;
        if (Float.isNaN(f)) {
            Log.v(TAG, Debug.getLocation() + " transitionToStart ");
            transitionToStart();
            return;
        }
        setProgress(f);
    }

    private void checkStructure(int i, ConstraintSet constraintSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65561, this, i, constraintSet) == null) {
            String name = Debug.getName(getContext(), i);
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                int id = childAt.getId();
                if (id == -1) {
                    Log.w(TAG, "CHECK: " + name + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
                }
                if (constraintSet.getConstraint(id) == null) {
                    Log.w(TAG, "CHECK: " + name + " NO CONSTRAINTS for " + Debug.getName(childAt));
                }
            }
            int[] knownIds = constraintSet.getKnownIds();
            for (int i3 = 0; i3 < knownIds.length; i3++) {
                int i4 = knownIds[i3];
                String name2 = Debug.getName(getContext(), i4);
                if (findViewById(knownIds[i3]) == null) {
                    Log.w(TAG, "CHECK: " + name + " NO View matches id " + name2);
                }
                if (constraintSet.getHeight(i4) == -1) {
                    Log.w(TAG, "CHECK: " + name + "(" + name2 + ") no LAYOUT_HEIGHT");
                }
                if (constraintSet.getWidth(i4) == -1) {
                    Log.w(TAG, "CHECK: " + name + "(" + name2 + ") no LAYOUT_HEIGHT");
                }
            }
        }
    }

    public void setTransition(MotionScene.Transition transition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, transition) == null) {
            this.mScene.setTransition(transition);
            setState(TransitionState.SETUP);
            if (this.mCurrentState == this.mScene.getEndId()) {
                this.mTransitionLastPosition = 1.0f;
                this.mTransitionPosition = 1.0f;
                this.mTransitionGoalPosition = 1.0f;
            } else {
                this.mTransitionLastPosition = 0.0f;
                this.mTransitionPosition = 0.0f;
                this.mTransitionGoalPosition = 0.0f;
            }
            this.mTransitionLastTime = transition.isTransitionFlag(1) ? -1L : getNanoTime();
            int startId = this.mScene.getStartId();
            int endId = this.mScene.getEndId();
            if (startId == this.mBeginState && endId == this.mEndState) {
                return;
            }
            this.mBeginState = startId;
            this.mEndState = endId;
            this.mScene.setTransition(startId, endId);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
            this.mModel.setMeasuredId(this.mBeginState, this.mEndState);
            this.mModel.reEvaluateState();
            rebuildScene();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator(this);
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new ArrayList<>();
        init(attributeSet);
    }

    private void checkStructure(MotionScene.Transition transition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, transition) == null) {
            Log.v(TAG, "CHECK: transition = " + transition.debugString(getContext()));
            Log.v(TAG, "CHECK: transition.setDuration = " + transition.getDuration());
            if (transition.getStartConstraintSetId() == transition.getEndConstraintSetId()) {
                Log.e(TAG, "CHECK: start and end constraint set should not be the same!");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator(this);
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new ArrayList<>();
        init(attributeSet);
    }
}

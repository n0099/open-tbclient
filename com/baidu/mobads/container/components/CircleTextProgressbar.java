package com.baidu.mobads.container.components;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class CircleTextProgressbar extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Rect bounds;
    public int circleColor;
    public ColorStateList inCircleColors;
    public RectF mArcRect;
    public BaseTask mBaseTask;
    public OnCountdownProgressListener mCountdownProgressListener;
    public Paint mPaint;
    public int mProgressTotalPart;
    public ProgressType mProgressType;
    public int outLineColor;
    public int outLineWidth;
    public int progress;
    public int progressLineColor;
    public int progressLineWidth;
    public long timeMillis;

    /* renamed from: com.baidu.mobads.container.components.CircleTextProgressbar$2  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$mobads$container$components$CircleTextProgressbar$ProgressType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1096776894, "Lcom/baidu/mobads/container/components/CircleTextProgressbar$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1096776894, "Lcom/baidu/mobads/container/components/CircleTextProgressbar$2;");
                    return;
                }
            }
            int[] iArr = new int[ProgressType.values().length];
            $SwitchMap$com$baidu$mobads$container$components$CircleTextProgressbar$ProgressType = iArr;
            try {
                iArr[ProgressType.COUNT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$components$CircleTextProgressbar$ProgressType[ProgressType.COUNT_BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface OnCountdownProgressListener {
        void onEnd();

        void onProgress(int i2);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class ProgressType {
        public static final /* synthetic */ ProgressType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ProgressType COUNT;
        public static final ProgressType COUNT_BACK;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1094813791, "Lcom/baidu/mobads/container/components/CircleTextProgressbar$ProgressType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1094813791, "Lcom/baidu/mobads/container/components/CircleTextProgressbar$ProgressType;");
                    return;
                }
            }
            COUNT = new ProgressType("COUNT", 0);
            ProgressType progressType = new ProgressType("COUNT_BACK", 1);
            COUNT_BACK = progressType;
            $VALUES = new ProgressType[]{COUNT, progressType};
        }

        public ProgressType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ProgressType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ProgressType) Enum.valueOf(ProgressType.class, str) : (ProgressType) invokeL.objValue;
        }

        public static ProgressType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ProgressType[]) $VALUES.clone() : (ProgressType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleTextProgressbar(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void executeTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mBaseTask = new BaseTask(this) { // from class: com.baidu.mobads.container.components.CircleTextProgressbar.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CircleTextProgressbar this$0;

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

                @Override // com.baidu.mobads.container.executor.BaseTask
                public Object doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        this.this$0.updateProTask();
                        return null;
                    }
                    return invokeV.objValue;
                }
            };
            TaskScheduler.getInstance().submitAtFixedRate(this.mBaseTask, 0L, this.timeMillis / this.mProgressTotalPart, TimeUnit.MILLISECONDS);
        }
    }

    private void initialize(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, context, attributeSet) == null) {
            this.mPaint.setAntiAlias(true);
            ColorStateList valueOf = ColorStateList.valueOf(0);
            this.inCircleColors = valueOf;
            this.circleColor = valueOf.getColorForState(getDrawableState(), 0);
        }
    }

    private void resetProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            int i2 = AnonymousClass2.$SwitchMap$com$baidu$mobads$container$components$CircleTextProgressbar$ProgressType[this.mProgressType.ordinal()];
            if (i2 == 1) {
                this.progress = 0;
            } else if (i2 != 2) {
                this.progress = 0;
            } else {
                this.progress = this.mProgressTotalPart;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            int i2 = AnonymousClass2.$SwitchMap$com$baidu$mobads$container$components$CircleTextProgressbar$ProgressType[this.mProgressType.ordinal()];
            if (i2 == 1) {
                this.progress++;
            } else if (i2 == 2) {
                this.progress--;
            }
            int i3 = this.progress;
            if (i3 >= 0 && i3 <= this.mProgressTotalPart) {
                OnCountdownProgressListener onCountdownProgressListener = this.mCountdownProgressListener;
                if (onCountdownProgressListener != null) {
                    onCountdownProgressListener.onProgress(i3);
                }
                postInvalidate();
                return;
            }
            this.progress = validateProgress(this.progress);
            OnCountdownProgressListener onCountdownProgressListener2 = this.mCountdownProgressListener;
            if (onCountdownProgressListener2 != null) {
                onCountdownProgressListener2.onEnd();
            }
            stop();
        }
    }

    private void validateCircleColor() {
        int colorForState;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.circleColor == (colorForState = this.inCircleColors.getColorForState(getDrawableState(), 0))) {
            return;
        }
        this.circleColor = colorForState;
        invalidate();
    }

    private int validateProgress(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, this, i2)) == null) {
            int i3 = this.mProgressTotalPart;
            if (i2 > i3) {
                return i3;
            }
            if (i2 < 0) {
                return 0;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.drawableStateChanged();
            validateCircleColor();
        }
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.progress : invokeV.intValue;
    }

    public ProgressType getProgressType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mProgressType : (ProgressType) invokeV.objValue;
    }

    public long getTimeMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.timeMillis : invokeV.longValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            getDrawingRect(this.bounds);
            float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.outLineColor);
            this.mPaint.setAlpha(127);
            canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.outLineWidth, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.outLineColor);
            this.mPaint.setStrokeWidth(this.progressLineWidth);
            this.mPaint.setStrokeCap(Paint.Cap.ROUND);
            this.mPaint.setAlpha(204);
            canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.progressLineWidth / 2), this.mPaint);
            TextPaint paint = getPaint();
            paint.setColor(getCurrentTextColor());
            paint.setAntiAlias(true);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
            this.mPaint.setColor(this.progressLineColor);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.progressLineWidth);
            this.mPaint.setStrokeCap(Paint.Cap.ROUND);
            this.mPaint.setAlpha(204);
            RectF rectF = this.mArcRect;
            int i2 = this.bounds.left;
            int i3 = this.progressLineWidth;
            rectF.set(i2 + (i3 / 2), rect.top + (i3 / 2), rect.right - (i3 / 2), rect.bottom - (i3 / 2));
            canvas.drawArc(this.mArcRect, 270.0f, (this.progress * 360) / this.mProgressTotalPart, false, this.mPaint);
        }
    }

    public void reStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            resetProgress();
            start();
        }
    }

    public void setCountdownProgressListener(OnCountdownProgressListener onCountdownProgressListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onCountdownProgressListener) == null) {
            this.mCountdownProgressListener = onCountdownProgressListener;
        }
    }

    public void setInCircleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.inCircleColors = ColorStateList.valueOf(i2);
            invalidate();
        }
    }

    public void setOutLineColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.outLineColor = i2;
            invalidate();
        }
    }

    public void setOutLineWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.outLineWidth = i2;
            invalidate();
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.progress = validateProgress(i2);
            invalidate();
        }
    }

    public void setProgressColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.progressLineColor = i2;
            invalidate();
        }
    }

    public void setProgressLineWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.progressLineWidth = i2;
            invalidate();
        }
    }

    public void setProgressTotalPart(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.mProgressTotalPart = i2;
            resetProgress();
        }
    }

    public void setProgressType(ProgressType progressType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, progressType) == null) {
            this.mProgressType = progressType;
            resetProgress();
            invalidate();
        }
    }

    public void setTimeMillis(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            this.timeMillis = j;
            invalidate();
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            stop();
            executeTimer();
        }
    }

    public void stop() {
        BaseTask baseTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (baseTask = this.mBaseTask) == null) {
            return;
        }
        baseTask.cancel();
        this.mBaseTask = null;
    }

    public void updateProgres(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048594, this, i2, i3) == null) {
            this.progress = (this.mProgressTotalPart * i3) / i2;
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleTextProgressbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleTextProgressbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.outLineColor = -16777216;
        this.outLineWidth = 2;
        this.inCircleColors = ColorStateList.valueOf(0);
        this.progressLineColor = -16776961;
        this.progressLineWidth = 8;
        this.mPaint = new Paint();
        this.mArcRect = new RectF();
        this.mProgressTotalPart = 100;
        this.progress = 100;
        this.mProgressType = ProgressType.COUNT_BACK;
        this.timeMillis = 3000L;
        this.bounds = new Rect();
        initialize(context, attributeSet);
    }
}

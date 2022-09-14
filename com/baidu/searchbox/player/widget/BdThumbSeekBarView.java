package com.baidu.searchbox.player.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BdThumbSeekBarView extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUFFERING_PAINT_COLOR = -2039584;
    public static final float DEFAULT_MAX = 100.0f;
    public static final int PLAYED_PAINT_COLOR = -16738561;
    public static final boolean SEEKBAR_SCALE_FLAG = true;
    public static final String TAG = "BdThumbSeekBarView";
    public static final int UI_DRAG_TRACE_COLOR = -2130706433;
    public static final int UI_SEEKBAR_DEFAULT_PADDING = 0;
    public static final int UI_SEEKBAR_DEFAULT_WIDTH = 50;
    public static final int UI_SEEKBAR_RIGHT_PADDING = 5;
    public static final int UI_SEEKBAR_SELECT_HEGHT = 3;
    public static final int UI_SEEKBAR_THUMB_PADDING = 0;
    public static final int UI_SEEKBAR_TRACE_HEIGHT = 1;
    public static final int UI_SELECT_COLOR_START = -16366706;
    public static final float UI_THUMB_SCALE = 1.5f;
    public static final int UI_TRACE_COLOR = 1291845632;
    public static final int UI_TRANSLATE_Y = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final Paint mBufferingPaint;
    public int mBufferingProgress;
    public final int mDefaultWidth;
    public SeekBarDirect mDirect;
    public final RectF mDrawRectF;
    public boolean mIsDragable;
    public OnBdSeekBarChangeListener mListener;
    public float mMax;
    public boolean mNeedThumbScale;
    public final Paint mPaint;
    public float mProgress;
    public BdSeeBarStatus mSeeBarStatus;
    public final Paint mSeekPaint;
    public LinearGradient mSeekShader;
    public final BdSeekBarStyle mStyle;
    public Bitmap mThumb;
    public final int mThumbPadding;
    public Bitmap mThumbScale;
    public final int mUIRightSpace;
    public final int mUISelectHeight;
    public final int mUISpace;
    public final int mUITraceHeight;

    /* renamed from: com.baidu.searchbox.player.widget.BdThumbSeekBarView$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$player$widget$BdThumbSeekBarView$BdSeekBarStyle;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1206824213, "Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1206824213, "Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView$1;");
                    return;
                }
            }
            int[] iArr = new int[BdSeekBarStyle.values().length];
            $SwitchMap$com$baidu$searchbox$player$widget$BdThumbSeekBarView$BdSeekBarStyle = iArr;
            try {
                iArr[BdSeekBarStyle.LINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$player$widget$BdThumbSeekBarView$BdSeekBarStyle[BdSeekBarStyle.ROUND_RECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class BdSeeBarStatus {
        public static final /* synthetic */ BdSeeBarStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BdSeeBarStatus None;
        public static final BdSeeBarStatus Seek;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1444464826, "Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView$BdSeeBarStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1444464826, "Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView$BdSeeBarStatus;");
                    return;
                }
            }
            None = new BdSeeBarStatus("None", 0);
            BdSeeBarStatus bdSeeBarStatus = new BdSeeBarStatus("Seek", 1);
            Seek = bdSeeBarStatus;
            $VALUES = new BdSeeBarStatus[]{None, bdSeeBarStatus};
        }

        public BdSeeBarStatus(String str, int i) {
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

        public static BdSeeBarStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BdSeeBarStatus) Enum.valueOf(BdSeeBarStatus.class, str) : (BdSeeBarStatus) invokeL.objValue;
        }

        public static BdSeeBarStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BdSeeBarStatus[]) $VALUES.clone() : (BdSeeBarStatus[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class BdSeekBarStyle {
        public static final /* synthetic */ BdSeekBarStyle[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BdSeekBarStyle LINE;
        public static final BdSeekBarStyle ROUND_RECT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(537660066, "Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView$BdSeekBarStyle;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(537660066, "Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView$BdSeekBarStyle;");
                    return;
                }
            }
            LINE = new BdSeekBarStyle("LINE", 0);
            BdSeekBarStyle bdSeekBarStyle = new BdSeekBarStyle("ROUND_RECT", 1);
            ROUND_RECT = bdSeekBarStyle;
            $VALUES = new BdSeekBarStyle[]{LINE, bdSeekBarStyle};
        }

        public BdSeekBarStyle(String str, int i) {
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

        public static BdSeekBarStyle valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BdSeekBarStyle) Enum.valueOf(BdSeekBarStyle.class, str) : (BdSeekBarStyle) invokeL.objValue;
        }

        public static BdSeekBarStyle[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BdSeekBarStyle[]) $VALUES.clone() : (BdSeekBarStyle[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface OnBdSeekBarChangeListener {
        void onProgressChanged(BdThumbSeekBarView bdThumbSeekBarView, int i, boolean z);

        void onStartTrackingTouch(BdThumbSeekBarView bdThumbSeekBarView);

        void onStopTrackingTouch(BdThumbSeekBarView bdThumbSeekBarView);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class SeekBarDirect {
        public static final /* synthetic */ SeekBarDirect[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SeekBarDirect Horizontal;
        public static final SeekBarDirect Vertical;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1468283432, "Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView$SeekBarDirect;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1468283432, "Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView$SeekBarDirect;");
                    return;
                }
            }
            Vertical = new SeekBarDirect("Vertical", 0);
            SeekBarDirect seekBarDirect = new SeekBarDirect("Horizontal", 1);
            Horizontal = seekBarDirect;
            $VALUES = new SeekBarDirect[]{Vertical, seekBarDirect};
        }

        public SeekBarDirect(String str, int i) {
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

        public static SeekBarDirect valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SeekBarDirect) Enum.valueOf(SeekBarDirect.class, str) : (SeekBarDirect) invokeL.objValue;
        }

        public static SeekBarDirect[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SeekBarDirect[]) $VALUES.clone() : (SeekBarDirect[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBarView(Context context, int i) {
        this(context, BdSeekBarStyle.LINE, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (BdSeekBarStyle) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void computeDrawRect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            int i = AnonymousClass1.$SwitchMap$com$baidu$searchbox$player$widget$BdThumbSeekBarView$BdSeekBarStyle[this.mStyle.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                this.mDrawRectF.top = (((getMeasuredHeight() - this.mUISelectHeight) + getPaddingTop()) - getPaddingBottom()) >> 1;
                RectF rectF = this.mDrawRectF;
                rectF.bottom = rectF.top + this.mUISelectHeight;
            } else if (this.mDirect == SeekBarDirect.Horizontal) {
                this.mDrawRectF.left = getPaddingLeft();
                this.mDrawRectF.right = getMeasuredWidth() - getPaddingRight();
                this.mDrawRectF.top = (((getMeasuredHeight() - this.mUITraceHeight) + getPaddingTop()) - getPaddingBottom()) >> 1;
                RectF rectF2 = this.mDrawRectF;
                rectF2.bottom = rectF2.top + this.mUITraceHeight;
            } else {
                this.mDrawRectF.top = getPaddingTop();
                this.mDrawRectF.bottom = getMeasuredHeight() - getPaddingBottom();
                this.mDrawRectF.left = (((getMeasuredWidth() - this.mUITraceHeight) + getPaddingLeft()) - getPaddingRight()) >> 1;
                RectF rectF3 = this.mDrawRectF;
                rectF3.right = rectF3.left + this.mUITraceHeight;
            }
        }
    }

    private int measureHeight(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i)) == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int height = this.mThumb.getHeight() + getPaddingTop() + getPaddingBottom();
            if (mode == Integer.MIN_VALUE) {
                if (height > size) {
                    scaleThumb(((size - getPaddingTop()) - getPaddingBottom()) / this.mThumb.getHeight());
                    return size;
                }
            } else if (mode == 1073741824) {
                if (height > size) {
                    scaleThumb(((size - getPaddingTop()) - getPaddingBottom()) / this.mThumb.getHeight());
                    return size;
                }
                return size;
            }
            return height;
        }
        return invokeI.intValue;
    }

    private int measureWidth(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i)) == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int width = this.mThumb.getWidth() + getPaddingLeft() + getPaddingRight();
            int i2 = this.mDefaultWidth;
            int i3 = width + i2;
            if (mode == Integer.MIN_VALUE) {
                if (i3 - i2 > size) {
                    scaleThumb(((size - getPaddingLeft()) - getPaddingRight()) / this.mThumb.getWidth());
                    return size;
                }
            } else if (mode == 1073741824) {
                if (i3 - i2 > size) {
                    scaleThumb(((size - getPaddingLeft()) - getPaddingRight()) / this.mThumb.getHeight());
                    return size;
                }
                return size;
            }
            return i3;
        }
        return invokeI.intValue;
    }

    private void scaleThumb(float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(65545, this, f) == null) || f <= 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        Bitmap bitmap = this.mThumb;
        this.mThumbScale = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.mThumb.getHeight(), matrix, true);
    }

    private void specifyPadding() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            int paddingLeft = getPaddingLeft();
            if (paddingLeft <= 0) {
                paddingLeft = this.mUISpace;
            }
            int paddingTop = getPaddingTop();
            if (paddingTop <= 0) {
                paddingTop = this.mUISpace;
            }
            int paddingRight = getPaddingRight();
            if (paddingRight <= 0) {
                if (this.mNeedThumbScale) {
                    paddingRight = this.mUISpace + this.mUIRightSpace;
                } else {
                    paddingRight = this.mUISpace;
                }
            }
            int paddingBottom = getPaddingBottom();
            if (paddingBottom <= 0) {
                paddingBottom = this.mUISpace;
            }
            setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public float getMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mMax : invokeV.floatValue;
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (int) this.mProgress : invokeV.intValue;
    }

    public boolean isDragble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mIsDragable : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0182  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDraw(Canvas canvas) {
        float width;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            int i = AnonymousClass1.$SwitchMap$com$baidu$searchbox$player$widget$BdThumbSeekBarView$BdSeekBarStyle[this.mStyle.ordinal()];
            if (i == 1) {
                if (this.mNeedThumbScale) {
                    this.mPaint.setColor(UI_DRAG_TRACE_COLOR);
                }
                canvas.drawRect(this.mDrawRectF, this.mPaint);
                RectF rectF = this.mDrawRectF;
                float f = rectF.left;
                float abs = Math.abs(rectF.right - f);
                RectF rectF2 = this.mDrawRectF;
                float abs2 = Math.abs(rectF2.top - rectF2.bottom);
                if (this.mDirect == SeekBarDirect.Horizontal) {
                    float f2 = this.mMax > 0.1f ? (this.mBufferingProgress * abs) / 100.0f : 0.0f;
                    RectF rectF3 = this.mDrawRectF;
                    rectF3.right = rectF3.left + f2;
                } else {
                    float f3 = this.mMax > 0.1f ? this.mBufferingProgress : 0.0f;
                    RectF rectF4 = this.mDrawRectF;
                    rectF4.top = rectF4.bottom - f3;
                }
                canvas.drawRect(this.mDrawRectF, this.mBufferingPaint);
                if (this.mDirect == SeekBarDirect.Horizontal) {
                    float f4 = this.mMax;
                    r1 = f4 > 0.1f ? (this.mProgress * abs) / f4 : 0.0f;
                    RectF rectF5 = this.mDrawRectF;
                    rectF5.right = rectF5.left + r1;
                } else {
                    float f5 = this.mMax;
                    r1 = f5 > 0.1f ? (this.mProgress * abs2) / f5 : 0.0f;
                    RectF rectF6 = this.mDrawRectF;
                    rectF6.top = rectF6.bottom - r1;
                }
                canvas.drawRect(this.mDrawRectF, this.mSeekPaint);
                if (this.mNeedThumbScale) {
                    if (this.mDirect == SeekBarDirect.Horizontal) {
                        int width2 = (int) (this.mDrawRectF.right - (this.mThumb.getWidth() >> 1));
                        int i2 = this.mThumbPadding;
                        if (width2 < (-i2) + f) {
                            width = (-i2) + f;
                        } else {
                            float f6 = abs + f;
                            if ((this.mThumb.getWidth() + width2) - this.mThumbPadding > f6) {
                                width = (f6 - this.mThumb.getWidth()) + this.mThumbPadding;
                            }
                            if (this.mSeeBarStatus != BdSeeBarStatus.Seek) {
                                canvas.drawBitmap(this.mThumbScale, width2, ((((getMeasuredHeight() - this.mThumbScale.getHeight()) + getPaddingTop()) - getPaddingBottom()) >> 1) + ((int) (0 * 1.5f)), (Paint) null);
                            } else {
                                canvas.drawBitmap(this.mThumb, Math.max(width2, -this.mThumbPadding), ((((getMeasuredHeight() - this.mThumb.getHeight()) + getPaddingTop()) - getPaddingBottom()) >> 1) + 0, (Paint) null);
                            }
                        }
                        width2 = (int) width;
                        if (this.mSeeBarStatus != BdSeeBarStatus.Seek) {
                        }
                    } else {
                        int height = (int) (this.mDrawRectF.top - (this.mThumb.getHeight() >> 1));
                        if (this.mSeeBarStatus == BdSeeBarStatus.Seek) {
                            canvas.drawBitmap(this.mThumbScale, (((getMeasuredWidth() - this.mThumbScale.getWidth()) + getPaddingLeft()) - getPaddingRight()) >> 1, height, (Paint) null);
                        } else {
                            canvas.drawBitmap(this.mThumb, (((getMeasuredWidth() - this.mThumb.getWidth()) + getPaddingLeft()) - getPaddingRight()) >> 1, height, (Paint) null);
                        }
                    }
                }
            } else if (i == 2) {
                this.mPaint.setColor(UI_TRACE_COLOR);
                RectF rectF7 = this.mDrawRectF;
                int i3 = this.mUISelectHeight;
                canvas.drawRoundRect(rectF7, i3 >> 1, i3, this.mPaint);
                this.mPaint.setColor(UI_SELECT_COLOR_START);
                float f7 = this.mMax;
                if (f7 > 0.1f) {
                    float f8 = this.mProgress;
                    RectF rectF8 = this.mDrawRectF;
                    r1 = (f8 * (rectF8.right - rectF8.left)) / f7;
                }
                RectF rectF9 = this.mDrawRectF;
                rectF9.right = rectF9.left + r1;
                int i4 = this.mUISelectHeight;
                canvas.drawRoundRect(rectF9, i4 >> 1, i4, this.mPaint);
                Bitmap bitmap = this.mThumb;
                canvas.drawBitmap(bitmap, this.mDrawRectF.right - (bitmap.getWidth() >> 1), (int) (this.mDrawRectF.top + ((this.mUISelectHeight - this.mThumb.getHeight()) >> 1)), (Paint) null);
            }
            computeDrawRect();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            specifyPadding();
            setMeasuredDimension(measureWidth(i), measureHeight(i2));
            computeDrawRect();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
        if (r6 != 3) goto L23;
     */
    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            if (this.mIsDragable) {
                if (this.mDirect == SeekBarDirect.Horizontal) {
                    float x = motionEvent.getX();
                    RectF rectF = this.mDrawRectF;
                    float f = rectF.left;
                    if (x < f) {
                        x = f;
                    } else {
                        float f2 = rectF.right;
                        if (x > f2) {
                            x = f2;
                        }
                    }
                    RectF rectF2 = this.mDrawRectF;
                    float f3 = rectF2.left;
                    setProgress(((x - f3) * this.mMax) / (rectF2.right - f3));
                } else {
                    float y = motionEvent.getY();
                    RectF rectF3 = this.mDrawRectF;
                    float f4 = rectF3.top;
                    if (y < f4) {
                        y = f4;
                    } else {
                        float f5 = rectF3.bottom;
                        if (y > f5) {
                            y = f5;
                        }
                    }
                    RectF rectF4 = this.mDrawRectF;
                    float f6 = rectF4.bottom;
                    setProgress(((f6 - y) * this.mMax) / (f6 - rectF4.top));
                }
                OnBdSeekBarChangeListener onBdSeekBarChangeListener = this.mListener;
                if (onBdSeekBarChangeListener != null) {
                    this.mSeeBarStatus = BdSeeBarStatus.Seek;
                    onBdSeekBarChangeListener.onProgressChanged(this, (int) this.mProgress, true);
                }
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    OnBdSeekBarChangeListener onBdSeekBarChangeListener2 = this.mListener;
                    if (onBdSeekBarChangeListener2 != null) {
                        onBdSeekBarChangeListener2.onStopTrackingTouch(this);
                        this.mSeeBarStatus = BdSeeBarStatus.None;
                    }
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    OnBdSeekBarChangeListener onBdSeekBarChangeListener3 = this.mListener;
                    if (onBdSeekBarChangeListener3 != null) {
                        onBdSeekBarChangeListener3.onStartTrackingTouch(this);
                        this.mSeeBarStatus = BdSeeBarStatus.Seek;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                invalidate();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setBufferColor(int i) {
        Paint paint;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || (paint = this.mBufferingPaint) == null) {
            return;
        }
        paint.setColor(i);
    }

    public void setBufferingProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.mBufferingProgress = i;
        }
    }

    public void setDragable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.mIsDragable = z;
        }
    }

    public void setMax(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f) == null) {
            this.mMax = f;
        }
    }

    public void setMaxDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            setMax(i);
        }
    }

    public void setOnSeekBarChangeListener(OnBdSeekBarChangeListener onBdSeekBarChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onBdSeekBarChangeListener) == null) {
            this.mListener = onBdSeekBarChangeListener;
        }
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            setProgress(i);
        }
    }

    public void setProgressBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.mPaint.setColor(i);
        }
    }

    public void setProgressColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.mSeekPaint.setColor(i);
        }
    }

    public void setScaleThumbBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bitmap) == null) {
            this.mThumbScale = bitmap;
        }
    }

    public void setSeekBarDirect(SeekBarDirect seekBarDirect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, seekBarDirect) == null) {
            this.mDirect = seekBarDirect;
        }
    }

    public void setThumbBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bitmap) == null) {
            this.mThumb = bitmap;
        }
    }

    public void setThumbScaleVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mNeedThumbScale = z;
        }
    }

    public void syncPos(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048597, this, i, i2, i3) == null) {
            setMax(i2);
            setBufferingProgress(i3);
            setProgress(i);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, BdSeekBarStyle.LINE, 1);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (BdSeekBarStyle) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void setProgress(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f) == null) {
            this.mProgress = f;
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBarView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, BdSeekBarStyle.LINE, 1);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (BdSeekBarStyle) objArr2[3], ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBarView(Context context, BdSeekBarStyle bdSeekBarStyle, int i) {
        this(context, null, bdSeekBarStyle, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdSeekBarStyle, Integer.valueOf(i)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (BdSeekBarStyle) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
    }

    public void syncPos(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i, i2) == null) {
            setBufferingProgress(i2);
            setProgress(i);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBarView(Context context, AttributeSet attributeSet, BdSeekBarStyle bdSeekBarStyle, int i) {
        this(context, attributeSet, 0, bdSeekBarStyle, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, bdSeekBarStyle, Integer.valueOf(i)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (BdSeekBarStyle) objArr2[3], ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBarView(Context context, AttributeSet attributeSet, int i, BdSeekBarStyle bdSeekBarStyle, int i2) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), bdSeekBarStyle, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mSeeBarStatus = BdSeeBarStatus.None;
        this.mNeedThumbScale = true;
        this.mDirect = SeekBarDirect.Horizontal;
        this.mIsDragable = true;
        setClickable(true);
        this.mStyle = bdSeekBarStyle;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(R.color.obfuscated_res_0x7f06041c));
        Paint paint2 = new Paint();
        this.mSeekPaint = paint2;
        paint2.setAntiAlias(true);
        this.mSeekPaint.setColor(getResources().getColor(R.color.obfuscated_res_0x7f06041e));
        Paint paint3 = new Paint();
        this.mBufferingPaint = paint3;
        paint3.setAntiAlias(true);
        this.mBufferingPaint.setColor(getResources().getColor(R.color.obfuscated_res_0x7f06041d));
        this.mMax = 100.0f;
        this.mProgress = 0.0f;
        this.mBufferingProgress = 0;
        if (this.mThumb == null) {
            this.mThumb = BitmapFactory.decodeResource(context.getResources(), R.drawable.obfuscated_res_0x7f080217);
        }
        this.mThumbPadding = BdPlayerUtils.dp2px(this, 0.0f);
        if (this.mThumbScale == null) {
            scaleThumb(1.5f);
        }
        this.mDrawRectF = new RectF();
        float f = getResources().getDisplayMetrics().density;
        this.mUISpace = (int) (0.0f * f);
        this.mUIRightSpace = (int) (5.0f * f);
        this.mUITraceHeight = (int) ((i2 * f) + 0.5d);
        this.mDefaultWidth = (int) (50.0f * f);
        this.mUISelectHeight = (int) (f * 3.0f);
        BdVideoLog.d(TAG, "mUITraceHeight: " + this.mUITraceHeight);
    }
}

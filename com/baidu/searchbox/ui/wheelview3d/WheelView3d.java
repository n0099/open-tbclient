package com.baidu.searchbox.ui.wheelview3d;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.ui.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.ui.wheelview3d.adapter.WheelAdapter;
import com.baidu.searchbox.ui.wheelview3d.interfaces.IPickerViewData;
import com.baidu.searchbox.ui.wheelview3d.listener.LoopViewGestureListener;
import com.baidu.searchbox.ui.wheelview3d.listener.OnItemSelectedListener;
import com.baidu.searchbox.ui.wheelview3d.timer.InertiaTimerTask;
import com.baidu.searchbox.ui.wheelview3d.timer.MessageHandler;
import com.baidu.searchbox.ui.wheelview3d.timer.SmoothScrollTimerTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class WheelView3d extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float DEFAULT_TEXT_TARGET_SKEWX = 0.5f;
    public static final float SCALE_CONTENT = 0.8f;
    public static final int VELOCITY_FLING = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public WheelAdapter adapter;
    public float centerContentOffset;
    public float centerY;
    public int change;
    public Context context;
    public int dividerColor;
    public DividerType dividerType;
    public int drawCenterContentStart;
    public int drawOutContentStart;
    public float firstLineY;
    public GestureDetector gestureDetector;
    public Handler handler;
    public int initPosition;
    public boolean isCenterLabel;
    public boolean isLoop;
    public boolean isOptions;
    public float itemHeight;
    public int itemsVisible;
    public String label;
    public float lineSpacingMultiplier;
    public ScheduledExecutorService mExecutor;
    public ScheduledFuture<?> mFuture;
    public int mGravity;
    public int mOffset;
    public int maxTextHeight;
    public int maxTextWidth;
    public int measuredHeight;
    public int measuredWidth;
    public OnItemSelectedListener onItemSelectedListener;
    public Paint paintCenterText;
    public Paint paintIndicator;
    public Paint paintOuterText;
    public int preCurrentIndex;
    public float previousY;
    public int radius;
    public float secondLineY;
    public int selectedItem;
    public long startTime;
    public int textColorCenter;
    public int textColorOut;
    public int textSize;
    public int textXOffset;
    public float totalScrollY;
    public Typeface typeface;
    public int widthMeasureSpec;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class ACTION {
        public static final /* synthetic */ ACTION[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ACTION CLICK;
        public static final ACTION DAGGLE;
        public static final ACTION FLING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1394310963, "Lcom/baidu/searchbox/ui/wheelview3d/WheelView3d$ACTION;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1394310963, "Lcom/baidu/searchbox/ui/wheelview3d/WheelView3d$ACTION;");
                    return;
                }
            }
            CLICK = new ACTION("CLICK", 0);
            FLING = new ACTION("FLING", 1);
            ACTION action = new ACTION("DAGGLE", 2);
            DAGGLE = action;
            $VALUES = new ACTION[]{CLICK, FLING, action};
        }

        public ACTION(String str, int i2) {
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

        public static ACTION valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ACTION) Enum.valueOf(ACTION.class, str) : (ACTION) invokeL.objValue;
        }

        public static ACTION[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ACTION[]) $VALUES.clone() : (ACTION[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class DividerType {
        public static final /* synthetic */ DividerType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DividerType FILL;
        public static final DividerType WRAP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1215585050, "Lcom/baidu/searchbox/ui/wheelview3d/WheelView3d$DividerType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1215585050, "Lcom/baidu/searchbox/ui/wheelview3d/WheelView3d$DividerType;");
                    return;
                }
            }
            FILL = new DividerType("FILL", 0);
            DividerType dividerType = new DividerType("WRAP", 1);
            WRAP = dividerType;
            $VALUES = new DividerType[]{FILL, dividerType};
        }

        public DividerType(String str, int i2) {
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

        public static DividerType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DividerType) Enum.valueOf(DividerType.class, str) : (DividerType) invokeL.objValue;
        }

        public static DividerType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DividerType[]) $VALUES.clone() : (DividerType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WheelView3d(Context context) {
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

    private String getContentText(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, obj)) == null) {
            if (obj == null) {
                return "";
            }
            if (obj instanceof IPickerViewData) {
                return ((IPickerViewData) obj).getPickerViewText();
            }
            return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
        }
        return (String) invokeL.objValue;
    }

    private int getLoopMappingIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2)) == null) {
            if (i2 < 0) {
                return getLoopMappingIndex(i2 + this.adapter.getItemsCount());
            }
            return i2 > this.adapter.getItemsCount() + (-1) ? getLoopMappingIndex(i2 - this.adapter.getItemsCount()) : i2;
        }
        return invokeI.intValue;
    }

    private void initLoopView(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context) == null) {
            this.context = context;
            this.handler = new MessageHandler(this);
            GestureDetector gestureDetector = new GestureDetector(context, new LoopViewGestureListener(this));
            this.gestureDetector = gestureDetector;
            gestureDetector.setIsLongpressEnabled(false);
            this.isLoop = true;
            this.totalScrollY = 0.0f;
            this.initPosition = -1;
            initPaints();
        }
    }

    private void initPaints() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            Paint paint = new Paint();
            this.paintOuterText = paint;
            paint.setColor(this.textColorOut);
            this.paintOuterText.setAntiAlias(true);
            this.paintOuterText.setTypeface(this.typeface);
            this.paintOuterText.setTextSize(this.textSize);
            Paint paint2 = new Paint();
            this.paintCenterText = paint2;
            paint2.setColor(this.textColorCenter);
            this.paintCenterText.setAntiAlias(true);
            this.paintCenterText.setTextScaleX(1.1f);
            this.paintCenterText.setTypeface(this.typeface);
            this.paintCenterText.setTextSize(this.textSize);
            Paint paint3 = new Paint();
            this.paintIndicator = paint3;
            paint3.setColor(this.dividerColor);
            this.paintIndicator.setAntiAlias(true);
            setLayerType(1, null);
        }
    }

    private void judgeLineSpace() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            float f2 = this.lineSpacingMultiplier;
            if (f2 < 1.0f) {
                this.lineSpacingMultiplier = 1.0f;
            } else if (f2 > 4.0f) {
                this.lineSpacingMultiplier = 4.0f;
            }
        }
    }

    private void measureTextWidthHeight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            Rect rect = new Rect();
            for (int i2 = 0; i2 < this.adapter.getItemsCount(); i2++) {
                String contentText = getContentText(this.adapter.getItem(i2));
                this.paintCenterText.getTextBounds(contentText, 0, contentText.length(), rect);
                int width = rect.width();
                if (width > this.maxTextWidth) {
                    this.maxTextWidth = width;
                }
                this.paintCenterText.getTextBounds("星期", 0, 2, rect);
                this.maxTextHeight = rect.height() + 2;
            }
            this.itemHeight = this.lineSpacingMultiplier * this.maxTextHeight;
        }
    }

    private void measuredCenterContentStart(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, str) == null) {
            Rect rect = new Rect();
            this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
            int i2 = this.mGravity;
            if (i2 == 3) {
                this.drawCenterContentStart = 0;
            } else if (i2 == 5) {
                this.drawCenterContentStart = (this.measuredWidth - rect.width()) - ((int) this.centerContentOffset);
            } else if (i2 != 17) {
            } else {
                if (!this.isOptions && (str2 = this.label) != null && !str2.equals("") && this.isCenterLabel) {
                    this.drawCenterContentStart = (int) ((this.measuredWidth - rect.width()) * 0.25d);
                } else {
                    this.drawCenterContentStart = (int) ((this.measuredWidth - rect.width()) * 0.5d);
                }
            }
        }
    }

    private void measuredOutContentStart(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, str) == null) {
            Rect rect = new Rect();
            this.paintOuterText.getTextBounds(str, 0, str.length(), rect);
            int i2 = this.mGravity;
            if (i2 == 3) {
                this.drawOutContentStart = 0;
            } else if (i2 == 5) {
                this.drawOutContentStart = (this.measuredWidth - rect.width()) - ((int) this.centerContentOffset);
            } else if (i2 != 17) {
            } else {
                if (!this.isOptions && (str2 = this.label) != null && !str2.equals("") && this.isCenterLabel) {
                    this.drawOutContentStart = (int) ((this.measuredWidth - rect.width()) * 0.25d);
                } else {
                    this.drawOutContentStart = (int) ((this.measuredWidth - rect.width()) * 0.5d);
                }
            }
        }
    }

    private void reMeasureTextSize(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, str) == null) {
            Rect rect = new Rect();
            this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
            int i2 = this.textSize;
            for (int width = rect.width(); width > this.measuredWidth; width = rect.width()) {
                i2--;
                this.paintCenterText.setTextSize(i2);
                this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
            }
            this.paintOuterText.setTextSize(i2);
        }
    }

    private void remeasure() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || this.adapter == null) {
            return;
        }
        measureTextWidthHeight();
        int i2 = (int) (this.itemHeight * (this.itemsVisible - 1));
        this.measuredHeight = (int) ((i2 * 2) / 3.141592653589793d);
        this.radius = (int) (i2 / 3.141592653589793d);
        this.measuredWidth = View.MeasureSpec.getSize(this.widthMeasureSpec);
        int i3 = this.measuredHeight;
        float f2 = this.itemHeight;
        this.firstLineY = (i3 - f2) / 2.0f;
        float f3 = (i3 + f2) / 2.0f;
        this.secondLineY = f3;
        this.centerY = (f3 - ((f2 - this.maxTextHeight) / 2.0f)) - this.centerContentOffset;
        if (this.initPosition == -1) {
            if (this.isLoop) {
                this.initPosition = (this.adapter.getItemsCount() + 1) / 2;
            } else {
                this.initPosition = 0;
            }
        }
        this.preCurrentIndex = this.initPosition;
    }

    public void cancelFuture() {
        ScheduledFuture<?> scheduledFuture;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (scheduledFuture = this.mFuture) == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.mFuture.cancel(true);
        this.mFuture = null;
    }

    public final WheelAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.adapter : (WheelAdapter) invokeV.objValue;
    }

    public final int getCurrentItem() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            WheelAdapter wheelAdapter = this.adapter;
            if (wheelAdapter == null) {
                return 0;
            }
            if (this.isLoop && ((i2 = this.selectedItem) < 0 || i2 >= wheelAdapter.getItemsCount())) {
                return Math.max(0, Math.min(Math.abs(Math.abs(this.selectedItem) - this.adapter.getItemsCount()), this.adapter.getItemsCount() - 1));
            }
            return Math.max(0, Math.min(this.selectedItem, this.adapter.getItemsCount() - 1));
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.handler : (Handler) invokeV.objValue;
    }

    public int getInitPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.initPosition : invokeV.intValue;
    }

    public float getItemHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.itemHeight : invokeV.floatValue;
    }

    public int getItemsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            WheelAdapter wheelAdapter = this.adapter;
            if (wheelAdapter != null) {
                return wheelAdapter.getItemsCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getTextWidth(Paint paint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, paint, str)) == null) {
            if (str == null || str.length() <= 0) {
                return 0;
            }
            int length = str.length();
            float[] fArr = new float[length];
            paint.getTextWidths(str, fArr);
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                i2 += (int) Math.ceil(fArr[i3]);
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    public float getTotalScrollY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.totalScrollY : invokeV.floatValue;
    }

    public void isCenterLabel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.isCenterLabel = z;
        }
    }

    public boolean isLoop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.isLoop : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, canvas) == null) || this.adapter == null) {
            return;
        }
        int min = Math.min(Math.max(0, this.initPosition), this.adapter.getItemsCount() - 1);
        this.initPosition = min;
        Object[] objArr = new Object[this.itemsVisible];
        int i3 = (int) (this.totalScrollY / this.itemHeight);
        this.change = i3;
        try {
            this.preCurrentIndex = min + (i3 % this.adapter.getItemsCount());
        } catch (ArithmeticException unused) {
        }
        if (!this.isLoop) {
            if (this.preCurrentIndex < 0) {
                this.preCurrentIndex = 0;
            }
            if (this.preCurrentIndex > this.adapter.getItemsCount() - 1) {
                this.preCurrentIndex = this.adapter.getItemsCount() - 1;
            }
        } else {
            if (this.preCurrentIndex < 0) {
                this.preCurrentIndex = this.adapter.getItemsCount() + this.preCurrentIndex;
            }
            if (this.preCurrentIndex > this.adapter.getItemsCount() - 1) {
                this.preCurrentIndex -= this.adapter.getItemsCount();
            }
        }
        float f2 = this.totalScrollY % this.itemHeight;
        int i4 = 0;
        while (true) {
            int i5 = this.itemsVisible;
            if (i4 >= i5) {
                break;
            }
            int i6 = this.preCurrentIndex - ((i5 / 2) - i4);
            if (this.isLoop) {
                objArr[i4] = this.adapter.getItem(getLoopMappingIndex(i6));
            } else if (i6 < 0) {
                objArr[i4] = "";
            } else if (i6 > this.adapter.getItemsCount() - 1) {
                objArr[i4] = "";
            } else {
                objArr[i4] = this.adapter.getItem(i6);
            }
            i4++;
        }
        if (this.dividerType == DividerType.WRAP) {
            if (TextUtils.isEmpty(this.label)) {
                i2 = (this.measuredWidth - this.maxTextWidth) / 2;
            } else {
                i2 = (this.measuredWidth - this.maxTextWidth) / 4;
            }
            float f3 = i2 - 12;
            float f4 = f3 <= 0.0f ? 10.0f : f3;
            float f5 = this.measuredWidth - f4;
            float f6 = this.firstLineY;
            float f7 = f4;
            canvas.drawLine(f7, f6, f5, f6, this.paintIndicator);
            float f8 = this.secondLineY;
            canvas.drawLine(f7, f8, f5, f8, this.paintIndicator);
        } else {
            float f9 = this.firstLineY;
            canvas.drawLine(0.0f, f9, this.measuredWidth, f9, this.paintIndicator);
            float f10 = this.secondLineY;
            canvas.drawLine(0.0f, f10, this.measuredWidth, f10, this.paintIndicator);
        }
        if (!TextUtils.isEmpty(this.label) && this.isCenterLabel) {
            canvas.drawText(this.label, (this.measuredWidth - getTextWidth(this.paintCenterText, this.label)) - this.centerContentOffset, this.centerY, this.paintCenterText);
        }
        for (int i7 = 0; i7 < this.itemsVisible; i7++) {
            canvas.save();
            double d2 = ((this.itemHeight * i7) - f2) / this.radius;
            float f11 = (float) (90.0d - ((d2 / 3.141592653589793d) * 180.0d));
            if (f11 < 90.0f && f11 > -90.0f) {
                float pow = (float) Math.pow(Math.abs(f11) / 90.0f, 2.2d);
                String contentText = (!this.isCenterLabel && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(getContentText(objArr[i7]))) ? getContentText(objArr[i7]) + this.label : getContentText(objArr[i7]);
                reMeasureTextSize(contentText);
                measuredCenterContentStart(contentText);
                measuredOutContentStart(contentText);
                float cos = (float) ((this.radius - (Math.cos(d2) * this.radius)) - ((Math.sin(d2) * this.maxTextHeight) / 2.0d));
                canvas.translate(0.0f, cos);
                float f12 = this.firstLineY;
                if (cos <= f12 && this.maxTextHeight + cos >= f12) {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.measuredWidth, this.firstLineY - cos);
                    canvas.scale(1.0f, ((float) Math.sin(d2)) * 0.8f);
                    canvas.drawText(contentText, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.firstLineY - cos, this.measuredWidth, (int) this.itemHeight);
                    canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                    canvas.drawText(contentText, this.drawCenterContentStart, this.maxTextHeight - this.centerContentOffset, this.paintCenterText);
                    canvas.restore();
                } else {
                    float f13 = this.secondLineY;
                    if (cos <= f13 && this.maxTextHeight + cos >= f13) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.measuredWidth, this.secondLineY - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                        canvas.drawText(contentText, this.drawCenterContentStart, this.maxTextHeight - this.centerContentOffset, this.paintCenterText);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.secondLineY - cos, this.measuredWidth, (int) this.itemHeight);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * 0.8f);
                        canvas.drawText(contentText, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                    } else {
                        if (cos >= this.firstLineY) {
                            int i8 = this.maxTextHeight;
                            if (i8 + cos <= this.secondLineY) {
                                canvas.drawText(contentText, this.drawCenterContentStart, i8 - this.centerContentOffset, this.paintCenterText);
                                this.selectedItem = this.preCurrentIndex - ((this.itemsVisible / 2) - i7);
                            }
                        }
                        canvas.save();
                        canvas.clipRect(0, 0, this.measuredWidth, (int) this.itemHeight);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * 0.8f);
                        Paint paint = this.paintOuterText;
                        int i9 = this.textXOffset;
                        paint.setTextSkewX((i9 == 0 ? 0 : i9 > 0 ? 1 : -1) * (f11 <= 0.0f ? 1 : -1) * 0.5f * pow);
                        this.paintOuterText.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(contentText, this.drawOutContentStart + (this.textXOffset * pow), this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                        canvas.restore();
                        this.paintCenterText.setTextSize(this.textSize);
                    }
                }
                canvas.restore();
                this.paintCenterText.setTextSize(this.textSize);
            } else {
                canvas.restore();
            }
        }
    }

    public final void onItemSelected() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.onItemSelectedListener == null) {
            return;
        }
        postDelayed(new Runnable(this) { // from class: com.baidu.searchbox.ui.wheelview3d.WheelView3d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WheelView3d this$0;

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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.onItemSelectedListener.onItemSelected(this.this$0.getCurrentItem());
                }
            }
        }, 200L);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
            this.widthMeasureSpec = i2;
            remeasure();
            setMeasuredDimension(this.measuredWidth, this.measuredHeight);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
            boolean onTouchEvent = this.gestureDetector.onTouchEvent(motionEvent);
            float f2 = (-this.initPosition) * this.itemHeight;
            float itemsCount = ((this.adapter.getItemsCount() - 1) - this.initPosition) * this.itemHeight;
            int action = motionEvent.getAction();
            boolean z = false;
            if (action == 0) {
                this.startTime = System.currentTimeMillis();
                cancelFuture();
                this.previousY = motionEvent.getRawY();
            } else if (action == 2) {
                float rawY = this.previousY - motionEvent.getRawY();
                this.previousY = motionEvent.getRawY();
                float f3 = this.totalScrollY + rawY;
                this.totalScrollY = f3;
                if (!this.isLoop && ((f3 - (this.itemHeight * 0.25f) < f2 && rawY < 0.0f) || (this.totalScrollY + (this.itemHeight * 0.25f) > itemsCount && rawY > 0.0f))) {
                    this.totalScrollY -= rawY;
                    z = true;
                }
            } else if (!onTouchEvent) {
                float y = motionEvent.getY();
                int i2 = this.radius;
                float f4 = this.itemHeight;
                this.mOffset = (int) (((((int) (((Math.acos((i2 - y) / i2) * this.radius) + (f4 / 2.0f)) / f4)) - (this.itemsVisible / 2)) * f4) - (((this.totalScrollY % f4) + f4) % f4));
                if (System.currentTimeMillis() - this.startTime > 120) {
                    smoothScroll(ACTION.DAGGLE);
                } else {
                    smoothScroll(ACTION.CLICK);
                }
            }
            if (!z && motionEvent.getAction() != 0) {
                invalidate();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void scrollBy(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048591, this, f2) == null) {
            cancelFuture();
            this.mFuture = this.mExecutor.scheduleWithFixedDelay(new InertiaTimerTask(this, f2), 0L, 5L, TimeUnit.MILLISECONDS);
        }
    }

    public final void setAdapter(WheelAdapter wheelAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, wheelAdapter) == null) {
            this.adapter = wheelAdapter;
            remeasure();
            invalidate();
        }
    }

    public final void setCurrentItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.selectedItem = i2;
            this.initPosition = i2;
            this.totalScrollY = 0.0f;
            invalidate();
        }
    }

    public final void setCyclic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.isLoop = z;
        }
    }

    public void setDividerColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.dividerColor = i2;
            this.paintIndicator.setColor(i2);
        }
    }

    public void setDividerType(DividerType dividerType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, dividerType) == null) {
            this.dividerType = dividerType;
        }
    }

    public void setGravity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.mGravity = i2;
        }
    }

    public void setIsOptions(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.isOptions = z;
        }
    }

    public void setLabel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.label = str;
        }
    }

    public void setLineSpacingMultiplier(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048600, this, f2) == null) || f2 == 0.0f) {
            return;
        }
        this.lineSpacingMultiplier = f2;
        judgeLineSpace();
    }

    public final void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onItemSelectedListener) == null) {
            this.onItemSelectedListener = onItemSelectedListener;
        }
    }

    public void setTextColorCenter(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.textColorCenter = i2;
            this.paintCenterText.setColor(i2);
        }
    }

    public void setTextColorOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.textColorOut = i2;
            this.paintOuterText.setColor(i2);
        }
    }

    public final void setTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            float f2 = i2;
            if (f2 > 0.0f) {
                this.textSize = i2;
                this.paintOuterText.setTextSize(f2);
                this.paintCenterText.setTextSize(f2);
            }
        }
    }

    public void setTextXOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.textXOffset = i2;
            if (i2 != 0) {
                this.paintCenterText.setTextScaleX(1.0f);
            }
        }
    }

    public void setTotalScrollY(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048606, this, f2) == null) {
            this.totalScrollY = f2;
        }
    }

    public final void setTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, typeface) == null) {
            this.typeface = typeface;
            this.paintOuterText.setTypeface(typeface);
            this.paintCenterText.setTypeface(this.typeface);
        }
    }

    public void smoothScroll(ACTION action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, action) == null) {
            cancelFuture();
            if (action == ACTION.FLING || action == ACTION.DAGGLE) {
                float f2 = this.totalScrollY;
                float f3 = this.itemHeight;
                int i2 = (int) (((f2 % f3) + f3) % f3);
                this.mOffset = i2;
                if (i2 > f3 / 2.0f) {
                    this.mOffset = (int) (f3 - i2);
                } else {
                    this.mOffset = -i2;
                }
            }
            this.mFuture = this.mExecutor.scheduleWithFixedDelay(new SmoothScrollTimerTask(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WheelView3d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isOptions = false;
        this.isCenterLabel = true;
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.typeface = Typeface.MONOSPACE;
        this.lineSpacingMultiplier = 1.6f;
        this.itemsVisible = 5;
        this.mOffset = 0;
        this.previousY = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.drawCenterContentStart = 0;
        this.drawOutContentStart = 0;
        this.textSize = 20;
        float f2 = getResources().getDisplayMetrics().density;
        if (f2 < 1.0f) {
            this.centerContentOffset = 2.4f;
        } else {
            int i4 = (1.0f > f2 ? 1 : (1.0f == f2 ? 0 : -1));
            if (i4 <= 0 && f2 < 2.0f) {
                this.centerContentOffset = 3.6f;
            } else if (i4 <= 0 && f2 < 2.0f) {
                this.centerContentOffset = 4.5f;
            } else if (2.0f <= f2 && f2 < 3.0f) {
                this.centerContentOffset = 6.0f;
            } else if (f2 >= 3.0f) {
                this.centerContentOffset = f2 * 2.5f;
            }
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(R.styleable.pickerview_wheelview_gravity, 17);
            this.textColorOut = obtainStyledAttributes.getColor(R.styleable.pickerview_wheelview_textColorOut, -5723992);
            this.textColorCenter = obtainStyledAttributes.getColor(R.styleable.pickerview_wheelview_textColorCenter, -14013910);
            this.dividerColor = obtainStyledAttributes.getColor(R.styleable.pickerview_wheelview_dividerColor, -2763307);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.pickerview_wheelview_textSize, this.textSize);
            this.lineSpacingMultiplier = obtainStyledAttributes.getFloat(R.styleable.pickerview_wheelview_lineSpacingMultiplier, this.lineSpacingMultiplier);
            obtainStyledAttributes.recycle();
        }
        judgeLineSpace();
        initLoopView(context);
    }
}

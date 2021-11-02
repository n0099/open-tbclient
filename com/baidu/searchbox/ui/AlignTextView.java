package com.baidu.searchbox.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes7.dex */
public class AlignTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Align mAlign;
    public boolean mFirstCalc;
    public float mLineSpacingAdd;
    public float mLineSpacingMultiplier;
    public List<String> mLines;
    public int mOriginalHeight;
    public int mOriginalLineCount;
    public int mOriginalPaddingBottom;
    public boolean mSetPaddingFromMe;
    public List<Integer> mTailLines;
    public float mTextHeight;
    public float mTextLineSpaceExtra;
    public int mWidth;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Align {
        public static final /* synthetic */ Align[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Align ALIGN_CENTER;
        public static final Align ALIGN_LEFT;
        public static final Align ALIGN_RIGHT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(622457892, "Lcom/baidu/searchbox/ui/AlignTextView$Align;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(622457892, "Lcom/baidu/searchbox/ui/AlignTextView$Align;");
                    return;
                }
            }
            ALIGN_LEFT = new Align("ALIGN_LEFT", 0);
            ALIGN_CENTER = new Align("ALIGN_CENTER", 1);
            Align align = new Align("ALIGN_RIGHT", 2);
            ALIGN_RIGHT = align;
            $VALUES = new Align[]{ALIGN_LEFT, ALIGN_CENTER, align};
        }

        public Align(String str, int i2) {
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

        public static Align valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Align) Enum.valueOf(Align.class, str) : (Align) invokeL.objValue;
        }

        public static Align[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Align[]) $VALUES.clone() : (Align[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlignTextView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTextLineSpaceExtra = 0.0f;
        this.mLines = new ArrayList();
        this.mTailLines = new ArrayList();
        this.mAlign = Align.ALIGN_LEFT;
        this.mFirstCalc = true;
        this.mLineSpacingMultiplier = 1.0f;
        this.mLineSpacingAdd = 0.0f;
        this.mOriginalHeight = 0;
        this.mOriginalLineCount = 0;
        this.mOriginalPaddingBottom = 0;
        this.mSetPaddingFromMe = false;
        setTextIsSelectable(false);
    }

    private void calc(Paint paint, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, paint, str) == null) {
            if (str.length() == 0) {
                this.mLines.add(StringUtils.LF);
                return;
            }
            int measureText = (int) (this.mWidth / paint.measureText("中"));
            int i2 = measureText + 1;
            int i3 = 0;
            StringBuilder sb = new StringBuilder(str.substring(0, Math.min(i2, str.length())));
            while (true) {
                if (i2 >= str.length()) {
                    break;
                }
                if (paint.measureText(str.substring(i3, i2 + 1)) > this.mWidth) {
                    this.mLines.add(sb.toString());
                    sb = new StringBuilder();
                    if (str.length() - i2 > measureText) {
                        int i4 = i2 + measureText;
                        sb.append(str.substring(i2, i4));
                        i3 = i2;
                        i2 = i4 - 1;
                    } else {
                        this.mLines.add(str.substring(i2));
                        break;
                    }
                } else {
                    sb.append(str.charAt(i2));
                }
                i2++;
            }
            if (sb.length() > 0) {
                this.mLines.add(sb.toString());
            }
            this.mTailLines.add(Integer.valueOf(this.mLines.size() - 1));
        }
    }

    private void measureTextViewHeight(String str, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{str, Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            TextView textView = new TextView(getContext());
            textView.setText(str);
            textView.setTextSize(0, f2);
            textView.measure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.mOriginalLineCount = textView.getLineCount();
            this.mOriginalHeight = textView.getMeasuredHeight();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0095, code lost:
        if (r14 == com.baidu.searchbox.ui.AlignTextView.Align.ALIGN_RIGHT) goto L14;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            TextPaint paint = getPaint();
            paint.setColor(getCurrentTextColor());
            paint.drawableState = getDrawableState();
            this.mWidth = getMeasuredWidth();
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float textSize = getTextSize() - (((fontMetrics.bottom - fontMetrics.descent) + fontMetrics.ascent) - fontMetrics.top);
            float f2 = 2.0f;
            if ((getGravity() & 16) == 16) {
                textSize += (this.mTextHeight - textSize) / 2.0f;
            }
            int paddingTop = getPaddingTop();
            int paddingLeft = getPaddingLeft();
            this.mWidth = (this.mWidth - paddingLeft) - getPaddingRight();
            int i2 = 0;
            int i3 = 0;
            while (i3 < this.mLines.size()) {
                float f3 = i3;
                float f4 = (this.mTextHeight * f3) + textSize;
                String str = this.mLines.get(i3);
                float f5 = paddingLeft;
                float measureText = this.mWidth - paint.measureText(str);
                float length = measureText / (str.length() - 1);
                if (this.mTailLines.contains(Integer.valueOf(i3))) {
                    length = 0.0f;
                    Align align = this.mAlign;
                    if (align == Align.ALIGN_CENTER) {
                        measureText /= f2;
                    }
                    f5 += measureText;
                }
                int i4 = 0;
                while (i4 < str.length()) {
                    int i5 = i4 + 1;
                    canvas.drawText(str.substring(i4, i5), paint.measureText(str.substring(i2, i4)) + (i4 * length) + f5, paddingTop + f4 + (this.mTextLineSpaceExtra * f3), paint);
                    i4 = i5;
                    i2 = 0;
                }
                i3++;
                f2 = 2.0f;
                i2 = 0;
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (this.mFirstCalc) {
                this.mWidth = getMeasuredWidth();
                String charSequence = getText().toString();
                TextPaint paint = getPaint();
                this.mLines.clear();
                this.mTailLines.clear();
                for (String str : charSequence.split("\\n")) {
                    calc(paint, str);
                }
                measureTextViewHeight(charSequence, paint.getTextSize(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
                float f2 = (this.mOriginalHeight * 1.0f) / this.mOriginalLineCount;
                this.mTextHeight = f2;
                float f3 = ((this.mLineSpacingMultiplier - 1.0f) * f2) + this.mLineSpacingAdd;
                this.mTextLineSpaceExtra = f3;
                this.mSetPaddingFromMe = true;
                setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), this.mOriginalPaddingBottom + ((int) ((f3 + f2) * (this.mLines.size() - this.mOriginalLineCount))));
                this.mFirstCalc = false;
            }
        }
    }

    public void setAlign(Align align) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, align) == null) {
            this.mAlign = align;
            invalidate();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) {
            if (!this.mSetPaddingFromMe) {
                this.mOriginalPaddingBottom = i5;
            }
            this.mSetPaddingFromMe = false;
            super.setPadding(i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, charSequence, bufferType) == null) {
            this.mFirstCalc = true;
            super.setText(charSequence, bufferType);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlignTextView(Context context, AttributeSet attributeSet) {
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
        this.mTextLineSpaceExtra = 0.0f;
        this.mLines = new ArrayList();
        this.mTailLines = new ArrayList();
        this.mAlign = Align.ALIGN_LEFT;
        this.mFirstCalc = true;
        this.mLineSpacingMultiplier = 1.0f;
        this.mLineSpacingAdd = 0.0f;
        this.mOriginalHeight = 0;
        this.mOriginalLineCount = 0;
        this.mOriginalPaddingBottom = 0;
        this.mSetPaddingFromMe = false;
        setTextIsSelectable(false);
        this.mLineSpacingMultiplier = attributeSet.getAttributeFloatValue("http://schemas.android.com/apk/res/android", "mLineSpacingMultiplier", 1.0f);
        this.mLineSpacingAdd = context.obtainStyledAttributes(attributeSet, new int[]{16843287}).getDimensionPixelSize(0, 0);
        this.mOriginalPaddingBottom = getPaddingBottom();
    }
}

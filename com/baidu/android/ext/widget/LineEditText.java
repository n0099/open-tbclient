package com.baidu.android.ext.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.EditText;
import com.baidu.searchbox.common.res.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class LineEditText extends EditText {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mDrawLineCount;
    public int mLeftZoneColor;
    public float mLeftZoneWidth;
    public int mLineColor;
    public float mLineSpace;
    public Paint mPaint;
    public Rect mRect;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LineEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDrawLineCount = 1;
        this.mLineSpace = 0.0f;
        initAttrs(context, attributeSet);
        this.mRect = new Rect();
        this.mPaint = new Paint();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, this, context, attributeSet) != null) || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.NovelLineEditView, 0, 0);
        try {
            this.mLineColor = obtainStyledAttributes.getColor(2, 0);
            this.mLeftZoneColor = obtainStyledAttributes.getColor(0, 0);
            this.mLeftZoneWidth = obtainStyledAttributes.getDimension(1, 0.0f);
            this.mLineSpace = obtainStyledAttributes.getDimension(3, 0.0f);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.mDrawLineCount = getHeight() / getLineHeight();
            int lineCount = getLineCount();
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mLeftZoneColor);
            canvas.drawRect(0.0f, 0.0f, this.mLeftZoneWidth, getMeasuredHeight() + 1, this.mPaint);
            this.mPaint.setColor(this.mLineColor);
            float f = this.mLeftZoneWidth;
            canvas.drawLine(f, 0.0f, f, getMeasuredHeight(), this.mPaint);
            int i = 0;
            for (int i2 = 0; i2 < lineCount; i2++) {
                float lineBounds = getLineBounds(i2, this.mRect);
                canvas.drawLine(0.0f, lineBounds + this.mLineSpace, getMeasuredWidth(), lineBounds + this.mLineSpace, this.mPaint);
            }
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mLineColor);
            if (lineCount < this.mDrawLineCount) {
                if (lineCount > 0) {
                    i = getLineBounds(lineCount - 1, this.mRect);
                }
                for (int i3 = 1; i3 < this.mDrawLineCount; i3++) {
                    float lineHeight = (getLineHeight() * i3) + i;
                    canvas.drawLine(0.0f, lineHeight + this.mLineSpace, getMeasuredWidth(), lineHeight + this.mLineSpace, this.mPaint);
                }
            }
            super.onDraw(canvas);
        }
    }
}

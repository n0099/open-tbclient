package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class MockView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mDiagonalsColor;
    public boolean mDrawDiagonals;
    public boolean mDrawLabel;
    public int mMargin;
    public Paint mPaintDiagonals;
    public Paint mPaintText;
    public Paint mPaintTextBackground;
    public String mText;
    public int mTextBackgroundColor;
    public Rect mTextBounds;
    public int mTextColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MockView(Context context) {
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
        this.mPaintDiagonals = new Paint();
        this.mPaintText = new Paint();
        this.mPaintTextBackground = new Paint();
        this.mDrawDiagonals = true;
        this.mDrawLabel = true;
        this.mText = null;
        this.mTextBounds = new Rect();
        this.mDiagonalsColor = Color.argb(255, 0, 0, 0);
        this.mTextColor = Color.argb(255, 200, 200, 200);
        this.mTextBackgroundColor = Color.argb(255, 50, 50, 50);
        this.mMargin = 4;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, context, attributeSet) == null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MockView);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = obtainStyledAttributes.getIndex(i);
                    if (index == 1) {
                        this.mText = obtainStyledAttributes.getString(index);
                    } else if (index == 4) {
                        this.mDrawDiagonals = obtainStyledAttributes.getBoolean(index, this.mDrawDiagonals);
                    } else if (index == 0) {
                        this.mDiagonalsColor = obtainStyledAttributes.getColor(index, this.mDiagonalsColor);
                    } else if (index == 2) {
                        this.mTextBackgroundColor = obtainStyledAttributes.getColor(index, this.mTextBackgroundColor);
                    } else if (index == 3) {
                        this.mTextColor = obtainStyledAttributes.getColor(index, this.mTextColor);
                    } else if (index == 5) {
                        this.mDrawLabel = obtainStyledAttributes.getBoolean(index, this.mDrawLabel);
                    }
                }
                obtainStyledAttributes.recycle();
            }
            if (this.mText == null) {
                try {
                    this.mText = context.getResources().getResourceEntryName(getId());
                } catch (Exception unused) {
                }
            }
            this.mPaintDiagonals.setColor(this.mDiagonalsColor);
            this.mPaintDiagonals.setAntiAlias(true);
            this.mPaintText.setColor(this.mTextColor);
            this.mPaintText.setAntiAlias(true);
            this.mPaintTextBackground.setColor(this.mTextBackgroundColor);
            this.mMargin = Math.round(this.mMargin * (getResources().getDisplayMetrics().xdpi / 160.0f));
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.onDraw(canvas);
            int width = getWidth();
            int height = getHeight();
            if (this.mDrawDiagonals) {
                width--;
                height--;
                float f = width;
                float f2 = height;
                canvas.drawLine(0.0f, 0.0f, f, f2, this.mPaintDiagonals);
                canvas.drawLine(0.0f, f2, f, 0.0f, this.mPaintDiagonals);
                canvas.drawLine(0.0f, 0.0f, f, 0.0f, this.mPaintDiagonals);
                canvas.drawLine(f, 0.0f, f, f2, this.mPaintDiagonals);
                canvas.drawLine(f, f2, 0.0f, f2, this.mPaintDiagonals);
                canvas.drawLine(0.0f, f2, 0.0f, 0.0f, this.mPaintDiagonals);
            }
            String str = this.mText;
            if (str == null || !this.mDrawLabel) {
                return;
            }
            this.mPaintText.getTextBounds(str, 0, str.length(), this.mTextBounds);
            float width2 = (width - this.mTextBounds.width()) / 2.0f;
            float height2 = ((height - this.mTextBounds.height()) / 2.0f) + this.mTextBounds.height();
            this.mTextBounds.offset((int) width2, (int) height2);
            Rect rect = this.mTextBounds;
            int i = rect.left;
            int i2 = this.mMargin;
            rect.set(i - i2, rect.top - i2, rect.right + i2, rect.bottom + i2);
            canvas.drawRect(this.mTextBounds, this.mPaintTextBackground);
            canvas.drawText(this.mText, width2, height2, this.mPaintText);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MockView(Context context, AttributeSet attributeSet) {
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
        this.mPaintDiagonals = new Paint();
        this.mPaintText = new Paint();
        this.mPaintTextBackground = new Paint();
        this.mDrawDiagonals = true;
        this.mDrawLabel = true;
        this.mText = null;
        this.mTextBounds = new Rect();
        this.mDiagonalsColor = Color.argb(255, 0, 0, 0);
        this.mTextColor = Color.argb(255, 200, 200, 200);
        this.mTextBackgroundColor = Color.argb(255, 50, 50, 50);
        this.mMargin = 4;
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MockView(Context context, AttributeSet attributeSet, int i) {
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
        this.mPaintDiagonals = new Paint();
        this.mPaintText = new Paint();
        this.mPaintTextBackground = new Paint();
        this.mDrawDiagonals = true;
        this.mDrawLabel = true;
        this.mText = null;
        this.mTextBounds = new Rect();
        this.mDiagonalsColor = Color.argb(255, 0, 0, 0);
        this.mTextColor = Color.argb(255, 200, 200, 200);
        this.mTextBackgroundColor = Color.argb(255, 50, 50, 50);
        this.mMargin = 4;
        init(context, attributeSet);
    }
}

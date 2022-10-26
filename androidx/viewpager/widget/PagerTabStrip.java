package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FULL_UNDERLINE_HEIGHT = 1;
    public static final int INDICATOR_HEIGHT = 3;
    public static final int MIN_PADDING_BOTTOM = 6;
    public static final int MIN_STRIP_HEIGHT = 32;
    public static final int MIN_TEXT_SPACING = 64;
    public static final int TAB_PADDING = 16;
    public static final int TAB_SPACING = 32;
    public static final String TAG = "PagerTabStrip";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mDrawFullUnderline;
    public boolean mDrawFullUnderlineSet;
    public int mFullUnderlineHeight;
    public boolean mIgnoreTap;
    public int mIndicatorColor;
    public int mIndicatorHeight;
    public float mInitialMotionX;
    public float mInitialMotionY;
    public int mMinPaddingBottom;
    public int mMinStripHeight;
    public int mMinTextSpacing;
    public int mTabAlpha;
    public int mTabPadding;
    public final Paint mTabPaint;
    public final Rect mTempRect;
    public int mTouchSlop;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PagerTabStrip(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerTabStrip(Context context, AttributeSet attributeSet) {
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
        this.mTabPaint = new Paint();
        this.mTempRect = new Rect();
        this.mTabAlpha = 255;
        this.mDrawFullUnderline = false;
        this.mDrawFullUnderlineSet = false;
        int i3 = this.mTextColor;
        this.mIndicatorColor = i3;
        this.mTabPaint.setColor(i3);
        float f = context.getResources().getDisplayMetrics().density;
        this.mIndicatorHeight = (int) ((3.0f * f) + 0.5f);
        this.mMinPaddingBottom = (int) ((6.0f * f) + 0.5f);
        this.mMinTextSpacing = (int) (64.0f * f);
        this.mTabPadding = (int) ((16.0f * f) + 0.5f);
        this.mFullUnderlineHeight = (int) ((1.0f * f) + 0.5f);
        this.mMinStripHeight = (int) ((f * 32.0f) + 0.5f);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.mPrevText.setFocusable(true);
        this.mPrevText.setOnClickListener(new View.OnClickListener(this) { // from class: androidx.viewpager.widget.PagerTabStrip.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PagerTabStrip this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    ViewPager viewPager = this.this$0.mPager;
                    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                }
            }
        });
        this.mNextText.setFocusable(true);
        this.mNextText.setOnClickListener(new View.OnClickListener(this) { // from class: androidx.viewpager.widget.PagerTabStrip.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PagerTabStrip this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    ViewPager viewPager = this.this$0.mPager;
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
            }
        });
        if (getBackground() == null) {
            this.mDrawFullUnderline = true;
        }
    }

    public boolean getDrawFullUnderline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mDrawFullUnderline;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public int getMinHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return Math.max(super.getMinHeight(), this.mMinStripHeight);
        }
        return invokeV.intValue;
    }

    public int getTabIndicatorColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mIndicatorColor;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.onDraw(canvas);
            int height = getHeight();
            int left = this.mCurrText.getLeft() - this.mTabPadding;
            int right = this.mCurrText.getRight() + this.mTabPadding;
            this.mTabPaint.setColor((this.mTabAlpha << 24) | (this.mIndicatorColor & 16777215));
            float f = height;
            canvas.drawRect(left, height - this.mIndicatorHeight, right, f, this.mTabPaint);
            if (this.mDrawFullUnderline) {
                this.mTabPaint.setColor((-16777216) | (this.mIndicatorColor & 16777215));
                canvas.drawRect(getPaddingLeft(), height - this.mFullUnderlineHeight, getWidth() - getPaddingRight(), f, this.mTabPaint);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0 && this.mIgnoreTap) {
                return false;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2 && (Math.abs(x - this.mInitialMotionX) > this.mTouchSlop || Math.abs(y - this.mInitialMotionY) > this.mTouchSlop)) {
                        this.mIgnoreTap = true;
                    }
                } else if (x < this.mCurrText.getLeft() - this.mTabPadding) {
                    ViewPager viewPager = this.mPager;
                    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                } else if (x > this.mCurrText.getRight() + this.mTabPadding) {
                    ViewPager viewPager2 = this.mPager;
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                }
            } else {
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                this.mIgnoreTap = false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.setBackgroundColor(i);
            if (!this.mDrawFullUnderlineSet) {
                if ((i & (-16777216)) == 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.mDrawFullUnderline = z;
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, drawable) == null) {
            super.setBackgroundDrawable(drawable);
            if (!this.mDrawFullUnderlineSet) {
                if (drawable == null) {
                    z = true;
                } else {
                    z = false;
                }
                this.mDrawFullUnderline = z;
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            super.setBackgroundResource(i);
            if (!this.mDrawFullUnderlineSet) {
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.mDrawFullUnderline = z;
            }
        }
    }

    public void setDrawFullUnderline(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.mDrawFullUnderline = z;
            this.mDrawFullUnderlineSet = true;
            invalidate();
        }
    }

    public void setTabIndicatorColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.mIndicatorColor = i;
            this.mTabPaint.setColor(i);
            invalidate();
        }
    }

    public void setTabIndicatorColorResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            setTabIndicatorColor(ContextCompat.getColor(getContext(), i));
        }
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            int i2 = this.mMinTextSpacing;
            if (i < i2) {
                i = i2;
            }
            super.setTextSpacing(i);
        }
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048585, this, i, i2, i3, i4) == null) {
            int i5 = this.mMinPaddingBottom;
            if (i4 < i5) {
                i4 = i5;
            }
            super.setPadding(i, i2, i3, i4);
        }
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void updateTextPositions(int i, float f, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Boolean.valueOf(z)}) == null) {
            Rect rect = this.mTempRect;
            int height = getHeight();
            int left = this.mCurrText.getLeft() - this.mTabPadding;
            int right = this.mCurrText.getRight() + this.mTabPadding;
            int i2 = height - this.mIndicatorHeight;
            rect.set(left, i2, right, height);
            super.updateTextPositions(i, f, z);
            this.mTabAlpha = (int) (Math.abs(f - 0.5f) * 2.0f * 255.0f);
            rect.union(this.mCurrText.getLeft() - this.mTabPadding, i2, this.mCurrText.getRight() + this.mTabPadding, height);
            invalidate(rect);
        }
    }
}

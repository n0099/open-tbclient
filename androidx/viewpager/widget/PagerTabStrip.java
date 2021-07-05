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
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    public PagerTabStrip(@NonNull Context context) {
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

    public boolean getDrawFullUnderline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDrawFullUnderline : invokeV.booleanValue;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public int getMinHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Math.max(super.getMinHeight(), this.mMinStripHeight) : invokeV.intValue;
    }

    @ColorInt
    public int getTabIndicatorColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mIndicatorColor : invokeV.intValue;
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
            float f2 = height;
            canvas.drawRect(left, height - this.mIndicatorHeight, right, f2, this.mTabPaint);
            if (this.mDrawFullUnderline) {
                this.mTabPaint.setColor((-16777216) | (this.mIndicatorColor & 16777215));
                canvas.drawRect(getPaddingLeft(), height - this.mFullUnderlineHeight, getWidth() - getPaddingRight(), f2, this.mTabPaint);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0 || !this.mIgnoreTap) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (action == 0) {
                    this.mInitialMotionX = x;
                    this.mInitialMotionY = y;
                    this.mIgnoreTap = false;
                } else if (action != 1) {
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
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.setBackgroundColor(i2);
            if (this.mDrawFullUnderlineSet) {
                return;
            }
            this.mDrawFullUnderline = (i2 & (-16777216)) == 0;
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, drawable) == null) {
            super.setBackgroundDrawable(drawable);
            if (this.mDrawFullUnderlineSet) {
                return;
            }
            this.mDrawFullUnderline = drawable == null;
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.setBackgroundResource(i2);
            if (this.mDrawFullUnderlineSet) {
                return;
            }
            this.mDrawFullUnderline = i2 == 0;
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

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048585, this, i2, i3, i4, i5) == null) {
            int i6 = this.mMinPaddingBottom;
            if (i5 < i6) {
                i5 = i6;
            }
            super.setPadding(i2, i3, i4, i5);
        }
    }

    public void setTabIndicatorColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.mIndicatorColor = i2;
            this.mTabPaint.setColor(i2);
            invalidate();
        }
    }

    public void setTabIndicatorColorResource(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            setTabIndicatorColor(ContextCompat.getColor(getContext(), i2));
        }
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            int i3 = this.mMinTextSpacing;
            if (i2 < i3) {
                i2 = i3;
            }
            super.setTextSpacing(i2);
        }
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void updateTextPositions(int i2, float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            Rect rect = this.mTempRect;
            int height = getHeight();
            int left = this.mCurrText.getLeft() - this.mTabPadding;
            int right = this.mCurrText.getRight() + this.mTabPadding;
            int i3 = height - this.mIndicatorHeight;
            rect.set(left, i3, right, height);
            super.updateTextPositions(i2, f2, z);
            this.mTabAlpha = (int) (Math.abs(f2 - 0.5f) * 2.0f * 255.0f);
            rect.union(this.mCurrText.getLeft() - this.mTabPadding, i3, this.mCurrText.getRight() + this.mTabPadding, height);
            invalidate(rect);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerTabStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        this.mTabPaint = new Paint();
        this.mTempRect = new Rect();
        this.mTabAlpha = 255;
        this.mDrawFullUnderline = false;
        this.mDrawFullUnderlineSet = false;
        int i4 = this.mTextColor;
        this.mIndicatorColor = i4;
        this.mTabPaint.setColor(i4);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mIndicatorHeight = (int) ((3.0f * f2) + 0.5f);
        this.mMinPaddingBottom = (int) ((6.0f * f2) + 0.5f);
        this.mMinTextSpacing = (int) (64.0f * f2);
        this.mTabPadding = (int) ((16.0f * f2) + 0.5f);
        this.mFullUnderlineHeight = (int) ((1.0f * f2) + 0.5f);
        this.mMinStripHeight = (int) ((f2 * 32.0f) + 0.5f);
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
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
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
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    ViewPager viewPager = this.this$0.mPager;
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
            }
        });
        if (getBackground() == null) {
            this.mDrawFullUnderline = true;
        }
    }
}

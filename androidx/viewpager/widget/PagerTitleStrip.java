package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Locale;
@ViewPager.DecorView
/* loaded from: classes.dex */
public class PagerTitleStrip extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] ATTRS;
    public static final float SIDE_ALPHA = 0.6f;
    public static final int[] TEXT_ATTRS;
    public static final int TEXT_SPACING = 16;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView mCurrText;
    public int mGravity;
    public int mLastKnownCurrentPage;
    public float mLastKnownPositionOffset;
    public TextView mNextText;
    public int mNonPrimaryAlpha;
    public final PageListener mPageListener;
    public ViewPager mPager;
    public TextView mPrevText;
    public int mScaledTextSpacing;
    public int mTextColor;
    public boolean mUpdatingPositions;
    public boolean mUpdatingText;
    public WeakReference<PagerAdapter> mWatchingAdapter;

    /* loaded from: classes.dex */
    public class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mScrollState;
        public final /* synthetic */ PagerTitleStrip this$0;

        public PageListener(PagerTitleStrip pagerTitleStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerTitleStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = pagerTitleStrip;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, viewPager, pagerAdapter, pagerAdapter2) == null) {
                this.this$0.updateAdapter(pagerAdapter, pagerAdapter2);
            }
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                PagerTitleStrip pagerTitleStrip = this.this$0;
                pagerTitleStrip.updateText(pagerTitleStrip.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
                float f2 = this.this$0.mLastKnownPositionOffset;
                if (f2 < 0.0f) {
                    f2 = 0.0f;
                }
                PagerTitleStrip pagerTitleStrip2 = this.this$0;
                pagerTitleStrip2.updateTextPositions(pagerTitleStrip2.mPager.getCurrentItem(), f2, true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.mScrollState = i2;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
                if (f2 > 0.5f) {
                    i2++;
                }
                this.this$0.updateTextPositions(i2, f2, false);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048580, this, i2) == null) && this.mScrollState == 0) {
                PagerTitleStrip pagerTitleStrip = this.this$0;
                pagerTitleStrip.updateText(pagerTitleStrip.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
                float f2 = this.this$0.mLastKnownPositionOffset;
                if (f2 < 0.0f) {
                    f2 = 0.0f;
                }
                PagerTitleStrip pagerTitleStrip2 = this.this$0;
                pagerTitleStrip2.updateTextPositions(pagerTitleStrip2.mPager.getCurrentItem(), f2, true);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Locale mLocale;

        public SingleLineAllCapsTransform(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mLocale = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, charSequence, view)) == null) {
                CharSequence transformation = super.getTransformation(charSequence, view);
                if (transformation != null) {
                    return transformation.toString().toUpperCase(this.mLocale);
                }
                return null;
            }
            return (CharSequence) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-647344328, "Landroidx/viewpager/widget/PagerTitleStrip;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-647344328, "Landroidx/viewpager/widget/PagerTitleStrip;");
                return;
            }
        }
        ATTRS = new int[]{16842804, 16842901, 16842904, 16842927};
        TEXT_ATTRS = new int[]{16843660};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PagerTitleStrip(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void setSingleLineAllCaps(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, textView) == null) {
            textView.setTransformationMethod(new SingleLineAllCapsTransform(textView.getContext()));
        }
    }

    public int getMinHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Drawable background = getBackground();
            if (background != null) {
                return background.getIntrinsicHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getTextSpacing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mScaledTextSpacing : invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onAttachedToWindow();
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                ViewPager viewPager = (ViewPager) parent;
                PagerAdapter adapter = viewPager.getAdapter();
                viewPager.setInternalPageChangeListener(this.mPageListener);
                viewPager.addOnAdapterChangeListener(this.mPageListener);
                this.mPager = viewPager;
                WeakReference<PagerAdapter> weakReference = this.mWatchingAdapter;
                updateAdapter(weakReference != null ? weakReference.get() : null, adapter);
                return;
            }
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            ViewPager viewPager = this.mPager;
            if (viewPager != null) {
                updateAdapter(viewPager.getAdapter(), null);
                this.mPager.setInternalPageChangeListener(null);
                this.mPager.removeOnAdapterChangeListener(this.mPageListener);
                this.mPager = null;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || this.mPager == null) {
            return;
        }
        float f2 = this.mLastKnownPositionOffset;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        updateTextPositions(this.mLastKnownCurrentPage, f2, true);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int max;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingTop, -2);
                int size = View.MeasureSpec.getSize(i2);
                int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, (int) (size * 0.2f), -2);
                this.mPrevText.measure(childMeasureSpec2, childMeasureSpec);
                this.mCurrText.measure(childMeasureSpec2, childMeasureSpec);
                this.mNextText.measure(childMeasureSpec2, childMeasureSpec);
                if (View.MeasureSpec.getMode(i3) == 1073741824) {
                    max = View.MeasureSpec.getSize(i3);
                } else {
                    max = Math.max(getMinHeight(), this.mCurrText.getMeasuredHeight() + paddingTop);
                }
                setMeasuredDimension(size, View.resolveSizeAndState(max, i3, this.mCurrText.getMeasuredState() << 16));
                return;
            }
            throw new IllegalStateException("Must measure with an exact width");
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.mUpdatingText) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mGravity = i2;
            requestLayout();
        }
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            int i2 = ((int) (f2 * 255.0f)) & 255;
            this.mNonPrimaryAlpha = i2;
            int i3 = (i2 << 24) | (this.mTextColor & 16777215);
            this.mPrevText.setTextColor(i3);
            this.mNextText.setTextColor(i3);
        }
    }

    public void setTextColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.mTextColor = i2;
            this.mCurrText.setTextColor(i2);
            int i3 = (this.mNonPrimaryAlpha << 24) | (this.mTextColor & 16777215);
            this.mPrevText.setTextColor(i3);
            this.mNextText.setTextColor(i3);
        }
    }

    public void setTextSize(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            this.mPrevText.setTextSize(i2, f2);
            this.mCurrText.setTextSize(i2, f2);
            this.mNextText.setTextSize(i2, f2);
        }
    }

    public void setTextSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.mScaledTextSpacing = i2;
            requestLayout();
        }
    }

    public void updateAdapter(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, pagerAdapter, pagerAdapter2) == null) {
            if (pagerAdapter != null) {
                pagerAdapter.unregisterDataSetObserver(this.mPageListener);
                this.mWatchingAdapter = null;
            }
            if (pagerAdapter2 != null) {
                pagerAdapter2.registerDataSetObserver(this.mPageListener);
                this.mWatchingAdapter = new WeakReference<>(pagerAdapter2);
            }
            ViewPager viewPager = this.mPager;
            if (viewPager != null) {
                this.mLastKnownCurrentPage = -1;
                this.mLastKnownPositionOffset = -1.0f;
                updateText(viewPager.getCurrentItem(), pagerAdapter2);
                requestLayout();
            }
        }
    }

    public void updateText(int i2, PagerAdapter pagerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i2, pagerAdapter) == null) {
            int count = pagerAdapter != null ? pagerAdapter.getCount() : 0;
            this.mUpdatingText = true;
            CharSequence charSequence = null;
            this.mPrevText.setText((i2 < 1 || pagerAdapter == null) ? null : pagerAdapter.getPageTitle(i2 - 1));
            this.mCurrText.setText((pagerAdapter == null || i2 >= count) ? null : pagerAdapter.getPageTitle(i2));
            int i3 = i2 + 1;
            if (i3 < count && pagerAdapter != null) {
                charSequence = pagerAdapter.getPageTitle(i3);
            }
            this.mNextText.setText(charSequence);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
            this.mPrevText.measure(makeMeasureSpec, makeMeasureSpec2);
            this.mCurrText.measure(makeMeasureSpec, makeMeasureSpec2);
            this.mNextText.measure(makeMeasureSpec, makeMeasureSpec2);
            this.mLastKnownCurrentPage = i2;
            if (!this.mUpdatingPositions) {
                updateTextPositions(i2, this.mLastKnownPositionOffset, false);
            }
            this.mUpdatingText = false;
        }
    }

    public void updateTextPositions(int i2, float f2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            if (i2 != this.mLastKnownCurrentPage) {
                updateText(i2, this.mPager.getAdapter());
            } else if (!z && f2 == this.mLastKnownPositionOffset) {
                return;
            }
            this.mUpdatingPositions = true;
            int measuredWidth = this.mPrevText.getMeasuredWidth();
            int measuredWidth2 = this.mCurrText.getMeasuredWidth();
            int measuredWidth3 = this.mNextText.getMeasuredWidth();
            int i7 = measuredWidth2 / 2;
            int width = getWidth();
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int i8 = paddingRight + i7;
            int i9 = (width - (paddingLeft + i7)) - i8;
            float f3 = 0.5f + f2;
            if (f3 > 1.0f) {
                f3 -= 1.0f;
            }
            int i10 = ((width - i8) - ((int) (i9 * f3))) - i7;
            int i11 = measuredWidth2 + i10;
            int baseline = this.mPrevText.getBaseline();
            int baseline2 = this.mCurrText.getBaseline();
            int baseline3 = this.mNextText.getBaseline();
            int max = Math.max(Math.max(baseline, baseline2), baseline3);
            int i12 = max - baseline;
            int i13 = max - baseline2;
            int i14 = max - baseline3;
            int max2 = Math.max(Math.max(this.mPrevText.getMeasuredHeight() + i12, this.mCurrText.getMeasuredHeight() + i13), this.mNextText.getMeasuredHeight() + i14);
            int i15 = this.mGravity & 112;
            if (i15 == 16) {
                i3 = (((height - paddingTop) - paddingBottom) - max2) / 2;
            } else if (i15 != 80) {
                i4 = i12 + paddingTop;
                i5 = i13 + paddingTop;
                i6 = paddingTop + i14;
                TextView textView = this.mCurrText;
                textView.layout(i10, i5, i11, textView.getMeasuredHeight() + i5);
                int min = Math.min(paddingLeft, (i10 - this.mScaledTextSpacing) - measuredWidth);
                TextView textView2 = this.mPrevText;
                textView2.layout(min, i4, measuredWidth + min, textView2.getMeasuredHeight() + i4);
                int max3 = Math.max((width - paddingRight) - measuredWidth3, i11 + this.mScaledTextSpacing);
                TextView textView3 = this.mNextText;
                textView3.layout(max3, i6, max3 + measuredWidth3, textView3.getMeasuredHeight() + i6);
                this.mLastKnownPositionOffset = f2;
                this.mUpdatingPositions = false;
            } else {
                i3 = (height - paddingBottom) - max2;
            }
            i4 = i12 + i3;
            i5 = i13 + i3;
            i6 = i3 + i14;
            TextView textView4 = this.mCurrText;
            textView4.layout(i10, i5, i11, textView4.getMeasuredHeight() + i5);
            int min2 = Math.min(paddingLeft, (i10 - this.mScaledTextSpacing) - measuredWidth);
            TextView textView22 = this.mPrevText;
            textView22.layout(min2, i4, measuredWidth + min2, textView22.getMeasuredHeight() + i4);
            int max32 = Math.max((width - paddingRight) - measuredWidth3, i11 + this.mScaledTextSpacing);
            TextView textView32 = this.mNextText;
            textView32.layout(max32, i6, max32 + measuredWidth3, textView32.getMeasuredHeight() + i6);
            this.mLastKnownPositionOffset = f2;
            this.mUpdatingPositions = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerTitleStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mLastKnownCurrentPage = -1;
        this.mLastKnownPositionOffset = -1.0f;
        this.mPageListener = new PageListener(this);
        TextView textView = new TextView(context);
        this.mPrevText = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.mCurrText = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.mNextText = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        boolean z = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            TextViewCompat.setTextAppearance(this.mPrevText, resourceId);
            TextViewCompat.setTextAppearance(this.mCurrText, resourceId);
            TextViewCompat.setTextAppearance(this.mNextText, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.mPrevText.setTextColor(color);
            this.mCurrText.setTextColor(color);
            this.mNextText.setTextColor(color);
        }
        this.mGravity = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.mPrevText.setEllipsize(TextUtils.TruncateAt.END);
        this.mCurrText.setEllipsize(TextUtils.TruncateAt.END);
        this.mNextText.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, TEXT_ATTRS);
            z = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.mPrevText);
            setSingleLineAllCaps(this.mCurrText);
            setSingleLineAllCaps(this.mNextText);
        } else {
            this.mPrevText.setSingleLine();
            this.mCurrText.setSingleLine();
            this.mNextText.setSingleLine();
        }
        this.mScaledTextSpacing = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }
}

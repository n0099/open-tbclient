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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = pagerTitleStrip;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.mScrollState = i;
            }
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
                float f = this.this$0.mLastKnownPositionOffset;
                if (f < 0.0f) {
                    f = 0.0f;
                }
                PagerTitleStrip pagerTitleStrip2 = this.this$0;
                pagerTitleStrip2.updateTextPositions(pagerTitleStrip2.mPager.getCurrentItem(), f, true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
                if (f > 0.5f) {
                    i++;
                }
                this.this$0.updateTextPositions(i, f, false);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && this.mScrollState == 0) {
                PagerTitleStrip pagerTitleStrip = this.this$0;
                pagerTitleStrip.updateText(pagerTitleStrip.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
                float f = this.this$0.mLastKnownPositionOffset;
                if (f < 0.0f) {
                    f = 0.0f;
                }
                PagerTitleStrip pagerTitleStrip2 = this.this$0;
                pagerTitleStrip2.updateTextPositions(pagerTitleStrip2.mPager.getCurrentItem(), f, true);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mLocale = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, charSequence, view2)) == null) {
                CharSequence transformation = super.getTransformation(charSequence, view2);
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

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        PagerAdapter pagerAdapter;
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
                if (weakReference != null) {
                    pagerAdapter = weakReference.get();
                } else {
                    pagerAdapter = null;
                }
                updateAdapter(pagerAdapter, adapter);
                return;
            }
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public static void setSingleLineAllCaps(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, textView) == null) {
            textView.setTransformationMethod(new SingleLineAllCapsTransform(textView.getContext()));
        }
    }

    public void setGravity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f) == null) {
            int i = ((int) (f * 255.0f)) & 255;
            this.mNonPrimaryAlpha = i;
            int i2 = (i << 24) | (this.mTextColor & 16777215);
            this.mPrevText.setTextColor(i2);
            this.mNextText.setTextColor(i2);
        }
    }

    public void setTextColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.mTextColor = i;
            this.mCurrText.setTextColor(i);
            int i2 = (this.mNonPrimaryAlpha << 24) | (this.mTextColor & 16777215);
            this.mPrevText.setTextColor(i2);
            this.mNextText.setTextColor(i2);
        }
    }

    public void setTextSpacing(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.mScaledTextSpacing = i;
            requestLayout();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mScaledTextSpacing;
        }
        return invokeV.intValue;
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

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && !this.mUpdatingText) {
            super.requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && this.mPager != null) {
            float f = this.mLastKnownPositionOffset;
            if (f < 0.0f) {
                f = 0.0f;
            }
            updateTextPositions(this.mLastKnownCurrentPage, f, true);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int max;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            if (View.MeasureSpec.getMode(i) == 1073741824) {
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
                int size = View.MeasureSpec.getSize(i);
                int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i, (int) (size * 0.2f), -2);
                this.mPrevText.measure(childMeasureSpec2, childMeasureSpec);
                this.mCurrText.measure(childMeasureSpec2, childMeasureSpec);
                this.mNextText.measure(childMeasureSpec2, childMeasureSpec);
                if (View.MeasureSpec.getMode(i2) == 1073741824) {
                    max = View.MeasureSpec.getSize(i2);
                } else {
                    max = Math.max(getMinHeight(), this.mCurrText.getMeasuredHeight() + paddingTop);
                }
                setMeasuredDimension(size, View.resolveSizeAndState(max, i2, this.mCurrText.getMeasuredState() << 16));
                return;
            }
            throw new IllegalStateException("Must measure with an exact width");
        }
    }

    public void setTextSize(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            this.mPrevText.setTextSize(i, f);
            this.mCurrText.setTextSize(i, f);
            this.mNextText.setTextSize(i, f);
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

    public void updateText(int i, PagerAdapter pagerAdapter) {
        int i2;
        CharSequence charSequence;
        CharSequence charSequence2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i, pagerAdapter) == null) {
            if (pagerAdapter != null) {
                i2 = pagerAdapter.getCount();
            } else {
                i2 = 0;
            }
            this.mUpdatingText = true;
            CharSequence charSequence3 = null;
            if (i >= 1 && pagerAdapter != null) {
                charSequence = pagerAdapter.getPageTitle(i - 1);
            } else {
                charSequence = null;
            }
            this.mPrevText.setText(charSequence);
            TextView textView = this.mCurrText;
            if (pagerAdapter != null && i < i2) {
                charSequence2 = pagerAdapter.getPageTitle(i);
            } else {
                charSequence2 = null;
            }
            textView.setText(charSequence2);
            int i3 = i + 1;
            if (i3 < i2 && pagerAdapter != null) {
                charSequence3 = pagerAdapter.getPageTitle(i3);
            }
            this.mNextText.setText(charSequence3);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
            this.mPrevText.measure(makeMeasureSpec, makeMeasureSpec2);
            this.mCurrText.measure(makeMeasureSpec, makeMeasureSpec2);
            this.mNextText.measure(makeMeasureSpec, makeMeasureSpec2);
            this.mLastKnownCurrentPage = i;
            if (!this.mUpdatingPositions) {
                updateTextPositions(i, this.mLastKnownPositionOffset, false);
            }
            this.mUpdatingText = false;
        }
    }

    public void updateTextPositions(int i, float f, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Boolean.valueOf(z)}) == null) {
            if (i != this.mLastKnownCurrentPage) {
                updateText(i, this.mPager.getAdapter());
            } else if (!z && f == this.mLastKnownPositionOffset) {
                return;
            }
            this.mUpdatingPositions = true;
            int measuredWidth = this.mPrevText.getMeasuredWidth();
            int measuredWidth2 = this.mCurrText.getMeasuredWidth();
            int measuredWidth3 = this.mNextText.getMeasuredWidth();
            int i6 = measuredWidth2 / 2;
            int width = getWidth();
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int i7 = paddingRight + i6;
            int i8 = (width - (paddingLeft + i6)) - i7;
            float f2 = 0.5f + f;
            if (f2 > 1.0f) {
                f2 -= 1.0f;
            }
            int i9 = ((width - i7) - ((int) (i8 * f2))) - i6;
            int i10 = measuredWidth2 + i9;
            int baseline = this.mPrevText.getBaseline();
            int baseline2 = this.mCurrText.getBaseline();
            int baseline3 = this.mNextText.getBaseline();
            int max = Math.max(Math.max(baseline, baseline2), baseline3);
            int i11 = max - baseline;
            int i12 = max - baseline2;
            int i13 = max - baseline3;
            int max2 = Math.max(Math.max(this.mPrevText.getMeasuredHeight() + i11, this.mCurrText.getMeasuredHeight() + i12), this.mNextText.getMeasuredHeight() + i13);
            int i14 = this.mGravity & 112;
            if (i14 != 16) {
                if (i14 != 80) {
                    i3 = i11 + paddingTop;
                    i4 = i12 + paddingTop;
                    i5 = paddingTop + i13;
                    TextView textView = this.mCurrText;
                    textView.layout(i9, i4, i10, textView.getMeasuredHeight() + i4);
                    int min = Math.min(paddingLeft, (i9 - this.mScaledTextSpacing) - measuredWidth);
                    TextView textView2 = this.mPrevText;
                    textView2.layout(min, i3, measuredWidth + min, textView2.getMeasuredHeight() + i3);
                    int max3 = Math.max((width - paddingRight) - measuredWidth3, i10 + this.mScaledTextSpacing);
                    TextView textView3 = this.mNextText;
                    textView3.layout(max3, i5, max3 + measuredWidth3, textView3.getMeasuredHeight() + i5);
                    this.mLastKnownPositionOffset = f;
                    this.mUpdatingPositions = false;
                }
                i2 = (height - paddingBottom) - max2;
            } else {
                i2 = (((height - paddingTop) - paddingBottom) - max2) / 2;
            }
            i3 = i11 + i2;
            i4 = i12 + i2;
            i5 = i2 + i13;
            TextView textView4 = this.mCurrText;
            textView4.layout(i9, i4, i10, textView4.getMeasuredHeight() + i4);
            int min2 = Math.min(paddingLeft, (i9 - this.mScaledTextSpacing) - measuredWidth);
            TextView textView22 = this.mPrevText;
            textView22.layout(min2, i3, measuredWidth + min2, textView22.getMeasuredHeight() + i3);
            int max32 = Math.max((width - paddingRight) - measuredWidth3, i10 + this.mScaledTextSpacing);
            TextView textView32 = this.mNextText;
            textView32.layout(max32, i5, max32 + measuredWidth3, textView32.getMeasuredHeight() + i5);
            this.mLastKnownPositionOffset = f;
            this.mUpdatingPositions = false;
        }
    }
}

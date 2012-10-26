package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
/* loaded from: classes.dex */
public class PagerTitleStrip extends ViewGroup implements ViewPager.Decor {
    private static final int[] ATTRS = {16842804, 16842904, 16842901};
    private static final int SIDE_ALPHA = 153;
    private static final String TAG = "PagerTitleStrip";
    private static final int TEXT_SPACING = 16;
    private TextView mCurrText;
    private int mLastKnownCurrentPage;
    private float mLastKnownPositionOffset;
    private TextView mNextText;
    private final PageListener mPageListener;
    ViewPager mPager;
    private TextView mPrevText;
    private int mScaledTextSpacing;
    private boolean mUpdatingPositions;
    private boolean mUpdatingText;

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    public PagerTitleStrip(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mLastKnownCurrentPage = -1;
        this.mLastKnownPositionOffset = -1.0f;
        this.mPageListener = new PageListener();
        TextView textView = new TextView(context);
        this.mPrevText = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.mCurrText = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.mNextText = textView3;
        addView(textView3);
        TypedArray a = context.obtainStyledAttributes(attrs, ATTRS);
        int textAppearance = a.getResourceId(0, 0);
        if (textAppearance != 0) {
            this.mPrevText.setTextAppearance(context, textAppearance);
            this.mCurrText.setTextAppearance(context, textAppearance);
            this.mNextText.setTextAppearance(context, textAppearance);
        }
        if (a.hasValue(1)) {
            int textColor = a.getColor(1, 0);
            this.mPrevText.setTextColor(textColor);
            this.mCurrText.setTextColor(textColor);
            this.mNextText.setTextColor(textColor);
        }
        int textSize = a.getDimensionPixelSize(2, 0);
        if (textSize != 0) {
            this.mPrevText.setTextSize(0, textSize);
            this.mCurrText.setTextSize(0, textSize);
            this.mNextText.setTextSize(0, textSize);
        }
        a.recycle();
        int defaultColor = this.mPrevText.getTextColors().getDefaultColor();
        int transparentColor = (-1728053248) | (16777215 & defaultColor);
        this.mPrevText.setTextColor(transparentColor);
        this.mNextText.setTextColor(transparentColor);
        this.mPrevText.setEllipsize(TextUtils.TruncateAt.END);
        this.mCurrText.setEllipsize(TextUtils.TruncateAt.END);
        this.mNextText.setEllipsize(TextUtils.TruncateAt.END);
        this.mPrevText.setSingleLine();
        this.mCurrText.setSingleLine();
        this.mNextText.setSingleLine();
        float density = context.getResources().getDisplayMetrics().density;
        this.mScaledTextSpacing = (int) (16.0f * density);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager pager = (ViewPager) parent;
        PagerAdapter adapter = pager.getAdapter();
        pager.setInternalPageChangeListener(this.mPageListener);
        pager.setOnAdapterChangeListener(this.mPageListener);
        this.mPager = pager;
        updateAdapter(null, adapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        updateAdapter(this.mPager.getAdapter(), null);
        this.mPager.setInternalPageChangeListener(null);
        this.mPager.setOnAdapterChangeListener(null);
        this.mPager = null;
    }

    void updateText(int currentItem, PagerAdapter adapter) {
        int itemCount = adapter != null ? adapter.getCount() : 0;
        this.mUpdatingText = true;
        CharSequence text = null;
        if (currentItem >= 1 && adapter != null) {
            text = adapter.getPageTitle(currentItem - 1);
        }
        this.mPrevText.setText(text);
        this.mCurrText.setText(adapter != null ? adapter.getPageTitle(currentItem) : null);
        CharSequence text2 = null;
        if (currentItem + 1 < itemCount && adapter != null) {
            text2 = adapter.getPageTitle(currentItem + 1);
        }
        this.mNextText.setText(text2);
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int childHeight = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int childWidthSpec = View.MeasureSpec.makeMeasureSpec((int) (width * 0.8f), Integer.MIN_VALUE);
        int childHeightSpec = View.MeasureSpec.makeMeasureSpec(childHeight, 1073741824);
        this.mPrevText.measure(childWidthSpec, childHeightSpec);
        this.mCurrText.measure(childWidthSpec, childHeightSpec);
        this.mNextText.measure(childWidthSpec, childHeightSpec);
        this.mLastKnownCurrentPage = currentItem;
        if (!this.mUpdatingPositions) {
            updateTextPositions(currentItem, this.mLastKnownPositionOffset);
        }
        this.mUpdatingText = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.mUpdatingText) {
            super.requestLayout();
        }
    }

    void updateAdapter(PagerAdapter oldAdapter, PagerAdapter newAdapter) {
        if (oldAdapter != null) {
            oldAdapter.unregisterDataSetObserver(this.mPageListener);
        }
        if (newAdapter != null) {
            newAdapter.registerDataSetObserver(this.mPageListener);
        }
        if (this.mPager != null) {
            this.mLastKnownCurrentPage = -1;
            this.mLastKnownPositionOffset = -1.0f;
            updateText(this.mPager.getCurrentItem(), newAdapter);
            requestLayout();
        }
    }

    void updateTextPositions(int position, float positionOffset) {
        if (position != this.mLastKnownCurrentPage) {
            updateText(position, this.mPager.getAdapter());
        } else if (positionOffset == this.mLastKnownPositionOffset) {
            return;
        }
        this.mUpdatingPositions = true;
        int prevWidth = this.mPrevText.getMeasuredWidth();
        int currWidth = this.mCurrText.getMeasuredWidth();
        int nextWidth = this.mNextText.getMeasuredWidth();
        int halfCurrWidth = currWidth / 2;
        int stripWidth = getWidth();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int textPaddedLeft = paddingLeft + halfCurrWidth;
        int textPaddedRight = paddingRight + halfCurrWidth;
        int contentWidth = (stripWidth - textPaddedLeft) - textPaddedRight;
        float currOffset = positionOffset + 0.5f;
        if (currOffset > 1.0f) {
            currOffset -= 1.0f;
        }
        int currCenter = (stripWidth - textPaddedRight) - ((int) (contentWidth * currOffset));
        int currLeft = currCenter - (currWidth / 2);
        int currRight = currLeft + currWidth;
        this.mCurrText.layout(currLeft, paddingTop, currRight, this.mCurrText.getMeasuredHeight() + paddingTop);
        int prevLeft = Math.min(paddingLeft, (currLeft - this.mScaledTextSpacing) - prevWidth);
        this.mPrevText.layout(prevLeft, paddingTop, prevLeft + prevWidth, this.mPrevText.getMeasuredHeight() + paddingTop);
        int nextLeft = Math.max((stripWidth - paddingRight) - nextWidth, this.mScaledTextSpacing + currRight);
        this.mNextText.layout(nextLeft, paddingTop, nextLeft + nextWidth, this.mNextText.getMeasuredHeight() + paddingTop);
        this.mLastKnownPositionOffset = positionOffset;
        this.mUpdatingPositions = false;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int minHeight = 0;
        Drawable bg = getBackground();
        if (bg != null) {
            minHeight = bg.getIntrinsicHeight();
        }
        int padding = getPaddingTop() + getPaddingBottom();
        int childHeight = heightSize - padding;
        int childWidthSpec = View.MeasureSpec.makeMeasureSpec((int) (widthSize * 0.8f), Integer.MIN_VALUE);
        int childHeightSpec = View.MeasureSpec.makeMeasureSpec(childHeight, heightMode);
        this.mPrevText.measure(childWidthSpec, childHeightSpec);
        this.mCurrText.measure(childWidthSpec, childHeightSpec);
        this.mNextText.measure(childWidthSpec, childHeightSpec);
        if (heightMode == 1073741824) {
            setMeasuredDimension(widthSize, heightSize);
            return;
        }
        int textHeight = this.mCurrText.getMeasuredHeight();
        setMeasuredDimension(widthSize, Math.max(minHeight, textHeight + padding));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (this.mPager != null) {
            updateTextPositions(this.mPager.getCurrentItem(), 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {
        private int mScrollState;

        private PageListener() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (positionOffset > 0.5f) {
                position++;
            }
            PagerTitleStrip.this.updateTextPositions(position, positionOffset);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            if (this.mScrollState == 0) {
                PagerTitleStrip.this.updateText(PagerTitleStrip.this.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            this.mScrollState = state;
        }

        @Override // android.support.v4.view.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(PagerAdapter oldAdapter, PagerAdapter newAdapter) {
            PagerTitleStrip.this.updateAdapter(oldAdapter, newAdapter);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip.this.updateText(PagerTitleStrip.this.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
        }
    }
}

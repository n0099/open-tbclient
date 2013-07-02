package com.baidu.browser.framework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.browser.core.util.BdUtil;
/* loaded from: classes.dex */
public class BdAdColumnView extends FrameLayout implements View.OnClickListener {
    private String mAdLink;
    private int mCancelViewWidth;
    private String mConfirmCancelText;
    private ConfirmCancelView mConfirmCancelView;
    private Bitmap mConfirmGapBitmap;
    private ImageView mConfirmGapView;
    private String mConfirmOkText;
    private ConfirmOkView mConfirmOkView;
    private String mConfirmTipText;
    private ConfirmTipView mConfirmTipView;
    private int mOkViewWidth;
    private int mPaddingLeft;
    private BdWindow mWindow;

    public BdAdColumnView(Context context) {
        super(context);
        this.mAdLink = "http://r2.mo.baidu.com/res/marketing/apk/baidubrowserfortieba_1000175b.apk";
        init(context);
    }

    public BdAdColumnView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAdLink = "http://r2.mo.baidu.com/res/marketing/apk/baidubrowserfortieba_1000175b.apk";
        init(context);
    }

    public BdAdColumnView(Context context, BdWindow bdWindow) {
        super(context);
        this.mAdLink = "http://r2.mo.baidu.com/res/marketing/apk/baidubrowserfortieba_1000175b.apk";
        this.mWindow = bdWindow;
        init(context);
    }

    private void init(Context context) {
        setBackgroundResource(context.getResources().getIdentifier("browser_ad_tip_background", "drawable", context.getPackageName()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.mConfirmTipText = context.getResources().getString(context.getResources().getIdentifier("browser_ad_browser_tip", "string", context.getPackageName()));
        this.mConfirmTipView = new ConfirmTipView(context);
        addView(this.mConfirmTipView, layoutParams);
        this.mConfirmOkText = context.getResources().getString(context.getResources().getIdentifier("browser_ad_browser_tip_ok", "string", context.getPackageName()));
        this.mConfirmOkView = new ConfirmOkView(context);
        this.mConfirmOkView.setOnClickListener(this);
        addView(this.mConfirmOkView, layoutParams);
        this.mConfirmGapView = new ImageView(context);
        this.mConfirmGapBitmap = BitmapFactory.decodeResource(getResources(), context.getResources().getIdentifier("browser_ad_tip_confirm_gap", "drawable", context.getPackageName()));
        this.mConfirmGapView.setImageBitmap(this.mConfirmGapBitmap);
        addView(this.mConfirmGapView, layoutParams);
        this.mConfirmCancelText = context.getResources().getString(context.getResources().getIdentifier("browser_ad_browser_tip_cancel", "string", context.getPackageName()));
        this.mConfirmCancelView = new ConfirmCancelView(context);
        this.mConfirmCancelView.setOnClickListener(this);
        addView(this.mConfirmCancelView, layoutParams);
        this.mOkViewWidth = BdUtil.dip2pix(context, 40.0f);
        this.mCancelViewWidth = BdUtil.dip2pix(context, 60.0f);
        this.mPaddingLeft = BdUtil.dip2pix(context, 4.0f);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.mConfirmOkView.measure(View.MeasureSpec.makeMeasureSpec(this.mOkViewWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        int width = this.mConfirmGapBitmap.getWidth();
        this.mConfirmGapView.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        this.mConfirmCancelView.measure(View.MeasureSpec.makeMeasureSpec(this.mCancelViewWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        this.mConfirmTipView.measure(View.MeasureSpec.makeMeasureSpec((((size - this.mOkViewWidth) - width) - this.mCancelViewWidth) - this.mPaddingLeft, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = this.mPaddingLeft;
        int childCount = getChildCount();
        int i6 = i5;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            int measuredWidth = childAt.getMeasuredWidth();
            childAt.layout(i6, 0, i6 + measuredWidth, getHeight());
            i6 += measuredWidth;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] autoSplit(String str, Paint paint, float f) {
        float measureText;
        int i;
        int i2 = 1;
        int i3 = 0;
        int length = str.length();
        if (paint.measureText(str) <= f) {
            return new String[]{str};
        }
        String[] strArr = new String[(int) Math.ceil(measureText / f)];
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            if (paint.measureText(str, i4, i2) > f) {
                i = i3 + 1;
                strArr[i3] = (String) str.subSequence(i4, i2);
                i4 = i2;
            } else {
                i = i3;
            }
            if (i2 == length) {
                strArr[i] = (String) str.subSequence(i4, i2);
                break;
            }
            i2++;
            i3 = i;
        }
        return strArr;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.mConfirmOkView)) {
            this.mWindow.startBrowsable(this.mAdLink);
        } else if (view.equals(this.mConfirmCancelView)) {
            this.mWindow.onAdColumnCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ConfirmTipView extends TextView {
        private Paint mTextPaint;

        public ConfirmTipView(Context context) {
            super(context);
            this.mTextPaint = new Paint();
            this.mTextPaint.setAntiAlias(true);
            this.mTextPaint.setColor(context.getResources().getColor(context.getResources().getIdentifier("browser_ad_tip_text", "color", context.getPackageName())));
            this.mTextPaint.setTextSize(context.getResources().getDimension(context.getResources().getIdentifier("browser_ad_browser_tip", "dimen", context.getPackageName())));
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            String[] autoSplit = BdAdColumnView.this.autoSplit(BdAdColumnView.this.mConfirmTipText, this.mTextPaint, BdAdColumnView.this.mConfirmTipView.getWidth() - (BdAdColumnView.this.mPaddingLeft * 2));
            float width = (BdAdColumnView.this.mConfirmTipView.getWidth() - this.mTextPaint.measureText(autoSplit[0])) / 2.0f;
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            int ceil = (int) (Math.ceil(fontMetrics.descent - fontMetrics.top) + 2.0d);
            float height = ((BdAdColumnView.this.mConfirmTipView.getHeight() - (autoSplit.length * ceil)) >> 1) + this.mTextPaint.getTextSize();
            for (String str : autoSplit) {
                canvas.drawText(str, width, height, this.mTextPaint);
                height += ceil + fontMetrics.leading;
            }
            super.onDraw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ConfirmOkView extends TextView {
        private Context mContext;
        private Paint mTextPaint;

        public ConfirmOkView(Context context) {
            super(context);
            this.mContext = context;
            this.mTextPaint = new Paint();
            this.mTextPaint.setAntiAlias(true);
            this.mTextPaint.setColor(context.getResources().getColor(context.getResources().getIdentifier("browser_ad_tip_text_ok", "color", context.getPackageName())));
            this.mTextPaint.setTextSize(context.getResources().getDimension(context.getResources().getIdentifier("browser_ad_browser_tip_ok", "dimen", context.getPackageName())));
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            canvas.drawText(BdAdColumnView.this.mConfirmOkText, (BdAdColumnView.this.mConfirmOkView.getWidth() - ((int) this.mTextPaint.measureText(BdAdColumnView.this.mConfirmOkText))) >> 1, ((BdAdColumnView.this.mConfirmOkView.getHeight() - ((int) (Math.ceil(fontMetrics.descent - fontMetrics.top) + 2.0d))) >> 1) + this.mTextPaint.getTextSize(), this.mTextPaint);
            super.onDraw(canvas);
        }

        @Override // android.widget.TextView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.mTextPaint.setColor(this.mContext.getResources().getColor(this.mContext.getResources().getIdentifier("browser_ad_tip_text_ok_press", "color", this.mContext.getPackageName())));
                invalidate();
            } else if (motionEvent.getAction() == 1) {
                this.mTextPaint.setColor(this.mContext.getResources().getColor(this.mContext.getResources().getIdentifier("browser_ad_tip_text_ok", "color", this.mContext.getPackageName())));
                invalidate();
            }
            return super.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ConfirmCancelView extends TextView {
        private Context mContext;
        private Paint mTextPaint;

        public ConfirmCancelView(Context context) {
            super(context);
            this.mContext = context;
            this.mTextPaint = new Paint();
            this.mTextPaint.setAntiAlias(true);
            this.mTextPaint.setColor(context.getResources().getColor(context.getResources().getIdentifier("browser_ad_tip_text_cancel", "color", context.getPackageName())));
            this.mTextPaint.setTextSize(context.getResources().getDimension(context.getResources().getIdentifier("browser_ad_browser_tip_cancel", "dimen", context.getPackageName())));
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            canvas.drawText(BdAdColumnView.this.mConfirmCancelText, (BdAdColumnView.this.mConfirmCancelView.getWidth() - ((int) this.mTextPaint.measureText(BdAdColumnView.this.mConfirmCancelText))) >> 1, ((BdAdColumnView.this.mConfirmCancelView.getHeight() - ((int) (Math.ceil(fontMetrics.descent - fontMetrics.top) + 2.0d))) >> 1) + this.mTextPaint.getTextSize(), this.mTextPaint);
            super.onDraw(canvas);
        }

        @Override // android.widget.TextView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.mTextPaint.setColor(this.mContext.getResources().getColor(this.mContext.getResources().getIdentifier("browser_ad_tip_text_cancel_press", "color", this.mContext.getPackageName())));
                invalidate();
            } else if (motionEvent.getAction() == 1) {
                this.mTextPaint.setColor(this.mContext.getResources().getColor(this.mContext.getResources().getIdentifier("browser_ad_tip_text_cancel", "color", this.mContext.getPackageName())));
                invalidate();
            }
            return super.onTouchEvent(motionEvent);
        }
    }
}

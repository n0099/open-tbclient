package com.baidu.mobads.container.landingpage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.landingpage.App2Activity;
import com.baidu.mobads.container.util.ScreenUtils;
/* loaded from: classes2.dex */
public class XActionBar extends RelativeLayout {
    public static final int BAR_HEIGHT = 46;
    public static final int BUTTON_WIDTH = 52;
    public static final int GO_BACK_BUTTON_VIEW_ID = 132343242;
    public static final int TEXT_HEIGHT = 16;
    public static final int THREE_POINT_BUTTON_VIEW_ID = 132343243;
    public App2Activity.ActionBarColorTheme colorTheme;
    public int mBarHeight;
    public int mBarWidth;
    public OnButtonClickListener mClickListener;
    public Context mContext;
    public Paint paint;
    public TextView titleTextView;

    /* loaded from: classes2.dex */
    public class CustomButtonView extends View {
        public static final int MOVE_GAP = 8;
        public static final int X_COORDINATE = 26;
        public static final int Y_COORDINATE = 23;

        public CustomButtonView(Context context) {
            super(context);
        }
    }

    /* loaded from: classes2.dex */
    public class GoBackButtonView extends CustomButtonView {
        public int frontColor;
        public Paint mArrowPaint;

        public GoBackButtonView(Context context, int i2) {
            super(context);
            this.frontColor = i2;
        }

        private Paint getArrowPaint() {
            if (this.mArrowPaint == null) {
                Paint paint = new Paint();
                this.mArrowPaint = paint;
                paint.setStyle(Paint.Style.STROKE);
                this.mArrowPaint.setColor(this.frontColor);
                this.mArrowPaint.setAlpha(255);
                this.mArrowPaint.setAntiAlias(true);
                this.mArrowPaint.setStrokeWidth((int) ScreenUtils.getScreenDensity(getContext()));
            }
            return this.mArrowPaint;
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawLine(ScreenUtils.getPixel(getContext(), 18), ScreenUtils.getPixel(getContext(), 15), ScreenUtils.getPixel(getContext(), 34), ScreenUtils.getPixel(getContext(), 31), getArrowPaint());
            canvas.drawLine(ScreenUtils.getPixel(getContext(), 18), ScreenUtils.getPixel(getContext(), 31), ScreenUtils.getPixel(getContext(), 34), ScreenUtils.getPixel(getContext(), 15), getArrowPaint());
        }
    }

    /* loaded from: classes2.dex */
    public interface OnButtonClickListener {
        void onGoBackBttonClick();

        void onThreePointButtonClick();
    }

    /* loaded from: classes2.dex */
    public class ThreePointButtonView extends CustomButtonView {
        public static final float POINT_RADIUS = 1.0f;
        public int frontColor;
        public Paint pointPaint;

        public ThreePointButtonView(Context context, int i2) {
            super(context);
            this.frontColor = i2;
        }

        private void drawPoint(Canvas canvas, int i2) {
            canvas.drawCircle(ScreenUtils.getPixel(getContext(), 26), ScreenUtils.getPixel(getContext(), i2), (int) (ScreenUtils.getScreenDensity(getContext()) * 1.0f), getPointPaint());
        }

        private Paint getPointPaint() {
            if (this.pointPaint == null) {
                Paint paint = new Paint();
                this.pointPaint = paint;
                paint.setColor(this.frontColor);
                this.pointPaint.setAlpha(255);
                this.pointPaint.setAntiAlias(true);
            }
            return this.pointPaint;
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            drawPoint(canvas, 31);
            drawPoint(canvas, 15);
            drawPoint(canvas, 23);
        }
    }

    public XActionBar(Context context) {
        super(context);
        this.paint = new Paint();
        this.mBarWidth = 0;
        this.mBarHeight = 0;
        this.mContext = context;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.colorTheme.equals(App2Activity.ActionBarColorTheme.ACTION_BAR_WHITE_THEME)) {
            this.paint.setColor(-5592406);
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeWidth(ScreenUtils.getPixel(this.mContext, 1));
            int i2 = this.mBarHeight;
            canvas.drawLine(0.0f, i2, this.mBarWidth, i2, this.paint);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.mBarWidth = i4 - i2;
        this.mBarHeight = i5 - i3;
    }

    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        this.mClickListener = onButtonClickListener;
    }

    public void setTitle(String str) {
        TextView textView = this.titleTextView;
        if (textView != null) {
            textView.setText(str);
            this.titleTextView.invalidate();
        }
    }

    public void showDefaultBar() {
        int pixel = ScreenUtils.getPixel(this.mContext, 52);
        View goBackButtonView = new GoBackButtonView(this.mContext, this.colorTheme.getCloseColor());
        goBackButtonView.setId(GO_BACK_BUTTON_VIEW_ID);
        addView(goBackButtonView, new RelativeLayout.LayoutParams(pixel, -1));
        goBackButtonView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.container.landingpage.XActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnButtonClickListener onButtonClickListener = XActionBar.this.mClickListener;
                if (onButtonClickListener != null) {
                    onButtonClickListener.onGoBackBttonClick();
                }
            }
        });
        View threePointButtonView = new ThreePointButtonView(this.mContext, this.colorTheme.getCloseColor());
        threePointButtonView.setId(THREE_POINT_BUTTON_VIEW_ID);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(pixel, -1);
        layoutParams.addRule(11);
        threePointButtonView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.container.landingpage.XActionBar.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnButtonClickListener onButtonClickListener = XActionBar.this.mClickListener;
                if (onButtonClickListener != null) {
                    onButtonClickListener.onThreePointButtonClick();
                }
            }
        });
        addView(threePointButtonView, layoutParams);
        TextView textView = new TextView(this.mContext);
        this.titleTextView = textView;
        textView.setTextSize(1, 16.0f);
        this.titleTextView.setLines(1);
        this.titleTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.titleTextView.setGravity(16);
        this.titleTextView.setTextColor(this.colorTheme.getTitleColor());
        this.titleTextView.setText("");
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ScreenUtils.getScreenRect(this.mContext).width() - (pixel * 2), -1);
        layoutParams2.addRule(14);
        addView(this.titleTextView, layoutParams2);
    }

    public XActionBar(Context context, App2Activity.ActionBarColorTheme actionBarColorTheme) {
        this(context);
        this.colorTheme = actionBarColorTheme;
        setBackgroundColor(actionBarColorTheme.getBackgroundColor());
        showDefaultBar();
    }
}

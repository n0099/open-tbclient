package com.baidu.mobads.container.landingpage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.util.ScreenUtils;
/* loaded from: classes2.dex */
public class NativeActionBar extends RelativeLayout {
    public static final int BUTTON_WIDTH = 52;
    public static final int GO_BACK_VIEW_ID = 132343252;
    public Context mBarContext;
    public OnGButtonClickListener mGButtonClickListener;
    public TextView titleTextView;

    /* loaded from: classes2.dex */
    public class GoBackButtonView extends View {
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
            canvas.drawLine(ScreenUtils.getPixel(getContext(), 26), ScreenUtils.getPixel(getContext(), 23), ScreenUtils.getPixel(getContext(), 34), ScreenUtils.getPixel(getContext(), 31), getArrowPaint());
            canvas.drawLine(ScreenUtils.getPixel(getContext(), 26), ScreenUtils.getPixel(getContext(), 23), ScreenUtils.getPixel(getContext(), 34), ScreenUtils.getPixel(getContext(), 15), getArrowPaint());
        }
    }

    /* loaded from: classes2.dex */
    public interface OnGButtonClickListener {
        void onGoBackBttonClick();
    }

    public NativeActionBar(Context context) {
        super(context);
        this.mBarContext = context;
        setBackgroundColor(Color.parseColor("#66CDAA"));
        showDefaultBar();
    }

    public void setTitle(String str) {
        TextView textView = this.titleTextView;
        if (textView != null) {
            textView.setText(str);
            this.titleTextView.invalidate();
        }
    }

    public void setmGButtonClickListener(OnGButtonClickListener onGButtonClickListener) {
        this.mGButtonClickListener = onGButtonClickListener;
    }

    public void showDefaultBar() {
        int pixel = ScreenUtils.getPixel(this.mBarContext, 52);
        View goBackButtonView = new GoBackButtonView(this.mBarContext, Color.parseColor("#FFFFFF"));
        goBackButtonView.setId(GO_BACK_VIEW_ID);
        addView(goBackButtonView, new RelativeLayout.LayoutParams(pixel, -1));
        goBackButtonView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.container.landingpage.NativeActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NativeActionBar.this.mGButtonClickListener != null) {
                    NativeActionBar.this.mGButtonClickListener.onGoBackBttonClick();
                }
            }
        });
        TextView textView = new TextView(this.mBarContext);
        this.titleTextView = textView;
        textView.setTextSize(1, 16.0f);
        this.titleTextView.setLines(1);
        this.titleTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.titleTextView.setTextColor(-1);
        this.titleTextView.setText("");
        this.titleTextView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenUtils.getScreenRect(this.mBarContext).width() - (pixel * 2), -1);
        layoutParams.addRule(14);
        addView(this.titleTextView, layoutParams);
    }
}

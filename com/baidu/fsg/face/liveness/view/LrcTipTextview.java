package com.baidu.fsg.face.liveness.view;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.fsg.face.liveness.view.LrcView;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes16.dex */
public class LrcTipTextview extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1767a;
    private TextView b;
    private TextView c;
    private TextView d;
    private int e;
    private int f;

    /* loaded from: classes16.dex */
    interface a {
        void a();
    }

    public LrcTipTextview(Context context) {
        super(context);
        a();
    }

    public LrcTipTextview(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        setOrientation(1);
        setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.e = getResources().getDimensionPixelSize(R.dimen.rim_text_size_16);
        this.f = getResources().getDimensionPixelSize(R.dimen.rim_text_size_24);
        this.b = new TextView(getContext());
        this.b.setTextColor(Color.rgb(255, 255, 255));
        this.b.setTextSize(0, this.f);
        this.b.setText(getContext().getString(R.string.rim_face_video_tips_start_resocrd));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_lrc_tip_text01_gap));
        this.b.setLayoutParams(layoutParams2);
        this.c = new TextView(getContext());
        this.c.setTextColor(Color.rgb(255, 255, 255));
        this.c.setTextSize(0, this.e);
        this.c.setText(getContext().getString(R.string.rim_face_video_tips_read_content));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_lrc_tip_text12_gap));
        this.c.setLayoutParams(layoutParams3);
        this.d = new TextView(getContext());
        this.d.setTextColor(Color.rgb(255, 255, 255));
        this.d.setTextSize(0, this.e);
        this.d.setText(getContext().getString(R.string.rim_face_video_tips_keep_face_in_box));
        this.d.setLayoutParams(layoutParams);
        addView(this.b);
        addView(this.c);
        addView(this.d);
    }

    public void startLrcTipAnim(final LrcView.a aVar) {
        postDelayed(new Runnable() { // from class: com.baidu.fsg.face.liveness.view.LrcTipTextview.1
            @Override // java.lang.Runnable
            public void run() {
                LrcTipTextview.this.b.setVisibility(8);
                final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) LrcTipTextview.this.getLayoutParams();
                final int top = LrcTipTextview.this.getTop() + LrcTipTextview.this.getPaddingTop();
                final int dimensionPixelOffset = LrcTipTextview.this.getResources().getDimensionPixelOffset(R.dimen.liveness_video_lrc_tip_margintop_afteranim);
                ValueAnimator ofInt = ValueAnimator.ofInt(1, 100);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.fsg.face.liveness.view.LrcTipTextview.1.1
                    private IntEvaluator e = new IntEvaluator();

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        float f = intValue / 100.0f;
                        layoutParams.topMargin = this.e.evaluate(f, Integer.valueOf(top), Integer.valueOf(dimensionPixelOffset)).intValue();
                        int intValue2 = this.e.evaluate(f, (Integer) 255, (Integer) 51).intValue();
                        LrcTipTextview.this.c.setTextColor(Color.rgb(intValue2, intValue2, intValue2));
                        LrcTipTextview.this.d.setTextColor(Color.rgb(intValue2, intValue2, intValue2));
                        LrcTipTextview.this.c.setTextSize(0, this.e.evaluate(f, Integer.valueOf(LrcTipTextview.this.e), Integer.valueOf(LrcTipTextview.this.f)).intValue());
                        LrcTipTextview.this.requestLayout();
                        if (intValue == 100) {
                            aVar.a();
                        }
                    }
                });
                ofInt.setDuration(400L).start();
            }
        }, 0L);
    }
}

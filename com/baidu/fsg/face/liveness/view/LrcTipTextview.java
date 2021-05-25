package com.baidu.fsg.face.liveness.view;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.fsg.face.liveness.view.LrcView;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes2.dex */
public class LrcTipTextview extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public boolean f6098a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f6099b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f6100c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f6101d;

    /* renamed from: e  reason: collision with root package name */
    public int f6102e;

    /* renamed from: f  reason: collision with root package name */
    public int f6103f;

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    public LrcTipTextview(Context context) {
        super(context);
        a();
    }

    public void startLrcTipAnim(final LrcView.a aVar) {
        postDelayed(new Runnable() { // from class: com.baidu.fsg.face.liveness.view.LrcTipTextview.1
            @Override // java.lang.Runnable
            public void run() {
                LrcTipTextview.this.f6099b.setVisibility(8);
                final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) LrcTipTextview.this.getLayoutParams();
                final int top = LrcTipTextview.this.getTop() + LrcTipTextview.this.getPaddingTop();
                final int dimensionPixelOffset = LrcTipTextview.this.getResources().getDimensionPixelOffset(R.dimen.liveness_video_lrc_tip_margintop_afteranim);
                ValueAnimator ofInt = ValueAnimator.ofInt(1, 100);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.fsg.face.liveness.view.LrcTipTextview.1.1

                    /* renamed from: e  reason: collision with root package name */
                    public IntEvaluator f6110e = new IntEvaluator();

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        float f2 = intValue / 100.0f;
                        layoutParams.topMargin = this.f6110e.evaluate(f2, Integer.valueOf(top), Integer.valueOf(dimensionPixelOffset)).intValue();
                        int intValue2 = this.f6110e.evaluate(f2, (Integer) 255, (Integer) 51).intValue();
                        LrcTipTextview.this.f6100c.setTextColor(Color.rgb(intValue2, intValue2, intValue2));
                        LrcTipTextview.this.f6101d.setTextColor(Color.rgb(intValue2, intValue2, intValue2));
                        LrcTipTextview.this.f6100c.setTextSize(0, this.f6110e.evaluate(f2, Integer.valueOf(LrcTipTextview.this.f6102e), Integer.valueOf(LrcTipTextview.this.f6103f)).intValue());
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

    private void a() {
        setOrientation(1);
        setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.f6102e = getResources().getDimensionPixelSize(R.dimen.rim_text_size_16);
        this.f6103f = getResources().getDimensionPixelSize(R.dimen.rim_text_size_24);
        TextView textView = new TextView(getContext());
        this.f6099b = textView;
        textView.setTextColor(Color.rgb(255, 255, 255));
        this.f6099b.setTextSize(0, this.f6103f);
        this.f6099b.setText(getContext().getString(R.string.rim_face_video_tips_start_resocrd));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_lrc_tip_text01_gap));
        this.f6099b.setLayoutParams(layoutParams2);
        TextView textView2 = new TextView(getContext());
        this.f6100c = textView2;
        textView2.setTextColor(Color.rgb(255, 255, 255));
        this.f6100c.setTextSize(0, this.f6102e);
        this.f6100c.setText(getContext().getString(R.string.rim_face_video_tips_read_content));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_lrc_tip_text12_gap));
        this.f6100c.setLayoutParams(layoutParams3);
        TextView textView3 = new TextView(getContext());
        this.f6101d = textView3;
        textView3.setTextColor(Color.rgb(255, 255, 255));
        this.f6101d.setTextSize(0, this.f6102e);
        this.f6101d.setText(getContext().getString(R.string.rim_face_video_tips_keep_face_in_box));
        this.f6101d.setLayoutParams(layoutParams);
        addView(this.f6099b);
        addView(this.f6100c);
        addView(this.f6101d);
    }

    public LrcTipTextview(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}

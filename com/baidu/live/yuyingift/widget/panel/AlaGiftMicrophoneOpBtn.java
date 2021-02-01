package com.baidu.live.yuyingift.widget.panel;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class AlaGiftMicrophoneOpBtn extends TextView {
    private LinearGradient caD;
    private LinearGradient caE;

    public AlaGiftMicrophoneOpBtn(Context context) {
        this(context, null);
    }

    public AlaGiftMicrophoneOpBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        int dimension = (int) getResources().getDimension(a.d.sdk_ds20);
        int dimension2 = (int) getResources().getDimension(a.d.sdk_ds7);
        float dimension3 = getResources().getDimension(a.d.sdk_ds24);
        setPadding(dimension, dimension2, dimension, dimension2);
        setTextSize(0, dimension3);
        setGravity(17);
        this.caD = new LinearGradient(0.0f, 0.0f, 0.0f, getPaint().getTextSize(), Color.parseColor("#FF6619"), Color.parseColor("#FF1E66"), Shader.TileMode.CLAMP);
        this.caE = new LinearGradient(0.0f, 0.0f, 0.0f, getPaint().getTextSize(), Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"), Shader.TileMode.CLAMP);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setBackgroundDrawable(getResources().getDrawable(a.e.yuyin_ala_gift_radius_60_solid_red));
            getPaint().setShader(this.caE);
            invalidate();
            return;
        }
        setBackgroundDrawable(getResources().getDrawable(a.e.yuyin_ala_gift_radius_60_hollow_red));
        getPaint().setShader(this.caD);
        invalidate();
    }
}

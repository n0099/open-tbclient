package com.baidu.live.business.view.emotion;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tieba.R;
import com.baidu.tieba.de0;
import com.baidu.tieba.mb0;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes3.dex */
public class EmptyView extends LinearLayout {
    public SimpleDraweeView a;
    public AppCompatTextView b;

    public EmptyView(Context context) {
        this(context, null);
    }

    public void b(int i) {
        c(i, LiveFeedPageSdk.HOST_LIVE_TAB);
    }

    public void setImageResource(int i) {
        if (i != -1) {
            this.a.setActualImageResource(i);
        }
    }

    public void setText(int i) {
        this.b.setText(i);
    }

    public EmptyView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void c(int i, String str) {
        super.setVisibility(i);
        if (i == 0) {
            a(str);
        }
    }

    public EmptyView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05ac, this);
        setOrientation(1);
        setGravity(17);
        this.a = (SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f0909d6);
        this.b = (AppCompatTextView) findViewById(R.id.obfuscated_res_0x7f0909d8);
    }

    public void a(String str) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.getLayoutParams();
        layoutParams.width = mb0.b(getContext(), EmotionStrategy.getInstance().emptyWidth);
        layoutParams.height = mb0.b(getContext(), EmotionStrategy.getInstance().emptyHeight);
        this.a.setLayoutParams(layoutParams);
        setImageResource(de0.f().b(str));
        if (LiveFeedPageSdk.HOST_QUANMIN.equals(LiveFeedPageSdk.getInstance().getHost())) {
            this.b.setText(R.string.obfuscated_res_0x7f0f0b89);
        } else {
            this.b.setText(R.string.obfuscated_res_0x7f0f0b88);
        }
        this.b.setTextColor(de0.f().a(getContext(), str, "color_8585852"));
    }

    public void setText(CharSequence charSequence) {
        this.b.setText(charSequence);
    }
}

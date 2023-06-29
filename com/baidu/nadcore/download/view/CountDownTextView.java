package com.baidu.nadcore.download.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.baidu.tieba.on0;
/* loaded from: classes3.dex */
public class CountDownTextView extends LinearLayout implements on0 {
    public TextView a;
    public TextView b;
    public String c;

    public CountDownTextView(Context context) {
        this(context, null);
    }

    @Override // com.baidu.tieba.on0
    public void a(long j) {
        this.b.setText(String.format(this.c, 0));
    }

    public void setLabelText(CharSequence charSequence) {
        this.a.setText(charSequence);
    }

    public void setTextColor(@ColorInt int i) {
        this.a.setTextColor(i);
        this.b.setTextColor(i);
    }

    public void setTextSize(int i) {
        float f = i;
        this.a.setTextSize(1, f);
        this.b.setTextSize(1, f);
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.tieba.on0
    public void b(long j, long j2) {
        this.b.setText(String.format(this.c, Integer.valueOf((int) Math.ceil(((float) (j2 - j)) / 1000.0f))));
    }

    @Override // com.baidu.tieba.on0
    public void c(long j, long j2) {
        this.b.setText(String.format(this.c, Integer.valueOf((int) Math.ceil(((float) (j2 - j)) / 1000.0f))));
    }

    @Override // com.baidu.tieba.on0
    public void onProgress(long j, long j2) {
        this.b.setText(String.format(this.c, Integer.valueOf((int) Math.ceil(((float) (j2 - j)) / 1000.0f))));
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = "%ss";
        d();
    }

    public final void d() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.nad_count_down_text_view, this);
        this.a = (TextView) inflate.findViewById(R.id.ad_count_down_label_text);
        this.b = (TextView) inflate.findViewById(R.id.ad_count_down_timer_text);
    }

    public void setTimerTextFormat(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.c = str;
        this.c += "%s";
        StringBuilder sb = new StringBuilder();
        sb.append(this.c);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        sb.append(str2);
        this.c = sb.toString();
    }
}

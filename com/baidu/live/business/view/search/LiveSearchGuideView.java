package com.baidu.live.business.view.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.baidu.tieba.fd0;
/* loaded from: classes3.dex */
public class LiveSearchGuideView extends FrameLayout {
    public ImageView a;
    public TextView b;

    public LiveSearchGuideView(@NonNull Context context) {
        this(context, null);
    }

    public LiveSearchGuideView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveSearchGuideView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05e8, this);
        this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f091597);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f091598);
        c();
    }

    public void c() {
        TextView textView = this.b;
        if (textView != null) {
            fd0.h(textView, 1, 12.0f);
        }
    }

    public void b(String str, boolean z) {
        if (this.b != null) {
            if (z) {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f080f49);
                this.b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f47);
                this.b.setTextColor(-1);
            } else if ("day".equals(str)) {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f080f48);
                this.b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f46);
                this.b.setTextColor(-1);
            } else if ("night".equals(str)) {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f080f49);
                this.b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f47);
                this.b.setTextColor(-1);
            }
        }
    }
}

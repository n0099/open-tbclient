package com.baidu.live.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.q.a;
/* loaded from: classes2.dex */
public class AlaListEmptyView extends LinearLayout {
    private ImageView azm;
    private TextView azn;

    public AlaListEmptyView(@NonNull Context context) {
        super(context);
        initView();
    }

    public AlaListEmptyView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public AlaListEmptyView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.sdk_list_empty_view_layout, this);
        this.azm = (ImageView) findViewById(a.g.ala_empty_view_img);
        this.azn = (TextView) findViewById(a.g.ala_empty_view_text);
    }

    public void setParams(int i, int i2) {
        if (i <= 0) {
            this.azm.setVisibility(8);
        } else {
            this.azm.setVisibility(0);
            this.azm.setImageResource(i);
        }
        if (i2 <= 0) {
            this.azn.setVisibility(8);
            return;
        }
        this.azn.setVisibility(0);
        this.azn.setText(i2);
    }

    public void setImageRes(int i) {
        if (i <= 0) {
            this.azm.setVisibility(8);
            return;
        }
        this.azm.setVisibility(0);
        this.azm.setImageResource(i);
    }
}

package com.baidu.live.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaListEmptyView extends LinearLayout {
    private ImageView aEC;
    private TextView aED;

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
        this.aEC = (ImageView) findViewById(a.g.ala_empty_view_img);
        this.aED = (TextView) findViewById(a.g.ala_empty_view_text);
    }

    public void setParams(int i, int i2) {
        if (i <= 0) {
            this.aEC.setVisibility(8);
        } else {
            this.aEC.setVisibility(0);
            this.aEC.setImageResource(i);
        }
        if (i2 <= 0) {
            this.aED.setVisibility(8);
            return;
        }
        this.aED.setVisibility(0);
        this.aED.setText(i2);
    }

    public void setImageRes(int i) {
        if (i <= 0) {
            this.aEC.setVisibility(8);
            return;
        }
        this.aEC.setVisibility(0);
        this.aEC.setImageResource(i);
    }
}

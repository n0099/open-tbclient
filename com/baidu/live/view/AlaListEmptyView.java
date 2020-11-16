package com.baidu.live.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class AlaListEmptyView extends LinearLayout {
    private ImageView bJD;
    private TextView bJE;

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
        LayoutInflater.from(getContext()).inflate(a.g.sdk_list_empty_view_layout, this);
        this.bJD = (ImageView) findViewById(a.f.ala_empty_view_img);
        this.bJE = (TextView) findViewById(a.f.ala_empty_view_text);
    }

    public void setParams(int i, int i2) {
        if (i <= 0) {
            this.bJD.setVisibility(8);
        } else {
            this.bJD.setVisibility(0);
            this.bJD.setImageResource(i);
        }
        if (i2 <= 0) {
            this.bJE.setVisibility(8);
            return;
        }
        this.bJE.setVisibility(0);
        this.bJE.setText(i2);
    }

    public void setImageRes(int i) {
        if (i <= 0) {
            this.bJD.setVisibility(8);
            return;
        }
        this.bJD.setVisibility(0);
        this.bJD.setImageResource(i);
    }
}

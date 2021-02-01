package com.baidu.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class AlaListEmptyView extends LinearLayout {
    private ImageView bSE;
    private TextView bSF;

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
        this.bSE = (ImageView) findViewById(a.f.ala_empty_view_img);
        this.bSF = (TextView) findViewById(a.f.ala_empty_view_text);
    }

    public void setParams(int i, int i2) {
        if (i <= 0) {
            this.bSE.setVisibility(8);
        } else {
            this.bSE.setVisibility(0);
            this.bSE.setImageResource(i);
        }
        if (i2 <= 0) {
            this.bSF.setVisibility(8);
            return;
        }
        this.bSF.setVisibility(0);
        this.bSF.setText(i2);
    }

    public void setImageRes(int i) {
        if (i <= 0) {
            this.bSE.setVisibility(8);
            return;
        }
        this.bSE.setVisibility(0);
        this.bSE.setImageResource(i);
    }
}

package com.baidu.adp.widget.ScrollView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a extends RelativeLayout implements b {
    private ProgressBar mProgress;
    private TextView vT;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate(context, R.layout.adp_detault_footer_layout, this);
        this.vT = (TextView) findViewById(R.id.foot_layout_text);
        this.mProgress = (ProgressBar) findViewById(R.id.foot_layout_progress);
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public void ib() {
        this.vT.setText(getResources().getString(R.string.adp_pull_up_to_get_more));
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public void hE() {
        this.vT.setText(getResources().getString(R.string.adp_release_to_get_more));
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public void hF() {
        this.vT.setText(getResources().getString(R.string.adp_refreshing));
        this.mProgress.setVisibility(0);
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public void ic() {
        this.vT.setText(getResources().getString(R.string.adp_pull_up_to_get_more));
        this.mProgress.setVisibility(8);
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public View getRealView() {
        return this;
    }
}

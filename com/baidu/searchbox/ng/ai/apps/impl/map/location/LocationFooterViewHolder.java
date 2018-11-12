package com.baidu.searchbox.ng.ai.apps.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class LocationFooterViewHolder extends RecyclerView.ViewHolder {
    private TextView mLoading;
    private ProgressBar mProgressBar;

    public LocationFooterViewHolder(View view) {
        super(view);
        init(view);
    }

    private void init(View view) {
        this.mLoading = (TextView) view.findViewById(e.g.loading_text);
        this.mProgressBar = (ProgressBar) view.findViewById(e.g.loading_progress);
    }

    public void setVisibility(boolean z) {
        this.itemView.setVisibility(z ? 0 : 4);
    }

    public void setText(String str) {
        this.mLoading.setText(str);
    }

    public void setLoadIconVisibility(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }
}

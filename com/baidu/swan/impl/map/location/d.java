package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class d extends RecyclerView.ViewHolder {
    private TextView bHw;
    private ProgressBar mProgressBar;

    public d(View view) {
        super(view);
        init(view);
    }

    private void init(View view) {
        this.bHw = (TextView) view.findViewById(R.id.loading_text);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.loading_progress);
    }

    public void dt(boolean z) {
        this.itemView.setVisibility(z ? 0 : 4);
    }
}

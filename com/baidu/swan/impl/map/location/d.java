package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class d extends RecyclerView.ViewHolder {
    private TextView bim;
    private ProgressBar mProgressBar;

    public d(View view) {
        super(view);
        init(view);
    }

    private void init(View view) {
        this.bim = (TextView) view.findViewById(d.g.loading_text);
        this.mProgressBar = (ProgressBar) view.findViewById(d.g.loading_progress);
    }

    public void cI(boolean z) {
        this.itemView.setVisibility(z ? 0 : 4);
    }
}

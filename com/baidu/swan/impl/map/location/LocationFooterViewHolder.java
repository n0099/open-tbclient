package com.baidu.swan.impl.map.location;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class LocationFooterViewHolder extends RecyclerView.ViewHolder {
    private TextView erI;
    private ProgressBar mProgressBar;

    public LocationFooterViewHolder(View view) {
        super(view);
        init(view);
    }

    private void init(View view) {
        this.erI = (TextView) view.findViewById(R.id.loading_text);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.loading_progress);
    }

    public void iv(boolean z) {
        this.itemView.setVisibility(z ? 0 : 4);
    }
}

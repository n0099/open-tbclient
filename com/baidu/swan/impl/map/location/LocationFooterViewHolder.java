package com.baidu.swan.impl.map.location;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class LocationFooterViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f12967a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f12968b;

    public LocationFooterViewHolder(View view) {
        super(view);
        a(view);
    }

    public final void a(View view) {
        this.f12967a = (TextView) view.findViewById(R.id.loading_text);
        this.f12968b = (ProgressBar) view.findViewById(R.id.loading_progress);
    }

    public void b(boolean z) {
        this.itemView.setVisibility(z ? 0 : 4);
    }
}

package com.baidu.swan.map.location;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import d.a.l0.j.e;
/* loaded from: classes3.dex */
public class LocationFooterViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f11841a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f11842b;

    public LocationFooterViewHolder(View view) {
        super(view);
        a(view);
    }

    public final void a(View view) {
        this.f11841a = (TextView) view.findViewById(e.loading_text);
        this.f11842b = (ProgressBar) view.findViewById(e.loading_progress);
    }

    public void b(boolean z) {
        this.itemView.setVisibility(z ? 0 : 4);
    }
}

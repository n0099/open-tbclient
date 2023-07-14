package com.baidu.live.business.base;

import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes3.dex */
public class LiveFeedBaseHolder extends RecyclerView.ViewHolder {
    public LiveBaseItemView a;

    public LiveFeedBaseHolder(LiveBaseItemView liveBaseItemView) {
        super(liveBaseItemView);
        this.a = liveBaseItemView;
    }

    public void b() {
        LiveBaseItemView liveBaseItemView = this.a;
        if (liveBaseItemView != null) {
            liveBaseItemView.a();
        }
    }

    public void c() {
        LiveBaseItemView liveBaseItemView = this.a;
        if (liveBaseItemView != null) {
            liveBaseItemView.b();
        }
    }

    public void d() {
        LiveBaseItemView liveBaseItemView = this.a;
        if (liveBaseItemView != null) {
            liveBaseItemView.c();
        }
    }
}

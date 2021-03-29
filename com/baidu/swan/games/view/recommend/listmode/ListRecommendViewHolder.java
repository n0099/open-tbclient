package com.baidu.swan.games.view.recommend.listmode;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import d.b.g0.a.f;
/* loaded from: classes3.dex */
public class ListRecommendViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public SimpleDraweeView f12916a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f12917b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f12918c;

    /* renamed from: d  reason: collision with root package name */
    public Button f12919d;

    public ListRecommendViewHolder(View view) {
        super(view);
        this.f12916a = (SimpleDraweeView) view.findViewById(f.swangame_recommend_item_icon);
        this.f12917b = (TextView) view.findViewById(f.swangame_recommend_item_name);
        this.f12918c = (TextView) view.findViewById(f.swangame_recommend_item_detail);
        this.f12919d = (Button) view.findViewById(f.swangame_recommend_item_play);
    }
}

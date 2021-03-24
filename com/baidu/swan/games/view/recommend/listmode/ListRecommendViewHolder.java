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
    public SimpleDraweeView f12915a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f12916b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f12917c;

    /* renamed from: d  reason: collision with root package name */
    public Button f12918d;

    public ListRecommendViewHolder(View view) {
        super(view);
        this.f12915a = (SimpleDraweeView) view.findViewById(f.swangame_recommend_item_icon);
        this.f12916b = (TextView) view.findViewById(f.swangame_recommend_item_name);
        this.f12917c = (TextView) view.findViewById(f.swangame_recommend_item_detail);
        this.f12918d = (Button) view.findViewById(f.swangame_recommend_item_play);
    }
}

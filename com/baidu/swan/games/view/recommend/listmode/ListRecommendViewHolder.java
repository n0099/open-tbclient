package com.baidu.swan.games.view.recommend.listmode;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import d.a.l0.f.e;
/* loaded from: classes3.dex */
public class ListRecommendViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public SimpleDraweeView f11724a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f11725b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f11726c;

    /* renamed from: d  reason: collision with root package name */
    public Button f11727d;

    public ListRecommendViewHolder(View view) {
        super(view);
        this.f11724a = (SimpleDraweeView) view.findViewById(e.swangame_recommend_item_icon);
        this.f11725b = (TextView) view.findViewById(e.swangame_recommend_item_name);
        this.f11726c = (TextView) view.findViewById(e.swangame_recommend_item_detail);
        this.f11727d = (Button) view.findViewById(e.swangame_recommend_item_play);
    }
}

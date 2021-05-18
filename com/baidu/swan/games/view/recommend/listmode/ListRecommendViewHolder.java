package com.baidu.swan.games.view.recommend.listmode;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import d.a.i0.f.e;
/* loaded from: classes3.dex */
public class ListRecommendViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public SimpleDraweeView f11823a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f11824b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f11825c;

    /* renamed from: d  reason: collision with root package name */
    public Button f11826d;

    public ListRecommendViewHolder(View view) {
        super(view);
        this.f11823a = (SimpleDraweeView) view.findViewById(e.swangame_recommend_item_icon);
        this.f11824b = (TextView) view.findViewById(e.swangame_recommend_item_name);
        this.f11825c = (TextView) view.findViewById(e.swangame_recommend_item_detail);
        this.f11826d = (Button) view.findViewById(e.swangame_recommend_item_play);
    }
}

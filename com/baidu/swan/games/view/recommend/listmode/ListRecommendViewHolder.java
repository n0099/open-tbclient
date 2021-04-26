package com.baidu.swan.games.view.recommend.listmode;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import d.a.h0.a.f;
/* loaded from: classes3.dex */
public class ListRecommendViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public SimpleDraweeView f12481a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f12482b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f12483c;

    /* renamed from: d  reason: collision with root package name */
    public Button f12484d;

    public ListRecommendViewHolder(View view) {
        super(view);
        this.f12481a = (SimpleDraweeView) view.findViewById(f.swangame_recommend_item_icon);
        this.f12482b = (TextView) view.findViewById(f.swangame_recommend_item_name);
        this.f12483c = (TextView) view.findViewById(f.swangame_recommend_item_detail);
        this.f12484d = (Button) view.findViewById(f.swangame_recommend_item_play);
    }
}

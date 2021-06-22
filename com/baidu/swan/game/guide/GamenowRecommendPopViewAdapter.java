package com.baidu.swan.game.guide;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import d.a.m0.f.j.h;
import d.a.m0.f.j.i;
import d.a.m0.f.j.n.c;
import d.a.m0.f.j.r.b;
import java.util.List;
/* loaded from: classes3.dex */
public class GamenowRecommendPopViewAdapter extends RecyclerView.Adapter<a> implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Context f11718e;

    /* renamed from: f  reason: collision with root package name */
    public List<GameGuideConfigInfo.RecommendGameInfo> f11719f;

    /* loaded from: classes3.dex */
    public class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f11720a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f11721b;

        public a(GamenowRecommendPopViewAdapter gamenowRecommendPopViewAdapter, View view) {
            super(view);
            this.f11720a = (SimpleDraweeView) view.findViewById(h.dv_icon);
            this.f11721b = (TextView) view.findViewById(h.tv_name);
        }
    }

    public GamenowRecommendPopViewAdapter(Context context, List<GameGuideConfigInfo.RecommendGameInfo> list) {
        this.f11718e = context;
        this.f11719f = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(a aVar, int i2) {
        GameGuideConfigInfo.RecommendGameInfo recommendGameInfo = this.f11719f.get(i2);
        if (recommendGameInfo == null) {
            return;
        }
        aVar.f11720a.setController(Fresco.newDraweeControllerBuilder().setUri(recommendGameInfo.iconUrl).build());
        aVar.f11721b.setText(recommendGameInfo.appName);
        aVar.itemView.setTag(Integer.valueOf(i2));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        a aVar = new a(this, LayoutInflater.from(this.f11718e).inflate(i.aiapps_gamenow_recommend_item_view, viewGroup, false));
        aVar.itemView.setOnClickListener(this);
        return aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f11719f.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue;
        if (view.getTag() != null && (intValue = ((Integer) view.getTag()).intValue()) < this.f11719f.size()) {
            GameGuideConfigInfo.RecommendGameInfo recommendGameInfo = this.f11719f.get(intValue);
            if (TextUtils.isEmpty(recommendGameInfo.appKey)) {
                return;
            }
            b.n().b("gbBDialogClick", "3", recommendGameInfo.appKey, String.valueOf(intValue));
            c.n().A(recommendGameInfo.appKey, recommendGameInfo.appName, recommendGameInfo.iconUrl, intValue);
        }
    }
}

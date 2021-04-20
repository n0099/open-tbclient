package com.baidu.swan.games.view.recommend.popview;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import d.b.g0.a.f;
import d.b.g0.a.g;
import d.b.g0.g.k0.i.b.c;
import d.b.g0.g.k0.i.b.e;
import d.b.g0.g.k0.i.f.d;
import java.util.List;
/* loaded from: classes3.dex */
public class GameGuideAdapter extends RecyclerView.Adapter<a> implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Context f12592e;

    /* renamed from: f  reason: collision with root package name */
    public List<RecommendItemModel> f12593f;

    /* renamed from: g  reason: collision with root package name */
    public c f12594g = new c();

    /* loaded from: classes3.dex */
    public class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f12595a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f12596b;

        public a(GameGuideAdapter gameGuideAdapter, View view) {
            super(view);
            this.f12595a = (SimpleDraweeView) view.findViewById(f.dv_icon);
            this.f12596b = (TextView) view.findViewById(f.tv_name);
        }
    }

    public GameGuideAdapter(Context context, List<RecommendItemModel> list) {
        this.f12592e = context;
        this.f12593f = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(a aVar, int i) {
        RecommendItemModel recommendItemModel = this.f12593f.get(i);
        if (recommendItemModel == null) {
            return;
        }
        aVar.f12595a.setController(Fresco.newDraweeControllerBuilder().setUri(recommendItemModel.getIconUrl()).build());
        aVar.f12596b.setText(recommendItemModel.getAppName());
        aVar.itemView.setTag(Integer.valueOf(i));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        a aVar = new a(this, LayoutInflater.from(this.f12592e).inflate(g.swangame_game_close_guide_item_view, (ViewGroup) null));
        aVar.itemView.setOnClickListener(this);
        d.a(aVar.itemView);
        return aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f12593f.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue;
        if (view.getTag() != null && (intValue = ((Integer) view.getTag()).intValue()) < this.f12593f.size()) {
            RecommendItemModel recommendItemModel = this.f12593f.get(intValue);
            if (TextUtils.isEmpty(recommendItemModel.getScheme()) || TextUtils.isEmpty(recommendItemModel.getAppKey())) {
                return;
            }
            SchemeRouter.invokeSchemeForInner(this.f12592e, Uri.parse(recommendItemModel.getScheme()));
            e.d(4, recommendItemModel.getAppKey());
            this.f12594g.b(3, "popview", recommendItemModel.getAppKey(), String.valueOf(intValue + 1));
        }
    }
}

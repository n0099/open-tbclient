package com.baidu.swan.games.view.recommend.popview;

import android.annotation.SuppressLint;
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
import d.a.l0.f.e;
import d.a.l0.f.f;
import d.a.l0.h.o0.g.b.c;
import java.util.List;
/* loaded from: classes3.dex */
public class GameGuideAdapter extends RecyclerView.Adapter<a> implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Context f11740e;

    /* renamed from: f  reason: collision with root package name */
    public List<RecommendItemModel> f11741f;

    /* renamed from: g  reason: collision with root package name */
    public c f11742g = new c();

    /* loaded from: classes3.dex */
    public class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f11743a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f11744b;

        public a(GameGuideAdapter gameGuideAdapter, View view) {
            super(view);
            this.f11743a = (SimpleDraweeView) view.findViewById(e.dv_icon);
            this.f11744b = (TextView) view.findViewById(e.tv_name);
        }
    }

    public GameGuideAdapter(Context context, List<RecommendItemModel> list) {
        this.f11740e = context;
        this.f11741f = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(a aVar, int i2) {
        RecommendItemModel recommendItemModel = this.f11741f.get(i2);
        if (recommendItemModel == null) {
            return;
        }
        aVar.f11743a.setController(Fresco.newDraweeControllerBuilder().setUri(recommendItemModel.getIconUrl()).build());
        aVar.f11744b.setText(recommendItemModel.getAppName());
        aVar.itemView.setTag(Integer.valueOf(i2));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"InflateParams"})
    /* renamed from: d */
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        a aVar = new a(this, LayoutInflater.from(this.f11740e).inflate(f.swangame_game_close_guide_item_view, (ViewGroup) null));
        aVar.itemView.setOnClickListener(this);
        d.a.l0.h.o0.g.f.e.a(aVar.itemView);
        return aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f11741f.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue;
        if (view.getTag() != null && (intValue = ((Integer) view.getTag()).intValue()) < this.f11741f.size()) {
            RecommendItemModel recommendItemModel = this.f11741f.get(intValue);
            if (TextUtils.isEmpty(recommendItemModel.getScheme()) || TextUtils.isEmpty(recommendItemModel.getAppKey())) {
                return;
            }
            SchemeRouter.invokeSchemeForInner(this.f11740e, Uri.parse(recommendItemModel.getScheme()));
            d.a.l0.h.o0.g.b.e.d(4, recommendItemModel.getAppKey());
            this.f11742g.b(3, "popview", recommendItemModel.getAppKey(), String.valueOf(intValue + 1));
        }
    }
}

package com.baidu.swan.games.view.recommend.popview;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.a;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends RecyclerView.Adapter<C0340a> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.a.c cqm = new com.baidu.swan.games.view.recommend.a.c();
    private List<RecommendItemModel> cqr;
    private Context mContext;

    public a(Context context, List<RecommendItemModel> list) {
        this.mContext = context;
        this.cqr = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: f */
    public C0340a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0340a c0340a = new C0340a(LayoutInflater.from(this.mContext).inflate(a.g.swangame_game_close_guide_item_view, (ViewGroup) null));
        c0340a.itemView.setOnClickListener(this);
        e.aA(c0340a.itemView);
        return c0340a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0340a c0340a, int i) {
        RecommendItemModel recommendItemModel = this.cqr.get(i);
        if (recommendItemModel != null) {
            c0340a.cqs.setController(com.facebook.drawee.a.a.c.djg().Oy(recommendItemModel.getIconUrl()).djX());
            c0340a.textView.setText(recommendItemModel.getAppName());
            c0340a.itemView.setTag(Integer.valueOf(i));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cqr.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue;
        if (view.getTag() != null && (intValue = ((Integer) view.getTag()).intValue()) < this.cqr.size()) {
            RecommendItemModel recommendItemModel = this.cqr.get(intValue);
            if (!TextUtils.isEmpty(recommendItemModel.getScheme()) && !TextUtils.isEmpty(recommendItemModel.getAppKey())) {
                SchemeRouter.invokeSchemeForInner(this.mContext, Uri.parse(recommendItemModel.getScheme()));
                com.baidu.swan.games.view.recommend.a.e.H(4, recommendItemModel.getAppKey());
                this.cqm.c(3, "popview", recommendItemModel.getAppKey(), String.valueOf(intValue + 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.view.recommend.popview.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0340a extends RecyclerView.ViewHolder {
        public SimpleDraweeView cqs;
        public TextView textView;

        public C0340a(View view) {
            super(view);
            this.cqs = (SimpleDraweeView) view.findViewById(a.f.dv_icon);
            this.textView = (TextView) view.findViewById(a.f.tv_name);
        }
    }
}

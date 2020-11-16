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
/* loaded from: classes7.dex */
public class a extends RecyclerView.Adapter<C0547a> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.a.c eao = new com.baidu.swan.games.view.recommend.a.c();
    private List<RecommendItemModel> eat;
    private Context mContext;

    public a(Context context, List<RecommendItemModel> list) {
        this.mContext = context;
        this.eat = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: d */
    public C0547a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0547a c0547a = new C0547a(LayoutInflater.from(this.mContext).inflate(a.g.swangame_game_close_guide_item_view, (ViewGroup) null));
        c0547a.itemView.setOnClickListener(this);
        e.aT(c0547a.itemView);
        return c0547a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0547a c0547a, int i) {
        RecommendItemModel recommendItemModel = this.eat.get(i);
        if (recommendItemModel != null) {
            c0547a.eau.setController(com.facebook.drawee.a.a.c.ekQ().XP(recommendItemModel.getIconUrl()).elH());
            c0547a.textView.setText(recommendItemModel.getAppName());
            c0547a.itemView.setTag(Integer.valueOf(i));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.eat.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue;
        if (view.getTag() != null && (intValue = ((Integer) view.getTag()).intValue()) < this.eat.size()) {
            RecommendItemModel recommendItemModel = this.eat.get(intValue);
            if (!TextUtils.isEmpty(recommendItemModel.getScheme()) && !TextUtils.isEmpty(recommendItemModel.getAppKey())) {
                SchemeRouter.invokeSchemeForInner(this.mContext, Uri.parse(recommendItemModel.getScheme()));
                com.baidu.swan.games.view.recommend.a.e.az(4, recommendItemModel.getAppKey());
                this.eao.c(3, "popview", recommendItemModel.getAppKey(), String.valueOf(intValue + 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.view.recommend.popview.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0547a extends RecyclerView.ViewHolder {
        public SimpleDraweeView eau;
        public TextView textView;

        public C0547a(View view) {
            super(view);
            this.eau = (SimpleDraweeView) view.findViewById(a.f.dv_icon);
            this.textView = (TextView) view.findViewById(a.f.tv_name);
        }
    }
}

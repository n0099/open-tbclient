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
/* loaded from: classes10.dex */
public class a extends RecyclerView.Adapter<C0537a> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.a.c dWe = new com.baidu.swan.games.view.recommend.a.c();
    private List<RecommendItemModel> dWj;
    private Context mContext;

    public a(Context context, List<RecommendItemModel> list) {
        this.mContext = context;
        this.dWj = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: d */
    public C0537a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0537a c0537a = new C0537a(LayoutInflater.from(this.mContext).inflate(a.g.swangame_game_close_guide_item_view, (ViewGroup) null));
        c0537a.itemView.setOnClickListener(this);
        e.aP(c0537a.itemView);
        return c0537a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0537a c0537a, int i) {
        RecommendItemModel recommendItemModel = this.dWj.get(i);
        if (recommendItemModel != null) {
            c0537a.dWk.setController(com.facebook.drawee.a.a.c.ehd().XA(recommendItemModel.getIconUrl()).ehU());
            c0537a.textView.setText(recommendItemModel.getAppName());
            c0537a.itemView.setTag(Integer.valueOf(i));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dWj.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue;
        if (view.getTag() != null && (intValue = ((Integer) view.getTag()).intValue()) < this.dWj.size()) {
            RecommendItemModel recommendItemModel = this.dWj.get(intValue);
            if (!TextUtils.isEmpty(recommendItemModel.getScheme()) && !TextUtils.isEmpty(recommendItemModel.getAppKey())) {
                SchemeRouter.invokeSchemeForInner(this.mContext, Uri.parse(recommendItemModel.getScheme()));
                com.baidu.swan.games.view.recommend.a.e.av(4, recommendItemModel.getAppKey());
                this.dWe.c(3, "popview", recommendItemModel.getAppKey(), String.valueOf(intValue + 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.view.recommend.popview.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0537a extends RecyclerView.ViewHolder {
        public SimpleDraweeView dWk;
        public TextView textView;

        public C0537a(View view) {
            super(view);
            this.dWk = (SimpleDraweeView) view.findViewById(a.f.dv_icon);
            this.textView = (TextView) view.findViewById(a.f.tv_name);
        }
    }
}

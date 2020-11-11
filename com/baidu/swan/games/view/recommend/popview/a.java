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
public class a extends RecyclerView.Adapter<C0549a> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.a.c ebW = new com.baidu.swan.games.view.recommend.a.c();
    private List<RecommendItemModel> ecb;
    private Context mContext;

    public a(Context context, List<RecommendItemModel> list) {
        this.mContext = context;
        this.ecb = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: d */
    public C0549a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0549a c0549a = new C0549a(LayoutInflater.from(this.mContext).inflate(a.g.swangame_game_close_guide_item_view, (ViewGroup) null));
        c0549a.itemView.setOnClickListener(this);
        e.aT(c0549a.itemView);
        return c0549a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0549a c0549a, int i) {
        RecommendItemModel recommendItemModel = this.ecb.get(i);
        if (recommendItemModel != null) {
            c0549a.ecc.setController(com.facebook.drawee.a.a.c.ekS().Ye(recommendItemModel.getIconUrl()).elJ());
            c0549a.textView.setText(recommendItemModel.getAppName());
            c0549a.itemView.setTag(Integer.valueOf(i));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.ecb.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue;
        if (view.getTag() != null && (intValue = ((Integer) view.getTag()).intValue()) < this.ecb.size()) {
            RecommendItemModel recommendItemModel = this.ecb.get(intValue);
            if (!TextUtils.isEmpty(recommendItemModel.getScheme()) && !TextUtils.isEmpty(recommendItemModel.getAppKey())) {
                SchemeRouter.invokeSchemeForInner(this.mContext, Uri.parse(recommendItemModel.getScheme()));
                com.baidu.swan.games.view.recommend.a.e.az(4, recommendItemModel.getAppKey());
                this.ebW.c(3, "popview", recommendItemModel.getAppKey(), String.valueOf(intValue + 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.view.recommend.popview.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0549a extends RecyclerView.ViewHolder {
        public SimpleDraweeView ecc;
        public TextView textView;

        public C0549a(View view) {
            super(view);
            this.ecc = (SimpleDraweeView) view.findViewById(a.f.dv_icon);
            this.textView = (TextView) view.findViewById(a.f.tv_name);
        }
    }
}

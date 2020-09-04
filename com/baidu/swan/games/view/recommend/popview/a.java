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
/* loaded from: classes8.dex */
public class a extends RecyclerView.Adapter<C0511a> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.a.c dzF = new com.baidu.swan.games.view.recommend.a.c();
    private List<RecommendItemModel> dzK;
    private Context mContext;

    public a(Context context, List<RecommendItemModel> list) {
        this.mContext = context;
        this.dzK = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: d */
    public C0511a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0511a c0511a = new C0511a(LayoutInflater.from(this.mContext).inflate(a.g.swangame_game_close_guide_item_view, (ViewGroup) null));
        c0511a.itemView.setOnClickListener(this);
        e.aL(c0511a.itemView);
        return c0511a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0511a c0511a, int i) {
        RecommendItemModel recommendItemModel = this.dzK.get(i);
        if (recommendItemModel != null) {
            c0511a.dzL.setController(com.facebook.drawee.a.a.c.dPw().Ux(recommendItemModel.getIconUrl()).dQn());
            c0511a.textView.setText(recommendItemModel.getAppName());
            c0511a.itemView.setTag(Integer.valueOf(i));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dzK.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue;
        if (view.getTag() != null && (intValue = ((Integer) view.getTag()).intValue()) < this.dzK.size()) {
            RecommendItemModel recommendItemModel = this.dzK.get(intValue);
            if (!TextUtils.isEmpty(recommendItemModel.getScheme()) && !TextUtils.isEmpty(recommendItemModel.getAppKey())) {
                SchemeRouter.invokeSchemeForInner(this.mContext, Uri.parse(recommendItemModel.getScheme()));
                com.baidu.swan.games.view.recommend.a.e.ah(4, recommendItemModel.getAppKey());
                this.dzF.c(3, "popview", recommendItemModel.getAppKey(), String.valueOf(intValue + 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.view.recommend.popview.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0511a extends RecyclerView.ViewHolder {
        public SimpleDraweeView dzL;
        public TextView textView;

        public C0511a(View view) {
            super(view);
            this.dzL = (SimpleDraweeView) view.findViewById(a.f.dv_icon);
            this.textView = (TextView) view.findViewById(a.f.tv_name);
        }
    }
}

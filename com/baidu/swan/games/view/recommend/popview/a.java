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
public class a extends RecyclerView.Adapter<C0463a> implements View.OnClickListener {
    private List<RecommendItemModel> dpE;
    private com.baidu.swan.games.view.recommend.a.c dpz = new com.baidu.swan.games.view.recommend.a.c();
    private Context mContext;

    public a(Context context, List<RecommendItemModel> list) {
        this.mContext = context;
        this.dpE = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: d */
    public C0463a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0463a c0463a = new C0463a(LayoutInflater.from(this.mContext).inflate(a.g.swangame_game_close_guide_item_view, (ViewGroup) null));
        c0463a.itemView.setOnClickListener(this);
        e.aJ(c0463a.itemView);
        return c0463a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0463a c0463a, int i) {
        RecommendItemModel recommendItemModel = this.dpE.get(i);
        if (recommendItemModel != null) {
            c0463a.dpF.setController(com.facebook.drawee.a.a.c.dDn().Rt(recommendItemModel.getIconUrl()).dEe());
            c0463a.textView.setText(recommendItemModel.getAppName());
            c0463a.itemView.setTag(Integer.valueOf(i));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dpE.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue;
        if (view.getTag() != null && (intValue = ((Integer) view.getTag()).intValue()) < this.dpE.size()) {
            RecommendItemModel recommendItemModel = this.dpE.get(intValue);
            if (!TextUtils.isEmpty(recommendItemModel.getScheme()) && !TextUtils.isEmpty(recommendItemModel.getAppKey())) {
                SchemeRouter.invokeSchemeForInner(this.mContext, Uri.parse(recommendItemModel.getScheme()));
                com.baidu.swan.games.view.recommend.a.e.aj(4, recommendItemModel.getAppKey());
                this.dpz.c(3, "popview", recommendItemModel.getAppKey(), String.valueOf(intValue + 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.view.recommend.popview.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0463a extends RecyclerView.ViewHolder {
        public SimpleDraweeView dpF;
        public TextView textView;

        public C0463a(View view) {
            super(view);
            this.dpF = (SimpleDraweeView) view.findViewById(a.f.dv_icon);
            this.textView = (TextView) view.findViewById(a.f.tv_name);
        }
    }
}

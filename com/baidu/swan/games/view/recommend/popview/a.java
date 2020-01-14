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
public class a extends RecyclerView.Adapter<C0342a> implements View.OnClickListener {
    private List<RecommendItemModel> cqD;
    private com.baidu.swan.games.view.recommend.a.c cqy = new com.baidu.swan.games.view.recommend.a.c();
    private Context mContext;

    public a(Context context, List<RecommendItemModel> list) {
        this.mContext = context;
        this.cqD = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: f */
    public C0342a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0342a c0342a = new C0342a(LayoutInflater.from(this.mContext).inflate(a.g.swangame_game_close_guide_item_view, (ViewGroup) null));
        c0342a.itemView.setOnClickListener(this);
        e.aE(c0342a.itemView);
        return c0342a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0342a c0342a, int i) {
        RecommendItemModel recommendItemModel = this.cqD.get(i);
        if (recommendItemModel != null) {
            c0342a.cqE.setController(com.facebook.drawee.a.a.c.dkj().OI(recommendItemModel.getIconUrl()).dla());
            c0342a.textView.setText(recommendItemModel.getAppName());
            c0342a.itemView.setTag(Integer.valueOf(i));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cqD.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue;
        if (view.getTag() != null && (intValue = ((Integer) view.getTag()).intValue()) < this.cqD.size()) {
            RecommendItemModel recommendItemModel = this.cqD.get(intValue);
            if (!TextUtils.isEmpty(recommendItemModel.getScheme()) && !TextUtils.isEmpty(recommendItemModel.getAppKey())) {
                SchemeRouter.invokeSchemeForInner(this.mContext, Uri.parse(recommendItemModel.getScheme()));
                com.baidu.swan.games.view.recommend.a.e.J(4, recommendItemModel.getAppKey());
                this.cqy.c(3, "popview", recommendItemModel.getAppKey(), String.valueOf(intValue + 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.view.recommend.popview.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0342a extends RecyclerView.ViewHolder {
        public SimpleDraweeView cqE;
        public TextView textView;

        public C0342a(View view) {
            super(view);
            this.cqE = (SimpleDraweeView) view.findViewById(a.f.dv_icon);
            this.textView = (TextView) view.findViewById(a.f.tv_name);
        }
    }
}

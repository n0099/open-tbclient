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
public class a extends RecyclerView.Adapter<C0523a> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.a.c dNH = new com.baidu.swan.games.view.recommend.a.c();
    private List<RecommendItemModel> dNM;
    private Context mContext;

    public a(Context context, List<RecommendItemModel> list) {
        this.mContext = context;
        this.dNM = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: d */
    public C0523a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0523a c0523a = new C0523a(LayoutInflater.from(this.mContext).inflate(a.g.swangame_game_close_guide_item_view, (ViewGroup) null));
        c0523a.itemView.setOnClickListener(this);
        e.aO(c0523a.itemView);
        return c0523a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0523a c0523a, int i) {
        RecommendItemModel recommendItemModel = this.dNM.get(i);
        if (recommendItemModel != null) {
            c0523a.dNN.setController(com.facebook.drawee.a.a.c.dXf().VN(recommendItemModel.getIconUrl()).dXW());
            c0523a.textView.setText(recommendItemModel.getAppName());
            c0523a.itemView.setTag(Integer.valueOf(i));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dNM.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue;
        if (view.getTag() != null && (intValue = ((Integer) view.getTag()).intValue()) < this.dNM.size()) {
            RecommendItemModel recommendItemModel = this.dNM.get(intValue);
            if (!TextUtils.isEmpty(recommendItemModel.getScheme()) && !TextUtils.isEmpty(recommendItemModel.getAppKey())) {
                SchemeRouter.invokeSchemeForInner(this.mContext, Uri.parse(recommendItemModel.getScheme()));
                com.baidu.swan.games.view.recommend.a.e.at(4, recommendItemModel.getAppKey());
                this.dNH.c(3, "popview", recommendItemModel.getAppKey(), String.valueOf(intValue + 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.view.recommend.popview.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0523a extends RecyclerView.ViewHolder {
        public SimpleDraweeView dNN;
        public TextView textView;

        public C0523a(View view) {
            super(view);
            this.dNN = (SimpleDraweeView) view.findViewById(a.f.dv_icon);
            this.textView = (TextView) view.findViewById(a.f.tv_name);
        }
    }
}

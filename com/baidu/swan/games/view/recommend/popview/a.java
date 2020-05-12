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
/* loaded from: classes11.dex */
public class a extends RecyclerView.Adapter<C0403a> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.a.c cTP = new com.baidu.swan.games.view.recommend.a.c();
    private List<RecommendItemModel> cTU;
    private Context mContext;

    public a(Context context, List<RecommendItemModel> list) {
        this.mContext = context;
        this.cTU = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: f */
    public C0403a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0403a c0403a = new C0403a(LayoutInflater.from(this.mContext).inflate(a.g.swangame_game_close_guide_item_view, (ViewGroup) null));
        c0403a.itemView.setOnClickListener(this);
        e.aF(c0403a.itemView);
        return c0403a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0403a c0403a, int i) {
        RecommendItemModel recommendItemModel = this.cTU.get(i);
        if (recommendItemModel != null) {
            c0403a.cTV.setController(com.facebook.drawee.a.a.c.dnN().Og(recommendItemModel.getIconUrl()).doE());
            c0403a.textView.setText(recommendItemModel.getAppName());
            c0403a.itemView.setTag(Integer.valueOf(i));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cTU.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue;
        if (view.getTag() != null && (intValue = ((Integer) view.getTag()).intValue()) < this.cTU.size()) {
            RecommendItemModel recommendItemModel = this.cTU.get(intValue);
            if (!TextUtils.isEmpty(recommendItemModel.getScheme()) && !TextUtils.isEmpty(recommendItemModel.getAppKey())) {
                SchemeRouter.invokeSchemeForInner(this.mContext, Uri.parse(recommendItemModel.getScheme()));
                com.baidu.swan.games.view.recommend.a.e.ac(4, recommendItemModel.getAppKey());
                this.cTP.c(3, "popview", recommendItemModel.getAppKey(), String.valueOf(intValue + 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.view.recommend.popview.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0403a extends RecyclerView.ViewHolder {
        public SimpleDraweeView cTV;
        public TextView textView;

        public C0403a(View view) {
            super(view);
            this.cTV = (SimpleDraweeView) view.findViewById(a.f.dv_icon);
            this.textView = (TextView) view.findViewById(a.f.tv_name);
        }
    }
}

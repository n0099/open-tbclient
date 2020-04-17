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
public class a extends RecyclerView.Adapter<C0382a> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.a.c cTK = new com.baidu.swan.games.view.recommend.a.c();
    private List<RecommendItemModel> cTP;
    private Context mContext;

    public a(Context context, List<RecommendItemModel> list) {
        this.mContext = context;
        this.cTP = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: f */
    public C0382a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0382a c0382a = new C0382a(LayoutInflater.from(this.mContext).inflate(a.g.swangame_game_close_guide_item_view, (ViewGroup) null));
        c0382a.itemView.setOnClickListener(this);
        e.aF(c0382a.itemView);
        return c0382a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0382a c0382a, int i) {
        RecommendItemModel recommendItemModel = this.cTP.get(i);
        if (recommendItemModel != null) {
            c0382a.cTQ.setController(com.facebook.drawee.a.a.c.dnP().Od(recommendItemModel.getIconUrl()).doG());
            c0382a.textView.setText(recommendItemModel.getAppName());
            c0382a.itemView.setTag(Integer.valueOf(i));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cTP.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue;
        if (view.getTag() != null && (intValue = ((Integer) view.getTag()).intValue()) < this.cTP.size()) {
            RecommendItemModel recommendItemModel = this.cTP.get(intValue);
            if (!TextUtils.isEmpty(recommendItemModel.getScheme()) && !TextUtils.isEmpty(recommendItemModel.getAppKey())) {
                SchemeRouter.invokeSchemeForInner(this.mContext, Uri.parse(recommendItemModel.getScheme()));
                com.baidu.swan.games.view.recommend.a.e.ac(4, recommendItemModel.getAppKey());
                this.cTK.c(3, "popview", recommendItemModel.getAppKey(), String.valueOf(intValue + 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.view.recommend.popview.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0382a extends RecyclerView.ViewHolder {
        public SimpleDraweeView cTQ;
        public TextView textView;

        public C0382a(View view) {
            super(view);
            this.cTQ = (SimpleDraweeView) view.findViewById(a.f.dv_icon);
            this.textView = (TextView) view.findViewById(a.f.tv_name);
        }
    }
}

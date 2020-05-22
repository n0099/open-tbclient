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
public class a extends RecyclerView.Adapter<C0444a> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.a.c deS = new com.baidu.swan.games.view.recommend.a.c();
    private List<RecommendItemModel> deX;
    private Context mContext;

    public a(Context context, List<RecommendItemModel> list) {
        this.mContext = context;
        this.deX = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: d */
    public C0444a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0444a c0444a = new C0444a(LayoutInflater.from(this.mContext).inflate(a.g.swangame_game_close_guide_item_view, (ViewGroup) null));
        c0444a.itemView.setOnClickListener(this);
        e.aE(c0444a.itemView);
        return c0444a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0444a c0444a, int i) {
        RecommendItemModel recommendItemModel = this.deX.get(i);
        if (recommendItemModel != null) {
            c0444a.deY.setController(com.facebook.drawee.a.a.c.dvf().PU(recommendItemModel.getIconUrl()).dvW());
            c0444a.textView.setText(recommendItemModel.getAppName());
            c0444a.itemView.setTag(Integer.valueOf(i));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.deX.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue;
        if (view.getTag() != null && (intValue = ((Integer) view.getTag()).intValue()) < this.deX.size()) {
            RecommendItemModel recommendItemModel = this.deX.get(intValue);
            if (!TextUtils.isEmpty(recommendItemModel.getScheme()) && !TextUtils.isEmpty(recommendItemModel.getAppKey())) {
                SchemeRouter.invokeSchemeForInner(this.mContext, Uri.parse(recommendItemModel.getScheme()));
                com.baidu.swan.games.view.recommend.a.e.ag(4, recommendItemModel.getAppKey());
                this.deS.c(3, "popview", recommendItemModel.getAppKey(), String.valueOf(intValue + 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.view.recommend.popview.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0444a extends RecyclerView.ViewHolder {
        public SimpleDraweeView deY;
        public TextView textView;

        public C0444a(View view) {
            super(view);
            this.deY = (SimpleDraweeView) view.findViewById(a.f.dv_icon);
            this.textView = (TextView) view.findViewById(a.f.tv_name);
        }
    }
}

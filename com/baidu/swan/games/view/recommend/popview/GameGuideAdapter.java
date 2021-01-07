package com.baidu.swan.games.view.recommend.popview;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.a;
import com.baidu.swan.games.view.recommend.a.e;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
/* loaded from: classes9.dex */
public class GameGuideAdapter extends RecyclerView.Adapter<a> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.a.c eqq = new com.baidu.swan.games.view.recommend.a.c();
    private List<RecommendItemModel> eqv;
    private Context mContext;

    public GameGuideAdapter(Context context, List<RecommendItemModel> list) {
        this.mContext = context;
        this.eqv = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(a.g.swangame_game_close_guide_item_view, (ViewGroup) null));
        aVar.itemView.setOnClickListener(this);
        d.be(aVar.itemView);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        RecommendItemModel recommendItemModel = this.eqv.get(i);
        if (recommendItemModel != null) {
            aVar.eqw.setController(com.facebook.drawee.a.a.c.euP().Zu(recommendItemModel.getIconUrl()).evG());
            aVar.textView.setText(recommendItemModel.getAppName());
            aVar.itemView.setTag(Integer.valueOf(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.eqv.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue;
        if (view.getTag() != null && (intValue = ((Integer) view.getTag()).intValue()) < this.eqv.size()) {
            RecommendItemModel recommendItemModel = this.eqv.get(intValue);
            if (!TextUtils.isEmpty(recommendItemModel.getScheme()) && !TextUtils.isEmpty(recommendItemModel.getAppKey())) {
                SchemeRouter.invokeSchemeForInner(this.mContext, Uri.parse(recommendItemModel.getScheme()));
                e.aB(4, recommendItemModel.getAppKey());
                this.eqq.c(3, "popview", recommendItemModel.getAppKey(), String.valueOf(intValue + 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ViewHolder {
        public SimpleDraweeView eqw;
        public TextView textView;

        public a(View view) {
            super(view);
            this.eqw = (SimpleDraweeView) view.findViewById(a.f.dv_icon);
            this.textView = (TextView) view.findViewById(a.f.tv_name);
        }
    }
}

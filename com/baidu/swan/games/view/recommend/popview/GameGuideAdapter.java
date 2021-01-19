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
/* loaded from: classes8.dex */
public class GameGuideAdapter extends RecyclerView.Adapter<a> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.a.c elB = new com.baidu.swan.games.view.recommend.a.c();
    private List<RecommendItemModel> elG;
    private Context mContext;

    public GameGuideAdapter(Context context, List<RecommendItemModel> list) {
        this.mContext = context;
        this.elG = list;
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
        RecommendItemModel recommendItemModel = this.elG.get(i);
        if (recommendItemModel != null) {
            aVar.elH.setController(com.facebook.drawee.a.a.c.eqV().Yn(recommendItemModel.getIconUrl()).erN());
            aVar.textView.setText(recommendItemModel.getAppName());
            aVar.itemView.setTag(Integer.valueOf(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.elG.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue;
        if (view.getTag() != null && (intValue = ((Integer) view.getTag()).intValue()) < this.elG.size()) {
            RecommendItemModel recommendItemModel = this.elG.get(intValue);
            if (!TextUtils.isEmpty(recommendItemModel.getScheme()) && !TextUtils.isEmpty(recommendItemModel.getAppKey())) {
                SchemeRouter.invokeSchemeForInner(this.mContext, Uri.parse(recommendItemModel.getScheme()));
                e.aC(4, recommendItemModel.getAppKey());
                this.elB.c(3, "popview", recommendItemModel.getAppKey(), String.valueOf(intValue + 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a extends RecyclerView.ViewHolder {
        public SimpleDraweeView elH;
        public TextView textView;

        public a(View view) {
            super(view);
            this.elH = (SimpleDraweeView) view.findViewById(a.f.dv_icon);
            this.textView = (TextView) view.findViewById(a.f.tv_name);
        }
    }
}

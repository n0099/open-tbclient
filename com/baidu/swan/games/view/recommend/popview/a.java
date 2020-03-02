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
public class a extends RecyclerView.Adapter<C0352a> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.a.c cuC = new com.baidu.swan.games.view.recommend.a.c();
    private List<RecommendItemModel> cuH;
    private Context mContext;

    public a(Context context, List<RecommendItemModel> list) {
        this.mContext = context;
        this.cuH = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: f */
    public C0352a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0352a c0352a = new C0352a(LayoutInflater.from(this.mContext).inflate(a.g.swangame_game_close_guide_item_view, (ViewGroup) null));
        c0352a.itemView.setOnClickListener(this);
        e.aE(c0352a.itemView);
        return c0352a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0352a c0352a, int i) {
        RecommendItemModel recommendItemModel = this.cuH.get(i);
        if (recommendItemModel != null) {
            c0352a.cuI.setController(com.facebook.drawee.a.a.c.dly().OV(recommendItemModel.getIconUrl()).dmp());
            c0352a.textView.setText(recommendItemModel.getAppName());
            c0352a.itemView.setTag(Integer.valueOf(i));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cuH.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue;
        if (view.getTag() != null && (intValue = ((Integer) view.getTag()).intValue()) < this.cuH.size()) {
            RecommendItemModel recommendItemModel = this.cuH.get(intValue);
            if (!TextUtils.isEmpty(recommendItemModel.getScheme()) && !TextUtils.isEmpty(recommendItemModel.getAppKey())) {
                SchemeRouter.invokeSchemeForInner(this.mContext, Uri.parse(recommendItemModel.getScheme()));
                com.baidu.swan.games.view.recommend.a.e.L(4, recommendItemModel.getAppKey());
                this.cuC.c(3, "popview", recommendItemModel.getAppKey(), String.valueOf(intValue + 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.view.recommend.popview.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0352a extends RecyclerView.ViewHolder {
        public SimpleDraweeView cuI;
        public TextView textView;

        public C0352a(View view) {
            super(view);
            this.cuI = (SimpleDraweeView) view.findViewById(a.f.dv_icon);
            this.textView = (TextView) view.findViewById(a.f.tv_name);
        }
    }
}

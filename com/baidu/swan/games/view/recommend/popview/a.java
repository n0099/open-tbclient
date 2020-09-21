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
/* loaded from: classes3.dex */
public class a extends RecyclerView.Adapter<C0506a> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.a.c dBG = new com.baidu.swan.games.view.recommend.a.c();
    private List<RecommendItemModel> dBL;
    private Context mContext;

    public a(Context context, List<RecommendItemModel> list) {
        this.mContext = context;
        this.dBL = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: d */
    public C0506a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0506a c0506a = new C0506a(LayoutInflater.from(this.mContext).inflate(a.g.swangame_game_close_guide_item_view, (ViewGroup) null));
        c0506a.itemView.setOnClickListener(this);
        e.aN(c0506a.itemView);
        return c0506a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0506a c0506a, int i) {
        RecommendItemModel recommendItemModel = this.dBL.get(i);
        if (recommendItemModel != null) {
            c0506a.dBM.setController(com.facebook.drawee.a.a.c.dTu().UZ(recommendItemModel.getIconUrl()).dUl());
            c0506a.textView.setText(recommendItemModel.getAppName());
            c0506a.itemView.setTag(Integer.valueOf(i));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dBL.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue;
        if (view.getTag() != null && (intValue = ((Integer) view.getTag()).intValue()) < this.dBL.size()) {
            RecommendItemModel recommendItemModel = this.dBL.get(intValue);
            if (!TextUtils.isEmpty(recommendItemModel.getScheme()) && !TextUtils.isEmpty(recommendItemModel.getAppKey())) {
                SchemeRouter.invokeSchemeForInner(this.mContext, Uri.parse(recommendItemModel.getScheme()));
                com.baidu.swan.games.view.recommend.a.e.ai(4, recommendItemModel.getAppKey());
                this.dBG.c(3, "popview", recommendItemModel.getAppKey(), String.valueOf(intValue + 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.view.recommend.popview.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0506a extends RecyclerView.ViewHolder {
        public SimpleDraweeView dBM;
        public TextView textView;

        public C0506a(View view) {
            super(view);
            this.dBM = (SimpleDraweeView) view.findViewById(a.f.dv_icon);
            this.textView = (TextView) view.findViewById(a.f.tv_name);
        }
    }
}

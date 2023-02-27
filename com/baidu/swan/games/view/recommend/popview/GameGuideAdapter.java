package com.baidu.swan.games.view.recommend.popview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.tieba.R;
import com.baidu.tieba.id4;
import com.baidu.tieba.vc4;
import com.baidu.tieba.xc4;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
/* loaded from: classes3.dex */
public class GameGuideAdapter extends RecyclerView.Adapter<a> implements View.OnClickListener {
    public Context a;
    public List<RecommendItemModel> b;
    public vc4 c = new vc4();

    /* loaded from: classes3.dex */
    public class a extends RecyclerView.ViewHolder {
        public SimpleDraweeView a;
        public TextView b;

        public a(GameGuideAdapter gameGuideAdapter, View view2) {
            super(view2);
            this.a = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f0908f7);
            this.b = (TextView) view2.findViewById(R.id.tv_name);
        }
    }

    public GameGuideAdapter(Context context, List<RecommendItemModel> list) {
        this.a = context;
        this.b = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"InflateParams"})
    /* renamed from: e */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        a aVar = new a(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0894, (ViewGroup) null));
        aVar.itemView.setOnClickListener(this);
        id4.a(aVar.itemView);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(a aVar, int i) {
        RecommendItemModel recommendItemModel = this.b.get(i);
        if (recommendItemModel == null) {
            return;
        }
        aVar.a.setController(Fresco.newDraweeControllerBuilder().setUri(recommendItemModel.getIconUrl()).build());
        aVar.b.setText(recommendItemModel.getAppName());
        aVar.itemView.setTag(Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int intValue;
        if (view2.getTag() == null || (intValue = ((Integer) view2.getTag()).intValue()) >= this.b.size()) {
            return;
        }
        RecommendItemModel recommendItemModel = this.b.get(intValue);
        if (!TextUtils.isEmpty(recommendItemModel.getScheme()) && !TextUtils.isEmpty(recommendItemModel.getAppKey())) {
            SchemeRouter.invokeSchemeForInner(this.a, Uri.parse(recommendItemModel.getScheme()));
            xc4.d(4, recommendItemModel.getAppKey());
            this.c.b(3, "popview", recommendItemModel.getAppKey(), String.valueOf(intValue + 1));
        }
    }
}

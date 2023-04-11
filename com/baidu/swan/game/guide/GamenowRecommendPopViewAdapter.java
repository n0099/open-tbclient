package com.baidu.swan.game.guide;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ey3;
import com.baidu.tieba.qy3;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
/* loaded from: classes3.dex */
public class GamenowRecommendPopViewAdapter extends RecyclerView.Adapter<a> implements View.OnClickListener {
    public Context a;
    public List<GameGuideConfigInfo.RecommendGameInfo> b;

    /* loaded from: classes3.dex */
    public class a extends RecyclerView.ViewHolder {
        public SimpleDraweeView a;
        public TextView b;

        public a(GamenowRecommendPopViewAdapter gamenowRecommendPopViewAdapter, View view2) {
            super(view2);
            this.a = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f09091e);
            this.b = (TextView) view2.findViewById(R.id.tv_name);
        }
    }

    public GamenowRecommendPopViewAdapter(Context context, List<GameGuideConfigInfo.RecommendGameInfo> list) {
        this.a = context;
        this.b = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k */
    public void onBindViewHolder(a aVar, int i) {
        GameGuideConfigInfo.RecommendGameInfo recommendGameInfo = this.b.get(i);
        if (recommendGameInfo == null) {
            return;
        }
        aVar.a.setController(Fresco.newDraweeControllerBuilder().setUri(recommendGameInfo.iconUrl).build());
        aVar.b.setText(recommendGameInfo.appName);
        aVar.itemView.setTag(Integer.valueOf(i));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        a aVar = new a(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d00ae, viewGroup, false));
        aVar.itemView.setOnClickListener(this);
        return aVar;
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
        GameGuideConfigInfo.RecommendGameInfo recommendGameInfo = this.b.get(intValue);
        if (TextUtils.isEmpty(recommendGameInfo.appKey)) {
            return;
        }
        qy3.n().b("gbBDialogClick", "3", recommendGameInfo.appKey, String.valueOf(intValue));
        ey3.n().A(recommendGameInfo.appKey, recommendGameInfo.appName, recommendGameInfo.iconUrl, intValue);
    }
}

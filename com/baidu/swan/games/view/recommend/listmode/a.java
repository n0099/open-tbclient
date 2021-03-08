package com.baidu.swan.games.view.recommend.listmode;

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.e;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.view.recommend.a.d;
import com.baidu.swan.games.view.recommend.listmode.ListRecommendAdapter;
/* loaded from: classes8.dex */
public class a extends com.baidu.swan.games.view.recommend.a.a {
    private g eoV;
    private View eoW;
    private View eoX;
    private ImageView eoY;
    private View eoZ;
    private ListRecommendAdapter epa;
    private RecyclerView mRecyclerView;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aZS() {
        View aZS = super.aZS();
        this.eoW = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.eoX = this.eoW.findViewById(a.f.swangame_recommend_dialog_content);
        this.eoZ = this.eoW.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.eoY = (ImageView) this.eoW.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.eoW.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new ListRecommendDivider(this.mContext));
        this.epa = new ListRecommendAdapter(this.mContext);
        this.mRecyclerView.setAdapter(this.epa);
        aX(aZS);
        return aZS;
    }

    private void initDialog() {
        g.a aG = new g.a(this.mContext).gT(true).gR(true).gW(false).aHY().aHZ().jb(17170445).aG(this.eoW);
        aG.gS(false);
        this.eoV = aG.aqn();
        e.b(f.aAo().azY(), this.eoV);
    }

    private void aX(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.listmode.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.eoD != null) {
                    a.this.eoD.aZZ();
                }
                a.this.bad();
            }
        });
        this.epa.a(new ListRecommendAdapter.a() { // from class: com.baidu.swan.games.view.recommend.listmode.a.2
            @Override // com.baidu.swan.games.view.recommend.listmode.ListRecommendAdapter.a
            public void lv(int i) {
                if (a.this.eoD != null) {
                    a.this.eoD.lr(i);
                }
                a.this.bae();
            }
        });
        this.eoW.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.listmode.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.eoC != null && a.this.eoD != null) {
                    a.this.eoD.aZY();
                }
                a.this.bae();
            }
        });
        this.eoY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.listmode.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bae();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        super.a(aVar);
        this.epa.a(aVar);
        bab();
    }

    private void bab() {
        SwanAppActivity azY = f.aAo().azY();
        float min = Math.min(azY != null && azY.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> aAb = f.aAo().aAb();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) aAb.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) aAb.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void bac() {
        boolean ail = com.baidu.swan.apps.t.a.axv().ail();
        this.eoZ.setVisibility(8);
        this.eoY.setImageResource(ail ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (ail) {
            this.eoX.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.listmode.a.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a.this.eoZ.getLayoutParams();
                    layoutParams.width = a.this.eoX.getWidth();
                    layoutParams.height = a.this.eoX.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    a.this.eoZ.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bad() {
        bac();
        if (this.eoV != null) {
            this.eoV.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bae() {
        if (this.eoV != null) {
            this.eoV.dismiss();
        }
    }
}

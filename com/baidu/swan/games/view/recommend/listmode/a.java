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
/* loaded from: classes9.dex */
public class a extends com.baidu.swan.games.view.recommend.a.a {
    private g ens;
    private View ent;
    private View enu;
    private ImageView enw;
    private View enx;
    private ListRecommendAdapter eny;
    private RecyclerView mRecyclerView;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aZP() {
        View aZP = super.aZP();
        this.ent = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.enu = this.ent.findViewById(a.f.swangame_recommend_dialog_content);
        this.enx = this.ent.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.enw = (ImageView) this.ent.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.ent.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new ListRecommendDivider(this.mContext));
        this.eny = new ListRecommendAdapter(this.mContext);
        this.mRecyclerView.setAdapter(this.eny);
        aX(aZP);
        return aZP;
    }

    private void initDialog() {
        g.a aG = new g.a(this.mContext).gT(true).gR(true).gW(false).aHV().aHW().ja(17170445).aG(this.ent);
        aG.gS(false);
        this.ens = aG.aqk();
        e.b(f.aAl().azV(), this.ens);
    }

    private void aX(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.listmode.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.emZ != null) {
                    a.this.emZ.aZW();
                }
                a.this.baa();
            }
        });
        this.eny.a(new ListRecommendAdapter.a() { // from class: com.baidu.swan.games.view.recommend.listmode.a.2
            @Override // com.baidu.swan.games.view.recommend.listmode.ListRecommendAdapter.a
            public void lu(int i) {
                if (a.this.emZ != null) {
                    a.this.emZ.lq(i);
                }
                a.this.bab();
            }
        });
        this.ent.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.listmode.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.emY != null && a.this.emZ != null) {
                    a.this.emZ.aZV();
                }
                a.this.bab();
            }
        });
        this.enw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.listmode.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bab();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        super.a(aVar);
        this.eny.a(aVar);
        aZY();
    }

    private void aZY() {
        SwanAppActivity azV = f.aAl().azV();
        float min = Math.min(azV != null && azV.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> azY = f.aAl().azY();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) azY.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) azY.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void aZZ() {
        boolean aii = com.baidu.swan.apps.t.a.axs().aii();
        this.enx.setVisibility(8);
        this.enw.setImageResource(aii ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (aii) {
            this.enu.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.listmode.a.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a.this.enx.getLayoutParams();
                    layoutParams.width = a.this.enu.getWidth();
                    layoutParams.height = a.this.enu.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    a.this.enx.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baa() {
        aZZ();
        if (this.ens != null) {
            this.ens.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bab() {
        if (this.ens != null) {
            this.ens.dismiss();
        }
    }
}

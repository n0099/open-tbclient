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
    private g elk;
    private View ell;
    private View elm;
    private ImageView eln;
    private View elo;
    private ListRecommendAdapter elp;
    private RecyclerView mRecyclerView;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aZC() {
        View aZC = super.aZC();
        this.ell = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.elm = this.ell.findViewById(a.f.swangame_recommend_dialog_content);
        this.elo = this.ell.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.eln = (ImageView) this.ell.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.ell.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new ListRecommendDivider(this.mContext));
        this.elp = new ListRecommendAdapter(this.mContext);
        this.mRecyclerView.setAdapter(this.elp);
        bb(aZC);
        return aZC;
    }

    private void initDialog() {
        g.a aK = new g.a(this.mContext).gR(true).gP(true).gU(false).aHC().aHD().iX(17170445).aK(this.ell);
        aK.gQ(false);
        this.elk = aK.apM();
        e.b(f.azN().azx(), this.elk);
    }

    private void bb(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.listmode.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.ekS != null) {
                    a.this.ekS.aZJ();
                }
                a.this.aZN();
            }
        });
        this.elp.a(new ListRecommendAdapter.a() { // from class: com.baidu.swan.games.view.recommend.listmode.a.2
            @Override // com.baidu.swan.games.view.recommend.listmode.ListRecommendAdapter.a
            public void lr(int i) {
                if (a.this.ekS != null) {
                    a.this.ekS.ln(i);
                }
                a.this.aZO();
            }
        });
        this.ell.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.listmode.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.ekR != null && a.this.ekS != null) {
                    a.this.ekS.aZI();
                }
                a.this.aZO();
            }
        });
        this.eln.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.listmode.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aZO();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        super.a(aVar);
        this.elp.a(aVar);
        aZL();
    }

    private void aZL() {
        SwanAppActivity azx = f.azN().azx();
        float min = Math.min(azx != null && azx.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> azA = f.azN().azA();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) azA.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) azA.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void aZM() {
        boolean ahK = com.baidu.swan.apps.t.a.awU().ahK();
        this.elo.setVisibility(8);
        this.eln.setImageResource(ahK ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (ahK) {
            this.elm.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.listmode.a.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a.this.elo.getLayoutParams();
                    layoutParams.width = a.this.elm.getWidth();
                    layoutParams.height = a.this.elm.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    a.this.elo.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZN() {
        aZM();
        if (this.elk != null) {
            this.elk.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZO() {
        if (this.elk != null) {
            this.elk.dismiss();
        }
    }
}

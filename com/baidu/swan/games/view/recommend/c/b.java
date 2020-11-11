package com.baidu.swan.games.view.recommend.c;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.e;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.view.recommend.c.a;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.games.view.recommend.a.a {
    private g ebF;
    private View ebG;
    private View ebH;
    private ImageView ebI;
    private View ebJ;
    private a ebK;
    private RecyclerView mRecyclerView;

    public b(@NonNull Context context, @NonNull com.baidu.swan.games.view.recommend.a.d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aYF() {
        View aYF = super.aYF();
        this.ebG = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.ebH = this.ebG.findViewById(a.f.swangame_recommend_dialog_content);
        this.ebJ = this.ebG.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.ebI = (ImageView) this.ebG.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.ebG.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new c(this.mContext));
        this.ebK = new a(this.mContext);
        this.mRecyclerView.setAdapter(this.ebK);
        aQ(aYF);
        return aYF;
    }

    private void initDialog() {
        g.a aA = new g.a(this.mContext).gr(true).gp(true).gu(false).aGZ().aHa().kg(17170445).aA(this.ebG);
        aA.gq(false);
        this.ebF = aA.apP();
        e.b(f.azO().azy(), this.ebF);
    }

    private void aQ(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.ebo != null) {
                    b.this.ebo.aYM();
                }
                b.this.aYQ();
            }
        });
        this.ebK.a(new a.InterfaceC0548a() { // from class: com.baidu.swan.games.view.recommend.c.b.2
            @Override // com.baidu.swan.games.view.recommend.c.a.InterfaceC0548a
            public void mv(int i) {
                if (b.this.ebo != null) {
                    b.this.ebo.mr(i);
                }
                b.this.aYR();
            }
        });
        this.ebG.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.ebn != null && b.this.ebo != null) {
                    b.this.ebo.aYL();
                }
                b.this.aYR();
            }
        });
        this.ebI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.aYR();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        super.a(aVar);
        this.ebK.a(aVar);
        aYO();
    }

    private void aYO() {
        SwanAppActivity azy = f.azO().azy();
        float min = Math.min(azy != null && azy.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> azB = f.azO().azB();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) azB.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) azB.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void aYP() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState();
        this.ebJ.setVisibility(8);
        this.ebI.setImageResource(nightModeSwitcherState ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (nightModeSwitcherState) {
            this.ebH.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b.this.ebJ.getLayoutParams();
                    layoutParams.width = b.this.ebH.getWidth();
                    layoutParams.height = b.this.ebH.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    b.this.ebJ.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYQ() {
        aYP();
        if (this.ebF != null) {
            this.ebF.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYR() {
        if (this.ebF != null) {
            this.ebF.dismiss();
        }
    }
}

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
/* loaded from: classes25.dex */
public class b extends com.baidu.swan.games.view.recommend.a.a {
    private g egX;
    private View egY;
    private View egZ;
    private ImageView eha;
    private View ehb;
    private a ehc;
    private RecyclerView mRecyclerView;

    public b(@NonNull Context context, @NonNull com.baidu.swan.games.view.recommend.a.d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View bbd() {
        View bbd = super.bbd();
        this.egY = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.egZ = this.egY.findViewById(a.f.swangame_recommend_dialog_content);
        this.ehb = this.egY.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.eha = (ImageView) this.egY.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.egY.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new c(this.mContext));
        this.ehc = new a(this.mContext);
        this.mRecyclerView.setAdapter(this.ehc);
        aS(bbd);
        return bbd;
    }

    private void initDialog() {
        g.a aC = new g.a(this.mContext).gJ(true).gH(true).gM(false).aJz().aJA().kA(17170445).aC(this.egY);
        aC.gI(false);
        this.egX = aC.asp();
        e.b(f.aCp().aBZ(), this.egX);
    }

    private void aS(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.egG != null) {
                    b.this.egG.bbk();
                }
                b.this.bbo();
            }
        });
        this.ehc.a(new a.InterfaceC0558a() { // from class: com.baidu.swan.games.view.recommend.c.b.2
            @Override // com.baidu.swan.games.view.recommend.c.a.InterfaceC0558a
            public void mP(int i) {
                if (b.this.egG != null) {
                    b.this.egG.mL(i);
                }
                b.this.bbp();
            }
        });
        this.egY.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.egF != null && b.this.egG != null) {
                    b.this.egG.bbj();
                }
                b.this.bbp();
            }
        });
        this.eha.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.bbp();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        super.a(aVar);
        this.ehc.a(aVar);
        bbm();
    }

    private void bbm() {
        SwanAppActivity aBZ = f.aCp().aBZ();
        float min = Math.min(aBZ != null && aBZ.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> aCc = f.aCp().aCc();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) aCc.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) aCc.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void bbn() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState();
        this.ehb.setVisibility(8);
        this.eha.setImageResource(nightModeSwitcherState ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (nightModeSwitcherState) {
            this.egZ.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b.this.ehb.getLayoutParams();
                    layoutParams.width = b.this.egZ.getWidth();
                    layoutParams.height = b.this.egZ.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    b.this.ehb.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbo() {
        bbn();
        if (this.egX != null) {
            this.egX.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbp() {
        if (this.egX != null) {
            this.egX.dismiss();
        }
    }
}

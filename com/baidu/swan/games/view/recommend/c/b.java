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
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.games.view.recommend.c.a;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.games.view.recommend.a.a {
    private g deB;
    private View deC;
    private View deD;
    private ImageView deE;
    private View deF;
    private a deG;
    private RecyclerView mRecyclerView;

    public b(@NonNull Context context, @NonNull com.baidu.swan.games.view.recommend.a.d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aDb() {
        View aDb = super.aDb();
        this.deC = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.deD = this.deC.findViewById(a.f.swangame_recommend_dialog_content);
        this.deF = this.deC.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.deE = (ImageView) this.deC.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.deC.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new c(this.mContext));
        this.deG = new a(this.mContext);
        this.mRecyclerView.setAdapter(this.deG);
        aB(aDb);
        return aDb;
    }

    private void initDialog() {
        g.a ao = new g.a(this.mContext).eT(true).eR(true).eW(false).aol().aom().gC(17170445).ao(this.deC);
        ao.eS(false);
        this.deB = ao.ZF();
        com.baidu.swan.apps.aq.d.b(f.ahV().ahF(), this.deB);
    }

    private void aB(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.dej != null) {
                    b.this.dej.aDi();
                }
                b.this.aDm();
            }
        });
        this.deG.a(new a.InterfaceC0443a() { // from class: com.baidu.swan.games.view.recommend.c.b.2
            @Override // com.baidu.swan.games.view.recommend.c.a.InterfaceC0443a
            public void iH(int i) {
                if (b.this.dej != null) {
                    b.this.dej.iD(i);
                }
                b.this.aDn();
            }
        });
        this.deC.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.dei != null && b.this.dej != null) {
                    b.this.dej.aDh();
                }
                b.this.aDn();
            }
        });
        this.deE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.aDn();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        super.a(aVar);
        this.deG.a(aVar);
        aDk();
    }

    private void aDk() {
        SwanAppActivity ahF = f.ahV().ahF();
        float min = Math.min(ahF != null && ahF.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> ahI = f.ahV().ahI();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) ahI.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) ahI.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void aDl() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState();
        this.deF.setVisibility(8);
        this.deE.setImageResource(nightModeSwitcherState ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (nightModeSwitcherState) {
            this.deD.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b.this.deF.getLayoutParams();
                    layoutParams.width = b.this.deD.getWidth();
                    layoutParams.height = b.this.deD.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    b.this.deF.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDm() {
        aDl();
        if (this.deB != null) {
            this.deB.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDn() {
        if (this.deB != null) {
            this.deB.dismiss();
        }
    }
}

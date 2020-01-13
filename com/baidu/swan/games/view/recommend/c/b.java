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
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.view.recommend.c.a;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.games.view.recommend.a.a {
    private g cqh;
    private View cqi;
    private View cqj;
    private ImageView cqk;
    private View cql;
    private a cqm;
    private RecyclerView mRecyclerView;

    public b(@NonNull Context context, @NonNull com.baidu.swan.games.view.recommend.a.d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aoF() {
        View aoF = super.aoF();
        this.cqi = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.cqj = this.cqi.findViewById(a.f.swangame_recommend_dialog_content);
        this.cql = this.cqi.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.cqk = (ImageView) this.cqi.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.cqi.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new c(this.mContext));
        this.cqm = new a(this.mContext);
        this.mRecyclerView.setAdapter(this.cqm);
        aB(aoF);
        return aoF;
    }

    private void initDialog() {
        g.a an = new g.a(this.mContext).dw(true).du(true).dz(false).ZX().ZY().fL(17170445).an(this.cqi);
        an.dv(false);
        this.cqh = an.MM();
        com.baidu.swan.apps.as.c.b(f.UC().Un(), this.cqh);
    }

    private void aB(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.cpQ != null) {
                    b.this.cpQ.aoM();
                }
                b.this.aoQ();
            }
        });
        this.cqm.a(new a.InterfaceC0341a() { // from class: com.baidu.swan.games.view.recommend.c.b.2
            @Override // com.baidu.swan.games.view.recommend.c.a.InterfaceC0341a
            public void hQ(int i) {
                if (b.this.cpQ != null) {
                    b.this.cpQ.hM(i);
                }
                b.this.aoR();
            }
        });
        this.cqi.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.cpP != null && b.this.cpQ != null) {
                    b.this.cpQ.aoL();
                }
                b.this.aoR();
            }
        });
        this.cqk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.aoR();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        super.a(aVar);
        this.cqm.a(aVar);
        aoO();
    }

    private void aoO() {
        SwanAppActivity Un = f.UC().Un();
        float min = Math.min(Un != null && Un.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> Uq = f.UC().Uq();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) Uq.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) Uq.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void aoP() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState();
        this.cql.setVisibility(8);
        this.cqk.setImageResource(nightModeSwitcherState ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (nightModeSwitcherState) {
            this.cqj.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b.this.cql.getLayoutParams();
                    layoutParams.width = b.this.cqj.getWidth();
                    layoutParams.height = b.this.cqj.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    b.this.cql.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoQ() {
        aoP();
        if (this.cqh != null) {
            this.cqh.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoR() {
        if (this.cqh != null) {
            this.cqh.dismiss();
        }
    }
}

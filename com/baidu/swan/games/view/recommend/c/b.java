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
/* loaded from: classes8.dex */
public class b extends com.baidu.swan.games.view.recommend.a.a {
    private g dzo;
    private View dzp;
    private View dzq;
    private ImageView dzr;
    private View dzs;
    private a dzt;
    private RecyclerView mRecyclerView;

    public b(@NonNull Context context, @NonNull com.baidu.swan.games.view.recommend.a.d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aQQ() {
        View aQQ = super.aQQ();
        this.dzp = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.dzq = this.dzp.findViewById(a.f.swangame_recommend_dialog_content);
        this.dzs = this.dzp.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.dzr = (ImageView) this.dzp.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.dzp.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new c(this.mContext));
        this.dzt = new a(this.mContext);
        this.mRecyclerView.setAdapter(this.dzt);
        aI(aQQ);
        return aQQ;
    }

    private void initDialog() {
        g.a as = new g.a(this.mContext).fB(true).fz(true).fE(false).azn().azo().jd(17170445).as(this.dzp);
        as.fA(false);
        this.dzo = as.ahZ();
        e.b(f.arY().arI(), this.dzo);
    }

    private void aI(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.dyX != null) {
                    b.this.dyX.aQX();
                }
                b.this.aRb();
            }
        });
        this.dzt.a(new a.InterfaceC0510a() { // from class: com.baidu.swan.games.view.recommend.c.b.2
            @Override // com.baidu.swan.games.view.recommend.c.a.InterfaceC0510a
            public void ls(int i) {
                if (b.this.dyX != null) {
                    b.this.dyX.lo(i);
                }
                b.this.aRc();
            }
        });
        this.dzp.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.dyW != null && b.this.dyX != null) {
                    b.this.dyX.aQW();
                }
                b.this.aRc();
            }
        });
        this.dzr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.aRc();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        super.a(aVar);
        this.dzt.a(aVar);
        aQZ();
    }

    private void aQZ() {
        SwanAppActivity arI = f.arY().arI();
        float min = Math.min(arI != null && arI.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> arL = f.arY().arL();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) arL.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) arL.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void aRa() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState();
        this.dzs.setVisibility(8);
        this.dzr.setImageResource(nightModeSwitcherState ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (nightModeSwitcherState) {
            this.dzq.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b.this.dzs.getLayoutParams();
                    layoutParams.width = b.this.dzq.getWidth();
                    layoutParams.height = b.this.dzq.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    b.this.dzs.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRb() {
        aRa();
        if (this.dzo != null) {
            this.dzo.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRc() {
        if (this.dzo != null) {
            this.dzo.dismiss();
        }
    }
}

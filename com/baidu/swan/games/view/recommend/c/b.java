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
    private g dNq;
    private View dNr;
    private View dNs;
    private ImageView dNt;
    private View dNu;
    private a dNv;
    private RecyclerView mRecyclerView;

    public b(@NonNull Context context, @NonNull com.baidu.swan.games.view.recommend.a.d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aUl() {
        View aUl = super.aUl();
        this.dNr = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.dNs = this.dNr.findViewById(a.f.swangame_recommend_dialog_content);
        this.dNu = this.dNr.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.dNt = (ImageView) this.dNr.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.dNr.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new c(this.mContext));
        this.dNv = new a(this.mContext);
        this.mRecyclerView.setAdapter(this.dNv);
        aL(aUl);
        return aUl;
    }

    private void initDialog() {
        g.a av = new g.a(this.mContext).fV(true).fT(true).fY(false).aCF().aCG().jL(17170445).av(this.dNr);
        av.fU(false);
        this.dNq = av.alu();
        e.b(f.avu().ave(), this.dNq);
    }

    private void aL(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.dMZ != null) {
                    b.this.dMZ.aUs();
                }
                b.this.aUw();
            }
        });
        this.dNv.a(new a.InterfaceC0522a() { // from class: com.baidu.swan.games.view.recommend.c.b.2
            @Override // com.baidu.swan.games.view.recommend.c.a.InterfaceC0522a
            public void ma(int i) {
                if (b.this.dMZ != null) {
                    b.this.dMZ.lW(i);
                }
                b.this.aUx();
            }
        });
        this.dNr.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.dMY != null && b.this.dMZ != null) {
                    b.this.dMZ.aUr();
                }
                b.this.aUx();
            }
        });
        this.dNt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.aUx();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        super.a(aVar);
        this.dNv.a(aVar);
        aUu();
    }

    private void aUu() {
        SwanAppActivity ave = f.avu().ave();
        float min = Math.min(ave != null && ave.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> avh = f.avu().avh();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) avh.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) avh.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void aUv() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.asC().getNightModeSwitcherState();
        this.dNu.setVisibility(8);
        this.dNt.setImageResource(nightModeSwitcherState ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (nightModeSwitcherState) {
            this.dNs.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b.this.dNu.getLayoutParams();
                    layoutParams.width = b.this.dNs.getWidth();
                    layoutParams.height = b.this.dNs.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    b.this.dNu.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUw() {
        aUv();
        if (this.dNq != null) {
            this.dNq.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUx() {
        if (this.dNq != null) {
            this.dNq.dismiss();
        }
    }
}

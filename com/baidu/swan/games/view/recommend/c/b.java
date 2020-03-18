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
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.games.view.recommend.a.a {
    private ImageView cuA;
    private View cuB;
    private a cuC;
    private g cux;
    private View cuy;
    private View cuz;
    private RecyclerView mRecyclerView;

    public b(@NonNull Context context, @NonNull com.baidu.swan.games.view.recommend.a.d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aqY() {
        View aqY = super.aqY();
        this.cuy = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.cuz = this.cuy.findViewById(a.f.swangame_recommend_dialog_content);
        this.cuB = this.cuy.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.cuA = (ImageView) this.cuy.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.cuy.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new c(this.mContext));
        this.cuC = new a(this.mContext);
        this.mRecyclerView.setAdapter(this.cuC);
        aB(aqY);
        return aqY;
    }

    private void initDialog() {
        g.a an = new g.a(this.mContext).dE(true).dC(true).dH(false).acq().acr().gb(17170445).an(this.cuy);
        an.dD(false);
        this.cux = an.Pf();
        com.baidu.swan.apps.as.c.b(f.WV().WG(), this.cux);
    }

    private void aB(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.cue != null) {
                    b.this.cue.arf();
                }
                b.this.arj();
            }
        });
        this.cuC.a(new a.InterfaceC0351a() { // from class: com.baidu.swan.games.view.recommend.c.b.2
            @Override // com.baidu.swan.games.view.recommend.c.a.InterfaceC0351a
            public void ih(int i) {
                if (b.this.cue != null) {
                    b.this.cue.id(i);
                }
                b.this.ark();
            }
        });
        this.cuy.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.cud != null && b.this.cue != null) {
                    b.this.cue.are();
                }
                b.this.ark();
            }
        });
        this.cuA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.ark();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        super.a(aVar);
        this.cuC.a(aVar);
        arh();
    }

    private void arh() {
        SwanAppActivity WG = f.WV().WG();
        float min = Math.min(WG != null && WG.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> WJ = f.WV().WJ();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) WJ.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) WJ.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void ari() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState();
        this.cuB.setVisibility(8);
        this.cuA.setImageResource(nightModeSwitcherState ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (nightModeSwitcherState) {
            this.cuz.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b.this.cuB.getLayoutParams();
                    layoutParams.width = b.this.cuz.getWidth();
                    layoutParams.height = b.this.cuz.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    b.this.cuB.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arj() {
        ari();
        if (this.cux != null) {
            this.cux.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ark() {
        if (this.cux != null) {
            this.cux.dismiss();
        }
    }
}

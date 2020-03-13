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
    private g cuk;
    private View cul;
    private View cum;
    private ImageView cun;
    private View cuo;
    private a cup;
    private RecyclerView mRecyclerView;

    public b(@NonNull Context context, @NonNull com.baidu.swan.games.view.recommend.a.d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aqV() {
        View aqV = super.aqV();
        this.cul = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.cum = this.cul.findViewById(a.f.swangame_recommend_dialog_content);
        this.cuo = this.cul.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.cun = (ImageView) this.cul.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.cul.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new c(this.mContext));
        this.cup = new a(this.mContext);
        this.mRecyclerView.setAdapter(this.cup);
        aB(aqV);
        return aqV;
    }

    private void initDialog() {
        g.a an = new g.a(this.mContext).dD(true).dB(true).dG(false).acn().aco().gb(17170445).an(this.cul);
        an.dC(false);
        this.cuk = an.Pc();
        com.baidu.swan.apps.as.c.b(f.WS().WD(), this.cuk);
    }

    private void aB(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.ctT != null) {
                    b.this.ctT.arc();
                }
                b.this.arg();
            }
        });
        this.cup.a(new a.InterfaceC0351a() { // from class: com.baidu.swan.games.view.recommend.c.b.2
            @Override // com.baidu.swan.games.view.recommend.c.a.InterfaceC0351a
            public void ih(int i) {
                if (b.this.ctT != null) {
                    b.this.ctT.id(i);
                }
                b.this.arh();
            }
        });
        this.cul.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.ctS != null && b.this.ctT != null) {
                    b.this.ctT.arb();
                }
                b.this.arh();
            }
        });
        this.cun.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.arh();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        super.a(aVar);
        this.cup.a(aVar);
        are();
    }

    private void are() {
        SwanAppActivity WD = f.WS().WD();
        float min = Math.min(WD != null && WD.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> WG = f.WS().WG();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) WG.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) WG.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void arf() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState();
        this.cuo.setVisibility(8);
        this.cun.setImageResource(nightModeSwitcherState ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (nightModeSwitcherState) {
            this.cum.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b.this.cuo.getLayoutParams();
                    layoutParams.width = b.this.cum.getWidth();
                    layoutParams.height = b.this.cum.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    b.this.cuo.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arg() {
        arf();
        if (this.cuk != null) {
            this.cuk.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arh() {
        if (this.cuk != null) {
            this.cuk.dismiss();
        }
    }
}

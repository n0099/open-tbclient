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
import com.baidu.swan.apps.w.e;
import com.baidu.swan.games.view.recommend.c.a;
/* loaded from: classes2.dex */
public class b extends com.baidu.swan.games.view.recommend.a.a {
    private g bGf;
    private View bGg;
    private View bGh;
    private ImageView bGi;
    private View bGj;
    private a bGk;
    private RecyclerView mRecyclerView;

    public b(@NonNull Context context, @NonNull com.baidu.swan.games.view.recommend.a.d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View YS() {
        View YS = super.YS();
        this.bGg = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.bGh = this.bGg.findViewById(a.f.swangame_recommend_dialog_content);
        this.bGj = this.bGg.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.bGi = (ImageView) this.bGg.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.bGg.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new c(this.mContext));
        this.bGk = new a(this.mContext);
        this.mRecyclerView.setAdapter(this.bGk);
        aC(YS);
        return YS;
    }

    private void initDialog() {
        g.a al = new g.a(this.mContext).cv(true).ct(true).cy(false).Qs().Qt().ew(17170445).al(this.bGg);
        al.cu(false);
        this.bGf = al.FW();
        com.baidu.swan.apps.an.b.b(e.LD().Lp(), this.bGf);
    }

    private void aC(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.bFN != null) {
                    b.this.bFN.YZ();
                }
                b.this.Zd();
            }
        });
        this.bGk.a(new a.InterfaceC0262a() { // from class: com.baidu.swan.games.view.recommend.c.b.2
            @Override // com.baidu.swan.games.view.recommend.c.a.InterfaceC0262a
            public void gm(int i) {
                if (b.this.bFN != null) {
                    b.this.bFN.gi(i);
                }
                b.this.Ze();
            }
        });
        this.bGg.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.bFM != null && b.this.bFN != null) {
                    b.this.bFN.YY();
                }
                b.this.Ze();
            }
        });
        this.bGi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.Ze();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.d.b bVar) {
        super.a(bVar);
        this.bGk.a(bVar);
        Zb();
    }

    private void Zb() {
        SwanAppActivity Lp = e.LD().Lp();
        float min = Math.min(Lp != null && Lp.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> Ls = e.LD().Ls();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) Ls.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) Ls.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void Zc() {
        boolean Kc = com.baidu.swan.apps.u.a.JD().Kc();
        this.bGj.setVisibility(8);
        this.bGi.setImageResource(Kc ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (Kc) {
            this.bGh.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b.this.bGj.getLayoutParams();
                    layoutParams.width = b.this.bGh.getWidth();
                    layoutParams.height = b.this.bGh.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    b.this.bGj.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zd() {
        Zc();
        if (this.bGf != null) {
            this.bGf.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ze() {
        if (this.bGf != null) {
            this.bGf.dismiss();
        }
    }
}

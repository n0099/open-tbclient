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
    private g bmh;
    private View bmi;
    private View bmj;
    private ImageView bmk;
    private View bml;
    private a bmm;
    private RecyclerView mRecyclerView;

    public b(@NonNull Context context, @NonNull com.baidu.swan.games.view.recommend.a.d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View Tf() {
        View Tf = super.Tf();
        this.bmi = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.bmj = this.bmi.findViewById(a.f.swangame_recommend_dialog_content);
        this.bml = this.bmi.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.bmk = (ImageView) this.bmi.findViewById(a.f.swangame_recommend_dialog_cancel);
        Tp();
        this.mRecyclerView = (RecyclerView) this.bmi.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new c(this.mContext));
        this.bmm = new a(this.mContext);
        this.mRecyclerView.setAdapter(this.bmm);
        au(Tf);
        return Tf;
    }

    private void Tp() {
        g.a ad = new g.a(this.mContext).cb(true).bZ(true).ce(false).KI().KJ().dx(17170445).ad(this.bmi);
        ad.ca(false);
        this.bmh = ad.Aq();
        com.baidu.swan.apps.an.b.a(e.FV().FH(), this.bmh);
    }

    private void au(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.blP != null) {
                    b.this.blP.Tn();
                }
                b.this.Ts();
            }
        });
        this.bmm.a(new a.InterfaceC0219a() { // from class: com.baidu.swan.games.view.recommend.c.b.2
            @Override // com.baidu.swan.games.view.recommend.c.a.InterfaceC0219a
            public void fm(int i) {
                if (b.this.blP != null) {
                    b.this.blP.fi(i);
                }
                b.this.Tt();
            }
        });
        this.bmi.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.blO != null && b.this.blP != null) {
                    b.this.blP.Tm();
                }
                b.this.Tt();
            }
        });
        this.bmk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.Tt();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.d.b bVar) {
        super.a(bVar);
        this.bmm.a(bVar);
        Tq();
    }

    private void Tq() {
        SwanAppActivity FH = e.FV().FH();
        float min = Math.min(FH != null && FH.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> FK = e.FV().FK();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) FK.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) FK.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void Tr() {
        boolean Ev = com.baidu.swan.apps.u.a.DW().Ev();
        this.bml.setVisibility(8);
        this.bmk.setImageResource(Ev ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (Ev) {
            this.bmj.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b.this.bml.getLayoutParams();
                    layoutParams.width = b.this.bmj.getWidth();
                    layoutParams.height = b.this.bmj.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    b.this.bml.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ts() {
        Tr();
        if (this.bmh != null) {
            this.bmh.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tt() {
        if (this.bmh != null) {
            this.bmh.dismiss();
        }
    }
}

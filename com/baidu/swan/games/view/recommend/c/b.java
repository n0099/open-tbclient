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
    private g djn;
    private View djo;
    private View djp;
    private ImageView djq;
    private View djr;
    private a djs;
    private RecyclerView mRecyclerView;

    public b(@NonNull Context context, @NonNull com.baidu.swan.games.view.recommend.a.d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aEh() {
        View aEh = super.aEh();
        this.djo = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.djp = this.djo.findViewById(a.f.swangame_recommend_dialog_content);
        this.djr = this.djo.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.djq = (ImageView) this.djo.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.djo.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new c(this.mContext));
        this.djs = new a(this.mContext);
        this.mRecyclerView.setAdapter(this.djs);
        aB(aEh);
        return aEh;
    }

    private void initDialog() {
        g.a ao = new g.a(this.mContext).eY(true).eW(true).fb(false).aps().apt().gN(17170445).ao(this.djo);
        ao.eX(false);
        this.djn = ao.aaL();
        com.baidu.swan.apps.aq.d.b(f.ajb().aiL(), this.djn);
    }

    private void aB(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.diW != null) {
                    b.this.diW.aEo();
                }
                b.this.aEs();
            }
        });
        this.djs.a(new a.InterfaceC0449a() { // from class: com.baidu.swan.games.view.recommend.c.b.2
            @Override // com.baidu.swan.games.view.recommend.c.a.InterfaceC0449a
            public void iS(int i) {
                if (b.this.diW != null) {
                    b.this.diW.iO(i);
                }
                b.this.aEt();
            }
        });
        this.djo.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.diV != null && b.this.diW != null) {
                    b.this.diW.aEn();
                }
                b.this.aEt();
            }
        });
        this.djq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.aEt();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        super.a(aVar);
        this.djs.a(aVar);
        aEq();
    }

    private void aEq() {
        SwanAppActivity aiL = f.ajb().aiL();
        float min = Math.min(aiL != null && aiL.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> aiO = f.ajb().aiO();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) aiO.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) aiO.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void aEr() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState();
        this.djr.setVisibility(8);
        this.djq.setImageResource(nightModeSwitcherState ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (nightModeSwitcherState) {
            this.djp.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b.this.djr.getLayoutParams();
                    layoutParams.width = b.this.djp.getWidth();
                    layoutParams.height = b.this.djp.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    b.this.djr.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEs() {
        aEr();
        if (this.djn != null) {
            this.djn.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEt() {
        if (this.djn != null) {
            this.djn.dismiss();
        }
    }
}

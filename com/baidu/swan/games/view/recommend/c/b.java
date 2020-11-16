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
/* loaded from: classes7.dex */
public class b extends com.baidu.swan.games.view.recommend.a.a {
    private g dZX;
    private View dZY;
    private View dZZ;
    private ImageView eaa;
    private View eab;
    private a eac;
    private RecyclerView mRecyclerView;

    public b(@NonNull Context context, @NonNull com.baidu.swan.games.view.recommend.a.d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aXY() {
        View aXY = super.aXY();
        this.dZY = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.dZZ = this.dZY.findViewById(a.f.swangame_recommend_dialog_content);
        this.eab = this.dZY.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.eaa = (ImageView) this.dZY.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.dZY.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new c(this.mContext));
        this.eac = new a(this.mContext);
        this.mRecyclerView.setAdapter(this.eac);
        aQ(aXY);
        return aXY;
    }

    private void initDialog() {
        g.a aA = new g.a(this.mContext).gu(true).gs(true).gx(false).aGr().aGs().kc(17170445).aA(this.dZY);
        aA.gt(false);
        this.dZX = aA.apg();
        e.b(f.azg().ayQ(), this.dZX);
    }

    private void aQ(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.dZG != null) {
                    b.this.dZG.aYf();
                }
                b.this.aYj();
            }
        });
        this.eac.a(new a.InterfaceC0546a() { // from class: com.baidu.swan.games.view.recommend.c.b.2
            @Override // com.baidu.swan.games.view.recommend.c.a.InterfaceC0546a
            public void mr(int i) {
                if (b.this.dZG != null) {
                    b.this.dZG.mn(i);
                }
                b.this.aYk();
            }
        });
        this.dZY.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.dZF != null && b.this.dZG != null) {
                    b.this.dZG.aYe();
                }
                b.this.aYk();
            }
        });
        this.eaa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.aYk();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        super.a(aVar);
        this.eac.a(aVar);
        aYh();
    }

    private void aYh() {
        SwanAppActivity ayQ = f.azg().ayQ();
        float min = Math.min(ayQ != null && ayQ.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> ayT = f.azg().ayT();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) ayT.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) ayT.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void aYi() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.awo().getNightModeSwitcherState();
        this.eab.setVisibility(8);
        this.eaa.setImageResource(nightModeSwitcherState ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (nightModeSwitcherState) {
            this.dZZ.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b.this.eab.getLayoutParams();
                    layoutParams.width = b.this.dZZ.getWidth();
                    layoutParams.height = b.this.dZZ.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    b.this.eab.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYj() {
        aYi();
        if (this.dZX != null) {
            this.dZX.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYk() {
        if (this.dZX != null) {
            this.dZX.dismiss();
        }
    }
}

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
/* loaded from: classes3.dex */
public class b extends com.baidu.swan.games.view.recommend.a.a {
    private g dBp;
    private View dBq;
    private View dBr;
    private ImageView dBs;
    private View dBt;
    private a dBu;
    private RecyclerView mRecyclerView;

    public b(@NonNull Context context, @NonNull com.baidu.swan.games.view.recommend.a.d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aRC() {
        View aRC = super.aRC();
        this.dBq = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.dBr = this.dBq.findViewById(a.f.swangame_recommend_dialog_content);
        this.dBt = this.dBq.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.dBs = (ImageView) this.dBq.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.dBq.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new c(this.mContext));
        this.dBu = new a(this.mContext);
        this.mRecyclerView.setAdapter(this.dBu);
        aK(aRC);
        return aRC;
    }

    private void initDialog() {
        g.a au = new g.a(this.mContext).fz(true).fx(true).fC(false).azW().azX().jo(17170445).au(this.dBq);
        au.fy(false);
        this.dBp = au.aiJ();
        e.b(f.asJ().ast(), this.dBp);
    }

    private void aK(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.dAY != null) {
                    b.this.dAY.aRJ();
                }
                b.this.aRN();
            }
        });
        this.dBu.a(new a.InterfaceC0505a() { // from class: com.baidu.swan.games.view.recommend.c.b.2
            @Override // com.baidu.swan.games.view.recommend.c.a.InterfaceC0505a
            public void lD(int i) {
                if (b.this.dAY != null) {
                    b.this.dAY.lz(i);
                }
                b.this.aRO();
            }
        });
        this.dBq.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.dAX != null && b.this.dAY != null) {
                    b.this.dAY.aRI();
                }
                b.this.aRO();
            }
        });
        this.dBs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.aRO();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        super.a(aVar);
        this.dBu.a(aVar);
        aRL();
    }

    private void aRL() {
        SwanAppActivity ast = f.asJ().ast();
        float min = Math.min(ast != null && ast.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> asw = f.asJ().asw();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) asw.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) asw.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void aRM() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.apQ().getNightModeSwitcherState();
        this.dBt.setVisibility(8);
        this.dBs.setImageResource(nightModeSwitcherState ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (nightModeSwitcherState) {
            this.dBr.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b.this.dBt.getLayoutParams();
                    layoutParams.width = b.this.dBr.getWidth();
                    layoutParams.height = b.this.dBr.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    b.this.dBt.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRN() {
        aRM();
        if (this.dBp != null) {
            this.dBp.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRO() {
        if (this.dBp != null) {
            this.dBp.dismiss();
        }
    }
}

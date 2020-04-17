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
    private g cTt;
    private View cTu;
    private View cTv;
    private ImageView cTw;
    private View cTx;
    private a cTy;
    private RecyclerView mRecyclerView;

    public b(@NonNull Context context, @NonNull com.baidu.swan.games.view.recommend.a.d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View azj() {
        View azj = super.azj();
        this.cTu = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.cTv = this.cTu.findViewById(a.f.swangame_recommend_dialog_content);
        this.cTx = this.cTu.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.cTw = (ImageView) this.cTu.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.cTu.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new c(this.mContext));
        this.cTy = new a(this.mContext);
        this.mRecyclerView.setAdapter(this.cTy);
        aC(azj);
        return azj;
    }

    private void initDialog() {
        g.a ao = new g.a(this.mContext).eA(true).ey(true).eD(false).akv().akw().gi(17170445).ao(this.cTu);
        ao.ez(false);
        this.cTt = ao.WU();
        com.baidu.swan.apps.as.c.b(f.aeK().aev(), this.cTt);
    }

    private void aC(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.cTc != null) {
                    b.this.cTc.azq();
                }
                b.this.azu();
            }
        });
        this.cTy.a(new a.InterfaceC0381a() { // from class: com.baidu.swan.games.view.recommend.c.b.2
            @Override // com.baidu.swan.games.view.recommend.c.a.InterfaceC0381a
            public void io(int i) {
                if (b.this.cTc != null) {
                    b.this.cTc.ik(i);
                }
                b.this.azv();
            }
        });
        this.cTu.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.cTb != null && b.this.cTc != null) {
                    b.this.cTc.azp();
                }
                b.this.azv();
            }
        });
        this.cTw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.azv();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        super.a(aVar);
        this.cTy.a(aVar);
        azs();
    }

    private void azs() {
        SwanAppActivity aev = f.aeK().aev();
        float min = Math.min(aev != null && aev.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> aey = f.aeK().aey();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) aey.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) aey.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void azt() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState();
        this.cTx.setVisibility(8);
        this.cTw.setImageResource(nightModeSwitcherState ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (nightModeSwitcherState) {
            this.cTv.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b.this.cTx.getLayoutParams();
                    layoutParams.width = b.this.cTv.getWidth();
                    layoutParams.height = b.this.cTv.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    b.this.cTx.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azu() {
        azt();
        if (this.cTt != null) {
            this.cTt.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azv() {
        if (this.cTt != null) {
            this.cTt.dismiss();
        }
    }
}

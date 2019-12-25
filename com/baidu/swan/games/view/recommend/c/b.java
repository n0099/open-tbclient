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
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.games.view.recommend.a.a {
    private g cpV;
    private View cpW;
    private View cpX;
    private ImageView cpY;
    private View cpZ;
    private a cqa;
    private RecyclerView mRecyclerView;

    public b(@NonNull Context context, @NonNull com.baidu.swan.games.view.recommend.a.d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aom() {
        View aom = super.aom();
        this.cpW = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.cpX = this.cpW.findViewById(a.f.swangame_recommend_dialog_content);
        this.cpZ = this.cpW.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.cpY = (ImageView) this.cpW.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.cpW.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new c(this.mContext));
        this.cqa = new a(this.mContext);
        this.mRecyclerView.setAdapter(this.cqa);
        ax(aom);
        return aom;
    }

    private void initDialog() {
        g.a aj = new g.a(this.mContext).dr(true).dp(true).du(false).ZA().ZB().fK(17170445).aj(this.cpW);
        aj.dq(false);
        this.cpV = aj.Mq();
        com.baidu.swan.apps.as.c.b(f.Uf().TQ(), this.cpV);
    }

    private void ax(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.cpE != null) {
                    b.this.cpE.aot();
                }
                b.this.aox();
            }
        });
        this.cqa.a(new a.InterfaceC0339a() { // from class: com.baidu.swan.games.view.recommend.c.b.2
            @Override // com.baidu.swan.games.view.recommend.c.a.InterfaceC0339a
            public void hQ(int i) {
                if (b.this.cpE != null) {
                    b.this.cpE.hM(i);
                }
                b.this.aoy();
            }
        });
        this.cpW.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.cpD != null && b.this.cpE != null) {
                    b.this.cpE.aos();
                }
                b.this.aoy();
            }
        });
        this.cpY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.aoy();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        super.a(aVar);
        this.cqa.a(aVar);
        aov();
    }

    private void aov() {
        SwanAppActivity TQ = f.Uf().TQ();
        float min = Math.min(TQ != null && TQ.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> TT = f.Uf().TT();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) TT.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) TT.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void aow() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState();
        this.cpZ.setVisibility(8);
        this.cpY.setImageResource(nightModeSwitcherState ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (nightModeSwitcherState) {
            this.cpX.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b.this.cpZ.getLayoutParams();
                    layoutParams.width = b.this.cpX.getWidth();
                    layoutParams.height = b.this.cpX.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    b.this.cpZ.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aox() {
        aow();
        if (this.cpV != null) {
            this.cpV.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoy() {
        if (this.cpV != null) {
            this.cpV.dismiss();
        }
    }
}

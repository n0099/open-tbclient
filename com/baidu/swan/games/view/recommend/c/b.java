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
    private g bmV;
    private View bmW;
    private View bmX;
    private ImageView bmY;
    private View bmZ;
    private a bna;
    private RecyclerView mRecyclerView;

    public b(@NonNull Context context, @NonNull com.baidu.swan.games.view.recommend.a.d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View TY() {
        View TY = super.TY();
        this.bmW = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.bmX = this.bmW.findViewById(a.f.swangame_recommend_dialog_content);
        this.bmZ = this.bmW.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.bmY = (ImageView) this.bmW.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.bmW.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new c(this.mContext));
        this.bna = new a(this.mContext);
        this.mRecyclerView.setAdapter(this.bna);
        aw(TY);
        return TY;
    }

    private void initDialog() {
        g.a af = new g.a(this.mContext).ce(true).cc(true).ch(false).Lv().Lw().dA(17170445).af(this.bmW);
        af.cd(false);
        this.bmV = af.AX();
        com.baidu.swan.apps.an.b.a(e.GF().Gr(), this.bmV);
    }

    private void aw(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.bmD != null) {
                    b.this.bmD.Ug();
                }
                b.this.Uk();
            }
        });
        this.bna.a(new a.InterfaceC0216a() { // from class: com.baidu.swan.games.view.recommend.c.b.2
            @Override // com.baidu.swan.games.view.recommend.c.a.InterfaceC0216a
            public void fq(int i) {
                if (b.this.bmD != null) {
                    b.this.bmD.fm(i);
                }
                b.this.Ul();
            }
        });
        this.bmW.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.bmC != null && b.this.bmD != null) {
                    b.this.bmD.Uf();
                }
                b.this.Ul();
            }
        });
        this.bmY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.Ul();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.d.b bVar) {
        super.a(bVar);
        this.bna.a(bVar);
        Ui();
    }

    private void Ui() {
        SwanAppActivity Gr = e.GF().Gr();
        float min = Math.min(Gr != null && Gr.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> Gu = e.GF().Gu();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) Gu.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) Gu.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void Uj() {
        boolean Fe = com.baidu.swan.apps.u.a.EF().Fe();
        this.bmZ.setVisibility(8);
        this.bmY.setImageResource(Fe ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (Fe) {
            this.bmX.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b.this.bmZ.getLayoutParams();
                    layoutParams.width = b.this.bmX.getWidth();
                    layoutParams.height = b.this.bmX.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    b.this.bmZ.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uk() {
        Uj();
        if (this.bmV != null) {
            this.bmV.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ul() {
        if (this.bmV != null) {
            this.bmV.dismiss();
        }
    }
}

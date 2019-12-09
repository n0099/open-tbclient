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
    private g bFo;
    private View bFp;
    private View bFq;
    private ImageView bFr;
    private View bFs;
    private a bFt;
    private RecyclerView mRecyclerView;

    public b(@NonNull Context context, @NonNull com.baidu.swan.games.view.recommend.a.d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View YQ() {
        View YQ = super.YQ();
        this.bFp = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.bFq = this.bFp.findViewById(a.f.swangame_recommend_dialog_content);
        this.bFs = this.bFp.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.bFr = (ImageView) this.bFp.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.bFp.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new c(this.mContext));
        this.bFt = new a(this.mContext);
        this.mRecyclerView.setAdapter(this.bFt);
        aC(YQ);
        return YQ;
    }

    private void initDialog() {
        g.a al = new g.a(this.mContext).cv(true).ct(true).cy(false).Qt().Qu().ew(17170445).al(this.bFp);
        al.cu(false);
        this.bFo = al.FX();
        com.baidu.swan.apps.an.b.b(e.LE().Lq(), this.bFo);
    }

    private void aC(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.bEW != null) {
                    b.this.bEW.YX();
                }
                b.this.Zb();
            }
        });
        this.bFt.a(new a.InterfaceC0257a() { // from class: com.baidu.swan.games.view.recommend.c.b.2
            @Override // com.baidu.swan.games.view.recommend.c.a.InterfaceC0257a
            public void gl(int i) {
                if (b.this.bEW != null) {
                    b.this.bEW.gh(i);
                }
                b.this.Zc();
            }
        });
        this.bFp.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.bEV != null && b.this.bEW != null) {
                    b.this.bEW.YW();
                }
                b.this.Zc();
            }
        });
        this.bFr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.Zc();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.d.b bVar) {
        super.a(bVar);
        this.bFt.a(bVar);
        YZ();
    }

    private void YZ() {
        SwanAppActivity Lq = e.LE().Lq();
        float min = Math.min(Lq != null && Lq.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> Lt = e.LE().Lt();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) Lt.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) Lt.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void Za() {
        boolean Kd = com.baidu.swan.apps.u.a.JE().Kd();
        this.bFs.setVisibility(8);
        this.bFr.setImageResource(Kd ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (Kd) {
            this.bFq.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b.this.bFs.getLayoutParams();
                    layoutParams.width = b.this.bFq.getWidth();
                    layoutParams.height = b.this.bFq.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    b.this.bFs.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zb() {
        Za();
        if (this.bFo != null) {
            this.bFo.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zc() {
        if (this.bFo != null) {
            this.bFo.dismiss();
        }
    }
}

package com.baidu.swan.games.view.recommend.listmode;

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.e;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.view.recommend.a.d;
import com.baidu.swan.games.view.recommend.listmode.ListRecommendAdapter;
/* loaded from: classes9.dex */
public class a extends com.baidu.swan.games.view.recommend.a.a {
    private g epZ;
    private View eqa;
    private View eqb;
    private ImageView eqc;
    private View eqd;
    private ListRecommendAdapter eqe;
    private RecyclerView mRecyclerView;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View bdw() {
        View bdw = super.bdw();
        this.eqa = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.eqb = this.eqa.findViewById(a.f.swangame_recommend_dialog_content);
        this.eqd = this.eqa.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.eqc = (ImageView) this.eqa.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.eqa.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new ListRecommendDivider(this.mContext));
        this.eqe = new ListRecommendAdapter(this.mContext);
        this.mRecyclerView.setAdapter(this.eqe);
        bb(bdw);
        return bdw;
    }

    private void initDialog() {
        g.a aK = new g.a(this.mContext).gV(true).gT(true).gY(false).aLw().aLx().kD(17170445).aK(this.eqa);
        aK.gU(false);
        this.epZ = aK.atH();
        e.b(f.aDH().aDr(), this.epZ);
    }

    private void bb(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.listmode.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.epH != null) {
                    a.this.epH.bdD();
                }
                a.this.bdH();
            }
        });
        this.eqe.a(new ListRecommendAdapter.a() { // from class: com.baidu.swan.games.view.recommend.listmode.a.2
            @Override // com.baidu.swan.games.view.recommend.listmode.ListRecommendAdapter.a
            public void mX(int i) {
                if (a.this.epH != null) {
                    a.this.epH.mT(i);
                }
                a.this.bdI();
            }
        });
        this.eqa.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.listmode.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.epG != null && a.this.epH != null) {
                    a.this.epH.bdC();
                }
                a.this.bdI();
            }
        });
        this.eqc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.listmode.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bdI();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        super.a(aVar);
        this.eqe.a(aVar);
        bdF();
    }

    private void bdF() {
        SwanAppActivity aDr = f.aDH().aDr();
        float min = Math.min(aDr != null && aDr.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> aDu = f.aDH().aDu();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) aDu.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) aDu.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void bdG() {
        boolean alE = com.baidu.swan.apps.t.a.aAO().alE();
        this.eqd.setVisibility(8);
        this.eqc.setImageResource(alE ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (alE) {
            this.eqb.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.listmode.a.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a.this.eqd.getLayoutParams();
                    layoutParams.width = a.this.eqb.getWidth();
                    layoutParams.height = a.this.eqb.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    a.this.eqd.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdH() {
        bdG();
        if (this.epZ != null) {
            this.epZ.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdI() {
        if (this.epZ != null) {
            this.epZ.dismiss();
        }
    }
}

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
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.games.view.recommend.a.a {
    private g dVN;
    private View dVO;
    private View dVP;
    private ImageView dVQ;
    private View dVR;
    private a dVS;
    private RecyclerView mRecyclerView;

    public b(@NonNull Context context, @NonNull com.baidu.swan.games.view.recommend.a.d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aWf() {
        View aWf = super.aWf();
        this.dVO = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.dVP = this.dVO.findViewById(a.f.swangame_recommend_dialog_content);
        this.dVR = this.dVO.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.dVQ = (ImageView) this.dVO.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.dVO.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new c(this.mContext));
        this.dVS = new a(this.mContext);
        this.mRecyclerView.setAdapter(this.dVS);
        aM(aWf);
        return aWf;
    }

    private void initDialog() {
        g.a aw = new g.a(this.mContext).gi(true).gg(true).gl(false).aEz().aEA().jW(17170445).aw(this.dVO);
        aw.gh(false);
        this.dVN = aw.ano();
        e.b(f.axo().awY(), this.dVN);
    }

    private void aM(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.dVw != null) {
                    b.this.dVw.aWm();
                }
                b.this.aWq();
            }
        });
        this.dVS.a(new a.InterfaceC0536a() { // from class: com.baidu.swan.games.view.recommend.c.b.2
            @Override // com.baidu.swan.games.view.recommend.c.a.InterfaceC0536a
            public void ml(int i) {
                if (b.this.dVw != null) {
                    b.this.dVw.mh(i);
                }
                b.this.aWr();
            }
        });
        this.dVO.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.dVv != null && b.this.dVw != null) {
                    b.this.dVw.aWl();
                }
                b.this.aWr();
            }
        });
        this.dVQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.aWr();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        super.a(aVar);
        this.dVS.a(aVar);
        aWo();
    }

    private void aWo() {
        SwanAppActivity awY = f.axo().awY();
        float min = Math.min(awY != null && awY.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> axb = f.axo().axb();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) axb.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) axb.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void aWp() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.auw().getNightModeSwitcherState();
        this.dVR.setVisibility(8);
        this.dVQ.setImageResource(nightModeSwitcherState ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (nightModeSwitcherState) {
            this.dVP.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b.this.dVR.getLayoutParams();
                    layoutParams.width = b.this.dVP.getWidth();
                    layoutParams.height = b.this.dVP.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    b.this.dVR.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWq() {
        aWp();
        if (this.dVN != null) {
            this.dVN.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWr() {
        if (this.dVN != null) {
            this.dVN.dismiss();
        }
    }
}

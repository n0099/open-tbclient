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
import com.baidu.swan.apps.aq.e;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.view.recommend.c.a;
/* loaded from: classes7.dex */
public class b extends com.baidu.swan.games.view.recommend.a.a {
    private g dpi;
    private View dpj;
    private View dpk;
    private ImageView dpl;
    private View dpm;
    private a dpn;
    private RecyclerView mRecyclerView;

    public b(@NonNull Context context, @NonNull com.baidu.swan.games.view.recommend.a.d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aIa() {
        View aIa = super.aIa();
        this.dpj = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.dpk = this.dpj.findViewById(a.f.swangame_recommend_dialog_content);
        this.dpm = this.dpj.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.dpl = (ImageView) this.dpj.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.dpj.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new c(this.mContext));
        this.dpn = new a(this.mContext);
        this.mRecyclerView.setAdapter(this.dpn);
        aG(aIa);
        return aIa;
    }

    private void initDialog() {
        g.a ar = new g.a(this.mContext).fh(true).ff(true).fk(false).arb().arc().gW(17170445).ar(this.dpj);
        ar.fg(false);
        this.dpi = ar.abN();
        e.b(f.akr().akb(), this.dpi);
    }

    private void aG(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.doR != null) {
                    b.this.doR.aIh();
                }
                b.this.aIl();
            }
        });
        this.dpn.a(new a.InterfaceC0462a() { // from class: com.baidu.swan.games.view.recommend.c.b.2
            @Override // com.baidu.swan.games.view.recommend.c.a.InterfaceC0462a
            public void jj(int i) {
                if (b.this.doR != null) {
                    b.this.doR.jf(i);
                }
                b.this.aIm();
            }
        });
        this.dpj.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.doQ != null && b.this.doR != null) {
                    b.this.doR.aIg();
                }
                b.this.aIm();
            }
        });
        this.dpl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.aIm();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        super.a(aVar);
        this.dpn.a(aVar);
        aIj();
    }

    private void aIj() {
        SwanAppActivity akb = f.akr().akb();
        float min = Math.min(akb != null && akb.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> ake = f.akr().ake();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) ake.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) ake.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void aIk() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState();
        this.dpm.setVisibility(8);
        this.dpl.setImageResource(nightModeSwitcherState ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (nightModeSwitcherState) {
            this.dpk.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b.this.dpm.getLayoutParams();
                    layoutParams.width = b.this.dpk.getWidth();
                    layoutParams.height = b.this.dpk.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    b.this.dpm.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIl() {
        aIk();
        if (this.dpi != null) {
            this.dpi.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIm() {
        if (this.dpi != null) {
            this.dpi.dismiss();
        }
    }
}

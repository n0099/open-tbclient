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
    private g bnt;
    private View bnu;
    private View bnv;
    private ImageView bnw;
    private View bnx;
    private a bny;
    private RecyclerView mRecyclerView;

    public b(@NonNull Context context, @NonNull com.baidu.swan.games.view.recommend.a.d dVar) {
        super(context, dVar);
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View Uc() {
        View Uc = super.Uc();
        this.bnu = LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.bnv = this.bnu.findViewById(a.f.swangame_recommend_dialog_content);
        this.bnx = this.bnu.findViewById(a.f.swangame_recommend_dialog_night_mask);
        this.bnw = (ImageView) this.bnu.findViewById(a.f.swangame_recommend_dialog_cancel);
        initDialog();
        this.mRecyclerView = (RecyclerView) this.bnu.findViewById(a.f.swangame_recommend_dialog_list);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecyclerView.addItemDecoration(new c(this.mContext));
        this.bny = new a(this.mContext);
        this.mRecyclerView.setAdapter(this.bny);
        aw(Uc);
        return Uc;
    }

    private void initDialog() {
        g.a af = new g.a(this.mContext).ce(true).cc(true).ch(false).Lz().LA().dB(17170445).af(this.bnu);
        af.cd(false);
        this.bnt = af.Bb();
        com.baidu.swan.apps.an.b.b(e.GJ().Gv(), this.bnt);
    }

    private void aw(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.bnb != null) {
                    b.this.bnb.Uk();
                }
                b.this.Uo();
            }
        });
        this.bny.a(new a.InterfaceC0230a() { // from class: com.baidu.swan.games.view.recommend.c.b.2
            @Override // com.baidu.swan.games.view.recommend.c.a.InterfaceC0230a
            public void fr(int i) {
                if (b.this.bnb != null) {
                    b.this.bnb.fn(i);
                }
                b.this.Up();
            }
        });
        this.bnu.findViewById(a.f.swangame_recommend_dialog_game_center).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.bna != null && b.this.bnb != null) {
                    b.this.bnb.Uj();
                }
                b.this.Up();
            }
        });
        this.bnw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.c.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.Up();
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.d.b bVar) {
        super.a(bVar);
        this.bny.a(bVar);
        Um();
    }

    private void Um() {
        SwanAppActivity Gv = e.GJ().Gv();
        float min = Math.min(Gv != null && Gv.isLandScape() ? 2.5f : 5.0f, this.mRecyclerView.getAdapter().getItemCount());
        Resources resources = this.mContext.getResources();
        float dimension = (int) ((min * (resources.getDimension(a.d.swangame_recommend_dialog_list_divider_height) + resources.getDimension(a.d.swangame_recommend_dialog_list_item_height))) + resources.getDimension(a.d.swangame_recommend_dialog_list_default_padding));
        float dimension2 = resources.getDimension(a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> Gy = e.GJ().Gy();
        this.mRecyclerView.getLayoutParams().width = (int) Math.min(dimension2, ((Integer) Gy.first).intValue());
        this.mRecyclerView.getLayoutParams().height = (int) Math.min(dimension, ((Integer) Gy.second).intValue() * 0.67f);
        this.mRecyclerView.requestLayout();
    }

    private void Un() {
        boolean Fi = com.baidu.swan.apps.u.a.EJ().Fi();
        this.bnx.setVisibility(8);
        this.bnw.setImageResource(Fi ? a.e.swangame_recommend_button_close_night : a.e.swangame_recommend_button_close);
        if (Fi) {
            this.bnv.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b.this.bnx.getLayoutParams();
                    layoutParams.width = b.this.bnv.getWidth();
                    layoutParams.height = b.this.bnv.getHeight();
                    layoutParams.topMargin = -layoutParams.height;
                    b.this.bnx.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uo() {
        Un();
        if (this.bnt != null) {
            this.bnt.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Up() {
        if (this.bnt != null) {
            this.bnt.dismiss();
        }
    }
}

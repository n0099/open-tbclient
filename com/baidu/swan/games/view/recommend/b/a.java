package com.baidu.swan.games.view.recommend.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.games.view.recommend.a.d;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
/* loaded from: classes7.dex */
public class a extends com.baidu.swan.games.view.recommend.a.a {
    private b dpb;
    private b dpc;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aIa() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.dpc = new b(this.mContext);
        this.dpc.dpe.setAlpha(0.0f);
        frameLayout.addView(this.dpc.dpe);
        this.dpb = new b(this.mContext);
        this.dpb.dpe.setAlpha(0.0f);
        this.dpb.dpf.setActualImageResource(17170445);
        this.dpb.dpg.setText((CharSequence) null);
        frameLayout.addView(this.dpb.dpe);
        this.dpb.dpe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.doR != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.doR.aIg();
                    } else {
                        a.this.doR.jf(a.this.mPosition);
                    }
                }
            }
        });
        return frameLayout;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        super.a(aVar);
        if (!c(aVar)) {
            this.mPosition = -2;
            this.dpc.dpf.setImageURI(aVar.dps.iconUrl);
            this.dpc.dpg.setText(aVar.dps.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void aIb() {
        if (c(this.doQ)) {
            this.dpb.dpe.setAlpha(1.0f);
            this.dpb.dpf.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.dpb.dpg.setText(a.h.swangame_recommend_button_goto_game_center);
            super.aIb();
            return;
        }
        this.mPosition = jh(this.mPosition);
        this.dpc.dpe.animate().setDuration(160L).alpha(1.0f);
        this.dpb.dpe.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel ji = a.this.ji(a.this.mPosition);
                a.this.dpb.dpf.setImageURI(ji.iconUrl);
                a.this.dpb.dpg.setText(ji.appName);
                a.this.dpb.dpe.setAlpha(1.0f);
                RecommendItemModel ji2 = a.this.ji(a.this.jh(a.this.mPosition));
                a.this.dpc.dpf.setImageURI(ji2.iconUrl);
                a.this.dpc.dpg.setText(ji2.appName);
                a.this.dpc.dpe.setAlpha(0.0f);
                a.super.aIb();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.dpt == null || aVar.dps == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int jh(int i) {
        if (i + 1 == this.doQ.dpt.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel ji(int i) {
        return i == -1 ? this.doQ.dps : this.doQ.dpt.get(i);
    }
}

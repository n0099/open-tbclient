package com.baidu.swan.games.view.recommend.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.games.view.recommend.a.d;
/* loaded from: classes2.dex */
public class a extends com.baidu.swan.games.view.recommend.a.a {
    private b bFh;
    private b bFi;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View YQ() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.bFi = new b(this.mContext);
        this.bFi.bFk.setAlpha(0.0f);
        frameLayout.addView(this.bFi.bFk);
        this.bFh = new b(this.mContext);
        this.bFh.bFk.setAlpha(0.0f);
        this.bFh.bFl.setActualImageResource(17170445);
        this.bFh.bFm.setText((CharSequence) null);
        frameLayout.addView(this.bFh.bFk);
        this.bFh.bFk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bEW != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.bEW.YW();
                    } else {
                        a.this.bEW.gh(a.this.mPosition);
                    }
                }
            }
        });
        return frameLayout;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.d.b bVar) {
        super.a(bVar);
        if (!c(bVar)) {
            this.mPosition = -2;
            this.bFi.bFl.setImageURI(bVar.bFy.iconUrl);
            this.bFi.bFm.setText(bVar.bFy.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void YR() {
        if (c(this.bEV)) {
            this.bFh.bFk.setAlpha(1.0f);
            this.bFh.bFl.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.bFh.bFm.setText(a.h.swangame_recommend_button_goto_game_center);
            super.YR();
            return;
        }
        this.mPosition = gj(this.mPosition);
        this.bFi.bFk.animate().setDuration(160L).alpha(1.0f);
        this.bFh.bFk.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                com.baidu.swan.games.view.recommend.d.a gk = a.this.gk(a.this.mPosition);
                a.this.bFh.bFl.setImageURI(gk.iconUrl);
                a.this.bFh.bFm.setText(gk.appName);
                a.this.bFh.bFk.setAlpha(1.0f);
                com.baidu.swan.games.view.recommend.d.a gk2 = a.this.gk(a.this.gj(a.this.mPosition));
                a.this.bFi.bFl.setImageURI(gk2.iconUrl);
                a.this.bFi.bFm.setText(gk2.appName);
                a.this.bFi.bFk.setAlpha(0.0f);
                a.super.YR();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.d.b bVar) {
        return bVar == null || bVar.bFz == null || bVar.bFy == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int gj(int i) {
        if (i + 1 == this.bEV.bFz.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.games.view.recommend.d.a gk(int i) {
        return i == -1 ? this.bEV.bFy : this.bEV.bFz.get(i);
    }
}

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
    private b bnm;
    private b bnn;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View Uc() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.bnn = new b(this.mContext);
        this.bnn.bnp.setAlpha(0.0f);
        frameLayout.addView(this.bnn.bnp);
        this.bnm = new b(this.mContext);
        this.bnm.bnp.setAlpha(0.0f);
        this.bnm.bnq.setActualImageResource(17170445);
        this.bnm.bnr.setText((CharSequence) null);
        frameLayout.addView(this.bnm.bnp);
        this.bnm.bnp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bnb != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.bnb.Uj();
                    } else {
                        a.this.bnb.fn(a.this.mPosition);
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
            this.bnn.bnq.setImageURI(bVar.bnD.iconUrl);
            this.bnn.bnr.setText(bVar.bnD.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void Ud() {
        if (c(this.bna)) {
            this.bnm.bnp.setAlpha(1.0f);
            this.bnm.bnq.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.bnm.bnr.setText(a.h.swangame_recommend_button_goto_game_center);
            super.Ud();
            return;
        }
        this.mPosition = fp(this.mPosition);
        this.bnn.bnp.animate().setDuration(160L).alpha(1.0f);
        this.bnm.bnp.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                com.baidu.swan.games.view.recommend.d.a fq = a.this.fq(a.this.mPosition);
                a.this.bnm.bnq.setImageURI(fq.iconUrl);
                a.this.bnm.bnr.setText(fq.appName);
                a.this.bnm.bnp.setAlpha(1.0f);
                com.baidu.swan.games.view.recommend.d.a fq2 = a.this.fq(a.this.fp(a.this.mPosition));
                a.this.bnn.bnq.setImageURI(fq2.iconUrl);
                a.this.bnn.bnr.setText(fq2.appName);
                a.this.bnn.bnp.setAlpha(0.0f);
                a.super.Ud();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.d.b bVar) {
        return bVar == null || bVar.bnE == null || bVar.bnD == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fp(int i) {
        if (i + 1 == this.bna.bnE.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.games.view.recommend.d.a fq(int i) {
        return i == -1 ? this.bna.bnD : this.bna.bnE.get(i);
    }
}

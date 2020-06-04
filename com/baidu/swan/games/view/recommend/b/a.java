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
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.games.view.recommend.a.a {
    private b deu;
    private b dev;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aDb() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.dev = new b(this.mContext);
        this.dev.dex.setAlpha(0.0f);
        frameLayout.addView(this.dev.dex);
        this.deu = new b(this.mContext);
        this.deu.dex.setAlpha(0.0f);
        this.deu.dey.setActualImageResource(17170445);
        this.deu.dez.setText((CharSequence) null);
        frameLayout.addView(this.deu.dex);
        this.deu.dex.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dej != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.dej.aDh();
                    } else {
                        a.this.dej.iD(a.this.mPosition);
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
            this.dev.dey.setImageURI(aVar.deL.iconUrl);
            this.dev.dez.setText(aVar.deL.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void aDc() {
        if (c(this.dei)) {
            this.deu.dex.setAlpha(1.0f);
            this.deu.dey.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.deu.dez.setText(a.h.swangame_recommend_button_goto_game_center);
            super.aDc();
            return;
        }
        this.mPosition = iF(this.mPosition);
        this.dev.dex.animate().setDuration(160L).alpha(1.0f);
        this.deu.dex.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel iG = a.this.iG(a.this.mPosition);
                a.this.deu.dey.setImageURI(iG.iconUrl);
                a.this.deu.dez.setText(iG.appName);
                a.this.deu.dex.setAlpha(1.0f);
                RecommendItemModel iG2 = a.this.iG(a.this.iF(a.this.mPosition));
                a.this.dev.dey.setImageURI(iG2.iconUrl);
                a.this.dev.dez.setText(iG2.appName);
                a.this.dev.dex.setAlpha(0.0f);
                a.super.aDc();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.deM == null || aVar.deL == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int iF(int i) {
        if (i + 1 == this.dei.deM.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel iG(int i) {
        return i == -1 ? this.dei.deL : this.dei.deM.get(i);
    }
}

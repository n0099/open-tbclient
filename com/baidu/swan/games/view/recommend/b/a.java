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
/* loaded from: classes10.dex */
public class a extends com.baidu.swan.games.view.recommend.a.a {
    private b dNj;
    private b dNk;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aUl() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.dNk = new b(this.mContext);
        this.dNk.dNm.setAlpha(0.0f);
        frameLayout.addView(this.dNk.dNm);
        this.dNj = new b(this.mContext);
        this.dNj.dNm.setAlpha(0.0f);
        this.dNj.dNn.setActualImageResource(17170445);
        this.dNj.dNo.setText((CharSequence) null);
        frameLayout.addView(this.dNj.dNm);
        this.dNj.dNm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dMZ != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.dMZ.aUr();
                    } else {
                        a.this.dMZ.lW(a.this.mPosition);
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
            this.dNk.dNn.setImageURI(aVar.dNA.iconUrl);
            this.dNk.dNo.setText(aVar.dNA.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void aUm() {
        if (c(this.dMY)) {
            this.dNj.dNm.setAlpha(1.0f);
            this.dNj.dNn.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.dNj.dNo.setText(a.h.swangame_recommend_button_goto_game_center);
            super.aUm();
            return;
        }
        this.mPosition = lY(this.mPosition);
        this.dNk.dNm.animate().setDuration(160L).alpha(1.0f);
        this.dNj.dNm.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel lZ = a.this.lZ(a.this.mPosition);
                a.this.dNj.dNn.setImageURI(lZ.iconUrl);
                a.this.dNj.dNo.setText(lZ.appName);
                a.this.dNj.dNm.setAlpha(1.0f);
                RecommendItemModel lZ2 = a.this.lZ(a.this.lY(a.this.mPosition));
                a.this.dNk.dNn.setImageURI(lZ2.iconUrl);
                a.this.dNk.dNo.setText(lZ2.appName);
                a.this.dNk.dNm.setAlpha(0.0f);
                a.super.aUm();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.dNB == null || aVar.dNA == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lY(int i) {
        if (i + 1 == this.dMY.dNB.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel lZ(int i) {
        return i == -1 ? this.dMY.dNA : this.dMY.dNB.get(i);
    }
}

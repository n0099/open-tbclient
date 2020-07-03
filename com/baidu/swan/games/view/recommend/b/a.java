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
    private b djg;
    private b djh;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aEh() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.djh = new b(this.mContext);
        this.djh.djj.setAlpha(0.0f);
        frameLayout.addView(this.djh.djj);
        this.djg = new b(this.mContext);
        this.djg.djj.setAlpha(0.0f);
        this.djg.djk.setActualImageResource(17170445);
        this.djg.djl.setText((CharSequence) null);
        frameLayout.addView(this.djg.djj);
        this.djg.djj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.diW != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.diW.aEn();
                    } else {
                        a.this.diW.iO(a.this.mPosition);
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
            this.djh.djk.setImageURI(aVar.djx.iconUrl);
            this.djh.djl.setText(aVar.djx.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void aEi() {
        if (c(this.diV)) {
            this.djg.djj.setAlpha(1.0f);
            this.djg.djk.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.djg.djl.setText(a.h.swangame_recommend_button_goto_game_center);
            super.aEi();
            return;
        }
        this.mPosition = iQ(this.mPosition);
        this.djh.djj.animate().setDuration(160L).alpha(1.0f);
        this.djg.djj.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel iR = a.this.iR(a.this.mPosition);
                a.this.djg.djk.setImageURI(iR.iconUrl);
                a.this.djg.djl.setText(iR.appName);
                a.this.djg.djj.setAlpha(1.0f);
                RecommendItemModel iR2 = a.this.iR(a.this.iQ(a.this.mPosition));
                a.this.djh.djk.setImageURI(iR2.iconUrl);
                a.this.djh.djl.setText(iR2.appName);
                a.this.djh.djj.setAlpha(0.0f);
                a.super.aEi();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.djy == null || aVar.djx == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int iQ(int i) {
        if (i + 1 == this.diV.djy.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel iR(int i) {
        return i == -1 ? this.diV.djx : this.diV.djy.get(i);
    }
}

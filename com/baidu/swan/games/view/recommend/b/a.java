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
    private b dVG;
    private b dVH;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aWf() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.dVH = new b(this.mContext);
        this.dVH.dVJ.setAlpha(0.0f);
        frameLayout.addView(this.dVH.dVJ);
        this.dVG = new b(this.mContext);
        this.dVG.dVJ.setAlpha(0.0f);
        this.dVG.dVK.setActualImageResource(17170445);
        this.dVG.dVL.setText((CharSequence) null);
        frameLayout.addView(this.dVG.dVJ);
        this.dVG.dVJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dVw != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.dVw.aWl();
                    } else {
                        a.this.dVw.mh(a.this.mPosition);
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
            this.dVH.dVK.setImageURI(aVar.dVX.iconUrl);
            this.dVH.dVL.setText(aVar.dVX.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void aWg() {
        if (c(this.dVv)) {
            this.dVG.dVJ.setAlpha(1.0f);
            this.dVG.dVK.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.dVG.dVL.setText(a.h.swangame_recommend_button_goto_game_center);
            super.aWg();
            return;
        }
        this.mPosition = mj(this.mPosition);
        this.dVH.dVJ.animate().setDuration(160L).alpha(1.0f);
        this.dVG.dVJ.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel mk = a.this.mk(a.this.mPosition);
                a.this.dVG.dVK.setImageURI(mk.iconUrl);
                a.this.dVG.dVL.setText(mk.appName);
                a.this.dVG.dVJ.setAlpha(1.0f);
                RecommendItemModel mk2 = a.this.mk(a.this.mj(a.this.mPosition));
                a.this.dVH.dVK.setImageURI(mk2.iconUrl);
                a.this.dVH.dVL.setText(mk2.appName);
                a.this.dVH.dVJ.setAlpha(0.0f);
                a.super.aWg();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.dVY == null || aVar.dVX == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mj(int i) {
        if (i + 1 == this.dVv.dVY.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel mk(int i) {
        return i == -1 ? this.dVv.dVX : this.dVv.dVY.get(i);
    }
}

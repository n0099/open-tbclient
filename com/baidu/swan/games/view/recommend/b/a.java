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
/* loaded from: classes8.dex */
public class a extends com.baidu.swan.games.view.recommend.a.a {
    private b dzh;
    private b dzi;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aQQ() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.dzi = new b(this.mContext);
        this.dzi.dzk.setAlpha(0.0f);
        frameLayout.addView(this.dzi.dzk);
        this.dzh = new b(this.mContext);
        this.dzh.dzk.setAlpha(0.0f);
        this.dzh.dzl.setActualImageResource(17170445);
        this.dzh.dzm.setText((CharSequence) null);
        frameLayout.addView(this.dzh.dzk);
        this.dzh.dzk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dyX != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.dyX.aQW();
                    } else {
                        a.this.dyX.lo(a.this.mPosition);
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
            this.dzi.dzl.setImageURI(aVar.dzy.iconUrl);
            this.dzi.dzm.setText(aVar.dzy.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void aQR() {
        if (c(this.dyW)) {
            this.dzh.dzk.setAlpha(1.0f);
            this.dzh.dzl.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.dzh.dzm.setText(a.h.swangame_recommend_button_goto_game_center);
            super.aQR();
            return;
        }
        this.mPosition = lq(this.mPosition);
        this.dzi.dzk.animate().setDuration(160L).alpha(1.0f);
        this.dzh.dzk.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel lr = a.this.lr(a.this.mPosition);
                a.this.dzh.dzl.setImageURI(lr.iconUrl);
                a.this.dzh.dzm.setText(lr.appName);
                a.this.dzh.dzk.setAlpha(1.0f);
                RecommendItemModel lr2 = a.this.lr(a.this.lq(a.this.mPosition));
                a.this.dzi.dzl.setImageURI(lr2.iconUrl);
                a.this.dzi.dzm.setText(lr2.appName);
                a.this.dzi.dzk.setAlpha(0.0f);
                a.super.aQR();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.dzz == null || aVar.dzy == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lq(int i) {
        if (i + 1 == this.dyW.dzz.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel lr(int i) {
        return i == -1 ? this.dyW.dzy : this.dyW.dzz.get(i);
    }
}

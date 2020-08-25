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
    private b dzd;
    private b dze;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aQQ() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.dze = new b(this.mContext);
        this.dze.dzg.setAlpha(0.0f);
        frameLayout.addView(this.dze.dzg);
        this.dzd = new b(this.mContext);
        this.dzd.dzg.setAlpha(0.0f);
        this.dzd.dzh.setActualImageResource(17170445);
        this.dzd.dzi.setText((CharSequence) null);
        frameLayout.addView(this.dzd.dzg);
        this.dzd.dzg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dyT != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.dyT.aQW();
                    } else {
                        a.this.dyT.lo(a.this.mPosition);
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
            this.dze.dzh.setImageURI(aVar.dzu.iconUrl);
            this.dze.dzi.setText(aVar.dzu.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void aQR() {
        if (c(this.dyS)) {
            this.dzd.dzg.setAlpha(1.0f);
            this.dzd.dzh.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.dzd.dzi.setText(a.h.swangame_recommend_button_goto_game_center);
            super.aQR();
            return;
        }
        this.mPosition = lq(this.mPosition);
        this.dze.dzg.animate().setDuration(160L).alpha(1.0f);
        this.dzd.dzg.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel lr = a.this.lr(a.this.mPosition);
                a.this.dzd.dzh.setImageURI(lr.iconUrl);
                a.this.dzd.dzi.setText(lr.appName);
                a.this.dzd.dzg.setAlpha(1.0f);
                RecommendItemModel lr2 = a.this.lr(a.this.lq(a.this.mPosition));
                a.this.dze.dzh.setImageURI(lr2.iconUrl);
                a.this.dze.dzi.setText(lr2.appName);
                a.this.dze.dzg.setAlpha(0.0f);
                a.super.aQR();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.dzv == null || aVar.dzu == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lq(int i) {
        if (i + 1 == this.dyS.dzv.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel lr(int i) {
        return i == -1 ? this.dyS.dzu : this.dyS.dzv.get(i);
    }
}

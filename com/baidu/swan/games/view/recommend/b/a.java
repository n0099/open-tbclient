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
    private b eby;
    private b ebz;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aYF() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.ebz = new b(this.mContext);
        this.ebz.ebB.setAlpha(0.0f);
        frameLayout.addView(this.ebz.ebB);
        this.eby = new b(this.mContext);
        this.eby.ebB.setAlpha(0.0f);
        this.eby.ebC.setActualImageResource(17170445);
        this.eby.ebD.setText((CharSequence) null);
        frameLayout.addView(this.eby.ebB);
        this.eby.ebB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ebo != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.ebo.aYL();
                    } else {
                        a.this.ebo.mr(a.this.mPosition);
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
            this.ebz.ebC.setImageURI(aVar.ebP.iconUrl);
            this.ebz.ebD.setText(aVar.ebP.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void aYG() {
        if (c(this.ebn)) {
            this.eby.ebB.setAlpha(1.0f);
            this.eby.ebC.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.eby.ebD.setText(a.h.swangame_recommend_button_goto_game_center);
            super.aYG();
            return;
        }
        this.mPosition = mt(this.mPosition);
        this.ebz.ebB.animate().setDuration(160L).alpha(1.0f);
        this.eby.ebB.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel mu = a.this.mu(a.this.mPosition);
                a.this.eby.ebC.setImageURI(mu.iconUrl);
                a.this.eby.ebD.setText(mu.appName);
                a.this.eby.ebB.setAlpha(1.0f);
                RecommendItemModel mu2 = a.this.mu(a.this.mt(a.this.mPosition));
                a.this.ebz.ebC.setImageURI(mu2.iconUrl);
                a.this.ebz.ebD.setText(mu2.appName);
                a.this.ebz.ebB.setAlpha(0.0f);
                a.super.aYG();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.ebQ == null || aVar.ebP == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mt(int i) {
        if (i + 1 == this.ebn.ebQ.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel mu(int i) {
        return i == -1 ? this.ebn.ebP : this.ebn.ebQ.get(i);
    }
}

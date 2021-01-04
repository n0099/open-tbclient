package com.baidu.swan.games.view.recommend.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.a;
import com.baidu.swan.games.view.recommend.a.d;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
/* loaded from: classes9.dex */
public class a extends com.baidu.swan.games.view.recommend.a.a {
    private b epS;
    private b epT;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View bdv() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.epT = new b(this.mContext);
        this.epT.epV.setAlpha(0.0f);
        frameLayout.addView(this.epT.epV);
        this.epS = new b(this.mContext);
        this.epS.epV.setAlpha(0.0f);
        this.epS.epW.setActualImageResource(17170445);
        this.epS.epX.setText((CharSequence) null);
        frameLayout.addView(this.epS.epV);
        this.epS.epV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.epH != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.epH.bdB();
                    } else {
                        a.this.epH.mT(a.this.mPosition);
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
            this.epT.epW.setImageURI(aVar.eqj.iconUrl);
            this.epT.epX.setText(aVar.eqj.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void bdw() {
        if (c(this.epG)) {
            this.epS.epV.setAlpha(1.0f);
            this.epS.epW.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.epS.epX.setText(a.h.swangame_recommend_button_goto_game_center);
            super.bdw();
            return;
        }
        this.mPosition = mV(this.mPosition);
        this.epT.epV.animate().setDuration(160L).alpha(1.0f);
        this.epS.epV.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel mW = a.this.mW(a.this.mPosition);
                a.this.epS.epW.setImageURI(mW.iconUrl);
                a.this.epS.epX.setText(mW.appName);
                a.this.epS.epV.setAlpha(1.0f);
                RecommendItemModel mW2 = a.this.mW(a.this.mV(a.this.mPosition));
                a.this.epT.epW.setImageURI(mW2.iconUrl);
                a.this.epT.epX.setText(mW2.appName);
                a.this.epT.epV.setAlpha(0.0f);
                a.super.bdw();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.eqk == null || aVar.eqj == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mV(int i) {
        if (i + 1 == this.epG.eqk.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel mW(int i) {
        return i == -1 ? this.epG.eqj : this.epG.eqk.get(i);
    }
}

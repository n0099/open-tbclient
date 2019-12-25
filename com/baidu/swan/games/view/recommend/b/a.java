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
/* loaded from: classes9.dex */
public class a extends com.baidu.swan.games.view.recommend.a.a {
    private b cpO;
    private b cpP;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aom() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.cpP = new b(this.mContext);
        this.cpP.cpR.setAlpha(0.0f);
        frameLayout.addView(this.cpP.cpR);
        this.cpO = new b(this.mContext);
        this.cpO.cpR.setAlpha(0.0f);
        this.cpO.cpS.setActualImageResource(17170445);
        this.cpO.cpT.setText((CharSequence) null);
        frameLayout.addView(this.cpO.cpR);
        this.cpO.cpR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cpE != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.cpE.aos();
                    } else {
                        a.this.cpE.hM(a.this.mPosition);
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
            this.cpP.cpS.setImageURI(aVar.cqf.iconUrl);
            this.cpP.cpT.setText(aVar.cqf.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void aon() {
        if (c(this.cpD)) {
            this.cpO.cpR.setAlpha(1.0f);
            this.cpO.cpS.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.cpO.cpT.setText(a.h.swangame_recommend_button_goto_game_center);
            super.aon();
            return;
        }
        this.mPosition = hO(this.mPosition);
        this.cpP.cpR.animate().setDuration(160L).alpha(1.0f);
        this.cpO.cpR.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel hP = a.this.hP(a.this.mPosition);
                a.this.cpO.cpS.setImageURI(hP.iconUrl);
                a.this.cpO.cpT.setText(hP.appName);
                a.this.cpO.cpR.setAlpha(1.0f);
                RecommendItemModel hP2 = a.this.hP(a.this.hO(a.this.mPosition));
                a.this.cpP.cpS.setImageURI(hP2.iconUrl);
                a.this.cpP.cpT.setText(hP2.appName);
                a.this.cpP.cpR.setAlpha(0.0f);
                a.super.aon();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.cqg == null || aVar.cqf == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int hO(int i) {
        if (i + 1 == this.cpD.cqg.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel hP(int i) {
        return i == -1 ? this.cpD.cqf : this.cpD.cqg.get(i);
    }
}

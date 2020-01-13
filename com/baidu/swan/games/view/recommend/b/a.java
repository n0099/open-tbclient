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
    private b cqa;
    private b cqb;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aoF() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.cqb = new b(this.mContext);
        this.cqb.cqd.setAlpha(0.0f);
        frameLayout.addView(this.cqb.cqd);
        this.cqa = new b(this.mContext);
        this.cqa.cqd.setAlpha(0.0f);
        this.cqa.cqe.setActualImageResource(17170445);
        this.cqa.cqf.setText((CharSequence) null);
        frameLayout.addView(this.cqa.cqd);
        this.cqa.cqd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cpQ != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.cpQ.aoL();
                    } else {
                        a.this.cpQ.hM(a.this.mPosition);
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
            this.cqb.cqe.setImageURI(aVar.cqr.iconUrl);
            this.cqb.cqf.setText(aVar.cqr.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void aoG() {
        if (c(this.cpP)) {
            this.cqa.cqd.setAlpha(1.0f);
            this.cqa.cqe.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.cqa.cqf.setText(a.h.swangame_recommend_button_goto_game_center);
            super.aoG();
            return;
        }
        this.mPosition = hO(this.mPosition);
        this.cqb.cqd.animate().setDuration(160L).alpha(1.0f);
        this.cqa.cqd.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel hP = a.this.hP(a.this.mPosition);
                a.this.cqa.cqe.setImageURI(hP.iconUrl);
                a.this.cqa.cqf.setText(hP.appName);
                a.this.cqa.cqd.setAlpha(1.0f);
                RecommendItemModel hP2 = a.this.hP(a.this.hO(a.this.mPosition));
                a.this.cqb.cqe.setImageURI(hP2.iconUrl);
                a.this.cqb.cqf.setText(hP2.appName);
                a.this.cqb.cqd.setAlpha(0.0f);
                a.super.aoG();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.cqs == null || aVar.cqr == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int hO(int i) {
        if (i + 1 == this.cpP.cqs.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel hP(int i) {
        return i == -1 ? this.cpP.cqr : this.cpP.cqs.get(i);
    }
}

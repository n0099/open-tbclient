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
    private b cTm;
    private b cTn;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View azj() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.cTn = new b(this.mContext);
        this.cTn.cTp.setAlpha(0.0f);
        frameLayout.addView(this.cTn.cTp);
        this.cTm = new b(this.mContext);
        this.cTm.cTp.setAlpha(0.0f);
        this.cTm.cTq.setActualImageResource(17170445);
        this.cTm.cTr.setText((CharSequence) null);
        frameLayout.addView(this.cTm.cTp);
        this.cTm.cTp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cTc != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.cTc.azp();
                    } else {
                        a.this.cTc.ik(a.this.mPosition);
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
            this.cTn.cTq.setImageURI(aVar.cTD.iconUrl);
            this.cTn.cTr.setText(aVar.cTD.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void azk() {
        if (c(this.cTb)) {
            this.cTm.cTp.setAlpha(1.0f);
            this.cTm.cTq.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.cTm.cTr.setText(a.h.swangame_recommend_button_goto_game_center);
            super.azk();
            return;
        }
        this.mPosition = im(this.mPosition);
        this.cTn.cTp.animate().setDuration(160L).alpha(1.0f);
        this.cTm.cTp.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel in = a.this.in(a.this.mPosition);
                a.this.cTm.cTq.setImageURI(in.iconUrl);
                a.this.cTm.cTr.setText(in.appName);
                a.this.cTm.cTp.setAlpha(1.0f);
                RecommendItemModel in2 = a.this.in(a.this.im(a.this.mPosition));
                a.this.cTn.cTq.setImageURI(in2.iconUrl);
                a.this.cTn.cTr.setText(in2.appName);
                a.this.cTn.cTp.setAlpha(0.0f);
                a.super.azk();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.cTE == null || aVar.cTD == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int im(int i) {
        if (i + 1 == this.cTb.cTE.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel in(int i) {
        return i == -1 ? this.cTb.cTD : this.cTb.cTE.get(i);
    }
}

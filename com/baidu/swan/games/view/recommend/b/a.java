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
/* loaded from: classes7.dex */
public class a extends com.baidu.swan.games.view.recommend.a.a {
    private b dZQ;
    private b dZR;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aXY() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.dZR = new b(this.mContext);
        this.dZR.dZT.setAlpha(0.0f);
        frameLayout.addView(this.dZR.dZT);
        this.dZQ = new b(this.mContext);
        this.dZQ.dZT.setAlpha(0.0f);
        this.dZQ.dZU.setActualImageResource(17170445);
        this.dZQ.dZV.setText((CharSequence) null);
        frameLayout.addView(this.dZQ.dZT);
        this.dZQ.dZT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dZG != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.dZG.aYe();
                    } else {
                        a.this.dZG.mn(a.this.mPosition);
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
            this.dZR.dZU.setImageURI(aVar.eah.iconUrl);
            this.dZR.dZV.setText(aVar.eah.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void aXZ() {
        if (c(this.dZF)) {
            this.dZQ.dZT.setAlpha(1.0f);
            this.dZQ.dZU.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.dZQ.dZV.setText(a.h.swangame_recommend_button_goto_game_center);
            super.aXZ();
            return;
        }
        this.mPosition = mp(this.mPosition);
        this.dZR.dZT.animate().setDuration(160L).alpha(1.0f);
        this.dZQ.dZT.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel mq = a.this.mq(a.this.mPosition);
                a.this.dZQ.dZU.setImageURI(mq.iconUrl);
                a.this.dZQ.dZV.setText(mq.appName);
                a.this.dZQ.dZT.setAlpha(1.0f);
                RecommendItemModel mq2 = a.this.mq(a.this.mp(a.this.mPosition));
                a.this.dZR.dZU.setImageURI(mq2.iconUrl);
                a.this.dZR.dZV.setText(mq2.appName);
                a.this.dZR.dZT.setAlpha(0.0f);
                a.super.aXZ();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.eai == null || aVar.eah == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mp(int i) {
        if (i + 1 == this.dZF.eai.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel mq(int i) {
        return i == -1 ? this.dZF.eah : this.dZF.eai.get(i);
    }
}

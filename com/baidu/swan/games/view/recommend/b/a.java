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
/* loaded from: classes25.dex */
public class a extends com.baidu.swan.games.view.recommend.a.a {
    private b egQ;
    private b egR;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View bbd() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.egR = new b(this.mContext);
        this.egR.egT.setAlpha(0.0f);
        frameLayout.addView(this.egR.egT);
        this.egQ = new b(this.mContext);
        this.egQ.egT.setAlpha(0.0f);
        this.egQ.egU.setActualImageResource(17170445);
        this.egQ.egV.setText((CharSequence) null);
        frameLayout.addView(this.egQ.egT);
        this.egQ.egT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.egG != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.egG.bbj();
                    } else {
                        a.this.egG.mL(a.this.mPosition);
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
            this.egR.egU.setImageURI(aVar.ehh.iconUrl);
            this.egR.egV.setText(aVar.ehh.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void bbe() {
        if (c(this.egF)) {
            this.egQ.egT.setAlpha(1.0f);
            this.egQ.egU.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.egQ.egV.setText(a.h.swangame_recommend_button_goto_game_center);
            super.bbe();
            return;
        }
        this.mPosition = mN(this.mPosition);
        this.egR.egT.animate().setDuration(160L).alpha(1.0f);
        this.egQ.egT.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel mO = a.this.mO(a.this.mPosition);
                a.this.egQ.egU.setImageURI(mO.iconUrl);
                a.this.egQ.egV.setText(mO.appName);
                a.this.egQ.egT.setAlpha(1.0f);
                RecommendItemModel mO2 = a.this.mO(a.this.mN(a.this.mPosition));
                a.this.egR.egU.setImageURI(mO2.iconUrl);
                a.this.egR.egV.setText(mO2.appName);
                a.this.egR.egT.setAlpha(0.0f);
                a.super.bbe();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.ehi == null || aVar.ehh == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mN(int i) {
        if (i + 1 == this.egF.ehi.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel mO(int i) {
        return i == -1 ? this.egF.ehh : this.egF.ehi.get(i);
    }
}

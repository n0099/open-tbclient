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
/* loaded from: classes3.dex */
public class a extends com.baidu.swan.games.view.recommend.a.a {
    private b dBi;
    private b dBj;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aRC() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.dBj = new b(this.mContext);
        this.dBj.dBl.setAlpha(0.0f);
        frameLayout.addView(this.dBj.dBl);
        this.dBi = new b(this.mContext);
        this.dBi.dBl.setAlpha(0.0f);
        this.dBi.dBm.setActualImageResource(17170445);
        this.dBi.dBn.setText((CharSequence) null);
        frameLayout.addView(this.dBi.dBl);
        this.dBi.dBl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dAY != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.dAY.aRI();
                    } else {
                        a.this.dAY.lz(a.this.mPosition);
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
            this.dBj.dBm.setImageURI(aVar.dBz.iconUrl);
            this.dBj.dBn.setText(aVar.dBz.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void aRD() {
        if (c(this.dAX)) {
            this.dBi.dBl.setAlpha(1.0f);
            this.dBi.dBm.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.dBi.dBn.setText(a.h.swangame_recommend_button_goto_game_center);
            super.aRD();
            return;
        }
        this.mPosition = lB(this.mPosition);
        this.dBj.dBl.animate().setDuration(160L).alpha(1.0f);
        this.dBi.dBl.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel lC = a.this.lC(a.this.mPosition);
                a.this.dBi.dBm.setImageURI(lC.iconUrl);
                a.this.dBi.dBn.setText(lC.appName);
                a.this.dBi.dBl.setAlpha(1.0f);
                RecommendItemModel lC2 = a.this.lC(a.this.lB(a.this.mPosition));
                a.this.dBj.dBm.setImageURI(lC2.iconUrl);
                a.this.dBj.dBn.setText(lC2.appName);
                a.this.dBj.dBl.setAlpha(0.0f);
                a.super.aRD();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.dBA == null || aVar.dBz == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lB(int i) {
        if (i + 1 == this.dAX.dBA.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel lC(int i) {
        return i == -1 ? this.dAX.dBz : this.dAX.dBA.get(i);
    }
}

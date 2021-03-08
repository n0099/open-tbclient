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
/* loaded from: classes8.dex */
public class a extends com.baidu.swan.games.view.recommend.a.a {
    private b eoO;
    private b eoP;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aZS() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.eoP = new b(this.mContext);
        this.eoP.eoR.setAlpha(0.0f);
        frameLayout.addView(this.eoP.eoR);
        this.eoO = new b(this.mContext);
        this.eoO.eoR.setAlpha(0.0f);
        this.eoO.eoS.setActualImageResource(17170445);
        this.eoO.eoT.setText((CharSequence) null);
        frameLayout.addView(this.eoO.eoR);
        this.eoO.eoR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eoD != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.eoD.aZY();
                    } else {
                        a.this.eoD.lr(a.this.mPosition);
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
            this.eoP.eoS.setImageURI(aVar.epf.iconUrl);
            this.eoP.eoT.setText(aVar.epf.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void aZT() {
        if (c(this.eoC)) {
            this.eoO.eoR.setAlpha(1.0f);
            this.eoO.eoS.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.eoO.eoT.setText(a.h.swangame_recommend_button_goto_game_center);
            super.aZT();
            return;
        }
        this.mPosition = lt(this.mPosition);
        this.eoP.eoR.animate().setDuration(160L).alpha(1.0f);
        this.eoO.eoR.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel lu = a.this.lu(a.this.mPosition);
                a.this.eoO.eoS.setImageURI(lu.iconUrl);
                a.this.eoO.eoT.setText(lu.appName);
                a.this.eoO.eoR.setAlpha(1.0f);
                RecommendItemModel lu2 = a.this.lu(a.this.lt(a.this.mPosition));
                a.this.eoP.eoS.setImageURI(lu2.iconUrl);
                a.this.eoP.eoT.setText(lu2.appName);
                a.this.eoP.eoR.setAlpha(0.0f);
                a.super.aZT();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.epg == null || aVar.epf == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lt(int i) {
        if (i + 1 == this.eoC.epg.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel lu(int i) {
        return i == -1 ? this.eoC.epf : this.eoC.epg.get(i);
    }
}

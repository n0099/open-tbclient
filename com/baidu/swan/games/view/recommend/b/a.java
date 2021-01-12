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
    private b eld;
    private b ele;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aZC() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.ele = new b(this.mContext);
        this.ele.elg.setAlpha(0.0f);
        frameLayout.addView(this.ele.elg);
        this.eld = new b(this.mContext);
        this.eld.elg.setAlpha(0.0f);
        this.eld.elh.setActualImageResource(17170445);
        this.eld.eli.setText((CharSequence) null);
        frameLayout.addView(this.eld.elg);
        this.eld.elg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ekS != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.ekS.aZI();
                    } else {
                        a.this.ekS.ln(a.this.mPosition);
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
            this.ele.elh.setImageURI(aVar.elu.iconUrl);
            this.ele.eli.setText(aVar.elu.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void aZD() {
        if (c(this.ekR)) {
            this.eld.elg.setAlpha(1.0f);
            this.eld.elh.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.eld.eli.setText(a.h.swangame_recommend_button_goto_game_center);
            super.aZD();
            return;
        }
        this.mPosition = lp(this.mPosition);
        this.ele.elg.animate().setDuration(160L).alpha(1.0f);
        this.eld.elg.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel lq = a.this.lq(a.this.mPosition);
                a.this.eld.elh.setImageURI(lq.iconUrl);
                a.this.eld.eli.setText(lq.appName);
                a.this.eld.elg.setAlpha(1.0f);
                RecommendItemModel lq2 = a.this.lq(a.this.lp(a.this.mPosition));
                a.this.ele.elh.setImageURI(lq2.iconUrl);
                a.this.ele.eli.setText(lq2.appName);
                a.this.ele.elg.setAlpha(0.0f);
                a.super.aZD();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.elv == null || aVar.elu == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lp(int i) {
        if (i + 1 == this.ekR.elv.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel lq(int i) {
        return i == -1 ? this.ekR.elu : this.ekR.elv.get(i);
    }
}

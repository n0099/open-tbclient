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
    private b cTr;
    private b cTs;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View azj() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.cTs = new b(this.mContext);
        this.cTs.cTu.setAlpha(0.0f);
        frameLayout.addView(this.cTs.cTu);
        this.cTr = new b(this.mContext);
        this.cTr.cTu.setAlpha(0.0f);
        this.cTr.cTv.setActualImageResource(17170445);
        this.cTr.cTw.setText((CharSequence) null);
        frameLayout.addView(this.cTr.cTu);
        this.cTr.cTu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cTh != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.cTh.azp();
                    } else {
                        a.this.cTh.ik(a.this.mPosition);
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
            this.cTs.cTv.setImageURI(aVar.cTI.iconUrl);
            this.cTs.cTw.setText(aVar.cTI.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void azk() {
        if (c(this.cTg)) {
            this.cTr.cTu.setAlpha(1.0f);
            this.cTr.cTv.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.cTr.cTw.setText(a.h.swangame_recommend_button_goto_game_center);
            super.azk();
            return;
        }
        this.mPosition = im(this.mPosition);
        this.cTs.cTu.animate().setDuration(160L).alpha(1.0f);
        this.cTr.cTu.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel in = a.this.in(a.this.mPosition);
                a.this.cTr.cTv.setImageURI(in.iconUrl);
                a.this.cTr.cTw.setText(in.appName);
                a.this.cTr.cTu.setAlpha(1.0f);
                RecommendItemModel in2 = a.this.in(a.this.im(a.this.mPosition));
                a.this.cTs.cTv.setImageURI(in2.iconUrl);
                a.this.cTs.cTw.setText(in2.appName);
                a.this.cTs.cTu.setAlpha(0.0f);
                a.super.azk();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.cTJ == null || aVar.cTI == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int im(int i) {
        if (i + 1 == this.cTg.cTJ.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel in(int i) {
        return i == -1 ? this.cTg.cTI : this.cTg.cTJ.get(i);
    }
}

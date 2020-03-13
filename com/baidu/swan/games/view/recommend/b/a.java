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
    private b cud;
    private b cue;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aqV() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.cue = new b(this.mContext);
        this.cue.cug.setAlpha(0.0f);
        frameLayout.addView(this.cue.cug);
        this.cud = new b(this.mContext);
        this.cud.cug.setAlpha(0.0f);
        this.cud.cuh.setActualImageResource(17170445);
        this.cud.cui.setText((CharSequence) null);
        frameLayout.addView(this.cud.cug);
        this.cud.cug.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ctT != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.ctT.arb();
                    } else {
                        a.this.ctT.id(a.this.mPosition);
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
            this.cue.cuh.setImageURI(aVar.cuw.iconUrl);
            this.cue.cui.setText(aVar.cuw.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void aqW() {
        if (c(this.ctS)) {
            this.cud.cug.setAlpha(1.0f);
            this.cud.cuh.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.cud.cui.setText(a.h.swangame_recommend_button_goto_game_center);
            super.aqW();
            return;
        }
        this.mPosition = m29if(this.mPosition);
        this.cue.cug.animate().setDuration(160L).alpha(1.0f);
        this.cud.cug.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel ig = a.this.ig(a.this.mPosition);
                a.this.cud.cuh.setImageURI(ig.iconUrl);
                a.this.cud.cui.setText(ig.appName);
                a.this.cud.cug.setAlpha(1.0f);
                RecommendItemModel ig2 = a.this.ig(a.this.m29if(a.this.mPosition));
                a.this.cue.cuh.setImageURI(ig2.iconUrl);
                a.this.cue.cui.setText(ig2.appName);
                a.this.cue.cug.setAlpha(0.0f);
                a.super.aqW();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.cux == null || aVar.cuw == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public int m29if(int i) {
        if (i + 1 == this.ctS.cux.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel ig(int i) {
        return i == -1 ? this.ctS.cuw : this.ctS.cux.get(i);
    }
}

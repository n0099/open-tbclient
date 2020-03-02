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
    private b cuc;
    private b cud;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aqV() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.cud = new b(this.mContext);
        this.cud.cuf.setAlpha(0.0f);
        frameLayout.addView(this.cud.cuf);
        this.cuc = new b(this.mContext);
        this.cuc.cuf.setAlpha(0.0f);
        this.cuc.cug.setActualImageResource(17170445);
        this.cuc.cuh.setText((CharSequence) null);
        frameLayout.addView(this.cuc.cuf);
        this.cuc.cuf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ctS != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.ctS.arb();
                    } else {
                        a.this.ctS.id(a.this.mPosition);
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
            this.cud.cug.setImageURI(aVar.cuv.iconUrl);
            this.cud.cuh.setText(aVar.cuv.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void aqW() {
        if (c(this.ctR)) {
            this.cuc.cuf.setAlpha(1.0f);
            this.cuc.cug.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.cuc.cuh.setText(a.h.swangame_recommend_button_goto_game_center);
            super.aqW();
            return;
        }
        this.mPosition = m29if(this.mPosition);
        this.cud.cuf.animate().setDuration(160L).alpha(1.0f);
        this.cuc.cuf.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel ig = a.this.ig(a.this.mPosition);
                a.this.cuc.cug.setImageURI(ig.iconUrl);
                a.this.cuc.cuh.setText(ig.appName);
                a.this.cuc.cuf.setAlpha(1.0f);
                RecommendItemModel ig2 = a.this.ig(a.this.m29if(a.this.mPosition));
                a.this.cud.cug.setImageURI(ig2.iconUrl);
                a.this.cud.cuh.setText(ig2.appName);
                a.this.cud.cuf.setAlpha(0.0f);
                a.super.aqW();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.cuw == null || aVar.cuv == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public int m29if(int i) {
        if (i + 1 == this.ctR.cuw.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel ig(int i) {
        return i == -1 ? this.ctR.cuv : this.ctR.cuw.get(i);
    }
}

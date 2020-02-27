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
    private b cub;
    private b cuc;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aqT() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.cuc = new b(this.mContext);
        this.cuc.cue.setAlpha(0.0f);
        frameLayout.addView(this.cuc.cue);
        this.cub = new b(this.mContext);
        this.cub.cue.setAlpha(0.0f);
        this.cub.cuf.setActualImageResource(17170445);
        this.cub.cug.setText((CharSequence) null);
        frameLayout.addView(this.cub.cue);
        this.cub.cue.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ctR != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.ctR.aqZ();
                    } else {
                        a.this.ctR.id(a.this.mPosition);
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
            this.cuc.cuf.setImageURI(aVar.cuu.iconUrl);
            this.cuc.cug.setText(aVar.cuu.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void aqU() {
        if (c(this.ctQ)) {
            this.cub.cue.setAlpha(1.0f);
            this.cub.cuf.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.cub.cug.setText(a.h.swangame_recommend_button_goto_game_center);
            super.aqU();
            return;
        }
        this.mPosition = m29if(this.mPosition);
        this.cuc.cue.animate().setDuration(160L).alpha(1.0f);
        this.cub.cue.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel ig = a.this.ig(a.this.mPosition);
                a.this.cub.cuf.setImageURI(ig.iconUrl);
                a.this.cub.cug.setText(ig.appName);
                a.this.cub.cue.setAlpha(1.0f);
                RecommendItemModel ig2 = a.this.ig(a.this.m29if(a.this.mPosition));
                a.this.cuc.cuf.setImageURI(ig2.iconUrl);
                a.this.cuc.cug.setText(ig2.appName);
                a.this.cuc.cue.setAlpha(0.0f);
                a.super.aqU();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.cuv == null || aVar.cuu == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public int m29if(int i) {
        if (i + 1 == this.ctQ.cuv.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel ig(int i) {
        return i == -1 ? this.ctQ.cuu : this.ctQ.cuv.get(i);
    }
}

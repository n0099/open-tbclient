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
    private b cuo;
    private b cup;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aqY() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.cup = new b(this.mContext);
        this.cup.cus.setAlpha(0.0f);
        frameLayout.addView(this.cup.cus);
        this.cuo = new b(this.mContext);
        this.cuo.cus.setAlpha(0.0f);
        this.cuo.cuu.setActualImageResource(17170445);
        this.cuo.cuv.setText((CharSequence) null);
        frameLayout.addView(this.cuo.cus);
        this.cuo.cus.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cue != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.cue.are();
                    } else {
                        a.this.cue.id(a.this.mPosition);
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
            this.cup.cuu.setImageURI(aVar.cuH.iconUrl);
            this.cup.cuv.setText(aVar.cuH.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void aqZ() {
        if (c(this.cud)) {
            this.cuo.cus.setAlpha(1.0f);
            this.cuo.cuu.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.cuo.cuv.setText(a.h.swangame_recommend_button_goto_game_center);
            super.aqZ();
            return;
        }
        this.mPosition = m28if(this.mPosition);
        this.cup.cus.animate().setDuration(160L).alpha(1.0f);
        this.cuo.cus.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel ig = a.this.ig(a.this.mPosition);
                a.this.cuo.cuu.setImageURI(ig.iconUrl);
                a.this.cuo.cuv.setText(ig.appName);
                a.this.cuo.cus.setAlpha(1.0f);
                RecommendItemModel ig2 = a.this.ig(a.this.m28if(a.this.mPosition));
                a.this.cup.cuu.setImageURI(ig2.iconUrl);
                a.this.cup.cuv.setText(ig2.appName);
                a.this.cup.cus.setAlpha(0.0f);
                a.super.aqZ();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.cuI == null || aVar.cuH == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public int m28if(int i) {
        if (i + 1 == this.cud.cuI.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel ig(int i) {
        return i == -1 ? this.cud.cuH : this.cud.cuI.get(i);
    }
}

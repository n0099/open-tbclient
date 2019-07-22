package com.baidu.swan.games.view.recommend.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.games.view.recommend.a.d;
/* loaded from: classes2.dex */
public class a extends com.baidu.swan.games.view.recommend.a.a {
    private b bmO;
    private b bmP;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View TY() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.bmP = new b(this.mContext);
        this.bmP.bmR.setAlpha(0.0f);
        frameLayout.addView(this.bmP.bmR);
        this.bmO = new b(this.mContext);
        this.bmO.bmR.setAlpha(0.0f);
        this.bmO.bmS.setActualImageResource(17170445);
        this.bmO.bmT.setText((CharSequence) null);
        frameLayout.addView(this.bmO.bmR);
        this.bmO.bmR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bmD != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.bmD.Uf();
                    } else {
                        a.this.bmD.fm(a.this.mPosition);
                    }
                }
            }
        });
        return frameLayout;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a, com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.d.b bVar) {
        super.a(bVar);
        if (!c(bVar)) {
            this.mPosition = -2;
            this.bmP.bmS.setImageURI(bVar.bnf.iconUrl);
            this.bmP.bmT.setText(bVar.bnf.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void TZ() {
        if (c(this.bmC)) {
            this.bmO.bmR.setAlpha(1.0f);
            this.bmO.bmS.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.bmO.bmT.setText(a.h.swangame_recommend_button_goto_game_center);
            super.TZ();
            return;
        }
        this.mPosition = fo(this.mPosition);
        this.bmP.bmR.animate().setDuration(160L).alpha(1.0f);
        this.bmO.bmR.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                com.baidu.swan.games.view.recommend.d.a fp = a.this.fp(a.this.mPosition);
                a.this.bmO.bmS.setImageURI(fp.iconUrl);
                a.this.bmO.bmT.setText(fp.appName);
                a.this.bmO.bmR.setAlpha(1.0f);
                com.baidu.swan.games.view.recommend.d.a fp2 = a.this.fp(a.this.fo(a.this.mPosition));
                a.this.bmP.bmS.setImageURI(fp2.iconUrl);
                a.this.bmP.bmT.setText(fp2.appName);
                a.this.bmP.bmR.setAlpha(0.0f);
                a.super.TZ();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.d.b bVar) {
        return bVar == null || bVar.bng == null || bVar.bnf == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fo(int i) {
        if (i + 1 == this.bmC.bng.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.games.view.recommend.d.a fp(int i) {
        return i == -1 ? this.bmC.bnf : this.bmC.bng.get(i);
    }
}

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
    private b bFY;
    private b bFZ;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View YS() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.bFZ = new b(this.mContext);
        this.bFZ.bGb.setAlpha(0.0f);
        frameLayout.addView(this.bFZ.bGb);
        this.bFY = new b(this.mContext);
        this.bFY.bGb.setAlpha(0.0f);
        this.bFY.bGc.setActualImageResource(17170445);
        this.bFY.bGd.setText((CharSequence) null);
        frameLayout.addView(this.bFY.bGb);
        this.bFY.bGb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bFN != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.bFN.YY();
                    } else {
                        a.this.bFN.gi(a.this.mPosition);
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
            this.bFZ.bGc.setImageURI(bVar.bGp.iconUrl);
            this.bFZ.bGd.setText(bVar.bGp.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void YT() {
        if (c(this.bFM)) {
            this.bFY.bGb.setAlpha(1.0f);
            this.bFY.bGc.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.bFY.bGd.setText(a.h.swangame_recommend_button_goto_game_center);
            super.YT();
            return;
        }
        this.mPosition = gk(this.mPosition);
        this.bFZ.bGb.animate().setDuration(160L).alpha(1.0f);
        this.bFY.bGb.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                com.baidu.swan.games.view.recommend.d.a gl = a.this.gl(a.this.mPosition);
                a.this.bFY.bGc.setImageURI(gl.iconUrl);
                a.this.bFY.bGd.setText(gl.appName);
                a.this.bFY.bGb.setAlpha(1.0f);
                com.baidu.swan.games.view.recommend.d.a gl2 = a.this.gl(a.this.gk(a.this.mPosition));
                a.this.bFZ.bGc.setImageURI(gl2.iconUrl);
                a.this.bFZ.bGd.setText(gl2.appName);
                a.this.bFZ.bGb.setAlpha(0.0f);
                a.super.YT();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.d.b bVar) {
        return bVar == null || bVar.bGq == null || bVar.bGp == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int gk(int i) {
        if (i + 1 == this.bFM.bGq.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.games.view.recommend.d.a gl(int i) {
        return i == -1 ? this.bFM.bGp : this.bFM.bGq.get(i);
    }
}

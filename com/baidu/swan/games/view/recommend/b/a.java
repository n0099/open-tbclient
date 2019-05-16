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
    private b bma;
    private b bmb;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View Tf() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.bmb = new b(this.mContext);
        this.bmb.bmd.setAlpha(0.0f);
        frameLayout.addView(this.bmb.bmd);
        this.bma = new b(this.mContext);
        this.bma.bmd.setAlpha(0.0f);
        this.bma.bme.setActualImageResource(17170445);
        this.bma.bmf.setText((CharSequence) null);
        frameLayout.addView(this.bma.bmd);
        this.bma.bmd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.blP != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.blP.Tm();
                    } else {
                        a.this.blP.fi(a.this.mPosition);
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
            this.bmb.bme.setImageURI(bVar.bms.iconUrl);
            this.bmb.bmf.setText(bVar.bms.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void Tg() {
        if (c(this.blO)) {
            this.bma.bmd.setAlpha(1.0f);
            this.bma.bme.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.bma.bmf.setText(a.h.swangame_recommend_button_goto_game_center);
            super.Tg();
            return;
        }
        this.mPosition = fk(this.mPosition);
        this.bmb.bmd.animate().setDuration(160L).alpha(1.0f);
        this.bma.bmd.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                com.baidu.swan.games.view.recommend.d.a fl = a.this.fl(a.this.mPosition);
                a.this.bma.bme.setImageURI(fl.iconUrl);
                a.this.bma.bmf.setText(fl.appName);
                a.this.bma.bmd.setAlpha(1.0f);
                com.baidu.swan.games.view.recommend.d.a fl2 = a.this.fl(a.this.fk(a.this.mPosition));
                a.this.bmb.bme.setImageURI(fl2.iconUrl);
                a.this.bmb.bmf.setText(fl2.appName);
                a.this.bmb.bmd.setAlpha(0.0f);
                a.super.Tg();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.d.b bVar) {
        return bVar == null || bVar.bmt == null || bVar.bms == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fk(int i) {
        if (i + 1 == this.blO.bmt.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.games.view.recommend.d.a fl(int i) {
        return i == -1 ? this.blO.bms : this.blO.bmt.get(i);
    }
}

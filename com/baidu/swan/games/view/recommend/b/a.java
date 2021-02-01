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
/* loaded from: classes9.dex */
public class a extends com.baidu.swan.games.view.recommend.a.a {
    private b enl;
    private b enm;
    private int mPosition;

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.mPosition = -2;
    }

    @Override // com.baidu.swan.games.view.recommend.a.a
    protected View aZP() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.enm = new b(this.mContext);
        this.enm.eno.setAlpha(0.0f);
        frameLayout.addView(this.enm.eno);
        this.enl = new b(this.mContext);
        this.enl.eno.setAlpha(0.0f);
        this.enl.enp.setActualImageResource(17170445);
        this.enl.enq.setText((CharSequence) null);
        frameLayout.addView(this.enl.eno);
        this.enl.eno.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.emZ != null && a.this.mPosition >= -1) {
                    if (a.this.mPosition == -1) {
                        a.this.emZ.aZV();
                    } else {
                        a.this.emZ.lq(a.this.mPosition);
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
            this.enm.enp.setImageURI(aVar.enD.iconUrl);
            this.enm.enq.setText(aVar.enD.appName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.view.recommend.a.a
    public void aZQ() {
        if (c(this.emY)) {
            this.enl.eno.setAlpha(1.0f);
            this.enl.enp.setActualImageResource(a.e.swangame_recommend_gamecenter);
            this.enl.enq.setText(a.h.swangame_recommend_button_goto_game_center);
            super.aZQ();
            return;
        }
        this.mPosition = ls(this.mPosition);
        this.enm.eno.animate().setDuration(160L).alpha(1.0f);
        this.enl.eno.animate().setDuration(160L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.games.view.recommend.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecommendItemModel lt = a.this.lt(a.this.mPosition);
                a.this.enl.enp.setImageURI(lt.iconUrl);
                a.this.enl.enq.setText(lt.appName);
                a.this.enl.eno.setAlpha(1.0f);
                RecommendItemModel lt2 = a.this.lt(a.this.ls(a.this.mPosition));
                a.this.enm.enp.setImageURI(lt2.iconUrl);
                a.this.enm.enq.setText(lt2.appName);
                a.this.enm.eno.setAlpha(0.0f);
                a.super.aZQ();
            }
        });
    }

    private boolean c(com.baidu.swan.games.view.recommend.model.a aVar) {
        return aVar == null || aVar.enE == null || aVar.enD == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ls(int i) {
        if (i + 1 == this.emY.enE.size()) {
            return -1;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecommendItemModel lt(int i) {
        return i == -1 ? this.emY.enD : this.emY.enE.get(i);
    }
}

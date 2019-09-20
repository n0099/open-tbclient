package com.baidu.swan.games.view.recommend.a;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
@UiThread
/* loaded from: classes2.dex */
public class a implements b {
    protected com.baidu.swan.games.view.recommend.d.b bna;
    protected InterfaceC0229a bnb;
    private int bnc;
    private boolean bnd;
    private ObjectAnimator bne;
    private d bnf;
    protected Context mContext;
    protected Handler mHandler;
    private ViewGroup mRootView;

    /* renamed from: com.baidu.swan.games.view.recommend.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0229a {
        void Uj();

        void Uk();

        void fn(int i);
    }

    public a(@NonNull Context context, @NonNull d dVar) {
        this.mContext = context;
        this.bnf = dVar;
        av(Uc());
        Uf();
        Uh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Uc() {
        return LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ud() {
        this.bne.start();
    }

    protected int Ue() {
        return 5000;
    }

    private void av(View view) {
        this.bnc = (int) this.mContext.getResources().getDimension(a.d.swangame_recommend_button_root_padding);
        this.mRootView = new FrameLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.swan.games.utils.b.ad(this.bnf.width), com.baidu.swan.games.utils.b.ad(this.bnf.height));
        layoutParams.setMargins(this.bnc, this.bnc, this.bnc, this.bnc);
        this.mRootView.setBackgroundColor(0);
        this.mRootView.addView(view, layoutParams);
    }

    private void Uf() {
        this.bne = Ug();
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.swan.games.view.recommend.a.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        int Ue = a.this.Ue();
                        if (Ue > 0 && a.this.bnd) {
                            a.this.mHandler.sendEmptyMessageDelayed(1, Ue);
                        }
                        a.this.Ud();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    private ObjectAnimator Ug() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mRootView, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.2f * 0.0f, 0.0f), Keyframe.ofFloat(1.0f * 0.2f, 6.0f), Keyframe.ofFloat(2.0f * 0.2f, -6.0f), Keyframe.ofFloat(3.0f * 0.2f, 6.0f), Keyframe.ofFloat(4.0f * 0.2f, -6.0f), Keyframe.ofFloat(0.2f * 5.0f, 0.0f)));
        ofPropertyValuesHolder.setDuration(600L);
        return ofPropertyValuesHolder;
    }

    private void Uh() {
        this.mRootView.setVisibility(8);
        com.baidu.swan.games.view.a.c(this.mRootView, Ui());
    }

    private com.baidu.swan.apps.model.a.a.b Ui() {
        com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b();
        bVar.cN(com.baidu.swan.games.utils.b.ad(this.bnf.left) - this.bnc);
        bVar.cO(com.baidu.swan.games.utils.b.ad(this.bnf.top) - this.bnc);
        bVar.setWidth(-2);
        bVar.setHeight(-2);
        return bVar;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.d.b bVar) {
        this.bna = bVar;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(InterfaceC0229a interfaceC0229a) {
        this.bnb = interfaceC0229a;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void by(boolean z) {
        if (this.bnd) {
            this.mHandler.removeMessages(1);
            if (z) {
                this.mHandler.sendEmptyMessage(1);
            }
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void show() {
        this.bnd = true;
        this.mRootView.setVisibility(0);
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessage(1);
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void hide() {
        this.bnd = false;
        this.mHandler.removeMessages(1);
        this.mRootView.setVisibility(8);
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void destroy() {
        this.bnd = false;
        this.mHandler.removeCallbacksAndMessages(null);
        com.baidu.swan.games.view.a.an(this.mRootView);
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void update() {
        com.baidu.swan.games.view.a.b(this.mRootView, Ui());
    }

    @NonNull
    public static a a(int i, @NonNull Context context, @NonNull d dVar) {
        switch (i) {
            case 1:
                return new com.baidu.swan.games.view.recommend.b.a(context, dVar);
            case 2:
                return new com.baidu.swan.games.view.recommend.c.b(context, dVar);
            default:
                return new com.baidu.swan.games.view.recommend.b.a(context, dVar);
        }
    }
}

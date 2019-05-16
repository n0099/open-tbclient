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
import com.baidu.mapapi.UIMsg;
import com.baidu.swan.apps.a;
@UiThread
/* loaded from: classes2.dex */
public class a implements b {
    protected com.baidu.swan.games.view.recommend.d.b blO;
    protected InterfaceC0218a blP;
    private int blQ;
    private boolean blR;
    private ObjectAnimator blS;
    private d blT;
    protected Context mContext;
    protected Handler mHandler;
    private ViewGroup mRootView;

    /* renamed from: com.baidu.swan.games.view.recommend.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0218a {
        void Tm();

        void Tn();

        void fi(int i);
    }

    public a(@NonNull Context context, @NonNull d dVar) {
        this.mContext = context;
        this.blT = dVar;
        at(Tf());
        Ti();
        Tk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Tf() {
        return LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Tg() {
        this.blS.start();
    }

    protected int Th() {
        return UIMsg.m_AppUI.MSG_APP_GPS;
    }

    private void at(View view) {
        this.blQ = (int) this.mContext.getResources().getDimension(a.d.swangame_recommend_button_root_padding);
        this.mRootView = new FrameLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.swan.games.utils.b.ad(this.blT.width), com.baidu.swan.games.utils.b.ad(this.blT.height));
        layoutParams.setMargins(this.blQ, this.blQ, this.blQ, this.blQ);
        this.mRootView.setBackgroundColor(0);
        this.mRootView.addView(view, layoutParams);
    }

    private void Ti() {
        this.blS = Tj();
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.swan.games.view.recommend.a.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        int Th = a.this.Th();
                        if (Th > 0 && a.this.blR) {
                            a.this.mHandler.sendEmptyMessageDelayed(1, Th);
                        }
                        a.this.Tg();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    private ObjectAnimator Tj() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mRootView, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.2f * 0.0f, 0.0f), Keyframe.ofFloat(1.0f * 0.2f, 6.0f), Keyframe.ofFloat(2.0f * 0.2f, -6.0f), Keyframe.ofFloat(3.0f * 0.2f, 6.0f), Keyframe.ofFloat(4.0f * 0.2f, -6.0f), Keyframe.ofFloat(0.2f * 5.0f, 0.0f)));
        ofPropertyValuesHolder.setDuration(600L);
        return ofPropertyValuesHolder;
    }

    private void Tk() {
        this.mRootView.setVisibility(8);
        com.baidu.swan.games.view.a.c(this.mRootView, Tl());
    }

    private com.baidu.swan.apps.model.a.a.b Tl() {
        com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b();
        bVar.setLeft(com.baidu.swan.games.utils.b.ad(this.blT.left) - this.blQ);
        bVar.setTop(com.baidu.swan.games.utils.b.ad(this.blT.top) - this.blQ);
        bVar.setWidth(-2);
        bVar.setHeight(-2);
        return bVar;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.d.b bVar) {
        this.blO = bVar;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(InterfaceC0218a interfaceC0218a) {
        this.blP = interfaceC0218a;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void bv(boolean z) {
        if (this.blR) {
            this.mHandler.removeMessages(1);
            if (z) {
                this.mHandler.sendEmptyMessage(1);
            }
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void show() {
        this.blR = true;
        this.mRootView.setVisibility(0);
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessage(1);
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void hide() {
        this.blR = false;
        this.mHandler.removeMessages(1);
        this.mRootView.setVisibility(8);
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void destroy() {
        this.blR = false;
        this.mHandler.removeCallbacksAndMessages(null);
        com.baidu.swan.games.view.a.al(this.mRootView);
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void update() {
        com.baidu.swan.games.view.a.b(this.mRootView, Tl());
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

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
/* loaded from: classes3.dex */
public class a implements b {
    protected com.baidu.swan.games.view.recommend.model.a dAX;
    protected InterfaceC0504a dAY;
    private int dAZ;
    private ObjectAnimator dBa;
    private d dBb;
    protected Context mContext;
    protected Handler mHandler;
    private boolean mIsShowing;
    private ViewGroup mRootView;

    /* renamed from: com.baidu.swan.games.view.recommend.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0504a {
        void aRI();

        void aRJ();

        void lz(int i);
    }

    public a(@NonNull Context context, @NonNull d dVar) {
        this.mContext = context;
        this.dBb = dVar;
        aJ(aRC());
        initAnimation();
        aRG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aRC() {
        return LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aRD() {
        this.dBa.start();
    }

    protected int aRE() {
        return 5000;
    }

    private void aJ(View view) {
        this.dAZ = (int) this.mContext.getResources().getDimension(a.d.swangame_recommend_button_root_padding);
        this.mRootView = new FrameLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.swan.games.utils.e.H(this.dBb.width), com.baidu.swan.games.utils.e.H(this.dBb.height));
        layoutParams.setMargins(this.dAZ, this.dAZ, this.dAZ, this.dAZ);
        this.mRootView.setBackgroundColor(0);
        this.mRootView.addView(view, layoutParams);
    }

    private void initAnimation() {
        this.dBa = aRF();
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.swan.games.view.recommend.a.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        int aRE = a.this.aRE();
                        if (aRE > 0 && a.this.mIsShowing) {
                            a.this.mHandler.sendEmptyMessageDelayed(1, aRE);
                        }
                        a.this.aRD();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    private ObjectAnimator aRF() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mRootView, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.2f * 0.0f, 0.0f), Keyframe.ofFloat(1.0f * 0.2f, 6.0f), Keyframe.ofFloat(2.0f * 0.2f, -6.0f), Keyframe.ofFloat(3.0f * 0.2f, 6.0f), Keyframe.ofFloat(4.0f * 0.2f, -6.0f), Keyframe.ofFloat(0.2f * 5.0f, 0.0f)));
        ofPropertyValuesHolder.setDuration(600L);
        return ofPropertyValuesHolder;
    }

    private void aRG() {
        this.mRootView.setVisibility(8);
        com.baidu.swan.games.view.c.c(this.mRootView, aRH());
    }

    private com.baidu.swan.apps.model.a.a.a aRH() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.iI(com.baidu.swan.games.utils.e.H(this.dBb.left) - this.dAZ);
        aVar.iJ(com.baidu.swan.games.utils.e.H(this.dBb.top) - this.dAZ);
        aVar.setWidth(-2);
        aVar.setHeight(-2);
        return aVar;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        this.dAX = aVar;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(InterfaceC0504a interfaceC0504a) {
        this.dAY = interfaceC0504a;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void eI(boolean z) {
        if (this.mIsShowing) {
            this.mHandler.removeMessages(1);
            if (z) {
                this.mHandler.sendEmptyMessage(1);
            }
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void show() {
        this.mIsShowing = true;
        this.mRootView.setVisibility(0);
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessage(1);
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void hide() {
        this.mIsShowing = false;
        this.mHandler.removeMessages(1);
        this.mRootView.setVisibility(8);
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void destroy() {
        this.mIsShowing = false;
        this.mHandler.removeCallbacksAndMessages(null);
        com.baidu.swan.games.view.c.removeView(this.mRootView);
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void update() {
        com.baidu.swan.games.view.c.b(this.mRootView, aRH());
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

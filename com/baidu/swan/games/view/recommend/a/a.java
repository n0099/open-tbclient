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
/* loaded from: classes11.dex */
public class a implements b {
    protected com.baidu.swan.games.view.recommend.model.a cTb;
    protected InterfaceC0380a cTc;
    private int cTd;
    private ObjectAnimator cTe;
    private d cTf;
    protected Context mContext;
    protected Handler mHandler;
    private boolean mIsShowing;
    private ViewGroup mRootView;

    /* renamed from: com.baidu.swan.games.view.recommend.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0380a {
        void azp();

        void azq();

        void ik(int i);
    }

    public a(@NonNull Context context, @NonNull d dVar) {
        this.mContext = context;
        this.cTf = dVar;
        aB(azj());
        initAnimation();
        azn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View azj() {
        return LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void azk() {
        this.cTe.start();
    }

    protected int azl() {
        return 5000;
    }

    private void aB(View view) {
        this.cTd = (int) this.mContext.getResources().getDimension(a.d.swangame_recommend_button_root_padding);
        this.mRootView = new FrameLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.swan.games.utils.d.C(this.cTf.width), com.baidu.swan.games.utils.d.C(this.cTf.height));
        layoutParams.setMargins(this.cTd, this.cTd, this.cTd, this.cTd);
        this.mRootView.setBackgroundColor(0);
        this.mRootView.addView(view, layoutParams);
    }

    private void initAnimation() {
        this.cTe = azm();
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.swan.games.view.recommend.a.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        int azl = a.this.azl();
                        if (azl > 0 && a.this.mIsShowing) {
                            a.this.mHandler.sendEmptyMessageDelayed(1, azl);
                        }
                        a.this.azk();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    private ObjectAnimator azm() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mRootView, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.2f * 0.0f, 0.0f), Keyframe.ofFloat(1.0f * 0.2f, 6.0f), Keyframe.ofFloat(2.0f * 0.2f, -6.0f), Keyframe.ofFloat(3.0f * 0.2f, 6.0f), Keyframe.ofFloat(4.0f * 0.2f, -6.0f), Keyframe.ofFloat(0.2f * 5.0f, 0.0f)));
        ofPropertyValuesHolder.setDuration(600L);
        return ofPropertyValuesHolder;
    }

    private void azn() {
        this.mRootView.setVisibility(8);
        com.baidu.swan.games.view.c.c(this.mRootView, azo());
    }

    private com.baidu.swan.apps.model.a.a.a azo() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.fF(com.baidu.swan.games.utils.d.C(this.cTf.left) - this.cTd);
        aVar.fG(com.baidu.swan.games.utils.d.C(this.cTf.f1017top) - this.cTd);
        aVar.setWidth(-2);
        aVar.setHeight(-2);
        return aVar;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        this.cTb = aVar;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(InterfaceC0380a interfaceC0380a) {
        this.cTc = interfaceC0380a;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void dP(boolean z) {
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
        com.baidu.swan.games.view.c.av(this.mRootView);
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void update() {
        com.baidu.swan.games.view.c.b(this.mRootView, azo());
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

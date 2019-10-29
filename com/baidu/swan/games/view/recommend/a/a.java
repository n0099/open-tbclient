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
    protected com.baidu.swan.games.view.recommend.d.b bFM;
    protected InterfaceC0261a bFN;
    private int bFO;
    private boolean bFP;
    private ObjectAnimator bFQ;
    private d bFR;
    protected Context mContext;
    protected Handler mHandler;
    private ViewGroup mRootView;

    /* renamed from: com.baidu.swan.games.view.recommend.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0261a {
        void YY();

        void YZ();

        void gi(int i);
    }

    public a(@NonNull Context context, @NonNull d dVar) {
        this.mContext = context;
        this.bFR = dVar;
        aB(YS());
        wI();
        YW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View YS() {
        return LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void YT() {
        this.bFQ.start();
    }

    protected int YU() {
        return 5000;
    }

    private void aB(View view) {
        this.bFO = (int) this.mContext.getResources().getDimension(a.d.swangame_recommend_button_root_padding);
        this.mRootView = new FrameLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.swan.games.utils.b.S(this.bFR.width), com.baidu.swan.games.utils.b.S(this.bFR.height));
        layoutParams.setMargins(this.bFO, this.bFO, this.bFO, this.bFO);
        this.mRootView.setBackgroundColor(0);
        this.mRootView.addView(view, layoutParams);
    }

    private void wI() {
        this.bFQ = YV();
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.swan.games.view.recommend.a.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        int YU = a.this.YU();
                        if (YU > 0 && a.this.bFP) {
                            a.this.mHandler.sendEmptyMessageDelayed(1, YU);
                        }
                        a.this.YT();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    private ObjectAnimator YV() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mRootView, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.2f * 0.0f, 0.0f), Keyframe.ofFloat(1.0f * 0.2f, 6.0f), Keyframe.ofFloat(2.0f * 0.2f, -6.0f), Keyframe.ofFloat(3.0f * 0.2f, 6.0f), Keyframe.ofFloat(4.0f * 0.2f, -6.0f), Keyframe.ofFloat(0.2f * 5.0f, 0.0f)));
        ofPropertyValuesHolder.setDuration(600L);
        return ofPropertyValuesHolder;
    }

    private void YW() {
        this.mRootView.setVisibility(8);
        com.baidu.swan.games.view.a.c(this.mRootView, YX());
    }

    private com.baidu.swan.apps.model.a.a.b YX() {
        com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b();
        bVar.dI(com.baidu.swan.games.utils.b.S(this.bFR.left) - this.bFO);
        bVar.dJ(com.baidu.swan.games.utils.b.S(this.bFR.top) - this.bFO);
        bVar.setWidth(-2);
        bVar.setHeight(-2);
        return bVar;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.d.b bVar) {
        this.bFM = bVar;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(InterfaceC0261a interfaceC0261a) {
        this.bFN = interfaceC0261a;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void bQ(boolean z) {
        if (this.bFP) {
            this.mHandler.removeMessages(1);
            if (z) {
                this.mHandler.sendEmptyMessage(1);
            }
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void show() {
        this.bFP = true;
        this.mRootView.setVisibility(0);
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessage(1);
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void hide() {
        this.bFP = false;
        this.mHandler.removeMessages(1);
        this.mRootView.setVisibility(8);
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void destroy() {
        this.bFP = false;
        this.mHandler.removeCallbacksAndMessages(null);
        com.baidu.swan.games.view.a.at(this.mRootView);
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void update() {
        com.baidu.swan.games.view.a.b(this.mRootView, YX());
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

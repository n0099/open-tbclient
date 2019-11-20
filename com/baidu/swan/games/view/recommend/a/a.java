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
    protected com.baidu.swan.games.view.recommend.d.b bEV;
    protected InterfaceC0261a bEW;
    private int bEX;
    private boolean bEY;
    private ObjectAnimator bEZ;
    private d bFa;
    protected Context mContext;
    protected Handler mHandler;
    private ViewGroup mRootView;

    /* renamed from: com.baidu.swan.games.view.recommend.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0261a {
        void YW();

        void YX();

        void gh(int i);
    }

    public a(@NonNull Context context, @NonNull d dVar) {
        this.mContext = context;
        this.bFa = dVar;
        aB(YQ());
        wJ();
        YU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View YQ() {
        return LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void YR() {
        this.bEZ.start();
    }

    protected int YS() {
        return 5000;
    }

    private void aB(View view) {
        this.bEX = (int) this.mContext.getResources().getDimension(a.d.swangame_recommend_button_root_padding);
        this.mRootView = new FrameLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.swan.games.utils.b.S(this.bFa.width), com.baidu.swan.games.utils.b.S(this.bFa.height));
        layoutParams.setMargins(this.bEX, this.bEX, this.bEX, this.bEX);
        this.mRootView.setBackgroundColor(0);
        this.mRootView.addView(view, layoutParams);
    }

    private void wJ() {
        this.bEZ = YT();
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.swan.games.view.recommend.a.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        int YS = a.this.YS();
                        if (YS > 0 && a.this.bEY) {
                            a.this.mHandler.sendEmptyMessageDelayed(1, YS);
                        }
                        a.this.YR();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    private ObjectAnimator YT() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mRootView, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.2f * 0.0f, 0.0f), Keyframe.ofFloat(1.0f * 0.2f, 6.0f), Keyframe.ofFloat(2.0f * 0.2f, -6.0f), Keyframe.ofFloat(3.0f * 0.2f, 6.0f), Keyframe.ofFloat(4.0f * 0.2f, -6.0f), Keyframe.ofFloat(0.2f * 5.0f, 0.0f)));
        ofPropertyValuesHolder.setDuration(600L);
        return ofPropertyValuesHolder;
    }

    private void YU() {
        this.mRootView.setVisibility(8);
        com.baidu.swan.games.view.a.c(this.mRootView, YV());
    }

    private com.baidu.swan.apps.model.a.a.b YV() {
        com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b();
        bVar.dI(com.baidu.swan.games.utils.b.S(this.bFa.left) - this.bEX);
        bVar.dJ(com.baidu.swan.games.utils.b.S(this.bFa.top) - this.bEX);
        bVar.setWidth(-2);
        bVar.setHeight(-2);
        return bVar;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.d.b bVar) {
        this.bEV = bVar;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(InterfaceC0261a interfaceC0261a) {
        this.bEW = interfaceC0261a;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void bQ(boolean z) {
        if (this.bEY) {
            this.mHandler.removeMessages(1);
            if (z) {
                this.mHandler.sendEmptyMessage(1);
            }
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void show() {
        this.bEY = true;
        this.mRootView.setVisibility(0);
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessage(1);
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void hide() {
        this.bEY = false;
        this.mHandler.removeMessages(1);
        this.mRootView.setVisibility(8);
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void destroy() {
        this.bEY = false;
        this.mHandler.removeCallbacksAndMessages(null);
        com.baidu.swan.games.view.a.at(this.mRootView);
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void update() {
        com.baidu.swan.games.view.a.b(this.mRootView, YV());
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

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
/* loaded from: classes10.dex */
public class a implements b {
    protected com.baidu.swan.games.view.recommend.model.a ebn;
    protected InterfaceC0547a ebo;
    private int ebp;
    private ObjectAnimator ebq;
    private d ebr;
    protected Context mContext;
    protected Handler mHandler;
    private boolean mIsShowing;
    private ViewGroup mRootView;

    /* renamed from: com.baidu.swan.games.view.recommend.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0547a {
        void aYL();

        void aYM();

        void mr(int i);
    }

    public a(@NonNull Context context, @NonNull d dVar) {
        this.mContext = context;
        this.ebr = dVar;
        aP(aYF());
        initAnimation();
        aYJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aYF() {
        return LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aYG() {
        this.ebq.start();
    }

    protected int aYH() {
        return 5000;
    }

    private void aP(View view) {
        this.ebp = (int) this.mContext.getResources().getDimension(a.d.swangame_recommend_button_root_padding);
        this.mRootView = new FrameLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.swan.games.utils.e.N(this.ebr.width), com.baidu.swan.games.utils.e.N(this.ebr.height));
        layoutParams.setMargins(this.ebp, this.ebp, this.ebp, this.ebp);
        this.mRootView.setBackgroundColor(0);
        this.mRootView.addView(view, layoutParams);
    }

    private void initAnimation() {
        this.ebq = aYI();
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.swan.games.view.recommend.a.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        int aYH = a.this.aYH();
                        if (aYH > 0 && a.this.mIsShowing) {
                            a.this.mHandler.sendEmptyMessageDelayed(1, aYH);
                        }
                        a.this.aYG();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    private ObjectAnimator aYI() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mRootView, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.2f * 0.0f, 0.0f), Keyframe.ofFloat(1.0f * 0.2f, 6.0f), Keyframe.ofFloat(2.0f * 0.2f, -6.0f), Keyframe.ofFloat(3.0f * 0.2f, 6.0f), Keyframe.ofFloat(4.0f * 0.2f, -6.0f), Keyframe.ofFloat(0.2f * 5.0f, 0.0f)));
        ofPropertyValuesHolder.setDuration(600L);
        return ofPropertyValuesHolder;
    }

    private void aYJ() {
        this.mRootView.setVisibility(8);
        com.baidu.swan.games.view.c.c(this.mRootView, aYK());
    }

    private com.baidu.swan.apps.model.a.a.a aYK() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.jA(com.baidu.swan.games.utils.e.N(this.ebr.left) - this.ebp);
        aVar.jB(com.baidu.swan.games.utils.e.N(this.ebr.top) - this.ebp);
        aVar.setWidth(-2);
        aVar.setHeight(-2);
        return aVar;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        this.ebn = aVar;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(InterfaceC0547a interfaceC0547a) {
        this.ebo = interfaceC0547a;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void fA(boolean z) {
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
        com.baidu.swan.games.view.c.b(this.mRootView, aYK());
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

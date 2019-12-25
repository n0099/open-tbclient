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
/* loaded from: classes9.dex */
public class a implements b {
    protected com.baidu.swan.games.view.recommend.model.a cpD;
    protected InterfaceC0338a cpE;
    private int cpF;
    private ObjectAnimator cpG;
    private d cpH;
    protected Context mContext;
    protected Handler mHandler;
    private boolean mIsShowing;
    private ViewGroup mRootView;

    /* renamed from: com.baidu.swan.games.view.recommend.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0338a {
        void aos();

        void aot();

        void hM(int i);
    }

    public a(@NonNull Context context, @NonNull d dVar) {
        this.mContext = context;
        this.cpH = dVar;
        aw(aom());
        initAnimation();
        aoq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aom() {
        return LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aon() {
        this.cpG.start();
    }

    protected int aoo() {
        return 5000;
    }

    private void aw(View view) {
        this.cpF = (int) this.mContext.getResources().getDimension(a.d.swangame_recommend_button_root_padding);
        this.mRootView = new FrameLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.swan.games.utils.d.T(this.cpH.width), com.baidu.swan.games.utils.d.T(this.cpH.height));
        layoutParams.setMargins(this.cpF, this.cpF, this.cpF, this.cpF);
        this.mRootView.setBackgroundColor(0);
        this.mRootView.addView(view, layoutParams);
    }

    private void initAnimation() {
        this.cpG = aop();
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.swan.games.view.recommend.a.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        int aoo = a.this.aoo();
                        if (aoo > 0 && a.this.mIsShowing) {
                            a.this.mHandler.sendEmptyMessageDelayed(1, aoo);
                        }
                        a.this.aon();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    private ObjectAnimator aop() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mRootView, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.2f * 0.0f, 0.0f), Keyframe.ofFloat(1.0f * 0.2f, 6.0f), Keyframe.ofFloat(2.0f * 0.2f, -6.0f), Keyframe.ofFloat(3.0f * 0.2f, 6.0f), Keyframe.ofFloat(4.0f * 0.2f, -6.0f), Keyframe.ofFloat(0.2f * 5.0f, 0.0f)));
        ofPropertyValuesHolder.setDuration(600L);
        return ofPropertyValuesHolder;
    }

    private void aoq() {
        this.mRootView.setVisibility(8);
        com.baidu.swan.games.view.c.c(this.mRootView, aor());
    }

    private com.baidu.swan.apps.model.a.a.a aor() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.fh(com.baidu.swan.games.utils.d.T(this.cpH.left) - this.cpF);
        aVar.fi(com.baidu.swan.games.utils.d.T(this.cpH.top) - this.cpF);
        aVar.setWidth(-2);
        aVar.setHeight(-2);
        return aVar;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        this.cpD = aVar;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(InterfaceC0338a interfaceC0338a) {
        this.cpE = interfaceC0338a;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void cG(boolean z) {
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
        com.baidu.swan.games.view.c.aq(this.mRootView);
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void update() {
        com.baidu.swan.games.view.c.b(this.mRootView, aor());
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

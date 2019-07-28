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
    protected com.baidu.swan.games.view.recommend.d.b bmC;
    protected InterfaceC0220a bmD;
    private int bmE;
    private boolean bmF;
    private ObjectAnimator bmG;
    private d bmH;
    protected Context mContext;
    protected Handler mHandler;
    private ViewGroup mRootView;

    /* renamed from: com.baidu.swan.games.view.recommend.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0220a {
        void Uf();

        void Ug();

        void fm(int i);
    }

    public a(@NonNull Context context, @NonNull d dVar) {
        this.mContext = context;
        this.bmH = dVar;
        av(TY());
        Ub();
        Ud();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View TY() {
        return LayoutInflater.from(this.mContext).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void TZ() {
        this.bmG.start();
    }

    protected int Ua() {
        return UIMsg.m_AppUI.MSG_APP_GPS;
    }

    private void av(View view) {
        this.bmE = (int) this.mContext.getResources().getDimension(a.d.swangame_recommend_button_root_padding);
        this.mRootView = new FrameLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.swan.games.utils.b.ad(this.bmH.width), com.baidu.swan.games.utils.b.ad(this.bmH.height));
        layoutParams.setMargins(this.bmE, this.bmE, this.bmE, this.bmE);
        this.mRootView.setBackgroundColor(0);
        this.mRootView.addView(view, layoutParams);
    }

    private void Ub() {
        this.bmG = Uc();
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.swan.games.view.recommend.a.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        int Ua = a.this.Ua();
                        if (Ua > 0 && a.this.bmF) {
                            a.this.mHandler.sendEmptyMessageDelayed(1, Ua);
                        }
                        a.this.TZ();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    private ObjectAnimator Uc() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mRootView, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.2f * 0.0f, 0.0f), Keyframe.ofFloat(1.0f * 0.2f, 6.0f), Keyframe.ofFloat(2.0f * 0.2f, -6.0f), Keyframe.ofFloat(3.0f * 0.2f, 6.0f), Keyframe.ofFloat(4.0f * 0.2f, -6.0f), Keyframe.ofFloat(0.2f * 5.0f, 0.0f)));
        ofPropertyValuesHolder.setDuration(600L);
        return ofPropertyValuesHolder;
    }

    private void Ud() {
        this.mRootView.setVisibility(8);
        com.baidu.swan.games.view.a.c(this.mRootView, Ue());
    }

    private com.baidu.swan.apps.model.a.a.b Ue() {
        com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b();
        bVar.cM(com.baidu.swan.games.utils.b.ad(this.bmH.left) - this.bmE);
        bVar.cN(com.baidu.swan.games.utils.b.ad(this.bmH.top) - this.bmE);
        bVar.setWidth(-2);
        bVar.setHeight(-2);
        return bVar;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(com.baidu.swan.games.view.recommend.d.b bVar) {
        this.bmC = bVar;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(InterfaceC0220a interfaceC0220a) {
        this.bmD = interfaceC0220a;
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void by(boolean z) {
        if (this.bmF) {
            this.mHandler.removeMessages(1);
            if (z) {
                this.mHandler.sendEmptyMessage(1);
            }
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void show() {
        this.bmF = true;
        this.mRootView.setVisibility(0);
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessage(1);
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void hide() {
        this.bmF = false;
        this.mHandler.removeMessages(1);
        this.mRootView.setVisibility(8);
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void destroy() {
        this.bmF = false;
        this.mHandler.removeCallbacksAndMessages(null);
        com.baidu.swan.games.view.a.an(this.mRootView);
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void update() {
        com.baidu.swan.games.view.a.b(this.mRootView, Ue());
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

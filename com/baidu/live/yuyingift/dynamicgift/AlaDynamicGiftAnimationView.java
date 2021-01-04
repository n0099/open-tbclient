package com.baidu.live.yuyingift.dynamicgift;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class AlaDynamicGiftAnimationView extends ImageView {
    private static Handler mHandler = new Handler();
    private com.baidu.live.yuyingift.dynamicgift.a bZR;
    private a bZS;
    private b bZT;
    private long bfe;
    private Runnable bff;

    /* loaded from: classes11.dex */
    interface a {
        void onFrameEnd();

        void onFrameStart();

        void onFrameUpdate(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface b {
        void Jq();

        void Jr();

        void eI(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.bZT = new b() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void Jq() {
                if (AlaDynamicGiftAnimationView.this.bZS != null) {
                    AlaDynamicGiftAnimationView.this.bZS.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void eI(int i) {
                if (AlaDynamicGiftAnimationView.this.bZS != null) {
                    AlaDynamicGiftAnimationView.this.bZS.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void Jr() {
                AlaDynamicGiftAnimationView.this.bZR.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bff != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bff);
                }
                if (AlaDynamicGiftAnimationView.this.bZS != null) {
                    AlaDynamicGiftAnimationView.this.bZS.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bZT = new b() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void Jq() {
                if (AlaDynamicGiftAnimationView.this.bZS != null) {
                    AlaDynamicGiftAnimationView.this.bZS.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void eI(int i) {
                if (AlaDynamicGiftAnimationView.this.bZS != null) {
                    AlaDynamicGiftAnimationView.this.bZS.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void Jr() {
                AlaDynamicGiftAnimationView.this.bZR.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bff != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bff);
                }
                if (AlaDynamicGiftAnimationView.this.bZS != null) {
                    AlaDynamicGiftAnimationView.this.bZS.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bZT = new b() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void Jq() {
                if (AlaDynamicGiftAnimationView.this.bZS != null) {
                    AlaDynamicGiftAnimationView.this.bZS.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void eI(int i2) {
                if (AlaDynamicGiftAnimationView.this.bZS != null) {
                    AlaDynamicGiftAnimationView.this.bZS.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void Jr() {
                AlaDynamicGiftAnimationView.this.bZR.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bff != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bff);
                }
                if (AlaDynamicGiftAnimationView.this.bZS != null) {
                    AlaDynamicGiftAnimationView.this.bZS.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.bff = new c(this);
        this.bZR = new com.baidu.live.yuyingift.dynamicgift.a();
        this.bZR.a(this.bZT);
    }

    public void setScreen(int i, int i2) {
        if (this.bZR != null) {
            this.bZR.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.bZR.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jp() {
        if (this.bff != null) {
            mHandler.postDelayed(this.bff, (long) this.bZR.Jv());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class c implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> bfi;

        public c(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.bfi = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.bfi != null && (alaDynamicGiftAnimationView = this.bfi.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.bZR.Ju()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.bfe > 4000 && alaDynamicGiftAnimationView.bZT != null) {
                            alaDynamicGiftAnimationView.bZT.Jr();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.Jp();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.bZR.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bZR != null) {
            this.bZR.h(canvas);
        }
    }

    public void startAnim() {
        this.bfe = System.currentTimeMillis();
        Jp();
    }

    public void stopAnim() {
        if (mHandler != null && this.bff != null) {
            mHandler.removeCallbacks(this.bff);
        }
        this.bZR.release();
    }

    public void setFrameCallback(a aVar) {
        this.bZS = aVar;
    }
}

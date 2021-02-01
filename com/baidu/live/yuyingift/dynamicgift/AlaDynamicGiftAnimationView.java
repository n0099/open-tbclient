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
    private com.baidu.live.yuyingift.dynamicgift.a bZh;
    private a bZi;
    private b bZj;
    private long bdu;
    private Runnable bdv;

    /* loaded from: classes11.dex */
    interface a {
        void onFrameEnd();

        void onFrameStart();

        void onFrameUpdate(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface b {
        void GL();

        void GM();

        void dh(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.bZj = new b() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void GL() {
                if (AlaDynamicGiftAnimationView.this.bZi != null) {
                    AlaDynamicGiftAnimationView.this.bZi.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void dh(int i) {
                if (AlaDynamicGiftAnimationView.this.bZi != null) {
                    AlaDynamicGiftAnimationView.this.bZi.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void GM() {
                AlaDynamicGiftAnimationView.this.bZh.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bdv != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bdv);
                }
                if (AlaDynamicGiftAnimationView.this.bZi != null) {
                    AlaDynamicGiftAnimationView.this.bZi.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bZj = new b() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void GL() {
                if (AlaDynamicGiftAnimationView.this.bZi != null) {
                    AlaDynamicGiftAnimationView.this.bZi.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void dh(int i) {
                if (AlaDynamicGiftAnimationView.this.bZi != null) {
                    AlaDynamicGiftAnimationView.this.bZi.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void GM() {
                AlaDynamicGiftAnimationView.this.bZh.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bdv != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bdv);
                }
                if (AlaDynamicGiftAnimationView.this.bZi != null) {
                    AlaDynamicGiftAnimationView.this.bZi.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bZj = new b() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void GL() {
                if (AlaDynamicGiftAnimationView.this.bZi != null) {
                    AlaDynamicGiftAnimationView.this.bZi.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void dh(int i2) {
                if (AlaDynamicGiftAnimationView.this.bZi != null) {
                    AlaDynamicGiftAnimationView.this.bZi.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void GM() {
                AlaDynamicGiftAnimationView.this.bZh.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bdv != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bdv);
                }
                if (AlaDynamicGiftAnimationView.this.bZi != null) {
                    AlaDynamicGiftAnimationView.this.bZi.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.bdv = new c(this);
        this.bZh = new com.baidu.live.yuyingift.dynamicgift.a();
        this.bZh.a(this.bZj);
    }

    public void setScreen(int i, int i2) {
        if (this.bZh != null) {
            this.bZh.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.bZh.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GK() {
        if (this.bdv != null) {
            mHandler.postDelayed(this.bdv, (long) this.bZh.GQ());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class c implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> bdy;

        public c(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.bdy = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.bdy != null && (alaDynamicGiftAnimationView = this.bdy.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.bZh.GP()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.bdu > 4000 && alaDynamicGiftAnimationView.bZj != null) {
                            alaDynamicGiftAnimationView.bZj.GM();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.GK();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.bZh.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bZh != null) {
            this.bZh.h(canvas);
        }
    }

    public void startAnim() {
        this.bdu = System.currentTimeMillis();
        GK();
    }

    public void stopAnim() {
        if (mHandler != null && this.bdv != null) {
            mHandler.removeCallbacks(this.bdv);
        }
        this.bZh.release();
    }

    public void setFrameCallback(a aVar) {
        this.bZi = aVar;
    }
}

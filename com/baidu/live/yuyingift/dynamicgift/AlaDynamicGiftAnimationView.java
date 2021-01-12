package com.baidu.live.yuyingift.dynamicgift;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class AlaDynamicGiftAnimationView extends ImageView {
    private static Handler mHandler = new Handler();
    private com.baidu.live.yuyingift.dynamicgift.a bVf;
    private a bVg;
    private b bVh;
    private long ban;
    private Runnable bao;

    /* loaded from: classes10.dex */
    interface a {
        void onFrameEnd();

        void onFrameStart();

        void onFrameUpdate(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public interface b {
        void Fv();

        void Fw();

        void dc(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.bVh = new b() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void Fv() {
                if (AlaDynamicGiftAnimationView.this.bVg != null) {
                    AlaDynamicGiftAnimationView.this.bVg.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void dc(int i) {
                if (AlaDynamicGiftAnimationView.this.bVg != null) {
                    AlaDynamicGiftAnimationView.this.bVg.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void Fw() {
                AlaDynamicGiftAnimationView.this.bVf.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bao != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bao);
                }
                if (AlaDynamicGiftAnimationView.this.bVg != null) {
                    AlaDynamicGiftAnimationView.this.bVg.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bVh = new b() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void Fv() {
                if (AlaDynamicGiftAnimationView.this.bVg != null) {
                    AlaDynamicGiftAnimationView.this.bVg.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void dc(int i) {
                if (AlaDynamicGiftAnimationView.this.bVg != null) {
                    AlaDynamicGiftAnimationView.this.bVg.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void Fw() {
                AlaDynamicGiftAnimationView.this.bVf.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bao != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bao);
                }
                if (AlaDynamicGiftAnimationView.this.bVg != null) {
                    AlaDynamicGiftAnimationView.this.bVg.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bVh = new b() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void Fv() {
                if (AlaDynamicGiftAnimationView.this.bVg != null) {
                    AlaDynamicGiftAnimationView.this.bVg.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void dc(int i2) {
                if (AlaDynamicGiftAnimationView.this.bVg != null) {
                    AlaDynamicGiftAnimationView.this.bVg.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void Fw() {
                AlaDynamicGiftAnimationView.this.bVf.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bao != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bao);
                }
                if (AlaDynamicGiftAnimationView.this.bVg != null) {
                    AlaDynamicGiftAnimationView.this.bVg.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.bao = new c(this);
        this.bVf = new com.baidu.live.yuyingift.dynamicgift.a();
        this.bVf.a(this.bVh);
    }

    public void setScreen(int i, int i2) {
        if (this.bVf != null) {
            this.bVf.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.bVf.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fu() {
        if (this.bao != null) {
            mHandler.postDelayed(this.bao, (long) this.bVf.FA());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class c implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> bas;

        public c(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.bas = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.bas != null && (alaDynamicGiftAnimationView = this.bas.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.bVf.Fz()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.ban > 4000 && alaDynamicGiftAnimationView.bVh != null) {
                            alaDynamicGiftAnimationView.bVh.Fw();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.Fu();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.bVf.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bVf != null) {
            this.bVf.h(canvas);
        }
    }

    public void startAnim() {
        this.ban = System.currentTimeMillis();
        Fu();
    }

    public void stopAnim() {
        if (mHandler != null && this.bao != null) {
            mHandler.removeCallbacks(this.bao);
        }
        this.bVf.release();
    }

    public void setFrameCallback(a aVar) {
        this.bVg = aVar;
    }
}

package com.baidu.live.yuyingift.dynamicgift;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class AlaDynamicGiftAnimationView extends ImageView {
    private static Handler mHandler = new Handler();
    private com.baidu.live.yuyingift.dynamicgift.a bTZ;
    private AlaDynamicGiftLayout.a bUa;
    private a bUb;
    private long bds;
    private Runnable bdt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void JO();

        void JP();

        void eK(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.bUb = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void JO() {
                if (AlaDynamicGiftAnimationView.this.bUa != null) {
                    AlaDynamicGiftAnimationView.this.bUa.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void eK(int i) {
                if (AlaDynamicGiftAnimationView.this.bUa != null) {
                    AlaDynamicGiftAnimationView.this.bUa.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void JP() {
                AlaDynamicGiftAnimationView.this.bTZ.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bdt != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bdt);
                }
                if (AlaDynamicGiftAnimationView.this.bUa != null) {
                    AlaDynamicGiftAnimationView.this.bUa.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bUb = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void JO() {
                if (AlaDynamicGiftAnimationView.this.bUa != null) {
                    AlaDynamicGiftAnimationView.this.bUa.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void eK(int i) {
                if (AlaDynamicGiftAnimationView.this.bUa != null) {
                    AlaDynamicGiftAnimationView.this.bUa.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void JP() {
                AlaDynamicGiftAnimationView.this.bTZ.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bdt != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bdt);
                }
                if (AlaDynamicGiftAnimationView.this.bUa != null) {
                    AlaDynamicGiftAnimationView.this.bUa.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bUb = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void JO() {
                if (AlaDynamicGiftAnimationView.this.bUa != null) {
                    AlaDynamicGiftAnimationView.this.bUa.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void eK(int i2) {
                if (AlaDynamicGiftAnimationView.this.bUa != null) {
                    AlaDynamicGiftAnimationView.this.bUa.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void JP() {
                AlaDynamicGiftAnimationView.this.bTZ.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bdt != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bdt);
                }
                if (AlaDynamicGiftAnimationView.this.bUa != null) {
                    AlaDynamicGiftAnimationView.this.bUa.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.bdt = new b(this);
        this.bTZ = new com.baidu.live.yuyingift.dynamicgift.a();
        this.bTZ.a(this.bUb);
    }

    public void setScreen(int i, int i2) {
        if (this.bTZ != null) {
            this.bTZ.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.bTZ.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JN() {
        if (this.bdt != null) {
            mHandler.postDelayed(this.bdt, (long) this.bTZ.JT());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> bdw;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.bdw = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.bdw != null && (alaDynamicGiftAnimationView = this.bdw.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.bTZ.JS()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.bds > 4000 && alaDynamicGiftAnimationView.bUb != null) {
                            alaDynamicGiftAnimationView.bUb.JP();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.JN();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.bTZ.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bTZ != null) {
            this.bTZ.g(canvas);
        }
    }

    public void startAnim() {
        this.bds = System.currentTimeMillis();
        JN();
    }

    public void stopAnim() {
        if (mHandler != null && this.bdt != null) {
            mHandler.removeCallbacks(this.bdt);
        }
        this.bTZ.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.bUa = aVar;
    }
}

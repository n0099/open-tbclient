package com.baidu.live.gift.dynamicGift;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class AlaDynamicGiftAnimationView extends ImageView {
    private static Handler mHandler = new Handler();
    private com.baidu.live.gift.dynamicGift.a bds;
    private AlaDynamicGiftLayout.a bdt;
    private long bdu;
    private Runnable bdv;
    private a bdw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface a {
        void GL();

        void GM();

        void dh(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.bdw = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void GL() {
                if (AlaDynamicGiftAnimationView.this.bdt != null) {
                    AlaDynamicGiftAnimationView.this.bdt.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void dh(int i) {
                if (AlaDynamicGiftAnimationView.this.bdt != null) {
                    AlaDynamicGiftAnimationView.this.bdt.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void GM() {
                AlaDynamicGiftAnimationView.this.bds.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bdv != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bdv);
                }
                if (AlaDynamicGiftAnimationView.this.bdt != null) {
                    AlaDynamicGiftAnimationView.this.bdt.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdw = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void GL() {
                if (AlaDynamicGiftAnimationView.this.bdt != null) {
                    AlaDynamicGiftAnimationView.this.bdt.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void dh(int i) {
                if (AlaDynamicGiftAnimationView.this.bdt != null) {
                    AlaDynamicGiftAnimationView.this.bdt.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void GM() {
                AlaDynamicGiftAnimationView.this.bds.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bdv != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bdv);
                }
                if (AlaDynamicGiftAnimationView.this.bdt != null) {
                    AlaDynamicGiftAnimationView.this.bdt.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdw = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void GL() {
                if (AlaDynamicGiftAnimationView.this.bdt != null) {
                    AlaDynamicGiftAnimationView.this.bdt.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void dh(int i2) {
                if (AlaDynamicGiftAnimationView.this.bdt != null) {
                    AlaDynamicGiftAnimationView.this.bdt.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void GM() {
                AlaDynamicGiftAnimationView.this.bds.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bdv != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bdv);
                }
                if (AlaDynamicGiftAnimationView.this.bdt != null) {
                    AlaDynamicGiftAnimationView.this.bdt.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.bdv = new b(this);
        this.bds = new com.baidu.live.gift.dynamicGift.a();
        this.bds.a(this.bdw);
    }

    public void setScreen(int i, int i2) {
        if (this.bds != null) {
            this.bds.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.bds.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GK() {
        if (this.bdv != null) {
            mHandler.postDelayed(this.bdv, (long) this.bds.GQ());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> bdy;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.bdy = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.bdy != null && (alaDynamicGiftAnimationView = this.bdy.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.bds.GP()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.bdu > 4000 && alaDynamicGiftAnimationView.bdw != null) {
                            alaDynamicGiftAnimationView.bdw.GM();
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
        this.bds.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bds != null) {
            this.bds.h(canvas);
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
        this.bds.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.bdt = aVar;
    }
}

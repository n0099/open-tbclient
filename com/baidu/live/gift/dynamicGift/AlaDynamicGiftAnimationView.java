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
    private com.baidu.live.gift.dynamicGift.a bfc;
    private AlaDynamicGiftLayout.a bfd;
    private long bfe;
    private Runnable bff;
    private a bfg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface a {
        void Jq();

        void Jr();

        void eI(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.bfg = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Jq() {
                if (AlaDynamicGiftAnimationView.this.bfd != null) {
                    AlaDynamicGiftAnimationView.this.bfd.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void eI(int i) {
                if (AlaDynamicGiftAnimationView.this.bfd != null) {
                    AlaDynamicGiftAnimationView.this.bfd.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Jr() {
                AlaDynamicGiftAnimationView.this.bfc.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bff != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bff);
                }
                if (AlaDynamicGiftAnimationView.this.bfd != null) {
                    AlaDynamicGiftAnimationView.this.bfd.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bfg = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Jq() {
                if (AlaDynamicGiftAnimationView.this.bfd != null) {
                    AlaDynamicGiftAnimationView.this.bfd.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void eI(int i) {
                if (AlaDynamicGiftAnimationView.this.bfd != null) {
                    AlaDynamicGiftAnimationView.this.bfd.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Jr() {
                AlaDynamicGiftAnimationView.this.bfc.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bff != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bff);
                }
                if (AlaDynamicGiftAnimationView.this.bfd != null) {
                    AlaDynamicGiftAnimationView.this.bfd.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bfg = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Jq() {
                if (AlaDynamicGiftAnimationView.this.bfd != null) {
                    AlaDynamicGiftAnimationView.this.bfd.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void eI(int i2) {
                if (AlaDynamicGiftAnimationView.this.bfd != null) {
                    AlaDynamicGiftAnimationView.this.bfd.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Jr() {
                AlaDynamicGiftAnimationView.this.bfc.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bff != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bff);
                }
                if (AlaDynamicGiftAnimationView.this.bfd != null) {
                    AlaDynamicGiftAnimationView.this.bfd.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.bff = new b(this);
        this.bfc = new com.baidu.live.gift.dynamicGift.a();
        this.bfc.a(this.bfg);
    }

    public void setScreen(int i, int i2) {
        if (this.bfc != null) {
            this.bfc.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.bfc.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jp() {
        if (this.bff != null) {
            mHandler.postDelayed(this.bff, (long) this.bfc.Jv());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> bfi;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.bfi = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.bfi != null && (alaDynamicGiftAnimationView = this.bfi.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.bfc.Ju()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.bfe > 4000 && alaDynamicGiftAnimationView.bfg != null) {
                            alaDynamicGiftAnimationView.bfg.Jr();
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
        this.bfc.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bfc != null) {
            this.bfc.h(canvas);
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
        this.bfc.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.bfd = aVar;
    }
}

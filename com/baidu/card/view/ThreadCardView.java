package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.t;
import com.baidu.tieba.card.CardLinkageManager;
/* loaded from: classes8.dex */
public class ThreadCardView extends FrameLayout {
    private t aib;
    private boolean aic;
    private Runnable aie;
    private Runnable aif;
    private int mPosition;
    private ViewGroup mViewGroup;

    public ThreadCardView(Context context) {
        super(context);
        this.aie = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.aic) {
                    if (ThreadCardView.this.aib != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.aib, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof t) {
                        CardLinkageManager.INSTANCE.pressLinkage((t) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.aic) {
                        CardLinkageManager.INSTANCE.pressLinkage((t) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.aif = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.aib != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.aib, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof t) {
                    CardLinkageManager.INSTANCE.pressLinkage((t) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aie = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.aic) {
                    if (ThreadCardView.this.aib != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.aib, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof t) {
                        CardLinkageManager.INSTANCE.pressLinkage((t) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.aic) {
                        CardLinkageManager.INSTANCE.pressLinkage((t) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.aif = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.aib != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.aib, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof t) {
                    CardLinkageManager.INSTANCE.pressLinkage((t) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aie = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.aic) {
                    if (ThreadCardView.this.aib != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.aib, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof t) {
                        CardLinkageManager.INSTANCE.pressLinkage((t) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.aic) {
                        CardLinkageManager.INSTANCE.pressLinkage((t) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.aif = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.aib != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.aib, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof t) {
                    CardLinkageManager.INSTANCE.pressLinkage((t) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public void setITypeListView(t tVar) {
        this.aib = tVar;
    }

    public void setParent(ViewGroup viewGroup) {
        this.mViewGroup = viewGroup;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aic = false;
                postDelayed(this.aie, ViewConfiguration.getTapTimeout());
                break;
            case 1:
                this.aic = true;
                removeCallbacks(this.aie);
                CardLinkageManager.INSTANCE.pressLinkage(this.aib, this.mPosition, true);
                postDelayed(this.aif, ViewConfiguration.getTapTimeout());
                break;
            case 3:
                this.aic = true;
                removeCallbacks(this.aie);
                removeCallbacks(this.aif);
                if (this.aib != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(this.aib, this.mPosition, false);
                    break;
                } else if (this.mViewGroup instanceof t) {
                    CardLinkageManager.INSTANCE.pressLinkage((t) this.mViewGroup, this.mPosition, false);
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.aie);
        removeCallbacks(this.aif);
        super.onDetachedFromWindow();
    }
}

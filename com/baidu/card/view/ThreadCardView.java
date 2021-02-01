package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tieba.card.CardLinkageManager;
/* loaded from: classes.dex */
public class ThreadCardView extends FrameLayout {
    private s amk;
    private boolean aml;
    private Runnable amm;
    private Runnable amn;
    private int mPosition;
    private ViewGroup mViewGroup;

    public ThreadCardView(Context context) {
        super(context);
        this.amm = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.aml) {
                    if (ThreadCardView.this.amk != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.amk, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof s) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.aml) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.amn = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.amk != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.amk, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof s) {
                    CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amm = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.aml) {
                    if (ThreadCardView.this.amk != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.amk, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof s) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.aml) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.amn = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.amk != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.amk, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof s) {
                    CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amm = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.aml) {
                    if (ThreadCardView.this.amk != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.amk, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof s) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.aml) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.amn = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.amk != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.amk, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof s) {
                    CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public void setITypeListView(s sVar) {
        this.amk = sVar;
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
                this.aml = false;
                postDelayed(this.amm, ViewConfiguration.getTapTimeout());
                break;
            case 1:
                this.aml = true;
                removeCallbacks(this.amm);
                CardLinkageManager.INSTANCE.pressLinkage(this.amk, this.mPosition, true);
                postDelayed(this.amn, ViewConfiguration.getTapTimeout());
                break;
            case 3:
                this.aml = true;
                removeCallbacks(this.amm);
                removeCallbacks(this.amn);
                if (this.amk != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(this.amk, this.mPosition, false);
                    break;
                } else if (this.mViewGroup instanceof s) {
                    CardLinkageManager.INSTANCE.pressLinkage((s) this.mViewGroup, this.mPosition, false);
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.amm);
        removeCallbacks(this.amn);
        super.onDetachedFromWindow();
    }
}

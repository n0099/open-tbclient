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
    private s amu;
    private boolean amv;
    private Runnable amw;
    private Runnable amx;
    private int mPosition;
    private ViewGroup mViewGroup;

    public ThreadCardView(Context context) {
        super(context);
        this.amw = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.amv) {
                    if (ThreadCardView.this.amu != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.amu, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof s) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.amv) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.amx = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.amu != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.amu, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof s) {
                    CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amw = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.amv) {
                    if (ThreadCardView.this.amu != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.amu, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof s) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.amv) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.amx = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.amu != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.amu, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof s) {
                    CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amw = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.amv) {
                    if (ThreadCardView.this.amu != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.amu, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof s) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.amv) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.amx = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.amu != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.amu, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof s) {
                    CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public void setITypeListView(s sVar) {
        this.amu = sVar;
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
                this.amv = false;
                postDelayed(this.amw, ViewConfiguration.getTapTimeout());
                break;
            case 1:
                this.amv = true;
                removeCallbacks(this.amw);
                CardLinkageManager.INSTANCE.pressLinkage(this.amu, this.mPosition, true);
                postDelayed(this.amx, ViewConfiguration.getTapTimeout());
                break;
            case 3:
                this.amv = true;
                removeCallbacks(this.amw);
                removeCallbacks(this.amx);
                if (this.amu != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(this.amu, this.mPosition, false);
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
        removeCallbacks(this.amw);
        removeCallbacks(this.amx);
        super.onDetachedFromWindow();
    }
}

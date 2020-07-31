package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.card.CardLinkageManager;
/* loaded from: classes15.dex */
public class ThreadCardView extends FrameLayout {
    private v ajt;
    private boolean aju;
    private Runnable ajv;
    private Runnable ajw;
    private int mPosition;
    private ViewGroup mViewGroup;

    public ThreadCardView(Context context) {
        super(context);
        this.ajv = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.aju) {
                    if (ThreadCardView.this.ajt != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.ajt, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof v) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.aju) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.ajw = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.ajt != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.ajt, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof v) {
                    CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajv = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.aju) {
                    if (ThreadCardView.this.ajt != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.ajt, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof v) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.aju) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.ajw = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.ajt != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.ajt, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof v) {
                    CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajv = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.aju) {
                    if (ThreadCardView.this.ajt != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.ajt, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof v) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.aju) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.ajw = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.ajt != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.ajt, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof v) {
                    CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public void setITypeListView(v vVar) {
        this.ajt = vVar;
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
                this.aju = false;
                postDelayed(this.ajv, ViewConfiguration.getTapTimeout());
                break;
            case 1:
                this.aju = true;
                removeCallbacks(this.ajv);
                CardLinkageManager.INSTANCE.pressLinkage(this.ajt, this.mPosition, true);
                postDelayed(this.ajw, ViewConfiguration.getTapTimeout());
                break;
            case 3:
                this.aju = true;
                removeCallbacks(this.ajv);
                removeCallbacks(this.ajw);
                if (this.ajt != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(this.ajt, this.mPosition, false);
                    break;
                } else if (this.mViewGroup instanceof v) {
                    CardLinkageManager.INSTANCE.pressLinkage((v) this.mViewGroup, this.mPosition, false);
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.ajv);
        removeCallbacks(this.ajw);
        super.onDetachedFromWindow();
    }
}

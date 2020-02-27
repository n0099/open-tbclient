package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.card.CardLinkageManager;
/* loaded from: classes8.dex */
public class ThreadCardView extends FrameLayout {
    private r OR;
    private boolean OT;
    private Runnable OU;
    private Runnable OV;
    private int mPosition;
    private ViewGroup mViewGroup;

    public ThreadCardView(Context context) {
        super(context);
        this.OU = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.OT) {
                    if (ThreadCardView.this.OR != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.OR, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof r) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.OT) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.OV = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.OR != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.OR, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof r) {
                    CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OU = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.OT) {
                    if (ThreadCardView.this.OR != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.OR, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof r) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.OT) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.OV = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.OR != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.OR, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof r) {
                    CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.OU = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.OT) {
                    if (ThreadCardView.this.OR != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.OR, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof r) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.OT) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.OV = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.OR != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.OR, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof r) {
                    CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public void setITypeListView(r rVar) {
        this.OR = rVar;
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
                this.OT = false;
                postDelayed(this.OU, ViewConfiguration.getTapTimeout());
                break;
            case 1:
                this.OT = true;
                removeCallbacks(this.OU);
                CardLinkageManager.INSTANCE.pressLinkage(this.OR, this.mPosition, true);
                postDelayed(this.OV, ViewConfiguration.getTapTimeout());
                break;
            case 3:
                this.OT = true;
                removeCallbacks(this.OU);
                removeCallbacks(this.OV);
                if (this.OR != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(this.OR, this.mPosition, false);
                    break;
                } else if (this.mViewGroup instanceof r) {
                    CardLinkageManager.INSTANCE.pressLinkage((r) this.mViewGroup, this.mPosition, false);
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.OU);
        removeCallbacks(this.OV);
        super.onDetachedFromWindow();
    }
}

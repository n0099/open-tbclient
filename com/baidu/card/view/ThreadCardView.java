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
    private v akI;
    private boolean akJ;
    private Runnable akK;
    private Runnable akL;
    private int mPosition;
    private ViewGroup mViewGroup;

    public ThreadCardView(Context context) {
        super(context);
        this.akK = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.akJ) {
                    if (ThreadCardView.this.akI != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.akI, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof v) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.akJ) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.akL = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.akI != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.akI, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof v) {
                    CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akK = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.akJ) {
                    if (ThreadCardView.this.akI != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.akI, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof v) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.akJ) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.akL = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.akI != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.akI, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof v) {
                    CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akK = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.akJ) {
                    if (ThreadCardView.this.akI != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.akI, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof v) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.akJ) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.akL = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.akI != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.akI, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof v) {
                    CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public void setITypeListView(v vVar) {
        this.akI = vVar;
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
                this.akJ = false;
                postDelayed(this.akK, ViewConfiguration.getTapTimeout());
                break;
            case 1:
                this.akJ = true;
                removeCallbacks(this.akK);
                CardLinkageManager.INSTANCE.pressLinkage(this.akI, this.mPosition, true);
                postDelayed(this.akL, ViewConfiguration.getTapTimeout());
                break;
            case 3:
                this.akJ = true;
                removeCallbacks(this.akK);
                removeCallbacks(this.akL);
                if (this.akI != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(this.akI, this.mPosition, false);
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
        removeCallbacks(this.akK);
        removeCallbacks(this.akL);
        super.onDetachedFromWindow();
    }
}

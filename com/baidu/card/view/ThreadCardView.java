package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.card.CardLinkageManager;
/* loaded from: classes20.dex */
public class ThreadCardView extends FrameLayout {
    private v alj;
    private boolean alk;
    private Runnable alm;
    private Runnable aln;
    private int mPosition;
    private ViewGroup mViewGroup;

    public ThreadCardView(Context context) {
        super(context);
        this.alm = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.alk) {
                    if (ThreadCardView.this.alj != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.alj, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof v) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.alk) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.aln = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.alj != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.alj, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof v) {
                    CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alm = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.alk) {
                    if (ThreadCardView.this.alj != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.alj, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof v) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.alk) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.aln = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.alj != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.alj, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof v) {
                    CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alm = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.alk) {
                    if (ThreadCardView.this.alj != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.alj, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof v) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.alk) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.aln = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.alj != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.alj, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof v) {
                    CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public void setITypeListView(v vVar) {
        this.alj = vVar;
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
                this.alk = false;
                postDelayed(this.alm, ViewConfiguration.getTapTimeout());
                break;
            case 1:
                this.alk = true;
                removeCallbacks(this.alm);
                CardLinkageManager.INSTANCE.pressLinkage(this.alj, this.mPosition, true);
                postDelayed(this.aln, ViewConfiguration.getTapTimeout());
                break;
            case 3:
                this.alk = true;
                removeCallbacks(this.alm);
                removeCallbacks(this.aln);
                if (this.alj != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(this.alj, this.mPosition, false);
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
        removeCallbacks(this.alm);
        removeCallbacks(this.aln);
        super.onDetachedFromWindow();
    }
}

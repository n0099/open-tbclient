package com.baidu.live.bottompanel;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.liveroom.d.d;
import com.baidu.live.liveroom.d.e;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaAudienceLiveRoomBottomPanelView extends LinearLayout {
    private final List<d> Wh;
    private final List<e> Wi;
    private e Wj;
    private AlaLiveRoomPanelTabHost Wk;
    private com.baidu.live.bottompanel.a Wl;
    private boolean Wm;
    private a Wn;
    private float mDownX;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes3.dex */
    public interface a {
        void pL();
    }

    public AlaAudienceLiveRoomBottomPanelView(Context context) {
        super(context);
        this.Wh = new LinkedList();
        this.Wi = new LinkedList();
        this.mDownX = 0.0f;
        this.Wm = false;
        this.Wn = new a() { // from class: com.baidu.live.bottompanel.AlaAudienceLiveRoomBottomPanelView.1
            @Override // com.baidu.live.bottompanel.AlaAudienceLiveRoomBottomPanelView.a
            public void pL() {
                AlaAudienceLiveRoomBottomPanelView.this.pK();
            }
        };
        init();
    }

    private void init() {
        setOrientation(0);
        this.mScroller = new Scroller(getContext());
        this.mTouchSlop = BdUtilHelper.getScreenDimensions(getContext())[0] / 4;
        this.Wk = new AlaLiveRoomPanelTabHost(getContext());
        this.Wk.setOnPageChangeListener(new AlaLiveRoomPanelTabHost.a() { // from class: com.baidu.live.bottompanel.AlaAudienceLiveRoomBottomPanelView.2
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.a
            public void a(int i, d dVar) {
                if (dVar != null && dVar.wl() != 1) {
                    BdUtilHelper.hideSoftKeyPad(AlaAudienceLiveRoomBottomPanelView.this.getContext(), AlaAudienceLiveRoomBottomPanelView.this);
                }
            }
        });
        addView(this.Wk);
        this.Wl = new com.baidu.live.bottompanel.a(getContext(), this.Wn);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setTabCtlList(List<d> list) {
        this.Wh.clear();
        if (!ListUtils.isEmpty(list)) {
            this.Wh.addAll(list);
        }
        Collections.sort(this.Wh, new Comparator<d>() { // from class: com.baidu.live.bottompanel.AlaAudienceLiveRoomBottomPanelView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(d dVar, d dVar2) {
                return dVar.wl() - dVar2.wl();
            }
        });
        this.Wk.setData(this.Wh, true);
    }

    public void setPageCtlList(List<e> list) {
        this.Wi.clear();
        if (!ListUtils.isEmpty(list)) {
            this.Wi.addAll(list);
        }
    }

    public boolean pK() {
        if (this.Wj != null) {
            View rootView = this.Wl.getRootView();
            this.mScroller.startScroll(rootView.getMeasuredWidth(), 0, -rootView.getMeasuredWidth(), 0);
            this.Wj.enterBackground();
            removeView(rootView);
            this.Wl.reset();
            this.Wj = null;
            this.Wm = false;
            return true;
        }
        return false;
    }

    public void setPageSelectedListener(AlaLiveRoomPanelTabHost.b bVar) {
        this.Wk.setPageSelectedListener(bVar);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller != null && !this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Wm) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mDownX = (int) motionEvent.getX();
                    return false;
                case 1:
                    this.mDownX = 0.0f;
                    return false;
                case 2:
                    return ((float) ((int) motionEvent.getX())) - this.mDownX >= ((float) this.mTouchSlop);
                default:
                    return false;
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Wm) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                default:
                    return true;
                case 1:
                    this.mDownX = 0.0f;
                    return false;
                case 2:
                    if (((int) motionEvent.getX()) - this.mDownX < this.mTouchSlop || this.Wj == null) {
                        return true;
                    }
                    pK();
                    return true;
            }
        }
        return true;
    }
}

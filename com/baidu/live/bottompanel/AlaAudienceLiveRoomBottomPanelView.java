package com.baidu.live.bottompanel;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.liveroom.c.d;
import com.baidu.live.liveroom.c.e;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaAudienceLiveRoomBottomPanelView extends LinearLayout {
    private final List<d> Un;
    private final List<e> Uo;
    private e Up;
    private AlaLiveRoomPanelTabHost Uq;
    private com.baidu.live.bottompanel.a Ur;
    private boolean Us;
    private a Ut;
    private float mDownX;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes2.dex */
    public interface a {
        void oV();
    }

    public AlaAudienceLiveRoomBottomPanelView(Context context) {
        super(context);
        this.Un = new LinkedList();
        this.Uo = new LinkedList();
        this.mDownX = 0.0f;
        this.Us = false;
        this.Ut = new a() { // from class: com.baidu.live.bottompanel.AlaAudienceLiveRoomBottomPanelView.1
            @Override // com.baidu.live.bottompanel.AlaAudienceLiveRoomBottomPanelView.a
            public void oV() {
                AlaAudienceLiveRoomBottomPanelView.this.oU();
            }
        };
        init();
    }

    private void init() {
        setOrientation(0);
        this.mScroller = new Scroller(getContext());
        this.mTouchSlop = BdUtilHelper.getScreenDimensions(getContext())[0] / 4;
        this.Uq = new AlaLiveRoomPanelTabHost(getContext());
        this.Uq.setOnPageChangeListener(new AlaLiveRoomPanelTabHost.a() { // from class: com.baidu.live.bottompanel.AlaAudienceLiveRoomBottomPanelView.2
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.a
            public void a(int i, d dVar) {
                if (dVar != null && dVar.uC() != 1) {
                    BdUtilHelper.hideSoftKeyPad(AlaAudienceLiveRoomBottomPanelView.this.getContext(), AlaAudienceLiveRoomBottomPanelView.this);
                }
            }
        });
        addView(this.Uq);
        this.Ur = new com.baidu.live.bottompanel.a(getContext(), this.Ut);
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
        this.Un.clear();
        if (!ListUtils.isEmpty(list)) {
            this.Un.addAll(list);
        }
        Collections.sort(this.Un, new Comparator<d>() { // from class: com.baidu.live.bottompanel.AlaAudienceLiveRoomBottomPanelView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(d dVar, d dVar2) {
                return dVar.uC() - dVar2.uC();
            }
        });
        this.Uq.setData(this.Un, true);
    }

    public void setPageCtlList(List<e> list) {
        this.Uo.clear();
        if (!ListUtils.isEmpty(list)) {
            this.Uo.addAll(list);
        }
    }

    public boolean oU() {
        if (this.Up != null) {
            View rootView = this.Ur.getRootView();
            this.mScroller.startScroll(rootView.getMeasuredWidth(), 0, -rootView.getMeasuredWidth(), 0);
            this.Up.enterBackground();
            removeView(rootView);
            this.Ur.reset();
            this.Up = null;
            this.Us = false;
            return true;
        }
        return false;
    }

    public void setPageSelectedListener(AlaLiveRoomPanelTabHost.b bVar) {
        this.Uq.setPageSelectedListener(bVar);
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
        if (this.Us) {
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
        if (this.Us) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                default:
                    return true;
                case 1:
                    this.mDownX = 0.0f;
                    return false;
                case 2:
                    if (((int) motionEvent.getX()) - this.mDownX < this.mTouchSlop || this.Up == null) {
                        return true;
                    }
                    oU();
                    return true;
            }
        }
        return true;
    }
}

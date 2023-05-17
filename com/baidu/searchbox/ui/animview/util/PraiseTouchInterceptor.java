package com.baidu.searchbox.ui.animview.util;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.ui.CoolPraiseView;
/* loaded from: classes4.dex */
public class PraiseTouchInterceptor {
    public static final boolean DEBUG = DebugUtil.isApkInDebug();
    public static final String TAG = "PraiseTouchInterceptor";
    public View mHostView;
    public boolean mIntercepted;
    public boolean mNeedToRestoreClickable;
    public boolean mOriginClickable;
    public Object mPraiseAnimeObj = new Object();
    public int mPraiseAnimState = -1;
    public int mLastPraiseAnimState = -1;

    private void registerPraiseStateEvent() {
        if (this.mHostView == null) {
            return;
        }
        BdEventBus.Companion.getDefault().register(this.mPraiseAnimeObj, CoolPraiseView.PraiseAnimState.class, 1, new Action<CoolPraiseView.PraiseAnimState>() { // from class: com.baidu.searchbox.ui.animview.util.PraiseTouchInterceptor.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.bdeventbus.Action
            public void call(CoolPraiseView.PraiseAnimState praiseAnimState) {
                PraiseTouchInterceptor praiseTouchInterceptor = PraiseTouchInterceptor.this;
                praiseTouchInterceptor.mLastPraiseAnimState = praiseTouchInterceptor.mPraiseAnimState;
                PraiseTouchInterceptor.this.mPraiseAnimState = praiseAnimState.getAnimState();
                if (PraiseTouchInterceptor.DEBUG) {
                    Log.d(PraiseTouchInterceptor.TAG, PraiseTouchInterceptor.this.mHostView.getClass().getSimpleName() + ": mLastPraiseAnimState=" + PraiseTouchInterceptor.this.mLastPraiseAnimState + ", mPraiseAnimState=" + PraiseTouchInterceptor.this.mPraiseAnimState);
                }
            }
        });
    }

    private void unregisterPraiseStateEvent() {
        if (this.mHostView == null) {
            return;
        }
        BdEventBus.Companion.getDefault().unregister(this.mPraiseAnimeObj);
    }

    public void detachView() {
        View view2 = this.mHostView;
        if (view2 != null) {
            view2.setOnTouchListener(null);
        }
        unregisterPraiseStateEvent();
        this.mNeedToRestoreClickable = false;
        this.mIntercepted = false;
        this.mHostView = null;
        this.mPraiseAnimState = -1;
        this.mLastPraiseAnimState = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleTouchEvent(MotionEvent motionEvent) {
        return performIntercept(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleTouchEventForListView(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            if (this.mNeedToRestoreClickable) {
                this.mHostView.setClickable(this.mOriginClickable);
                this.mNeedToRestoreClickable = false;
            }
            this.mIntercepted = false;
        }
        return this.mIntercepted;
    }

    public void attachView(View view2) {
        detachView();
        this.mHostView = view2;
        registerPraiseStateEvent();
        View view3 = this.mHostView;
        if (view3 != null) {
            view3.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.searchbox.ui.animview.util.PraiseTouchInterceptor.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view4, MotionEvent motionEvent) {
                    if (PraiseTouchInterceptor.this.mHostView instanceof ListView) {
                        return PraiseTouchInterceptor.this.handleTouchEventForListView(motionEvent);
                    }
                    return PraiseTouchInterceptor.this.mHostView instanceof RecyclerView ? PraiseTouchInterceptor.this.handleTouchEvent(motionEvent) : PraiseTouchInterceptor.this.handleTouchEvent(motionEvent);
                }
            });
        }
    }

    public boolean handleInterceptTouchForListView(MotionEvent motionEvent) {
        return performIntercept(motionEvent);
    }

    private boolean performIntercept(MotionEvent motionEvent) {
        if (this.mHostView == null) {
            return false;
        }
        if (DEBUG && DeviceUtils.OSInfo.hasKitKat()) {
            Log.d(TAG, this.mHostView.getClass().getSimpleName() + ": onTouchEvent " + MotionEvent.actionToString(motionEvent.getAction()));
        }
        if (this.mPraiseAnimState != 1) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            View view2 = this.mHostView;
            if (view2 instanceof ViewGroup) {
                ((ViewGroup) view2).requestDisallowInterceptTouchEvent(true);
            }
            View view3 = this.mHostView;
            if (view3 instanceof ListView) {
                this.mOriginClickable = view3.isClickable();
                this.mNeedToRestoreClickable = true;
                this.mHostView.setClickable(false);
            }
        }
        this.mIntercepted = true;
        if (DEBUG && DeviceUtils.OSInfo.hasKitKat()) {
            Log.d(TAG, this.mHostView.getClass().getSimpleName() + ": disable 1, onTouchEvent " + MotionEvent.actionToString(motionEvent.getAction()));
        }
        return true;
    }
}

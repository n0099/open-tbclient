package com.baidu.searchbox.ui.animview.util;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.searchbox.ui.CoolPraiseView;
import rx.functions.b;
/* loaded from: classes12.dex */
public class PraiseTouchInterceptor {
    private static final boolean DEBUG = DebugUtil.isApkInDebug();
    private static final String TAG = "PraiseTouchInterceptor";
    private View mHostView;
    private boolean mIntercepted;
    private boolean mNeedToRestoreClickable;
    private boolean mOriginClickable;
    private Object mPraiseAnimeObj = new Object();
    private int mPraiseAnimState = -1;
    private int mLastPraiseAnimState = -1;

    public void attachView(View view) {
        detachView();
        this.mHostView = view;
        registerPraiseStateEvent();
        if (this.mHostView != null) {
            this.mHostView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.searchbox.ui.animview.util.PraiseTouchInterceptor.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (PraiseTouchInterceptor.this.mHostView instanceof ListView) {
                        return PraiseTouchInterceptor.this.handleTouchEventForListView(motionEvent);
                    }
                    return PraiseTouchInterceptor.this.mHostView instanceof RecyclerView ? PraiseTouchInterceptor.this.handleTouchEvent(motionEvent) : PraiseTouchInterceptor.this.handleTouchEvent(motionEvent);
                }
            });
        }
    }

    public void detachView() {
        if (this.mHostView != null) {
            this.mHostView.setOnTouchListener(null);
        }
        unregisterPraiseStateEvent();
        this.mNeedToRestoreClickable = false;
        this.mIntercepted = false;
        this.mHostView = null;
        this.mPraiseAnimState = -1;
        this.mLastPraiseAnimState = -1;
    }

    private void registerPraiseStateEvent() {
        if (this.mHostView != null) {
            EventBusWrapper.registerOnMainThread(this.mPraiseAnimeObj, CoolPraiseView.PraiseAnimState.class, new b<CoolPraiseView.PraiseAnimState>() { // from class: com.baidu.searchbox.ui.animview.util.PraiseTouchInterceptor.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(CoolPraiseView.PraiseAnimState praiseAnimState) {
                    PraiseTouchInterceptor.this.mLastPraiseAnimState = PraiseTouchInterceptor.this.mPraiseAnimState;
                    PraiseTouchInterceptor.this.mPraiseAnimState = praiseAnimState.getAnimState();
                    if (PraiseTouchInterceptor.DEBUG) {
                        Log.d(PraiseTouchInterceptor.TAG, PraiseTouchInterceptor.this.mHostView.getClass().getSimpleName() + ": mLastPraiseAnimState=" + PraiseTouchInterceptor.this.mLastPraiseAnimState + ", mPraiseAnimState=" + PraiseTouchInterceptor.this.mPraiseAnimState);
                    }
                }
            });
        }
    }

    private void unregisterPraiseStateEvent() {
        if (this.mHostView != null) {
            EventBusWrapper.unregister(this.mPraiseAnimeObj);
        }
    }

    @SuppressLint({"NewApi"})
    private boolean performIntercept(MotionEvent motionEvent) {
        if (this.mHostView == null) {
            return false;
        }
        if (DEBUG) {
            Log.d(TAG, this.mHostView.getClass().getSimpleName() + ": onTouchEvent " + MotionEvent.actionToString(motionEvent.getAction()));
        }
        if (this.mPraiseAnimState == 1) {
            if (motionEvent.getAction() == 0) {
                if (this.mHostView instanceof ViewGroup) {
                    ((ViewGroup) this.mHostView).requestDisallowInterceptTouchEvent(true);
                }
                if (this.mHostView instanceof ListView) {
                    this.mOriginClickable = this.mHostView.isClickable();
                    this.mNeedToRestoreClickable = true;
                    this.mHostView.setClickable(false);
                }
            }
            this.mIntercepted = true;
            if (DEBUG) {
                Log.d(TAG, this.mHostView.getClass().getSimpleName() + ": disable 1, onTouchEvent " + MotionEvent.actionToString(motionEvent.getAction()));
            }
            return true;
        }
        return false;
    }

    public boolean handleInterceptTouchForListView(MotionEvent motionEvent) {
        return performIntercept(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleTouchEventForListView(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (this.mNeedToRestoreClickable) {
                    this.mHostView.setClickable(this.mOriginClickable);
                    this.mNeedToRestoreClickable = false;
                }
                this.mIntercepted = false;
                break;
        }
        return this.mIntercepted;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleTouchEvent(MotionEvent motionEvent) {
        return performIntercept(motionEvent);
    }
}

package com.baidu.searchbox.ng.ai.apps.view.container.touch;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.turbo.AiAppsCoreRuntime;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsWebMessage;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.swancore.AiAppsSwanCoreManager;
import com.baidu.searchbox.ng.ai.apps.swancore.model.SwanCoreVersion;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewType;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.searchbox.ng.ai.apps.view.container.util.AiAppsEventHelper;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes2.dex */
public class AiAppsTouchListener implements View.OnTouchListener {
    private static final boolean DEBUG = false;
    private static final int LONG_PRESS_INTERVAL = 350;
    public static final String SWAN_CORE_SPLIT = "1.12.0";
    private static final String TAG = "AiAppsTouchListener";
    private static final int TAP_PRESS_MOVE_DISTANCE = 10;
    private TouchPosition mDownPosition;
    private long mDownTime;
    private String mSlaveId;
    private String mViewId;
    private String mViewType;
    private boolean isSendToMaster = false;
    private int[] mWebViewLocation = new int[2];
    private LongPressRunnable mLongPressRunnable = new LongPressRunnable();

    public AiAppsTouchListener(String str, String str2, String str3) {
        this.mSlaveId = str;
        this.mViewId = str2;
        this.mViewType = str3;
        setSendTarget();
        syncWebViewLocation();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        handleEvent(view, motionEvent);
        return true;
    }

    public static boolean isNewCore() {
        SwanCoreVersion swanCoreVersion = AiAppsCoreRuntime.getInstance().getSwanCoreVersion();
        if ((swanCoreVersion != null ? swanCoreVersion.swanCoreVersion : 0L) < AiAppsSwanCoreManager.getVersion(SWAN_CORE_SPLIT)) {
            return false;
        }
        return true;
    }

    private void setSendTarget() {
        this.isSendToMaster = !isNewCore() && TextUtils.equals(AiAppsNAViewType.CANVAS, this.mViewType);
    }

    private void syncWebViewLocation() {
        WebView bdWebViewBySlaveId = AiAppsUtils.getBdWebViewBySlaveId(this.mSlaveId);
        if (bdWebViewBySlaveId != null) {
            bdWebViewBySlaveId.getLocationOnScreen(this.mWebViewLocation);
        }
    }

    private void handleEvent(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.mSlaveId) || TextUtils.isEmpty(this.mViewId)) {
            AiAppsLog.e(TAG, "params is null, slaveId = " + this.mSlaveId + " ; viewId = " + this.mViewId);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.mDownPosition = new TouchPosition(motionEvent.getX(), motionEvent.getY());
            this.mDownTime = motionEvent.getEventTime();
            this.mLongPressRunnable.setEvent(motionEvent);
            view.postDelayed(this.mLongPressRunnable, 350L);
            syncWebViewLocation();
        } else if (actionMasked == 1 || actionMasked == 3 || !isValidMoveDistance(new TouchPosition(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.mLongPressRunnable);
        }
        sendEventToWebView(createWebMessage(motionEvent));
        if (actionMasked == 1 && isValidMoveDistance(new TouchPosition(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.mDownTime < 350) {
            sendEventToWebView(createWebMessage(motionEvent, AiAppsTouchHelper.TouchEventName.TOUCH_TAP));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEventToWebView(AiAppsWebMessage aiAppsWebMessage) {
        if (!this.isSendToMaster) {
            AiAppsController.getInstance().sendJSMessage(this.mSlaveId, aiAppsWebMessage);
        } else {
            AiAppsController.getInstance().sendJSMessage(aiAppsWebMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public AiAppsWebMessage createWebMessage(MotionEvent motionEvent, String str) {
        AiAppsTouchHelper aiAppsTouchHelper = new AiAppsTouchHelper(motionEvent, str);
        aiAppsTouchHelper.setWebViewPosition(this.mWebViewLocation);
        AiAppsWebMessage aiAppsWebMessage = new AiAppsWebMessage();
        aiAppsWebMessage.mData = AiAppsEventHelper.getEventJson(this.mSlaveId, this.mViewId, this.mViewType, aiAppsTouchHelper.getTouchAction(), aiAppsTouchHelper.genJsonObject());
        return aiAppsWebMessage;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private AiAppsWebMessage createWebMessage(MotionEvent motionEvent) {
        AiAppsTouchHelper aiAppsTouchHelper = new AiAppsTouchHelper(motionEvent);
        aiAppsTouchHelper.setWebViewPosition(this.mWebViewLocation);
        AiAppsWebMessage aiAppsWebMessage = new AiAppsWebMessage();
        aiAppsWebMessage.mData = AiAppsEventHelper.getEventJson(this.mSlaveId, this.mViewId, this.mViewType, aiAppsTouchHelper.getTouchAction(), aiAppsTouchHelper.genJsonObject());
        return aiAppsWebMessage;
    }

    private boolean isValidMoveDistance(TouchPosition touchPosition) {
        return this.mDownPosition != null && this.mDownPosition.getDistance(touchPosition) <= ((double) AiAppsUIUtils.dp2px(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class LongPressRunnable implements Runnable {
        private MotionEvent mEvent;
        private AiAppsWebMessage mWebMessage;

        private LongPressRunnable() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEvent(MotionEvent motionEvent) {
            this.mEvent = motionEvent;
            this.mWebMessage = AiAppsTouchListener.this.createWebMessage(this.mEvent, AiAppsTouchHelper.TouchEventName.TOUCH_LONG_TAP);
        }

        @Override // java.lang.Runnable
        public void run() {
            AiAppsTouchListener.this.sendEventToWebView(this.mWebMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class TouchPosition {
        private double x;
        private double y;

        public TouchPosition(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double getDistance(TouchPosition touchPosition) {
            if (touchPosition == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(touchPosition.x - this.x, 2.0d) + Math.pow(touchPosition.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}

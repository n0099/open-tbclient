package com.baidu.searchbox.ng.ai.apps.view.container.touch;

import android.text.TextUtils;
import android.view.MotionEvent;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppsTouchHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppsTouchHelper";
    private List<FingerNode> mChangedTouchList;
    private long mTimeStamp;
    private String mTouchAction;
    private List<FingerNode> mTouchList;
    private int[] mWebViewPosition;

    /* loaded from: classes2.dex */
    private interface EventNode {
        public static final String CHANGED_TOUCH = "changedTouches";
        public static final String TIME_STAMP = "timeStamp";
        public static final String TOUCH = "touches";
    }

    /* loaded from: classes2.dex */
    interface TouchEventName {
        public static final String TOUCH_CANCEL = "touchcancel";
        public static final String TOUCH_END = "touchend";
        public static final String TOUCH_ERROR = "error";
        public static final String TOUCH_LONG_TAP = "longtap";
        public static final String TOUCH_MOVE = "touchmove";
        public static final String TOUCH_POINTER_DOWN = "touchpointerdown";
        public static final String TOUCH_POINTER_UP = "touchpointerup";
        public static final String TOUCH_START = "touchstart";
        public static final String TOUCH_TAP = "tap";
    }

    public AiAppsTouchHelper(MotionEvent motionEvent) {
        this.mTouchAction = TouchEventName.TOUCH_ERROR;
        this.mTimeStamp = 0L;
        this.mTouchList = new ArrayList();
        this.mChangedTouchList = new ArrayList();
        this.mWebViewPosition = new int[2];
        parseMotionEvent(motionEvent, "");
    }

    public AiAppsTouchHelper(MotionEvent motionEvent, String str) {
        this.mTouchAction = TouchEventName.TOUCH_ERROR;
        this.mTimeStamp = 0L;
        this.mTouchList = new ArrayList();
        this.mChangedTouchList = new ArrayList();
        this.mWebViewPosition = new int[2];
        parseMotionEvent(motionEvent, str);
    }

    public String getTouchAction() {
        return this.mTouchAction;
    }

    public void setWebViewPosition(int[] iArr) {
        this.mWebViewPosition = iArr;
    }

    private void parseMotionEvent(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.mTouchAction = TouchEventName.TOUCH_START;
                onChangedTouch(motionEvent);
                break;
            case 1:
                this.mTouchAction = TouchEventName.TOUCH_END;
                onChangedTouch(motionEvent);
                break;
            case 2:
                this.mTouchAction = TouchEventName.TOUCH_MOVE;
                onChangedTouch(motionEvent);
                break;
            case 3:
                this.mTouchAction = TouchEventName.TOUCH_CANCEL;
                onChangedTouch(motionEvent);
                break;
            case 4:
            default:
                this.mTouchAction = TouchEventName.TOUCH_ERROR;
                break;
            case 5:
                this.mTouchAction = TouchEventName.TOUCH_POINTER_DOWN;
                onChangedTouch(motionEvent);
                break;
            case 6:
                this.mTouchAction = TouchEventName.TOUCH_POINTER_UP;
                onChangedTouch(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.mTouchAction = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.mTouchAction, TouchEventName.TOUCH_POINTER_DOWN)) {
            this.mTouchAction = TouchEventName.TOUCH_START;
        }
        if (TextUtils.equals(this.mTouchAction, TouchEventName.TOUCH_POINTER_UP)) {
            this.mTouchAction = TouchEventName.TOUCH_END;
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.mTouchAction, TouchEventName.TOUCH_END) && !TextUtils.equals(this.mTouchAction, TouchEventName.TOUCH_CANCEL)) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.mTouchList.add(getFingerNode(motionEvent, i));
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    private void onChangedTouch(MotionEvent motionEvent) {
        try {
            if (!(motionEvent.getActionMasked() == 2)) {
                this.mChangedTouchList.add(getFingerNode(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.mChangedTouchList.add(getFingerNode(motionEvent, i));
            }
        } catch (Exception e) {
        }
    }

    public FingerNode getFingerNode(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        FingerNode fingerNode = new FingerNode();
        fingerNode.identifier = pointerId;
        fingerNode.x = motionEvent.getX(i);
        fingerNode.y = motionEvent.getY(i);
        fingerNode.rawX = (motionEvent.getRawX() + fingerNode.x) - motionEvent.getX();
        fingerNode.rawY = (motionEvent.getRawY() + fingerNode.y) - motionEvent.getY();
        fingerNode.pressure = motionEvent.getPressure(i);
        return fingerNode;
    }

    public JSONObject genJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.mTouchList.isEmpty()) {
                for (FingerNode fingerNode : this.mTouchList) {
                    if (fingerNode != null) {
                        jSONArray.put(fingerNode.genJSONObject());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.mChangedTouchList.isEmpty()) {
                for (FingerNode fingerNode2 : this.mChangedTouchList) {
                    if (fingerNode2 != null) {
                        jSONArray2.put(fingerNode2.genJSONObject());
                    }
                }
            }
            jSONObject.put("timeStamp", this.mTimeStamp);
            jSONObject.put(EventNode.TOUCH, jSONArray);
            jSONObject.put(EventNode.CHANGED_TOUCH, jSONArray2);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class FingerNode {
        private static final String CLIENT_X = "clientX";
        private static final String CLIENT_Y = "clientY";
        private static final String FINGER_IDENTIFIER = "identifier";
        private static final String FORCE = "force";
        private static final String TOUCH_X = "x";
        private static final String TOUCH_Y = "y";
        private int identifier;
        private float pressure;
        private float rawX;
        private float rawY;
        private float x;
        private float y;

        private FingerNode() {
        }

        JSONObject genJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", AiAppsUIUtils.px2dpFloat(this.x));
                jSONObject.put("y", AiAppsUIUtils.px2dpFloat(this.y));
                jSONObject.put(CLIENT_X, AiAppsUIUtils.px2dpFloat(this.rawX - AiAppsTouchHelper.this.mWebViewPosition[0]));
                jSONObject.put(CLIENT_Y, AiAppsUIUtils.px2dpFloat(this.rawY - AiAppsTouchHelper.this.mWebViewPosition[1]));
                jSONObject.put(FINGER_IDENTIFIER, this.identifier);
                jSONObject.put(FORCE, this.pressure);
            } catch (JSONException e) {
            }
            return jSONObject;
        }
    }
}

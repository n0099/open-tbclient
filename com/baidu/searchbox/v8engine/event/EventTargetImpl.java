package com.baidu.searchbox.v8engine.event;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes5.dex */
public class EventTargetImpl implements EventTarget {
    private static final boolean DEBUG = false;
    private static final String EVENT_TYPE = "type";
    private static final String TAG = "EventTargetImpl";
    private JSRuntime mJSRuntime;
    private final Lock mLock = new ReentrantLock();
    private Map<String, List<JsFunction>> mTargets;

    public EventTargetImpl(JSRuntime jSRuntime) {
        this.mJSRuntime = jSRuntime;
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(final JSEvent jSEvent) {
        if (!JSEvent.isValid(jSEvent)) {
            return false;
        }
        this.mJSRuntime.runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.event.EventTargetImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    EventTargetImpl.this.mLock.lock();
                    for (JsFunction jsFunction : new ArrayList(EventTargetImpl.this.getEventListeners(jSEvent.type))) {
                        if (jsFunction != null) {
                            jsFunction.call(EventTargetImpl.this, jSEvent.data, false);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    EventTargetImpl.this.mLock.unlock();
                }
            }
        });
        return true;
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTarget
    @JavascriptInterface
    public boolean dispatchEvent(final JsObject jsObject) {
        final String parseEventType = parseEventType(jsObject);
        if (TextUtils.isEmpty(parseEventType)) {
            return false;
        }
        this.mJSRuntime.runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.event.EventTargetImpl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    EventTargetImpl.this.mLock.lock();
                    for (JsFunction jsFunction : new ArrayList(EventTargetImpl.this.getEventListeners(parseEventType))) {
                        if (jsFunction != null) {
                            jsFunction.call(EventTargetImpl.this, jsObject, false);
                        }
                    }
                    jsObject.release();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    EventTargetImpl.this.mLock.unlock();
                }
            }
        });
        return true;
    }

    private String parseEventType(JsObject jsObject) {
        int propertyIndex;
        if (jsObject != null && (propertyIndex = jsObject.getPropertyIndex("type")) >= 0) {
            return jsObject.toString(propertyIndex);
        }
        return null;
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTarget
    public boolean hasEventListener(String... strArr) {
        if (strArr == null) {
            return false;
        }
        try {
            this.mLock.lock();
            for (String str : strArr) {
                if (getTargetMap().containsKey(str) && !getTargetMap().get(str).isEmpty()) {
                    return true;
                }
            }
            return false;
        } finally {
            this.mLock.unlock();
        }
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTarget
    @JavascriptInterface
    public void addEventListener(String str, JsFunction jsFunction) {
        if (!isArgumentsInvalid(str, jsFunction)) {
            try {
                this.mLock.lock();
                List<JsFunction> eventListeners = getEventListeners(str);
                if (!eventListeners.contains(jsFunction)) {
                    jsFunction.setReleaseMode(false);
                    eventListeners.add(jsFunction);
                }
                if (!getTargetMap().containsKey(str)) {
                    getTargetMap().put(str, eventListeners);
                }
            } finally {
                this.mLock.unlock();
            }
        }
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTarget
    @JavascriptInterface
    public void removeEventListener(String str) {
        removeEventListener(str, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [248=4] */
    @Override // com.baidu.searchbox.v8engine.event.EventTarget
    @JavascriptInterface
    public void removeEventListener(String str, JsFunction jsFunction) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.mLock.lock();
            if (jsFunction == null) {
                List<JsFunction> eventListeners = getEventListeners(str);
                if (eventListeners != null) {
                    while (!eventListeners.isEmpty()) {
                        JsFunction jsFunction2 = eventListeners.get(0);
                        eventListeners.remove(jsFunction2);
                        jsFunction2.release();
                    }
                    if (eventListeners.isEmpty() && getTargetMap().containsKey(str)) {
                        getTargetMap().remove(str);
                    }
                }
                return;
            }
            List<JsFunction> eventListeners2 = getEventListeners(str);
            if (eventListeners2 == null || !eventListeners2.contains(jsFunction)) {
                return;
            }
            eventListeners2.remove(jsFunction);
            jsFunction.release();
            if (eventListeners2.isEmpty() && getTargetMap().containsKey(str)) {
                getTargetMap().remove(str);
            }
        } finally {
            this.mLock.unlock();
        }
    }

    private boolean isArgumentsInvalid(String str, JsFunction jsFunction) {
        return TextUtils.isEmpty(str) || jsFunction == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<JsFunction> getEventListeners(String str) {
        List<JsFunction> list = getTargetMap().get(str);
        return list == null ? new ArrayList() : list;
    }

    public Map<String, List<JsFunction>> getTargetMap() {
        if (this.mTargets == null) {
            this.mTargets = new TreeMap();
        }
        return this.mTargets;
    }
}

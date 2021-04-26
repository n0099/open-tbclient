package com.baidu.mobads.container.util;

import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.container.adrequest.IOAdEventDispatcher;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class XAdRemoteEventDispatcher implements IOAdEventDispatcher {
    public Map<String, ArrayList<IOAdEventListener>> evtlisteners;
    public Handler mHandler;

    public XAdRemoteEventDispatcher() {
        removeAllListeners();
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.mobads.container.adrequest.IOAdEventDispatcher
    public void addEventListener(String str, IOAdEventListener iOAdEventListener) {
        if (str == null || iOAdEventListener == null) {
            return;
        }
        removeEventListener(str, iOAdEventListener);
        ArrayList<IOAdEventListener> arrayList = this.evtlisteners.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.evtlisteners.put(str, arrayList);
        }
        arrayList.add(iOAdEventListener);
    }

    @Override // com.baidu.mobads.container.adrequest.IOAdEventDispatcher
    public void dispatchEvent(IOAdEvent iOAdEvent) {
        if (iOAdEvent == null) {
            return;
        }
        try {
            iOAdEvent.setTarget(this);
            ArrayList<IOAdEventListener> arrayList = this.evtlisteners.get(iOAdEvent.getType());
            if (arrayList != null) {
                int size = arrayList.size();
                IOAdEventListener[] iOAdEventListenerArr = new IOAdEventListener[size];
                arrayList.toArray(iOAdEventListenerArr);
                for (int i2 = 0; i2 < size; i2++) {
                    IOAdEventListener iOAdEventListener = iOAdEventListenerArr[i2];
                    if (iOAdEventListener != null) {
                        iOAdEventListener.run(iOAdEvent);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public void dispose() {
        removeAllListeners();
    }

    public IOAdEventListener getEventType(String str) {
        ArrayList<IOAdEventListener> arrayList;
        if (!hasEventListener(str) || (arrayList = this.evtlisteners.get(str)) == null || arrayList.size() <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    @Override // com.baidu.mobads.container.adrequest.IOAdEventDispatcher
    public boolean hasEventListener(String str) {
        ArrayList<IOAdEventListener> arrayList = this.evtlisteners.get(str);
        return (arrayList == null || arrayList.isEmpty()) ? false : true;
    }

    @Override // com.baidu.mobads.container.adrequest.IOAdEventDispatcher
    public void removeAllListeners() {
        this.evtlisteners = new ConcurrentHashMap();
    }

    @Override // com.baidu.mobads.container.adrequest.IOAdEventDispatcher
    public void removeEventListener(String str, IOAdEventListener iOAdEventListener) {
        if (str != null && iOAdEventListener != null) {
            try {
                ArrayList<IOAdEventListener> arrayList = this.evtlisteners.get(str);
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                arrayList.remove(iOAdEventListener);
                if (!arrayList.isEmpty()) {
                    return;
                }
                this.evtlisteners.remove(str);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IOAdEventDispatcher
    public void removeEventListeners(String str) {
        this.evtlisteners.remove(str);
    }
}

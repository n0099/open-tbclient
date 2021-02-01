package com.baidu.mobads.openad.a;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.q;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class c implements IOAdEventDispatcher {

    /* renamed from: a  reason: collision with root package name */
    protected Map<String, ArrayList<IOAdEventListener>> f3418a;

    public c() {
        removeAllListeners();
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher
    public void addEventListener(String str, IOAdEventListener iOAdEventListener) {
        if (str != null && iOAdEventListener != null) {
            removeEventListener(str, iOAdEventListener);
            ArrayList<IOAdEventListener> arrayList = this.f3418a.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f3418a.put(str, arrayList);
            }
            arrayList.add(iOAdEventListener);
        }
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher
    public boolean hasEventListener(String str) {
        ArrayList<IOAdEventListener> arrayList = this.f3418a.get(str);
        return (arrayList == null || arrayList.isEmpty()) ? false : true;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher
    public void removeEventListener(String str, IOAdEventListener iOAdEventListener) {
        if (str != null && iOAdEventListener != null) {
            try {
                ArrayList<IOAdEventListener> arrayList = this.f3418a.get(str);
                if (arrayList != null && arrayList.size() > 0) {
                    arrayList.remove(iOAdEventListener);
                    if (arrayList.isEmpty()) {
                        this.f3418a.remove(str);
                    }
                }
            } catch (Exception e) {
                q.a().e(e);
            }
        }
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher
    public void removeEventListeners(String str) {
        this.f3418a.remove(str);
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher
    public void removeAllListeners() {
        this.f3418a = new ConcurrentHashMap();
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher
    public void dispatchEvent(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            try {
                iOAdEvent.setTarget(this);
                ArrayList<IOAdEventListener> arrayList = this.f3418a.get(iOAdEvent.getType());
                if (arrayList != null) {
                    IOAdEventListener[] iOAdEventListenerArr = new IOAdEventListener[arrayList.size()];
                    arrayList.toArray(iOAdEventListenerArr);
                    for (IOAdEventListener iOAdEventListener : iOAdEventListenerArr) {
                        if (iOAdEventListener != null) {
                            iOAdEventListener.run(iOAdEvent);
                        }
                    }
                }
            } catch (Exception e) {
                q.a().e(e);
            }
        }
    }
}

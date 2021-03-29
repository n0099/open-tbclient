package com.baidu.mobads.openad.a;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.q;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class c implements IOAdEventDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, ArrayList<IOAdEventListener>> f8400a;

    public c() {
        removeAllListeners();
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher
    public void addEventListener(String str, IOAdEventListener iOAdEventListener) {
        if (str == null || iOAdEventListener == null) {
            return;
        }
        removeEventListener(str, iOAdEventListener);
        ArrayList<IOAdEventListener> arrayList = this.f8400a.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f8400a.put(str, arrayList);
        }
        arrayList.add(iOAdEventListener);
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher
    public void dispatchEvent(IOAdEvent iOAdEvent) {
        if (iOAdEvent == null) {
            return;
        }
        try {
            iOAdEvent.setTarget(this);
            ArrayList<IOAdEventListener> arrayList = this.f8400a.get(iOAdEvent.getType());
            if (arrayList != null) {
                int size = arrayList.size();
                IOAdEventListener[] iOAdEventListenerArr = new IOAdEventListener[size];
                arrayList.toArray(iOAdEventListenerArr);
                for (int i = 0; i < size; i++) {
                    IOAdEventListener iOAdEventListener = iOAdEventListenerArr[i];
                    if (iOAdEventListener != null) {
                        iOAdEventListener.run(iOAdEvent);
                    }
                }
            }
        } catch (Exception e2) {
            q.a().e(e2);
        }
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher
    public boolean hasEventListener(String str) {
        ArrayList<IOAdEventListener> arrayList = this.f8400a.get(str);
        return (arrayList == null || arrayList.isEmpty()) ? false : true;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher
    public void removeAllListeners() {
        this.f8400a = new ConcurrentHashMap();
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher
    public void removeEventListener(String str, IOAdEventListener iOAdEventListener) {
        if (str == null || iOAdEventListener == null) {
            return;
        }
        try {
            ArrayList<IOAdEventListener> arrayList = this.f8400a.get(str);
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            arrayList.remove(iOAdEventListener);
            if (arrayList.isEmpty()) {
                this.f8400a.remove(str);
            }
        } catch (Exception e2) {
            q.a().e(e2);
        }
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher
    public void removeEventListeners(String str) {
        this.f8400a.remove(str);
    }
}

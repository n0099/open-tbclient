package com.baidu.mobads.component;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class XNativeViewManager {
    public static XNativeViewManager sInstance;
    public CopyOnWriteArrayList<XNativeView> mViewList;

    public static XNativeViewManager getInstance() {
        if (sInstance == null) {
            synchronized (XNativeViewManager.class) {
                if (sInstance == null) {
                    XNativeViewManager xNativeViewManager = new XNativeViewManager();
                    sInstance = xNativeViewManager;
                    xNativeViewManager.mViewList = new CopyOnWriteArrayList<>();
                }
            }
        }
        return sInstance;
    }

    public void addItem(XNativeView xNativeView) {
        this.mViewList.add(xNativeView);
    }

    public void removeNativeView(XNativeView xNativeView) {
        CopyOnWriteArrayList<XNativeView> copyOnWriteArrayList = this.mViewList;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            return;
        }
        Iterator<XNativeView> it = this.mViewList.iterator();
        while (it.hasNext()) {
            if (it.next() == xNativeView) {
                this.mViewList.remove(xNativeView);
            }
        }
    }

    public void resetAllPlayer(XNativeView xNativeView) {
        CopyOnWriteArrayList<XNativeView> copyOnWriteArrayList = this.mViewList;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            return;
        }
        Iterator<XNativeView> it = this.mViewList.iterator();
        while (it.hasNext()) {
            XNativeView next = it.next();
            if (next != xNativeView) {
                next.stop();
            }
        }
    }
}

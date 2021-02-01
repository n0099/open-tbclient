package com.baidu.mobads.component;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public class XNativeViewManager {
    private static XNativeViewManager sInstance;
    private CopyOnWriteArrayList<XNativeView> mViewList;

    private XNativeViewManager() {
    }

    public static XNativeViewManager getInstance() {
        if (sInstance == null) {
            synchronized (XNativeViewManager.class) {
                if (sInstance == null) {
                    sInstance = new XNativeViewManager();
                    sInstance.mViewList = new CopyOnWriteArrayList<>();
                }
            }
        }
        return sInstance;
    }

    public void addItem(XNativeView xNativeView) {
        this.mViewList.add(xNativeView);
    }

    public void resetAllPlayer(XNativeView xNativeView) {
        if (this.mViewList != null && this.mViewList.size() != 0) {
            Iterator<XNativeView> it = this.mViewList.iterator();
            while (it.hasNext()) {
                XNativeView next = it.next();
                if (next != xNativeView) {
                    next.stop();
                }
            }
        }
    }

    public void removeNativeView(XNativeView xNativeView) {
        if (this.mViewList != null && this.mViewList.size() != 0) {
            Iterator<XNativeView> it = this.mViewList.iterator();
            while (it.hasNext()) {
                if (it.next() == xNativeView) {
                    this.mViewList.remove(xNativeView);
                }
            }
        }
    }
}

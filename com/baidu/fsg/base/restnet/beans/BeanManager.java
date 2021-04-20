package com.baidu.fsg.base.restnet.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes2.dex */
public final class BeanManager {
    public static BeanManager mBeanMgr;
    public final HashMap<String, ArrayList<ApollonBean>> mContextBeanList = new HashMap<>();

    public static synchronized BeanManager getInstance() {
        BeanManager beanManager;
        synchronized (BeanManager.class) {
            if (mBeanMgr == null) {
                mBeanMgr = new BeanManager();
            }
            beanManager = mBeanMgr;
        }
        return beanManager;
    }

    public synchronized void addBean(String str, ApollonBean apollonBean) {
        ArrayList<ApollonBean> arrayList = this.mContextBeanList.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.mContextBeanList.put(str, arrayList);
        }
        arrayList.add(apollonBean);
    }

    public synchronized void removeAllBeans(String str) {
        ArrayList<ApollonBean> arrayList = this.mContextBeanList.get(str);
        if (arrayList != null) {
            Iterator<ApollonBean> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().destroyBean();
            }
            this.mContextBeanList.remove(str);
        }
    }

    public synchronized void removeBean(ApollonBean apollonBean) {
        for (String str : this.mContextBeanList.keySet()) {
            ArrayList<ApollonBean> arrayList = this.mContextBeanList.get(str);
            Iterator<ApollonBean> it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (apollonBean == it.next()) {
                        arrayList.remove(apollonBean);
                        apollonBean.destroyBean();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }
}

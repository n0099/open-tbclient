package com.baidu.fsg.base.restnet.beans.business;

import android.text.TextUtils;
import com.baidu.fsg.base.NoProguard;
import com.baidu.fsg.base.utils.LogUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public final class BeanRequestCache implements NoProguard {
    public static BeanRequestCache mRequestCache;
    public final HashMap<String, BeanRequestBase> mRequestList = new HashMap<>();

    public static synchronized BeanRequestCache getInstance() {
        BeanRequestCache beanRequestCache;
        synchronized (BeanRequestCache.class) {
            if (mRequestCache == null) {
                mRequestCache = new BeanRequestCache();
            }
            beanRequestCache = mRequestCache;
        }
        return beanRequestCache;
    }

    public void addBeanRequestToCache(String str, BeanRequestBase beanRequestBase) {
        if (str == null || str.equals("") || beanRequestBase == null) {
            return;
        }
        this.mRequestList.put(str, beanRequestBase);
    }

    public void clearPaySdkRequestCache() {
        LogUtil.e(BeanRequestCache.class.getSimpleName(), "clearPaySdkRequestCache", null);
        Set<String> keySet = this.mRequestList.keySet();
        HashSet<String> hashSet = new HashSet();
        for (String str : keySet) {
            if (this.mRequestList.get(str) != null && this.mRequestList.get(str).mBelongPaySdk) {
                hashSet.add(str);
            }
        }
        for (String str2 : hashSet) {
            removeBeanRequestFromCache(str2);
        }
    }

    public void clearRequestCache() {
        this.mRequestList.clear();
    }

    public BeanRequestBase getBeanRequestFromCache(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        return this.mRequestList.get(str);
    }

    public void removeBeanRequestFromCache(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mRequestList.remove(str);
    }
}

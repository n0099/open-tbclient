package com.baidu.searchbox.schemeauthenticate;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.baidu.android.util.concurrent.ExecutorUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.schemeauthenticate.database.AuthenticateControl;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class SchemeAuthenticateMonitor {
    public static final String ALLOW = "1";
    public static final int CACHE_TIMEOUT = 4000;
    public static final String CONFIRM = "2";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final int MAX_SIZE = 50;
    public static final String TAG = "SchemeAuthenticateMonitor";
    public static SchemeAuthenticateMonitor sInstanse;
    public volatile Set<String> mSchemeWhiteListSet;
    public volatile ArrayList<String> mSchemeWhitePrefixList;
    public CountDownLatch mLatch = new CountDownLatch(1);
    public LruCache<String, SiteAuthenticateInfo> siteAuthenticateInfoLruCache = new LruCache<>(50);

    /* loaded from: classes4.dex */
    public static class SiteAuthenticateInfo {
        public long mExpireTime;
        public String mSameOriginUri;
        public Map<String, String> mSchemeList = new HashMap();
        public String mType;
        public String mUrl;

        public long getExpireTime() {
            return this.mExpireTime;
        }

        public String getSameOriginUri() {
            return AuthenticateUtils.getAuthKey(this.mUrl, this.mType);
        }

        public Map<String, String> getSchemeList() {
            return this.mSchemeList;
        }

        public String getType() {
            return this.mType;
        }

        public String toString() {
            return "mSchemeList:" + this.mSchemeList + ",expireTime:" + this.mExpireTime + ",";
        }

        public void setExpireTime(long j) {
            this.mExpireTime = j;
        }

        public void setSchemeList(Map<String, String> map) {
            this.mSchemeList = map;
        }

        public void setType(String str) {
            this.mType = str;
        }

        public void setUrl(String str) {
            this.mUrl = str;
        }
    }

    public SchemeAuthenticateMonitor() {
        init();
    }

    public static SchemeAuthenticateMonitor getInstanse() {
        if (sInstanse == null) {
            synchronized (SchemeAuthenticateMonitor.class) {
                if (sInstanse == null) {
                    sInstanse = new SchemeAuthenticateMonitor();
                }
            }
        }
        return sInstanse;
    }

    public void init() {
        ExecutorUtils.postOnIO(new Runnable() { // from class: com.baidu.searchbox.schemeauthenticate.SchemeAuthenticateMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                SchemeAuthenticateMonitor.this.initCache();
            }
        }, "authenticate_initCache");
    }

    private String getType(String str) {
        try {
            return Uri.parse(str).getQueryParameter("oauthType");
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean checkIsInWhiteList(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            str2 = getAllPath(Uri.parse(str));
        } else {
            str2 = "";
        }
        if (this.mSchemeWhiteListSet == null) {
            try {
                this.mLatch.await(4000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (this.mSchemeWhiteListSet != null && this.mSchemeWhiteListSet.contains(str2)) {
            return true;
        }
        if (this.mSchemeWhitePrefixList != null) {
            Iterator<String> it = this.mSchemeWhitePrefixList.iterator();
            while (it.hasNext()) {
                if (str2.startsWith(it.next())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static String getAllPath(Uri uri) {
        String path;
        if (uri != null) {
            if (UnitedSchemeUtility.hasVersion(uri) && (path = uri.getPath()) != null && path.length() > 1) {
                return uri.getPath().substring(1);
            }
            return uri.getHost() + uri.getPath();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCache() {
        AuthenticateControl authenticateControl = AuthenticateControl.getInstance(AppRuntime.getAppContext());
        long currentTimeMillis = System.currentTimeMillis();
        authenticateControl.clearExpireItem(currentTimeMillis);
        for (AuthenticateControl.AuthenticateItem authenticateItem : authenticateControl.getAuthenticateItemList(currentTimeMillis)) {
            SiteAuthenticateInfo siteAuthenticateInfo = new SiteAuthenticateInfo();
            siteAuthenticateInfo.setUrl(authenticateItem.url);
            siteAuthenticateInfo.setType(authenticateItem.type);
            siteAuthenticateInfo.setExpireTime(authenticateItem.expireTime);
            HashMap hashMap = new HashMap();
            try {
                AuthenticateNetManager.schemeList2Map(authenticateItem.schemeList, hashMap);
            } catch (Exception e) {
                if (DEBUG) {
                    String str = TAG;
                    Log.e(str, "init exception:" + e);
                }
            }
            siteAuthenticateInfo.setSchemeList(hashMap);
            updateSiteAuthenticateInfo(false, authenticateItem.url, authenticateItem.type, siteAuthenticateInfo);
        }
        this.mSchemeWhiteListSet = SchemeWhiteListListener.getSchemeWhiteListSet(AppRuntime.getAppContext());
        this.mSchemeWhitePrefixList = SchemeWhiteListListener.getSchemeWhitePrefixList(AppRuntime.getAppContext());
        this.mLatch.countDown();
    }

    public boolean checkIsAvalid(String str, String str2) {
        if (DEBUG) {
            String str3 = TAG;
            Log.i(str3, "checkIsAvalid url:" + str + ",schemeCmd:" + str2);
        }
        SiteAuthenticateInfo siteAuthenticateInfo = this.siteAuthenticateInfoLruCache.get(AuthenticateUtils.getAuthKey(str, getType(str2)));
        if (siteAuthenticateInfo != null) {
            if (DEBUG) {
                String str4 = TAG;
                Log.i(str4, "checkIsAvalid siteAuthenticateInfo:" + siteAuthenticateInfo);
            }
            if (System.currentTimeMillis() > siteAuthenticateInfo.getExpireTime()) {
                return false;
            }
            String str5 = siteAuthenticateInfo.getSchemeList().get(AuthenticateUtils.getSchemeAuthority(str2));
            if (TextUtils.equals(str5, "1") || TextUtils.equals(str5, "2")) {
                return true;
            }
        }
        if (checkIsInWhiteList(str2)) {
            return true;
        }
        return false;
    }

    public boolean needConfirm(String str, String str2) {
        if (DEBUG) {
            String str3 = TAG;
            Log.i(str3, "checkIsAvalid url:" + str + ",schemeCmd:" + str2);
        }
        SiteAuthenticateInfo siteAuthenticateInfo = this.siteAuthenticateInfoLruCache.get(AuthenticateUtils.getAuthKey(str, getType(str2)));
        if (siteAuthenticateInfo != null) {
            if (DEBUG) {
                String str4 = TAG;
                Log.i(str4, "checkIsAvalid siteAuthenticateInfo:" + siteAuthenticateInfo);
            }
            if (System.currentTimeMillis() > siteAuthenticateInfo.getExpireTime()) {
                return false;
            }
            if (TextUtils.equals(siteAuthenticateInfo.getSchemeList().get(AuthenticateUtils.getSchemeAuthority(str2)), "2")) {
                return true;
            }
        }
        return false;
    }

    public void updateSiteAuthenticateInfo(String str, String str2, SiteAuthenticateInfo siteAuthenticateInfo) {
        this.siteAuthenticateInfoLruCache.put(AuthenticateUtils.getAuthKey(str, str2), siteAuthenticateInfo);
    }

    public void updateSiteAuthenticateInfo(boolean z, String str, String str2, SiteAuthenticateInfo siteAuthenticateInfo) {
        String authKey = AuthenticateUtils.getAuthKey(str, str2);
        if (z) {
            this.siteAuthenticateInfoLruCache.put(authKey, siteAuthenticateInfo);
        } else if (this.siteAuthenticateInfoLruCache.get(authKey) == null) {
            this.siteAuthenticateInfoLruCache.put(authKey, siteAuthenticateInfo);
        }
    }
}

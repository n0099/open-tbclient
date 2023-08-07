package com.baidu.swan.apps.favordata;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.NoProGuard;
import com.baidu.tieba.wv2;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class SwanFavorItemData implements Serializable, NoProGuard {
    public static final int IS_NEW_FAVOR = 1;
    public static final int IS_NOT_NEW_FAVOR = 0;
    public static final String SCHEME_AUTHORITY_SWAN_APP = "swan";
    public static final String SCHEME_AUTHORITY_SWAN_GAME = "swangame";
    public long mCreateTime;
    public int mIndex;
    public String mAppKey = "";
    public String mAppName = "";
    public String mIconUrl = "";
    public int mAppType = 0;
    public int mAppFrameType = -1;
    public int mAppPayProtected = 0;
    public int mIsNewFavor = 0;

    public int getAppFrameType() {
        return this.mAppFrameType;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public int getAppType() {
        return this.mAppType;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public int getIsNewFavor() {
        return this.mIsNewFavor;
    }

    public int getPayProtected() {
        return this.mAppPayProtected;
    }

    public int getFrameTypeFromScheme(String str) {
        char c;
        String authority = Uri.parse(str).getAuthority();
        if (authority == null) {
            return -1;
        }
        int hashCode = authority.hashCode();
        if (hashCode != -319738621) {
            if (hashCode == 3543441 && authority.equals("swan")) {
                c = 0;
            }
            c = 65535;
        } else {
            if (authority.equals(SCHEME_AUTHORITY_SWAN_GAME)) {
                c = 1;
            }
            c = 65535;
        }
        if (c == 0) {
            return 0;
        }
        if (c != 1) {
            return -1;
        }
        return 1;
    }

    public String getSchema(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return wv2.h1(getAppKey(), str, getAppFrameType());
    }

    public void setAppFrameType(int i) {
        this.mAppFrameType = i;
    }

    public void setAppKey(String str) {
        this.mAppKey = str;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public void setAppType(int i) {
        this.mAppType = i;
    }

    public void setCreateTime(long j) {
        this.mCreateTime = j;
    }

    public void setIconUrl(String str) {
        this.mIconUrl = str;
    }

    public void setIndex(int i) {
        this.mIndex = i;
    }

    public void setIsNewFavor(int i) {
        this.mIsNewFavor = i;
    }

    public void setPayProtected(int i) {
        this.mAppPayProtected = i;
    }
}

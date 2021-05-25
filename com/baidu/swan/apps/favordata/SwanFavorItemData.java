package com.baidu.swan.apps.favordata;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.NoProGuard;
import d.a.l0.a.f1.e.c;
import java.io.Serializable;
/* loaded from: classes2.dex */
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

    public int getFrameTypeFromScheme(String str) {
        char c2;
        String authority = Uri.parse(str).getAuthority();
        if (authority != null) {
            int hashCode = authority.hashCode();
            if (hashCode != -319738621) {
                if (hashCode == 3543441 && authority.equals("swan")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (authority.equals(SCHEME_AUTHORITY_SWAN_GAME)) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                return c2 != 1 ? -1 : 1;
            }
            return 0;
        }
        return -1;
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

    public String getSchema(String str) {
        return TextUtils.isEmpty(str) ? "" : c.e1(getAppKey(), str, getAppFrameType());
    }

    public void setAppFrameType(int i2) {
        this.mAppFrameType = i2;
    }

    public void setAppKey(String str) {
        this.mAppKey = str;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public void setAppType(int i2) {
        this.mAppType = i2;
    }

    public void setCreateTime(long j) {
        this.mCreateTime = j;
    }

    public void setIconUrl(String str) {
        this.mIconUrl = str;
    }

    public void setIndex(int i2) {
        this.mIndex = i2;
    }

    public void setIsNewFavor(int i2) {
        this.mIsNewFavor = i2;
    }

    public void setPayProtected(int i2) {
        this.mAppPayProtected = i2;
    }
}

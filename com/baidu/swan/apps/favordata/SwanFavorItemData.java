package com.baidu.swan.apps.favordata;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.NoProGuard;
import d.b.g0.a.y0.e.c;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class SwanFavorItemData implements Serializable, NoProGuard {
    public static final String SCHEME_AUTHORITY_SWAN_APP = "swan";
    public static final String SCHEME_AUTHORITY_SWAN_GAME = "swangame";
    public int mIndex;
    public String mAppKey = "";
    public String mAppName = "";
    public String mIconUrl = "";
    public int mAppType = 0;
    public int mAppFrameType = -1;

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

    public String getSchema(String str) {
        return TextUtils.isEmpty(str) ? "" : c.X0(getAppKey(), str, getAppFrameType());
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

    public void setIconUrl(String str) {
        this.mIconUrl = str;
    }

    public void setIndex(int i) {
        this.mIndex = i;
    }
}

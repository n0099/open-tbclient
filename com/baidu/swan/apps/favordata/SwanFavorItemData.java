package com.baidu.swan.apps.favordata;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.NoProGuard;
import com.baidu.swan.apps.u.c.c;
import java.io.Serializable;
/* loaded from: classes25.dex */
public class SwanFavorItemData implements NoProGuard, Serializable {
    private static final String SCHEME_AUTHORITY_SWAN_APP = "swan";
    private static final String SCHEME_AUTHORITY_SWAN_GAME = "swangame";
    private int mIndex;
    private String mAppKey = "";
    private String mAppName = "";
    private String mIconUrl = "";
    private int mAppType = 0;
    private int mAppFrameType = -1;

    public String getAppName() {
        return this.mAppName;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public void setIconUrl(String str) {
        this.mIconUrl = str;
    }

    public String getSchema(String str) {
        return TextUtils.isEmpty(str) ? "" : c.f(getAppKey(), str, getAppFrameType());
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public void setAppKey(String str) {
        this.mAppKey = str;
    }

    public void setAppType(int i) {
        this.mAppType = i;
    }

    public int getAppType() {
        return this.mAppType;
    }

    public int getAppFrameType() {
        return this.mAppFrameType;
    }

    public void setAppFrameType(int i) {
        this.mAppFrameType = i;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setIndex(int i) {
        this.mIndex = i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public int getFrameTypeFromScheme(String str) {
        boolean z;
        String authority = Uri.parse(str).getAuthority();
        if (authority != null) {
            switch (authority.hashCode()) {
                case -319738621:
                    if (authority.equals(SCHEME_AUTHORITY_SWAN_GAME)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3543441:
                    if (authority.equals("swan")) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case false:
                    return 0;
                case true:
                    return 1;
                default:
                    return -1;
            }
        }
        return -1;
    }
}

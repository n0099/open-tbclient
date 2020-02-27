package com.baidu.searchbox.network.core;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes13.dex */
public class HttpResourceManager {
    private static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.bin";
    private static volatile HttpResourceManager singleton = null;
    private Context mContext;

    public void setContext(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static HttpResourceManager getSingleton() {
        if (singleton == null) {
            synchronized (HttpResourceManager.class) {
                if (singleton == null) {
                    singleton = new HttpResourceManager();
                }
            }
        }
        return singleton;
    }

    public InputStream getPublicSuffixResourceInputStream() throws IOException {
        if (this.mContext != null) {
            return this.mContext.getAssets().open(PUBLIC_SUFFIX_RESOURCE);
        }
        return null;
    }
}

package com.baidu.live.tbadk.util;

import android.graphics.drawable.Drawable;
import com.baidu.live.tbadk.widget.CommonEmptyView;
/* loaded from: classes11.dex */
public class HostResourceManager {
    private static volatile HostResourceManager mInstance = null;
    private IResourceAdapter mResourceAdapter = null;

    private HostResourceManager() {
    }

    public static HostResourceManager getInstance() {
        if (mInstance == null) {
            synchronized (HostResourceManager.class) {
                if (mInstance == null) {
                    mInstance = new HostResourceManager();
                }
            }
        }
        return mInstance;
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        this.mResourceAdapter = iResourceAdapter;
    }

    public Drawable getEmotionDrawable(CommonEmptyView.ImgType imgType, CommonEmptyView.StyleType styleType) {
        if (this.mResourceAdapter == null) {
            return null;
        }
        return this.mResourceAdapter.getEmotionDrawable(imgType, styleType);
    }
}

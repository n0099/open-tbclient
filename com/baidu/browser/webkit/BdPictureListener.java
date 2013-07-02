package com.baidu.browser.webkit;

import android.graphics.Picture;
import com.baidu.browser.webkit.sys.BdSysPictureListener;
import com.baidu.browser.webkit.zeus.BdZeusPictureListener;
/* loaded from: classes.dex */
public class BdPictureListener {
    private BdSysPictureListener mSysPictureListener;
    private BdZeusPictureListener mZeusPictureListener;

    public BdPictureListener() {
        if (BdWebViewManager.getInstance().isZeusLoaded()) {
            this.mZeusPictureListener = new BdZeusPictureListener(this);
        } else {
            this.mSysPictureListener = new BdSysPictureListener(this);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof BdPictureListener) && unwrap() == ((BdPictureListener) obj).unwrap();
    }

    public int hashCode() {
        return this.mZeusPictureListener != null ? this.mZeusPictureListener.hashCode() : this.mSysPictureListener.hashCode();
    }

    public boolean isContains(Object obj) {
        return this.mZeusPictureListener != null ? this.mZeusPictureListener == obj : this.mSysPictureListener == obj;
    }

    public Object unwrap() {
        return this.mZeusPictureListener != null ? this.mZeusPictureListener : this.mSysPictureListener;
    }

    public void onNewPicture(BdWebView bdWebView, Picture picture) {
    }
}

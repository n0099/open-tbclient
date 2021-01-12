package com.baidu.pano.platform.plugin.indooralbum;

import android.view.View;
import com.baidu.lbsapi.panoramaview.PanoramaView;
import com.baidu.pano.platform.plugin.indooralbum.IndoorAlbumCallback;
/* loaded from: classes6.dex */
public class IndoorAlbumPlugin {
    protected static Object mLock = new Object();
    protected static IndoorAlbumPlugin mPlugin = null;
    protected PanoramaView mPanoView = null;
    protected View mAlbumView = null;
    protected IndoorAlbumCallback mCallback = null;

    public static synchronized IndoorAlbumPlugin getInstance() {
        IndoorAlbumPlugin indoorAlbumPlugin;
        synchronized (IndoorAlbumPlugin.class) {
            synchronized (mLock) {
                if (mPlugin == null) {
                    mPlugin = new IndoorAlbumPlugin();
                }
            }
            indoorAlbumPlugin = mPlugin;
        }
        return indoorAlbumPlugin;
    }

    public void init() {
        try {
            this.mCallback = (IndoorAlbumCallback) Class.forName("com.baidu.panosdk.plugin.indoor.AlbumEntity").newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            this.mCallback = null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            this.mCallback = null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            this.mCallback = null;
        } catch (Exception e4) {
            e4.printStackTrace();
            this.mCallback = null;
        }
    }

    public void init(IndoorAlbumCallback indoorAlbumCallback) {
        synchronized (mLock) {
            this.mCallback = indoorAlbumCallback;
        }
    }

    public boolean hasPlugin() {
        boolean z;
        synchronized (mLock) {
            z = this.mCallback != null;
        }
        return z;
    }

    public void loadAlbumView(PanoramaView panoramaView, IndoorAlbumCallback.EntryInfo entryInfo) {
        synchronized (mLock) {
            clearAlbumView();
            if (entryInfo != null && entryInfo.isCorrect() && panoramaView != null && this.mCallback != null) {
                this.mPanoView = panoramaView;
                this.mAlbumView = this.mCallback.loadAlbumView(this.mPanoView, entryInfo);
                this.mPanoView.removeView(this.mAlbumView);
                this.mPanoView.addView(this.mAlbumView);
            }
        }
    }

    protected void clearAlbumView() {
        if (this.mAlbumView != null) {
            if (this.mPanoView != null) {
                this.mPanoView.removeView(this.mAlbumView);
                this.mPanoView = null;
            }
            this.mAlbumView = null;
        }
    }

    public void setAlbumViewShow(boolean z) {
        synchronized (mLock) {
            if (this.mAlbumView != null) {
                if (z) {
                    this.mAlbumView.setVisibility(0);
                } else {
                    this.mAlbumView.setVisibility(8);
                }
            }
        }
    }

    public void onDestroyView() {
        synchronized (mLock) {
            clearAlbumView();
        }
    }

    public Object getLock() {
        return mLock;
    }
}

package com.baidu.pano.platform.plugin.indooralbum;

import android.view.View;
import com.baidu.lbsapi.panoramaview.PanoramaView;
import com.baidu.pano.platform.plugin.indooralbum.IndoorAlbumCallback;
/* loaded from: classes2.dex */
public class IndoorAlbumPlugin {
    public static Object mLock = new Object();
    public static IndoorAlbumPlugin mPlugin;
    public PanoramaView mPanoView = null;
    public View mAlbumView = null;
    public IndoorAlbumCallback mCallback = null;

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

    public void clearAlbumView() {
        View view = this.mAlbumView;
        if (view != null) {
            PanoramaView panoramaView = this.mPanoView;
            if (panoramaView != null) {
                panoramaView.removeView(view);
                this.mPanoView = null;
            }
            this.mAlbumView = null;
        }
    }

    public Object getLock() {
        return mLock;
    }

    public boolean hasPlugin() {
        boolean z;
        synchronized (mLock) {
            z = this.mCallback != null;
        }
        return z;
    }

    public void init() {
        try {
            this.mCallback = (IndoorAlbumCallback) Class.forName("com.baidu.panosdk.plugin.indoor.AlbumEntity").newInstance();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            this.mCallback = null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            this.mCallback = null;
        } catch (InstantiationException e4) {
            e4.printStackTrace();
            this.mCallback = null;
        } catch (Exception e5) {
            e5.printStackTrace();
            this.mCallback = null;
        }
    }

    public void loadAlbumView(PanoramaView panoramaView, IndoorAlbumCallback.EntryInfo entryInfo) {
        synchronized (mLock) {
            clearAlbumView();
            if (entryInfo != null && entryInfo.isCorrect() && panoramaView != null && this.mCallback != null) {
                this.mPanoView = panoramaView;
                View loadAlbumView = this.mCallback.loadAlbumView(panoramaView, entryInfo);
                this.mAlbumView = loadAlbumView;
                this.mPanoView.removeView(loadAlbumView);
                this.mPanoView.addView(this.mAlbumView);
            }
        }
    }

    public void onDestroyView() {
        synchronized (mLock) {
            clearAlbumView();
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

    public void init(IndoorAlbumCallback indoorAlbumCallback) {
        synchronized (mLock) {
            this.mCallback = indoorAlbumCallback;
        }
    }
}

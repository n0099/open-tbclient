package com.baidu.pano.platform.plugin.indooralbum;

import android.view.View;
import com.baidu.lbsapi.panoramaview.PanoramaView;
/* loaded from: classes2.dex */
public interface IndoorAlbumCallback {

    /* loaded from: classes2.dex */
    public static class EntryInfo {
        public String mExitUid = null;
        public String mEnterPid = null;

        public String getEnterPid() {
            return this.mEnterPid;
        }

        public String getExitUid() {
            return this.mExitUid;
        }

        public boolean isCorrect() {
            return this.mEnterPid != null;
        }

        public EntryInfo setEnterPid(String str) {
            this.mEnterPid = str;
            return this;
        }

        public EntryInfo setExitUid(String str) {
            this.mExitUid = str;
            return this;
        }
    }

    View loadAlbumView(PanoramaView panoramaView, EntryInfo entryInfo);
}

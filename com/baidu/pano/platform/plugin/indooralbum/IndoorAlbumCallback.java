package com.baidu.pano.platform.plugin.indooralbum;

import android.view.View;
import com.baidu.lbsapi.panoramaview.PanoramaView;
/* loaded from: classes5.dex */
public interface IndoorAlbumCallback {
    View loadAlbumView(PanoramaView panoramaView, EntryInfo entryInfo);

    /* loaded from: classes5.dex */
    public static class EntryInfo {
        private String mExitUid = null;
        private String mEnterPid = null;

        public String getExitUid() {
            return this.mExitUid;
        }

        public String getEnterPid() {
            return this.mEnterPid;
        }

        public EntryInfo setExitUid(String str) {
            this.mExitUid = str;
            return this;
        }

        public EntryInfo setEnterPid(String str) {
            this.mEnterPid = str;
            return this;
        }

        public boolean isCorrect() {
            return this.mEnterPid != null;
        }
    }
}

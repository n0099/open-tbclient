package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class v implements MediaScannerConnection.MediaScannerConnectionClient {
    private String acy;
    private MediaScannerConnection afp;
    private String[] afq;
    private String[] afr;
    private boolean afs;
    private a aft;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void uZ();
    }

    public v(Context context) {
        this.mContext = context;
        this.afp = new MediaScannerConnection(this.mContext, this);
    }

    public void dI(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.acy = "image/jpeg";
        if (substring.equals(".gif")) {
            this.acy = "image/gif";
        }
        this.afp.connect();
    }

    public void scanFile(String str, String str2) {
        this.mPath = str;
        this.acy = str2;
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.acy)) {
            this.afp.connect();
            return;
        }
        this.mPath = null;
        this.acy = null;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.acy)) {
            this.afp.scanFile(this.mPath, this.acy);
        }
        if (this.afq != null && this.afr != null && this.afq.length == this.afr.length) {
            int length = this.afq.length;
            for (int i = 0; i < length; i++) {
                this.afp.scanFile(this.afq[i], this.afr[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.acy) && str.equals(this.mPath)) {
            this.afp.disconnect();
            this.mPath = null;
            this.acy = null;
            this.afs = true;
        } else if (this.afq != null && this.afr != null && this.afq.length == this.afr.length) {
            this.length--;
            if (this.length == 0) {
                this.afp.disconnect();
                this.afq = null;
                this.afr = null;
                this.afs = true;
            } else {
                this.afs = false;
            }
        }
        if (this.afs && this.aft != null) {
            this.aft.uZ();
        }
    }
}

package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection afo;
    private String afp;
    private String[] afq;
    private String[] afr;
    private boolean afs;
    private a aft;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void uE();
    }

    public w(Context context) {
        this.mContext = context;
        this.afo = new MediaScannerConnection(this.mContext, this);
    }

    public void dB(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.afp = "image/jpeg";
        if (substring.equals(".gif")) {
            this.afp = "image/gif";
        }
        this.afo.connect();
    }

    public void scanFile(String str, String str2) {
        this.mPath = str;
        this.afp = str2;
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.afp)) {
            this.afo.connect();
            return;
        }
        this.mPath = null;
        this.afp = null;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.afp)) {
            this.afo.scanFile(this.mPath, this.afp);
        }
        if (this.afq != null && this.afr != null && this.afq.length == this.afr.length) {
            int length = this.afq.length;
            for (int i = 0; i < length; i++) {
                this.afo.scanFile(this.afq[i], this.afr[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.afp) && str.equals(this.mPath)) {
            this.afo.disconnect();
            this.mPath = null;
            this.afp = null;
            this.afs = true;
        } else if (this.afq != null && this.afr != null && this.afq.length == this.afr.length) {
            this.length--;
            if (this.length == 0) {
                this.afo.disconnect();
                this.afq = null;
                this.afr = null;
                this.afs = true;
            } else {
                this.afs = false;
            }
        }
        if (this.afs && this.aft != null) {
            this.aft.uE();
        }
    }
}

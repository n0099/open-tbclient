package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class z implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection Xo;
    private String Xp;
    private String[] Xq;
    private String[] Xr;
    private boolean Xs;
    private a Xt;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void tv();
    }

    public z(Context context) {
        this.mContext = context;
        this.Xo = new MediaScannerConnection(this.mContext, this);
    }

    public void dk(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.Xp = "image/jpeg";
        if (substring.equals(".gif")) {
            this.Xp = "image/gif";
        }
        this.Xo.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.Xp)) {
            this.Xo.scanFile(this.mPath, this.Xp);
        }
        if (this.Xq != null && this.Xr != null && this.Xq.length == this.Xr.length) {
            int length = this.Xq.length;
            for (int i = 0; i < length; i++) {
                this.Xo.scanFile(this.Xq[i], this.Xr[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.Xp) && str.equals(this.mPath)) {
            this.Xo.disconnect();
            this.mPath = null;
            this.Xp = null;
            this.Xs = true;
        } else if (this.Xq != null && this.Xr != null && this.Xq.length == this.Xr.length) {
            this.length--;
            if (this.length == 0) {
                this.Xo.disconnect();
                this.Xq = null;
                this.Xr = null;
                this.Xs = true;
            } else {
                this.Xs = false;
            }
        }
        if (this.Xs && this.Xt != null) {
            this.Xt.tv();
        }
    }
}

package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class z implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection Wp;
    private String Wq;
    private String[] Wr;
    private String[] Ws;
    private boolean Wt;
    private a Wu;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void ty();
    }

    public z(Context context) {
        this.mContext = context;
        this.Wp = new MediaScannerConnection(this.mContext, this);
    }

    public void dn(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.Wq = "image/jpeg";
        if (substring.equals(".gif")) {
            this.Wq = "image/gif";
        }
        this.Wp.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.Wq)) {
            this.Wp.scanFile(this.mPath, this.Wq);
        }
        if (this.Wr != null && this.Ws != null && this.Wr.length == this.Ws.length) {
            int length = this.Wr.length;
            for (int i = 0; i < length; i++) {
                this.Wp.scanFile(this.Wr[i], this.Ws[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.Wq) && str.equals(this.mPath)) {
            this.Wp.disconnect();
            this.mPath = null;
            this.Wq = null;
            this.Wt = true;
        } else if (this.Wr != null && this.Ws != null && this.Wr.length == this.Ws.length) {
            this.length--;
            if (this.length == 0) {
                this.Wp.disconnect();
                this.Wr = null;
                this.Ws = null;
                this.Wt = true;
            } else {
                this.Wt = false;
            }
        }
        if (this.Wt && this.Wu != null) {
            this.Wu.ty();
        }
    }
}

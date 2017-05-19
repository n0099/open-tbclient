package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class y implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection aes;
    private String aet;
    private String[] aeu;
    private String[] aev;
    private boolean aew;
    private a aex;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void uH();
    }

    public y(Context context) {
        this.mContext = context;
        this.aes = new MediaScannerConnection(this.mContext, this);
    }

    /* renamed from: do  reason: not valid java name */
    public void m11do(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.aet = "image/jpeg";
        if (substring.equals(".gif")) {
            this.aet = "image/gif";
        }
        this.aes.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aet)) {
            this.aes.scanFile(this.mPath, this.aet);
        }
        if (this.aeu != null && this.aev != null && this.aeu.length == this.aev.length) {
            int length = this.aeu.length;
            for (int i = 0; i < length; i++) {
                this.aes.scanFile(this.aeu[i], this.aev[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aet) && str.equals(this.mPath)) {
            this.aes.disconnect();
            this.mPath = null;
            this.aet = null;
            this.aew = true;
        } else if (this.aeu != null && this.aev != null && this.aeu.length == this.aev.length) {
            this.length--;
            if (this.length == 0) {
                this.aes.disconnect();
                this.aeu = null;
                this.aev = null;
                this.aew = true;
            } else {
                this.aew = false;
            }
        }
        if (this.aew && this.aex != null) {
            this.aex.uH();
        }
    }
}

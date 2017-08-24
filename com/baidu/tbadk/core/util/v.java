package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class v implements MediaScannerConnection.MediaScannerConnectionClient {
    private String adX;
    private MediaScannerConnection agM;
    private String[] agN;
    private String[] agO;
    private boolean agP;
    private a agQ;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void vk();
    }

    public v(Context context) {
        this.mContext = context;
        this.agM = new MediaScannerConnection(this.mContext, this);
    }

    public void dS(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.adX = "image/jpeg";
        if (substring.equals(".gif")) {
            this.adX = "image/gif";
        }
        this.agM.connect();
    }

    public void scanFile(String str, String str2) {
        this.mPath = str;
        this.adX = str2;
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.adX)) {
            this.agM.connect();
            return;
        }
        this.mPath = null;
        this.adX = null;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.adX)) {
            this.agM.scanFile(this.mPath, this.adX);
        }
        if (this.agN != null && this.agO != null && this.agN.length == this.agO.length) {
            int length = this.agN.length;
            for (int i = 0; i < length; i++) {
                this.agM.scanFile(this.agN[i], this.agO[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.adX) && str.equals(this.mPath)) {
            this.agM.disconnect();
            this.mPath = null;
            this.adX = null;
            this.agP = true;
        } else if (this.agN != null && this.agO != null && this.agN.length == this.agO.length) {
            this.length--;
            if (this.length == 0) {
                this.agM.disconnect();
                this.agN = null;
                this.agO = null;
                this.agP = true;
            } else {
                this.agP = false;
            }
        }
        if (this.agP && this.agQ != null) {
            this.agQ.vk();
        }
    }
}

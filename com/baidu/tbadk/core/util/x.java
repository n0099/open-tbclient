package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class x implements MediaScannerConnection.MediaScannerConnectionClient {
    private a ZA;
    private MediaScannerConnection Zv;
    private String Zw;
    private String[] Zx;
    private String[] Zy;
    private boolean Zz;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void uA();
    }

    public x(Context context) {
        this.mContext = context;
        this.Zv = new MediaScannerConnection(this.mContext, this);
    }

    public void dq(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.Zw = "image/jpeg";
        if (substring.equals(".gif")) {
            this.Zw = "image/gif";
        }
        this.Zv.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.Zw)) {
            this.Zv.scanFile(this.mPath, this.Zw);
        }
        if (this.Zx != null && this.Zy != null && this.Zx.length == this.Zy.length) {
            int length = this.Zx.length;
            for (int i = 0; i < length; i++) {
                this.Zv.scanFile(this.Zx[i], this.Zy[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.Zw) && str.equals(this.mPath)) {
            this.Zv.disconnect();
            this.mPath = null;
            this.Zw = null;
            this.Zz = true;
        } else if (this.Zx != null && this.Zy != null && this.Zx.length == this.Zy.length) {
            this.length--;
            if (this.length == 0) {
                this.Zv.disconnect();
                this.Zx = null;
                this.Zy = null;
                this.Zz = true;
            } else {
                this.Zz = false;
            }
        }
        if (this.Zz && this.ZA != null) {
            this.ZA.uA();
        }
    }
}

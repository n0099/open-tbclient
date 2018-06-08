package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class x implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection apl;
    private String apm;
    private String[] apn;
    private String[] apo;
    private boolean apq;
    private a apr;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void yH();
    }

    public x(Context context) {
        this.mContext = context;
        this.apl = new MediaScannerConnection(this.mContext, this);
    }

    public void ex(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.apm = "image/jpeg";
        if (substring.equals(".gif")) {
            this.apm = "image/gif";
        }
        this.apl.connect();
    }

    public void ey(String str) {
        this.mPath = str;
        this.apm = ez(str);
        this.apl.connect();
    }

    private String ez(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("mp4") && !lowerCase.endsWith("mpeg4") && lowerCase.endsWith("3gp")) {
            return "video/3gp";
        }
        return "video/mp4";
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.apm)) {
            this.apl.scanFile(this.mPath, this.apm);
        }
        if (this.apn != null && this.apo != null && this.apn.length == this.apo.length) {
            int length = this.apn.length;
            for (int i = 0; i < length; i++) {
                this.apl.scanFile(this.apn[i], this.apo[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.apm) && str.equals(this.mPath)) {
            this.apl.disconnect();
            this.mPath = null;
            this.apm = null;
            this.apq = true;
        } else if (this.apn != null && this.apo != null && this.apn.length == this.apo.length) {
            this.length--;
            if (this.length == 0) {
                this.apl.disconnect();
                this.apn = null;
                this.apo = null;
                this.apq = true;
            } else {
                this.apq = false;
            }
        }
        if (this.apq && this.apr != null) {
            this.apr.yH();
        }
    }
}

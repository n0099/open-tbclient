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
    private String wf;

    /* loaded from: classes.dex */
    public interface a {
        void yM();
    }

    public x(Context context) {
        this.mContext = context;
        this.apl = new MediaScannerConnection(this.mContext, this);
    }

    public void ey(String str) {
        this.wf = str;
        String substring = this.wf.substring(this.wf.lastIndexOf("."));
        this.apm = "image/jpeg";
        if (substring.equals(".gif")) {
            this.apm = "image/gif";
        }
        this.apl.connect();
    }

    public void ez(String str) {
        this.wf = str;
        this.apm = eA(str);
        this.apl.connect();
    }

    private String eA(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("mp4") && !lowerCase.endsWith("mpeg4") && lowerCase.endsWith("3gp")) {
            return "video/3gp";
        }
        return "video/mp4";
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.wf) && !TextUtils.isEmpty(this.apm)) {
            this.apl.scanFile(this.wf, this.apm);
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
        if (!TextUtils.isEmpty(this.wf) && !TextUtils.isEmpty(this.apm) && str.equals(this.wf)) {
            this.apl.disconnect();
            this.wf = null;
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
            this.apr.yM();
        }
    }
}

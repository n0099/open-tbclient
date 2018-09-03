package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class x implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection apm;
    private String apn;
    private String[] apo;
    private String[] apq;
    private boolean apr;
    private a aps;
    private int length;
    private Context mContext;
    private String wg;

    /* loaded from: classes.dex */
    public interface a {
        void yK();
    }

    public x(Context context) {
        this.mContext = context;
        this.apm = new MediaScannerConnection(this.mContext, this);
    }

    public void ey(String str) {
        this.wg = str;
        String substring = this.wg.substring(this.wg.lastIndexOf("."));
        this.apn = "image/jpeg";
        if (substring.equals(".gif")) {
            this.apn = "image/gif";
        }
        this.apm.connect();
    }

    public void ez(String str) {
        this.wg = str;
        this.apn = eA(str);
        this.apm.connect();
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
        if (!TextUtils.isEmpty(this.wg) && !TextUtils.isEmpty(this.apn)) {
            this.apm.scanFile(this.wg, this.apn);
        }
        if (this.apo != null && this.apq != null && this.apo.length == this.apq.length) {
            int length = this.apo.length;
            for (int i = 0; i < length; i++) {
                this.apm.scanFile(this.apo[i], this.apq[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.wg) && !TextUtils.isEmpty(this.apn) && str.equals(this.wg)) {
            this.apm.disconnect();
            this.wg = null;
            this.apn = null;
            this.apr = true;
        } else if (this.apo != null && this.apq != null && this.apo.length == this.apq.length) {
            this.length--;
            if (this.length == 0) {
                this.apm.disconnect();
                this.apo = null;
                this.apq = null;
                this.apr = true;
            } else {
                this.apr = false;
            }
        }
        if (this.apr && this.aps != null) {
            this.aps.yK();
        }
    }
}

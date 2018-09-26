package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection arK;
    private String arL;
    private String[] arM;
    private String[] arN;
    private boolean arO;
    private a arP;
    private int length;
    private Context mContext;
    private String yz;

    /* loaded from: classes.dex */
    public interface a {
        void zP();
    }

    public w(Context context) {
        this.mContext = context;
        this.arK = new MediaScannerConnection(this.mContext, this);
    }

    public void eQ(String str) {
        this.yz = str;
        String substring = this.yz.substring(this.yz.lastIndexOf("."));
        this.arL = "image/jpeg";
        if (substring.equals(".gif")) {
            this.arL = "image/gif";
        }
        this.arK.connect();
    }

    public void eR(String str) {
        this.yz = str;
        this.arL = eS(str);
        this.arK.connect();
    }

    private String eS(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("mp4") && !lowerCase.endsWith("mpeg4") && lowerCase.endsWith("3gp")) {
            return "video/3gp";
        }
        return "video/mp4";
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.yz) && !TextUtils.isEmpty(this.arL)) {
            this.arK.scanFile(this.yz, this.arL);
        }
        if (this.arM != null && this.arN != null && this.arM.length == this.arN.length) {
            int length = this.arM.length;
            for (int i = 0; i < length; i++) {
                this.arK.scanFile(this.arM[i], this.arN[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.yz) && !TextUtils.isEmpty(this.arL) && str.equals(this.yz)) {
            this.arK.disconnect();
            this.yz = null;
            this.arL = null;
            this.arO = true;
        } else if (this.arM != null && this.arN != null && this.arM.length == this.arN.length) {
            this.length--;
            if (this.length == 0) {
                this.arK.disconnect();
                this.arM = null;
                this.arN = null;
                this.arO = true;
            } else {
                this.arO = false;
            }
        }
        if (this.arO && this.arP != null) {
            this.arP.zP();
        }
    }
}

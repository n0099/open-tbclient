package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection aga;
    private String agb;
    private String[] agc;
    private String[] agd;
    private boolean agf;
    private a agg;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void uL();
    }

    public w(Context context) {
        this.mContext = context;
        this.aga = new MediaScannerConnection(this.mContext, this);
    }

    public void dH(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.agb = "image/jpeg";
        if (substring.equals(".gif")) {
            this.agb = "image/gif";
        }
        this.aga.connect();
    }

    public void dI(String str) {
        this.mPath = str;
        this.agb = dJ(str);
        this.aga.connect();
    }

    private String dJ(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("mp4") && !lowerCase.endsWith("mpeg4") && lowerCase.endsWith("3gp")) {
            return "video/3gp";
        }
        return "video/mp4";
    }

    public void scanFile(String str, String str2) {
        this.mPath = str;
        this.agb = str2;
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.agb)) {
            this.aga.connect();
            return;
        }
        this.mPath = null;
        this.agb = null;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.agb)) {
            this.aga.scanFile(this.mPath, this.agb);
        }
        if (this.agc != null && this.agd != null && this.agc.length == this.agd.length) {
            int length = this.agc.length;
            for (int i = 0; i < length; i++) {
                this.aga.scanFile(this.agc[i], this.agd[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.agb) && str.equals(this.mPath)) {
            this.aga.disconnect();
            this.mPath = null;
            this.agb = null;
            this.agf = true;
        } else if (this.agc != null && this.agd != null && this.agc.length == this.agd.length) {
            this.length--;
            if (this.length == 0) {
                this.aga.disconnect();
                this.agc = null;
                this.agd = null;
                this.agf = true;
            } else {
                this.agf = false;
            }
        }
        if (this.agf && this.agg != null) {
            this.agg.uL();
        }
    }
}

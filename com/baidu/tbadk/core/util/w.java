package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection agd;
    private String agf;
    private String[] agg;
    private String[] agh;
    private boolean agi;
    private a agj;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void uL();
    }

    public w(Context context) {
        this.mContext = context;
        this.agd = new MediaScannerConnection(this.mContext, this);
    }

    public void dH(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.agf = "image/jpeg";
        if (substring.equals(".gif")) {
            this.agf = "image/gif";
        }
        this.agd.connect();
    }

    public void dI(String str) {
        this.mPath = str;
        this.agf = dJ(str);
        this.agd.connect();
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
        this.agf = str2;
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.agf)) {
            this.agd.connect();
            return;
        }
        this.mPath = null;
        this.agf = null;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.agf)) {
            this.agd.scanFile(this.mPath, this.agf);
        }
        if (this.agg != null && this.agh != null && this.agg.length == this.agh.length) {
            int length = this.agg.length;
            for (int i = 0; i < length; i++) {
                this.agd.scanFile(this.agg[i], this.agh[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.agf) && str.equals(this.mPath)) {
            this.agd.disconnect();
            this.mPath = null;
            this.agf = null;
            this.agi = true;
        } else if (this.agg != null && this.agh != null && this.agg.length == this.agh.length) {
            this.length--;
            if (this.length == 0) {
                this.agd.disconnect();
                this.agg = null;
                this.agh = null;
                this.agi = true;
            } else {
                this.agi = false;
            }
        }
        if (this.agi && this.agj != null) {
            this.agj.uL();
        }
    }
}

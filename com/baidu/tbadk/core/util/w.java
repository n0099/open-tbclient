package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private String ade;
    private MediaScannerConnection agd;
    private String[] agf;
    private String[] agg;
    private boolean agh;
    private a agi;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void vh();
    }

    public w(Context context) {
        this.mContext = context;
        this.agd = new MediaScannerConnection(this.mContext, this);
    }

    public void dJ(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.ade = "image/jpeg";
        if (substring.equals(".gif")) {
            this.ade = "image/gif";
        }
        this.agd.connect();
    }

    public void scanFile(String str, String str2) {
        this.mPath = str;
        this.ade = str2;
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.ade)) {
            this.agd.connect();
            return;
        }
        this.mPath = null;
        this.ade = null;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.ade)) {
            this.agd.scanFile(this.mPath, this.ade);
        }
        if (this.agf != null && this.agg != null && this.agf.length == this.agg.length) {
            int length = this.agf.length;
            for (int i = 0; i < length; i++) {
                this.agd.scanFile(this.agf[i], this.agg[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.ade) && str.equals(this.mPath)) {
            this.agd.disconnect();
            this.mPath = null;
            this.ade = null;
            this.agh = true;
        } else if (this.agf != null && this.agg != null && this.agf.length == this.agg.length) {
            this.length--;
            if (this.length == 0) {
                this.agd.disconnect();
                this.agf = null;
                this.agg = null;
                this.agh = true;
            } else {
                this.agh = false;
            }
        }
        if (this.agh && this.agi != null) {
            this.agi.vh();
        }
    }
}

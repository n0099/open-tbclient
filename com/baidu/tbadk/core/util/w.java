package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private String ade;
    private MediaScannerConnection agf;
    private String[] agg;
    private String[] agh;
    private boolean agi;
    private a agj;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void vh();
    }

    public w(Context context) {
        this.mContext = context;
        this.agf = new MediaScannerConnection(this.mContext, this);
    }

    public void dJ(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.ade = "image/jpeg";
        if (substring.equals(".gif")) {
            this.ade = "image/gif";
        }
        this.agf.connect();
    }

    public void scanFile(String str, String str2) {
        this.mPath = str;
        this.ade = str2;
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.ade)) {
            this.agf.connect();
            return;
        }
        this.mPath = null;
        this.ade = null;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.ade)) {
            this.agf.scanFile(this.mPath, this.ade);
        }
        if (this.agg != null && this.agh != null && this.agg.length == this.agh.length) {
            int length = this.agg.length;
            for (int i = 0; i < length; i++) {
                this.agf.scanFile(this.agg[i], this.agh[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.ade) && str.equals(this.mPath)) {
            this.agf.disconnect();
            this.mPath = null;
            this.ade = null;
            this.agi = true;
        } else if (this.agg != null && this.agh != null && this.agg.length == this.agh.length) {
            this.length--;
            if (this.length == 0) {
                this.agf.disconnect();
                this.agg = null;
                this.agh = null;
                this.agi = true;
            } else {
                this.agi = false;
            }
        }
        if (this.agi && this.agj != null) {
            this.agj.vh();
        }
    }
}

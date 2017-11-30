package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection agh;
    private String agi;
    private String[] agj;
    private String[] agk;
    private boolean agl;
    private a agm;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void uO();
    }

    public w(Context context) {
        this.mContext = context;
        this.agh = new MediaScannerConnection(this.mContext, this);
    }

    public void dH(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.agi = "image/jpeg";
        if (substring.equals(".gif")) {
            this.agi = "image/gif";
        }
        this.agh.connect();
    }

    public void dI(String str) {
        this.mPath = str;
        this.agi = dJ(str);
        this.agh.connect();
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
        this.agi = str2;
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.agi)) {
            this.agh.connect();
            return;
        }
        this.mPath = null;
        this.agi = null;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.agi)) {
            this.agh.scanFile(this.mPath, this.agi);
        }
        if (this.agj != null && this.agk != null && this.agj.length == this.agk.length) {
            int length = this.agj.length;
            for (int i = 0; i < length; i++) {
                this.agh.scanFile(this.agj[i], this.agk[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.agi) && str.equals(this.mPath)) {
            this.agh.disconnect();
            this.mPath = null;
            this.agi = null;
            this.agl = true;
        } else if (this.agj != null && this.agk != null && this.agj.length == this.agk.length) {
            this.length--;
            if (this.length == 0) {
                this.agh.disconnect();
                this.agj = null;
                this.agk = null;
                this.agl = true;
            } else {
                this.agl = false;
            }
        }
        if (this.agl && this.agm != null) {
            this.agm.uO();
        }
    }
}

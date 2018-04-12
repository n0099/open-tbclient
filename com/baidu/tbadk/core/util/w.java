package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.ar.util.Constants;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection ahf;
    private String ahg;
    private String[] ahh;
    private String[] ahi;
    private boolean ahj;
    private a ahk;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void vh();
    }

    public w(Context context) {
        this.mContext = context;
        this.ahf = new MediaScannerConnection(this.mContext, this);
    }

    public void dX(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf(Constants.DOT));
        this.ahg = "image/jpeg";
        if (substring.equals(".gif")) {
            this.ahg = "image/gif";
        }
        this.ahf.connect();
    }

    public void dY(String str) {
        this.mPath = str;
        this.ahg = dZ(str);
        this.ahf.connect();
    }

    private String dZ(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("mp4") && !lowerCase.endsWith("mpeg4") && lowerCase.endsWith("3gp")) {
            return "video/3gp";
        }
        return "video/mp4";
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.ahg)) {
            this.ahf.scanFile(this.mPath, this.ahg);
        }
        if (this.ahh != null && this.ahi != null && this.ahh.length == this.ahi.length) {
            int length = this.ahh.length;
            for (int i = 0; i < length; i++) {
                this.ahf.scanFile(this.ahh[i], this.ahi[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.ahg) && str.equals(this.mPath)) {
            this.ahf.disconnect();
            this.mPath = null;
            this.ahg = null;
            this.ahj = true;
        } else if (this.ahh != null && this.ahi != null && this.ahh.length == this.ahi.length) {
            this.length--;
            if (this.length == 0) {
                this.ahf.disconnect();
                this.ahh = null;
                this.ahi = null;
                this.ahj = true;
            } else {
                this.ahj = false;
            }
        }
        if (this.ahj && this.ahk != null) {
            this.ahk.vh();
        }
    }
}

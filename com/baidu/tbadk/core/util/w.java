package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.ar.util.Constants;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection aVV;
    private String aVW;
    private String[] aVX;
    private String[] aVY;
    private boolean aVZ;
    private a aWa;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void Cx();
    }

    public w(Context context) {
        this.mContext = context;
        this.aVV = new MediaScannerConnection(this.mContext, this);
    }

    public void ef(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf(Constants.DOT));
        this.aVW = "image/jpeg";
        if (substring.equals(".gif")) {
            this.aVW = "image/gif";
        }
        this.aVV.connect();
    }

    public void eg(String str) {
        this.mPath = str;
        this.aVW = eh(str);
        this.aVV.connect();
    }

    private String eh(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("mp4") && !lowerCase.endsWith("mpeg4") && lowerCase.endsWith("3gp")) {
            return "video/3gp";
        }
        return "video/mp4";
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aVW)) {
            this.aVV.scanFile(this.mPath, this.aVW);
        }
        if (this.aVX != null && this.aVY != null && this.aVX.length == this.aVY.length) {
            int length = this.aVX.length;
            for (int i = 0; i < length; i++) {
                this.aVV.scanFile(this.aVX[i], this.aVY[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aVW) && str.equals(this.mPath)) {
            this.aVV.disconnect();
            this.mPath = null;
            this.aVW = null;
            this.aVZ = true;
        } else if (this.aVX != null && this.aVY != null && this.aVX.length == this.aVY.length) {
            this.length--;
            if (this.length == 0) {
                this.aVV.disconnect();
                this.aVX = null;
                this.aVY = null;
                this.aVZ = true;
            } else {
                this.aVZ = false;
            }
        }
        if (this.aVZ && this.aWa != null) {
            this.aWa.Cx();
        }
    }
}

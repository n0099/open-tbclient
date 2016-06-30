package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class z implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection WF;
    private String WG;
    private String[] WH;
    private String[] WI;
    private boolean WJ;
    private a WK;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void tw();
    }

    public z(Context context) {
        this.mContext = context;
        this.WF = new MediaScannerConnection(this.mContext, this);
    }

    public void dl(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.WG = "image/jpeg";
        if (substring.equals(".gif")) {
            this.WG = "image/gif";
        }
        this.WF.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.WG)) {
            this.WF.scanFile(this.mPath, this.WG);
        }
        if (this.WH != null && this.WI != null && this.WH.length == this.WI.length) {
            int length = this.WH.length;
            for (int i = 0; i < length; i++) {
                this.WF.scanFile(this.WH[i], this.WI[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.WG) && str.equals(this.mPath)) {
            this.WF.disconnect();
            this.mPath = null;
            this.WG = null;
            this.WJ = true;
        } else if (this.WH != null && this.WI != null && this.WH.length == this.WI.length) {
            this.length--;
            if (this.length == 0) {
                this.WF.disconnect();
                this.WH = null;
                this.WI = null;
                this.WJ = true;
            } else {
                this.WJ = false;
            }
        }
        if (this.WJ && this.WK != null) {
            this.WK.tw();
        }
    }
}

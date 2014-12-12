package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class ab implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection Il;
    private String[] Im;
    private String[] In;
    private boolean Io;
    private ac Ip;
    private int length;
    private Context mContext;
    private String mMimeType;
    private String mPath;

    public ab(Context context) {
        this.mContext = context;
        this.Il = new MediaScannerConnection(this.mContext, this);
    }

    public void cy(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf("."));
        this.mMimeType = "image/jpeg";
        if (substring.equals(".gif")) {
            this.mMimeType = "image/gif";
        }
        this.Il.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType)) {
            this.Il.scanFile(this.mPath, this.mMimeType);
        }
        if (this.Im != null && this.In != null && this.Im.length == this.In.length) {
            int length = this.Im.length;
            for (int i = 0; i < length; i++) {
                this.Il.scanFile(this.Im[i], this.In[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType) && str.equals(this.mPath)) {
            this.Il.disconnect();
            this.mPath = null;
            this.mMimeType = null;
            this.Io = true;
        } else if (this.Im != null && this.In != null && this.Im.length == this.In.length) {
            this.length--;
            if (this.length == 0) {
                this.Il.disconnect();
                this.Im = null;
                this.In = null;
                this.Io = true;
            } else {
                this.Io = false;
            }
        }
        if (this.Io && this.Ip != null) {
            this.Ip.oU();
        }
    }
}

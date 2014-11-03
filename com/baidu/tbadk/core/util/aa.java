package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class aa implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection DY;
    private String DZ;
    private String[] Ea;
    private String[] Eb;
    private boolean Ec;
    private ab Ed;
    private String dM;
    private int length;
    private Context mContext;

    public aa(Context context) {
        this.mContext = context;
        this.DY = new MediaScannerConnection(this.mContext, this);
    }

    public void bF(String str) {
        this.dM = str;
        String substring = this.dM.substring(this.dM.lastIndexOf("."));
        this.DZ = "image/jpeg";
        if (substring.equals(".gif")) {
            this.DZ = "image/gif";
        }
        this.DY.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.dM) && !TextUtils.isEmpty(this.DZ)) {
            this.DY.scanFile(this.dM, this.DZ);
        }
        if (this.Ea != null && this.Eb != null && this.Ea.length == this.Eb.length) {
            int length = this.Ea.length;
            for (int i = 0; i < length; i++) {
                this.DY.scanFile(this.Ea[i], this.Eb[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.dM) && !TextUtils.isEmpty(this.DZ) && str.equals(this.dM)) {
            this.DY.disconnect();
            this.dM = null;
            this.DZ = null;
            this.Ec = true;
        } else if (this.Ea != null && this.Eb != null && this.Ea.length == this.Eb.length) {
            this.length--;
            if (this.length == 0) {
                this.DY.disconnect();
                this.Ea = null;
                this.Eb = null;
                this.Ec = true;
            } else {
                this.Ec = false;
            }
        }
        if (this.Ec && this.Ed != null) {
            this.Ed.ma();
        }
    }
}

package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class aa implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection DX;
    private String DY;
    private String[] DZ;
    private String[] Ea;
    private boolean Eb;
    private ab Ec;
    private String dM;
    private int length;
    private Context mContext;

    public aa(Context context) {
        this.mContext = context;
        this.DX = new MediaScannerConnection(this.mContext, this);
    }

    public void bF(String str) {
        this.dM = str;
        String substring = this.dM.substring(this.dM.lastIndexOf("."));
        this.DY = "image/jpeg";
        if (substring.equals(".gif")) {
            this.DY = "image/gif";
        }
        this.DX.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.dM) && !TextUtils.isEmpty(this.DY)) {
            this.DX.scanFile(this.dM, this.DY);
        }
        if (this.DZ != null && this.Ea != null && this.DZ.length == this.Ea.length) {
            int length = this.DZ.length;
            for (int i = 0; i < length; i++) {
                this.DX.scanFile(this.DZ[i], this.Ea[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.dM) && !TextUtils.isEmpty(this.DY) && str.equals(this.dM)) {
            this.DX.disconnect();
            this.dM = null;
            this.DY = null;
            this.Eb = true;
        } else if (this.DZ != null && this.Ea != null && this.DZ.length == this.Ea.length) {
            this.length--;
            if (this.length == 0) {
                this.DX.disconnect();
                this.DZ = null;
                this.Ea = null;
                this.Eb = true;
            } else {
                this.Eb = false;
            }
        }
        if (this.Eb && this.Ec != null) {
            this.Ec.ma();
        }
    }
}

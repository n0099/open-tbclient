package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.ar.util.Constants;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection aVJ;
    private String aVK;
    private String[] aVL;
    private String[] aVM;
    private boolean aVN;
    private a aVO;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void Cw();
    }

    public w(Context context) {
        this.mContext = context;
        this.aVJ = new MediaScannerConnection(this.mContext, this);
    }

    public void ef(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf(Constants.DOT));
        this.aVK = "image/jpeg";
        if (substring.equals(".gif")) {
            this.aVK = "image/gif";
        }
        this.aVJ.connect();
    }

    public void eg(String str) {
        this.mPath = str;
        this.aVK = eh(str);
        this.aVJ.connect();
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
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aVK)) {
            this.aVJ.scanFile(this.mPath, this.aVK);
        }
        if (this.aVL != null && this.aVM != null && this.aVL.length == this.aVM.length) {
            int length = this.aVL.length;
            for (int i = 0; i < length; i++) {
                this.aVJ.scanFile(this.aVL[i], this.aVM[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aVK) && str.equals(this.mPath)) {
            this.aVJ.disconnect();
            this.mPath = null;
            this.aVK = null;
            this.aVN = true;
        } else if (this.aVL != null && this.aVM != null && this.aVL.length == this.aVM.length) {
            this.length--;
            if (this.length == 0) {
                this.aVJ.disconnect();
                this.aVL = null;
                this.aVM = null;
                this.aVN = true;
            } else {
                this.aVN = false;
            }
        }
        if (this.aVN && this.aVO != null) {
            this.aVO.Cw();
        }
    }
}

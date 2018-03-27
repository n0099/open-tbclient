package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.ar.util.Constants;
/* loaded from: classes.dex */
public class w implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection aVL;
    private String aVM;
    private String[] aVN;
    private String[] aVO;
    private boolean aVP;
    private a aVQ;
    private int length;
    private Context mContext;
    private String mPath;

    /* loaded from: classes.dex */
    public interface a {
        void Cx();
    }

    public w(Context context) {
        this.mContext = context;
        this.aVL = new MediaScannerConnection(this.mContext, this);
    }

    public void ef(String str) {
        this.mPath = str;
        String substring = this.mPath.substring(this.mPath.lastIndexOf(Constants.DOT));
        this.aVM = "image/jpeg";
        if (substring.equals(".gif")) {
            this.aVM = "image/gif";
        }
        this.aVL.connect();
    }

    public void eg(String str) {
        this.mPath = str;
        this.aVM = eh(str);
        this.aVL.connect();
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
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aVM)) {
            this.aVL.scanFile(this.mPath, this.aVM);
        }
        if (this.aVN != null && this.aVO != null && this.aVN.length == this.aVO.length) {
            int length = this.aVN.length;
            for (int i = 0; i < length; i++) {
                this.aVL.scanFile(this.aVN[i], this.aVO[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.aVM) && str.equals(this.mPath)) {
            this.aVL.disconnect();
            this.mPath = null;
            this.aVM = null;
            this.aVP = true;
        } else if (this.aVN != null && this.aVO != null && this.aVN.length == this.aVO.length) {
            this.length--;
            if (this.length == 0) {
                this.aVL.disconnect();
                this.aVN = null;
                this.aVO = null;
                this.aVP = true;
            } else {
                this.aVP = false;
            }
        }
        if (this.aVP && this.aVQ != null) {
            this.aVQ.Cx();
        }
    }
}

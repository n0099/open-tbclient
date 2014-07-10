package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class ao implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection a;
    private Context b;
    private String c;
    private String d;
    private String[] e;
    private String[] f;
    private int g;
    private boolean h;
    private ap i;

    public ao(Context context) {
        this.b = context;
        this.a = new MediaScannerConnection(this.b, this);
    }

    public void a(String str) {
        this.c = str;
        String substring = this.c.substring(this.c.lastIndexOf("."));
        this.d = "image/jpeg";
        if (substring.equals(".gif")) {
            this.d = "image/gif";
        }
        this.a.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d)) {
            this.a.scanFile(this.c, this.d);
        }
        if (this.e != null && this.f != null && this.e.length == this.f.length) {
            int length = this.e.length;
            for (int i = 0; i < length; i++) {
                this.a.scanFile(this.e[i], this.f[i]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (!TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d) && str.equals(this.c)) {
            this.a.disconnect();
            this.c = null;
            this.d = null;
            this.h = true;
        } else if (this.e != null && this.f != null && this.e.length == this.f.length) {
            this.g--;
            if (this.g == 0) {
                this.a.disconnect();
                this.e = null;
                this.f = null;
                this.h = true;
            } else {
                this.h = false;
            }
        }
        if (this.h && this.i != null) {
            this.i.a();
        }
    }
}

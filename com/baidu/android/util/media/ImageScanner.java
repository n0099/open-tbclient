package com.baidu.android.util.media;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
/* loaded from: classes19.dex */
public final class ImageScanner {

    /* loaded from: classes19.dex */
    public interface OnScanCompletedListener {
        void onScanCompleted(String str, Uri uri);
    }

    private ImageScanner() {
    }

    public static void scanImageFiles(Context context, String str, String[] strArr, OnScanCompletedListener onScanCompletedListener) {
        String[] strArr2;
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                File[] listFiles = new File(str).listFiles();
                if (listFiles != null) {
                    strArr2 = new String[listFiles.length];
                    for (int i = 0; i < listFiles.length; i++) {
                        strArr2[i] = listFiles[i].getAbsolutePath();
                    }
                } else {
                    strArr2 = new String[]{str};
                }
                scanFile(context, strArr2, strArr, onScanCompletedListener);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
    }

    public static void scanFile(Context context, String[] strArr, String[] strArr2, OnScanCompletedListener onScanCompletedListener) {
        ClientProxy clientProxy = new ClientProxy(strArr, strArr2, onScanCompletedListener);
        MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(context, clientProxy);
        clientProxy.mConnection = mediaScannerConnection;
        mediaScannerConnection.connect();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public static class ClientProxy implements MediaScannerConnection.MediaScannerConnectionClient {
        final OnScanCompletedListener mClient;
        MediaScannerConnection mConnection;
        final String[] mMimeTypes;
        int mNextPath;
        final String[] mPaths;

        ClientProxy(String[] strArr, String[] strArr2, OnScanCompletedListener onScanCompletedListener) {
            this.mPaths = strArr;
            this.mMimeTypes = strArr2;
            this.mClient = onScanCompletedListener;
        }

        @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
        public void onMediaScannerConnected() {
            scanNextPath();
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(String str, Uri uri) {
            if (this.mClient != null) {
                this.mClient.onScanCompleted(str, uri);
            }
            scanNextPath();
        }

        void scanNextPath() {
            if (this.mNextPath >= this.mPaths.length) {
                this.mConnection.disconnect();
                return;
            }
            this.mConnection.scanFile(this.mPaths[this.mNextPath], this.mMimeTypes != null ? this.mMimeTypes[this.mNextPath] : null);
            this.mNextPath++;
        }
    }
}

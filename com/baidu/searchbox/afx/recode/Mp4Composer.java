package com.baidu.searchbox.afx.recode;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import com.baidu.searchbox.afx.recode.Mp4ComposerEngine;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class Mp4Composer {
    private static final String TAG = "Mp4Composer";
    private ExecutorService mExecutorService;

    /* loaded from: classes3.dex */
    public interface Listener {
        void onCompleted();

        void onFailed(Exception exc);

        void onProgress(float f);
    }

    private ExecutorService getExecutorService() {
        if (this.mExecutorService == null) {
            this.mExecutorService = Executors.newSingleThreadExecutor();
        }
        return this.mExecutorService;
    }

    public void start(String str, String str2, Listener listener) {
        start(new File(str), str2, listener);
    }

    public void start(File file, String str, Listener listener) {
        try {
            start(new FileInputStream(file).getFD(), str, listener);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            if (listener != null) {
                listener.onFailed(e);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            if (listener != null) {
                listener.onFailed(e2);
            }
        }
    }

    public void start(Context context, String str, String str2, Listener listener) {
        try {
            start(context.getAssets().openFd(str), str2, listener);
        } catch (IOException e) {
            e.printStackTrace();
            if (listener != null) {
                listener.onFailed(e);
            }
        }
    }

    public void start(AssetFileDescriptor assetFileDescriptor, String str, Listener listener) {
        start(assetFileDescriptor, (FileDescriptor) null, str, listener);
    }

    public void start(FileDescriptor fileDescriptor, String str, Listener listener) {
        if (fileDescriptor == null || !fileDescriptor.valid()) {
            if (listener != null) {
                listener.onFailed(new RuntimeException("The file descriptor object is invalid."));
                return;
            }
            return;
        }
        start((AssetFileDescriptor) null, fileDescriptor, str, listener);
    }

    private void start(final AssetFileDescriptor assetFileDescriptor, final FileDescriptor fileDescriptor, final String str, final Listener listener) {
        File file = new File(str);
        if (file.exists() && file.length() > 0) {
            if (listener != null) {
                listener.onCompleted();
                return;
            }
            return;
        }
        getExecutorService().execute(new Runnable() { // from class: com.baidu.searchbox.afx.recode.Mp4Composer.1
            @Override // java.lang.Runnable
            public void run() {
                Mp4ComposerEngine mp4ComposerEngine = new Mp4ComposerEngine();
                mp4ComposerEngine.setProgressCallback(new Mp4ComposerEngine.ProgressCallback() { // from class: com.baidu.searchbox.afx.recode.Mp4Composer.1.1
                    @Override // com.baidu.searchbox.afx.recode.Mp4ComposerEngine.ProgressCallback
                    public void onProgress(float f) {
                        if (listener != null) {
                            listener.onProgress(f);
                        }
                    }
                });
                try {
                    if (assetFileDescriptor == null) {
                        mp4ComposerEngine.compose(fileDescriptor, str, Mp4Composer.this.getMp4Info(fileDescriptor));
                    } else {
                        mp4ComposerEngine.compose(assetFileDescriptor, str, Mp4Composer.this.getMp4Info(assetFileDescriptor));
                    }
                    if (listener != null) {
                        listener.onCompleted();
                    }
                    Mp4Composer.this.mExecutorService.shutdown();
                } catch (Exception e) {
                    e.printStackTrace();
                    if (listener != null) {
                        listener.onFailed(e);
                    }
                    Mp4Composer.this.mExecutorService.shutdown();
                }
            }
        });
    }

    public void cancel() {
        getExecutorService().shutdownNow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Mp4Info getMp4Info(AssetFileDescriptor assetFileDescriptor) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        if (assetFileDescriptor.getDeclaredLength() < 0) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor());
        } else {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
        return getMp4Info(mediaMetadataRetriever);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Mp4Info getMp4Info(FileDescriptor fileDescriptor) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(fileDescriptor);
        return getMp4Info(mediaMetadataRetriever);
    }

    private Mp4Info getMp4Info(MediaMetadataRetriever mediaMetadataRetriever) {
        try {
            mediaMetadataRetriever.extractMetadata(12);
            return new Mp4Info(Integer.valueOf(mediaMetadataRetriever.extractMetadata(18)).intValue(), Integer.valueOf(mediaMetadataRetriever.extractMetadata(19)).intValue(), Integer.valueOf(mediaMetadataRetriever.extractMetadata(24)).intValue(), Integer.valueOf(mediaMetadataRetriever.extractMetadata(20)).intValue(), 1000 * Long.valueOf(mediaMetadataRetriever.extractMetadata(9)).longValue());
        } finally {
            if (mediaMetadataRetriever != null) {
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException e) {
                    Log.e(TAG, "Failed to release mediaMetadataRetriever.", e);
                }
            }
        }
    }
}

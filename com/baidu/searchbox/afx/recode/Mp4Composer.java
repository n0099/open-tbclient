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
/* loaded from: classes2.dex */
public class Mp4Composer {
    public static final String TAG = "Mp4Composer";
    public ExecutorService mExecutorService;

    /* loaded from: classes2.dex */
    public interface Listener {
        void onCompleted();

        void onFailed(Exception exc);

        void onProgress(float f2);
    }

    private ExecutorService getExecutorService() {
        if (this.mExecutorService == null) {
            this.mExecutorService = Executors.newSingleThreadExecutor();
        }
        return this.mExecutorService;
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

    public void cancel() {
        getExecutorService().shutdownNow();
    }

    public void start(String str, String str2, Listener listener) {
        start(new File(str), str2, listener);
    }

    public void start(File file, String str, Listener listener) {
        try {
            start(new FileInputStream(file).getFD(), str, listener);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            if (listener != null) {
                listener.onFailed(e2);
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            if (listener != null) {
                listener.onFailed(e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Mp4Info getMp4Info(FileDescriptor fileDescriptor) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(fileDescriptor);
        return getMp4Info(mediaMetadataRetriever);
    }

    public void start(Context context, String str, String str2, Listener listener) {
        try {
            start(context.getAssets().openFd(str), str2, listener);
        } catch (IOException e2) {
            e2.printStackTrace();
            if (listener != null) {
                listener.onFailed(e2);
            }
        }
    }

    private Mp4Info getMp4Info(MediaMetadataRetriever mediaMetadataRetriever) {
        try {
            mediaMetadataRetriever.extractMetadata(12);
            return new Mp4Info(Integer.valueOf(mediaMetadataRetriever.extractMetadata(18)).intValue(), Integer.valueOf(mediaMetadataRetriever.extractMetadata(19)).intValue(), Integer.valueOf(mediaMetadataRetriever.extractMetadata(24)).intValue(), Integer.valueOf(mediaMetadataRetriever.extractMetadata(20)).intValue(), 1000 * Long.valueOf(mediaMetadataRetriever.extractMetadata(9)).longValue());
        } finally {
            if (mediaMetadataRetriever != null) {
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException e2) {
                    Log.e(TAG, "Failed to release mediaMetadataRetriever.", e2);
                }
            }
        }
    }

    public void start(AssetFileDescriptor assetFileDescriptor, String str, Listener listener) {
        start(assetFileDescriptor, (FileDescriptor) null, str, listener);
    }

    public void start(FileDescriptor fileDescriptor, String str, Listener listener) {
        if (fileDescriptor != null && fileDescriptor.valid()) {
            start((AssetFileDescriptor) null, fileDescriptor, str, listener);
        } else if (listener != null) {
            listener.onFailed(new RuntimeException("The file descriptor object is invalid."));
        }
    }

    private void start(final AssetFileDescriptor assetFileDescriptor, final FileDescriptor fileDescriptor, final String str, final Listener listener) {
        File file = new File(str);
        if (!file.exists() || file.length() <= 0) {
            getExecutorService().execute(new Runnable() { // from class: com.baidu.searchbox.afx.recode.Mp4Composer.1
                @Override // java.lang.Runnable
                public void run() {
                    Mp4ComposerEngine mp4ComposerEngine = new Mp4ComposerEngine();
                    mp4ComposerEngine.setProgressCallback(new Mp4ComposerEngine.ProgressCallback() { // from class: com.baidu.searchbox.afx.recode.Mp4Composer.1.1
                        @Override // com.baidu.searchbox.afx.recode.Mp4ComposerEngine.ProgressCallback
                        public void onProgress(float f2) {
                            Listener listener2 = listener;
                            if (listener2 != null) {
                                listener2.onProgress(f2);
                            }
                        }
                    });
                    try {
                        if (assetFileDescriptor == null) {
                            mp4ComposerEngine.compose(fileDescriptor, str, Mp4Composer.this.getMp4Info(fileDescriptor));
                        } else {
                            mp4ComposerEngine.compose(assetFileDescriptor, str, Mp4Composer.this.getMp4Info(assetFileDescriptor));
                        }
                        Listener listener2 = listener;
                        if (listener2 != null) {
                            listener2.onCompleted();
                        }
                        Mp4Composer.this.mExecutorService.shutdown();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        Listener listener3 = listener;
                        if (listener3 != null) {
                            listener3.onFailed(e2);
                        }
                        Mp4Composer.this.mExecutorService.shutdown();
                    }
                }
            });
        } else if (listener != null) {
            listener.onCompleted();
        }
    }
}

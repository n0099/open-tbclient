package com.baidu.mobads.container.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: classes2.dex */
public class FileCacheManager {
    public static final int FILE_CHECK_COMPLETION = 256;
    public static long MAX_CACHA_Byte = 50000000;
    public static final long MAX_CACHE_KB_DEFAULT = 50000000;
    public MyHandler mHandler = new MyHandler(this);
    public IFileCacheCheckListener mListener;

    /* loaded from: classes2.dex */
    public interface IFileCacheCheckListener {
        void checkFileCacheEnd();
    }

    /* loaded from: classes2.dex */
    public static class MyHandler extends Handler {
        public WeakReference<FileCacheManager> mReference;

        public MyHandler(FileCacheManager fileCacheManager) {
            super(Looper.getMainLooper());
            this.mReference = new WeakReference<>(fileCacheManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            FileCacheManager fileCacheManager = this.mReference.get();
            if (fileCacheManager == null) {
                return;
            }
            if (message.what == 256 && fileCacheManager.mListener != null) {
                fileCacheManager.mListener.checkFileCacheEnd();
            }
            super.handleMessage(message);
        }
    }

    public static void setMaxCache(int i2) {
        MAX_CACHA_Byte = i2 * 1000 * 1000;
    }

    public void clear(final String str) {
        TaskScheduler.getInstance().submit(new BaseTask() { // from class: com.baidu.mobads.container.util.FileCacheManager.1
            @Override // com.baidu.mobads.container.executor.BaseTask
            public Object doInBackground() {
                try {
                    File file = new File(str);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File[] listFiles = file.listFiles();
                    if (listFiles == null || listFiles.length <= 0) {
                        if (FileCacheManager.this.mHandler != null) {
                            FileCacheManager.this.mHandler.sendEmptyMessage(256);
                            return null;
                        }
                        return null;
                    }
                    Arrays.sort(listFiles, new Comparator<File>() { // from class: com.baidu.mobads.container.util.FileCacheManager.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        public int compare(File file2, File file3) {
                            return Long.valueOf(file2.lastModified()).compareTo(Long.valueOf(file3.lastModified()));
                        }
                    });
                    long j = 0;
                    for (int length = listFiles.length - 1; length >= 0; length--) {
                        File file2 = listFiles[length];
                        if (file2.exists()) {
                            if (file2.length() + j > FileCacheManager.MAX_CACHA_Byte) {
                                file2.delete();
                            } else {
                                j += file2.length();
                            }
                        }
                    }
                    if (FileCacheManager.this.mHandler != null) {
                        FileCacheManager.this.mHandler.sendEmptyMessage(256);
                        return null;
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
        });
    }

    public void setFileCheckCompletion(IFileCacheCheckListener iFileCacheCheckListener) {
        this.mListener = iFileCacheCheckListener;
    }

    public void updateFileLastModified(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.setLastModified(System.currentTimeMillis());
            }
        } catch (Exception unused) {
        }
    }
}

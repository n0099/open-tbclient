package com.baidu.searchbox.ng.ai.apps.install.decrypt;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
public class FileOutputThread extends HandlerThread {
    static final int WHAT_QUIT = 200;
    static final int WHAT_WORK = 100;
    private File mDstFolder;
    private CountDownLatch mLatch;

    /* loaded from: classes2.dex */
    public static class MessageObj {
        byte[] content;
        String path;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileOutputThread(String str, File file, CountDownLatch countDownLatch) {
        this(str, 0, file, countDownLatch);
    }

    private FileOutputThread(String str, int i, File file, CountDownLatch countDownLatch) {
        super(str, i);
        this.mDstFolder = file;
        this.mLatch = countDownLatch;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler createHandler() {
        return new Handler(getLooper()) { // from class: com.baidu.searchbox.ng.ai.apps.install.decrypt.FileOutputThread.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 100) {
                    MessageObj messageObj = (MessageObj) message.obj;
                    File file = new File(FileOutputThread.this.mDstFolder + messageObj.path);
                    try {
                        if (!file.exists()) {
                            file.getParentFile().mkdirs();
                            file.createNewFile();
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(messageObj.content);
                        AiAppsFileUtils.closeSafely(fileOutputStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (message.what == 200) {
                    if (FileOutputThread.this.mLatch != null) {
                        FileOutputThread.this.mLatch.countDown();
                    }
                    FileOutputThread.this.quit();
                }
            }
        };
    }
}

package com.baidu.mobads.container;

import android.content.Context;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.SdcardUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class XAdPersistData {
    public static String SEPERATOR = ":";
    public static XAdPersistData mInstance;
    public String mDataPath;
    public boolean mDataSync = false;
    public HashMap<String, String> mData = new HashMap<>();

    private void close(Writer writer) {
        try {
            writer.close();
        } catch (Throwable unused) {
        }
    }

    public static XAdPersistData getInstance() {
        if (mInstance == null) {
            synchronized (XAdPersistData.class) {
                mInstance = new XAdPersistData();
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean readData(String str, HashMap<String, String> hashMap) {
        Reader reader = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                close((Reader) null);
                return true;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                String readLine = bufferedReader.readLine();
                int indexOf = readLine.indexOf(SEPERATOR);
                if (indexOf > 0) {
                    hashMap.put(readLine.substring(0, indexOf), readLine.substring(indexOf + 1));
                }
                close(bufferedReader);
                return true;
            } catch (Throwable unused) {
                reader = bufferedReader;
                close(reader);
                return false;
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeData(String str, HashMap<String, String> hashMap) {
        Writer writer = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            try {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    bufferedWriter.write(String.format("%s%s%s\n", entry.getKey(), SEPERATOR, entry.getValue()));
                }
                close(bufferedWriter);
            } catch (Throwable unused) {
                writer = bufferedWriter;
                close(writer);
            }
        } catch (Throwable unused2) {
        }
    }

    public String get(String str) {
        return this.mData.get(str);
    }

    public void put(String str, String str2) {
        this.mData.put(str, str2);
        try {
            TaskScheduler.getInstance().submitWithDelay(new BaseTask() { // from class: com.baidu.mobads.container.XAdPersistData.2
                @Override // com.baidu.mobads.container.executor.BaseTask
                public Object doInBackground() {
                    XAdPersistData xAdPersistData = XAdPersistData.this;
                    xAdPersistData.writeData(xAdPersistData.mDataPath, XAdPersistData.this.mData);
                    return null;
                }
            }, 3L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
        }
    }

    public void sync(final Context context) {
        if (context != null && !this.mDataSync) {
            try {
                TaskScheduler.getInstance().submitWithDelay(new BaseTask() { // from class: com.baidu.mobads.container.XAdPersistData.1
                    @Override // com.baidu.mobads.container.executor.BaseTask
                    public Object doInBackground() {
                        XAdPersistData.this.mDataPath = String.format("%s/%s", SdcardUtils.getStoragePathForDlApk(context), "pdata");
                        XAdPersistData xAdPersistData = XAdPersistData.this;
                        xAdPersistData.mDataSync = xAdPersistData.readData(xAdPersistData.mDataPath, XAdPersistData.this.mData);
                        return null;
                    }
                }, 0L, TimeUnit.MILLISECONDS);
            } catch (Throwable unused) {
            }
        }
    }

    private void close(Reader reader) {
        try {
            reader.close();
        } catch (Throwable unused) {
        }
    }
}

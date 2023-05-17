package com.baidu.searchbox.aideviceperformance.utils;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class FileUtil {
    public void copyDirFromAssets(Context context, String str, String str2) {
        try {
            String[] list = context.getAssets().list(str);
            if (list != null && list.length != 0) {
                new File(str2).mkdirs();
                for (String str3 : list) {
                    copyDirFromAssets(context, str + File.separator + str3, str2 + File.separator + str3);
                }
                return;
            }
            copyFileFromAssets(context, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void copyFileFromAssets(Context context, String str, String str2) throws IOException {
        InputStream open = context.getAssets().open(str);
        File file = new File(str2);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = open.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.flush();
                open.close();
                fileOutputStream.close();
                file.setReadable(true);
                return;
            }
        }
    }

    public boolean deleteFile(File file) {
        File[] listFiles;
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return file.delete();
        }
        for (File file2 : file.listFiles()) {
            deleteFile(file2);
            file2.delete();
        }
        return true;
    }
}

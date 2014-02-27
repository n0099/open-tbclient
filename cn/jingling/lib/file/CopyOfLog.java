package cn.jingling.lib.file;

import android.os.Environment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class CopyOfLog {
    static File SDFile;
    static FileOutputStream fos;
    static File logFile;

    public CopyOfLog() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                SDFile = Environment.getExternalStorageDirectory();
                File file = new File(String.valueOf(SDFile.getAbsolutePath()) + File.separator + "myMatrix.txt");
                logFile = file;
                if (!file.exists()) {
                    logFile.createNewFile();
                }
                fos = new FileOutputStream(logFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void writeArrayAsMatrix(int[] iArr, int i) {
        if (iArr != null && iArr.length != 0) {
            for (int i2 = 0; i2 < iArr.length; i2++) {
                try {
                    fos.write(Integer.toString(iArr[i2]).getBytes());
                    if ((i2 + 1) % i == 0 || i2 + 1 == iArr.length) {
                        fos.write(10);
                    } else {
                        fos.write(44);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }
}

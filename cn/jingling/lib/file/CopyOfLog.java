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
                logFile = new File(String.valueOf(SDFile.getAbsolutePath()) + File.separator + "myMatrix.txt");
                if (!logFile.exists()) {
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

    public void writeArrayAsMatrix(int[] origPixel, int lineLenth) {
        if (origPixel != null && origPixel.length != 0) {
            for (int i = 0; i < origPixel.length; i++) {
                try {
                    fos.write(Integer.toString(origPixel[i]).getBytes());
                    if ((i + 1) % lineLenth == 0 || i + 1 == origPixel.length) {
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

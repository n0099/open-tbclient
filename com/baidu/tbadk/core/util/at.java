package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
/* loaded from: classes.dex */
public class at {
    private static at Va;
    private Drawable[] UW;
    private int UX = -1315344;
    private int UY = -14670029;
    private PorterDuffColorFilter UZ = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);

    private at() {
    }

    public static at sL() {
        synchronized (at.class) {
            if (Va == null) {
                Va = new at();
            }
        }
        return Va;
    }

    public void c(String str, String str2, String str3, String str4, String str5) {
        int i = -1315344;
        int i2 = -14670029;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            com.baidu.tbadk.core.sharedPref.b.rB().putInt("pullview_background_color_day", -1315344);
            com.baidu.tbadk.core.sharedPref.b.rB().putInt("pullview_background_color_night", -14670029);
        } else {
            int i3 = com.baidu.tbadk.core.sharedPref.b.rB().getInt("pullview_background_color_day", -1315344);
            int i4 = com.baidu.tbadk.core.sharedPref.b.rB().getInt("pullview_background_color_night", -14670029);
            try {
                i = Color.parseColor(str4);
            } catch (Exception e) {
            }
            try {
                i2 = Color.parseColor(str5);
            } catch (Exception e2) {
            }
            if (i3 != i || i2 != i4) {
                com.baidu.tbadk.core.sharedPref.b.rB().putInt("pullview_background_color_day", i);
                com.baidu.tbadk.core.sharedPref.b.rB().putInt("pullview_background_color_night", i2);
                this.UX = i;
                this.UY = i2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016204));
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.g.l.hJ().b(new au(this));
            return;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.rB().getString("pull_image_url", "");
        int i5 = com.baidu.adp.lib.g.c.toInt(str3, 0);
        if (str.equals(string)) {
            if (cc(i5)) {
                sM();
                return;
            } else if (sQ()) {
                com.baidu.adp.lib.g.l.hJ().b(new av(this, str2, i5, str));
                return;
            } else {
                c(str, str2, i5);
                return;
            }
        }
        c(str, str2, com.baidu.adp.lib.g.c.toInt(str3, 0));
    }

    public void sM() {
        com.baidu.adp.lib.g.l.hJ().b(new aw(this));
    }

    public AnimationDrawable ca(int i) {
        Drawable[] drawableArr;
        if (this.UW != null) {
            boolean z = i == 1;
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setColorFilter(z ? this.UZ : null);
            for (Drawable drawable : this.UW) {
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
            return animationDrawable;
        }
        return null;
    }

    public int cb(int i) {
        if (i == 1) {
            return this.UY;
        }
        return this.UX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sN() {
        boolean z = false;
        String string = com.baidu.tbadk.core.sharedPref.b.rB().getString("pull_image_url", "");
        int i = com.baidu.tbadk.core.sharedPref.b.rB().getInt("pull_image_num", 0);
        this.UX = com.baidu.tbadk.core.sharedPref.b.rB().getInt("pullview_background_color_day", -1315344);
        this.UY = com.baidu.tbadk.core.sharedPref.b.rB().getInt("pullview_background_color_night", -14670029);
        if (!TextUtils.isEmpty(string)) {
            if (i > 0 && cc(i)) {
                this.UW = new Drawable[i];
                File sO = sO();
                if (sO != null) {
                    File[] listFiles = sO.listFiles();
                    for (int i2 = 1; i2 <= i; i2++) {
                        this.UW[i2 - 1] = a(listFiles, String.valueOf(i2) + ".");
                    }
                }
            }
            if (this.UW != null) {
                Drawable[] drawableArr = this.UW;
                int length = drawableArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z = true;
                        break;
                    }
                    if (drawableArr[i3] == null) {
                        break;
                    }
                    i3++;
                }
            }
            if (!z) {
                this.UW = null;
            }
        } else {
            this.UW = null;
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016203, true));
    }

    private Drawable a(File[] fileArr, String str) {
        File file;
        if (fileArr == null || fileArr.length == 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        int length = fileArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                file = null;
                break;
            }
            file = fileArr[i];
            if (file != null && file.isFile() && file.length() > 0 && file.getName().startsWith(str)) {
                break;
            }
            i++;
        }
        if (file != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 1;
            Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            if (decodeFile != null) {
                return new BitmapDrawable(decodeFile);
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cc(int i) {
        File sO = sO();
        if (sO == null) {
            return false;
        }
        File[] listFiles = sO.listFiles();
        if (listFiles == null || listFiles.length < i) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (b(sO, String.valueOf(i3) + ".")) {
                i2++;
            }
        }
        return i2 == i;
    }

    private boolean b(File file, String str) {
        File[] listFiles;
        for (File file2 : file.listFiles()) {
            if (file2.exists() && file2.isFile() && !TextUtils.isEmpty(file2.getName()) && file2.getName().startsWith(str) && file2.length() > 0) {
                return true;
            }
        }
        return false;
    }

    private File sO() {
        return p(new File(TbadkCoreApplication.m411getInst().getFilesDir(), "pullImages" + File.separator + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File sP() {
        File file = new File(TbadkCoreApplication.m411getInst().getFilesDir(), "pullImages" + File.separator + "download");
        p(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, "pullFile.zip");
        }
        return null;
    }

    private boolean sQ() {
        File sP = sP();
        return sP != null && sP.exists() && sP.isFile() && sP.length() > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [415=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(File file, String str) {
        FileInputStream fileInputStream;
        String e;
        boolean z = false;
        if (file != null) {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        e = com.baidu.adp.lib.util.ab.e(fileInputStream);
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.v.d(fileInputStream);
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.v.d(fileInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                com.baidu.adp.lib.util.v.d(fileInputStream);
                throw th;
            }
            if (!TextUtils.isEmpty(e)) {
                if (e.equalsIgnoreCase(str)) {
                    com.baidu.adp.lib.util.v.d(fileInputStream);
                    z = true;
                }
            }
            com.baidu.adp.lib.util.v.d(fileInputStream);
        }
        return z;
    }

    private void c(String str, String str2, int i) {
        com.baidu.adp.lib.g.l.hJ().b(new ax(this, str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, int i) {
        sS();
        com.baidu.tbadk.core.sharedPref.b.rB().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.rB().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.rB().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.rB().remove("pullview_background_color_night");
        cJ(str);
        File sP = sP();
        if (c(sP, str2)) {
            com.baidu.tbadk.core.sharedPref.b.rB().putString("pull_image_url", str);
            com.baidu.tbadk.core.sharedPref.b.rB().putInt("pull_image_num", i);
            o(sP);
            sN();
            return;
        }
        deleteDir(sP);
    }

    private void cJ(String str) {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            HttpResponse execute = defaultHttpClient.execute(new HttpGet(str));
            if (execute.getStatusLine().getStatusCode() == 200) {
                h(execute.getEntity().getContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            defaultHttpClient.getConnectionManager().shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(File file) {
        ZipInputStream zipInputStream;
        if (file != null) {
            try {
                zipInputStream = new ZipInputStream(new FileInputStream(file));
                while (true) {
                    try {
                        try {
                            ZipEntry nextEntry = zipInputStream.getNextEntry();
                            if (nextEntry != null) {
                                if (!nextEntry.isDirectory()) {
                                    String name = nextEntry.getName();
                                    if (!TextUtils.isEmpty(name) && name.contains(File.separator)) {
                                        a(name.substring(name.lastIndexOf(File.separator)), zipInputStream);
                                    }
                                }
                            } else {
                                com.baidu.adp.lib.util.v.d(zipInputStream);
                                return;
                            }
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.v.d(zipInputStream);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.util.v.d(zipInputStream);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                zipInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                zipInputStream = null;
                com.baidu.adp.lib.util.v.d(zipInputStream);
                throw th;
            }
        }
    }

    private void a(String str, InputStream inputStream) {
        File sO = sO();
        if (sO != null && inputStream != null) {
            c(inputStream, new File(sO, str));
        }
    }

    private void h(InputStream inputStream) {
        c(inputStream, sP());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sR() {
        File sP = sP();
        if (sP != null && sP.isFile() && sP.exists()) {
            sP.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sS() {
        deleteDir(new File(TbadkCoreApplication.m411getInst().getFilesDir(), "pullImages"));
    }

    private void c(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        if (file != null && inputStream != null) {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    try {
                        byte[] bArr = new byte[512];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read != -1) {
                                fileOutputStream.write(bArr, 0, read);
                            } else {
                                com.baidu.adp.lib.util.v.b(fileOutputStream);
                                return;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.v.b(fileOutputStream);
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.v.b(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                com.baidu.adp.lib.util.v.b(fileOutputStream);
                throw th;
            }
        }
    }

    private File p(File file) {
        if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
            return null;
        }
        return file;
    }

    private void deleteDir(File file) {
        if (file != null) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    deleteDir(file2);
                }
                file.delete();
            }
        }
    }
}

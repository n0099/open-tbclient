package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
public class av {
    private static av Jo;
    private Drawable[] Jm;
    private PorterDuffColorFilter Jn = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);

    private av() {
    }

    public static av po() {
        synchronized (av.class) {
            if (Jo == null) {
                Jo = new av();
            }
        }
        return Jo;
    }

    public void j(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.g.l.ek().b(new aw(this));
            return;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.oc().getString("pull_image_url", "");
        int i = com.baidu.adp.lib.g.c.toInt(str3, 0);
        if (str.equals(string)) {
            if (ca(i)) {
                pp();
                return;
            } else if (pt()) {
                com.baidu.adp.lib.g.l.ek().b(new ax(this, str2, i, str));
                return;
            } else {
                c(str, str2, i);
                return;
            }
        }
        c(str, str2, com.baidu.adp.lib.g.c.toInt(str3, 0));
    }

    public void pp() {
        com.baidu.adp.lib.g.l.ek().b(new ay(this));
    }

    public AnimationDrawable bZ(int i) {
        Drawable[] drawableArr;
        if (this.Jm != null) {
            boolean z = i == 1;
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setColorFilter(z ? this.Jn : null);
            for (Drawable drawable : this.Jm) {
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
            return animationDrawable;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pq() {
        boolean z = false;
        String string = com.baidu.tbadk.core.sharedPref.b.oc().getString("pull_image_url", "");
        int i = com.baidu.tbadk.core.sharedPref.b.oc().getInt("pull_image_num", 0);
        if (!TextUtils.isEmpty(string)) {
            if (i > 0 && ca(i)) {
                this.Jm = new Drawable[i];
                File pr = pr();
                if (pr != null) {
                    File[] listFiles = pr.listFiles();
                    for (int i2 = 1; i2 <= i; i2++) {
                        this.Jm[i2 - 1] = a(listFiles, String.valueOf(i2) + ".");
                    }
                }
            }
            if (this.Jm != null) {
                Drawable[] drawableArr = this.Jm;
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
                this.Jm = null;
            }
        } else {
            this.Jm = null;
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
    public boolean ca(int i) {
        File pr = pr();
        if (pr == null) {
            return false;
        }
        File[] listFiles = pr.listFiles();
        if (listFiles == null || listFiles.length < i) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (b(pr, String.valueOf(i3) + ".")) {
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

    private File pr() {
        return p(new File(TbadkCoreApplication.m255getInst().getFilesDir(), "pullImages" + File.separator + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File ps() {
        File file = new File(TbadkCoreApplication.m255getInst().getFilesDir(), "pullImages" + File.separator + "download");
        p(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, "pullFile.zip");
        }
        return null;
    }

    private boolean pt() {
        File ps = ps();
        return ps != null && ps.exists() && ps.isFile() && ps.length() > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [348=4] */
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
                        e = com.baidu.adp.lib.util.z.e(fileInputStream);
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.t.d(fileInputStream);
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.t.d(fileInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                com.baidu.adp.lib.util.t.d(fileInputStream);
                throw th;
            }
            if (!TextUtils.isEmpty(e)) {
                if (e.equalsIgnoreCase(str)) {
                    com.baidu.adp.lib.util.t.d(fileInputStream);
                    z = true;
                }
            }
            com.baidu.adp.lib.util.t.d(fileInputStream);
        }
        return z;
    }

    private void c(String str, String str2, int i) {
        com.baidu.adp.lib.g.l.ek().b(new az(this, str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, int i) {
        pv();
        com.baidu.tbadk.core.sharedPref.b.oc().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.oc().remove("pull_image_num");
        cA(str);
        File ps = ps();
        if (c(ps, str2)) {
            com.baidu.tbadk.core.sharedPref.b.oc().putString("pull_image_url", str);
            com.baidu.tbadk.core.sharedPref.b.oc().putInt("pull_image_num", i);
            o(ps);
            pq();
            return;
        }
        deleteDir(ps);
    }

    private void cA(String str) {
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
                                com.baidu.adp.lib.util.t.d(zipInputStream);
                                return;
                            }
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.t.d(zipInputStream);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.util.t.d(zipInputStream);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                zipInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                zipInputStream = null;
                com.baidu.adp.lib.util.t.d(zipInputStream);
                throw th;
            }
        }
    }

    private void a(String str, InputStream inputStream) {
        File pr = pr();
        if (pr != null && inputStream != null) {
            c(inputStream, new File(pr, str));
        }
    }

    private void h(InputStream inputStream) {
        c(inputStream, ps());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu() {
        File ps = ps();
        if (ps != null && ps.isFile() && ps.exists()) {
            ps.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pv() {
        deleteDir(new File(TbadkCoreApplication.m255getInst().getFilesDir(), "pullImages"));
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
                                com.baidu.adp.lib.util.t.b(fileOutputStream);
                                return;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.t.b(fileOutputStream);
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.t.b(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                com.baidu.adp.lib.util.t.b(fileOutputStream);
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

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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
/* loaded from: classes.dex */
public class am {
    private static am XF;
    private boolean XA;
    private Drawable[] Xw;
    private a[] Xx;
    private boolean Xz;
    private boolean XB = true;
    private int XC = -1315344;
    private int XD = -14670029;
    private PorterDuffColorFilter XE = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    private int[] Xy = {u.f.listview_pull_refresh01, u.f.listview_pull_refresh02};

    /* loaded from: classes.dex */
    public static class a {
        public Drawable XM;
        public Drawable XN;
    }

    private am() {
        aw(com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("pullview_should_show_3d_loading", this.XB));
    }

    public static am tN() {
        synchronized (am.class) {
            if (XF == null) {
                XF = new am();
            }
        }
        return XF;
    }

    public void b(String str, String str2, String str3, String str4, String str5) {
        int i = -1315344;
        int i2 = -14670029;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            com.baidu.tbadk.core.sharedPref.b.sO().putInt("pullview_background_color_day", -1315344);
            com.baidu.tbadk.core.sharedPref.b.sO().putInt("pullview_background_color_night", -14670029);
        } else {
            int i3 = com.baidu.tbadk.core.sharedPref.b.sO().getInt("pullview_background_color_day", -1315344);
            int i4 = com.baidu.tbadk.core.sharedPref.b.sO().getInt("pullview_background_color_night", -14670029);
            try {
                i = Color.parseColor(str4);
            } catch (Exception e) {
            }
            try {
                i2 = Color.parseColor(str5);
            } catch (Exception e2) {
            }
            if (i3 != i || i2 != i4) {
                com.baidu.tbadk.core.sharedPref.b.sO().putInt("pullview_background_color_day", i);
                com.baidu.tbadk.core.sharedPref.b.sO().putInt("pullview_background_color_night", i2);
                this.XC = i;
                this.XD = i2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE));
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("pullview_should_show_3d_loading", true);
            aw(true);
            com.baidu.adp.lib.h.k.dN().b(new an(this));
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("pullview_should_show_3d_loading", false);
        aw(false);
        String string = com.baidu.tbadk.core.sharedPref.b.sO().getString("pull_image_url", "");
        int g = com.baidu.adp.lib.h.b.g(str3, 0);
        if (str.equals(string)) {
            if (cw(g)) {
                tO();
                return;
            } else if (tS()) {
                com.baidu.adp.lib.h.k.dN().b(new ao(this, str2, g, str));
                return;
            } else {
                b(str, str2, g);
                return;
            }
        }
        b(str, str2, com.baidu.adp.lib.h.b.g(str3, 0));
    }

    public void tO() {
        com.baidu.adp.lib.h.k.dN().b(new ap(this));
    }

    public AnimationDrawable ct(int i) {
        Drawable[] drawableArr;
        if (this.Xw != null) {
            boolean z = i == 1;
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setColorFilter(z ? this.XE : null);
            for (Drawable drawable : this.Xw) {
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
            return animationDrawable;
        }
        return null;
    }

    public AnimationDrawable cu(int i) {
        a[] aVarArr;
        if (this.Xx == null) {
            this.Xx = new a[this.Xy.length];
            for (int i2 = 0; i2 < this.Xy.length; i2++) {
                this.Xx[i2] = new a();
            }
        }
        boolean z = i == 1;
        if (z && !this.Xz) {
            this.Xz = true;
            for (int i3 = 0; i3 < this.Xy.length; i3++) {
                this.Xx[i3].XN = new BitmapDrawable(av.cC(this.Xy[i3]));
            }
        }
        if (!z && !this.XA) {
            this.XA = true;
            for (int i4 = 0; i4 < this.Xy.length; i4++) {
                this.Xx[i4].XM = new BitmapDrawable(av.cC(this.Xy[i4]));
            }
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (a aVar : this.Xx) {
            if (aVar != null) {
                Drawable drawable = z ? aVar.XN : aVar.XM;
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
        }
        return animationDrawable;
    }

    public int cv(int i) {
        if (i == 1) {
            return this.XD;
        }
        return this.XC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tP() {
        boolean z = false;
        String string = com.baidu.tbadk.core.sharedPref.b.sO().getString("pull_image_url", "");
        int i = com.baidu.tbadk.core.sharedPref.b.sO().getInt("pull_image_num", 0);
        this.XC = com.baidu.tbadk.core.sharedPref.b.sO().getInt("pullview_background_color_day", -1315344);
        this.XD = com.baidu.tbadk.core.sharedPref.b.sO().getInt("pullview_background_color_night", -14670029);
        if (!TextUtils.isEmpty(string)) {
            if (i > 0 && cw(i)) {
                this.Xw = new Drawable[i];
                File tQ = tQ();
                if (tQ != null) {
                    File[] listFiles = tQ.listFiles();
                    for (int i2 = 1; i2 <= i; i2++) {
                        this.Xw[i2 - 1] = a(listFiles, String.valueOf(i2) + ".");
                    }
                }
            }
            if (this.Xw != null) {
                Drawable[] drawableArr = this.Xw;
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
                this.Xw = null;
            }
        } else {
            this.Xw = null;
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_PULL_IMAGE_CHANGE, true));
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
    public boolean cw(int i) {
        File tQ = tQ();
        if (tQ == null) {
            return false;
        }
        File[] listFiles = tQ.listFiles();
        if (listFiles == null || listFiles.length < i) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (b(tQ, String.valueOf(i3) + ".")) {
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

    private File tQ() {
        return r(new File(TbadkCoreApplication.m9getInst().getFilesDir(), "pullImages" + File.separator + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File tR() {
        File file = new File(TbadkCoreApplication.m9getInst().getFilesDir(), "pullImages" + File.separator + "download");
        r(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, "pullFile.zip");
        }
        return null;
    }

    private boolean tS() {
        File tR = tR();
        return tR != null && tR.exists() && tR.isFile() && tR.length() > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [480=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(File file, String str) {
        FileInputStream fileInputStream;
        String d;
        boolean z = false;
        if (file != null) {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        d = com.baidu.adp.lib.util.t.d(fileInputStream);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.o.c(fileInputStream);
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.o.c(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                com.baidu.adp.lib.util.o.c(fileInputStream);
                throw th;
            }
            if (!TextUtils.isEmpty(d)) {
                if (d.equalsIgnoreCase(str)) {
                    com.baidu.adp.lib.util.o.c(fileInputStream);
                    z = true;
                }
            }
            com.baidu.adp.lib.util.o.c(fileInputStream);
        }
        return z;
    }

    private void b(String str, String str2, int i) {
        com.baidu.adp.lib.h.k.dN().b(new aq(this, str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, int i) {
        tU();
        com.baidu.tbadk.core.sharedPref.b.sO().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.sO().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.sO().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.sO().remove("pullview_background_color_night");
        dp(str);
        File tR = tR();
        if (c(tR, str2)) {
            com.baidu.tbadk.core.sharedPref.b.sO().putString("pull_image_url", str);
            com.baidu.tbadk.core.sharedPref.b.sO().putInt("pull_image_num", i);
            q(tR);
            tP();
            return;
        }
        deleteDir(tR);
    }

    private void dp(String str) {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            HttpResponse execute = defaultHttpClient.execute(new HttpGet(str));
            if (execute.getStatusLine().getStatusCode() == 200) {
                f(execute.getEntity().getContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            defaultHttpClient.getConnectionManager().shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(File file) {
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
                                com.baidu.adp.lib.util.o.c(zipInputStream);
                                return;
                            }
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.o.c(zipInputStream);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.util.o.c(zipInputStream);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                zipInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                zipInputStream = null;
                com.baidu.adp.lib.util.o.c(zipInputStream);
                throw th;
            }
        }
    }

    private void a(String str, InputStream inputStream) {
        File tQ = tQ();
        if (tQ != null && inputStream != null) {
            b(inputStream, new File(tQ, str));
        }
    }

    private void f(InputStream inputStream) {
        b(inputStream, tR());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tT() {
        File tR = tR();
        if (tR != null && tR.isFile() && tR.exists()) {
            tR.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tU() {
        deleteDir(new File(TbadkCoreApplication.m9getInst().getFilesDir(), "pullImages"));
    }

    private void b(InputStream inputStream, File file) {
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
                                com.baidu.adp.lib.util.o.b((OutputStream) fileOutputStream);
                                return;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.o.b((OutputStream) fileOutputStream);
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.o.b((OutputStream) fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                com.baidu.adp.lib.util.o.b((OutputStream) fileOutputStream);
                throw th;
            }
        }
    }

    private File r(File file) {
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

    public boolean tV() {
        return UtilHelper.detectOpenGLES20(TbadkCoreApplication.m9getInst().getContext()) && this.XB;
    }

    public void aw(boolean z) {
        this.XB = z;
    }
}

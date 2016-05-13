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
import com.baidu.tieba.t;
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
public class al {
    private static al Xn;
    private Drawable[] Xe;
    private a[] Xf;
    private boolean Xh;
    private boolean Xi;
    private boolean Xj = true;
    private int Xk = -1315344;
    private int Xl = -14670029;
    private PorterDuffColorFilter Xm = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    private int[] Xg = {t.f.listview_pull_refresh01, t.f.listview_pull_refresh02};

    /* loaded from: classes.dex */
    public static class a {
        public Drawable Xu;
        public Drawable Xv;
    }

    private al() {
        ay(com.baidu.tbadk.core.sharedPref.b.sR().getBoolean("pullview_should_show_3d_loading", this.Xj));
    }

    public static al tO() {
        synchronized (al.class) {
            if (Xn == null) {
                Xn = new al();
            }
        }
        return Xn;
    }

    public void b(String str, String str2, String str3, String str4, String str5) {
        int i = -1315344;
        int i2 = -14670029;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            com.baidu.tbadk.core.sharedPref.b.sR().putInt("pullview_background_color_day", -1315344);
            com.baidu.tbadk.core.sharedPref.b.sR().putInt("pullview_background_color_night", -14670029);
        } else {
            int i3 = com.baidu.tbadk.core.sharedPref.b.sR().getInt("pullview_background_color_day", -1315344);
            int i4 = com.baidu.tbadk.core.sharedPref.b.sR().getInt("pullview_background_color_night", -14670029);
            try {
                i = Color.parseColor(str4);
            } catch (Exception e) {
            }
            try {
                i2 = Color.parseColor(str5);
            } catch (Exception e2) {
            }
            if (i3 != i || i2 != i4) {
                com.baidu.tbadk.core.sharedPref.b.sR().putInt("pullview_background_color_day", i);
                com.baidu.tbadk.core.sharedPref.b.sR().putInt("pullview_background_color_night", i2);
                this.Xk = i;
                this.Xl = i2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE));
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.sharedPref.b.sR().putBoolean("pullview_should_show_3d_loading", true);
            ay(true);
            com.baidu.adp.lib.h.k.dM().b(new am(this));
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.sR().putBoolean("pullview_should_show_3d_loading", false);
        ay(false);
        String string = com.baidu.tbadk.core.sharedPref.b.sR().getString("pull_image_url", "");
        int g = com.baidu.adp.lib.h.b.g(str3, 0);
        if (str.equals(string)) {
            if (cv(g)) {
                tP();
                return;
            } else if (tT()) {
                com.baidu.adp.lib.h.k.dM().b(new an(this, str2, g, str));
                return;
            } else {
                b(str, str2, g);
                return;
            }
        }
        b(str, str2, com.baidu.adp.lib.h.b.g(str3, 0));
    }

    public void tP() {
        com.baidu.adp.lib.h.k.dM().b(new ao(this));
    }

    public AnimationDrawable cs(int i) {
        Drawable[] drawableArr;
        if (this.Xe != null) {
            boolean z = i == 1;
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setColorFilter(z ? this.Xm : null);
            for (Drawable drawable : this.Xe) {
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
            return animationDrawable;
        }
        return null;
    }

    public AnimationDrawable ct(int i) {
        a[] aVarArr;
        if (this.Xf == null) {
            this.Xf = new a[this.Xg.length];
            for (int i2 = 0; i2 < this.Xg.length; i2++) {
                this.Xf[i2] = new a();
            }
        }
        boolean z = i == 1;
        if (z && !this.Xh) {
            this.Xh = true;
            for (int i3 = 0; i3 < this.Xg.length; i3++) {
                this.Xf[i3].Xv = new BitmapDrawable(at.cB(this.Xg[i3]));
            }
        }
        if (!z && !this.Xi) {
            this.Xi = true;
            for (int i4 = 0; i4 < this.Xg.length; i4++) {
                this.Xf[i4].Xu = new BitmapDrawable(at.cB(this.Xg[i4]));
            }
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (a aVar : this.Xf) {
            if (aVar != null) {
                Drawable drawable = z ? aVar.Xv : aVar.Xu;
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
        }
        return animationDrawable;
    }

    public int cu(int i) {
        if (i == 1) {
            return this.Xl;
        }
        return this.Xk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tQ() {
        boolean z = false;
        String string = com.baidu.tbadk.core.sharedPref.b.sR().getString("pull_image_url", "");
        int i = com.baidu.tbadk.core.sharedPref.b.sR().getInt("pull_image_num", 0);
        this.Xk = com.baidu.tbadk.core.sharedPref.b.sR().getInt("pullview_background_color_day", -1315344);
        this.Xl = com.baidu.tbadk.core.sharedPref.b.sR().getInt("pullview_background_color_night", -14670029);
        if (!TextUtils.isEmpty(string)) {
            if (i > 0 && cv(i)) {
                this.Xe = new Drawable[i];
                File tR = tR();
                if (tR != null) {
                    File[] listFiles = tR.listFiles();
                    for (int i2 = 1; i2 <= i; i2++) {
                        this.Xe[i2 - 1] = a(listFiles, String.valueOf(i2) + ".");
                    }
                }
            }
            if (this.Xe != null) {
                Drawable[] drawableArr = this.Xe;
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
                this.Xe = null;
            }
        } else {
            this.Xe = null;
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
    public boolean cv(int i) {
        File tR = tR();
        if (tR == null) {
            return false;
        }
        File[] listFiles = tR.listFiles();
        if (listFiles == null || listFiles.length < i) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (b(tR, String.valueOf(i3) + ".")) {
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

    private File tR() {
        return r(new File(TbadkCoreApplication.m11getInst().getFilesDir(), "pullImages" + File.separator + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File tS() {
        File file = new File(TbadkCoreApplication.m11getInst().getFilesDir(), "pullImages" + File.separator + "download");
        r(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, "pullFile.zip");
        }
        return null;
    }

    private boolean tT() {
        File tS = tS();
        return tS != null && tS.exists() && tS.isFile() && tS.length() > 0;
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
        com.baidu.adp.lib.h.k.dM().b(new ap(this, str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, int i) {
        tV();
        com.baidu.tbadk.core.sharedPref.b.sR().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.sR().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.sR().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.sR().remove("pullview_background_color_night");
        dq(str);
        File tS = tS();
        if (c(tS, str2)) {
            com.baidu.tbadk.core.sharedPref.b.sR().putString("pull_image_url", str);
            com.baidu.tbadk.core.sharedPref.b.sR().putInt("pull_image_num", i);
            q(tS);
            tQ();
            return;
        }
        deleteDir(tS);
    }

    private void dq(String str) {
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
        File tR = tR();
        if (tR != null && inputStream != null) {
            b(inputStream, new File(tR, str));
        }
    }

    private void f(InputStream inputStream) {
        b(inputStream, tS());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tU() {
        File tS = tS();
        if (tS != null && tS.isFile() && tS.exists()) {
            tS.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tV() {
        deleteDir(new File(TbadkCoreApplication.m11getInst().getFilesDir(), "pullImages"));
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
                                com.baidu.adp.lib.util.o.a((OutputStream) fileOutputStream);
                                return;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.o.a((OutputStream) fileOutputStream);
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.o.a((OutputStream) fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                com.baidu.adp.lib.util.o.a((OutputStream) fileOutputStream);
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

    public boolean tW() {
        return UtilHelper.detectOpenGLES20(TbadkCoreApplication.m11getInst().getContext()) && this.Xj;
    }

    public void ay(boolean z) {
        this.Xj = z;
    }
}

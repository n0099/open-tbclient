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
import com.baidu.tieba.w;
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
public class ai {
    private static ai afo;
    private Drawable[] aff;
    private a[] afg;
    private boolean afi;
    private boolean afj;
    private boolean afk = true;
    private int afl = -1315344;
    private int afm = -14670029;
    private PorterDuffColorFilter afn = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    private int[] afh = {w.g.listview_pull_refresh01, w.g.listview_pull_refresh02};

    /* loaded from: classes.dex */
    public static class a {
        public Drawable afv;
        public Drawable afw;
    }

    private ai() {
        aD(com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("pullview_should_show_3d_loading", this.afk));
    }

    public static ai uW() {
        synchronized (ai.class) {
            if (afo == null) {
                afo = new ai();
            }
        }
        return afo;
    }

    public void b(String str, String str2, String str3, String str4, String str5) {
        int i = -1315344;
        int i2 = -14670029;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            com.baidu.tbadk.core.sharedPref.b.tX().putInt("pullview_background_color_day", -1315344);
            com.baidu.tbadk.core.sharedPref.b.tX().putInt("pullview_background_color_night", -14670029);
        } else {
            int i3 = com.baidu.tbadk.core.sharedPref.b.tX().getInt("pullview_background_color_day", -1315344);
            int i4 = com.baidu.tbadk.core.sharedPref.b.tX().getInt("pullview_background_color_night", -14670029);
            try {
                i = Color.parseColor(str4);
            } catch (Exception e) {
            }
            try {
                i2 = Color.parseColor(str5);
            } catch (Exception e2) {
            }
            if (i3 != i || i2 != i4) {
                com.baidu.tbadk.core.sharedPref.b.tX().putInt("pullview_background_color_day", i);
                com.baidu.tbadk.core.sharedPref.b.tX().putInt("pullview_background_color_night", i2);
                this.afl = i;
                this.afm = i2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE));
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("pullview_should_show_3d_loading", true);
            aD(true);
            com.baidu.adp.lib.g.k.fT().e(new aj(this));
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("pullview_should_show_3d_loading", false);
        aD(false);
        String string = com.baidu.tbadk.core.sharedPref.b.tX().getString("pull_image_url", "");
        int g = com.baidu.adp.lib.g.b.g(str3, 0);
        if (str.equals(string)) {
            if (cH(g)) {
                uX();
                return;
            } else if (vb()) {
                com.baidu.adp.lib.g.k.fT().e(new ak(this, str2, g, str));
                return;
            } else {
                b(str, str2, g);
                return;
            }
        }
        b(str, str2, com.baidu.adp.lib.g.b.g(str3, 0));
    }

    public void uX() {
        com.baidu.adp.lib.g.k.fT().e(new al(this));
    }

    public AnimationDrawable cE(int i) {
        Drawable[] drawableArr;
        if (this.aff != null) {
            boolean z = i == 1;
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setColorFilter(z ? this.afn : null);
            for (Drawable drawable : this.aff) {
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
            return animationDrawable;
        }
        return null;
    }

    public AnimationDrawable cF(int i) {
        a[] aVarArr;
        if (this.afg == null) {
            this.afg = new a[this.afh.length];
            for (int i2 = 0; i2 < this.afh.length; i2++) {
                this.afg[i2] = new a();
            }
        }
        boolean z = i == 1;
        if (z && !this.afi) {
            this.afi = true;
            for (int i3 = 0; i3 < this.afh.length; i3++) {
                this.afg[i3].afw = new BitmapDrawable(aq.cN(this.afh[i3]));
            }
        }
        if (!z && !this.afj) {
            this.afj = true;
            for (int i4 = 0; i4 < this.afh.length; i4++) {
                this.afg[i4].afv = new BitmapDrawable(aq.cN(this.afh[i4]));
            }
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (a aVar : this.afg) {
            if (aVar != null) {
                Drawable drawable = z ? aVar.afw : aVar.afv;
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
        }
        return animationDrawable;
    }

    public int cG(int i) {
        if (i == 1) {
            return this.afm;
        }
        return this.afl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uY() {
        boolean z = false;
        String string = com.baidu.tbadk.core.sharedPref.b.tX().getString("pull_image_url", "");
        int i = com.baidu.tbadk.core.sharedPref.b.tX().getInt("pull_image_num", 0);
        this.afl = com.baidu.tbadk.core.sharedPref.b.tX().getInt("pullview_background_color_day", -1315344);
        this.afm = com.baidu.tbadk.core.sharedPref.b.tX().getInt("pullview_background_color_night", -14670029);
        if (!TextUtils.isEmpty(string)) {
            if (i > 0 && cH(i)) {
                this.aff = new Drawable[i];
                File uZ = uZ();
                if (uZ != null) {
                    File[] listFiles = uZ.listFiles();
                    for (int i2 = 1; i2 <= i; i2++) {
                        this.aff[i2 - 1] = a(listFiles, String.valueOf(i2) + ".");
                    }
                }
            }
            if (this.aff != null) {
                Drawable[] drawableArr = this.aff;
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
                this.aff = null;
            }
        } else {
            this.aff = null;
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
    public boolean cH(int i) {
        File uZ = uZ();
        if (uZ == null) {
            return false;
        }
        File[] listFiles = uZ.listFiles();
        if (listFiles == null || listFiles.length < i) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (c(uZ, String.valueOf(i3) + ".")) {
                i2++;
            }
        }
        return i2 == i;
    }

    private boolean c(File file, String str) {
        File[] listFiles;
        for (File file2 : file.listFiles()) {
            if (file2.exists() && file2.isFile() && !TextUtils.isEmpty(file2.getName()) && file2.getName().startsWith(str) && file2.length() > 0) {
                return true;
            }
        }
        return false;
    }

    private File uZ() {
        return s(new File(TbadkCoreApplication.m9getInst().getFilesDir(), "pullImages" + File.separator + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File va() {
        File file = new File(TbadkCoreApplication.m9getInst().getFilesDir(), "pullImages" + File.separator + "download");
        s(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, "pullFile.zip");
        }
        return null;
    }

    private boolean vb() {
        File va = va();
        return va != null && va.exists() && va.isFile() && va.length() > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [480=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(File file, String str) {
        FileInputStream fileInputStream;
        String k;
        boolean z = false;
        if (file != null) {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        k = com.baidu.adp.lib.util.t.k(fileInputStream);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.o.j(fileInputStream);
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.o.j(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                com.baidu.adp.lib.util.o.j(fileInputStream);
                throw th;
            }
            if (!TextUtils.isEmpty(k)) {
                if (k.equalsIgnoreCase(str)) {
                    com.baidu.adp.lib.util.o.j(fileInputStream);
                    z = true;
                }
            }
            com.baidu.adp.lib.util.o.j(fileInputStream);
        }
        return z;
    }

    private void b(String str, String str2, int i) {
        com.baidu.adp.lib.g.k.fT().e(new am(this, str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, int i) {
        vd();
        com.baidu.tbadk.core.sharedPref.b.tX().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.tX().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.tX().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.tX().remove("pullview_background_color_night");
        dr(str);
        File va = va();
        if (d(va, str2)) {
            com.baidu.tbadk.core.sharedPref.b.tX().putString("pull_image_url", str);
            com.baidu.tbadk.core.sharedPref.b.tX().putInt("pull_image_num", i);
            r(va);
            uY();
            return;
        }
        deleteDir(va);
    }

    private void dr(String str) {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            HttpResponse execute = defaultHttpClient.execute(new HttpGet(str));
            if (execute.getStatusLine().getStatusCode() == 200) {
                p(execute.getEntity().getContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            defaultHttpClient.getConnectionManager().shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(File file) {
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
                                com.baidu.adp.lib.util.o.j(zipInputStream);
                                return;
                            }
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.o.j(zipInputStream);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.util.o.j(zipInputStream);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                zipInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                zipInputStream = null;
                com.baidu.adp.lib.util.o.j(zipInputStream);
                throw th;
            }
        }
    }

    private void a(String str, InputStream inputStream) {
        File uZ = uZ();
        if (uZ != null && inputStream != null) {
            b(inputStream, new File(uZ, str));
        }
    }

    private void p(InputStream inputStream) {
        b(inputStream, va());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vc() {
        File va = va();
        if (va != null && va.isFile() && va.exists()) {
            va.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vd() {
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
                                com.baidu.adp.lib.util.o.d(fileOutputStream);
                                return;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.o.d(fileOutputStream);
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.o.d(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                com.baidu.adp.lib.util.o.d(fileOutputStream);
                throw th;
            }
        }
    }

    private File s(File file) {
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

    public boolean ve() {
        return UtilHelper.detectOpenGLES20(TbadkCoreApplication.m9getInst().getContext()) && this.afk;
    }

    public void aD(boolean z) {
        this.afk = z;
    }

    public boolean vf() {
        return this.afk;
    }
}

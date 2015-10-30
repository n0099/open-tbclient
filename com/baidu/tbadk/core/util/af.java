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
import com.baidu.tieba.i;
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
public class af {
    private static af aaJ;
    private Drawable[] aaB;
    private a[] aaC;
    private boolean aaE;
    private boolean aaF;
    private int aaG = -1315344;
    private int aaH = -14670029;
    private PorterDuffColorFilter aaI = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    private int[] aaD = {i.e.listview_pull_refresh01, i.e.listview_pull_refresh02};

    /* loaded from: classes.dex */
    public static class a {
        public Drawable aaQ;
        public Drawable aaR;
    }

    private af() {
    }

    public static af uq() {
        synchronized (af.class) {
            if (aaJ == null) {
                aaJ = new af();
            }
        }
        return aaJ;
    }

    public void b(String str, String str2, String str3, String str4, String str5) {
        int i = -1315344;
        int i2 = -14670029;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            com.baidu.tbadk.core.sharedPref.b.tr().putInt("pullview_background_color_day", -1315344);
            com.baidu.tbadk.core.sharedPref.b.tr().putInt("pullview_background_color_night", -14670029);
        } else {
            int i3 = com.baidu.tbadk.core.sharedPref.b.tr().getInt("pullview_background_color_day", -1315344);
            int i4 = com.baidu.tbadk.core.sharedPref.b.tr().getInt("pullview_background_color_night", -14670029);
            try {
                i = Color.parseColor(str4);
            } catch (Exception e) {
            }
            try {
                i2 = Color.parseColor(str5);
            } catch (Exception e2) {
            }
            if (i3 != i || i2 != i4) {
                com.baidu.tbadk.core.sharedPref.b.tr().putInt("pullview_background_color_day", i);
                com.baidu.tbadk.core.sharedPref.b.tr().putInt("pullview_background_color_night", i2);
                this.aaG = i;
                this.aaH = i2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE));
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.g.k.hh().b(new ag(this));
            return;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.tr().getString("pull_image_url", "");
        int g = com.baidu.adp.lib.g.b.g(str3, 0);
        if (str.equals(string)) {
            if (cs(g)) {
                ur();
                return;
            } else if (uv()) {
                com.baidu.adp.lib.g.k.hh().b(new ah(this, str2, g, str));
                return;
            } else {
                c(str, str2, g);
                return;
            }
        }
        c(str, str2, com.baidu.adp.lib.g.b.g(str3, 0));
    }

    public void ur() {
        com.baidu.adp.lib.g.k.hh().b(new ai(this));
    }

    public AnimationDrawable cp(int i) {
        Drawable[] drawableArr;
        if (this.aaB != null) {
            boolean z = i == 1;
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setColorFilter(z ? this.aaI : null);
            for (Drawable drawable : this.aaB) {
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
            return animationDrawable;
        }
        return null;
    }

    public AnimationDrawable cq(int i) {
        a[] aVarArr;
        if (this.aaC == null) {
            this.aaC = new a[this.aaD.length];
            for (int i2 = 0; i2 < this.aaD.length; i2++) {
                this.aaC[i2] = new a();
            }
        }
        boolean z = i == 1;
        if (z && !this.aaE) {
            this.aaE = true;
            for (int i3 = 0; i3 < this.aaD.length; i3++) {
                this.aaC[i3].aaR = new BitmapDrawable(an.cy(this.aaD[i3]));
            }
        }
        if (!z && !this.aaF) {
            this.aaF = true;
            for (int i4 = 0; i4 < this.aaD.length; i4++) {
                this.aaC[i4].aaQ = new BitmapDrawable(an.cy(this.aaD[i4]));
            }
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (a aVar : this.aaC) {
            if (aVar != null) {
                Drawable drawable = z ? aVar.aaR : aVar.aaQ;
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
        }
        return animationDrawable;
    }

    public int cr(int i) {
        if (i == 1) {
            return this.aaH;
        }
        return this.aaG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void us() {
        boolean z = false;
        String string = com.baidu.tbadk.core.sharedPref.b.tr().getString("pull_image_url", "");
        int i = com.baidu.tbadk.core.sharedPref.b.tr().getInt("pull_image_num", 0);
        this.aaG = com.baidu.tbadk.core.sharedPref.b.tr().getInt("pullview_background_color_day", -1315344);
        this.aaH = com.baidu.tbadk.core.sharedPref.b.tr().getInt("pullview_background_color_night", -14670029);
        if (!TextUtils.isEmpty(string)) {
            if (i > 0 && cs(i)) {
                this.aaB = new Drawable[i];
                File ut = ut();
                if (ut != null) {
                    File[] listFiles = ut.listFiles();
                    for (int i2 = 1; i2 <= i; i2++) {
                        this.aaB[i2 - 1] = a(listFiles, String.valueOf(i2) + ".");
                    }
                }
            }
            if (this.aaB != null) {
                Drawable[] drawableArr = this.aaB;
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
                this.aaB = null;
            }
        } else {
            this.aaB = null;
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
    public boolean cs(int i) {
        File ut = ut();
        if (ut == null) {
            return false;
        }
        File[] listFiles = ut.listFiles();
        if (listFiles == null || listFiles.length < i) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (b(ut, String.valueOf(i3) + ".")) {
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

    private File ut() {
        return t(new File(TbadkCoreApplication.m411getInst().getFilesDir(), "pullImages" + File.separator + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File uu() {
        File file = new File(TbadkCoreApplication.m411getInst().getFilesDir(), "pullImages" + File.separator + "download");
        t(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, "pullFile.zip");
        }
        return null;
    }

    private boolean uv() {
        File uu = uu();
        return uu != null && uu.exists() && uu.isFile() && uu.length() > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [469=4] */
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
                        e = com.baidu.adp.lib.util.t.e(fileInputStream);
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.o.d(fileInputStream);
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.o.d(fileInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                com.baidu.adp.lib.util.o.d(fileInputStream);
                throw th;
            }
            if (!TextUtils.isEmpty(e)) {
                if (e.equalsIgnoreCase(str)) {
                    com.baidu.adp.lib.util.o.d(fileInputStream);
                    z = true;
                }
            }
            com.baidu.adp.lib.util.o.d(fileInputStream);
        }
        return z;
    }

    private void c(String str, String str2, int i) {
        com.baidu.adp.lib.g.k.hh().b(new aj(this, str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, int i) {
        ux();
        com.baidu.tbadk.core.sharedPref.b.tr().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.tr().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.tr().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.tr().remove("pullview_background_color_night");
        dg(str);
        File uu = uu();
        if (c(uu, str2)) {
            com.baidu.tbadk.core.sharedPref.b.tr().putString("pull_image_url", str);
            com.baidu.tbadk.core.sharedPref.b.tr().putInt("pull_image_num", i);
            s(uu);
            us();
            return;
        }
        deleteDir(uu);
    }

    private void dg(String str) {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            HttpResponse execute = defaultHttpClient.execute(new HttpGet(str));
            if (execute.getStatusLine().getStatusCode() == 200) {
                g(execute.getEntity().getContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            defaultHttpClient.getConnectionManager().shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(File file) {
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
                                com.baidu.adp.lib.util.o.d(zipInputStream);
                                return;
                            }
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.o.d(zipInputStream);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.util.o.d(zipInputStream);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                zipInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                zipInputStream = null;
                com.baidu.adp.lib.util.o.d(zipInputStream);
                throw th;
            }
        }
    }

    private void a(String str, InputStream inputStream) {
        File ut = ut();
        if (ut != null && inputStream != null) {
            b(inputStream, new File(ut, str));
        }
    }

    private void g(InputStream inputStream) {
        b(inputStream, uu());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uw() {
        File uu = uu();
        if (uu != null && uu.isFile() && uu.exists()) {
            uu.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux() {
        deleteDir(new File(TbadkCoreApplication.m411getInst().getFilesDir(), "pullImages"));
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

    private File t(File file) {
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

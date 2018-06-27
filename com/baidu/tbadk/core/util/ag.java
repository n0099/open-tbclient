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
import com.baidu.tieba.d;
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
public class ag {
    private static ag aqH;
    private boolean aqB;
    private boolean aqC;
    private Drawable[] aqy;
    private a[] aqz;
    private boolean aqD = true;
    private int aqE = -1315344;
    private int aqF = -14670029;
    private PorterDuffColorFilter aqG = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    private int[] aqA = {d.f.listview_pull_refresh01, d.f.listview_pull_refresh02};

    /* loaded from: classes.dex */
    public static class a {
        public Drawable aqO;
        public Drawable aqP;
    }

    private ag() {
        aJ(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("pullview_should_show_3d_loading", this.aqD));
    }

    public static ag zl() {
        synchronized (ag.class) {
            if (aqH == null) {
                aqH = new ag();
            }
        }
        return aqH;
    }

    public void b(final String str, final String str2, String str3, String str4, String str5) {
        int i = -1315344;
        int i2 = -14670029;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("pullview_background_color_day", -1315344);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("pullview_background_color_night", -14670029);
        } else {
            int i3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pullview_background_color_day", -1315344);
            int i4 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pullview_background_color_night", -14670029);
            try {
                i = Color.parseColor(str4);
            } catch (Exception e) {
            }
            try {
                i2 = Color.parseColor(str5);
            } catch (Exception e2) {
            }
            if (i3 != i || i2 != i4) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("pullview_background_color_day", i);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("pullview_background_color_night", i2);
                this.aqE = i;
                this.aqF = i2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016204));
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pullview_should_show_3d_loading", true);
            aJ(true);
            com.baidu.adp.lib.g.h.in().c(new Runnable() { // from class: com.baidu.tbadk.core.util.ag.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pull_image_url");
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pull_image_num");
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pullview_background_color_day");
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pullview_background_color_night");
                    ag.this.zs();
                    ag.this.zn();
                }
            });
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pullview_should_show_3d_loading", false);
        aJ(false);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("pull_image_url", "");
        final int g = com.baidu.adp.lib.g.b.g(str3, 0);
        if (str.equals(string)) {
            if (cM(g)) {
                zm();
                return;
            } else if (zq()) {
                com.baidu.adp.lib.g.h.in().c(new Runnable() { // from class: com.baidu.tbadk.core.util.ag.2
                    @Override // java.lang.Runnable
                    public void run() {
                        File zp = ag.this.zp();
                        if (ag.this.d(zp, str2)) {
                            ag.this.s(zp);
                            if (ag.this.cM(g)) {
                                ag.this.zn();
                                return;
                            }
                        }
                        ag.this.zr();
                        ag.this.c(str, str2, g);
                    }
                });
                return;
            } else {
                b(str, str2, g);
                return;
            }
        }
        b(str, str2, com.baidu.adp.lib.g.b.g(str3, 0));
    }

    public void zm() {
        com.baidu.adp.lib.g.h.in().c(new Runnable() { // from class: com.baidu.tbadk.core.util.ag.3
            @Override // java.lang.Runnable
            public void run() {
                ag.this.zn();
            }
        });
    }

    public AnimationDrawable cJ(int i) {
        Drawable[] drawableArr;
        if (this.aqy != null) {
            boolean z = i == 1;
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setColorFilter(z ? this.aqG : null);
            for (Drawable drawable : this.aqy) {
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
            return animationDrawable;
        }
        return null;
    }

    public AnimationDrawable cK(int i) {
        a[] aVarArr;
        if (this.aqz == null) {
            this.aqz = new a[this.aqA.length];
            for (int i2 = 0; i2 < this.aqA.length; i2++) {
                this.aqz[i2] = new a();
            }
        }
        boolean z = i == 1;
        if (z && !this.aqB) {
            this.aqB = true;
            for (int i3 = 0; i3 < this.aqA.length; i3++) {
                this.aqz[i3].aqP = new BitmapDrawable(am.cT(this.aqA[i3]));
            }
        }
        if (!z && !this.aqC) {
            this.aqC = true;
            for (int i4 = 0; i4 < this.aqA.length; i4++) {
                this.aqz[i4].aqO = new BitmapDrawable(am.cT(this.aqA[i4]));
            }
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (a aVar : this.aqz) {
            if (aVar != null) {
                Drawable drawable = z ? aVar.aqP : aVar.aqO;
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
        }
        return animationDrawable;
    }

    public int cL(int i) {
        if (i == 1) {
            return this.aqF;
        }
        return this.aqE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zn() {
        boolean z = false;
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("pull_image_url", "");
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pull_image_num", 0);
        this.aqE = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pullview_background_color_day", -1315344);
        this.aqF = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pullview_background_color_night", -14670029);
        if (!TextUtils.isEmpty(string)) {
            if (i > 0 && cM(i)) {
                this.aqy = new Drawable[i];
                File zo = zo();
                if (zo != null) {
                    File[] listFiles = zo.listFiles();
                    for (int i2 = 1; i2 <= i; i2++) {
                        this.aqy[i2 - 1] = a(listFiles, i2 + ".");
                    }
                }
            }
            if (this.aqy != null) {
                Drawable[] drawableArr = this.aqy;
                int length = drawableArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z = true;
                        break;
                    } else if (drawableArr[i3] == null) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            if (!z) {
                this.aqy = null;
            }
        } else {
            this.aqy = null;
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
            if (i < length) {
                file = fileArr[i];
                if (file != null && file.isFile() && file.length() > 0 && file.getName().startsWith(str)) {
                    break;
                }
                i++;
            } else {
                file = null;
                break;
            }
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
    public boolean cM(int i) {
        File zo = zo();
        if (zo == null) {
            return false;
        }
        File[] listFiles = zo.listFiles();
        if (listFiles == null || listFiles.length < i) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (c(zo, i3 + ".")) {
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

    private File zo() {
        return t(new File(TbadkCoreApplication.getInst().getFilesDir(), "pullImages" + File.separator + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File zp() {
        File file = new File(TbadkCoreApplication.getInst().getFilesDir(), "pullImages" + File.separator + "download");
        t(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, "pullFile.zip");
        }
        return null;
    }

    private boolean zq() {
        File zp = zp();
        return zp != null && zp.exists() && zp.isFile() && zp.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(File file, String str) {
        FileInputStream fileInputStream;
        String g;
        boolean z = false;
        if (file != null) {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        g = com.baidu.adp.lib.util.s.g(fileInputStream);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.n.f(fileInputStream);
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.n.f(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                com.baidu.adp.lib.util.n.f(fileInputStream);
                throw th;
            }
            if (!TextUtils.isEmpty(g)) {
                if (g.equalsIgnoreCase(str)) {
                    z = true;
                    com.baidu.adp.lib.util.n.f(fileInputStream);
                }
            }
            com.baidu.adp.lib.util.n.f(fileInputStream);
        }
        return z;
    }

    private void b(final String str, final String str2, final int i) {
        com.baidu.adp.lib.g.h.in().c(new Runnable() { // from class: com.baidu.tbadk.core.util.ag.4
            @Override // java.lang.Runnable
            public void run() {
                ag.this.c(str, str2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, int i) {
        zs();
        com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pullview_background_color_night");
        eF(str);
        File zp = zp();
        if (d(zp, str2)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("pull_image_url", str);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("pull_image_num", i);
            s(zp);
            zn();
            return;
        }
        deleteDir(zp);
    }

    private void eF(String str) {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            HttpResponse execute = defaultHttpClient.execute(new HttpGet(str));
            if (execute.getStatusLine().getStatusCode() == 200) {
                i(execute.getEntity().getContent());
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
                                        b(name.substring(name.lastIndexOf(File.separator)), zipInputStream);
                                    }
                                }
                            } else {
                                com.baidu.adp.lib.util.n.f(zipInputStream);
                                return;
                            }
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.n.f(zipInputStream);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.util.n.f(zipInputStream);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                zipInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                zipInputStream = null;
                com.baidu.adp.lib.util.n.f(zipInputStream);
                throw th;
            }
        }
    }

    private void b(String str, InputStream inputStream) {
        File zo = zo();
        if (zo != null && inputStream != null) {
            c(inputStream, new File(zo, str));
        }
    }

    private void i(InputStream inputStream) {
        c(inputStream, zp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zr() {
        File zp = zp();
        if (zp != null && zp.isFile() && zp.exists()) {
            zp.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zs() {
        deleteDir(new File(TbadkCoreApplication.getInst().getFilesDir(), "pullImages"));
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
                                com.baidu.adp.lib.util.n.b((OutputStream) fileOutputStream);
                                return;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.n.b((OutputStream) fileOutputStream);
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.n.b((OutputStream) fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                com.baidu.adp.lib.util.n.b((OutputStream) fileOutputStream);
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

    public boolean zt() {
        return UtilHelper.detectOpenGLES20(TbadkCoreApplication.getInst().getContext()) && this.aqD;
    }

    public void aJ(boolean z) {
        this.aqD = z;
    }
}

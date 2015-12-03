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
import com.baidu.tieba.n;
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
public class ak {
    private static ak abA;
    private Drawable[] abr;
    private a[] abt;
    private boolean abv;
    private boolean abw;
    private int abx = -1315344;
    private int aby = -14670029;
    private PorterDuffColorFilter abz = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    private int[] abu = {n.e.listview_pull_refresh01, n.e.listview_pull_refresh02};

    /* loaded from: classes.dex */
    public static class a {
        public Drawable abH;
        public Drawable abI;
    }

    private ak() {
    }

    public static ak uZ() {
        synchronized (ak.class) {
            if (abA == null) {
                abA = new ak();
            }
        }
        return abA;
    }

    public void b(String str, String str2, String str3, String str4, String str5) {
        int i = -1315344;
        int i2 = -14670029;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            com.baidu.tbadk.core.sharedPref.b.tZ().putInt("pullview_background_color_day", -1315344);
            com.baidu.tbadk.core.sharedPref.b.tZ().putInt("pullview_background_color_night", -14670029);
        } else {
            int i3 = com.baidu.tbadk.core.sharedPref.b.tZ().getInt("pullview_background_color_day", -1315344);
            int i4 = com.baidu.tbadk.core.sharedPref.b.tZ().getInt("pullview_background_color_night", -14670029);
            try {
                i = Color.parseColor(str4);
            } catch (Exception e) {
            }
            try {
                i2 = Color.parseColor(str5);
            } catch (Exception e2) {
            }
            if (i3 != i || i2 != i4) {
                com.baidu.tbadk.core.sharedPref.b.tZ().putInt("pullview_background_color_day", i);
                com.baidu.tbadk.core.sharedPref.b.tZ().putInt("pullview_background_color_night", i2);
                this.abx = i;
                this.aby = i2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE));
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.h.k.hk().b(new al(this));
            return;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.tZ().getString("pull_image_url", "");
        int g = com.baidu.adp.lib.h.b.g(str3, 0);
        if (str.equals(string)) {
            if (cA(g)) {
                va();
                return;
            } else if (ve()) {
                com.baidu.adp.lib.h.k.hk().b(new am(this, str2, g, str));
                return;
            } else {
                c(str, str2, g);
                return;
            }
        }
        c(str, str2, com.baidu.adp.lib.h.b.g(str3, 0));
    }

    public void va() {
        com.baidu.adp.lib.h.k.hk().b(new an(this));
    }

    public AnimationDrawable cx(int i) {
        Drawable[] drawableArr;
        if (this.abr != null) {
            boolean z = i == 1;
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setColorFilter(z ? this.abz : null);
            for (Drawable drawable : this.abr) {
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
            return animationDrawable;
        }
        return null;
    }

    public AnimationDrawable cy(int i) {
        a[] aVarArr;
        if (this.abt == null) {
            this.abt = new a[this.abu.length];
            for (int i2 = 0; i2 < this.abu.length; i2++) {
                this.abt[i2] = new a();
            }
        }
        boolean z = i == 1;
        if (z && !this.abv) {
            this.abv = true;
            for (int i3 = 0; i3 < this.abu.length; i3++) {
                this.abt[i3].abI = new BitmapDrawable(as.cG(this.abu[i3]));
            }
        }
        if (!z && !this.abw) {
            this.abw = true;
            for (int i4 = 0; i4 < this.abu.length; i4++) {
                this.abt[i4].abH = new BitmapDrawable(as.cG(this.abu[i4]));
            }
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (a aVar : this.abt) {
            if (aVar != null) {
                Drawable drawable = z ? aVar.abI : aVar.abH;
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
        }
        return animationDrawable;
    }

    public int cz(int i) {
        if (i == 1) {
            return this.aby;
        }
        return this.abx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vb() {
        boolean z = false;
        String string = com.baidu.tbadk.core.sharedPref.b.tZ().getString("pull_image_url", "");
        int i = com.baidu.tbadk.core.sharedPref.b.tZ().getInt("pull_image_num", 0);
        this.abx = com.baidu.tbadk.core.sharedPref.b.tZ().getInt("pullview_background_color_day", -1315344);
        this.aby = com.baidu.tbadk.core.sharedPref.b.tZ().getInt("pullview_background_color_night", -14670029);
        if (!TextUtils.isEmpty(string)) {
            if (i > 0 && cA(i)) {
                this.abr = new Drawable[i];
                File vc = vc();
                if (vc != null) {
                    File[] listFiles = vc.listFiles();
                    for (int i2 = 1; i2 <= i; i2++) {
                        this.abr[i2 - 1] = a(listFiles, String.valueOf(i2) + ".");
                    }
                }
            }
            if (this.abr != null) {
                Drawable[] drawableArr = this.abr;
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
                this.abr = null;
            }
        } else {
            this.abr = null;
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
    public boolean cA(int i) {
        File vc = vc();
        if (vc == null) {
            return false;
        }
        File[] listFiles = vc.listFiles();
        if (listFiles == null || listFiles.length < i) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (b(vc, String.valueOf(i3) + ".")) {
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

    private File vc() {
        return t(new File(TbadkCoreApplication.m411getInst().getFilesDir(), "pullImages" + File.separator + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File vd() {
        File file = new File(TbadkCoreApplication.m411getInst().getFilesDir(), "pullImages" + File.separator + "download");
        t(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, "pullFile.zip");
        }
        return null;
    }

    private boolean ve() {
        File vd = vd();
        return vd != null && vd.exists() && vd.isFile() && vd.length() > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [469=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(File file, String str) {
        FileInputStream fileInputStream;
        String f;
        boolean z = false;
        if (file != null) {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        f = com.baidu.adp.lib.util.t.f(fileInputStream);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.o.e(fileInputStream);
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.o.e(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                com.baidu.adp.lib.util.o.e(fileInputStream);
                throw th;
            }
            if (!TextUtils.isEmpty(f)) {
                if (f.equalsIgnoreCase(str)) {
                    com.baidu.adp.lib.util.o.e(fileInputStream);
                    z = true;
                }
            }
            com.baidu.adp.lib.util.o.e(fileInputStream);
        }
        return z;
    }

    private void c(String str, String str2, int i) {
        com.baidu.adp.lib.h.k.hk().b(new ao(this, str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, int i) {
        vg();
        com.baidu.tbadk.core.sharedPref.b.tZ().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.tZ().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.tZ().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.tZ().remove("pullview_background_color_night");
        dq(str);
        File vd = vd();
        if (c(vd, str2)) {
            com.baidu.tbadk.core.sharedPref.b.tZ().putString("pull_image_url", str);
            com.baidu.tbadk.core.sharedPref.b.tZ().putInt("pull_image_num", i);
            s(vd);
            vb();
            return;
        }
        deleteDir(vd);
    }

    private void dq(String str) {
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
                                com.baidu.adp.lib.util.o.e(zipInputStream);
                                return;
                            }
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.o.e(zipInputStream);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.util.o.e(zipInputStream);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                zipInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                zipInputStream = null;
                com.baidu.adp.lib.util.o.e(zipInputStream);
                throw th;
            }
        }
    }

    private void a(String str, InputStream inputStream) {
        File vc = vc();
        if (vc != null && inputStream != null) {
            b(inputStream, new File(vc, str));
        }
    }

    private void h(InputStream inputStream) {
        b(inputStream, vd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vf() {
        File vd = vd();
        if (vd != null && vd.isFile() && vd.exists()) {
            vd.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vg() {
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

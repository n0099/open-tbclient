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
public class aj {
    private static aj acA;
    private Drawable[] acs;
    private a[] act;
    private boolean acv;
    private boolean acw;
    private int acx = -1315344;
    private int acy = -14670029;
    private PorterDuffColorFilter acz = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    private int[] acu = {t.f.listview_pull_refresh01, t.f.listview_pull_refresh02};

    /* loaded from: classes.dex */
    public static class a {
        public Drawable acH;
        public Drawable acI;
    }

    private aj() {
    }

    public static aj vO() {
        synchronized (aj.class) {
            if (acA == null) {
                acA = new aj();
            }
        }
        return acA;
    }

    public void b(String str, String str2, String str3, String str4, String str5) {
        int i = -1315344;
        int i2 = -14670029;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            com.baidu.tbadk.core.sharedPref.b.uO().putInt("pullview_background_color_day", -1315344);
            com.baidu.tbadk.core.sharedPref.b.uO().putInt("pullview_background_color_night", -14670029);
        } else {
            int i3 = com.baidu.tbadk.core.sharedPref.b.uO().getInt("pullview_background_color_day", -1315344);
            int i4 = com.baidu.tbadk.core.sharedPref.b.uO().getInt("pullview_background_color_night", -14670029);
            try {
                i = Color.parseColor(str4);
            } catch (Exception e) {
            }
            try {
                i2 = Color.parseColor(str5);
            } catch (Exception e2) {
            }
            if (i3 != i || i2 != i4) {
                com.baidu.tbadk.core.sharedPref.b.uO().putInt("pullview_background_color_day", i);
                com.baidu.tbadk.core.sharedPref.b.uO().putInt("pullview_background_color_night", i2);
                this.acx = i;
                this.acy = i2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE));
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.h.k.hs().b(new ak(this));
            return;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.uO().getString("pull_image_url", "");
        int g = com.baidu.adp.lib.h.b.g(str3, 0);
        if (str.equals(string)) {
            if (cK(g)) {
                vP();
                return;
            } else if (vT()) {
                com.baidu.adp.lib.h.k.hs().b(new al(this, str2, g, str));
                return;
            } else {
                c(str, str2, g);
                return;
            }
        }
        c(str, str2, com.baidu.adp.lib.h.b.g(str3, 0));
    }

    public void vP() {
        com.baidu.adp.lib.h.k.hs().b(new am(this));
    }

    public AnimationDrawable cH(int i) {
        Drawable[] drawableArr;
        if (this.acs != null) {
            boolean z = i == 1;
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setColorFilter(z ? this.acz : null);
            for (Drawable drawable : this.acs) {
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
            return animationDrawable;
        }
        return null;
    }

    public AnimationDrawable cI(int i) {
        a[] aVarArr;
        if (this.act == null) {
            this.act = new a[this.acu.length];
            for (int i2 = 0; i2 < this.acu.length; i2++) {
                this.act[i2] = new a();
            }
        }
        boolean z = i == 1;
        if (z && !this.acv) {
            this.acv = true;
            for (int i3 = 0; i3 < this.acu.length; i3++) {
                this.act[i3].acI = new BitmapDrawable(ar.cQ(this.acu[i3]));
            }
        }
        if (!z && !this.acw) {
            this.acw = true;
            for (int i4 = 0; i4 < this.acu.length; i4++) {
                this.act[i4].acH = new BitmapDrawable(ar.cQ(this.acu[i4]));
            }
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (a aVar : this.act) {
            if (aVar != null) {
                Drawable drawable = z ? aVar.acI : aVar.acH;
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
        }
        return animationDrawable;
    }

    public int cJ(int i) {
        if (i == 1) {
            return this.acy;
        }
        return this.acx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vQ() {
        boolean z = false;
        String string = com.baidu.tbadk.core.sharedPref.b.uO().getString("pull_image_url", "");
        int i = com.baidu.tbadk.core.sharedPref.b.uO().getInt("pull_image_num", 0);
        this.acx = com.baidu.tbadk.core.sharedPref.b.uO().getInt("pullview_background_color_day", -1315344);
        this.acy = com.baidu.tbadk.core.sharedPref.b.uO().getInt("pullview_background_color_night", -14670029);
        if (!TextUtils.isEmpty(string)) {
            if (i > 0 && cK(i)) {
                this.acs = new Drawable[i];
                File vR = vR();
                if (vR != null) {
                    File[] listFiles = vR.listFiles();
                    for (int i2 = 1; i2 <= i; i2++) {
                        this.acs[i2 - 1] = a(listFiles, String.valueOf(i2) + ".");
                    }
                }
            }
            if (this.acs != null) {
                Drawable[] drawableArr = this.acs;
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
                this.acs = null;
            }
        } else {
            this.acs = null;
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
    public boolean cK(int i) {
        File vR = vR();
        if (vR == null) {
            return false;
        }
        File[] listFiles = vR.listFiles();
        if (listFiles == null || listFiles.length < i) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (b(vR, String.valueOf(i3) + ".")) {
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

    private File vR() {
        return t(new File(TbadkCoreApplication.m411getInst().getFilesDir(), "pullImages" + File.separator + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File vS() {
        File file = new File(TbadkCoreApplication.m411getInst().getFilesDir(), "pullImages" + File.separator + "download");
        t(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, "pullFile.zip");
        }
        return null;
    }

    private boolean vT() {
        File vS = vS();
        return vS != null && vS.exists() && vS.isFile() && vS.length() > 0;
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
        com.baidu.adp.lib.h.k.hs().b(new an(this, str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, int i) {
        vV();
        com.baidu.tbadk.core.sharedPref.b.uO().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.uO().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.uO().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.uO().remove("pullview_background_color_night");
        dq(str);
        File vS = vS();
        if (c(vS, str2)) {
            com.baidu.tbadk.core.sharedPref.b.uO().putString("pull_image_url", str);
            com.baidu.tbadk.core.sharedPref.b.uO().putInt("pull_image_num", i);
            s(vS);
            vQ();
            return;
        }
        deleteDir(vS);
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
        File vR = vR();
        if (vR != null && inputStream != null) {
            b(inputStream, new File(vR, str));
        }
    }

    private void h(InputStream inputStream) {
        b(inputStream, vS());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vU() {
        File vS = vS();
        if (vS != null && vS.isFile() && vS.exists()) {
            vS.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vV() {
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

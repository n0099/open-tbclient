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
    private static ak ace;
    private Drawable[] abW;
    private a[] abX;
    private boolean abZ;
    private boolean aca;
    private int acb = -1315344;
    private int acc = -14670029;
    private PorterDuffColorFilter acd = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    private int[] abY = {n.f.listview_pull_refresh01, n.f.listview_pull_refresh02};

    /* loaded from: classes.dex */
    public static class a {
        public Drawable acl;
        public Drawable acm;
    }

    private ak() {
    }

    public static ak uJ() {
        synchronized (ak.class) {
            if (ace == null) {
                ace = new ak();
            }
        }
        return ace;
    }

    public void b(String str, String str2, String str3, String str4, String str5) {
        int i = -1315344;
        int i2 = -14670029;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            com.baidu.tbadk.core.sharedPref.b.tJ().putInt("pullview_background_color_day", -1315344);
            com.baidu.tbadk.core.sharedPref.b.tJ().putInt("pullview_background_color_night", -14670029);
        } else {
            int i3 = com.baidu.tbadk.core.sharedPref.b.tJ().getInt("pullview_background_color_day", -1315344);
            int i4 = com.baidu.tbadk.core.sharedPref.b.tJ().getInt("pullview_background_color_night", -14670029);
            try {
                i = Color.parseColor(str4);
            } catch (Exception e) {
            }
            try {
                i2 = Color.parseColor(str5);
            } catch (Exception e2) {
            }
            if (i3 != i || i2 != i4) {
                com.baidu.tbadk.core.sharedPref.b.tJ().putInt("pullview_background_color_day", i);
                com.baidu.tbadk.core.sharedPref.b.tJ().putInt("pullview_background_color_night", i2);
                this.acb = i;
                this.acc = i2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE));
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.h.k.hk().b(new al(this));
            return;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.tJ().getString("pull_image_url", "");
        int g = com.baidu.adp.lib.h.b.g(str3, 0);
        if (str.equals(string)) {
            if (ct(g)) {
                uK();
                return;
            } else if (uO()) {
                com.baidu.adp.lib.h.k.hk().b(new am(this, str2, g, str));
                return;
            } else {
                c(str, str2, g);
                return;
            }
        }
        c(str, str2, com.baidu.adp.lib.h.b.g(str3, 0));
    }

    public void uK() {
        com.baidu.adp.lib.h.k.hk().b(new an(this));
    }

    public AnimationDrawable cq(int i) {
        Drawable[] drawableArr;
        if (this.abW != null) {
            boolean z = i == 1;
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setColorFilter(z ? this.acd : null);
            for (Drawable drawable : this.abW) {
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
            return animationDrawable;
        }
        return null;
    }

    public AnimationDrawable cr(int i) {
        a[] aVarArr;
        if (this.abX == null) {
            this.abX = new a[this.abY.length];
            for (int i2 = 0; i2 < this.abY.length; i2++) {
                this.abX[i2] = new a();
            }
        }
        boolean z = i == 1;
        if (z && !this.abZ) {
            this.abZ = true;
            for (int i3 = 0; i3 < this.abY.length; i3++) {
                this.abX[i3].acm = new BitmapDrawable(as.cz(this.abY[i3]));
            }
        }
        if (!z && !this.aca) {
            this.aca = true;
            for (int i4 = 0; i4 < this.abY.length; i4++) {
                this.abX[i4].acl = new BitmapDrawable(as.cz(this.abY[i4]));
            }
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (a aVar : this.abX) {
            if (aVar != null) {
                Drawable drawable = z ? aVar.acm : aVar.acl;
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
        }
        return animationDrawable;
    }

    public int cs(int i) {
        if (i == 1) {
            return this.acc;
        }
        return this.acb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uL() {
        boolean z = false;
        String string = com.baidu.tbadk.core.sharedPref.b.tJ().getString("pull_image_url", "");
        int i = com.baidu.tbadk.core.sharedPref.b.tJ().getInt("pull_image_num", 0);
        this.acb = com.baidu.tbadk.core.sharedPref.b.tJ().getInt("pullview_background_color_day", -1315344);
        this.acc = com.baidu.tbadk.core.sharedPref.b.tJ().getInt("pullview_background_color_night", -14670029);
        if (!TextUtils.isEmpty(string)) {
            if (i > 0 && ct(i)) {
                this.abW = new Drawable[i];
                File uM = uM();
                if (uM != null) {
                    File[] listFiles = uM.listFiles();
                    for (int i2 = 1; i2 <= i; i2++) {
                        this.abW[i2 - 1] = a(listFiles, String.valueOf(i2) + ".");
                    }
                }
            }
            if (this.abW != null) {
                Drawable[] drawableArr = this.abW;
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
                this.abW = null;
            }
        } else {
            this.abW = null;
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
    public boolean ct(int i) {
        File uM = uM();
        if (uM == null) {
            return false;
        }
        File[] listFiles = uM.listFiles();
        if (listFiles == null || listFiles.length < i) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (b(uM, String.valueOf(i3) + ".")) {
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

    private File uM() {
        return t(new File(TbadkCoreApplication.m411getInst().getFilesDir(), "pullImages" + File.separator + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File uN() {
        File file = new File(TbadkCoreApplication.m411getInst().getFilesDir(), "pullImages" + File.separator + "download");
        t(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, "pullFile.zip");
        }
        return null;
    }

    private boolean uO() {
        File uN = uN();
        return uN != null && uN.exists() && uN.isFile() && uN.length() > 0;
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
        uQ();
        com.baidu.tbadk.core.sharedPref.b.tJ().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.tJ().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.tJ().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.tJ().remove("pullview_background_color_night");
        dt(str);
        File uN = uN();
        if (c(uN, str2)) {
            com.baidu.tbadk.core.sharedPref.b.tJ().putString("pull_image_url", str);
            com.baidu.tbadk.core.sharedPref.b.tJ().putInt("pull_image_num", i);
            s(uN);
            uL();
            return;
        }
        deleteDir(uN);
    }

    private void dt(String str) {
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
        File uM = uM();
        if (uM != null && inputStream != null) {
            b(inputStream, new File(uM, str));
        }
    }

    private void h(InputStream inputStream) {
        b(inputStream, uN());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uP() {
        File uN = uN();
        if (uN != null && uN.isFile() && uN.exists()) {
            uN.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uQ() {
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

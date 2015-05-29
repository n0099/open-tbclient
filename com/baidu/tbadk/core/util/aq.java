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
public class aq {
    private static aq VH;
    private av[] VA;
    private boolean VC;
    private boolean VD;
    private Drawable[] Vz;
    private int VE = -1315344;
    private int VF = -14670029;
    private PorterDuffColorFilter VG = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    private int[] VB = {com.baidu.tieba.p.listview_pull_refresh01, com.baidu.tieba.p.listview_pull_refresh02};

    private aq() {
    }

    public static aq to() {
        synchronized (aq.class) {
            if (VH == null) {
                VH = new aq();
            }
        }
        return VH;
    }

    public void c(String str, String str2, String str3, String str4, String str5) {
        int i = -1315344;
        int i2 = -14670029;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            com.baidu.tbadk.core.sharedPref.b.sl().putInt("pullview_background_color_day", -1315344);
            com.baidu.tbadk.core.sharedPref.b.sl().putInt("pullview_background_color_night", -14670029);
        } else {
            int i3 = com.baidu.tbadk.core.sharedPref.b.sl().getInt("pullview_background_color_day", -1315344);
            int i4 = com.baidu.tbadk.core.sharedPref.b.sl().getInt("pullview_background_color_night", -14670029);
            try {
                i = Color.parseColor(str4);
            } catch (Exception e) {
            }
            try {
                i2 = Color.parseColor(str5);
            } catch (Exception e2) {
            }
            if (i3 != i || i2 != i4) {
                com.baidu.tbadk.core.sharedPref.b.sl().putInt("pullview_background_color_day", i);
                com.baidu.tbadk.core.sharedPref.b.sl().putInt("pullview_background_color_night", i2);
                this.VE = i;
                this.VF = i2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016204));
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.g.l.ht().b(new ar(this));
            return;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.sl().getString("pull_image_url", "");
        int i5 = com.baidu.adp.lib.g.c.toInt(str3, 0);
        if (str.equals(string)) {
            if (cg(i5)) {
                tp();
                return;
            } else if (tt()) {
                com.baidu.adp.lib.g.l.ht().b(new as(this, str2, i5, str));
                return;
            } else {
                c(str, str2, i5);
                return;
            }
        }
        c(str, str2, com.baidu.adp.lib.g.c.toInt(str3, 0));
    }

    public void tp() {
        com.baidu.adp.lib.g.l.ht().b(new at(this));
    }

    public AnimationDrawable cd(int i) {
        Drawable[] drawableArr;
        if (this.Vz != null) {
            boolean z = i == 1;
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setColorFilter(z ? this.VG : null);
            for (Drawable drawable : this.Vz) {
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
            return animationDrawable;
        }
        return null;
    }

    public AnimationDrawable ce(int i) {
        av[] avVarArr;
        if (this.VA == null) {
            this.VA = new av[this.VB.length];
            for (int i2 = 0; i2 < this.VB.length; i2++) {
                this.VA[i2] = new av();
            }
        }
        boolean z = i == 1;
        if (z && !this.VC) {
            this.VC = true;
            for (int i3 = 0; i3 < this.VB.length; i3++) {
                this.VA[i3].VP = ay.n(1, this.VB[i3]);
            }
        }
        if (!z && !this.VD) {
            this.VD = true;
            for (int i4 = 0; i4 < this.VB.length; i4++) {
                this.VA[i4].VO = ay.n(0, this.VB[i4]);
            }
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (av avVar : this.VA) {
            if (avVar != null) {
                animationDrawable.addFrame(z ? avVar.VP : avVar.VO, 100);
            }
        }
        return animationDrawable;
    }

    public int cf(int i) {
        if (i == 1) {
            return this.VF;
        }
        return this.VE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tq() {
        boolean z = false;
        String string = com.baidu.tbadk.core.sharedPref.b.sl().getString("pull_image_url", "");
        int i = com.baidu.tbadk.core.sharedPref.b.sl().getInt("pull_image_num", 0);
        this.VE = com.baidu.tbadk.core.sharedPref.b.sl().getInt("pullview_background_color_day", -1315344);
        this.VF = com.baidu.tbadk.core.sharedPref.b.sl().getInt("pullview_background_color_night", -14670029);
        if (!TextUtils.isEmpty(string)) {
            if (i > 0 && cg(i)) {
                this.Vz = new Drawable[i];
                File tr = tr();
                if (tr != null) {
                    File[] listFiles = tr.listFiles();
                    for (int i2 = 1; i2 <= i; i2++) {
                        this.Vz[i2 - 1] = a(listFiles, String.valueOf(i2) + ".");
                    }
                }
            }
            if (this.Vz != null) {
                Drawable[] drawableArr = this.Vz;
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
                this.Vz = null;
            }
        } else {
            this.Vz = null;
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
    public boolean cg(int i) {
        File tr = tr();
        if (tr == null) {
            return false;
        }
        File[] listFiles = tr.listFiles();
        if (listFiles == null || listFiles.length < i) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (b(tr, String.valueOf(i3) + ".")) {
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

    private File tr() {
        return r(new File(TbadkCoreApplication.m411getInst().getFilesDir(), "pullImages" + File.separator + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File ts() {
        File file = new File(TbadkCoreApplication.m411getInst().getFilesDir(), "pullImages" + File.separator + "download");
        r(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, "pullFile.zip");
        }
        return null;
    }

    private boolean tt() {
        File ts = ts();
        return ts != null && ts.exists() && ts.isFile() && ts.length() > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [468=4] */
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
                        e = com.baidu.adp.lib.util.ac.e(fileInputStream);
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.w.d(fileInputStream);
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.w.d(fileInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                com.baidu.adp.lib.util.w.d(fileInputStream);
                throw th;
            }
            if (!TextUtils.isEmpty(e)) {
                if (e.equalsIgnoreCase(str)) {
                    com.baidu.adp.lib.util.w.d(fileInputStream);
                    z = true;
                }
            }
            com.baidu.adp.lib.util.w.d(fileInputStream);
        }
        return z;
    }

    private void c(String str, String str2, int i) {
        com.baidu.adp.lib.g.l.ht().b(new au(this, str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, int i) {
        tv();
        com.baidu.tbadk.core.sharedPref.b.sl().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.sl().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.sl().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.sl().remove("pullview_background_color_night");
        cX(str);
        File ts = ts();
        if (c(ts, str2)) {
            com.baidu.tbadk.core.sharedPref.b.sl().putString("pull_image_url", str);
            com.baidu.tbadk.core.sharedPref.b.sl().putInt("pull_image_num", i);
            q(ts);
            tq();
            return;
        }
        deleteDir(ts);
    }

    private void cX(String str) {
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
                                com.baidu.adp.lib.util.w.d(zipInputStream);
                                return;
                            }
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.w.d(zipInputStream);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.util.w.d(zipInputStream);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                zipInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                zipInputStream = null;
                com.baidu.adp.lib.util.w.d(zipInputStream);
                throw th;
            }
        }
    }

    private void a(String str, InputStream inputStream) {
        File tr = tr();
        if (tr != null && inputStream != null) {
            c(inputStream, new File(tr, str));
        }
    }

    private void h(InputStream inputStream) {
        c(inputStream, ts());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tu() {
        File ts = ts();
        if (ts != null && ts.isFile() && ts.exists()) {
            ts.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tv() {
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
                                com.baidu.adp.lib.util.w.b(fileOutputStream);
                                return;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.w.b(fileOutputStream);
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.w.b(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                com.baidu.adp.lib.util.w.b(fileOutputStream);
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
}

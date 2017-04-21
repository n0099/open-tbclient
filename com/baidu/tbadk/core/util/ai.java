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
    private static ai afW;
    private Drawable[] afN;
    private a[] afO;
    private boolean afQ;
    private boolean afR;
    private boolean afS = true;
    private int afT = -1315344;
    private int afU = -14670029;
    private PorterDuffColorFilter afV = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    private int[] afP = {w.g.listview_pull_refresh01, w.g.listview_pull_refresh02};

    /* loaded from: classes.dex */
    public static class a {
        public Drawable agd;
        public Drawable agf;
    }

    private ai() {
        aF(com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("pullview_should_show_3d_loading", this.afS));
    }

    public static ai vJ() {
        synchronized (ai.class) {
            if (afW == null) {
                afW = new ai();
            }
        }
        return afW;
    }

    public void b(String str, String str2, String str3, String str4, String str5) {
        int i = -1315344;
        int i2 = -14670029;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            com.baidu.tbadk.core.sharedPref.b.uL().putInt("pullview_background_color_day", -1315344);
            com.baidu.tbadk.core.sharedPref.b.uL().putInt("pullview_background_color_night", -14670029);
        } else {
            int i3 = com.baidu.tbadk.core.sharedPref.b.uL().getInt("pullview_background_color_day", -1315344);
            int i4 = com.baidu.tbadk.core.sharedPref.b.uL().getInt("pullview_background_color_night", -14670029);
            try {
                i = Color.parseColor(str4);
            } catch (Exception e) {
            }
            try {
                i2 = Color.parseColor(str5);
            } catch (Exception e2) {
            }
            if (i3 != i || i2 != i4) {
                com.baidu.tbadk.core.sharedPref.b.uL().putInt("pullview_background_color_day", i);
                com.baidu.tbadk.core.sharedPref.b.uL().putInt("pullview_background_color_night", i2);
                this.afT = i;
                this.afU = i2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE));
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("pullview_should_show_3d_loading", true);
            aF(true);
            com.baidu.adp.lib.g.k.fT().e(new aj(this));
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("pullview_should_show_3d_loading", false);
        aF(false);
        String string = com.baidu.tbadk.core.sharedPref.b.uL().getString("pull_image_url", "");
        int g = com.baidu.adp.lib.g.b.g(str3, 0);
        if (str.equals(string)) {
            if (cK(g)) {
                vK();
                return;
            } else if (vO()) {
                com.baidu.adp.lib.g.k.fT().e(new ak(this, str2, g, str));
                return;
            } else {
                b(str, str2, g);
                return;
            }
        }
        b(str, str2, com.baidu.adp.lib.g.b.g(str3, 0));
    }

    public void vK() {
        com.baidu.adp.lib.g.k.fT().e(new al(this));
    }

    public AnimationDrawable cH(int i) {
        Drawable[] drawableArr;
        if (this.afN != null) {
            boolean z = i == 1;
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setColorFilter(z ? this.afV : null);
            for (Drawable drawable : this.afN) {
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
        if (this.afO == null) {
            this.afO = new a[this.afP.length];
            for (int i2 = 0; i2 < this.afP.length; i2++) {
                this.afO[i2] = new a();
            }
        }
        boolean z = i == 1;
        if (z && !this.afQ) {
            this.afQ = true;
            for (int i3 = 0; i3 < this.afP.length; i3++) {
                this.afO[i3].agf = new BitmapDrawable(aq.cQ(this.afP[i3]));
            }
        }
        if (!z && !this.afR) {
            this.afR = true;
            for (int i4 = 0; i4 < this.afP.length; i4++) {
                this.afO[i4].agd = new BitmapDrawable(aq.cQ(this.afP[i4]));
            }
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (a aVar : this.afO) {
            if (aVar != null) {
                Drawable drawable = z ? aVar.agf : aVar.agd;
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
        }
        return animationDrawable;
    }

    public int cJ(int i) {
        if (i == 1) {
            return this.afU;
        }
        return this.afT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vL() {
        boolean z = false;
        String string = com.baidu.tbadk.core.sharedPref.b.uL().getString("pull_image_url", "");
        int i = com.baidu.tbadk.core.sharedPref.b.uL().getInt("pull_image_num", 0);
        this.afT = com.baidu.tbadk.core.sharedPref.b.uL().getInt("pullview_background_color_day", -1315344);
        this.afU = com.baidu.tbadk.core.sharedPref.b.uL().getInt("pullview_background_color_night", -14670029);
        if (!TextUtils.isEmpty(string)) {
            if (i > 0 && cK(i)) {
                this.afN = new Drawable[i];
                File vM = vM();
                if (vM != null) {
                    File[] listFiles = vM.listFiles();
                    for (int i2 = 1; i2 <= i; i2++) {
                        this.afN[i2 - 1] = a(listFiles, String.valueOf(i2) + ".");
                    }
                }
            }
            if (this.afN != null) {
                Drawable[] drawableArr = this.afN;
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
                this.afN = null;
            }
        } else {
            this.afN = null;
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
        File vM = vM();
        if (vM == null) {
            return false;
        }
        File[] listFiles = vM.listFiles();
        if (listFiles == null || listFiles.length < i) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (c(vM, String.valueOf(i3) + ".")) {
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

    private File vM() {
        return s(new File(TbadkCoreApplication.m9getInst().getFilesDir(), "pullImages" + File.separator + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File vN() {
        File file = new File(TbadkCoreApplication.m9getInst().getFilesDir(), "pullImages" + File.separator + "download");
        s(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, "pullFile.zip");
        }
        return null;
    }

    private boolean vO() {
        File vN = vN();
        return vN != null && vN.exists() && vN.isFile() && vN.length() > 0;
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
        vQ();
        com.baidu.tbadk.core.sharedPref.b.uL().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.uL().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.uL().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.uL().remove("pullview_background_color_night");
        dt(str);
        File vN = vN();
        if (d(vN, str2)) {
            com.baidu.tbadk.core.sharedPref.b.uL().putString("pull_image_url", str);
            com.baidu.tbadk.core.sharedPref.b.uL().putInt("pull_image_num", i);
            r(vN);
            vL();
            return;
        }
        deleteDir(vN);
    }

    private void dt(String str) {
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
        File vM = vM();
        if (vM != null && inputStream != null) {
            b(inputStream, new File(vM, str));
        }
    }

    private void p(InputStream inputStream) {
        b(inputStream, vN());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vP() {
        File vN = vN();
        if (vN != null && vN.isFile() && vN.exists()) {
            vN.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vQ() {
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

    public boolean vR() {
        return UtilHelper.detectOpenGLES20(TbadkCoreApplication.m9getInst().getContext()) && this.afS;
    }

    public void aF(boolean z) {
        this.afS = z;
    }
}

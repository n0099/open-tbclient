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
import com.baidu.tieba.r;
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
public class ah {
    private static ah aar;
    private Drawable[] aai;
    private a[] aaj;
    private boolean aal;
    private boolean aam;
    private boolean aan = true;
    private int aao = -1315344;
    private int aap = -14670029;
    private PorterDuffColorFilter aaq = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    private int[] aak = {r.g.listview_pull_refresh01, r.g.listview_pull_refresh02};

    /* loaded from: classes.dex */
    public static class a {
        public Drawable aay;
        public Drawable aaz;
    }

    private ah() {
        aE(com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("pullview_should_show_3d_loading", this.aan));
    }

    public static ah uP() {
        synchronized (ah.class) {
            if (aar == null) {
                aar = new ah();
            }
        }
        return aar;
    }

    public void b(String str, String str2, String str3, String str4, String str5) {
        int i = -1315344;
        int i2 = -14670029;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            com.baidu.tbadk.core.sharedPref.b.tQ().putInt("pullview_background_color_day", -1315344);
            com.baidu.tbadk.core.sharedPref.b.tQ().putInt("pullview_background_color_night", -14670029);
        } else {
            int i3 = com.baidu.tbadk.core.sharedPref.b.tQ().getInt("pullview_background_color_day", -1315344);
            int i4 = com.baidu.tbadk.core.sharedPref.b.tQ().getInt("pullview_background_color_night", -14670029);
            try {
                i = Color.parseColor(str4);
            } catch (Exception e) {
            }
            try {
                i2 = Color.parseColor(str5);
            } catch (Exception e2) {
            }
            if (i3 != i || i2 != i4) {
                com.baidu.tbadk.core.sharedPref.b.tQ().putInt("pullview_background_color_day", i);
                com.baidu.tbadk.core.sharedPref.b.tQ().putInt("pullview_background_color_night", i2);
                this.aao = i;
                this.aap = i2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE));
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("pullview_should_show_3d_loading", true);
            aE(true);
            com.baidu.adp.lib.g.k.eF().e(new ai(this));
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("pullview_should_show_3d_loading", false);
        aE(false);
        String string = com.baidu.tbadk.core.sharedPref.b.tQ().getString("pull_image_url", "");
        int g = com.baidu.adp.lib.g.b.g(str3, 0);
        if (str.equals(string)) {
            if (cL(g)) {
                uQ();
                return;
            } else if (uU()) {
                com.baidu.adp.lib.g.k.eF().e(new aj(this, str2, g, str));
                return;
            } else {
                b(str, str2, g);
                return;
            }
        }
        b(str, str2, com.baidu.adp.lib.g.b.g(str3, 0));
    }

    public void uQ() {
        com.baidu.adp.lib.g.k.eF().e(new ak(this));
    }

    public AnimationDrawable cI(int i) {
        Drawable[] drawableArr;
        if (this.aai != null) {
            boolean z = i == 1;
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setColorFilter(z ? this.aaq : null);
            for (Drawable drawable : this.aai) {
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
            return animationDrawable;
        }
        return null;
    }

    public AnimationDrawable cJ(int i) {
        a[] aVarArr;
        if (this.aaj == null) {
            this.aaj = new a[this.aak.length];
            for (int i2 = 0; i2 < this.aak.length; i2++) {
                this.aaj[i2] = new a();
            }
        }
        boolean z = i == 1;
        if (z && !this.aal) {
            this.aal = true;
            for (int i3 = 0; i3 < this.aak.length; i3++) {
                this.aaj[i3].aaz = new BitmapDrawable(ap.cR(this.aak[i3]));
            }
        }
        if (!z && !this.aam) {
            this.aam = true;
            for (int i4 = 0; i4 < this.aak.length; i4++) {
                this.aaj[i4].aay = new BitmapDrawable(ap.cR(this.aak[i4]));
            }
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (a aVar : this.aaj) {
            if (aVar != null) {
                Drawable drawable = z ? aVar.aaz : aVar.aay;
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
        }
        return animationDrawable;
    }

    public int cK(int i) {
        if (i == 1) {
            return this.aap;
        }
        return this.aao;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uR() {
        boolean z = false;
        String string = com.baidu.tbadk.core.sharedPref.b.tQ().getString("pull_image_url", "");
        int i = com.baidu.tbadk.core.sharedPref.b.tQ().getInt("pull_image_num", 0);
        this.aao = com.baidu.tbadk.core.sharedPref.b.tQ().getInt("pullview_background_color_day", -1315344);
        this.aap = com.baidu.tbadk.core.sharedPref.b.tQ().getInt("pullview_background_color_night", -14670029);
        if (!TextUtils.isEmpty(string)) {
            if (i > 0 && cL(i)) {
                this.aai = new Drawable[i];
                File uS = uS();
                if (uS != null) {
                    File[] listFiles = uS.listFiles();
                    for (int i2 = 1; i2 <= i; i2++) {
                        this.aai[i2 - 1] = a(listFiles, String.valueOf(i2) + ".");
                    }
                }
            }
            if (this.aai != null) {
                Drawable[] drawableArr = this.aai;
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
                this.aai = null;
            }
        } else {
            this.aai = null;
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
    public boolean cL(int i) {
        File uS = uS();
        if (uS == null) {
            return false;
        }
        File[] listFiles = uS.listFiles();
        if (listFiles == null || listFiles.length < i) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (b(uS, String.valueOf(i3) + ".")) {
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

    private File uS() {
        return r(new File(TbadkCoreApplication.m9getInst().getFilesDir(), "pullImages" + File.separator + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File uT() {
        File file = new File(TbadkCoreApplication.m9getInst().getFilesDir(), "pullImages" + File.separator + "download");
        r(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, "pullFile.zip");
        }
        return null;
    }

    private boolean uU() {
        File uT = uT();
        return uT != null && uT.exists() && uT.isFile() && uT.length() > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [480=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(File file, String str) {
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
        com.baidu.adp.lib.g.k.eF().e(new al(this, str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, int i) {
        uW();
        com.baidu.tbadk.core.sharedPref.b.tQ().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.tQ().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.tQ().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.tQ().remove("pullview_background_color_night");
        dt(str);
        File uT = uT();
        if (c(uT, str2)) {
            com.baidu.tbadk.core.sharedPref.b.tQ().putString("pull_image_url", str);
            com.baidu.tbadk.core.sharedPref.b.tQ().putInt("pull_image_num", i);
            q(uT);
            uR();
            return;
        }
        deleteDir(uT);
    }

    private void dt(String str) {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            HttpResponse execute = defaultHttpClient.execute(new HttpGet(str));
            if (execute.getStatusLine().getStatusCode() == 200) {
                m(execute.getEntity().getContent());
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
        File uS = uS();
        if (uS != null && inputStream != null) {
            b(inputStream, new File(uS, str));
        }
    }

    private void m(InputStream inputStream) {
        b(inputStream, uT());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uV() {
        File uT = uT();
        if (uT != null && uT.isFile() && uT.exists()) {
            uT.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uW() {
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

    public boolean uX() {
        return UtilHelper.detectOpenGLES20(TbadkCoreApplication.m9getInst().getContext()) && this.aan;
    }

    public void aE(boolean z) {
        this.aan = z;
    }
}

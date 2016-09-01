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
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
/* loaded from: classes.dex */
public class am {
    private static am abc;
    private Drawable[] aaT;
    private a[] aaU;
    private boolean aaW;
    private boolean aaX;
    private boolean aaY = true;
    private int aaZ = -1315344;
    private int aba = -14670029;
    private PorterDuffColorFilter abb = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    private int[] aaV = {t.f.listview_pull_refresh01, t.f.listview_pull_refresh02};

    /* loaded from: classes.dex */
    public static class a {
        public Drawable abj;
        public Drawable abk;
    }

    private am() {
        aA(com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("pullview_should_show_3d_loading", this.aaY));
    }

    public static am uS() {
        synchronized (am.class) {
            if (abc == null) {
                abc = new am();
            }
        }
        return abc;
    }

    public void b(String str, String str2, String str3, String str4, String str5) {
        int i = -1315344;
        int i2 = -14670029;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            com.baidu.tbadk.core.sharedPref.b.tS().putInt("pullview_background_color_day", -1315344);
            com.baidu.tbadk.core.sharedPref.b.tS().putInt("pullview_background_color_night", -14670029);
        } else {
            int i3 = com.baidu.tbadk.core.sharedPref.b.tS().getInt("pullview_background_color_day", -1315344);
            int i4 = com.baidu.tbadk.core.sharedPref.b.tS().getInt("pullview_background_color_night", -14670029);
            try {
                i = Color.parseColor(str4);
            } catch (Exception e) {
            }
            try {
                i2 = Color.parseColor(str5);
            } catch (Exception e2) {
            }
            if (i3 != i || i2 != i4) {
                com.baidu.tbadk.core.sharedPref.b.tS().putInt("pullview_background_color_day", i);
                com.baidu.tbadk.core.sharedPref.b.tS().putInt("pullview_background_color_night", i2);
                this.aaZ = i;
                this.aba = i2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE));
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("pullview_should_show_3d_loading", true);
            aA(true);
            com.baidu.adp.lib.h.k.eH().e(new an(this));
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("pullview_should_show_3d_loading", false);
        aA(false);
        String string = com.baidu.tbadk.core.sharedPref.b.tS().getString("pull_image_url", "");
        int g = com.baidu.adp.lib.h.b.g(str3, 0);
        if (str.equals(string)) {
            if (cJ(g)) {
                uT();
                return;
            } else if (uX()) {
                com.baidu.adp.lib.h.k.eH().e(new ao(this, str2, g, str));
                return;
            } else {
                b(str, str2, g);
                return;
            }
        }
        b(str, str2, com.baidu.adp.lib.h.b.g(str3, 0));
    }

    public void uT() {
        com.baidu.adp.lib.h.k.eH().e(new ap(this));
    }

    public AnimationDrawable cG(int i) {
        Drawable[] drawableArr;
        if (this.aaT != null) {
            boolean z = i == 1;
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setColorFilter(z ? this.abb : null);
            for (Drawable drawable : this.aaT) {
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
            return animationDrawable;
        }
        return null;
    }

    public AnimationDrawable cH(int i) {
        a[] aVarArr;
        if (this.aaU == null) {
            this.aaU = new a[this.aaV.length];
            for (int i2 = 0; i2 < this.aaV.length; i2++) {
                this.aaU[i2] = new a();
            }
        }
        boolean z = i == 1;
        if (z && !this.aaW) {
            this.aaW = true;
            for (int i3 = 0; i3 < this.aaV.length; i3++) {
                this.aaU[i3].abk = new BitmapDrawable(av.cP(this.aaV[i3]));
            }
        }
        if (!z && !this.aaX) {
            this.aaX = true;
            for (int i4 = 0; i4 < this.aaV.length; i4++) {
                this.aaU[i4].abj = new BitmapDrawable(av.cP(this.aaV[i4]));
            }
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (a aVar : this.aaU) {
            if (aVar != null) {
                Drawable drawable = z ? aVar.abk : aVar.abj;
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
        }
        return animationDrawable;
    }

    public int cI(int i) {
        if (i == 1) {
            return this.aba;
        }
        return this.aaZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uU() {
        boolean z = false;
        String string = com.baidu.tbadk.core.sharedPref.b.tS().getString("pull_image_url", "");
        int i = com.baidu.tbadk.core.sharedPref.b.tS().getInt("pull_image_num", 0);
        this.aaZ = com.baidu.tbadk.core.sharedPref.b.tS().getInt("pullview_background_color_day", -1315344);
        this.aba = com.baidu.tbadk.core.sharedPref.b.tS().getInt("pullview_background_color_night", -14670029);
        if (!TextUtils.isEmpty(string)) {
            if (i > 0 && cJ(i)) {
                this.aaT = new Drawable[i];
                File uV = uV();
                if (uV != null) {
                    File[] listFiles = uV.listFiles();
                    for (int i2 = 1; i2 <= i; i2++) {
                        this.aaT[i2 - 1] = a(listFiles, String.valueOf(i2) + ".");
                    }
                }
            }
            if (this.aaT != null) {
                Drawable[] drawableArr = this.aaT;
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
                this.aaT = null;
            }
        } else {
            this.aaT = null;
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
    public boolean cJ(int i) {
        File uV = uV();
        if (uV == null) {
            return false;
        }
        File[] listFiles = uV.listFiles();
        if (listFiles == null || listFiles.length < i) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (b(uV, String.valueOf(i3) + ".")) {
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

    private File uV() {
        return r(new File(TbadkCoreApplication.m9getInst().getFilesDir(), "pullImages" + File.separator + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File uW() {
        File file = new File(TbadkCoreApplication.m9getInst().getFilesDir(), "pullImages" + File.separator + "download");
        r(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, "pullFile.zip");
        }
        return null;
    }

    private boolean uX() {
        File uW = uW();
        return uW != null && uW.exists() && uW.isFile() && uW.length() > 0;
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
        com.baidu.adp.lib.h.k.eH().e(new aq(this, str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, int i) {
        uZ();
        com.baidu.tbadk.core.sharedPref.b.tS().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.tS().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.tS().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.tS().remove("pullview_background_color_night");
        dr(str);
        File uW = uW();
        if (c(uW, str2)) {
            com.baidu.tbadk.core.sharedPref.b.tS().putString("pull_image_url", str);
            com.baidu.tbadk.core.sharedPref.b.tS().putInt("pull_image_num", i);
            q(uW);
            uU();
            return;
        }
        deleteDir(uW);
    }

    private void dr(String str) {
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
        File uV = uV();
        if (uV != null && inputStream != null) {
            b(inputStream, new File(uV, str));
        }
    }

    private void m(InputStream inputStream) {
        b(inputStream, uW());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uY() {
        File uW = uW();
        if (uW != null && uW.isFile() && uW.exists()) {
            uW.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uZ() {
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

    public boolean va() {
        return UtilHelper.detectOpenGLES20(TbadkCoreApplication.m9getInst().getContext()) && this.aaY;
    }

    public void aA(boolean z) {
        this.aaY = z;
    }
}

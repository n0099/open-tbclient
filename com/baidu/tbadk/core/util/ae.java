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
public class ae {
    private static ae aaN;
    private Drawable[] aaF;
    private a[] aaG;
    private boolean aaI;
    private boolean aaJ;
    private int aaK = -1315344;
    private int aaL = -14670029;
    private PorterDuffColorFilter aaM = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    private int[] aaH = {i.e.listview_pull_refresh01, i.e.listview_pull_refresh02};

    /* loaded from: classes.dex */
    public static class a {
        public Drawable aaU;
        public Drawable aaV;
    }

    private ae() {
    }

    public static ae uv() {
        synchronized (ae.class) {
            if (aaN == null) {
                aaN = new ae();
            }
        }
        return aaN;
    }

    public void b(String str, String str2, String str3, String str4, String str5) {
        int i = -1315344;
        int i2 = -14670029;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            com.baidu.tbadk.core.sharedPref.b.tx().putInt("pullview_background_color_day", -1315344);
            com.baidu.tbadk.core.sharedPref.b.tx().putInt("pullview_background_color_night", -14670029);
        } else {
            int i3 = com.baidu.tbadk.core.sharedPref.b.tx().getInt("pullview_background_color_day", -1315344);
            int i4 = com.baidu.tbadk.core.sharedPref.b.tx().getInt("pullview_background_color_night", -14670029);
            try {
                i = Color.parseColor(str4);
            } catch (Exception e) {
            }
            try {
                i2 = Color.parseColor(str5);
            } catch (Exception e2) {
            }
            if (i3 != i || i2 != i4) {
                com.baidu.tbadk.core.sharedPref.b.tx().putInt("pullview_background_color_day", i);
                com.baidu.tbadk.core.sharedPref.b.tx().putInt("pullview_background_color_night", i2);
                this.aaK = i;
                this.aaL = i2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE));
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.g.k.hg().b(new af(this));
            return;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.tx().getString("pull_image_url", "");
        int g = com.baidu.adp.lib.g.b.g(str3, 0);
        if (str.equals(string)) {
            if (cq(g)) {
                uw();
                return;
            } else if (uA()) {
                com.baidu.adp.lib.g.k.hg().b(new ag(this, str2, g, str));
                return;
            } else {
                c(str, str2, g);
                return;
            }
        }
        c(str, str2, com.baidu.adp.lib.g.b.g(str3, 0));
    }

    public void uw() {
        com.baidu.adp.lib.g.k.hg().b(new ah(this));
    }

    public AnimationDrawable cn(int i) {
        Drawable[] drawableArr;
        if (this.aaF != null) {
            boolean z = i == 1;
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setColorFilter(z ? this.aaM : null);
            for (Drawable drawable : this.aaF) {
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
            return animationDrawable;
        }
        return null;
    }

    public AnimationDrawable co(int i) {
        a[] aVarArr;
        if (this.aaG == null) {
            this.aaG = new a[this.aaH.length];
            for (int i2 = 0; i2 < this.aaH.length; i2++) {
                this.aaG[i2] = new a();
            }
        }
        boolean z = i == 1;
        if (z && !this.aaI) {
            this.aaI = true;
            for (int i3 = 0; i3 < this.aaH.length; i3++) {
                this.aaG[i3].aaV = new BitmapDrawable(al.cw(this.aaH[i3]));
            }
        }
        if (!z && !this.aaJ) {
            this.aaJ = true;
            for (int i4 = 0; i4 < this.aaH.length; i4++) {
                this.aaG[i4].aaU = new BitmapDrawable(al.cw(this.aaH[i4]));
            }
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (a aVar : this.aaG) {
            if (aVar != null) {
                Drawable drawable = z ? aVar.aaV : aVar.aaU;
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
        }
        return animationDrawable;
    }

    public int cp(int i) {
        if (i == 1) {
            return this.aaL;
        }
        return this.aaK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux() {
        boolean z = false;
        String string = com.baidu.tbadk.core.sharedPref.b.tx().getString("pull_image_url", "");
        int i = com.baidu.tbadk.core.sharedPref.b.tx().getInt("pull_image_num", 0);
        this.aaK = com.baidu.tbadk.core.sharedPref.b.tx().getInt("pullview_background_color_day", -1315344);
        this.aaL = com.baidu.tbadk.core.sharedPref.b.tx().getInt("pullview_background_color_night", -14670029);
        if (!TextUtils.isEmpty(string)) {
            if (i > 0 && cq(i)) {
                this.aaF = new Drawable[i];
                File uy = uy();
                if (uy != null) {
                    File[] listFiles = uy.listFiles();
                    for (int i2 = 1; i2 <= i; i2++) {
                        this.aaF[i2 - 1] = a(listFiles, String.valueOf(i2) + ".");
                    }
                }
            }
            if (this.aaF != null) {
                Drawable[] drawableArr = this.aaF;
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
                this.aaF = null;
            }
        } else {
            this.aaF = null;
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
    public boolean cq(int i) {
        File uy = uy();
        if (uy == null) {
            return false;
        }
        File[] listFiles = uy.listFiles();
        if (listFiles == null || listFiles.length < i) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (b(uy, String.valueOf(i3) + ".")) {
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

    private File uy() {
        return t(new File(TbadkCoreApplication.m411getInst().getFilesDir(), "pullImages" + File.separator + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File uz() {
        File file = new File(TbadkCoreApplication.m411getInst().getFilesDir(), "pullImages" + File.separator + "download");
        t(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, "pullFile.zip");
        }
        return null;
    }

    private boolean uA() {
        File uz = uz();
        return uz != null && uz.exists() && uz.isFile() && uz.length() > 0;
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
        com.baidu.adp.lib.g.k.hg().b(new ai(this, str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, int i) {
        uC();
        com.baidu.tbadk.core.sharedPref.b.tx().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.tx().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.tx().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.tx().remove("pullview_background_color_night");
        dc(str);
        File uz = uz();
        if (c(uz, str2)) {
            com.baidu.tbadk.core.sharedPref.b.tx().putString("pull_image_url", str);
            com.baidu.tbadk.core.sharedPref.b.tx().putInt("pull_image_num", i);
            s(uz);
            ux();
            return;
        }
        deleteDir(uz);
    }

    private void dc(String str) {
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
        File uy = uy();
        if (uy != null && inputStream != null) {
            b(inputStream, new File(uy, str));
        }
    }

    private void g(InputStream inputStream) {
        b(inputStream, uz());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uB() {
        File uz = uz();
        if (uz != null && uz.isFile() && uz.exists()) {
            uz.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uC() {
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

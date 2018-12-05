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
import com.baidu.searchbox.ng.ai.apps.scheme.actions.OpenAppAction;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
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
    private static af aBF;
    private boolean aBA;
    private Drawable[] aBw;
    private a[] aBx;
    private boolean aBz;
    private boolean aBB = true;
    private int aBC = -1315344;
    private int aBD = -14670029;
    private PorterDuffColorFilter aBE = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    private int[] aBy = {e.f.listview_pull_refresh01, e.f.listview_pull_refresh02};

    /* loaded from: classes.dex */
    public static class a {
        public Drawable aBM;
        public Drawable aBN;
    }

    private af() {
        bt(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("pullview_should_show_3d_loading", this.aBB));
    }

    public static af Dx() {
        synchronized (af.class) {
            if (aBF == null) {
                aBF = new af();
            }
        }
        return aBF;
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
                this.aBC = i;
                this.aBD = i2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016204));
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pullview_should_show_3d_loading", true);
            bt(true);
            com.baidu.adp.lib.g.h.jH().c(new Runnable() { // from class: com.baidu.tbadk.core.util.af.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pull_image_url");
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pull_image_num");
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pullview_background_color_day");
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pullview_background_color_night");
                    af.this.DE();
                    af.this.Dz();
                }
            });
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pullview_should_show_3d_loading", false);
        bt(false);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("pull_image_url", "");
        final int l = com.baidu.adp.lib.g.b.l(str3, 0);
        if (str.equals(string)) {
            if (dJ(l)) {
                Dy();
                return;
            } else if (DC()) {
                com.baidu.adp.lib.g.h.jH().c(new Runnable() { // from class: com.baidu.tbadk.core.util.af.2
                    @Override // java.lang.Runnable
                    public void run() {
                        File DB = af.this.DB();
                        if (af.this.f(DB, str2)) {
                            af.this.z(DB);
                            if (af.this.dJ(l)) {
                                af.this.Dz();
                                return;
                            }
                        }
                        af.this.DD();
                        af.this.c(str, str2, l);
                    }
                });
                return;
            } else {
                b(str, str2, l);
                return;
            }
        }
        b(str, str2, com.baidu.adp.lib.g.b.l(str3, 0));
    }

    public void Dy() {
        com.baidu.adp.lib.g.h.jH().c(new Runnable() { // from class: com.baidu.tbadk.core.util.af.3
            @Override // java.lang.Runnable
            public void run() {
                af.this.Dz();
            }
        });
    }

    public AnimationDrawable dG(int i) {
        Drawable[] drawableArr;
        if (this.aBw != null) {
            boolean z = i == 1;
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setColorFilter(z ? this.aBE : null);
            for (Drawable drawable : this.aBw) {
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
            return animationDrawable;
        }
        return null;
    }

    public AnimationDrawable dH(int i) {
        a[] aVarArr;
        if (this.aBx == null) {
            this.aBx = new a[this.aBy.length];
            for (int i2 = 0; i2 < this.aBy.length; i2++) {
                this.aBx[i2] = new a();
            }
        }
        boolean z = i == 1;
        if (z && !this.aBz) {
            this.aBz = true;
            for (int i3 = 0; i3 < this.aBy.length; i3++) {
                this.aBx[i3].aBN = new BitmapDrawable(al.dQ(this.aBy[i3]));
            }
        }
        if (!z && !this.aBA) {
            this.aBA = true;
            for (int i4 = 0; i4 < this.aBy.length; i4++) {
                this.aBx[i4].aBM = new BitmapDrawable(al.dQ(this.aBy[i4]));
            }
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (a aVar : this.aBx) {
            if (aVar != null) {
                Drawable drawable = z ? aVar.aBN : aVar.aBM;
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
        }
        return animationDrawable;
    }

    public int dI(int i) {
        if (i == 1) {
            return this.aBD;
        }
        return this.aBC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dz() {
        boolean z = false;
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("pull_image_url", "");
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pull_image_num", 0);
        this.aBC = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pullview_background_color_day", -1315344);
        this.aBD = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pullview_background_color_night", -14670029);
        if (!TextUtils.isEmpty(string)) {
            if (i > 0 && dJ(i)) {
                this.aBw = new Drawable[i];
                File DA = DA();
                if (DA != null) {
                    File[] listFiles = DA.listFiles();
                    for (int i2 = 1; i2 <= i; i2++) {
                        this.aBw[i2 - 1] = a(listFiles, i2 + ".");
                    }
                }
            }
            if (this.aBw != null) {
                Drawable[] drawableArr = this.aBw;
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
                this.aBw = null;
            }
        } else {
            this.aBw = null;
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
    public boolean dJ(int i) {
        File DA = DA();
        if (DA == null) {
            return false;
        }
        File[] listFiles = DA.listFiles();
        if (listFiles == null || listFiles.length < i) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (e(DA, i3 + ".")) {
                i2++;
            }
        }
        return i2 == i;
    }

    private boolean e(File file, String str) {
        File[] listFiles;
        for (File file2 : file.listFiles()) {
            if (file2.exists() && file2.isFile() && !TextUtils.isEmpty(file2.getName()) && file2.getName().startsWith(str) && file2.length() > 0) {
                return true;
            }
        }
        return false;
    }

    private File DA() {
        return A(new File(TbadkCoreApplication.getInst().getFilesDir(), "pullImages" + File.separator + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File DB() {
        File file = new File(TbadkCoreApplication.getInst().getFilesDir(), "pullImages" + File.separator + OpenAppAction.PARAMS_DOWNLOAD_KEY);
        A(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, "pullFile.zip");
        }
        return null;
    }

    private boolean DC() {
        File DB = DB();
        return DB != null && DB.exists() && DB.isFile() && DB.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(File file, String str) {
        FileInputStream fileInputStream;
        String i;
        boolean z = false;
        if (file != null) {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        i = com.baidu.adp.lib.util.s.i(fileInputStream);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.n.h(fileInputStream);
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.n.h(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                com.baidu.adp.lib.util.n.h(fileInputStream);
                throw th;
            }
            if (!TextUtils.isEmpty(i)) {
                if (i.equalsIgnoreCase(str)) {
                    z = true;
                    com.baidu.adp.lib.util.n.h(fileInputStream);
                }
            }
            com.baidu.adp.lib.util.n.h(fileInputStream);
        }
        return z;
    }

    private void b(final String str, final String str2, final int i) {
        com.baidu.adp.lib.g.h.jH().c(new Runnable() { // from class: com.baidu.tbadk.core.util.af.4
            @Override // java.lang.Runnable
            public void run() {
                af.this.c(str, str2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, int i) {
        DE();
        com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pullview_background_color_night");
        fB(str);
        File DB = DB();
        if (f(DB, str2)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("pull_image_url", str);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("pull_image_num", i);
            z(DB);
            Dz();
            return;
        }
        deleteDir(DB);
    }

    private void fB(String str) {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            HttpResponse execute = defaultHttpClient.execute(new HttpGet(str));
            if (execute.getStatusLine().getStatusCode() == 200) {
                l(execute.getEntity().getContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            defaultHttpClient.getConnectionManager().shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(File file) {
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
                                com.baidu.adp.lib.util.n.h(zipInputStream);
                                return;
                            }
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.n.h(zipInputStream);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.util.n.h(zipInputStream);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                zipInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                zipInputStream = null;
                com.baidu.adp.lib.util.n.h(zipInputStream);
                throw th;
            }
        }
    }

    private void b(String str, InputStream inputStream) {
        File DA = DA();
        if (DA != null && inputStream != null) {
            c(inputStream, new File(DA, str));
        }
    }

    private void l(InputStream inputStream) {
        c(inputStream, DB());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DD() {
        File DB = DB();
        if (DB != null && DB.isFile() && DB.exists()) {
            DB.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DE() {
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

    private File A(File file) {
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

    public boolean DF() {
        return UtilHelper.detectOpenGLES20(TbadkCoreApplication.getInst().getContext()) && this.aBB;
    }

    public void bt(boolean z) {
        this.aBB = z;
    }
}

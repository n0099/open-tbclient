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
    private static af ayf;
    private Drawable[] axW;
    private a[] axX;
    private boolean axZ;
    private boolean aya;
    private boolean ayb = true;
    private int ayc = -1315344;
    private int ayd = -14670029;
    private PorterDuffColorFilter aye = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    private int[] axY = {e.f.listview_pull_refresh01, e.f.listview_pull_refresh02};

    /* loaded from: classes.dex */
    public static class a {
        public Drawable aym;
        public Drawable ayn;
    }

    private af() {
        bs(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("pullview_should_show_3d_loading", this.ayb));
    }

    public static af Ct() {
        synchronized (af.class) {
            if (ayf == null) {
                ayf = new af();
            }
        }
        return ayf;
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
                this.ayc = i;
                this.ayd = i2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016204));
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pullview_should_show_3d_loading", true);
            bs(true);
            com.baidu.adp.lib.g.h.jH().c(new Runnable() { // from class: com.baidu.tbadk.core.util.af.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pull_image_url");
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pull_image_num");
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pullview_background_color_day");
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pullview_background_color_night");
                    af.this.CA();
                    af.this.Cv();
                }
            });
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pullview_should_show_3d_loading", false);
        bs(false);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("pull_image_url", "");
        final int l = com.baidu.adp.lib.g.b.l(str3, 0);
        if (str.equals(string)) {
            if (dv(l)) {
                Cu();
                return;
            } else if (Cy()) {
                com.baidu.adp.lib.g.h.jH().c(new Runnable() { // from class: com.baidu.tbadk.core.util.af.2
                    @Override // java.lang.Runnable
                    public void run() {
                        File Cx = af.this.Cx();
                        if (af.this.f(Cx, str2)) {
                            af.this.y(Cx);
                            if (af.this.dv(l)) {
                                af.this.Cv();
                                return;
                            }
                        }
                        af.this.Cz();
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

    public void Cu() {
        com.baidu.adp.lib.g.h.jH().c(new Runnable() { // from class: com.baidu.tbadk.core.util.af.3
            @Override // java.lang.Runnable
            public void run() {
                af.this.Cv();
            }
        });
    }

    public AnimationDrawable ds(int i) {
        Drawable[] drawableArr;
        if (this.axW != null) {
            boolean z = i == 1;
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setColorFilter(z ? this.aye : null);
            for (Drawable drawable : this.axW) {
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
            return animationDrawable;
        }
        return null;
    }

    public AnimationDrawable dt(int i) {
        a[] aVarArr;
        if (this.axX == null) {
            this.axX = new a[this.axY.length];
            for (int i2 = 0; i2 < this.axY.length; i2++) {
                this.axX[i2] = new a();
            }
        }
        boolean z = i == 1;
        if (z && !this.axZ) {
            this.axZ = true;
            for (int i3 = 0; i3 < this.axY.length; i3++) {
                this.axX[i3].ayn = new BitmapDrawable(al.dC(this.axY[i3]));
            }
        }
        if (!z && !this.aya) {
            this.aya = true;
            for (int i4 = 0; i4 < this.axY.length; i4++) {
                this.axX[i4].aym = new BitmapDrawable(al.dC(this.axY[i4]));
            }
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (a aVar : this.axX) {
            if (aVar != null) {
                Drawable drawable = z ? aVar.ayn : aVar.aym;
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
        }
        return animationDrawable;
    }

    public int du(int i) {
        if (i == 1) {
            return this.ayd;
        }
        return this.ayc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cv() {
        boolean z = false;
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("pull_image_url", "");
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pull_image_num", 0);
        this.ayc = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pullview_background_color_day", -1315344);
        this.ayd = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pullview_background_color_night", -14670029);
        if (!TextUtils.isEmpty(string)) {
            if (i > 0 && dv(i)) {
                this.axW = new Drawable[i];
                File Cw = Cw();
                if (Cw != null) {
                    File[] listFiles = Cw.listFiles();
                    for (int i2 = 1; i2 <= i; i2++) {
                        this.axW[i2 - 1] = a(listFiles, i2 + ".");
                    }
                }
            }
            if (this.axW != null) {
                Drawable[] drawableArr = this.axW;
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
                this.axW = null;
            }
        } else {
            this.axW = null;
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
    public boolean dv(int i) {
        File Cw = Cw();
        if (Cw == null) {
            return false;
        }
        File[] listFiles = Cw.listFiles();
        if (listFiles == null || listFiles.length < i) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (e(Cw, i3 + ".")) {
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

    private File Cw() {
        return z(new File(TbadkCoreApplication.getInst().getFilesDir(), "pullImages" + File.separator + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File Cx() {
        File file = new File(TbadkCoreApplication.getInst().getFilesDir(), "pullImages" + File.separator + OpenAppAction.PARAMS_DOWNLOAD_KEY);
        z(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, "pullFile.zip");
        }
        return null;
    }

    private boolean Cy() {
        File Cx = Cx();
        return Cx != null && Cx.exists() && Cx.isFile() && Cx.length() > 0;
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
        CA();
        com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pullview_background_color_night");
        fj(str);
        File Cx = Cx();
        if (f(Cx, str2)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("pull_image_url", str);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("pull_image_num", i);
            y(Cx);
            Cv();
            return;
        }
        deleteDir(Cx);
    }

    private void fj(String str) {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            HttpResponse execute = defaultHttpClient.execute(new HttpGet(str));
            if (execute.getStatusLine().getStatusCode() == 200) {
                k(execute.getEntity().getContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            defaultHttpClient.getConnectionManager().shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(File file) {
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
        File Cw = Cw();
        if (Cw != null && inputStream != null) {
            c(inputStream, new File(Cw, str));
        }
    }

    private void k(InputStream inputStream) {
        c(inputStream, Cx());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cz() {
        File Cx = Cx();
        if (Cx != null && Cx.isFile() && Cx.exists()) {
            Cx.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CA() {
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

    private File z(File file) {
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

    public boolean CB() {
        return UtilHelper.detectOpenGLES20(TbadkCoreApplication.getInst().getContext()) && this.ayb;
    }

    public void bs(boolean z) {
        this.ayb = z;
    }
}

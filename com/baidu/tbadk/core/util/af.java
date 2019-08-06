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
import com.baidu.tieba.R;
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
public class af {
    private static af bSX;
    private a[] bSP;
    private boolean bSR;
    private boolean bSS;
    private Drawable[] drawables;
    private boolean bST = true;
    private int bSU = -1315344;
    private int bSV = -14670029;
    private PorterDuffColorFilter bSW = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    private int[] bSQ = {R.drawable.listview_pull_refresh01, R.drawable.listview_pull_refresh02};

    /* loaded from: classes.dex */
    public static class a {
        public Drawable bTe;
        public Drawable bTf;
    }

    private af() {
        ec(com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("pullview_should_show_3d_loading", this.bST));
    }

    public static af aiU() {
        synchronized (af.class) {
            if (bSX == null) {
                bSX = new af();
            }
        }
        return bSX;
    }

    public void e(final String str, final String str2, String str3, String str4, String str5) {
        int i = -1315344;
        int i2 = -14670029;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("pullview_background_color_day", -1315344);
            com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("pullview_background_color_night", -14670029);
        } else {
            int i3 = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("pullview_background_color_day", -1315344);
            int i4 = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("pullview_background_color_night", -14670029);
            try {
                i = Color.parseColor(str4);
            } catch (Exception e) {
            }
            try {
                i2 = Color.parseColor(str5);
            } catch (Exception e2) {
            }
            if (i3 != i || i2 != i4) {
                com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("pullview_background_color_day", i);
                com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("pullview_background_color_night", i2);
                this.bSU = i;
                this.bSV = i2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016204));
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("pullview_should_show_3d_loading", true);
            ec(true);
            com.baidu.adp.lib.g.h.iL().c(new Runnable() { // from class: com.baidu.tbadk.core.util.af.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.core.sharedPref.b.ahQ().remove("pull_image_url");
                    com.baidu.tbadk.core.sharedPref.b.ahQ().remove("pull_image_num");
                    com.baidu.tbadk.core.sharedPref.b.ahQ().remove("pullview_background_color_day");
                    com.baidu.tbadk.core.sharedPref.b.ahQ().remove("pullview_background_color_night");
                    af.this.ajb();
                    af.this.aiW();
                }
            });
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("pullview_should_show_3d_loading", false);
        ec(false);
        String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("pull_image_url", "");
        final int f = com.baidu.adp.lib.g.b.f(str3, 0);
        if (str.equals(string)) {
            if (ie(f)) {
                aiV();
                return;
            } else if (aiZ()) {
                com.baidu.adp.lib.g.h.iL().c(new Runnable() { // from class: com.baidu.tbadk.core.util.af.2
                    @Override // java.lang.Runnable
                    public void run() {
                        File aiY = af.this.aiY();
                        if (af.this.e(aiY, str2)) {
                            af.this.C(aiY);
                            if (af.this.ie(f)) {
                                af.this.aiW();
                                return;
                            }
                        }
                        af.this.aja();
                        af.this.j(str, str2, f);
                    }
                });
                return;
            } else {
                i(str, str2, f);
                return;
            }
        }
        i(str, str2, com.baidu.adp.lib.g.b.f(str3, 0));
    }

    public void aiV() {
        com.baidu.adp.lib.g.h.iL().c(new Runnable() { // from class: com.baidu.tbadk.core.util.af.3
            @Override // java.lang.Runnable
            public void run() {
                af.this.aiW();
            }
        });
    }

    public AnimationDrawable ib(int i) {
        Drawable[] drawableArr;
        if (this.drawables != null) {
            boolean z = i == 1;
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setColorFilter(z ? this.bSW : null);
            for (Drawable drawable : this.drawables) {
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
            return animationDrawable;
        }
        return null;
    }

    public AnimationDrawable ic(int i) {
        a[] aVarArr;
        if (this.bSP == null) {
            this.bSP = new a[this.bSQ.length];
            for (int i2 = 0; i2 < this.bSQ.length; i2++) {
                this.bSP[i2] = new a();
            }
        }
        boolean z = i == 1;
        if (z && !this.bSR) {
            this.bSR = true;
            for (int i3 = 0; i3 < this.bSQ.length; i3++) {
                this.bSP[i3].bTf = new BitmapDrawable(am.il(this.bSQ[i3]));
            }
        }
        if (!z && !this.bSS) {
            this.bSS = true;
            for (int i4 = 0; i4 < this.bSQ.length; i4++) {
                this.bSP[i4].bTe = new BitmapDrawable(am.il(this.bSQ[i4]));
            }
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (a aVar : this.bSP) {
            if (aVar != null) {
                Drawable drawable = z ? aVar.bTf : aVar.bTe;
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
        }
        return animationDrawable;
    }

    public int id(int i) {
        if (i == 1) {
            return this.bSV;
        }
        return this.bSU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiW() {
        boolean z = false;
        String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("pull_image_url", "");
        int i = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("pull_image_num", 0);
        this.bSU = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("pullview_background_color_day", -1315344);
        this.bSV = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("pullview_background_color_night", -14670029);
        if (!TextUtils.isEmpty(string)) {
            if (i > 0 && ie(i)) {
                this.drawables = new Drawable[i];
                File aiX = aiX();
                if (aiX != null) {
                    File[] listFiles = aiX.listFiles();
                    for (int i2 = 1; i2 <= i; i2++) {
                        this.drawables[i2 - 1] = a(listFiles, i2 + ".");
                    }
                }
            }
            if (this.drawables != null) {
                Drawable[] drawableArr = this.drawables;
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
                this.drawables = null;
            }
        } else {
            this.drawables = null;
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
    public boolean ie(int i) {
        File aiX = aiX();
        if (aiX == null) {
            return false;
        }
        File[] listFiles = aiX.listFiles();
        if (listFiles == null || listFiles.length < i) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (d(aiX, i3 + ".")) {
                i2++;
            }
        }
        return i2 == i;
    }

    private boolean d(File file, String str) {
        File[] listFiles;
        for (File file2 : file.listFiles()) {
            if (file2.exists() && file2.isFile() && !TextUtils.isEmpty(file2.getName()) && file2.getName().startsWith(str) && file2.length() > 0) {
                return true;
            }
        }
        return false;
    }

    private File aiX() {
        return D(new File(TbadkCoreApplication.getInst().getFilesDir(), "pullImages" + File.separator + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File aiY() {
        File file = new File(TbadkCoreApplication.getInst().getFilesDir(), "pullImages" + File.separator + "download");
        D(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, "pullFile.zip");
        }
        return null;
    }

    private boolean aiZ() {
        File aiY = aiY();
        return aiY != null && aiY.exists() && aiY.isFile() && aiY.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(File file, String str) {
        FileInputStream fileInputStream;
        String h;
        boolean z = false;
        if (file != null) {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        h = com.baidu.adp.lib.util.s.h(fileInputStream);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.n.g(fileInputStream);
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.n.g(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                com.baidu.adp.lib.util.n.g(fileInputStream);
                throw th;
            }
            if (!TextUtils.isEmpty(h)) {
                if (h.equalsIgnoreCase(str)) {
                    z = true;
                    com.baidu.adp.lib.util.n.g(fileInputStream);
                }
            }
            com.baidu.adp.lib.util.n.g(fileInputStream);
        }
        return z;
    }

    private void i(final String str, final String str2, final int i) {
        com.baidu.adp.lib.g.h.iL().c(new Runnable() { // from class: com.baidu.tbadk.core.util.af.4
            @Override // java.lang.Runnable
            public void run() {
                af.this.j(str, str2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, String str2, int i) {
        ajb();
        com.baidu.tbadk.core.sharedPref.b.ahQ().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.ahQ().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.ahQ().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.ahQ().remove("pullview_background_color_night");
        nT(str);
        File aiY = aiY();
        if (e(aiY, str2)) {
            com.baidu.tbadk.core.sharedPref.b.ahQ().putString("pull_image_url", str);
            com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("pull_image_num", i);
            C(aiY);
            aiW();
            return;
        }
        deleteDir(aiY);
    }

    private void nT(String str) {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            HttpResponse execute = defaultHttpClient.execute(new HttpGet(str));
            if (execute.getStatusLine().getStatusCode() == 200) {
                n(execute.getEntity().getContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            defaultHttpClient.getConnectionManager().shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(File file) {
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
                                com.baidu.adp.lib.util.n.g(zipInputStream);
                                return;
                            }
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.n.g(zipInputStream);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.util.n.g(zipInputStream);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                zipInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                zipInputStream = null;
                com.baidu.adp.lib.util.n.g(zipInputStream);
                throw th;
            }
        }
    }

    private void b(String str, InputStream inputStream) {
        File aiX = aiX();
        if (aiX != null && inputStream != null) {
            e(inputStream, new File(aiX, str));
        }
    }

    private void n(InputStream inputStream) {
        e(inputStream, aiY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aja() {
        File aiY = aiY();
        if (aiY != null && aiY.isFile() && aiY.exists()) {
            aiY.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajb() {
        deleteDir(new File(TbadkCoreApplication.getInst().getFilesDir(), "pullImages"));
    }

    private void e(InputStream inputStream, File file) {
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
                                com.baidu.adp.lib.util.n.c(fileOutputStream);
                                return;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.n.c(fileOutputStream);
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.n.c(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                com.baidu.adp.lib.util.n.c(fileOutputStream);
                throw th;
            }
        }
    }

    private File D(File file) {
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

    public boolean ajc() {
        return this.bST;
    }

    public void ec(boolean z) {
        this.bST = z;
    }
}

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
import com.baidu.tieba.d;
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
    private static af ahc;
    private Drawable[] agT;
    private a[] agU;
    private boolean agW;
    private boolean agX;
    private boolean agY = true;
    private int agZ = -1315344;
    private int aha = -14670029;
    private PorterDuffColorFilter ahb = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    private int[] agV = {d.f.listview_pull_refresh01, d.f.listview_pull_refresh02};

    /* loaded from: classes.dex */
    public static class a {
        public Drawable ahj;
        public Drawable ahk;
    }

    private af() {
        az(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("pullview_should_show_3d_loading", this.agY));
    }

    public static af ve() {
        synchronized (af.class) {
            if (ahc == null) {
                ahc = new af();
            }
        }
        return ahc;
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
                this.agZ = i;
                this.aha = i2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE));
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pullview_should_show_3d_loading", true);
            az(true);
            com.baidu.adp.lib.g.h.fQ().c(new Runnable() { // from class: com.baidu.tbadk.core.util.af.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pull_image_url");
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pull_image_num");
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pullview_background_color_day");
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pullview_background_color_night");
                    af.this.vl();
                    af.this.vg();
                }
            });
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pullview_should_show_3d_loading", false);
        az(false);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("pull_image_url", "");
        final int g = com.baidu.adp.lib.g.b.g(str3, 0);
        if (str.equals(string)) {
            if (cN(g)) {
                vf();
                return;
            } else if (vj()) {
                com.baidu.adp.lib.g.h.fQ().c(new Runnable() { // from class: com.baidu.tbadk.core.util.af.2
                    @Override // java.lang.Runnable
                    public void run() {
                        File vi = af.this.vi();
                        if (af.this.d(vi, str2)) {
                            af.this.t(vi);
                            if (af.this.cN(g)) {
                                af.this.vg();
                                return;
                            }
                        }
                        af.this.vk();
                        af.this.c(str, str2, g);
                    }
                });
                return;
            } else {
                b(str, str2, g);
                return;
            }
        }
        b(str, str2, com.baidu.adp.lib.g.b.g(str3, 0));
    }

    public void vf() {
        com.baidu.adp.lib.g.h.fQ().c(new Runnable() { // from class: com.baidu.tbadk.core.util.af.3
            @Override // java.lang.Runnable
            public void run() {
                af.this.vg();
            }
        });
    }

    public AnimationDrawable cK(int i) {
        Drawable[] drawableArr;
        if (this.agT != null) {
            boolean z = i == 1;
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setColorFilter(z ? this.ahb : null);
            for (Drawable drawable : this.agT) {
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
            return animationDrawable;
        }
        return null;
    }

    public AnimationDrawable cL(int i) {
        a[] aVarArr;
        if (this.agU == null) {
            this.agU = new a[this.agV.length];
            for (int i2 = 0; i2 < this.agV.length; i2++) {
                this.agU[i2] = new a();
            }
        }
        boolean z = i == 1;
        if (z && !this.agW) {
            this.agW = true;
            for (int i3 = 0; i3 < this.agV.length; i3++) {
                this.agU[i3].ahk = new BitmapDrawable(aj.cT(this.agV[i3]));
            }
        }
        if (!z && !this.agX) {
            this.agX = true;
            for (int i4 = 0; i4 < this.agV.length; i4++) {
                this.agU[i4].ahj = new BitmapDrawable(aj.cT(this.agV[i4]));
            }
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (a aVar : this.agU) {
            if (aVar != null) {
                Drawable drawable = z ? aVar.ahk : aVar.ahj;
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
        }
        return animationDrawable;
    }

    public int cM(int i) {
        if (i == 1) {
            return this.aha;
        }
        return this.agZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vg() {
        boolean z = false;
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("pull_image_url", "");
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pull_image_num", 0);
        this.agZ = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pullview_background_color_day", -1315344);
        this.aha = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pullview_background_color_night", -14670029);
        if (!TextUtils.isEmpty(string)) {
            if (i > 0 && cN(i)) {
                this.agT = new Drawable[i];
                File vh = vh();
                if (vh != null) {
                    File[] listFiles = vh.listFiles();
                    for (int i2 = 1; i2 <= i; i2++) {
                        this.agT[i2 - 1] = a(listFiles, i2 + ".");
                    }
                }
            }
            if (this.agT != null) {
                Drawable[] drawableArr = this.agT;
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
                this.agT = null;
            }
        } else {
            this.agT = null;
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
    public boolean cN(int i) {
        File vh = vh();
        if (vh == null) {
            return false;
        }
        File[] listFiles = vh.listFiles();
        if (listFiles == null || listFiles.length < i) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (c(vh, i3 + ".")) {
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

    private File vh() {
        return u(new File(TbadkCoreApplication.getInst().getFilesDir(), "pullImages" + File.separator + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File vi() {
        File file = new File(TbadkCoreApplication.getInst().getFilesDir(), "pullImages" + File.separator + "download");
        u(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, "pullFile.zip");
        }
        return null;
    }

    private boolean vj() {
        File vi = vi();
        return vi != null && vi.exists() && vi.isFile() && vi.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(File file, String str) {
        FileInputStream fileInputStream;
        String e;
        boolean z = false;
        if (file != null) {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        e = com.baidu.adp.lib.util.s.e(fileInputStream);
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.n.d(fileInputStream);
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.n.d(fileInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                com.baidu.adp.lib.util.n.d(fileInputStream);
                throw th;
            }
            if (!TextUtils.isEmpty(e)) {
                if (e.equalsIgnoreCase(str)) {
                    z = true;
                    com.baidu.adp.lib.util.n.d(fileInputStream);
                }
            }
            com.baidu.adp.lib.util.n.d(fileInputStream);
        }
        return z;
    }

    private void b(final String str, final String str2, final int i) {
        com.baidu.adp.lib.g.h.fQ().c(new Runnable() { // from class: com.baidu.tbadk.core.util.af.4
            @Override // java.lang.Runnable
            public void run() {
                af.this.c(str, str2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, int i) {
        vl();
        com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.getInstance().remove("pullview_background_color_night");
        dM(str);
        File vi = vi();
        if (d(vi, str2)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("pull_image_url", str);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("pull_image_num", i);
            t(vi);
            vg();
            return;
        }
        deleteDir(vi);
    }

    private void dM(String str) {
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
    public void t(File file) {
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
                                com.baidu.adp.lib.util.n.d(zipInputStream);
                                return;
                            }
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.n.d(zipInputStream);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.util.n.d(zipInputStream);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                zipInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                zipInputStream = null;
                com.baidu.adp.lib.util.n.d(zipInputStream);
                throw th;
            }
        }
    }

    private void a(String str, InputStream inputStream) {
        File vh = vh();
        if (vh != null && inputStream != null) {
            c(inputStream, new File(vh, str));
        }
    }

    private void g(InputStream inputStream) {
        c(inputStream, vi());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vk() {
        File vi = vi();
        if (vi != null && vi.isFile() && vi.exists()) {
            vi.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vl() {
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

    private File u(File file) {
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

    public boolean vm() {
        return UtilHelper.detectOpenGLES20(TbadkCoreApplication.getInst().getContext()) && this.agY;
    }

    public void az(boolean z) {
        this.agY = z;
    }
}

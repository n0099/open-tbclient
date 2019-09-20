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
    private static af bTy;
    private a[] bTq;
    private boolean bTs;
    private boolean bTt;
    private Drawable[] drawables;
    private boolean bTu = true;
    private int bTv = -1315344;
    private int bTw = -14670029;
    private PorterDuffColorFilter bTx = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    private int[] bTr = {R.drawable.listview_pull_refresh01, R.drawable.listview_pull_refresh02};

    /* loaded from: classes.dex */
    public static class a {
        public Drawable bTF;
        public Drawable bTG;
    }

    private af() {
        ec(com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("pullview_should_show_3d_loading", this.bTu));
    }

    public static af aiY() {
        synchronized (af.class) {
            if (bTy == null) {
                bTy = new af();
            }
        }
        return bTy;
    }

    public void e(final String str, final String str2, String str3, String str4, String str5) {
        int i = -1315344;
        int i2 = -14670029;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            com.baidu.tbadk.core.sharedPref.b.ahU().putInt("pullview_background_color_day", -1315344);
            com.baidu.tbadk.core.sharedPref.b.ahU().putInt("pullview_background_color_night", -14670029);
        } else {
            int i3 = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("pullview_background_color_day", -1315344);
            int i4 = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("pullview_background_color_night", -14670029);
            try {
                i = Color.parseColor(str4);
            } catch (Exception e) {
            }
            try {
                i2 = Color.parseColor(str5);
            } catch (Exception e2) {
            }
            if (i3 != i || i2 != i4) {
                com.baidu.tbadk.core.sharedPref.b.ahU().putInt("pullview_background_color_day", i);
                com.baidu.tbadk.core.sharedPref.b.ahU().putInt("pullview_background_color_night", i2);
                this.bTv = i;
                this.bTw = i2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016204));
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("pullview_should_show_3d_loading", true);
            ec(true);
            com.baidu.adp.lib.g.h.iL().c(new Runnable() { // from class: com.baidu.tbadk.core.util.af.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.core.sharedPref.b.ahU().remove("pull_image_url");
                    com.baidu.tbadk.core.sharedPref.b.ahU().remove("pull_image_num");
                    com.baidu.tbadk.core.sharedPref.b.ahU().remove("pullview_background_color_day");
                    com.baidu.tbadk.core.sharedPref.b.ahU().remove("pullview_background_color_night");
                    af.this.ajf();
                    af.this.aja();
                }
            });
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("pullview_should_show_3d_loading", false);
        ec(false);
        String string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("pull_image_url", "");
        final int f = com.baidu.adp.lib.g.b.f(str3, 0);
        if (str.equals(string)) {
            if (ie(f)) {
                aiZ();
                return;
            } else if (ajd()) {
                com.baidu.adp.lib.g.h.iL().c(new Runnable() { // from class: com.baidu.tbadk.core.util.af.2
                    @Override // java.lang.Runnable
                    public void run() {
                        File ajc = af.this.ajc();
                        if (af.this.e(ajc, str2)) {
                            af.this.C(ajc);
                            if (af.this.ie(f)) {
                                af.this.aja();
                                return;
                            }
                        }
                        af.this.aje();
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

    public void aiZ() {
        com.baidu.adp.lib.g.h.iL().c(new Runnable() { // from class: com.baidu.tbadk.core.util.af.3
            @Override // java.lang.Runnable
            public void run() {
                af.this.aja();
            }
        });
    }

    public AnimationDrawable ib(int i) {
        Drawable[] drawableArr;
        boolean z = true;
        if (this.drawables != null) {
            if (i != 1 && i != 4) {
                z = false;
            }
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setColorFilter(z ? this.bTx : null);
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
        if (this.bTq == null) {
            this.bTq = new a[this.bTr.length];
            for (int i2 = 0; i2 < this.bTr.length; i2++) {
                this.bTq[i2] = new a();
            }
        }
        boolean z = i == 1 || i == 4;
        if (z && !this.bTs) {
            this.bTs = true;
            for (int i3 = 0; i3 < this.bTr.length; i3++) {
                this.bTq[i3].bTG = new BitmapDrawable(am.il(this.bTr[i3]));
            }
        }
        if (!z && !this.bTt) {
            this.bTt = true;
            for (int i4 = 0; i4 < this.bTr.length; i4++) {
                this.bTq[i4].bTF = new BitmapDrawable(am.il(this.bTr[i4]));
            }
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (a aVar : this.bTq) {
            if (aVar != null) {
                Drawable drawable = z ? aVar.bTG : aVar.bTF;
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
        }
        return animationDrawable;
    }

    public int id(int i) {
        boolean z = true;
        if (i != 1 && i != 4) {
            z = false;
        }
        if (z) {
            return this.bTw;
        }
        return this.bTv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aja() {
        boolean z = false;
        String string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("pull_image_url", "");
        int i = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("pull_image_num", 0);
        this.bTv = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("pullview_background_color_day", -1315344);
        this.bTw = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("pullview_background_color_night", -14670029);
        if (!TextUtils.isEmpty(string)) {
            if (i > 0 && ie(i)) {
                this.drawables = new Drawable[i];
                File ajb = ajb();
                if (ajb != null) {
                    File[] listFiles = ajb.listFiles();
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
        File ajb = ajb();
        if (ajb == null) {
            return false;
        }
        File[] listFiles = ajb.listFiles();
        if (listFiles == null || listFiles.length < i) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (d(ajb, i3 + ".")) {
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

    private File ajb() {
        return D(new File(TbadkCoreApplication.getInst().getFilesDir(), "pullImages" + File.separator + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File ajc() {
        File file = new File(TbadkCoreApplication.getInst().getFilesDir(), "pullImages" + File.separator + "download");
        D(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, "pullFile.zip");
        }
        return null;
    }

    private boolean ajd() {
        File ajc = ajc();
        return ajc != null && ajc.exists() && ajc.isFile() && ajc.length() > 0;
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
        ajf();
        com.baidu.tbadk.core.sharedPref.b.ahU().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.ahU().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.ahU().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.ahU().remove("pullview_background_color_night");
        nV(str);
        File ajc = ajc();
        if (e(ajc, str2)) {
            com.baidu.tbadk.core.sharedPref.b.ahU().putString("pull_image_url", str);
            com.baidu.tbadk.core.sharedPref.b.ahU().putInt("pull_image_num", i);
            C(ajc);
            aja();
            return;
        }
        deleteDir(ajc);
    }

    private void nV(String str) {
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
        File ajb = ajb();
        if (ajb != null && inputStream != null) {
            e(inputStream, new File(ajb, str));
        }
    }

    private void n(InputStream inputStream) {
        e(inputStream, ajc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aje() {
        File ajc = ajc();
        if (ajc != null && ajc.isFile() && ajc.exists()) {
            ajc.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajf() {
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

    public boolean ajg() {
        return this.bTu;
    }

    public void ec(boolean z) {
        this.bTu = z;
    }
}

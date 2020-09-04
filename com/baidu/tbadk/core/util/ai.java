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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
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
public class ai {
    private static ai eku;
    private Drawable[] drawables;
    private a[] eks;
    private boolean hasDayDefault;
    private boolean hasNightDefault;
    private boolean ekt = true;
    private int pullview_backgroundColor_day = -1315344;
    private int pullview_backgroundColor_night = -14670029;
    private PorterDuffColorFilter nightColorSkin = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    private int[] defaultResources = {R.drawable.listview_pull_refresh01, R.drawable.listview_pull_refresh02};

    /* loaded from: classes.dex */
    public static class a {
        public Drawable dayDrawable;
        public Drawable nightDrawable;
    }

    private ai() {
        in(com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.PULL_VIEW_SHOULD_SHOW_3D_LOADING, this.ekt));
    }

    public static ai bjb() {
        synchronized (ai.class) {
            if (eku == null) {
                eku = new ai();
            }
        }
        return eku;
    }

    public void saveOrUpdateImages(final String str, final String str2, String str3, String str4, String str5) {
        int i = -1315344;
        int i2 = -14670029;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.PULL_VIEW_BACKGROUND_COLOR_DAY, -1315344);
            com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.PULL_VIEW_BACKGROUND_COLOR_NIGHT, -14670029);
        } else {
            int i3 = com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.PULL_VIEW_BACKGROUND_COLOR_DAY, -1315344);
            int i4 = com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.PULL_VIEW_BACKGROUND_COLOR_NIGHT, -14670029);
            try {
                i = Color.parseColor(str4);
            } catch (Exception e) {
            }
            try {
                i2 = Color.parseColor(str5);
            } catch (Exception e2) {
            }
            if (i3 != i || i2 != i4) {
                com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.PULL_VIEW_BACKGROUND_COLOR_DAY, i);
                com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.PULL_VIEW_BACKGROUND_COLOR_NIGHT, i2);
                this.pullview_backgroundColor_day = i;
                this.pullview_backgroundColor_night = i2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE));
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.PULL_VIEW_SHOULD_SHOW_3D_LOADING, true);
            in(true);
            com.baidu.adp.lib.f.h.mT().submitTaskToSingleThread(new Runnable() { // from class: com.baidu.tbadk.core.util.ai.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.core.sharedPref.b.bik().remove(SharedPrefConfig.PULL_IMAGE_URL);
                    com.baidu.tbadk.core.sharedPref.b.bik().remove(SharedPrefConfig.PULL_IAMGE_NUM);
                    com.baidu.tbadk.core.sharedPref.b.bik().remove(SharedPrefConfig.PULL_VIEW_BACKGROUND_COLOR_DAY);
                    com.baidu.tbadk.core.sharedPref.b.bik().remove(SharedPrefConfig.PULL_VIEW_BACKGROUND_COLOR_NIGHT);
                    ai.this.deletePullDir();
                    ai.this.buildDrawables();
                }
            });
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.PULL_VIEW_SHOULD_SHOW_3D_LOADING, false);
        in(false);
        String string = com.baidu.tbadk.core.sharedPref.b.bik().getString(SharedPrefConfig.PULL_IMAGE_URL, "");
        final int i5 = com.baidu.adp.lib.f.b.toInt(str3, 0);
        if (str.equals(string)) {
            if (isImagesExist(i5)) {
                buildDrawablesAsync();
                return;
            } else if (isZipFileExist()) {
                com.baidu.adp.lib.f.h.mT().submitTaskToSingleThread(new Runnable() { // from class: com.baidu.tbadk.core.util.ai.2
                    @Override // java.lang.Runnable
                    public void run() {
                        File zipFile = ai.this.getZipFile();
                        if (ai.this.checkFileMd5(zipFile, str2)) {
                            ai.this.decompressZipFile(zipFile);
                            if (ai.this.isImagesExist(i5)) {
                                ai.this.buildDrawables();
                                return;
                            }
                        }
                        ai.this.deleteZipFile();
                        ai.this.startDownload(str, str2, i5);
                    }
                });
                return;
            } else {
                startDownloadAsync(str, str2, i5);
                return;
            }
        }
        startDownloadAsync(str, str2, com.baidu.adp.lib.f.b.toInt(str3, 0));
    }

    public void buildDrawablesAsync() {
        com.baidu.adp.lib.f.h.mT().submitTaskToSingleThread(new Runnable() { // from class: com.baidu.tbadk.core.util.ai.3
            @Override // java.lang.Runnable
            public void run() {
                ai.this.buildDrawables();
            }
        });
    }

    public AnimationDrawable getAnimationDrawable(int i) {
        Drawable[] drawableArr;
        boolean z = true;
        if (this.drawables != null) {
            if (i != 1 && i != 4) {
                z = false;
            }
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setColorFilter(z ? this.nightColorSkin : null);
            for (Drawable drawable : this.drawables) {
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
            return animationDrawable;
        }
        return null;
    }

    public AnimationDrawable getDefaultAnimationDrawable(int i) {
        a[] aVarArr;
        if (this.eks == null) {
            this.eks = new a[this.defaultResources.length];
            for (int i2 = 0; i2 < this.defaultResources.length; i2++) {
                this.eks[i2] = new a();
            }
        }
        boolean z = i == 1 || i == 4;
        if (z && !this.hasNightDefault) {
            this.hasNightDefault = true;
            for (int i3 = 0; i3 < this.defaultResources.length; i3++) {
                this.eks[i3].nightDrawable = new BitmapDrawable(ap.getBitmap565Quality(this.defaultResources[i3]));
            }
        }
        if (!z && !this.hasDayDefault) {
            this.hasDayDefault = true;
            for (int i4 = 0; i4 < this.defaultResources.length; i4++) {
                this.eks[i4].dayDrawable = new BitmapDrawable(ap.getBitmap565Quality(this.defaultResources[i4]));
            }
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (a aVar : this.eks) {
            if (aVar != null) {
                Drawable drawable = z ? aVar.nightDrawable : aVar.dayDrawable;
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
        }
        return animationDrawable;
    }

    public int getPullViewBackgroundColor(int i) {
        boolean z = true;
        if (i != 1 && i != 4) {
            z = false;
        }
        if (z) {
            return this.pullview_backgroundColor_night;
        }
        return this.pullview_backgroundColor_day;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buildDrawables() {
        boolean z = false;
        String string = com.baidu.tbadk.core.sharedPref.b.bik().getString(SharedPrefConfig.PULL_IMAGE_URL, "");
        int i = com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.PULL_IAMGE_NUM, 0);
        this.pullview_backgroundColor_day = com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.PULL_VIEW_BACKGROUND_COLOR_DAY, -1315344);
        this.pullview_backgroundColor_night = com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.PULL_VIEW_BACKGROUND_COLOR_NIGHT, -14670029);
        if (!TextUtils.isEmpty(string)) {
            if (i > 0 && isImagesExist(i)) {
                this.drawables = new Drawable[i];
                File imageFileDir = getImageFileDir();
                if (imageFileDir != null) {
                    File[] listFiles = imageFileDir.listFiles();
                    for (int i2 = 1; i2 <= i; i2++) {
                        this.drawables[i2 - 1] = buildDrawable(listFiles, i2 + ".");
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
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_PULL_IMAGE_CHANGE, true));
    }

    private Drawable buildDrawable(File[] fileArr, String str) {
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
    public boolean isImagesExist(int i) {
        File imageFileDir = getImageFileDir();
        if (imageFileDir == null) {
            return false;
        }
        File[] listFiles = imageFileDir.listFiles();
        if (listFiles == null || listFiles.length < i) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (hasFileName(imageFileDir, i3 + ".")) {
                i2++;
            }
        }
        return i2 == i;
    }

    private boolean hasFileName(File file, String str) {
        File[] listFiles;
        for (File file2 : file.listFiles()) {
            if (file2.exists() && file2.isFile() && !TextUtils.isEmpty(file2.getName()) && file2.getName().startsWith(str) && file2.length() > 0) {
                return true;
            }
        }
        return false;
    }

    private File getImageFileDir() {
        return createFileDir(new File(TbadkCoreApplication.getInst().getFilesDir(), "pullImages" + File.separator + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File getZipFile() {
        File file = new File(TbadkCoreApplication.getInst().getFilesDir(), "pullImages" + File.separator + "download");
        createFileDir(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, "pullFile.zip");
        }
        return null;
    }

    private boolean isZipFileExist() {
        File zipFile = getZipFile();
        return zipFile != null && zipFile.exists() && zipFile.isFile() && zipFile.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkFileMd5(File file, String str) {
        FileInputStream fileInputStream;
        String md5;
        boolean z = false;
        if (file != null) {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        md5 = com.baidu.adp.lib.util.s.toMd5(fileInputStream);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                throw th;
            }
            if (!TextUtils.isEmpty(md5)) {
                if (md5.equalsIgnoreCase(str)) {
                    z = true;
                    com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                }
            }
            com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
        }
        return z;
    }

    private void startDownloadAsync(final String str, final String str2, final int i) {
        com.baidu.adp.lib.f.h.mT().submitTaskToSingleThread(new Runnable() { // from class: com.baidu.tbadk.core.util.ai.4
            @Override // java.lang.Runnable
            public void run() {
                ai.this.startDownload(str, str2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDownload(String str, String str2, int i) {
        deletePullDir();
        com.baidu.tbadk.core.sharedPref.b.bik().remove(SharedPrefConfig.PULL_IMAGE_URL);
        com.baidu.tbadk.core.sharedPref.b.bik().remove(SharedPrefConfig.PULL_IAMGE_NUM);
        com.baidu.tbadk.core.sharedPref.b.bik().remove(SharedPrefConfig.PULL_VIEW_BACKGROUND_COLOR_DAY);
        com.baidu.tbadk.core.sharedPref.b.bik().remove(SharedPrefConfig.PULL_VIEW_BACKGROUND_COLOR_NIGHT);
        downloadZipFile(str);
        File zipFile = getZipFile();
        if (checkFileMd5(zipFile, str2)) {
            com.baidu.tbadk.core.sharedPref.b.bik().putString(SharedPrefConfig.PULL_IMAGE_URL, str);
            com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.PULL_IAMGE_NUM, i);
            decompressZipFile(zipFile);
            buildDrawables();
            return;
        }
        deleteDir(zipFile);
    }

    private void downloadZipFile(String str) {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            HttpResponse execute = defaultHttpClient.execute(new HttpGet(str));
            if (execute.getStatusLine().getStatusCode() == 200) {
                saveZip(execute.getEntity().getContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            defaultHttpClient.getConnectionManager().shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decompressZipFile(File file) {
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
                                        saveImage(name.substring(name.lastIndexOf(File.separator)), zipInputStream);
                                    }
                                }
                            } else {
                                com.baidu.adp.lib.util.n.close((InputStream) zipInputStream);
                                return;
                            }
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.n.close((InputStream) zipInputStream);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.util.n.close((InputStream) zipInputStream);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                zipInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                zipInputStream = null;
                com.baidu.adp.lib.util.n.close((InputStream) zipInputStream);
                throw th;
            }
        }
    }

    private void saveImage(String str, InputStream inputStream) {
        File imageFileDir = getImageFileDir();
        if (imageFileDir != null && inputStream != null) {
            saveFile(inputStream, new File(imageFileDir, str));
        }
    }

    private void saveZip(InputStream inputStream) {
        saveFile(inputStream, getZipFile());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteZipFile() {
        File zipFile = getZipFile();
        if (zipFile != null && zipFile.isFile() && zipFile.exists()) {
            zipFile.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deletePullDir() {
        deleteDir(new File(TbadkCoreApplication.getInst().getFilesDir(), "pullImages"));
    }

    private void saveFile(InputStream inputStream, File file) {
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
                                com.baidu.adp.lib.util.n.close((OutputStream) fileOutputStream);
                                return;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.n.close((OutputStream) fileOutputStream);
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.n.close((OutputStream) fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                com.baidu.adp.lib.util.n.close((OutputStream) fileOutputStream);
                throw th;
            }
        }
    }

    private File createFileDir(File file) {
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

    public boolean bjc() {
        return this.ekt;
    }

    public void in(boolean z) {
        this.ekt = z;
    }
}

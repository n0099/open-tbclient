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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.c.e.m.h;
import d.b.c.e.p.m;
import d.b.c.e.p.q;
import d.b.i0.r.d0.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
/* loaded from: classes3.dex */
public class PullViewHelper {
    public static final long CLOSE_PULLVIEW_DELAYED_TIME = 0;
    public static final int IMAGE_COLORFILTER_NIGHT = -5000269;
    public static final String IMAGE_DIR = "images";
    public static final int PULLVIEW_BGCOLOR_DAY_DEFAULT = -1315344;
    public static final int PULLVIEW_BGCOLOR_NIGHT_DEFAULT = -14670029;
    public static final String PULL_FILE_DIR = "pullImages";
    public static final String ZIP_DIR = "download";
    public static final String ZIP_FILE_NAME = "pullFile.zip";
    public static PullViewHelper sInstance;
    public PullViewDrawable[] defaultDrawables;
    public Drawable[] drawables;
    public boolean hasDayDefault;
    public boolean hasNightDefault;
    public boolean defaultShouldShowLoadingView = true;
    public int pullview_backgroundColor_day = PULLVIEW_BGCOLOR_DAY_DEFAULT;
    public int pullview_backgroundColor_night = PULLVIEW_BGCOLOR_NIGHT_DEFAULT;
    public PorterDuffColorFilter nightColorSkin = new PorterDuffColorFilter(IMAGE_COLORFILTER_NIGHT, PorterDuff.Mode.MULTIPLY);
    public int[] defaultResources = {R.drawable.listview_pull_refresh01, R.drawable.listview_pull_refresh02};

    /* loaded from: classes3.dex */
    public interface CallBack {
        void result(boolean z);
    }

    /* loaded from: classes3.dex */
    public static class PullViewDrawable {
        public Drawable dayDrawable;
        public Drawable nightDrawable;
    }

    public PullViewHelper() {
        setShouldShowLoadingView(b.j().g("pullview_should_show_3d_loading", this.defaultShouldShowLoadingView));
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
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buildDrawables() {
        String p = b.j().p("pull_image_url", "");
        boolean z = false;
        int k = b.j().k("pull_image_num", 0);
        this.pullview_backgroundColor_day = b.j().k("pullview_background_color_day", PULLVIEW_BGCOLOR_DAY_DEFAULT);
        this.pullview_backgroundColor_night = b.j().k("pullview_background_color_night", PULLVIEW_BGCOLOR_NIGHT_DEFAULT);
        if (!TextUtils.isEmpty(p)) {
            if (k > 0 && isImagesExist(k)) {
                this.drawables = new Drawable[k];
                File imageFileDir = getImageFileDir();
                if (imageFileDir != null) {
                    File[] listFiles = imageFileDir.listFiles();
                    for (int i = 1; i <= k; i++) {
                        this.drawables[i - 1] = buildDrawable(listFiles, i + ".");
                    }
                }
            }
            Drawable[] drawableArr = this.drawables;
            if (drawableArr != null) {
                int length = drawableArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = true;
                        break;
                    } else if (drawableArr[i2] == null) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            if (!z) {
                this.drawables = null;
            }
        } else {
            this.drawables = null;
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016203, Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkFileMd5(File file, String str) {
        FileInputStream fileInputStream;
        if (file == null) {
            return false;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            String b2 = q.b(fileInputStream);
            if (!TextUtils.isEmpty(b2)) {
                if (b2.equalsIgnoreCase(str)) {
                    m.e(fileInputStream);
                    return true;
                }
            }
            m.e(fileInputStream);
        } catch (Exception e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            m.e(fileInputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            m.e(fileInputStream2);
            throw th;
        }
        return false;
    }

    private File createFileDir(File file) {
        if ((file.exists() && file.isDirectory()) || file.mkdirs()) {
            return file;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decompressZipFile(File file) {
        if (file == null) {
            return;
        }
        ZipInputStream zipInputStream = null;
        try {
            try {
                ZipInputStream zipInputStream2 = new ZipInputStream(new FileInputStream(file));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry != null) {
                            if (!nextEntry.isDirectory()) {
                                String name = nextEntry.getName();
                                if (!TextUtils.isEmpty(name) && name.contains(File.separator)) {
                                    saveImage(name.substring(name.lastIndexOf(File.separator)), zipInputStream2);
                                }
                            }
                        } else {
                            m.e(zipInputStream2);
                            return;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        zipInputStream = zipInputStream2;
                        e.printStackTrace();
                        m.e(zipInputStream);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        zipInputStream = zipInputStream2;
                        m.e(zipInputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    private void deleteDir(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                deleteDir(file2);
            }
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deletePullDir() {
        deleteDir(new File(TbadkCoreApplication.getInst().getFilesDir(), PULL_FILE_DIR));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteZipFile() {
        File zipFile = getZipFile();
        if (zipFile != null && zipFile.isFile() && zipFile.exists()) {
            zipFile.delete();
        }
    }

    private void downloadZipFile(String str) {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            try {
                HttpResponse execute = defaultHttpClient.execute(new HttpGet(str));
                if (execute.getStatusLine().getStatusCode() == 200) {
                    saveZip(execute.getEntity().getContent());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            defaultHttpClient.getConnectionManager().shutdown();
        }
    }

    private File getImageFileDir() {
        File filesDir = TbadkCoreApplication.getInst().getFilesDir();
        return createFileDir(new File(filesDir, PULL_FILE_DIR + File.separator + "images"));
    }

    public static PullViewHelper getInstance() {
        synchronized (PullViewHelper.class) {
            if (sInstance == null) {
                sInstance = new PullViewHelper();
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File getZipFile() {
        File filesDir = TbadkCoreApplication.getInst().getFilesDir();
        File file = new File(filesDir, PULL_FILE_DIR + File.separator + "download");
        createFileDir(file);
        if (file.exists() && file.isDirectory()) {
            return new File(file, ZIP_FILE_NAME);
        }
        return null;
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isImagesExist(int i) {
        File[] listFiles;
        File imageFileDir = getImageFileDir();
        if (imageFileDir != null && (listFiles = imageFileDir.listFiles()) != null && listFiles.length >= i) {
            int i2 = 0;
            for (int i3 = 1; i3 <= i; i3++) {
                if (hasFileName(imageFileDir, i3 + ".")) {
                    i2++;
                }
            }
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private boolean isZipFileExist() {
        File zipFile = getZipFile();
        return zipFile != null && zipFile.exists() && zipFile.isFile() && zipFile.length() > 0;
    }

    private void saveFile(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        if (file == null || inputStream == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            byte[] bArr = new byte[512];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    m.f(fileOutputStream);
                    return;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            m.f(fileOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            m.f(fileOutputStream2);
            throw th;
        }
    }

    private void saveImage(String str, InputStream inputStream) {
        File imageFileDir = getImageFileDir();
        if (imageFileDir == null || inputStream == null) {
            return;
        }
        saveFile(inputStream, new File(imageFileDir, str));
    }

    private void saveZip(InputStream inputStream) {
        saveFile(inputStream, getZipFile());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDownload(String str, String str2, int i) {
        deletePullDir();
        b.j().C("pull_image_url");
        b.j().C("pull_image_num");
        b.j().C("pullview_background_color_day");
        b.j().C("pullview_background_color_night");
        downloadZipFile(str);
        File zipFile = getZipFile();
        if (checkFileMd5(zipFile, str2)) {
            b.j().x("pull_image_url", str);
            b.j().v("pull_image_num", i);
            decompressZipFile(zipFile);
            buildDrawables();
            return;
        }
        deleteDir(zipFile);
    }

    private void startDownloadAsync(final String str, final String str2, final int i) {
        h.a().c(new Runnable() { // from class: com.baidu.tbadk.core.util.PullViewHelper.4
            @Override // java.lang.Runnable
            public void run() {
                PullViewHelper.this.startDownload(str, str2, i);
            }
        });
    }

    public void buildDrawablesAsync() {
        h.a().c(new Runnable() { // from class: com.baidu.tbadk.core.util.PullViewHelper.3
            @Override // java.lang.Runnable
            public void run() {
                PullViewHelper.this.buildDrawables();
            }
        });
    }

    public AnimationDrawable getAnimationDrawable(int i) {
        Drawable[] drawableArr;
        if (this.drawables != null) {
            boolean z = true;
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
        PullViewDrawable[] pullViewDrawableArr;
        if (this.defaultDrawables == null) {
            this.defaultDrawables = new PullViewDrawable[this.defaultResources.length];
            for (int i2 = 0; i2 < this.defaultResources.length; i2++) {
                this.defaultDrawables[i2] = new PullViewDrawable();
            }
        }
        boolean z = i == 1 || i == 4;
        if (z && !this.hasNightDefault) {
            this.hasNightDefault = true;
            for (int i3 = 0; i3 < this.defaultResources.length; i3++) {
                this.defaultDrawables[i3].nightDrawable = new BitmapDrawable(SkinManager.getBitmap565Quality(this.defaultResources[i3]));
            }
        }
        if (!z && !this.hasDayDefault) {
            this.hasDayDefault = true;
            for (int i4 = 0; i4 < this.defaultResources.length; i4++) {
                this.defaultDrawables[i4].dayDrawable = new BitmapDrawable(SkinManager.getBitmap565Quality(this.defaultResources[i4]));
            }
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (PullViewDrawable pullViewDrawable : this.defaultDrawables) {
            if (pullViewDrawable != null) {
                Drawable drawable = z ? pullViewDrawable.nightDrawable : pullViewDrawable.dayDrawable;
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
        }
        return animationDrawable;
    }

    public boolean getDefaultShowShow3DLoading() {
        return this.defaultShouldShowLoadingView;
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

    public boolean isShouldShowLoadingView() {
        return this.defaultShouldShowLoadingView;
    }

    public void saveOrUpdateImages(final String str, final String str2, String str3, String str4, String str5) {
        boolean isEmpty = TextUtils.isEmpty(str4);
        int i = PULLVIEW_BGCOLOR_NIGHT_DEFAULT;
        int i2 = PULLVIEW_BGCOLOR_DAY_DEFAULT;
        if (!isEmpty && !TextUtils.isEmpty(str5)) {
            int k = b.j().k("pullview_background_color_day", PULLVIEW_BGCOLOR_DAY_DEFAULT);
            int k2 = b.j().k("pullview_background_color_night", PULLVIEW_BGCOLOR_NIGHT_DEFAULT);
            try {
                i2 = Color.parseColor(str4);
            } catch (Exception unused) {
            }
            try {
                i = Color.parseColor(str5);
            } catch (Exception unused2) {
            }
            if (k != i2 || i != k2) {
                b.j().v("pullview_background_color_day", i2);
                b.j().v("pullview_background_color_night", i);
                this.pullview_backgroundColor_day = i2;
                this.pullview_backgroundColor_night = i;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016204));
            }
        } else {
            b.j().v("pullview_background_color_day", PULLVIEW_BGCOLOR_DAY_DEFAULT);
            b.j().v("pullview_background_color_night", PULLVIEW_BGCOLOR_NIGHT_DEFAULT);
        }
        if (TextUtils.isEmpty(str)) {
            b.j().t("pullview_should_show_3d_loading", true);
            setShouldShowLoadingView(true);
            h.a().c(new Runnable() { // from class: com.baidu.tbadk.core.util.PullViewHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    b.j().C("pull_image_url");
                    b.j().C("pull_image_num");
                    b.j().C("pullview_background_color_day");
                    b.j().C("pullview_background_color_night");
                    PullViewHelper.this.deletePullDir();
                    PullViewHelper.this.buildDrawables();
                }
            });
            return;
        }
        b.j().t("pullview_should_show_3d_loading", false);
        setShouldShowLoadingView(false);
        String p = b.j().p("pull_image_url", "");
        final int d2 = d.b.c.e.m.b.d(str3, 0);
        if (str.equals(p)) {
            if (isImagesExist(d2)) {
                buildDrawablesAsync();
                return;
            } else if (isZipFileExist()) {
                h.a().c(new Runnable() { // from class: com.baidu.tbadk.core.util.PullViewHelper.2
                    @Override // java.lang.Runnable
                    public void run() {
                        File zipFile = PullViewHelper.this.getZipFile();
                        if (PullViewHelper.this.checkFileMd5(zipFile, str2)) {
                            PullViewHelper.this.decompressZipFile(zipFile);
                            if (PullViewHelper.this.isImagesExist(d2)) {
                                PullViewHelper.this.buildDrawables();
                                return;
                            }
                        }
                        PullViewHelper.this.deleteZipFile();
                        PullViewHelper.this.startDownload(str, str2, d2);
                    }
                });
                return;
            } else {
                startDownloadAsync(str, str2, d2);
                return;
            }
        }
        startDownloadAsync(str, str2, d.b.c.e.m.b.d(str3, 0));
    }

    public void setShouldShowLoadingView(boolean z) {
        this.defaultShouldShowLoadingView = z;
    }
}

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
import c.a.d.f.m.h;
import c.a.d.f.p.o;
import c.a.d.f.p.t;
import c.a.s0.s.g0.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
/* loaded from: classes11.dex */
public class PullViewHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long CLOSE_PULLVIEW_DELAYED_TIME = 0;
    public static final int IMAGE_COLORFILTER_NIGHT = -5000269;
    public static final String IMAGE_DIR = "images";
    public static final int PULLVIEW_BGCOLOR_DAY_DEFAULT = -1315344;
    public static final int PULLVIEW_BGCOLOR_NIGHT_DEFAULT = -14670029;
    public static final String PULL_FILE_DIR = "pullImages";
    public static final String ZIP_DIR = "download";
    public static final String ZIP_FILE_NAME = "pullFile.zip";
    public static PullViewHelper sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public PullViewDrawable[] defaultDrawables;
    public int[] defaultResources;
    public boolean defaultShouldShowLoadingView;
    public Drawable[] drawables;
    public boolean hasDayDefault;
    public boolean hasNightDefault;
    public PorterDuffColorFilter nightColorSkin;
    public int pullview_backgroundColor_day;
    public int pullview_backgroundColor_night;

    /* loaded from: classes11.dex */
    public interface CallBack {
        void result(boolean z);
    }

    /* loaded from: classes11.dex */
    public static class PullViewDrawable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Drawable dayDrawable;
        public Drawable nightDrawable;

        public PullViewDrawable() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public PullViewHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.defaultShouldShowLoadingView = true;
        this.pullview_backgroundColor_day = PULLVIEW_BGCOLOR_DAY_DEFAULT;
        this.pullview_backgroundColor_night = PULLVIEW_BGCOLOR_NIGHT_DEFAULT;
        this.nightColorSkin = new PorterDuffColorFilter(IMAGE_COLORFILTER_NIGHT, PorterDuff.Mode.MULTIPLY);
        this.defaultResources = new int[]{R.drawable.listview_pull_refresh01, R.drawable.listview_pull_refresh02};
        setShouldShowLoadingView(b.j().g("pullview_should_show_3d_loading", this.defaultShouldShowLoadingView));
    }

    private Drawable buildDrawable(File[] fileArr, String str) {
        InterceptResult invokeLL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, fileArr, str)) == null) {
            if (fileArr == null || fileArr.length == 0 || TextUtils.isEmpty(str)) {
                return null;
            }
            int length = fileArr.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    file = fileArr[i2];
                    if (file != null && file.isFile() && file.length() > 0 && file.getName().startsWith(str)) {
                        break;
                    }
                    i2++;
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
        return (Drawable) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buildDrawables() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            String p = b.j().p("pull_image_url", "");
            boolean z = false;
            int k2 = b.j().k("pull_image_num", 0);
            this.pullview_backgroundColor_day = b.j().k("pullview_background_color_day", PULLVIEW_BGCOLOR_DAY_DEFAULT);
            this.pullview_backgroundColor_night = b.j().k("pullview_background_color_night", PULLVIEW_BGCOLOR_NIGHT_DEFAULT);
            if (!TextUtils.isEmpty(p)) {
                if (k2 > 0 && isImagesExist(k2)) {
                    this.drawables = new Drawable[k2];
                    File imageFileDir = getImageFileDir();
                    if (imageFileDir != null) {
                        File[] listFiles = imageFileDir.listFiles();
                        for (int i2 = 1; i2 <= k2; i2++) {
                            this.drawables[i2 - 1] = buildDrawable(listFiles, i2 + ".");
                        }
                    }
                }
                Drawable[] drawableArr = this.drawables;
                if (drawableArr != null) {
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
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016203, Boolean.TRUE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkFileMd5(File file, String str) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, file, str)) == null) {
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
                String b2 = t.b(fileInputStream);
                if (!TextUtils.isEmpty(b2)) {
                    if (b2.equalsIgnoreCase(str)) {
                        o.e(fileInputStream);
                        return true;
                    }
                }
                o.e(fileInputStream);
            } catch (Exception e3) {
                e = e3;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
                o.e(fileInputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                o.e(fileInputStream2);
                throw th;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private File createFileDir(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, file)) == null) {
            if ((file.exists() && file.isDirectory()) || file.mkdirs()) {
                return file;
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decompressZipFile(File file) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, file) == null) || file == null) {
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
                            o.e(zipInputStream2);
                            return;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        zipInputStream = zipInputStream2;
                        e.printStackTrace();
                        o.e(zipInputStream);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        zipInputStream = zipInputStream2;
                        o.e(zipInputStream);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void deleteDir(File file) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, this, file) == null) || file == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            deleteDir(new File(TbadkCoreApplication.getInst().getFilesDir(), PULL_FILE_DIR));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteZipFile() {
        File zipFile;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65552, this) == null) && (zipFile = getZipFile()) != null && zipFile.isFile() && zipFile.exists()) {
            zipFile.delete();
        }
    }

    private void downloadZipFile(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, str) == null) {
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
    }

    private File getImageFileDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            File filesDir = TbadkCoreApplication.getInst().getFilesDir();
            return createFileDir(new File(filesDir, PULL_FILE_DIR + File.separator + "images"));
        }
        return (File) invokeV.objValue;
    }

    public static PullViewHelper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            synchronized (PullViewHelper.class) {
                if (sInstance == null) {
                    sInstance = new PullViewHelper();
                }
            }
            return sInstance;
        }
        return (PullViewHelper) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File getZipFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            File filesDir = TbadkCoreApplication.getInst().getFilesDir();
            File file = new File(filesDir, PULL_FILE_DIR + File.separator + "download");
            createFileDir(file);
            if (file.exists() && file.isDirectory()) {
                return new File(file, ZIP_FILE_NAME);
            }
            return null;
        }
        return (File) invokeV.objValue;
    }

    private boolean hasFileName(File file, String str) {
        InterceptResult invokeLL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, this, file, str)) == null) {
            for (File file2 : file.listFiles()) {
                if (file2.exists() && file2.isFile() && !TextUtils.isEmpty(file2.getName()) && file2.getName().startsWith(str) && file2.length() > 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isImagesExist(int i2) {
        InterceptResult invokeI;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65558, this, i2)) == null) {
            File imageFileDir = getImageFileDir();
            if (imageFileDir != null && (listFiles = imageFileDir.listFiles()) != null && listFiles.length >= i2) {
                int i3 = 0;
                for (int i4 = 1; i4 <= i2; i4++) {
                    if (hasFileName(imageFileDir, i4 + ".")) {
                        i3++;
                    }
                }
                if (i3 == i2) {
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    private boolean isZipFileExist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            File zipFile = getZipFile();
            return zipFile != null && zipFile.exists() && zipFile.isFile() && zipFile.length() > 0;
        }
        return invokeV.booleanValue;
    }

    private void saveFile(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65560, this, inputStream, file) == null) || file == null || inputStream == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[512];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    o.f(fileOutputStream);
                    return;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            o.f(fileOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            o.f(fileOutputStream2);
            throw th;
        }
    }

    private void saveImage(String str, InputStream inputStream) {
        File imageFileDir;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65561, this, str, inputStream) == null) || (imageFileDir = getImageFileDir()) == null || inputStream == null) {
            return;
        }
        saveFile(inputStream, new File(imageFileDir, str));
    }

    private void saveZip(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, inputStream) == null) {
            saveFile(inputStream, getZipFile());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDownload(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65563, this, str, str2, i2) == null) {
            deletePullDir();
            b.j().C("pull_image_url");
            b.j().C("pull_image_num");
            b.j().C("pullview_background_color_day");
            b.j().C("pullview_background_color_night");
            downloadZipFile(str);
            File zipFile = getZipFile();
            if (checkFileMd5(zipFile, str2)) {
                b.j().x("pull_image_url", str);
                b.j().v("pull_image_num", i2);
                decompressZipFile(zipFile);
                buildDrawables();
                return;
            }
            deleteDir(zipFile);
        }
    }

    private void startDownloadAsync(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65564, this, str, str2, i2) == null) {
            h.a().c(new Runnable(this, str, str2, i2) { // from class: com.baidu.tbadk.core.util.PullViewHelper.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PullViewHelper this$0;
                public final /* synthetic */ String val$downloadUrl;
                public final /* synthetic */ String val$md5;
                public final /* synthetic */ int val$num;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$downloadUrl = str;
                    this.val$md5 = str2;
                    this.val$num = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.startDownload(this.val$downloadUrl, this.val$md5, this.val$num);
                    }
                }
            });
        }
    }

    public void buildDrawablesAsync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h.a().c(new Runnable(this) { // from class: com.baidu.tbadk.core.util.PullViewHelper.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PullViewHelper this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.buildDrawables();
                    }
                }
            });
        }
    }

    public AnimationDrawable getAnimationDrawable(int i2) {
        InterceptResult invokeI;
        Drawable[] drawableArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (this.drawables != null) {
                boolean z = true;
                if (i2 != 1 && i2 != 4) {
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
        return (AnimationDrawable) invokeI.objValue;
    }

    public AnimationDrawable getDefaultAnimationDrawable(int i2) {
        InterceptResult invokeI;
        PullViewDrawable[] pullViewDrawableArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.defaultDrawables == null) {
                this.defaultDrawables = new PullViewDrawable[this.defaultResources.length];
                for (int i3 = 0; i3 < this.defaultResources.length; i3++) {
                    this.defaultDrawables[i3] = new PullViewDrawable();
                }
            }
            boolean z = i2 == 1 || i2 == 4;
            if (z && !this.hasNightDefault) {
                this.hasNightDefault = true;
                for (int i4 = 0; i4 < this.defaultResources.length; i4++) {
                    this.defaultDrawables[i4].nightDrawable = new BitmapDrawable(SkinManager.getBitmap565Quality(this.defaultResources[i4]));
                }
            }
            if (!z && !this.hasDayDefault) {
                this.hasDayDefault = true;
                for (int i5 = 0; i5 < this.defaultResources.length; i5++) {
                    this.defaultDrawables[i5].dayDrawable = new BitmapDrawable(SkinManager.getBitmap565Quality(this.defaultResources[i5]));
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
        return (AnimationDrawable) invokeI.objValue;
    }

    public boolean getDefaultShowShow3DLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.defaultShouldShowLoadingView : invokeV.booleanValue;
    }

    public int getPullViewBackgroundColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            boolean z = true;
            if (i2 != 1 && i2 != 4) {
                z = false;
            }
            if (z) {
                return this.pullview_backgroundColor_night;
            }
            return this.pullview_backgroundColor_day;
        }
        return invokeI.intValue;
    }

    public boolean isShouldShowLoadingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.defaultShouldShowLoadingView : invokeV.booleanValue;
    }

    public void saveOrUpdateImages(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, str, str2, str3, str4, str5) == null) {
            boolean isEmpty = TextUtils.isEmpty(str4);
            int i2 = PULLVIEW_BGCOLOR_NIGHT_DEFAULT;
            int i3 = PULLVIEW_BGCOLOR_DAY_DEFAULT;
            if (!isEmpty && !TextUtils.isEmpty(str5)) {
                int k2 = b.j().k("pullview_background_color_day", PULLVIEW_BGCOLOR_DAY_DEFAULT);
                int k3 = b.j().k("pullview_background_color_night", PULLVIEW_BGCOLOR_NIGHT_DEFAULT);
                try {
                    i3 = Color.parseColor(str4);
                } catch (Exception unused) {
                }
                try {
                    i2 = Color.parseColor(str5);
                } catch (Exception unused2) {
                }
                if (k2 != i3 || i2 != k3) {
                    b.j().v("pullview_background_color_day", i3);
                    b.j().v("pullview_background_color_night", i2);
                    this.pullview_backgroundColor_day = i3;
                    this.pullview_backgroundColor_night = i2;
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016204));
                }
            } else {
                b.j().v("pullview_background_color_day", PULLVIEW_BGCOLOR_DAY_DEFAULT);
                b.j().v("pullview_background_color_night", PULLVIEW_BGCOLOR_NIGHT_DEFAULT);
            }
            if (TextUtils.isEmpty(str)) {
                b.j().t("pullview_should_show_3d_loading", true);
                setShouldShowLoadingView(true);
                h.a().c(new Runnable(this) { // from class: com.baidu.tbadk.core.util.PullViewHelper.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PullViewHelper this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            b.j().C("pull_image_url");
                            b.j().C("pull_image_num");
                            b.j().C("pullview_background_color_day");
                            b.j().C("pullview_background_color_night");
                            this.this$0.deletePullDir();
                            this.this$0.buildDrawables();
                        }
                    }
                });
                return;
            }
            b.j().t("pullview_should_show_3d_loading", false);
            setShouldShowLoadingView(false);
            String p = b.j().p("pull_image_url", "");
            int e2 = c.a.d.f.m.b.e(str3, 0);
            if (str.equals(p)) {
                if (isImagesExist(e2)) {
                    buildDrawablesAsync();
                    return;
                } else if (isZipFileExist()) {
                    h.a().c(new Runnable(this, str2, e2, str) { // from class: com.baidu.tbadk.core.util.PullViewHelper.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ PullViewHelper this$0;
                        public final /* synthetic */ String val$md5;
                        public final /* synthetic */ int val$picNumInteger;
                        public final /* synthetic */ String val$pullImageUrl;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str2, Integer.valueOf(e2), str};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$md5 = str2;
                            this.val$picNumInteger = e2;
                            this.val$pullImageUrl = str;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                File zipFile = this.this$0.getZipFile();
                                if (this.this$0.checkFileMd5(zipFile, this.val$md5)) {
                                    this.this$0.decompressZipFile(zipFile);
                                    if (this.this$0.isImagesExist(this.val$picNumInteger)) {
                                        this.this$0.buildDrawables();
                                        return;
                                    }
                                }
                                this.this$0.deleteZipFile();
                                this.this$0.startDownload(this.val$pullImageUrl, this.val$md5, this.val$picNumInteger);
                            }
                        }
                    });
                    return;
                } else {
                    startDownloadAsync(str, str2, e2);
                    return;
                }
            }
            startDownloadAsync(str, str2, c.a.d.f.m.b.e(str3, 0));
        }
    }

    public void setShouldShowLoadingView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.defaultShouldShowLoadingView = z;
        }
    }
}

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.o65;
import com.baidu.tieba.vg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes4.dex */
public class PullViewHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long CLOSE_PULLVIEW_DELAYED_TIME = 0;
    public static final int IMAGE_COLORFILTER_NIGHT = -5000269;
    public static final String IMAGE_DIR = "images";
    public static final int PULLVIEW_BGCOLOR_DAY_DEFAULT = -1315344;
    public static final int PULLVIEW_BGCOLOR_NIGHT_DEFAULT = -14670029;
    public static final String PULL_FILE_DIR = "pullImages";
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

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        setShouldShowLoadingView(o65.m().i("pullview_should_show_3d_loading", this.defaultShouldShowLoadingView));
    }

    private File createFileDir(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, file)) == null) {
            if (file.exists() && file.isDirectory()) {
                return file;
            }
            if (file.mkdirs()) {
                return file;
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public int getPullViewBackgroundColor(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return this.pullview_backgroundColor_night;
            }
            return this.pullview_backgroundColor_day;
        }
        return invokeI.intValue;
    }

    public void setShouldShowLoadingView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.defaultShouldShowLoadingView = z;
        }
    }

    private Drawable buildDrawable(File[] fileArr, String str) {
        InterceptResult invokeLL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, fileArr, str)) == null) {
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
        return (Drawable) invokeLL.objValue;
    }

    private boolean hasFileName(File file, String str) {
        InterceptResult invokeLL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, file, str)) == null) {
            if (file == null || TextUtils.isEmpty(str) || (listFiles = file.listFiles()) == null) {
                return false;
            }
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists() && file2.isFile() && !TextUtils.isEmpty(file2.getName()) && file2.getName().startsWith(str) && file2.length() > 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buildDrawables() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            String s = o65.m().s("pull_image_url", "");
            boolean z = false;
            int n = o65.m().n("pull_image_num", 0);
            this.pullview_backgroundColor_day = o65.m().n("pullview_background_color_day", PULLVIEW_BGCOLOR_DAY_DEFAULT);
            this.pullview_backgroundColor_night = o65.m().n("pullview_background_color_night", PULLVIEW_BGCOLOR_NIGHT_DEFAULT);
            if (!TextUtils.isEmpty(s)) {
                if (n > 0 && isImagesExist(n)) {
                    this.drawables = new Drawable[n];
                    File imageFileDir = getImageFileDir();
                    if (imageFileDir != null && (listFiles = imageFileDir.listFiles()) != null) {
                        for (int i = 1; i <= n; i++) {
                            this.drawables[i - 1] = buildDrawable(listFiles, i + ".");
                        }
                    }
                }
                Drawable[] drawableArr = this.drawables;
                if (drawableArr != null) {
                    int length = drawableArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            if (drawableArr[i2] == null) {
                                break;
                            }
                            i2++;
                        } else {
                            z = true;
                            break;
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

    private void deleteDir(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, this, file) != null) || file == null) {
            return;
        }
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2 != null) {
                    deleteDir(file2);
                }
            }
            file.delete();
        }
    }

    public AnimationDrawable getAnimationDrawable(int i) {
        InterceptResult invokeI;
        boolean z;
        Drawable[] drawableArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            PorterDuffColorFilter porterDuffColorFilter = null;
            if (this.drawables == null) {
                return null;
            }
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            AnimationDrawable animationDrawable = new AnimationDrawable();
            if (z) {
                porterDuffColorFilter = this.nightColorSkin;
            }
            animationDrawable.setColorFilter(porterDuffColorFilter);
            for (Drawable drawable : this.drawables) {
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
            return animationDrawable;
        }
        return (AnimationDrawable) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deletePullDir() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            deleteDir(new File(TbadkCoreApplication.getInst().getFilesDir(), PULL_FILE_DIR));
        }
    }

    public static PullViewHelper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (PullViewHelper.class) {
                if (sInstance == null) {
                    sInstance = new PullViewHelper();
                }
            }
            return sInstance;
        }
        return (PullViewHelper) invokeV.objValue;
    }

    public boolean isShouldShowLoadingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.defaultShouldShowLoadingView;
        }
        return invokeV.booleanValue;
    }

    private File getImageFileDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            File filesDir = TbadkCoreApplication.getInst().getFilesDir();
            return createFileDir(new File(filesDir, PULL_FILE_DIR + File.separator + "images"));
        }
        return (File) invokeV.objValue;
    }

    private boolean isImagesExist(int i) {
        InterceptResult invokeI;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i)) == null) {
            File imageFileDir = getImageFileDir();
            if (imageFileDir == null || (listFiles = imageFileDir.listFiles()) == null || listFiles.length < i) {
                return false;
            }
            int i2 = 0;
            for (int i3 = 1; i3 <= i; i3++) {
                if (hasFileName(imageFileDir, i3 + ".")) {
                    i2++;
                }
            }
            if (i2 != i) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public AnimationDrawable getDefaultAnimationDrawable(int i) {
        InterceptResult invokeI;
        boolean z;
        PullViewDrawable[] pullViewDrawableArr;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (this.defaultDrawables == null) {
                this.defaultDrawables = new PullViewDrawable[this.defaultResources.length];
                for (int i2 = 0; i2 < this.defaultResources.length; i2++) {
                    this.defaultDrawables[i2] = new PullViewDrawable();
                }
            }
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
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
                    if (z) {
                        drawable = pullViewDrawable.nightDrawable;
                    } else {
                        drawable = pullViewDrawable.dayDrawable;
                    }
                    if (drawable != null) {
                        animationDrawable.addFrame(drawable, 100);
                    }
                }
            }
            return animationDrawable;
        }
        return (AnimationDrawable) invokeI.objValue;
    }

    public void saveOrUpdateImages(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, str, str2, str3, str4, str5) == null) {
            boolean isEmpty = TextUtils.isEmpty(str4);
            int i = PULLVIEW_BGCOLOR_NIGHT_DEFAULT;
            int i2 = PULLVIEW_BGCOLOR_DAY_DEFAULT;
            if (!isEmpty && !TextUtils.isEmpty(str5)) {
                int n = o65.m().n("pullview_background_color_day", PULLVIEW_BGCOLOR_DAY_DEFAULT);
                int n2 = o65.m().n("pullview_background_color_night", PULLVIEW_BGCOLOR_NIGHT_DEFAULT);
                try {
                    i2 = Color.parseColor(str4);
                } catch (Exception unused) {
                }
                try {
                    i = Color.parseColor(str5);
                } catch (Exception unused2) {
                }
                if (n != i2 || i != n2) {
                    o65.m().z("pullview_background_color_day", i2);
                    o65.m().z("pullview_background_color_night", i);
                    this.pullview_backgroundColor_day = i2;
                    this.pullview_backgroundColor_night = i;
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016204));
                }
            } else {
                o65.m().z("pullview_background_color_day", PULLVIEW_BGCOLOR_DAY_DEFAULT);
                o65.m().z("pullview_background_color_night", PULLVIEW_BGCOLOR_NIGHT_DEFAULT);
            }
            o65.m().w("pullview_should_show_3d_loading", true);
            setShouldShowLoadingView(true);
            vg.a().c(new Runnable(this) { // from class: com.baidu.tbadk.core.util.PullViewHelper.1
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
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
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
                        o65.m().H("pull_image_url");
                        o65.m().H("pull_image_num");
                        o65.m().H("pullview_background_color_day");
                        o65.m().H("pullview_background_color_night");
                        this.this$0.deletePullDir();
                        this.this$0.buildDrawables();
                    }
                }
            });
        }
    }
}

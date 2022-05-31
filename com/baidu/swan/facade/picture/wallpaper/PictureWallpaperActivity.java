package com.baidu.swan.facade.picture.wallpaper;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.AnyThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.facade.picture.widget.PictureCropView;
import com.baidu.swan.facade.picture.widget.PictureView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bc3;
import com.repackage.bd3;
import com.repackage.yc3;
import com.repackage.zy2;
import java.io.IOException;
/* loaded from: classes2.dex */
public class PictureWallpaperActivity extends SwanAppBaseActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_PIC_REFERER = "extra_picture_referer";
    public static final String EXTRA_PIC_URL = "extra_picture_url";
    public transient /* synthetic */ FieldHolder $fh;
    public PictureCropView mCropView;
    public LoadingView mLoadingView;
    public String mPicUrl;
    public String mPicUrlReferer;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PictureWallpaperActivity a;

        /* renamed from: com.baidu.swan.facade.picture.wallpaper.PictureWallpaperActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0164a implements PictureView.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0164a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.swan.facade.picture.widget.PictureView.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.onLoadImage(false);
                }
            }

            @Override // com.baidu.swan.facade.picture.widget.PictureView.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.a.onLoadImage(true);
                }
            }
        }

        public a(PictureWallpaperActivity pictureWallpaperActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pictureWallpaperActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pictureWallpaperActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mCropView.setData(this.a.mPicUrl, this.a.mPicUrlReferer, new C0164a(this));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PictureCropView a;
        public final /* synthetic */ PictureWallpaperActivity b;

        public b(PictureWallpaperActivity pictureWallpaperActivity, PictureCropView pictureCropView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pictureWallpaperActivity, pictureCropView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pictureWallpaperActivity;
            this.a = pictureCropView;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bitmap croppedImage = this.a.getCroppedImage();
                if (croppedImage != null) {
                    try {
                        WallpaperManager.getInstance(this.b.getApplicationContext()).setBitmap(croppedImage);
                        z = true;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    this.b.onSetWallpaperResult(z);
                }
                z = false;
                this.b.onSetWallpaperResult(z);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ PictureWallpaperActivity b;

        public c(PictureWallpaperActivity pictureWallpaperActivity, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pictureWallpaperActivity, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pictureWallpaperActivity;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.mLoadingView.setVisibility(8);
                if (this.a) {
                    zy2.f(this.b.getApplicationContext(), R.string.obfuscated_res_0x7f0f1261).v();
                } else {
                    zy2.f(this.b.getApplicationContext(), R.string.obfuscated_res_0x7f0f1260).v();
                }
                this.b.finish();
            }
        }
    }

    public PictureWallpaperActivity() {
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
        this.mPicUrl = null;
        this.mPicUrlReferer = null;
    }

    private void initData(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, intent) == null) {
            if (intent != null) {
                this.mPicUrl = intent.getStringExtra(EXTRA_PIC_URL);
                this.mPicUrlReferer = intent.getStringExtra(EXTRA_PIC_REFERER);
            }
            if (TextUtils.isEmpty(this.mPicUrl)) {
                finish();
            }
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mCropView = (PictureCropView) findViewById(R.id.obfuscated_res_0x7f091847);
            LoadingView loadingView = (LoadingView) findViewById(R.id.obfuscated_res_0x7f091845);
            this.mLoadingView = loadingView;
            loadingView.setMsg(R.string.obfuscated_res_0x7f0f125e);
            findViewById(R.id.obfuscated_res_0x7f091848).setOnClickListener(this);
            findViewById(R.id.obfuscated_res_0x7f091849).setOnClickListener(this);
            this.mCropView.post(new a(this));
        }
    }

    public static void launchWallpaperActivity(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, context, str, str2) == null) {
            Intent intent = new Intent(context, PictureWallpaperActivity.class);
            intent.putExtra(EXTRA_PIC_URL, str);
            intent.putExtra(EXTRA_PIC_REFERER, str2);
            boolean z = context instanceof Activity;
            if (!z) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            context.startActivity(intent);
            if (z) {
                ((Activity) context).overridePendingTransition(R.anim.obfuscated_res_0x7f010022, 0);
            }
        }
    }

    private void onSetWallpaper() {
        PictureCropView pictureCropView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && (pictureCropView = this.mCropView) != null && pictureCropView.f()) {
            this.mLoadingView.setVisibility(0);
            bc3.k(new b(this, pictureCropView), "set-wallpaper");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void onSetWallpaperResult(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, this, z) == null) {
            bd3.e0(new c(this, z));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091848) {
                onBackPressed();
            } else if (id == R.id.obfuscated_res_0x7f091849) {
                onSetWallpaper();
            }
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.repackage.vc4, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            int c0 = bd3.c0(this);
            super.onCreate(bundle);
            bd3.g(this, c0);
            setContentView(R.layout.obfuscated_res_0x7f0d07a9);
            yc3.a(this);
            initData(getIntent());
            initView();
        }
    }

    public void onLoadImage(boolean z) {
        PictureCropView pictureCropView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && (pictureCropView = this.mCropView) != null && z) {
            findViewById(R.id.obfuscated_res_0x7f091849).setEnabled(pictureCropView.f());
        }
    }
}

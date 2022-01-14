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
import c.a.r0.a.c2.b.f.e;
import c.a.r0.a.z2.n0;
import c.a.r0.a.z2.q;
import c.a.r0.a.z2.q0;
import c.a.r0.g.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.facade.picture.widget.PictureCropView;
import com.baidu.swan.facade.picture.widget.PictureView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes11.dex */
public class PictureWallpaperActivity extends SwanAppBaseActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_PIC_REFERER = "extra_picture_referer";
    public static final String EXTRA_PIC_URL = "extra_picture_url";
    public transient /* synthetic */ FieldHolder $fh;
    public PictureCropView mCropView;
    public LoadingView mLoadingView;
    public String mPicUrl;
    public String mPicUrlReferer;

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PictureWallpaperActivity f39572e;

        /* renamed from: com.baidu.swan.facade.picture.wallpaper.PictureWallpaperActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class C1888a implements PictureView.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C1888a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
                    this.a.f39572e.onLoadImage(false);
                }
            }

            @Override // com.baidu.swan.facade.picture.widget.PictureView.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.f39572e.onLoadImage(true);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39572e = pictureWallpaperActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f39572e.mCropView.setData(this.f39572e.mPicUrl, this.f39572e.mPicUrlReferer, new C1888a(this));
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PictureCropView f39573e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PictureWallpaperActivity f39574f;

        public b(PictureWallpaperActivity pictureWallpaperActivity, PictureCropView pictureCropView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pictureWallpaperActivity, pictureCropView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39574f = pictureWallpaperActivity;
            this.f39573e = pictureCropView;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bitmap croppedImage = this.f39573e.getCroppedImage();
                if (croppedImage != null) {
                    try {
                        WallpaperManager.getInstance(this.f39574f.getApplicationContext()).setBitmap(croppedImage);
                        z = true;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    this.f39574f.onSetWallpaperResult(z);
                }
                z = false;
                this.f39574f.onSetWallpaperResult(z);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f39575e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PictureWallpaperActivity f39576f;

        public c(PictureWallpaperActivity pictureWallpaperActivity, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pictureWallpaperActivity, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39576f = pictureWallpaperActivity;
            this.f39575e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f39576f.mLoadingView.setVisibility(8);
                if (this.f39575e) {
                    e.f(this.f39576f.getApplicationContext(), c.a.r0.g.e.swan_app_picture_set_wallpaper_succeed).v();
                } else {
                    e.f(this.f39576f.getApplicationContext(), c.a.r0.g.e.swan_app_picture_set_wallpaper_fail).v();
                }
                this.f39576f.finish();
            }
        }
    }

    public PictureWallpaperActivity() {
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
            this.mCropView = (PictureCropView) findViewById(c.a.r0.g.c.picture_wallpaper_browseview);
            LoadingView loadingView = (LoadingView) findViewById(c.a.r0.g.c.picture_set_wallpaper_loading_view);
            this.mLoadingView = loadingView;
            loadingView.setMsg(c.a.r0.g.e.swan_app_picture_set_wallpaper_doing);
            findViewById(c.a.r0.g.c.picture_wallpaper_cancel).setOnClickListener(this);
            findViewById(c.a.r0.g.c.picture_wallpaper_pick).setOnClickListener(this);
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
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            if (z) {
                ((Activity) context).overridePendingTransition(c.a.r0.g.a.aiapps_slide_in_from_right, 0);
            }
        }
    }

    private void onSetWallpaper() {
        PictureCropView pictureCropView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && (pictureCropView = this.mCropView) != null && pictureCropView.hasSetBitmap()) {
            this.mLoadingView.setVisibility(0);
            q.k(new b(this, pictureCropView), "set-wallpaper");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void onSetWallpaperResult(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, this, z) == null) {
            q0.e0(new c(this, z));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            int id = view.getId();
            if (id == c.a.r0.g.c.picture_wallpaper_cancel) {
                onBackPressed();
            } else if (id == c.a.r0.g.c.picture_wallpaper_pick) {
                onSetWallpaper();
            }
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, c.a.r0.r.a.a.g, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            int c0 = q0.c0(this);
            super.onCreate(bundle);
            q0.g(this, c0);
            setContentView(d.swan_app_pictrue_wallpager_layout);
            n0.a(this);
            initData(getIntent());
            initView();
        }
    }

    public void onLoadImage(boolean z) {
        PictureCropView pictureCropView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && (pictureCropView = this.mCropView) != null && z) {
            findViewById(c.a.r0.g.c.picture_wallpaper_pick).setEnabled(pictureCropView.hasSetBitmap());
        }
    }
}

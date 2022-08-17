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
import com.repackage.qe3;
import com.repackage.r03;
import com.repackage.td3;
import com.repackage.te3;
import java.io.IOException;
/* loaded from: classes3.dex */
public class PictureWallpaperActivity extends SwanAppBaseActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PictureCropView m;
    public LoadingView n;
    public String o;
    public String p;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PictureWallpaperActivity a;

        /* renamed from: com.baidu.swan.facade.picture.wallpaper.PictureWallpaperActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0184a implements PictureView.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0184a(a aVar) {
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
                    this.a.a.J(false);
                }
            }

            @Override // com.baidu.swan.facade.picture.widget.PictureView.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.a.J(true);
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
                this.a.m.setData(this.a.o, this.a.p, new C0184a(this));
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    this.b.L(z);
                }
                z = false;
                this.b.L(z);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.b.n.setVisibility(8);
                if (this.a) {
                    r03.f(this.b.getApplicationContext(), R.string.obfuscated_res_0x7f0f1254).v();
                } else {
                    r03.f(this.b.getApplicationContext(), R.string.obfuscated_res_0x7f0f1253).v();
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
        this.o = null;
        this.p = null;
    }

    public static void H(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, context, str, str2) == null) {
            Intent intent = new Intent(context, PictureWallpaperActivity.class);
            intent.putExtra("extra_picture_url", str);
            intent.putExtra("extra_picture_referer", str2);
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

    public final void F(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
            if (intent != null) {
                this.o = intent.getStringExtra("extra_picture_url");
                this.p = intent.getStringExtra("extra_picture_referer");
            }
            if (TextUtils.isEmpty(this.o)) {
                finish();
            }
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.m = (PictureCropView) findViewById(R.id.obfuscated_res_0x7f091994);
            LoadingView loadingView = (LoadingView) findViewById(R.id.obfuscated_res_0x7f091992);
            this.n = loadingView;
            loadingView.setMsg(R.string.obfuscated_res_0x7f0f1251);
            findViewById(R.id.obfuscated_res_0x7f091995).setOnClickListener(this);
            findViewById(R.id.obfuscated_res_0x7f091996).setOnClickListener(this);
            this.m.post(new a(this));
        }
    }

    public void J(boolean z) {
        PictureCropView pictureCropView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && (pictureCropView = this.m) != null && z) {
            findViewById(R.id.obfuscated_res_0x7f091996).setEnabled(pictureCropView.f());
        }
    }

    public final void K() {
        PictureCropView pictureCropView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (pictureCropView = this.m) != null && pictureCropView.f()) {
            this.n.setVisibility(0);
            td3.k(new b(this, pictureCropView), "set-wallpaper");
        }
    }

    @AnyThread
    public final void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            te3.e0(new c(this, z));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091995) {
                onBackPressed();
            } else if (id == R.id.obfuscated_res_0x7f091996) {
                K();
            }
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.repackage.ne4, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            int c0 = te3.c0(this);
            super.onCreate(bundle);
            te3.g(this, c0);
            setContentView(R.layout.obfuscated_res_0x7f0d07fa);
            qe3.a(this);
            F(getIntent());
            G();
        }
    }
}

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
import com.alibaba.fastjson.asm.Label;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.facade.picture.widget.PictureCropView;
import com.baidu.swan.facade.picture.widget.PictureView;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.q;
import d.a.l0.a.v2.q0;
import d.a.l0.a.z1.b.f.e;
import d.a.l0.e.d;
import java.io.IOException;
/* loaded from: classes3.dex */
public class PictureWallpaperActivity extends SwanAppBaseActivity implements View.OnClickListener {
    public static final String EXTRA_PIC_REFERER = "extra_picture_referer";
    public static final String EXTRA_PIC_URL = "extra_picture_url";
    public PictureCropView mCropView;
    public LoadingView mLoadingView;
    public String mPicUrl = null;
    public String mPicUrlReferer = null;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: com.baidu.swan.facade.picture.wallpaper.PictureWallpaperActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0159a implements PictureView.c {
            public C0159a() {
            }

            @Override // com.baidu.swan.facade.picture.widget.PictureView.c
            public void a() {
                PictureWallpaperActivity.this.onLoadImage(false);
            }

            @Override // com.baidu.swan.facade.picture.widget.PictureView.c
            public void b() {
                PictureWallpaperActivity.this.onLoadImage(true);
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PictureWallpaperActivity.this.mCropView.setData(PictureWallpaperActivity.this.mPicUrl, PictureWallpaperActivity.this.mPicUrlReferer, new C0159a());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PictureCropView f11531e;

        public b(PictureCropView pictureCropView) {
            this.f11531e = pictureCropView;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Bitmap croppedImage = this.f11531e.getCroppedImage();
            if (croppedImage != null) {
                try {
                    WallpaperManager.getInstance(PictureWallpaperActivity.this.getApplicationContext()).setBitmap(croppedImage);
                    z = true;
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                PictureWallpaperActivity.this.onSetWallpaperResult(z);
            }
            z = false;
            PictureWallpaperActivity.this.onSetWallpaperResult(z);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11533e;

        public c(boolean z) {
            this.f11533e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            PictureWallpaperActivity.this.mLoadingView.setVisibility(8);
            if (this.f11533e) {
                e.f(PictureWallpaperActivity.this.getApplicationContext(), d.a.l0.e.e.swan_app_picture_set_wallpaper_succeed).u();
            } else {
                e.f(PictureWallpaperActivity.this.getApplicationContext(), d.a.l0.e.e.swan_app_picture_set_wallpaper_fail).u();
            }
            PictureWallpaperActivity.this.finish();
        }
    }

    private void initData(Intent intent) {
        if (intent != null) {
            this.mPicUrl = intent.getStringExtra(EXTRA_PIC_URL);
            this.mPicUrlReferer = intent.getStringExtra(EXTRA_PIC_REFERER);
        }
        if (TextUtils.isEmpty(this.mPicUrl)) {
            finish();
        }
    }

    private void initView() {
        this.mCropView = (PictureCropView) findViewById(d.a.l0.e.c.picture_wallpaper_browseview);
        LoadingView loadingView = (LoadingView) findViewById(d.a.l0.e.c.picture_set_wallpaper_loading_view);
        this.mLoadingView = loadingView;
        loadingView.setMsg(d.a.l0.e.e.swan_app_picture_set_wallpaper_doing);
        findViewById(d.a.l0.e.c.picture_wallpaper_cancel).setOnClickListener(this);
        findViewById(d.a.l0.e.c.picture_wallpaper_pick).setOnClickListener(this);
        this.mCropView.post(new a());
    }

    public static void launchWallpaperActivity(Context context, String str, String str2) {
        Intent intent = new Intent(context, PictureWallpaperActivity.class);
        intent.putExtra(EXTRA_PIC_URL, str);
        intent.putExtra(EXTRA_PIC_REFERER, str2);
        boolean z = context instanceof Activity;
        if (!z) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        context.startActivity(intent);
        if (z) {
            ((Activity) context).overridePendingTransition(d.a.l0.e.a.aiapps_slide_in_from_right, 0);
        }
    }

    private void onSetWallpaper() {
        PictureCropView pictureCropView = this.mCropView;
        if (pictureCropView == null || !pictureCropView.f()) {
            return;
        }
        this.mLoadingView.setVisibility(0);
        q.j(new b(pictureCropView), "set-wallpaper");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void onSetWallpaperResult(boolean z) {
        q0.b0(new c(z));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.a.l0.e.c.picture_wallpaper_cancel) {
            onBackPressed();
        } else if (id == d.a.l0.e.c.picture_wallpaper_pick) {
            onSetWallpaper();
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, d.a.l0.o.a.a.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int Z = q0.Z(this);
        super.onCreate(bundle);
        q0.g(this, Z);
        setContentView(d.swan_app_pictrue_wallpager_layout);
        n0.a(this);
        initData(getIntent());
        initView();
    }

    public void onLoadImage(boolean z) {
        PictureCropView pictureCropView = this.mCropView;
        if (pictureCropView == null || !z) {
            return;
        }
        findViewById(d.a.l0.e.c.picture_wallpaper_pick).setEnabled(pictureCropView.f());
    }
}

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
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.facade.picture.widget.PictureCropView;
import com.baidu.swan.facade.picture.widget.PictureView;
import com.baidu.tieba.R;
import com.baidu.tieba.tp3;
import com.baidu.tieba.ub3;
import com.baidu.tieba.wo3;
import com.baidu.tieba.wp3;
import java.io.IOException;
/* loaded from: classes4.dex */
public class PictureWallpaperActivity extends SwanAppBaseActivity implements View.OnClickListener {
    public PictureCropView m;
    public LoadingView n;
    public String o = null;
    public String p = null;

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: com.baidu.swan.facade.picture.wallpaper.PictureWallpaperActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0216a implements PictureView.c {
            public C0216a() {
            }

            @Override // com.baidu.swan.facade.picture.widget.PictureView.c
            public void a() {
                PictureWallpaperActivity.this.J(false);
            }

            @Override // com.baidu.swan.facade.picture.widget.PictureView.c
            public void b() {
                PictureWallpaperActivity.this.J(true);
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PictureWallpaperActivity.this.m.setData(PictureWallpaperActivity.this.o, PictureWallpaperActivity.this.p, new C0216a());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ PictureCropView a;

        public b(PictureCropView pictureCropView) {
            this.a = pictureCropView;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Bitmap croppedImage = this.a.getCroppedImage();
            if (croppedImage != null) {
                try {
                    WallpaperManager.getInstance(PictureWallpaperActivity.this.getApplicationContext()).setBitmap(croppedImage);
                    z = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                PictureWallpaperActivity.this.M(z);
            }
            z = false;
            PictureWallpaperActivity.this.M(z);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public final /* synthetic */ boolean a;

        public c(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            PictureWallpaperActivity.this.n.setVisibility(8);
            if (this.a) {
                ub3.f(PictureWallpaperActivity.this.getApplicationContext(), R.string.obfuscated_res_0x7f0f14a2).v();
            } else {
                ub3.f(PictureWallpaperActivity.this.getApplicationContext(), R.string.obfuscated_res_0x7f0f14a1).v();
            }
            PictureWallpaperActivity.this.finish();
        }
    }

    public final void K() {
        PictureCropView pictureCropView = this.m;
        if (pictureCropView != null && pictureCropView.f()) {
            this.n.setVisibility(0);
            wo3.k(new b(pictureCropView), "set-wallpaper");
        }
    }

    public final void G(Intent intent) {
        if (intent != null) {
            this.o = intent.getStringExtra("extra_picture_url");
            this.p = intent.getStringExtra("extra_picture_referer");
        }
        if (TextUtils.isEmpty(this.o)) {
            finish();
        }
    }

    public void J(boolean z) {
        PictureCropView pictureCropView = this.m;
        if (pictureCropView != null && z) {
            findViewById(R.id.obfuscated_res_0x7f091c4f).setEnabled(pictureCropView.f());
        }
    }

    @AnyThread
    public final void M(boolean z) {
        wp3.e0(new c(z));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f091c4e) {
            onBackPressed();
        } else if (id == R.id.obfuscated_res_0x7f091c4f) {
            K();
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.sp4, android.app.Activity
    public void onCreate(Bundle bundle) {
        int c0 = wp3.c0(this);
        super.onCreate(bundle);
        wp3.g(this, c0);
        setContentView(R.layout.obfuscated_res_0x7f0d08ef);
        tp3.a(this);
        G(getIntent());
        H();
    }

    public static void I(Context context, String str, String str2) {
        Intent intent = new Intent(context, PictureWallpaperActivity.class);
        intent.putExtra("extra_picture_url", str);
        intent.putExtra("extra_picture_referer", str2);
        boolean z = context instanceof Activity;
        if (!z) {
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        }
        context.startActivity(intent);
        if (z) {
            ((Activity) context).overridePendingTransition(R.anim.obfuscated_res_0x7f010023, 0);
        }
    }

    public final void H() {
        this.m = (PictureCropView) findViewById(R.id.obfuscated_res_0x7f091c4d);
        LoadingView loadingView = (LoadingView) findViewById(R.id.obfuscated_res_0x7f091c4b);
        this.n = loadingView;
        loadingView.setMsg(R.string.obfuscated_res_0x7f0f149f);
        findViewById(R.id.obfuscated_res_0x7f091c4e).setOnClickListener(this);
        findViewById(R.id.obfuscated_res_0x7f091c4f).setOnClickListener(this);
        this.m.post(new a());
    }
}

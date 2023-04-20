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
import com.baidu.tieba.ml3;
import com.baidu.tieba.n73;
import com.baidu.tieba.pk3;
import com.baidu.tieba.pl3;
import java.io.IOException;
/* loaded from: classes3.dex */
public class PictureWallpaperActivity extends SwanAppBaseActivity implements View.OnClickListener {
    public PictureCropView m;
    public LoadingView n;
    public String o = null;
    public String p = null;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: com.baidu.swan.facade.picture.wallpaper.PictureWallpaperActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0190a implements PictureView.c {
            public C0190a() {
            }

            @Override // com.baidu.swan.facade.picture.widget.PictureView.c
            public void a() {
                PictureWallpaperActivity.this.K(false);
            }

            @Override // com.baidu.swan.facade.picture.widget.PictureView.c
            public void b() {
                PictureWallpaperActivity.this.K(true);
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PictureWallpaperActivity.this.m.setData(PictureWallpaperActivity.this.o, PictureWallpaperActivity.this.p, new C0190a());
        }
    }

    /* loaded from: classes3.dex */
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
                PictureWallpaperActivity.this.N(z);
            }
            z = false;
            PictureWallpaperActivity.this.N(z);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public final /* synthetic */ boolean a;

        public c(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            PictureWallpaperActivity.this.n.setVisibility(8);
            if (this.a) {
                n73.f(PictureWallpaperActivity.this.getApplicationContext(), R.string.obfuscated_res_0x7f0f1344).v();
            } else {
                n73.f(PictureWallpaperActivity.this.getApplicationContext(), R.string.obfuscated_res_0x7f0f1343).v();
            }
            PictureWallpaperActivity.this.finish();
        }
    }

    public final void M() {
        PictureCropView pictureCropView = this.m;
        if (pictureCropView != null && pictureCropView.f()) {
            this.n.setVisibility(0);
            pk3.k(new b(pictureCropView), "set-wallpaper");
        }
    }

    public final void H(Intent intent) {
        if (intent != null) {
            this.o = intent.getStringExtra("extra_picture_url");
            this.p = intent.getStringExtra("extra_picture_referer");
        }
        if (TextUtils.isEmpty(this.o)) {
            finish();
        }
    }

    public void K(boolean z) {
        PictureCropView pictureCropView = this.m;
        if (pictureCropView != null && z) {
            findViewById(R.id.obfuscated_res_0x7f091b60).setEnabled(pictureCropView.f());
        }
    }

    @AnyThread
    public final void N(boolean z) {
        pl3.e0(new c(z));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f091b5f) {
            onBackPressed();
        } else if (id == R.id.obfuscated_res_0x7f091b60) {
            M();
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.ll4, android.app.Activity
    public void onCreate(Bundle bundle) {
        int c0 = pl3.c0(this);
        super.onCreate(bundle);
        pl3.g(this, c0);
        setContentView(R.layout.obfuscated_res_0x7f0d0883);
        ml3.a(this);
        H(getIntent());
        I();
    }

    public static void J(Context context, String str, String str2) {
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

    public final void I() {
        this.m = (PictureCropView) findViewById(R.id.obfuscated_res_0x7f091b5e);
        LoadingView loadingView = (LoadingView) findViewById(R.id.obfuscated_res_0x7f091b5c);
        this.n = loadingView;
        loadingView.setMsg(R.string.obfuscated_res_0x7f0f1341);
        findViewById(R.id.obfuscated_res_0x7f091b5f).setOnClickListener(this);
        findViewById(R.id.obfuscated_res_0x7f091b60).setOnClickListener(this);
        this.m.post(new a());
    }
}

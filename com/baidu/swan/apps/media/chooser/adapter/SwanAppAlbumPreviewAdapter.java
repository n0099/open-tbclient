package com.baidu.swan.apps.media.chooser.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.swan.apps.media.image.HugePhotoDraweeView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.t;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SwanAppAlbumPreviewAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<MediaModel> f12305a;

    /* renamed from: c  reason: collision with root package name */
    public Activity f12307c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.a.b1.d.d.a f12308d;

    /* renamed from: f  reason: collision with root package name */
    public g f12310f;

    /* renamed from: e  reason: collision with root package name */
    public int[] f12309e = new int[1];

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<View> f12306b = new SparseArray<>();

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SwanAppAlbumPreviewAdapter.this.f12308d != null) {
                SwanAppAlbumPreviewAdapter.this.f12308d.clickContainer();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f12312e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f12313f;

        /* loaded from: classes2.dex */
        public class a implements MediaPlayer.OnPreparedListener {

            /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC0170a implements Runnable {
                public RunnableC0170a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    b bVar = b.this;
                    SwanAppAlbumPreviewAdapter.this.r(bVar.f12312e);
                }
            }

            public a() {
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.f12312e.f12327c.postDelayed(new RunnableC0170a(), 300L);
            }
        }

        /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0171b implements MediaPlayer.OnErrorListener {
            public C0171b() {
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                b bVar = b.this;
                SwanAppAlbumPreviewAdapter.this.p(bVar.f12312e);
                return false;
            }
        }

        /* loaded from: classes2.dex */
        public class c implements MediaPlayer.OnCompletionListener {
            public c() {
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                b bVar = b.this;
                SwanAppAlbumPreviewAdapter.this.p(bVar.f12312e);
            }
        }

        public b(g gVar, MediaModel mediaModel) {
            this.f12312e = gVar;
            this.f12313f = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f12312e.f12327c.isPlaying()) {
                return;
            }
            this.f12312e.f12326b.setVisibility(0);
            this.f12312e.f12327c.setVisibility(0);
            this.f12312e.f12328d.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.f12308d != null) {
                SwanAppAlbumPreviewAdapter.this.f12308d.hideBar();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.f12307c);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.f12312e.f12327c.setMediaController(mediaController);
            this.f12312e.f12327c.setVideoPath(this.f12313f.b());
            this.f12312e.f12327c.setOnPreparedListener(new a());
            this.f12312e.f12327c.setOnErrorListener(new C0171b());
            this.f12312e.f12327c.setOnCompletionListener(new c());
            this.f12312e.f12327c.start();
            SwanAppAlbumPreviewAdapter.this.f12310f = this.f12312e;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f12319e;

        public c(g gVar) {
            this.f12319e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f12319e.f12327c.isPlaying()) {
                this.f12319e.f12327c.stopPlayback();
                SwanAppAlbumPreviewAdapter.this.p(this.f12319e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f12321a;

        public d(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, g gVar) {
            this.f12321a = gVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f12321a.f12325a.setVisibility(8);
            this.f12321a.f12325a.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f12322a;

        public e(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, g gVar) {
            this.f12322a = gVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f12322a.f12325a.setVisibility(0);
            this.f12322a.f12325a.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes2.dex */
    public class f extends BaseControllerListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HugePhotoDraweeView f12323a;

        public f(HugePhotoDraweeView hugePhotoDraweeView) {
            this.f12323a = hugePhotoDraweeView;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFailure(String str, Throwable th) {
            super.onFailure(str, th);
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            super.onFinalImageSet(str, obj, animatable);
            if (obj instanceof CloseableStaticBitmap) {
                this.f12323a.setIsDynamicBitmap(false);
                this.f12323a.setZoomEnabled(true);
                Bitmap underlyingBitmap = ((CloseableStaticBitmap) obj).getUnderlyingBitmap();
                SwanAppAlbumPreviewAdapter.this.f12309e = t.b();
                d.b.g0.a.b1.e.b b2 = d.b.g0.a.b1.e.b.b(underlyingBitmap);
                if (underlyingBitmap.getWidth() < SwanAppAlbumPreviewAdapter.this.f12309e[0] && underlyingBitmap.getHeight() < SwanAppAlbumPreviewAdapter.this.f12309e[0]) {
                    b2.m();
                } else {
                    b2.n();
                }
                this.f12323a.setImage(b2);
                SwanAppAlbumPreviewAdapter.this.n(this.f12323a, underlyingBitmap);
            } else if (obj instanceof CloseableAnimatedImage) {
                this.f12323a.setIsDynamicBitmap(true);
                this.f12323a.setZoomEnabled(false);
                this.f12323a.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
            }
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onSubmit(String str, Object obj) {
            super.onSubmit(str, obj);
        }
    }

    /* loaded from: classes2.dex */
    public class g {

        /* renamed from: a  reason: collision with root package name */
        public HugePhotoDraweeView f12325a;

        /* renamed from: b  reason: collision with root package name */
        public View f12326b;

        /* renamed from: c  reason: collision with root package name */
        public VideoView f12327c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f12328d;

        public g(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, View view) {
            this.f12325a = (HugePhotoDraweeView) view.findViewById(d.b.g0.a.f.album_preview_image);
            this.f12326b = view.findViewById(d.b.g0.a.f.preview_video_layout);
            this.f12327c = (VideoView) view.findViewById(d.b.g0.a.f.preview_video_view);
            this.f12328d = (ImageView) view.findViewById(d.b.g0.a.f.video_preview);
        }
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.f12307c = activity;
        this.f12305a = arrayList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f12305a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        g gVar;
        MediaModel mediaModel = this.f12305a.get(i);
        View view = this.f12306b.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.f12307c).inflate(d.b.g0.a.g.swanapp_album_preview_item, viewGroup, false);
            gVar = new g(this, view);
            view.setTag(gVar);
            this.f12306b.put(i, view);
        } else {
            gVar = (g) view.getTag();
        }
        l(gVar, mediaModel);
        m(gVar, mediaModel);
        viewGroup.addView(view);
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void j() {
        g gVar = this.f12310f;
        if (gVar != null) {
            VideoView videoView = gVar.f12327c;
            if (videoView != null && videoView.isPlaying()) {
                videoView.stopPlayback();
            }
            this.f12310f.f12327c = null;
            this.f12310f = null;
        }
    }

    public final ControllerListener k(HugePhotoDraweeView hugePhotoDraweeView) {
        return new f(hugePhotoDraweeView);
    }

    public final void l(g gVar, MediaModel mediaModel) {
        if (gVar == null || mediaModel == null || TextUtils.isEmpty(mediaModel.b())) {
            return;
        }
        ControllerListener k = k(gVar.f12325a);
        String b2 = mediaModel.b();
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(b2.startsWith("http") ? Uri.parse(b2) : Uri.fromFile(new File(mediaModel.b())));
        newBuilderWithSource.setResizeOptions(new ResizeOptions(h0.m(this.f12307c), h0.l(this.f12307c), 10240.0f));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(d.b.g0.a.b1.d.c.c.f43429d).setImageRequest(newBuilderWithSource.build()).setControllerListener(k).setOldController(gVar.f12325a.getController()).build();
        gVar.f12325a.setVisibility(0);
        gVar.f12325a.setController(build);
        if (mediaModel instanceof ImageModel) {
            gVar.f12326b.setVisibility(8);
            gVar.f12325a.setOnClickListener(new a());
        }
    }

    public final void m(g gVar, MediaModel mediaModel) {
        if (!(mediaModel instanceof VideoModel)) {
            gVar.f12328d.setVisibility(8);
        } else if (gVar == null || TextUtils.isEmpty(mediaModel.b())) {
        } else {
            gVar.f12326b.setVisibility(8);
            gVar.f12327c.setVisibility(8);
            gVar.f12328d.setVisibility(0);
            gVar.f12325a.setOnClickListener(new b(gVar, mediaModel));
            gVar.f12326b.setOnClickListener(new c(gVar));
        }
    }

    public final void n(HugePhotoDraweeView hugePhotoDraweeView, Bitmap bitmap) {
        int m = h0.m(this.f12307c);
        int l = h0.l(this.f12307c);
        if (bitmap == null || bitmap.getHeight() <= l * 1.6f) {
            return;
        }
        float width = bitmap.getWidth() == 0 ? 1.0f : m / bitmap.getWidth();
        hugePhotoDraweeView.setDoubleTapZoomScale(width);
        hugePhotoDraweeView.setScaleAndCenter(width, new PointF(m / 2, 0.0f));
    }

    public void o() {
        g gVar = this.f12310f;
        if (gVar == null || gVar.f12327c == null || !this.f12310f.f12327c.isPlaying()) {
            return;
        }
        this.f12310f.f12327c.stopPlayback();
        q(this.f12310f, false);
    }

    public final void p(g gVar) {
        q(gVar, true);
    }

    public final void q(g gVar, boolean z) {
        d.b.g0.a.b1.d.d.a aVar;
        if (gVar == null) {
            return;
        }
        gVar.f12328d.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f12307c, d.b.g0.a.a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new e(this, gVar));
        gVar.f12325a.startAnimation(loadAnimation);
        if (!z || (aVar = this.f12308d) == null) {
            return;
        }
        aVar.showBar();
    }

    public final void r(g gVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f12307c, d.b.g0.a.a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new d(this, gVar));
        gVar.f12325a.startAnimation(loadAnimation);
    }

    public void s(int i, int i2) {
        if (i >= this.f12306b.size() || this.f12306b.get(i) == null) {
            return;
        }
        this.f12306b.get(i).findViewById(d.b.g0.a.f.album_preview_item_root).setBackgroundColor(this.f12307c.getResources().getColor(i2));
    }

    public void u(d.b.g0.a.b1.d.d.a aVar) {
        this.f12308d = aVar;
    }
}

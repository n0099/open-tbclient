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
import d.b.h0.a.i2.h0;
import d.b.h0.a.i2.t;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SwanAppAlbumPreviewAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<MediaModel> f11974a;

    /* renamed from: c  reason: collision with root package name */
    public Activity f11976c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.a.b1.d.d.a f11977d;

    /* renamed from: f  reason: collision with root package name */
    public g f11979f;

    /* renamed from: e  reason: collision with root package name */
    public int[] f11978e = new int[1];

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<View> f11975b = new SparseArray<>();

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SwanAppAlbumPreviewAdapter.this.f11977d != null) {
                SwanAppAlbumPreviewAdapter.this.f11977d.clickContainer();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f11981e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f11982f;

        /* loaded from: classes2.dex */
        public class a implements MediaPlayer.OnPreparedListener {

            /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC0173a implements Runnable {
                public RunnableC0173a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    b bVar = b.this;
                    SwanAppAlbumPreviewAdapter.this.r(bVar.f11981e);
                }
            }

            public a() {
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.f11981e.f11996c.postDelayed(new RunnableC0173a(), 300L);
            }
        }

        /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0174b implements MediaPlayer.OnErrorListener {
            public C0174b() {
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                b bVar = b.this;
                SwanAppAlbumPreviewAdapter.this.p(bVar.f11981e);
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
                SwanAppAlbumPreviewAdapter.this.p(bVar.f11981e);
            }
        }

        public b(g gVar, MediaModel mediaModel) {
            this.f11981e = gVar;
            this.f11982f = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f11981e.f11996c.isPlaying()) {
                return;
            }
            this.f11981e.f11995b.setVisibility(0);
            this.f11981e.f11996c.setVisibility(0);
            this.f11981e.f11997d.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.f11977d != null) {
                SwanAppAlbumPreviewAdapter.this.f11977d.hideBar();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.f11976c);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.f11981e.f11996c.setMediaController(mediaController);
            this.f11981e.f11996c.setVideoPath(this.f11982f.b());
            this.f11981e.f11996c.setOnPreparedListener(new a());
            this.f11981e.f11996c.setOnErrorListener(new C0174b());
            this.f11981e.f11996c.setOnCompletionListener(new c());
            this.f11981e.f11996c.start();
            SwanAppAlbumPreviewAdapter.this.f11979f = this.f11981e;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f11988e;

        public c(g gVar) {
            this.f11988e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f11988e.f11996c.isPlaying()) {
                this.f11988e.f11996c.stopPlayback();
                SwanAppAlbumPreviewAdapter.this.p(this.f11988e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f11990a;

        public d(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, g gVar) {
            this.f11990a = gVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f11990a.f11994a.setVisibility(8);
            this.f11990a.f11994a.clearAnimation();
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
        public final /* synthetic */ g f11991a;

        public e(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, g gVar) {
            this.f11991a = gVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f11991a.f11994a.setVisibility(0);
            this.f11991a.f11994a.clearAnimation();
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
        public final /* synthetic */ HugePhotoDraweeView f11992a;

        public f(HugePhotoDraweeView hugePhotoDraweeView) {
            this.f11992a = hugePhotoDraweeView;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFailure(String str, Throwable th) {
            super.onFailure(str, th);
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            super.onFinalImageSet(str, obj, animatable);
            if (obj instanceof CloseableStaticBitmap) {
                this.f11992a.setIsDynamicBitmap(false);
                this.f11992a.setZoomEnabled(true);
                Bitmap underlyingBitmap = ((CloseableStaticBitmap) obj).getUnderlyingBitmap();
                SwanAppAlbumPreviewAdapter.this.f11978e = t.b();
                d.b.h0.a.b1.e.b b2 = d.b.h0.a.b1.e.b.b(underlyingBitmap);
                if (underlyingBitmap.getWidth() < SwanAppAlbumPreviewAdapter.this.f11978e[0] && underlyingBitmap.getHeight() < SwanAppAlbumPreviewAdapter.this.f11978e[0]) {
                    b2.m();
                } else {
                    b2.n();
                }
                this.f11992a.setImage(b2);
                SwanAppAlbumPreviewAdapter.this.n(this.f11992a, underlyingBitmap);
            } else if (obj instanceof CloseableAnimatedImage) {
                this.f11992a.setIsDynamicBitmap(true);
                this.f11992a.setZoomEnabled(false);
                this.f11992a.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
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
        public HugePhotoDraweeView f11994a;

        /* renamed from: b  reason: collision with root package name */
        public View f11995b;

        /* renamed from: c  reason: collision with root package name */
        public VideoView f11996c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f11997d;

        public g(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, View view) {
            this.f11994a = (HugePhotoDraweeView) view.findViewById(d.b.h0.a.f.album_preview_image);
            this.f11995b = view.findViewById(d.b.h0.a.f.preview_video_layout);
            this.f11996c = (VideoView) view.findViewById(d.b.h0.a.f.preview_video_view);
            this.f11997d = (ImageView) view.findViewById(d.b.h0.a.f.video_preview);
        }
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.f11976c = activity;
        this.f11974a = arrayList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f11974a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        g gVar;
        MediaModel mediaModel = this.f11974a.get(i);
        View view = this.f11975b.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.f11976c).inflate(d.b.h0.a.g.swanapp_album_preview_item, viewGroup, false);
            gVar = new g(this, view);
            view.setTag(gVar);
            this.f11975b.put(i, view);
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
        g gVar = this.f11979f;
        if (gVar != null) {
            VideoView videoView = gVar.f11996c;
            if (videoView != null && videoView.isPlaying()) {
                videoView.stopPlayback();
            }
            this.f11979f.f11996c = null;
            this.f11979f = null;
        }
    }

    public final ControllerListener k(HugePhotoDraweeView hugePhotoDraweeView) {
        return new f(hugePhotoDraweeView);
    }

    public final void l(g gVar, MediaModel mediaModel) {
        if (gVar == null || mediaModel == null || TextUtils.isEmpty(mediaModel.b())) {
            return;
        }
        ControllerListener k = k(gVar.f11994a);
        String b2 = mediaModel.b();
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(b2.startsWith("http") ? Uri.parse(b2) : Uri.fromFile(new File(mediaModel.b())));
        newBuilderWithSource.setResizeOptions(new ResizeOptions(h0.m(this.f11976c), h0.l(this.f11976c), 10240.0f));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(d.b.h0.a.b1.d.c.c.f44150d).setImageRequest(newBuilderWithSource.build()).setControllerListener(k).setOldController(gVar.f11994a.getController()).build();
        gVar.f11994a.setVisibility(0);
        gVar.f11994a.setController(build);
        if (mediaModel instanceof ImageModel) {
            gVar.f11995b.setVisibility(8);
            gVar.f11994a.setOnClickListener(new a());
        }
    }

    public final void m(g gVar, MediaModel mediaModel) {
        if (!(mediaModel instanceof VideoModel)) {
            gVar.f11997d.setVisibility(8);
        } else if (gVar == null || TextUtils.isEmpty(mediaModel.b())) {
        } else {
            gVar.f11995b.setVisibility(8);
            gVar.f11996c.setVisibility(8);
            gVar.f11997d.setVisibility(0);
            gVar.f11994a.setOnClickListener(new b(gVar, mediaModel));
            gVar.f11995b.setOnClickListener(new c(gVar));
        }
    }

    public final void n(HugePhotoDraweeView hugePhotoDraweeView, Bitmap bitmap) {
        int m = h0.m(this.f11976c);
        int l = h0.l(this.f11976c);
        if (bitmap == null || bitmap.getHeight() <= l * 1.6f) {
            return;
        }
        float width = bitmap.getWidth() == 0 ? 1.0f : m / bitmap.getWidth();
        hugePhotoDraweeView.setDoubleTapZoomScale(width);
        hugePhotoDraweeView.setScaleAndCenter(width, new PointF(m / 2, 0.0f));
    }

    public void o() {
        g gVar = this.f11979f;
        if (gVar == null || gVar.f11996c == null || !this.f11979f.f11996c.isPlaying()) {
            return;
        }
        this.f11979f.f11996c.stopPlayback();
        q(this.f11979f, false);
    }

    public final void p(g gVar) {
        q(gVar, true);
    }

    public final void q(g gVar, boolean z) {
        d.b.h0.a.b1.d.d.a aVar;
        if (gVar == null) {
            return;
        }
        gVar.f11997d.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f11976c, d.b.h0.a.a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new e(this, gVar));
        gVar.f11994a.startAnimation(loadAnimation);
        if (!z || (aVar = this.f11977d) == null) {
            return;
        }
        aVar.showBar();
    }

    public final void r(g gVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f11976c, d.b.h0.a.a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new d(this, gVar));
        gVar.f11994a.startAnimation(loadAnimation);
    }

    public void s(int i, int i2) {
        if (i >= this.f11975b.size() || this.f11975b.get(i) == null) {
            return;
        }
        this.f11975b.get(i).findViewById(d.b.h0.a.f.album_preview_item_root).setBackgroundColor(this.f11976c.getResources().getColor(i2));
    }

    public void u(d.b.h0.a.b1.d.d.a aVar) {
        this.f11977d = aVar;
    }
}

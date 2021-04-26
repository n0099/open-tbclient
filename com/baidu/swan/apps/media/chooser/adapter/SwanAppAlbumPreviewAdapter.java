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
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.t;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SwanAppAlbumPreviewAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<MediaModel> f11812a;

    /* renamed from: c  reason: collision with root package name */
    public Activity f11814c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.h0.a.b1.d.d.a f11815d;

    /* renamed from: f  reason: collision with root package name */
    public g f11817f;

    /* renamed from: e  reason: collision with root package name */
    public int[] f11816e = new int[1];

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<View> f11813b = new SparseArray<>();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SwanAppAlbumPreviewAdapter.this.f11815d != null) {
                SwanAppAlbumPreviewAdapter.this.f11815d.clickContainer();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f11819e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f11820f;

        /* loaded from: classes3.dex */
        public class a implements MediaPlayer.OnPreparedListener {

            /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0168a implements Runnable {
                public RunnableC0168a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    b bVar = b.this;
                    SwanAppAlbumPreviewAdapter.this.r(bVar.f11819e);
                }
            }

            public a() {
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.f11819e.f11834c.postDelayed(new RunnableC0168a(), 300L);
            }
        }

        /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0169b implements MediaPlayer.OnErrorListener {
            public C0169b() {
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                b bVar = b.this;
                SwanAppAlbumPreviewAdapter.this.p(bVar.f11819e);
                return false;
            }
        }

        /* loaded from: classes3.dex */
        public class c implements MediaPlayer.OnCompletionListener {
            public c() {
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                b bVar = b.this;
                SwanAppAlbumPreviewAdapter.this.p(bVar.f11819e);
            }
        }

        public b(g gVar, MediaModel mediaModel) {
            this.f11819e = gVar;
            this.f11820f = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f11819e.f11834c.isPlaying()) {
                return;
            }
            this.f11819e.f11833b.setVisibility(0);
            this.f11819e.f11834c.setVisibility(0);
            this.f11819e.f11835d.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.f11815d != null) {
                SwanAppAlbumPreviewAdapter.this.f11815d.hideBar();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.f11814c);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.f11819e.f11834c.setMediaController(mediaController);
            this.f11819e.f11834c.setVideoPath(this.f11820f.b());
            this.f11819e.f11834c.setOnPreparedListener(new a());
            this.f11819e.f11834c.setOnErrorListener(new C0169b());
            this.f11819e.f11834c.setOnCompletionListener(new c());
            this.f11819e.f11834c.start();
            SwanAppAlbumPreviewAdapter.this.f11817f = this.f11819e;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f11826e;

        public c(g gVar) {
            this.f11826e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f11826e.f11834c.isPlaying()) {
                this.f11826e.f11834c.stopPlayback();
                SwanAppAlbumPreviewAdapter.this.p(this.f11826e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f11828a;

        public d(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, g gVar) {
            this.f11828a = gVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f11828a.f11832a.setVisibility(8);
            this.f11828a.f11832a.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f11829a;

        public e(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, g gVar) {
            this.f11829a = gVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f11829a.f11832a.setVisibility(0);
            this.f11829a.f11832a.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes3.dex */
    public class f extends BaseControllerListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HugePhotoDraweeView f11830a;

        public f(HugePhotoDraweeView hugePhotoDraweeView) {
            this.f11830a = hugePhotoDraweeView;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFailure(String str, Throwable th) {
            super.onFailure(str, th);
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            super.onFinalImageSet(str, obj, animatable);
            if (obj instanceof CloseableStaticBitmap) {
                this.f11830a.setIsDynamicBitmap(false);
                this.f11830a.setZoomEnabled(true);
                Bitmap underlyingBitmap = ((CloseableStaticBitmap) obj).getUnderlyingBitmap();
                SwanAppAlbumPreviewAdapter.this.f11816e = t.b();
                d.a.h0.a.b1.e.b b2 = d.a.h0.a.b1.e.b.b(underlyingBitmap);
                if (underlyingBitmap.getWidth() < SwanAppAlbumPreviewAdapter.this.f11816e[0] && underlyingBitmap.getHeight() < SwanAppAlbumPreviewAdapter.this.f11816e[0]) {
                    b2.m();
                } else {
                    b2.n();
                }
                this.f11830a.setImage(b2);
                SwanAppAlbumPreviewAdapter.this.n(this.f11830a, underlyingBitmap);
            } else if (obj instanceof CloseableAnimatedImage) {
                this.f11830a.setIsDynamicBitmap(true);
                this.f11830a.setZoomEnabled(false);
                this.f11830a.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
            }
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onSubmit(String str, Object obj) {
            super.onSubmit(str, obj);
        }
    }

    /* loaded from: classes3.dex */
    public class g {

        /* renamed from: a  reason: collision with root package name */
        public HugePhotoDraweeView f11832a;

        /* renamed from: b  reason: collision with root package name */
        public View f11833b;

        /* renamed from: c  reason: collision with root package name */
        public VideoView f11834c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f11835d;

        public g(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, View view) {
            this.f11832a = (HugePhotoDraweeView) view.findViewById(d.a.h0.a.f.album_preview_image);
            this.f11833b = view.findViewById(d.a.h0.a.f.preview_video_layout);
            this.f11834c = (VideoView) view.findViewById(d.a.h0.a.f.preview_video_view);
            this.f11835d = (ImageView) view.findViewById(d.a.h0.a.f.video_preview);
        }
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.f11814c = activity;
        this.f11812a = arrayList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f11812a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        g gVar;
        MediaModel mediaModel = this.f11812a.get(i2);
        View view = this.f11813b.get(i2);
        if (view == null) {
            view = LayoutInflater.from(this.f11814c).inflate(d.a.h0.a.g.swanapp_album_preview_item, viewGroup, false);
            gVar = new g(this, view);
            view.setTag(gVar);
            this.f11813b.put(i2, view);
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
        g gVar = this.f11817f;
        if (gVar != null) {
            VideoView videoView = gVar.f11834c;
            if (videoView != null && videoView.isPlaying()) {
                videoView.stopPlayback();
            }
            this.f11817f.f11834c = null;
            this.f11817f = null;
        }
    }

    public final ControllerListener k(HugePhotoDraweeView hugePhotoDraweeView) {
        return new f(hugePhotoDraweeView);
    }

    public final void l(g gVar, MediaModel mediaModel) {
        if (gVar == null || mediaModel == null || TextUtils.isEmpty(mediaModel.b())) {
            return;
        }
        ControllerListener k = k(gVar.f11832a);
        String b2 = mediaModel.b();
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(b2.startsWith("http") ? Uri.parse(b2) : Uri.fromFile(new File(mediaModel.b())));
        newBuilderWithSource.setResizeOptions(new ResizeOptions(h0.m(this.f11814c), h0.l(this.f11814c), 10240.0f));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(d.a.h0.a.b1.d.c.c.f41425d).setImageRequest(newBuilderWithSource.build()).setControllerListener(k).setOldController(gVar.f11832a.getController()).build();
        gVar.f11832a.setVisibility(0);
        gVar.f11832a.setController(build);
        if (mediaModel instanceof ImageModel) {
            gVar.f11833b.setVisibility(8);
            gVar.f11832a.setOnClickListener(new a());
        }
    }

    public final void m(g gVar, MediaModel mediaModel) {
        if (!(mediaModel instanceof VideoModel)) {
            gVar.f11835d.setVisibility(8);
        } else if (gVar == null || TextUtils.isEmpty(mediaModel.b())) {
        } else {
            gVar.f11833b.setVisibility(8);
            gVar.f11834c.setVisibility(8);
            gVar.f11835d.setVisibility(0);
            gVar.f11832a.setOnClickListener(new b(gVar, mediaModel));
            gVar.f11833b.setOnClickListener(new c(gVar));
        }
    }

    public final void n(HugePhotoDraweeView hugePhotoDraweeView, Bitmap bitmap) {
        int m = h0.m(this.f11814c);
        int l = h0.l(this.f11814c);
        if (bitmap == null || bitmap.getHeight() <= l * 1.6f) {
            return;
        }
        float width = bitmap.getWidth() == 0 ? 1.0f : m / bitmap.getWidth();
        hugePhotoDraweeView.setDoubleTapZoomScale(width);
        hugePhotoDraweeView.setScaleAndCenter(width, new PointF(m / 2, 0.0f));
    }

    public void o() {
        g gVar = this.f11817f;
        if (gVar == null || gVar.f11834c == null || !this.f11817f.f11834c.isPlaying()) {
            return;
        }
        this.f11817f.f11834c.stopPlayback();
        q(this.f11817f, false);
    }

    public final void p(g gVar) {
        q(gVar, true);
    }

    public final void q(g gVar, boolean z) {
        d.a.h0.a.b1.d.d.a aVar;
        if (gVar == null) {
            return;
        }
        gVar.f11835d.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f11814c, d.a.h0.a.a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new e(this, gVar));
        gVar.f11832a.startAnimation(loadAnimation);
        if (!z || (aVar = this.f11815d) == null) {
            return;
        }
        aVar.showBar();
    }

    public final void r(g gVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f11814c, d.a.h0.a.a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new d(this, gVar));
        gVar.f11832a.startAnimation(loadAnimation);
    }

    public void s(int i2, int i3) {
        if (i2 >= this.f11813b.size() || this.f11813b.get(i2) == null) {
            return;
        }
        this.f11813b.get(i2).findViewById(d.a.h0.a.f.album_preview_item_root).setBackgroundColor(this.f11814c.getResources().getColor(i3));
    }

    public void t(d.a.h0.a.b1.d.d.a aVar) {
        this.f11815d = aVar;
    }
}

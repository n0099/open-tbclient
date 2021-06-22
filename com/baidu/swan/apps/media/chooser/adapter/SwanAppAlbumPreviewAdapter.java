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
import androidx.annotation.ColorInt;
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
import d.a.m0.a.v2.n0;
import d.a.m0.a.v2.u;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SwanAppAlbumPreviewAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<MediaModel> f11025a;

    /* renamed from: c  reason: collision with root package name */
    public Activity f11027c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.m0.a.i1.d.d.a f11028d;

    /* renamed from: f  reason: collision with root package name */
    public h f11030f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.a.i1.d.e.a f11031g;

    /* renamed from: e  reason: collision with root package name */
    public int[] f11029e = new int[1];

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<View> f11026b = new SparseArray<>();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SwanAppAlbumPreviewAdapter.this.f11028d != null) {
                SwanAppAlbumPreviewAdapter.this.f11028d.clickContainer();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnLongClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f11033e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f11034f;

        public b(h hVar, MediaModel mediaModel) {
            this.f11033e = hVar;
            this.f11034f = mediaModel;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SwanAppAlbumPreviewAdapter.this.p(this.f11033e, (ImageModel) this.f11034f);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f11036e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f11037f;

        /* loaded from: classes3.dex */
        public class a implements MediaPlayer.OnPreparedListener {

            /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0157a implements Runnable {
                public RunnableC0157a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    c cVar = c.this;
                    SwanAppAlbumPreviewAdapter.this.t(cVar.f11036e);
                }
            }

            public a() {
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                c.this.f11036e.f11052d.postDelayed(new RunnableC0157a(), 300L);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements MediaPlayer.OnErrorListener {
            public b() {
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                c cVar = c.this;
                SwanAppAlbumPreviewAdapter.this.r(cVar.f11036e);
                return false;
            }
        }

        /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$c$c  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0158c implements MediaPlayer.OnCompletionListener {
            public C0158c() {
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                c cVar = c.this;
                SwanAppAlbumPreviewAdapter.this.r(cVar.f11036e);
            }
        }

        public c(h hVar, MediaModel mediaModel) {
            this.f11036e = hVar;
            this.f11037f = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f11036e.f11052d.isPlaying()) {
                return;
            }
            this.f11036e.f11051c.setVisibility(0);
            this.f11036e.f11052d.setVisibility(0);
            this.f11036e.f11053e.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.f11028d != null) {
                SwanAppAlbumPreviewAdapter.this.f11028d.hideBar();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.f11027c);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.f11036e.f11052d.setMediaController(mediaController);
            this.f11036e.f11052d.setVideoPath(this.f11037f.b());
            this.f11036e.f11052d.setOnPreparedListener(new a());
            this.f11036e.f11052d.setOnErrorListener(new b());
            this.f11036e.f11052d.setOnCompletionListener(new C0158c());
            this.f11036e.f11052d.start();
            SwanAppAlbumPreviewAdapter.this.f11030f = this.f11036e;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f11043e;

        public d(h hVar) {
            this.f11043e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f11043e.f11052d.isPlaying()) {
                this.f11043e.f11052d.stopPlayback();
                SwanAppAlbumPreviewAdapter.this.r(this.f11043e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f11045a;

        public e(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, h hVar) {
            this.f11045a = hVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f11045a.f11050b.setVisibility(8);
            this.f11045a.f11050b.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f11046a;

        public f(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, h hVar) {
            this.f11046a = hVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f11046a.f11050b.setVisibility(0);
            this.f11046a.f11050b.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes3.dex */
    public class g extends BaseControllerListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HugePhotoDraweeView f11047a;

        public g(HugePhotoDraweeView hugePhotoDraweeView) {
            this.f11047a = hugePhotoDraweeView;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFailure(String str, Throwable th) {
            super.onFailure(str, th);
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            super.onFinalImageSet(str, obj, animatable);
            if (obj instanceof CloseableStaticBitmap) {
                this.f11047a.setIsDynamicBitmap(false);
                this.f11047a.setZoomEnabled(true);
                Bitmap underlyingBitmap = ((CloseableStaticBitmap) obj).getUnderlyingBitmap();
                SwanAppAlbumPreviewAdapter.this.f11029e = u.j();
                d.a.m0.a.i1.e.b b2 = d.a.m0.a.i1.e.b.b(underlyingBitmap);
                if (b2 == null) {
                    return;
                }
                if (underlyingBitmap.getWidth() < SwanAppAlbumPreviewAdapter.this.f11029e[0] && underlyingBitmap.getHeight() < SwanAppAlbumPreviewAdapter.this.f11029e[0]) {
                    b2.m();
                } else {
                    b2.n();
                }
                this.f11047a.setImage(b2);
                SwanAppAlbumPreviewAdapter.this.o(this.f11047a, underlyingBitmap);
            } else if (obj instanceof CloseableAnimatedImage) {
                this.f11047a.setIsDynamicBitmap(true);
                this.f11047a.setZoomEnabled(false);
                this.f11047a.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
            }
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onSubmit(String str, Object obj) {
            super.onSubmit(str, obj);
        }
    }

    /* loaded from: classes3.dex */
    public class h {

        /* renamed from: a  reason: collision with root package name */
        public View f11049a;

        /* renamed from: b  reason: collision with root package name */
        public HugePhotoDraweeView f11050b;

        /* renamed from: c  reason: collision with root package name */
        public View f11051c;

        /* renamed from: d  reason: collision with root package name */
        public VideoView f11052d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f11053e;

        public h(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, View view) {
            this.f11049a = view;
            this.f11050b = (HugePhotoDraweeView) view.findViewById(d.a.m0.a.f.album_preview_image);
            this.f11051c = view.findViewById(d.a.m0.a.f.preview_video_layout);
            this.f11052d = (VideoView) view.findViewById(d.a.m0.a.f.preview_video_view);
            this.f11053e = (ImageView) view.findViewById(d.a.m0.a.f.video_preview);
        }
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.f11027c = activity;
        this.f11025a = arrayList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f11025a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        h hVar;
        MediaModel mediaModel = this.f11025a.get(i2);
        View view = this.f11026b.get(i2);
        if (view == null) {
            view = LayoutInflater.from(this.f11027c).inflate(d.a.m0.a.g.swanapp_album_preview_item, viewGroup, false);
            hVar = new h(this, view);
            view.setTag(hVar);
            this.f11026b.put(i2, view);
        } else {
            hVar = (h) view.getTag();
        }
        m(hVar, mediaModel);
        n(hVar, mediaModel);
        viewGroup.addView(view);
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void k() {
        h hVar = this.f11030f;
        if (hVar != null) {
            VideoView videoView = hVar.f11052d;
            if (videoView != null && videoView.isPlaying()) {
                videoView.stopPlayback();
            }
            this.f11030f.f11052d = null;
            this.f11030f = null;
        }
    }

    public final ControllerListener l(HugePhotoDraweeView hugePhotoDraweeView) {
        return new g(hugePhotoDraweeView);
    }

    public final void m(h hVar, MediaModel mediaModel) {
        if (hVar == null || mediaModel == null || TextUtils.isEmpty(mediaModel.b())) {
            return;
        }
        ControllerListener l = l(hVar.f11050b);
        String b2 = mediaModel.b();
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(b2.startsWith("http") ? Uri.parse(b2) : Uri.fromFile(new File(mediaModel.b())));
        newBuilderWithSource.setResizeOptions(new ResizeOptions(n0.o(this.f11027c), n0.n(this.f11027c), 10240.0f));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(d.a.m0.a.i1.d.c.c.f46650d).setImageRequest(newBuilderWithSource.build()).setControllerListener(l).setOldController(hVar.f11050b.getController()).build();
        hVar.f11050b.setVisibility(0);
        hVar.f11050b.setController(build);
        if (mediaModel instanceof ImageModel) {
            hVar.f11051c.setVisibility(8);
            hVar.f11050b.setOnClickListener(new a());
            hVar.f11050b.setOnLongClickListener(new b(hVar, mediaModel));
        }
    }

    public final void n(h hVar, MediaModel mediaModel) {
        if (!(mediaModel instanceof VideoModel)) {
            hVar.f11053e.setVisibility(8);
        } else if (hVar == null || TextUtils.isEmpty(mediaModel.b())) {
        } else {
            hVar.f11051c.setVisibility(8);
            hVar.f11052d.setVisibility(8);
            hVar.f11053e.setVisibility(0);
            hVar.f11050b.setOnClickListener(new c(hVar, mediaModel));
            hVar.f11051c.setOnClickListener(new d(hVar));
        }
    }

    public final void o(HugePhotoDraweeView hugePhotoDraweeView, Bitmap bitmap) {
        int o = n0.o(this.f11027c);
        int n = n0.n(this.f11027c);
        if (bitmap == null || bitmap.getHeight() <= n * 1.6f) {
            return;
        }
        float width = bitmap.getWidth() == 0 ? 1.0f : o / bitmap.getWidth();
        hugePhotoDraweeView.setDoubleTapZoomScale(width);
        hugePhotoDraweeView.setScaleAndCenter(width, new PointF(o / 2, 0.0f));
    }

    public final void p(h hVar, ImageModel imageModel) {
        if (this.f11031g == null) {
            this.f11031g = new d.a.m0.a.i1.d.e.a(this.f11027c);
        }
        this.f11031g.j(hVar.f11049a, imageModel.b());
    }

    public void q() {
        h hVar = this.f11030f;
        if (hVar == null || hVar.f11052d == null || !this.f11030f.f11052d.isPlaying()) {
            return;
        }
        this.f11030f.f11052d.stopPlayback();
        s(this.f11030f, false);
    }

    public final void r(h hVar) {
        s(hVar, true);
    }

    public final void s(h hVar, boolean z) {
        d.a.m0.a.i1.d.d.a aVar;
        if (hVar == null) {
            return;
        }
        hVar.f11053e.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f11027c, d.a.m0.a.a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new f(this, hVar));
        hVar.f11050b.startAnimation(loadAnimation);
        if (!z || (aVar = this.f11028d) == null) {
            return;
        }
        aVar.showBar();
    }

    public final void t(h hVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f11027c, d.a.m0.a.a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new e(this, hVar));
        hVar.f11050b.startAnimation(loadAnimation);
    }

    public void u(int i2, @ColorInt int i3) {
        if (i2 >= this.f11026b.size() || this.f11026b.get(i2) == null) {
            return;
        }
        this.f11026b.get(i2).findViewById(d.a.m0.a.f.album_preview_item_root).setBackgroundColor(i3);
    }

    public void v(d.a.m0.a.i1.d.d.a aVar) {
        this.f11028d = aVar;
    }
}

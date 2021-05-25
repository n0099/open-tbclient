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
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.u;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SwanAppAlbumPreviewAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<MediaModel> f10881a;

    /* renamed from: c  reason: collision with root package name */
    public Activity f10883c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.i1.d.d.a f10884d;

    /* renamed from: f  reason: collision with root package name */
    public h f10886f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.a.i1.d.e.a f10887g;

    /* renamed from: e  reason: collision with root package name */
    public int[] f10885e = new int[1];

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<View> f10882b = new SparseArray<>();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SwanAppAlbumPreviewAdapter.this.f10884d != null) {
                SwanAppAlbumPreviewAdapter.this.f10884d.clickContainer();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnLongClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f10889e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f10890f;

        public b(h hVar, MediaModel mediaModel) {
            this.f10889e = hVar;
            this.f10890f = mediaModel;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SwanAppAlbumPreviewAdapter.this.p(this.f10889e, (ImageModel) this.f10890f);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f10892e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f10893f;

        /* loaded from: classes3.dex */
        public class a implements MediaPlayer.OnPreparedListener {

            /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0154a implements Runnable {
                public RunnableC0154a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    c cVar = c.this;
                    SwanAppAlbumPreviewAdapter.this.t(cVar.f10892e);
                }
            }

            public a() {
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                c.this.f10892e.f10908d.postDelayed(new RunnableC0154a(), 300L);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements MediaPlayer.OnErrorListener {
            public b() {
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                c cVar = c.this;
                SwanAppAlbumPreviewAdapter.this.r(cVar.f10892e);
                return false;
            }
        }

        /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$c$c  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0155c implements MediaPlayer.OnCompletionListener {
            public C0155c() {
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                c cVar = c.this;
                SwanAppAlbumPreviewAdapter.this.r(cVar.f10892e);
            }
        }

        public c(h hVar, MediaModel mediaModel) {
            this.f10892e = hVar;
            this.f10893f = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f10892e.f10908d.isPlaying()) {
                return;
            }
            this.f10892e.f10907c.setVisibility(0);
            this.f10892e.f10908d.setVisibility(0);
            this.f10892e.f10909e.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.f10884d != null) {
                SwanAppAlbumPreviewAdapter.this.f10884d.hideBar();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.f10883c);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.f10892e.f10908d.setMediaController(mediaController);
            this.f10892e.f10908d.setVideoPath(this.f10893f.b());
            this.f10892e.f10908d.setOnPreparedListener(new a());
            this.f10892e.f10908d.setOnErrorListener(new b());
            this.f10892e.f10908d.setOnCompletionListener(new C0155c());
            this.f10892e.f10908d.start();
            SwanAppAlbumPreviewAdapter.this.f10886f = this.f10892e;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f10899e;

        public d(h hVar) {
            this.f10899e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f10899e.f10908d.isPlaying()) {
                this.f10899e.f10908d.stopPlayback();
                SwanAppAlbumPreviewAdapter.this.r(this.f10899e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f10901a;

        public e(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, h hVar) {
            this.f10901a = hVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f10901a.f10906b.setVisibility(8);
            this.f10901a.f10906b.clearAnimation();
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
        public final /* synthetic */ h f10902a;

        public f(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, h hVar) {
            this.f10902a = hVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f10902a.f10906b.setVisibility(0);
            this.f10902a.f10906b.clearAnimation();
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
        public final /* synthetic */ HugePhotoDraweeView f10903a;

        public g(HugePhotoDraweeView hugePhotoDraweeView) {
            this.f10903a = hugePhotoDraweeView;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFailure(String str, Throwable th) {
            super.onFailure(str, th);
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            super.onFinalImageSet(str, obj, animatable);
            if (obj instanceof CloseableStaticBitmap) {
                this.f10903a.setIsDynamicBitmap(false);
                this.f10903a.setZoomEnabled(true);
                Bitmap underlyingBitmap = ((CloseableStaticBitmap) obj).getUnderlyingBitmap();
                SwanAppAlbumPreviewAdapter.this.f10885e = u.j();
                d.a.l0.a.i1.e.b b2 = d.a.l0.a.i1.e.b.b(underlyingBitmap);
                if (b2 == null) {
                    return;
                }
                if (underlyingBitmap.getWidth() < SwanAppAlbumPreviewAdapter.this.f10885e[0] && underlyingBitmap.getHeight() < SwanAppAlbumPreviewAdapter.this.f10885e[0]) {
                    b2.m();
                } else {
                    b2.n();
                }
                this.f10903a.setImage(b2);
                SwanAppAlbumPreviewAdapter.this.o(this.f10903a, underlyingBitmap);
            } else if (obj instanceof CloseableAnimatedImage) {
                this.f10903a.setIsDynamicBitmap(true);
                this.f10903a.setZoomEnabled(false);
                this.f10903a.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
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
        public View f10905a;

        /* renamed from: b  reason: collision with root package name */
        public HugePhotoDraweeView f10906b;

        /* renamed from: c  reason: collision with root package name */
        public View f10907c;

        /* renamed from: d  reason: collision with root package name */
        public VideoView f10908d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f10909e;

        public h(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, View view) {
            this.f10905a = view;
            this.f10906b = (HugePhotoDraweeView) view.findViewById(d.a.l0.a.f.album_preview_image);
            this.f10907c = view.findViewById(d.a.l0.a.f.preview_video_layout);
            this.f10908d = (VideoView) view.findViewById(d.a.l0.a.f.preview_video_view);
            this.f10909e = (ImageView) view.findViewById(d.a.l0.a.f.video_preview);
        }
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.f10883c = activity;
        this.f10881a = arrayList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f10881a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        h hVar;
        MediaModel mediaModel = this.f10881a.get(i2);
        View view = this.f10882b.get(i2);
        if (view == null) {
            view = LayoutInflater.from(this.f10883c).inflate(d.a.l0.a.g.swanapp_album_preview_item, viewGroup, false);
            hVar = new h(this, view);
            view.setTag(hVar);
            this.f10882b.put(i2, view);
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
        h hVar = this.f10886f;
        if (hVar != null) {
            VideoView videoView = hVar.f10908d;
            if (videoView != null && videoView.isPlaying()) {
                videoView.stopPlayback();
            }
            this.f10886f.f10908d = null;
            this.f10886f = null;
        }
    }

    public final ControllerListener l(HugePhotoDraweeView hugePhotoDraweeView) {
        return new g(hugePhotoDraweeView);
    }

    public final void m(h hVar, MediaModel mediaModel) {
        if (hVar == null || mediaModel == null || TextUtils.isEmpty(mediaModel.b())) {
            return;
        }
        ControllerListener l = l(hVar.f10906b);
        String b2 = mediaModel.b();
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(b2.startsWith("http") ? Uri.parse(b2) : Uri.fromFile(new File(mediaModel.b())));
        newBuilderWithSource.setResizeOptions(new ResizeOptions(n0.o(this.f10883c), n0.n(this.f10883c), 10240.0f));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(d.a.l0.a.i1.d.c.c.f42866d).setImageRequest(newBuilderWithSource.build()).setControllerListener(l).setOldController(hVar.f10906b.getController()).build();
        hVar.f10906b.setVisibility(0);
        hVar.f10906b.setController(build);
        if (mediaModel instanceof ImageModel) {
            hVar.f10907c.setVisibility(8);
            hVar.f10906b.setOnClickListener(new a());
            hVar.f10906b.setOnLongClickListener(new b(hVar, mediaModel));
        }
    }

    public final void n(h hVar, MediaModel mediaModel) {
        if (!(mediaModel instanceof VideoModel)) {
            hVar.f10909e.setVisibility(8);
        } else if (hVar == null || TextUtils.isEmpty(mediaModel.b())) {
        } else {
            hVar.f10907c.setVisibility(8);
            hVar.f10908d.setVisibility(8);
            hVar.f10909e.setVisibility(0);
            hVar.f10906b.setOnClickListener(new c(hVar, mediaModel));
            hVar.f10907c.setOnClickListener(new d(hVar));
        }
    }

    public final void o(HugePhotoDraweeView hugePhotoDraweeView, Bitmap bitmap) {
        int o = n0.o(this.f10883c);
        int n = n0.n(this.f10883c);
        if (bitmap == null || bitmap.getHeight() <= n * 1.6f) {
            return;
        }
        float width = bitmap.getWidth() == 0 ? 1.0f : o / bitmap.getWidth();
        hugePhotoDraweeView.setDoubleTapZoomScale(width);
        hugePhotoDraweeView.setScaleAndCenter(width, new PointF(o / 2, 0.0f));
    }

    public final void p(h hVar, ImageModel imageModel) {
        if (this.f10887g == null) {
            this.f10887g = new d.a.l0.a.i1.d.e.a(this.f10883c);
        }
        this.f10887g.j(hVar.f10905a, imageModel.b());
    }

    public void q() {
        h hVar = this.f10886f;
        if (hVar == null || hVar.f10908d == null || !this.f10886f.f10908d.isPlaying()) {
            return;
        }
        this.f10886f.f10908d.stopPlayback();
        s(this.f10886f, false);
    }

    public final void r(h hVar) {
        s(hVar, true);
    }

    public final void s(h hVar, boolean z) {
        d.a.l0.a.i1.d.d.a aVar;
        if (hVar == null) {
            return;
        }
        hVar.f10909e.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f10883c, d.a.l0.a.a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new f(this, hVar));
        hVar.f10906b.startAnimation(loadAnimation);
        if (!z || (aVar = this.f10884d) == null) {
            return;
        }
        aVar.showBar();
    }

    public final void t(h hVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f10883c, d.a.l0.a.a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new e(this, hVar));
        hVar.f10906b.startAnimation(loadAnimation);
    }

    public void u(int i2, @ColorInt int i3) {
        if (i2 >= this.f10882b.size() || this.f10882b.get(i2) == null) {
            return;
        }
        this.f10882b.get(i2).findViewById(d.a.l0.a.f.album_preview_item_root).setBackgroundColor(i3);
    }

    public void v(d.a.l0.a.i1.d.d.a aVar) {
        this.f10884d = aVar;
    }
}

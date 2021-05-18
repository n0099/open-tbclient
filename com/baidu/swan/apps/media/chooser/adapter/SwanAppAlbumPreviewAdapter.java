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
import d.a.i0.a.v2.n0;
import d.a.i0.a.v2.u;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SwanAppAlbumPreviewAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<MediaModel> f10980a;

    /* renamed from: c  reason: collision with root package name */
    public Activity f10982c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.a.i1.d.d.a f10983d;

    /* renamed from: f  reason: collision with root package name */
    public h f10985f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.a.i1.d.e.a f10986g;

    /* renamed from: e  reason: collision with root package name */
    public int[] f10984e = new int[1];

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<View> f10981b = new SparseArray<>();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SwanAppAlbumPreviewAdapter.this.f10983d != null) {
                SwanAppAlbumPreviewAdapter.this.f10983d.clickContainer();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnLongClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f10988e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f10989f;

        public b(h hVar, MediaModel mediaModel) {
            this.f10988e = hVar;
            this.f10989f = mediaModel;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SwanAppAlbumPreviewAdapter.this.p(this.f10988e, (ImageModel) this.f10989f);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f10991e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f10992f;

        /* loaded from: classes3.dex */
        public class a implements MediaPlayer.OnPreparedListener {

            /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0153a implements Runnable {
                public RunnableC0153a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    c cVar = c.this;
                    SwanAppAlbumPreviewAdapter.this.t(cVar.f10991e);
                }
            }

            public a() {
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                c.this.f10991e.f11007d.postDelayed(new RunnableC0153a(), 300L);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements MediaPlayer.OnErrorListener {
            public b() {
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                c cVar = c.this;
                SwanAppAlbumPreviewAdapter.this.r(cVar.f10991e);
                return false;
            }
        }

        /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$c$c  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0154c implements MediaPlayer.OnCompletionListener {
            public C0154c() {
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                c cVar = c.this;
                SwanAppAlbumPreviewAdapter.this.r(cVar.f10991e);
            }
        }

        public c(h hVar, MediaModel mediaModel) {
            this.f10991e = hVar;
            this.f10992f = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f10991e.f11007d.isPlaying()) {
                return;
            }
            this.f10991e.f11006c.setVisibility(0);
            this.f10991e.f11007d.setVisibility(0);
            this.f10991e.f11008e.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.f10983d != null) {
                SwanAppAlbumPreviewAdapter.this.f10983d.hideBar();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.f10982c);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.f10991e.f11007d.setMediaController(mediaController);
            this.f10991e.f11007d.setVideoPath(this.f10992f.b());
            this.f10991e.f11007d.setOnPreparedListener(new a());
            this.f10991e.f11007d.setOnErrorListener(new b());
            this.f10991e.f11007d.setOnCompletionListener(new C0154c());
            this.f10991e.f11007d.start();
            SwanAppAlbumPreviewAdapter.this.f10985f = this.f10991e;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f10998e;

        public d(h hVar) {
            this.f10998e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f10998e.f11007d.isPlaying()) {
                this.f10998e.f11007d.stopPlayback();
                SwanAppAlbumPreviewAdapter.this.r(this.f10998e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f11000a;

        public e(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, h hVar) {
            this.f11000a = hVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f11000a.f11005b.setVisibility(8);
            this.f11000a.f11005b.clearAnimation();
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
        public final /* synthetic */ h f11001a;

        public f(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, h hVar) {
            this.f11001a = hVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f11001a.f11005b.setVisibility(0);
            this.f11001a.f11005b.clearAnimation();
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
        public final /* synthetic */ HugePhotoDraweeView f11002a;

        public g(HugePhotoDraweeView hugePhotoDraweeView) {
            this.f11002a = hugePhotoDraweeView;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFailure(String str, Throwable th) {
            super.onFailure(str, th);
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            super.onFinalImageSet(str, obj, animatable);
            if (obj instanceof CloseableStaticBitmap) {
                this.f11002a.setIsDynamicBitmap(false);
                this.f11002a.setZoomEnabled(true);
                Bitmap underlyingBitmap = ((CloseableStaticBitmap) obj).getUnderlyingBitmap();
                SwanAppAlbumPreviewAdapter.this.f10984e = u.j();
                d.a.i0.a.i1.e.b b2 = d.a.i0.a.i1.e.b.b(underlyingBitmap);
                if (b2 == null) {
                    return;
                }
                if (underlyingBitmap.getWidth() < SwanAppAlbumPreviewAdapter.this.f10984e[0] && underlyingBitmap.getHeight() < SwanAppAlbumPreviewAdapter.this.f10984e[0]) {
                    b2.m();
                } else {
                    b2.n();
                }
                this.f11002a.setImage(b2);
                SwanAppAlbumPreviewAdapter.this.o(this.f11002a, underlyingBitmap);
            } else if (obj instanceof CloseableAnimatedImage) {
                this.f11002a.setIsDynamicBitmap(true);
                this.f11002a.setZoomEnabled(false);
                this.f11002a.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
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
        public View f11004a;

        /* renamed from: b  reason: collision with root package name */
        public HugePhotoDraweeView f11005b;

        /* renamed from: c  reason: collision with root package name */
        public View f11006c;

        /* renamed from: d  reason: collision with root package name */
        public VideoView f11007d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f11008e;

        public h(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, View view) {
            this.f11004a = view;
            this.f11005b = (HugePhotoDraweeView) view.findViewById(d.a.i0.a.f.album_preview_image);
            this.f11006c = view.findViewById(d.a.i0.a.f.preview_video_layout);
            this.f11007d = (VideoView) view.findViewById(d.a.i0.a.f.preview_video_view);
            this.f11008e = (ImageView) view.findViewById(d.a.i0.a.f.video_preview);
        }
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.f10982c = activity;
        this.f10980a = arrayList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f10980a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        h hVar;
        MediaModel mediaModel = this.f10980a.get(i2);
        View view = this.f10981b.get(i2);
        if (view == null) {
            view = LayoutInflater.from(this.f10982c).inflate(d.a.i0.a.g.swanapp_album_preview_item, viewGroup, false);
            hVar = new h(this, view);
            view.setTag(hVar);
            this.f10981b.put(i2, view);
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
        h hVar = this.f10985f;
        if (hVar != null) {
            VideoView videoView = hVar.f11007d;
            if (videoView != null && videoView.isPlaying()) {
                videoView.stopPlayback();
            }
            this.f10985f.f11007d = null;
            this.f10985f = null;
        }
    }

    public final ControllerListener l(HugePhotoDraweeView hugePhotoDraweeView) {
        return new g(hugePhotoDraweeView);
    }

    public final void m(h hVar, MediaModel mediaModel) {
        if (hVar == null || mediaModel == null || TextUtils.isEmpty(mediaModel.b())) {
            return;
        }
        ControllerListener l = l(hVar.f11005b);
        String b2 = mediaModel.b();
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(b2.startsWith("http") ? Uri.parse(b2) : Uri.fromFile(new File(mediaModel.b())));
        newBuilderWithSource.setResizeOptions(new ResizeOptions(n0.o(this.f10982c), n0.n(this.f10982c), 10240.0f));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(d.a.i0.a.i1.d.c.c.f42692d).setImageRequest(newBuilderWithSource.build()).setControllerListener(l).setOldController(hVar.f11005b.getController()).build();
        hVar.f11005b.setVisibility(0);
        hVar.f11005b.setController(build);
        if (mediaModel instanceof ImageModel) {
            hVar.f11006c.setVisibility(8);
            hVar.f11005b.setOnClickListener(new a());
            hVar.f11005b.setOnLongClickListener(new b(hVar, mediaModel));
        }
    }

    public final void n(h hVar, MediaModel mediaModel) {
        if (!(mediaModel instanceof VideoModel)) {
            hVar.f11008e.setVisibility(8);
        } else if (hVar == null || TextUtils.isEmpty(mediaModel.b())) {
        } else {
            hVar.f11006c.setVisibility(8);
            hVar.f11007d.setVisibility(8);
            hVar.f11008e.setVisibility(0);
            hVar.f11005b.setOnClickListener(new c(hVar, mediaModel));
            hVar.f11006c.setOnClickListener(new d(hVar));
        }
    }

    public final void o(HugePhotoDraweeView hugePhotoDraweeView, Bitmap bitmap) {
        int o = n0.o(this.f10982c);
        int n = n0.n(this.f10982c);
        if (bitmap == null || bitmap.getHeight() <= n * 1.6f) {
            return;
        }
        float width = bitmap.getWidth() == 0 ? 1.0f : o / bitmap.getWidth();
        hugePhotoDraweeView.setDoubleTapZoomScale(width);
        hugePhotoDraweeView.setScaleAndCenter(width, new PointF(o / 2, 0.0f));
    }

    public final void p(h hVar, ImageModel imageModel) {
        if (this.f10986g == null) {
            this.f10986g = new d.a.i0.a.i1.d.e.a(this.f10982c);
        }
        this.f10986g.j(hVar.f11004a, imageModel.b());
    }

    public void q() {
        h hVar = this.f10985f;
        if (hVar == null || hVar.f11007d == null || !this.f10985f.f11007d.isPlaying()) {
            return;
        }
        this.f10985f.f11007d.stopPlayback();
        s(this.f10985f, false);
    }

    public final void r(h hVar) {
        s(hVar, true);
    }

    public final void s(h hVar, boolean z) {
        d.a.i0.a.i1.d.d.a aVar;
        if (hVar == null) {
            return;
        }
        hVar.f11008e.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f10982c, d.a.i0.a.a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new f(this, hVar));
        hVar.f11005b.startAnimation(loadAnimation);
        if (!z || (aVar = this.f10983d) == null) {
            return;
        }
        aVar.showBar();
    }

    public final void t(h hVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f10982c, d.a.i0.a.a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new e(this, hVar));
        hVar.f11005b.startAnimation(loadAnimation);
    }

    public void u(int i2, @ColorInt int i3) {
        if (i2 >= this.f10981b.size() || this.f10981b.get(i2) == null) {
            return;
        }
        this.f10981b.get(i2).findViewById(d.a.i0.a.f.album_preview_item_root).setBackgroundColor(i3);
    }

    public void v(d.a.i0.a.i1.d.d.a aVar) {
        this.f10983d = aVar;
    }
}

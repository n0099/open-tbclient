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
    public ArrayList<MediaModel> f10943a;

    /* renamed from: c  reason: collision with root package name */
    public Activity f10945c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.i1.d.d.a f10946d;

    /* renamed from: f  reason: collision with root package name */
    public h f10948f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.a.i1.d.e.a f10949g;

    /* renamed from: e  reason: collision with root package name */
    public int[] f10947e = new int[1];

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<View> f10944b = new SparseArray<>();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SwanAppAlbumPreviewAdapter.this.f10946d != null) {
                SwanAppAlbumPreviewAdapter.this.f10946d.clickContainer();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnLongClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f10951e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f10952f;

        public b(h hVar, MediaModel mediaModel) {
            this.f10951e = hVar;
            this.f10952f = mediaModel;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SwanAppAlbumPreviewAdapter.this.p(this.f10951e, (ImageModel) this.f10952f);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f10954e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f10955f;

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
                    SwanAppAlbumPreviewAdapter.this.t(cVar.f10954e);
                }
            }

            public a() {
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                c.this.f10954e.f10970d.postDelayed(new RunnableC0154a(), 300L);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements MediaPlayer.OnErrorListener {
            public b() {
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                c cVar = c.this;
                SwanAppAlbumPreviewAdapter.this.r(cVar.f10954e);
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
                SwanAppAlbumPreviewAdapter.this.r(cVar.f10954e);
            }
        }

        public c(h hVar, MediaModel mediaModel) {
            this.f10954e = hVar;
            this.f10955f = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f10954e.f10970d.isPlaying()) {
                return;
            }
            this.f10954e.f10969c.setVisibility(0);
            this.f10954e.f10970d.setVisibility(0);
            this.f10954e.f10971e.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.f10946d != null) {
                SwanAppAlbumPreviewAdapter.this.f10946d.hideBar();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.f10945c);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.f10954e.f10970d.setMediaController(mediaController);
            this.f10954e.f10970d.setVideoPath(this.f10955f.b());
            this.f10954e.f10970d.setOnPreparedListener(new a());
            this.f10954e.f10970d.setOnErrorListener(new b());
            this.f10954e.f10970d.setOnCompletionListener(new C0155c());
            this.f10954e.f10970d.start();
            SwanAppAlbumPreviewAdapter.this.f10948f = this.f10954e;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f10961e;

        public d(h hVar) {
            this.f10961e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f10961e.f10970d.isPlaying()) {
                this.f10961e.f10970d.stopPlayback();
                SwanAppAlbumPreviewAdapter.this.r(this.f10961e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f10963a;

        public e(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, h hVar) {
            this.f10963a = hVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f10963a.f10968b.setVisibility(8);
            this.f10963a.f10968b.clearAnimation();
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
        public final /* synthetic */ h f10964a;

        public f(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, h hVar) {
            this.f10964a = hVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f10964a.f10968b.setVisibility(0);
            this.f10964a.f10968b.clearAnimation();
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
        public final /* synthetic */ HugePhotoDraweeView f10965a;

        public g(HugePhotoDraweeView hugePhotoDraweeView) {
            this.f10965a = hugePhotoDraweeView;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFailure(String str, Throwable th) {
            super.onFailure(str, th);
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            super.onFinalImageSet(str, obj, animatable);
            if (obj instanceof CloseableStaticBitmap) {
                this.f10965a.setIsDynamicBitmap(false);
                this.f10965a.setZoomEnabled(true);
                Bitmap underlyingBitmap = ((CloseableStaticBitmap) obj).getUnderlyingBitmap();
                SwanAppAlbumPreviewAdapter.this.f10947e = u.j();
                d.a.l0.a.i1.e.b b2 = d.a.l0.a.i1.e.b.b(underlyingBitmap);
                if (b2 == null) {
                    return;
                }
                if (underlyingBitmap.getWidth() < SwanAppAlbumPreviewAdapter.this.f10947e[0] && underlyingBitmap.getHeight() < SwanAppAlbumPreviewAdapter.this.f10947e[0]) {
                    b2.m();
                } else {
                    b2.n();
                }
                this.f10965a.setImage(b2);
                SwanAppAlbumPreviewAdapter.this.o(this.f10965a, underlyingBitmap);
            } else if (obj instanceof CloseableAnimatedImage) {
                this.f10965a.setIsDynamicBitmap(true);
                this.f10965a.setZoomEnabled(false);
                this.f10965a.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
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
        public View f10967a;

        /* renamed from: b  reason: collision with root package name */
        public HugePhotoDraweeView f10968b;

        /* renamed from: c  reason: collision with root package name */
        public View f10969c;

        /* renamed from: d  reason: collision with root package name */
        public VideoView f10970d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f10971e;

        public h(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, View view) {
            this.f10967a = view;
            this.f10968b = (HugePhotoDraweeView) view.findViewById(d.a.l0.a.f.album_preview_image);
            this.f10969c = view.findViewById(d.a.l0.a.f.preview_video_layout);
            this.f10970d = (VideoView) view.findViewById(d.a.l0.a.f.preview_video_view);
            this.f10971e = (ImageView) view.findViewById(d.a.l0.a.f.video_preview);
        }
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.f10945c = activity;
        this.f10943a = arrayList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f10943a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        h hVar;
        MediaModel mediaModel = this.f10943a.get(i2);
        View view = this.f10944b.get(i2);
        if (view == null) {
            view = LayoutInflater.from(this.f10945c).inflate(d.a.l0.a.g.swanapp_album_preview_item, viewGroup, false);
            hVar = new h(this, view);
            view.setTag(hVar);
            this.f10944b.put(i2, view);
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
        h hVar = this.f10948f;
        if (hVar != null) {
            VideoView videoView = hVar.f10970d;
            if (videoView != null && videoView.isPlaying()) {
                videoView.stopPlayback();
            }
            this.f10948f.f10970d = null;
            this.f10948f = null;
        }
    }

    public final ControllerListener l(HugePhotoDraweeView hugePhotoDraweeView) {
        return new g(hugePhotoDraweeView);
    }

    public final void m(h hVar, MediaModel mediaModel) {
        if (hVar == null || mediaModel == null || TextUtils.isEmpty(mediaModel.b())) {
            return;
        }
        ControllerListener l = l(hVar.f10968b);
        String b2 = mediaModel.b();
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(b2.startsWith("http") ? Uri.parse(b2) : Uri.fromFile(new File(mediaModel.b())));
        newBuilderWithSource.setResizeOptions(new ResizeOptions(n0.o(this.f10945c), n0.n(this.f10945c), 10240.0f));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(d.a.l0.a.i1.d.c.c.f46542d).setImageRequest(newBuilderWithSource.build()).setControllerListener(l).setOldController(hVar.f10968b.getController()).build();
        hVar.f10968b.setVisibility(0);
        hVar.f10968b.setController(build);
        if (mediaModel instanceof ImageModel) {
            hVar.f10969c.setVisibility(8);
            hVar.f10968b.setOnClickListener(new a());
            hVar.f10968b.setOnLongClickListener(new b(hVar, mediaModel));
        }
    }

    public final void n(h hVar, MediaModel mediaModel) {
        if (!(mediaModel instanceof VideoModel)) {
            hVar.f10971e.setVisibility(8);
        } else if (hVar == null || TextUtils.isEmpty(mediaModel.b())) {
        } else {
            hVar.f10969c.setVisibility(8);
            hVar.f10970d.setVisibility(8);
            hVar.f10971e.setVisibility(0);
            hVar.f10968b.setOnClickListener(new c(hVar, mediaModel));
            hVar.f10969c.setOnClickListener(new d(hVar));
        }
    }

    public final void o(HugePhotoDraweeView hugePhotoDraweeView, Bitmap bitmap) {
        int o = n0.o(this.f10945c);
        int n = n0.n(this.f10945c);
        if (bitmap == null || bitmap.getHeight() <= n * 1.6f) {
            return;
        }
        float width = bitmap.getWidth() == 0 ? 1.0f : o / bitmap.getWidth();
        hugePhotoDraweeView.setDoubleTapZoomScale(width);
        hugePhotoDraweeView.setScaleAndCenter(width, new PointF(o / 2, 0.0f));
    }

    public final void p(h hVar, ImageModel imageModel) {
        if (this.f10949g == null) {
            this.f10949g = new d.a.l0.a.i1.d.e.a(this.f10945c);
        }
        this.f10949g.j(hVar.f10967a, imageModel.b());
    }

    public void q() {
        h hVar = this.f10948f;
        if (hVar == null || hVar.f10970d == null || !this.f10948f.f10970d.isPlaying()) {
            return;
        }
        this.f10948f.f10970d.stopPlayback();
        s(this.f10948f, false);
    }

    public final void r(h hVar) {
        s(hVar, true);
    }

    public final void s(h hVar, boolean z) {
        d.a.l0.a.i1.d.d.a aVar;
        if (hVar == null) {
            return;
        }
        hVar.f10971e.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f10945c, d.a.l0.a.a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new f(this, hVar));
        hVar.f10968b.startAnimation(loadAnimation);
        if (!z || (aVar = this.f10946d) == null) {
            return;
        }
        aVar.showBar();
    }

    public final void t(h hVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f10945c, d.a.l0.a.a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new e(this, hVar));
        hVar.f10968b.startAnimation(loadAnimation);
    }

    public void u(int i2, @ColorInt int i3) {
        if (i2 >= this.f10944b.size() || this.f10944b.get(i2) == null) {
            return;
        }
        this.f10944b.get(i2).findViewById(d.a.l0.a.f.album_preview_item_root).setBackgroundColor(i3);
    }

    public void v(d.a.l0.a.i1.d.d.a aVar) {
        this.f10946d = aVar;
    }
}

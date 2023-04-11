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
import com.baidu.tieba.R;
import com.baidu.tieba.jv2;
import com.baidu.tieba.ll3;
import com.baidu.tieba.nv2;
import com.baidu.tieba.sk3;
import com.baidu.tieba.tv2;
import com.baidu.tieba.xv2;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SwanAppAlbumPreviewAdapter extends PagerAdapter {
    public ArrayList<MediaModel> a;
    public Activity c;
    public nv2 d;
    public h f;
    public tv2 g;
    public int[] e = new int[1];
    public SparseArray<View> b = new SparseArray<>();

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        return view2 == obj;
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public final /* synthetic */ h a;
        public final /* synthetic */ MediaModel b;

        /* loaded from: classes3.dex */
        public class a implements MediaPlayer.OnPreparedListener {

            /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0185a implements Runnable {
                public RunnableC0185a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    c cVar = c.this;
                    SwanAppAlbumPreviewAdapter.this.t(cVar.a);
                }
            }

            public a() {
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                c.this.a.d.postDelayed(new RunnableC0185a(), 300L);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements MediaPlayer.OnErrorListener {
            public b() {
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c cVar = c.this;
                SwanAppAlbumPreviewAdapter.this.r(cVar.a);
                return false;
            }
        }

        /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$c$c  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0186c implements MediaPlayer.OnCompletionListener {
            public C0186c() {
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                c cVar = c.this;
                SwanAppAlbumPreviewAdapter.this.r(cVar.a);
            }
        }

        public c(h hVar, MediaModel mediaModel) {
            this.a = hVar;
            this.b = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (this.a.d.isPlaying()) {
                return;
            }
            this.a.c.setVisibility(0);
            this.a.d.setVisibility(0);
            this.a.e.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.d != null) {
                SwanAppAlbumPreviewAdapter.this.d.c();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.c);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.a.d.setMediaController(mediaController);
            this.a.d.setVideoPath(this.b.getPath());
            this.a.d.setOnPreparedListener(new a());
            this.a.d.setOnErrorListener(new b());
            this.a.d.setOnCompletionListener(new C0186c());
            this.a.d.start();
            SwanAppAlbumPreviewAdapter.this.f = this.a;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (SwanAppAlbumPreviewAdapter.this.d != null) {
                SwanAppAlbumPreviewAdapter.this.d.g();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnLongClickListener {
        public final /* synthetic */ h a;
        public final /* synthetic */ MediaModel b;

        public b(h hVar, MediaModel mediaModel) {
            this.a = hVar;
            this.b = mediaModel;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            SwanAppAlbumPreviewAdapter.this.p(this.a, (ImageModel) this.b);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public final /* synthetic */ h a;

        public d(h hVar) {
            this.a = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (this.a.d.isPlaying()) {
                this.a.d.stopPlayback();
                SwanAppAlbumPreviewAdapter.this.r(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Animation.AnimationListener {
        public final /* synthetic */ h a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        public e(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, h hVar) {
            this.a = hVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.a.b.setVisibility(8);
            this.a.b.clearAnimation();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Animation.AnimationListener {
        public final /* synthetic */ h a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        public f(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, h hVar) {
            this.a = hVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.a.b.setVisibility(0);
            this.a.b.clearAnimation();
        }
    }

    /* loaded from: classes3.dex */
    public class g extends BaseControllerListener {
        public final /* synthetic */ HugePhotoDraweeView a;

        public g(HugePhotoDraweeView hugePhotoDraweeView) {
            this.a = hugePhotoDraweeView;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFailure(String str, Throwable th) {
            super.onFailure(str, th);
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onSubmit(String str, Object obj) {
            super.onSubmit(str, obj);
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            super.onFinalImageSet(str, obj, animatable);
            if (obj instanceof CloseableStaticBitmap) {
                this.a.setIsDynamicBitmap(false);
                this.a.setZoomEnabled(true);
                Bitmap underlyingBitmap = ((CloseableStaticBitmap) obj).getUnderlyingBitmap();
                SwanAppAlbumPreviewAdapter.this.e = sk3.j();
                xv2 b = xv2.b(underlyingBitmap);
                if (b == null) {
                    return;
                }
                if (underlyingBitmap.getWidth() < SwanAppAlbumPreviewAdapter.this.e[0] && underlyingBitmap.getHeight() < SwanAppAlbumPreviewAdapter.this.e[0]) {
                    b.m();
                } else {
                    b.n();
                }
                this.a.setImage(b);
                SwanAppAlbumPreviewAdapter.this.o(this.a, underlyingBitmap);
            } else if (obj instanceof CloseableAnimatedImage) {
                this.a.setIsDynamicBitmap(true);
                this.a.setZoomEnabled(false);
                this.a.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h {
        public View a;
        public HugePhotoDraweeView b;
        public View c;
        public VideoView d;
        public ImageView e;

        public h(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, View view2) {
            this.a = view2;
            this.b = (HugePhotoDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f09025f);
            this.c = view2.findViewById(R.id.obfuscated_res_0x7f091bfc);
            this.d = (VideoView) view2.findViewById(R.id.obfuscated_res_0x7f091bff);
            this.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092762);
        }
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.c = activity;
        this.a = arrayList;
    }

    public final void p(h hVar, ImageModel imageModel) {
        if (this.g == null) {
            this.g = new tv2(this.c);
        }
        this.g.i(hVar.a, imageModel.getPath());
    }

    public final void s(h hVar, boolean z) {
        nv2 nv2Var;
        if (hVar == null) {
            return;
        }
        hVar.e.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.c, R.anim.obfuscated_res_0x7f010149);
        loadAnimation.setAnimationListener(new f(this, hVar));
        hVar.b.startAnimation(loadAnimation);
        if (z && (nv2Var = this.d) != null) {
            nv2Var.e();
        }
    }

    public void u(int i, @ColorInt int i2) {
        if (i < this.b.size() && this.b.get(i) != null) {
            this.b.get(i).findViewById(R.id.obfuscated_res_0x7f090260).setBackgroundColor(i2);
        }
    }

    public final ControllerListener l(HugePhotoDraweeView hugePhotoDraweeView) {
        return new g(hugePhotoDraweeView);
    }

    public final void r(h hVar) {
        s(hVar, true);
    }

    public final void t(h hVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.c, R.anim.obfuscated_res_0x7f01014a);
        loadAnimation.setAnimationListener(new e(this, hVar));
        hVar.b.startAnimation(loadAnimation);
    }

    public void x(nv2 nv2Var) {
        this.d = nv2Var;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.a.size();
    }

    public void k() {
        h hVar = this.f;
        if (hVar != null) {
            VideoView videoView = hVar.d;
            if (videoView != null && videoView.isPlaying()) {
                videoView.stopPlayback();
            }
            this.f.d = null;
            this.f = null;
        }
    }

    public void q() {
        h hVar = this.f;
        if (hVar != null && hVar.d != null && this.f.d.isPlaying()) {
            this.f.d.stopPlayback();
            s(this.f, false);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        h hVar;
        MediaModel mediaModel = this.a.get(i);
        View view2 = this.b.get(i);
        if (view2 == null) {
            view2 = LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d0893, viewGroup, false);
            hVar = new h(this, view2);
            view2.setTag(hVar);
            this.b.put(i, view2);
        } else {
            hVar = (h) view2.getTag();
        }
        m(hVar, mediaModel);
        n(hVar, mediaModel);
        viewGroup.addView(view2);
        return view2;
    }

    public final void o(HugePhotoDraweeView hugePhotoDraweeView, Bitmap bitmap) {
        float width;
        int o = ll3.o(this.c);
        int n = ll3.n(this.c);
        if (bitmap != null && bitmap.getHeight() > n * 1.6f) {
            if (bitmap.getWidth() == 0) {
                width = 1.0f;
            } else {
                width = o / bitmap.getWidth();
            }
            hugePhotoDraweeView.setDoubleTapZoomScale(width);
            hugePhotoDraweeView.setScaleAndCenter(width, new PointF(o / 2, 0.0f));
        }
    }

    public final void m(h hVar, MediaModel mediaModel) {
        Uri fromFile;
        if (hVar != null && mediaModel != null && !TextUtils.isEmpty(mediaModel.getPath())) {
            ControllerListener l = l(hVar.b);
            String path = mediaModel.getPath();
            if (path.startsWith("http")) {
                fromFile = Uri.parse(path);
            } else {
                fromFile = Uri.fromFile(new File(mediaModel.getPath()));
            }
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(fromFile);
            newBuilderWithSource.setResizeOptions(new ResizeOptions(ll3.o(this.c), ll3.n(this.c), 10240.0f));
            newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
            AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(jv2.d).setImageRequest(newBuilderWithSource.build()).setControllerListener(l).setOldController(hVar.b.getController()).build();
            hVar.b.setVisibility(0);
            hVar.b.setController(build);
            if (mediaModel instanceof ImageModel) {
                hVar.c.setVisibility(8);
                hVar.b.setOnClickListener(new a());
                hVar.b.setOnLongClickListener(new b(hVar, mediaModel));
            }
        }
    }

    public final void n(h hVar, MediaModel mediaModel) {
        if (!(mediaModel instanceof VideoModel)) {
            hVar.e.setVisibility(8);
        } else if (hVar != null && !TextUtils.isEmpty(mediaModel.getPath())) {
            hVar.c.setVisibility(8);
            hVar.d.setVisibility(8);
            hVar.e.setVisibility(0);
            hVar.b.setOnClickListener(new c(hVar, mediaModel));
            hVar.c.setOnClickListener(new d(hVar));
        }
    }
}

package com.baidu.swan.apps.media.chooser.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
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
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.q;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.swan.apps.media.image.HugePhotoDraweeView;
import com.facebook.drawee.drawable.p;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;
import org.apache.http.HttpHost;
/* loaded from: classes11.dex */
public class SwanAppAlbumPreviewAdapter extends PagerAdapter {
    private ArrayList<MediaModel> caB;
    private Activity caH;
    private com.baidu.swan.apps.media.chooser.c.a cbe;
    private a cbg;
    private int[] cbf = new int[1];
    private SparseArray<View> cbd = new SparseArray<>();

    public void a(com.baidu.swan.apps.media.chooser.c.a aVar) {
        this.cbe = aVar;
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.caH = activity;
        this.caB = arrayList;
    }

    public void ae(int i, int i2) {
        if (i < this.cbd.size() && this.cbd.get(i) != null) {
            this.cbd.get(i).findViewById(a.f.album_preview_item_root).setBackgroundColor(this.caH.getResources().getColor(i2));
        }
    }

    public void afF() {
        if (this.cbg == null || this.cbg.cbp == null || !this.cbg.cbp.isPlaying()) {
            return;
        }
        this.cbg.cbp.stopPlayback();
        a(this.cbg, false);
    }

    public void destroy() {
        if (this.cbg == null) {
            return;
        }
        VideoView videoView = this.cbg.cbp;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.cbg.cbp = null;
        this.cbg = null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.caB.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        a aVar;
        MediaModel mediaModel = this.caB.get(i);
        View view = this.cbd.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.caH).inflate(a.g.swanapp_album_preview_item, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
            this.cbd.put(i, view);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, mediaModel);
        b(aVar, mediaModel);
        viewGroup.addView(view);
        return view;
    }

    private void a(a aVar, MediaModel mediaModel) {
        if (aVar == null || mediaModel == null || TextUtils.isEmpty(mediaModel.getPath())) {
            return;
        }
        com.facebook.drawee.controller.c a2 = a(aVar.cbn);
        String path = mediaModel.getPath();
        ImageRequestBuilder Z = ImageRequestBuilder.Z(path.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        Z.c(new d(af.getDisplayWidth(this.caH), af.getDisplayHeight(this.caH), 10240.0f));
        Z.vQ(true);
        com.facebook.drawee.controller.a doC = com.facebook.drawee.a.a.c.dnP().vC(com.baidu.swan.apps.media.chooser.b.c.cbA).aW(Z.duW()).c(a2).c(aVar.cbn.getController()).doG();
        aVar.cbn.setVisibility(0);
        aVar.cbn.setController(doC);
        if (!(mediaModel instanceof ImageModel)) {
            return;
        }
        aVar.cbo.setVisibility(8);
        aVar.cbn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppAlbumPreviewAdapter.this.cbe != null) {
                    SwanAppAlbumPreviewAdapter.this.cbe.afy();
                }
            }
        });
    }

    private void b(final a aVar, MediaModel mediaModel) {
        if (mediaModel instanceof VideoModel) {
            if (aVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
                return;
            }
            aVar.cbo.setVisibility(8);
            aVar.cbp.setVisibility(8);
            aVar.cbq.setVisibility(0);
            aVar.cbn.setOnClickListener(new AnonymousClass2(aVar, mediaModel));
            aVar.cbo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!aVar.cbp.isPlaying()) {
                        return;
                    }
                    aVar.cbp.stopPlayback();
                    SwanAppAlbumPreviewAdapter.this.b(aVar);
                }
            });
            return;
        }
        aVar.cbq.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$2  reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ a cbi;
        final /* synthetic */ MediaModel cbj;

        AnonymousClass2(a aVar, MediaModel mediaModel) {
            this.cbi = aVar;
            this.cbj = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.cbi.cbp.isPlaying()) {
                return;
            }
            this.cbi.cbo.setVisibility(0);
            this.cbi.cbp.setVisibility(0);
            this.cbi.cbq.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.cbe != null) {
                SwanAppAlbumPreviewAdapter.this.cbe.afz();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.caH);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.cbi.cbp.setMediaController(mediaController);
            this.cbi.cbp.setVideoPath(this.cbj.getPath());
            this.cbi.cbp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    AnonymousClass2.this.cbi.cbp.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppAlbumPreviewAdapter.this.a(AnonymousClass2.this.cbi);
                        }
                    }, 300L);
                }
            });
            this.cbi.cbp.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.2
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.cbi);
                    return false;
                }
            });
            this.cbi.cbp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.cbi);
                }
            });
            this.cbi.cbp.start();
            SwanAppAlbumPreviewAdapter.this.cbg = this.cbi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.caH, a.C0227a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.cbn.setVisibility(8);
                aVar.cbn.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.cbn.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        a(aVar, true);
    }

    private void a(final a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        aVar.cbq.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.caH, a.C0227a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.cbn.setVisibility(0);
                aVar.cbn.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.cbn.startAnimation(loadAnimation);
        if (z && this.cbe != null) {
            this.cbe.afA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        private HugePhotoDraweeView cbn;
        private View cbo;
        private VideoView cbp;
        private ImageView cbq;

        public a(View view) {
            this.cbn = (HugePhotoDraweeView) view.findViewById(a.f.album_preview_image);
            this.cbo = view.findViewById(a.f.preview_video_layout);
            this.cbp = (VideoView) view.findViewById(a.f.preview_video_view);
            this.cbq = (ImageView) view.findViewById(a.f.video_preview);
        }
    }

    private com.facebook.drawee.controller.c a(final HugePhotoDraweeView hugePhotoDraweeView) {
        return new com.facebook.drawee.controller.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.6
            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void g(String str, Object obj) {
                super.g(str, obj);
            }

            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void a(String str, Object obj, Animatable animatable) {
                super.a(str, obj, animatable);
                if (obj instanceof com.facebook.imagepipeline.g.d) {
                    hugePhotoDraweeView.setIsDynamicBitmap(false);
                    hugePhotoDraweeView.setZoomEnabled(true);
                    Bitmap dsN = ((com.facebook.imagepipeline.g.d) obj).dsN();
                    SwanAppAlbumPreviewAdapter.this.cbf = q.aoY();
                    com.baidu.swan.apps.media.image.b j = com.baidu.swan.apps.media.image.b.j(dsN);
                    if (dsN.getWidth() >= SwanAppAlbumPreviewAdapter.this.cbf[0] || dsN.getHeight() >= SwanAppAlbumPreviewAdapter.this.cbf[0]) {
                        j.afX();
                    } else {
                        j.afY();
                    }
                    hugePhotoDraweeView.setImage(j);
                    SwanAppAlbumPreviewAdapter.this.a(hugePhotoDraweeView, dsN);
                } else if (obj instanceof com.facebook.imagepipeline.g.a) {
                    hugePhotoDraweeView.setIsDynamicBitmap(true);
                    hugePhotoDraweeView.setZoomEnabled(false);
                    hugePhotoDraweeView.getHierarchy().b(p.b.lWc);
                }
            }

            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void h(String str, Throwable th) {
                super.h(str, th);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HugePhotoDraweeView hugePhotoDraweeView, Bitmap bitmap) {
        int displayWidth = af.getDisplayWidth(this.caH);
        int displayHeight = af.getDisplayHeight(this.caH);
        if (bitmap != null && bitmap.getHeight() > displayHeight * 1.6f) {
            float width = bitmap.getWidth() == 0 ? 1.0f : displayWidth / bitmap.getWidth();
            hugePhotoDraweeView.setDoubleTapZoomScale(width);
            hugePhotoDraweeView.setScaleAndCenter(width, new PointF(displayWidth / 2, 0.0f));
        }
    }
}

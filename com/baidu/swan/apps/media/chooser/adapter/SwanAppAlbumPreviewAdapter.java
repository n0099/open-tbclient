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
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.t;
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
/* loaded from: classes10.dex */
public class SwanAppAlbumPreviewAdapter extends PagerAdapter {
    private ArrayList<MediaModel> aiK;
    private Activity bIs;
    private com.baidu.swan.apps.media.chooser.c.a cWY;
    private a cXa;
    private int[] cWZ = new int[1];
    private SparseArray<View> cWX = new SparseArray<>();

    public void a(com.baidu.swan.apps.media.chooser.c.a aVar) {
        this.cWY = aVar;
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.bIs = activity;
        this.aiK = arrayList;
    }

    public void ao(int i, int i2) {
        if (i < this.cWX.size() && this.cWX.get(i) != null) {
            this.cWX.get(i).findViewById(a.f.album_preview_item_root).setBackgroundColor(this.bIs.getResources().getColor(i2));
        }
    }

    public void ayr() {
        if (this.cXa == null || this.cXa.cXj == null || !this.cXa.cXj.isPlaying()) {
            return;
        }
        this.cXa.cXj.stopPlayback();
        a(this.cXa, false);
    }

    public void destroy() {
        if (this.cXa == null) {
            return;
        }
        VideoView videoView = this.cXa.cXj;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.cXa.cXj = null;
        this.cXa = null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.aiK.size();
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
        MediaModel mediaModel = this.aiK.get(i);
        View view = this.cWX.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.bIs).inflate(a.g.swanapp_album_preview_item, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
            this.cWX.put(i, view);
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
        com.facebook.drawee.controller.c a2 = a(aVar.cXh);
        String path = mediaModel.getPath();
        ImageRequestBuilder ad = ImageRequestBuilder.ad(path.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        ad.c(new d(ah.getDisplayWidth(this.bIs), ah.getDisplayHeight(this.bIs), 10240.0f));
        ad.Ai(true);
        com.facebook.drawee.controller.a ehQ = com.facebook.drawee.a.a.c.ehd().zU(com.baidu.swan.apps.media.chooser.b.c.cXu).bn(ad.eoj()).c(a2).c(aVar.cXh.getController()).ehU();
        aVar.cXh.setVisibility(0);
        aVar.cXh.setController(ehQ);
        if (!(mediaModel instanceof ImageModel)) {
            return;
        }
        aVar.cXi.setVisibility(8);
        aVar.cXh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppAlbumPreviewAdapter.this.cWY != null) {
                    SwanAppAlbumPreviewAdapter.this.cWY.ayk();
                }
            }
        });
    }

    private void b(final a aVar, MediaModel mediaModel) {
        if (mediaModel instanceof VideoModel) {
            if (aVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
                return;
            }
            aVar.cXi.setVisibility(8);
            aVar.cXj.setVisibility(8);
            aVar.cXk.setVisibility(0);
            aVar.cXh.setOnClickListener(new AnonymousClass2(aVar, mediaModel));
            aVar.cXi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!aVar.cXj.isPlaying()) {
                        return;
                    }
                    aVar.cXj.stopPlayback();
                    SwanAppAlbumPreviewAdapter.this.b(aVar);
                }
            });
            return;
        }
        aVar.cXk.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$2  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ a cXc;
        final /* synthetic */ MediaModel cXd;

        AnonymousClass2(a aVar, MediaModel mediaModel) {
            this.cXc = aVar;
            this.cXd = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.cXc.cXj.isPlaying()) {
                return;
            }
            this.cXc.cXi.setVisibility(0);
            this.cXc.cXj.setVisibility(0);
            this.cXc.cXk.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.cWY != null) {
                SwanAppAlbumPreviewAdapter.this.cWY.ayl();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.bIs);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.cXc.cXj.setMediaController(mediaController);
            this.cXc.cXj.setVideoPath(this.cXd.getPath());
            this.cXc.cXj.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    AnonymousClass2.this.cXc.cXj.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppAlbumPreviewAdapter.this.a(AnonymousClass2.this.cXc);
                        }
                    }, 300L);
                }
            });
            this.cXc.cXj.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.2
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.cXc);
                    return false;
                }
            });
            this.cXc.cXj.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.cXc);
                }
            });
            this.cXc.cXj.start();
            SwanAppAlbumPreviewAdapter.this.cXa = this.cXc;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.bIs, a.C0357a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.cXh.setVisibility(8);
                aVar.cXh.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.cXh.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        a(aVar, true);
    }

    private void a(final a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        aVar.cXk.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.bIs, a.C0357a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.cXh.setVisibility(0);
                aVar.cXh.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.cXh.startAnimation(loadAnimation);
        if (z && this.cWY != null) {
            this.cWY.aym();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        private HugePhotoDraweeView cXh;
        private View cXi;
        private VideoView cXj;
        private ImageView cXk;

        public a(View view) {
            this.cXh = (HugePhotoDraweeView) view.findViewById(a.f.album_preview_image);
            this.cXi = view.findViewById(a.f.preview_video_layout);
            this.cXj = (VideoView) view.findViewById(a.f.preview_video_view);
            this.cXk = (ImageView) view.findViewById(a.f.video_preview);
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
                    Bitmap elZ = ((com.facebook.imagepipeline.g.d) obj).elZ();
                    SwanAppAlbumPreviewAdapter.this.cWZ = t.aKd();
                    com.baidu.swan.apps.media.image.b m = com.baidu.swan.apps.media.image.b.m(elZ);
                    if (elZ.getWidth() >= SwanAppAlbumPreviewAdapter.this.cWZ[0] || elZ.getHeight() >= SwanAppAlbumPreviewAdapter.this.cWZ[0]) {
                        m.ayI();
                    } else {
                        m.ayJ();
                    }
                    hugePhotoDraweeView.setImage(m);
                    SwanAppAlbumPreviewAdapter.this.a(hugePhotoDraweeView, elZ);
                } else if (obj instanceof com.facebook.imagepipeline.g.a) {
                    hugePhotoDraweeView.setIsDynamicBitmap(true);
                    hugePhotoDraweeView.setZoomEnabled(false);
                    hugePhotoDraweeView.getHierarchy().b(p.b.oGo);
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
        int displayWidth = ah.getDisplayWidth(this.bIs);
        int displayHeight = ah.getDisplayHeight(this.bIs);
        if (bitmap != null && bitmap.getHeight() > displayHeight * 1.6f) {
            float width = bitmap.getWidth() == 0 ? 1.0f : displayWidth / bitmap.getWidth();
            hugePhotoDraweeView.setDoubleTapZoomScale(width);
            hugePhotoDraweeView.setScaleAndCenter(width, new PointF(displayWidth / 2, 0.0f));
        }
    }
}

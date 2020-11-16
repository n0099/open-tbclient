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
/* loaded from: classes7.dex */
public class SwanAppAlbumPreviewAdapter extends PagerAdapter {
    private ArrayList<MediaModel> aiP;
    private Activity bMo;
    private com.baidu.swan.apps.media.chooser.c.a dbk;
    private a dbm;
    private int[] dbl = new int[1];
    private SparseArray<View> dbj = new SparseArray<>();

    public void a(com.baidu.swan.apps.media.chooser.c.a aVar) {
        this.dbk = aVar;
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.bMo = activity;
        this.aiP = arrayList;
    }

    public void ao(int i, int i2) {
        if (i < this.dbj.size() && this.dbj.get(i) != null) {
            this.dbj.get(i).findViewById(a.f.album_preview_item_root).setBackgroundColor(this.bMo.getResources().getColor(i2));
        }
    }

    public void aAj() {
        if (this.dbm == null || this.dbm.dbv == null || !this.dbm.dbv.isPlaying()) {
            return;
        }
        this.dbm.dbv.stopPlayback();
        a(this.dbm, false);
    }

    public void destroy() {
        if (this.dbm == null) {
            return;
        }
        VideoView videoView = this.dbm.dbv;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.dbm.dbv = null;
        this.dbm = null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.aiP.size();
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
        MediaModel mediaModel = this.aiP.get(i);
        View view = this.dbj.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.bMo).inflate(a.g.swanapp_album_preview_item, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
            this.dbj.put(i, view);
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
        com.facebook.drawee.controller.c a2 = a(aVar.dbt);
        String path = mediaModel.getPath();
        ImageRequestBuilder ae = ImageRequestBuilder.ae(path.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        ae.c(new d(ah.getDisplayWidth(this.bMo), ah.getDisplayHeight(this.bMo), 10240.0f));
        ae.AA(true);
        com.facebook.drawee.controller.a elD = com.facebook.drawee.a.a.c.ekQ().Am(com.baidu.swan.apps.media.chooser.b.c.dbG).bo(ae.erW()).c(a2).c(aVar.dbt.getController()).elH();
        aVar.dbt.setVisibility(0);
        aVar.dbt.setController(elD);
        if (!(mediaModel instanceof ImageModel)) {
            return;
        }
        aVar.dbu.setVisibility(8);
        aVar.dbt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppAlbumPreviewAdapter.this.dbk != null) {
                    SwanAppAlbumPreviewAdapter.this.dbk.aAc();
                }
            }
        });
    }

    private void b(final a aVar, MediaModel mediaModel) {
        if (mediaModel instanceof VideoModel) {
            if (aVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
                return;
            }
            aVar.dbu.setVisibility(8);
            aVar.dbv.setVisibility(8);
            aVar.dbw.setVisibility(0);
            aVar.dbt.setOnClickListener(new AnonymousClass2(aVar, mediaModel));
            aVar.dbu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!aVar.dbv.isPlaying()) {
                        return;
                    }
                    aVar.dbv.stopPlayback();
                    SwanAppAlbumPreviewAdapter.this.b(aVar);
                }
            });
            return;
        }
        aVar.dbw.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$2  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ a dbo;
        final /* synthetic */ MediaModel dbp;

        AnonymousClass2(a aVar, MediaModel mediaModel) {
            this.dbo = aVar;
            this.dbp = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.dbo.dbv.isPlaying()) {
                return;
            }
            this.dbo.dbu.setVisibility(0);
            this.dbo.dbv.setVisibility(0);
            this.dbo.dbw.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.dbk != null) {
                SwanAppAlbumPreviewAdapter.this.dbk.aAd();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.bMo);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.dbo.dbv.setMediaController(mediaController);
            this.dbo.dbv.setVideoPath(this.dbp.getPath());
            this.dbo.dbv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    AnonymousClass2.this.dbo.dbv.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppAlbumPreviewAdapter.this.a(AnonymousClass2.this.dbo);
                        }
                    }, 300L);
                }
            });
            this.dbo.dbv.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.2
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.dbo);
                    return false;
                }
            });
            this.dbo.dbv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.dbo);
                }
            });
            this.dbo.dbv.start();
            SwanAppAlbumPreviewAdapter.this.dbm = this.dbo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.bMo, a.C0367a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.dbt.setVisibility(8);
                aVar.dbt.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.dbt.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        a(aVar, true);
    }

    private void a(final a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        aVar.dbw.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.bMo, a.C0367a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.dbt.setVisibility(0);
                aVar.dbt.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.dbt.startAnimation(loadAnimation);
        if (z && this.dbk != null) {
            this.dbk.aAe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
        private HugePhotoDraweeView dbt;
        private View dbu;
        private VideoView dbv;
        private ImageView dbw;

        public a(View view) {
            this.dbt = (HugePhotoDraweeView) view.findViewById(a.f.album_preview_image);
            this.dbu = view.findViewById(a.f.preview_video_layout);
            this.dbv = (VideoView) view.findViewById(a.f.preview_video_view);
            this.dbw = (ImageView) view.findViewById(a.f.video_preview);
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
                    Bitmap epO = ((com.facebook.imagepipeline.g.d) obj).epO();
                    SwanAppAlbumPreviewAdapter.this.dbl = t.aLV();
                    com.baidu.swan.apps.media.image.b m = com.baidu.swan.apps.media.image.b.m(epO);
                    if (epO.getWidth() >= SwanAppAlbumPreviewAdapter.this.dbl[0] || epO.getHeight() >= SwanAppAlbumPreviewAdapter.this.dbl[0]) {
                        m.aAA();
                    } else {
                        m.aAB();
                    }
                    hugePhotoDraweeView.setImage(m);
                    SwanAppAlbumPreviewAdapter.this.a(hugePhotoDraweeView, epO);
                } else if (obj instanceof com.facebook.imagepipeline.g.a) {
                    hugePhotoDraweeView.setIsDynamicBitmap(true);
                    hugePhotoDraweeView.setZoomEnabled(false);
                    hugePhotoDraweeView.getHierarchy().b(p.b.oRk);
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
        int displayWidth = ah.getDisplayWidth(this.bMo);
        int displayHeight = ah.getDisplayHeight(this.bMo);
        if (bitmap != null && bitmap.getHeight() > displayHeight * 1.6f) {
            float width = bitmap.getWidth() == 0 ? 1.0f : displayWidth / bitmap.getWidth();
            hugePhotoDraweeView.setDoubleTapZoomScale(width);
            hugePhotoDraweeView.setScaleAndCenter(width, new PointF(displayWidth / 2, 0.0f));
        }
    }
}

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
    private Activity bNY;
    private com.baidu.swan.apps.media.chooser.c.a dcT;
    private a dcV;
    private int[] dcU = new int[1];
    private SparseArray<View> dcS = new SparseArray<>();

    public void a(com.baidu.swan.apps.media.chooser.c.a aVar) {
        this.dcT = aVar;
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.bNY = activity;
        this.aiK = arrayList;
    }

    public void ao(int i, int i2) {
        if (i < this.dcS.size() && this.dcS.get(i) != null) {
            this.dcS.get(i).findViewById(a.f.album_preview_item_root).setBackgroundColor(this.bNY.getResources().getColor(i2));
        }
    }

    public void aAR() {
        if (this.dcV == null || this.dcV.dde == null || !this.dcV.dde.isPlaying()) {
            return;
        }
        this.dcV.dde.stopPlayback();
        a(this.dcV, false);
    }

    public void destroy() {
        if (this.dcV == null) {
            return;
        }
        VideoView videoView = this.dcV.dde;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.dcV.dde = null;
        this.dcV = null;
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
        View view = this.dcS.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.bNY).inflate(a.g.swanapp_album_preview_item, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
            this.dcS.put(i, view);
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
        com.facebook.drawee.controller.c a2 = a(aVar.ddc);
        String path = mediaModel.getPath();
        ImageRequestBuilder ad = ImageRequestBuilder.ad(path.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        ad.c(new d(ah.getDisplayWidth(this.bNY), ah.getDisplayHeight(this.bNY), 10240.0f));
        ad.At(true);
        com.facebook.drawee.controller.a elF = com.facebook.drawee.a.a.c.ekS().Af(com.baidu.swan.apps.media.chooser.b.c.ddp).bn(ad.erY()).c(a2).c(aVar.ddc.getController()).elJ();
        aVar.ddc.setVisibility(0);
        aVar.ddc.setController(elF);
        if (!(mediaModel instanceof ImageModel)) {
            return;
        }
        aVar.ddd.setVisibility(8);
        aVar.ddc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppAlbumPreviewAdapter.this.dcT != null) {
                    SwanAppAlbumPreviewAdapter.this.dcT.aAK();
                }
            }
        });
    }

    private void b(final a aVar, MediaModel mediaModel) {
        if (mediaModel instanceof VideoModel) {
            if (aVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
                return;
            }
            aVar.ddd.setVisibility(8);
            aVar.dde.setVisibility(8);
            aVar.ddf.setVisibility(0);
            aVar.ddc.setOnClickListener(new AnonymousClass2(aVar, mediaModel));
            aVar.ddd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!aVar.dde.isPlaying()) {
                        return;
                    }
                    aVar.dde.stopPlayback();
                    SwanAppAlbumPreviewAdapter.this.b(aVar);
                }
            });
            return;
        }
        aVar.ddf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$2  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ a dcX;
        final /* synthetic */ MediaModel dcY;

        AnonymousClass2(a aVar, MediaModel mediaModel) {
            this.dcX = aVar;
            this.dcY = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.dcX.dde.isPlaying()) {
                return;
            }
            this.dcX.ddd.setVisibility(0);
            this.dcX.dde.setVisibility(0);
            this.dcX.ddf.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.dcT != null) {
                SwanAppAlbumPreviewAdapter.this.dcT.aAL();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.bNY);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.dcX.dde.setMediaController(mediaController);
            this.dcX.dde.setVideoPath(this.dcY.getPath());
            this.dcX.dde.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    AnonymousClass2.this.dcX.dde.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppAlbumPreviewAdapter.this.a(AnonymousClass2.this.dcX);
                        }
                    }, 300L);
                }
            });
            this.dcX.dde.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.2
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.dcX);
                    return false;
                }
            });
            this.dcX.dde.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.dcX);
                }
            });
            this.dcX.dde.start();
            SwanAppAlbumPreviewAdapter.this.dcV = this.dcX;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.bNY, a.C0369a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.ddc.setVisibility(8);
                aVar.ddc.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.ddc.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        a(aVar, true);
    }

    private void a(final a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        aVar.ddf.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.bNY, a.C0369a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.ddc.setVisibility(0);
                aVar.ddc.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.ddc.startAnimation(loadAnimation);
        if (z && this.dcT != null) {
            this.dcT.aAM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        private HugePhotoDraweeView ddc;
        private View ddd;
        private VideoView dde;
        private ImageView ddf;

        public a(View view) {
            this.ddc = (HugePhotoDraweeView) view.findViewById(a.f.album_preview_image);
            this.ddd = view.findViewById(a.f.preview_video_layout);
            this.dde = (VideoView) view.findViewById(a.f.preview_video_view);
            this.ddf = (ImageView) view.findViewById(a.f.video_preview);
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
                    Bitmap epQ = ((com.facebook.imagepipeline.g.d) obj).epQ();
                    SwanAppAlbumPreviewAdapter.this.dcU = t.aMD();
                    com.baidu.swan.apps.media.image.b m = com.baidu.swan.apps.media.image.b.m(epQ);
                    if (epQ.getWidth() >= SwanAppAlbumPreviewAdapter.this.dcU[0] || epQ.getHeight() >= SwanAppAlbumPreviewAdapter.this.dcU[0]) {
                        m.aBi();
                    } else {
                        m.aBj();
                    }
                    hugePhotoDraweeView.setImage(m);
                    SwanAppAlbumPreviewAdapter.this.a(hugePhotoDraweeView, epQ);
                } else if (obj instanceof com.facebook.imagepipeline.g.a) {
                    hugePhotoDraweeView.setIsDynamicBitmap(true);
                    hugePhotoDraweeView.setZoomEnabled(false);
                    hugePhotoDraweeView.getHierarchy().b(p.b.oPH);
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
        int displayWidth = ah.getDisplayWidth(this.bNY);
        int displayHeight = ah.getDisplayHeight(this.bNY);
        if (bitmap != null && bitmap.getHeight() > displayHeight * 1.6f) {
            float width = bitmap.getWidth() == 0 ? 1.0f : displayWidth / bitmap.getWidth();
            hugePhotoDraweeView.setDoubleTapZoomScale(width);
            hugePhotoDraweeView.setScaleAndCenter(width, new PointF(displayWidth / 2, 0.0f));
        }
    }
}

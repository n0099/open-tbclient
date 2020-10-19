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
    private ArrayList<MediaModel> aiJ;
    private Activity bFt;
    private com.baidu.swan.apps.media.chooser.c.a cOC;
    private a cOE;
    private int[] cOD = new int[1];
    private SparseArray<View> cOB = new SparseArray<>();

    public void a(com.baidu.swan.apps.media.chooser.c.a aVar) {
        this.cOC = aVar;
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.bFt = activity;
        this.aiJ = arrayList;
    }

    public void an(int i, int i2) {
        if (i < this.cOB.size() && this.cOB.get(i) != null) {
            this.cOB.get(i).findViewById(a.f.album_preview_item_root).setBackgroundColor(this.bFt.getResources().getColor(i2));
        }
    }

    public void awx() {
        if (this.cOE == null || this.cOE.cON == null || !this.cOE.cON.isPlaying()) {
            return;
        }
        this.cOE.cON.stopPlayback();
        a(this.cOE, false);
    }

    public void destroy() {
        if (this.cOE == null) {
            return;
        }
        VideoView videoView = this.cOE.cON;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.cOE.cON = null;
        this.cOE = null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.aiJ.size();
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
        MediaModel mediaModel = this.aiJ.get(i);
        View view = this.cOB.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.bFt).inflate(a.g.swanapp_album_preview_item, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
            this.cOB.put(i, view);
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
        com.facebook.drawee.controller.c a2 = a(aVar.cOL);
        String path = mediaModel.getPath();
        ImageRequestBuilder ad = ImageRequestBuilder.ad(path.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        ad.c(new d(ah.getDisplayWidth(this.bFt), ah.getDisplayHeight(this.bFt), 10240.0f));
        ad.za(true);
        com.facebook.drawee.controller.a dXS = com.facebook.drawee.a.a.c.dXf().yM(com.baidu.swan.apps.media.chooser.b.c.cOY).bj(ad.eej()).c(a2).c(aVar.cOL.getController()).dXW();
        aVar.cOL.setVisibility(0);
        aVar.cOL.setController(dXS);
        if (!(mediaModel instanceof ImageModel)) {
            return;
        }
        aVar.cOM.setVisibility(8);
        aVar.cOL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppAlbumPreviewAdapter.this.cOC != null) {
                    SwanAppAlbumPreviewAdapter.this.cOC.awq();
                }
            }
        });
    }

    private void b(final a aVar, MediaModel mediaModel) {
        if (mediaModel instanceof VideoModel) {
            if (aVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
                return;
            }
            aVar.cOM.setVisibility(8);
            aVar.cON.setVisibility(8);
            aVar.cOO.setVisibility(0);
            aVar.cOL.setOnClickListener(new AnonymousClass2(aVar, mediaModel));
            aVar.cOM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!aVar.cON.isPlaying()) {
                        return;
                    }
                    aVar.cON.stopPlayback();
                    SwanAppAlbumPreviewAdapter.this.b(aVar);
                }
            });
            return;
        }
        aVar.cOO.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$2  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ a cOG;
        final /* synthetic */ MediaModel cOH;

        AnonymousClass2(a aVar, MediaModel mediaModel) {
            this.cOG = aVar;
            this.cOH = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.cOG.cON.isPlaying()) {
                return;
            }
            this.cOG.cOM.setVisibility(0);
            this.cOG.cON.setVisibility(0);
            this.cOG.cOO.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.cOC != null) {
                SwanAppAlbumPreviewAdapter.this.cOC.awr();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.bFt);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.cOG.cON.setMediaController(mediaController);
            this.cOG.cON.setVideoPath(this.cOH.getPath());
            this.cOG.cON.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    AnonymousClass2.this.cOG.cON.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppAlbumPreviewAdapter.this.a(AnonymousClass2.this.cOG);
                        }
                    }, 300L);
                }
            });
            this.cOG.cON.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.2
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.cOG);
                    return false;
                }
            });
            this.cOG.cON.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.cOG);
                }
            });
            this.cOG.cON.start();
            SwanAppAlbumPreviewAdapter.this.cOE = this.cOG;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.bFt, a.C0343a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.cOL.setVisibility(8);
                aVar.cOL.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.cOL.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        a(aVar, true);
    }

    private void a(final a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        aVar.cOO.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.bFt, a.C0343a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.cOL.setVisibility(0);
                aVar.cOL.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.cOL.startAnimation(loadAnimation);
        if (z && this.cOC != null) {
            this.cOC.aws();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        private HugePhotoDraweeView cOL;
        private View cOM;
        private VideoView cON;
        private ImageView cOO;

        public a(View view) {
            this.cOL = (HugePhotoDraweeView) view.findViewById(a.f.album_preview_image);
            this.cOM = view.findViewById(a.f.preview_video_layout);
            this.cON = (VideoView) view.findViewById(a.f.preview_video_view);
            this.cOO = (ImageView) view.findViewById(a.f.video_preview);
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
                    Bitmap ecb = ((com.facebook.imagepipeline.g.d) obj).ecb();
                    SwanAppAlbumPreviewAdapter.this.cOD = t.aIj();
                    com.baidu.swan.apps.media.image.b m = com.baidu.swan.apps.media.image.b.m(ecb);
                    if (ecb.getWidth() >= SwanAppAlbumPreviewAdapter.this.cOD[0] || ecb.getHeight() >= SwanAppAlbumPreviewAdapter.this.cOD[0]) {
                        m.awO();
                    } else {
                        m.awP();
                    }
                    hugePhotoDraweeView.setImage(m);
                    SwanAppAlbumPreviewAdapter.this.a(hugePhotoDraweeView, ecb);
                } else if (obj instanceof com.facebook.imagepipeline.g.a) {
                    hugePhotoDraweeView.setIsDynamicBitmap(true);
                    hugePhotoDraweeView.setZoomEnabled(false);
                    hugePhotoDraweeView.getHierarchy().b(p.b.nOV);
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
        int displayWidth = ah.getDisplayWidth(this.bFt);
        int displayHeight = ah.getDisplayHeight(this.bFt);
        if (bitmap != null && bitmap.getHeight() > displayHeight * 1.6f) {
            float width = bitmap.getWidth() == 0 ? 1.0f : displayWidth / bitmap.getWidth();
            hugePhotoDraweeView.setDoubleTapZoomScale(width);
            hugePhotoDraweeView.setScaleAndCenter(width, new PointF(displayWidth / 2, 0.0f));
        }
    }
}

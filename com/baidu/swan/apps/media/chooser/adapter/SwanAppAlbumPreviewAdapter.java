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
/* loaded from: classes8.dex */
public class SwanAppAlbumPreviewAdapter extends PagerAdapter {
    private ArrayList<MediaModel> ahU;
    private com.baidu.swan.apps.media.chooser.c.a cAt;
    private a cAv;
    private Activity czY;
    private int[] cAu = new int[1];
    private SparseArray<View> cAs = new SparseArray<>();

    public void a(com.baidu.swan.apps.media.chooser.c.a aVar) {
        this.cAt = aVar;
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.czY = activity;
        this.ahU = arrayList;
    }

    public void ao(int i, int i2) {
        if (i < this.cAs.size() && this.cAs.get(i) != null) {
            this.cAs.get(i).findViewById(a.f.album_preview_item_root).setBackgroundColor(this.czY.getResources().getColor(i2));
        }
    }

    public void atd() {
        if (this.cAv == null || this.cAv.cAE == null || !this.cAv.cAE.isPlaying()) {
            return;
        }
        this.cAv.cAE.stopPlayback();
        a(this.cAv, false);
    }

    public void destroy() {
        if (this.cAv == null) {
            return;
        }
        VideoView videoView = this.cAv.cAE;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.cAv.cAE = null;
        this.cAv = null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.ahU.size();
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
        MediaModel mediaModel = this.ahU.get(i);
        View view = this.cAs.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.czY).inflate(a.g.swanapp_album_preview_item, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
            this.cAs.put(i, view);
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
        com.facebook.drawee.controller.c a2 = a(aVar.cAC);
        String path = mediaModel.getPath();
        ImageRequestBuilder ab = ImageRequestBuilder.ab(path.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        ab.c(new d(ah.getDisplayWidth(this.czY), ah.getDisplayHeight(this.czY), 10240.0f));
        ab.yi(true);
        com.facebook.drawee.controller.a dQa = com.facebook.drawee.a.a.c.dPn().xU(com.baidu.swan.apps.media.chooser.b.c.cAP).be(ab.dWr()).c(a2).c(aVar.cAC.getController()).dQe();
        aVar.cAC.setVisibility(0);
        aVar.cAC.setController(dQa);
        if (!(mediaModel instanceof ImageModel)) {
            return;
        }
        aVar.cAD.setVisibility(8);
        aVar.cAC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppAlbumPreviewAdapter.this.cAt != null) {
                    SwanAppAlbumPreviewAdapter.this.cAt.asW();
                }
            }
        });
    }

    private void b(final a aVar, MediaModel mediaModel) {
        if (mediaModel instanceof VideoModel) {
            if (aVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
                return;
            }
            aVar.cAD.setVisibility(8);
            aVar.cAE.setVisibility(8);
            aVar.cAF.setVisibility(0);
            aVar.cAC.setOnClickListener(new AnonymousClass2(aVar, mediaModel));
            aVar.cAD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!aVar.cAE.isPlaying()) {
                        return;
                    }
                    aVar.cAE.stopPlayback();
                    SwanAppAlbumPreviewAdapter.this.b(aVar);
                }
            });
            return;
        }
        aVar.cAF.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$2  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ a cAx;
        final /* synthetic */ MediaModel cAy;

        AnonymousClass2(a aVar, MediaModel mediaModel) {
            this.cAx = aVar;
            this.cAy = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.cAx.cAE.isPlaying()) {
                return;
            }
            this.cAx.cAD.setVisibility(0);
            this.cAx.cAE.setVisibility(0);
            this.cAx.cAF.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.cAt != null) {
                SwanAppAlbumPreviewAdapter.this.cAt.asX();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.czY);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.cAx.cAE.setMediaController(mediaController);
            this.cAx.cAE.setVideoPath(this.cAy.getPath());
            this.cAx.cAE.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    AnonymousClass2.this.cAx.cAE.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppAlbumPreviewAdapter.this.a(AnonymousClass2.this.cAx);
                        }
                    }, 300L);
                }
            });
            this.cAx.cAE.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.2
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.cAx);
                    return false;
                }
            });
            this.cAx.cAE.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.cAx);
                }
            });
            this.cAx.cAE.start();
            SwanAppAlbumPreviewAdapter.this.cAv = this.cAx;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.czY, a.C0331a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.cAC.setVisibility(8);
                aVar.cAC.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.cAC.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        a(aVar, true);
    }

    private void a(final a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        aVar.cAF.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.czY, a.C0331a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.cAC.setVisibility(0);
                aVar.cAC.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.cAC.startAnimation(loadAnimation);
        if (z && this.cAt != null) {
            this.cAt.asY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        private HugePhotoDraweeView cAC;
        private View cAD;
        private VideoView cAE;
        private ImageView cAF;

        public a(View view) {
            this.cAC = (HugePhotoDraweeView) view.findViewById(a.f.album_preview_image);
            this.cAD = view.findViewById(a.f.preview_video_layout);
            this.cAE = (VideoView) view.findViewById(a.f.preview_video_view);
            this.cAF = (ImageView) view.findViewById(a.f.video_preview);
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
                    Bitmap dUj = ((com.facebook.imagepipeline.g.d) obj).dUj();
                    SwanAppAlbumPreviewAdapter.this.cAu = t.aEQ();
                    com.baidu.swan.apps.media.image.b m = com.baidu.swan.apps.media.image.b.m(dUj);
                    if (dUj.getWidth() >= SwanAppAlbumPreviewAdapter.this.cAu[0] || dUj.getHeight() >= SwanAppAlbumPreviewAdapter.this.cAu[0]) {
                        m.atu();
                    } else {
                        m.atv();
                    }
                    hugePhotoDraweeView.setImage(m);
                    SwanAppAlbumPreviewAdapter.this.a(hugePhotoDraweeView, dUj);
                } else if (obj instanceof com.facebook.imagepipeline.g.a) {
                    hugePhotoDraweeView.setIsDynamicBitmap(true);
                    hugePhotoDraweeView.setZoomEnabled(false);
                    hugePhotoDraweeView.getHierarchy().b(p.b.npm);
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
        int displayWidth = ah.getDisplayWidth(this.czY);
        int displayHeight = ah.getDisplayHeight(this.czY);
        if (bitmap != null && bitmap.getHeight() > displayHeight * 1.6f) {
            float width = bitmap.getWidth() == 0 ? 1.0f : displayWidth / bitmap.getWidth();
            hugePhotoDraweeView.setDoubleTapZoomScale(width);
            hugePhotoDraweeView.setScaleAndCenter(width, new PointF(displayWidth / 2, 0.0f));
        }
    }
}

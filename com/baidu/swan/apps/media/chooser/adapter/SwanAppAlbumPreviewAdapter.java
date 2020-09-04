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
    private ArrayList<MediaModel> ahW;
    private Activity cAc;
    private com.baidu.swan.apps.media.chooser.c.a cAx;
    private a cAz;
    private int[] cAy = new int[1];
    private SparseArray<View> cAw = new SparseArray<>();

    public void a(com.baidu.swan.apps.media.chooser.c.a aVar) {
        this.cAx = aVar;
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.cAc = activity;
        this.ahW = arrayList;
    }

    public void ao(int i, int i2) {
        if (i < this.cAw.size() && this.cAw.get(i) != null) {
            this.cAw.get(i).findViewById(a.f.album_preview_item_root).setBackgroundColor(this.cAc.getResources().getColor(i2));
        }
    }

    public void atd() {
        if (this.cAz == null || this.cAz.cAI == null || !this.cAz.cAI.isPlaying()) {
            return;
        }
        this.cAz.cAI.stopPlayback();
        a(this.cAz, false);
    }

    public void destroy() {
        if (this.cAz == null) {
            return;
        }
        VideoView videoView = this.cAz.cAI;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.cAz.cAI = null;
        this.cAz = null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.ahW.size();
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
        MediaModel mediaModel = this.ahW.get(i);
        View view = this.cAw.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.cAc).inflate(a.g.swanapp_album_preview_item, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
            this.cAw.put(i, view);
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
        com.facebook.drawee.controller.c a2 = a(aVar.cAG);
        String path = mediaModel.getPath();
        ImageRequestBuilder ab = ImageRequestBuilder.ab(path.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        ab.c(new d(ah.getDisplayWidth(this.cAc), ah.getDisplayHeight(this.cAc), 10240.0f));
        ab.yk(true);
        com.facebook.drawee.controller.a dQj = com.facebook.drawee.a.a.c.dPw().xW(com.baidu.swan.apps.media.chooser.b.c.cAT).be(ab.dWA()).c(a2).c(aVar.cAG.getController()).dQn();
        aVar.cAG.setVisibility(0);
        aVar.cAG.setController(dQj);
        if (!(mediaModel instanceof ImageModel)) {
            return;
        }
        aVar.cAH.setVisibility(8);
        aVar.cAG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppAlbumPreviewAdapter.this.cAx != null) {
                    SwanAppAlbumPreviewAdapter.this.cAx.asW();
                }
            }
        });
    }

    private void b(final a aVar, MediaModel mediaModel) {
        if (mediaModel instanceof VideoModel) {
            if (aVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
                return;
            }
            aVar.cAH.setVisibility(8);
            aVar.cAI.setVisibility(8);
            aVar.cAJ.setVisibility(0);
            aVar.cAG.setOnClickListener(new AnonymousClass2(aVar, mediaModel));
            aVar.cAH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!aVar.cAI.isPlaying()) {
                        return;
                    }
                    aVar.cAI.stopPlayback();
                    SwanAppAlbumPreviewAdapter.this.b(aVar);
                }
            });
            return;
        }
        aVar.cAJ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$2  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ a cAB;
        final /* synthetic */ MediaModel cAC;

        AnonymousClass2(a aVar, MediaModel mediaModel) {
            this.cAB = aVar;
            this.cAC = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.cAB.cAI.isPlaying()) {
                return;
            }
            this.cAB.cAH.setVisibility(0);
            this.cAB.cAI.setVisibility(0);
            this.cAB.cAJ.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.cAx != null) {
                SwanAppAlbumPreviewAdapter.this.cAx.asX();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.cAc);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.cAB.cAI.setMediaController(mediaController);
            this.cAB.cAI.setVideoPath(this.cAC.getPath());
            this.cAB.cAI.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    AnonymousClass2.this.cAB.cAI.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppAlbumPreviewAdapter.this.a(AnonymousClass2.this.cAB);
                        }
                    }, 300L);
                }
            });
            this.cAB.cAI.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.2
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.cAB);
                    return false;
                }
            });
            this.cAB.cAI.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.cAB);
                }
            });
            this.cAB.cAI.start();
            SwanAppAlbumPreviewAdapter.this.cAz = this.cAB;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.cAc, a.C0331a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.cAG.setVisibility(8);
                aVar.cAG.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.cAG.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        a(aVar, true);
    }

    private void a(final a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        aVar.cAJ.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.cAc, a.C0331a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.cAG.setVisibility(0);
                aVar.cAG.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.cAG.startAnimation(loadAnimation);
        if (z && this.cAx != null) {
            this.cAx.asY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        private HugePhotoDraweeView cAG;
        private View cAH;
        private VideoView cAI;
        private ImageView cAJ;

        public a(View view) {
            this.cAG = (HugePhotoDraweeView) view.findViewById(a.f.album_preview_image);
            this.cAH = view.findViewById(a.f.preview_video_layout);
            this.cAI = (VideoView) view.findViewById(a.f.preview_video_view);
            this.cAJ = (ImageView) view.findViewById(a.f.video_preview);
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
                    Bitmap dUs = ((com.facebook.imagepipeline.g.d) obj).dUs();
                    SwanAppAlbumPreviewAdapter.this.cAy = t.aEQ();
                    com.baidu.swan.apps.media.image.b m = com.baidu.swan.apps.media.image.b.m(dUs);
                    if (dUs.getWidth() >= SwanAppAlbumPreviewAdapter.this.cAy[0] || dUs.getHeight() >= SwanAppAlbumPreviewAdapter.this.cAy[0]) {
                        m.atu();
                    } else {
                        m.atv();
                    }
                    hugePhotoDraweeView.setImage(m);
                    SwanAppAlbumPreviewAdapter.this.a(hugePhotoDraweeView, dUs);
                } else if (obj instanceof com.facebook.imagepipeline.g.a) {
                    hugePhotoDraweeView.setIsDynamicBitmap(true);
                    hugePhotoDraweeView.setZoomEnabled(false);
                    hugePhotoDraweeView.getHierarchy().b(p.b.npE);
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
        int displayWidth = ah.getDisplayWidth(this.cAc);
        int displayHeight = ah.getDisplayHeight(this.cAc);
        if (bitmap != null && bitmap.getHeight() > displayHeight * 1.6f) {
            float width = bitmap.getWidth() == 0 ? 1.0f : displayWidth / bitmap.getWidth();
            hugePhotoDraweeView.setDoubleTapZoomScale(width);
            hugePhotoDraweeView.setScaleAndCenter(width, new PointF(displayWidth / 2, 0.0f));
        }
    }
}

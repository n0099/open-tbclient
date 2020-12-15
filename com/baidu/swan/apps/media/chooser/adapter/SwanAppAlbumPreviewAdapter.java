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
/* loaded from: classes25.dex */
public class SwanAppAlbumPreviewAdapter extends PagerAdapter {
    private ArrayList<MediaModel> ajO;
    private Activity beD;
    private com.baidu.swan.apps.media.chooser.c.a dij;
    private a dil;
    private int[] dik = new int[1];
    private SparseArray<View> dii = new SparseArray<>();

    public void a(com.baidu.swan.apps.media.chooser.c.a aVar) {
        this.dij = aVar;
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.beD = activity;
        this.ajO = arrayList;
    }

    public void aq(int i, int i2) {
        if (i < this.dii.size() && this.dii.get(i) != null) {
            this.dii.get(i).findViewById(a.f.album_preview_item_root).setBackgroundColor(this.beD.getResources().getColor(i2));
        }
    }

    public void aDs() {
        if (this.dil == null || this.dil.diw == null || !this.dil.diw.isPlaying()) {
            return;
        }
        this.dil.diw.stopPlayback();
        a(this.dil, false);
    }

    public void destroy() {
        if (this.dil == null) {
            return;
        }
        VideoView videoView = this.dil.diw;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.dil.diw = null;
        this.dil = null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.ajO.size();
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
        MediaModel mediaModel = this.ajO.get(i);
        View view = this.dii.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.beD).inflate(a.g.swanapp_album_preview_item, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
            this.dii.put(i, view);
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
        com.facebook.drawee.controller.c a2 = a(aVar.diu);
        String path = mediaModel.getPath();
        ImageRequestBuilder af = ImageRequestBuilder.af(path.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        af.c(new d(ah.getDisplayWidth(this.beD), ah.getDisplayHeight(this.beD), 10240.0f));
        af.Bb(true);
        com.facebook.drawee.controller.a ert = com.facebook.drawee.a.a.c.eqG().AP(com.baidu.swan.apps.media.chooser.b.c.diH).bo(af.exx()).c(a2).c(aVar.diu.getController()).erx();
        aVar.diu.setVisibility(0);
        aVar.diu.setController(ert);
        if (!(mediaModel instanceof ImageModel)) {
            return;
        }
        aVar.div.setVisibility(8);
        aVar.diu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppAlbumPreviewAdapter.this.dij != null) {
                    SwanAppAlbumPreviewAdapter.this.dij.aDl();
                }
            }
        });
    }

    private void b(final a aVar, MediaModel mediaModel) {
        if (mediaModel instanceof VideoModel) {
            if (aVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
                return;
            }
            aVar.div.setVisibility(8);
            aVar.diw.setVisibility(8);
            aVar.dix.setVisibility(0);
            aVar.diu.setOnClickListener(new AnonymousClass2(aVar, mediaModel));
            aVar.div.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!aVar.diw.isPlaying()) {
                        return;
                    }
                    aVar.diw.stopPlayback();
                    SwanAppAlbumPreviewAdapter.this.b(aVar);
                }
            });
            return;
        }
        aVar.dix.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$2  reason: invalid class name */
    /* loaded from: classes25.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ a din;
        final /* synthetic */ MediaModel dio;

        AnonymousClass2(a aVar, MediaModel mediaModel) {
            this.din = aVar;
            this.dio = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.din.diw.isPlaying()) {
                return;
            }
            this.din.div.setVisibility(0);
            this.din.diw.setVisibility(0);
            this.din.dix.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.dij != null) {
                SwanAppAlbumPreviewAdapter.this.dij.aDm();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.beD);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.din.diw.setMediaController(mediaController);
            this.din.diw.setVideoPath(this.dio.getPath());
            this.din.diw.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    AnonymousClass2.this.din.diw.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppAlbumPreviewAdapter.this.a(AnonymousClass2.this.din);
                        }
                    }, 300L);
                }
            });
            this.din.diw.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.2
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.din);
                    return false;
                }
            });
            this.din.diw.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.din);
                }
            });
            this.din.diw.start();
            SwanAppAlbumPreviewAdapter.this.dil = this.din;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.beD, a.C0379a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.diu.setVisibility(8);
                aVar.diu.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.diu.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        a(aVar, true);
    }

    private void a(final a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        aVar.dix.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.beD, a.C0379a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.diu.setVisibility(0);
                aVar.diu.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.diu.startAnimation(loadAnimation);
        if (z && this.dij != null) {
            this.dij.aDn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a {
        private HugePhotoDraweeView diu;
        private View div;
        private VideoView diw;
        private ImageView dix;

        public a(View view) {
            this.diu = (HugePhotoDraweeView) view.findViewById(a.f.album_preview_image);
            this.div = view.findViewById(a.f.preview_video_layout);
            this.diw = (VideoView) view.findViewById(a.f.preview_video_view);
            this.dix = (ImageView) view.findViewById(a.f.video_preview);
        }
    }

    private com.facebook.drawee.controller.c a(final HugePhotoDraweeView hugePhotoDraweeView) {
        return new com.facebook.drawee.controller.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.6
            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void f(String str, Object obj) {
                super.f(str, obj);
            }

            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void a(String str, Object obj, Animatable animatable) {
                super.a(str, obj, animatable);
                if (obj instanceof com.facebook.imagepipeline.f.d) {
                    hugePhotoDraweeView.setIsDynamicBitmap(false);
                    hugePhotoDraweeView.setZoomEnabled(true);
                    Bitmap evu = ((com.facebook.imagepipeline.f.d) obj).evu();
                    SwanAppAlbumPreviewAdapter.this.dik = t.aPc();
                    com.baidu.swan.apps.media.image.b m = com.baidu.swan.apps.media.image.b.m(evu);
                    if (evu.getWidth() >= SwanAppAlbumPreviewAdapter.this.dik[0] || evu.getHeight() >= SwanAppAlbumPreviewAdapter.this.dik[0]) {
                        m.aDJ();
                    } else {
                        m.aDK();
                    }
                    hugePhotoDraweeView.setImage(m);
                    SwanAppAlbumPreviewAdapter.this.a(hugePhotoDraweeView, evu);
                } else if (obj instanceof com.facebook.imagepipeline.f.a) {
                    hugePhotoDraweeView.setIsDynamicBitmap(true);
                    hugePhotoDraweeView.setZoomEnabled(false);
                    hugePhotoDraweeView.getHierarchy().b(p.b.pgv);
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
        int displayWidth = ah.getDisplayWidth(this.beD);
        int displayHeight = ah.getDisplayHeight(this.beD);
        if (bitmap != null && bitmap.getHeight() > displayHeight * 1.6f) {
            float width = bitmap.getWidth() == 0 ? 1.0f : displayWidth / bitmap.getWidth();
            hugePhotoDraweeView.setDoubleTapZoomScale(width);
            hugePhotoDraweeView.setScaleAndCenter(width, new PointF(displayWidth / 2, 0.0f));
        }
    }
}

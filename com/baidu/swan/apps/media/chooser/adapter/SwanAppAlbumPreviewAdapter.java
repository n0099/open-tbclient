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
    private ArrayList<MediaModel> caH;
    private Activity caN;
    private com.baidu.swan.apps.media.chooser.c.a cbk;
    private a cbm;
    private int[] cbl = new int[1];
    private SparseArray<View> cbj = new SparseArray<>();

    public void a(com.baidu.swan.apps.media.chooser.c.a aVar) {
        this.cbk = aVar;
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.caN = activity;
        this.caH = arrayList;
    }

    public void ae(int i, int i2) {
        if (i < this.cbj.size() && this.cbj.get(i) != null) {
            this.cbj.get(i).findViewById(a.f.album_preview_item_root).setBackgroundColor(this.caN.getResources().getColor(i2));
        }
    }

    public void afE() {
        if (this.cbm == null || this.cbm.cbv == null || !this.cbm.cbv.isPlaying()) {
            return;
        }
        this.cbm.cbv.stopPlayback();
        a(this.cbm, false);
    }

    public void destroy() {
        if (this.cbm == null) {
            return;
        }
        VideoView videoView = this.cbm.cbv;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.cbm.cbv = null;
        this.cbm = null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.caH.size();
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
        MediaModel mediaModel = this.caH.get(i);
        View view = this.cbj.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.caN).inflate(a.g.swanapp_album_preview_item, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
            this.cbj.put(i, view);
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
        com.facebook.drawee.controller.c a2 = a(aVar.cbt);
        String path = mediaModel.getPath();
        ImageRequestBuilder Z = ImageRequestBuilder.Z(path.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        Z.c(new d(af.getDisplayWidth(this.caN), af.getDisplayHeight(this.caN), 10240.0f));
        Z.vQ(true);
        com.facebook.drawee.controller.a doz = com.facebook.drawee.a.a.c.dnM().vC(com.baidu.swan.apps.media.chooser.b.c.cbG).aX(Z.duT()).c(a2).c(aVar.cbt.getController()).doD();
        aVar.cbt.setVisibility(0);
        aVar.cbt.setController(doz);
        if (!(mediaModel instanceof ImageModel)) {
            return;
        }
        aVar.cbu.setVisibility(8);
        aVar.cbt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppAlbumPreviewAdapter.this.cbk != null) {
                    SwanAppAlbumPreviewAdapter.this.cbk.afx();
                }
            }
        });
    }

    private void b(final a aVar, MediaModel mediaModel) {
        if (mediaModel instanceof VideoModel) {
            if (aVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
                return;
            }
            aVar.cbu.setVisibility(8);
            aVar.cbv.setVisibility(8);
            aVar.cbw.setVisibility(0);
            aVar.cbt.setOnClickListener(new AnonymousClass2(aVar, mediaModel));
            aVar.cbu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!aVar.cbv.isPlaying()) {
                        return;
                    }
                    aVar.cbv.stopPlayback();
                    SwanAppAlbumPreviewAdapter.this.b(aVar);
                }
            });
            return;
        }
        aVar.cbw.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$2  reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ a cbo;
        final /* synthetic */ MediaModel cbp;

        AnonymousClass2(a aVar, MediaModel mediaModel) {
            this.cbo = aVar;
            this.cbp = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.cbo.cbv.isPlaying()) {
                return;
            }
            this.cbo.cbu.setVisibility(0);
            this.cbo.cbv.setVisibility(0);
            this.cbo.cbw.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.cbk != null) {
                SwanAppAlbumPreviewAdapter.this.cbk.afy();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.caN);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.cbo.cbv.setMediaController(mediaController);
            this.cbo.cbv.setVideoPath(this.cbp.getPath());
            this.cbo.cbv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    AnonymousClass2.this.cbo.cbv.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppAlbumPreviewAdapter.this.a(AnonymousClass2.this.cbo);
                        }
                    }, 300L);
                }
            });
            this.cbo.cbv.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.2
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.cbo);
                    return false;
                }
            });
            this.cbo.cbv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.cbo);
                }
            });
            this.cbo.cbv.start();
            SwanAppAlbumPreviewAdapter.this.cbm = this.cbo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.caN, a.C0248a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.cbt.setVisibility(8);
                aVar.cbt.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.cbt.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        a(aVar, true);
    }

    private void a(final a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        aVar.cbw.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.caN, a.C0248a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.cbt.setVisibility(0);
                aVar.cbt.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.cbt.startAnimation(loadAnimation);
        if (z && this.cbk != null) {
            this.cbk.afz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        private HugePhotoDraweeView cbt;
        private View cbu;
        private VideoView cbv;
        private ImageView cbw;

        public a(View view) {
            this.cbt = (HugePhotoDraweeView) view.findViewById(a.f.album_preview_image);
            this.cbu = view.findViewById(a.f.preview_video_layout);
            this.cbv = (VideoView) view.findViewById(a.f.preview_video_view);
            this.cbw = (ImageView) view.findViewById(a.f.video_preview);
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
                    Bitmap dsK = ((com.facebook.imagepipeline.g.d) obj).dsK();
                    SwanAppAlbumPreviewAdapter.this.cbl = q.aoX();
                    com.baidu.swan.apps.media.image.b j = com.baidu.swan.apps.media.image.b.j(dsK);
                    if (dsK.getWidth() >= SwanAppAlbumPreviewAdapter.this.cbl[0] || dsK.getHeight() >= SwanAppAlbumPreviewAdapter.this.cbl[0]) {
                        j.afW();
                    } else {
                        j.afX();
                    }
                    hugePhotoDraweeView.setImage(j);
                    SwanAppAlbumPreviewAdapter.this.a(hugePhotoDraweeView, dsK);
                } else if (obj instanceof com.facebook.imagepipeline.g.a) {
                    hugePhotoDraweeView.setIsDynamicBitmap(true);
                    hugePhotoDraweeView.setZoomEnabled(false);
                    hugePhotoDraweeView.getHierarchy().b(p.b.lWg);
                }
            }

            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void g(String str, Throwable th) {
                super.g(str, th);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HugePhotoDraweeView hugePhotoDraweeView, Bitmap bitmap) {
        int displayWidth = af.getDisplayWidth(this.caN);
        int displayHeight = af.getDisplayHeight(this.caN);
        if (bitmap != null && bitmap.getHeight() > displayHeight * 1.6f) {
            float width = bitmap.getWidth() == 0 ? 1.0f : displayWidth / bitmap.getWidth();
            hugePhotoDraweeView.setDoubleTapZoomScale(width);
            hugePhotoDraweeView.setScaleAndCenter(width, new PointF(displayWidth / 2, 0.0f));
        }
    }
}

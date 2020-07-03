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
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.r;
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
    private ArrayList<MediaModel> agU;
    private Activity bdo;
    private com.baidu.swan.apps.media.chooser.c.a cqB;
    private a cqD;
    private int[] cqC = new int[1];
    private SparseArray<View> cqA = new SparseArray<>();

    public void a(com.baidu.swan.apps.media.chooser.c.a aVar) {
        this.cqB = aVar;
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.bdo = activity;
        this.agU = arrayList;
    }

    public void aj(int i, int i2) {
        if (i < this.cqA.size() && this.cqA.get(i) != null) {
            this.cqA.get(i).findViewById(a.f.album_preview_item_root).setBackgroundColor(this.bdo.getResources().getColor(i2));
        }
    }

    public void ajZ() {
        if (this.cqD == null || this.cqD.cqM == null || !this.cqD.cqM.isPlaying()) {
            return;
        }
        this.cqD.cqM.stopPlayback();
        a(this.cqD, false);
    }

    public void destroy() {
        if (this.cqD == null) {
            return;
        }
        VideoView videoView = this.cqD.cqM;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.cqD.cqM = null;
        this.cqD = null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.agU.size();
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
        MediaModel mediaModel = this.agU.get(i);
        View view = this.cqA.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.bdo).inflate(a.g.swanapp_album_preview_item, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
            this.cqA.put(i, view);
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
        com.facebook.drawee.controller.c a2 = a(aVar.cqK);
        String path = mediaModel.getPath();
        ImageRequestBuilder ac = ImageRequestBuilder.ac(path.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        ac.c(new d(ag.getDisplayWidth(this.bdo), ag.getDisplayHeight(this.bdo), 10240.0f));
        ac.wM(true);
        com.facebook.drawee.controller.a dAJ = com.facebook.drawee.a.a.c.dzW().wy(com.baidu.swan.apps.media.chooser.b.c.cqX).bc(ac.dHb()).c(a2).c(aVar.cqK.getController()).dAN();
        aVar.cqK.setVisibility(0);
        aVar.cqK.setController(dAJ);
        if (!(mediaModel instanceof ImageModel)) {
            return;
        }
        aVar.cqL.setVisibility(8);
        aVar.cqK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppAlbumPreviewAdapter.this.cqB != null) {
                    SwanAppAlbumPreviewAdapter.this.cqB.ajS();
                }
            }
        });
    }

    private void b(final a aVar, MediaModel mediaModel) {
        if (mediaModel instanceof VideoModel) {
            if (aVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
                return;
            }
            aVar.cqL.setVisibility(8);
            aVar.cqM.setVisibility(8);
            aVar.cqN.setVisibility(0);
            aVar.cqK.setOnClickListener(new AnonymousClass2(aVar, mediaModel));
            aVar.cqL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!aVar.cqM.isPlaying()) {
                        return;
                    }
                    aVar.cqM.stopPlayback();
                    SwanAppAlbumPreviewAdapter.this.b(aVar);
                }
            });
            return;
        }
        aVar.cqN.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$2  reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ a cqF;
        final /* synthetic */ MediaModel cqG;

        AnonymousClass2(a aVar, MediaModel mediaModel) {
            this.cqF = aVar;
            this.cqG = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.cqF.cqM.isPlaying()) {
                return;
            }
            this.cqF.cqL.setVisibility(0);
            this.cqF.cqM.setVisibility(0);
            this.cqF.cqN.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.cqB != null) {
                SwanAppAlbumPreviewAdapter.this.cqB.ajT();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.bdo);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.cqF.cqM.setMediaController(mediaController);
            this.cqF.cqM.setVideoPath(this.cqG.getPath());
            this.cqF.cqM.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    AnonymousClass2.this.cqF.cqM.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppAlbumPreviewAdapter.this.a(AnonymousClass2.this.cqF);
                        }
                    }, 300L);
                }
            });
            this.cqF.cqM.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.2
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.cqF);
                    return false;
                }
            });
            this.cqF.cqM.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.cqF);
                }
            });
            this.cqF.cqM.start();
            SwanAppAlbumPreviewAdapter.this.cqD = this.cqF;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.bdo, a.C0287a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.cqK.setVisibility(8);
                aVar.cqK.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.cqK.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        a(aVar, true);
    }

    private void a(final a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        aVar.cqN.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.bdo, a.C0287a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.cqK.setVisibility(0);
                aVar.cqK.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.cqK.startAnimation(loadAnimation);
        if (z && this.cqB != null) {
            this.cqB.ajU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        private HugePhotoDraweeView cqK;
        private View cqL;
        private VideoView cqM;
        private ImageView cqN;

        public a(View view) {
            this.cqK = (HugePhotoDraweeView) view.findViewById(a.f.album_preview_image);
            this.cqL = view.findViewById(a.f.preview_video_layout);
            this.cqM = (VideoView) view.findViewById(a.f.preview_video_view);
            this.cqN = (ImageView) view.findViewById(a.f.video_preview);
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
                    Bitmap dET = ((com.facebook.imagepipeline.g.d) obj).dET();
                    SwanAppAlbumPreviewAdapter.this.cqC = r.auE();
                    com.baidu.swan.apps.media.image.b j = com.baidu.swan.apps.media.image.b.j(dET);
                    if (dET.getWidth() >= SwanAppAlbumPreviewAdapter.this.cqC[0] || dET.getHeight() >= SwanAppAlbumPreviewAdapter.this.cqC[0]) {
                        j.akr();
                    } else {
                        j.aks();
                    }
                    hugePhotoDraweeView.setImage(j);
                    SwanAppAlbumPreviewAdapter.this.a(hugePhotoDraweeView, dET);
                } else if (obj instanceof com.facebook.imagepipeline.g.a) {
                    hugePhotoDraweeView.setIsDynamicBitmap(true);
                    hugePhotoDraweeView.setZoomEnabled(false);
                    hugePhotoDraweeView.getHierarchy().b(p.b.mNi);
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
        int displayWidth = ag.getDisplayWidth(this.bdo);
        int displayHeight = ag.getDisplayHeight(this.bdo);
        if (bitmap != null && bitmap.getHeight() > displayHeight * 1.6f) {
            float width = bitmap.getWidth() == 0 ? 1.0f : displayWidth / bitmap.getWidth();
            hugePhotoDraweeView.setDoubleTapZoomScale(width);
            hugePhotoDraweeView.setScaleAndCenter(width, new PointF(displayWidth / 2, 0.0f));
        }
    }
}

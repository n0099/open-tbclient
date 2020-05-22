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
    private com.baidu.swan.apps.media.chooser.c.a clN;
    private a clP;
    private ArrayList<MediaModel> clk;
    private Activity clq;
    private int[] clO = new int[1];
    private SparseArray<View> clM = new SparseArray<>();

    public void a(com.baidu.swan.apps.media.chooser.c.a aVar) {
        this.clN = aVar;
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.clq = activity;
        this.clk = arrayList;
    }

    public void ah(int i, int i2) {
        if (i < this.clM.size() && this.clM.get(i) != null) {
            this.clM.get(i).findViewById(a.f.album_preview_item_root).setBackgroundColor(this.clq.getResources().getColor(i2));
        }
    }

    public void aiT() {
        if (this.clP == null || this.clP.clY == null || !this.clP.clY.isPlaying()) {
            return;
        }
        this.clP.clY.stopPlayback();
        a(this.clP, false);
    }

    public void destroy() {
        if (this.clP == null) {
            return;
        }
        VideoView videoView = this.clP.clY;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.clP.clY = null;
        this.clP = null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.clk.size();
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
        MediaModel mediaModel = this.clk.get(i);
        View view = this.clM.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.clq).inflate(a.g.swanapp_album_preview_item, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
            this.clM.put(i, view);
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
        com.facebook.drawee.controller.c a2 = a(aVar.clW);
        String path = mediaModel.getPath();
        ImageRequestBuilder ab = ImageRequestBuilder.ab(path.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        ab.c(new d(ag.getDisplayWidth(this.clq), ag.getDisplayHeight(this.clq), 10240.0f));
        ab.wo(true);
        com.facebook.drawee.controller.a dvS = com.facebook.drawee.a.a.c.dvf().wa(com.baidu.swan.apps.media.chooser.b.c.cmk).bb(ab.dCl()).c(a2).c(aVar.clW.getController()).dvW();
        aVar.clW.setVisibility(0);
        aVar.clW.setController(dvS);
        if (!(mediaModel instanceof ImageModel)) {
            return;
        }
        aVar.clX.setVisibility(8);
        aVar.clW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppAlbumPreviewAdapter.this.clN != null) {
                    SwanAppAlbumPreviewAdapter.this.clN.aiM();
                }
            }
        });
    }

    private void b(final a aVar, MediaModel mediaModel) {
        if (mediaModel instanceof VideoModel) {
            if (aVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
                return;
            }
            aVar.clX.setVisibility(8);
            aVar.clY.setVisibility(8);
            aVar.clZ.setVisibility(0);
            aVar.clW.setOnClickListener(new AnonymousClass2(aVar, mediaModel));
            aVar.clX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!aVar.clY.isPlaying()) {
                        return;
                    }
                    aVar.clY.stopPlayback();
                    SwanAppAlbumPreviewAdapter.this.b(aVar);
                }
            });
            return;
        }
        aVar.clZ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$2  reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ a clR;
        final /* synthetic */ MediaModel clS;

        AnonymousClass2(a aVar, MediaModel mediaModel) {
            this.clR = aVar;
            this.clS = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.clR.clY.isPlaying()) {
                return;
            }
            this.clR.clX.setVisibility(0);
            this.clR.clY.setVisibility(0);
            this.clR.clZ.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.clN != null) {
                SwanAppAlbumPreviewAdapter.this.clN.aiN();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.clq);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.clR.clY.setMediaController(mediaController);
            this.clR.clY.setVideoPath(this.clS.getPath());
            this.clR.clY.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    AnonymousClass2.this.clR.clY.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppAlbumPreviewAdapter.this.a(AnonymousClass2.this.clR);
                        }
                    }, 300L);
                }
            });
            this.clR.clY.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.2
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.clR);
                    return false;
                }
            });
            this.clR.clY.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.clR);
                }
            });
            this.clR.clY.start();
            SwanAppAlbumPreviewAdapter.this.clP = this.clR;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.clq, a.C0281a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.clW.setVisibility(8);
                aVar.clW.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.clW.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        a(aVar, true);
    }

    private void a(final a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        aVar.clZ.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.clq, a.C0281a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.clW.setVisibility(0);
                aVar.clW.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.clW.startAnimation(loadAnimation);
        if (z && this.clN != null) {
            this.clN.aiO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        private HugePhotoDraweeView clW;
        private View clX;
        private VideoView clY;
        private ImageView clZ;

        public a(View view) {
            this.clW = (HugePhotoDraweeView) view.findViewById(a.f.album_preview_image);
            this.clX = view.findViewById(a.f.preview_video_layout);
            this.clY = (VideoView) view.findViewById(a.f.preview_video_view);
            this.clZ = (ImageView) view.findViewById(a.f.video_preview);
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
                    Bitmap dAd = ((com.facebook.imagepipeline.g.d) obj).dAd();
                    SwanAppAlbumPreviewAdapter.this.clO = r.aty();
                    com.baidu.swan.apps.media.image.b j = com.baidu.swan.apps.media.image.b.j(dAd);
                    if (dAd.getWidth() >= SwanAppAlbumPreviewAdapter.this.clO[0] || dAd.getHeight() >= SwanAppAlbumPreviewAdapter.this.clO[0]) {
                        j.ajl();
                    } else {
                        j.ajm();
                    }
                    hugePhotoDraweeView.setImage(j);
                    SwanAppAlbumPreviewAdapter.this.a(hugePhotoDraweeView, dAd);
                } else if (obj instanceof com.facebook.imagepipeline.g.a) {
                    hugePhotoDraweeView.setIsDynamicBitmap(true);
                    hugePhotoDraweeView.setZoomEnabled(false);
                    hugePhotoDraweeView.getHierarchy().b(p.b.mqa);
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
        int displayWidth = ag.getDisplayWidth(this.clq);
        int displayHeight = ag.getDisplayHeight(this.clq);
        if (bitmap != null && bitmap.getHeight() > displayHeight * 1.6f) {
            float width = bitmap.getWidth() == 0 ? 1.0f : displayWidth / bitmap.getWidth();
            hugePhotoDraweeView.setDoubleTapZoomScale(width);
            hugePhotoDraweeView.setScaleAndCenter(width, new PointF(displayWidth / 2, 0.0f));
        }
    }
}

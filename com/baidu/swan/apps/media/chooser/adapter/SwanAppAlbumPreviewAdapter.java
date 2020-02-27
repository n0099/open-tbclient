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
    private ArrayList<MediaModel> bBX;
    private com.baidu.swan.apps.media.chooser.c.a bCv;
    private a bCw;
    private Activity mContext;
    private int[] maxTextureSize = new int[1];
    private SparseArray<View> mViewList = new SparseArray<>();

    public void a(com.baidu.swan.apps.media.chooser.c.a aVar) {
        this.bCv = aVar;
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.mContext = activity;
        this.bBX = arrayList;
    }

    public void ab(int i, int i2) {
        if (i < this.mViewList.size() && this.mViewList.get(i) != null) {
            this.mViewList.get(i).findViewById(a.f.album_preview_item_root).setBackgroundColor(this.mContext.getResources().getColor(i2));
        }
    }

    public void XD() {
        if (this.bCw == null || this.bCw.bCF == null || !this.bCw.bCF.isPlaying()) {
            return;
        }
        this.bCw.bCF.stopPlayback();
        a(this.bCw, false);
    }

    public void destroy() {
        if (this.bCw == null) {
            return;
        }
        VideoView videoView = this.bCw.bCF;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.bCw.bCF = null;
        this.bCw = null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bBX.size();
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
        MediaModel mediaModel = this.bBX.get(i);
        View view = this.mViewList.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.swanapp_album_preview_item, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
            this.mViewList.put(i, view);
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
        com.facebook.drawee.controller.c a2 = a(aVar.bCD);
        String path = mediaModel.getPath();
        ImageRequestBuilder Y = ImageRequestBuilder.Y(path.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        Y.c(new d(af.getDisplayWidth(this.mContext), af.getDisplayHeight(this.mContext), 10240.0f));
        Y.vw(true);
        com.facebook.drawee.controller.a dmj = com.facebook.drawee.a.a.c.dlw().vh(com.baidu.swan.apps.media.chooser.b.c.bCQ).bg(Y.dsA()).c(a2).c(aVar.bCD.getController()).dmn();
        aVar.bCD.setVisibility(0);
        aVar.bCD.setController(dmj);
        if (!(mediaModel instanceof ImageModel)) {
            return;
        }
        aVar.bCE.setVisibility(8);
        aVar.bCD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppAlbumPreviewAdapter.this.bCv != null) {
                    SwanAppAlbumPreviewAdapter.this.bCv.clickContainer();
                }
            }
        });
    }

    private void b(final a aVar, MediaModel mediaModel) {
        if (mediaModel instanceof VideoModel) {
            if (aVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
                return;
            }
            aVar.bCE.setVisibility(8);
            aVar.bCF.setVisibility(8);
            aVar.bCG.setVisibility(0);
            aVar.bCD.setOnClickListener(new AnonymousClass2(aVar, mediaModel));
            aVar.bCE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!aVar.bCF.isPlaying()) {
                        return;
                    }
                    aVar.bCF.stopPlayback();
                    SwanAppAlbumPreviewAdapter.this.b(aVar);
                }
            });
            return;
        }
        aVar.bCG.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$2  reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ a bCy;
        final /* synthetic */ MediaModel bCz;

        AnonymousClass2(a aVar, MediaModel mediaModel) {
            this.bCy = aVar;
            this.bCz = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.bCy.bCF.isPlaying()) {
                return;
            }
            this.bCy.bCE.setVisibility(0);
            this.bCy.bCF.setVisibility(0);
            this.bCy.bCG.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.bCv != null) {
                SwanAppAlbumPreviewAdapter.this.bCv.Xx();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.mContext);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.bCy.bCF.setMediaController(mediaController);
            this.bCy.bCF.setVideoPath(this.bCz.getPath());
            this.bCy.bCF.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    AnonymousClass2.this.bCy.bCF.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppAlbumPreviewAdapter.this.a(AnonymousClass2.this.bCy);
                        }
                    }, 300L);
                }
            });
            this.bCy.bCF.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.2
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.bCy);
                    return false;
                }
            });
            this.bCy.bCF.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.bCy);
                }
            });
            this.bCy.bCF.start();
            SwanAppAlbumPreviewAdapter.this.bCw = this.bCy;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0197a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.bCD.setVisibility(8);
                aVar.bCD.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.bCD.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        a(aVar, true);
    }

    private void a(final a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        aVar.bCG.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0197a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.bCD.setVisibility(0);
                aVar.bCD.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.bCD.startAnimation(loadAnimation);
        if (z && this.bCv != null) {
            this.bCv.Xy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        private HugePhotoDraweeView bCD;
        private View bCE;
        private VideoView bCF;
        private ImageView bCG;

        public a(View view) {
            this.bCD = (HugePhotoDraweeView) view.findViewById(a.f.album_preview_image);
            this.bCE = view.findViewById(a.f.preview_video_layout);
            this.bCF = (VideoView) view.findViewById(a.f.preview_video_view);
            this.bCG = (ImageView) view.findViewById(a.f.video_preview);
        }
    }

    private com.facebook.drawee.controller.c a(final HugePhotoDraweeView hugePhotoDraweeView) {
        return new com.facebook.drawee.controller.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.6
            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void onSubmit(String str, Object obj) {
                super.onSubmit(str, obj);
            }

            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void onFinalImageSet(String str, Object obj, Animatable animatable) {
                super.onFinalImageSet(str, obj, animatable);
                if (obj instanceof com.facebook.imagepipeline.g.d) {
                    hugePhotoDraweeView.setIsDynamicBitmap(false);
                    hugePhotoDraweeView.setZoomEnabled(true);
                    Bitmap dqp = ((com.facebook.imagepipeline.g.d) obj).dqp();
                    SwanAppAlbumPreviewAdapter.this.maxTextureSize = q.getMaxTextureSize();
                    com.baidu.swan.apps.media.image.b i = com.baidu.swan.apps.media.image.b.i(dqp);
                    if (dqp.getWidth() >= SwanAppAlbumPreviewAdapter.this.maxTextureSize[0] || dqp.getHeight() >= SwanAppAlbumPreviewAdapter.this.maxTextureSize[0]) {
                        i.XN();
                    } else {
                        i.XO();
                    }
                    hugePhotoDraweeView.setImage(i);
                    SwanAppAlbumPreviewAdapter.this.a(hugePhotoDraweeView, dqp);
                } else if (obj instanceof com.facebook.imagepipeline.g.a) {
                    hugePhotoDraweeView.setIsDynamicBitmap(true);
                    hugePhotoDraweeView.setZoomEnabled(false);
                    hugePhotoDraweeView.getHierarchy().b(p.b.lMN);
                }
            }

            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void onFailure(String str, Throwable th) {
                super.onFailure(str, th);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HugePhotoDraweeView hugePhotoDraweeView, Bitmap bitmap) {
        int displayWidth = af.getDisplayWidth(this.mContext);
        int displayHeight = af.getDisplayHeight(this.mContext);
        if (bitmap != null && bitmap.getHeight() > displayHeight * 1.6f) {
            float width = bitmap.getWidth() == 0 ? 1.0f : displayWidth / bitmap.getWidth();
            hugePhotoDraweeView.setDoubleTapZoomScale(width);
            hugePhotoDraweeView.setScaleAndCenter(width, new PointF(displayWidth / 2, 0.0f));
        }
    }
}

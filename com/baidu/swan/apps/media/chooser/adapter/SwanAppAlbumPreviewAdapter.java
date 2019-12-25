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
/* loaded from: classes9.dex */
public class SwanAppAlbumPreviewAdapter extends PagerAdapter {
    private com.baidu.swan.apps.media.chooser.c.a bxB;
    private a bxC;
    private ArrayList<MediaModel> bxd;
    private Activity mContext;
    private int[] maxTextureSize = new int[1];
    private SparseArray<View> mViewList = new SparseArray<>();

    public void a(com.baidu.swan.apps.media.chooser.c.a aVar) {
        this.bxB = aVar;
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.mContext = activity;
        this.bxd = arrayList;
    }

    public void X(int i, int i2) {
        if (i < this.mViewList.size() && this.mViewList.get(i) != null) {
            this.mViewList.get(i).findViewById(a.f.album_preview_item_root).setBackgroundColor(this.mContext.getResources().getColor(i2));
        }
    }

    public void US() {
        if (this.bxC == null || this.bxC.bxL == null || !this.bxC.bxL.isPlaying()) {
            return;
        }
        this.bxC.bxL.stopPlayback();
        a(this.bxC, false);
    }

    public void destroy() {
        if (this.bxC == null) {
            return;
        }
        VideoView videoView = this.bxC.bxL;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.bxC.bxL = null;
        this.bxC = null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bxd.size();
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
        MediaModel mediaModel = this.bxd.get(i);
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
        com.facebook.drawee.controller.c a2 = a(aVar.bxJ);
        String path = mediaModel.getPath();
        ImageRequestBuilder X = ImageRequestBuilder.X(path.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        X.c(new d(af.getDisplayWidth(this.mContext), af.getDisplayHeight(this.mContext), 10240.0f));
        X.vg(true);
        com.facebook.drawee.controller.a djT = com.facebook.drawee.a.a.c.djg().uR(com.baidu.swan.apps.media.chooser.b.c.bxW).be(X.dpZ()).c(a2).c(aVar.bxJ.getController()).djX();
        aVar.bxJ.setVisibility(0);
        aVar.bxJ.setController(djT);
        if (!(mediaModel instanceof ImageModel)) {
            return;
        }
        aVar.bxK.setVisibility(8);
        aVar.bxJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppAlbumPreviewAdapter.this.bxB != null) {
                    SwanAppAlbumPreviewAdapter.this.bxB.clickContainer();
                }
            }
        });
    }

    private void b(final a aVar, MediaModel mediaModel) {
        if (mediaModel instanceof VideoModel) {
            if (aVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
                return;
            }
            aVar.bxK.setVisibility(8);
            aVar.bxL.setVisibility(8);
            aVar.bxM.setVisibility(0);
            aVar.bxJ.setOnClickListener(new AnonymousClass2(aVar, mediaModel));
            aVar.bxK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!aVar.bxL.isPlaying()) {
                        return;
                    }
                    aVar.bxL.stopPlayback();
                    SwanAppAlbumPreviewAdapter.this.b(aVar);
                }
            });
            return;
        }
        aVar.bxM.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$2  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ a bxE;
        final /* synthetic */ MediaModel bxF;

        AnonymousClass2(a aVar, MediaModel mediaModel) {
            this.bxE = aVar;
            this.bxF = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.bxE.bxL.isPlaying()) {
                return;
            }
            this.bxE.bxK.setVisibility(0);
            this.bxE.bxL.setVisibility(0);
            this.bxE.bxM.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.bxB != null) {
                SwanAppAlbumPreviewAdapter.this.bxB.UM();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.mContext);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.bxE.bxL.setMediaController(mediaController);
            this.bxE.bxL.setVideoPath(this.bxF.getPath());
            this.bxE.bxL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    AnonymousClass2.this.bxE.bxL.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppAlbumPreviewAdapter.this.a(AnonymousClass2.this.bxE);
                        }
                    }, 300L);
                }
            });
            this.bxE.bxL.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.2
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.bxE);
                    return false;
                }
            });
            this.bxE.bxL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.bxE);
                }
            });
            this.bxE.bxL.start();
            SwanAppAlbumPreviewAdapter.this.bxC = this.bxE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0185a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.bxJ.setVisibility(8);
                aVar.bxJ.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.bxJ.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        a(aVar, true);
    }

    private void a(final a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        aVar.bxM.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0185a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.bxJ.setVisibility(0);
                aVar.bxJ.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.bxJ.startAnimation(loadAnimation);
        if (z && this.bxB != null) {
            this.bxB.UN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        private HugePhotoDraweeView bxJ;
        private View bxK;
        private VideoView bxL;
        private ImageView bxM;

        public a(View view) {
            this.bxJ = (HugePhotoDraweeView) view.findViewById(a.f.album_preview_image);
            this.bxK = view.findViewById(a.f.preview_video_layout);
            this.bxL = (VideoView) view.findViewById(a.f.preview_video_view);
            this.bxM = (ImageView) view.findViewById(a.f.video_preview);
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
                    Bitmap dnV = ((com.facebook.imagepipeline.g.d) obj).dnV();
                    SwanAppAlbumPreviewAdapter.this.maxTextureSize = q.getMaxTextureSize();
                    com.baidu.swan.apps.media.image.b i = com.baidu.swan.apps.media.image.b.i(dnV);
                    if (dnV.getWidth() >= SwanAppAlbumPreviewAdapter.this.maxTextureSize[0] || dnV.getHeight() >= SwanAppAlbumPreviewAdapter.this.maxTextureSize[0]) {
                        i.Vc();
                    } else {
                        i.Vd();
                    }
                    hugePhotoDraweeView.setImage(i);
                    SwanAppAlbumPreviewAdapter.this.a(hugePhotoDraweeView, dnV);
                } else if (obj instanceof com.facebook.imagepipeline.g.a) {
                    hugePhotoDraweeView.setIsDynamicBitmap(true);
                    hugePhotoDraweeView.setZoomEnabled(false);
                    hugePhotoDraweeView.getHierarchy().b(p.b.lIE);
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

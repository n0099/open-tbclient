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
    private ArrayList<MediaModel> bBZ;
    private com.baidu.swan.apps.media.chooser.c.a bCx;
    private a bCy;
    private Activity mContext;
    private int[] maxTextureSize = new int[1];
    private SparseArray<View> mViewList = new SparseArray<>();

    public void a(com.baidu.swan.apps.media.chooser.c.a aVar) {
        this.bCx = aVar;
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.mContext = activity;
        this.bBZ = arrayList;
    }

    public void ab(int i, int i2) {
        if (i < this.mViewList.size() && this.mViewList.get(i) != null) {
            this.mViewList.get(i).findViewById(a.f.album_preview_item_root).setBackgroundColor(this.mContext.getResources().getColor(i2));
        }
    }

    public void XF() {
        if (this.bCy == null || this.bCy.bCH == null || !this.bCy.bCH.isPlaying()) {
            return;
        }
        this.bCy.bCH.stopPlayback();
        a(this.bCy, false);
    }

    public void destroy() {
        if (this.bCy == null) {
            return;
        }
        VideoView videoView = this.bCy.bCH;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.bCy.bCH = null;
        this.bCy = null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bBZ.size();
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
        MediaModel mediaModel = this.bBZ.get(i);
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
        com.facebook.drawee.controller.c a2 = a(aVar.bCF);
        String path = mediaModel.getPath();
        ImageRequestBuilder Y = ImageRequestBuilder.Y(path.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        Y.c(new d(af.getDisplayWidth(this.mContext), af.getDisplayHeight(this.mContext), 10240.0f));
        Y.vw(true);
        com.facebook.drawee.controller.a dmm = com.facebook.drawee.a.a.c.dlz().vh(com.baidu.swan.apps.media.chooser.b.c.bCS).bg(Y.dsD()).c(a2).c(aVar.bCF.getController()).dmq();
        aVar.bCF.setVisibility(0);
        aVar.bCF.setController(dmm);
        if (!(mediaModel instanceof ImageModel)) {
            return;
        }
        aVar.bCG.setVisibility(8);
        aVar.bCF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppAlbumPreviewAdapter.this.bCx != null) {
                    SwanAppAlbumPreviewAdapter.this.bCx.clickContainer();
                }
            }
        });
    }

    private void b(final a aVar, MediaModel mediaModel) {
        if (mediaModel instanceof VideoModel) {
            if (aVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
                return;
            }
            aVar.bCG.setVisibility(8);
            aVar.bCH.setVisibility(8);
            aVar.bCI.setVisibility(0);
            aVar.bCF.setOnClickListener(new AnonymousClass2(aVar, mediaModel));
            aVar.bCG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!aVar.bCH.isPlaying()) {
                        return;
                    }
                    aVar.bCH.stopPlayback();
                    SwanAppAlbumPreviewAdapter.this.b(aVar);
                }
            });
            return;
        }
        aVar.bCI.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$2  reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ a bCA;
        final /* synthetic */ MediaModel bCB;

        AnonymousClass2(a aVar, MediaModel mediaModel) {
            this.bCA = aVar;
            this.bCB = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.bCA.bCH.isPlaying()) {
                return;
            }
            this.bCA.bCG.setVisibility(0);
            this.bCA.bCH.setVisibility(0);
            this.bCA.bCI.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.bCx != null) {
                SwanAppAlbumPreviewAdapter.this.bCx.Xz();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.mContext);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.bCA.bCH.setMediaController(mediaController);
            this.bCA.bCH.setVideoPath(this.bCB.getPath());
            this.bCA.bCH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    AnonymousClass2.this.bCA.bCH.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppAlbumPreviewAdapter.this.a(AnonymousClass2.this.bCA);
                        }
                    }, 300L);
                }
            });
            this.bCA.bCH.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.2
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.bCA);
                    return false;
                }
            });
            this.bCA.bCH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.bCA);
                }
            });
            this.bCA.bCH.start();
            SwanAppAlbumPreviewAdapter.this.bCy = this.bCA;
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
                aVar.bCF.setVisibility(8);
                aVar.bCF.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.bCF.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        a(aVar, true);
    }

    private void a(final a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        aVar.bCI.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0197a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.bCF.setVisibility(0);
                aVar.bCF.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.bCF.startAnimation(loadAnimation);
        if (z && this.bCx != null) {
            this.bCx.XA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        private HugePhotoDraweeView bCF;
        private View bCG;
        private VideoView bCH;
        private ImageView bCI;

        public a(View view) {
            this.bCF = (HugePhotoDraweeView) view.findViewById(a.f.album_preview_image);
            this.bCG = view.findViewById(a.f.preview_video_layout);
            this.bCH = (VideoView) view.findViewById(a.f.preview_video_view);
            this.bCI = (ImageView) view.findViewById(a.f.video_preview);
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
                    Bitmap dqs = ((com.facebook.imagepipeline.g.d) obj).dqs();
                    SwanAppAlbumPreviewAdapter.this.maxTextureSize = q.getMaxTextureSize();
                    com.baidu.swan.apps.media.image.b i = com.baidu.swan.apps.media.image.b.i(dqs);
                    if (dqs.getWidth() >= SwanAppAlbumPreviewAdapter.this.maxTextureSize[0] || dqs.getHeight() >= SwanAppAlbumPreviewAdapter.this.maxTextureSize[0]) {
                        i.XP();
                    } else {
                        i.XQ();
                    }
                    hugePhotoDraweeView.setImage(i);
                    SwanAppAlbumPreviewAdapter.this.a(hugePhotoDraweeView, dqs);
                } else if (obj instanceof com.facebook.imagepipeline.g.a) {
                    hugePhotoDraweeView.setIsDynamicBitmap(true);
                    hugePhotoDraweeView.setZoomEnabled(false);
                    hugePhotoDraweeView.getHierarchy().b(p.b.lNa);
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

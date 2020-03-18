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
    private com.baidu.swan.apps.media.chooser.c.a bCI;
    private a bCJ;
    private ArrayList<MediaModel> bCk;
    private Activity mContext;
    private int[] maxTextureSize = new int[1];
    private SparseArray<View> mViewList = new SparseArray<>();

    public void a(com.baidu.swan.apps.media.chooser.c.a aVar) {
        this.bCI = aVar;
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.mContext = activity;
        this.bCk = arrayList;
    }

    public void ab(int i, int i2) {
        if (i < this.mViewList.size() && this.mViewList.get(i) != null) {
            this.mViewList.get(i).findViewById(a.f.album_preview_item_root).setBackgroundColor(this.mContext.getResources().getColor(i2));
        }
    }

    public void XI() {
        if (this.bCJ == null || this.bCJ.bCS == null || !this.bCJ.bCS.isPlaying()) {
            return;
        }
        this.bCJ.bCS.stopPlayback();
        a(this.bCJ, false);
    }

    public void destroy() {
        if (this.bCJ == null) {
            return;
        }
        VideoView videoView = this.bCJ.bCS;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.bCJ.bCS = null;
        this.bCJ = null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bCk.size();
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
        MediaModel mediaModel = this.bCk.get(i);
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
        com.facebook.drawee.controller.c a2 = a(aVar.bCQ);
        String path = mediaModel.getPath();
        ImageRequestBuilder Y = ImageRequestBuilder.Y(path.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        Y.c(new d(af.getDisplayWidth(this.mContext), af.getDisplayHeight(this.mContext), 10240.0f));
        Y.vD(true);
        com.facebook.drawee.controller.a dmJ = com.facebook.drawee.a.a.c.dlW().vo(com.baidu.swan.apps.media.chooser.b.c.bDd).bg(Y.dta()).c(a2).c(aVar.bCQ.getController()).dmN();
        aVar.bCQ.setVisibility(0);
        aVar.bCQ.setController(dmJ);
        if (!(mediaModel instanceof ImageModel)) {
            return;
        }
        aVar.bCR.setVisibility(8);
        aVar.bCQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppAlbumPreviewAdapter.this.bCI != null) {
                    SwanAppAlbumPreviewAdapter.this.bCI.clickContainer();
                }
            }
        });
    }

    private void b(final a aVar, MediaModel mediaModel) {
        if (mediaModel instanceof VideoModel) {
            if (aVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
                return;
            }
            aVar.bCR.setVisibility(8);
            aVar.bCS.setVisibility(8);
            aVar.bCT.setVisibility(0);
            aVar.bCQ.setOnClickListener(new AnonymousClass2(aVar, mediaModel));
            aVar.bCR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!aVar.bCS.isPlaying()) {
                        return;
                    }
                    aVar.bCS.stopPlayback();
                    SwanAppAlbumPreviewAdapter.this.b(aVar);
                }
            });
            return;
        }
        aVar.bCT.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$2  reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ a bCL;
        final /* synthetic */ MediaModel bCM;

        AnonymousClass2(a aVar, MediaModel mediaModel) {
            this.bCL = aVar;
            this.bCM = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.bCL.bCS.isPlaying()) {
                return;
            }
            this.bCL.bCR.setVisibility(0);
            this.bCL.bCS.setVisibility(0);
            this.bCL.bCT.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.bCI != null) {
                SwanAppAlbumPreviewAdapter.this.bCI.XC();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.mContext);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.bCL.bCS.setMediaController(mediaController);
            this.bCL.bCS.setVideoPath(this.bCM.getPath());
            this.bCL.bCS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    AnonymousClass2.this.bCL.bCS.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppAlbumPreviewAdapter.this.a(AnonymousClass2.this.bCL);
                        }
                    }, 300L);
                }
            });
            this.bCL.bCS.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.2
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.bCL);
                    return false;
                }
            });
            this.bCL.bCS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.bCL);
                }
            });
            this.bCL.bCS.start();
            SwanAppAlbumPreviewAdapter.this.bCJ = this.bCL;
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
                aVar.bCQ.setVisibility(8);
                aVar.bCQ.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.bCQ.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        a(aVar, true);
    }

    private void a(final a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        aVar.bCT.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0197a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.bCQ.setVisibility(0);
                aVar.bCQ.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.bCQ.startAnimation(loadAnimation);
        if (z && this.bCI != null) {
            this.bCI.XD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        private HugePhotoDraweeView bCQ;
        private View bCR;
        private VideoView bCS;
        private ImageView bCT;

        public a(View view) {
            this.bCQ = (HugePhotoDraweeView) view.findViewById(a.f.album_preview_image);
            this.bCR = view.findViewById(a.f.preview_video_layout);
            this.bCS = (VideoView) view.findViewById(a.f.preview_video_view);
            this.bCT = (ImageView) view.findViewById(a.f.video_preview);
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
                    Bitmap dqP = ((com.facebook.imagepipeline.g.d) obj).dqP();
                    SwanAppAlbumPreviewAdapter.this.maxTextureSize = q.getMaxTextureSize();
                    com.baidu.swan.apps.media.image.b i = com.baidu.swan.apps.media.image.b.i(dqP);
                    if (dqP.getWidth() >= SwanAppAlbumPreviewAdapter.this.maxTextureSize[0] || dqP.getHeight() >= SwanAppAlbumPreviewAdapter.this.maxTextureSize[0]) {
                        i.XS();
                    } else {
                        i.XT();
                    }
                    hugePhotoDraweeView.setImage(i);
                    SwanAppAlbumPreviewAdapter.this.a(hugePhotoDraweeView, dqP);
                } else if (obj instanceof com.facebook.imagepipeline.g.a) {
                    hugePhotoDraweeView.setIsDynamicBitmap(true);
                    hugePhotoDraweeView.setZoomEnabled(false);
                    hugePhotoDraweeView.getHierarchy().b(p.b.lOG);
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

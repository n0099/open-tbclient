package com.baidu.swan.apps.media.chooser.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.media.MediaPlayer;
import android.net.Uri;
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
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.t;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.swan.apps.media.image.HugePhotoDraweeView;
import com.facebook.drawee.controller.c;
import com.facebook.drawee.drawable.p;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;
import org.apache.http.HttpHost;
/* loaded from: classes9.dex */
public class SwanAppAlbumPreviewAdapter extends PagerAdapter {
    private ArrayList<MediaModel> ajo;
    private com.baidu.swan.apps.media.chooser.listener.a dkC;
    private a dkE;
    private Activity mContext;
    private int[] dkD = new int[1];
    private SparseArray<View> dkB = new SparseArray<>();

    public void a(com.baidu.swan.apps.media.chooser.listener.a aVar) {
        this.dkC = aVar;
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.mContext = activity;
        this.ajo = arrayList;
    }

    public void ai(int i, int i2) {
        if (i < this.dkB.size() && this.dkB.get(i) != null) {
            this.dkB.get(i).findViewById(a.f.album_preview_item_root).setBackgroundColor(this.mContext.getResources().getColor(i2));
        }
    }

    public void aBp() {
        if (this.dkE == null || this.dkE.dkN == null || !this.dkE.dkN.isPlaying()) {
            return;
        }
        this.dkE.dkN.stopPlayback();
        a(this.dkE, false);
    }

    public void destroy() {
        if (this.dkE == null) {
            return;
        }
        VideoView videoView = this.dkE.dkN;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.dkE.dkN = null;
        this.dkE = null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.ajo.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        a aVar;
        MediaModel mediaModel = this.ajo.get(i);
        View view = this.dkB.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.swanapp_album_preview_item, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
            this.dkB.put(i, view);
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
        c a2 = a(aVar.dkL);
        String path = mediaModel.getPath();
        ImageRequestBuilder ag = ImageRequestBuilder.ag(path.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        ag.c(new d(ah.getDisplayWidth(this.mContext), ah.getDisplayHeight(this.mContext), 10240.0f));
        ag.By(true);
        com.facebook.drawee.controller.a eub = com.facebook.drawee.a.a.c.eto().Bm(com.baidu.swan.apps.media.chooser.b.c.dlb).bo(ag.eAi()).c(a2).c(aVar.dkL.getController()).euf();
        aVar.dkL.setVisibility(0);
        aVar.dkL.setController(eub);
        if (!(mediaModel instanceof ImageModel)) {
            return;
        }
        aVar.dkM.setVisibility(8);
        aVar.dkL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppAlbumPreviewAdapter.this.dkC != null) {
                    SwanAppAlbumPreviewAdapter.this.dkC.aBi();
                }
            }
        });
    }

    private void b(final a aVar, MediaModel mediaModel) {
        if (mediaModel instanceof VideoModel) {
            if (aVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
                return;
            }
            aVar.dkM.setVisibility(8);
            aVar.dkN.setVisibility(8);
            aVar.dkO.setVisibility(0);
            aVar.dkL.setOnClickListener(new AnonymousClass2(aVar, mediaModel));
            aVar.dkM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!aVar.dkN.isPlaying()) {
                        return;
                    }
                    aVar.dkN.stopPlayback();
                    SwanAppAlbumPreviewAdapter.this.b(aVar);
                }
            });
            return;
        }
        aVar.dkO.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$2  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ a dkG;
        final /* synthetic */ MediaModel dkH;

        AnonymousClass2(a aVar, MediaModel mediaModel) {
            this.dkG = aVar;
            this.dkH = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.dkG.dkN.isPlaying()) {
                return;
            }
            this.dkG.dkM.setVisibility(0);
            this.dkG.dkN.setVisibility(0);
            this.dkG.dkO.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.dkC != null) {
                SwanAppAlbumPreviewAdapter.this.dkC.aBj();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.mContext);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.dkG.dkN.setMediaController(mediaController);
            this.dkG.dkN.setVideoPath(this.dkH.getPath());
            this.dkG.dkN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    AnonymousClass2.this.dkG.dkN.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppAlbumPreviewAdapter.this.a(AnonymousClass2.this.dkG);
                        }
                    }, 300L);
                }
            });
            this.dkG.dkN.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.2
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.dkG);
                    return false;
                }
            });
            this.dkG.dkN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.dkG);
                }
            });
            this.dkG.dkN.start();
            SwanAppAlbumPreviewAdapter.this.dkE = this.dkG;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0352a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.dkL.setVisibility(8);
                aVar.dkL.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.dkL.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        a(aVar, true);
    }

    private void a(final a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        aVar.dkO.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0352a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.dkL.setVisibility(0);
                aVar.dkL.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.dkL.startAnimation(loadAnimation);
        if (z && this.dkC != null) {
            this.dkC.aBk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        private HugePhotoDraweeView dkL;
        private View dkM;
        private VideoView dkN;
        private ImageView dkO;

        public a(View view) {
            this.dkL = (HugePhotoDraweeView) view.findViewById(a.f.album_preview_image);
            this.dkM = view.findViewById(a.f.preview_video_layout);
            this.dkN = (VideoView) view.findViewById(a.f.preview_video_view);
            this.dkO = (ImageView) view.findViewById(a.f.video_preview);
        }
    }

    private c a(final HugePhotoDraweeView hugePhotoDraweeView) {
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
                    Bitmap eyg = ((com.facebook.imagepipeline.f.d) obj).eyg();
                    SwanAppAlbumPreviewAdapter.this.dkD = t.aNT();
                    com.baidu.swan.apps.media.image.b m = com.baidu.swan.apps.media.image.b.m(eyg);
                    if (eyg.getWidth() >= SwanAppAlbumPreviewAdapter.this.dkD[0] || eyg.getHeight() >= SwanAppAlbumPreviewAdapter.this.dkD[0]) {
                        m.aBG();
                    } else {
                        m.aBH();
                    }
                    hugePhotoDraweeView.setImage(m);
                    SwanAppAlbumPreviewAdapter.this.a(hugePhotoDraweeView, eyg);
                } else if (obj instanceof com.facebook.imagepipeline.f.a) {
                    hugePhotoDraweeView.setIsDynamicBitmap(true);
                    hugePhotoDraweeView.setZoomEnabled(false);
                    hugePhotoDraweeView.getHierarchy().b(p.b.pDs);
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
        int displayWidth = ah.getDisplayWidth(this.mContext);
        int displayHeight = ah.getDisplayHeight(this.mContext);
        if (bitmap != null && bitmap.getHeight() > displayHeight * 1.6f) {
            float width = bitmap.getWidth() == 0 ? 1.0f : displayWidth / bitmap.getWidth();
            hugePhotoDraweeView.setDoubleTapZoomScale(width);
            hugePhotoDraweeView.setScaleAndCenter(width, new PointF(displayWidth / 2, 0.0f));
        }
    }
}

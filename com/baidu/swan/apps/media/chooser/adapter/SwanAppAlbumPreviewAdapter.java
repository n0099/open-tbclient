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
/* loaded from: classes8.dex */
public class SwanAppAlbumPreviewAdapter extends PagerAdapter {
    private ArrayList<MediaModel> akG;
    private com.baidu.swan.apps.media.chooser.listener.a dmd;
    private a dmf;
    private Activity mContext;
    private int[] dme = new int[1];
    private SparseArray<View> dmc = new SparseArray<>();

    public void a(com.baidu.swan.apps.media.chooser.listener.a aVar) {
        this.dmd = aVar;
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.mContext = activity;
        this.akG = arrayList;
    }

    public void ai(int i, int i2) {
        if (i < this.dmc.size() && this.dmc.get(i) != null) {
            this.dmc.get(i).findViewById(a.f.album_preview_item_root).setBackgroundColor(this.mContext.getResources().getColor(i2));
        }
    }

    public void aBs() {
        if (this.dmf == null || this.dmf.dmo == null || !this.dmf.dmo.isPlaying()) {
            return;
        }
        this.dmf.dmo.stopPlayback();
        a(this.dmf, false);
    }

    public void destroy() {
        if (this.dmf == null) {
            return;
        }
        VideoView videoView = this.dmf.dmo;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.dmf.dmo = null;
        this.dmf = null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.akG.size();
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
        MediaModel mediaModel = this.akG.get(i);
        View view = this.dmc.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.swanapp_album_preview_item, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
            this.dmc.put(i, view);
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
        c a2 = a(aVar.dmm);
        String path = mediaModel.getPath();
        ImageRequestBuilder ag = ImageRequestBuilder.ag(path.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        ag.c(new d(ah.getDisplayWidth(this.mContext), ah.getDisplayHeight(this.mContext), 10240.0f));
        ag.Bw(true);
        com.facebook.drawee.controller.a eus = com.facebook.drawee.a.a.c.etF().Bk(com.baidu.swan.apps.media.chooser.b.c.dmC).bq(ag.eAz()).c(a2).c(aVar.dmm.getController()).euw();
        aVar.dmm.setVisibility(0);
        aVar.dmm.setController(eus);
        if (!(mediaModel instanceof ImageModel)) {
            return;
        }
        aVar.dmn.setVisibility(8);
        aVar.dmm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppAlbumPreviewAdapter.this.dmd != null) {
                    SwanAppAlbumPreviewAdapter.this.dmd.aBl();
                }
            }
        });
    }

    private void b(final a aVar, MediaModel mediaModel) {
        if (mediaModel instanceof VideoModel) {
            if (aVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
                return;
            }
            aVar.dmn.setVisibility(8);
            aVar.dmo.setVisibility(8);
            aVar.dmp.setVisibility(0);
            aVar.dmm.setOnClickListener(new AnonymousClass2(aVar, mediaModel));
            aVar.dmn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!aVar.dmo.isPlaying()) {
                        return;
                    }
                    aVar.dmo.stopPlayback();
                    SwanAppAlbumPreviewAdapter.this.b(aVar);
                }
            });
            return;
        }
        aVar.dmp.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$2  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ a dmh;
        final /* synthetic */ MediaModel dmi;

        AnonymousClass2(a aVar, MediaModel mediaModel) {
            this.dmh = aVar;
            this.dmi = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.dmh.dmo.isPlaying()) {
                return;
            }
            this.dmh.dmn.setVisibility(0);
            this.dmh.dmo.setVisibility(0);
            this.dmh.dmp.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.dmd != null) {
                SwanAppAlbumPreviewAdapter.this.dmd.aBm();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.mContext);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.dmh.dmo.setMediaController(mediaController);
            this.dmh.dmo.setVideoPath(this.dmi.getPath());
            this.dmh.dmo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    AnonymousClass2.this.dmh.dmo.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppAlbumPreviewAdapter.this.a(AnonymousClass2.this.dmh);
                        }
                    }, 300L);
                }
            });
            this.dmh.dmo.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.2
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.dmh);
                    return false;
                }
            });
            this.dmh.dmo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.dmh);
                }
            });
            this.dmh.dmo.start();
            SwanAppAlbumPreviewAdapter.this.dmf = this.dmh;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0358a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.dmm.setVisibility(8);
                aVar.dmm.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.dmm.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        a(aVar, true);
    }

    private void a(final a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        aVar.dmp.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0358a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.dmm.setVisibility(0);
                aVar.dmm.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.dmm.startAnimation(loadAnimation);
        if (z && this.dmd != null) {
            this.dmd.aBn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        private HugePhotoDraweeView dmm;
        private View dmn;
        private VideoView dmo;
        private ImageView dmp;

        public a(View view) {
            this.dmm = (HugePhotoDraweeView) view.findViewById(a.f.album_preview_image);
            this.dmn = view.findViewById(a.f.preview_video_layout);
            this.dmo = (VideoView) view.findViewById(a.f.preview_video_view);
            this.dmp = (ImageView) view.findViewById(a.f.video_preview);
        }
    }

    private c a(final HugePhotoDraweeView hugePhotoDraweeView) {
        return new com.facebook.drawee.controller.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.6
            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void g(String str, Object obj) {
                super.g(str, obj);
            }

            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void a(String str, Object obj, Animatable animatable) {
                super.a(str, obj, animatable);
                if (obj instanceof com.facebook.imagepipeline.f.d) {
                    hugePhotoDraweeView.setIsDynamicBitmap(false);
                    hugePhotoDraweeView.setZoomEnabled(true);
                    Bitmap eyx = ((com.facebook.imagepipeline.f.d) obj).eyx();
                    SwanAppAlbumPreviewAdapter.this.dme = t.aNW();
                    com.baidu.swan.apps.media.image.b m = com.baidu.swan.apps.media.image.b.m(eyx);
                    if (eyx.getWidth() >= SwanAppAlbumPreviewAdapter.this.dme[0] || eyx.getHeight() >= SwanAppAlbumPreviewAdapter.this.dme[0]) {
                        m.aBJ();
                    } else {
                        m.aBK();
                    }
                    hugePhotoDraweeView.setImage(m);
                    SwanAppAlbumPreviewAdapter.this.a(hugePhotoDraweeView, eyx);
                } else if (obj instanceof com.facebook.imagepipeline.f.a) {
                    hugePhotoDraweeView.setIsDynamicBitmap(true);
                    hugePhotoDraweeView.setZoomEnabled(false);
                    hugePhotoDraweeView.getHierarchy().b(p.b.pFX);
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

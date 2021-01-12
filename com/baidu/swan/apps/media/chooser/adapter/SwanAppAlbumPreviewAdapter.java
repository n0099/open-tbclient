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
    private ArrayList<MediaModel> ajz;
    private com.baidu.swan.apps.media.chooser.listener.a dip;
    private a dit;
    private Activity mContext;
    private int[] diq = new int[1];
    private SparseArray<View> dio = new SparseArray<>();

    public void a(com.baidu.swan.apps.media.chooser.listener.a aVar) {
        this.dip = aVar;
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.mContext = activity;
        this.ajz = arrayList;
    }

    public void al(int i, int i2) {
        if (i < this.dio.size() && this.dio.get(i) != null) {
            this.dio.get(i).findViewById(a.f.album_preview_item_root).setBackgroundColor(this.mContext.getResources().getColor(i2));
        }
    }

    public void aAR() {
        if (this.dit == null || this.dit.diC == null || !this.dit.diC.isPlaying()) {
            return;
        }
        this.dit.diC.stopPlayback();
        a(this.dit, false);
    }

    public void destroy() {
        if (this.dit == null) {
            return;
        }
        VideoView videoView = this.dit.diC;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.dit.diC = null;
        this.dit = null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.ajz.size();
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
        MediaModel mediaModel = this.ajz.get(i);
        View view = this.dio.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.swanapp_album_preview_item, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
            this.dio.put(i, view);
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
        c a2 = a(aVar.diA);
        String path = mediaModel.getPath();
        ImageRequestBuilder ag = ImageRequestBuilder.ag(path.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        ag.c(new d(ah.getDisplayWidth(this.mContext), ah.getDisplayHeight(this.mContext), 10240.0f));
        ag.Bf(true);
        com.facebook.drawee.controller.a erJ = com.facebook.drawee.a.a.c.eqV().AT(com.baidu.swan.apps.media.chooser.b.c.diQ).bo(ag.exQ()).c(a2).c(aVar.diA.getController()).erN();
        aVar.diA.setVisibility(0);
        aVar.diA.setController(erJ);
        if (!(mediaModel instanceof ImageModel)) {
            return;
        }
        aVar.diB.setVisibility(8);
        aVar.diA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppAlbumPreviewAdapter.this.dip != null) {
                    SwanAppAlbumPreviewAdapter.this.dip.aAK();
                }
            }
        });
    }

    private void b(final a aVar, MediaModel mediaModel) {
        if (mediaModel instanceof VideoModel) {
            if (aVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
                return;
            }
            aVar.diB.setVisibility(8);
            aVar.diC.setVisibility(8);
            aVar.diD.setVisibility(0);
            aVar.diA.setOnClickListener(new AnonymousClass2(aVar, mediaModel));
            aVar.diB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!aVar.diC.isPlaying()) {
                        return;
                    }
                    aVar.diC.stopPlayback();
                    SwanAppAlbumPreviewAdapter.this.b(aVar);
                }
            });
            return;
        }
        aVar.diD.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$2  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ a div;
        final /* synthetic */ MediaModel diw;

        AnonymousClass2(a aVar, MediaModel mediaModel) {
            this.div = aVar;
            this.diw = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.div.diC.isPlaying()) {
                return;
            }
            this.div.diB.setVisibility(0);
            this.div.diC.setVisibility(0);
            this.div.diD.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.dip != null) {
                SwanAppAlbumPreviewAdapter.this.dip.aAL();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.mContext);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.div.diC.setMediaController(mediaController);
            this.div.diC.setVideoPath(this.diw.getPath());
            this.div.diC.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    AnonymousClass2.this.div.diC.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppAlbumPreviewAdapter.this.a(AnonymousClass2.this.div);
                        }
                    }, 300L);
                }
            });
            this.div.diC.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.2
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.div);
                    return false;
                }
            });
            this.div.diC.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.div);
                }
            });
            this.div.diC.start();
            SwanAppAlbumPreviewAdapter.this.dit = this.div;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0355a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.diA.setVisibility(8);
                aVar.diA.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.diA.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        a(aVar, true);
    }

    private void a(final a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        aVar.diD.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0355a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.diA.setVisibility(0);
                aVar.diA.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.diA.startAnimation(loadAnimation);
        if (z && this.dip != null) {
            this.dip.aAM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        private HugePhotoDraweeView diA;
        private View diB;
        private VideoView diC;
        private ImageView diD;

        public a(View view) {
            this.diA = (HugePhotoDraweeView) view.findViewById(a.f.album_preview_image);
            this.diB = view.findViewById(a.f.preview_video_layout);
            this.diC = (VideoView) view.findViewById(a.f.preview_video_view);
            this.diD = (ImageView) view.findViewById(a.f.video_preview);
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
                    Bitmap evN = ((com.facebook.imagepipeline.f.d) obj).evN();
                    SwanAppAlbumPreviewAdapter.this.diq = t.aNA();
                    com.baidu.swan.apps.media.image.b n = com.baidu.swan.apps.media.image.b.n(evN);
                    if (evN.getWidth() >= SwanAppAlbumPreviewAdapter.this.diq[0] || evN.getHeight() >= SwanAppAlbumPreviewAdapter.this.diq[0]) {
                        n.aBj();
                    } else {
                        n.aBk();
                    }
                    hugePhotoDraweeView.setImage(n);
                    SwanAppAlbumPreviewAdapter.this.a(hugePhotoDraweeView, evN);
                } else if (obj instanceof com.facebook.imagepipeline.f.a) {
                    hugePhotoDraweeView.setIsDynamicBitmap(true);
                    hugePhotoDraweeView.setZoomEnabled(false);
                    hugePhotoDraweeView.getHierarchy().b(p.b.pti);
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

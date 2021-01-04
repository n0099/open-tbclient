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
    private ArrayList<MediaModel> akq;
    private com.baidu.swan.apps.media.chooser.listener.a dnd;
    private a dnf;
    private Activity mContext;
    private int[] dne = new int[1];
    private SparseArray<View> dnc = new SparseArray<>();

    public void a(com.baidu.swan.apps.media.chooser.listener.a aVar) {
        this.dnd = aVar;
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        this.mContext = activity;
        this.akq = arrayList;
    }

    public void al(int i, int i2) {
        if (i < this.dnc.size() && this.dnc.get(i) != null) {
            this.dnc.get(i).findViewById(a.f.album_preview_item_root).setBackgroundColor(this.mContext.getResources().getColor(i2));
        }
    }

    public void aEK() {
        if (this.dnf == null || this.dnf.dno == null || !this.dnf.dno.isPlaying()) {
            return;
        }
        this.dnf.dno.stopPlayback();
        a(this.dnf, false);
    }

    public void destroy() {
        if (this.dnf == null) {
            return;
        }
        VideoView videoView = this.dnf.dno;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.dnf.dno = null;
        this.dnf = null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.akq.size();
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
        MediaModel mediaModel = this.akq.get(i);
        View view = this.dnc.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.swanapp_album_preview_item, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
            this.dnc.put(i, view);
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
        c a2 = a(aVar.dnm);
        String path = mediaModel.getPath();
        ImageRequestBuilder aj = ImageRequestBuilder.aj(path.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        aj.c(new d(ah.getDisplayWidth(this.mContext), ah.getDisplayHeight(this.mContext), 10240.0f));
        aj.Bj(true);
        com.facebook.drawee.controller.a evv = com.facebook.drawee.a.a.c.euI().AX(com.baidu.swan.apps.media.chooser.b.c.dnD).bo(aj.eBe()).c(a2).c(aVar.dnm.getController()).evz();
        aVar.dnm.setVisibility(0);
        aVar.dnm.setController(evv);
        if (!(mediaModel instanceof ImageModel)) {
            return;
        }
        aVar.dnn.setVisibility(8);
        aVar.dnm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SwanAppAlbumPreviewAdapter.this.dnd != null) {
                    SwanAppAlbumPreviewAdapter.this.dnd.aED();
                }
            }
        });
    }

    private void b(final a aVar, MediaModel mediaModel) {
        if (mediaModel instanceof VideoModel) {
            if (aVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
                return;
            }
            aVar.dnn.setVisibility(8);
            aVar.dno.setVisibility(8);
            aVar.dnp.setVisibility(0);
            aVar.dnm.setOnClickListener(new AnonymousClass2(aVar, mediaModel));
            aVar.dnn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!aVar.dno.isPlaying()) {
                        return;
                    }
                    aVar.dno.stopPlayback();
                    SwanAppAlbumPreviewAdapter.this.b(aVar);
                }
            });
            return;
        }
        aVar.dnp.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$2  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ a dnh;
        final /* synthetic */ MediaModel dni;

        AnonymousClass2(a aVar, MediaModel mediaModel) {
            this.dnh = aVar;
            this.dni = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.dnh.dno.isPlaying()) {
                return;
            }
            this.dnh.dnn.setVisibility(0);
            this.dnh.dno.setVisibility(0);
            this.dnh.dnp.setVisibility(8);
            if (SwanAppAlbumPreviewAdapter.this.dnd != null) {
                SwanAppAlbumPreviewAdapter.this.dnd.aEE();
            }
            MediaController mediaController = new MediaController(SwanAppAlbumPreviewAdapter.this.mContext);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.dnh.dno.setMediaController(mediaController);
            this.dnh.dno.setVideoPath(this.dni.getPath());
            this.dnh.dno.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    AnonymousClass2.this.dnh.dno.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppAlbumPreviewAdapter.this.a(AnonymousClass2.this.dnh);
                        }
                    }, 300L);
                }
            });
            this.dnh.dno.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.2
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.dnh);
                    return false;
                }
            });
            this.dnh.dno.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.2.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    SwanAppAlbumPreviewAdapter.this.b(AnonymousClass2.this.dnh);
                }
            });
            this.dnh.dno.start();
            SwanAppAlbumPreviewAdapter.this.dnf = this.dnh;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0372a.swanapp_album_preview_img_exit);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.dnm.setVisibility(8);
                aVar.dnm.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.dnm.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        a(aVar, true);
    }

    private void a(final a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        aVar.dnp.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0372a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aVar.dnm.setVisibility(0);
                aVar.dnm.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.dnm.startAnimation(loadAnimation);
        if (z && this.dnd != null) {
            this.dnd.aEF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        private HugePhotoDraweeView dnm;
        private View dnn;
        private VideoView dno;
        private ImageView dnp;

        public a(View view) {
            this.dnm = (HugePhotoDraweeView) view.findViewById(a.f.album_preview_image);
            this.dnn = view.findViewById(a.f.preview_video_layout);
            this.dno = (VideoView) view.findViewById(a.f.preview_video_view);
            this.dnp = (ImageView) view.findViewById(a.f.video_preview);
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
                    Bitmap ezc = ((com.facebook.imagepipeline.f.d) obj).ezc();
                    SwanAppAlbumPreviewAdapter.this.dne = t.aRt();
                    com.baidu.swan.apps.media.image.b n = com.baidu.swan.apps.media.image.b.n(ezc);
                    if (ezc.getWidth() >= SwanAppAlbumPreviewAdapter.this.dne[0] || ezc.getHeight() >= SwanAppAlbumPreviewAdapter.this.dne[0]) {
                        n.aFc();
                    } else {
                        n.aFd();
                    }
                    hugePhotoDraweeView.setImage(n);
                    SwanAppAlbumPreviewAdapter.this.a(hugePhotoDraweeView, ezc);
                } else if (obj instanceof com.facebook.imagepipeline.f.a) {
                    hugePhotoDraweeView.setIsDynamicBitmap(true);
                    hugePhotoDraweeView.setZoomEnabled(false);
                    hugePhotoDraweeView.getHierarchy().b(p.b.pxD);
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

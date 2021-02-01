package com.baidu.swan.videoplayer.media.video;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.swan.apps.component.b.a;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.media.b.c;
import com.baidu.swan.videoplayer.c;
import com.facebook.drawee.drawable.p;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
/* loaded from: classes15.dex */
public class VideoContainerManager extends a<VideoHolderWrapper, c> {
    private SwanAppComponentContainerView cLI;
    private VideoHolderWrapper eAV;
    private Context mContext;

    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        this.mContext = context;
        this.cLI = new SwanAppComponentContainerView(this.mContext);
        this.cLI.setBackgroundColor(Color.parseColor("#666666"));
        gr(1);
    }

    public void e(c cVar) {
        if (cVar != null) {
            f(cVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: eM */
    public VideoHolderWrapper cv(@NonNull Context context) {
        return bga();
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView cw(@NonNull Context context) {
        return this.cLI;
    }

    private void f(c cVar) {
        if (cVar != null) {
            if (!(alg() != null)) {
                if (bga().getParent() instanceof ViewGroup) {
                    ((ViewGroup) bga().getParent()).removeView(bga());
                }
                bgd().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + alb().isSuccess() + " position " + cVar.cLu);
                return;
            }
            c ale = ale();
            if (!TextUtils.equals(cVar.cLq, ale.cLq) || !TextUtils.equals(cVar.cLr, ale.cLr) || !TextUtils.equals(cVar.cLs, ale.cLs)) {
                com.baidu.swan.apps.component.e.a.bk("video", "updateCoverContainerPosition with different id");
            }
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + a((VideoContainerManager) cVar).isSuccess() + " position " + cVar.cLu);
        }
    }

    private VideoHolderWrapper bga() {
        if (this.eAV == null) {
            this.eAV = new VideoHolderWrapper(this.mContext);
        }
        return this.eAV;
    }

    public FrameLayout getVideoHolder() {
        return bga().getVideoHolder();
    }

    public void g(View.OnClickListener onClickListener) {
        View playerIcon = bga().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        l(playerIcon, 0);
    }

    public void bgb() {
        l(bga().getPlayerIcon(), 8);
    }

    public void dy(String str, String str2) {
        bga().setPoster(str, str2);
        l(bga().getVideoPoster(), 0);
    }

    public void bgc() {
        l(bga().getVideoPoster(), 8);
    }

    public SwanAppComponentContainerView bgd() {
        return this.cLI;
    }

    private void l(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes15.dex */
    public class VideoHolderWrapper extends FrameLayout {
        private FrameLayout eAW;
        private ImageView eAX;
        private SimpleDraweeView eAY;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            bge();
            bgf();
            bgg();
        }

        private void bge() {
            this.eAW = new FrameLayout(getContext());
            addView(this.eAW, new FrameLayout.LayoutParams(-1, -1));
        }

        private void bgf() {
            this.eAY = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.eAY.getHierarchy().b(p.b.pDw);
            addView(this.eAY, layoutParams);
        }

        private void bgg() {
            this.eAX = new ImageView(VideoContainerManager.this.mContext);
            this.eAX.setImageResource(c.a.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.eAX, layoutParams);
        }

        public FrameLayout getVideoHolder() {
            return this.eAW;
        }

        public View getPlayerIcon() {
            return this.eAX;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.eAY;
        }

        public void setPoster(String str) {
            setPoster(str, "cover");
        }

        public void setPoster(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                p.b bVar = p.b.pDw;
                char c = 65535;
                switch (str2.hashCode()) {
                    case 3143043:
                        if (str2.equals("fill")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 94852023:
                        if (str2.equals("cover")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 951526612:
                        if (str2.equals("contain")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        p.b bVar2 = p.b.pDv;
                        break;
                    case 1:
                        p.b bVar3 = p.b.pDw;
                        break;
                    case 2:
                        p.b bVar4 = p.b.pDq;
                        break;
                }
                this.eAY.getHierarchy().b(p.b.pDw);
                a(str, this.eAY);
            }
        }

        public void a(String str, SimpleDraweeView simpleDraweeView) {
            Uri tV = tV(str);
            if (tV == null) {
                simpleDraweeView.setController(null);
                return;
            }
            ImageRequestBuilder ag = ImageRequestBuilder.ag(tV);
            int measuredWidth = simpleDraweeView.getMeasuredWidth() / 2;
            int measuredHeight = simpleDraweeView.getMeasuredHeight() / 2;
            if (measuredWidth > 0 && measuredHeight > 0) {
                ag.c(new d(measuredWidth, measuredHeight));
            }
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.eto().c(simpleDraweeView.getController()).bo(ag.eAi()).euf());
        }

        public Uri tV(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) || str.startsWith("file://")) {
                return Uri.parse(str);
            }
            if (str.startsWith("/")) {
                return Uri.fromFile(new File(str));
            }
            return null;
        }
    }
}

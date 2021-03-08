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
/* loaded from: classes14.dex */
public class VideoContainerManager extends a<VideoHolderWrapper, c> {
    private SwanAppComponentContainerView cNi;
    private VideoHolderWrapper eCw;
    private Context mContext;

    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        this.mContext = context;
        this.cNi = new SwanAppComponentContainerView(this.mContext);
        this.cNi.setBackgroundColor(Color.parseColor("#666666"));
        gs(1);
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
    /* renamed from: eL */
    public VideoHolderWrapper cu(@NonNull Context context) {
        return bgc();
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView cv(@NonNull Context context) {
        return this.cNi;
    }

    private void f(c cVar) {
        if (cVar != null) {
            if (!(alj() != null)) {
                if (bgc().getParent() instanceof ViewGroup) {
                    ((ViewGroup) bgc().getParent()).removeView(bgc());
                }
                bgf().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + ale().isSuccess() + " position " + cVar.cMU);
                return;
            }
            c alh = alh();
            if (!TextUtils.equals(cVar.cMQ, alh.cMQ) || !TextUtils.equals(cVar.cMR, alh.cMR) || !TextUtils.equals(cVar.cMS, alh.cMS)) {
                com.baidu.swan.apps.component.e.a.bk("video", "updateCoverContainerPosition with different id");
            }
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + a((VideoContainerManager) cVar).isSuccess() + " position " + cVar.cMU);
        }
    }

    private VideoHolderWrapper bgc() {
        if (this.eCw == null) {
            this.eCw = new VideoHolderWrapper(this.mContext);
        }
        return this.eCw;
    }

    public FrameLayout getVideoHolder() {
        return bgc().getVideoHolder();
    }

    public void g(View.OnClickListener onClickListener) {
        View playerIcon = bgc().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        l(playerIcon, 0);
    }

    public void bgd() {
        l(bgc().getPlayerIcon(), 8);
    }

    public void dy(String str, String str2) {
        bgc().setPoster(str, str2);
        l(bgc().getVideoPoster(), 0);
    }

    public void bge() {
        l(bgc().getVideoPoster(), 8);
    }

    public SwanAppComponentContainerView bgf() {
        return this.cNi;
    }

    private void l(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes14.dex */
    public class VideoHolderWrapper extends FrameLayout {
        private FrameLayout eCx;
        private ImageView eCy;
        private SimpleDraweeView eCz;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            bgg();
            bgh();
            bgi();
        }

        private void bgg() {
            this.eCx = new FrameLayout(getContext());
            addView(this.eCx, new FrameLayout.LayoutParams(-1, -1));
        }

        private void bgh() {
            this.eCz = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.eCz.getHierarchy().b(p.b.pGb);
            addView(this.eCz, layoutParams);
        }

        private void bgi() {
            this.eCy = new ImageView(VideoContainerManager.this.mContext);
            this.eCy.setImageResource(c.a.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.eCy, layoutParams);
        }

        public FrameLayout getVideoHolder() {
            return this.eCx;
        }

        public View getPlayerIcon() {
            return this.eCy;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.eCz;
        }

        public void setPoster(String str) {
            setPoster(str, "cover");
        }

        public void setPoster(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                p.b bVar = p.b.pGb;
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
                        p.b bVar2 = p.b.pGa;
                        break;
                    case 1:
                        p.b bVar3 = p.b.pGb;
                        break;
                    case 2:
                        p.b bVar4 = p.b.pFV;
                        break;
                }
                this.eCz.getHierarchy().b(p.b.pGb);
                a(str, this.eCz);
            }
        }

        public void a(String str, SimpleDraweeView simpleDraweeView) {
            Uri uc = uc(str);
            if (uc == null) {
                simpleDraweeView.setController(null);
                return;
            }
            ImageRequestBuilder ag = ImageRequestBuilder.ag(uc);
            int measuredWidth = simpleDraweeView.getMeasuredWidth() / 2;
            int measuredHeight = simpleDraweeView.getMeasuredHeight() / 2;
            if (measuredWidth > 0 && measuredHeight > 0) {
                ag.c(new d(measuredWidth, measuredHeight));
            }
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.etF().c(simpleDraweeView.getController()).bq(ag.eAz()).euw());
        }

        public Uri uc(String str) {
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

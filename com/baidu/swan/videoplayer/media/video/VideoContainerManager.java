package com.baidu.swan.videoplayer.media.video;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
/* loaded from: classes25.dex */
public class VideoContainerManager extends a<VideoHolderWrapper, c> {
    private SwanAppComponentContainerView cdq;
    private VideoHolderWrapper dOj;
    private Context mContext;

    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        this.mContext = context;
        this.cdq = new SwanAppComponentContainerView(this.mContext);
        this.cdq.setBackgroundColor(Color.parseColor("#666666"));
        gO(1);
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
    /* renamed from: dL */
    public VideoHolderWrapper be(@NonNull Context context) {
        return aXL();
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView bE(@NonNull Context context) {
        return this.cdq;
    }

    private void f(c cVar) {
        if (cVar != null) {
            if (!(adN() != null)) {
                if (aXL().getParent() instanceof ViewGroup) {
                    ((ViewGroup) aXL().getParent()).removeView(aXL());
                }
                aXO().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + adI().isSuccess() + " position " + cVar.cdd);
                return;
            }
            c adL = adL();
            if (!TextUtils.equals(cVar.ccZ, adL.ccZ) || !TextUtils.equals(cVar.cda, adL.cda) || !TextUtils.equals(cVar.cdb, adL.cdb)) {
                com.baidu.swan.apps.component.e.a.ba("video", "updateCoverContainerPosition with different id");
            }
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + a((VideoContainerManager) cVar).isSuccess() + " position " + cVar.cdd);
        }
    }

    private VideoHolderWrapper aXL() {
        if (this.dOj == null) {
            this.dOj = new VideoHolderWrapper(this.mContext);
        }
        return this.dOj;
    }

    public FrameLayout getVideoHolder() {
        return aXL().getVideoHolder();
    }

    public void e(View.OnClickListener onClickListener) {
        View playerIcon = aXL().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        g(playerIcon, 0);
    }

    public void aXM() {
        g(aXL().getPlayerIcon(), 8);
    }

    /* renamed from: do  reason: not valid java name */
    public void m36do(String str, String str2) {
        aXL().setPoster(str, str2);
        g(aXL().getVideoPoster(), 0);
    }

    public void aXN() {
        g(aXL().getVideoPoster(), 8);
    }

    public SwanAppComponentContainerView aXO() {
        return this.cdq;
    }

    private void g(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes25.dex */
    public class VideoHolderWrapper extends FrameLayout {
        private FrameLayout dOk;
        private ImageView dOl;
        private SimpleDraweeView dOm;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            aXP();
            aXQ();
            aXR();
        }

        private void aXP() {
            this.dOk = new FrameLayout(getContext());
            addView(this.dOk, new FrameLayout.LayoutParams(-1, -1));
        }

        private void aXQ() {
            this.dOm = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.dOm.getHierarchy().b(p.b.nzG);
            addView(this.dOm, layoutParams);
        }

        private void aXR() {
            this.dOl = new ImageView(VideoContainerManager.this.mContext);
            this.dOl.setImageResource(c.a.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.dOl, layoutParams);
        }

        public FrameLayout getVideoHolder() {
            return this.dOk;
        }

        public View getPlayerIcon() {
            return this.dOl;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.dOm;
        }

        public void setPoster(String str) {
            setPoster(str, "cover");
        }

        public void setPoster(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                p.b bVar = p.b.nzG;
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
                        p.b bVar2 = p.b.nzF;
                        break;
                    case 1:
                        p.b bVar3 = p.b.nzG;
                        break;
                    case 2:
                        p.b bVar4 = p.b.nzA;
                        break;
                }
                this.dOm.getHierarchy().b(p.b.nzG);
                a(str, this.dOm);
            }
        }

        public void a(String str, SimpleDraweeView simpleDraweeView) {
            Uri uri = getUri(str);
            if (uri == null) {
                simpleDraweeView.setController(null);
                return;
            }
            ImageRequestBuilder ad = ImageRequestBuilder.ad(uri);
            int measuredWidth = simpleDraweeView.getMeasuredWidth() / 2;
            int measuredHeight = simpleDraweeView.getMeasuredHeight() / 2;
            if (measuredWidth > 0 && measuredHeight > 0) {
                ad.c(new d(measuredWidth, measuredHeight));
            }
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.dTu().c(simpleDraweeView.getController()).bg(ad.eay()).dUl());
        }

        public Uri getUri(String str) {
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

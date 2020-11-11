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
/* loaded from: classes12.dex */
public class VideoContainerManager extends a<VideoHolderWrapper, c> {
    private SwanAppComponentContainerView cEa;
    private VideoHolderWrapper eoB;
    private Context mContext;

    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        this.mContext = context;
        this.cEa = new SwanAppComponentContainerView(this.mContext);
        this.cEa.setBackgroundColor(Color.parseColor("#666666"));
        hG(1);
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
    /* renamed from: dR */
    public VideoHolderWrapper bk(@NonNull Context context) {
        return beM();
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView bK(@NonNull Context context) {
        return this.cEa;
    }

    private void f(c cVar) {
        if (cVar != null) {
            if (!(akS() != null)) {
                if (beM().getParent() instanceof ViewGroup) {
                    ((ViewGroup) beM().getParent()).removeView(beM());
                }
                beP().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + akN().isSuccess() + " position " + cVar.cDO);
                return;
            }
            c akQ = akQ();
            if (!TextUtils.equals(cVar.cDK, akQ.cDK) || !TextUtils.equals(cVar.cDL, akQ.cDL) || !TextUtils.equals(cVar.cDM, akQ.cDM)) {
                com.baidu.swan.apps.component.e.a.bm("video", "updateCoverContainerPosition with different id");
            }
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + a((VideoContainerManager) cVar).isSuccess() + " position " + cVar.cDO);
        }
    }

    private VideoHolderWrapper beM() {
        if (this.eoB == null) {
            this.eoB = new VideoHolderWrapper(this.mContext);
        }
        return this.eoB;
    }

    public FrameLayout getVideoHolder() {
        return beM().getVideoHolder();
    }

    public void f(View.OnClickListener onClickListener) {
        View playerIcon = beM().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        g(playerIcon, 0);
    }

    public void beN() {
        g(beM().getPlayerIcon(), 8);
    }

    public void dA(String str, String str2) {
        beM().setPoster(str, str2);
        g(beM().getVideoPoster(), 0);
    }

    public void beO() {
        g(beM().getVideoPoster(), 8);
    }

    public SwanAppComponentContainerView beP() {
        return this.cEa;
    }

    private void g(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public class VideoHolderWrapper extends FrameLayout {
        private FrameLayout eoC;
        private ImageView eoD;
        private SimpleDraweeView eoE;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            beQ();
            beR();
            beS();
        }

        private void beQ() {
            this.eoC = new FrameLayout(getContext());
            addView(this.eoC, new FrameLayout.LayoutParams(-1, -1));
        }

        private void beR() {
            this.eoE = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.eoE.getHierarchy().b(p.b.oPL);
            addView(this.eoE, layoutParams);
        }

        private void beS() {
            this.eoD = new ImageView(VideoContainerManager.this.mContext);
            this.eoD.setImageResource(c.a.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.eoD, layoutParams);
        }

        public FrameLayout getVideoHolder() {
            return this.eoC;
        }

        public View getPlayerIcon() {
            return this.eoD;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.eoE;
        }

        public void setPoster(String str) {
            setPoster(str, "cover");
        }

        public void setPoster(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                p.b bVar = p.b.oPL;
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
                        p.b bVar2 = p.b.oPK;
                        break;
                    case 1:
                        p.b bVar3 = p.b.oPL;
                        break;
                    case 2:
                        p.b bVar4 = p.b.oPF;
                        break;
                }
                this.eoE.getHierarchy().b(p.b.oPL);
                a(str, this.eoE);
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
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.ekS().c(simpleDraweeView.getController()).bn(ad.erY()).elJ());
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

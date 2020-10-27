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
    private SwanAppComponentContainerView cyh;
    private VideoHolderWrapper eiH;
    private Context mContext;

    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        this.mContext = context;
        this.cyh = new SwanAppComponentContainerView(this.mContext);
        this.cyh.setBackgroundColor(Color.parseColor("#666666"));
        hw(1);
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
        return bcm();
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView bK(@NonNull Context context) {
        return this.cyh;
    }

    private void f(c cVar) {
        if (cVar != null) {
            if (!(ais() != null)) {
                if (bcm().getParent() instanceof ViewGroup) {
                    ((ViewGroup) bcm().getParent()).removeView(bcm());
                }
                bcp().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + ain().isSuccess() + " position " + cVar.cxV);
                return;
            }
            c aiq = aiq();
            if (!TextUtils.equals(cVar.cxR, aiq.cxR) || !TextUtils.equals(cVar.cxS, aiq.cxS) || !TextUtils.equals(cVar.cxT, aiq.cxT)) {
                com.baidu.swan.apps.component.e.a.bm("video", "updateCoverContainerPosition with different id");
            }
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + a((VideoContainerManager) cVar).isSuccess() + " position " + cVar.cxV);
        }
    }

    private VideoHolderWrapper bcm() {
        if (this.eiH == null) {
            this.eiH = new VideoHolderWrapper(this.mContext);
        }
        return this.eiH;
    }

    public FrameLayout getVideoHolder() {
        return bcm().getVideoHolder();
    }

    public void e(View.OnClickListener onClickListener) {
        View playerIcon = bcm().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        g(playerIcon, 0);
    }

    public void bcn() {
        g(bcm().getPlayerIcon(), 8);
    }

    public void dA(String str, String str2) {
        bcm().setPoster(str, str2);
        g(bcm().getVideoPoster(), 0);
    }

    public void bco() {
        g(bcm().getVideoPoster(), 8);
    }

    public SwanAppComponentContainerView bcp() {
        return this.cyh;
    }

    private void g(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public class VideoHolderWrapper extends FrameLayout {
        private FrameLayout eiI;
        private ImageView eiJ;
        private SimpleDraweeView eiK;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            bcq();
            bcr();
            bcs();
        }

        private void bcq() {
            this.eiI = new FrameLayout(getContext());
            addView(this.eiI, new FrameLayout.LayoutParams(-1, -1));
        }

        private void bcr() {
            this.eiK = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.eiK.getHierarchy().b(p.b.oGs);
            addView(this.eiK, layoutParams);
        }

        private void bcs() {
            this.eiJ = new ImageView(VideoContainerManager.this.mContext);
            this.eiJ.setImageResource(c.a.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.eiJ, layoutParams);
        }

        public FrameLayout getVideoHolder() {
            return this.eiI;
        }

        public View getPlayerIcon() {
            return this.eiJ;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.eiK;
        }

        public void setPoster(String str) {
            setPoster(str, "cover");
        }

        public void setPoster(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                p.b bVar = p.b.oGs;
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
                        p.b bVar2 = p.b.oGr;
                        break;
                    case 1:
                        p.b bVar3 = p.b.oGs;
                        break;
                    case 2:
                        p.b bVar4 = p.b.oGm;
                        break;
                }
                this.eiK.getHierarchy().b(p.b.oGs);
                a(str, this.eiK);
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
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.ehd().c(simpleDraweeView.getController()).bn(ad.eoj()).ehU());
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

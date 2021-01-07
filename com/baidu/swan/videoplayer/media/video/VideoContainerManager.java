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
/* loaded from: classes3.dex */
public class VideoContainerManager extends a<VideoHolderWrapper, c> {
    private SwanAppComponentContainerView cOg;
    private VideoHolderWrapper eDA;
    private Context mContext;

    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        this.mContext = context;
        this.cOg = new SwanAppComponentContainerView(this.mContext);
        this.cOg.setBackgroundColor(Color.parseColor("#666666"));
        hU(1);
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
    /* renamed from: eP */
    public VideoHolderWrapper cx(@NonNull Context context) {
        return bjH();
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView cy(@NonNull Context context) {
        return this.cOg;
    }

    private void f(c cVar) {
        if (cVar != null) {
            if (!(aoC() != null)) {
                if (bjH().getParent() instanceof ViewGroup) {
                    ((ViewGroup) bjH().getParent()).removeView(bjH());
                }
                bjK().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + aox().isSuccess() + " position " + cVar.cNS);
                return;
            }
            c aoA = aoA();
            if (!TextUtils.equals(cVar.cNO, aoA.cNO) || !TextUtils.equals(cVar.cNP, aoA.cNP) || !TextUtils.equals(cVar.cNQ, aoA.cNQ)) {
                com.baidu.swan.apps.component.e.a.br("video", "updateCoverContainerPosition with different id");
            }
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + a((VideoContainerManager) cVar).isSuccess() + " position " + cVar.cNS);
        }
    }

    private VideoHolderWrapper bjH() {
        if (this.eDA == null) {
            this.eDA = new VideoHolderWrapper(this.mContext);
        }
        return this.eDA;
    }

    public FrameLayout getVideoHolder() {
        return bjH().getVideoHolder();
    }

    public void g(View.OnClickListener onClickListener) {
        View playerIcon = bjH().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        l(playerIcon, 0);
    }

    public void bjI() {
        l(bjH().getPlayerIcon(), 8);
    }

    public void dF(String str, String str2) {
        bjH().setPoster(str, str2);
        l(bjH().getVideoPoster(), 0);
    }

    public void bjJ() {
        l(bjH().getVideoPoster(), 8);
    }

    public SwanAppComponentContainerView bjK() {
        return this.cOg;
    }

    private void l(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public class VideoHolderWrapper extends FrameLayout {
        private FrameLayout eDB;
        private ImageView eDC;
        private SimpleDraweeView eDD;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            bjL();
            bjM();
            bjN();
        }

        private void bjL() {
            this.eDB = new FrameLayout(getContext());
            addView(this.eDB, new FrameLayout.LayoutParams(-1, -1));
        }

        private void bjM() {
            this.eDD = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.eDD.getHierarchy().b(p.b.pxO);
            addView(this.eDD, layoutParams);
        }

        private void bjN() {
            this.eDC = new ImageView(VideoContainerManager.this.mContext);
            this.eDC.setImageResource(c.a.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.eDC, layoutParams);
        }

        public FrameLayout getVideoHolder() {
            return this.eDB;
        }

        public View getPlayerIcon() {
            return this.eDC;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.eDD;
        }

        public void setPoster(String str) {
            setPoster(str, "cover");
        }

        public void setPoster(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                p.b bVar = p.b.pxO;
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
                        p.b bVar2 = p.b.pxN;
                        break;
                    case 1:
                        p.b bVar3 = p.b.pxO;
                        break;
                    case 2:
                        p.b bVar4 = p.b.pxI;
                        break;
                }
                this.eDD.getHierarchy().b(p.b.pxO);
                a(str, this.eDD);
            }
        }

        public void a(String str, SimpleDraweeView simpleDraweeView) {
            Uri uN = uN(str);
            if (uN == null) {
                simpleDraweeView.setController(null);
                return;
            }
            ImageRequestBuilder aj = ImageRequestBuilder.aj(uN);
            int measuredWidth = simpleDraweeView.getMeasuredWidth() / 2;
            int measuredHeight = simpleDraweeView.getMeasuredHeight() / 2;
            if (measuredWidth > 0 && measuredHeight > 0) {
                aj.c(new d(measuredWidth, measuredHeight));
            }
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.euP().c(simpleDraweeView.getController()).bo(aj.eBI()).evG());
        }

        public Uri uN(String str) {
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

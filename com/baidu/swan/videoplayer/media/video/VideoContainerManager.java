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
        return bjG();
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView cy(@NonNull Context context) {
        return this.cOg;
    }

    private void f(c cVar) {
        if (cVar != null) {
            if (!(aoB() != null)) {
                if (bjG().getParent() instanceof ViewGroup) {
                    ((ViewGroup) bjG().getParent()).removeView(bjG());
                }
                bjJ().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + aow().isSuccess() + " position " + cVar.cNS);
                return;
            }
            c aoz = aoz();
            if (!TextUtils.equals(cVar.cNO, aoz.cNO) || !TextUtils.equals(cVar.cNP, aoz.cNP) || !TextUtils.equals(cVar.cNQ, aoz.cNQ)) {
                com.baidu.swan.apps.component.e.a.br("video", "updateCoverContainerPosition with different id");
            }
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + a((VideoContainerManager) cVar).isSuccess() + " position " + cVar.cNS);
        }
    }

    private VideoHolderWrapper bjG() {
        if (this.eDA == null) {
            this.eDA = new VideoHolderWrapper(this.mContext);
        }
        return this.eDA;
    }

    public FrameLayout getVideoHolder() {
        return bjG().getVideoHolder();
    }

    public void g(View.OnClickListener onClickListener) {
        View playerIcon = bjG().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        l(playerIcon, 0);
    }

    public void bjH() {
        l(bjG().getPlayerIcon(), 8);
    }

    public void dF(String str, String str2) {
        bjG().setPoster(str, str2);
        l(bjG().getVideoPoster(), 0);
    }

    public void bjI() {
        l(bjG().getVideoPoster(), 8);
    }

    public SwanAppComponentContainerView bjJ() {
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
            bjK();
            bjL();
            bjM();
        }

        private void bjK() {
            this.eDB = new FrameLayout(getContext());
            addView(this.eDB, new FrameLayout.LayoutParams(-1, -1));
        }

        private void bjL() {
            this.eDD = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.eDD.getHierarchy().b(p.b.pxH);
            addView(this.eDD, layoutParams);
        }

        private void bjM() {
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
                p.b bVar = p.b.pxH;
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
                        p.b bVar2 = p.b.pxG;
                        break;
                    case 1:
                        p.b bVar3 = p.b.pxH;
                        break;
                    case 2:
                        p.b bVar4 = p.b.pxB;
                        break;
                }
                this.eDD.getHierarchy().b(p.b.pxH);
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
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.euI().c(simpleDraweeView.getController()).bo(aj.eBe()).evz());
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

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
    private SwanAppComponentContainerView cJu;
    private VideoHolderWrapper eyO;
    private Context mContext;

    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        this.mContext = context;
        this.cJu = new SwanAppComponentContainerView(this.mContext);
        this.cJu.setBackgroundColor(Color.parseColor("#666666"));
        gn(1);
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
    /* renamed from: eN */
    public VideoHolderWrapper cw(@NonNull Context context) {
        return bfN();
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView cx(@NonNull Context context) {
        return this.cJu;
    }

    private void f(c cVar) {
        if (cVar != null) {
            if (!(akI() != null)) {
                if (bfN().getParent() instanceof ViewGroup) {
                    ((ViewGroup) bfN().getParent()).removeView(bfN());
                }
                bfQ().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + akD().isSuccess() + " position " + cVar.cJg);
                return;
            }
            c akG = akG();
            if (!TextUtils.equals(cVar.cJc, akG.cJc) || !TextUtils.equals(cVar.cJd, akG.cJd) || !TextUtils.equals(cVar.cJe, akG.cJe)) {
                com.baidu.swan.apps.component.e.a.bq("video", "updateCoverContainerPosition with different id");
            }
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + a((VideoContainerManager) cVar).isSuccess() + " position " + cVar.cJg);
        }
    }

    private VideoHolderWrapper bfN() {
        if (this.eyO == null) {
            this.eyO = new VideoHolderWrapper(this.mContext);
        }
        return this.eyO;
    }

    public FrameLayout getVideoHolder() {
        return bfN().getVideoHolder();
    }

    public void g(View.OnClickListener onClickListener) {
        View playerIcon = bfN().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        l(playerIcon, 0);
    }

    public void bfO() {
        l(bfN().getPlayerIcon(), 8);
    }

    public void dE(String str, String str2) {
        bfN().setPoster(str, str2);
        l(bfN().getVideoPoster(), 0);
    }

    public void bfP() {
        l(bfN().getVideoPoster(), 8);
    }

    public SwanAppComponentContainerView bfQ() {
        return this.cJu;
    }

    private void l(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes14.dex */
    public class VideoHolderWrapper extends FrameLayout {
        private FrameLayout eyP;
        private ImageView eyQ;
        private SimpleDraweeView eyR;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            bfR();
            bfS();
            bfT();
        }

        private void bfR() {
            this.eyP = new FrameLayout(getContext());
            addView(this.eyP, new FrameLayout.LayoutParams(-1, -1));
        }

        private void bfS() {
            this.eyR = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.eyR.getHierarchy().b(p.b.ptm);
            addView(this.eyR, layoutParams);
        }

        private void bfT() {
            this.eyQ = new ImageView(VideoContainerManager.this.mContext);
            this.eyQ.setImageResource(c.a.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.eyQ, layoutParams);
        }

        public FrameLayout getVideoHolder() {
            return this.eyP;
        }

        public View getPlayerIcon() {
            return this.eyQ;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.eyR;
        }

        public void setPoster(String str) {
            setPoster(str, "cover");
        }

        public void setPoster(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                p.b bVar = p.b.ptm;
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
                        p.b bVar2 = p.b.ptl;
                        break;
                    case 1:
                        p.b bVar3 = p.b.ptm;
                        break;
                    case 2:
                        p.b bVar4 = p.b.ptg;
                        break;
                }
                this.eyR.getHierarchy().b(p.b.ptm);
                a(str, this.eyR);
            }
        }

        public void a(String str, SimpleDraweeView simpleDraweeView) {
            Uri tC = tC(str);
            if (tC == null) {
                simpleDraweeView.setController(null);
                return;
            }
            ImageRequestBuilder ag = ImageRequestBuilder.ag(tC);
            int measuredWidth = simpleDraweeView.getMeasuredWidth() / 2;
            int measuredHeight = simpleDraweeView.getMeasuredHeight() / 2;
            if (measuredWidth > 0 && measuredHeight > 0) {
                ag.c(new d(measuredWidth, measuredHeight));
            }
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.eqV().c(simpleDraweeView.getController()).bo(ag.exQ()).erN());
        }

        public Uri tC(String str) {
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

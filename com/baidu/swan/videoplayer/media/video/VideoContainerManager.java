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
/* loaded from: classes11.dex */
public class VideoContainerManager extends a<VideoHolderWrapper, c> {
    private SwanAppComponentContainerView bPV;
    private VideoHolderWrapper dsp;
    private Context mContext;

    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        this.mContext = context;
        this.bPV = new SwanAppComponentContainerView(this.mContext);
        this.bPV.setBackgroundColor(Color.parseColor("#666666"));
        es(1);
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
    /* renamed from: dA */
    public VideoHolderWrapper aY(@NonNull Context context) {
        return aJH();
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView bu(@NonNull Context context) {
        return this.bPV;
    }

    private void f(c cVar) {
        if (cVar != null) {
            if (!(Vl() != null)) {
                if (aJH().getParent() instanceof ViewGroup) {
                    ((ViewGroup) aJH().getParent()).removeView(aJH());
                }
                aJK().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + Vg().isSuccess() + " position " + cVar.bPJ);
                return;
            }
            c Vj = Vj();
            if (!TextUtils.equals(cVar.bPF, Vj.bPF) || !TextUtils.equals(cVar.bPG, Vj.bPG) || !TextUtils.equals(cVar.bPH, Vj.bPH)) {
                com.baidu.swan.apps.component.e.a.aS("video", "updateCoverContainerPosition with different id");
            }
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + a((VideoContainerManager) cVar).isSuccess() + " position " + cVar.bPJ);
        }
    }

    private VideoHolderWrapper aJH() {
        if (this.dsp == null) {
            this.dsp = new VideoHolderWrapper(this.mContext);
        }
        return this.dsp;
    }

    public FrameLayout getVideoHolder() {
        return aJH().getVideoHolder();
    }

    public void e(View.OnClickListener onClickListener) {
        View playerIcon = aJH().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        g(playerIcon, 0);
    }

    public void aJI() {
        g(aJH().getPlayerIcon(), 8);
    }

    public void cT(String str, String str2) {
        aJH().setPoster(str, str2);
        g(aJH().getVideoPoster(), 0);
    }

    public void aJJ() {
        g(aJH().getVideoPoster(), 8);
    }

    public SwanAppComponentContainerView aJK() {
        return this.bPV;
    }

    private void g(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes11.dex */
    public class VideoHolderWrapper extends FrameLayout {
        private FrameLayout dsq;
        private ImageView dsr;
        private SimpleDraweeView dss;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            aJL();
            aJM();
            aJN();
        }

        private void aJL() {
            this.dsq = new FrameLayout(getContext());
            addView(this.dsq, new FrameLayout.LayoutParams(-1, -1));
        }

        private void aJM() {
            this.dss = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.dss.getHierarchy().b(p.b.mqe);
            addView(this.dss, layoutParams);
        }

        private void aJN() {
            this.dsr = new ImageView(VideoContainerManager.this.mContext);
            this.dsr.setImageResource(c.a.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.dsr, layoutParams);
        }

        public FrameLayout getVideoHolder() {
            return this.dsq;
        }

        public View getPlayerIcon() {
            return this.dsr;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.dss;
        }

        public void setPoster(String str) {
            setPoster(str, "cover");
        }

        public void setPoster(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                p.b bVar = p.b.mqe;
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
                        p.b bVar2 = p.b.mqd;
                        break;
                    case 1:
                        p.b bVar3 = p.b.mqe;
                        break;
                    case 2:
                        p.b bVar4 = p.b.mpY;
                        break;
                }
                this.dss.getHierarchy().b(p.b.mqe);
                a(str, this.dss);
            }
        }

        public void a(String str, SimpleDraweeView simpleDraweeView) {
            Uri uri = getUri(str);
            if (uri == null) {
                simpleDraweeView.setController(null);
                return;
            }
            ImageRequestBuilder ab = ImageRequestBuilder.ab(uri);
            int measuredWidth = simpleDraweeView.getMeasuredWidth() / 2;
            int measuredHeight = simpleDraweeView.getMeasuredHeight() / 2;
            if (measuredWidth > 0 && measuredHeight > 0) {
                ab.c(new d(measuredWidth, measuredHeight));
            }
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.dvf().c(simpleDraweeView.getController()).bb(ab.dCl()).dvW());
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

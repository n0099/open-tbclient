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
/* loaded from: classes9.dex */
public class VideoContainerManager extends a<VideoHolderWrapper, c> {
    private SwanAppComponentContainerView cbj;
    private VideoHolderWrapper dMc;
    private Context mContext;

    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        this.mContext = context;
        this.cbj = new SwanAppComponentContainerView(this.mContext);
        this.cbj.setBackgroundColor(Color.parseColor("#666666"));
        gF(1);
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
    /* renamed from: dM */
    public VideoHolderWrapper bf(@NonNull Context context) {
        return aWZ();
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView bF(@NonNull Context context) {
        return this.cbj;
    }

    private void f(c cVar) {
        if (cVar != null) {
            if (!(ade() != null)) {
                if (aWZ().getParent() instanceof ViewGroup) {
                    ((ViewGroup) aWZ().getParent()).removeView(aWZ());
                }
                aXc().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + acZ().isSuccess() + " position " + cVar.caX);
                return;
            }
            c adc = adc();
            if (!TextUtils.equals(cVar.caT, adc.caT) || !TextUtils.equals(cVar.caU, adc.caU) || !TextUtils.equals(cVar.caV, adc.caV)) {
                com.baidu.swan.apps.component.e.a.ba("video", "updateCoverContainerPosition with different id");
            }
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + a((VideoContainerManager) cVar).isSuccess() + " position " + cVar.caX);
        }
    }

    private VideoHolderWrapper aWZ() {
        if (this.dMc == null) {
            this.dMc = new VideoHolderWrapper(this.mContext);
        }
        return this.dMc;
    }

    public FrameLayout getVideoHolder() {
        return aWZ().getVideoHolder();
    }

    public void e(View.OnClickListener onClickListener) {
        View playerIcon = aWZ().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        g(playerIcon, 0);
    }

    public void aXa() {
        g(aWZ().getPlayerIcon(), 8);
    }

    /* renamed from: do  reason: not valid java name */
    public void m37do(String str, String str2) {
        aWZ().setPoster(str, str2);
        g(aWZ().getVideoPoster(), 0);
    }

    public void aXb() {
        g(aWZ().getVideoPoster(), 8);
    }

    public SwanAppComponentContainerView aXc() {
        return this.cbj;
    }

    private void g(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public class VideoHolderWrapper extends FrameLayout {
        private FrameLayout dMd;
        private ImageView dMe;
        private SimpleDraweeView dMf;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            aXd();
            aXe();
            aXf();
        }

        private void aXd() {
            this.dMd = new FrameLayout(getContext());
            addView(this.dMd, new FrameLayout.LayoutParams(-1, -1));
        }

        private void aXe() {
            this.dMf = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.dMf.getHierarchy().b(p.b.npq);
            addView(this.dMf, layoutParams);
        }

        private void aXf() {
            this.dMe = new ImageView(VideoContainerManager.this.mContext);
            this.dMe.setImageResource(c.a.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.dMe, layoutParams);
        }

        public FrameLayout getVideoHolder() {
            return this.dMd;
        }

        public View getPlayerIcon() {
            return this.dMe;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.dMf;
        }

        public void setPoster(String str) {
            setPoster(str, "cover");
        }

        public void setPoster(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                p.b bVar = p.b.npq;
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
                        p.b bVar2 = p.b.npp;
                        break;
                    case 1:
                        p.b bVar3 = p.b.npq;
                        break;
                    case 2:
                        p.b bVar4 = p.b.npk;
                        break;
                }
                this.dMf.getHierarchy().b(p.b.npq);
                a(str, this.dMf);
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
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.dPn().c(simpleDraweeView.getController()).be(ab.dWr()).dQe());
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

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
    private SwanAppComponentContainerView cpG;
    private VideoHolderWrapper eak;
    private Context mContext;

    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        this.mContext = context;
        this.cpG = new SwanAppComponentContainerView(this.mContext);
        this.cpG.setBackgroundColor(Color.parseColor("#666666"));
        hl(1);
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
        return bat();
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView bK(@NonNull Context context) {
        return this.cpG;
    }

    private void f(c cVar) {
        if (cVar != null) {
            if (!(agy() != null)) {
                if (bat().getParent() instanceof ViewGroup) {
                    ((ViewGroup) bat().getParent()).removeView(bat());
                }
                baw().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + agt().isSuccess() + " position " + cVar.cpt);
                return;
            }
            c agw = agw();
            if (!TextUtils.equals(cVar.cpp, agw.cpp) || !TextUtils.equals(cVar.cpq, agw.cpq) || !TextUtils.equals(cVar.cpr, agw.cpr)) {
                com.baidu.swan.apps.component.e.a.bf("video", "updateCoverContainerPosition with different id");
            }
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + a((VideoContainerManager) cVar).isSuccess() + " position " + cVar.cpt);
        }
    }

    private VideoHolderWrapper bat() {
        if (this.eak == null) {
            this.eak = new VideoHolderWrapper(this.mContext);
        }
        return this.eak;
    }

    public FrameLayout getVideoHolder() {
        return bat().getVideoHolder();
    }

    public void e(View.OnClickListener onClickListener) {
        View playerIcon = bat().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        g(playerIcon, 0);
    }

    public void bau() {
        g(bat().getPlayerIcon(), 8);
    }

    public void dt(String str, String str2) {
        bat().setPoster(str, str2);
        g(bat().getVideoPoster(), 0);
    }

    public void bav() {
        g(bat().getVideoPoster(), 8);
    }

    public SwanAppComponentContainerView baw() {
        return this.cpG;
    }

    private void g(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public class VideoHolderWrapper extends FrameLayout {
        private FrameLayout eal;
        private ImageView eam;
        private SimpleDraweeView ean;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            bax();
            bay();
            baz();
        }

        private void bax() {
            this.eal = new FrameLayout(getContext());
            addView(this.eal, new FrameLayout.LayoutParams(-1, -1));
        }

        private void bay() {
            this.ean = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.ean.getHierarchy().b(p.b.nOZ);
            addView(this.ean, layoutParams);
        }

        private void baz() {
            this.eam = new ImageView(VideoContainerManager.this.mContext);
            this.eam.setImageResource(c.a.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.eam, layoutParams);
        }

        public FrameLayout getVideoHolder() {
            return this.eal;
        }

        public View getPlayerIcon() {
            return this.eam;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.ean;
        }

        public void setPoster(String str) {
            setPoster(str, "cover");
        }

        public void setPoster(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                p.b bVar = p.b.nOZ;
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
                        p.b bVar2 = p.b.nOY;
                        break;
                    case 1:
                        p.b bVar3 = p.b.nOZ;
                        break;
                    case 2:
                        p.b bVar4 = p.b.nOT;
                        break;
                }
                this.ean.getHierarchy().b(p.b.nOZ);
                a(str, this.ean);
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
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.dXf().c(simpleDraweeView.getController()).bj(ad.eej()).dXW());
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

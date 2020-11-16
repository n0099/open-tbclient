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
/* loaded from: classes6.dex */
public class VideoContainerManager extends a<VideoHolderWrapper, c> {
    private SwanAppComponentContainerView cCq;
    private VideoHolderWrapper emR;
    private Context mContext;

    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        this.mContext = context;
        this.cCq = new SwanAppComponentContainerView(this.mContext);
        this.cCq.setBackgroundColor(Color.parseColor("#666666"));
        hC(1);
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
        return bef();
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView bK(@NonNull Context context) {
        return this.cCq;
    }

    private void f(c cVar) {
        if (cVar != null) {
            if (!(akk() != null)) {
                if (bef().getParent() instanceof ViewGroup) {
                    ((ViewGroup) bef().getParent()).removeView(bef());
                }
                bei().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + akf().isSuccess() + " position " + cVar.cCe);
                return;
            }
            c aki = aki();
            if (!TextUtils.equals(cVar.cCa, aki.cCa) || !TextUtils.equals(cVar.cCb, aki.cCb) || !TextUtils.equals(cVar.cCc, aki.cCc)) {
                com.baidu.swan.apps.component.e.a.bl("video", "updateCoverContainerPosition with different id");
            }
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + a((VideoContainerManager) cVar).isSuccess() + " position " + cVar.cCe);
        }
    }

    private VideoHolderWrapper bef() {
        if (this.emR == null) {
            this.emR = new VideoHolderWrapper(this.mContext);
        }
        return this.emR;
    }

    public FrameLayout getVideoHolder() {
        return bef().getVideoHolder();
    }

    public void f(View.OnClickListener onClickListener) {
        View playerIcon = bef().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        i(playerIcon, 0);
    }

    public void beg() {
        i(bef().getPlayerIcon(), 8);
    }

    public void dz(String str, String str2) {
        bef().setPoster(str, str2);
        i(bef().getVideoPoster(), 0);
    }

    public void beh() {
        i(bef().getVideoPoster(), 8);
    }

    public SwanAppComponentContainerView bei() {
        return this.cCq;
    }

    private void i(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes6.dex */
    public class VideoHolderWrapper extends FrameLayout {
        private FrameLayout emS;
        private ImageView emT;
        private SimpleDraweeView emU;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            bej();
            bek();
            bel();
        }

        private void bej() {
            this.emS = new FrameLayout(getContext());
            addView(this.emS, new FrameLayout.LayoutParams(-1, -1));
        }

        private void bek() {
            this.emU = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.emU.getHierarchy().b(p.b.oRo);
            addView(this.emU, layoutParams);
        }

        private void bel() {
            this.emT = new ImageView(VideoContainerManager.this.mContext);
            this.emT.setImageResource(c.a.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.emT, layoutParams);
        }

        public FrameLayout getVideoHolder() {
            return this.emS;
        }

        public View getPlayerIcon() {
            return this.emT;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.emU;
        }

        public void setPoster(String str) {
            setPoster(str, "cover");
        }

        public void setPoster(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                p.b bVar = p.b.oRo;
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
                        p.b bVar2 = p.b.oRn;
                        break;
                    case 1:
                        p.b bVar3 = p.b.oRo;
                        break;
                    case 2:
                        p.b bVar4 = p.b.oRi;
                        break;
                }
                this.emU.getHierarchy().b(p.b.oRo);
                a(str, this.emU);
            }
        }

        public void a(String str, SimpleDraweeView simpleDraweeView) {
            Uri uri = getUri(str);
            if (uri == null) {
                simpleDraweeView.setController(null);
                return;
            }
            ImageRequestBuilder ae = ImageRequestBuilder.ae(uri);
            int measuredWidth = simpleDraweeView.getMeasuredWidth() / 2;
            int measuredHeight = simpleDraweeView.getMeasuredHeight() / 2;
            if (measuredWidth > 0 && measuredHeight > 0) {
                ae.c(new d(measuredWidth, measuredHeight));
            }
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.ekQ().c(simpleDraweeView.getController()).bo(ae.erW()).elH());
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

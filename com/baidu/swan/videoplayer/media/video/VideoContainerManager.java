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
    private SwanAppComponentContainerView bUJ;
    private VideoHolderWrapper dxa;
    private Context mContext;

    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        this.mContext = context;
        this.bUJ = new SwanAppComponentContainerView(this.mContext);
        this.bUJ.setBackgroundColor(Color.parseColor("#666666"));
        eF(1);
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
    /* renamed from: dB */
    public VideoHolderWrapper aZ(@NonNull Context context) {
        return aKN();
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView bv(@NonNull Context context) {
        return this.bUJ;
    }

    private void f(c cVar) {
        if (cVar != null) {
            if (!(Wr() != null)) {
                if (aKN().getParent() instanceof ViewGroup) {
                    ((ViewGroup) aKN().getParent()).removeView(aKN());
                }
                aKQ().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + Wm().isSuccess() + " position " + cVar.bUx);
                return;
            }
            c Wp = Wp();
            if (!TextUtils.equals(cVar.bUt, Wp.bUt) || !TextUtils.equals(cVar.bUu, Wp.bUu) || !TextUtils.equals(cVar.bUv, Wp.bUv)) {
                com.baidu.swan.apps.component.e.a.aU("video", "updateCoverContainerPosition with different id");
            }
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + a((VideoContainerManager) cVar).isSuccess() + " position " + cVar.bUx);
        }
    }

    private VideoHolderWrapper aKN() {
        if (this.dxa == null) {
            this.dxa = new VideoHolderWrapper(this.mContext);
        }
        return this.dxa;
    }

    public FrameLayout getVideoHolder() {
        return aKN().getVideoHolder();
    }

    public void e(View.OnClickListener onClickListener) {
        View playerIcon = aKN().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        g(playerIcon, 0);
    }

    public void aKO() {
        g(aKN().getPlayerIcon(), 8);
    }

    public void cV(String str, String str2) {
        aKN().setPoster(str, str2);
        g(aKN().getVideoPoster(), 0);
    }

    public void aKP() {
        g(aKN().getVideoPoster(), 8);
    }

    public SwanAppComponentContainerView aKQ() {
        return this.bUJ;
    }

    private void g(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes11.dex */
    public class VideoHolderWrapper extends FrameLayout {
        private FrameLayout dxb;
        private ImageView dxc;
        private SimpleDraweeView dxd;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            aKR();
            aKS();
            aKT();
        }

        private void aKR() {
            this.dxb = new FrameLayout(getContext());
            addView(this.dxb, new FrameLayout.LayoutParams(-1, -1));
        }

        private void aKS() {
            this.dxd = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.dxd.getHierarchy().b(p.b.mNm);
            addView(this.dxd, layoutParams);
        }

        private void aKT() {
            this.dxc = new ImageView(VideoContainerManager.this.mContext);
            this.dxc.setImageResource(c.a.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.dxc, layoutParams);
        }

        public FrameLayout getVideoHolder() {
            return this.dxb;
        }

        public View getPlayerIcon() {
            return this.dxc;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.dxd;
        }

        public void setPoster(String str) {
            setPoster(str, "cover");
        }

        public void setPoster(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                p.b bVar = p.b.mNm;
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
                        p.b bVar2 = p.b.mNl;
                        break;
                    case 1:
                        p.b bVar3 = p.b.mNm;
                        break;
                    case 2:
                        p.b bVar4 = p.b.mNg;
                        break;
                }
                this.dxd.getHierarchy().b(p.b.mNm);
                a(str, this.dxd);
            }
        }

        public void a(String str, SimpleDraweeView simpleDraweeView) {
            Uri uri = getUri(str);
            if (uri == null) {
                simpleDraweeView.setController(null);
                return;
            }
            ImageRequestBuilder ac = ImageRequestBuilder.ac(uri);
            int measuredWidth = simpleDraweeView.getMeasuredWidth() / 2;
            int measuredHeight = simpleDraweeView.getMeasuredHeight() / 2;
            if (measuredWidth > 0 && measuredHeight > 0) {
                ac.c(new d(measuredWidth, measuredHeight));
            }
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.dzW().c(simpleDraweeView.getController()).bc(ac.dHb()).dAN());
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

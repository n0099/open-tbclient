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
/* loaded from: classes3.dex */
public class VideoContainerManager extends a<VideoHolderWrapper, c> {
    private SwanAppComponentContainerView bVB;
    private VideoHolderWrapper dCS;
    private Context mContext;

    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        this.mContext = context;
        this.bVB = new SwanAppComponentContainerView(this.mContext);
        this.bVB.setBackgroundColor(Color.parseColor("#666666"));
        eH(1);
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
    /* renamed from: dF */
    public VideoHolderWrapper ba(@NonNull Context context) {
        return aOB();
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView by(@NonNull Context context) {
        return this.bVB;
    }

    private void f(c cVar) {
        if (cVar != null) {
            if (!(WY() != null)) {
                if (aOB().getParent() instanceof ViewGroup) {
                    ((ViewGroup) aOB().getParent()).removeView(aOB());
                }
                aOE().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + WT().isSuccess() + " position " + cVar.bVp);
                return;
            }
            c WW = WW();
            if (!TextUtils.equals(cVar.bVl, WW.bVl) || !TextUtils.equals(cVar.bVm, WW.bVm) || !TextUtils.equals(cVar.bVn, WW.bVn)) {
                com.baidu.swan.apps.component.e.a.aV("video", "updateCoverContainerPosition with different id");
            }
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + a((VideoContainerManager) cVar).isSuccess() + " position " + cVar.bVp);
        }
    }

    private VideoHolderWrapper aOB() {
        if (this.dCS == null) {
            this.dCS = new VideoHolderWrapper(this.mContext);
        }
        return this.dCS;
    }

    public FrameLayout getVideoHolder() {
        return aOB().getVideoHolder();
    }

    public void e(View.OnClickListener onClickListener) {
        View playerIcon = aOB().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        g(playerIcon, 0);
    }

    public void aOC() {
        g(aOB().getPlayerIcon(), 8);
    }

    public void cY(String str, String str2) {
        aOB().setPoster(str, str2);
        g(aOB().getVideoPoster(), 0);
    }

    public void aOD() {
        g(aOB().getVideoPoster(), 8);
    }

    public SwanAppComponentContainerView aOE() {
        return this.bVB;
    }

    private void g(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public class VideoHolderWrapper extends FrameLayout {
        private FrameLayout dCT;
        private ImageView dCU;
        private SimpleDraweeView dCV;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            aOF();
            aOG();
            aOH();
        }

        private void aOF() {
            this.dCT = new FrameLayout(getContext());
            addView(this.dCT, new FrameLayout.LayoutParams(-1, -1));
        }

        private void aOG() {
            this.dCV = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.dCV.getHierarchy().b(p.b.mVA);
            addView(this.dCV, layoutParams);
        }

        private void aOH() {
            this.dCU = new ImageView(VideoContainerManager.this.mContext);
            this.dCU.setImageResource(c.a.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.dCU, layoutParams);
        }

        public FrameLayout getVideoHolder() {
            return this.dCT;
        }

        public View getPlayerIcon() {
            return this.dCU;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.dCV;
        }

        public void setPoster(String str) {
            setPoster(str, "cover");
        }

        public void setPoster(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                p.b bVar = p.b.mVA;
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
                        p.b bVar2 = p.b.mVz;
                        break;
                    case 1:
                        p.b bVar3 = p.b.mVA;
                        break;
                    case 2:
                        p.b bVar4 = p.b.mVu;
                        break;
                }
                this.dCV.getHierarchy().b(p.b.mVA);
                a(str, this.dCV);
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
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.dDn().c(simpleDraweeView.getController()).bc(ab.dKs()).dEe());
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

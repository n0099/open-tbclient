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
    private SwanAppComponentContainerView cJl;
    private VideoHolderWrapper etT;
    private Context mContext;

    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        this.mContext = context;
        this.cJl = new SwanAppComponentContainerView(this.mContext);
        this.cJl.setBackgroundColor(Color.parseColor("#666666"));
        ia(1);
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
    /* renamed from: ew */
    public VideoHolderWrapper bQ(@NonNull Context context) {
        return bhk();
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView cq(@NonNull Context context) {
        return this.cJl;
    }

    private void f(c cVar) {
        if (cVar != null) {
            if (!(ans() != null)) {
                if (bhk().getParent() instanceof ViewGroup) {
                    ((ViewGroup) bhk().getParent()).removeView(bhk());
                }
                bhn().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + ann().isSuccess() + " position " + cVar.cIZ);
                return;
            }
            c anq = anq();
            if (!TextUtils.equals(cVar.cIV, anq.cIV) || !TextUtils.equals(cVar.cIW, anq.cIW) || !TextUtils.equals(cVar.cIX, anq.cIX)) {
                com.baidu.swan.apps.component.e.a.bs("video", "updateCoverContainerPosition with different id");
            }
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + a((VideoContainerManager) cVar).isSuccess() + " position " + cVar.cIZ);
        }
    }

    private VideoHolderWrapper bhk() {
        if (this.etT == null) {
            this.etT = new VideoHolderWrapper(this.mContext);
        }
        return this.etT;
    }

    public FrameLayout getVideoHolder() {
        return bhk().getVideoHolder();
    }

    public void f(View.OnClickListener onClickListener) {
        View playerIcon = bhk().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        i(playerIcon, 0);
    }

    public void bhl() {
        i(bhk().getPlayerIcon(), 8);
    }

    public void dG(String str, String str2) {
        bhk().setPoster(str, str2);
        i(bhk().getVideoPoster(), 0);
    }

    public void bhm() {
        i(bhk().getVideoPoster(), 8);
    }

    public SwanAppComponentContainerView bhn() {
        return this.cJl;
    }

    private void i(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes6.dex */
    public class VideoHolderWrapper extends FrameLayout {
        private FrameLayout etU;
        private ImageView etV;
        private SimpleDraweeView etW;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            bho();
            bhp();
            bhq();
        }

        private void bho() {
            this.etU = new FrameLayout(getContext());
            addView(this.etU, new FrameLayout.LayoutParams(-1, -1));
        }

        private void bhp() {
            this.etW = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.etW.getHierarchy().b(p.b.pgz);
            addView(this.etW, layoutParams);
        }

        private void bhq() {
            this.etV = new ImageView(VideoContainerManager.this.mContext);
            this.etV.setImageResource(c.a.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.etV, layoutParams);
        }

        public FrameLayout getVideoHolder() {
            return this.etU;
        }

        public View getPlayerIcon() {
            return this.etV;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.etW;
        }

        public void setPoster(String str) {
            setPoster(str, "cover");
        }

        public void setPoster(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                p.b bVar = p.b.pgz;
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
                        p.b bVar2 = p.b.pgy;
                        break;
                    case 1:
                        p.b bVar3 = p.b.pgz;
                        break;
                    case 2:
                        p.b bVar4 = p.b.pgt;
                        break;
                }
                this.etW.getHierarchy().b(p.b.pgz);
                a(str, this.etW);
            }
        }

        public void a(String str, SimpleDraweeView simpleDraweeView) {
            Uri uri = getUri(str);
            if (uri == null) {
                simpleDraweeView.setController(null);
                return;
            }
            ImageRequestBuilder af = ImageRequestBuilder.af(uri);
            int measuredWidth = simpleDraweeView.getMeasuredWidth() / 2;
            int measuredHeight = simpleDraweeView.getMeasuredHeight() / 2;
            if (measuredWidth > 0 && measuredHeight > 0) {
                af.c(new d(measuredWidth, measuredHeight));
            }
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.eqG().c(simpleDraweeView.getController()).bo(af.exx()).erx());
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

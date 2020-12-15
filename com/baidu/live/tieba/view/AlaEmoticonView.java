package com.baidu.live.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.lib.resourceloader.BdResourceCallback;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.view.fresco.SimpleDraweeView;
import com.facebook.drawee.a.a.c;
import com.facebook.imagepipeline.f.f;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
/* loaded from: classes4.dex */
public class AlaEmoticonView extends FrameLayout {
    private SimpleDraweeView bGw;
    private TbImageView bGx;
    private a bGy;

    /* loaded from: classes4.dex */
    public interface a {
        void Vm();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void Vn();

        void onFail();
    }

    public AlaEmoticonView(Context context) {
        this(context, null);
    }

    public AlaEmoticonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaEmoticonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.g.ala_emoticon_view, (ViewGroup) this, true);
        this.bGw = (SimpleDraweeView) inflate.findViewById(a.f.emoticon_iv);
        this.bGx = (TbImageView) inflate.findViewById(a.f.emoticon_result_iv);
    }

    public void aQ(String str, String str2) {
        this.bGw.setVisibility(StringUtils.isNull(str, true) ? 8 : 0);
        aR(str, str2);
        this.bGx.setVisibility(StringUtils.isNull(str2, true) ? 8 : 0);
        c(str2, StringUtils.isNull(str, true) ? 1.0f : 0.0f);
    }

    public void stopLoad() {
        if (this.bGw != null) {
            this.bGw.clearAnimation();
            if (this.bGw.getController() != null && this.bGw.getController().erm() != null && this.bGw.getController().erm().isRunning()) {
                this.bGw.getController().erm().stop();
            }
        }
    }

    public void setEmoticonListener(a aVar) {
        this.bGy = aVar;
    }

    private void aR(String str, final String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.bGw.setVisibility(0);
            this.bGw.setController(c.eqG().bo(ImageRequest.Zv(str)).c(this.bGw.getController()).AP(true).c(new com.facebook.drawee.controller.b<f>() { // from class: com.baidu.live.tieba.view.AlaEmoticonView.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                public void a(String str3, f fVar, Animatable animatable) {
                    if (animatable instanceof com.facebook.fresco.animation.c.a) {
                        ((com.facebook.fresco.animation.c.a) animatable).a(new com.facebook.fresco.animation.c.c() { // from class: com.baidu.live.tieba.view.AlaEmoticonView.1.1
                            @Override // com.facebook.fresco.animation.c.c, com.facebook.fresco.animation.c.b
                            public void a(com.facebook.fresco.animation.c.a aVar) {
                            }

                            @Override // com.facebook.fresco.animation.c.c, com.facebook.fresco.animation.c.b
                            public void b(com.facebook.fresco.animation.c.a aVar) {
                            }

                            @Override // com.facebook.fresco.animation.c.c, com.facebook.fresco.animation.c.b
                            public void a(com.facebook.fresco.animation.c.a aVar, int i) {
                                super.a(aVar, i);
                                if (aVar != null && i >= aVar.getFrameCount() - 1) {
                                    AlaEmoticonView.this.a(aVar, str2);
                                }
                            }
                        });
                    }
                }
            }).erx());
        }
    }

    private void c(String str, float f) {
        this.bGx.setAlpha(f);
        this.bGx.setDefaultBgResource(a.e.sdk_transparent_bg);
        this.bGx.startLoad(str, 10, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.fresco.animation.c.a aVar, String str) {
        aVar.stop();
        aVar.a((com.facebook.fresco.animation.c.b) null);
        if (!TextUtils.isEmpty(str)) {
            this.bGx.setAlpha(1.0f);
            this.bGw.setVisibility(8);
        }
        if (this.bGy != null) {
            this.bGy.Vm();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopLoad();
    }

    public static void a(String str, final String str2, final b bVar, Object obj) {
        if (!StringUtils.isNull(str, true)) {
            c.eqI().e(ImageRequestBuilder.af(Uri.parse(str)).Ba(true).exx(), obj).a(new com.facebook.imagepipeline.d.b() { // from class: com.baidu.live.tieba.view.AlaEmoticonView.2
                @Override // com.facebook.imagepipeline.d.b
                public void e(@Nullable Bitmap bitmap) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.tieba.view.AlaEmoticonView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!StringUtils.isNull(str2, true)) {
                                AlaEmoticonView.a(str2, bVar);
                            } else if (bVar != null) {
                                bVar.Vn();
                            }
                        }
                    });
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.b] */
                @Override // com.facebook.datasource.a
                public void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> bVar2) {
                    if (bVar != null) {
                        bVar.onFail();
                    }
                }
            }, com.facebook.common.b.a.epJ());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.tieba.view.AlaEmoticonView$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static class AnonymousClass3 implements Runnable {
        final /* synthetic */ b bGC;
        final /* synthetic */ String val$url;

        AnonymousClass3(String str, b bVar) {
            this.val$url = str;
            this.bGC = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            BdResourceLoader.getInstance().loadResource(this.val$url, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.tieba.view.AlaEmoticonView.3.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(final BdImage bdImage, final String str, int i) {
                    super.onLoaded((AnonymousClass1) bdImage, str, i);
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.tieba.view.AlaEmoticonView.3.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (bdImage != null && bdImage.getRawBitmap() != null && str != null && str.equals(AnonymousClass3.this.val$url) && AnonymousClass3.this.bGC != null) {
                                AnonymousClass3.this.bGC.Vn();
                            }
                        }
                    });
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, b bVar) {
        SafeHandler.getInst().post(new AnonymousClass3(str, bVar));
    }
}

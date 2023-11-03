package com.baidu.nadcore.lp.reward.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.txt.UnifyTextView;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tieba.R;
import com.baidu.tieba.al0;
import com.baidu.tieba.an0;
import com.baidu.tieba.az0;
import com.baidu.tieba.be0;
import com.baidu.tieba.bz0;
import com.baidu.tieba.d91;
import com.baidu.tieba.fd0;
import com.baidu.tieba.fn0;
import com.baidu.tieba.gn0;
import com.baidu.tieba.p11;
import com.baidu.tieba.pe0;
import com.baidu.tieba.pn0;
import com.baidu.tieba.qi0;
import com.baidu.tieba.rn0;
import com.baidu.tieba.sm0;
import com.baidu.tieba.sn0;
import com.baidu.tieba.t11;
import com.baidu.tieba.vg0;
import com.baidu.tieba.wi0;
import com.baidu.tieba.wk0;
import com.baidu.tieba.wm0;
import com.baidu.tieba.zd0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010F\u001a\u00020%\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010G\u0012\b\b\u0002\u0010J\u001a\u00020I¢\u0006\u0004\bK\u0010LJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u001b\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\bJ\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0017R\u001d\u0010\u001d\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\"\u001a\u00020\u001e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010#R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001d\u0010,\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001a\u001a\u0004\b*\u0010+R\u001d\u00101\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u001a\u001a\u0004\b/\u00100R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001d\u0010:\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u001a\u001a\u0004\b9\u0010\u001cR\u001d\u0010=\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u001a\u001a\u0004\b<\u0010\u001cR\u001d\u0010B\u001a\u00020>8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u001a\u001a\u0004\b@\u0010AR\u001d\u0010E\u001a\u00020\u001e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u001a\u001a\u0004\bD\u0010!¨\u0006M"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardImageView;", "Landroid/widget/LinearLayout;", "", DnsModel.AREA_KEY, "", "handleClick", "(Ljava/lang/String;)V", "registerDownloadEventBus", "()V", "setAvatar", "setBrandName", "Lkotlin/Function0;", "clickCallback", "setClickCallBack", "(Lkotlin/Function0;)V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "setData", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)V", "setDetailButton", "setDownloadButton", "setImage", "setTitle", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Lcom/baidu/nadcore/widget/AdImageView;", "avatar$delegate", "Lkotlin/Lazy;", "getAvatar", "()Lcom/baidu/nadcore/widget/AdImageView;", "avatar", "Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "brandName$delegate", "getBrandName", "()Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "brandName", "Lkotlin/Function0;", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "contextRef", "Ljava/lang/ref/WeakReference;", "Landroid/widget/TextView;", "detailBtn$delegate", "getDetailBtn", "()Landroid/widget/TextView;", "detailBtn", "Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadBtn$delegate", "getDownloadBtn", "()Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadBtn", "", "downloadEventObject", "Ljava/lang/Object;", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "downloadPresenter", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "image$delegate", "getImage", "image", "imageBg$delegate", "getImageBg", "imageBg", "Landroid/widget/FrameLayout;", "imageContainer$delegate", "getImageContainer", "()Landroid/widget/FrameLayout;", "imageContainer", "title$delegate", "getTitle", "title", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadRewardImageView extends LinearLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public zd0 i;
    public gn0 j;
    public Function0<Unit> k;
    public final Object l;
    public final WeakReference<Context> m;

    @JvmOverloads
    public NadRewardImageView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public NadRewardImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final AdImageView getAvatar() {
        return (AdImageView) this.a.getValue();
    }

    private final UnifyTextView getBrandName() {
        return (UnifyTextView) this.b.getValue();
    }

    private final TextView getDetailBtn() {
        return (TextView) this.g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NadMiniVideoDownloadView getDownloadBtn() {
        return (NadMiniVideoDownloadView) this.h.getValue();
    }

    private final AdImageView getImage() {
        return (AdImageView) this.f.getValue();
    }

    private final AdImageView getImageBg() {
        return (AdImageView) this.e.getValue();
    }

    private final FrameLayout getImageContainer() {
        return (FrameLayout) this.d.getValue();
    }

    private final UnifyTextView getTitle() {
        return (UnifyTextView) this.c.getValue();
    }

    /* loaded from: classes3.dex */
    public static final class a extends wi0<fd0> {
        public a(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wi0
        public void onEvent(fd0 event) {
            Intrinsics.checkNotNullParameter(event, "event");
            gn0 gn0Var = NadRewardImageView.this.j;
            if ((gn0Var == null || gn0Var.p()) && event.a != null && NadRewardImageView.this.getDownloadBtn().getDownloadStatus() != AdDownloadStatus.DOWNLOADING) {
                NadRewardImageView.this.getDownloadBtn().performClick();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardImageView.this.e("avatar");
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardImageView.this.e("name");
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardImageView.this.e("detailButton");
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            List<MonitorUrl> list;
            zd0 zd0Var = NadRewardImageView.this.i;
            if (zd0Var != null) {
                zd0Var.m();
            }
            gn0 gn0Var = NadRewardImageView.this.j;
            if (gn0Var != null) {
                list = gn0Var.e;
            } else {
                list = null;
            }
            be0.b(list);
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardImageView.this.e("image");
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardImageView.this.e("title");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadRewardImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<AdImageView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardImageView$avatar$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AdImageView invoke() {
                View findViewById = NadRewardImageView.this.findViewById(R.id.obfuscated_res_0x7f09032e);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.avatar)");
                return (AdImageView) findViewById;
            }
        });
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardImageView$brandName$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UnifyTextView invoke() {
                View findViewById = NadRewardImageView.this.findViewById(R.id.brand_name);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.brand_name)");
                return (UnifyTextView) findViewById;
            }
        });
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardImageView$title$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UnifyTextView invoke() {
                View findViewById = NadRewardImageView.this.findViewById(R.id.obfuscated_res_0x7f0925fe);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
                return (UnifyTextView) findViewById;
            }
        });
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardImageView$imageContainer$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                View findViewById = NadRewardImageView.this.findViewById(R.id.image_container);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.image_container)");
                return (FrameLayout) findViewById;
            }
        });
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<AdImageView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardImageView$imageBg$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AdImageView invoke() {
                View findViewById = NadRewardImageView.this.findViewById(R.id.image_bg);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.image_bg)");
                return (AdImageView) findViewById;
            }
        });
        this.f = LazyKt__LazyJVMKt.lazy(new Function0<AdImageView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardImageView$image$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AdImageView invoke() {
                View findViewById = NadRewardImageView.this.findViewById(R.id.obfuscated_res_0x7f0910d4);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.image)");
                return (AdImageView) findViewById;
            }
        });
        this.g = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardImageView$detailBtn$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View findViewById = NadRewardImageView.this.findViewById(R.id.detail_btn);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.detail_btn)");
                return (TextView) findViewById;
            }
        });
        this.h = LazyKt__LazyJVMKt.lazy(new Function0<NadMiniVideoDownloadView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardImageView$downloadBtn$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NadMiniVideoDownloadView invoke() {
                View findViewById = NadRewardImageView.this.findViewById(R.id.download_btn);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.download_btn)");
                return (NadMiniVideoDownloadView) findViewById;
            }
        });
        this.l = new Object();
        this.m = new WeakReference<>(context);
        LayoutInflater from = LayoutInflater.from(context);
        wk0 a2 = al0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        from.inflate(a2.t(), this);
    }

    public /* synthetic */ NadRewardImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setClickCallBack(Function0<Unit> clickCallback) {
        Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
        this.k = clickCallback;
    }

    public final void setData(gn0 gn0Var) {
        this.j = gn0Var;
        g();
        h();
        l();
        k();
        i();
        j();
        f();
    }

    public final void e(String str) {
        String str2;
        an0 an0Var;
        List<MonitorUrl> list;
        boolean z;
        an0 an0Var2;
        ClogBuilder u = new ClogBuilder().j(str).y(ClogBuilder.LogType.CLICK).u(ClogBuilder.Page.WELFAREIMAGELP);
        gn0 gn0Var = this.j;
        String str3 = null;
        if (gn0Var != null && (an0Var2 = gn0Var.f) != null) {
            str2 = an0Var2.d;
        } else {
            str2 = null;
        }
        az0.e(u.p(str2));
        gn0 gn0Var2 = this.j;
        if (gn0Var2 != null && (list = gn0Var2.e) != null) {
            ArrayList<MonitorUrl> arrayList = new ArrayList();
            for (Object obj : list) {
                String str4 = ((MonitorUrl) obj).clickUrl;
                if (str4 != null && !StringsKt__StringsJVMKt.isBlank(str4)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    arrayList.add(obj);
                }
            }
            for (MonitorUrl monitorUrl : arrayList) {
                bz0.b(monitorUrl.clickUrl);
            }
        }
        if (Intrinsics.areEqual(str, "detailButton")) {
            gn0 gn0Var3 = this.j;
            if (gn0Var3 != null && (an0Var = gn0Var3.f) != null) {
                str3 = an0Var.c;
            }
            pe0.c(str3, getContext());
            return;
        }
        Function0<Unit> function0 = this.k;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void f() {
        Context context = this.m.get();
        if (!(context instanceof Activity)) {
            context = null;
        }
        Activity activity = (Activity) context;
        if (activity != null) {
            qi0.b.c(activity, this.l, new a(fd0.class));
        }
    }

    public final void g() {
        String str;
        an0 an0Var;
        AdImageView avatar = getAvatar();
        gn0 gn0Var = this.j;
        if (gn0Var != null && (an0Var = gn0Var.f) != null) {
            str = an0Var.f;
        } else {
            str = null;
        }
        avatar.r(str);
        avatar.setOnClickListener(new b());
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
        if (r1 == true) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h() {
        String str;
        an0 an0Var;
        an0 an0Var2;
        String str2;
        boolean z;
        UnifyTextView brandName = getBrandName();
        gn0 gn0Var = this.j;
        boolean z2 = true;
        if (gn0Var != null && (an0Var2 = gn0Var.f) != null && (str2 = an0Var2.e) != null) {
            if (str2.length() > 0) {
                z = true;
            } else {
                z = false;
            }
        }
        z2 = false;
        if (z2) {
            brandName.setVisibility(0);
        } else {
            brandName.setVisibility(8);
        }
        gn0 gn0Var2 = this.j;
        if (gn0Var2 != null && (an0Var = gn0Var2.f) != null) {
            str = an0Var.e;
        } else {
            str = null;
        }
        brandName.setText(str);
        brandName.setOnClickListener(new c());
    }

    public final void i() {
        String str;
        boolean z;
        String str2;
        String str3;
        wm0 wm0Var;
        wm0 wm0Var2;
        wm0 wm0Var3;
        wm0 wm0Var4;
        TextView detailBtn = getDetailBtn();
        Resources resources = detailBtn.getResources();
        wk0 a2 = al0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        float dimension = resources.getDimension(a2.i());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gn0 gn0Var = this.j;
        String str4 = null;
        if (gn0Var != null && (wm0Var4 = gn0Var.m) != null) {
            str = wm0Var4.r;
        } else {
            str = null;
        }
        gradientDrawable.setColor(p11.a(str, R.color.nad_reward_image_style_btn_color));
        gradientDrawable.setCornerRadius(dimension);
        Unit unit = Unit.INSTANCE;
        detailBtn.setBackground(gradientDrawable);
        gn0 gn0Var2 = this.j;
        boolean z2 = false;
        if (gn0Var2 != null && gn0Var2.o()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            detailBtn.setVisibility(0);
        } else {
            detailBtn.setVisibility(8);
        }
        detailBtn.setOnClickListener(new d());
        gn0 gn0Var3 = this.j;
        if (gn0Var3 != null && (wm0Var3 = gn0Var3.m) != null && wm0Var3.g) {
            str3 = detailBtn.getContext().getString(R.string.nad_reward_detail_btn_open_app);
        } else {
            gn0 gn0Var4 = this.j;
            if (gn0Var4 != null && (wm0Var2 = gn0Var4.m) != null) {
                str2 = wm0Var2.b;
            } else {
                str2 = null;
            }
            if (!((str2 == null || StringsKt__StringsJVMKt.isBlank(str2)) ? true : true)) {
                gn0 gn0Var5 = this.j;
                if (gn0Var5 != null && (wm0Var = gn0Var5.m) != null) {
                    str4 = wm0Var.b;
                }
            } else {
                str4 = detailBtn.getContext().getString(R.string.nad_reward_detail_btn_text);
            }
            str3 = str4;
        }
        detailBtn.setText(str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l() {
        boolean z;
        gn0 gn0Var;
        String str;
        boolean z2;
        String str2;
        CharSequence charSequence;
        an0 an0Var;
        an0 an0Var2;
        fn0 m;
        an0 an0Var3;
        an0 an0Var4;
        String str3;
        boolean z3;
        UnifyTextView title = getTitle();
        gn0 gn0Var2 = this.j;
        boolean z4 = true;
        if (gn0Var2 != null && (an0Var4 = gn0Var2.f) != null && (str3 = an0Var4.g) != null) {
            if (str3.length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                z = true;
                if (!z) {
                    title.setVisibility(0);
                } else {
                    title.setVisibility(8);
                }
                gn0Var = this.j;
                String str4 = null;
                if (gn0Var == null && (an0Var3 = gn0Var.f) != null) {
                    str = an0Var3.g;
                } else {
                    str = null;
                }
                if (str == null && str.length() != 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    Drawable drawable = ContextCompat.getDrawable(title.getContext(), R.drawable.nad_tag_icon);
                    float dimension = title.getResources().getDimension(R.dimen.nad_dimen_100dp);
                    Resources resources = title.getResources();
                    wk0 a2 = al0.a();
                    Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
                    float dimension2 = resources.getDimension(a2.n());
                    Intrinsics.checkNotNull(drawable);
                    float intrinsicHeight = dimension2 / drawable.getIntrinsicHeight();
                    gn0 gn0Var3 = this.j;
                    if (gn0Var3 != null && (m = gn0Var3.m()) != null) {
                        str2 = m.b();
                    } else {
                        str2 = null;
                    }
                    if (str2 != null && str2.length() != 0) {
                        z4 = false;
                    }
                    if (z4) {
                        gn0 gn0Var4 = this.j;
                        if (gn0Var4 != null && (an0Var2 = gn0Var4.f) != null) {
                            str4 = an0Var2.g;
                        }
                        charSequence = d91.b(str4, 2, getTitle(), title.getContext(), drawable, (int) dimension, intrinsicHeight);
                    } else {
                        gn0 gn0Var5 = this.j;
                        if (gn0Var5 != null && (an0Var = gn0Var5.f) != null) {
                            str4 = an0Var.g;
                        }
                        charSequence = str4;
                    }
                    title.setText(charSequence);
                }
                title.setOnClickListener(new g());
            }
        }
        z = false;
        if (!z) {
        }
        gn0Var = this.j;
        String str42 = null;
        if (gn0Var == null) {
        }
        str = null;
        if (str == null) {
        }
        z2 = true;
        if (!z2) {
        }
        title.setOnClickListener(new g());
    }

    public final void j() {
        String str;
        boolean z;
        Object obj;
        sm0 sm0Var;
        String str2;
        wm0 wm0Var;
        an0 an0Var;
        wm0 wm0Var2;
        gn0 gn0Var;
        wm0 wm0Var3;
        sm0 sm0Var2;
        pn0 c2;
        wm0 wm0Var4;
        zd0 zd0Var = this.i;
        if (zd0Var != null) {
            zd0Var.k();
        }
        String str3 = null;
        this.i = null;
        NadMiniVideoDownloadView downloadBtn = getDownloadBtn();
        Resources resources = downloadBtn.getResources();
        wk0 a2 = al0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        float dimension = resources.getDimension(a2.i());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gn0 gn0Var2 = this.j;
        if (gn0Var2 != null && (wm0Var4 = gn0Var2.m) != null) {
            str = wm0Var4.r;
        } else {
            str = null;
        }
        gradientDrawable.setColor(p11.a(str, R.color.nad_reward_image_style_btn_color));
        gradientDrawable.setCornerRadius(dimension);
        Unit unit = Unit.INSTANCE;
        downloadBtn.setBackground(gradientDrawable);
        downloadBtn.setTextColor(ContextCompat.getColor(downloadBtn.getContext(), R.color.nad_reward_image_btn_text_color));
        downloadBtn.setProgressColor(ContextCompat.getColor(downloadBtn.getContext(), R.color.nad_reward_image_btn_download_progress));
        gn0 gn0Var3 = this.j;
        if (gn0Var3 != null && (c2 = gn0Var3.c()) != null) {
            z = c2.e();
        } else {
            z = false;
        }
        downloadBtn.setIconArrowSwitch(z);
        gn0 gn0Var4 = this.j;
        boolean z2 = true;
        if ((gn0Var4 == null || !gn0Var4.p() || (gn0Var = this.j) == null || (wm0Var3 = gn0Var.m) == null || (sm0Var2 = wm0Var3.p) == null || !sm0Var2.e) ? false : false) {
            downloadBtn.setVisibility(0);
            obj = downloadBtn;
        } else {
            downloadBtn.setVisibility(8);
            obj = null;
        }
        if (obj != null) {
            gn0 gn0Var5 = this.j;
            if (gn0Var5 != null && (wm0Var2 = gn0Var5.m) != null) {
                sm0Var = wm0Var2.p;
            } else {
                sm0Var = null;
            }
            gn0 gn0Var6 = this.j;
            if (gn0Var6 != null && (an0Var = gn0Var6.f) != null) {
                str2 = an0Var.d;
            } else {
                str2 = null;
            }
            gn0 gn0Var7 = this.j;
            if (gn0Var7 != null && (wm0Var = gn0Var7.m) != null) {
                str3 = wm0Var.t;
            }
            vg0 d2 = vg0.d(sm0Var, str2, str3);
            Intrinsics.checkNotNullExpressionValue(d2, "AdDownloadBean.from(adMo….enhanceModel?.btnScheme)");
            d2.q.a = ClogBuilder.Page.WELFAREIMAGELP.type;
            this.i = new zd0(d2, getDownloadBtn());
        }
        downloadBtn.setOnClickListener(new e());
    }

    public final void k() {
        sn0 sn0Var;
        String str;
        rn0 e2;
        List<sn0> c2;
        FrameLayout imageContainer = getImageContainer();
        ViewGroup.LayoutParams layoutParams = imageContainer.getLayoutParams();
        layoutParams.height = (t11.c.e(imageContainer.getContext()) * 9) / 16;
        imageContainer.setLayoutParams(layoutParams);
        imageContainer.setOnClickListener(new f());
        gn0 gn0Var = this.j;
        String str2 = null;
        if (gn0Var != null && (e2 = gn0Var.e()) != null && (c2 = e2.c()) != null) {
            sn0Var = c2.get(0);
        } else {
            sn0Var = null;
        }
        AdImageView imageBg = getImageBg();
        if (sn0Var != null) {
            str = sn0Var.a();
        } else {
            str = null;
        }
        imageBg.b(str, 90, 5);
        AdImageView image = getImage();
        if (sn0Var != null) {
            str2 = sn0Var.a();
        }
        image.r(str2);
    }
}

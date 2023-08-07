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
import com.baidu.tieba.cr0;
import com.baidu.tieba.d61;
import com.baidu.tieba.el0;
import com.baidu.tieba.fn0;
import com.baidu.tieba.fp0;
import com.baidu.tieba.gr0;
import com.baidu.tieba.h61;
import com.baidu.tieba.ii0;
import com.baidu.tieba.jp0;
import com.baidu.tieba.ki0;
import com.baidu.tieba.lr0;
import com.baidu.tieba.mr0;
import com.baidu.tieba.oh0;
import com.baidu.tieba.q31;
import com.baidu.tieba.r31;
import com.baidu.tieba.ud1;
import com.baidu.tieba.vr0;
import com.baidu.tieba.xr0;
import com.baidu.tieba.yq0;
import com.baidu.tieba.yr0;
import com.baidu.tieba.zm0;
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
    public ii0 i;
    public mr0 j;
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
    public static final class a extends fn0<oh0> {
        public a(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fn0
        public void onEvent(oh0 event) {
            List<MonitorUrl> list;
            Intrinsics.checkNotNullParameter(event, "event");
            mr0 mr0Var = NadRewardImageView.this.j;
            if ((mr0Var != null && !mr0Var.p()) || event.a == null) {
                return;
            }
            if (NadRewardImageView.this.getDownloadBtn().getDownloadStatus() != AdDownloadStatus.DOWNLOADING) {
                NadRewardImageView.this.getDownloadBtn().performClick();
            }
            mr0 mr0Var2 = NadRewardImageView.this.j;
            if (mr0Var2 != null) {
                list = mr0Var2.e;
            } else {
                list = null;
            }
            ki0.b(list);
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
            ii0 ii0Var = NadRewardImageView.this.i;
            if (ii0Var != null) {
                ii0Var.l();
            }
            mr0 mr0Var = NadRewardImageView.this.j;
            if (mr0Var != null) {
                list = mr0Var.e;
            } else {
                list = null;
            }
            ki0.b(list);
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
                View findViewById = NadRewardImageView.this.findViewById(R.id.obfuscated_res_0x7f090316);
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
                View findViewById = NadRewardImageView.this.findViewById(R.id.obfuscated_res_0x7f09255a);
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
                View findViewById = NadRewardImageView.this.findViewById(R.id.obfuscated_res_0x7f09107a);
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
        fp0 a2 = jp0.a();
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

    public final void setData(mr0 mr0Var) {
        this.j = mr0Var;
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
        List<MonitorUrl> list;
        boolean z;
        gr0 gr0Var;
        ClogBuilder u = new ClogBuilder().j(str).y(ClogBuilder.LogType.CLICK).u(ClogBuilder.Page.WELFAREIMAGELP);
        mr0 mr0Var = this.j;
        if (mr0Var != null && (gr0Var = mr0Var.f) != null) {
            str2 = gr0Var.d;
        } else {
            str2 = null;
        }
        q31.e(u.p(str2));
        mr0 mr0Var2 = this.j;
        if (mr0Var2 != null && (list = mr0Var2.e) != null) {
            ArrayList<MonitorUrl> arrayList = new ArrayList();
            for (Object obj : list) {
                String str3 = ((MonitorUrl) obj).clickUrl;
                if (str3 != null && !StringsKt__StringsJVMKt.isBlank(str3)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    arrayList.add(obj);
                }
            }
            for (MonitorUrl monitorUrl : arrayList) {
                r31.b(monitorUrl.clickUrl);
            }
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
            zm0.b.c(activity, this.l, new a(oh0.class));
        }
    }

    public final void g() {
        String str;
        gr0 gr0Var;
        AdImageView avatar = getAvatar();
        mr0 mr0Var = this.j;
        if (mr0Var != null && (gr0Var = mr0Var.f) != null) {
            str = gr0Var.f;
        } else {
            str = null;
        }
        avatar.b(str);
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
        gr0 gr0Var;
        gr0 gr0Var2;
        String str2;
        boolean z;
        UnifyTextView brandName = getBrandName();
        mr0 mr0Var = this.j;
        boolean z2 = true;
        if (mr0Var != null && (gr0Var2 = mr0Var.f) != null && (str2 = gr0Var2.e) != null) {
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
        mr0 mr0Var2 = this.j;
        if (mr0Var2 != null && (gr0Var = mr0Var2.f) != null) {
            str = gr0Var.e;
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
        cr0 cr0Var;
        cr0 cr0Var2;
        cr0 cr0Var3;
        cr0 cr0Var4;
        TextView detailBtn = getDetailBtn();
        Resources resources = detailBtn.getResources();
        fp0 a2 = jp0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        float dimension = resources.getDimension(a2.h());
        GradientDrawable gradientDrawable = new GradientDrawable();
        mr0 mr0Var = this.j;
        String str4 = null;
        if (mr0Var != null && (cr0Var4 = mr0Var.m) != null) {
            str = cr0Var4.r;
        } else {
            str = null;
        }
        gradientDrawable.setColor(d61.a(str, R.color.nad_reward_image_style_btn_color));
        gradientDrawable.setCornerRadius(dimension);
        Unit unit = Unit.INSTANCE;
        detailBtn.setBackground(gradientDrawable);
        mr0 mr0Var2 = this.j;
        boolean z2 = false;
        if (mr0Var2 != null && mr0Var2.o()) {
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
        mr0 mr0Var3 = this.j;
        if (mr0Var3 != null && (cr0Var3 = mr0Var3.m) != null && cr0Var3.g) {
            str3 = detailBtn.getContext().getString(R.string.nad_reward_detail_btn_open_app);
        } else {
            mr0 mr0Var4 = this.j;
            if (mr0Var4 != null && (cr0Var2 = mr0Var4.m) != null) {
                str2 = cr0Var2.b;
            } else {
                str2 = null;
            }
            if (!((str2 == null || StringsKt__StringsJVMKt.isBlank(str2)) ? true : true)) {
                mr0 mr0Var5 = this.j;
                if (mr0Var5 != null && (cr0Var = mr0Var5.m) != null) {
                    str4 = cr0Var.b;
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
        mr0 mr0Var;
        String str;
        boolean z2;
        String str2;
        CharSequence charSequence;
        gr0 gr0Var;
        gr0 gr0Var2;
        lr0 n;
        gr0 gr0Var3;
        gr0 gr0Var4;
        String str3;
        boolean z3;
        UnifyTextView title = getTitle();
        mr0 mr0Var2 = this.j;
        boolean z4 = true;
        if (mr0Var2 != null && (gr0Var4 = mr0Var2.f) != null && (str3 = gr0Var4.g) != null) {
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
                mr0Var = this.j;
                String str4 = null;
                if (mr0Var == null && (gr0Var3 = mr0Var.f) != null) {
                    str = gr0Var3.g;
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
                    fp0 a2 = jp0.a();
                    Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
                    float dimension2 = resources.getDimension(a2.m());
                    Intrinsics.checkNotNull(drawable);
                    float intrinsicHeight = dimension2 / drawable.getIntrinsicHeight();
                    mr0 mr0Var3 = this.j;
                    if (mr0Var3 != null && (n = mr0Var3.n()) != null) {
                        str2 = n.b();
                    } else {
                        str2 = null;
                    }
                    if (str2 != null && str2.length() != 0) {
                        z4 = false;
                    }
                    if (z4) {
                        mr0 mr0Var4 = this.j;
                        if (mr0Var4 != null && (gr0Var2 = mr0Var4.f) != null) {
                            str4 = gr0Var2.g;
                        }
                        charSequence = ud1.b(str4, 2, getTitle(), title.getContext(), drawable, (int) dimension, intrinsicHeight);
                    } else {
                        mr0 mr0Var5 = this.j;
                        if (mr0Var5 != null && (gr0Var = mr0Var5.f) != null) {
                            str4 = gr0Var.g;
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
        mr0Var = this.j;
        String str42 = null;
        if (mr0Var == null) {
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
        yq0 yq0Var;
        String str2;
        cr0 cr0Var;
        gr0 gr0Var;
        cr0 cr0Var2;
        mr0 mr0Var;
        cr0 cr0Var3;
        yq0 yq0Var2;
        vr0 c2;
        cr0 cr0Var4;
        ii0 ii0Var = this.i;
        if (ii0Var != null) {
            ii0Var.j();
        }
        String str3 = null;
        this.i = null;
        NadMiniVideoDownloadView downloadBtn = getDownloadBtn();
        Resources resources = downloadBtn.getResources();
        fp0 a2 = jp0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        float dimension = resources.getDimension(a2.h());
        GradientDrawable gradientDrawable = new GradientDrawable();
        mr0 mr0Var2 = this.j;
        if (mr0Var2 != null && (cr0Var4 = mr0Var2.m) != null) {
            str = cr0Var4.r;
        } else {
            str = null;
        }
        gradientDrawable.setColor(d61.a(str, R.color.nad_reward_image_style_btn_color));
        gradientDrawable.setCornerRadius(dimension);
        Unit unit = Unit.INSTANCE;
        downloadBtn.setBackground(gradientDrawable);
        downloadBtn.setTextColor(ContextCompat.getColor(downloadBtn.getContext(), R.color.nad_reward_image_btn_text_color));
        downloadBtn.setProgressColor(ContextCompat.getColor(downloadBtn.getContext(), R.color.nad_reward_image_btn_download_progress));
        mr0 mr0Var3 = this.j;
        if (mr0Var3 != null && (c2 = mr0Var3.c()) != null) {
            z = c2.f();
        } else {
            z = false;
        }
        downloadBtn.setIconArrowSwitch(z);
        mr0 mr0Var4 = this.j;
        boolean z2 = true;
        if ((mr0Var4 == null || !mr0Var4.p() || (mr0Var = this.j) == null || (cr0Var3 = mr0Var.m) == null || (yq0Var2 = cr0Var3.p) == null || !yq0Var2.e) ? false : false) {
            downloadBtn.setVisibility(0);
            obj = downloadBtn;
        } else {
            downloadBtn.setVisibility(8);
            obj = null;
        }
        if (obj != null) {
            mr0 mr0Var5 = this.j;
            if (mr0Var5 != null && (cr0Var2 = mr0Var5.m) != null) {
                yq0Var = cr0Var2.p;
            } else {
                yq0Var = null;
            }
            mr0 mr0Var6 = this.j;
            if (mr0Var6 != null && (gr0Var = mr0Var6.f) != null) {
                str2 = gr0Var.d;
            } else {
                str2 = null;
            }
            mr0 mr0Var7 = this.j;
            if (mr0Var7 != null && (cr0Var = mr0Var7.m) != null) {
                str3 = cr0Var.t;
            }
            el0 d2 = el0.d(yq0Var, str2, str3);
            Intrinsics.checkNotNullExpressionValue(d2, "AdDownloadBean.from(adMo….enhanceModel?.btnScheme)");
            d2.q.a = ClogBuilder.Page.WELFAREIMAGELP.type;
            this.i = new ii0(d2, getDownloadBtn());
        }
        downloadBtn.setOnClickListener(new e());
    }

    public final void k() {
        yr0 yr0Var;
        String str;
        xr0 e2;
        List<yr0> c2;
        FrameLayout imageContainer = getImageContainer();
        ViewGroup.LayoutParams layoutParams = imageContainer.getLayoutParams();
        layoutParams.height = (h61.c.e(imageContainer.getContext()) * 9) / 16;
        imageContainer.setLayoutParams(layoutParams);
        imageContainer.setOnClickListener(new f());
        mr0 mr0Var = this.j;
        String str2 = null;
        if (mr0Var != null && (e2 = mr0Var.e()) != null && (c2 = e2.c()) != null) {
            yr0Var = c2.get(0);
        } else {
            yr0Var = null;
        }
        AdImageView imageBg = getImageBg();
        if (yr0Var != null) {
            str = yr0Var.a();
        } else {
            str = null;
        }
        imageBg.a(str, 90, 5);
        AdImageView image = getImage();
        if (yr0Var != null) {
            str2 = yr0Var.a();
        }
        image.b(str2);
    }
}

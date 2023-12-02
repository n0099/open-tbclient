package com.baidu.nadcore.slidingtag;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.cyberplayer.sdk.statistics.UbcRemoteStat;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.bo0;
import com.baidu.tieba.ce0;
import com.baidu.tieba.ph0;
import com.baidu.tieba.uy0;
import com.baidu.tieba.vy0;
import com.baidu.tieba.w11;
import com.baidu.tieba.wg0;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.yy.gslbsdk.db.DelayTB;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u00104\u001a\u000203\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\b\b\u0002\u00107\u001a\u00020\b¢\u0006\u0004\b8\u00109J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u0015J\u000f\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001d\u0010\u0015J\u0019\u0010\u001e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001e\u0010\u0015J!\u0010\u001e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001e\u0010\u0013J!\u0010#\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R%\u0010-\u001a\n (*\u0004\u0018\u00010'0'8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R%\u00100\u001a\n (*\u0004\u0018\u00010'0'8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010*\u001a\u0004\b/\u0010,R\u0016\u00101\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102¨\u0006:"}, d2 = {"Lcom/baidu/nadcore/slidingtag/NadDownloadSlidingTagView;", "Lcom/baidu/tieba/ph0;", "Lcom/baidu/nadcore/slidingtag/NadSlidingTagBaseView;", "Landroid/view/ViewGroup;", "parent", "", UbcRemoteStat.BIND_SERVICE, "(Landroid/view/ViewGroup;)V", "", "getCurrentMeasuredWidth", "()I", "getNextMeasuredWidth", "getRealView", "()Lcom/baidu/nadcore/slidingtag/NadDownloadSlidingTagView;", "Lcom/baidu/nadcore/model/NadSlidingTagModel;", "model", "", DelayTB.DELAY, "innerStartDelay", "(Lcom/baidu/nadcore/model/NadSlidingTagModel;J)V", "setDownloadTextView", "(Lcom/baidu/nadcore/model/NadSlidingTagModel;)V", "setLinear", "maxWidthPx", "setMaxWidth", "(I)V", "setTextViewList", "setTvListMaxWidth", "()V", "start", "startDelay", "", "text", "Lcom/baidu/nadcore/download/model/AdDownloadBean;", "data", StickerDataChangeType.UPDATE, "(Ljava/lang/String;Lcom/baidu/nadcore/download/model/AdDownloadBean;)V", "downloadInitText", "Ljava/lang/String;", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "downloadTextPrefix$delegate", "Lkotlin/Lazy;", "getDownloadTextPrefix", "()Landroid/widget/TextView;", "downloadTextPrefix", "downloadTextView$delegate", "getDownloadTextView", "downloadTextView", "maxWidth", "I", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadDownloadSlidingTagView extends NadSlidingTagBaseView implements ph0<NadDownloadSlidingTagView> {
    public int q;
    public String r;
    public final Lazy s;
    public final Lazy t;

    @JvmOverloads
    public NadDownloadSlidingTagView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public NadDownloadSlidingTagView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final TextView getDownloadTextPrefix() {
        return (TextView) this.s.getValue();
    }

    private final TextView getDownloadTextView() {
        return (TextView) this.t.getValue();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ph0
    public NadDownloadSlidingTagView getRealView() {
        return this;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadDownloadSlidingTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        String string = getResources().getString(R.string.nad_download_start);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…tring.nad_download_start)");
        this.r = string;
        this.s = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.baidu.nadcore.slidingtag.NadDownloadSlidingTagView$downloadTextPrefix$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) NadDownloadSlidingTagView.this.findViewById(R.id.nad_sliding_download_text_prefix);
            }
        });
        this.t = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.baidu.nadcore.slidingtag.NadDownloadSlidingTagView$downloadTextView$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) NadDownloadSlidingTagView.this.findViewById(R.id.nad_sliding_download_text);
            }
        });
        LayoutInflater.from(context).inflate(R.layout.nad_download_sliding_tag_layout, (ViewGroup) this, true);
    }

    public /* synthetic */ NadDownloadSlidingTagView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setDownloadTextView(bo0 bo0Var) {
        String str;
        boolean z;
        bo0.b bVar = bo0Var.c;
        String str2 = null;
        if (bVar != null) {
            str = bVar.a;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            str = getResources().getString(R.string.nad_download_start);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(com.…tring.nad_download_start)");
        }
        this.r = str;
        bo0.c cVar = (bo0.c) CollectionsKt___CollectionsKt.getOrNull(bo0Var.a, 0);
        if (cVar != null) {
            str2 = cVar.c;
        }
        int f = ce0.f(str2, R.color.nad_sliding_tag_text_color_default);
        TextView downloadTextPrefix = getDownloadTextPrefix();
        downloadTextPrefix.setTextColor(f);
        downloadTextPrefix.setTextSize(0, getTextSizePx());
        downloadTextPrefix.setSingleLine();
        downloadTextPrefix.setEllipsize(TextUtils.TruncateAt.END);
        downloadTextPrefix.setIncludeFontPadding(false);
        downloadTextPrefix.setVisibility(0);
        TextView downloadTextView = getDownloadTextView();
        if (TextUtils.equals(downloadTextView.getText(), "")) {
            downloadTextView.setText(this.r);
        }
        downloadTextView.setTextColor(f);
        downloadTextView.setTextSize(0, getTextSizePx());
        downloadTextView.setSingleLine();
        downloadTextView.setEllipsize(TextUtils.TruncateAt.END);
        downloadTextView.setGravity(16);
        downloadTextView.setIncludeFontPadding(false);
        downloadTextView.setVisibility(0);
    }

    private final void setLinear(bo0 bo0Var) {
        LinearLayout linear = getLinear();
        int i = 0;
        if (!getTvList().isEmpty()) {
            if (getLinear().getChildAt(0) instanceof AdImageView) {
                linear.setPadding(w11.c.a(linear.getContext(), 5.0f), w11.c.a(linear.getContext(), 5.0f), w11.c.a(linear.getContext(), 5.0f), w11.c.a(linear.getContext(), 5.0f));
            } else {
                linear.setPadding(w11.c.a(linear.getContext(), 7.0f), w11.c.a(linear.getContext(), 8.0f), w11.c.a(linear.getContext(), 5.0f), w11.c.a(linear.getContext(), 8.0f));
            }
            linear.setGravity(16);
            TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(getTvList(), 0);
            if (textView != null) {
                s(textView);
                linear.addView(textView, r());
                setTextHeight(o(textView));
                Unit unit = Unit.INSTANCE;
            }
        } else {
            i = 8;
        }
        linear.setVisibility(i);
    }

    private final void setTextViewList(bo0 bo0Var) {
        for (bo0.c cVar : bo0Var.a) {
            TextView a = vy0.a(getContext(), cVar);
            if (a != null) {
                a.setTextSize(0, getTextSizePx());
                a.setLayoutParams(r());
                a.setPadding(0, 0, 0, 0);
                a.setMaxLines(1);
                a.setSingleLine();
                a.setEllipsize(TextUtils.TruncateAt.END);
                a.setGravity(16);
                a.setIncludeFontPadding(false);
                a.setVisibility(0);
                if (a != null) {
                    getTvList().add(a);
                }
            }
        }
        x();
    }

    @Override // com.baidu.tieba.ph0
    public void b(String str, wg0 data) {
        Intrinsics.checkNotNullParameter(data, "data");
        TextView downloadTextView = getDownloadTextView();
        if (downloadTextView != null) {
            AdDownloadStatus adDownloadStatus = data.c;
            if (adDownloadStatus != null) {
                int i = uy0.$EnumSwitchMapping$0[adDownloadStatus.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        str = getResources().getString(R.string.nad_downloading);
                    }
                } else {
                    str = this.r;
                }
            }
            downloadTextView.setText(str);
        }
        postInvalidate();
    }

    @Override // com.baidu.tieba.ph0
    public void c(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (!(parent instanceof RelativeLayout)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        parent.addView(this, layoutParams);
        parent.setVisibility(0);
    }

    @Override // com.baidu.nadcore.slidingtag.NadSlidingTagBaseView
    public void setMaxWidth(int i) {
        this.q = i;
    }

    @Override // com.baidu.nadcore.slidingtag.NadSlidingTagBaseView
    public int getCurrentMeasuredWidth() {
        int p;
        int a;
        TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(getTvList(), getCurrentIdx());
        if (textView == null) {
            setVisibility(8);
            return 0;
        }
        if (textView.getLayoutParams() == null) {
            textView.setLayoutParams(r());
        }
        if (getLinear().getChildAt(0) instanceof AdImageView) {
            int a2 = w11.c.a(getContext(), 5.0f) + getIconSizePx() + w11.c.a(getContext(), 5.0f) + p(textView) + w11.c.a(getContext(), 5.0f);
            TextView downloadTextPrefix = getDownloadTextPrefix();
            Intrinsics.checkNotNullExpressionValue(downloadTextPrefix, "downloadTextPrefix");
            int p2 = a2 + p(downloadTextPrefix) + w11.c.a(getContext(), 5.0f);
            TextView downloadTextView = getDownloadTextView();
            Intrinsics.checkNotNullExpressionValue(downloadTextView, "downloadTextView");
            p = p2 + p(downloadTextView);
            a = w11.c.a(getContext(), 9.0f);
        } else {
            int a3 = w11.c.a(getContext(), 7.0f) + p(textView) + w11.c.a(getContext(), 5.0f);
            TextView downloadTextPrefix2 = getDownloadTextPrefix();
            Intrinsics.checkNotNullExpressionValue(downloadTextPrefix2, "downloadTextPrefix");
            int p3 = a3 + p(downloadTextPrefix2) + w11.c.a(getContext(), 5.0f);
            TextView downloadTextView2 = getDownloadTextView();
            Intrinsics.checkNotNullExpressionValue(downloadTextView2, "downloadTextView");
            p = p3 + p(downloadTextView2);
            a = w11.c.a(getContext(), 9.0f);
        }
        int i = p + a;
        int i2 = this.q;
        if (i2 > 0) {
            i = RangesKt___RangesKt.coerceAtMost(i, i2);
        }
        getWidthMap().put(Integer.valueOf(getCurrentIdx()), Integer.valueOf(i));
        return i;
    }

    @Override // com.baidu.nadcore.slidingtag.NadSlidingTagBaseView
    public int getNextMeasuredWidth() {
        int p;
        int a;
        int nextIndex = getNextIndex();
        TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(getTvList(), nextIndex);
        if (textView == null) {
            setVisibility(8);
            return 0;
        }
        if (textView.getLayoutParams() == null) {
            textView.setLayoutParams(r());
        }
        if (getLinear().getChildAt(0) instanceof AdImageView) {
            int a2 = w11.c.a(getContext(), 5.0f) + getIconSizePx() + w11.c.a(getContext(), 5.0f) + p(textView) + w11.c.a(getContext(), 5.0f);
            TextView downloadTextPrefix = getDownloadTextPrefix();
            Intrinsics.checkNotNullExpressionValue(downloadTextPrefix, "downloadTextPrefix");
            int p2 = a2 + p(downloadTextPrefix) + w11.c.a(getContext(), 5.0f);
            TextView downloadTextView = getDownloadTextView();
            Intrinsics.checkNotNullExpressionValue(downloadTextView, "downloadTextView");
            p = p2 + p(downloadTextView);
            a = w11.c.a(getContext(), 9.0f);
        } else {
            int a3 = w11.c.a(getContext(), 7.0f) + p(textView) + w11.c.a(getContext(), 5.0f);
            TextView downloadTextPrefix2 = getDownloadTextPrefix();
            Intrinsics.checkNotNullExpressionValue(downloadTextPrefix2, "downloadTextPrefix");
            int p3 = a3 + p(downloadTextPrefix2) + w11.c.a(getContext(), 5.0f);
            TextView downloadTextView2 = getDownloadTextView();
            Intrinsics.checkNotNullExpressionValue(downloadTextView2, "downloadTextView");
            p = p3 + p(downloadTextView2);
            a = w11.c.a(getContext(), 9.0f);
        }
        int i = p + a;
        int i2 = this.q;
        if (i2 > 0) {
            i = RangesKt___RangesKt.coerceAtMost(i, i2);
        }
        getWidthMap().put(Integer.valueOf(nextIndex), Integer.valueOf(i));
        return i;
    }

    public final void x() {
        int a;
        int a2 = this.q - w11.c.a(getContext(), 9.0f);
        TextView downloadTextView = getDownloadTextView();
        Intrinsics.checkNotNullExpressionValue(downloadTextView, "downloadTextView");
        int p = (a2 - p(downloadTextView)) - w11.c.a(getContext(), 5.0f);
        TextView downloadTextPrefix = getDownloadTextPrefix();
        Intrinsics.checkNotNullExpressionValue(downloadTextPrefix, "downloadTextPrefix");
        int p2 = (p - p(downloadTextPrefix)) - w11.c.a(getContext(), 5.0f);
        if (getLinear().getChildAt(0) instanceof AdImageView) {
            a = getIconSizePx() + w11.c.a(getContext(), 5.0f) + w11.c.a(getContext(), 5.0f);
        } else {
            a = w11.c.a(getContext(), 7.0f);
        }
        int i = p2 - a;
        for (TextView textView : getTvList()) {
            textView.setMaxWidth(i);
        }
    }
}

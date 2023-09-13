package com.baidu.nadcore.slidingtag;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.ls0;
import com.baidu.tieba.m31;
import com.baidu.tieba.m61;
import com.baidu.tieba.o71;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yy.gslbsdk.db.DelayTB;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00100\u001a\u00020\u0002¢\u0006\u0004\b1\u00102J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0004J%\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010!\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0012H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0002H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b(\u0010)J\u0019\u0010*\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b*\u0010)J\u0019\u0010+\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b+\u0010)J!\u0010+\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b+\u0010\u0014R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010-¨\u00063"}, d2 = {"Lcom/baidu/nadcore/slidingtag/NadLabelSlidingTagView;", "Lcom/baidu/nadcore/slidingtag/NadSlidingTagBaseView;", "", "getCurrentMeasuredWidth", "()I", "getMaxItemWidth", "getNextMeasuredWidth", "Landroid/content/Context;", "context", "Lcom/baidu/nadcore/model/NadSlidingTagModel$TagItem;", "item", "Landroid/widget/TextView;", "getNormalTextView", "(Landroid/content/Context;Lcom/baidu/nadcore/model/NadSlidingTagModel$TagItem;)Landroid/widget/TextView;", "Lcom/baidu/nadcore/model/NadSlidingTagModel;", "model", "", DelayTB.DELAY, "", "innerStartDelay", "(Lcom/baidu/nadcore/model/NadSlidingTagModel;J)V", "", SpeedStatsUtils.IS_NIGHT_MODE, "textColor", "onNightModeChanged", "(ZLjava/lang/Integer;)V", "Lcom/baidu/nadcore/slidingtag/INadSlidingActionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lcom/baidu/nadcore/slidingtag/INadSlidingActionListener;)V", "iconSize", "", "textSize", "setFontSize", "(IF)V", "setLinear", "()V", "maxWidthPx", "setMaxWidth", "(I)V", "setTextViewList", "(Lcom/baidu/nadcore/model/NadSlidingTagModel;)V", "start", "startDelay", "maxItemWidth", "I", "Landroid/util/AttributeSet;", "attributeSet", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadLabelSlidingTagView extends NadSlidingTagBaseView {
    public int q;
    public int r;

    @JvmOverloads
    public NadLabelSlidingTagView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public NadLabelSlidingTagView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @Override // com.baidu.nadcore.slidingtag.NadSlidingTagBaseView
    public void setActionListener(m31 m31Var) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadLabelSlidingTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.nad_label_sliding_tag_layout, (ViewGroup) this, true);
        setYBiasWithoutIcon(0);
        setYBias(0);
    }

    public /* synthetic */ NadLabelSlidingTagView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setTextViewList(ls0 ls0Var) {
        for (ls0.c cVar : ls0Var.a) {
            TextView w = w(getContext(), cVar);
            if (w != null) {
                w.setTextSize(0, getTextSizePx());
                w.setLayoutParams(q());
                w.setPadding(0, 0, 0, 0);
                w.setMaxLines(1);
                w.setSingleLine();
                w.setEllipsize(TextUtils.TruncateAt.END);
                w.setGravity(17);
                int i = this.q;
                if (i > 0) {
                    w.setMaxWidth(i);
                }
                w.setVisibility(0);
                if (w != null) {
                    o71.f(w);
                    this.r = Math.max(this.r, w.getMeasuredWidth());
                    getTvList().add(w);
                }
            }
        }
    }

    @Override // com.baidu.nadcore.slidingtag.NadSlidingTagBaseView
    public int getCurrentMeasuredWidth() {
        TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(getTvList(), getCurrentIdx());
        if (textView == null) {
            setVisibility(8);
            return 0;
        }
        if (textView.getLayoutParams() == null) {
            textView.setLayoutParams(q());
        }
        int o = o(textView);
        int i = this.q;
        if (i > 0) {
            o = RangesKt___RangesKt.coerceAtMost(o, i);
        }
        getWidthMap().put(Integer.valueOf(getCurrentIdx()), Integer.valueOf(o));
        return o;
    }

    @Override // com.baidu.nadcore.slidingtag.NadSlidingTagBaseView
    public int getNextMeasuredWidth() {
        int nextIndex = getNextIndex();
        TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(getTvList(), nextIndex);
        if (textView == null) {
            setVisibility(8);
            return 0;
        }
        if (textView.getLayoutParams() == null) {
            textView.setLayoutParams(q());
        }
        int o = o(textView);
        int i = this.q;
        if (i > 0) {
            o = RangesKt___RangesKt.coerceAtMost(o, i);
        }
        getWidthMap().put(Integer.valueOf(nextIndex), Integer.valueOf(o));
        return o;
    }

    @Override // com.baidu.nadcore.slidingtag.NadSlidingTagBaseView
    public int getMaxItemWidth() {
        int i = this.r;
        if (i <= 0) {
            return this.q;
        }
        return i;
    }

    @Override // com.baidu.nadcore.slidingtag.NadSlidingTagBaseView
    public void setFontSize(int i, float f) {
        setTextSizePx(f);
        setTextHeight(f);
    }

    public final TextView w(Context context, ls0.c cVar) {
        if (cVar != null && !StringsKt__StringsJVMKt.isBlank(cVar.a)) {
            int a = m61.a(cVar.c, R.color.nad_sliding_tag_text_color_default);
            TextView textView = new TextView(context);
            textView.setText(cVar.a);
            textView.setTextColor(a);
            return textView;
        }
        return null;
    }

    @Override // com.baidu.nadcore.slidingtag.NadSlidingTagBaseView
    public void setMaxWidth(int i) {
        this.q = i;
    }
}

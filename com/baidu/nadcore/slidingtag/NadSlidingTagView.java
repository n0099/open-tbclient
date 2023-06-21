package com.baidu.nadcore.slidingtag;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.c31;
import com.baidu.tieba.d31;
import com.baidu.tieba.d61;
import com.baidu.tieba.g31;
import com.baidu.tieba.ks0;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yy.gslbsdk.db.DelayTB;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002%&B'\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0004J!\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0011¢\u0006\u0004\b\u000f\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0014J\u0019\u0010\u0019\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0014J\u0019\u0010\u001a\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0014J!\u0010\u001a\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006'"}, d2 = {"Lcom/baidu/nadcore/slidingtag/NadSlidingTagView;", "Lcom/baidu/nadcore/slidingtag/NadSlidingTagBaseView;", "", "getCurrentMeasuredWidth", "()I", "getNextMeasuredWidth", "Lcom/baidu/nadcore/model/NadSlidingTagModel;", "model", "", DelayTB.DELAY, "", "innerStartDelay", "(Lcom/baidu/nadcore/model/NadSlidingTagModel;J)V", "Lcom/baidu/nadcore/slidingtag/INadSlidingActionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lcom/baidu/nadcore/slidingtag/INadSlidingActionListener;)V", "Lcom/baidu/nadcore/slidingtag/NadSlidingTagView$IOnActionListener;", "(Lcom/baidu/nadcore/slidingtag/NadSlidingTagView$IOnActionListener;)V", "setLinear", "(Lcom/baidu/nadcore/model/NadSlidingTagModel;)V", "maxWidthPx", "setMaxWidth", "(I)V", "setTextViewList", "start", "startDelay", "Lcom/baidu/nadcore/slidingtag/NadSlidingTagView$IOnActionListener;", "maxWidth", "I", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "IOnActionListener", "SimpleActionListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadSlidingTagView extends NadSlidingTagBaseView {
    public a p;
    public int q;

    /* loaded from: classes3.dex */
    public interface a {
        void a(Context context, String str, int i, String str2);
    }

    @JvmOverloads
    public NadSlidingTagView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public NadSlidingTagView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* loaded from: classes3.dex */
    public static final class b implements a {
        public final /* synthetic */ d31 a;

        public b(d31 d31Var) {
            this.a = d31Var;
        }

        @Override // com.baidu.nadcore.slidingtag.NadSlidingTagView.a
        public void a(Context context, String text, int i, String cmd) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            d31 d31Var = this.a;
            if (d31Var != null) {
                d31Var.a(new c31(context, text, i, cmd));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements View.OnClickListener {
        public final /* synthetic */ LinearLayout a;
        public final /* synthetic */ NadSlidingTagView b;
        public final /* synthetic */ ks0 c;

        public c(LinearLayout linearLayout, NadSlidingTagView nadSlidingTagView, ks0 ks0Var) {
            this.a = linearLayout;
            this.b = nadSlidingTagView;
            this.c = ks0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            CharSequence text;
            a aVar = this.b.p;
            if (aVar != null) {
                Context context = this.a.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(this.b.getTvList(), this.b.getCurrentIdx());
                aVar.a(context, (textView == null || (text = textView.getText()) == null || (r1 = text.toString()) == null) ? "" : "", this.b.getCurrentIdx(), this.c.g);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadSlidingTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.nad_sliding_tag_layout, (ViewGroup) this, true);
    }

    public /* synthetic */ NadSlidingTagView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setLinear(ks0 ks0Var) {
        LinearLayout linear = getLinear();
        int i = 0;
        if (!getTvList().isEmpty()) {
            if (getLinear().getChildAt(0) instanceof AdImageView) {
                linear.setPadding(d61.c.a(linear.getContext(), 5.0f), d61.c.a(linear.getContext(), 5.0f), d61.c.a(linear.getContext(), 7.0f), d61.c.a(linear.getContext(), 5.0f));
            } else {
                linear.setPadding(d61.c.a(linear.getContext(), 7.0f), d61.c.a(linear.getContext(), 8.0f), d61.c.a(linear.getContext(), 7.0f), d61.c.a(linear.getContext(), 8.0f));
            }
            linear.setGravity(16);
            TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(getTvList(), 0);
            if (textView != null) {
                s(textView);
                linear.addView(textView, r());
                setTextHeight(o(textView));
                Unit unit = Unit.INSTANCE;
            }
            linear.setOnClickListener(new c(linear, this, ks0Var));
        } else {
            i = 8;
        }
        linear.setVisibility(i);
    }

    private final void setTextViewList(ks0 ks0Var) {
        for (ks0.c cVar : ks0Var.a) {
            TextView a2 = g31.a(getContext(), cVar);
            if (a2 != null) {
                a2.setTextSize(0, getTextSizePx());
                a2.setLayoutParams(r());
                a2.setPadding(0, 0, 0, 0);
                a2.setMaxLines(1);
                a2.setSingleLine();
                a2.setEllipsize(TextUtils.TruncateAt.END);
                a2.setGravity(16);
                a2.setIncludeFontPadding(false);
                a2.setVisibility(0);
                if (a2 != null) {
                    getTvList().add(a2);
                }
            }
        }
    }

    public final void setActionListener(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.p = listener;
    }

    @Override // com.baidu.nadcore.slidingtag.NadSlidingTagBaseView
    public void setMaxWidth(int i) {
        this.q = i;
    }

    @Override // com.baidu.nadcore.slidingtag.NadSlidingTagBaseView
    public int getCurrentMeasuredWidth() {
        int a2;
        int a3;
        TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(getTvList(), getCurrentIdx());
        if (textView == null) {
            setVisibility(8);
            return 0;
        }
        if (textView.getLayoutParams() == null) {
            textView.setLayoutParams(r());
        }
        if (getLinear().getChildAt(0) instanceof AdImageView) {
            a2 = d61.c.a(getContext(), 5.0f) + getIconSizePx() + d61.c.a(getContext(), 5.0f) + p(textView);
            a3 = d61.c.a(getContext(), 7.0f);
        } else {
            a2 = d61.c.a(getContext(), 7.0f) + p(textView);
            a3 = d61.c.a(getContext(), 7.0f);
        }
        int i = a2 + a3;
        int i2 = this.q;
        if (i2 > 0) {
            i = RangesKt___RangesKt.coerceAtMost(i, i2);
        }
        getWidthMap().put(Integer.valueOf(getCurrentIdx()), Integer.valueOf(i));
        return i;
    }

    @Override // com.baidu.nadcore.slidingtag.NadSlidingTagBaseView
    public int getNextMeasuredWidth() {
        int a2;
        int a3;
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
            a2 = d61.c.a(getContext(), 5.0f) + getIconSizePx() + d61.c.a(getContext(), 5.0f) + p(textView);
            a3 = d61.c.a(getContext(), 7.0f);
        } else {
            a2 = d61.c.a(getContext(), 7.0f) + p(textView);
            a3 = d61.c.a(getContext(), 7.0f);
        }
        int i = a2 + a3;
        int i2 = this.q;
        if (i2 > 0) {
            i = RangesKt___RangesKt.coerceAtMost(i, i2);
        }
        getWidthMap().put(Integer.valueOf(nextIndex), Integer.valueOf(i));
        return i;
    }

    @Override // com.baidu.nadcore.slidingtag.NadSlidingTagBaseView
    public void setActionListener(d31 d31Var) {
        setActionListener(new b(d31Var));
    }
}

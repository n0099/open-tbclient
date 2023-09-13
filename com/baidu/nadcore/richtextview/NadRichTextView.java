package com.baidu.nadcore.richtextview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.cyberplayer.sdk.statistics.UbcRemoteStat;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.tieba.R;
import com.baidu.tieba.a31;
import com.baidu.tieba.b31;
import com.baidu.tieba.bm0;
import com.baidu.tieba.il0;
import com.baidu.tieba.q61;
import com.baidu.tieba.z21;
import com.baidu.tieba.zd1;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.bumptech.glide.load.engine.GlideException;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001AB'\b\u0007\u0012\u0006\u0010:\u001a\u000209\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;\u0012\b\b\u0002\u0010>\u001a\u00020=¢\u0006\u0004\b?\u0010@J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010\u001fR.\u00100\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010.8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006B"}, d2 = {"Lcom/baidu/nadcore/richtextview/NadRichTextView;", "Lcom/baidu/tieba/bm0;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/view/ViewGroup;", "parent", "", UbcRemoteStat.BIND_SERVICE, "(Landroid/view/ViewGroup;)V", "getRealView", "()Lcom/baidu/nadcore/richtextview/NadRichTextView;", "Lcom/baidu/nadcore/richtextview/NadRichTextView$ICustomizedProcessor;", "processor", "setCustomizedProcessor", "(Lcom/baidu/nadcore/richtextview/NadRichTextView$ICustomizedProcessor;)V", "Landroid/view/View$OnClickListener;", "titleListener", "linkListener", "setOnClickListener", "(Landroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;)V", "", "text", "Lcom/baidu/nadcore/download/model/AdDownloadBean;", "data", StickerDataChangeType.UPDATE, "(Ljava/lang/String;Lcom/baidu/nadcore/download/model/AdDownloadBean;)V", "", "updateText", "()Z", "customProcessor", "Lcom/baidu/nadcore/richtextview/NadRichTextView$ICustomizedProcessor;", "linkClickListener", "Landroid/view/View$OnClickListener;", "Landroid/graphics/drawable/Drawable;", "linkIcon", "Landroid/graphics/drawable/Drawable;", "getLinkIcon", "()Landroid/graphics/drawable/Drawable;", "setLinkIcon", "(Landroid/graphics/drawable/Drawable;)V", "linkText", "Ljava/lang/String;", "getLinkText", "()Ljava/lang/String;", "setLinkText", "(Ljava/lang/String;)V", "mainTextClickListener", "Lcom/baidu/nadcore/richtextview/NadRichTextParams;", "p", "params", "Lcom/baidu/nadcore/richtextview/NadRichTextParams;", "getParams", "()Lcom/baidu/nadcore/richtextview/NadRichTextParams;", "setParams", "(Lcom/baidu/nadcore/richtextview/NadRichTextParams;)V", "Landroid/text/SpannableStringBuilder;", "textSpanBuilder", "Landroid/text/SpannableStringBuilder;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ICustomizedProcessor", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadRichTextView extends AppCompatTextView implements bm0<NadRichTextView> {
    public a31 a;
    public String b;
    public Drawable c;
    public final SpannableStringBuilder d;
    public View.OnClickListener e;
    public View.OnClickListener f;
    public b g;

    /* loaded from: classes3.dex */
    public interface b {
        CharSequence a(CharSequence charSequence);
    }

    @JvmOverloads
    public NadRichTextView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public NadRichTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @Override // com.baidu.tieba.bm0
    public void c(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bm0
    public NadRichTextView getRealView() {
        return this;
    }

    /* loaded from: classes3.dex */
    public static final class a implements View.OnTouchListener {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            boolean z;
            if (motionEvent == null) {
                return false;
            }
            if (motionEvent.getAction() == 1) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float totalPaddingLeft = x - NadRichTextView.this.getTotalPaddingLeft();
                float totalPaddingTop = y - NadRichTextView.this.getTotalPaddingTop();
                float scrollX = totalPaddingLeft + NadRichTextView.this.getScrollX();
                float scrollY = totalPaddingTop + NadRichTextView.this.getScrollY();
                Layout layout = NadRichTextView.this.getLayout();
                if (layout != null) {
                    int lineForVertical = layout.getLineForVertical((int) scrollY);
                    Layout layout2 = NadRichTextView.this.getLayout();
                    if (layout2 != null) {
                        int offsetForHorizontal = layout2.getOffsetForHorizontal(lineForVertical, scrollX);
                        z21[] z21VarArr = (z21[]) NadRichTextView.this.d.getSpans(offsetForHorizontal, offsetForHorizontal, z21.class);
                        if (z21VarArr != null) {
                            if (z21VarArr.length == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                if (view2 != null) {
                                    z21VarArr[0].onClick(view2);
                                }
                            } else {
                                View.OnClickListener onClickListener = NadRichTextView.this.e;
                                if (onClickListener != null) {
                                    onClickListener.onClick(view2);
                                }
                            }
                        } else {
                            View.OnClickListener onClickListener2 = NadRichTextView.this.e;
                            if (onClickListener2 != null) {
                                onClickListener2.onClick(view2);
                            }
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends z21 {
        public c(a31 a31Var, int i, boolean z) {
            super(i, z);
        }

        @Override // com.baidu.tieba.z21, android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            View.OnClickListener onClickListener = NadRichTextView.this.f;
            if (onClickListener != null) {
                onClickListener.onClick(widget);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            CharSequence charSequence;
            NadRichTextView nadRichTextView = NadRichTextView.this;
            b bVar = nadRichTextView.g;
            if (bVar == null || (charSequence = bVar.a(NadRichTextView.this.d)) == null) {
                charSequence = NadRichTextView.this.d;
            }
            nadRichTextView.setText(charSequence);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadRichTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = "";
        this.d = new SpannableStringBuilder();
        setOnTouchListener(new a());
    }

    public /* synthetic */ NadRichTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setCustomizedProcessor(b bVar) {
        this.g = bVar;
    }

    public final void setLinkIcon(Drawable drawable) {
        this.c = drawable;
    }

    public final void setLinkText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public final Drawable getLinkIcon() {
        return this.c;
    }

    public final String getLinkText() {
        return this.b;
    }

    public final a31 getParams() {
        return this.a;
    }

    public final boolean i() {
        a31 a31Var = this.a;
        if (a31Var == null) {
            return false;
        }
        String str = new String(new char[]{21704});
        SpannableString spannableString = new SpannableString(str + this.b);
        if (this.c != null) {
            spannableString.setSpan(new zd1(new InsetDrawable(this.c, q61.c.a(getContext(), 3.3f), 0, q61.c.a(getContext(), 1.7f), 0), (int) getTextSize(), ((int) getTextSize()) - q61.c.a(getContext(), 1.7f)), 0, 1, 33);
        } else {
            spannableString = new SpannableString(this.b);
        }
        spannableString.setSpan(new c(a31Var, a31Var.e(), false), 0, spannableString.length(), 33);
        this.d.clear();
        int g = a31Var.g();
        float h = a31Var.h();
        float measureText = getPaint().measureText(spannableString.toString()) + q61.c.a(getContext(), 3.3f) + q61.c.a(getContext(), 1.7f);
        String f = a31Var.f();
        int i = (int) h;
        StaticLayout staticLayout = new StaticLayout(f + GlideException.IndentedAppendable.INDENT + ((Object) spannableString), getPaint(), i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        int lineCount = staticLayout.getLineCount();
        if (g < lineCount) {
            float f2 = 0.0f;
            int i2 = g - 1;
            for (int i3 = 0; i3 < i2; i3++) {
                f2 += staticLayout.getLineWidth(i3);
            }
            this.d.append(TextUtils.ellipsize(f, getPaint(), f2 + (h - measureText), TextUtils.TruncateAt.END));
        } else if (new StaticLayout(f, getPaint(), i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineCount() < lineCount) {
            this.d.append((CharSequence) f);
            this.d.append((CharSequence) "\n");
        } else {
            this.d.append((CharSequence) f);
        }
        if (a31Var.i()) {
            this.d.setSpan(new StyleSpan(1), 0, this.d.length(), 33);
        } else {
            this.d.setSpan(new StyleSpan(0), 0, this.d.length(), 33);
        }
        this.d.append((CharSequence) spannableString);
        this.d.append((CharSequence) " ");
        post(new d());
        return true;
    }

    public final void setOnClickListener(View.OnClickListener titleListener, View.OnClickListener linkListener) {
        Intrinsics.checkNotNullParameter(titleListener, "titleListener");
        Intrinsics.checkNotNullParameter(linkListener, "linkListener");
        this.e = titleListener;
        this.f = linkListener;
    }

    public final void setParams(a31 a31Var) {
        Drawable c2;
        if (a31Var != null) {
            this.b = a31Var.d();
            String type = a31Var.getType();
            int hashCode = type.hashCode();
            if (hashCode != 950394699) {
                if (hashCode == 1427818632 && type.equals("download")) {
                    c2 = a31Var.b();
                    this.c = c2;
                }
                c2 = null;
                this.c = c2;
            } else {
                if (type.equals("command")) {
                    c2 = a31Var.c();
                    this.c = c2;
                }
                c2 = null;
                this.c = c2;
            }
        }
        this.a = a31Var;
    }

    @Override // com.baidu.tieba.bm0
    public void update(String text, il0 data) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(data, "data");
        AdDownloadStatus adDownloadStatus = data.c;
        if (adDownloadStatus != null) {
            int i = b31.$EnumSwitchMapping$0[adDownloadStatus.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    text = getResources().getString(R.string.nad_downloading);
                    Intrinsics.checkNotNullExpressionValue(text, "resources.getString(com.…R.string.nad_downloading)");
                }
            } else {
                text = getResources().getString(R.string.nad_download_start);
                Intrinsics.checkNotNullExpressionValue(text, "resources.getString(com.…tring.nad_download_start)");
            }
        }
        this.b = text;
        AdDownloadStatus adDownloadStatus2 = data.c;
        Drawable drawable = null;
        if (adDownloadStatus2 == null || b31.$EnumSwitchMapping$1[adDownloadStatus2.ordinal()] != 1) {
            a31 a31Var = this.a;
            if (a31Var != null) {
                drawable = a31Var.b();
            }
        } else {
            a31 a31Var2 = this.a;
            if (a31Var2 != null) {
                drawable = a31Var2.a();
            }
        }
        this.c = drawable;
        i();
    }
}

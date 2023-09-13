package com.baidu.searchbox.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.LineHeightSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.util.devices.DeviceUtil;
import java.util.HashMap;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001,B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b%\u0010&B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b%\u0010)B#\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\u0006\u0010*\u001a\u00020\u0004¢\u0006\u0004\b%\u0010+J\u001d\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0010J\u0017\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\n8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001dR\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001dR\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001dR\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001d¨\u0006-"}, d2 = {"Lcom/baidu/searchbox/ui/UnifyTextView;", "Landroid/widget/TextView;", "Landroid/content/Context;", "context", "", "id", "getDimensionPixelSize", "(Landroid/content/Context;I)I", "", "content", "", "hasEmoji", "(Ljava/lang/CharSequence;)Z", "bottomPadding", "", "setBottomPadding", "(I)V", "text", "Landroid/widget/TextView$BufferType;", "type", "setTextWithUnifiedPadding", "(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V", "topPadding", "setTopPadding", "topAndBottomCompatable", "(Ljava/lang/CharSequence;)V", "DEBUG", "Z", "DEFAULT_TOP_BOTTOM_PADDING", "I", "", "TAG", "Ljava/lang/String;", "mBottomBuffer", "mBottomPadding", "mTopBuffer", "mTopPadding", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ExcludeInnerPaddingSpan", "lib-spannable_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public class UnifyTextView extends TextView {
    public final boolean DEBUG;
    public int DEFAULT_TOP_BOTTOM_PADDING;
    public final String TAG;
    public HashMap _$_findViewCache;
    public int mBottomBuffer;
    public int mBottomPadding;
    public int mTopBuffer;
    public int mTopPadding;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view2 = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view2 == null) {
            View findViewById = findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ?\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/ui/UnifyTextView$ExcludeInnerPaddingSpan;", "Landroid/text/style/LineHeightSpan;", "", "text", "", "start", "end", "spanstartv", "lineHeight", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "", "chooseHeight", "(Ljava/lang/CharSequence;IIIILandroid/graphics/Paint$FontMetricsInt;)V", "BOTTOM_BUFFER", "I", "", "MEIZU_15", "Ljava/lang/String;", "TOP_BUFFER", "lineSpace", "mBottomPadding", "mTopPadding", "Landroid/widget/TextView;", "textView", "Landroid/widget/TextView;", "<init>", "(Landroid/widget/TextView;IIIII)V", "lib-spannable_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class ExcludeInnerPaddingSpan implements LineHeightSpan {
        public final int BOTTOM_BUFFER;
        public final String MEIZU_15;
        public final int TOP_BUFFER;
        public final int lineSpace;
        public final int mBottomPadding;
        public final int mTopPadding;
        public final TextView textView;

        public ExcludeInnerPaddingSpan(TextView textView, int i, int i2, int i3, int i4, int i5) {
            Intrinsics.checkNotNullParameter(textView, "textView");
            this.textView = textView;
            this.TOP_BUFFER = i;
            this.BOTTOM_BUFFER = i2;
            this.lineSpace = i3;
            this.mTopPadding = i4;
            this.mBottomPadding = i5;
            this.MEIZU_15 = "meizu_15_CN";
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence text, int i, int i2, int i3, int i4, Paint.FontMetricsInt fm) {
            CharSequence subSequence;
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(fm, "fm");
            int i5 = fm.descent - fm.ascent;
            if (i5 <= 0) {
                return;
            }
            int textSize = (int) this.textView.getTextSize();
            int round = Math.round(fm.descent * ((textSize * 1.0f) / i5));
            fm.descent = round;
            int i6 = round - textSize;
            fm.ascent = i6;
            fm.top = (i6 - this.TOP_BUFFER) - this.mTopPadding;
            String deviceName = DeviceUtil.BrandInfo.getDeviceName();
            int sDKLevel = DeviceUtil.OSInfo.getSDKLevel();
            int i7 = 0;
            try {
                if (text.length() == i2 && (subSequence = text.subSequence(i, i2)) != null && (StringsKt__StringsKt.contains$default(subSequence, 'y', false, 2, (Object) null) || StringsKt__StringsKt.contains$default(subSequence, 'g', false, 2, (Object) null))) {
                    i7 = this.BOTTOM_BUFFER;
                }
            } catch (Exception unused) {
            }
            if (TextUtils.equals(deviceName, this.MEIZU_15) && sDKLevel == 25 && i > 0) {
                fm.bottom = ((fm.descent + i7) + this.mBottomPadding) - this.lineSpace;
            } else {
                fm.bottom = fm.descent + i7 + this.mBottomPadding;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnifyTextView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final boolean hasEmoji(CharSequence charSequence) {
        return Pattern.compile("[🀀-🏿]|[🐀-\u1f7ff]|[☀-⟿]").matcher(charSequence).find();
    }

    public final void setBottomPadding(int i) {
        this.mBottomPadding = i;
    }

    public final void setTopPadding(int i) {
        this.mTopPadding = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnifyTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final int getDimensionPixelSize(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getDimensionPixelSize(i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"CustomViewStyleable"})
    public UnifyTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "UnifyTextView";
        this.DEFAULT_TOP_BOTTOM_PADDING = getDimensionPixelSize(context, com.baidu.tieba.R.dimen.obfuscated_res_0x7f0707e1);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.baidu.android.common.base.spannable.R.styleable.spannable_etextview);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "getContext().obtainStyle…able.spannable_etextview)");
        this.mTopPadding = obtainStyledAttributes.getDimensionPixelSize(1, this.DEFAULT_TOP_BOTTOM_PADDING);
        this.mBottomPadding = obtainStyledAttributes.getDimensionPixelSize(0, this.DEFAULT_TOP_BOTTOM_PADDING);
        obtainStyledAttributes.recycle();
    }

    private final void topAndBottomCompatable(CharSequence charSequence) {
        if (hasEmoji(charSequence)) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.mTopBuffer = Math.round(getDimensionPixelSize(context, com.baidu.tieba.R.dimen.obfuscated_res_0x7f0707e2) * 1.5f);
            if (this.DEBUG) {
                String str = this.TAG;
                Log.d(str, "has emoji, mTopBuffer: " + this.mTopBuffer);
            }
        } else {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            this.mTopBuffer = getDimensionPixelSize(context2, com.baidu.tieba.R.dimen.obfuscated_res_0x7f0707e2);
            if (this.DEBUG) {
                String str2 = this.TAG;
                Log.d(str2, "has no emoji, mTopBuffer: " + this.mTopBuffer);
            }
        }
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        this.mBottomBuffer = getDimensionPixelSize(context3, com.baidu.tieba.R.dimen.obfuscated_res_0x7f0707e0);
    }

    public final void setTextWithUnifiedPadding(CharSequence charSequence, TextView.BufferType bufferType) {
        SpannableStringBuilder spannableStringBuilder;
        if (charSequence == null) {
            return;
        }
        topAndBottomCompatable(charSequence);
        float lineSpacingExtra = getLineSpacingExtra();
        if (charSequence instanceof SpannableStringBuilder) {
            spannableStringBuilder = (SpannableStringBuilder) charSequence;
            spannableStringBuilder.setSpan(new ExcludeInnerPaddingSpan(this, this.mTopBuffer, this.mBottomBuffer, (int) lineSpacingExtra, this.mTopPadding, this.mBottomPadding), 0, charSequence.length(), 33);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(charSequence);
            spannableStringBuilder.setSpan(new ExcludeInnerPaddingSpan(this, this.mTopBuffer, this.mBottomBuffer, (int) lineSpacingExtra, this.mTopPadding, this.mBottomPadding), 0, charSequence.length(), 33);
        }
        setText(spannableStringBuilder, bufferType);
    }
}

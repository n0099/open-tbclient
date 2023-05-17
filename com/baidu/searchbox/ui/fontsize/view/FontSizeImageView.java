package com.baidu.searchbox.ui.fontsize.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeImageViewExtKt;
import com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u0014H\u0002J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001cH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/ui/fontsize/view/FontSizeImageView;", "Landroid/widget/ImageView;", "Lcom/baidu/searchbox/ui/fontsize/listener/IFontSizeViewListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mDefaultParams", "Lcom/baidu/searchbox/ui/fontsize/view/Params;", "mImageParams", "mIsResponseFontSize", "", "mResId", "mScaleParamsType", "mType", "isResponseFontSize", "onFontSizeChange", "", "setFontSizeType", "type", "setImageResource", "resId", "setIsResponseFontSize", "setScaledDrawableLayoutParams", "defaultParams", "Landroid/view/ViewGroup$LayoutParams;", "setScaledLayoutParams", "updateDrawableParams", "params", "updateImageDrawable", "updateParams", "Companion", "customs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class FontSizeImageView extends ImageView implements IFontSizeViewListener {
    public static final Companion Companion = new Companion(null);
    public static final int SCALE_PARAMS_TYPE_DEFAULT = -1;
    public static final int SCALE_PARAMS_TYPE_DRAWABLE = 1;
    public static final int SCALE_PARAMS_TYPE_NORMAL = 0;
    public Map<Integer, View> _$_findViewCache;
    public Params mDefaultParams;
    public Params mImageParams;
    public boolean mIsResponseFontSize;
    public int mResId;
    public int mScaleParamsType;
    public int mType;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FontSizeImageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FontSizeImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i));
        if (view2 == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view2;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/ui/fontsize/view/FontSizeImageView$Companion;", "", "()V", "SCALE_PARAMS_TYPE_DEFAULT", "", "SCALE_PARAMS_TYPE_DRAWABLE", "SCALE_PARAMS_TYPE_NORMAL", "customs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FontSizeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.mResId = -1;
        this.mIsResponseFontSize = true;
        this.mScaleParamsType = -1;
    }

    public /* synthetic */ FontSizeImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void updateDrawableParams(ViewGroup.LayoutParams layoutParams) {
        Params params;
        if (isResponseFontSize() && (params = this.mImageParams) != null) {
            Intrinsics.checkNotNull(params);
            Params params2 = this.mDefaultParams;
            if (params2 != null) {
                if (layoutParams.width > 0) {
                    layoutParams.width = params2.getWidth() + (FontSizeHelper.getScaledSize(this.mType, params.getWidth(), 2) - params.getWidth());
                }
                if (layoutParams.height > 0) {
                    layoutParams.height = params2.getHeight() + (FontSizeHelper.getScaledSize(this.mType, params.getHeight(), 2) - params.getHeight());
                }
            }
        }
        setLayoutParams(layoutParams);
    }

    private final void updateImageDrawable() {
        if (this.mResId != -1) {
            if (isResponseFontSize()) {
                Drawable drawableByResId = FontSizeHelper.getDrawableByResId(this.mResId);
                if (drawableByResId != null) {
                    if (this.mScaleParamsType != -1) {
                        this.mImageParams = new Params(drawableByResId.getIntrinsicWidth(), drawableByResId.getIntrinsicWidth());
                    }
                    FontSizeImageViewExtKt.setScaledImageDrawable$default(this, this.mType, drawableByResId, 0, 4, null);
                    return;
                }
                return;
            }
            setImageResource(this.mResId);
        }
    }

    private final void updateParams(ViewGroup.LayoutParams layoutParams) {
        Params params;
        if (isResponseFontSize() && (params = this.mDefaultParams) != null) {
            if (layoutParams.width > 0) {
                layoutParams.width = FontSizeHelper.getScaledSize(this.mType, params.getWidth(), 2);
            }
            if (layoutParams.height > 0) {
                layoutParams.height = FontSizeHelper.getScaledSize(this.mType, params.getHeight(), 2);
            }
        }
        setLayoutParams(layoutParams);
    }

    public void setFontSizeType(int i) {
        this.mType = i;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.mResId = i;
        if (isResponseFontSize()) {
            updateImageDrawable();
        } else {
            super.setImageResource(i);
        }
    }

    public void setIsResponseFontSize(boolean z) {
        this.mIsResponseFontSize = z;
    }

    public final void setScaledDrawableLayoutParams(ViewGroup.LayoutParams layoutParams) {
        this.mScaleParamsType = 1;
        if (layoutParams != null) {
            this.mDefaultParams = new Params(layoutParams.width, layoutParams.height);
            updateDrawableParams(layoutParams);
        }
    }

    public final void setScaledLayoutParams(ViewGroup.LayoutParams layoutParams) {
        this.mScaleParamsType = 0;
        if (layoutParams != null) {
            this.mDefaultParams = new Params(layoutParams.width, layoutParams.height);
            updateParams(layoutParams);
        }
    }

    public boolean isResponseFontSize() {
        return this.mIsResponseFontSize;
    }

    @Override // com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener
    public void onFontSizeChange() {
        int i = this.mScaleParamsType;
        if (i == -1) {
            updateImageDrawable();
        } else if (this.mDefaultParams != null) {
            if (i == 0) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams");
                updateParams(layoutParams);
            } else if (i == 1) {
                ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
                Intrinsics.checkNotNullExpressionValue(layoutParams2, "layoutParams");
                updateDrawableParams(layoutParams2);
            }
            updateImageDrawable();
        }
    }
}

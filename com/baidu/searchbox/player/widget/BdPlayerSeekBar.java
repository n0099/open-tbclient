package com.baidu.searchbox.player.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.player.callback.ISeekBarListener;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.widget.BdThumbSeekBarView;
import com.baidu.tieba.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001a\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0007H\u0016J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\u001cH\u0016J\b\u0010$\u001a\u00020\u001cH\u0016J \u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0007H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/baidu/searchbox/player/widget/BdPlayerSeekBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "durationView", "Lcom/baidu/searchbox/player/widget/BdPlayerProgressView;", "isSeeking", "", "progressView", "seekBarListener", "Lcom/baidu/searchbox/player/callback/ISeekBarListener;", "getSeekBarListener", "()Lcom/baidu/searchbox/player/callback/ISeekBarListener;", "setSeekBarListener", "(Lcom/baidu/searchbox/player/callback/ISeekBarListener;)V", "seekBarView", "Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView;", "getSeekBarView", "()Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView;", "setSeekBarView", "(Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView;)V", "getLayoutId", "inflate", "", "setBufferingPosition", "bufferingPos", "setDuration", "duration", "setPosition", CriusAttrConstants.POSITION, "switchToFull", "switchToHalf", "syncPos", "pos", "dur", "buffer", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class BdPlayerSeekBar extends FrameLayout {
    public Map<Integer, View> _$_findViewCache;
    public BdPlayerProgressView durationView;
    @JvmField
    public boolean isSeeking;
    public BdPlayerProgressView progressView;
    public ISeekBarListener seekBarListener;
    public BdThumbSeekBarView seekBarView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BdPlayerSeekBar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BdPlayerSeekBar(Context context, AttributeSet attributeSet) {
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

    public int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d0173;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BdPlayerSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        inflate();
    }

    public void syncPos(int i, int i2, int i3) {
        if (this.isSeeking) {
            return;
        }
        setPosition(i);
        setDuration(i2);
        setBufferingPosition(i3);
    }

    public /* synthetic */ BdPlayerSeekBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void inflate() {
        LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        this.progressView = (BdPlayerProgressView) findViewById(R.id.obfuscated_res_0x7f0916cb);
        this.durationView = (BdPlayerProgressView) findViewById(R.id.obfuscated_res_0x7f0916c5);
        BdThumbSeekBarView bdThumbSeekBarView = (BdThumbSeekBarView) findViewById(R.id.obfuscated_res_0x7f0916d7);
        this.seekBarView = bdThumbSeekBarView;
        if (bdThumbSeekBarView != null) {
            bdThumbSeekBarView.setOnSeekBarChangeListener(new BdThumbSeekBarView.OnBdSeekBarChangeListener() { // from class: com.baidu.searchbox.player.widget.BdPlayerSeekBar$inflate$1
                @Override // com.baidu.searchbox.player.widget.BdThumbSeekBarView.OnBdSeekBarChangeListener
                public void onStartTrackingTouch(BdThumbSeekBarView bdThumbSeekBarView2) {
                    BdPlayerSeekBar bdPlayerSeekBar = BdPlayerSeekBar.this;
                    bdPlayerSeekBar.isSeeking = true;
                    ISeekBarListener seekBarListener = bdPlayerSeekBar.getSeekBarListener();
                    if (seekBarListener != null) {
                        seekBarListener.onStartTrackingTouch(bdThumbSeekBarView2);
                    }
                }

                @Override // com.baidu.searchbox.player.widget.BdThumbSeekBarView.OnBdSeekBarChangeListener
                public void onStopTrackingTouch(BdThumbSeekBarView bdThumbSeekBarView2) {
                    BdPlayerSeekBar bdPlayerSeekBar = BdPlayerSeekBar.this;
                    bdPlayerSeekBar.isSeeking = false;
                    ISeekBarListener seekBarListener = bdPlayerSeekBar.getSeekBarListener();
                    if (seekBarListener != null) {
                        seekBarListener.onStopTrackingTouch(BdPlayerSeekBar.this.getSeekBarView());
                    }
                }

                @Override // com.baidu.searchbox.player.widget.BdThumbSeekBarView.OnBdSeekBarChangeListener
                public void onProgressChanged(BdThumbSeekBarView bdThumbSeekBarView2, int i, boolean z) {
                    BdPlayerSeekBar.this.setPosition(i);
                    ISeekBarListener seekBarListener = BdPlayerSeekBar.this.getSeekBarListener();
                    if (seekBarListener != null) {
                        seekBarListener.onProgressChanged(bdThumbSeekBarView2, i, z);
                    }
                }
            });
        }
    }

    public final ISeekBarListener getSeekBarListener() {
        return this.seekBarListener;
    }

    public final BdThumbSeekBarView getSeekBarView() {
        return this.seekBarView;
    }

    public void setBufferingPosition(int i) {
        BdThumbSeekBarView bdThumbSeekBarView = this.seekBarView;
        if (bdThumbSeekBarView != null) {
            bdThumbSeekBarView.setBufferingProgress(i);
        }
    }

    public void setDuration(int i) {
        BdPlayerProgressView bdPlayerProgressView;
        BdThumbSeekBarView bdThumbSeekBarView = this.seekBarView;
        if (bdThumbSeekBarView != null) {
            bdThumbSeekBarView.setMax(i);
        }
        if (this.durationView != null) {
            boolean z = false;
            String textWithSecond = BdPlayerUtils.getTextWithSecond(i, false);
            if (textWithSecond != null) {
                if (textWithSecond.length() == 0) {
                    z = true;
                }
                if (!(!z)) {
                    textWithSecond = null;
                }
                if (textWithSecond != null && (bdPlayerProgressView = this.durationView) != null) {
                    bdPlayerProgressView.setPositionText(textWithSecond);
                }
            }
        }
    }

    public void setPosition(int i) {
        BdThumbSeekBarView bdThumbSeekBarView = this.seekBarView;
        boolean z = false;
        if (bdThumbSeekBarView != null) {
            bdThumbSeekBarView.setProgress(i);
            if (bdThumbSeekBarView.getMax() >= 3600.0f) {
                z = true;
            }
        }
        String textWithSecond = BdPlayerUtils.getTextWithSecond(i, z);
        BdPlayerProgressView bdPlayerProgressView = this.progressView;
        if (bdPlayerProgressView == null || !(true ^ TextUtils.isEmpty(textWithSecond))) {
            bdPlayerProgressView = null;
        }
        if (bdPlayerProgressView != null) {
            bdPlayerProgressView.setPositionText(textWithSecond);
        }
    }

    public final void setSeekBarListener(ISeekBarListener iSeekBarListener) {
        this.seekBarListener = iSeekBarListener;
    }

    public final void setSeekBarView(BdThumbSeekBarView bdThumbSeekBarView) {
        this.seekBarView = bdThumbSeekBarView;
    }

    public void switchToFull() {
        ViewGroup.LayoutParams layoutParams;
        BdPlayerProgressView bdPlayerProgressView = this.progressView;
        if (bdPlayerProgressView != null) {
            bdPlayerProgressView.setTextSize(BdPlayerUtils.dp2px(this, 12.0f));
        }
        BdPlayerProgressView bdPlayerProgressView2 = this.durationView;
        if (bdPlayerProgressView2 != null) {
            bdPlayerProgressView2.setTextSize(BdPlayerUtils.dp2px(this, 12.0f));
        }
        BdThumbSeekBarView bdThumbSeekBarView = this.seekBarView;
        RelativeLayout.LayoutParams layoutParams2 = null;
        if (bdThumbSeekBarView != null) {
            layoutParams = bdThumbSeekBarView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        }
        if (layoutParams2 != null) {
            layoutParams2.leftMargin = BdPlayerUtils.dp2px(this, 3.0f);
            layoutParams2.rightMargin = BdPlayerUtils.dp2px(this, 1.0f);
            BdThumbSeekBarView bdThumbSeekBarView2 = this.seekBarView;
            if (bdThumbSeekBarView2 != null) {
                bdThumbSeekBarView2.setLayoutParams(layoutParams2);
            }
        }
    }

    public void switchToHalf() {
        ViewGroup.LayoutParams layoutParams;
        BdPlayerProgressView bdPlayerProgressView = this.progressView;
        if (bdPlayerProgressView != null) {
            bdPlayerProgressView.setTextSize(BdPlayerUtils.dp2px(this, 10.0f));
        }
        BdPlayerProgressView bdPlayerProgressView2 = this.durationView;
        if (bdPlayerProgressView2 != null) {
            bdPlayerProgressView2.setTextSize(BdPlayerUtils.dp2px(this, 10.0f));
        }
        BdThumbSeekBarView bdThumbSeekBarView = this.seekBarView;
        RelativeLayout.LayoutParams layoutParams2 = null;
        if (bdThumbSeekBarView != null) {
            layoutParams = bdThumbSeekBarView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        }
        if (layoutParams2 != null) {
            layoutParams2.leftMargin = BdPlayerUtils.dp2px(this, 3.0f);
            layoutParams2.rightMargin = BdPlayerUtils.dp2px(this, 3.0f);
            BdThumbSeekBarView bdThumbSeekBarView2 = this.seekBarView;
            if (bdThumbSeekBarView2 != null) {
                bdThumbSeekBarView2.setLayoutParams(layoutParams2);
            }
        }
    }
}

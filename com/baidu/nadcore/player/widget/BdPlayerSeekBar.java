package com.baidu.nadcore.player.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.baidu.nadcore.player.widget.BdThumbSeekBarView;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tieba.R;
import com.baidu.tieba.ex0;
import com.baidu.tieba.tq0;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u0010-\u001a\u00020\u0005¢\u0006\u0004\b.\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J'\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00060"}, d2 = {"Lcom/baidu/nadcore/player/widget/BdPlayerSeekBar;", "Landroid/widget/FrameLayout;", "", "inflate", "()V", "", "bufferingPos", "setBufferingPosition", "(I)V", "duration", "setDuration", CriusAttrConstants.POSITION, "setPosition", "switchToFull", "switchToHalf", "pos", "dur", "buffer", "syncPos", "(III)V", "Lcom/baidu/nadcore/player/widget/BdPlayerProgressView;", "durationView", "Lcom/baidu/nadcore/player/widget/BdPlayerProgressView;", "", "isSeeking", "Z", "progressView", "Lcom/baidu/nadcore/player/callback/ISeekBarListener;", "seekBarListener", "Lcom/baidu/nadcore/player/callback/ISeekBarListener;", "getSeekBarListener", "()Lcom/baidu/nadcore/player/callback/ISeekBarListener;", "setSeekBarListener", "(Lcom/baidu/nadcore/player/callback/ISeekBarListener;)V", "Lcom/baidu/nadcore/player/widget/BdThumbSeekBarView;", "seekBarView", "Lcom/baidu/nadcore/player/widget/BdThumbSeekBarView;", "getSeekBarView", "()Lcom/baidu/nadcore/player/widget/BdThumbSeekBarView;", "setSeekBarView", "(Lcom/baidu/nadcore/player/widget/BdThumbSeekBarView;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-widget"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public class BdPlayerSeekBar extends FrameLayout {
    public BdThumbSeekBarView a;
    public BdPlayerProgressView b;
    public BdPlayerProgressView c;
    public tq0 d;
    @JvmField
    public boolean e;

    @JvmOverloads
    public BdPlayerSeekBar(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public BdPlayerSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* loaded from: classes3.dex */
    public static final class a implements BdThumbSeekBarView.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.nadcore.player.widget.BdThumbSeekBarView.b
        public void a(BdThumbSeekBarView bdThumbSeekBarView) {
            BdPlayerSeekBar bdPlayerSeekBar = BdPlayerSeekBar.this;
            bdPlayerSeekBar.e = true;
            tq0 seekBarListener = bdPlayerSeekBar.getSeekBarListener();
            if (seekBarListener != null) {
                seekBarListener.a(bdThumbSeekBarView);
            }
        }

        @Override // com.baidu.nadcore.player.widget.BdThumbSeekBarView.b
        public void c(BdThumbSeekBarView bdThumbSeekBarView) {
            BdPlayerSeekBar bdPlayerSeekBar = BdPlayerSeekBar.this;
            bdPlayerSeekBar.e = false;
            tq0 seekBarListener = bdPlayerSeekBar.getSeekBarListener();
            if (seekBarListener != null) {
                seekBarListener.c(BdPlayerSeekBar.this.getSeekBarView());
            }
        }

        @Override // com.baidu.nadcore.player.widget.BdThumbSeekBarView.b
        public void b(BdThumbSeekBarView bdThumbSeekBarView, int i, boolean z) {
            BdPlayerSeekBar.this.setPosition(i);
            tq0 seekBarListener = BdPlayerSeekBar.this.getSeekBarListener();
            if (seekBarListener != null) {
                seekBarListener.b(bdThumbSeekBarView, i, z);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BdPlayerSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        a();
    }

    public /* synthetic */ BdPlayerSeekBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.nad_bdvideoplayer_seek_bar_view, this);
        this.b = (BdPlayerProgressView) findViewById(R.id.nad_main_progress_text);
        this.c = (BdPlayerProgressView) findViewById(R.id.nad_main_duration_text);
        BdThumbSeekBarView bdThumbSeekBarView = (BdThumbSeekBarView) findViewById(R.id.obfuscated_res_0x7f091717);
        this.a = bdThumbSeekBarView;
        if (bdThumbSeekBarView != null) {
            bdThumbSeekBarView.setOnSeekBarChangeListener(new a());
        }
    }

    public final tq0 getSeekBarListener() {
        return this.d;
    }

    public final BdThumbSeekBarView getSeekBarView() {
        return this.a;
    }

    public void setBufferingPosition(int i) {
        BdThumbSeekBarView bdThumbSeekBarView = this.a;
        if (bdThumbSeekBarView != null) {
            bdThumbSeekBarView.setBufferingProgress(i);
        }
    }

    public void setDuration(int i) {
        BdPlayerProgressView bdPlayerProgressView;
        BdThumbSeekBarView bdThumbSeekBarView = this.a;
        if (bdThumbSeekBarView != null) {
            bdThumbSeekBarView.setMax(i);
        }
        if (this.c != null) {
            boolean z = false;
            String b = ex0.b(i, false);
            if (b != null) {
                if (b.length() == 0) {
                    z = true;
                }
                if (!(!z)) {
                    b = null;
                }
                if (b != null && (bdPlayerProgressView = this.c) != null) {
                    bdPlayerProgressView.setPositionText(b);
                }
            }
        }
    }

    public void setPosition(int i) {
        BdThumbSeekBarView bdThumbSeekBarView = this.a;
        boolean z = false;
        if (bdThumbSeekBarView != null) {
            bdThumbSeekBarView.setProgress(i);
            if (bdThumbSeekBarView.getMax() >= 3600) {
                z = true;
            }
        }
        String b = ex0.b(i, z);
        BdPlayerProgressView bdPlayerProgressView = this.b;
        if (bdPlayerProgressView != null) {
            if (!(true ^ TextUtils.isEmpty(b))) {
                bdPlayerProgressView = null;
            }
            if (bdPlayerProgressView != null) {
                bdPlayerProgressView.setPositionText(b);
            }
        }
    }

    public final void setSeekBarListener(tq0 tq0Var) {
        this.d = tq0Var;
    }

    public final void setSeekBarView(BdThumbSeekBarView bdThumbSeekBarView) {
        this.a = bdThumbSeekBarView;
    }
}

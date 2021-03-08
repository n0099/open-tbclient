package a.a.a.a.r.b.e;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes4.dex */
public abstract class c extends LinearLayout {
    public c(Context context) {
        this(context, null);
    }

    public c(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public abstract void a(Activity activity, KsNativeAd ksNativeAd, KsNativeAd.AdInteractionListener adInteractionListener);
}

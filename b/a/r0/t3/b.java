package b.a.r0.t3;

import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface b {
    void addViewAtRow(int i2, @NonNull View view);

    @NonNull
    View getView();

    void removeAllViews();

    void setItemParams(int i2, int i3);
}

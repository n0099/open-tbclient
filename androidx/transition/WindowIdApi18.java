package androidx.transition;

import android.view.View;
import android.view.WindowId;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
@RequiresApi(18)
/* loaded from: classes.dex */
public class WindowIdApi18 implements WindowIdImpl {
    public final WindowId mWindowId;

    public WindowIdApi18(@NonNull View view2) {
        this.mWindowId = view2.getWindowId();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof WindowIdApi18) && ((WindowIdApi18) obj).mWindowId.equals(this.mWindowId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.mWindowId.hashCode();
    }
}

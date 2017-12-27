package android.support.v7.view.menu;

import android.support.annotation.RestrictTo;
import android.widget.ListView;
@RestrictTo
/* loaded from: classes2.dex */
public interface ShowableListMenu {
    void dismiss();

    ListView getListView();

    boolean isShowing();

    void show();
}

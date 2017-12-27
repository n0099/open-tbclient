package android.support.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ah extends ai {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    public static ah c(ViewGroup viewGroup) {
        return (ah) ai.Q(viewGroup);
    }

    public void add(View view) {
        this.vO.add(view);
    }

    public void remove(View view) {
        this.vO.remove(view);
    }
}

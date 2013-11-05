package android.support.v4.view;

import android.view.View;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements Comparator<View> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(View view, View view2) {
        bn bnVar = (bn) view.getLayoutParams();
        bn bnVar2 = (bn) view2.getLayoutParams();
        if (bnVar.f336a != bnVar2.f336a) {
            return bnVar.f336a ? 1 : -1;
        }
        return bnVar.e - bnVar2.e;
    }
}

package android.support.v4.print;

import android.content.Context;
import android.print.PrintAttributes;
/* loaded from: classes2.dex */
class b extends a {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.print.PrintHelperKitkat
    public PrintAttributes.Builder a(PrintAttributes printAttributes) {
        PrintAttributes.Builder a = super.a(printAttributes);
        if (printAttributes.getDuplexMode() != 0) {
            a.setDuplexMode(printAttributes.getDuplexMode());
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        super(context);
        this.Av = false;
    }
}

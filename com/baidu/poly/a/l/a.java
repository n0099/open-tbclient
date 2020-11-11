package com.baidu.poly.a.l;

import android.text.TextUtils;
import android.view.ViewGroup;
/* loaded from: classes6.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class RunnableC0310a implements Runnable {
        final /* synthetic */ c cds;

        RunnableC0310a(c cVar) {
            this.cds = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.cds);
        }
    }

    public static c a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, String str, long j) {
        if (viewGroup == null) {
            return null;
        }
        c cVar = new c(viewGroup.getContext());
        if (!TextUtils.isEmpty(str)) {
            cVar.setText(str);
        }
        a(viewGroup, layoutParams, cVar, j);
        return cVar;
    }

    private static void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, c cVar, long j) {
        if (cVar.getParent() instanceof ViewGroup) {
            ((ViewGroup) cVar.getParent()).removeView(cVar);
        }
        viewGroup.addView(cVar, layoutParams);
        cVar.setLoading(true);
        if (j != -1) {
            viewGroup.postDelayed(new RunnableC0310a(cVar), j);
        }
    }

    public static void a(c cVar) {
        if (cVar != null && (cVar.getParent() instanceof ViewGroup)) {
            ((ViewGroup) cVar.getParent()).removeView(cVar);
            cVar.setLoading(false);
        }
    }
}

package com.baidu.poly.a.k;

import android.text.TextUtils;
import android.view.ViewGroup;
/* loaded from: classes10.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class RunnableC0153a implements Runnable {
        final /* synthetic */ c aNq;

        RunnableC0153a(c cVar) {
            this.aNq = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.aNq);
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
            viewGroup.postDelayed(new RunnableC0153a(cVar), j);
        }
    }

    public static void a(c cVar) {
        if (cVar != null && (cVar.getParent() instanceof ViewGroup)) {
            ((ViewGroup) cVar.getParent()).removeView(cVar);
            cVar.setLoading(false);
        }
    }
}

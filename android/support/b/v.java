package android.support.b;

import android.support.b.z;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
class v {
    private static final String[] vb = new String[0];
    private static String LOG_TAG = "TransitionManager";
    private static z vc = new b();
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<z>>>> vd = new ThreadLocal<>();
    static ArrayList<ViewGroup> ve = new ArrayList<>();

    static ArrayMap<ViewGroup, ArrayList<z>> cV() {
        WeakReference<ArrayMap<ViewGroup, ArrayList<z>>> weakReference = vd.get();
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new ArrayMap());
            vd.set(weakReference);
        }
        return weakReference.get();
    }

    private static void a(ViewGroup viewGroup, z zVar) {
        if (zVar != null && viewGroup != null) {
            a aVar = new a(zVar, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    private static void b(ViewGroup viewGroup, z zVar) {
        ArrayList<z> arrayList = cV().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<z> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().L(viewGroup);
            }
        }
        if (zVar != null) {
            zVar.c(viewGroup, true);
        }
        m G = m.G(viewGroup);
        if (G != null) {
            G.exit();
        }
    }

    public static void c(ViewGroup viewGroup, z zVar) {
        if (!ve.contains(viewGroup) && ViewCompat.isLaidOut(viewGroup)) {
            ve.add(viewGroup);
            if (zVar == null) {
                zVar = vc;
            }
            z clone = zVar.clone();
            b(viewGroup, clone);
            m.a(viewGroup, null);
            a(viewGroup, clone);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
        ViewGroup uQ;
        z uS;

        a(z zVar, ViewGroup viewGroup) {
            this.uS = zVar;
            this.uQ = viewGroup;
        }

        private void cW() {
            this.uQ.getViewTreeObserver().removeOnPreDrawListener(this);
            this.uQ.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            cW();
            v.ve.remove(this.uQ);
            ArrayList<z> arrayList = v.cV().get(this.uQ);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<z> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().M(this.uQ);
                }
            }
            this.uS.u(true);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ArrayList<z> arrayList;
            ArrayList arrayList2;
            cW();
            v.ve.remove(this.uQ);
            final ArrayMap<ViewGroup, ArrayList<z>> cV = v.cV();
            ArrayList<z> arrayList3 = cV.get(this.uQ);
            if (arrayList3 == null) {
                ArrayList<z> arrayList4 = new ArrayList<>();
                cV.put(this.uQ, arrayList4);
                arrayList = arrayList4;
                arrayList2 = null;
            } else if (arrayList3.size() <= 0) {
                arrayList = arrayList3;
                arrayList2 = null;
            } else {
                arrayList = arrayList3;
                arrayList2 = new ArrayList(arrayList3);
            }
            arrayList.add(this.uS);
            this.uS.a(new z.d() { // from class: android.support.b.v.a.1
                @Override // android.support.b.z.d, android.support.b.z.c
                public void a(z zVar) {
                    ((ArrayList) cV.get(a.this.uQ)).remove(zVar);
                }
            });
            this.uS.c(this.uQ, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((z) it.next()).M(this.uQ);
                }
            }
            this.uS.b(this.uQ);
            return true;
        }
    }
}

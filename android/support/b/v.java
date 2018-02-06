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
    private static final String[] vc = new String[0];
    private static String LOG_TAG = "TransitionManager";
    private static z vd = new b();
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<z>>>> ve = new ThreadLocal<>();
    static ArrayList<ViewGroup> vf = new ArrayList<>();

    static ArrayMap<ViewGroup, ArrayList<z>> cV() {
        WeakReference<ArrayMap<ViewGroup, ArrayList<z>>> weakReference = ve.get();
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new ArrayMap());
            ve.set(weakReference);
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
        if (!vf.contains(viewGroup) && ViewCompat.isLaidOut(viewGroup)) {
            vf.add(viewGroup);
            if (zVar == null) {
                zVar = vd;
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
        ViewGroup uR;
        z uT;

        a(z zVar, ViewGroup viewGroup) {
            this.uT = zVar;
            this.uR = viewGroup;
        }

        private void cW() {
            this.uR.getViewTreeObserver().removeOnPreDrawListener(this);
            this.uR.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            cW();
            v.vf.remove(this.uR);
            ArrayList<z> arrayList = v.cV().get(this.uR);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<z> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().M(this.uR);
                }
            }
            this.uT.u(true);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ArrayList<z> arrayList;
            ArrayList arrayList2;
            cW();
            v.vf.remove(this.uR);
            final ArrayMap<ViewGroup, ArrayList<z>> cV = v.cV();
            ArrayList<z> arrayList3 = cV.get(this.uR);
            if (arrayList3 == null) {
                ArrayList<z> arrayList4 = new ArrayList<>();
                cV.put(this.uR, arrayList4);
                arrayList = arrayList4;
                arrayList2 = null;
            } else if (arrayList3.size() <= 0) {
                arrayList = arrayList3;
                arrayList2 = null;
            } else {
                arrayList = arrayList3;
                arrayList2 = new ArrayList(arrayList3);
            }
            arrayList.add(this.uT);
            this.uT.a(new z.d() { // from class: android.support.b.v.a.1
                @Override // android.support.b.z.d, android.support.b.z.c
                public void a(z zVar) {
                    ((ArrayList) cV.get(a.this.uR)).remove(zVar);
                }
            });
            this.uT.c(this.uR, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((z) it.next()).M(this.uR);
                }
            }
            this.uT.b(this.uR);
            return true;
        }
    }
}

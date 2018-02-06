package android.support.b;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
abstract class ao extends z {
    private static final String[] uz = {"android:visibility:visibility", "android:visibility:parent"};

    @Override // android.support.b.z
    public String[] getTransitionProperties() {
        return uz;
    }

    private void a(af afVar) {
        afVar.values.put("android:visibility:visibility", Integer.valueOf(afVar.view.getVisibility()));
        afVar.values.put("android:visibility:parent", afVar.view.getParent());
    }

    @Override // android.support.b.z
    public void captureStartValues(af afVar) {
        a(afVar);
    }

    @Override // android.support.b.z
    public void captureEndValues(af afVar) {
        a(afVar);
    }

    public boolean b(af afVar) {
        if (afVar == null) {
            return false;
        }
        return ((Integer) afVar.values.get("android:visibility:visibility")).intValue() == 0 && ((View) afVar.values.get("android:visibility:parent")) != null;
    }

    private a a(af afVar, af afVar2) {
        a aVar = new a();
        aVar.vV = false;
        aVar.vW = false;
        if (afVar != null) {
            aVar.vX = ((Integer) afVar.values.get("android:visibility:visibility")).intValue();
            aVar.vZ = (ViewGroup) afVar.values.get("android:visibility:parent");
        } else {
            aVar.vX = -1;
            aVar.vZ = null;
        }
        if (afVar2 != null) {
            aVar.vY = ((Integer) afVar2.values.get("android:visibility:visibility")).intValue();
            aVar.wa = (ViewGroup) afVar2.values.get("android:visibility:parent");
        } else {
            aVar.vY = -1;
            aVar.wa = null;
        }
        if (afVar != null && afVar2 != null) {
            if (aVar.vX == aVar.vY && aVar.vZ == aVar.wa) {
                return aVar;
            }
            if (aVar.vX != aVar.vY) {
                if (aVar.vX == 0) {
                    aVar.vW = false;
                    aVar.vV = true;
                } else if (aVar.vY == 0) {
                    aVar.vW = true;
                    aVar.vV = true;
                }
            } else if (aVar.vZ != aVar.wa) {
                if (aVar.wa == null) {
                    aVar.vW = false;
                    aVar.vV = true;
                } else if (aVar.vZ == null) {
                    aVar.vW = true;
                    aVar.vV = true;
                }
            }
        }
        if (afVar == null) {
            aVar.vW = true;
            aVar.vV = true;
        } else if (afVar2 == null) {
            aVar.vW = false;
            aVar.vV = true;
        }
        return aVar;
    }

    @Override // android.support.b.z
    public Animator createAnimator(ViewGroup viewGroup, af afVar, af afVar2) {
        boolean z = false;
        a a2 = a(afVar, afVar2);
        if (a2.vV) {
            if (this.vm.size() > 0 || this.vl.size() > 0) {
                View view = afVar != null ? afVar.view : null;
                View view2 = afVar2 != null ? afVar2.view : null;
                z = a(view, (long) (view != null ? view.getId() : -1)) || a(view2, (long) (view2 != null ? view2.getId() : -1));
            }
            if (z || a2.vZ != null || a2.wa != null) {
                if (a2.vW) {
                    return a(viewGroup, afVar, a2.vX, afVar2, a2.vY);
                }
                return b(viewGroup, afVar, a2.vX, afVar2, a2.vY);
            }
        }
        return null;
    }

    public Animator a(ViewGroup viewGroup, af afVar, int i, af afVar2, int i2) {
        return null;
    }

    public Animator b(ViewGroup viewGroup, af afVar, int i, af afVar2, int i2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        boolean vV;
        boolean vW;
        int vX;
        int vY;
        ViewGroup vZ;
        ViewGroup wa;

        a() {
        }
    }
}

package android.support.b;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
abstract class ao extends z {
    private static final String[] uy = {"android:visibility:visibility", "android:visibility:parent"};

    @Override // android.support.b.z
    public String[] getTransitionProperties() {
        return uy;
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
        aVar.vU = false;
        aVar.vV = false;
        if (afVar != null) {
            aVar.vW = ((Integer) afVar.values.get("android:visibility:visibility")).intValue();
            aVar.vY = (ViewGroup) afVar.values.get("android:visibility:parent");
        } else {
            aVar.vW = -1;
            aVar.vY = null;
        }
        if (afVar2 != null) {
            aVar.vX = ((Integer) afVar2.values.get("android:visibility:visibility")).intValue();
            aVar.vZ = (ViewGroup) afVar2.values.get("android:visibility:parent");
        } else {
            aVar.vX = -1;
            aVar.vZ = null;
        }
        if (afVar != null && afVar2 != null) {
            if (aVar.vW == aVar.vX && aVar.vY == aVar.vZ) {
                return aVar;
            }
            if (aVar.vW != aVar.vX) {
                if (aVar.vW == 0) {
                    aVar.vV = false;
                    aVar.vU = true;
                } else if (aVar.vX == 0) {
                    aVar.vV = true;
                    aVar.vU = true;
                }
            } else if (aVar.vY != aVar.vZ) {
                if (aVar.vZ == null) {
                    aVar.vV = false;
                    aVar.vU = true;
                } else if (aVar.vY == null) {
                    aVar.vV = true;
                    aVar.vU = true;
                }
            }
        }
        if (afVar == null) {
            aVar.vV = true;
            aVar.vU = true;
        } else if (afVar2 == null) {
            aVar.vV = false;
            aVar.vU = true;
        }
        return aVar;
    }

    @Override // android.support.b.z
    public Animator createAnimator(ViewGroup viewGroup, af afVar, af afVar2) {
        boolean z = false;
        a a2 = a(afVar, afVar2);
        if (a2.vU) {
            if (this.vl.size() > 0 || this.vk.size() > 0) {
                View view = afVar != null ? afVar.view : null;
                View view2 = afVar2 != null ? afVar2.view : null;
                z = a(view, (long) (view != null ? view.getId() : -1)) || a(view2, (long) (view2 != null ? view2.getId() : -1));
            }
            if (z || a2.vY != null || a2.vZ != null) {
                if (a2.vV) {
                    return a(viewGroup, afVar, a2.vW, afVar2, a2.vX);
                }
                return b(viewGroup, afVar, a2.vW, afVar2, a2.vX);
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
        boolean vU;
        boolean vV;
        int vW;
        int vX;
        ViewGroup vY;
        ViewGroup vZ;

        a() {
        }
    }
}

package android.support.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.support.b.z;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
class j extends ao {
    private static boolean DBG = false;
    private int uG;

    public j() {
        this(3);
    }

    public j(int i) {
        this.uG = i;
    }

    private Animator a(View view, float f, float f2, AnimatorListenerAdapter animatorListenerAdapter) {
        ObjectAnimator objectAnimator = null;
        if (f == f2) {
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationEnd(null);
            }
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view, "alpha", f, f2);
            if (DBG) {
                Log.d("Fade", "Created animator " + objectAnimator);
            }
            if (animatorListenerAdapter != null) {
                objectAnimator.addListener(animatorListenerAdapter);
            }
        }
        return objectAnimator;
    }

    private void a(af afVar) {
        int[] iArr = new int[2];
        afVar.view.getLocationOnScreen(iArr);
        afVar.values.put("android:fade:screenX", Integer.valueOf(iArr[0]));
        afVar.values.put("android:fade:screenY", Integer.valueOf(iArr[1]));
    }

    @Override // android.support.b.ao, android.support.b.z
    public void captureStartValues(af afVar) {
        super.captureStartValues(afVar);
        a(afVar);
    }

    @Override // android.support.b.ao
    public Animator a(ViewGroup viewGroup, af afVar, int i, af afVar2, int i2) {
        if ((this.uG & 1) != 1 || afVar2 == null) {
            return null;
        }
        final View view = afVar2.view;
        if (DBG) {
            Log.d("Fade", "Fade.onAppear: startView, startVis, endView, endVis = " + (afVar != null ? afVar.view : null) + ", " + i + ", " + view + ", " + i2);
        }
        view.setAlpha(0.0f);
        a(new z.d() { // from class: android.support.b.j.1
            boolean mCanceled = false;
            float uH;

            @Override // android.support.b.z.d, android.support.b.z.c
            public void a(z zVar) {
                if (!this.mCanceled) {
                    view.setAlpha(1.0f);
                }
            }

            @Override // android.support.b.z.d, android.support.b.z.c
            public void b(z zVar) {
                this.uH = view.getAlpha();
                view.setAlpha(1.0f);
            }

            @Override // android.support.b.z.d, android.support.b.z.c
            public void c(z zVar) {
                view.setAlpha(this.uH);
            }
        });
        return a(view, 0.0f, 1.0f, null);
    }

    @Override // android.support.b.ao
    public Animator b(final ViewGroup viewGroup, af afVar, int i, af afVar2, final int i2) {
        final View view;
        final View view2;
        View view3;
        if ((this.uG & 2) != 2) {
            return null;
        }
        final View view4 = afVar != null ? afVar.view : null;
        View view5 = afVar2 != null ? afVar2.view : null;
        if (DBG) {
            Log.d("Fade", "Fade.onDisappear: startView, startVis, endView, endVis = " + view4 + ", " + i + ", " + view5 + ", " + i2);
        }
        if (view5 == null || view5.getParent() == null) {
            if (view5 != null) {
                view = null;
                view2 = view5;
                view4 = view5;
            } else {
                if (view4 != null) {
                    if (view4.getParent() == null) {
                        view = null;
                        view2 = view4;
                    } else if ((view4.getParent() instanceof View) && view4.getParent().getParent() == null) {
                        int id = ((View) view4.getParent()).getId();
                        if (id == -1 || viewGroup.findViewById(id) == null || !this.vt) {
                            view3 = null;
                            view4 = null;
                        } else {
                            view3 = view4;
                        }
                        view = null;
                        view2 = view3;
                    }
                }
                view = null;
                view2 = null;
                view4 = null;
            }
        } else if (i2 == 4) {
            view = view5;
            view2 = null;
            view4 = view5;
        } else if (view4 == view5) {
            view = view5;
            view2 = null;
            view4 = view5;
        } else {
            view = null;
            view2 = view4;
        }
        if (view2 != null) {
            int intValue = ((Integer) afVar.values.get("android:fade:screenX")).intValue();
            int intValue2 = ((Integer) afVar.values.get("android:fade:screenY")).intValue();
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            ViewCompat.offsetLeftAndRight(view2, (intValue - iArr[0]) - view2.getLeft());
            ViewCompat.offsetTopAndBottom(view2, (intValue2 - iArr[1]) - view2.getTop());
            ah.c(viewGroup).add(view2);
            return a(view4, 1.0f, 0.0f, new AnimatorListenerAdapter() { // from class: android.support.b.j.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    view4.setAlpha(1.0f);
                    if (view != null) {
                        view.setVisibility(i2);
                    }
                    if (view2 != null) {
                        ah.c(viewGroup).remove(view2);
                    }
                }
            });
        } else if (view != null) {
            view.setVisibility(0);
            return a(view4, 1.0f, 0.0f, new AnimatorListenerAdapter() { // from class: android.support.b.j.3
                boolean mCanceled = false;
                float uH = -1.0f;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    this.mCanceled = true;
                    if (this.uH >= 0.0f) {
                        view4.setAlpha(this.uH);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mCanceled) {
                        view4.setAlpha(1.0f);
                    }
                    if (view != null && !this.mCanceled) {
                        view.setVisibility(i2);
                    }
                    if (view2 != null) {
                        ah.c(viewGroup).add(view2);
                    }
                }
            });
        } else {
            return null;
        }
    }
}

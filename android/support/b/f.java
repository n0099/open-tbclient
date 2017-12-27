package android.support.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.b.z;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import java.util.Map;
/* loaded from: classes2.dex */
class f extends z {
    private static final String[] uy = {"android:changeBounds:bounds", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static l uz = new l();
    int[] uA = new int[2];
    boolean uB = false;
    boolean uC = false;

    @Override // android.support.b.z
    public String[] getTransitionProperties() {
        return uy;
    }

    private void a(af afVar) {
        View view = afVar.view;
        afVar.values.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        afVar.values.put("android:changeBounds:parent", afVar.view.getParent());
        afVar.view.getLocationInWindow(this.uA);
        afVar.values.put("android:changeBounds:windowX", Integer.valueOf(this.uA[0]));
        afVar.values.put("android:changeBounds:windowY", Integer.valueOf(this.uA[1]));
    }

    @Override // android.support.b.z
    public void captureStartValues(af afVar) {
        a(afVar);
    }

    @Override // android.support.b.z
    public void captureEndValues(af afVar) {
        a(afVar);
    }

    @Override // android.support.b.z
    public Animator createAnimator(final ViewGroup viewGroup, af afVar, af afVar2) {
        int i;
        int i2;
        int i3;
        int i4;
        if (afVar == null || afVar2 == null) {
            return null;
        }
        Map<String, Object> map = afVar.values;
        Map<String, Object> map2 = afVar2.values;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        final View view = afVar2.view;
        boolean z = viewGroup2 == viewGroup3 || viewGroup2.getId() == viewGroup3.getId();
        if (!this.uC || z) {
            Rect rect = (Rect) afVar.values.get("android:changeBounds:bounds");
            Rect rect2 = (Rect) afVar2.values.get("android:changeBounds:bounds");
            int i5 = rect.left;
            int i6 = rect2.left;
            int i7 = rect.top;
            int i8 = rect2.top;
            int i9 = rect.right;
            int i10 = rect2.right;
            int i11 = rect.bottom;
            int i12 = rect2.bottom;
            int i13 = i9 - i5;
            int i14 = i11 - i7;
            int i15 = i10 - i6;
            int i16 = i12 - i8;
            int i17 = 0;
            if (i13 != 0 && i14 != 0 && i15 != 0 && i16 != 0) {
                if (i5 != i6) {
                    i17 = 1;
                }
                if (i7 != i8) {
                    i17++;
                }
                if (i9 != i10) {
                    i17++;
                }
                if (i11 != i12) {
                    i17++;
                }
            }
            if (i17 > 0) {
                if (!this.uB) {
                    PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[i17];
                    if (i5 != i6) {
                        view.setLeft(i5);
                    }
                    if (i7 != i8) {
                        view.setTop(i7);
                    }
                    if (i9 != i10) {
                        view.setRight(i9);
                    }
                    if (i11 != i12) {
                        view.setBottom(i11);
                    }
                    if (i5 == i6) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                        propertyValuesHolderArr[0] = PropertyValuesHolder.ofInt(CustomDialogData.POS_LEFT, i5, i6);
                    }
                    if (i7 != i8) {
                        i3 = i2 + 1;
                        propertyValuesHolderArr[i2] = PropertyValuesHolder.ofInt("top", i7, i8);
                    } else {
                        i3 = i2;
                    }
                    if (i9 != i10) {
                        i4 = i3 + 1;
                        propertyValuesHolderArr[i3] = PropertyValuesHolder.ofInt("right", i9, i10);
                    } else {
                        i4 = i3;
                    }
                    if (i11 != i12) {
                        int i18 = i4 + 1;
                        propertyValuesHolderArr[i4] = PropertyValuesHolder.ofInt("bottom", i11, i12);
                    }
                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr);
                    if (view.getParent() instanceof ViewGroup) {
                        ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                        a(new z.d() { // from class: android.support.b.f.1
                            boolean mCanceled = false;

                            @Override // android.support.b.z.d, android.support.b.z.c
                            public void a(z zVar) {
                                if (!this.mCanceled) {
                                }
                            }

                            @Override // android.support.b.z.d, android.support.b.z.c
                            public void b(z zVar) {
                            }

                            @Override // android.support.b.z.d, android.support.b.z.c
                            public void c(z zVar) {
                            }
                        });
                    }
                    return ofPropertyValuesHolder;
                }
                if (i13 != i15) {
                    view.setRight(Math.max(i13, i15) + i6);
                }
                if (i14 != i16) {
                    view.setBottom(Math.max(i14, i16) + i8);
                }
                if (i5 != i6) {
                    view.setTranslationX(i5 - i6);
                }
                if (i7 != i8) {
                    view.setTranslationY(i7 - i8);
                }
                float f = i6 - i5;
                float f2 = i8 - i7;
                int i19 = i15 - i13;
                int i20 = i16 - i14;
                int i21 = 0;
                if (f != 0.0f) {
                    i21 = 1;
                }
                if (f2 != 0.0f) {
                    i21++;
                }
                if (i19 != 0 || i20 != 0) {
                    i21++;
                }
                PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[i21];
                if (f == 0.0f) {
                    i = 0;
                } else {
                    i = 1;
                    propertyValuesHolderArr2[0] = PropertyValuesHolder.ofFloat("translationX", view.getTranslationX(), 0.0f);
                }
                if (f2 != 0.0f) {
                    int i22 = i + 1;
                    propertyValuesHolderArr2[i] = PropertyValuesHolder.ofFloat("translationY", view.getTranslationY(), 0.0f);
                }
                if (i19 != 0 || i20 != 0) {
                    new Rect(0, 0, i13, i14);
                    new Rect(0, 0, i15, i16);
                }
                ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr2);
                if (view.getParent() instanceof ViewGroup) {
                    ViewGroup viewGroup5 = (ViewGroup) view.getParent();
                    a(new z.d() { // from class: android.support.b.f.2
                        boolean mCanceled = false;

                        @Override // android.support.b.z.d, android.support.b.z.c
                        public void a(z zVar) {
                            if (!this.mCanceled) {
                            }
                        }

                        @Override // android.support.b.z.d, android.support.b.z.c
                        public void b(z zVar) {
                        }

                        @Override // android.support.b.z.d, android.support.b.z.c
                        public void c(z zVar) {
                        }
                    });
                }
                ofPropertyValuesHolder2.addListener(new AnimatorListenerAdapter() { // from class: android.support.b.f.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                    }
                });
                return ofPropertyValuesHolder2;
            }
        } else {
            int intValue = ((Integer) afVar.values.get("android:changeBounds:windowX")).intValue();
            int intValue2 = ((Integer) afVar.values.get("android:changeBounds:windowY")).intValue();
            int intValue3 = ((Integer) afVar2.values.get("android:changeBounds:windowX")).intValue();
            int intValue4 = ((Integer) afVar2.values.get("android:changeBounds:windowY")).intValue();
            if (intValue != intValue3 || intValue2 != intValue4) {
                viewGroup.getLocationInWindow(this.uA);
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                view.draw(new Canvas(createBitmap));
                final BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
                view.setVisibility(4);
                ai.Q(viewGroup).add(bitmapDrawable);
                ObjectAnimator ofObject = ObjectAnimator.ofObject(bitmapDrawable, "bounds", uz, new Rect(intValue - this.uA[0], intValue2 - this.uA[1], (intValue - this.uA[0]) + view.getWidth(), (intValue2 - this.uA[1]) + view.getHeight()), new Rect(intValue3 - this.uA[0], intValue4 - this.uA[1], (intValue3 - this.uA[0]) + view.getWidth(), (intValue4 - this.uA[1]) + view.getHeight()));
                ofObject.addListener(new AnimatorListenerAdapter() { // from class: android.support.b.f.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        ai.Q(viewGroup).remove(bitmapDrawable);
                        view.setVisibility(0);
                    }
                });
                return ofObject;
            }
        }
        return null;
    }
}

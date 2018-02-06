package android.support.v7.widget;

import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class DefaultItemAnimator extends SimpleItemAnimator {
    private ArrayList<RecyclerView.ViewHolder> Oc = new ArrayList<>();
    private ArrayList<RecyclerView.ViewHolder> Od = new ArrayList<>();
    private ArrayList<b> Oe = new ArrayList<>();
    private ArrayList<a> Of = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.ViewHolder>> Og = new ArrayList<>();
    ArrayList<ArrayList<b>> Oh = new ArrayList<>();
    ArrayList<ArrayList<a>> Oi = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> Oj = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> Ok = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> Ol = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> Om = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        public int OB;
        public int OC;
        public int OD;
        public int OE;
        public RecyclerView.ViewHolder OF;

        b(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
            this.OF = viewHolder;
            this.OB = i;
            this.OC = i2;
            this.OD = i3;
            this.OE = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        public RecyclerView.ViewHolder OA;
        public int OB;
        public int OC;
        public int OD;
        public int OE;
        public RecyclerView.ViewHolder Oz;

        private a(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.Oz = viewHolder;
            this.OA = viewHolder2;
        }

        a(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
            this(viewHolder, viewHolder2);
            this.OB = i;
            this.OC = i2;
            this.OD = i3;
            this.OE = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.Oz + ", newHolder=" + this.OA + ", fromX=" + this.OB + ", fromY=" + this.OC + ", toX=" + this.OD + ", toY=" + this.OE + '}';
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        boolean z = !this.Oc.isEmpty();
        boolean z2 = !this.Oe.isEmpty();
        boolean z3 = !this.Of.isEmpty();
        boolean z4 = !this.Od.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.ViewHolder> it = this.Oc.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            this.Oc.clear();
            if (z2) {
                final ArrayList<b> arrayList = new ArrayList<>();
                arrayList.addAll(this.Oe);
                this.Oh.add(arrayList);
                this.Oe.clear();
                Runnable runnable = new Runnable() { // from class: android.support.v7.widget.DefaultItemAnimator.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            b bVar = (b) it2.next();
                            DefaultItemAnimator.this.a(bVar.OF, bVar.OB, bVar.OC, bVar.OD, bVar.OE);
                        }
                        arrayList.clear();
                        DefaultItemAnimator.this.Oh.remove(arrayList);
                    }
                };
                if (z) {
                    ViewCompat.postOnAnimationDelayed(arrayList.get(0).OF.itemView, runnable, getRemoveDuration());
                } else {
                    runnable.run();
                }
            }
            if (z3) {
                final ArrayList<a> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.Of);
                this.Oi.add(arrayList2);
                this.Of.clear();
                Runnable runnable2 = new Runnable() { // from class: android.support.v7.widget.DefaultItemAnimator.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            DefaultItemAnimator.this.a((a) it2.next());
                        }
                        arrayList2.clear();
                        DefaultItemAnimator.this.Oi.remove(arrayList2);
                    }
                };
                if (z) {
                    ViewCompat.postOnAnimationDelayed(arrayList2.get(0).Oz.itemView, runnable2, getRemoveDuration());
                } else {
                    runnable2.run();
                }
            }
            if (z4) {
                final ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.Od);
                this.Og.add(arrayList3);
                this.Od.clear();
                Runnable runnable3 = new Runnable() { // from class: android.support.v7.widget.DefaultItemAnimator.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            DefaultItemAnimator.this.b((RecyclerView.ViewHolder) it2.next());
                        }
                        arrayList3.clear();
                        DefaultItemAnimator.this.Og.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    ViewCompat.postOnAnimationDelayed(arrayList3.get(0).itemView, runnable3, (z ? getRemoveDuration() : 0L) + Math.max(z2 ? getMoveDuration() : 0L, z3 ? getChangeDuration() : 0L));
                } else {
                    runnable3.run();
                }
            }
        }
    }

    @Override // android.support.v7.widget.SimpleItemAnimator
    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        c(viewHolder);
        this.Oc.add(viewHolder);
        return true;
    }

    private void a(final RecyclerView.ViewHolder viewHolder) {
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(viewHolder.itemView);
        this.Ol.add(viewHolder);
        animate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new c() { // from class: android.support.v7.widget.DefaultItemAnimator.4
            @Override // android.support.v7.widget.DefaultItemAnimator.c, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view) {
                DefaultItemAnimator.this.dispatchRemoveStarting(viewHolder);
            }

            @Override // android.support.v7.widget.DefaultItemAnimator.c, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                animate.setListener(null);
                ViewCompat.setAlpha(view, 1.0f);
                DefaultItemAnimator.this.dispatchRemoveFinished(viewHolder);
                DefaultItemAnimator.this.Ol.remove(viewHolder);
                DefaultItemAnimator.this.fV();
            }
        }).start();
    }

    @Override // android.support.v7.widget.SimpleItemAnimator
    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        c(viewHolder);
        ViewCompat.setAlpha(viewHolder.itemView, 0.0f);
        this.Od.add(viewHolder);
        return true;
    }

    void b(final RecyclerView.ViewHolder viewHolder) {
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(viewHolder.itemView);
        this.Oj.add(viewHolder);
        animate.alpha(1.0f).setDuration(getAddDuration()).setListener(new c() { // from class: android.support.v7.widget.DefaultItemAnimator.5
            @Override // android.support.v7.widget.DefaultItemAnimator.c, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view) {
                DefaultItemAnimator.this.dispatchAddStarting(viewHolder);
            }

            @Override // android.support.v7.widget.DefaultItemAnimator.c, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(View view) {
                ViewCompat.setAlpha(view, 1.0f);
            }

            @Override // android.support.v7.widget.DefaultItemAnimator.c, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                animate.setListener(null);
                DefaultItemAnimator.this.dispatchAddFinished(viewHolder);
                DefaultItemAnimator.this.Oj.remove(viewHolder);
                DefaultItemAnimator.this.fV();
            }
        }).start();
    }

    @Override // android.support.v7.widget.SimpleItemAnimator
    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.itemView;
        int translationX = (int) (i + ViewCompat.getTranslationX(viewHolder.itemView));
        int translationY = (int) (i2 + ViewCompat.getTranslationY(viewHolder.itemView));
        c(viewHolder);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        if (i5 != 0) {
            ViewCompat.setTranslationX(view, -i5);
        }
        if (i6 != 0) {
            ViewCompat.setTranslationY(view, -i6);
        }
        this.Oe.add(new b(viewHolder, translationX, translationY, i3, i4));
        return true;
    }

    void a(final RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.itemView;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            ViewCompat.animate(view).translationX(0.0f);
        }
        if (i6 != 0) {
            ViewCompat.animate(view).translationY(0.0f);
        }
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(view);
        this.Ok.add(viewHolder);
        animate.setDuration(getMoveDuration()).setListener(new c() { // from class: android.support.v7.widget.DefaultItemAnimator.6
            @Override // android.support.v7.widget.DefaultItemAnimator.c, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view2) {
                DefaultItemAnimator.this.dispatchMoveStarting(viewHolder);
            }

            @Override // android.support.v7.widget.DefaultItemAnimator.c, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(View view2) {
                if (i5 != 0) {
                    ViewCompat.setTranslationX(view2, 0.0f);
                }
                if (i6 != 0) {
                    ViewCompat.setTranslationY(view2, 0.0f);
                }
            }

            @Override // android.support.v7.widget.DefaultItemAnimator.c, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view2) {
                animate.setListener(null);
                DefaultItemAnimator.this.dispatchMoveFinished(viewHolder);
                DefaultItemAnimator.this.Ok.remove(viewHolder);
                DefaultItemAnimator.this.fV();
            }
        }).start();
    }

    @Override // android.support.v7.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        if (viewHolder == viewHolder2) {
            return animateMove(viewHolder, i, i2, i3, i4);
        }
        float translationX = ViewCompat.getTranslationX(viewHolder.itemView);
        float translationY = ViewCompat.getTranslationY(viewHolder.itemView);
        float alpha = ViewCompat.getAlpha(viewHolder.itemView);
        c(viewHolder);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        ViewCompat.setTranslationX(viewHolder.itemView, translationX);
        ViewCompat.setTranslationY(viewHolder.itemView, translationY);
        ViewCompat.setAlpha(viewHolder.itemView, alpha);
        if (viewHolder2 != null) {
            c(viewHolder2);
            ViewCompat.setTranslationX(viewHolder2.itemView, -i5);
            ViewCompat.setTranslationY(viewHolder2.itemView, -i6);
            ViewCompat.setAlpha(viewHolder2.itemView, 0.0f);
        }
        this.Of.add(new a(viewHolder, viewHolder2, i, i2, i3, i4));
        return true;
    }

    void a(final a aVar) {
        RecyclerView.ViewHolder viewHolder = aVar.Oz;
        View view = viewHolder == null ? null : viewHolder.itemView;
        RecyclerView.ViewHolder viewHolder2 = aVar.OA;
        final View view2 = viewHolder2 != null ? viewHolder2.itemView : null;
        if (view != null) {
            final ViewPropertyAnimatorCompat duration = ViewCompat.animate(view).setDuration(getChangeDuration());
            this.Om.add(aVar.Oz);
            duration.translationX(aVar.OD - aVar.OB);
            duration.translationY(aVar.OE - aVar.OC);
            duration.alpha(0.0f).setListener(new c() { // from class: android.support.v7.widget.DefaultItemAnimator.7
                @Override // android.support.v7.widget.DefaultItemAnimator.c, android.support.v4.view.ViewPropertyAnimatorListener
                public void onAnimationStart(View view3) {
                    DefaultItemAnimator.this.dispatchChangeStarting(aVar.Oz, true);
                }

                @Override // android.support.v7.widget.DefaultItemAnimator.c, android.support.v4.view.ViewPropertyAnimatorListener
                public void onAnimationEnd(View view3) {
                    duration.setListener(null);
                    ViewCompat.setAlpha(view3, 1.0f);
                    ViewCompat.setTranslationX(view3, 0.0f);
                    ViewCompat.setTranslationY(view3, 0.0f);
                    DefaultItemAnimator.this.dispatchChangeFinished(aVar.Oz, true);
                    DefaultItemAnimator.this.Om.remove(aVar.Oz);
                    DefaultItemAnimator.this.fV();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimatorCompat animate = ViewCompat.animate(view2);
            this.Om.add(aVar.OA);
            animate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new c() { // from class: android.support.v7.widget.DefaultItemAnimator.8
                @Override // android.support.v7.widget.DefaultItemAnimator.c, android.support.v4.view.ViewPropertyAnimatorListener
                public void onAnimationStart(View view3) {
                    DefaultItemAnimator.this.dispatchChangeStarting(aVar.OA, false);
                }

                @Override // android.support.v7.widget.DefaultItemAnimator.c, android.support.v4.view.ViewPropertyAnimatorListener
                public void onAnimationEnd(View view3) {
                    animate.setListener(null);
                    ViewCompat.setAlpha(view2, 1.0f);
                    ViewCompat.setTranslationX(view2, 0.0f);
                    ViewCompat.setTranslationY(view2, 0.0f);
                    DefaultItemAnimator.this.dispatchChangeFinished(aVar.OA, false);
                    DefaultItemAnimator.this.Om.remove(aVar.OA);
                    DefaultItemAnimator.this.fV();
                }
            }).start();
        }
    }

    private void a(List<a> list, RecyclerView.ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = list.get(size);
            if (a(aVar, viewHolder) && aVar.Oz == null && aVar.OA == null) {
                list.remove(aVar);
            }
        }
    }

    private void b(a aVar) {
        if (aVar.Oz != null) {
            a(aVar, aVar.Oz);
        }
        if (aVar.OA != null) {
            a(aVar, aVar.OA);
        }
    }

    private boolean a(a aVar, RecyclerView.ViewHolder viewHolder) {
        boolean z = false;
        if (aVar.OA == viewHolder) {
            aVar.OA = null;
        } else if (aVar.Oz != viewHolder) {
            return false;
        } else {
            aVar.Oz = null;
            z = true;
        }
        ViewCompat.setAlpha(viewHolder.itemView, 1.0f);
        ViewCompat.setTranslationX(viewHolder.itemView, 0.0f);
        ViewCompat.setTranslationY(viewHolder.itemView, 0.0f);
        dispatchChangeFinished(viewHolder, z);
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ViewCompat.animate(view).cancel();
        for (int size = this.Oe.size() - 1; size >= 0; size--) {
            if (this.Oe.get(size).OF == viewHolder) {
                ViewCompat.setTranslationY(view, 0.0f);
                ViewCompat.setTranslationX(view, 0.0f);
                dispatchMoveFinished(viewHolder);
                this.Oe.remove(size);
            }
        }
        a(this.Of, viewHolder);
        if (this.Oc.remove(viewHolder)) {
            ViewCompat.setAlpha(view, 1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.Od.remove(viewHolder)) {
            ViewCompat.setAlpha(view, 1.0f);
            dispatchAddFinished(viewHolder);
        }
        for (int size2 = this.Oi.size() - 1; size2 >= 0; size2--) {
            ArrayList<a> arrayList = this.Oi.get(size2);
            a(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.Oi.remove(size2);
            }
        }
        for (int size3 = this.Oh.size() - 1; size3 >= 0; size3--) {
            ArrayList<b> arrayList2 = this.Oh.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).OF != viewHolder) {
                    size4--;
                } else {
                    ViewCompat.setTranslationY(view, 0.0f);
                    ViewCompat.setTranslationX(view, 0.0f);
                    dispatchMoveFinished(viewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.Oh.remove(size3);
                    }
                }
            }
        }
        for (int size5 = this.Og.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.ViewHolder> arrayList3 = this.Og.get(size5);
            if (arrayList3.remove(viewHolder)) {
                ViewCompat.setAlpha(view, 1.0f);
                dispatchAddFinished(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.Og.remove(size5);
                }
            }
        }
        if (this.Ol.remove(viewHolder)) {
        }
        if (this.Oj.remove(viewHolder)) {
        }
        if (this.Om.remove(viewHolder)) {
        }
        if (this.Ok.remove(viewHolder)) {
        }
        fV();
    }

    private void c(RecyclerView.ViewHolder viewHolder) {
        AnimatorCompatHelper.clearInterpolator(viewHolder.itemView);
        endAnimation(viewHolder);
    }

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        return (this.Od.isEmpty() && this.Of.isEmpty() && this.Oe.isEmpty() && this.Oc.isEmpty() && this.Ok.isEmpty() && this.Ol.isEmpty() && this.Oj.isEmpty() && this.Om.isEmpty() && this.Oh.isEmpty() && this.Og.isEmpty() && this.Oi.isEmpty()) ? false : true;
    }

    void fV() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        for (int size = this.Oe.size() - 1; size >= 0; size--) {
            b bVar = this.Oe.get(size);
            View view = bVar.OF.itemView;
            ViewCompat.setTranslationY(view, 0.0f);
            ViewCompat.setTranslationX(view, 0.0f);
            dispatchMoveFinished(bVar.OF);
            this.Oe.remove(size);
        }
        for (int size2 = this.Oc.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.Oc.get(size2));
            this.Oc.remove(size2);
        }
        for (int size3 = this.Od.size() - 1; size3 >= 0; size3--) {
            RecyclerView.ViewHolder viewHolder = this.Od.get(size3);
            ViewCompat.setAlpha(viewHolder.itemView, 1.0f);
            dispatchAddFinished(viewHolder);
            this.Od.remove(size3);
        }
        for (int size4 = this.Of.size() - 1; size4 >= 0; size4--) {
            b(this.Of.get(size4));
        }
        this.Of.clear();
        if (isRunning()) {
            for (int size5 = this.Oh.size() - 1; size5 >= 0; size5--) {
                ArrayList<b> arrayList = this.Oh.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    b bVar2 = arrayList.get(size6);
                    View view2 = bVar2.OF.itemView;
                    ViewCompat.setTranslationY(view2, 0.0f);
                    ViewCompat.setTranslationX(view2, 0.0f);
                    dispatchMoveFinished(bVar2.OF);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.Oh.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.Og.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.ViewHolder> arrayList2 = this.Og.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ViewHolder viewHolder2 = arrayList2.get(size8);
                    ViewCompat.setAlpha(viewHolder2.itemView, 1.0f);
                    dispatchAddFinished(viewHolder2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.Og.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.Oi.size() - 1; size9 >= 0; size9--) {
                ArrayList<a> arrayList3 = this.Oi.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    b(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.Oi.remove(arrayList3);
                    }
                }
            }
            l(this.Ol);
            l(this.Ok);
            l(this.Oj);
            l(this.Om);
            dispatchAnimationsFinished();
        }
    }

    void l(List<RecyclerView.ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ViewCompat.animate(list.get(size).itemView).cancel();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder viewHolder, List<Object> list) {
        return !list.isEmpty() || super.canReuseUpdatedViewHolder(viewHolder, list);
    }

    /* loaded from: classes2.dex */
    private static class c implements ViewPropertyAnimatorListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view) {
        }
    }
}

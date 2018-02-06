package android.support.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.support.annotation.RestrictTo;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class z implements Cloneable {
    private static ThreadLocal<ArrayMap<Animator, a>> vi = new ThreadLocal<>();
    long vj = -1;
    long mDuration = -1;
    TimeInterpolator vk = null;
    ArrayList<Integer> vl = new ArrayList<>();
    ArrayList<View> vm = new ArrayList<>();
    ArrayList<Integer> vn = null;
    ArrayList<View> vo = null;
    ArrayList<Class> vp = null;
    ArrayList<Integer> vq = null;
    ArrayList<View> vr = null;
    ArrayList<Class> vs = null;
    ae vt = null;
    ViewGroup uR = null;
    boolean vu = false;
    int vv = 0;
    boolean mPaused = false;
    ArrayList<c> sB = null;
    ArrayList<Animator> mAnimators = new ArrayList<>();
    private String mName = getClass().getName();
    private ag vw = new ag();
    private ag vx = new ag();
    ArrayList<Animator> vy = new ArrayList<>();
    private boolean vz = false;

    /* loaded from: classes2.dex */
    public interface c {
        void a(z zVar);

        void b(z zVar);

        void c(z zVar);

        void d(z zVar);
    }

    public abstract void captureEndValues(af afVar);

    public abstract void captureStartValues(af afVar);

    private static ArrayMap<Animator, a> cX() {
        ArrayMap<Animator, a> arrayMap = vi.get();
        if (arrayMap == null) {
            ArrayMap<Animator, a> arrayMap2 = new ArrayMap<>();
            vi.set(arrayMap2);
            return arrayMap2;
        }
        return arrayMap;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public z h(long j) {
        this.mDuration = j;
        return this;
    }

    public long getStartDelay() {
        return this.vj;
    }

    public z i(long j) {
        this.vj = j;
        return this;
    }

    public TimeInterpolator getInterpolator() {
        return this.vk;
    }

    public z b(TimeInterpolator timeInterpolator) {
        this.vk = timeInterpolator;
        return this;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public Animator createAnimator(ViewGroup viewGroup, af afVar, af afVar2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo
    public void a(ViewGroup viewGroup, ag agVar, ag agVar2) {
        Animator createAnimator;
        View view;
        af afVar;
        Animator animator;
        af afVar2;
        ArrayMap arrayMap = new ArrayMap(agVar2.vL);
        SparseArray sparseArray = new SparseArray(agVar2.vM.size());
        for (int i = 0; i < agVar2.vM.size(); i++) {
            sparseArray.put(agVar2.vM.keyAt(i), agVar2.vM.valueAt(i));
        }
        LongSparseArray longSparseArray = new LongSparseArray(agVar2.vN.size());
        for (int i2 = 0; i2 < agVar2.vN.size(); i2++) {
            longSparseArray.put(agVar2.vN.keyAt(i2), agVar2.vN.valueAt(i2));
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (View view2 : agVar.vL.keySet()) {
            boolean z = false;
            if (view2.getParent() instanceof ListView) {
                z = true;
            }
            if (!z) {
                int id = view2.getId();
                af afVar3 = agVar.vL.get(view2) != null ? agVar.vL.get(view2) : agVar.vM.get(id);
                if (agVar2.vL.get(view2) != null) {
                    afVar2 = agVar2.vL.get(view2);
                    arrayMap.remove(view2);
                } else if (id == -1) {
                    afVar2 = null;
                } else {
                    afVar2 = agVar2.vM.get(id);
                    View view3 = null;
                    for (View view4 : arrayMap.keySet()) {
                        if (view4.getId() != id) {
                            view4 = view3;
                        }
                        view3 = view4;
                    }
                    if (view3 != null) {
                        arrayMap.remove(view3);
                    }
                }
                sparseArray.remove(id);
                if (a(view2, id)) {
                    arrayList.add(afVar3);
                    arrayList2.add(afVar2);
                }
            } else {
                ListView listView = (ListView) view2.getParent();
                if (listView.getAdapter().hasStableIds()) {
                    long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view2));
                    longSparseArray.remove(itemIdAtPosition);
                    arrayList.add(agVar.vN.get(itemIdAtPosition));
                    arrayList2.add(null);
                }
            }
        }
        int size = agVar.vN.size();
        for (int i3 = 0; i3 < size; i3++) {
            long keyAt = agVar.vN.keyAt(i3);
            if (a((View) null, keyAt)) {
                longSparseArray.remove(keyAt);
                arrayList.add(agVar.vN.get(keyAt));
                arrayList2.add(agVar2.vN.get(keyAt));
            }
        }
        for (View view5 : arrayMap.keySet()) {
            int id2 = view5.getId();
            if (a(view5, id2)) {
                af afVar4 = agVar.vL.get(view5) != null ? agVar.vL.get(view5) : agVar.vM.get(id2);
                sparseArray.remove(id2);
                arrayList.add(afVar4);
                arrayList2.add((af) arrayMap.get(view5));
            }
        }
        int size2 = sparseArray.size();
        for (int i4 = 0; i4 < size2; i4++) {
            int keyAt2 = sparseArray.keyAt(i4);
            if (a((View) null, keyAt2)) {
                arrayList.add(agVar.vM.get(keyAt2));
                arrayList2.add((af) sparseArray.get(keyAt2));
            }
        }
        int size3 = longSparseArray.size();
        for (int i5 = 0; i5 < size3; i5++) {
            long keyAt3 = longSparseArray.keyAt(i5);
            arrayList.add(agVar.vN.get(keyAt3));
            arrayList2.add((af) longSparseArray.get(keyAt3));
        }
        ArrayMap<Animator, a> cX = cX();
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < arrayList.size()) {
                af afVar5 = (af) arrayList.get(i7);
                af afVar6 = (af) arrayList2.get(i7);
                if ((afVar5 != null || afVar6 != null) && ((afVar5 == null || !afVar5.equals(afVar6)) && (createAnimator = createAnimator(viewGroup, afVar5, afVar6)) != null)) {
                    if (afVar6 != null) {
                        View view6 = afVar6.view;
                        String[] transitionProperties = getTransitionProperties();
                        if (view6 == null || transitionProperties == null || transitionProperties.length <= 0) {
                            afVar = null;
                            animator = createAnimator;
                        } else {
                            af afVar7 = new af();
                            afVar7.view = view6;
                            af afVar8 = agVar2.vL.get(view6);
                            if (afVar8 != null) {
                                for (int i8 = 0; i8 < transitionProperties.length; i8++) {
                                    afVar7.values.put(transitionProperties[i8], afVar8.values.get(transitionProperties[i8]));
                                }
                            }
                            int size4 = cX.size();
                            int i9 = 0;
                            while (true) {
                                if (i9 >= size4) {
                                    afVar = afVar7;
                                    animator = createAnimator;
                                    break;
                                }
                                a aVar = cX.get(cX.keyAt(i9));
                                if (aVar.vC == null || aVar.view != view6 || (((aVar.name != null || getName() != null) && !aVar.name.equals(getName())) || !aVar.vC.equals(afVar7))) {
                                    i9++;
                                } else {
                                    animator = null;
                                    afVar = afVar7;
                                    break;
                                }
                            }
                        }
                        createAnimator = animator;
                        view = view6;
                    } else {
                        view = afVar5.view;
                        afVar = null;
                    }
                    if (createAnimator != null) {
                        cX.put(createAnimator, new a(view, getName(), ap.R(viewGroup), afVar));
                        this.mAnimators.add(createAnimator);
                    }
                }
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(View view, long j) {
        if (this.vn == null || !this.vn.contains(Integer.valueOf((int) j))) {
            if (this.vo == null || !this.vo.contains(view)) {
                if (this.vp != null && view != null) {
                    int size = this.vp.size();
                    for (int i = 0; i < size; i++) {
                        if (this.vp.get(i).isInstance(view)) {
                            return false;
                        }
                    }
                }
                if (this.vl.size() == 0 && this.vm.size() == 0) {
                    return true;
                }
                if (this.vl.size() > 0) {
                    for (int i2 = 0; i2 < this.vl.size(); i2++) {
                        if (this.vl.get(i2).intValue() == j) {
                            return true;
                        }
                    }
                }
                if (view == null || this.vm.size() <= 0) {
                    return false;
                }
                for (int i3 = 0; i3 < this.vm.size(); i3++) {
                    if (this.vm.get(i3) == view) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo
    public void cY() {
        start();
        ArrayMap<Animator, a> cX = cX();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (cX.containsKey(next)) {
                start();
                a(next, cX);
            }
        }
        this.mAnimators.clear();
        end();
    }

    private void a(Animator animator, final ArrayMap<Animator, a> arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: android.support.b.z.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    z.this.vy.add(animator2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    arrayMap.remove(animator2);
                    z.this.vy.remove(animator2);
                }
            });
            b(animator);
        }
    }

    public z U(int i) {
        if (i > 0) {
            this.vl.add(Integer.valueOf(i));
        }
        return this;
    }

    public z V(int i) {
        if (i > 0) {
            this.vl.remove(Integer.valueOf(i));
        }
        return this;
    }

    public z h(int i, boolean z) {
        this.vn = a(this.vn, i, z);
        return this;
    }

    public z i(int i, boolean z) {
        this.vq = a(this.vq, i, z);
        return this;
    }

    private ArrayList<Integer> a(ArrayList<Integer> arrayList, int i, boolean z) {
        if (i > 0) {
            if (z) {
                return b.a(arrayList, Integer.valueOf(i));
            }
            return b.b(arrayList, Integer.valueOf(i));
        }
        return arrayList;
    }

    public z d(View view, boolean z) {
        this.vo = c(this.vo, view, z);
        return this;
    }

    public z e(View view, boolean z) {
        this.vr = c(this.vr, view, z);
        return this;
    }

    private ArrayList<View> c(ArrayList<View> arrayList, View view, boolean z) {
        if (view != null) {
            if (z) {
                return b.a(arrayList, view);
            }
            return b.b(arrayList, view);
        }
        return arrayList;
    }

    public z c(Class cls, boolean z) {
        this.vp = a(this.vp, cls, z);
        return this;
    }

    public z d(Class cls, boolean z) {
        this.vs = a(this.vs, cls, z);
        return this;
    }

    private ArrayList<Class> a(ArrayList<Class> arrayList, Class cls, boolean z) {
        if (cls != null) {
            if (z) {
                return b.a(arrayList, cls);
            }
            return b.b(arrayList, cls);
        }
        return arrayList;
    }

    public z J(View view) {
        this.vm.add(view);
        return this;
    }

    public z K(View view) {
        if (view != null) {
            this.vm.remove(view);
        }
        return this;
    }

    public List<Integer> getTargetIds() {
        return this.vl;
    }

    public List<View> getTargets() {
        return this.vm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ViewGroup viewGroup, boolean z) {
        u(z);
        if (this.vl.size() > 0 || this.vm.size() > 0) {
            if (this.vl.size() > 0) {
                for (int i = 0; i < this.vl.size(); i++) {
                    int intValue = this.vl.get(i).intValue();
                    View findViewById = viewGroup.findViewById(intValue);
                    if (findViewById != null) {
                        af afVar = new af();
                        afVar.view = findViewById;
                        if (z) {
                            captureStartValues(afVar);
                        } else {
                            captureEndValues(afVar);
                        }
                        if (z) {
                            this.vw.vL.put(findViewById, afVar);
                            if (intValue >= 0) {
                                this.vw.vM.put(intValue, afVar);
                            }
                        } else {
                            this.vx.vL.put(findViewById, afVar);
                            if (intValue >= 0) {
                                this.vx.vM.put(intValue, afVar);
                            }
                        }
                    }
                }
            }
            if (this.vm.size() > 0) {
                for (int i2 = 0; i2 < this.vm.size(); i2++) {
                    View view = this.vm.get(i2);
                    if (view != null) {
                        af afVar2 = new af();
                        afVar2.view = view;
                        if (z) {
                            captureStartValues(afVar2);
                        } else {
                            captureEndValues(afVar2);
                        }
                        if (z) {
                            this.vw.vL.put(view, afVar2);
                        } else {
                            this.vx.vL.put(view, afVar2);
                        }
                    }
                }
                return;
            }
            return;
        }
        f(viewGroup, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(boolean z) {
        if (z) {
            this.vw.vL.clear();
            this.vw.vM.clear();
            this.vw.vN.clear();
            return;
        }
        this.vx.vL.clear();
        this.vx.vM.clear();
        this.vx.vN.clear();
    }

    private void f(View view, boolean z) {
        int i;
        long itemIdAtPosition;
        if (view != null) {
            boolean z2 = view.getParent() instanceof ListView;
            if (!z2 || ((ListView) view.getParent()).getAdapter().hasStableIds()) {
                if (!z2) {
                    i = view.getId();
                    itemIdAtPosition = -1;
                } else {
                    ListView listView = (ListView) view.getParent();
                    i = -1;
                    itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                }
                if (this.vn == null || !this.vn.contains(Integer.valueOf(i))) {
                    if (this.vo == null || !this.vo.contains(view)) {
                        if (this.vp != null && view != null) {
                            int size = this.vp.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                if (this.vp.get(i2).isInstance(view)) {
                                    return;
                                }
                            }
                        }
                        af afVar = new af();
                        afVar.view = view;
                        if (z) {
                            captureStartValues(afVar);
                        } else {
                            captureEndValues(afVar);
                        }
                        if (z) {
                            if (!z2) {
                                this.vw.vL.put(view, afVar);
                                if (i >= 0) {
                                    this.vw.vM.put(i, afVar);
                                }
                            } else {
                                this.vw.vN.put(itemIdAtPosition, afVar);
                            }
                        } else if (!z2) {
                            this.vx.vL.put(view, afVar);
                            if (i >= 0) {
                                this.vx.vM.put(i, afVar);
                            }
                        } else {
                            this.vx.vN.put(itemIdAtPosition, afVar);
                        }
                        if (view instanceof ViewGroup) {
                            if (this.vq == null || !this.vq.contains(Integer.valueOf(i))) {
                                if (this.vr == null || !this.vr.contains(view)) {
                                    if (this.vs != null && view != null) {
                                        int size2 = this.vs.size();
                                        for (int i3 = 0; i3 < size2; i3++) {
                                            if (this.vs.get(i3).isInstance(view)) {
                                                return;
                                            }
                                        }
                                    }
                                    ViewGroup viewGroup = (ViewGroup) view;
                                    for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                        f(viewGroup.getChildAt(i4), z);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public af getTransitionValues(View view, boolean z) {
        if (this.vt != null) {
            return this.vt.getTransitionValues(view, z);
        }
        ag agVar = z ? this.vw : this.vx;
        af afVar = agVar.vL.get(view);
        if (afVar == null) {
            int id = view.getId();
            if (id >= 0) {
                afVar = agVar.vM.get(id);
            }
            if (afVar == null && (view.getParent() instanceof ListView)) {
                ListView listView = (ListView) view.getParent();
                return agVar.vN.get(listView.getItemIdAtPosition(listView.getPositionForView(view)));
            }
            return afVar;
        }
        return afVar;
    }

    @RestrictTo
    public void L(View view) {
        if (!this.vz) {
            ArrayMap<Animator, a> cX = cX();
            int size = cX.size();
            ap R = ap.R(view);
            for (int i = size - 1; i >= 0; i--) {
                a valueAt = cX.valueAt(i);
                if (valueAt.view != null && R.equals(valueAt.vD)) {
                    cX.keyAt(i).cancel();
                }
            }
            if (this.sB != null && this.sB.size() > 0) {
                ArrayList arrayList = (ArrayList) this.sB.clone();
                int size2 = arrayList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((c) arrayList.get(i2)).b(this);
                }
            }
            this.mPaused = true;
        }
    }

    @RestrictTo
    public void M(View view) {
        if (this.mPaused) {
            if (!this.vz) {
                ArrayMap<Animator, a> cX = cX();
                int size = cX.size();
                ap R = ap.R(view);
                for (int i = size - 1; i >= 0; i--) {
                    a valueAt = cX.valueAt(i);
                    if (valueAt.view != null && R.equals(valueAt.vD)) {
                        cX.keyAt(i).end();
                    }
                }
                if (this.sB != null && this.sB.size() > 0) {
                    ArrayList arrayList = (ArrayList) this.sB.clone();
                    int size2 = arrayList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((c) arrayList.get(i2)).c(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ViewGroup viewGroup) {
        a aVar;
        boolean z;
        ArrayMap<Animator, a> cX = cX();
        for (int size = cX.size() - 1; size >= 0; size--) {
            Animator keyAt = cX.keyAt(size);
            if (keyAt != null && (aVar = cX.get(keyAt)) != null && aVar.view != null && aVar.view.getContext() == viewGroup.getContext()) {
                af afVar = aVar.vC;
                View view = aVar.view;
                af afVar2 = this.vx.vL != null ? this.vx.vL.get(view) : null;
                af afVar3 = afVar2 == null ? this.vx.vM.get(view.getId()) : afVar2;
                if (afVar != null && afVar3 != null) {
                    for (String str : afVar.values.keySet()) {
                        Object obj = afVar.values.get(str);
                        Object obj2 = afVar3.values.get(str);
                        if (obj != null && obj2 != null && !obj.equals(obj2)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    if (keyAt.isRunning() || keyAt.isStarted()) {
                        keyAt.cancel();
                    } else {
                        cX.remove(keyAt);
                    }
                }
            }
        }
        a(viewGroup, this.vw, this.vx);
        cY();
    }

    @RestrictTo
    protected void b(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new AnimatorListenerAdapter() { // from class: android.support.b.z.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                z.this.end();
                animator2.removeListener(this);
            }
        });
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo
    public void start() {
        if (this.vv == 0) {
            if (this.sB != null && this.sB.size() > 0) {
                ArrayList arrayList = (ArrayList) this.sB.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((c) arrayList.get(i)).d(this);
                }
            }
            this.vz = false;
        }
        this.vv++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo
    public void end() {
        this.vv--;
        if (this.vv == 0) {
            if (this.sB != null && this.sB.size() > 0) {
                ArrayList arrayList = (ArrayList) this.sB.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((c) arrayList.get(i)).a(this);
                }
            }
            for (int i2 = 0; i2 < this.vw.vN.size(); i2++) {
                View view = this.vw.vN.valueAt(i2).view;
            }
            for (int i3 = 0; i3 < this.vx.vN.size(); i3++) {
                View view2 = this.vx.vN.valueAt(i3).view;
            }
            this.vz = true;
        }
    }

    public z a(c cVar) {
        if (this.sB == null) {
            this.sB = new ArrayList<>();
        }
        this.sB.add(cVar);
        return this;
    }

    public z b(c cVar) {
        if (this.sB != null) {
            this.sB.remove(cVar);
            if (this.sB.size() == 0) {
                this.sB = null;
            }
        }
        return this;
    }

    public String toString() {
        return toString("");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: cZ */
    public z clone() {
        try {
            z zVar = (z) super.clone();
            try {
                zVar.mAnimators = new ArrayList<>();
                zVar.vw = new ag();
                zVar.vx = new ag();
                return zVar;
            } catch (CloneNotSupportedException e) {
                return zVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public String getName() {
        return this.mName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toString(String str) {
        String str2;
        String str3 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration != -1) {
            str3 = str3 + "dur(" + this.mDuration + ") ";
        }
        if (this.vj != -1) {
            str3 = str3 + "dly(" + this.vj + ") ";
        }
        if (this.vk != null) {
            str3 = str3 + "interp(" + this.vk + ") ";
        }
        if (this.vl.size() > 0 || this.vm.size() > 0) {
            String str4 = str3 + "tgts(";
            if (this.vl.size() > 0) {
                str2 = str4;
                for (int i = 0; i < this.vl.size(); i++) {
                    if (i > 0) {
                        str2 = str2 + ", ";
                    }
                    str2 = str2 + this.vl.get(i);
                }
            } else {
                str2 = str4;
            }
            if (this.vm.size() > 0) {
                for (int i2 = 0; i2 < this.vm.size(); i2++) {
                    if (i2 > 0) {
                        str2 = str2 + ", ";
                    }
                    str2 = str2 + this.vm.get(i2);
                }
            }
            return str2 + ")";
        }
        return str3;
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public static class d implements c {
        @Override // android.support.b.z.c
        public void d(z zVar) {
        }

        @Override // android.support.b.z.c
        public void a(z zVar) {
        }

        @Override // android.support.b.z.c
        public void b(z zVar) {
        }

        @Override // android.support.b.z.c
        public void c(z zVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        String name;
        af vC;
        ap vD;
        View view;

        a(View view, String str, ap apVar, af afVar) {
            this.view = view;
            this.name = str;
            this.vC = afVar;
            this.vD = apVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        static <T> ArrayList<T> a(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        static <T> ArrayList<T> b(ArrayList<T> arrayList, T t) {
            if (arrayList != null) {
                arrayList.remove(t);
                if (arrayList.isEmpty()) {
                    return null;
                }
                return arrayList;
            }
            return arrayList;
        }
    }
}

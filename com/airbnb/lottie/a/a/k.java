package com.airbnb.lottie.a.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
@TargetApi(19)
/* loaded from: classes7.dex */
public class k implements i, l {
    private final MergePaths Ek;
    private final String name;
    private final Path Ei = new Path();
    private final Path Ej = new Path();
    private final Path path = new Path();
    private final List<l> DT = new ArrayList();

    public k(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.Ek = mergePaths;
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof l) {
                this.DT.add((l) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.DT.size()) {
                this.DT.get(i2).b(list, list2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path iW() {
        this.path.reset();
        switch (this.Ek.kc()) {
            case Merge:
                ja();
                break;
            case Add:
                a(Path.Op.UNION);
                break;
            case Subtract:
                a(Path.Op.REVERSE_DIFFERENCE);
                break;
            case Intersect:
                a(Path.Op.INTERSECT);
                break;
            case ExcludeIntersections:
                a(Path.Op.XOR);
                break;
        }
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void ja() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.DT.size()) {
                this.path.addPath(this.DT.get(i2).iW());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.Ej.reset();
        this.Ei.reset();
        int size = this.DT.size() - 1;
        while (true) {
            int i = size;
            if (i < 1) {
                break;
            }
            l lVar = this.DT.get(i);
            if (lVar instanceof c) {
                List<l> iU = ((c) lVar).iU();
                for (int size2 = iU.size() - 1; size2 >= 0; size2--) {
                    Path iW = iU.get(size2).iW();
                    iW.transform(((c) lVar).iV());
                    this.Ej.addPath(iW);
                }
            } else {
                this.Ej.addPath(lVar.iW());
            }
            size = i - 1;
        }
        l lVar2 = this.DT.get(0);
        if (lVar2 instanceof c) {
            List<l> iU2 = ((c) lVar2).iU();
            for (int i2 = 0; i2 < iU2.size(); i2++) {
                Path iW2 = iU2.get(i2).iW();
                iW2.transform(((c) lVar2).iV());
                this.Ei.addPath(iW2);
            }
        } else {
            this.Ei.set(lVar2.iW());
        }
        this.path.op(this.Ei, this.Ej, op);
    }
}

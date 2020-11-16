package com.airbnb.lottie.a.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
@TargetApi(19)
/* loaded from: classes16.dex */
public class k implements i, l {
    private final MergePaths Dq;
    private final String name;
    private final Path Do = new Path();
    private final Path Dp = new Path();
    private final Path path = new Path();
    private final List<l> CZ = new ArrayList();

    public k(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.Dq = mergePaths;
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof l) {
                this.CZ.add((l) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.CZ.size()) {
                this.CZ.get(i2).b(list, list2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path iW() {
        this.path.reset();
        switch (this.Dq.kc()) {
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
            if (i2 < this.CZ.size()) {
                this.path.addPath(this.CZ.get(i2).iW());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.Dp.reset();
        this.Do.reset();
        int size = this.CZ.size() - 1;
        while (true) {
            int i = size;
            if (i < 1) {
                break;
            }
            l lVar = this.CZ.get(i);
            if (lVar instanceof c) {
                List<l> iU = ((c) lVar).iU();
                for (int size2 = iU.size() - 1; size2 >= 0; size2--) {
                    Path iW = iU.get(size2).iW();
                    iW.transform(((c) lVar).iV());
                    this.Dp.addPath(iW);
                }
            } else {
                this.Dp.addPath(lVar.iW());
            }
            size = i - 1;
        }
        l lVar2 = this.CZ.get(0);
        if (lVar2 instanceof c) {
            List<l> iU2 = ((c) lVar2).iU();
            for (int i2 = 0; i2 < iU2.size(); i2++) {
                Path iW2 = iU2.get(i2).iW();
                iW2.transform(((c) lVar2).iV());
                this.Do.addPath(iW2);
            }
        } else {
            this.Do.set(lVar2.iW());
        }
        this.path.op(this.Do, this.Dp, op);
    }
}

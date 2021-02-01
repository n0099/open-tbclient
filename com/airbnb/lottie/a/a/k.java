package com.airbnb.lottie.a.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
@TargetApi(19)
/* loaded from: classes4.dex */
public class k implements i, l {
    private final MergePaths DX;
    private final String name;
    private final Path DV = new Path();
    private final Path DW = new Path();
    private final Path path = new Path();
    private final List<l> DD = new ArrayList();

    public k(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.DX = mergePaths;
    }

    @Override // com.airbnb.lottie.a.a.i
    public void b(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof l) {
                this.DD.add((l) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.DD.size()) {
                this.DD.get(i2).c(list, list2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path iu() {
        this.path.reset();
        switch (this.DX.jA()) {
            case Merge:
                iy();
                break;
            case Add:
                b(Path.Op.UNION);
                break;
            case Subtract:
                b(Path.Op.REVERSE_DIFFERENCE);
                break;
            case Intersect:
                b(Path.Op.INTERSECT);
                break;
            case ExcludeIntersections:
                b(Path.Op.XOR);
                break;
        }
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void iy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.DD.size()) {
                this.path.addPath(this.DD.get(i2).iu());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @TargetApi(19)
    private void b(Path.Op op) {
        this.DW.reset();
        this.DV.reset();
        int size = this.DD.size() - 1;
        while (true) {
            int i = size;
            if (i < 1) {
                break;
            }
            l lVar = this.DD.get(i);
            if (lVar instanceof c) {
                List<l> is = ((c) lVar).is();
                for (int size2 = is.size() - 1; size2 >= 0; size2--) {
                    Path iu = is.get(size2).iu();
                    iu.transform(((c) lVar).it());
                    this.DW.addPath(iu);
                }
            } else {
                this.DW.addPath(lVar.iu());
            }
            size = i - 1;
        }
        l lVar2 = this.DD.get(0);
        if (lVar2 instanceof c) {
            List<l> is2 = ((c) lVar2).is();
            for (int i2 = 0; i2 < is2.size(); i2++) {
                Path iu2 = is2.get(i2).iu();
                iu2.transform(((c) lVar2).it());
                this.DV.addPath(iu2);
            }
        } else {
            this.DV.set(lVar2.iu());
        }
        this.path.op(this.DV, this.DW, op);
    }
}

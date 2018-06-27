package com.airbnb.lottie.a.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
@TargetApi(19)
/* loaded from: classes2.dex */
public class j implements i, k {
    private final MergePaths lT;
    private final String name;
    private final Path lR = new Path();
    private final Path lS = new Path();
    private final Path lo = new Path();
    private final List<k> lC = new ArrayList();

    public j(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.lT = mergePaths;
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof k) {
                this.lC.add((k) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lC.size()) {
                this.lC.get(i2).b(list, list2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        this.lo.reset();
        switch (this.lT.cT()) {
            case Merge:
                bN();
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
        return this.lo;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void bN() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lC.size()) {
                this.lo.addPath(this.lC.get(i2).getPath());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.lS.reset();
        this.lR.reset();
        int size = this.lC.size() - 1;
        while (true) {
            int i = size;
            if (i < 1) {
                break;
            }
            k kVar = this.lC.get(i);
            if (kVar instanceof c) {
                List<k> bI = ((c) kVar).bI();
                for (int size2 = bI.size() - 1; size2 >= 0; size2--) {
                    Path path = bI.get(size2).getPath();
                    path.transform(((c) kVar).bJ());
                    this.lS.addPath(path);
                }
            } else {
                this.lS.addPath(kVar.getPath());
            }
            size = i - 1;
        }
        k kVar2 = this.lC.get(0);
        if (kVar2 instanceof c) {
            List<k> bI2 = ((c) kVar2).bI();
            for (int i2 = 0; i2 < bI2.size(); i2++) {
                Path path2 = bI2.get(i2).getPath();
                path2.transform(((c) kVar2).bJ());
                this.lR.addPath(path2);
            }
        } else {
            this.lR.set(kVar2.getPath());
        }
        this.lo.op(this.lR, this.lS, op);
    }
}

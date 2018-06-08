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
    private final MergePaths lV;
    private final String name;
    private final Path lT = new Path();
    private final Path lU = new Path();
    private final Path lp = new Path();
    private final List<k> lE = new ArrayList();

    public j(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.lV = mergePaths;
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof k) {
                this.lE.add((k) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lE.size()) {
                this.lE.get(i2).b(list, list2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        this.lp.reset();
        switch (this.lV.cT()) {
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
        return this.lp;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void bN() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lE.size()) {
                this.lp.addPath(this.lE.get(i2).getPath());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.lU.reset();
        this.lT.reset();
        int size = this.lE.size() - 1;
        while (true) {
            int i = size;
            if (i < 1) {
                break;
            }
            k kVar = this.lE.get(i);
            if (kVar instanceof c) {
                List<k> bI = ((c) kVar).bI();
                for (int size2 = bI.size() - 1; size2 >= 0; size2--) {
                    Path path = bI.get(size2).getPath();
                    path.transform(((c) kVar).bJ());
                    this.lU.addPath(path);
                }
            } else {
                this.lU.addPath(kVar.getPath());
            }
            size = i - 1;
        }
        k kVar2 = this.lE.get(0);
        if (kVar2 instanceof c) {
            List<k> bI2 = ((c) kVar2).bI();
            for (int i2 = 0; i2 < bI2.size(); i2++) {
                Path path2 = bI2.get(i2).getPath();
                path2.transform(((c) kVar2).bJ());
                this.lT.addPath(path2);
            }
        } else {
            this.lT.set(kVar2.getPath());
        }
        this.lp.op(this.lT, this.lU, op);
    }
}

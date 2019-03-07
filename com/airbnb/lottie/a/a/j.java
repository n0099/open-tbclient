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
    private final String name;
    private final MergePaths oV;
    private final Path oT = new Path();
    private final Path oU = new Path();
    private final Path ot = new Path();
    private final List<k> oE = new ArrayList();

    public j(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.oV = mergePaths;
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof k) {
                this.oE.add((k) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.oE.size()) {
                this.oE.get(i2).b(list, list2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        this.ot.reset();
        switch (this.oV.eo()) {
            case Merge:
                di();
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
        return this.ot;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void di() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.oE.size()) {
                this.ot.addPath(this.oE.get(i2).getPath());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.oU.reset();
        this.oT.reset();
        int size = this.oE.size() - 1;
        while (true) {
            int i = size;
            if (i < 1) {
                break;
            }
            k kVar = this.oE.get(i);
            if (kVar instanceof c) {
                List<k> dd = ((c) kVar).dd();
                for (int size2 = dd.size() - 1; size2 >= 0; size2--) {
                    Path path = dd.get(size2).getPath();
                    path.transform(((c) kVar).de());
                    this.oU.addPath(path);
                }
            } else {
                this.oU.addPath(kVar.getPath());
            }
            size = i - 1;
        }
        k kVar2 = this.oE.get(0);
        if (kVar2 instanceof c) {
            List<k> dd2 = ((c) kVar2).dd();
            for (int i2 = 0; i2 < dd2.size(); i2++) {
                Path path2 = dd2.get(i2).getPath();
                path2.transform(((c) kVar2).de());
                this.oT.addPath(path2);
            }
        } else {
            this.oT.set(kVar2.getPath());
        }
        this.ot.op(this.oT, this.oU, op);
    }
}

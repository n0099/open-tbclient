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
    private final MergePaths pa;
    private final Path oY = new Path();
    private final Path oZ = new Path();
    private final Path oy = new Path();
    private final List<k> oJ = new ArrayList();

    public j(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.pa = mergePaths;
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof k) {
                this.oJ.add((k) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.oJ.size()) {
                this.oJ.get(i2).b(list, list2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        this.oy.reset();
        switch (this.pa.eq()) {
            case Merge:
                dk();
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
        return this.oy;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void dk() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.oJ.size()) {
                this.oy.addPath(this.oJ.get(i2).getPath());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.oZ.reset();
        this.oY.reset();
        int size = this.oJ.size() - 1;
        while (true) {
            int i = size;
            if (i < 1) {
                break;
            }
            k kVar = this.oJ.get(i);
            if (kVar instanceof c) {
                List<k> df = ((c) kVar).df();
                for (int size2 = df.size() - 1; size2 >= 0; size2--) {
                    Path path = df.get(size2).getPath();
                    path.transform(((c) kVar).dg());
                    this.oZ.addPath(path);
                }
            } else {
                this.oZ.addPath(kVar.getPath());
            }
            size = i - 1;
        }
        k kVar2 = this.oJ.get(0);
        if (kVar2 instanceof c) {
            List<k> df2 = ((c) kVar2).df();
            for (int i2 = 0; i2 < df2.size(); i2++) {
                Path path2 = df2.get(i2).getPath();
                path2.transform(((c) kVar2).dg());
                this.oY.addPath(path2);
            }
        } else {
            this.oY.set(kVar2.getPath());
        }
        this.oy.op(this.oY, this.oZ, op);
    }
}

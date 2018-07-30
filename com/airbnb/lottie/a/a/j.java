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
    private final MergePaths lK;
    private final String name;
    private final Path lI = new Path();
    private final Path lJ = new Path();
    private final Path lg = new Path();
    private final List<k> lr = new ArrayList();

    public j(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.lK = mergePaths;
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof k) {
                this.lr.add((k) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lr.size()) {
                this.lr.get(i2).b(list, list2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        this.lg.reset();
        switch (this.lK.cR()) {
            case Merge:
                bL();
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
        return this.lg;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void bL() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lr.size()) {
                this.lg.addPath(this.lr.get(i2).getPath());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.lJ.reset();
        this.lI.reset();
        int size = this.lr.size() - 1;
        while (true) {
            int i = size;
            if (i < 1) {
                break;
            }
            k kVar = this.lr.get(i);
            if (kVar instanceof c) {
                List<k> bG = ((c) kVar).bG();
                for (int size2 = bG.size() - 1; size2 >= 0; size2--) {
                    Path path = bG.get(size2).getPath();
                    path.transform(((c) kVar).bH());
                    this.lJ.addPath(path);
                }
            } else {
                this.lJ.addPath(kVar.getPath());
            }
            size = i - 1;
        }
        k kVar2 = this.lr.get(0);
        if (kVar2 instanceof c) {
            List<k> bG2 = ((c) kVar2).bG();
            for (int i2 = 0; i2 < bG2.size(); i2++) {
                Path path2 = bG2.get(i2).getPath();
                path2.transform(((c) kVar2).bH());
                this.lI.addPath(path2);
            }
        } else {
            this.lI.set(kVar2.getPath());
        }
        this.lg.op(this.lI, this.lJ, op);
    }
}

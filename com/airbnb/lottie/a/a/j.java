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
    private final MergePaths mx;
    private final String name;
    private final Path mu = new Path();
    private final Path mw = new Path();
    private final Path lS = new Path();
    private final List<k> md = new ArrayList();

    public j(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.mx = mergePaths;
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof k) {
                this.md.add((k) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.md.size()) {
                this.md.get(i2).b(list, list2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        this.lS.reset();
        switch (this.mx.di()) {
            case Merge:
                cc();
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
        return this.lS;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void cc() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.md.size()) {
                this.lS.addPath(this.md.get(i2).getPath());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.mw.reset();
        this.mu.reset();
        int size = this.md.size() - 1;
        while (true) {
            int i = size;
            if (i < 1) {
                break;
            }
            k kVar = this.md.get(i);
            if (kVar instanceof c) {
                List<k> bX = ((c) kVar).bX();
                for (int size2 = bX.size() - 1; size2 >= 0; size2--) {
                    Path path = bX.get(size2).getPath();
                    path.transform(((c) kVar).bY());
                    this.mw.addPath(path);
                }
            } else {
                this.mw.addPath(kVar.getPath());
            }
            size = i - 1;
        }
        k kVar2 = this.md.get(0);
        if (kVar2 instanceof c) {
            List<k> bX2 = ((c) kVar2).bX();
            for (int i2 = 0; i2 < bX2.size(); i2++) {
                Path path2 = bX2.get(i2).getPath();
                path2.transform(((c) kVar2).bY());
                this.mu.addPath(path2);
            }
        } else {
            this.mu.set(kVar2.getPath());
        }
        this.lS.op(this.mu, this.mw, op);
    }
}

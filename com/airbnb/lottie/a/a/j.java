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
    private final MergePaths om;
    private final Path oj = new Path();
    private final Path ol = new Path();
    private final Path nJ = new Path();
    private final List<k> nU = new ArrayList();

    public j(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.om = mergePaths;
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof k) {
                this.nU.add((k) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.nU.size()) {
                this.nU.get(i2).b(list, list2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        this.nJ.reset();
        switch (this.om.dY()) {
            case Merge:
                cS();
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
        return this.nJ;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void cS() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.nU.size()) {
                this.nJ.addPath(this.nU.get(i2).getPath());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.ol.reset();
        this.oj.reset();
        int size = this.nU.size() - 1;
        while (true) {
            int i = size;
            if (i < 1) {
                break;
            }
            k kVar = this.nU.get(i);
            if (kVar instanceof c) {
                List<k> cN = ((c) kVar).cN();
                for (int size2 = cN.size() - 1; size2 >= 0; size2--) {
                    Path path = cN.get(size2).getPath();
                    path.transform(((c) kVar).cO());
                    this.ol.addPath(path);
                }
            } else {
                this.ol.addPath(kVar.getPath());
            }
            size = i - 1;
        }
        k kVar2 = this.nU.get(0);
        if (kVar2 instanceof c) {
            List<k> cN2 = ((c) kVar2).cN();
            for (int i2 = 0; i2 < cN2.size(); i2++) {
                Path path2 = cN2.get(i2).getPath();
                path2.transform(((c) kVar2).cO());
                this.oj.addPath(path2);
            }
        } else {
            this.oj.set(kVar2.getPath());
        }
        this.nJ.op(this.oj, this.ol, op);
    }
}

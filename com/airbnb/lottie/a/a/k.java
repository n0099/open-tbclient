package com.airbnb.lottie.a.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
@TargetApi(19)
/* loaded from: classes6.dex */
public class k implements i, l {
    private final MergePaths gl;
    private final String name;
    private final Path gj = new Path();
    private final Path gk = new Path();
    private final Path path = new Path();
    private final List<l> fT = new ArrayList();

    public k(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.gl = mergePaths;
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof l) {
                this.fT.add((l) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fT.size()) {
                this.fT.get(i2).b(list, list2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path bG() {
        this.path.reset();
        switch (this.gl.cM()) {
            case Merge:
                bK();
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

    private void bK() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fT.size()) {
                this.path.addPath(this.fT.get(i2).bG());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.gk.reset();
        this.gj.reset();
        int size = this.fT.size() - 1;
        while (true) {
            int i = size;
            if (i < 1) {
                break;
            }
            l lVar = this.fT.get(i);
            if (lVar instanceof c) {
                List<l> bE = ((c) lVar).bE();
                for (int size2 = bE.size() - 1; size2 >= 0; size2--) {
                    Path bG = bE.get(size2).bG();
                    bG.transform(((c) lVar).bF());
                    this.gk.addPath(bG);
                }
            } else {
                this.gk.addPath(lVar.bG());
            }
            size = i - 1;
        }
        l lVar2 = this.fT.get(0);
        if (lVar2 instanceof c) {
            List<l> bE2 = ((c) lVar2).bE();
            for (int i2 = 0; i2 < bE2.size(); i2++) {
                Path bG2 = bE2.get(i2).bG();
                bG2.transform(((c) lVar2).bF());
                this.gj.addPath(bG2);
            }
        } else {
            this.gj.set(lVar2.bG());
        }
        this.path.op(this.gj, this.gk, op);
    }
}

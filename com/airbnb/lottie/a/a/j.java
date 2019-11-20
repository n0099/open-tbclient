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
    private final MergePaths ev;
    private final String name;
    private final Path es = new Path();
    private final Path eu = new Path();
    private final Path path = new Path();
    private final List<k> ed = new ArrayList();

    public j(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.ev = mergePaths;
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof k) {
                this.ed.add((k) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ed.size()) {
                this.ed.get(i2).b(list, list2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path bw() {
        this.path.reset();
        switch (this.ev.cI()) {
            case Merge:
                bA();
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

    private void bA() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ed.size()) {
                this.path.addPath(this.ed.get(i2).bw());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.eu.reset();
        this.es.reset();
        int size = this.ed.size() - 1;
        while (true) {
            int i = size;
            if (i < 1) {
                break;
            }
            k kVar = this.ed.get(i);
            if (kVar instanceof c) {
                List<k> bu = ((c) kVar).bu();
                for (int size2 = bu.size() - 1; size2 >= 0; size2--) {
                    Path bw = bu.get(size2).bw();
                    bw.transform(((c) kVar).bv());
                    this.eu.addPath(bw);
                }
            } else {
                this.eu.addPath(kVar.bw());
            }
            size = i - 1;
        }
        k kVar2 = this.ed.get(0);
        if (kVar2 instanceof c) {
            List<k> bu2 = ((c) kVar2).bu();
            for (int i2 = 0; i2 < bu2.size(); i2++) {
                Path bw2 = bu2.get(i2).bw();
                bw2.transform(((c) kVar2).bv());
                this.es.addPath(bw2);
            }
        } else {
            this.es.set(kVar2.bw());
        }
        this.path.op(this.es, this.eu, op);
    }
}

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
    private final MergePaths mw;
    private final String name;
    private final Path mt = new Path();
    private final Path mu = new Path();
    private final Path lR = new Path();
    private final List<k> mc = new ArrayList();

    public j(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.mw = mergePaths;
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof k) {
                this.mc.add((k) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mc.size()) {
                this.mc.get(i2).b(list, list2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path cd() {
        this.lR.reset();
        switch (this.mw.dp()) {
            case Merge:
                ch();
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
        return this.lR;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void ch() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mc.size()) {
                this.lR.addPath(this.mc.get(i2).cd());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.mu.reset();
        this.mt.reset();
        int size = this.mc.size() - 1;
        while (true) {
            int i = size;
            if (i < 1) {
                break;
            }
            k kVar = this.mc.get(i);
            if (kVar instanceof c) {
                List<k> cb = ((c) kVar).cb();
                for (int size2 = cb.size() - 1; size2 >= 0; size2--) {
                    Path cd = cb.get(size2).cd();
                    cd.transform(((c) kVar).cc());
                    this.mu.addPath(cd);
                }
            } else {
                this.mu.addPath(kVar.cd());
            }
            size = i - 1;
        }
        k kVar2 = this.mc.get(0);
        if (kVar2 instanceof c) {
            List<k> cb2 = ((c) kVar2).cb();
            for (int i2 = 0; i2 < cb2.size(); i2++) {
                Path cd2 = cb2.get(i2).cd();
                cd2.transform(((c) kVar2).cc());
                this.mt.addPath(cd2);
            }
        } else {
            this.mt.set(kVar2.cd());
        }
        this.lR.op(this.mt, this.mu, op);
    }
}

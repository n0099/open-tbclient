package com.baidu.live.lottie.a.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.baidu.live.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
@TargetApi(19)
/* loaded from: classes10.dex */
public class k implements i, l {
    private final MergePaths btO;
    private final String name;
    private final Path DX = new Path();
    private final Path DY = new Path();
    private final Path path = new Path();
    private final List<l> DG = new ArrayList();

    public k(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.btO = mergePaths;
    }

    @Override // com.baidu.live.lottie.a.a.i
    public void b(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof l) {
                this.DG.add((l) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.baidu.live.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.DG.size()) {
                this.DG.get(i2).c(list, list2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.live.lottie.a.a.l
    public Path iv() {
        this.path.reset();
        switch (this.btO.Qk()) {
            case Merge:
                iz();
                break;
            case Add:
                b(Path.Op.UNION);
                break;
            case Subtract:
                b(Path.Op.REVERSE_DIFFERENCE);
                break;
            case Intersect:
                b(Path.Op.INTERSECT);
                break;
            case ExcludeIntersections:
                b(Path.Op.XOR);
                break;
        }
        return this.path;
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void iz() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.DG.size()) {
                this.path.addPath(this.DG.get(i2).iv());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @TargetApi(19)
    private void b(Path.Op op) {
        this.DY.reset();
        this.DX.reset();
        int size = this.DG.size() - 1;
        while (true) {
            int i = size;
            if (i < 1) {
                break;
            }
            l lVar = this.DG.get(i);
            if (lVar instanceof c) {
                List<l> it = ((c) lVar).it();
                for (int size2 = it.size() - 1; size2 >= 0; size2--) {
                    Path iv = it.get(size2).iv();
                    iv.transform(((c) lVar).iu());
                    this.DY.addPath(iv);
                }
            } else {
                this.DY.addPath(lVar.iv());
            }
            size = i - 1;
        }
        l lVar2 = this.DG.get(0);
        if (lVar2 instanceof c) {
            List<l> it2 = ((c) lVar2).it();
            for (int i2 = 0; i2 < it2.size(); i2++) {
                Path iv2 = it2.get(i2).iv();
                iv2.transform(((c) lVar2).iu());
                this.DX.addPath(iv2);
            }
        } else {
            this.DX.set(lVar2.iv());
        }
        this.path.op(this.DX, this.DY, op);
    }
}

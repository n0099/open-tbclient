package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c implements d, l, a.InterfaceC0013a, com.airbnb.lottie.model.f {
    private final com.airbnb.lottie.f Df;
    @Nullable
    private List<l> EZ;
    @Nullable
    private com.airbnb.lottie.a.b.o Fa;
    private final List<b> contents;
    private final Matrix matrix;
    private final String name;
    private final Path path;
    private final RectF rect;

    private static List<b> a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, List<com.airbnb.lottie.model.content.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b a2 = list.get(i2).a(fVar, aVar);
                if (a2 != null) {
                    arrayList.add(a2);
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    @Nullable
    static com.airbnb.lottie.model.a.l l(List<com.airbnb.lottie.model.content.b> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                com.airbnb.lottie.model.content.b bVar = list.get(i2);
                if (!(bVar instanceof com.airbnb.lottie.model.a.l)) {
                    i = i2 + 1;
                } else {
                    return (com.airbnb.lottie.model.a.l) bVar;
                }
            } else {
                return null;
            }
        }
    }

    public c(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.j jVar) {
        this(fVar, aVar, jVar.getName(), a(fVar, aVar, jVar.getItems()), l(jVar.getItems()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, String str, List<b> list, @Nullable com.airbnb.lottie.model.a.l lVar) {
        this.matrix = new Matrix();
        this.path = new Path();
        this.rect = new RectF();
        this.name = str;
        this.Df = fVar;
        this.contents = list;
        if (lVar != null) {
            this.Fa = lVar.jk();
            this.Fa.a(aVar);
            this.Fa.a(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            b bVar = list.get(size);
            if (bVar instanceof i) {
                arrayList.add((i) bVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((i) arrayList.get(size2)).b(list.listIterator(list.size()));
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0013a
    public void ir() {
        this.Df.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.contents.size());
        arrayList.addAll(list);
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            b bVar = this.contents.get(size);
            bVar.b(arrayList, this.contents.subList(0, size));
            arrayList.add(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<l> is() {
        if (this.EZ == null) {
            this.EZ = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.contents.size()) {
                    break;
                }
                b bVar = this.contents.get(i2);
                if (bVar instanceof l) {
                    this.EZ.add((l) bVar);
                }
                i = i2 + 1;
            }
        }
        return this.EZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix it() {
        if (this.Fa != null) {
            return this.Fa.getMatrix();
        }
        this.matrix.reset();
        return this.matrix;
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path iu() {
        this.matrix.reset();
        if (this.Fa != null) {
            this.matrix.set(this.Fa.getMatrix());
        }
        this.path.reset();
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            b bVar = this.contents.get(size);
            if (bVar instanceof l) {
                this.path.addPath(((l) bVar).iu(), this.matrix);
            }
        }
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        this.matrix.set(matrix);
        if (this.Fa != null) {
            this.matrix.preConcat(this.Fa.getMatrix());
            i = (int) ((((this.Fa.iP().getValue().intValue() / 100.0f) * i) / 255.0f) * 255.0f);
        }
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            b bVar = this.contents.get(size);
            if (bVar instanceof d) {
                ((d) bVar).c(canvas, this.matrix, i);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.matrix.set(matrix);
        if (this.Fa != null) {
            this.matrix.preConcat(this.Fa.getMatrix());
        }
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            b bVar = this.contents.get(size);
            if (bVar instanceof d) {
                ((d) bVar).d(this.rect, this.matrix);
                if (rectF.isEmpty()) {
                    rectF.set(this.rect);
                } else {
                    rectF.set(Math.min(rectF.left, this.rect.left), Math.min(rectF.top, this.rect.top), Math.max(rectF.right, this.rect.right), Math.max(rectF.bottom, this.rect.bottom));
                }
            }
        }
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        if (eVar.h(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.bo(getName());
                if (eVar.j(getName(), i)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.k(getName(), i)) {
                int i2 = i + eVar.i(getName(), i);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < this.contents.size()) {
                        b bVar = this.contents.get(i4);
                        if (bVar instanceof com.airbnb.lottie.model.f) {
                            ((com.airbnb.lottie.model.f) bVar).a(eVar, i2, list, eVar2);
                        }
                        i3 = i4 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (this.Fa != null) {
            this.Fa.b(t, cVar);
        }
    }
}

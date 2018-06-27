package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements d, k, a.InterfaceC0006a {
    private final com.airbnb.lottie.f jY;
    private final List<b> lB;
    @Nullable
    private List<k> lC;
    @Nullable
    private com.airbnb.lottie.a.b.p lD;
    private final Path lo;
    private final Matrix matrix;
    private final String name;
    private final RectF rect;

    private static List<b> a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, List<com.airbnb.lottie.model.content.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b a = list.get(i2).a(fVar, aVar);
                if (a != null) {
                    arrayList.add(a);
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    @Nullable
    static com.airbnb.lottie.model.a.l g(List<com.airbnb.lottie.model.content.b> list) {
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
        this(fVar, aVar, jVar.getName(), a(fVar, aVar, jVar.getItems()), g(jVar.getItems()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, String str, List<b> list, @Nullable com.airbnb.lottie.model.a.l lVar) {
        this.matrix = new Matrix();
        this.lo = new Path();
        this.rect = new RectF();
        this.name = str;
        this.jY = fVar;
        this.lB = list;
        if (lVar != null) {
            this.lD = lVar.cC();
            this.lD.a(aVar);
            this.lD.a(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            b bVar = list.get(size);
            if (bVar instanceof i) {
                arrayList.add((i) bVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((i) arrayList.get(size2)).a(list.listIterator(list.size()));
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bH() {
        this.jY.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lB.size()) {
                b bVar = this.lB.get(i2);
                if (bVar instanceof d) {
                    d dVar = (d) bVar;
                    if (str2 == null || str2.equals(bVar.getName())) {
                        dVar.b(str, null, colorFilter);
                    } else {
                        dVar.b(str, str2, colorFilter);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.lB.size());
        arrayList.addAll(list);
        for (int size = this.lB.size() - 1; size >= 0; size--) {
            b bVar = this.lB.get(size);
            bVar.b(arrayList, this.lB.subList(0, size));
            arrayList.add(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<k> bI() {
        if (this.lC == null) {
            this.lC = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lB.size()) {
                    break;
                }
                b bVar = this.lB.get(i2);
                if (bVar instanceof k) {
                    this.lC.add((k) bVar);
                }
                i = i2 + 1;
            }
        }
        return this.lC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix bJ() {
        if (this.lD != null) {
            return this.lD.getMatrix();
        }
        this.matrix.reset();
        return this.matrix;
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        this.matrix.reset();
        if (this.lD != null) {
            this.matrix.set(this.lD.getMatrix());
        }
        this.lo.reset();
        for (int size = this.lB.size() - 1; size >= 0; size--) {
            b bVar = this.lB.get(size);
            if (bVar instanceof k) {
                this.lo.addPath(((k) bVar).getPath(), this.matrix);
            }
        }
        return this.lo;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.matrix.set(matrix);
        if (this.lD != null) {
            this.matrix.preConcat(this.lD.getMatrix());
            i = (int) ((((this.lD.cc().getValue().intValue() / 100.0f) * i) / 255.0f) * 255.0f);
        }
        for (int size = this.lB.size() - 1; size >= 0; size--) {
            b bVar = this.lB.get(size);
            if (bVar instanceof d) {
                ((d) bVar).a(canvas, this.matrix, i);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.matrix.set(matrix);
        if (this.lD != null) {
            this.matrix.preConcat(this.lD.getMatrix());
        }
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.lB.size() - 1; size >= 0; size--) {
            b bVar = this.lB.get(size);
            if (bVar instanceof d) {
                ((d) bVar).a(this.rect, this.matrix);
                if (rectF.isEmpty()) {
                    rectF.set(this.rect);
                } else {
                    rectF.set(Math.min(rectF.left, this.rect.left), Math.min(rectF.top, this.rect.top), Math.max(rectF.right, this.rect.right), Math.max(rectF.bottom, this.rect.bottom));
                }
            }
        }
    }
}

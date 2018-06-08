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
    private final List<b> lD;
    @Nullable
    private List<k> lE;
    @Nullable
    private com.airbnb.lottie.a.b.p lF;
    private final Path lp;
    private final RectF lr;
    private final Matrix matrix;
    private final String name;

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
        this.lp = new Path();
        this.lr = new RectF();
        this.name = str;
        this.jY = fVar;
        this.lD = list;
        if (lVar != null) {
            this.lF = lVar.cC();
            this.lF.a(aVar);
            this.lF.a(this);
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
            if (i2 < this.lD.size()) {
                b bVar = this.lD.get(i2);
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
        ArrayList arrayList = new ArrayList(list.size() + this.lD.size());
        arrayList.addAll(list);
        for (int size = this.lD.size() - 1; size >= 0; size--) {
            b bVar = this.lD.get(size);
            bVar.b(arrayList, this.lD.subList(0, size));
            arrayList.add(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<k> bI() {
        if (this.lE == null) {
            this.lE = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lD.size()) {
                    break;
                }
                b bVar = this.lD.get(i2);
                if (bVar instanceof k) {
                    this.lE.add((k) bVar);
                }
                i = i2 + 1;
            }
        }
        return this.lE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix bJ() {
        if (this.lF != null) {
            return this.lF.getMatrix();
        }
        this.matrix.reset();
        return this.matrix;
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        this.matrix.reset();
        if (this.lF != null) {
            this.matrix.set(this.lF.getMatrix());
        }
        this.lp.reset();
        for (int size = this.lD.size() - 1; size >= 0; size--) {
            b bVar = this.lD.get(size);
            if (bVar instanceof k) {
                this.lp.addPath(((k) bVar).getPath(), this.matrix);
            }
        }
        return this.lp;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.matrix.set(matrix);
        if (this.lF != null) {
            this.matrix.preConcat(this.lF.getMatrix());
            i = (int) ((((this.lF.cc().getValue().intValue() / 100.0f) * i) / 255.0f) * 255.0f);
        }
        for (int size = this.lD.size() - 1; size >= 0; size--) {
            b bVar = this.lD.get(size);
            if (bVar instanceof d) {
                ((d) bVar).a(canvas, this.matrix, i);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.matrix.set(matrix);
        if (this.lF != null) {
            this.matrix.preConcat(this.lF.getMatrix());
        }
        this.lr.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.lD.size() - 1; size >= 0; size--) {
            b bVar = this.lD.get(size);
            if (bVar instanceof d) {
                ((d) bVar).a(this.lr, this.matrix);
                if (rectF.isEmpty()) {
                    rectF.set(this.lr);
                } else {
                    rectF.set(Math.min(rectF.left, this.lr.left), Math.min(rectF.top, this.lr.top), Math.max(rectF.right, this.lr.right), Math.max(rectF.bottom, this.lr.bottom));
                }
            }
        }
    }
}

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
public class c implements d, k, a.InterfaceC0009a {
    private final Matrix matrix;
    private final String name;
    private final com.airbnb.lottie.f nh;
    private final List<b> oI;
    @Nullable
    private List<k> oJ;
    @Nullable
    private com.airbnb.lottie.a.b.p oK;
    private final Path oy;
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
        this.oy = new Path();
        this.rect = new RectF();
        this.name = str;
        this.nh = fVar;
        this.oI = list;
        if (lVar != null) {
            this.oK = lVar.dY();
            this.oK.a(aVar);
            this.oK.a(this);
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

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0009a
    public void dd() {
        this.nh.invalidateSelf();
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
            if (i2 < this.oI.size()) {
                b bVar = this.oI.get(i2);
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
        ArrayList arrayList = new ArrayList(list.size() + this.oI.size());
        arrayList.addAll(list);
        for (int size = this.oI.size() - 1; size >= 0; size--) {
            b bVar = this.oI.get(size);
            bVar.b(arrayList, this.oI.subList(0, size));
            arrayList.add(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<k> de() {
        if (this.oJ == null) {
            this.oJ = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.oI.size()) {
                    break;
                }
                b bVar = this.oI.get(i2);
                if (bVar instanceof k) {
                    this.oJ.add((k) bVar);
                }
                i = i2 + 1;
            }
        }
        return this.oJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix df() {
        if (this.oK != null) {
            return this.oK.getMatrix();
        }
        this.matrix.reset();
        return this.matrix;
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        this.matrix.reset();
        if (this.oK != null) {
            this.matrix.set(this.oK.getMatrix());
        }
        this.oy.reset();
        for (int size = this.oI.size() - 1; size >= 0; size--) {
            b bVar = this.oI.get(size);
            if (bVar instanceof k) {
                this.oy.addPath(((k) bVar).getPath(), this.matrix);
            }
        }
        return this.oy;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.matrix.set(matrix);
        if (this.oK != null) {
            this.matrix.preConcat(this.oK.getMatrix());
            i = (int) ((((this.oK.dy().getValue().intValue() / 100.0f) * i) / 255.0f) * 255.0f);
        }
        for (int size = this.oI.size() - 1; size >= 0; size--) {
            b bVar = this.oI.get(size);
            if (bVar instanceof d) {
                ((d) bVar).a(canvas, this.matrix, i);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.matrix.set(matrix);
        if (this.oK != null) {
            this.matrix.preConcat(this.oK.getMatrix());
        }
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.oI.size() - 1; size >= 0; size--) {
            b bVar = this.oI.get(size);
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

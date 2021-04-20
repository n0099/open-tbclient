package a.a.a.a.s;

import a.a.a.a.s.e;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes.dex */
public class a extends a.a.a.a.s.f.a {

    /* renamed from: b  reason: collision with root package name */
    public final Set<e> f1290b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<d> f1291c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<c> f1292d;

    public a(int i, ObjectInput objectInput) {
        super(i);
        HashSet hashSet;
        int readInt = objectInput.readInt();
        HashSet hashSet2 = new HashSet(readInt);
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < readInt; i2++) {
            e eVar = new e(objectInput.readInt(), objectInput);
            hashSet2.add(eVar);
            for (e.a aVar : eVar.f1318d) {
                hashMap.put(Long.valueOf(aVar.f1319b), aVar);
            }
        }
        int readInt2 = objectInput.readInt();
        HashSet hashSet3 = new HashSet(readInt2);
        for (int i3 = 0; i3 < readInt2; i3++) {
            hashSet3.add(new d(objectInput.readInt(), objectInput, hashMap));
        }
        this.f1290b = Collections.unmodifiableSet(hashSet2);
        this.f1291c = Collections.unmodifiableSet(hashSet3);
        if (i == 1) {
            int readInt3 = objectInput.readInt();
            hashSet = new HashSet(readInt3);
            for (int i4 = 0; i4 < readInt3; i4++) {
                hashSet.add(new c(objectInput.readInt(), objectInput, hashMap));
            }
        } else {
            hashSet = new HashSet();
        }
        this.f1292d = Collections.unmodifiableSet(hashSet);
    }

    public a(Set<e> set, Set<d> set2, Set<c> set3) {
        super(1);
        this.f1290b = set;
        this.f1291c = set2;
        this.f1292d = set3;
    }

    @Override // a.a.a.a.s.f.a
    public void a(ObjectOutput objectOutput) {
        objectOutput.writeInt(this.f1290b.size());
        for (e eVar : this.f1290b) {
            objectOutput.writeInt(eVar.f1326a);
            eVar.a(objectOutput);
        }
        objectOutput.writeInt(this.f1291c.size());
        for (d dVar : this.f1291c) {
            objectOutput.writeInt(dVar.f1326a);
            dVar.a(objectOutput);
        }
        objectOutput.writeInt(this.f1292d.size());
        for (c cVar : this.f1292d) {
            objectOutput.writeInt(cVar.f1326a);
            cVar.a(objectOutput);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return Objects.equals(this.f1290b, aVar.f1290b) && Objects.equals(this.f1291c, aVar.f1291c);
    }

    public int hashCode() {
        return Objects.hash(this.f1290b, this.f1291c);
    }
}

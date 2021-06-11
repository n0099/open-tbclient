package a.a.a.a.v;

import a.a.a.a.v.e;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes.dex */
public class a extends a.a.a.a.v.f.a {

    /* renamed from: b  reason: collision with root package name */
    public final Set<e> f1312b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<d> f1313c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<c> f1314d;

    public a(int i2, ObjectInput objectInput) {
        super(i2);
        HashSet hashSet;
        int readInt = objectInput.readInt();
        HashSet hashSet2 = new HashSet(readInt);
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < readInt; i3++) {
            e eVar = new e(objectInput.readInt(), objectInput);
            hashSet2.add(eVar);
            for (e.a aVar : eVar.f1340d) {
                hashMap.put(Long.valueOf(aVar.f1341b), aVar);
            }
        }
        int readInt2 = objectInput.readInt();
        HashSet hashSet3 = new HashSet(readInt2);
        for (int i4 = 0; i4 < readInt2; i4++) {
            hashSet3.add(new d(objectInput.readInt(), objectInput, hashMap));
        }
        this.f1312b = Collections.unmodifiableSet(hashSet2);
        this.f1313c = Collections.unmodifiableSet(hashSet3);
        if (i2 == 1) {
            int readInt3 = objectInput.readInt();
            hashSet = new HashSet(readInt3);
            for (int i5 = 0; i5 < readInt3; i5++) {
                hashSet.add(new c(objectInput.readInt(), objectInput, hashMap));
            }
        } else {
            hashSet = new HashSet();
        }
        this.f1314d = Collections.unmodifiableSet(hashSet);
    }

    public a(Set<e> set, Set<d> set2, Set<c> set3) {
        super(1);
        this.f1312b = set;
        this.f1313c = set2;
        this.f1314d = set3;
    }

    @Override // a.a.a.a.v.f.a
    public void a(ObjectOutput objectOutput) {
        objectOutput.writeInt(this.f1312b.size());
        for (e eVar : this.f1312b) {
            objectOutput.writeInt(eVar.f1349a);
            eVar.a(objectOutput);
        }
        objectOutput.writeInt(this.f1313c.size());
        for (d dVar : this.f1313c) {
            objectOutput.writeInt(dVar.f1349a);
            dVar.a(objectOutput);
        }
        objectOutput.writeInt(this.f1314d.size());
        for (c cVar : this.f1314d) {
            objectOutput.writeInt(cVar.f1349a);
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
        return Objects.equals(this.f1312b, aVar.f1312b) && Objects.equals(this.f1313c, aVar.f1313c);
    }

    public int hashCode() {
        return Objects.hash(this.f1312b, this.f1313c);
    }
}

package a.a.a.a.a;

import a.a.a.a.a.e;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes4.dex */
public class a extends a.a.a.a.a.a.a {
    public final Set<e> b;
    public final Set<d> c;
    public final Set<c> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int i, ObjectInput objectInput) {
        super(i);
        HashSet hashSet;
        int readInt = objectInput.readInt();
        HashSet hashSet2 = new HashSet(readInt);
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < readInt; i2++) {
            e eVar = new e(objectInput.readInt(), objectInput);
            hashSet2.add(eVar);
            for (e.a aVar : eVar.d) {
                hashMap.put(Long.valueOf(aVar.b), aVar);
            }
        }
        int readInt2 = objectInput.readInt();
        HashSet hashSet3 = new HashSet(readInt2);
        for (int i3 = 0; i3 < readInt2; i3++) {
            hashSet3.add(new d(objectInput.readInt(), objectInput, hashMap));
        }
        this.b = Collections.unmodifiableSet(hashSet2);
        this.c = Collections.unmodifiableSet(hashSet3);
        if (i == 1) {
            int readInt3 = objectInput.readInt();
            hashSet = new HashSet(readInt3);
            for (int i4 = 0; i4 < readInt3; i4++) {
                hashSet.add(new c(objectInput.readInt(), objectInput, hashMap));
            }
        } else {
            hashSet = new HashSet();
        }
        this.d = Collections.unmodifiableSet(hashSet);
    }

    public a(Set<e> set, Set<d> set2, Set<c> set3) {
        super(1);
        this.b = set;
        this.c = set2;
        this.d = set3;
    }

    @Override // a.a.a.a.a.a.a
    public void a(ObjectOutput objectOutput) {
        objectOutput.writeInt(this.b.size());
        for (e eVar : this.b) {
            objectOutput.writeInt(eVar.f952a);
            eVar.a(objectOutput);
        }
        objectOutput.writeInt(this.c.size());
        for (d dVar : this.c) {
            objectOutput.writeInt(dVar.f952a);
            dVar.a(objectOutput);
        }
        objectOutput.writeInt(this.d.size());
        for (c cVar : this.d) {
            objectOutput.writeInt(cVar.f952a);
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
        return Objects.equals(this.b, aVar.b) && Objects.equals(this.c, aVar.c);
    }

    public int hashCode() {
        return Objects.hash(this.b, this.c);
    }
}

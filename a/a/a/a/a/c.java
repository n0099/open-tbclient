package a.a.a.a.a;

import a.a.a.a.a.e;
import a.a.a.a.o;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class c extends a.a.a.a.a.a.a {
    public final String b;
    public final List<b> c;

    /* loaded from: classes4.dex */
    public static final class a extends a.a.a.a.a.a.a implements o {
        public final e.a BG;
        public final long b;
        public final int c;

        public a(int i, ObjectInput objectInput, Map<Long, e.a> map, b bVar) {
            super(i);
            this.b = objectInput.readLong();
            this.c = objectInput.readInt();
            this.BG = map.get(Long.valueOf(this.b));
        }

        public a(JSONObject jSONObject, Map<Long, e.a> map, b bVar) {
            super(0);
            this.b = a.a.a.a.a.b.a(jSONObject.getLong("id"), 0L);
            this.c = a.a.a.a.a.b.a(jSONObject.getInt("weight"), 0);
            this.BG = map.get(Long.valueOf(this.b));
        }

        @Override // a.a.a.a.a.a.a
        public void a(ObjectOutput objectOutput) {
            objectOutput.writeLong(this.b);
            objectOutput.writeInt(this.c);
        }

        @Override // a.a.a.a.o
        public boolean a() {
            return true;
        }

        @Override // a.a.a.a.o
        public int b() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && this.c == aVar.c && Objects.equals(this.BG, aVar.BG);
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.b), Integer.valueOf(this.c), this.BG);
        }
    }

    /* loaded from: classes4.dex */
    public static final class b extends a.a.a.a.a.a.a {
        public final long b;
        public final Set<a> c;

        public b(int i, ObjectInput objectInput, Map<Long, e.a> map) {
            super(i);
            this.b = objectInput.readLong();
            int readInt = objectInput.readInt();
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < readInt; i2++) {
                hashSet.add(new a(objectInput.readInt(), objectInput, map, this));
            }
            this.c = Collections.unmodifiableSet(hashSet);
        }

        public b(JSONObject jSONObject, Map<Long, e.a> map) {
            super(0);
            this.b = a.a.a.a.a.b.b(jSONObject.optLong("tmout", 5000L), 100L, 30000L);
            HashSet hashSet = new HashSet();
            JSONArray jSONArray = jSONObject.getJSONArray("pids");
            for (int i = 0; i < jSONArray.length(); i++) {
                hashSet.add(new a(jSONArray.getJSONObject(i), map, this));
            }
            this.c = Collections.unmodifiableSet(hashSet);
        }

        @Override // a.a.a.a.a.a.a
        public void a(ObjectOutput objectOutput) {
            objectOutput.writeLong(this.b);
            objectOutput.writeInt(this.c.size());
            for (a aVar : this.c) {
                objectOutput.writeInt(aVar.f952a);
                aVar.a(objectOutput);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && Objects.equals(this.c, bVar.c);
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.b), this.c);
        }
    }

    public c(int i, ObjectInput objectInput, Map<Long, e.a> map) {
        super(i);
        this.b = objectInput.readUTF();
        int readInt = objectInput.readInt();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(new b(objectInput.readInt(), objectInput, map));
        }
        this.c = Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(JSONObject jSONObject, Map<Long, e.a> map) {
        super(0);
        this.b = jSONObject.getString(UbcStatConstant.KEY_CONTENT_EXT_SID);
        JSONArray jSONArray = jSONObject.getJSONArray("pGroups");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new b(jSONArray.getJSONObject(i), map));
        }
        this.c = Collections.unmodifiableList(arrayList);
    }

    @Override // a.a.a.a.a.a.a
    public void a(ObjectOutput objectOutput) {
        objectOutput.writeUTF(this.b);
        objectOutput.writeInt(this.c.size());
        for (b bVar : this.c) {
            objectOutput.writeInt(bVar.f952a);
            bVar.a(objectOutput);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return Objects.equals(this.b, cVar.b) && Objects.equals(this.c, cVar.c);
    }

    public int hashCode() {
        return Objects.hash(this.b, this.c);
    }
}

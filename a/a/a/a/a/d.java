package a.a.a.a.a;

import a.a.a.a.a.e;
import a.a.a.a.o;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class d extends a.a.a.a.a.a.a {
    public final String b;
    public final long c;
    public final long d;
    public final Set<b> e;

    /* loaded from: classes4.dex */
    public static final class a extends a.a.a.a.a.a.a implements o {
        public final e.a BG;
        public final b BH;
        public final long b;
        public final int c;

        public a(int i, ObjectInput objectInput, Map<Long, e.a> map, b bVar) {
            super(i);
            this.BH = bVar;
            this.b = objectInput.readLong();
            this.c = objectInput.readInt();
            this.BG = map.get(Long.valueOf(this.b));
        }

        public a(JSONObject jSONObject, Map<Long, e.a> map, b bVar) {
            super(0);
            this.BH = bVar;
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
    public static final class b extends a.a.a.a.a.a.a implements o {
        public final int b;
        public final Set<a> c;

        public b(int i, ObjectInput objectInput, Map<Long, e.a> map) {
            super(i);
            this.b = objectInput.readInt();
            int readInt = objectInput.readInt();
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < readInt; i2++) {
                hashSet.add(new a(objectInput.readInt(), objectInput, map, this));
            }
            this.c = Collections.unmodifiableSet(hashSet);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(JSONObject jSONObject, Map<Long, e.a> map) {
            super(0);
            this.b = a.a.a.a.a.b.a(jSONObject.getInt("weight"), 0);
            HashSet hashSet = new HashSet();
            JSONArray jSONArray = jSONObject.getJSONArray("pids");
            for (int i = 0; i < jSONArray.length(); i++) {
                hashSet.add(new a(jSONArray.getJSONObject(i), map, this));
            }
            this.c = Collections.unmodifiableSet(hashSet);
        }

        @Override // a.a.a.a.a.a.a
        public void a(ObjectOutput objectOutput) {
            objectOutput.writeInt(this.b);
            objectOutput.writeInt(this.c.size());
            for (a aVar : this.c) {
                objectOutput.writeInt(aVar.f952a);
                aVar.a(objectOutput);
            }
        }

        @Override // a.a.a.a.o
        public boolean a() {
            return true;
        }

        @Override // a.a.a.a.o
        public int b() {
            return this.b;
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
            return Objects.hash(Integer.valueOf(this.b), this.c);
        }
    }

    public d(int i, ObjectInput objectInput, Map<Long, e.a> map) {
        super(i);
        this.b = objectInput.readUTF();
        this.c = objectInput.readLong();
        this.d = objectInput.readLong();
        int readInt = objectInput.readInt();
        HashSet hashSet = new HashSet(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            hashSet.add(new b(objectInput.readInt(), objectInput, map));
        }
        this.e = Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(JSONObject jSONObject, Map<Long, e.a> map) {
        super(0);
        this.b = jSONObject.getString(UbcStatConstant.KEY_CONTENT_EXT_SID);
        this.c = a.a.a.a.a.b.a(jSONObject.getLong("wt"), 0L);
        this.d = a.a.a.a.a.b.a(jSONObject.getLong("tmout"), 0L);
        JSONArray jSONArray = jSONObject.getJSONArray("pGroups");
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(new b(jSONArray.getJSONObject(i), map));
        }
        this.e = Collections.unmodifiableSet(hashSet);
    }

    @Override // a.a.a.a.a.a.a
    public void a(ObjectOutput objectOutput) {
        objectOutput.writeUTF(this.b);
        objectOutput.writeLong(this.c);
        objectOutput.writeLong(this.d);
        objectOutput.writeInt(this.e.size());
        for (b bVar : this.e) {
            objectOutput.writeInt(bVar.f952a);
            bVar.a(objectOutput);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.c == dVar.c && this.d == dVar.d && Objects.equals(this.b, dVar.b) && Objects.equals(this.e, dVar.e);
    }

    public int hashCode() {
        return Objects.hash(this.b, Long.valueOf(this.c), Long.valueOf(this.d), this.e);
    }
}

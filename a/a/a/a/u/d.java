package a.a.a.a.u;

import a.a.a.a.p;
import a.a.a.a.u.e;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class d extends a.a.a.a.u.f.a {

    /* renamed from: b  reason: collision with root package name */
    public final String f1320b;

    /* renamed from: c  reason: collision with root package name */
    public final long f1321c;

    /* renamed from: d  reason: collision with root package name */
    public final long f1322d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<b> f1323e;

    /* loaded from: classes.dex */
    public static final class a extends a.a.a.a.u.f.a implements p {

        /* renamed from: b  reason: collision with root package name */
        public final long f1324b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1325c;

        /* renamed from: d  reason: collision with root package name */
        public final e.a f1326d;

        /* renamed from: e  reason: collision with root package name */
        public final b f1327e;

        public a(int i2, ObjectInput objectInput, Map<Long, e.a> map, b bVar) {
            super(i2);
            this.f1327e = bVar;
            this.f1324b = objectInput.readLong();
            this.f1325c = objectInput.readInt();
            this.f1326d = map.get(Long.valueOf(this.f1324b));
        }

        public a(JSONObject jSONObject, Map<Long, e.a> map, b bVar) {
            super(0);
            this.f1327e = bVar;
            this.f1324b = a.a.a.a.u.b.a(jSONObject.getLong("id"), 0L);
            this.f1325c = a.a.a.a.u.b.a(jSONObject.getInt("weight"), 0);
            this.f1326d = map.get(Long.valueOf(this.f1324b));
        }

        @Override // a.a.a.a.u.f.a
        public void a(ObjectOutput objectOutput) {
            objectOutput.writeLong(this.f1324b);
            objectOutput.writeInt(this.f1325c);
        }

        @Override // a.a.a.a.p
        public boolean a() {
            return true;
        }

        @Override // a.a.a.a.p
        public int b() {
            return this.f1325c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1324b == aVar.f1324b && this.f1325c == aVar.f1325c && Objects.equals(this.f1326d, aVar.f1326d);
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.f1324b), Integer.valueOf(this.f1325c), this.f1326d);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends a.a.a.a.u.f.a implements p {

        /* renamed from: b  reason: collision with root package name */
        public final int f1328b;

        /* renamed from: c  reason: collision with root package name */
        public final Set<a> f1329c;

        public b(int i2, ObjectInput objectInput, Map<Long, e.a> map) {
            super(i2);
            this.f1328b = objectInput.readInt();
            int readInt = objectInput.readInt();
            HashSet hashSet = new HashSet();
            for (int i3 = 0; i3 < readInt; i3++) {
                hashSet.add(new a(objectInput.readInt(), objectInput, map, this));
            }
            this.f1329c = Collections.unmodifiableSet(hashSet);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(JSONObject jSONObject, Map<Long, e.a> map) {
            super(0);
            this.f1328b = a.a.a.a.u.b.a(jSONObject.getInt("weight"), 0);
            HashSet hashSet = new HashSet();
            JSONArray jSONArray = jSONObject.getJSONArray(TiebaStatic.Params.PID_MERGE);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                hashSet.add(new a(jSONArray.getJSONObject(i2), map, this));
            }
            this.f1329c = Collections.unmodifiableSet(hashSet);
        }

        @Override // a.a.a.a.u.f.a
        public void a(ObjectOutput objectOutput) {
            objectOutput.writeInt(this.f1328b);
            objectOutput.writeInt(this.f1329c.size());
            for (a aVar : this.f1329c) {
                objectOutput.writeInt(aVar.f1341a);
                aVar.a(objectOutput);
            }
        }

        @Override // a.a.a.a.p
        public boolean a() {
            return true;
        }

        @Override // a.a.a.a.p
        public int b() {
            return this.f1328b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f1328b == bVar.f1328b && Objects.equals(this.f1329c, bVar.f1329c);
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f1328b), this.f1329c);
        }
    }

    public d(int i2, ObjectInput objectInput, Map<Long, e.a> map) {
        super(i2);
        this.f1320b = objectInput.readUTF();
        this.f1321c = objectInput.readLong();
        this.f1322d = objectInput.readLong();
        int readInt = objectInput.readInt();
        HashSet hashSet = new HashSet(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            hashSet.add(new b(objectInput.readInt(), objectInput, map));
        }
        this.f1323e = Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(JSONObject jSONObject, Map<Long, e.a> map) {
        super(0);
        this.f1320b = jSONObject.getString("sid");
        this.f1321c = a.a.a.a.u.b.a(jSONObject.getLong("wt"), 0L);
        this.f1322d = a.a.a.a.u.b.a(jSONObject.getLong("tmout"), 0L);
        JSONArray jSONArray = jSONObject.getJSONArray("pGroups");
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            hashSet.add(new b(jSONArray.getJSONObject(i2), map));
        }
        this.f1323e = Collections.unmodifiableSet(hashSet);
    }

    @Override // a.a.a.a.u.f.a
    public void a(ObjectOutput objectOutput) {
        objectOutput.writeUTF(this.f1320b);
        objectOutput.writeLong(this.f1321c);
        objectOutput.writeLong(this.f1322d);
        objectOutput.writeInt(this.f1323e.size());
        for (b bVar : this.f1323e) {
            objectOutput.writeInt(bVar.f1341a);
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
        return this.f1321c == dVar.f1321c && this.f1322d == dVar.f1322d && Objects.equals(this.f1320b, dVar.f1320b) && Objects.equals(this.f1323e, dVar.f1323e);
    }

    public int hashCode() {
        return Objects.hash(this.f1320b, Long.valueOf(this.f1321c), Long.valueOf(this.f1322d), this.f1323e);
    }
}

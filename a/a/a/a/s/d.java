package a.a.a.a.s;

import a.a.a.a.n;
import a.a.a.a.s.e;
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
public final class d extends a.a.a.a.s.f.a {

    /* renamed from: b  reason: collision with root package name */
    public final String f1306b;

    /* renamed from: c  reason: collision with root package name */
    public final long f1307c;

    /* renamed from: d  reason: collision with root package name */
    public final long f1308d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<b> f1309e;

    /* loaded from: classes.dex */
    public static final class a extends a.a.a.a.s.f.a implements n {

        /* renamed from: b  reason: collision with root package name */
        public final long f1310b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1311c;

        /* renamed from: d  reason: collision with root package name */
        public final e.a f1312d;

        /* renamed from: e  reason: collision with root package name */
        public final b f1313e;

        public a(int i, ObjectInput objectInput, Map<Long, e.a> map, b bVar) {
            super(i);
            this.f1313e = bVar;
            this.f1310b = objectInput.readLong();
            this.f1311c = objectInput.readInt();
            this.f1312d = map.get(Long.valueOf(this.f1310b));
        }

        public a(JSONObject jSONObject, Map<Long, e.a> map, b bVar) {
            super(0);
            this.f1313e = bVar;
            this.f1310b = a.a.a.a.s.b.a(jSONObject.getLong("id"), 0L);
            this.f1311c = a.a.a.a.s.b.a(jSONObject.getInt("weight"), 0);
            this.f1312d = map.get(Long.valueOf(this.f1310b));
        }

        @Override // a.a.a.a.s.f.a
        public void a(ObjectOutput objectOutput) {
            objectOutput.writeLong(this.f1310b);
            objectOutput.writeInt(this.f1311c);
        }

        @Override // a.a.a.a.n
        public boolean a() {
            return true;
        }

        @Override // a.a.a.a.n
        public int b() {
            return this.f1311c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1310b == aVar.f1310b && this.f1311c == aVar.f1311c && Objects.equals(this.f1312d, aVar.f1312d);
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.f1310b), Integer.valueOf(this.f1311c), this.f1312d);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends a.a.a.a.s.f.a implements n {

        /* renamed from: b  reason: collision with root package name */
        public final int f1314b;

        /* renamed from: c  reason: collision with root package name */
        public final Set<a> f1315c;

        public b(int i, ObjectInput objectInput, Map<Long, e.a> map) {
            super(i);
            this.f1314b = objectInput.readInt();
            int readInt = objectInput.readInt();
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < readInt; i2++) {
                hashSet.add(new a(objectInput.readInt(), objectInput, map, this));
            }
            this.f1315c = Collections.unmodifiableSet(hashSet);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(JSONObject jSONObject, Map<Long, e.a> map) {
            super(0);
            this.f1314b = a.a.a.a.s.b.a(jSONObject.getInt("weight"), 0);
            HashSet hashSet = new HashSet();
            JSONArray jSONArray = jSONObject.getJSONArray(TiebaStatic.Params.PID_MERGE);
            for (int i = 0; i < jSONArray.length(); i++) {
                hashSet.add(new a(jSONArray.getJSONObject(i), map, this));
            }
            this.f1315c = Collections.unmodifiableSet(hashSet);
        }

        @Override // a.a.a.a.s.f.a
        public void a(ObjectOutput objectOutput) {
            objectOutput.writeInt(this.f1314b);
            objectOutput.writeInt(this.f1315c.size());
            for (a aVar : this.f1315c) {
                objectOutput.writeInt(aVar.f1326a);
                aVar.a(objectOutput);
            }
        }

        @Override // a.a.a.a.n
        public boolean a() {
            return true;
        }

        @Override // a.a.a.a.n
        public int b() {
            return this.f1314b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f1314b == bVar.f1314b && Objects.equals(this.f1315c, bVar.f1315c);
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f1314b), this.f1315c);
        }
    }

    public d(int i, ObjectInput objectInput, Map<Long, e.a> map) {
        super(i);
        this.f1306b = objectInput.readUTF();
        this.f1307c = objectInput.readLong();
        this.f1308d = objectInput.readLong();
        int readInt = objectInput.readInt();
        HashSet hashSet = new HashSet(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            hashSet.add(new b(objectInput.readInt(), objectInput, map));
        }
        this.f1309e = Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(JSONObject jSONObject, Map<Long, e.a> map) {
        super(0);
        this.f1306b = jSONObject.getString("sid");
        this.f1307c = a.a.a.a.s.b.a(jSONObject.getLong("wt"), 0L);
        this.f1308d = a.a.a.a.s.b.a(jSONObject.getLong("tmout"), 0L);
        JSONArray jSONArray = jSONObject.getJSONArray("pGroups");
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(new b(jSONArray.getJSONObject(i), map));
        }
        this.f1309e = Collections.unmodifiableSet(hashSet);
    }

    @Override // a.a.a.a.s.f.a
    public void a(ObjectOutput objectOutput) {
        objectOutput.writeUTF(this.f1306b);
        objectOutput.writeLong(this.f1307c);
        objectOutput.writeLong(this.f1308d);
        objectOutput.writeInt(this.f1309e.size());
        for (b bVar : this.f1309e) {
            objectOutput.writeInt(bVar.f1326a);
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
        return this.f1307c == dVar.f1307c && this.f1308d == dVar.f1308d && Objects.equals(this.f1306b, dVar.f1306b) && Objects.equals(this.f1309e, dVar.f1309e);
    }

    public int hashCode() {
        return Objects.hash(this.f1306b, Long.valueOf(this.f1307c), Long.valueOf(this.f1308d), this.f1309e);
    }
}

package a.a.a.a.v;

import a.a.a.a.q;
import a.a.a.a.v.e;
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
public final class d extends a.a.a.a.v.f.a {

    /* renamed from: b  reason: collision with root package name */
    public final String f1328b;

    /* renamed from: c  reason: collision with root package name */
    public final long f1329c;

    /* renamed from: d  reason: collision with root package name */
    public final long f1330d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<b> f1331e;

    /* loaded from: classes.dex */
    public static final class a extends a.a.a.a.v.f.a implements q {

        /* renamed from: b  reason: collision with root package name */
        public final long f1332b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1333c;

        /* renamed from: d  reason: collision with root package name */
        public final e.a f1334d;

        /* renamed from: e  reason: collision with root package name */
        public final b f1335e;

        public a(int i2, ObjectInput objectInput, Map<Long, e.a> map, b bVar) {
            super(i2);
            this.f1335e = bVar;
            this.f1332b = objectInput.readLong();
            this.f1333c = objectInput.readInt();
            this.f1334d = map.get(Long.valueOf(this.f1332b));
        }

        public a(JSONObject jSONObject, Map<Long, e.a> map, b bVar) {
            super(0);
            this.f1335e = bVar;
            this.f1332b = a.a.a.a.v.b.a(jSONObject.getLong("id"), 0L);
            this.f1333c = a.a.a.a.v.b.a(jSONObject.getInt("weight"), 0);
            this.f1334d = map.get(Long.valueOf(this.f1332b));
        }

        @Override // a.a.a.a.v.f.a
        public void a(ObjectOutput objectOutput) {
            objectOutput.writeLong(this.f1332b);
            objectOutput.writeInt(this.f1333c);
        }

        @Override // a.a.a.a.q
        public boolean a() {
            return true;
        }

        @Override // a.a.a.a.q
        public int b() {
            return this.f1333c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1332b == aVar.f1332b && this.f1333c == aVar.f1333c && Objects.equals(this.f1334d, aVar.f1334d);
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.f1332b), Integer.valueOf(this.f1333c), this.f1334d);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends a.a.a.a.v.f.a implements q {

        /* renamed from: b  reason: collision with root package name */
        public final int f1336b;

        /* renamed from: c  reason: collision with root package name */
        public final Set<a> f1337c;

        public b(int i2, ObjectInput objectInput, Map<Long, e.a> map) {
            super(i2);
            this.f1336b = objectInput.readInt();
            int readInt = objectInput.readInt();
            HashSet hashSet = new HashSet();
            for (int i3 = 0; i3 < readInt; i3++) {
                hashSet.add(new a(objectInput.readInt(), objectInput, map, this));
            }
            this.f1337c = Collections.unmodifiableSet(hashSet);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(JSONObject jSONObject, Map<Long, e.a> map) {
            super(0);
            this.f1336b = a.a.a.a.v.b.a(jSONObject.getInt("weight"), 0);
            HashSet hashSet = new HashSet();
            JSONArray jSONArray = jSONObject.getJSONArray(TiebaStatic.Params.PID_MERGE);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                hashSet.add(new a(jSONArray.getJSONObject(i2), map, this));
            }
            this.f1337c = Collections.unmodifiableSet(hashSet);
        }

        @Override // a.a.a.a.v.f.a
        public void a(ObjectOutput objectOutput) {
            objectOutput.writeInt(this.f1336b);
            objectOutput.writeInt(this.f1337c.size());
            for (a aVar : this.f1337c) {
                objectOutput.writeInt(aVar.f1349a);
                aVar.a(objectOutput);
            }
        }

        @Override // a.a.a.a.q
        public boolean a() {
            return true;
        }

        @Override // a.a.a.a.q
        public int b() {
            return this.f1336b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f1336b == bVar.f1336b && Objects.equals(this.f1337c, bVar.f1337c);
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f1336b), this.f1337c);
        }
    }

    public d(int i2, ObjectInput objectInput, Map<Long, e.a> map) {
        super(i2);
        this.f1328b = objectInput.readUTF();
        this.f1329c = objectInput.readLong();
        this.f1330d = objectInput.readLong();
        int readInt = objectInput.readInt();
        HashSet hashSet = new HashSet(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            hashSet.add(new b(objectInput.readInt(), objectInput, map));
        }
        this.f1331e = Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(JSONObject jSONObject, Map<Long, e.a> map) {
        super(0);
        this.f1328b = jSONObject.getString("sid");
        this.f1329c = a.a.a.a.v.b.a(jSONObject.getLong("wt"), 0L);
        this.f1330d = a.a.a.a.v.b.a(jSONObject.getLong("tmout"), 0L);
        JSONArray jSONArray = jSONObject.getJSONArray("pGroups");
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            hashSet.add(new b(jSONArray.getJSONObject(i2), map));
        }
        this.f1331e = Collections.unmodifiableSet(hashSet);
    }

    @Override // a.a.a.a.v.f.a
    public void a(ObjectOutput objectOutput) {
        objectOutput.writeUTF(this.f1328b);
        objectOutput.writeLong(this.f1329c);
        objectOutput.writeLong(this.f1330d);
        objectOutput.writeInt(this.f1331e.size());
        for (b bVar : this.f1331e) {
            objectOutput.writeInt(bVar.f1349a);
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
        return this.f1329c == dVar.f1329c && this.f1330d == dVar.f1330d && Objects.equals(this.f1328b, dVar.f1328b) && Objects.equals(this.f1331e, dVar.f1331e);
    }

    public int hashCode() {
        return Objects.hash(this.f1328b, Long.valueOf(this.f1329c), Long.valueOf(this.f1330d), this.f1331e);
    }
}

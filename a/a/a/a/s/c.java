package a.a.a.a.s;

import a.a.a.a.n;
import a.a.a.a.s.e;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.tbadk.core.util.TiebaStatic;
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
/* loaded from: classes.dex */
public final class c extends a.a.a.a.s.f.a {

    /* renamed from: b  reason: collision with root package name */
    public final String f1299b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b> f1300c;

    /* loaded from: classes.dex */
    public static final class a extends a.a.a.a.s.f.a implements n {

        /* renamed from: b  reason: collision with root package name */
        public final long f1301b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1302c;

        /* renamed from: d  reason: collision with root package name */
        public final e.a f1303d;

        public a(int i, ObjectInput objectInput, Map<Long, e.a> map, b bVar) {
            super(i);
            this.f1301b = objectInput.readLong();
            this.f1302c = objectInput.readInt();
            this.f1303d = map.get(Long.valueOf(this.f1301b));
        }

        public a(JSONObject jSONObject, Map<Long, e.a> map, b bVar) {
            super(0);
            this.f1301b = a.a.a.a.s.b.a(jSONObject.getLong("id"), 0L);
            this.f1302c = a.a.a.a.s.b.a(jSONObject.getInt("weight"), 0);
            this.f1303d = map.get(Long.valueOf(this.f1301b));
        }

        @Override // a.a.a.a.s.f.a
        public void a(ObjectOutput objectOutput) {
            objectOutput.writeLong(this.f1301b);
            objectOutput.writeInt(this.f1302c);
        }

        @Override // a.a.a.a.n
        public boolean a() {
            return true;
        }

        @Override // a.a.a.a.n
        public int b() {
            return this.f1302c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1301b == aVar.f1301b && this.f1302c == aVar.f1302c && Objects.equals(this.f1303d, aVar.f1303d);
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.f1301b), Integer.valueOf(this.f1302c), this.f1303d);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends a.a.a.a.s.f.a {

        /* renamed from: b  reason: collision with root package name */
        public final long f1304b;

        /* renamed from: c  reason: collision with root package name */
        public final Set<a> f1305c;

        public b(int i, ObjectInput objectInput, Map<Long, e.a> map) {
            super(i);
            this.f1304b = objectInput.readLong();
            int readInt = objectInput.readInt();
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < readInt; i2++) {
                hashSet.add(new a(objectInput.readInt(), objectInput, map, this));
            }
            this.f1305c = Collections.unmodifiableSet(hashSet);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(JSONObject jSONObject, Map<Long, e.a> map) {
            super(0);
            this.f1304b = a.a.a.a.s.b.a(jSONObject.optLong("tmout", 5000L), 100L, (long) StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
            HashSet hashSet = new HashSet();
            JSONArray jSONArray = jSONObject.getJSONArray(TiebaStatic.Params.PID_MERGE);
            for (int i = 0; i < jSONArray.length(); i++) {
                hashSet.add(new a(jSONArray.getJSONObject(i), map, this));
            }
            this.f1305c = Collections.unmodifiableSet(hashSet);
        }

        @Override // a.a.a.a.s.f.a
        public void a(ObjectOutput objectOutput) {
            objectOutput.writeLong(this.f1304b);
            objectOutput.writeInt(this.f1305c.size());
            for (a aVar : this.f1305c) {
                objectOutput.writeInt(aVar.f1326a);
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
            return this.f1304b == bVar.f1304b && Objects.equals(this.f1305c, bVar.f1305c);
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.f1304b), this.f1305c);
        }
    }

    public c(int i, ObjectInput objectInput, Map<Long, e.a> map) {
        super(i);
        this.f1299b = objectInput.readUTF();
        int readInt = objectInput.readInt();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(new b(objectInput.readInt(), objectInput, map));
        }
        this.f1300c = Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(JSONObject jSONObject, Map<Long, e.a> map) {
        super(0);
        this.f1299b = jSONObject.getString("sid");
        JSONArray jSONArray = jSONObject.getJSONArray("pGroups");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new b(jSONArray.getJSONObject(i), map));
        }
        this.f1300c = Collections.unmodifiableList(arrayList);
    }

    @Override // a.a.a.a.s.f.a
    public void a(ObjectOutput objectOutput) {
        objectOutput.writeUTF(this.f1299b);
        objectOutput.writeInt(this.f1300c.size());
        for (b bVar : this.f1300c) {
            objectOutput.writeInt(bVar.f1326a);
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
        return Objects.equals(this.f1299b, cVar.f1299b) && Objects.equals(this.f1300c, cVar.f1300c);
    }

    public int hashCode() {
        return Objects.hash(this.f1299b, this.f1300c);
    }
}

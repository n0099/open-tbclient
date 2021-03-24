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
    public final String f1313b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b> f1314c;

    /* loaded from: classes.dex */
    public static final class a extends a.a.a.a.s.f.a implements n {

        /* renamed from: b  reason: collision with root package name */
        public final long f1315b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1316c;

        /* renamed from: d  reason: collision with root package name */
        public final e.a f1317d;

        public a(int i, ObjectInput objectInput, Map<Long, e.a> map, b bVar) {
            super(i);
            this.f1315b = objectInput.readLong();
            this.f1316c = objectInput.readInt();
            this.f1317d = map.get(Long.valueOf(this.f1315b));
        }

        public a(JSONObject jSONObject, Map<Long, e.a> map, b bVar) {
            super(0);
            this.f1315b = a.a.a.a.s.b.a(jSONObject.getLong("id"), 0L);
            this.f1316c = a.a.a.a.s.b.a(jSONObject.getInt("weight"), 0);
            this.f1317d = map.get(Long.valueOf(this.f1315b));
        }

        @Override // a.a.a.a.s.f.a
        public void a(ObjectOutput objectOutput) {
            objectOutput.writeLong(this.f1315b);
            objectOutput.writeInt(this.f1316c);
        }

        @Override // a.a.a.a.n
        public boolean a() {
            return true;
        }

        @Override // a.a.a.a.n
        public int b() {
            return this.f1316c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1315b == aVar.f1315b && this.f1316c == aVar.f1316c && Objects.equals(this.f1317d, aVar.f1317d);
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.f1315b), Integer.valueOf(this.f1316c), this.f1317d);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends a.a.a.a.s.f.a {

        /* renamed from: b  reason: collision with root package name */
        public final long f1318b;

        /* renamed from: c  reason: collision with root package name */
        public final Set<a> f1319c;

        public b(int i, ObjectInput objectInput, Map<Long, e.a> map) {
            super(i);
            this.f1318b = objectInput.readLong();
            int readInt = objectInput.readInt();
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < readInt; i2++) {
                hashSet.add(new a(objectInput.readInt(), objectInput, map, this));
            }
            this.f1319c = Collections.unmodifiableSet(hashSet);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(JSONObject jSONObject, Map<Long, e.a> map) {
            super(0);
            this.f1318b = a.a.a.a.s.b.a(jSONObject.optLong("tmout", 5000L), 100L, (long) StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
            HashSet hashSet = new HashSet();
            JSONArray jSONArray = jSONObject.getJSONArray(TiebaStatic.Params.PID_MERGE);
            for (int i = 0; i < jSONArray.length(); i++) {
                hashSet.add(new a(jSONArray.getJSONObject(i), map, this));
            }
            this.f1319c = Collections.unmodifiableSet(hashSet);
        }

        @Override // a.a.a.a.s.f.a
        public void a(ObjectOutput objectOutput) {
            objectOutput.writeLong(this.f1318b);
            objectOutput.writeInt(this.f1319c.size());
            for (a aVar : this.f1319c) {
                objectOutput.writeInt(aVar.f1340a);
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
            return this.f1318b == bVar.f1318b && Objects.equals(this.f1319c, bVar.f1319c);
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.f1318b), this.f1319c);
        }
    }

    public c(int i, ObjectInput objectInput, Map<Long, e.a> map) {
        super(i);
        this.f1313b = objectInput.readUTF();
        int readInt = objectInput.readInt();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(new b(objectInput.readInt(), objectInput, map));
        }
        this.f1314c = Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(JSONObject jSONObject, Map<Long, e.a> map) {
        super(0);
        this.f1313b = jSONObject.getString("sid");
        JSONArray jSONArray = jSONObject.getJSONArray("pGroups");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new b(jSONArray.getJSONObject(i), map));
        }
        this.f1314c = Collections.unmodifiableList(arrayList);
    }

    @Override // a.a.a.a.s.f.a
    public void a(ObjectOutput objectOutput) {
        objectOutput.writeUTF(this.f1313b);
        objectOutput.writeInt(this.f1314c.size());
        for (b bVar : this.f1314c) {
            objectOutput.writeInt(bVar.f1340a);
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
        return Objects.equals(this.f1313b, cVar.f1313b) && Objects.equals(this.f1314c, cVar.f1314c);
    }

    public int hashCode() {
        return Objects.hash(this.f1313b, this.f1314c);
    }
}

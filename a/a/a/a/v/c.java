package a.a.a.a.v;

import a.a.a.a.q;
import a.a.a.a.v.e;
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
public final class c extends a.a.a.a.v.f.a {

    /* renamed from: b  reason: collision with root package name */
    public final String f1321b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b> f1322c;

    /* loaded from: classes.dex */
    public static final class a extends a.a.a.a.v.f.a implements q {

        /* renamed from: b  reason: collision with root package name */
        public final long f1323b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1324c;

        /* renamed from: d  reason: collision with root package name */
        public final e.a f1325d;

        public a(int i2, ObjectInput objectInput, Map<Long, e.a> map, b bVar) {
            super(i2);
            this.f1323b = objectInput.readLong();
            this.f1324c = objectInput.readInt();
            this.f1325d = map.get(Long.valueOf(this.f1323b));
        }

        public a(JSONObject jSONObject, Map<Long, e.a> map, b bVar) {
            super(0);
            this.f1323b = a.a.a.a.v.b.a(jSONObject.getLong("id"), 0L);
            this.f1324c = a.a.a.a.v.b.a(jSONObject.getInt("weight"), 0);
            this.f1325d = map.get(Long.valueOf(this.f1323b));
        }

        @Override // a.a.a.a.v.f.a
        public void a(ObjectOutput objectOutput) {
            objectOutput.writeLong(this.f1323b);
            objectOutput.writeInt(this.f1324c);
        }

        @Override // a.a.a.a.q
        public boolean a() {
            return true;
        }

        @Override // a.a.a.a.q
        public int b() {
            return this.f1324c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1323b == aVar.f1323b && this.f1324c == aVar.f1324c && Objects.equals(this.f1325d, aVar.f1325d);
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.f1323b), Integer.valueOf(this.f1324c), this.f1325d);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends a.a.a.a.v.f.a {

        /* renamed from: b  reason: collision with root package name */
        public final long f1326b;

        /* renamed from: c  reason: collision with root package name */
        public final Set<a> f1327c;

        public b(int i2, ObjectInput objectInput, Map<Long, e.a> map) {
            super(i2);
            this.f1326b = objectInput.readLong();
            int readInt = objectInput.readInt();
            HashSet hashSet = new HashSet();
            for (int i3 = 0; i3 < readInt; i3++) {
                hashSet.add(new a(objectInput.readInt(), objectInput, map, this));
            }
            this.f1327c = Collections.unmodifiableSet(hashSet);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(JSONObject jSONObject, Map<Long, e.a> map) {
            super(0);
            this.f1326b = a.a.a.a.v.b.a(jSONObject.optLong("tmout", 5000L), 100L, 30000L);
            HashSet hashSet = new HashSet();
            JSONArray jSONArray = jSONObject.getJSONArray(TiebaStatic.Params.PID_MERGE);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                hashSet.add(new a(jSONArray.getJSONObject(i2), map, this));
            }
            this.f1327c = Collections.unmodifiableSet(hashSet);
        }

        @Override // a.a.a.a.v.f.a
        public void a(ObjectOutput objectOutput) {
            objectOutput.writeLong(this.f1326b);
            objectOutput.writeInt(this.f1327c.size());
            for (a aVar : this.f1327c) {
                objectOutput.writeInt(aVar.f1349a);
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
            return this.f1326b == bVar.f1326b && Objects.equals(this.f1327c, bVar.f1327c);
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.f1326b), this.f1327c);
        }
    }

    public c(int i2, ObjectInput objectInput, Map<Long, e.a> map) {
        super(i2);
        this.f1321b = objectInput.readUTF();
        int readInt = objectInput.readInt();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(new b(objectInput.readInt(), objectInput, map));
        }
        this.f1322c = Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(JSONObject jSONObject, Map<Long, e.a> map) {
        super(0);
        this.f1321b = jSONObject.getString("sid");
        JSONArray jSONArray = jSONObject.getJSONArray("pGroups");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(new b(jSONArray.getJSONObject(i2), map));
        }
        this.f1322c = Collections.unmodifiableList(arrayList);
    }

    @Override // a.a.a.a.v.f.a
    public void a(ObjectOutput objectOutput) {
        objectOutput.writeUTF(this.f1321b);
        objectOutput.writeInt(this.f1322c.size());
        for (b bVar : this.f1322c) {
            objectOutput.writeInt(bVar.f1349a);
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
        return Objects.equals(this.f1321b, cVar.f1321b) && Objects.equals(this.f1322c, cVar.f1322c);
    }

    public int hashCode() {
        return Objects.hash(this.f1321b, this.f1322c);
    }
}

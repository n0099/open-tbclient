package a.a.a.a.s;

import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class e extends a.a.a.a.s.f.a {

    /* renamed from: b  reason: collision with root package name */
    public final String f1330b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1331c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<a> f1332d;

    /* loaded from: classes.dex */
    public static class a extends a.a.a.a.s.f.a {

        /* renamed from: b  reason: collision with root package name */
        public final long f1333b;

        /* renamed from: c  reason: collision with root package name */
        public final String f1334c;

        /* renamed from: d  reason: collision with root package name */
        public final String f1335d;

        /* renamed from: e  reason: collision with root package name */
        public final int f1336e;

        /* renamed from: f  reason: collision with root package name */
        public final float f1337f;

        /* renamed from: g  reason: collision with root package name */
        public final int f1338g;

        /* renamed from: h  reason: collision with root package name */
        public final int f1339h;
        public final int i;
        public final boolean j;
        public final e k;

        public a(int i, ObjectInput objectInput, e eVar) {
            super(i);
            this.k = eVar;
            this.f1333b = objectInput.readLong();
            this.f1334c = objectInput.readUTF();
            this.f1335d = objectInput.readUTF();
            this.f1336e = objectInput.readInt();
            this.f1337f = objectInput.readFloat();
            this.f1338g = objectInput.readInt();
            this.f1339h = objectInput.readInt();
            this.i = objectInput.readInt();
            if (i == 0) {
                objectInput.readInt();
                objectInput.readInt();
            }
            this.j = objectInput.readBoolean();
        }

        public a(JSONObject jSONObject, e eVar) {
            super(1);
            this.k = eVar;
            this.f1333b = b.a(jSONObject.getLong("id"), 0L);
            this.f1334c = jSONObject.getString("pid");
            this.f1335d = jSONObject.getString("type");
            this.f1336e = jSONObject.getInt("tmout");
            this.f1337f = b.a((float) jSONObject.optDouble("sample", 0.0d), 0.0f, 1.0f);
            this.f1338g = b.a(jSONObject.optInt("width", 0), 0);
            this.f1339h = b.a(jSONObject.optInt("height", 0), 0);
            this.i = b.a(jSONObject.optInt("interval", 30), 30);
            int optInt = jSONObject.optInt("orientation", 0);
            if (optInt != 0 && optInt != 1) {
                optInt = 0;
            }
            this.j = optInt == 1;
        }

        @Override // a.a.a.a.s.f.a
        public void a(ObjectOutput objectOutput) {
            objectOutput.writeLong(this.f1333b);
            objectOutput.writeUTF(this.f1334c);
            objectOutput.writeUTF(this.f1335d);
            objectOutput.writeInt(this.f1336e);
            objectOutput.writeFloat(this.f1337f);
            objectOutput.writeInt(this.f1338g);
            objectOutput.writeInt(this.f1339h);
            objectOutput.writeInt(this.i);
            objectOutput.writeBoolean(this.j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1333b == aVar.f1333b && this.f1336e == aVar.f1336e && Float.compare(aVar.f1337f, this.f1337f) == 0 && this.f1338g == aVar.f1338g && this.f1339h == aVar.f1339h && this.i == aVar.i && this.j == aVar.j && Objects.equals(this.f1334c, aVar.f1334c) && Objects.equals(this.f1335d, aVar.f1335d);
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.f1333b), this.f1334c, this.f1335d, Integer.valueOf(this.f1336e), Float.valueOf(this.f1337f), Integer.valueOf(this.f1338g), Integer.valueOf(this.f1339h), Integer.valueOf(this.i), Boolean.valueOf(this.j));
        }

        public String toString() {
            return "Pid{id=" + this.f1333b + ", pid='" + this.f1334c + "', type='" + this.f1335d + "', tmout='" + this.f1336e + "', sample='" + this.f1337f + "', width='" + this.f1338g + "', height='" + this.f1339h + "', interval='" + this.i + "', isHorizontal='" + this.j + "'}";
        }
    }

    public e(int i, ObjectInput objectInput) {
        super(i);
        this.f1330b = objectInput.readUTF();
        this.f1331c = objectInput.readUTF();
        int readInt = objectInput.readInt();
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < readInt; i2++) {
            hashSet.add(new a(objectInput.readInt(), objectInput, this));
        }
        this.f1332d = Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(JSONObject jSONObject) {
        super(0);
        this.f1330b = jSONObject.getString("sspId");
        this.f1331c = jSONObject.getString("type");
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray(TiebaStatic.Params.PID_MERGE);
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(new a(jSONArray.getJSONObject(i), this));
        }
        this.f1332d = Collections.unmodifiableSet(hashSet);
    }

    @Override // a.a.a.a.s.f.a
    public void a(ObjectOutput objectOutput) {
        objectOutput.writeUTF(this.f1330b);
        objectOutput.writeUTF(this.f1331c);
        objectOutput.writeInt(this.f1332d.size());
        for (a aVar : this.f1332d) {
            objectOutput.writeInt(aVar.f1340a);
            aVar.a(objectOutput);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return Objects.equals(this.f1330b, eVar.f1330b) && Objects.equals(this.f1331c, eVar.f1331c) && Objects.equals(this.f1332d, eVar.f1332d);
    }

    public int hashCode() {
        return Objects.hash(this.f1330b, this.f1331c, this.f1332d);
    }
}

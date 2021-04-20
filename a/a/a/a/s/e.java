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
    public final String f1316b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1317c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<a> f1318d;

    /* loaded from: classes.dex */
    public static class a extends a.a.a.a.s.f.a {

        /* renamed from: b  reason: collision with root package name */
        public final long f1319b;

        /* renamed from: c  reason: collision with root package name */
        public final String f1320c;

        /* renamed from: d  reason: collision with root package name */
        public final String f1321d;

        /* renamed from: e  reason: collision with root package name */
        public final int f1322e;

        /* renamed from: f  reason: collision with root package name */
        public final float f1323f;

        /* renamed from: g  reason: collision with root package name */
        public final int f1324g;

        /* renamed from: h  reason: collision with root package name */
        public final int f1325h;
        public final int i;
        public final boolean j;
        public final e k;

        public a(int i, ObjectInput objectInput, e eVar) {
            super(i);
            this.k = eVar;
            this.f1319b = objectInput.readLong();
            this.f1320c = objectInput.readUTF();
            this.f1321d = objectInput.readUTF();
            this.f1322e = objectInput.readInt();
            this.f1323f = objectInput.readFloat();
            this.f1324g = objectInput.readInt();
            this.f1325h = objectInput.readInt();
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
            this.f1319b = b.a(jSONObject.getLong("id"), 0L);
            this.f1320c = jSONObject.getString("pid");
            this.f1321d = jSONObject.getString("type");
            this.f1322e = jSONObject.getInt("tmout");
            this.f1323f = b.a((float) jSONObject.optDouble("sample", 0.0d), 0.0f, 1.0f);
            this.f1324g = b.a(jSONObject.optInt("width", 0), 0);
            this.f1325h = b.a(jSONObject.optInt("height", 0), 0);
            this.i = b.a(jSONObject.optInt("interval", 30), 30);
            int optInt = jSONObject.optInt("orientation", 0);
            if (optInt != 0 && optInt != 1) {
                optInt = 0;
            }
            this.j = optInt == 1;
        }

        @Override // a.a.a.a.s.f.a
        public void a(ObjectOutput objectOutput) {
            objectOutput.writeLong(this.f1319b);
            objectOutput.writeUTF(this.f1320c);
            objectOutput.writeUTF(this.f1321d);
            objectOutput.writeInt(this.f1322e);
            objectOutput.writeFloat(this.f1323f);
            objectOutput.writeInt(this.f1324g);
            objectOutput.writeInt(this.f1325h);
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
            return this.f1319b == aVar.f1319b && this.f1322e == aVar.f1322e && Float.compare(aVar.f1323f, this.f1323f) == 0 && this.f1324g == aVar.f1324g && this.f1325h == aVar.f1325h && this.i == aVar.i && this.j == aVar.j && Objects.equals(this.f1320c, aVar.f1320c) && Objects.equals(this.f1321d, aVar.f1321d);
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.f1319b), this.f1320c, this.f1321d, Integer.valueOf(this.f1322e), Float.valueOf(this.f1323f), Integer.valueOf(this.f1324g), Integer.valueOf(this.f1325h), Integer.valueOf(this.i), Boolean.valueOf(this.j));
        }

        public String toString() {
            return "Pid{id=" + this.f1319b + ", pid='" + this.f1320c + "', type='" + this.f1321d + "', tmout='" + this.f1322e + "', sample='" + this.f1323f + "', width='" + this.f1324g + "', height='" + this.f1325h + "', interval='" + this.i + "', isHorizontal='" + this.j + "'}";
        }
    }

    public e(int i, ObjectInput objectInput) {
        super(i);
        this.f1316b = objectInput.readUTF();
        this.f1317c = objectInput.readUTF();
        int readInt = objectInput.readInt();
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < readInt; i2++) {
            hashSet.add(new a(objectInput.readInt(), objectInput, this));
        }
        this.f1318d = Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(JSONObject jSONObject) {
        super(0);
        this.f1316b = jSONObject.getString("sspId");
        this.f1317c = jSONObject.getString("type");
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray(TiebaStatic.Params.PID_MERGE);
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(new a(jSONArray.getJSONObject(i), this));
        }
        this.f1318d = Collections.unmodifiableSet(hashSet);
    }

    @Override // a.a.a.a.s.f.a
    public void a(ObjectOutput objectOutput) {
        objectOutput.writeUTF(this.f1316b);
        objectOutput.writeUTF(this.f1317c);
        objectOutput.writeInt(this.f1318d.size());
        for (a aVar : this.f1318d) {
            objectOutput.writeInt(aVar.f1326a);
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
        return Objects.equals(this.f1316b, eVar.f1316b) && Objects.equals(this.f1317c, eVar.f1317c) && Objects.equals(this.f1318d, eVar.f1318d);
    }

    public int hashCode() {
        return Objects.hash(this.f1316b, this.f1317c, this.f1318d);
    }
}

package a.a.a.a.v;

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
public final class e extends a.a.a.a.v.f.a {

    /* renamed from: b  reason: collision with root package name */
    public final String f1338b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1339c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<a> f1340d;

    /* loaded from: classes.dex */
    public static class a extends a.a.a.a.v.f.a {

        /* renamed from: b  reason: collision with root package name */
        public final long f1341b;

        /* renamed from: c  reason: collision with root package name */
        public final String f1342c;

        /* renamed from: d  reason: collision with root package name */
        public final String f1343d;

        /* renamed from: e  reason: collision with root package name */
        public final int f1344e;

        /* renamed from: f  reason: collision with root package name */
        public final float f1345f;

        /* renamed from: g  reason: collision with root package name */
        public final int f1346g;

        /* renamed from: h  reason: collision with root package name */
        public final int f1347h;

        /* renamed from: i  reason: collision with root package name */
        public final int f1348i;
        public final boolean j;
        public final e k;

        public a(int i2, ObjectInput objectInput, e eVar) {
            super(i2);
            this.k = eVar;
            this.f1341b = objectInput.readLong();
            this.f1342c = objectInput.readUTF();
            this.f1343d = objectInput.readUTF();
            this.f1344e = objectInput.readInt();
            this.f1345f = objectInput.readFloat();
            this.f1346g = objectInput.readInt();
            this.f1347h = objectInput.readInt();
            this.f1348i = objectInput.readInt();
            if (i2 == 0) {
                objectInput.readInt();
                objectInput.readInt();
            }
            this.j = objectInput.readBoolean();
        }

        public a(JSONObject jSONObject, e eVar) {
            super(1);
            this.k = eVar;
            this.f1341b = b.a(jSONObject.getLong("id"), 0L);
            this.f1342c = jSONObject.getString("pid");
            this.f1343d = jSONObject.getString("type");
            this.f1344e = jSONObject.getInt("tmout");
            this.f1345f = b.a((float) jSONObject.optDouble("sample", 0.0d), 0.0f, 1.0f);
            this.f1346g = b.a(jSONObject.optInt("width", 0), 0);
            this.f1347h = b.a(jSONObject.optInt("height", 0), 0);
            this.f1348i = b.a(jSONObject.optInt("interval", 30), 30);
            int optInt = jSONObject.optInt("orientation", 0);
            if (optInt != 0 && optInt != 1) {
                optInt = 0;
            }
            this.j = optInt == 1;
        }

        @Override // a.a.a.a.v.f.a
        public void a(ObjectOutput objectOutput) {
            objectOutput.writeLong(this.f1341b);
            objectOutput.writeUTF(this.f1342c);
            objectOutput.writeUTF(this.f1343d);
            objectOutput.writeInt(this.f1344e);
            objectOutput.writeFloat(this.f1345f);
            objectOutput.writeInt(this.f1346g);
            objectOutput.writeInt(this.f1347h);
            objectOutput.writeInt(this.f1348i);
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
            return this.f1341b == aVar.f1341b && this.f1344e == aVar.f1344e && Float.compare(aVar.f1345f, this.f1345f) == 0 && this.f1346g == aVar.f1346g && this.f1347h == aVar.f1347h && this.f1348i == aVar.f1348i && this.j == aVar.j && Objects.equals(this.f1342c, aVar.f1342c) && Objects.equals(this.f1343d, aVar.f1343d);
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.f1341b), this.f1342c, this.f1343d, Integer.valueOf(this.f1344e), Float.valueOf(this.f1345f), Integer.valueOf(this.f1346g), Integer.valueOf(this.f1347h), Integer.valueOf(this.f1348i), Boolean.valueOf(this.j));
        }

        public String toString() {
            return "Pid{id=" + this.f1341b + ", pid='" + this.f1342c + "', type='" + this.f1343d + "', tmout='" + this.f1344e + "', sample='" + this.f1345f + "', width='" + this.f1346g + "', height='" + this.f1347h + "', interval='" + this.f1348i + "', isHorizontal='" + this.j + "'}";
        }
    }

    public e(int i2, ObjectInput objectInput) {
        super(i2);
        this.f1338b = objectInput.readUTF();
        this.f1339c = objectInput.readUTF();
        int readInt = objectInput.readInt();
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < readInt; i3++) {
            hashSet.add(new a(objectInput.readInt(), objectInput, this));
        }
        this.f1340d = Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(JSONObject jSONObject) {
        super(0);
        this.f1338b = jSONObject.getString("sspId");
        this.f1339c = jSONObject.getString("type");
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray(TiebaStatic.Params.PID_MERGE);
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            hashSet.add(new a(jSONArray.getJSONObject(i2), this));
        }
        this.f1340d = Collections.unmodifiableSet(hashSet);
    }

    @Override // a.a.a.a.v.f.a
    public void a(ObjectOutput objectOutput) {
        objectOutput.writeUTF(this.f1338b);
        objectOutput.writeUTF(this.f1339c);
        objectOutput.writeInt(this.f1340d.size());
        for (a aVar : this.f1340d) {
            objectOutput.writeInt(aVar.f1349a);
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
        return Objects.equals(this.f1338b, eVar.f1338b) && Objects.equals(this.f1339c, eVar.f1339c) && Objects.equals(this.f1340d, eVar.f1340d);
    }

    public int hashCode() {
        return Objects.hash(this.f1338b, this.f1339c, this.f1340d);
    }
}

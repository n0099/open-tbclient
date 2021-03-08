package a.a.a.a.a;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class e extends a.a.a.a.a.a.a {
    public final String b;
    public final String c;
    public final Set<a> d;

    /* loaded from: classes4.dex */
    public static class a extends a.a.a.a.a.a.a {
        public final e BI;
        public final long b;
        public final String c;
        public final String d;
        public final int e;
        public final float f;
        public final int g;
        public final int h;
        public final int i;
        public final boolean j;

        public a(int i, ObjectInput objectInput, e eVar) {
            super(i);
            this.BI = eVar;
            this.b = objectInput.readLong();
            this.c = objectInput.readUTF();
            this.d = objectInput.readUTF();
            this.e = objectInput.readInt();
            this.f = objectInput.readFloat();
            this.g = objectInput.readInt();
            this.h = objectInput.readInt();
            this.i = objectInput.readInt();
            if (i == 0) {
                objectInput.readInt();
                objectInput.readInt();
            }
            this.j = objectInput.readBoolean();
        }

        public a(JSONObject jSONObject, e eVar) {
            super(1);
            this.BI = eVar;
            this.b = b.a(jSONObject.getLong("id"), 0L);
            this.c = jSONObject.getString("pid");
            this.d = jSONObject.getString("type");
            this.e = jSONObject.getInt("tmout");
            this.f = b.a((float) jSONObject.optDouble("sample", 0.0d), 0.0f, 1.0f);
            this.g = b.a(jSONObject.optInt("width", 0), 0);
            this.h = b.a(jSONObject.optInt("height", 0), 0);
            this.i = b.a(jSONObject.optInt("interval", 30), 30);
            int optInt = jSONObject.optInt("orientation", 0);
            if (optInt != 0 && optInt != 1) {
                optInt = 0;
            }
            this.j = optInt == 1;
        }

        @Override // a.a.a.a.a.a.a
        public void a(ObjectOutput objectOutput) {
            objectOutput.writeLong(this.b);
            objectOutput.writeUTF(this.c);
            objectOutput.writeUTF(this.d);
            objectOutput.writeInt(this.e);
            objectOutput.writeFloat(this.f);
            objectOutput.writeInt(this.g);
            objectOutput.writeInt(this.h);
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
            return this.b == aVar.b && this.e == aVar.e && Float.compare(aVar.f, this.f) == 0 && this.g == aVar.g && this.h == aVar.h && this.i == aVar.i && this.j == aVar.j && Objects.equals(this.c, aVar.c) && Objects.equals(this.d, aVar.d);
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.b), this.c, this.d, Integer.valueOf(this.e), Float.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i), Boolean.valueOf(this.j));
        }

        public String toString() {
            return "Pid{id=" + this.b + ", pid='" + this.c + "', type='" + this.d + "', tmout='" + this.e + "', sample='" + this.f + "', width='" + this.g + "', height='" + this.h + "', interval='" + this.i + "', isHorizontal='" + this.j + "'}";
        }
    }

    public e(int i, ObjectInput objectInput) {
        super(i);
        this.b = objectInput.readUTF();
        this.c = objectInput.readUTF();
        int readInt = objectInput.readInt();
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < readInt; i2++) {
            hashSet.add(new a(objectInput.readInt(), objectInput, this));
        }
        this.d = Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(JSONObject jSONObject) {
        super(0);
        this.b = jSONObject.getString("sspId");
        this.c = jSONObject.getString("type");
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("pids");
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(new a(jSONArray.getJSONObject(i), this));
        }
        this.d = Collections.unmodifiableSet(hashSet);
    }

    @Override // a.a.a.a.a.a.a
    public void a(ObjectOutput objectOutput) {
        objectOutput.writeUTF(this.b);
        objectOutput.writeUTF(this.c);
        objectOutput.writeInt(this.d.size());
        for (a aVar : this.d) {
            objectOutput.writeInt(aVar.f952a);
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
        return Objects.equals(this.b, eVar.b) && Objects.equals(this.c, eVar.c) && Objects.equals(this.d, eVar.d);
    }

    public int hashCode() {
        return Objects.hash(this.b, this.c, this.d);
    }
}

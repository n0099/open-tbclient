package a.a.a.a.s;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class h extends a.a.a.a.s.n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final String f1357b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1358c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<a> f1359d;

    /* loaded from: classes.dex */
    public static class a extends a.a.a.a.s.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final long f1360b;

        /* renamed from: c  reason: collision with root package name */
        public final String f1361c;

        /* renamed from: d  reason: collision with root package name */
        public final String f1362d;

        /* renamed from: e  reason: collision with root package name */
        public final int f1363e;

        /* renamed from: f  reason: collision with root package name */
        public final float f1364f;

        /* renamed from: g  reason: collision with root package name */
        public final int f1365g;

        /* renamed from: h  reason: collision with root package name */
        public final int f1366h;

        /* renamed from: i  reason: collision with root package name */
        public final int f1367i;
        public final boolean j;
        public final double k;
        public final h l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, ObjectInput objectInput, h hVar) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), objectInput, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = hVar;
            this.f1360b = objectInput.readLong();
            this.f1361c = objectInput.readUTF();
            this.f1362d = objectInput.readUTF();
            this.f1363e = objectInput.readInt();
            this.f1364f = objectInput.readFloat();
            this.f1365g = objectInput.readInt();
            this.f1366h = objectInput.readInt();
            this.f1367i = objectInput.readInt();
            if (i2 == 0) {
                objectInput.readInt();
                objectInput.readInt();
            }
            this.j = objectInput.readBoolean();
            this.k = i2 >= 2 ? objectInput.readDouble() : 0.0d;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(JSONObject jSONObject, h hVar) {
            super(2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, hVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.l = hVar;
            this.f1360b = b.a(jSONObject.getLong("id"), 0L);
            this.f1361c = jSONObject.getString("pid");
            this.f1362d = jSONObject.getString("type");
            this.f1363e = jSONObject.getInt("tmout");
            this.f1364f = b.a((float) jSONObject.optDouble("sample", 0.0d), 0.0f, 1.0f);
            this.f1365g = b.a(jSONObject.optInt("width", 0), 0);
            this.f1366h = b.a(jSONObject.optInt("height", 0), 0);
            this.f1367i = b.a(jSONObject.optInt("interval", 30), 30);
            int optInt = jSONObject.optInt("orientation", 0);
            if (optInt != 0 && optInt != 1) {
                optInt = 0;
            }
            this.j = optInt == 1;
            this.k = b.a(jSONObject.optDouble("basePrice", 0.0d), 0.0d);
        }

        @Override // a.a.a.a.s.n.a
        public void a(ObjectOutput objectOutput) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, objectOutput) == null) {
                objectOutput.writeLong(this.f1360b);
                objectOutput.writeUTF(this.f1361c);
                objectOutput.writeUTF(this.f1362d);
                objectOutput.writeInt(this.f1363e);
                objectOutput.writeFloat(this.f1364f);
                objectOutput.writeInt(this.f1365g);
                objectOutput.writeInt(this.f1366h);
                objectOutput.writeInt(this.f1367i);
                objectOutput.writeBoolean(this.j);
                objectOutput.writeDouble(this.k);
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || a.class != obj.getClass()) {
                    return false;
                }
                a aVar = (a) obj;
                return this.f1360b == aVar.f1360b && this.f1363e == aVar.f1363e && Float.compare(aVar.f1364f, this.f1364f) == 0 && this.f1365g == aVar.f1365g && this.f1366h == aVar.f1366h && this.f1367i == aVar.f1367i && this.j == aVar.j && Objects.equals(this.f1361c, aVar.f1361c) && Objects.equals(this.f1362d, aVar.f1362d);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Objects.hash(Long.valueOf(this.f1360b), this.f1361c, this.f1362d, Integer.valueOf(this.f1363e), Float.valueOf(this.f1364f), Integer.valueOf(this.f1365g), Integer.valueOf(this.f1366h), Integer.valueOf(this.f1367i), Boolean.valueOf(this.j)) : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "Pid{id=" + this.f1360b + ", pid='" + this.f1361c + "', type='" + this.f1362d + "', tmout='" + this.f1363e + "', sample='" + this.f1364f + "', width='" + this.f1365g + "', height='" + this.f1366h + "', interval='" + this.f1367i + "', isHorizontal='" + this.j + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(int i2, ObjectInput objectInput) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), objectInput};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1357b = objectInput.readUTF();
        this.f1358c = objectInput.readUTF();
        int readInt = objectInput.readInt();
        HashSet hashSet = new HashSet();
        for (int i5 = 0; i5 < readInt; i5++) {
            hashSet.add(new a(objectInput.readInt(), objectInput, this));
        }
        this.f1359d = Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(JSONObject jSONObject) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1357b = jSONObject.getString("sspId");
        this.f1358c = jSONObject.getString("type");
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray(TiebaStatic.Params.PID_MERGE);
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            hashSet.add(new a(jSONArray.getJSONObject(i4), this));
        }
        this.f1359d = Collections.unmodifiableSet(hashSet);
    }

    @Override // a.a.a.a.s.n.a
    public void a(ObjectOutput objectOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, objectOutput) == null) {
            objectOutput.writeUTF(this.f1357b);
            objectOutput.writeUTF(this.f1358c);
            objectOutput.writeInt(this.f1359d.size());
            for (a aVar : this.f1359d) {
                objectOutput.writeInt(aVar.f1375a);
                aVar.a(objectOutput);
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || h.class != obj.getClass()) {
                return false;
            }
            h hVar = (h) obj;
            return Objects.equals(this.f1357b, hVar.f1357b) && Objects.equals(this.f1358c, hVar.f1358c) && Objects.equals(this.f1359d, hVar.f1359d);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Objects.hash(this.f1357b, this.f1358c, this.f1359d) : invokeV.intValue;
    }
}

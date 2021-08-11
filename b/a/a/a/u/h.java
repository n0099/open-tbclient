package b.a.a.a.u;

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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class h extends b.a.a.a.u.n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final String f1444b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1445c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<a> f1446d;

    /* loaded from: classes.dex */
    public static class a extends b.a.a.a.u.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final long f1447b;

        /* renamed from: c  reason: collision with root package name */
        public final String f1448c;

        /* renamed from: d  reason: collision with root package name */
        public final String f1449d;

        /* renamed from: e  reason: collision with root package name */
        public final int f1450e;

        /* renamed from: f  reason: collision with root package name */
        public final float f1451f;

        /* renamed from: g  reason: collision with root package name */
        public final int f1452g;

        /* renamed from: h  reason: collision with root package name */
        public final int f1453h;

        /* renamed from: i  reason: collision with root package name */
        public final int f1454i;

        /* renamed from: j  reason: collision with root package name */
        public final boolean f1455j;
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
            this.f1447b = objectInput.readLong();
            this.f1448c = objectInput.readUTF();
            this.f1449d = objectInput.readUTF();
            this.f1450e = objectInput.readInt();
            this.f1451f = objectInput.readFloat();
            this.f1452g = objectInput.readInt();
            this.f1453h = objectInput.readInt();
            this.f1454i = objectInput.readInt();
            if (i2 == 0) {
                objectInput.readInt();
                objectInput.readInt();
            }
            this.f1455j = objectInput.readBoolean();
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
            this.f1447b = b.d(jSONObject.getLong("id"), 0L);
            this.f1448c = jSONObject.getString("pid");
            this.f1449d = jSONObject.getString("type");
            this.f1450e = jSONObject.getInt("tmout");
            this.f1451f = b.b((float) jSONObject.optDouble("sample", 0.0d), 0.0f, 1.0f);
            this.f1452g = b.c(jSONObject.optInt("width", 0), 0);
            this.f1453h = b.c(jSONObject.optInt("height", 0), 0);
            this.f1454i = b.c(jSONObject.optInt("interval", 30), 30);
            int optInt = jSONObject.optInt("orientation", 0);
            if (optInt != 0 && optInt != 1) {
                optInt = 0;
            }
            this.f1455j = optInt == 1;
            this.k = b.a(jSONObject.optDouble("basePrice", 0.0d), 0.0d);
        }

        public void a(ObjectOutput objectOutput) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, objectOutput) == null) {
                objectOutput.writeLong(this.f1447b);
                objectOutput.writeUTF(this.f1448c);
                objectOutput.writeUTF(this.f1449d);
                objectOutput.writeInt(this.f1450e);
                objectOutput.writeFloat(this.f1451f);
                objectOutput.writeInt(this.f1452g);
                objectOutput.writeInt(this.f1453h);
                objectOutput.writeInt(this.f1454i);
                objectOutput.writeBoolean(this.f1455j);
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
                return this.f1447b == aVar.f1447b && this.f1450e == aVar.f1450e && Float.compare(aVar.f1451f, this.f1451f) == 0 && this.f1452g == aVar.f1452g && this.f1453h == aVar.f1453h && this.f1454i == aVar.f1454i && this.f1455j == aVar.f1455j && Objects.equals(this.f1448c, aVar.f1448c) && Objects.equals(this.f1449d, aVar.f1449d);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Objects.hash(Long.valueOf(this.f1447b), this.f1448c, this.f1449d, Integer.valueOf(this.f1450e), Float.valueOf(this.f1451f), Integer.valueOf(this.f1452g), Integer.valueOf(this.f1453h), Integer.valueOf(this.f1454i), Boolean.valueOf(this.f1455j)) : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "Pid{id=" + this.f1447b + ", pid='" + this.f1448c + ExtendedMessageFormat.QUOTE + ", type='" + this.f1449d + ExtendedMessageFormat.QUOTE + ", tmout='" + this.f1450e + ExtendedMessageFormat.QUOTE + ", sample='" + this.f1451f + ExtendedMessageFormat.QUOTE + ", width='" + this.f1452g + ExtendedMessageFormat.QUOTE + ", height='" + this.f1453h + ExtendedMessageFormat.QUOTE + ", interval='" + this.f1454i + ExtendedMessageFormat.QUOTE + ", isHorizontal='" + this.f1455j + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
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
        this.f1444b = objectInput.readUTF();
        this.f1445c = objectInput.readUTF();
        int readInt = objectInput.readInt();
        HashSet hashSet = new HashSet();
        for (int i5 = 0; i5 < readInt; i5++) {
            hashSet.add(new a(objectInput.readInt(), objectInput, this));
        }
        this.f1446d = Collections.unmodifiableSet(hashSet);
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
        this.f1444b = jSONObject.getString("sspId");
        this.f1445c = jSONObject.getString("type");
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray(TiebaStatic.Params.PID_MERGE);
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            hashSet.add(new a(jSONArray.getJSONObject(i4), this));
        }
        this.f1446d = Collections.unmodifiableSet(hashSet);
    }

    public void a(ObjectOutput objectOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, objectOutput) == null) {
            objectOutput.writeUTF(this.f1444b);
            objectOutput.writeUTF(this.f1445c);
            objectOutput.writeInt(this.f1446d.size());
            for (a aVar : this.f1446d) {
                objectOutput.writeInt(aVar.f1463a);
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
            return Objects.equals(this.f1444b, hVar.f1444b) && Objects.equals(this.f1445c, hVar.f1445c) && Objects.equals(this.f1446d, hVar.f1446d);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Objects.hash(this.f1444b, this.f1445c, this.f1446d) : invokeV.intValue;
    }
}

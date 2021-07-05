package a.a.a.a.v;

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
public final class e extends a.a.a.a.v.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final String f1341b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1342c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<a> f1343d;

    /* loaded from: classes.dex */
    public static class a extends a.a.a.a.v.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final long f1344b;

        /* renamed from: c  reason: collision with root package name */
        public final String f1345c;

        /* renamed from: d  reason: collision with root package name */
        public final String f1346d;

        /* renamed from: e  reason: collision with root package name */
        public final int f1347e;

        /* renamed from: f  reason: collision with root package name */
        public final float f1348f;

        /* renamed from: g  reason: collision with root package name */
        public final int f1349g;

        /* renamed from: h  reason: collision with root package name */
        public final int f1350h;

        /* renamed from: i  reason: collision with root package name */
        public final int f1351i;
        public final boolean j;
        public final e k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, ObjectInput objectInput, e eVar) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), objectInput, eVar};
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
            this.k = eVar;
            this.f1344b = objectInput.readLong();
            this.f1345c = objectInput.readUTF();
            this.f1346d = objectInput.readUTF();
            this.f1347e = objectInput.readInt();
            this.f1348f = objectInput.readFloat();
            this.f1349g = objectInput.readInt();
            this.f1350h = objectInput.readInt();
            this.f1351i = objectInput.readInt();
            if (i2 == 0) {
                objectInput.readInt();
                objectInput.readInt();
            }
            this.j = objectInput.readBoolean();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(JSONObject jSONObject, e eVar) {
            super(1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, eVar};
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
            this.k = eVar;
            this.f1344b = b.a(jSONObject.getLong("id"), 0L);
            this.f1345c = jSONObject.getString("pid");
            this.f1346d = jSONObject.getString("type");
            this.f1347e = jSONObject.getInt("tmout");
            this.f1348f = b.a((float) jSONObject.optDouble("sample", 0.0d), 0.0f, 1.0f);
            this.f1349g = b.a(jSONObject.optInt("width", 0), 0);
            this.f1350h = b.a(jSONObject.optInt("height", 0), 0);
            this.f1351i = b.a(jSONObject.optInt("interval", 30), 30);
            int optInt = jSONObject.optInt("orientation", 0);
            if (optInt != 0 && optInt != 1) {
                optInt = 0;
            }
            this.j = optInt == 1;
        }

        @Override // a.a.a.a.v.f.a
        public void a(ObjectOutput objectOutput) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, objectOutput) == null) {
                objectOutput.writeLong(this.f1344b);
                objectOutput.writeUTF(this.f1345c);
                objectOutput.writeUTF(this.f1346d);
                objectOutput.writeInt(this.f1347e);
                objectOutput.writeFloat(this.f1348f);
                objectOutput.writeInt(this.f1349g);
                objectOutput.writeInt(this.f1350h);
                objectOutput.writeInt(this.f1351i);
                objectOutput.writeBoolean(this.j);
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
                return this.f1344b == aVar.f1344b && this.f1347e == aVar.f1347e && Float.compare(aVar.f1348f, this.f1348f) == 0 && this.f1349g == aVar.f1349g && this.f1350h == aVar.f1350h && this.f1351i == aVar.f1351i && this.j == aVar.j && Objects.equals(this.f1345c, aVar.f1345c) && Objects.equals(this.f1346d, aVar.f1346d);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Objects.hash(Long.valueOf(this.f1344b), this.f1345c, this.f1346d, Integer.valueOf(this.f1347e), Float.valueOf(this.f1348f), Integer.valueOf(this.f1349g), Integer.valueOf(this.f1350h), Integer.valueOf(this.f1351i), Boolean.valueOf(this.j)) : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "Pid{id=" + this.f1344b + ", pid='" + this.f1345c + "', type='" + this.f1346d + "', tmout='" + this.f1347e + "', sample='" + this.f1348f + "', width='" + this.f1349g + "', height='" + this.f1350h + "', interval='" + this.f1351i + "', isHorizontal='" + this.j + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i2, ObjectInput objectInput) {
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
        this.f1341b = objectInput.readUTF();
        this.f1342c = objectInput.readUTF();
        int readInt = objectInput.readInt();
        HashSet hashSet = new HashSet();
        for (int i5 = 0; i5 < readInt; i5++) {
            hashSet.add(new a(objectInput.readInt(), objectInput, this));
        }
        this.f1343d = Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(JSONObject jSONObject) {
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
        this.f1341b = jSONObject.getString("sspId");
        this.f1342c = jSONObject.getString("type");
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray(TiebaStatic.Params.PID_MERGE);
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            hashSet.add(new a(jSONArray.getJSONObject(i4), this));
        }
        this.f1343d = Collections.unmodifiableSet(hashSet);
    }

    @Override // a.a.a.a.v.f.a
    public void a(ObjectOutput objectOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, objectOutput) == null) {
            objectOutput.writeUTF(this.f1341b);
            objectOutput.writeUTF(this.f1342c);
            objectOutput.writeInt(this.f1343d.size());
            for (a aVar : this.f1343d) {
                objectOutput.writeInt(aVar.f1352a);
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
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return Objects.equals(this.f1341b, eVar.f1341b) && Objects.equals(this.f1342c, eVar.f1342c) && Objects.equals(this.f1343d, eVar.f1343d);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Objects.hash(this.f1341b, this.f1342c, this.f1343d) : invokeV.intValue;
    }
}

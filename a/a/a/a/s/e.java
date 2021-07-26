package a.a.a.a.s;

import a.a.a.a.p;
import a.a.a.a.s.h;
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
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class e extends a.a.a.a.s.n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final String f1340b;

    /* renamed from: c  reason: collision with root package name */
    public final long f1341c;

    /* renamed from: d  reason: collision with root package name */
    public final long f1342d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1343e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<b> f1344f;

    /* loaded from: classes.dex */
    public static final class a extends a.a.a.a.s.n.a implements p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final long f1345b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1346c;

        /* renamed from: d  reason: collision with root package name */
        public final h.a f1347d;

        /* renamed from: e  reason: collision with root package name */
        public final b f1348e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, ObjectInput objectInput, Map<Long, h.a> map, b bVar) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), objectInput, map, bVar};
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
            this.f1348e = bVar;
            this.f1345b = objectInput.readLong();
            this.f1346c = objectInput.readInt();
            this.f1347d = map.get(Long.valueOf(this.f1345b));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(JSONObject jSONObject, Map<Long, h.a> map, b bVar) {
            super(0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, map, bVar};
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
            this.f1348e = bVar;
            this.f1345b = a.a.a.a.s.b.a(jSONObject.getLong("id"), 0L);
            this.f1346c = a.a.a.a.s.b.a(jSONObject.getInt("weight"), 0);
            this.f1347d = map.get(Long.valueOf(this.f1345b));
        }

        @Override // a.a.a.a.s.n.a
        public void a(ObjectOutput objectOutput) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, objectOutput) == null) {
                objectOutput.writeLong(this.f1345b);
                objectOutput.writeInt(this.f1346c);
            }
        }

        @Override // a.a.a.a.p
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // a.a.a.a.p
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1346c : invokeV.intValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || a.class != obj.getClass()) {
                    return false;
                }
                a aVar = (a) obj;
                return this.f1345b == aVar.f1345b && this.f1346c == aVar.f1346c && Objects.equals(this.f1347d, aVar.f1347d);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Objects.hash(Long.valueOf(this.f1345b), Integer.valueOf(this.f1346c), this.f1347d) : invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends a.a.a.a.s.n.a implements p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final int f1349b;

        /* renamed from: c  reason: collision with root package name */
        public final Set<a> f1350c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2, ObjectInput objectInput, Map<Long, h.a> map) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), objectInput, map};
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
            this.f1349b = objectInput.readInt();
            int readInt = objectInput.readInt();
            HashSet hashSet = new HashSet();
            for (int i5 = 0; i5 < readInt; i5++) {
                hashSet.add(new a(objectInput.readInt(), objectInput, map, this));
            }
            this.f1350c = Collections.unmodifiableSet(hashSet);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(JSONObject jSONObject, Map<Long, h.a> map) {
            super(0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, map};
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
            this.f1349b = a.a.a.a.s.b.a(jSONObject.getInt("weight"), 0);
            HashSet hashSet = new HashSet();
            JSONArray jSONArray = jSONObject.getJSONArray(TiebaStatic.Params.PID_MERGE);
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                hashSet.add(new a(jSONArray.getJSONObject(i4), map, this));
            }
            this.f1350c = Collections.unmodifiableSet(hashSet);
        }

        @Override // a.a.a.a.s.n.a
        public void a(ObjectOutput objectOutput) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, objectOutput) == null) {
                objectOutput.writeInt(this.f1349b);
                objectOutput.writeInt(this.f1350c.size());
                for (a aVar : this.f1350c) {
                    objectOutput.writeInt(aVar.f1375a);
                    aVar.a(objectOutput);
                }
            }
        }

        @Override // a.a.a.a.p
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // a.a.a.a.p
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1349b : invokeV.intValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || b.class != obj.getClass()) {
                    return false;
                }
                b bVar = (b) obj;
                return this.f1349b == bVar.f1349b && Objects.equals(this.f1350c, bVar.f1350c);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Objects.hash(Integer.valueOf(this.f1349b), this.f1350c) : invokeV.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i2, ObjectInput objectInput, Map<Long, h.a> map) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), objectInput, map};
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
        this.f1340b = objectInput.readUTF();
        this.f1341c = objectInput.readLong();
        this.f1342d = objectInput.readLong();
        int readInt = objectInput.readInt();
        HashSet hashSet = new HashSet(readInt);
        for (int i5 = 0; i5 < readInt; i5++) {
            hashSet.add(new b(objectInput.readInt(), objectInput, map));
        }
        this.f1344f = Collections.unmodifiableSet(hashSet);
        if (i2 >= 1) {
            this.f1343e = objectInput.readInt();
        } else {
            this.f1343e = 0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(JSONObject jSONObject, Map<Long, h.a> map) {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, map};
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
        this.f1340b = jSONObject.getString("sid");
        this.f1341c = a.a.a.a.s.b.a(jSONObject.getLong("wt"), 0L);
        this.f1342d = a.a.a.a.s.b.a(jSONObject.getLong("tmout"), 0L);
        JSONArray jSONArray = jSONObject.getJSONArray("pGroups");
        HashSet hashSet = new HashSet();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            hashSet.add(new b(jSONArray.getJSONObject(i4), map));
        }
        this.f1344f = Collections.unmodifiableSet(hashSet);
        this.f1343e = jSONObject.optInt("ver", 0);
    }

    @Override // a.a.a.a.s.n.a
    public void a(ObjectOutput objectOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, objectOutput) == null) {
            objectOutput.writeUTF(this.f1340b);
            objectOutput.writeLong(this.f1341c);
            objectOutput.writeLong(this.f1342d);
            objectOutput.writeInt(this.f1344f.size());
            for (b bVar : this.f1344f) {
                objectOutput.writeInt(bVar.f1375a);
                bVar.a(objectOutput);
            }
            objectOutput.writeInt(this.f1343e);
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
            return this.f1341c == eVar.f1341c && this.f1342d == eVar.f1342d && Objects.equals(this.f1340b, eVar.f1340b) && Objects.equals(this.f1344f, eVar.f1344f) && this.f1343e == eVar.f1343e;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Objects.hash(this.f1340b, Long.valueOf(this.f1341c), Long.valueOf(this.f1342d), this.f1344f, Integer.valueOf(this.f1343e)) : invokeV.intValue;
    }
}

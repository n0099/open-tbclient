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
public final class d extends a.a.a.a.s.n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final String f1332b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b> f1333c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1334d;

    /* loaded from: classes.dex */
    public static final class a extends a.a.a.a.s.n.a implements p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final long f1335b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1336c;

        /* renamed from: d  reason: collision with root package name */
        public final h.a f1337d;

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
            this.f1335b = objectInput.readLong();
            this.f1336c = objectInput.readInt();
            this.f1337d = map.get(Long.valueOf(this.f1335b));
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
            this.f1335b = a.a.a.a.s.b.a(jSONObject.getLong("id"), 0L);
            this.f1336c = a.a.a.a.s.b.a(jSONObject.getInt("weight"), 0);
            this.f1337d = map.get(Long.valueOf(this.f1335b));
        }

        @Override // a.a.a.a.s.n.a
        public void a(ObjectOutput objectOutput) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, objectOutput) == null) {
                objectOutput.writeLong(this.f1335b);
                objectOutput.writeInt(this.f1336c);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1336c : invokeV.intValue;
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
                return this.f1335b == aVar.f1335b && this.f1336c == aVar.f1336c && Objects.equals(this.f1337d, aVar.f1337d);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Objects.hash(Long.valueOf(this.f1335b), Integer.valueOf(this.f1336c), this.f1337d) : invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends a.a.a.a.s.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final long f1338b;

        /* renamed from: c  reason: collision with root package name */
        public final Set<a> f1339c;

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
            this.f1338b = objectInput.readLong();
            int readInt = objectInput.readInt();
            HashSet hashSet = new HashSet();
            for (int i5 = 0; i5 < readInt; i5++) {
                hashSet.add(new a(objectInput.readInt(), objectInput, map, this));
            }
            this.f1339c = Collections.unmodifiableSet(hashSet);
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
            this.f1338b = a.a.a.a.s.b.a(jSONObject.optLong("tmout", 5000L), 100L, 30000L);
            HashSet hashSet = new HashSet();
            JSONArray jSONArray = jSONObject.getJSONArray(TiebaStatic.Params.PID_MERGE);
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                hashSet.add(new a(jSONArray.getJSONObject(i4), map, this));
            }
            this.f1339c = Collections.unmodifiableSet(hashSet);
        }

        @Override // a.a.a.a.s.n.a
        public void a(ObjectOutput objectOutput) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, objectOutput) == null) {
                objectOutput.writeLong(this.f1338b);
                objectOutput.writeInt(this.f1339c.size());
                for (a aVar : this.f1339c) {
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
                if (obj == null || b.class != obj.getClass()) {
                    return false;
                }
                b bVar = (b) obj;
                return this.f1338b == bVar.f1338b && Objects.equals(this.f1339c, bVar.f1339c);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Objects.hash(Long.valueOf(this.f1338b), this.f1339c) : invokeV.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(int i2, ObjectInput objectInput, Map<Long, h.a> map) {
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
        this.f1332b = objectInput.readUTF();
        int readInt = objectInput.readInt();
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < readInt; i5++) {
            arrayList.add(new b(objectInput.readInt(), objectInput, map));
        }
        this.f1333c = Collections.unmodifiableList(arrayList);
        if (i2 >= 1) {
            this.f1334d = objectInput.readInt();
        } else {
            this.f1334d = 0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(JSONObject jSONObject, Map<Long, h.a> map) {
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
        this.f1332b = jSONObject.getString("sid");
        JSONArray jSONArray = jSONObject.getJSONArray("pGroups");
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            arrayList.add(new b(jSONArray.getJSONObject(i4), map));
        }
        this.f1333c = Collections.unmodifiableList(arrayList);
        this.f1334d = jSONObject.optInt("ver", 0);
    }

    @Override // a.a.a.a.s.n.a
    public void a(ObjectOutput objectOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, objectOutput) == null) {
            objectOutput.writeUTF(this.f1332b);
            objectOutput.writeInt(this.f1333c.size());
            for (b bVar : this.f1333c) {
                objectOutput.writeInt(bVar.f1375a);
                bVar.a(objectOutput);
            }
            objectOutput.writeInt(this.f1334d);
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return Objects.equals(this.f1332b, dVar.f1332b) && Objects.equals(this.f1333c, dVar.f1333c) && this.f1334d == dVar.f1334d;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Objects.hash(this.f1332b, this.f1333c, Integer.valueOf(this.f1334d)) : invokeV.intValue;
    }
}

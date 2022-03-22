package c.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.NumberUtils;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class n extends d0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final long f23214b;

    /* renamed from: c  reason: collision with root package name */
    public final long f23215c;

    /* renamed from: d  reason: collision with root package name */
    public final int f23216d;

    /* renamed from: e  reason: collision with root package name */
    public final List<c> f23217e;

    /* loaded from: classes3.dex */
    public class a implements Comparator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) ? -Integer.compare(((c) obj).a, ((c) obj2).a) : invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends d0 implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long a;

        /* renamed from: b  reason: collision with root package name */
        public final int f23218b;

        /* renamed from: c  reason: collision with root package name */
        public final Ssp.Pid f23219c;

        /* renamed from: d  reason: collision with root package name */
        public final c f23220d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i, ObjectInput objectInput, Map<Long, Ssp.Pid> map, c cVar) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), objectInput, map, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23220d = cVar;
            long readLong = objectInput.readLong();
            this.a = readLong;
            this.f23218b = objectInput.readInt();
            this.f23219c = map.get(Long.valueOf(readLong));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(JSONObject jSONObject, Map<Long, Ssp.Pid> map, c cVar) {
            super(0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, map, cVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f23220d = cVar;
            long adjustLong = NumberUtils.adjustLong(jSONObject.getLong("id"), 0L);
            this.a = adjustLong;
            this.f23218b = NumberUtils.adjustInt(jSONObject.getInt("weight"), 0);
            this.f23219c = map.get(Long.valueOf(adjustLong));
        }

        @Override // c.d.d
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // c.d.d
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23218b : invokeV.intValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || b.class != obj.getClass()) {
                    return false;
                }
                b bVar = (b) obj;
                return this.a == bVar.a && this.f23218b == bVar.f23218b && Objects.equals(this.f23219c, bVar.f23219c);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Objects.hash(Long.valueOf(this.a), Integer.valueOf(this.f23218b), this.f23219c) : invokeV.intValue;
        }

        @Override // c.d.d0
        public void srzableInternal(ObjectOutput objectOutput) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, objectOutput) == null) {
                objectOutput.writeLong(this.a);
                objectOutput.writeInt(this.f23218b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends d0 implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f23221b;

        /* loaded from: classes3.dex */
        public class a implements Comparator<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.util.Comparator
            public int compare(Object obj, Object obj2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) ? -Integer.compare(((b) obj).f23218b, ((b) obj2).f23218b) : invokeLL.intValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i, ObjectInput objectInput, Map<Long, Ssp.Pid> map) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), objectInput, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = objectInput.readInt();
            int readInt = objectInput.readInt();
            HashSet hashSet = new HashSet();
            for (int i4 = 0; i4 < readInt; i4++) {
                hashSet.add(new b(objectInput.readInt(), objectInput, map, this));
            }
            this.f23221b = Collections.unmodifiableList(new ArrayList(hashSet));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(JSONObject jSONObject, Map<Long, Ssp.Pid> map) {
            super(0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, map};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = NumberUtils.adjustInt(jSONObject.getInt("weight"), 0);
            HashSet hashSet = new HashSet();
            JSONArray jSONArray = jSONObject.getJSONArray(TiebaStatic.Params.PID_MERGE);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                hashSet.add(new b(jSONArray.getJSONObject(i3), map, this));
            }
            ArrayList arrayList = new ArrayList(hashSet);
            a(arrayList);
            this.f23221b = Collections.unmodifiableList(arrayList);
        }

        public final <T extends b> List<T> a(List<T> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
                Collections.sort(list, new a(this));
                return list;
            }
            return (List) invokeL.objValue;
        }

        @Override // c.d.d
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // c.d.d
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || c.class != obj.getClass()) {
                    return false;
                }
                c cVar = (c) obj;
                return this.a == cVar.a && Objects.equals(this.f23221b, cVar.f23221b);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Objects.hash(Integer.valueOf(this.a), this.f23221b) : invokeV.intValue;
        }

        @Override // c.d.d0
        public void srzableInternal(ObjectOutput objectOutput) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, objectOutput) == null) {
                objectOutput.writeInt(this.a);
                objectOutput.writeInt(this.f23221b.size());
                for (b bVar : this.f23221b) {
                    bVar.srzable(objectOutput);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(int i, ObjectInput objectInput, Map<Long, Ssp.Pid> map) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), objectInput, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = objectInput.readUTF();
        this.f23214b = objectInput.readLong();
        this.f23215c = objectInput.readLong();
        int readInt = objectInput.readInt();
        HashSet hashSet = new HashSet(readInt);
        for (int i4 = 0; i4 < readInt; i4++) {
            hashSet.add(new c(objectInput.readInt(), objectInput, map));
        }
        ArrayList arrayList = new ArrayList(hashSet);
        a(arrayList);
        this.f23217e = Collections.unmodifiableList(arrayList);
        if (i >= 1) {
            this.f23216d = objectInput.readInt();
        } else {
            this.f23216d = 0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(JSONObject jSONObject, Map<Long, Ssp.Pid> map) {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = jSONObject.getString("sid");
        this.f23214b = NumberUtils.adjustLong(jSONObject.getLong("wt"), 0L);
        this.f23215c = NumberUtils.adjustLong(jSONObject.getLong("tmout"), 0L);
        JSONArray jSONArray = jSONObject.getJSONArray("pGroups");
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            hashSet.add(new c(jSONArray.getJSONObject(i3), map));
        }
        ArrayList arrayList = new ArrayList(hashSet);
        a(arrayList);
        this.f23217e = Collections.unmodifiableList(arrayList);
        this.f23216d = jSONObject.optInt("ver", 0);
    }

    public final <T extends c> List<T> a(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            Collections.sort(list, new a(this));
            return list;
        }
        return (List) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || n.class != obj.getClass()) {
                return false;
            }
            n nVar = (n) obj;
            return this.f23214b == nVar.f23214b && this.f23215c == nVar.f23215c && Objects.equals(this.a, nVar.a) && Objects.equals(this.f23217e, nVar.f23217e) && this.f23216d == nVar.f23216d;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Objects.hash(this.a, Long.valueOf(this.f23214b), Long.valueOf(this.f23215c), this.f23217e, Integer.valueOf(this.f23216d)) : invokeV.intValue;
    }

    @Override // c.d.d0
    public void srzableInternal(ObjectOutput objectOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, objectOutput) == null) {
            objectOutput.writeUTF(this.a);
            objectOutput.writeLong(this.f23214b);
            objectOutput.writeLong(this.f23215c);
            objectOutput.writeInt(this.f23217e.size());
            for (c cVar : this.f23217e) {
                cVar.srzable(objectOutput);
            }
            objectOutput.writeInt(this.f23216d);
        }
    }
}

package b.g;

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
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class l extends c0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f31186a;

    /* renamed from: b  reason: collision with root package name */
    public final long f31187b;

    /* renamed from: c  reason: collision with root package name */
    public final long f31188c;

    /* renamed from: d  reason: collision with root package name */
    public final int f31189d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<b> f31190e;

    /* loaded from: classes6.dex */
    public static final class a extends c0 implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long f31191a;

        /* renamed from: b  reason: collision with root package name */
        public final int f31192b;

        /* renamed from: c  reason: collision with root package name */
        public final Ssp.Pid f31193c;

        /* renamed from: d  reason: collision with root package name */
        public final b f31194d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, ObjectInput objectInput, Map<Long, Ssp.Pid> map, b bVar) {
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
            this.f31194d = bVar;
            long readLong = objectInput.readLong();
            this.f31191a = readLong;
            this.f31192b = objectInput.readInt();
            this.f31193c = map.get(Long.valueOf(readLong));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(JSONObject jSONObject, Map<Long, Ssp.Pid> map, b bVar) {
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
            this.f31194d = bVar;
            long adjustLong = NumberUtils.adjustLong(jSONObject.getLong("id"), 0L);
            this.f31191a = adjustLong;
            this.f31192b = NumberUtils.adjustInt(jSONObject.getInt("weight"), 0);
            this.f31193c = map.get(Long.valueOf(adjustLong));
        }

        @Override // b.g.k
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // b.g.k
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31192b : invokeV.intValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || a.class != obj.getClass()) {
                    return false;
                }
                a aVar = (a) obj;
                return this.f31191a == aVar.f31191a && this.f31192b == aVar.f31192b && Objects.equals(this.f31193c, aVar.f31193c);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Objects.hash(Long.valueOf(this.f31191a), Integer.valueOf(this.f31192b), this.f31193c) : invokeV.intValue;
        }

        @Override // b.g.c0
        public void srzableInternal(ObjectOutput objectOutput) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, objectOutput) == null) {
                objectOutput.writeLong(this.f31191a);
                objectOutput.writeInt(this.f31192b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends c0 implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f31195a;

        /* renamed from: b  reason: collision with root package name */
        public final Set<a> f31196b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2, ObjectInput objectInput, Map<Long, Ssp.Pid> map) {
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
            this.f31195a = objectInput.readInt();
            int readInt = objectInput.readInt();
            HashSet hashSet = new HashSet();
            for (int i5 = 0; i5 < readInt; i5++) {
                hashSet.add(new a(objectInput.readInt(), objectInput, map, this));
            }
            this.f31196b = Collections.unmodifiableSet(hashSet);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(JSONObject jSONObject, Map<Long, Ssp.Pid> map) {
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
            this.f31195a = NumberUtils.adjustInt(jSONObject.getInt("weight"), 0);
            HashSet hashSet = new HashSet();
            JSONArray jSONArray = jSONObject.getJSONArray(TiebaStatic.Params.PID_MERGE);
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                hashSet.add(new a(jSONArray.getJSONObject(i4), map, this));
            }
            this.f31196b = Collections.unmodifiableSet(hashSet);
        }

        @Override // b.g.k
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // b.g.k
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31195a : invokeV.intValue;
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
                return this.f31195a == bVar.f31195a && Objects.equals(this.f31196b, bVar.f31196b);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Objects.hash(Integer.valueOf(this.f31195a), this.f31196b) : invokeV.intValue;
        }

        @Override // b.g.c0
        public void srzableInternal(ObjectOutput objectOutput) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, objectOutput) == null) {
                objectOutput.writeInt(this.f31195a);
                objectOutput.writeInt(this.f31196b.size());
                for (a aVar : this.f31196b) {
                    aVar.srzable(objectOutput);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(int i2, ObjectInput objectInput, Map<Long, Ssp.Pid> map) {
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
        this.f31186a = objectInput.readUTF();
        this.f31187b = objectInput.readLong();
        this.f31188c = objectInput.readLong();
        int readInt = objectInput.readInt();
        HashSet hashSet = new HashSet(readInt);
        for (int i5 = 0; i5 < readInt; i5++) {
            hashSet.add(new b(objectInput.readInt(), objectInput, map));
        }
        this.f31190e = Collections.unmodifiableSet(hashSet);
        if (i2 >= 1) {
            this.f31189d = objectInput.readInt();
        } else {
            this.f31189d = 0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(JSONObject jSONObject, Map<Long, Ssp.Pid> map) {
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
        this.f31186a = jSONObject.getString("sid");
        this.f31187b = NumberUtils.adjustLong(jSONObject.getLong("wt"), 0L);
        this.f31188c = NumberUtils.adjustLong(jSONObject.getLong("tmout"), 0L);
        JSONArray jSONArray = jSONObject.getJSONArray("pGroups");
        HashSet hashSet = new HashSet();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            hashSet.add(new b(jSONArray.getJSONObject(i4), map));
        }
        this.f31190e = Collections.unmodifiableSet(hashSet);
        this.f31189d = jSONObject.optInt("ver", 0);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || l.class != obj.getClass()) {
                return false;
            }
            l lVar = (l) obj;
            return this.f31187b == lVar.f31187b && this.f31188c == lVar.f31188c && Objects.equals(this.f31186a, lVar.f31186a) && Objects.equals(this.f31190e, lVar.f31190e) && this.f31189d == lVar.f31189d;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Objects.hash(this.f31186a, Long.valueOf(this.f31187b), Long.valueOf(this.f31188c), this.f31190e, Integer.valueOf(this.f31189d)) : invokeV.intValue;
    }

    @Override // b.g.c0
    public void srzableInternal(ObjectOutput objectOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objectOutput) == null) {
            objectOutput.writeUTF(this.f31186a);
            objectOutput.writeLong(this.f31187b);
            objectOutput.writeLong(this.f31188c);
            objectOutput.writeInt(this.f31190e.size());
            for (b bVar : this.f31190e) {
                bVar.srzable(objectOutput);
            }
            objectOutput.writeInt(this.f31189d);
        }
    }
}

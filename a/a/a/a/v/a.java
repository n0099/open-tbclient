package a.a.a.a.v;

import a.a.a.a.v.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes.dex */
public class a extends a.a.a.a.v.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Set<e> f1315b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<d> f1316c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<c> f1317d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int i2, ObjectInput objectInput) {
        super(i2);
        HashSet hashSet;
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
        int readInt = objectInput.readInt();
        HashSet hashSet2 = new HashSet(readInt);
        HashMap hashMap = new HashMap();
        for (int i5 = 0; i5 < readInt; i5++) {
            e eVar = new e(objectInput.readInt(), objectInput);
            hashSet2.add(eVar);
            for (e.a aVar : eVar.f1343d) {
                hashMap.put(Long.valueOf(aVar.f1344b), aVar);
            }
        }
        int readInt2 = objectInput.readInt();
        HashSet hashSet3 = new HashSet(readInt2);
        for (int i6 = 0; i6 < readInt2; i6++) {
            hashSet3.add(new d(objectInput.readInt(), objectInput, hashMap));
        }
        this.f1315b = Collections.unmodifiableSet(hashSet2);
        this.f1316c = Collections.unmodifiableSet(hashSet3);
        if (i2 == 1) {
            int readInt3 = objectInput.readInt();
            hashSet = new HashSet(readInt3);
            for (int i7 = 0; i7 < readInt3; i7++) {
                hashSet.add(new c(objectInput.readInt(), objectInput, hashMap));
            }
        } else {
            hashSet = new HashSet();
        }
        this.f1317d = Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Set<e> set, Set<d> set2, Set<c> set3) {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {set, set2, set3};
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
        this.f1315b = set;
        this.f1316c = set2;
        this.f1317d = set3;
    }

    @Override // a.a.a.a.v.f.a
    public void a(ObjectOutput objectOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, objectOutput) == null) {
            objectOutput.writeInt(this.f1315b.size());
            for (e eVar : this.f1315b) {
                objectOutput.writeInt(eVar.f1352a);
                eVar.a(objectOutput);
            }
            objectOutput.writeInt(this.f1316c.size());
            for (d dVar : this.f1316c) {
                objectOutput.writeInt(dVar.f1352a);
                dVar.a(objectOutput);
            }
            objectOutput.writeInt(this.f1317d.size());
            for (c cVar : this.f1317d) {
                objectOutput.writeInt(cVar.f1352a);
                cVar.a(objectOutput);
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
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return Objects.equals(this.f1315b, aVar.f1315b) && Objects.equals(this.f1316c, aVar.f1316c);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Objects.hash(this.f1315b, this.f1316c) : invokeV.intValue;
    }
}

package a.a.a.a.s;

import a.a.a.a.s.h;
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
public class a extends a.a.a.a.s.n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Set<h> f1317b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<e> f1318c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<d> f1319d;

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
            h hVar = new h(objectInput.readInt(), objectInput);
            hashSet2.add(hVar);
            for (h.a aVar : hVar.f1359d) {
                hashMap.put(Long.valueOf(aVar.f1360b), aVar);
            }
        }
        int readInt2 = objectInput.readInt();
        HashSet hashSet3 = new HashSet(readInt2);
        for (int i6 = 0; i6 < readInt2; i6++) {
            hashSet3.add(new e(objectInput.readInt(), objectInput, hashMap));
        }
        this.f1317b = Collections.unmodifiableSet(hashSet2);
        this.f1318c = Collections.unmodifiableSet(hashSet3);
        if (i2 == 1) {
            int readInt3 = objectInput.readInt();
            hashSet = new HashSet(readInt3);
            for (int i7 = 0; i7 < readInt3; i7++) {
                hashSet.add(new d(objectInput.readInt(), objectInput, hashMap));
            }
        } else {
            hashSet = new HashSet();
        }
        this.f1319d = Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Set<h> set, Set<e> set2, Set<d> set3) {
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
        this.f1317b = set;
        this.f1318c = set2;
        this.f1319d = set3;
    }

    @Override // a.a.a.a.s.n.a
    public void a(ObjectOutput objectOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, objectOutput) == null) {
            objectOutput.writeInt(this.f1317b.size());
            for (h hVar : this.f1317b) {
                objectOutput.writeInt(hVar.f1375a);
                hVar.a(objectOutput);
            }
            objectOutput.writeInt(this.f1318c.size());
            for (e eVar : this.f1318c) {
                objectOutput.writeInt(eVar.f1375a);
                eVar.a(objectOutput);
            }
            objectOutput.writeInt(this.f1319d.size());
            for (d dVar : this.f1319d) {
                objectOutput.writeInt(dVar.f1375a);
                dVar.a(objectOutput);
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
            return Objects.equals(this.f1317b, aVar.f1317b) && Objects.equals(this.f1318c, aVar.f1318c);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Objects.hash(this.f1317b, this.f1318c) : invokeV.intValue;
    }
}

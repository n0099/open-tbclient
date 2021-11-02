package b.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes6.dex */
public class c extends c0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Set<Ssp> f31125a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<l> f31126b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<j> f31127c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i2, ObjectInput objectInput) {
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
            Ssp ssp = new Ssp(objectInput.readInt(), objectInput);
            hashSet2.add(ssp);
            for (Ssp.Pid pid : ssp.pids) {
                hashMap.put(Long.valueOf(pid.id), pid);
            }
        }
        int readInt2 = objectInput.readInt();
        HashSet hashSet3 = new HashSet(readInt2);
        for (int i6 = 0; i6 < readInt2; i6++) {
            hashSet3.add(new l(objectInput.readInt(), objectInput, hashMap));
        }
        this.f31125a = Collections.unmodifiableSet(hashSet2);
        this.f31126b = Collections.unmodifiableSet(hashSet3);
        if (i2 == 1) {
            int readInt3 = objectInput.readInt();
            hashSet = new HashSet(readInt3);
            for (int i7 = 0; i7 < readInt3; i7++) {
                hashSet.add(new j(objectInput.readInt(), objectInput, hashMap));
            }
        } else {
            hashSet = new HashSet();
        }
        this.f31127c = Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Set<Ssp> set, Set<l> set2, Set<j> set3) {
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
        this.f31125a = set;
        this.f31126b = set2;
        this.f31127c = set3;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return Objects.equals(this.f31125a, cVar.f31125a) && Objects.equals(this.f31126b, cVar.f31126b);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Objects.hash(this.f31125a, this.f31126b) : invokeV.intValue;
    }

    @Override // b.g.c0
    public void srzableInternal(ObjectOutput objectOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objectOutput) == null) {
            objectOutput.writeInt(this.f31125a.size());
            for (Ssp ssp : this.f31125a) {
                ssp.srzable(objectOutput);
            }
            objectOutput.writeInt(this.f31126b.size());
            for (l lVar : this.f31126b) {
                lVar.srzable(objectOutput);
            }
            objectOutput.writeInt(this.f31127c.size());
            for (j jVar : this.f31127c) {
                jVar.srzable(objectOutput);
            }
        }
    }
}

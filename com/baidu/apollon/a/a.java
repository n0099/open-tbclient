package com.baidu.apollon.a;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<ArrayList<b>> f35827a;

    /* renamed from: b  reason: collision with root package name */
    public int f35828b;

    /* renamed from: com.baidu.apollon.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1572a {
        void a();
    }

    /* loaded from: classes6.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f35829a;

        /* renamed from: b  reason: collision with root package name */
        public int f35830b;

        /* renamed from: c  reason: collision with root package name */
        public int f35831c;

        /* renamed from: d  reason: collision with root package name */
        public InterfaceC1572a f35832d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f35833e;

        public b(a aVar, int i2, int i3, int i4, InterfaceC1572a interfaceC1572a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), interfaceC1572a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35833e = aVar;
            this.f35829a = i2;
            this.f35830b = i3;
            this.f35831c = i4;
            this.f35832d = interfaceC1572a;
        }
    }

    public a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35827a = new SparseArray<>();
        this.f35828b = 0;
        this.f35828b = i2;
    }

    public void a(b bVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || (i2 = bVar.f35829a) < 0) {
            return;
        }
        ArrayList<b> arrayList = this.f35827a.get(i2);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f35827a.put(bVar.f35829a, arrayList);
        }
        arrayList.add(bVar);
    }

    public void b(int i2) {
        ArrayList<b> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (arrayList = this.f35827a.get(this.f35828b)) == null || arrayList.size() == 0) {
            return;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f35831c == i2) {
                this.f35828b = next.f35830b;
                next.f35832d.a();
                return;
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f35828b = i2;
        }
    }
}

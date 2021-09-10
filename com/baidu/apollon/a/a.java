package com.baidu.apollon.a;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<ArrayList<b>> f37753a;

    /* renamed from: b  reason: collision with root package name */
    public int f37754b;

    /* renamed from: com.baidu.apollon.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1609a {
        void a();
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f37755a;

        /* renamed from: b  reason: collision with root package name */
        public int f37756b;

        /* renamed from: c  reason: collision with root package name */
        public int f37757c;

        /* renamed from: d  reason: collision with root package name */
        public InterfaceC1609a f37758d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f37759e;

        public b(a aVar, int i2, int i3, int i4, InterfaceC1609a interfaceC1609a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), interfaceC1609a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37759e = aVar;
            this.f37755a = i2;
            this.f37756b = i3;
            this.f37757c = i4;
            this.f37758d = interfaceC1609a;
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
        this.f37753a = new SparseArray<>();
        this.f37754b = 0;
        this.f37754b = i2;
    }

    public void a(b bVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || (i2 = bVar.f37755a) < 0) {
            return;
        }
        ArrayList<b> arrayList = this.f37753a.get(i2);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f37753a.put(bVar.f37755a, arrayList);
        }
        arrayList.add(bVar);
    }

    public void b(int i2) {
        ArrayList<b> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (arrayList = this.f37753a.get(this.f37754b)) == null || arrayList.size() == 0) {
            return;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f37757c == i2) {
                this.f37754b = next.f37756b;
                next.f37758d.a();
                return;
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f37754b = i2;
        }
    }
}

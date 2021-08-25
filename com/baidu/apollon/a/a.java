package com.baidu.apollon.a;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<ArrayList<b>> f37634a;

    /* renamed from: b  reason: collision with root package name */
    public int f37635b;

    /* renamed from: com.baidu.apollon.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1609a {
        void a();
    }

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f37636a;

        /* renamed from: b  reason: collision with root package name */
        public int f37637b;

        /* renamed from: c  reason: collision with root package name */
        public int f37638c;

        /* renamed from: d  reason: collision with root package name */
        public InterfaceC1609a f37639d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f37640e;

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
            this.f37640e = aVar;
            this.f37636a = i2;
            this.f37637b = i3;
            this.f37638c = i4;
            this.f37639d = interfaceC1609a;
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
        this.f37634a = new SparseArray<>();
        this.f37635b = 0;
        this.f37635b = i2;
    }

    public void a(b bVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || (i2 = bVar.f37636a) < 0) {
            return;
        }
        ArrayList<b> arrayList = this.f37634a.get(i2);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f37634a.put(bVar.f37636a, arrayList);
        }
        arrayList.add(bVar);
    }

    public void b(int i2) {
        ArrayList<b> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (arrayList = this.f37634a.get(this.f37635b)) == null || arrayList.size() == 0) {
            return;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f37638c == i2) {
                this.f37635b = next.f37637b;
                next.f37639d.a();
                return;
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f37635b = i2;
        }
    }
}

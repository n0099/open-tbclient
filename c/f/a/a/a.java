package c.f.a.a;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SparseArray<ArrayList<b>> a;

    /* renamed from: b  reason: collision with root package name */
    public int f28503b;

    /* renamed from: c.f.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1573a {
        void a();
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f28504b;

        /* renamed from: c  reason: collision with root package name */
        public int f28505c;

        /* renamed from: d  reason: collision with root package name */
        public InterfaceC1573a f28506d;

        public b(a aVar, int i2, int i3, int i4, InterfaceC1573a interfaceC1573a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), interfaceC1573a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i2;
            this.f28504b = i3;
            this.f28505c = i4;
            this.f28506d = interfaceC1573a;
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
        this.a = new SparseArray<>();
        this.f28503b = 0;
        this.f28503b = i2;
    }

    public void a(int i2) {
        ArrayList<b> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (arrayList = this.a.get(this.f28503b)) == null || arrayList.size() == 0) {
            return;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f28505c == i2) {
                this.f28503b = next.f28504b;
                next.f28506d.a();
                return;
            }
        }
    }

    public void b(b bVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || (i2 = bVar.a) < 0) {
            return;
        }
        ArrayList<b> arrayList = this.a.get(i2);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.a.put(bVar.a, arrayList);
        }
        arrayList.add(bVar);
    }
}

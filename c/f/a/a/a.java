package c.f.a.a;

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
    public final SparseArray<ArrayList<b>> f32220a;

    /* renamed from: b  reason: collision with root package name */
    public int f32221b;

    /* renamed from: c.f.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1463a {
        void a();
    }

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f32222a;

        /* renamed from: b  reason: collision with root package name */
        public int f32223b;

        /* renamed from: c  reason: collision with root package name */
        public int f32224c;

        /* renamed from: d  reason: collision with root package name */
        public InterfaceC1463a f32225d;

        public b(a aVar, int i2, int i3, int i4, InterfaceC1463a interfaceC1463a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), interfaceC1463a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32222a = i2;
            this.f32223b = i3;
            this.f32224c = i4;
            this.f32225d = interfaceC1463a;
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
        this.f32220a = new SparseArray<>();
        this.f32221b = 0;
        this.f32221b = i2;
    }

    public void a(int i2) {
        ArrayList<b> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (arrayList = this.f32220a.get(this.f32221b)) == null || arrayList.size() == 0) {
            return;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f32224c == i2) {
                this.f32221b = next.f32223b;
                next.f32225d.a();
                return;
            }
        }
    }

    public void b(b bVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || (i2 = bVar.f32222a) < 0) {
            return;
        }
        ArrayList<b> arrayList = this.f32220a.get(i2);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f32220a.put(bVar.f32222a, arrayList);
        }
        arrayList.add(bVar);
    }
}

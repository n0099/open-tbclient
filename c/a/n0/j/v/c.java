package c.a.n0.j.v;

import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.input.ReturnKeyType;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f8947b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8948c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8949d;

    /* renamed from: e  reason: collision with root package name */
    public int f8950e;

    /* renamed from: f  reason: collision with root package name */
    public String f8951f;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        this.f8947b = Integer.MAX_VALUE;
        this.f8948c = false;
        this.f8949d = false;
    }

    public boolean a(c.a.n0.a.o.b.a aVar) throws JSTypeMismatchException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            try {
                this.a = aVar.B("defaultValue");
                this.f8947b = aVar.q("maxLength");
                this.f8948c = aVar.l("multiple");
                this.f8949d = aVar.l("confirmHold");
                String B = aVar.B("confirmType");
                char c2 = 65535;
                switch (B.hashCode()) {
                    case -906336856:
                        if (B.equals("search")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case SpeedStatsStampTable.AD_LOAD_BEAR_END_STAMP_KEY /* 3304 */:
                        if (B.equals(ReturnKeyType.GO)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 3089282:
                        if (B.equals("done")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 3377907:
                        if (B.equals("next")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 3526536:
                        if (B.equals(ReturnKeyType.SEND)) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    this.f8950e = 6;
                    this.f8951f = "done";
                } else if (c2 == 1) {
                    this.f8950e = 5;
                    this.f8951f = "next";
                } else if (c2 == 2) {
                    this.f8950e = 3;
                    this.f8951f = "search";
                } else if (c2 == 3) {
                    this.f8950e = 2;
                    this.f8951f = ReturnKeyType.GO;
                } else if (c2 != 4) {
                    this.f8950e = 6;
                    this.f8951f = "done";
                } else {
                    this.f8950e = 4;
                    this.f8951f = ReturnKeyType.SEND;
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}

package c.a.r0.a.o0.d;

import android.content.ContentValues;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public ContentValues f8215d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@Nullable Map<String, String> map) {
        super("lifecycle", map);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Map) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.r0.a.o0.d.c, c.a.r0.a.o0.d.b
    public void m(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            map.put("cuid", c.a.r0.a.c1.a.h0().i(c.a.r0.a.c1.a.c()));
            map.put("mtjCuid", c.a.r0.a.c1.a.h0().i(c.a.r0.a.c1.a.c()));
            ContentValues contentValues = this.f8215d;
            if (contentValues != null) {
                for (String str : contentValues.keySet()) {
                    Object obj = this.f8215d.get(str);
                    if (!(obj instanceof Number) && !(obj instanceof Boolean)) {
                        map.put(str, String.valueOf(obj));
                    } else {
                        map.put(str, obj);
                    }
                }
                return;
            }
            for (Map.Entry<String, String> entry : this.f8214c.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull ContentValues contentValues) {
        super("lifecycle", null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {contentValues};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Map) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f8215d = contentValues;
    }
}

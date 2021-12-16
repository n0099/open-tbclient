package c.a.r0.k0;

import android.content.Intent;
import com.baidu.tbadk.mutiprocess.DataType;
import com.baidu.tbadk.mutiprocess.ParcelableEvent;
import com.baidu.tbadk.mutiprocess.SerializableEvent;
import com.baidu.tbadk.mutiprocess.StickyEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(Intent intent, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, intent, aVar) == null) {
            if (aVar instanceof StickyEvent) {
                intent.putExtra("value_type", DataType.ORM.ordinal());
                intent.putExtra("value", (StickyEvent) aVar);
            } else if (aVar instanceof ParcelableEvent) {
                intent.putExtra("value_type", DataType.PARCELABLE.ordinal());
                intent.putExtra("value", (ParcelableEvent) aVar);
            } else if (aVar instanceof SerializableEvent) {
                intent.putExtra("value_type", DataType.SERIALIZABLE.ordinal());
                intent.putExtra("value", (SerializableEvent) aVar);
            }
        }
    }
}

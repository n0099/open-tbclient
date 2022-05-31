package com.baidu.nadcore.sweetsqlite;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.by0;
import com.repackage.hy0;
import java.io.Serializable;
/* loaded from: classes2.dex */
public abstract class Column implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 10929877886821294L;
    public transient /* synthetic */ FieldHolder $fh;
    public final by0 field;
    public boolean isAssignedValue;

    public Column(by0 by0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {by0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isAssignedValue = false;
        this.field = by0Var;
    }

    public abstract void clear();

    public void copyTo(Column column) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, column) == null) {
            hy0.f(this, column);
        }
    }

    public abstract String stringValue();

    public abstract int type();
}

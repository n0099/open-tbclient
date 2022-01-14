package com.baidu.ar.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "b";
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject bJ;
    public JSONObject bK;
    public e bL;
    public String bM;
    public ICallbackWith<String> bN;
    public Context mContext;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1920934103, "Lcom/baidu/ar/a/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1920934103, "Lcom/baidu/ar/a/b;");
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.bM = "default";
        if (context != null) {
            this.mContext = context.getApplicationContext();
            a a = d.a(context);
            if (a != null) {
                this.bJ = a.bI;
                this.bM = a.bH;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, aVar) == null) || aVar == null || (context = this.mContext) == null) {
            return;
        }
        this.bM = aVar.bH;
        this.bJ = aVar.bI;
        d.a(context, aVar);
    }

    public void a(ICallbackWith<String> iCallbackWith) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iCallbackWith) == null) {
            this.bN = iCallbackWith;
        }
    }

    public JSONObject af() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.bK == null) {
                String str = TAG;
                com.baidu.ar.h.b.c(str, "use inner config: " + this.bJ);
                return this.bJ;
            }
            String str2 = TAG;
            com.baidu.ar.h.b.c(str2, "use outter config: " + this.bK);
            return this.bK;
        }
        return (JSONObject) invokeV.objValue;
    }

    public int ag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.ag() : invokeV.intValue;
    }

    public void b(ICallbackWith<JSONObject> iCallbackWith) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iCallbackWith) == null) {
            e eVar = new e();
            this.bL = eVar;
            eVar.c(new ICallbackWith<String>(this) { // from class: com.baidu.ar.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b bO;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.bO = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.ar.callback.ICallbackWith
                /* renamed from: n */
                public void run(String str) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) || this.bO.bN == null) {
                        return;
                    }
                    this.bO.bN.run(str);
                }
            });
            this.bL.a(this.mContext, this.bM, new ICallbackWith<a>(this, iCallbackWith) { // from class: com.baidu.ar.a.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b bO;
                public final /* synthetic */ ICallbackWith bP;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iCallbackWith};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.bO = this;
                    this.bP = iCallbackWith;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.ar.callback.ICallbackWith
                /* renamed from: b */
                public void run(a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        this.bO.bL = null;
                        this.bO.a(aVar);
                        ICallbackWith iCallbackWith2 = this.bP;
                        if (iCallbackWith2 == null || aVar == null) {
                            return;
                        }
                        iCallbackWith2.run(aVar.bI);
                    }
                }
            });
        }
    }

    public void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            this.bK = jSONObject;
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.bN = null;
            e eVar = this.bL;
            if (eVar != null) {
                eVar.cancel();
                this.bL = null;
            }
            this.mContext = null;
        }
    }
}

package com.baidu.ar.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a<InT, OutT> implements b<InT, OutT> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean qH;
    public a<OutT, ?> tD;
    public OutT tE;
    public boolean tF;
    public boolean tG;
    public boolean tH;
    public int tI;
    public String tJ;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, this, i, str) == null) {
            this.tH = true;
            this.tI = i;
            this.tJ = str;
        }
    }

    private void fo() {
        a<OutT, ?> aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.qH || !this.tF || (aVar = this.tD) == null) {
            return;
        }
        if (this.tH) {
            aVar.b(this.tI, this.tJ);
        } else if (this.tG) {
        } else {
            aVar.h(this.tE);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.ar.e.a<OutT, T> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> b<OutT, T> a(a<OutT, T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            this.tD = aVar;
            fo();
            return aVar;
        }
        return (b) invokeL.objValue;
    }

    public void a(int i, String str, IError iError) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, iError) == null) || iError == null) {
            return;
        }
        iError.onError(i, str, null);
    }

    public abstract void a(InT r1, ICallbackWith<OutT> iCallbackWith, IError iError);

    public final void b(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            this.tF = true;
            this.tG = true;
            a(i, str, new IError(this) { // from class: com.baidu.ar.e.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a tK;

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
                    this.tK = this;
                }

                @Override // com.baidu.ar.callback.IError
                public void onError(int i2, String str2, Exception exc) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str2, exc) == null) {
                        this.tK.a(i2, str2);
                        if (this.tK.qH || this.tK.tD == null) {
                            return;
                        }
                        this.tK.tD.b(i2, str2);
                    }
                }
            });
        }
    }

    @Override // com.baidu.ar.callback.ICancellable
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.qH = true;
            fp();
        }
    }

    public abstract void fp();

    public final void h(InT r5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, r5) == null) || this.qH) {
            return;
        }
        a((a<InT, OutT>) r5, new ICallbackWith<OutT>(this) { // from class: com.baidu.ar.e.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a tK;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.tK = this;
            }

            @Override // com.baidu.ar.callback.ICallbackWith
            public void run(OutT outt) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, outt) == null) {
                    this.tK.tF = true;
                    this.tK.tE = outt;
                    if (this.tK.qH || this.tK.tD == null) {
                        return;
                    }
                    this.tK.tD.h(outt);
                }
            }
        }, new IError(this) { // from class: com.baidu.ar.e.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a tK;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.tK = this;
            }

            @Override // com.baidu.ar.callback.IError
            public void onError(int i, String str, Exception exc) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, exc) == null) {
                    this.tK.b(i, str);
                }
            }
        });
    }
}

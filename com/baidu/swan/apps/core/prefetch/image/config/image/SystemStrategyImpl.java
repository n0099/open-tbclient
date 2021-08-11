package com.baidu.swan.apps.core.prefetch.image.config.image;

import android.webkit.MimeTypeMap;
import androidx.annotation.NonNull;
import c.a.n0.a.h0.o.h.d.b.a;
import c.a.n0.a.h0.o.h.g.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class SystemStrategyImpl implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f45697a;

    public SystemStrategyImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45697a = new ArrayList<String>(this) { // from class: com.baidu.swan.apps.core.prefetch.image.config.image.SystemStrategyImpl.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SystemStrategyImpl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
                add("png");
                add("jpg");
                add("jpeg");
                add(OvalActionButton.WEBP);
                add("bmp");
                add("gif");
            }
        };
    }

    @Override // c.a.n0.a.h0.o.h.d.b.a
    public boolean a(@NonNull g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(gVar.d());
            gVar.a(MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl));
            return this.f45697a.contains(fileExtensionFromUrl);
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "SystemStrategyImpl" : (String) invokeV.objValue;
    }
}

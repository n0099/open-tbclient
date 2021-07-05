package a.a.a.a;

import a.a.a.a.y.f.g.d;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunNativeAd;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b implements FunNativeAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f1007a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b f1008b;

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1007a = str;
        this.f1008b = new d.b(str);
    }

    public abstract void a(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener);

    @Override // com.fun.ad.sdk.FunNativeAd
    public final void show(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, viewGroup, list, list2, funAdInteractionListener) == null) {
            if (context == null || viewGroup == null || list == null || funAdInteractionListener == null) {
                throw new IllegalArgumentException();
            }
            this.f1008b.c();
            a(context, viewGroup, list, list2, funAdInteractionListener);
        }
    }
}

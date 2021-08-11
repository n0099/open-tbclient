package b.a.a.a.t.b.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.a.a.a.t.a.e.c;
import b.a.a.a.u.h;
import b.a.a.a.x.f.g.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunNativeAd;
import com.win.opensdk.PBNative;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends b.a.a.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final PBNative f1397c;

    /* renamed from: d  reason: collision with root package name */
    public final c f1398d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PBNative pBNative, String str, h.a aVar, c cVar) {
        super(str, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pBNative, str, aVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (h.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1397c = pBNative;
        this.f1398d = cVar;
    }

    @Override // b.a.a.a.a
    public void a(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, context, viewGroup, list, list2, funAdInteractionListener) == null) {
            c cVar = this.f1398d;
            PBNative pBNative = this.f1397c;
            String str = this.f1043a;
            synchronized (cVar.o) {
                c.b bVar = cVar.o.get(pBNative);
                if (bVar == null) {
                    bVar = new c.b(str);
                    cVar.o.put(pBNative, bVar);
                }
                b.g(bVar.f1316b, cVar.f1057h.f1519a, "sh_start", new Object[0]);
                bVar.f1316b = true;
                bVar.f1317c = funAdInteractionListener;
            }
            pBNative.registerViewForInteraction(viewGroup, null, list);
        }
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public ChannelNativeAds_6 getChannelNativeAds_6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ChannelNativeAds_6.create(this.f1397c) : (ChannelNativeAds_6) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1397c.getBody() : (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1397c.getIcon() : (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public List<String> getImageUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f1397c.getIM());
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public FunNativeAd.InteractionType getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1397c.isD() ? FunNativeAd.InteractionType.TYPE_DOWNLOAD : FunNativeAd.InteractionType.TYPE_BROWSE : (FunNativeAd.InteractionType) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f1397c.getHeadline() : (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public View getVideoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }
}

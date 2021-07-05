package a.a.a.a.u.b.c;

import a.a.a.a.b;
import a.a.a.a.u.a.d.b;
import a.a.a.a.y.f.g.c;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
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
public class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final PBNative f1308c;

    /* renamed from: d  reason: collision with root package name */
    public final a.a.a.a.u.a.d.b f1309d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PBNative pBNative, String str, a.a.a.a.u.a.d.b bVar) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pBNative, str, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1308c = pBNative;
        this.f1309d = bVar;
    }

    @Override // a.a.a.a.b
    public void a(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, context, viewGroup, list, list2, funAdInteractionListener) == null) {
            a.a.a.a.u.a.d.b bVar = this.f1309d;
            PBNative pBNative = this.f1308c;
            String str = this.f1007a;
            synchronized (bVar.n) {
                b.C0002b c0002b = bVar.n.get(pBNative);
                if (c0002b == null) {
                    c0002b = new b.C0002b(str);
                    bVar.n.put(pBNative, c0002b);
                }
                c.a(c0002b.f1235b, bVar.f1017h.f1409a, "sh_start", new Object[0]);
                c0002b.f1235b = true;
                c0002b.f1236c = funAdInteractionListener;
            }
            pBNative.registerViewForInteraction(viewGroup, null, list);
        }
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public ChannelNativeAds_6 getChannelNativeAds_6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ChannelNativeAds_6.create(this.f1308c) : (ChannelNativeAds_6) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1308c.getBody() : (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1308c.getIcon() : (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public List<String> getImageUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f1308c.getIM());
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public FunNativeAd.InteractionType getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1308c.isD() ? FunNativeAd.InteractionType.TYPE_DOWNLOAD : FunNativeAd.InteractionType.TYPE_BROWSE : (FunNativeAd.InteractionType) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f1308c.getHeadline() : (String) invokeV.objValue;
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

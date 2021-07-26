package a.a.a.a.r.a.c;

import a.a.a.a.s.h;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class l extends a.a.a.a.b<RewardVideoAD> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<RewardVideoAD, String> n;

    /* loaded from: classes.dex */
    public class a implements RewardVideoADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1203a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1204b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ RewardVideoAD[] f1205c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1206d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f1207e;

        public a(l lVar, RewardVideoAD[] rewardVideoADArr, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, rewardVideoADArr, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1207e = lVar;
            this.f1205c = rewardVideoADArr;
            this.f1206d = funAdSlot;
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.a.a.a.v.d.a();
                this.f1207e.f1015h.a(this.f1204b);
                this.f1204b = true;
                this.f1207e.e();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a.a.a.a.v.d.a();
                this.f1207e.f1015h.d();
                this.f1207e.f();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADExpose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                a.a.a.a.v.d.a();
                this.f1207e.f1015h.b(this.f1203a);
                this.f1203a = true;
                RewardVideoAD rewardVideoAD = this.f1205c[0];
                l lVar = this.f1207e;
                lVar.a((l) rewardVideoAD, lVar.n.remove(rewardVideoAD));
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                a.a.a.a.v.d.a();
                this.f1207e.f1015h.b();
                RewardVideoAD rewardVideoAD = this.f1205c[0];
                this.f1207e.n.put(rewardVideoAD, this.f1206d.getSid());
                l lVar = this.f1207e;
                lVar.a((l) rewardVideoAD);
                lVar.h();
                this.f1207e.l.b(rewardVideoAD, this.f1206d.getSid());
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                a.a.a.a.v.d.a();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onError(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, adError) == null) {
                a.a.a.a.v.d.b("GDTRewardVideoAd onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
                this.f1207e.f1015h.a(Integer.valueOf(adError.getErrorCode()));
                this.f1207e.b(adError.getErrorCode(), adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onReward(Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, map) == null) {
                a.a.a.a.v.d.a();
                this.f1207e.f1015h.f();
                this.f1207e.i();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoCached() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                a.a.a.a.v.d.a();
                this.f1207e.f1015h.c();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                a.a.a.a.v.d.a();
                this.f1207e.f1015h.j();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(h.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((h.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new HashMap<>();
    }

    @Override // a.a.a.a.b
    public a.a.a.a.u.a a(h.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? new a.a.a.a.u.i(aVar) : (a.a.a.a.u.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, RewardVideoAD rewardVideoAD) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, viewGroup, str, rewardVideoAD)) == null) {
            RewardVideoAD rewardVideoAD2 = rewardVideoAD;
            this.f1015h.g();
            this.n.put(rewardVideoAD2, str);
            rewardVideoAD2.showAD(activity);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            a aVar = new a(this, r1, funAdSlot);
            this.f1015h.a(funAdSlot, this.f1016i);
            RewardVideoAD rewardVideoAD = new RewardVideoAD(context.getApplicationContext(), this.f1016i.f1361c, (RewardVideoADListener) aVar, true);
            RewardVideoAD[] rewardVideoADArr = {rewardVideoAD};
            rewardVideoAD.loadAD();
            g();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(RewardVideoAD rewardVideoAD) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rewardVideoAD) == null) {
            this.n.remove(rewardVideoAD);
        }
    }
}

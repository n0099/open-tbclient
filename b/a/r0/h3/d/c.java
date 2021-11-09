package b.a.r0.h3.d;

import android.content.res.Configuration;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import b.a.e.e.m.e;
import b.a.q0.q0.l;
import b.a.r0.h3.b.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c implements b.a.r0.h3.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final b.a.r0.h3.b.c f17750a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final d f17751b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.q0.a1.a f17752c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f17753d;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f17754e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17754e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17754e.f17751b.a();
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    }

    public c(@NonNull b.a.r0.h3.b.c cVar, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17753d = new a(this);
        this.f17750a = cVar;
        this.f17751b = dVar;
    }

    @Override // b.a.r0.h3.b.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.q0.a1.a aVar = this.f17752c;
            if (aVar != null) {
                aVar.release();
            }
            d();
        }
    }

    @Override // b.a.r0.h3.b.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_START_STAMP_KEY);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, b.a.q0.a1.a.class, this.f17750a.getActivity());
            if (runTask == null || runTask.getData() == null) {
                return false;
            }
            b.a.q0.a1.a aVar = (b.a.q0.a1.a) runTask.getData();
            this.f17752c = aVar;
            aVar.b(new b(this.f17750a, this.f17751b, this));
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 2).param("obj_locate", 2).param("obj_type", "a064"));
            f();
            this.f17752c.a();
            l.b().j(System.currentTimeMillis() - currentTimeMillis);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e.a().removeCallbacks(this.f17753d);
        }
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            b.a.q0.a1.a aVar = this.f17752c;
            if (aVar != null) {
                return aVar.getView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int k = b.a.q0.s.e0.b.j().k("video_splash_timeout", 1);
            e.a().postDelayed(this.f17753d, (k > 0 ? k : 1) * 1000);
        }
    }

    @Override // b.a.r0.h3.b.a
    public void onConfigurationChanged(Configuration configuration) {
        b.a.q0.a1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, configuration) == null) || (aVar = this.f17752c) == null || aVar.getView() == null || this.f17752c.getView().getParent() == null) {
            return;
        }
        boolean z = false;
        if (this.f17752c.getView() != null) {
            if (this.f17752c.getView().getHeight() == b.a.e.e.p.l.i(this.f17750a.getActivity())) {
                z = true;
            }
        }
        int k = b.a.e.e.p.l.k(this.f17750a.getActivity());
        int i2 = b.a.e.e.p.l.i(this.f17750a.getActivity());
        if (!z) {
            i2 = (int) (b.a.e.e.p.l.i(this.f17750a.getActivity()) * 0.8125d);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f17752c.getView().getLayoutParams();
        layoutParams.width = k;
        layoutParams.height = i2;
        this.f17752c.getView().setLayoutParams(layoutParams);
    }

    @Override // b.a.r0.h3.b.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // b.a.r0.h3.b.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }
}

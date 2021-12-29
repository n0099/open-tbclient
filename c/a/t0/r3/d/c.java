package c.a.t0.r3.d;

import android.content.res.Configuration;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import c.a.d.f.m.e;
import c.a.d.f.p.n;
import c.a.s0.s0.l;
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
/* loaded from: classes8.dex */
public class c implements c.a.t0.r3.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final c.a.t0.r3.b.b a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final c.a.t0.r3.b.c f22485b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.b1.a f22486c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f22487d;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22488e;

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
            this.f22488e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22488e.f22485b.a();
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    }

    public c(@NonNull c.a.t0.r3.b.b bVar, @NonNull c.a.t0.r3.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22487d = new a(this);
        this.a = bVar;
        this.f22485b = cVar;
    }

    @Override // c.a.t0.r3.b.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.s0.b1.a aVar = this.f22486c;
            if (aVar != null) {
                aVar.release();
            }
            d();
        }
    }

    @Override // c.a.t0.r3.b.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_START_STAMP_KEY);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, c.a.s0.b1.a.class, this.a.getActivity());
            if (runTask == null || runTask.getData() == null) {
                return false;
            }
            c.a.s0.b1.a aVar = (c.a.s0.b1.a) runTask.getData();
            this.f22486c = aVar;
            aVar.b(new b(this.a, this.f22485b, this));
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 2).param("obj_locate", 2).param("obj_type", "a064"));
            f();
            this.f22486c.a();
            l.b().j(System.currentTimeMillis() - currentTimeMillis);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e.a().removeCallbacks(this.f22487d);
        }
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.s0.b1.a aVar = this.f22486c;
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
            int k2 = c.a.s0.s.g0.b.j().k("video_splash_timeout", 1);
            e.a().postDelayed(this.f22487d, (k2 > 0 ? k2 : 1) * 1000);
        }
    }

    @Override // c.a.t0.r3.b.a
    public void onConfigurationChanged(Configuration configuration) {
        c.a.s0.b1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, configuration) == null) || (aVar = this.f22486c) == null || aVar.getView() == null || this.f22486c.getView().getParent() == null) {
            return;
        }
        boolean z = false;
        if (this.f22486c.getView() != null) {
            if (this.f22486c.getView().getHeight() == n.i(this.a.getActivity())) {
                z = true;
            }
        }
        int k2 = n.k(this.a.getActivity());
        int i2 = n.i(this.a.getActivity());
        if (!z) {
            i2 = (int) (n.i(this.a.getActivity()) * 0.8125d);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f22486c.getView().getLayoutParams();
        layoutParams.width = k2;
        layoutParams.height = i2;
        this.f22486c.getView().setLayoutParams(layoutParams);
    }

    @Override // c.a.t0.r3.b.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // c.a.t0.r3.b.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }
}

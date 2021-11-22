package b.a.r0.i3.d;

import android.content.res.Configuration;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import b.a.e.f.m.e;
import b.a.q0.q0.l;
import b.a.r0.i3.b.d;
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
public class c implements b.a.r0.i3.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final b.a.r0.i3.b.c f19461a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final d f19462b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.q0.z0.a f19463c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f19464d;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19465e;

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
            this.f19465e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19465e.f19462b.a();
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    }

    public c(@NonNull b.a.r0.i3.b.c cVar, @NonNull d dVar) {
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
        this.f19464d = new a(this);
        this.f19461a = cVar;
        this.f19462b = dVar;
    }

    @Override // b.a.r0.i3.b.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.q0.z0.a aVar = this.f19463c;
            if (aVar != null) {
                aVar.release();
            }
            d();
        }
    }

    @Override // b.a.r0.i3.b.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_START_STAMP_KEY);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, b.a.q0.z0.a.class, this.f19461a.getActivity());
            if (runTask == null || runTask.getData() == null) {
                return false;
            }
            b.a.q0.z0.a aVar = (b.a.q0.z0.a) runTask.getData();
            this.f19463c = aVar;
            aVar.b(new b(this.f19461a, this.f19462b, this));
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 2).param("obj_locate", 2).param("obj_type", "a064"));
            f();
            this.f19463c.a();
            l.b().j(System.currentTimeMillis() - currentTimeMillis);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e.a().removeCallbacks(this.f19464d);
        }
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            b.a.q0.z0.a aVar = this.f19463c;
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
            e.a().postDelayed(this.f19464d, (k > 0 ? k : 1) * 1000);
        }
    }

    @Override // b.a.r0.i3.b.a
    public void onConfigurationChanged(Configuration configuration) {
        b.a.q0.z0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, configuration) == null) || (aVar = this.f19463c) == null || aVar.getView() == null || this.f19463c.getView().getParent() == null) {
            return;
        }
        boolean z = false;
        if (this.f19463c.getView() != null) {
            if (this.f19463c.getView().getHeight() == b.a.e.f.p.l.i(this.f19461a.getActivity())) {
                z = true;
            }
        }
        int k = b.a.e.f.p.l.k(this.f19461a.getActivity());
        int i2 = b.a.e.f.p.l.i(this.f19461a.getActivity());
        if (!z) {
            i2 = (int) (b.a.e.f.p.l.i(this.f19461a.getActivity()) * 0.8125d);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f19463c.getView().getLayoutParams();
        layoutParams.width = k;
        layoutParams.height = i2;
        this.f19463c.getView().setLayoutParams(layoutParams);
    }

    @Override // b.a.r0.i3.b.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // b.a.r0.i3.b.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }
}

package c.a.p0.q1.i.o;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.e.m.d;
import c.a.p0.c3.w.d;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class c extends c.a.p0.c3.w.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.e.m.d P0;
    public ThreadData Q0;
    public boolean R0;
    public boolean S0;
    public CustomMessageListener T0;
    public Runnable U0;

    /* loaded from: classes2.dex */
    public class a implements d.InterfaceC0114d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.e.m.d.InterfaceC0114d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.startPlay();
            }
        }

        @Override // c.a.e.m.d.InterfaceC0114d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.e.m.d.InterfaceC0114d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // c.a.e.m.d.InterfaceC0114d
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.p0.c3.w.d.l
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || this.a.g0()) {
                return;
            }
            if (i2 >= i) {
                if (this.a.P0 != null) {
                    this.a.P0.I(false, false, "HOME");
                }
            } else if (i == 0 || this.a.T || (i2 * 100) / i < 80 || i <= 15000) {
            } else {
                c cVar = this.a;
                cVar.G0(cVar.Q0);
            }
        }
    }

    /* renamed from: c.a.p0.q1.i.o.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1312c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1312c(c cVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.e.m.e.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof c.a.e.m.e.b) || (bVar = (c.a.e.m.e.b) customResponsedMessage.getData()) == null) {
                return;
            }
            String d2 = bVar.d();
            if (StringUtils.isNull(d2) || this.a.Q0 == null || !d2.equals(this.a.Q0.getId())) {
                return;
            }
            this.a.F0();
            c.a.e.m.d dVar = this.a.P0;
            c cVar = this.a;
            dVar.K(cVar.E0(cVar.Q0, bVar));
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.P0 == null) {
                return;
            }
            c cVar = this.a;
            cVar.S0 = false;
            cVar.P0.L();
            this.a.P0.w();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, View view) {
        super(context, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.R0 = false;
        this.T0 = new C1312c(this, 2921395);
        this.U0 = new d(this);
        l0(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c.a.e.m.a E0(ThreadData threadData, c.a.e.m.e.b bVar) {
        InterceptResult invokeLL;
        int i;
        VideoInfo threadVideoInfo;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, threadData, bVar)) == null) {
            if (threadData == null || bVar == null) {
                return null;
            }
            int c2 = bVar.c();
            int b2 = bVar.b();
            int a2 = bVar.a();
            int i4 = -1;
            if (a2 != -1) {
                int i5 = c2 != -1 ? (a2 - c2) - 1 : -1;
                if (b2 != -1) {
                    i4 = i5;
                    i = (b2 - a2) - 1;
                    threadVideoInfo = threadData.getThreadVideoInfo();
                    if (threadVideoInfo == null) {
                        int intValue = threadVideoInfo.video_width.intValue();
                        i3 = threadVideoInfo.video_height.intValue();
                        i2 = intValue;
                    } else {
                        i2 = 0;
                        i3 = 0;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("video_vid", threadData.getId());
                    hashMap.put("video_title", threadData.getTitle());
                    hashMap.put("forum_id", String.valueOf(threadData.getFid()));
                    hashMap.put("forum_name", threadData.getForum_name());
                    hashMap.put("up_distance", String.valueOf(i4));
                    hashMap.put("down_distance", String.valueOf(i));
                    c.a.e.m.a h2 = c.a.e.m.c.h(3, 0, "1546854828072", a2 + 1, i2, i3);
                    h2.a(hashMap);
                    return h2;
                }
                i4 = i5;
            }
            i = -1;
            threadVideoInfo = threadData.getThreadVideoInfo();
            if (threadVideoInfo == null) {
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("video_vid", threadData.getId());
            hashMap2.put("video_title", threadData.getTitle());
            hashMap2.put("forum_id", String.valueOf(threadData.getFid()));
            hashMap2.put("forum_name", threadData.getForum_name());
            hashMap2.put("up_distance", String.valueOf(i4));
            hashMap2.put("down_distance", String.valueOf(i));
            c.a.e.m.a h22 = c.a.e.m.c.h(3, 0, "1546854828072", a2 + 1, i2, i3);
            h22.a(hashMap2);
            return h22;
        }
        return (c.a.e.m.a) invokeLL.objValue;
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.P0 == null) {
            c.a.e.m.d dVar = new c.a.e.m.d(this.O, (ViewGroup) getMainView());
            this.P0 = dVar;
            dVar.G(new a(this));
            m0(new b(this));
        }
    }

    public final void G0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) || threadData == null || threadData.getId() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, threadData.getId()));
    }

    @Override // c.a.p0.c3.w.d
    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.c3.w.d, c.a.p0.c3.w.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.e.m.d dVar = this.P0;
            if (dVar == null || !dVar.r()) {
                return super.isPlaying();
            }
            return this.S0 || this.P0.t();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.w.d, c.a.p0.c3.w.a
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            c.a.e.m.d dVar = this.P0;
            if (dVar != null) {
                if (z) {
                    if (dVar.r()) {
                        this.S0 = false;
                        this.P0.L();
                    }
                } else if (dVar.r()) {
                    this.R0 = true;
                    this.P0.F(true);
                }
            }
            return super.onBackground(z);
        }
        return invokeZ.booleanValue;
    }

    @Override // c.a.p0.c3.w.b, c.a.p0.c3.w.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.e.m.d dVar = this.P0;
            if ((dVar != null ? dVar.I(false, false, "HOME") : false) || UbsABTestHelper.isFeedVideoImmersionTransition()) {
                return;
            }
            startPlay();
        }
    }

    @Override // c.a.p0.c3.w.b, c.a.p0.c3.w.d, c.a.p0.c3.w.a
    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, threadData) == null) || threadData == null) {
            return;
        }
        super.setData(threadData);
        boolean z = this.Q0 == threadData;
        this.Q0 = threadData;
        if (this.P0 != null) {
            if (this.R0 && z) {
                this.R0 = false;
            } else {
                this.P0.B();
            }
        }
    }

    @Override // c.a.p0.c3.w.d, c.a.p0.c3.w.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.T0.setTag(this.R);
            MessageManager.getInstance().registerListener(this.T0);
        }
    }

    @Override // c.a.p0.c3.w.d, c.a.p0.c3.w.a
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.e.m.d dVar = this.P0;
            if (dVar != null && dVar.r()) {
                this.S0 = true;
                this.P0.E();
                return;
            }
            super.startPlay();
        }
    }

    @Override // c.a.p0.c3.w.d, c.a.p0.c3.w.a
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.stopPlay();
            c.a.e.m.d dVar = this.P0;
            if (dVar == null || !dVar.r()) {
                return;
            }
            c.a.d.f.m.e.a().removeCallbacks(this.U0);
            c.a.d.f.m.e.a().post(this.U0);
        }
    }
}

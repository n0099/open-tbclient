package c.a.r0.q2.u.f;

import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.s.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class u extends c.a.q0.x.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public VoiceData$VoiceModel f22206f;

    /* renamed from: g  reason: collision with root package name */
    public LocationModel f22207g;

    /* renamed from: h  reason: collision with root package name */
    public PbEditorData.ThreadData f22208h;

    /* renamed from: i  reason: collision with root package name */
    public BaseActivity<?> f22209i;

    /* renamed from: j  reason: collision with root package name */
    public int f22210j;

    /* renamed from: k  reason: collision with root package name */
    public LocationModel.e f22211k;
    public LocationModel.f l;

    /* loaded from: classes6.dex */
    public class a implements LocationModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u a;

        public a(u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uVar;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f22209i.showToast(c.a.r0.q2.l.no_network_guide);
                this.a.n(0, false, null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData locationData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locationData) == null) {
                if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                    this.a.n(2, true, locationData.getFormatted_address());
                } else {
                    onFail(null);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                BaseActivity baseActivity = this.a.f22209i;
                if (StringUtils.isNull(str)) {
                    str = this.a.a().getContext().getString(c.a.r0.q2.l.location_fail);
                }
                baseActivity.showToast(str);
                this.a.n(0, false, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements LocationModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u a;

        public b(u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uVar;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.n(0, false, null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.f
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.n(2, true, str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u f22212e;

        public c(u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22212e = uVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f22212e.n(0, true, null);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u f22213e;

        public d(u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22213e = uVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (c.a.d.f.p.j.z()) {
                    this.f22213e.n(1, true, null);
                    this.f22213e.f22207g.L();
                } else {
                    this.f22213e.f22211k.a();
                }
                aVar.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(EditorTools editorTools) {
        super(editorTools);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {editorTools};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((EditorTools) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22210j = 0;
        this.f22211k = new a(this);
        this.l = new b(this);
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22210j : invokeV.intValue;
    }

    public VoiceData$VoiceModel g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22206f : (VoiceData$VoiceModel) invokeV.objValue;
    }

    public BaseActivity<?> getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22209i : (BaseActivity) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.f22209i.getActivity())));
        }
    }

    public void i(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, baseActivity) == null) {
            LocationModel locationModel = new LocationModel(baseActivity.getPageContext());
            this.f22207g = locationModel;
            locationModel.O(this.f22211k);
            this.f22207g.P(this.l);
            if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && a() != null) {
                a().sendAction(new c.a.q0.x.a(2, 12, " "));
            }
            if (this.f22207g.z() || a() == null) {
                return;
            }
            a().sendAction(new c.a.q0.x.a(20, 8, null));
        }
    }

    public void j(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) && i3 == -1 && i2 == 23004) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!PermissionUtil.checkLocationForGoogle(this.f22209i.getActivity())) {
                PermissionUtil.reuqestLocation(this.f22209i.getActivity(), 0);
            } else {
                s();
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f22207g.z()) {
                if (this.f22207g.D()) {
                    this.f22211k.b(c.a.r0.t3.o0.b.a().b());
                    return;
                }
                if (c.a.d.f.p.l.C()) {
                    this.f22207g.I();
                }
                n(0, true, null);
                return;
            }
            n(0, false, null);
        }
    }

    public void m() {
        PbEditorData.ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (threadData = this.f22208h) == null || StringUtils.isNull(threadData.getAuthorName()) || this.f22208h.getAuthorId() <= 0) {
            return;
        }
        String valueOf = String.valueOf(this.f22208h.getAuthorId());
        if (valueOf != null && !valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.f22209i.getActivity(), this.f22208h.getAuthorId(), this.f22208h.getAuthorName(), this.f22208h.getAuthorNameShow(), GiftTabActivityConfig.FROM_PB, c.a.d.f.m.b.g(this.f22208h.getThreadId(), 0L), c.a.d.f.m.b.g(this.f22208h.getPostId(), 0L))));
        } else {
            c.a.d.f.p.l.L(this.f22209i.getActivity(), c.a.r0.q2.l.can_not_send_gift_to_yourself);
        }
    }

    public final void n(int i2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str}) == null) {
            this.f22210j = i2;
            if (a() != null) {
                a().sendAction(new c.a.q0.x.a(19, 8, new c.a.q0.x.v.a(i2, z, str)));
            }
        }
    }

    public void o(BaseActivity<?> baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, baseActivity) == null) {
            this.f22209i = baseActivity;
        }
    }

    public void p(PbEditorData.ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, threadData) == null) {
            this.f22208h = threadData;
            if (a() == null || this.f22208h == null) {
                return;
            }
            a().setFid(c.a.d.f.m.b.g(this.f22208h.getForumId(), 0L));
            a().setTid(this.f22208h.getThreadId());
        }
    }

    public void q(VoiceData$VoiceModel voiceData$VoiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, voiceData$VoiceModel) == null) {
            this.f22206f = voiceData$VoiceModel;
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f22209i.getActivity());
            aVar.setMessageId(c.a.r0.q2.l.location_app_permission_prompt).setPositiveButton(c.a.r0.q2.l.isopen, new d(this)).setNegativeButton(c.a.r0.q2.l.cancel, new c(this)).create(this.f22209i.getPageContext());
            aVar.show();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!this.f22207g.E(this.f22209i.getActivity())) {
                this.f22209i.showToast(c.a.r0.q2.l.location_system_permission_prompt);
            } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
                r();
            } else if (this.f22207g.D()) {
                h();
            } else {
                this.f22207g.N(false);
                n(1, true, null);
                this.f22207g.I();
            }
        }
    }
}

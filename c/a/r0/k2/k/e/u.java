package c.a.r0.k2.k.e;

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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class u extends c.a.q0.x.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public VoiceData$VoiceModel f20498f;

    /* renamed from: g  reason: collision with root package name */
    public LocationModel f20499g;

    /* renamed from: h  reason: collision with root package name */
    public PbEditorData.ThreadData f20500h;

    /* renamed from: i  reason: collision with root package name */
    public BaseActivity<?> f20501i;

    /* renamed from: j  reason: collision with root package name */
    public int f20502j;
    public LocationModel.e k;
    public LocationModel.f l;

    /* loaded from: classes3.dex */
    public class a implements LocationModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ u f20503a;

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
            this.f20503a = uVar;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20503a.f20501i.showToast(R.string.no_network_guide);
                this.f20503a.o(0, false, null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData locationData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locationData) == null) {
                if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                    this.f20503a.o(2, true, locationData.getFormatted_address());
                } else {
                    onFail(null);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                BaseActivity baseActivity = this.f20503a.f20501i;
                if (StringUtils.isNull(str)) {
                    str = this.f20503a.a().getContext().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                this.f20503a.o(0, false, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements LocationModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ u f20504a;

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
            this.f20504a = uVar;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20504a.o(0, false, null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.f
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f20504a.o(2, true, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u f20505e;

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
            this.f20505e = uVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f20505e.o(0, true, null);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u f20506e;

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
            this.f20506e = uVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (c.a.e.e.p.j.z()) {
                    this.f20506e.o(1, true, null);
                    this.f20506e.f20499g.K();
                } else {
                    this.f20506e.k.a();
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
        this.f20502j = 0;
        this.k = new a(this);
        this.l = new b(this);
    }

    public BaseActivity<?> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20501i : (BaseActivity) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20502j : invokeV.intValue;
    }

    public VoiceData$VoiceModel h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20498f : (VoiceData$VoiceModel) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.f20501i.getActivity())));
        }
    }

    public void j(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, baseActivity) == null) {
            LocationModel locationModel = new LocationModel(baseActivity.getPageContext());
            this.f20499g = locationModel;
            locationModel.N(this.k);
            this.f20499g.O(this.l);
            if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && a() != null) {
                a().sendAction(new c.a.q0.x.a(2, 12, " "));
            }
            if (this.f20499g.z() || a() == null) {
                return;
            }
            a().sendAction(new c.a.q0.x.a(20, 8, null));
        }
    }

    public void k(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) && i3 == -1 && i2 == 23004) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!PermissionUtil.checkLocationForGoogle(this.f20501i.getActivity())) {
                PermissionUtil.reuqestLocation(this.f20501i.getActivity(), 0);
            } else {
                t();
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f20499g.z()) {
                if (this.f20499g.D()) {
                    this.k.b(c.a.r0.k3.n0.b.a().b());
                    return;
                }
                if (c.a.e.e.p.l.D()) {
                    this.f20499g.H();
                }
                o(0, true, null);
                return;
            }
            o(0, false, null);
        }
    }

    public void n() {
        PbEditorData.ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (threadData = this.f20500h) == null || StringUtils.isNull(threadData.getAuthorName()) || this.f20500h.getAuthorId() <= 0) {
            return;
        }
        String valueOf = String.valueOf(this.f20500h.getAuthorId());
        if (valueOf != null && !valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.f20501i.getActivity(), this.f20500h.getAuthorId(), this.f20500h.getAuthorName(), this.f20500h.getAuthorNameShow(), GiftTabActivityConfig.FROM_PB, c.a.e.e.m.b.g(this.f20500h.getThreadId(), 0L), c.a.e.e.m.b.g(this.f20500h.getPostId(), 0L))));
        } else {
            c.a.e.e.p.l.L(this.f20501i.getActivity(), R.string.can_not_send_gift_to_yourself);
        }
    }

    public final void o(int i2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str}) == null) {
            this.f20502j = i2;
            if (a() != null) {
                a().sendAction(new c.a.q0.x.a(19, 8, new c.a.q0.x.v.a(i2, z, str)));
            }
        }
    }

    public void p(BaseActivity<?> baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, baseActivity) == null) {
            this.f20501i = baseActivity;
        }
    }

    public void q(PbEditorData.ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, threadData) == null) {
            this.f20500h = threadData;
            if (a() == null || this.f20500h == null) {
                return;
            }
            a().setFid(c.a.e.e.m.b.g(this.f20500h.getForumId(), 0L));
            a().setTid(this.f20500h.getThreadId());
        }
    }

    public void r(VoiceData$VoiceModel voiceData$VoiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, voiceData$VoiceModel) == null) {
            this.f20498f = voiceData$VoiceModel;
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f20501i.getActivity());
            aVar.setMessageId(R.string.location_app_permission_prompt).setPositiveButton(R.string.isopen, new d(this)).setNegativeButton(R.string.cancel, new c(this)).create(this.f20501i.getPageContext());
            aVar.show();
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!UtilHelper.isSystemLocationProviderEnabled(this.f20501i.getActivity())) {
                this.f20501i.showToast(R.string.location_system_permission_prompt);
            } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
                s();
            } else if (this.f20499g.D()) {
                i();
            } else {
                this.f20499g.M(false);
                o(1, true, null);
                this.f20499g.H();
            }
        }
    }
}

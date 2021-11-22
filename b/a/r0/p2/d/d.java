package b.a.r0.p2.d;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import b.a.q0.s.s.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d implements b.a.r0.p2.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f23681a;

    /* renamed from: b  reason: collision with root package name */
    public String f23682b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f23683c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.q0.s.g0.a f23684d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.q0.s.g0.c f23685e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f23686f;

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23687e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23687e = dVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().removeMessage(this.f23687e.f23686f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23688e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23688e = dVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar.dismiss();
                    this.f23688e.f23683c.showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10038");
                aVar.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.f23688e.f23683c.getPageActivity(), 2, true, 5);
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                if (!StringUtils.isNULL("4010001002")) {
                    memberPayActivityConfig.setSceneId("4010001002");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* renamed from: b.a.r0.p2.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1150d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1150d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f23689e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f23690f;

        public e(d dVar, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23690f = dVar;
            this.f23689e = userMuteAddAndDelCustomMessage;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f23690f.g();
                MessageManager.getInstance().sendMessage(this.f23689e);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23681a = -1;
        this.f23682b = "";
        this.f23683c = tbPageContext;
        b.a.q0.s.g0.c cVar = new b.a.q0.s.g0.c();
        this.f23685e = cVar;
        cVar.f13738a = 1000L;
        this.f23686f = bdUniqueId;
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        BdUniqueId bdUniqueId2 = this.f23686f;
        userMuteAddAndDelCustomMessage.mId = bdUniqueId2;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(bdUniqueId2);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        BdUniqueId bdUniqueId3 = this.f23686f;
        userMuteCheckCustomMessage.mId = bdUniqueId3;
        userMuteCheckCustomMessage.setTag(bdUniqueId3);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    @Override // b.a.r0.p2.h.a
    public void a(int i2, int i3, String str, int i4, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), str2}) == null) {
            b.a.q0.s.g0.a aVar = this.f23684d;
            if (aVar != null) {
                aVar.h(false);
            }
            this.f23681a = i3;
            this.f23682b = str;
            if (i4 == 0) {
                if (i2 == 1) {
                    this.f23685e.c(this.f23683c.getString(R.string.mute_success));
                } else if (i2 == 2) {
                    this.f23685e.c(this.f23683c.getResources().getString(R.string.un_mute_success));
                }
            } else if (i4 == 220017) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.f23683c.getString(R.string.mute_error_beyond_limit);
                }
                i(str2);
            } else if (i4 == 1990043) {
                h();
            } else {
                if (b.a.e.f.p.k.isEmpty(str2)) {
                    if (i2 == 1) {
                        str2 = this.f23683c.getResources().getString(R.string.mute_fail);
                    } else if (i2 == 2) {
                        str2 = this.f23683c.getResources().getString(R.string.un_mute_fail);
                    }
                }
                this.f23685e.b(str2);
            }
        }
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23682b : (String) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23681a : invokeV.intValue;
    }

    public BdUniqueId f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23686f : (BdUniqueId) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f23684d == null) {
                b.a.q0.s.g0.a aVar = new b.a.q0.s.g0.a(this.f23683c);
                this.f23684d = aVar;
                aVar.e(new a(this));
            }
            this.f23684d.h(true);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f23683c.getPageActivity());
            aVar.setMessage(this.f23683c.getString(R.string.mute_is_super_member_function));
            aVar.setPositiveButton(R.string.open_now, new c(this));
            aVar.setNegativeButton(R.string.cancel, new C1150d(this));
            aVar.create(this.f23683c).show();
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (str == null) {
                str = "";
            }
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f23683c.getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new b(this));
            aVar.create(this.f23683c).show();
        }
    }

    public void j(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), userMuteAddAndDelCustomMessage, str, str2}) == null) {
            if (z) {
                g();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f23683c.getPageActivity());
            if (b.a.e.f.p.k.isEmpty(str)) {
                aVar.setMessage(this.f23683c.getResources().getString(R.string.block_mute_message_alert, str2));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(R.string.confirm, new e(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(R.string.cancel, new f(this));
            aVar.create(this.f23683c).show();
        }
    }
}

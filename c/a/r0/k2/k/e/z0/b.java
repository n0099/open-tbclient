package c.a.r0.k2.k.e.z0;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.d1.o;
import c.a.q0.s.s.a;
import c.a.r0.k3.x;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.adapter.PbAdCardGiftItemResponseMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f20560a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.k2.h.a f20561b;

    /* renamed from: c  reason: collision with root package name */
    public LikeModel f20562c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.k2.h.e f20563d;

    /* renamed from: e  reason: collision with root package name */
    public AlertDialog f20564e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.e.a.e f20565f;

    /* renamed from: g  reason: collision with root package name */
    public AntiHelper.k f20566g;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f20567a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20567a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof PbAdCardGiftItemResponseMessage)) {
                PbAdCardGiftItemResponseMessage pbAdCardGiftItemResponseMessage = (PbAdCardGiftItemResponseMessage) httpResponsedMessage;
                if (pbAdCardGiftItemResponseMessage.getError() == 0 && pbAdCardGiftItemResponseMessage.getData() != null) {
                    this.f20567a.x(pbAdCardGiftItemResponseMessage.getData());
                } else if (pbAdCardGiftItemResponseMessage.getError() == 502014 || pbAdCardGiftItemResponseMessage.getError() == 502015) {
                    this.f20567a.w(pbAdCardGiftItemResponseMessage.getError(), pbAdCardGiftItemResponseMessage.getErrorString());
                } else {
                    this.f20567a.f20560a.showToast(pbAdCardGiftItemResponseMessage.getErrorString());
                }
            }
        }
    }

    /* renamed from: c.a.r0.k2.k.e.z0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0973b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20568e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f20569f;

        public C0973b(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20569f = bVar;
            this.f20568e = i2;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || o.a()) {
                return;
            }
            if (this.f20568e == 502014) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f20569f.f20560a.getActivity()).createNormalCfg(this.f20569f.f20563d.m().getName(), FrsActivityConfig.FRS_PB_CARD_GIFT);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            } else if (!this.f20569f.f20560a.checkUpIsLogin()) {
                return;
            } else {
                if (this.f20569f.f20562c == null) {
                    b bVar = this.f20569f;
                    bVar.f20562c = new LikeModel(bVar.f20560a.getPageContext());
                    this.f20569f.f20562c.setLoadDataCallBack(this.f20569f.f20565f);
                }
                this.f20569f.f20562c.setFrom(FrsActivityConfig.FRS_PB_CARD_GIFT);
                this.f20569f.f20562c.L(this.f20569f.f20563d.m().getName(), String.valueOf(this.f20569f.f20563d.m().getId()));
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20570e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20570e = bVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f20570e.p();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f20571a;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20571a = bVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || this.f20571a.f20563d == null || this.f20571a.f20563d.m() == null || obj == null) {
                return;
            }
            if (AntiHelper.m(this.f20571a.f20562c.getErrorCode(), this.f20571a.f20562c.getErrorString())) {
                if (AntiHelper.t(this.f20571a.f20560a.getContext(), this.f20571a.f20562c.J(), this.f20571a.f20566g) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                    return;
                }
                return;
            }
            this.f20571a.f20563d.m().getName();
            String id = this.f20571a.f20563d.m().getId();
            x xVar = obj instanceof x ? (x) obj : null;
            boolean z = false;
            boolean z2 = xVar != null && this.f20571a.f20562c.getErrorCode() == 0;
            if (xVar == null || xVar.d() != 3250013) {
                z = z2;
            } else {
                BdToast.h(TbadkCoreApplication.getInst().getContext(), xVar.e(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
            }
            if (xVar == null || !z) {
                if (this.f20571a.f20562c.getErrorCode() != 22) {
                    this.f20571a.f20560a.showToast(this.f20571a.f20562c.getErrorString());
                    return;
                } else {
                    this.f20571a.f20560a.showToast(this.f20571a.f20560a.getPageContext().getPageActivity().getString(R.string.had_liked_forum));
                    return;
                }
            }
            xVar.v(1);
            this.f20571a.f20560a.showToast(this.f20571a.f20560a.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_attention_success));
            this.f20571a.t(true, id);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, xVar));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20572e;

        public g(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20572e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20572e.f20564e.dismiss();
                b bVar = this.f20572e;
                bVar.n(bVar.f20561b);
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f20572e.f20560a.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20573e;

        public h(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20573e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20573e.f20564e.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20574e;

        public i(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20574e = bVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f20574e.p();
            }
        }
    }

    public b(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20565f = new e(this);
        this.f20566g = new f(this);
        this.f20560a = pbFragment;
        r();
        s();
    }

    public final void n(c.a.r0.k2.h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        c.a.r0.j3.c.g().c(this.f20560a.getUniqueId(), c.a.r0.j3.a.e(this.f20563d.O(), "a005", "common_click", 1, aVar.f19790f, true, aVar.f19789e.f19791a + "", "", 19));
    }

    public final void o(c.a.r0.k2.h.a aVar) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        String s1 = this.f20563d.O().s1();
        c.a.r0.j3.c.g().d(this.f20560a.getUniqueId(), c.a.r0.j3.a.c(s1, str, "", null) + "_dialog", c.a.r0.j3.a.g(this.f20563d.O(), "a005", "common_exp", aVar.f19790f, true, aVar.f19789e.f19791a + "", "", 19));
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LikeModel likeModel = this.f20562c;
            if (likeModel != null) {
                likeModel.I();
            }
            AlertDialog alertDialog = this.f20564e;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f20560a.registerListener(new a(this, CmdConfigHttp.CMD_GET_CARD_GIFT_REQ));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ, TbConfig.SERVER_ADDRESS + TbConfig.PB_CARD_GIFT_GET_URL);
            tbHttpMessageTask.setResponsedClass(PbAdCardGiftItemResponseMessage.class);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void t(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048582, this, z, str) == null) {
            c.a.r0.l1.t.d.j().g(TbadkCoreApplication.getCurrentAccount(), str, z, null);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void u(c.a.r0.k2.h.a aVar) {
        c.a.r0.k2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || aVar == null || aVar.f19789e == null || (eVar = this.f20563d) == null || eVar.O() == null) {
            return;
        }
        this.f20561b = aVar;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
        httpMessage.addParam("tid", this.f20563d.O().s1());
        httpMessage.addParam(CardBoxMemberPayActivityConfig.PACKET_ID, aVar.f19789e.f19791a);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void v(c.a.r0.k2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.f20563d = eVar;
        }
    }

    public final void w(int i2, String str) {
        int i3;
        int i4;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, str) == null) {
            if (i2 == 502014) {
                i3 = R.string.pb_ad_card_gift_fail_guide_update_level;
                i4 = R.string.cancel;
                string = this.f20560a.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_update_level_message);
            } else {
                i3 = R.string.pb_ad_card_gift_fail_guide_attention_bar;
                i4 = R.string.pb_ad_card_gift_fail_guide_attention_bar_cancel;
                string = this.f20560a.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_attention_title, this.f20563d.m().getName());
                str = "";
            }
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f20560a.getPageContext().getPageActivity());
            aVar.setTitle(str);
            aVar.setMessage(string);
            aVar.setPositiveButton(i3, new C0973b(this, i2));
            aVar.setNegativeButton(i4, new c(this));
            aVar.setOnDismissListener(new d(this));
            aVar.setTitleShowCenter(true);
            aVar.setNegativeTextColor(R.color.CAM_X0105);
            aVar.setCanceledOnTouchOutside(true);
            aVar.create(this.f20560a.getPageContext()).show();
        }
    }

    public final void x(c.a.r0.k2.h.b bVar) {
        c.a.r0.k2.h.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            c.a.r0.k2.h.a aVar2 = this.f20561b;
            if (aVar2 != null) {
                aVar2.f19789e = bVar;
            }
            c.a.r0.k2.h.e eVar = this.f20563d;
            if (eVar != null && (aVar = eVar.l) != null) {
                aVar.f19789e = bVar;
            }
            o(this.f20561b);
            AlertDialog create = new AlertDialog.Builder(this.f20560a.getPageContext().getPageActivity()).create();
            this.f20564e = create;
            create.setCanceledOnTouchOutside(false);
            c.a.e.e.m.g.i(this.f20564e, this.f20560a.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f20560a.getPageContext().getPageActivity()).inflate(R.layout.pb_ad_card_gift_success_dialog, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.bg_ad_card_gift_success);
            tbImageView.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30));
            tbImageView.setConrers(3);
            tbImageView.setDrawCorner(true);
            tbImageView.startLoad(String.valueOf(R.drawable.pic_popupwindow_gife), 24, false);
            TextView textView = (TextView) inflate.findViewById(R.id.btn_ad_card_gift_success_view);
            textView.setOnClickListener(new g(this));
            ImageView imageView = (ImageView) inflate.findViewById(R.id.btn_ad_card_gift_success_close);
            imageView.setOnClickListener(new h(this));
            TextView textView2 = (TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_card_id);
            TextView textView3 = (TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_title);
            textView3.setText(this.f20560a.getPageContext().getPageActivity().getString(R.string.pb_ad_card_gift_success_dialog_card_title, new Object[]{bVar.f19793c}));
            textView2.setText(this.f20560a.getPageContext().getPageActivity().getString(R.string.pb_ad_card_gift_success_dialog_card_id, new Object[]{bVar.f19796f}));
            SkinManager.setImageResource(imageView, R.drawable.icon_use_close_n);
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
            SkinManager.setViewTextColor(textView3, R.color.CAM_X0105);
            SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_tip), R.color.CAM_X0107);
            SkinManager.setBackgroundResource(textView, R.drawable.btn_pb_ad_card_gift_get);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0112);
            this.f20564e.setOnDismissListener(new i(this));
            Window window = this.f20564e.getWindow();
            window.setWindowAnimations(R.style.normal_dialog_style);
            window.setGravity(17);
            window.setLayout(-2, -2);
            window.setContentView(inflate);
        }
    }
}

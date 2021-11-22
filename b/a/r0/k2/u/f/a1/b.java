package b.a.r0.k2.u.f.a1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.c1.o;
import b.a.q0.s.s.a;
import b.a.r0.k2.j;
import b.a.r0.k2.l;
import b.a.r0.k2.m;
import b.a.r0.m3.x;
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
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.adapter.PbAdCardGiftItemResponseMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f20532a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.k2.r.a f20533b;

    /* renamed from: c  reason: collision with root package name */
    public LikeModel f20534c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.k2.r.f f20535d;

    /* renamed from: e  reason: collision with root package name */
    public AlertDialog f20536e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.e.a.e f20537f;

    /* renamed from: g  reason: collision with root package name */
    public AntiHelper.k f20538g;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f20539a;

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
            this.f20539a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof PbAdCardGiftItemResponseMessage)) {
                PbAdCardGiftItemResponseMessage pbAdCardGiftItemResponseMessage = (PbAdCardGiftItemResponseMessage) httpResponsedMessage;
                if (pbAdCardGiftItemResponseMessage.getError() == 0 && pbAdCardGiftItemResponseMessage.getData() != null) {
                    this.f20539a.x(pbAdCardGiftItemResponseMessage.getData());
                } else if (pbAdCardGiftItemResponseMessage.getError() == 502014 || pbAdCardGiftItemResponseMessage.getError() == 502015) {
                    this.f20539a.w(pbAdCardGiftItemResponseMessage.getError(), pbAdCardGiftItemResponseMessage.getErrorString());
                } else {
                    this.f20539a.f20532a.showToast(pbAdCardGiftItemResponseMessage.getErrorString());
                }
            }
        }
    }

    /* renamed from: b.a.r0.k2.u.f.a1.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1026b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20540e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f20541f;

        public C1026b(b bVar, int i2) {
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
            this.f20541f = bVar;
            this.f20540e = i2;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || o.a()) {
                return;
            }
            if (this.f20540e == 502014) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f20541f.f20532a.getActivity()).createNormalCfg(this.f20541f.f20535d.l().getName(), FrsActivityConfig.FRS_PB_CARD_GIFT);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            } else if (!this.f20541f.f20532a.checkUpIsLogin()) {
                return;
            } else {
                if (this.f20541f.f20534c == null) {
                    b bVar = this.f20541f;
                    bVar.f20534c = new LikeModel(bVar.f20532a.getPageContext());
                    this.f20541f.f20534c.setLoadDataCallBack(this.f20541f.f20537f);
                }
                this.f20541f.f20534c.setFrom(FrsActivityConfig.FRS_PB_CARD_GIFT);
                this.f20541f.f20534c.L(this.f20541f.f20535d.l().getName(), String.valueOf(this.f20541f.f20535d.l().getId()));
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20542e;

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
            this.f20542e = bVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f20542e.p();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f20543a;

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
            this.f20543a = bVar;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || this.f20543a.f20535d == null || this.f20543a.f20535d.l() == null || obj == null) {
                return;
            }
            if (AntiHelper.m(this.f20543a.f20534c.getErrorCode(), this.f20543a.f20534c.getErrorString())) {
                if (AntiHelper.t(this.f20543a.f20532a.getContext(), this.f20543a.f20534c.J(), this.f20543a.f20538g) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                    return;
                }
                return;
            }
            this.f20543a.f20535d.l().getName();
            String id = this.f20543a.f20535d.l().getId();
            x xVar = obj instanceof x ? (x) obj : null;
            boolean z = false;
            boolean z2 = xVar != null && this.f20543a.f20534c.getErrorCode() == 0;
            if (xVar == null || xVar.d() != 3250013) {
                z = z2;
            } else {
                BdToast.h(TbadkCoreApplication.getInst().getContext(), xVar.e(), b.a.r0.k2.h.icon_pure_toast_mistake40_svg, 3000, true).q();
            }
            if (xVar == null || !z) {
                if (this.f20543a.f20534c.getErrorCode() != 22) {
                    this.f20543a.f20532a.showToast(this.f20543a.f20534c.getErrorString());
                    return;
                } else {
                    this.f20543a.f20532a.showToast(this.f20543a.f20532a.getPageContext().getPageActivity().getString(l.had_liked_forum));
                    return;
                }
            }
            xVar.v(1);
            this.f20543a.f20532a.showToast(this.f20543a.f20532a.getPageContext().getPageActivity().getResources().getString(l.pb_ad_card_gift_fail_guide_attention_success));
            this.f20543a.t(true, id);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, xVar));
        }
    }

    /* loaded from: classes5.dex */
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
        public void onNavigationButtonClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20544e;

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
            this.f20544e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20544e.f20536e.dismiss();
                b bVar = this.f20544e;
                bVar.n(bVar.f20533b);
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f20544e.f20532a.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20545e;

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
            this.f20545e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20545e.f20536e.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20546e;

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
            this.f20546e = bVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f20546e.p();
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
        this.f20537f = new e(this);
        this.f20538g = new f(this);
        this.f20532a = pbFragment;
        r();
        s();
    }

    public final void n(b.a.r0.k2.r.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        b.a.r0.l3.c.g().c(this.f20532a.getUniqueId(), b.a.r0.l3.a.e(this.f20535d.O(), "a005", "common_click", 1, aVar.f20280f, true, aVar.f20279e.f20281a + "", "", 19));
    }

    public final void o(b.a.r0.k2.r.a aVar) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        String t1 = this.f20535d.O().t1();
        b.a.r0.l3.c.g().d(this.f20532a.getUniqueId(), b.a.r0.l3.a.c(t1, str, "", null) + "_dialog", b.a.r0.l3.a.g(this.f20535d.O(), "a005", "common_exp", aVar.f20280f, true, aVar.f20279e.f20281a + "", "", 19));
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
            LikeModel likeModel = this.f20534c;
            if (likeModel != null) {
                likeModel.I();
            }
            AlertDialog alertDialog = this.f20536e;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f20532a.registerListener(new a(this, CmdConfigHttp.CMD_GET_CARD_GIFT_REQ));
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
            b.a.r0.l1.t.d.j().g(TbadkCoreApplication.getCurrentAccount(), str, z, null);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void u(b.a.r0.k2.r.a aVar) {
        b.a.r0.k2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || aVar == null || aVar.f20279e == null || (fVar = this.f20535d) == null || fVar.O() == null) {
            return;
        }
        this.f20533b = aVar;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
        httpMessage.addParam("tid", this.f20535d.O().t1());
        httpMessage.addParam(CardBoxMemberPayActivityConfig.PACKET_ID, aVar.f20279e.f20281a);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void v(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.f20535d = fVar;
        }
    }

    public final void w(int i2, String str) {
        int i3;
        int i4;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, str) == null) {
            if (i2 == 502014) {
                i3 = l.pb_ad_card_gift_fail_guide_update_level;
                i4 = l.cancel;
                string = this.f20532a.getPageContext().getPageActivity().getResources().getString(l.pb_ad_card_gift_fail_guide_update_level_message);
            } else {
                i3 = l.pb_ad_card_gift_fail_guide_attention_bar;
                i4 = l.pb_ad_card_gift_fail_guide_attention_bar_cancel;
                string = this.f20532a.getPageContext().getPageActivity().getResources().getString(l.pb_ad_card_gift_fail_guide_attention_title, this.f20535d.l().getName());
                str = "";
            }
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f20532a.getPageContext().getPageActivity());
            aVar.setTitle(str);
            aVar.setMessage(string);
            aVar.setPositiveButton(i3, new C1026b(this, i2));
            aVar.setNegativeButton(i4, new c(this));
            aVar.setOnDismissListener(new d(this));
            aVar.setTitleShowCenter(true);
            aVar.setNegativeTextColor(b.a.r0.k2.f.CAM_X0105);
            aVar.setCanceledOnTouchOutside(true);
            aVar.create(this.f20532a.getPageContext()).show();
        }
    }

    public final void x(b.a.r0.k2.r.b bVar) {
        b.a.r0.k2.r.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            b.a.r0.k2.r.a aVar2 = this.f20533b;
            if (aVar2 != null) {
                aVar2.f20279e = bVar;
            }
            b.a.r0.k2.r.f fVar = this.f20535d;
            if (fVar != null && (aVar = fVar.l) != null) {
                aVar.f20279e = bVar;
            }
            o(this.f20533b);
            AlertDialog create = new AlertDialog.Builder(this.f20532a.getPageContext().getPageActivity()).create();
            this.f20536e = create;
            create.setCanceledOnTouchOutside(false);
            b.a.e.f.m.g.i(this.f20536e, this.f20532a.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f20532a.getPageContext().getPageActivity()).inflate(j.pb_ad_card_gift_success_dialog, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(b.a.r0.k2.i.bg_ad_card_gift_success);
            tbImageView.setRadius(b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds30));
            tbImageView.setConrers(3);
            tbImageView.setDrawCorner(true);
            tbImageView.startLoad(String.valueOf(b.a.r0.k2.h.pic_popupwindow_gife), 24, false);
            TextView textView = (TextView) inflate.findViewById(b.a.r0.k2.i.btn_ad_card_gift_success_view);
            textView.setOnClickListener(new g(this));
            ImageView imageView = (ImageView) inflate.findViewById(b.a.r0.k2.i.btn_ad_card_gift_success_close);
            imageView.setOnClickListener(new h(this));
            TextView textView2 = (TextView) inflate.findViewById(b.a.r0.k2.i.txt_ad_card_gift_success_card_id);
            TextView textView3 = (TextView) inflate.findViewById(b.a.r0.k2.i.txt_ad_card_gift_success_title);
            textView3.setText(this.f20532a.getPageContext().getPageActivity().getString(l.pb_ad_card_gift_success_dialog_card_title, new Object[]{bVar.f20283c}));
            textView2.setText(this.f20532a.getPageContext().getPageActivity().getString(l.pb_ad_card_gift_success_dialog_card_id, new Object[]{bVar.f20286f}));
            SkinManager.setImageResource(imageView, b.a.r0.k2.h.icon_use_close_n);
            SkinManager.setViewTextColor(textView2, b.a.r0.k2.f.CAM_X0107);
            SkinManager.setViewTextColor(textView3, b.a.r0.k2.f.CAM_X0105);
            SkinManager.setViewTextColor((TextView) inflate.findViewById(b.a.r0.k2.i.txt_ad_card_gift_success_tip), b.a.r0.k2.f.CAM_X0107);
            SkinManager.setBackgroundResource(textView, b.a.r0.k2.h.btn_pb_ad_card_gift_get);
            SkinManager.setViewTextColor(textView, b.a.r0.k2.f.CAM_X0112);
            this.f20536e.setOnDismissListener(new i(this));
            Window window = this.f20536e.getWindow();
            window.setWindowAnimations(m.normal_dialog_style);
            window.setGravity(17);
            window.setLayout(-2, -2);
            window.setContentView(inflate);
        }
    }
}

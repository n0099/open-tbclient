package b.a.r0.k2.u.f.z0;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.d1.o;
import b.a.q0.s.s.a;
import b.a.r0.k2.j;
import b.a.r0.k2.l;
import b.a.r0.k2.m;
import b.a.r0.l3.x;
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
    public PbFragment f19546a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.k2.r.a f19547b;

    /* renamed from: c  reason: collision with root package name */
    public LikeModel f19548c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.k2.r.f f19549d;

    /* renamed from: e  reason: collision with root package name */
    public AlertDialog f19550e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.e.a.e f19551f;

    /* renamed from: g  reason: collision with root package name */
    public AntiHelper.k f19552g;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f19553a;

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
            this.f19553a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof PbAdCardGiftItemResponseMessage)) {
                PbAdCardGiftItemResponseMessage pbAdCardGiftItemResponseMessage = (PbAdCardGiftItemResponseMessage) httpResponsedMessage;
                if (pbAdCardGiftItemResponseMessage.getError() == 0 && pbAdCardGiftItemResponseMessage.getData() != null) {
                    this.f19553a.x(pbAdCardGiftItemResponseMessage.getData());
                } else if (pbAdCardGiftItemResponseMessage.getError() == 502014 || pbAdCardGiftItemResponseMessage.getError() == 502015) {
                    this.f19553a.w(pbAdCardGiftItemResponseMessage.getError(), pbAdCardGiftItemResponseMessage.getErrorString());
                } else {
                    this.f19553a.f19546a.showToast(pbAdCardGiftItemResponseMessage.getErrorString());
                }
            }
        }
    }

    /* renamed from: b.a.r0.k2.u.f.z0.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0972b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19554e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f19555f;

        public C0972b(b bVar, int i2) {
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
            this.f19555f = bVar;
            this.f19554e = i2;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || o.a()) {
                return;
            }
            if (this.f19554e == 502014) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f19555f.f19546a.getActivity()).createNormalCfg(this.f19555f.f19549d.l().getName(), FrsActivityConfig.FRS_PB_CARD_GIFT);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            } else if (!this.f19555f.f19546a.checkUpIsLogin()) {
                return;
            } else {
                if (this.f19555f.f19548c == null) {
                    b bVar = this.f19555f;
                    bVar.f19548c = new LikeModel(bVar.f19546a.getPageContext());
                    this.f19555f.f19548c.setLoadDataCallBack(this.f19555f.f19551f);
                }
                this.f19555f.f19548c.setFrom(FrsActivityConfig.FRS_PB_CARD_GIFT);
                this.f19555f.f19548c.L(this.f19555f.f19549d.l().getName(), String.valueOf(this.f19555f.f19549d.l().getId()));
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
        public final /* synthetic */ b f19556e;

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
            this.f19556e = bVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f19556e.p();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f19557a;

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
            this.f19557a = bVar;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || this.f19557a.f19549d == null || this.f19557a.f19549d.l() == null || obj == null) {
                return;
            }
            if (AntiHelper.m(this.f19557a.f19548c.getErrorCode(), this.f19557a.f19548c.getErrorString())) {
                if (AntiHelper.t(this.f19557a.f19546a.getContext(), this.f19557a.f19548c.J(), this.f19557a.f19552g) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                    return;
                }
                return;
            }
            this.f19557a.f19549d.l().getName();
            String id = this.f19557a.f19549d.l().getId();
            x xVar = obj instanceof x ? (x) obj : null;
            boolean z = false;
            boolean z2 = xVar != null && this.f19557a.f19548c.getErrorCode() == 0;
            if (xVar == null || xVar.d() != 3250013) {
                z = z2;
            } else {
                BdToast.h(TbadkCoreApplication.getInst().getContext(), xVar.e(), b.a.r0.k2.h.icon_pure_toast_mistake40_svg, 3000, true).q();
            }
            if (xVar == null || !z) {
                if (this.f19557a.f19548c.getErrorCode() != 22) {
                    this.f19557a.f19546a.showToast(this.f19557a.f19548c.getErrorString());
                    return;
                } else {
                    this.f19557a.f19546a.showToast(this.f19557a.f19546a.getPageContext().getPageActivity().getString(l.had_liked_forum));
                    return;
                }
            }
            xVar.v(1);
            this.f19557a.f19546a.showToast(this.f19557a.f19546a.getPageContext().getPageActivity().getResources().getString(l.pb_ad_card_gift_fail_guide_attention_success));
            this.f19557a.t(true, id);
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
        public final /* synthetic */ b f19558e;

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
            this.f19558e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19558e.f19550e.dismiss();
                b bVar = this.f19558e;
                bVar.n(bVar.f19547b);
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f19558e.f19546a.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19559e;

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
            this.f19559e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19559e.f19550e.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19560e;

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
            this.f19560e = bVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f19560e.p();
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
        this.f19551f = new e(this);
        this.f19552g = new f(this);
        this.f19546a = pbFragment;
        r();
        s();
    }

    public final void n(b.a.r0.k2.r.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        b.a.r0.k3.c.g().c(this.f19546a.getUniqueId(), b.a.r0.k3.a.e(this.f19549d.O(), "a005", "common_click", 1, aVar.f18744f, true, aVar.f18743e.f18745a + "", "", 19));
    }

    public final void o(b.a.r0.k2.r.a aVar) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        String s1 = this.f19549d.O().s1();
        b.a.r0.k3.c.g().d(this.f19546a.getUniqueId(), b.a.r0.k3.a.c(s1, str, "", null) + "_dialog", b.a.r0.k3.a.g(this.f19549d.O(), "a005", "common_exp", aVar.f18744f, true, aVar.f18743e.f18745a + "", "", 19));
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
            LikeModel likeModel = this.f19548c;
            if (likeModel != null) {
                likeModel.I();
            }
            AlertDialog alertDialog = this.f19550e;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f19546a.registerListener(new a(this, CmdConfigHttp.CMD_GET_CARD_GIFT_REQ));
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
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || aVar == null || aVar.f18743e == null || (fVar = this.f19549d) == null || fVar.O() == null) {
            return;
        }
        this.f19547b = aVar;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
        httpMessage.addParam("tid", this.f19549d.O().s1());
        httpMessage.addParam(CardBoxMemberPayActivityConfig.PACKET_ID, aVar.f18743e.f18745a);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void v(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.f19549d = fVar;
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
                string = this.f19546a.getPageContext().getPageActivity().getResources().getString(l.pb_ad_card_gift_fail_guide_update_level_message);
            } else {
                i3 = l.pb_ad_card_gift_fail_guide_attention_bar;
                i4 = l.pb_ad_card_gift_fail_guide_attention_bar_cancel;
                string = this.f19546a.getPageContext().getPageActivity().getResources().getString(l.pb_ad_card_gift_fail_guide_attention_title, this.f19549d.l().getName());
                str = "";
            }
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f19546a.getPageContext().getPageActivity());
            aVar.setTitle(str);
            aVar.setMessage(string);
            aVar.setPositiveButton(i3, new C0972b(this, i2));
            aVar.setNegativeButton(i4, new c(this));
            aVar.setOnDismissListener(new d(this));
            aVar.setTitleShowCenter(true);
            aVar.setNegativeTextColor(b.a.r0.k2.f.CAM_X0105);
            aVar.setCanceledOnTouchOutside(true);
            aVar.create(this.f19546a.getPageContext()).show();
        }
    }

    public final void x(b.a.r0.k2.r.b bVar) {
        b.a.r0.k2.r.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            b.a.r0.k2.r.a aVar2 = this.f19547b;
            if (aVar2 != null) {
                aVar2.f18743e = bVar;
            }
            b.a.r0.k2.r.f fVar = this.f19549d;
            if (fVar != null && (aVar = fVar.l) != null) {
                aVar.f18743e = bVar;
            }
            o(this.f19547b);
            AlertDialog create = new AlertDialog.Builder(this.f19546a.getPageContext().getPageActivity()).create();
            this.f19550e = create;
            create.setCanceledOnTouchOutside(false);
            b.a.e.e.m.g.i(this.f19550e, this.f19546a.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f19546a.getPageContext().getPageActivity()).inflate(j.pb_ad_card_gift_success_dialog, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(b.a.r0.k2.i.bg_ad_card_gift_success);
            tbImageView.setRadius(b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds30));
            tbImageView.setConrers(3);
            tbImageView.setDrawCorner(true);
            tbImageView.startLoad(String.valueOf(b.a.r0.k2.h.pic_popupwindow_gife), 24, false);
            TextView textView = (TextView) inflate.findViewById(b.a.r0.k2.i.btn_ad_card_gift_success_view);
            textView.setOnClickListener(new g(this));
            ImageView imageView = (ImageView) inflate.findViewById(b.a.r0.k2.i.btn_ad_card_gift_success_close);
            imageView.setOnClickListener(new h(this));
            TextView textView2 = (TextView) inflate.findViewById(b.a.r0.k2.i.txt_ad_card_gift_success_card_id);
            TextView textView3 = (TextView) inflate.findViewById(b.a.r0.k2.i.txt_ad_card_gift_success_title);
            textView3.setText(this.f19546a.getPageContext().getPageActivity().getString(l.pb_ad_card_gift_success_dialog_card_title, new Object[]{bVar.f18747c}));
            textView2.setText(this.f19546a.getPageContext().getPageActivity().getString(l.pb_ad_card_gift_success_dialog_card_id, new Object[]{bVar.f18750f}));
            SkinManager.setImageResource(imageView, b.a.r0.k2.h.icon_use_close_n);
            SkinManager.setViewTextColor(textView2, b.a.r0.k2.f.CAM_X0107);
            SkinManager.setViewTextColor(textView3, b.a.r0.k2.f.CAM_X0105);
            SkinManager.setViewTextColor((TextView) inflate.findViewById(b.a.r0.k2.i.txt_ad_card_gift_success_tip), b.a.r0.k2.f.CAM_X0107);
            SkinManager.setBackgroundResource(textView, b.a.r0.k2.h.btn_pb_ad_card_gift_get);
            SkinManager.setViewTextColor(textView, b.a.r0.k2.f.CAM_X0112);
            this.f19550e.setOnDismissListener(new i(this));
            Window window = this.f19550e.getWindow();
            window.setWindowAnimations(m.normal_dialog_style);
            window.setGravity(17);
            window.setLayout(-2, -2);
            window.setContentView(inflate);
        }
    }
}

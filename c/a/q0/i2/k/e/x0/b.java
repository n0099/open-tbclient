package c.a.q0.i2.k.e.x0;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.b1.l;
import c.a.p0.s.s.a;
import c.a.q0.i3.w;
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
    public PbFragment f19662a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.i2.h.a f19663b;

    /* renamed from: c  reason: collision with root package name */
    public LikeModel f19664c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.i2.h.e f19665d;

    /* renamed from: e  reason: collision with root package name */
    public AlertDialog f19666e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.e.a.e f19667f;

    /* renamed from: g  reason: collision with root package name */
    public AntiHelper.k f19668g;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f19669a;

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
            this.f19669a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof PbAdCardGiftItemResponseMessage)) {
                PbAdCardGiftItemResponseMessage pbAdCardGiftItemResponseMessage = (PbAdCardGiftItemResponseMessage) httpResponsedMessage;
                if (pbAdCardGiftItemResponseMessage.getError() == 0 && pbAdCardGiftItemResponseMessage.getData() != null) {
                    this.f19669a.x(pbAdCardGiftItemResponseMessage.getData());
                } else if (pbAdCardGiftItemResponseMessage.getError() == 502014 || pbAdCardGiftItemResponseMessage.getError() == 502015) {
                    this.f19669a.w(pbAdCardGiftItemResponseMessage.getError(), pbAdCardGiftItemResponseMessage.getErrorString());
                } else {
                    this.f19669a.f19662a.showToast(pbAdCardGiftItemResponseMessage.getErrorString());
                }
            }
        }
    }

    /* renamed from: c.a.q0.i2.k.e.x0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0928b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19670e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f19671f;

        public C0928b(b bVar, int i2) {
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
            this.f19671f = bVar;
            this.f19670e = i2;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || l.a()) {
                return;
            }
            if (this.f19670e == 502014) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f19671f.f19662a.getActivity()).createNormalCfg(this.f19671f.f19665d.m().getName(), FrsActivityConfig.FRS_PB_CARD_GIFT);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            } else if (!this.f19671f.f19662a.checkUpIsLogin()) {
                return;
            } else {
                if (this.f19671f.f19664c == null) {
                    b bVar = this.f19671f;
                    bVar.f19664c = new LikeModel(bVar.f19662a.getPageContext());
                    this.f19671f.f19664c.setLoadDataCallBack(this.f19671f.f19667f);
                }
                this.f19671f.f19664c.setFrom(FrsActivityConfig.FRS_PB_CARD_GIFT);
                this.f19671f.f19664c.L(this.f19671f.f19665d.m().getName(), String.valueOf(this.f19671f.f19665d.m().getId()));
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

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
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
        public final /* synthetic */ b f19672e;

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
            this.f19672e = bVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f19672e.p();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f19673a;

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
            this.f19673a = bVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || this.f19673a.f19665d == null || this.f19673a.f19665d.m() == null || obj == null) {
                return;
            }
            if (AntiHelper.m(this.f19673a.f19664c.getErrorCode(), this.f19673a.f19664c.getErrorString())) {
                if (AntiHelper.t(this.f19673a.f19662a.getContext(), this.f19673a.f19664c.J(), this.f19673a.f19668g) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                    return;
                }
                return;
            }
            this.f19673a.f19665d.m().getName();
            String id = this.f19673a.f19665d.m().getId();
            w wVar = obj instanceof w ? (w) obj : null;
            boolean z = false;
            boolean z2 = wVar != null && this.f19673a.f19664c.getErrorCode() == 0;
            if (wVar == null || wVar.d() != 3250013) {
                z = z2;
            } else {
                BdToast.h(TbadkCoreApplication.getInst().getContext(), wVar.e(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
            }
            if (wVar == null || !z) {
                if (this.f19673a.f19664c.getErrorCode() != 22) {
                    this.f19673a.f19662a.showToast(this.f19673a.f19664c.getErrorString());
                    return;
                } else {
                    this.f19673a.f19662a.showToast(this.f19673a.f19662a.getPageContext().getPageActivity().getString(R.string.had_liked_forum));
                    return;
                }
            }
            wVar.v(1);
            this.f19673a.f19662a.showToast(this.f19673a.f19662a.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_attention_success));
            this.f19673a.t(true, id);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
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
        public void onNavigationButtonClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.p0.s.s.a aVar) {
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
        public final /* synthetic */ b f19674e;

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
            this.f19674e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19674e.f19666e.dismiss();
                b bVar = this.f19674e;
                bVar.n(bVar.f19663b);
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f19674e.f19662a.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19675e;

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
            this.f19675e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19675e.f19666e.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19676e;

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
            this.f19676e = bVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f19676e.p();
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
        this.f19667f = new e(this);
        this.f19668g = new f(this);
        this.f19662a = pbFragment;
        r();
        s();
    }

    public final void n(c.a.q0.i2.h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        c.a.q0.h3.c.g().c(this.f19662a.getUniqueId(), c.a.q0.h3.a.e(this.f19665d.O(), "a005", "common_click", 1, aVar.f19049f, true, aVar.f19048e.f19050a + "", "", 19));
    }

    public final void o(c.a.q0.i2.h.a aVar) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        String q1 = this.f19665d.O().q1();
        c.a.q0.h3.c.g().d(this.f19662a.getUniqueId(), c.a.q0.h3.a.c(q1, str, "", null) + "_dialog", c.a.q0.h3.a.g(this.f19665d.O(), "a005", "common_exp", aVar.f19049f, true, aVar.f19048e.f19050a + "", "", 19));
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
            LikeModel likeModel = this.f19664c;
            if (likeModel != null) {
                likeModel.I();
            }
            AlertDialog alertDialog = this.f19666e;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f19662a.registerListener(new a(this, CmdConfigHttp.CMD_GET_CARD_GIFT_REQ));
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
            c.a.q0.j1.t.d.j().g(TbadkCoreApplication.getCurrentAccount(), str, z, null);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void u(c.a.q0.i2.h.a aVar) {
        c.a.q0.i2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || aVar == null || aVar.f19048e == null || (eVar = this.f19665d) == null || eVar.O() == null) {
            return;
        }
        this.f19663b = aVar;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
        httpMessage.addParam("tid", this.f19665d.O().q1());
        httpMessage.addParam(CardBoxMemberPayActivityConfig.PACKET_ID, aVar.f19048e.f19050a);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void v(c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.f19665d = eVar;
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
                string = this.f19662a.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_update_level_message);
            } else {
                i3 = R.string.pb_ad_card_gift_fail_guide_attention_bar;
                i4 = R.string.pb_ad_card_gift_fail_guide_attention_bar_cancel;
                string = this.f19662a.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_attention_title, this.f19665d.m().getName());
                str = "";
            }
            c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f19662a.getPageContext().getPageActivity());
            aVar.setTitle(str);
            aVar.setMessage(string);
            aVar.setPositiveButton(i3, new C0928b(this, i2));
            aVar.setNegativeButton(i4, new c(this));
            aVar.setOnDismissListener(new d(this));
            aVar.setTitleShowCenter(true);
            aVar.setNegativeTextColor(R.color.CAM_X0105);
            aVar.setCanceledOnTouchOutside(true);
            aVar.create(this.f19662a.getPageContext()).show();
        }
    }

    public final void x(c.a.q0.i2.h.b bVar) {
        c.a.q0.i2.h.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            c.a.q0.i2.h.a aVar2 = this.f19663b;
            if (aVar2 != null) {
                aVar2.f19048e = bVar;
            }
            c.a.q0.i2.h.e eVar = this.f19665d;
            if (eVar != null && (aVar = eVar.l) != null) {
                aVar.f19048e = bVar;
            }
            o(this.f19663b);
            AlertDialog create = new AlertDialog.Builder(this.f19662a.getPageContext().getPageActivity()).create();
            this.f19666e = create;
            create.setCanceledOnTouchOutside(false);
            c.a.e.e.m.g.i(this.f19666e, this.f19662a.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f19662a.getPageContext().getPageActivity()).inflate(R.layout.pb_ad_card_gift_success_dialog, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.bg_ad_card_gift_success);
            tbImageView.setRadius(c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30));
            tbImageView.setConrers(3);
            tbImageView.setDrawCorner(true);
            tbImageView.startLoad(String.valueOf(R.drawable.pic_popupwindow_gife), 24, false);
            TextView textView = (TextView) inflate.findViewById(R.id.btn_ad_card_gift_success_view);
            textView.setOnClickListener(new g(this));
            ImageView imageView = (ImageView) inflate.findViewById(R.id.btn_ad_card_gift_success_close);
            imageView.setOnClickListener(new h(this));
            TextView textView2 = (TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_card_id);
            TextView textView3 = (TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_title);
            textView3.setText(this.f19662a.getPageContext().getPageActivity().getString(R.string.pb_ad_card_gift_success_dialog_card_title, new Object[]{bVar.f19052c}));
            textView2.setText(this.f19662a.getPageContext().getPageActivity().getString(R.string.pb_ad_card_gift_success_dialog_card_id, new Object[]{bVar.f19055f}));
            SkinManager.setImageResource(imageView, R.drawable.icon_use_close_n);
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
            SkinManager.setViewTextColor(textView3, R.color.CAM_X0105);
            SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_tip), R.color.CAM_X0107);
            SkinManager.setBackgroundResource(textView, R.drawable.btn_pb_ad_card_gift_get);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0112);
            this.f19666e.setOnDismissListener(new i(this));
            Window window = this.f19666e.getWindow();
            window.setWindowAnimations(R.style.normal_dialog_style);
            window.setGravity(17);
            window.setLayout(-2, -2);
            window.setContentView(inflate);
        }
    }
}

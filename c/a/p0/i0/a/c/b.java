package c.a.p0.i0.a.c;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.HotThread.tinfo;
/* loaded from: classes2.dex */
public class b extends c.a.o0.k0.f.a<tinfo, c.a.o0.k0.d.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15476g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15477h;
    public TextView i;
    public TextView j;
    public TextView k;
    public LinearLayout l;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tinfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f15478b;

        public a(b bVar, tinfo tinfoVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, tinfoVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15478b = bVar;
            this.a = tinfoVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = this.a.forum_name;
                if (m.isForumName(str)) {
                    TiebaStatic.eventStat(this.f15478b.getActivity(), "kantie_6", null, 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f15478b.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15476g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090623);
        this.f15477h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090621);
        this.i = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09061e);
        this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090620);
        this.k = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090622);
        this.l = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f09061f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.k0.f.e
    /* renamed from: m */
    public void i(tinfo tinfoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tinfoVar) == null) {
            super.i(tinfoVar);
            if (StringUtils.isNull(tinfoVar.title)) {
                this.j.setVisibility(8);
            } else {
                this.j.setVisibility(0);
                this.j.setText(tinfoVar.title);
            }
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.l.setVisibility(8);
            } else {
                this.l.setVisibility(0);
                this.f15476g.setVisibility(0);
                this.f15476g.setText(UtilHelper.getFixedText(getContext().getString(R.string.obfuscated_res_0x7f0f03c0, tinfoVar.forum_name), 7, false));
                this.f15476g.setOnClickListener(new a(this, tinfoVar));
                if (tinfoVar.zan_num == null) {
                    this.f15477h.setVisibility(8);
                } else {
                    this.f15477h.setVisibility(0);
                    TextView textView = this.f15477h;
                    textView.setText(tinfoVar.zan_num + "");
                }
                if (tinfoVar.reply_num == null) {
                    this.i.setVisibility(8);
                } else {
                    this.i.setVisibility(0);
                    TextView textView2 = this.i;
                    textView2.setText(tinfoVar.reply_num + "");
                }
            }
            if (StringUtils.isNull(tinfoVar._abstract)) {
                this.k.setVisibility(8);
                return;
            }
            this.k.setVisibility(0);
            this.k.setText(tinfoVar._abstract);
        }
    }

    @Override // c.a.p0.a4.v
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i)) == null) {
            c.a.o0.r.c layoutMode = d().getLayoutMode();
            layoutMode.k(i == 1);
            layoutMode.j(e());
            return true;
        }
        return invokeLI.booleanValue;
    }
}

package c.a.p0.i0.a.c;

import android.view.View;
import android.widget.TextView;
import c.a.d.f.p.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes2.dex */
public class a extends c.a.o0.k0.f.a<tinfo, c.a.o0.k0.d.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f15473g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15474h;
    public TextView i;
    public TextView j;
    public TextView k;
    public View l;

    /* renamed from: c.a.p0.i0.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1158a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tinfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f15475b;

        public View$OnClickListenerC1158a(a aVar, tinfo tinfoVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tinfoVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15475b = aVar;
            this.a = tinfoVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = this.a.forum_name;
                if (m.isForumName(str)) {
                    TiebaStatic.eventStat(this.f15475b.getActivity(), "kantie_6", null, 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f15475b.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
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
        this.f15473g = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f09061b);
        this.f15474h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09061d);
        this.l = view.findViewById(R.id.obfuscated_res_0x7f090619);
        this.i = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09061a);
        this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09061c);
        this.k = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090617);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.k0.f.e
    /* renamed from: m */
    public void i(tinfo tinfoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tinfoVar) == null) {
            super.i(tinfoVar);
            if (tinfoVar == null) {
                return;
            }
            String str = null;
            List<Pic> list = tinfoVar.pics;
            if (list != null && list.size() > 0) {
                str = tinfoVar.pics.get(0).small_pic;
            }
            this.f15473g.J(str, 10, false);
            this.f15474h.setText(tinfoVar.title);
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.i.setVisibility(8);
            } else {
                this.i.setVisibility(0);
                this.i.setText(UtilHelper.getFixedText(getContext().getString(R.string.obfuscated_res_0x7f0f03c0, tinfoVar.forum_name), 7, false));
                this.i.setOnClickListener(new View$OnClickListenerC1158a(this, tinfoVar));
            }
            Integer num = tinfoVar.zan_num;
            if (num != null) {
                this.j.setText(String.valueOf(num));
            }
            Integer num2 = tinfoVar.reply_num;
            if (num2 != null) {
                this.k.setText(String.valueOf(num2));
            }
            this.l.setVisibility(0);
            c.a.p0.a4.q0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.d(String.valueOf(tinfoVar.forum_id))) {
                SkinManager.setViewTextColor(this.f15474h, R.color.CAM_X0109, 1);
            } else {
                SkinManager.setViewTextColor(this.f15474h, R.color.CAM_X0105, 1);
            }
        }
    }

    @Override // c.a.p0.a4.v
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i)) == null) {
            c.a.o0.w0.a.a(tbPageContext, e());
            return true;
        }
        return invokeLI.booleanValue;
    }
}

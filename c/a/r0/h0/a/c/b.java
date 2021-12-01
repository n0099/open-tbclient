package c.a.r0.h0.a.c;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.k;
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
/* loaded from: classes5.dex */
public class b extends c.a.q0.l0.f.a<tinfo, c.a.q0.l0.d.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: k  reason: collision with root package name */
    public TextView f17484k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public LinearLayout p;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ tinfo f17485e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f17486f;

        public a(b bVar, tinfo tinfoVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, tinfoVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17486f = bVar;
            this.f17485e = tinfoVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = this.f17485e.forum_name;
                if (k.isForumName(str)) {
                    TiebaStatic.eventStat(this.f17486f.getActivity(), "kantie_6", null, 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f17486f.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17484k = (TextView) view.findViewById(R.id.chosen_no_picture_title);
        this.l = (TextView) view.findViewById(R.id.chosen_no_picture_praise);
        this.m = (TextView) view.findViewById(R.id.chosen_no_picture_comment);
        this.n = (TextView) view.findViewById(R.id.chosen_no_picture_head);
        this.o = (TextView) view.findViewById(R.id.chosen_no_picture_sub);
        this.p = (LinearLayout) view.findViewById(R.id.chosen_no_picture_comment_line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.l0.f.e
    /* renamed from: l */
    public void h(tinfo tinfoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tinfoVar) == null) {
            super.h(tinfoVar);
            if (StringUtils.isNull(tinfoVar.title)) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
                this.n.setText(tinfoVar.title);
            }
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.p.setVisibility(8);
            } else {
                this.p.setVisibility(0);
                this.f17484k.setVisibility(0);
                this.f17484k.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.f17484k.setOnClickListener(new a(this, tinfoVar));
                if (tinfoVar.zan_num == null) {
                    this.l.setVisibility(8);
                } else {
                    this.l.setVisibility(0);
                    TextView textView = this.l;
                    textView.setText(tinfoVar.zan_num + "");
                }
                if (tinfoVar.reply_num == null) {
                    this.m.setVisibility(8);
                } else {
                    this.m.setVisibility(0);
                    TextView textView2 = this.m;
                    textView2.setText(tinfoVar.reply_num + "");
                }
            }
            if (StringUtils.isNull(tinfoVar._abstract)) {
                this.o.setVisibility(8);
                return;
            }
            this.o.setVisibility(0);
            this.o.setText(tinfoVar._abstract);
        }
    }

    @Override // c.a.r0.t3.u
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2)) == null) {
            c.a.q0.s.c layoutMode = c().getLayoutMode();
            layoutMode.k(i2 == 1);
            layoutMode.j(d());
            return true;
        }
        return invokeLI.booleanValue;
    }
}

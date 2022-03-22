package c.a.p0.i0.a.c;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.o0.r.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
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
public class c extends c.a.o0.k0.f.a<tinfo, c.a.o0.k0.d.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15479g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15480h;
    public TextView i;
    public TextView j;
    public RelativeLayout k;
    public TbImageView l;
    public TbImageView m;
    public TbImageView n;
    public View.OnClickListener o;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    c.a.o0.k0.c.b bVar = new c.a.o0.k0.c.b(4096, new d(((Integer) tag).intValue(), this.a.b()), null, null);
                    bVar.i(this.a.h());
                    this.a.c().dispatchMvcEvent(bVar);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tinfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f15481b;

        public b(c cVar, tinfo tinfoVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, tinfoVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15481b = cVar;
            this.a = tinfoVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = this.a.forum_name;
                if (m.isForumName(str)) {
                    TiebaStatic.eventStat(this.f15481b.getActivity(), "kantie_6", null, 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f15481b.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
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
        this.o = new a(this);
        this.f15479g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090643);
        this.f15480h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090642);
        this.i = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09063c);
        this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09063d);
        this.k = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f09063e);
        this.l = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f09063f);
        this.m = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090641);
        this.n = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090640);
        this.l.setOnClickListener(this.o);
        this.m.setOnClickListener(this.o);
        this.n.setOnClickListener(this.o);
    }

    public final void n(tinfo tinfoVar) {
        List<Pic> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tinfoVar) == null) || tinfoVar == null) {
            return;
        }
        if (l.c().g() && (list = tinfoVar.pics) != null && list.size() > 0) {
            this.k.setVisibility(0);
            int size = tinfoVar.pics.size();
            if (size != 1) {
                if (size != 2) {
                    if (size != 3) {
                        return;
                    }
                    String str = tinfoVar.pics.get(2).small_pic;
                    this.n.setVisibility(0);
                    this.n.J(str, 10, false);
                    this.n.setTag(2);
                }
                String str2 = tinfoVar.pics.get(1).small_pic;
                this.m.setVisibility(0);
                this.m.J(str2, 10, false);
                this.m.setTag(1);
            }
            String str3 = tinfoVar.pics.get(0).small_pic;
            this.l.setVisibility(0);
            this.l.J(str3, 10, false);
            this.l.setTag(0);
            return;
        }
        this.k.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.k0.f.e
    /* renamed from: o */
    public void i(tinfo tinfoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tinfoVar) == null) {
            super.i(tinfoVar);
            if (tinfoVar == null) {
                return;
            }
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.f15479g.setVisibility(8);
            } else {
                this.f15479g.setVisibility(0);
                this.f15479g.setText(UtilHelper.getFixedText(getContext().getString(R.string.obfuscated_res_0x7f0f03c0, tinfoVar.forum_name), 7, false));
                this.f15479g.setOnClickListener(new b(this, tinfoVar));
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.j.setVisibility(8);
            } else {
                this.j.setVisibility(0);
                this.j.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.f15480h.setVisibility(8);
            } else {
                this.f15480h.setVisibility(0);
                TextView textView = this.f15480h;
                textView.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.i.setVisibility(8);
            } else {
                this.i.setVisibility(0);
                TextView textView2 = this.i;
                textView2.setText(tinfoVar.reply_num + "");
            }
            n(tinfoVar);
        }
    }

    @Override // c.a.p0.a4.v
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
            c.a.o0.r.c layoutMode = d().getLayoutMode();
            layoutMode.k(i == 1);
            layoutMode.j(e());
            return true;
        }
        return invokeLI.booleanValue;
    }
}

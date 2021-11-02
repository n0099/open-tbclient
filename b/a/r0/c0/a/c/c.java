package b.a.r0.c0.a.c;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.e.p.k;
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
/* loaded from: classes4.dex */
public class c extends b.a.q0.k0.f.a<tinfo, b.a.q0.k0.d.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public RelativeLayout o;
    public TbImageView p;
    public TbImageView q;
    public TbImageView r;
    public View.OnClickListener s;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f15110e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15110e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    b.a.q0.k0.c.b bVar = new b.a.q0.k0.c.b(4096, new d(((Integer) tag).intValue(), this.f15110e.a()), null, null);
                    bVar.i(this.f15110e.g());
                    this.f15110e.b().dispatchMvcEvent(bVar);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ tinfo f15111e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f15112f;

        public b(c cVar, tinfo tinfoVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, tinfoVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15112f = cVar;
            this.f15111e = tinfoVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = this.f15111e.forum_name;
                if (k.isForumName(str)) {
                    TiebaStatic.eventStat(this.f15112f.getActivity(), "kantie_6", null, 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f15112f.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
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
        this.s = new a(this);
        this.k = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.l = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.m = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.n = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.o = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.p = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.q = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.r = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.p.setOnClickListener(this.s);
        this.q.setOnClickListener(this.s);
        this.r.setOnClickListener(this.s);
    }

    public final void m(tinfo tinfoVar) {
        List<Pic> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tinfoVar) == null) || tinfoVar == null) {
            return;
        }
        if (b.a.q0.s.k.c().g() && (list = tinfoVar.pics) != null && list.size() > 0) {
            this.o.setVisibility(0);
            int size = tinfoVar.pics.size();
            if (size != 1) {
                if (size != 2) {
                    if (size != 3) {
                        return;
                    }
                    String str = tinfoVar.pics.get(2).small_pic;
                    this.r.setVisibility(0);
                    this.r.startLoad(str, 10, false);
                    this.r.setTag(2);
                }
                String str2 = tinfoVar.pics.get(1).small_pic;
                this.q.setVisibility(0);
                this.q.startLoad(str2, 10, false);
                this.q.setTag(1);
            }
            String str3 = tinfoVar.pics.get(0).small_pic;
            this.p.setVisibility(0);
            this.p.startLoad(str3, 10, false);
            this.p.setTag(0);
            return;
        }
        this.o.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.q0.k0.f.e
    /* renamed from: n */
    public void h(tinfo tinfoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tinfoVar) == null) {
            super.h(tinfoVar);
            if (tinfoVar == null) {
                return;
            }
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.k.setVisibility(8);
            } else {
                this.k.setVisibility(0);
                this.k.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.k.setOnClickListener(new b(this, tinfoVar));
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
                this.n.setText(tinfoVar.title);
            }
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
            m(tinfoVar);
        }
    }

    @Override // b.a.r0.l3.u
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i2)) == null) {
            b.a.q0.s.c layoutMode = c().getLayoutMode();
            layoutMode.k(i2 == 1);
            layoutMode.j(d());
            return true;
        }
        return invokeLI.booleanValue;
    }
}

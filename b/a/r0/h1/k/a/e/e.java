package b.a.r0.h1.k.a.e;

import android.view.View;
import android.widget.TextView;
import b.a.e.f.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.CellTopicLinearLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class e extends b.a.r0.b0.b<b.a.r0.h1.k.a.c.d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public CellTopicLinearLayout n;
    public TextView o;
    public TbImageView p;
    public TextView q;
    public TextView r;
    public b.a.r0.h1.k.a.c.d s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = 3;
        View i4 = i();
        this.n = (CellTopicLinearLayout) i4.findViewById(R.id.topic_special_root);
        this.o = (TextView) i4.findViewById(R.id.topic_special_title);
        this.p = (TbImageView) i4.findViewById(R.id.topic_special_thread_img);
        this.q = (TextView) i4.findViewById(R.id.topic_special_thread_title);
        this.r = (TextView) i4.findViewById(R.id.topic_special_thread_discuss);
        this.p.setRadius(l.g(this.f16225g, R.dimen.tbds10));
        this.p.setConrers(15);
        this.p.setPlaceHolder(2);
        this.n.setTopicOnClickListener(this);
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_topic_special_view : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || i2 == this.m) {
            return;
        }
        this.m = i2;
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105);
        this.p.setSkinType(this.m);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: o */
    public void j(b.a.r0.h1.k.a.c.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || dVar == null || dVar.f19074i == null) {
            return;
        }
        this.s = dVar;
        if (dVar.f19070e) {
            if (StringUtils.isNull(dVar.f19073h)) {
                this.o.setText(R.string.topic_special_title_default);
            } else {
                this.o.setText(dVar.f19073h);
            }
        }
        this.o.setVisibility(dVar.f19070e ? 0 : 8);
        String str = null;
        if (!ListUtils.isEmpty(dVar.f19074i.E0())) {
            Iterator<MediaData> it = dVar.f19074i.E0().iterator();
            while (it.hasNext()) {
                MediaData next = it.next();
                if (next != null && next.getType() == 3) {
                    str = next.getPicUrl();
                    if (StringUtils.isNull(str)) {
                        str = next.getSmallUrl();
                    }
                    if (StringUtils.isNull(str)) {
                        str = next.getThumbnails_url();
                    }
                    if (StringUtils.isNull(str)) {
                        str = next.getSrc_pic();
                    }
                    if (!StringUtils.isNull(str)) {
                        break;
                    }
                }
            }
        }
        if (!StringHelper.equals(str, this.p.getUrl())) {
            this.p.reset();
        }
        this.p.startLoad(str, 10, false);
        if (StringUtils.isNull(dVar.f19074i.getTitle())) {
            this.q.setVisibility(8);
        } else {
            this.q.setVisibility(0);
            this.q.setText(dVar.f19074i.getTitle());
        }
        this.r.setText(String.format(this.f16225g.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.f19074i.U0())));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.a.r0.h1.k.a.c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || (dVar = this.s) == null || dVar.f19074i == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13354").param("tid", this.s.f19074i.E).param("topic_id", this.s.f19072g).param("obj_locate", this.s.f19071f));
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.f16224f.getPageActivity()).createFromThreadCfg(this.s.f19074i, null, "", 18005, true, false, false);
        if (this.s.f19074i.Y() == null) {
            createFromThreadCfg.setForumId(String.valueOf(this.s.f19074i.T()));
            createFromThreadCfg.setForumName(this.s.f19074i.Z());
        } else {
            createFromThreadCfg.setForumId(this.s.f19074i.Y().getForumId());
            createFromThreadCfg.setForumName(this.s.f19074i.Y().getForumName());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }
}

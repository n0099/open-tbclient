package c.a.r0.o1.l.b.e;

import android.view.View;
import android.widget.TextView;
import c.a.d.f.p.n;
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
/* loaded from: classes2.dex */
public class e extends c.a.r0.f0.b<c.a.r0.o1.l.b.c.d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public CellTopicLinearLayout n;
    public TextView o;
    public TbImageView p;
    public TextView q;
    public TextView r;
    public c.a.r0.o1.l.b.c.d s;

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
        View j2 = j();
        this.n = (CellTopicLinearLayout) j2.findViewById(R.id.topic_special_root);
        this.o = (TextView) j2.findViewById(R.id.topic_special_title);
        this.p = (TbImageView) j2.findViewById(R.id.topic_special_thread_img);
        this.q = (TextView) j2.findViewById(R.id.topic_special_thread_title);
        this.r = (TextView) j2.findViewById(R.id.topic_special_thread_discuss);
        this.p.setRadius(n.f(this.f17262g, R.dimen.tbds10));
        this.p.setConrers(15);
        this.p.setPlaceHolder(2);
        this.n.setTopicOnClickListener(this);
    }

    @Override // c.a.r0.f0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_topic_special_view : invokeV.intValue;
    }

    @Override // c.a.r0.f0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || i2 == this.m) {
            return;
        }
        this.m = i2;
        SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0105);
        this.p.setSkinType(this.m);
        SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.r0.o1.l.b.c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || (dVar = this.s) == null || dVar.f20236i == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13354").param("tid", this.s.f20236i.E).param("topic_id", this.s.f20234g).param("obj_locate", this.s.f20233f));
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.f17261f.getPageActivity()).createFromThreadCfg(this.s.f20236i, null, "", 18005, true, false, false);
        if (this.s.f20236i.Z() == null) {
            createFromThreadCfg.setForumId(String.valueOf(this.s.f20236i.U()));
            createFromThreadCfg.setForumName(this.s.f20236i.b0());
        } else {
            createFromThreadCfg.setForumId(this.s.f20236i.Z().getForumId());
            createFromThreadCfg.setForumName(this.s.f20236i.Z().getForumName());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.f0.b
    /* renamed from: p */
    public void k(c.a.r0.o1.l.b.c.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) || dVar == null || dVar.f20236i == null) {
            return;
        }
        this.s = dVar;
        if (dVar.f20232e) {
            if (StringUtils.isNull(dVar.f20235h)) {
                this.o.setText(R.string.topic_special_title_default);
            } else {
                this.o.setText(dVar.f20235h);
            }
        }
        this.o.setVisibility(dVar.f20232e ? 0 : 8);
        String str = null;
        if (!ListUtils.isEmpty(dVar.f20236i.G0())) {
            Iterator<MediaData> it = dVar.f20236i.G0().iterator();
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
        if (StringUtils.isNull(dVar.f20236i.getTitle())) {
            this.q.setVisibility(8);
        } else {
            this.q.setVisibility(0);
            this.q.setText(dVar.f20236i.getTitle());
        }
        this.r.setText(String.format(this.f17262g.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.f20236i.W0())));
    }
}

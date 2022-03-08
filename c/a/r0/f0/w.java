package c.a.r0.f0;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.r.r.e2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class w extends b<e2> implements c.a.r0.t.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View m;
    public TbPageContext<?> n;
    public HeadImageView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public e2 s;
    public v t;
    public ConstrainImageGroup u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View j2 = j();
        j2.setOnClickListener(this);
        this.n = tbPageContext;
        HeadImageView headImageView = (HeadImageView) j2.findViewById(R.id.topic_icon);
        this.o = headImageView;
        headImageView.setIsRound(true);
        this.o.setDefaultResource(R.drawable.pic_head_topic);
        this.p = (TextView) j2.findViewById(R.id.card_topic_name);
        this.r = (TextView) j2.findViewById(R.id.card_thread_title);
        this.q = (TextView) j2.findViewById(R.id.card_reply_time);
        this.u = (ConstrainImageGroup) j2.findViewById(R.id.card_img_layout);
        this.m = j2.findViewById(R.id.card_divider_line);
        this.u.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        c.a.q0.e1.j.f fVar = new c.a.q0.e1.j.f(3);
        fVar.d(1.0d);
        this.u.setImageProcessor(fVar);
        this.u.setSinglePicUseStyleV10(true);
        this.u.setFromCDN(true);
        this.u.setClickable(false);
    }

    @Override // c.a.r0.t.e
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // c.a.r0.f0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.frs_hot_topic_card_layout : invokeV.intValue;
    }

    @Override // c.a.r0.f0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            this.o.invalidate();
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundResource(j(), R.drawable.addresslist_item_bg);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
            this.u.onChangeSkinType();
            this.o.setDefaultBgResource(i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || this.s == null) {
            return;
        }
        if (g() != null) {
            g().b(view, this.s, this.t);
        }
        if (view == j()) {
            m.a(this.s.w1());
            m.l(this.r, this.s.w1(), R.color.CAM_X0105, R.color.CAM_X0109);
            p();
        }
    }

    public final void p() {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (e2Var = this.s) == null || e2Var.J() == null || this.s.J().getName_show() == null) {
            return;
        }
        long U = this.s.U();
        OriginalForumInfo originalForumInfo = this.s.J1;
        if (originalForumInfo != null) {
            U = c.a.d.f.m.b.g(originalForumInfo.id, 0L);
        }
        long j2 = U;
        String name_show = this.s.J().getName_show();
        HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(getContext());
        HotTopicActivityConfig createNormalConfig = hotTopicActivityConfig.createNormalConfig("", name_show + "", "3");
        createNormalConfig.setExtra(j2, this.s.V(), this.s.b1(), c.a.d.f.m.b.g(this.s.w1(), 0L));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.f0.b
    /* renamed from: q */
    public void k(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, e2Var) == null) {
            if (e2Var == null) {
                if (j() != null) {
                    j().setVisibility(8);
                    return;
                }
                return;
            }
            this.s = e2Var;
            if (j() != null) {
                j().setVisibility(0);
                j().setOnClickListener(this);
            }
            if (e2Var.J() != null) {
                this.p.setText(e2Var.J().getName_show());
            }
            this.q.setText(StringHelper.getFormatTime(e2Var.x0() * 1000));
            String str = e2Var.C1() + "：";
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.append((CharSequence) e2Var.a3(false, true));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), 0, str.length(), 33);
            this.r.setText(spannableStringBuilder);
            ArrayList<MediaData> G0 = e2Var.G0();
            if (c.a.q0.r.l.c().g() && ListUtils.getCount(G0) != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < G0.size(); i2++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(G0, i2);
                    if (mediaData != null && mediaData.getType() == 3) {
                        arrayList.add(mediaData);
                    }
                }
                if (ListUtils.getCount(arrayList) > 0) {
                    this.u.setVisibility(0);
                    this.u.setImageMediaList(arrayList);
                } else {
                    this.u.setVisibility(8);
                }
            } else {
                this.u.setVisibility(8);
            }
            m.l(this.r, this.s.w1(), R.color.CAM_X0105, R.color.CAM_X0109);
            l(this.n, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void s(c.a.d.f.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || (constrainImageGroup = this.u) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(bVar);
    }

    public void t(c.a.d.f.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || (constrainImageGroup = this.u) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(bVar);
    }
}

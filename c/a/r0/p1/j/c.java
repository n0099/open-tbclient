package c.a.r0.p1.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.holder.HotRankListNormaItemHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes6.dex */
public class c extends c.a.d.m.e.a<c.a.r0.p1.l.c, HotRankListNormaItemHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public TbPageContext n;
    public String o;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.p1.l.c f21044e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f21045f;

        public a(c cVar, c.a.r0.p1.l.c cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21045f = cVar;
            this.f21044e = cVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f21045f.n != null) {
                    String h2 = this.f21044e.h();
                    if (!StringUtils.isNull(h2)) {
                        UrlManager.getInstance().dealOneLink(this.f21045f.n, new String[]{h2});
                    }
                }
                TiebaStatic.log("c10820");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.p1.l.c f21046e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f21047f;

        public b(c cVar, c.a.r0.p1.l.c cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21047f = cVar;
            this.f21046e = cVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(view.getContext()).createNormalConfig(String.valueOf(this.f21046e.d()), this.f21046e.g(), "5")));
                TiebaStatic.log(new StatisticItem("c11237").param("obj_id", String.valueOf(this.f21046e.d())).param("obj_locate", this.f21047f.o));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(HotRanklistActivity hotRanklistActivity, BdUniqueId bdUniqueId) {
        super(hotRanklistActivity.getPageContext().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hotRanklistActivity, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = hotRanklistActivity.getPageContext();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, c.a.r0.p1.l.c cVar, HotRankListNormaItemHolder hotRankListNormaItemHolder) {
        l0(i2, view, viewGroup, cVar, hotRankListNormaItemHolder);
        return view;
    }

    public final void i0(int i2, HotRankListNormaItemHolder hotRankListNormaItemHolder, c.a.r0.p1.l.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, hotRankListNormaItemHolder, cVar) == null) || hotRankListNormaItemHolder == null || cVar == null) {
            return;
        }
        hotRankListNormaItemHolder.tipInfoItem.setVisibility(8);
        if (cVar.l() == 1) {
            hotRankListNormaItemHolder.topicRanking.setText("");
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.topicRanking, c.a.r0.p1.d.icon_grade_shaitu1);
            hotRankListNormaItemHolder.tipInfoItem.setVisibility(0);
            hotRankListNormaItemHolder.tipTitle.setText(m0(StringUtils.isNull(cVar.e()) ? this.f2907e.getResources().getString(c.a.r0.p1.h.hot_topic_hot_list) : cVar.e(), StringUtils.isNull(cVar.k()) ? this.f2907e.getResources().getString(c.a.r0.p1.h.hot_topic_update_time) : cVar.k()));
            hotRankListNormaItemHolder.dividerLineTop.setVisibility(0);
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.tipRuleContainer, c.a.r0.p1.d.hot_topic_ranklist_bg);
            hotRankListNormaItemHolder.tipRuleContainer.setOnClickListener(new a(this, cVar));
        } else if (cVar.l() == 2) {
            hotRankListNormaItemHolder.topicRanking.setText("");
            hotRankListNormaItemHolder.dividerLineTop.setVisibility(8);
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.topicRanking, c.a.r0.p1.d.icon_grade_shaitu2);
        } else if (cVar.l() == 3) {
            hotRankListNormaItemHolder.topicRanking.setText("");
            hotRankListNormaItemHolder.dividerLineTop.setVisibility(8);
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.topicRanking, c.a.r0.p1.d.icon_grade_shaitu3);
        } else {
            String str = "" + cVar.l();
            if (cVar.l() < 10) {
                str = "0" + str;
            }
            hotRankListNormaItemHolder.topicRanking.setText(str);
            hotRankListNormaItemHolder.dividerLineTop.setVisibility(8);
            hotRankListNormaItemHolder.topicRanking.setBackgroundDrawable(null);
        }
        if (cVar.i() == 1) {
            hotRankListNormaItemHolder.topicTagPic.setVisibility(0);
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.topicTagPic, c.a.r0.p1.d.icon_topic_ranklist_new);
        } else if (cVar.i() == 2) {
            hotRankListNormaItemHolder.topicTagPic.setVisibility(0);
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.topicTagPic, c.a.r0.p1.d.icon_topic_ranklist_hot);
        } else if (cVar.i() == 3) {
            hotRankListNormaItemHolder.topicTagPic.setVisibility(0);
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.topicTagPic, c.a.r0.p1.d.icon_topic_ranklist_tuijian);
        } else {
            hotRankListNormaItemHolder.topicTagPic.setVisibility(8);
        }
        String numFormat9999W = StringHelper.numFormat9999W(cVar.a());
        hotRankListNormaItemHolder.topicNeme.setText(TextUtils.isEmpty(cVar.g()) ? "" : UtilHelper.getFixedText(cVar.g(), 10));
        hotRankListNormaItemHolder.topicDiscussNum.setText(numFormat9999W);
        hotRankListNormaItemHolder.topicNormalItem.setOnClickListener(new b(this, cVar));
    }

    public final void j0(HotRankListNormaItemHolder hotRankListNormaItemHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, hotRankListNormaItemHolder) == null) || hotRankListNormaItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (hotRankListNormaItemHolder.skinType != skinType) {
            hotRankListNormaItemHolder.skinType = skinType;
            SkinManager.setBackgroundColor(hotRankListNormaItemHolder.getView(), c.a.r0.p1.b.CAM_X0201);
            SkinManager.setViewTextColor(hotRankListNormaItemHolder.topicRanking, c.a.r0.p1.b.CAM_X0110, 1);
            SkinManager.setViewTextColor(hotRankListNormaItemHolder.topicNeme, c.a.r0.p1.b.CAM_X0105, 1);
            SkinManager.setViewTextColor(hotRankListNormaItemHolder.topicDiscussNum, c.a.r0.p1.b.CAM_X0110, 1);
            SkinManager.setBackgroundColor(hotRankListNormaItemHolder.dividerLineTop, c.a.r0.p1.b.CAM_X0204);
            SkinManager.setBackgroundColor(hotRankListNormaItemHolder.dividerLineBottom, c.a.r0.p1.b.CAM_X0204);
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.topicNormalItem, c.a.r0.p1.d.hot_topic_ranklist_bg);
            SkinManager.setViewTextColor(hotRankListNormaItemHolder.tipRule, c.a.r0.p1.b.CAM_X0302, 1);
            SkinManager.setViewTextColor(hotRankListNormaItemHolder.tipTitle, c.a.r0.p1.b.CAM_X0109, 1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: k0 */
    public HotRankListNormaItemHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new HotRankListNormaItemHolder(LayoutInflater.from(this.f2907e).inflate(c.a.r0.p1.f.hot_topic_ranklist_normal_item, viewGroup, false)) : (HotRankListNormaItemHolder) invokeL.objValue;
    }

    public View l0(int i2, View view, ViewGroup viewGroup, c.a.r0.p1.l.c cVar, HotRankListNormaItemHolder hotRankListNormaItemHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, cVar, hotRankListNormaItemHolder})) == null) {
            if (cVar != null) {
                j0(hotRankListNormaItemHolder);
                i0(i2, hotRankListNormaItemHolder, cVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final SpannableString m0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            int length = !StringUtils.isNull(str) ? str.length() : 0;
            int length2 = !StringUtils.isNull(str2) ? str2.length() : 0;
            SpannableString spannableString = new SpannableString("" + str + str2);
            if (length > 0 && length2 > 0) {
                spannableString.setSpan(new TextAppearanceSpan(this.n.getPageActivity(), c.a.r0.p1.i.hot_ranklist_module_name_stysle), 0, length, 33);
                spannableString.setSpan(new TextAppearanceSpan(this.n.getPageActivity(), c.a.r0.p1.i.hot_ranklist_module_tip_stysle), length, spannableString.length(), 33);
            }
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }

    public void n0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.o = str;
        }
    }
}

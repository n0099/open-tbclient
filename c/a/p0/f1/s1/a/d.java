package c.a.p0.f1.s1.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import com.baidu.tieba.frs.forumRule.adapter.ForumRuleDetailSelfVH;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes2.dex */
public class d extends c.a.d.o.e.a<c.a.p0.f1.s1.c.b, ForumRuleDetailSelfVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumRulesShowActivity i;
    public String j;
    public boolean k;
    public int l;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.f1.s1.c.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f14514b;

        public a(d dVar, c.a.p0.f1.s1.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14514b = dVar;
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f14514b.k) {
                    this.f14514b.g0();
                } else {
                    this.f14514b.h0(this.a);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ForumRulesShowActivity forumRulesShowActivity, BdUniqueId bdUniqueId) {
        super(forumRulesShowActivity, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumRulesShowActivity, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
        this.l = 0;
        this.i = forumRulesShowActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i, View view, ViewGroup viewGroup, c.a.p0.f1.s1.c.b bVar, ForumRuleDetailSelfVH forumRuleDetailSelfVH) {
        f0(i, view, viewGroup, bVar, forumRuleDetailSelfVH);
        return view;
    }

    public final void c0(ForumRuleDetailSelfVH forumRuleDetailSelfVH, c.a.p0.f1.s1.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, forumRuleDetailSelfVH, bVar) == null) {
            if (bVar.e() != null) {
                forumRuleDetailSelfVH.f32503b.setDefaultResource(R.drawable.obfuscated_res_0x7f080b75);
                forumRuleDetailSelfVH.f32503b.J(bVar.e().portrait, 12, false);
                forumRuleDetailSelfVH.f32504c.setText(bVar.e().name_show);
                forumRuleDetailSelfVH.d(bVar.e().user_level.intValue());
                forumRuleDetailSelfVH.f32506e.setVisibility(0);
            }
            forumRuleDetailSelfVH.f32505d.setText(R.string.obfuscated_res_0x7f0f02ea);
            forumRuleDetailSelfVH.f32505d.setVisibility(0);
            forumRuleDetailSelfVH.i("manager");
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.j)) {
                forumRuleDetailSelfVH.h(String.valueOf(System.currentTimeMillis() / 1000));
            } else {
                forumRuleDetailSelfVH.f32508g.setText(bVar.k());
            }
            d0(forumRuleDetailSelfVH, bVar);
            forumRuleDetailSelfVH.e(bVar.j());
        }
    }

    public final void d0(ForumRuleDetailSelfVH forumRuleDetailSelfVH, c.a.p0.f1.s1.c.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, forumRuleDetailSelfVH, bVar) == null) && bVar.i()) {
            forumRuleDetailSelfVH.f32509h.setOnClickListener(new a(this, bVar));
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.j)) {
                forumRuleDetailSelfVH.f32509h.setVisibility(8);
            } else if (!StringUtils.isNull(bVar.k()) && bVar.b() == 0) {
                long a2 = c.a.p0.f1.s1.e.a.a(bVar.k());
                int b2 = c.a.p0.f1.s1.e.a.b(Long.valueOf(StringUtils.isNull(bVar.f()) ? "0" : bVar.f()).longValue() - a2);
                if (b2 < 0) {
                    b2 = c.a.p0.f1.s1.e.a.b((System.currentTimeMillis() / 1000) - a2);
                }
                forumRuleDetailSelfVH.f32509h.setVisibility(0);
                if (b2 >= 7) {
                    this.k = false;
                    return;
                }
                forumRuleDetailSelfVH.f32509h.setUseDisableState(true);
                this.k = true;
                this.l = 7 - b2;
            } else {
                forumRuleDetailSelfVH.g(bVar.b());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: e0 */
    public ForumRuleDetailSelfVH M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            ForumRuleDetailSelfVH forumRuleDetailSelfVH = new ForumRuleDetailSelfVH(LayoutInflater.from(this.i).inflate(R.layout.obfuscated_res_0x7f0d02c9, viewGroup, false));
            this.f2573g = forumRuleDetailSelfVH;
            return forumRuleDetailSelfVH;
        }
        return (ForumRuleDetailSelfVH) invokeL.objValue;
    }

    public View f0(int i, View view, ViewGroup viewGroup, c.a.p0.f1.s1.c.b bVar, ForumRuleDetailSelfVH forumRuleDetailSelfVH) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view, viewGroup, bVar, forumRuleDetailSelfVH})) == null) {
            if (bVar == null) {
                return view;
            }
            c0(forumRuleDetailSelfVH, bVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void g0() {
        ForumRulesShowActivity forumRulesShowActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (forumRulesShowActivity = this.i) == null) {
            return;
        }
        String string = forumRulesShowActivity.getString(R.string.obfuscated_res_0x7f0f0697);
        String format = String.format(string, this.l + "");
        if (this.i.getView() != null) {
            BdTopToast bdTopToast = new BdTopToast(this.i);
            bdTopToast.i(false);
            bdTopToast.h(format);
            bdTopToast.j(this.i.getView().l());
        }
    }

    public final void h0(c.a.p0.f1.s1.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || this.i == null || bVar == null) {
            return;
        }
        ForumRuleBaseData forumRuleBaseData = new ForumRuleBaseData();
        forumRuleBaseData.setTitle(bVar.n());
        forumRuleBaseData.setPreface(bVar.j());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < bVar.m().size(); i++) {
            ForumRule forumRule = bVar.m().get(i);
            ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData = new ForumRuleBaseData.ForumRuleItemPbData();
            forumRuleItemPbData.status = forumRule.status + "";
            forumRuleItemPbData.title = forumRule.title + "";
            forumRuleItemPbData.mContent = new ArrayList();
            List<PbContent> list = forumRule.content;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < forumRule.content.size(); i2++) {
                    PbContent pbContent = forumRule.content.get(i2);
                    ForumRuleBaseData.ForumRuleItemPbContentData forumRuleItemPbContentData = new ForumRuleBaseData.ForumRuleItemPbContentData();
                    forumRuleItemPbContentData.href = pbContent.link;
                    if (pbContent.type.intValue() == 0) {
                        forumRuleItemPbContentData.tag = "plainText";
                    } else if (pbContent.type.intValue() == 1) {
                        forumRuleItemPbContentData.tag = "a";
                    } else if (pbContent.type.intValue() == 2) {
                        forumRuleItemPbContentData.tag = TtmlNode.TAG_BR;
                    }
                    forumRuleItemPbContentData.value = pbContent.text;
                    forumRuleItemPbData.mContent.add(forumRuleItemPbContentData);
                }
            }
            arrayList.add(forumRuleItemPbData);
        }
        forumRuleBaseData.setPbDataList(arrayList);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRuleEditActivityConfig(this.i, bVar.g().forum_id + "", bVar.g().forum_name + "", ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, forumRuleBaseData, bVar.g().avatar, bVar.e().user_level.intValue(), 25053)));
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.j = str;
        }
    }
}

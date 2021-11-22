package b.a.r0.j1.o;

import android.text.TextUtils;
import android.view.View;
import b.a.r0.j1.l.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RelateTopicForumActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.view.RelateForumHorizonalListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends b.a.r0.b0.c<n> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelateForumHorizonalListView x;
    public List<b.a.e.m.e.n> y;
    public TbPageContext<?> z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext) {
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
        this.z = tbPageContext;
        this.x = new RelateForumHorizonalListView(getContext());
        this.y = new ArrayList();
        this.x.setTag(g());
        this.x.setLoadMoreClickListener(this);
        this.u.addView(this.x);
        this.m.setOnClickListener(this);
        t(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(b.a.r0.j1.c.ds1));
        s(false);
    }

    @Override // b.a.r0.b0.c, b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            super.k(tbPageContext, i2);
            RelateForumHorizonalListView relateForumHorizonalListView = this.x;
            if (relateForumHorizonalListView != null) {
                relateForumHorizonalListView.onSkinTypeChanged(i2);
            }
        }
    }

    @Override // b.a.r0.b0.b
    public void m(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            super.m(bdUniqueId);
            RelateForumHorizonalListView relateForumHorizonalListView = this.x;
            if (relateForumHorizonalListView != null) {
                relateForumHorizonalListView.setTag(g());
            }
        }
    }

    @Override // b.a.r0.b0.c, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            super.onClick(view);
            RelateForumHorizonalListView relateForumHorizonalListView = this.x;
            if (relateForumHorizonalListView == null || relateForumHorizonalListView.getLastItemView() != view || this.y == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            this.z.sendMessage(new CustomMessage(2002001, new RelateTopicForumActivityConfig(this.z.getPageActivity(), this.y, ((HotTopicActivity) this.z.getOrignalPage()).getHotTopicId())));
        }
    }

    @Override // b.a.r0.b0.b
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            super.setFrom(str);
            this.x.setFrom(str);
        }
    }

    public final List<b.a.q0.e1.g.a> u(List<b.a.e.m.e.n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (b.a.e.m.e.n nVar : list) {
                if (nVar instanceof RelateForumItemData) {
                    RelateForumItemData relateForumItemData = (RelateForumItemData) nVar;
                    long j = relateForumItemData.forumId;
                    String str = relateForumItemData.forumName;
                    String str2 = relateForumItemData.forumAvatar;
                    boolean z = relateForumItemData.isLiked;
                    if (j >= 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        b.a.q0.e1.g.a aVar = new b.a.q0.e1.g.a();
                        aVar.f13033b = str2;
                        aVar.f13035d = j;
                        aVar.f13034c = str;
                        aVar.f13036e = z;
                        arrayList.add(aVar);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.c
    /* renamed from: v */
    public void q(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, nVar) == null) {
            super.j(nVar);
            if (nVar == null) {
                i().setVisibility(8);
                return;
            }
            this.y.clear();
            List<b.a.e.m.e.n> list = nVar.f19812e;
            if (list != null) {
                this.y.addAll(list);
            }
            List<b.a.q0.e1.g.a> u = u(this.y);
            int count = ListUtils.getCount(u);
            if (count <= 0) {
                i().setVisibility(8);
                return;
            }
            i().setVisibility(0);
            if (count > 10) {
                this.x.setData(u.subList(0, 10), h(), true);
            } else {
                this.x.setData(u, h(), false);
            }
            k(h(), TbadkCoreApplication.getInst().getSkinType());
        }
    }
}

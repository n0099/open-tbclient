package c.a.p0.h1.f;

import android.text.TextUtils;
import android.view.View;
import c.a.p0.h1.c.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RelateTopicForumActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
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
/* loaded from: classes3.dex */
public class a extends c.a.p0.a0.c<n> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelateForumHorizonalListView x;
    public List<c.a.e.k.e.n> y;
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
        this.x = new RelateForumHorizonalListView(d());
        this.y = new ArrayList();
        this.x.setTag(h());
        this.x.setLoadMoreClickListener(this);
        this.u.addView(this.x);
        this.m.setOnClickListener(this);
        u(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
        t(false);
    }

    @Override // c.a.p0.a0.c, c.a.p0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            super.l(tbPageContext, i2);
            RelateForumHorizonalListView relateForumHorizonalListView = this.x;
            if (relateForumHorizonalListView != null) {
                relateForumHorizonalListView.onSkinTypeChanged(i2);
            }
        }
    }

    @Override // c.a.p0.a0.b
    public void n(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            super.n(bdUniqueId);
            RelateForumHorizonalListView relateForumHorizonalListView = this.x;
            if (relateForumHorizonalListView != null) {
                relateForumHorizonalListView.setTag(h());
            }
        }
    }

    @Override // c.a.p0.a0.c, android.view.View.OnClickListener
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

    @Override // c.a.p0.a0.b
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            super.setFrom(str);
            this.x.setFrom(str);
        }
    }

    public final List<c.a.o0.d1.g.a> v(List<c.a.e.k.e.n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (c.a.e.k.e.n nVar : list) {
                if (nVar instanceof RelateForumItemData) {
                    RelateForumItemData relateForumItemData = (RelateForumItemData) nVar;
                    long j2 = relateForumItemData.forumId;
                    String str = relateForumItemData.forumName;
                    String str2 = relateForumItemData.forumAvatar;
                    boolean z = relateForumItemData.isLiked;
                    if (j2 >= 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        c.a.o0.d1.g.a aVar = new c.a.o0.d1.g.a();
                        aVar.f12837b = str2;
                        aVar.f12839d = j2;
                        aVar.f12838c = str;
                        aVar.f12840e = z;
                        arrayList.add(aVar);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a0.b
    /* renamed from: w */
    public void k(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, nVar) == null) {
            super.s(nVar);
            if (nVar == null) {
                j().setVisibility(8);
                return;
            }
            this.y.clear();
            List<c.a.e.k.e.n> list = nVar.f18324e;
            if (list != null) {
                this.y.addAll(list);
            }
            List<c.a.o0.d1.g.a> v = v(this.y);
            int count = ListUtils.getCount(v);
            if (count <= 0) {
                j().setVisibility(8);
                return;
            }
            j().setVisibility(0);
            if (count > 10) {
                this.x.setData(v.subList(0, 10), i(), true);
            } else {
                this.x.setData(v, i(), false);
            }
            l(i(), TbadkCoreApplication.getInst().getSkinType());
        }
    }
}

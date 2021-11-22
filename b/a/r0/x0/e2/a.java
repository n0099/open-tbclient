package b.a.r0.x0.e2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.r0.x0.k;
import b.a.r0.x0.v2.d;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamepaltform.GameRankHorizontalLayout;
import com.baidu.tieba.frs.gamepaltform.GameRankListViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a extends k<b.a.r0.a1.b, GameRankListViewHolder> implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.r0.x0.v2.b x;

    /* renamed from: b.a.r0.x0.e2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1338a implements GameRankHorizontalLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27281a;

        public C1338a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27281a = aVar;
        }

        @Override // com.baidu.tieba.frs.gamepaltform.GameRankHorizontalLayout.b
        public void a(b.a.r0.a1.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) || aVar == null) {
                return;
            }
            if (this.f27281a.x != null) {
                TiebaStatic.log(new StatisticItem("c12105").param("fid", this.f27281a.x.f27993c).param("obj_locate", i2 + 1));
            }
            if (StringUtils.isNull(aVar.c())) {
                return;
            }
            b.a.q0.m.a.m(this.f27281a.o.getPageActivity(), aVar.c());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.q0.s.e0.b j = b.a.q0.s.e0.b.j();
                j.x("game_rank_list_info", System.currentTimeMillis() + ",7");
                b.a.q0.s.e0.b.j().v("game_rank_list_show_times", 0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921005));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = new b.a.r0.x0.v2.b();
    }

    @Override // b.a.r0.x0.v2.d
    public b.a.r0.x0.v2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.x : (b.a.r0.x0.v2.b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: v0 */
    public GameRankListViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new GameRankListViewHolder(LayoutInflater.from(this.f2421e).inflate(R.layout.game_rank_list_item, (ViewGroup) null)) : (GameRankListViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.x0.k, b.a.e.m.e.a
    /* renamed from: w0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.a1.b bVar, GameRankListViewHolder gameRankListViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, gameRankListViewHolder})) == null) {
            super.Z(i2, view, viewGroup, bVar, gameRankListViewHolder);
            if (bVar == null) {
                return null;
            }
            SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
            if (this.x != null) {
                TiebaStatic.log(new StatisticItem("c12104").param("fid", this.x.f27993c));
            }
            GameRankHorizontalLayout gameRankHorizontalLayout = gameRankListViewHolder.mGameRankHorizontalLayout;
            if (gameRankHorizontalLayout != null) {
                gameRankHorizontalLayout.setData(bVar);
                gameRankListViewHolder.mGameRankHorizontalLayout.setOnCardClickListener(new C1338a(this));
            }
            TextView textView = gameRankListViewHolder.mCloseBtn;
            if (textView != null) {
                textView.setOnClickListener(new b(this));
            }
            this.o.getLayoutMode().k(this.r == 1);
            this.o.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}

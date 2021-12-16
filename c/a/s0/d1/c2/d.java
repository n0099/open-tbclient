package c.a.s0.d1.c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.e;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.s0.v3.x;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.frsfeedforums.FrsMoreFeedForumsActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<FrsMoreFeedForumsActivity> f15744e;

    /* renamed from: f  reason: collision with root package name */
    public List<FeedForumData> f15745f;

    /* renamed from: g  reason: collision with root package name */
    public int f15746g;

    /* renamed from: h  reason: collision with root package name */
    public LikeModel f15747h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f15748i;

    /* renamed from: j  reason: collision with root package name */
    public e f15749j;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15750e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15750e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.s0.d1.c2.b bVar;
            FeedForumData feedForumData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (bVar = (c.a.s0.d1.c2.b) view.getTag()) == null || (feedForumData = (FeedForumData) this.f15750e.getItem(bVar.f15742h)) == null) {
                return;
            }
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (((FrsMoreFeedForumsActivity) this.f15750e.f15744e.getOrignalPage()).checkUpIsLogin()) {
                    this.f15750e.f15747h.L(feedForumData.getForumName(), feedForumData.getForumId());
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", feedForumData.getForumId());
                    if (!l.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    TiebaStatic.log(statisticItem);
                }
            } else if (view.getId() == R.id.frs_like_feed_forum_item) {
                this.f15750e.f15744e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f15750e.f15744e.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                TiebaStatic.log(new StatisticItem("c10050").param("fid", feedForumData.getForumId()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (AntiHelper.m(this.a.f15747h.getErrorCode(), this.a.f15747h.getErrorString())) {
                    AntiHelper.u(this.a.f15744e.getPageActivity(), this.a.f15747h.getErrorString());
                } else if (obj == null) {
                    if (StringUtils.isNull(this.a.f15747h.getErrorString())) {
                        return;
                    }
                    m.M(TbadkCoreApplication.getInst(), this.a.f15747h.getErrorString());
                } else {
                    x xVar = (x) obj;
                    xVar.v(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, xVar));
                }
            }
        }
    }

    public d(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15748i = new a(this);
        this.f15749j = new b(this);
        this.f15744e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f15747h = likeModel;
        likeModel.setLoadDataCallBack(this.f15749j);
    }

    public final void c(c.a.s0.d1.c2.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar.f15743i == this.f15746g) {
            return;
        }
        SkinManager.setBackgroundResource(bVar.a, R.drawable.frs_like_feed_forum_item_bg);
        SkinManager.setViewTextColor(bVar.f15737c, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(bVar.f15738d, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(bVar.f15739e, R.color.CAM_X0305, 1);
        View view = bVar.f15741g;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
        }
        bVar.f15743i = this.f15746g;
    }

    public final String d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 < 0) {
                return "0";
            }
            if (i2 < 10000) {
                return String.valueOf(i2);
            }
            if (i2 == 10000) {
                return "1W";
            }
            float f2 = i2 / 10000.0f;
            return f2 <= 9999.9f ? String.format("%.1fW", Float.valueOf(f2)) : "9999.9+W";
        }
        return (String) invokeI.objValue;
    }

    public final void e(c.a.s0.d1.c2.b bVar) {
        EntelechyUserLikeButton entelechyUserLikeButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null || (entelechyUserLikeButton = bVar.f15740f) == null) {
            return;
        }
        entelechyUserLikeButton.updateLikeStatus(true);
        bVar.f15740f.setEnabled(false);
    }

    public void f(List<FeedForumData> list, x xVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, list, xVar) == null) || list == null || list.size() <= 0 || xVar == null) {
            return;
        }
        for (FeedForumData feedForumData : list) {
            if (feedForumData.getForumId() != null && feedForumData.getForumId().equals(xVar.g())) {
                feedForumData.setIsLike(xVar.l());
                notifyDataSetChanged();
                return;
            }
        }
    }

    public void g(List<FeedForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f15745f = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<FeedForumData> list = this.f15745f;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            List<FeedForumData> list = this.f15745f;
            if (list != null) {
                return list.get(i2);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c.a.s0.d1.c2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            this.f15746g = TbadkCoreApplication.getInst().getSkinType();
            if (view == null) {
                view = LayoutInflater.from(this.f15744e.getPageActivity()).inflate(R.layout.frs_more_feed_forum_item, (ViewGroup) null);
                bVar = new c.a.s0.d1.c2.b(view);
                view.setTag(bVar);
                bVar.f15740f.setTag(bVar);
            } else {
                bVar = (c.a.s0.d1.c2.b) view.getTag();
            }
            FeedForumData feedForumData = (FeedForumData) getItem(i2);
            if (bVar == null) {
                return null;
            }
            bVar.f15742h = i2;
            bVar.a.setOnClickListener(this.f15748i);
            bVar.f15736b.setPlaceHolder(1);
            bVar.f15736b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.f15736b.startLoad(feedForumData.getAvatar(), 15, false);
            bVar.f15737c.setText(feedForumData.getForumName());
            bVar.f15738d.setText(String.format(this.f15744e.getPageActivity().getString(R.string.attention_post_count), d(feedForumData.getMemberCount()), d(feedForumData.getPostNum())));
            bVar.f15739e.setText(feedForumData.getReason());
            if (feedForumData.getIsLike() == 0) {
                bVar.f15740f.setClickable(true);
                bVar.f15740f.setOnClickListener(this.f15748i);
                bVar.f15740f.setEnabled(true);
                bVar.f15740f.updateLikeStatus(false);
            } else {
                e(bVar);
            }
            c(bVar);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

package c.a.r0.w0.r1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.e;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.r0.j3.x;
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
/* loaded from: classes4.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<FrsMoreFeedForumsActivity> f27707e;

    /* renamed from: f  reason: collision with root package name */
    public List<FeedForumData> f27708f;

    /* renamed from: g  reason: collision with root package name */
    public int f27709g;

    /* renamed from: h  reason: collision with root package name */
    public LikeModel f27710h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f27711i;

    /* renamed from: j  reason: collision with root package name */
    public e f27712j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f27713e;

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
            this.f27713e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.r0.w0.r1.b bVar;
            FeedForumData feedForumData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (bVar = (c.a.r0.w0.r1.b) view.getTag()) == null || (feedForumData = (FeedForumData) this.f27713e.getItem(bVar.f27705h)) == null) {
                return;
            }
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (((FrsMoreFeedForumsActivity) this.f27713e.f27707e.getOrignalPage()).checkUpIsLogin()) {
                    this.f27713e.f27710h.L(feedForumData.getForumName(), feedForumData.getForumId());
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", feedForumData.getForumId());
                    if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    TiebaStatic.log(statisticItem);
                }
            } else if (view.getId() == R.id.frs_like_feed_forum_item) {
                this.f27713e.f27707e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f27713e.f27707e.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                TiebaStatic.log(new StatisticItem("c10050").param("fid", feedForumData.getForumId()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f27714a;

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
            this.f27714a = dVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (AntiHelper.m(this.f27714a.f27710h.getErrorCode(), this.f27714a.f27710h.getErrorString())) {
                    AntiHelper.u(this.f27714a.f27707e.getPageActivity(), this.f27714a.f27710h.getErrorString());
                } else if (obj == null) {
                    if (StringUtils.isNull(this.f27714a.f27710h.getErrorString())) {
                        return;
                    }
                    l.M(TbadkCoreApplication.getInst(), this.f27714a.f27710h.getErrorString());
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
        this.f27711i = new a(this);
        this.f27712j = new b(this);
        this.f27707e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f27710h = likeModel;
        likeModel.setLoadDataCallBack(this.f27712j);
    }

    public final void c(c.a.r0.w0.r1.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar.f27706i == this.f27709g) {
            return;
        }
        SkinManager.setBackgroundResource(bVar.f27698a, R.drawable.frs_like_feed_forum_item_bg);
        SkinManager.setViewTextColor(bVar.f27700c, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(bVar.f27701d, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(bVar.f27702e, R.color.CAM_X0305, 1);
        View view = bVar.f27704g;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
        }
        bVar.f27706i = this.f27709g;
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

    public final void e(c.a.r0.w0.r1.b bVar) {
        EntelechyUserLikeButton entelechyUserLikeButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null || (entelechyUserLikeButton = bVar.f27703f) == null) {
            return;
        }
        entelechyUserLikeButton.updateLikeStatus(true);
        bVar.f27703f.setEnabled(false);
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
            this.f27708f = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<FeedForumData> list = this.f27708f;
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
            List<FeedForumData> list = this.f27708f;
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
        c.a.r0.w0.r1.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            this.f27709g = TbadkCoreApplication.getInst().getSkinType();
            if (view == null) {
                view = LayoutInflater.from(this.f27707e.getPageActivity()).inflate(R.layout.frs_more_feed_forum_item, (ViewGroup) null);
                bVar = new c.a.r0.w0.r1.b(view);
                view.setTag(bVar);
                bVar.f27703f.setTag(bVar);
            } else {
                bVar = (c.a.r0.w0.r1.b) view.getTag();
            }
            FeedForumData feedForumData = (FeedForumData) getItem(i2);
            if (bVar == null) {
                return null;
            }
            bVar.f27705h = i2;
            bVar.f27698a.setOnClickListener(this.f27711i);
            bVar.f27699b.setPlaceHolder(1);
            bVar.f27699b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.f27699b.startLoad(feedForumData.getAvatar(), 15, false);
            bVar.f27700c.setText(feedForumData.getForumName());
            bVar.f27701d.setText(String.format(this.f27707e.getPageActivity().getString(R.string.attention_post_count), d(feedForumData.getMemberCount()), d(feedForumData.getPostNum())));
            bVar.f27702e.setText(feedForumData.getReason());
            if (feedForumData.getIsLike() == 0) {
                bVar.f27703f.setClickable(true);
                bVar.f27703f.setOnClickListener(this.f27711i);
                bVar.f27703f.setEnabled(true);
                bVar.f27703f.updateLikeStatus(false);
            } else {
                e(bVar);
            }
            c(bVar);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

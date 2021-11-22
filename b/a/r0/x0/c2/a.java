package b.a.r0.x0.c2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.e;
import b.a.e.f.p.l;
import b.a.q0.s.s.a;
import b.a.r0.m3.x;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsMoreFeedForumsConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<FrsFragment> f27114a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f27115b;

    /* renamed from: c  reason: collision with root package name */
    public View f27116c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27117d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f27118e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f27119f;

    /* renamed from: g  reason: collision with root package name */
    public View f27120g;

    /* renamed from: h  reason: collision with root package name */
    public View f27121h;

    /* renamed from: i  reason: collision with root package name */
    public List<b.a.r0.x0.c2.b> f27122i;
    public List<FeedForumData> j;
    public LikeModel k;
    public Handler l;
    public int m;
    public String n;
    public boolean o;
    public boolean p;
    public View.OnClickListener q;
    public e r;

    /* renamed from: b.a.r0.x0.c2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1330a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27123e;

        public View$OnClickListenerC1330a(a aVar) {
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
            this.f27123e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.frs_feed_forum_attention) {
                    if (ViewHelper.checkUpIsLogin(this.f27123e.f27114a.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                        this.f27123e.k.L(feedForumData.getForumName(), feedForumData.getForumId());
                        TiebaStatic.log(new StatisticItem(this.f27123e.m == 1 ? "c10028" : "c10040").param("fid", feedForumData.getForumId()));
                    }
                } else if (view.getId() == R.id.like_feed_forums_arrow) {
                    this.f27123e.s();
                    TiebaStatic.log(new StatisticItem("c10029").param("fid", this.f27123e.n));
                } else if (view.getId() != R.id.frs_like_feed_forum_item) {
                    if (view.getId() != this.f27123e.f27119f.getId() || ListUtils.getCount(this.f27123e.j) <= 0) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(this.f27123e.f27114a.getPageActivity(), (Serializable) this.f27123e.j)));
                    TiebaStatic.log(new StatisticItem("c10046").param("fid", this.f27123e.n));
                } else {
                    FeedForumData feedForumData2 = (FeedForumData) view.getTag();
                    if (feedForumData2 != null) {
                        this.f27123e.f27114a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f27123e.f27114a.getPageActivity()).createNormalCfg(feedForumData2.getForumName(), this.f27123e.m == 1 ? FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND : "")));
                        TiebaStatic.log(new StatisticItem(this.f27123e.m == 2 ? "c10042" : "c10030").param("fid", feedForumData2.getForumId()));
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27124e;

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
                    return;
                }
            }
            this.f27124e = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f27124e.j != null) {
                    this.f27124e.j.clear();
                }
                this.f27124e.m();
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(a aVar) {
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

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27125a;

        /* renamed from: b.a.r0.x0.c2.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1331a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ x f27126e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f27127f;

            public RunnableC1331a(d dVar, x xVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, xVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f27127f = dVar;
                this.f27126e = xVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Iterator it = this.f27127f.f27125a.j.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        FeedForumData feedForumData = (FeedForumData) it.next();
                        if (feedForumData.getForumId().equals(this.f27126e.g())) {
                            this.f27127f.f27125a.j.remove(feedForumData);
                            break;
                        }
                    }
                    if (this.f27127f.f27125a.j.size() > 0) {
                        this.f27127f.f27125a.p();
                    } else {
                        this.f27127f.f27125a.m();
                    }
                }
            }
        }

        public d(a aVar) {
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
            this.f27125a = aVar;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (AntiHelper.m(this.f27125a.k.getErrorCode(), this.f27125a.k.getErrorString())) {
                    AntiHelper.u(this.f27125a.f27114a.getPageActivity(), this.f27125a.k.getErrorString());
                } else if (obj == null) {
                    if (StringUtils.isNull(this.f27125a.k.getErrorString())) {
                        return;
                    }
                    l.M(TbadkCoreApplication.getInst(), this.f27125a.k.getErrorString());
                } else {
                    x xVar = (x) obj;
                    if (ListUtils.getCount(this.f27125a.j) <= 0 || xVar == null) {
                        return;
                    }
                    Iterator it = this.f27125a.f27122i.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b.a.r0.x0.c2.b bVar = (b.a.r0.x0.c2.b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.f27133f.getTag();
                        if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(xVar.g())) {
                            feedForumData.setIsLike(1);
                            this.f27125a.l(bVar);
                            break;
                        }
                    }
                    if (this.f27125a.m == 1) {
                        this.f27125a.l.postDelayed(new RunnableC1331a(this, xVar), 1000L);
                    }
                }
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27122i = new ArrayList();
        this.l = new Handler();
        this.m = 1;
        this.n = "";
        this.o = false;
        this.q = new View$OnClickListenerC1330a(this);
        this.r = new d(this);
    }

    public final String k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
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

    public final void l(b.a.r0.x0.c2.b bVar) {
        EntelechyUserLikeButton entelechyUserLikeButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null || (entelechyUserLikeButton = bVar.f27133f) == null) {
            return;
        }
        entelechyUserLikeButton.updateLikeStatus(true);
        bVar.f27133f.setEnabled(false);
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f27115b.setVisibility(8);
        }
    }

    public void n(TbPageContext tbPageContext, View view, int i2, boolean z, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{tbPageContext, view, Integer.valueOf(i2), Boolean.valueOf(z), bdUniqueId}) == null) {
            this.f27114a = tbPageContext;
            this.f27115b = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
            this.f27116c = view.findViewById(R.id.frs_header_feed_forums_divider);
            this.f27120g = view.findViewById(R.id.layout_like_feed_forum_header);
            this.f27117d = (TextView) this.f27115b.findViewById(R.id.like_feed_forums_label);
            ImageView imageView = (ImageView) this.f27115b.findViewById(R.id.like_feed_forums_arrow);
            this.f27118e = imageView;
            imageView.setOnClickListener(this.q);
            this.f27119f = (TextView) this.f27115b.findViewById(R.id.feed_forums_more);
            this.f27121h = view.findViewById(R.id.feed_forum_bottom_line);
            this.f27119f.setOnClickListener(this.q);
            LikeModel likeModel = new LikeModel(tbPageContext);
            this.k = likeModel;
            likeModel.setUniqueId(bdUniqueId);
            this.k.setLoadDataCallBack(this.r);
            this.m = i2;
            this.p = z;
        }
    }

    public void o(String str, List<FeedForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) {
            this.n = str;
            this.j = list;
            p();
            if (this.m != 2 || this.o) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c10035").param("fid", this.n));
            this.o = true;
        }
    }

    public final void p() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (ListUtils.getCount(this.j) == 0) {
                m();
                return;
            }
            r();
            int size = this.j.size() > 2 ? 2 : this.j.size();
            int size2 = size - this.f27122i.size();
            if (size2 > 0) {
                for (int i3 = 0; i3 < size2; i3++) {
                    if (this.m == 1) {
                        i2 = R.layout.frs_header_feed_forum_item;
                    } else {
                        i2 = R.layout.frs_feed_forum_item;
                    }
                    View inflate = LayoutInflater.from(this.f27114a.getPageActivity()).inflate(i2, (ViewGroup) null);
                    this.f27115b.addView(inflate);
                    this.f27122i.add(new b.a.r0.x0.c2.b(inflate));
                }
            } else if (size2 < 0) {
                for (int i4 = 0; i4 < (-size2); i4++) {
                    int size3 = this.f27122i.size() - 1;
                    this.f27115b.removeView(this.f27122i.get(size3).f27128a);
                    this.f27122i.remove(size3);
                }
            }
            for (int i5 = 0; i5 < size; i5++) {
                FeedForumData feedForumData = this.j.get(i5);
                b.a.r0.x0.c2.b bVar = this.f27122i.get(i5);
                if (feedForumData != null && bVar != null) {
                    bVar.f27128a.setTag(feedForumData);
                    bVar.f27128a.setOnClickListener(this.q);
                    bVar.f27129b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                    bVar.f27129b.setPlaceHolder(1);
                    bVar.f27129b.startLoad(feedForumData.getAvatar(), 15, false);
                    bVar.f27130c.setText(feedForumData.getForumName());
                    bVar.f27131d.setText(String.format(this.f27114a.getPageActivity().getString(R.string.attention_post_count), k(feedForumData.getMemberCount()), k(feedForumData.getPostNum())));
                    bVar.f27132e.setText(feedForumData.getReason());
                    if (feedForumData.getIsLike() == 0) {
                        bVar.f27133f.setClickable(true);
                        bVar.f27133f.setOnClickListener(this.q);
                        bVar.f27133f.setTag(feedForumData);
                        bVar.f27133f.updateLikeStatus(false);
                        bVar.f27133f.setEnabled(true);
                    } else {
                        l(bVar);
                    }
                }
            }
            if (this.p) {
                this.f27121h.setVisibility(0);
            } else {
                this.f27121h.setVisibility(8);
            }
            q();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SkinManager.setBackgroundColor(this.f27115b, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f27116c, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f27120g, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f27117d, R.color.CAM_X0108, 1);
            SkinManager.setImageResource(this.f27118e, R.drawable.icon_frs_recommend_arrow_down);
            SkinManager.setViewTextColor(this.f27119f, R.color.CAM_X0110, 1);
            for (b.a.r0.x0.c2.b bVar : this.f27122i) {
                SkinManager.setBackgroundResource(bVar.f27128a, R.drawable.frs_like_feed_forum_item_bg);
                SkinManager.setViewTextColor(bVar.f27130c, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(bVar.f27131d, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(bVar.f27132e, R.color.CAM_X0305, 1);
                EntelechyUserLikeButton entelechyUserLikeButton = bVar.f27133f;
                entelechyUserLikeButton.updateLikeStatus(!entelechyUserLikeButton.isEnabled());
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f27115b.setVisibility(0);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f27114a.getPageActivity());
            aVar.setMessage(this.f27114a.getPageActivity().getString(R.string.not_intrested));
            aVar.setPositiveButton(R.string.alert_yes_button, new b(this));
            aVar.setNegativeButton(R.string.cancel, new c(this));
            aVar.create(this.f27114a).show();
        }
    }

    public a(TbPageContext tbPageContext, View view, int i2, boolean z, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, Integer.valueOf(i2), Boolean.valueOf(z), bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27122i = new ArrayList();
        this.l = new Handler();
        this.m = 1;
        this.n = "";
        this.o = false;
        this.q = new View$OnClickListenerC1330a(this);
        this.r = new d(this);
        n(tbPageContext, view, i2, z, bdUniqueId);
    }
}

package c.a.r0.d1.c2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.e;
import c.a.d.f.p.l;
import c.a.q0.s.s.a;
import c.a.r0.t3.x;
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
    public TbPageContext<FrsFragment> a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f15312b;

    /* renamed from: c  reason: collision with root package name */
    public View f15313c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15314d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f15315e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15316f;

    /* renamed from: g  reason: collision with root package name */
    public View f15317g;

    /* renamed from: h  reason: collision with root package name */
    public View f15318h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.r0.d1.c2.b> f15319i;

    /* renamed from: j  reason: collision with root package name */
    public List<FeedForumData> f15320j;

    /* renamed from: k  reason: collision with root package name */
    public LikeModel f15321k;
    public Handler l;
    public int m;
    public String n;
    public boolean o;
    public boolean p;
    public View.OnClickListener q;
    public e r;

    /* renamed from: c.a.r0.d1.c2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC0931a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15322e;

        public View$OnClickListenerC0931a(a aVar) {
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
            this.f15322e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.frs_feed_forum_attention) {
                    if (ViewHelper.checkUpIsLogin(this.f15322e.a.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                        this.f15322e.f15321k.L(feedForumData.getForumName(), feedForumData.getForumId());
                        TiebaStatic.log(new StatisticItem(this.f15322e.m == 1 ? "c10028" : "c10040").param("fid", feedForumData.getForumId()));
                    }
                } else if (view.getId() == R.id.like_feed_forums_arrow) {
                    this.f15322e.s();
                    TiebaStatic.log(new StatisticItem("c10029").param("fid", this.f15322e.n));
                } else if (view.getId() != R.id.frs_like_feed_forum_item) {
                    if (view.getId() != this.f15322e.f15316f.getId() || ListUtils.getCount(this.f15322e.f15320j) <= 0) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(this.f15322e.a.getPageActivity(), (Serializable) this.f15322e.f15320j)));
                    TiebaStatic.log(new StatisticItem("c10046").param("fid", this.f15322e.n));
                } else {
                    FeedForumData feedForumData2 = (FeedForumData) view.getTag();
                    if (feedForumData2 != null) {
                        this.f15322e.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f15322e.a.getPageActivity()).createNormalCfg(feedForumData2.getForumName(), this.f15322e.m == 1 ? FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND : "")));
                        TiebaStatic.log(new StatisticItem(this.f15322e.m == 2 ? "c10042" : "c10030").param("fid", feedForumData2.getForumId()));
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
        public final /* synthetic */ a f15323e;

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
            this.f15323e = aVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f15323e.f15320j != null) {
                    this.f15323e.f15320j.clear();
                }
                this.f15323e.m();
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

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
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
        public final /* synthetic */ a a;

        /* renamed from: c.a.r0.d1.c2.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0932a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ x f15324e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f15325f;

            public RunnableC0932a(d dVar, x xVar) {
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
                this.f15325f = dVar;
                this.f15324e = xVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Iterator it = this.f15325f.a.f15320j.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        FeedForumData feedForumData = (FeedForumData) it.next();
                        if (feedForumData.getForumId().equals(this.f15324e.g())) {
                            this.f15325f.a.f15320j.remove(feedForumData);
                            break;
                        }
                    }
                    if (this.f15325f.a.f15320j.size() > 0) {
                        this.f15325f.a.p();
                    } else {
                        this.f15325f.a.m();
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
            this.a = aVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (AntiHelper.m(this.a.f15321k.getErrorCode(), this.a.f15321k.getErrorString())) {
                    AntiHelper.u(this.a.a.getPageActivity(), this.a.f15321k.getErrorString());
                } else if (obj == null) {
                    if (StringUtils.isNull(this.a.f15321k.getErrorString())) {
                        return;
                    }
                    l.M(TbadkCoreApplication.getInst(), this.a.f15321k.getErrorString());
                } else {
                    x xVar = (x) obj;
                    if (ListUtils.getCount(this.a.f15320j) <= 0 || xVar == null) {
                        return;
                    }
                    Iterator it = this.a.f15319i.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        c.a.r0.d1.c2.b bVar = (c.a.r0.d1.c2.b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.f15330f.getTag();
                        if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(xVar.g())) {
                            feedForumData.setIsLike(1);
                            this.a.l(bVar);
                            break;
                        }
                    }
                    if (this.a.m == 1) {
                        this.a.l.postDelayed(new RunnableC0932a(this, xVar), 1000L);
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
        this.f15319i = new ArrayList();
        this.l = new Handler();
        this.m = 1;
        this.n = "";
        this.o = false;
        this.q = new View$OnClickListenerC0931a(this);
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

    public final void l(c.a.r0.d1.c2.b bVar) {
        EntelechyUserLikeButton entelechyUserLikeButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null || (entelechyUserLikeButton = bVar.f15330f) == null) {
            return;
        }
        entelechyUserLikeButton.updateLikeStatus(true);
        bVar.f15330f.setEnabled(false);
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f15312b.setVisibility(8);
        }
    }

    public void n(TbPageContext tbPageContext, View view, int i2, boolean z, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{tbPageContext, view, Integer.valueOf(i2), Boolean.valueOf(z), bdUniqueId}) == null) {
            this.a = tbPageContext;
            this.f15312b = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
            this.f15313c = view.findViewById(R.id.frs_header_feed_forums_divider);
            this.f15317g = view.findViewById(R.id.layout_like_feed_forum_header);
            this.f15314d = (TextView) this.f15312b.findViewById(R.id.like_feed_forums_label);
            ImageView imageView = (ImageView) this.f15312b.findViewById(R.id.like_feed_forums_arrow);
            this.f15315e = imageView;
            imageView.setOnClickListener(this.q);
            this.f15316f = (TextView) this.f15312b.findViewById(R.id.feed_forums_more);
            this.f15318h = view.findViewById(R.id.feed_forum_bottom_line);
            this.f15316f.setOnClickListener(this.q);
            LikeModel likeModel = new LikeModel(tbPageContext);
            this.f15321k = likeModel;
            likeModel.setUniqueId(bdUniqueId);
            this.f15321k.setLoadDataCallBack(this.r);
            this.m = i2;
            this.p = z;
        }
    }

    public void o(String str, List<FeedForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) {
            this.n = str;
            this.f15320j = list;
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
            if (ListUtils.getCount(this.f15320j) == 0) {
                m();
                return;
            }
            r();
            int size = this.f15320j.size() > 2 ? 2 : this.f15320j.size();
            int size2 = size - this.f15319i.size();
            if (size2 > 0) {
                for (int i3 = 0; i3 < size2; i3++) {
                    if (this.m == 1) {
                        i2 = R.layout.frs_header_feed_forum_item;
                    } else {
                        i2 = R.layout.frs_feed_forum_item;
                    }
                    View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(i2, (ViewGroup) null);
                    this.f15312b.addView(inflate);
                    this.f15319i.add(new c.a.r0.d1.c2.b(inflate));
                }
            } else if (size2 < 0) {
                for (int i4 = 0; i4 < (-size2); i4++) {
                    int size3 = this.f15319i.size() - 1;
                    this.f15312b.removeView(this.f15319i.get(size3).a);
                    this.f15319i.remove(size3);
                }
            }
            for (int i5 = 0; i5 < size; i5++) {
                FeedForumData feedForumData = this.f15320j.get(i5);
                c.a.r0.d1.c2.b bVar = this.f15319i.get(i5);
                if (feedForumData != null && bVar != null) {
                    bVar.a.setTag(feedForumData);
                    bVar.a.setOnClickListener(this.q);
                    bVar.f15326b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                    bVar.f15326b.setPlaceHolder(1);
                    bVar.f15326b.startLoad(feedForumData.getAvatar(), 15, false);
                    bVar.f15327c.setText(feedForumData.getForumName());
                    bVar.f15328d.setText(String.format(this.a.getPageActivity().getString(R.string.attention_post_count), k(feedForumData.getMemberCount()), k(feedForumData.getPostNum())));
                    bVar.f15329e.setText(feedForumData.getReason());
                    if (feedForumData.getIsLike() == 0) {
                        bVar.f15330f.setClickable(true);
                        bVar.f15330f.setOnClickListener(this.q);
                        bVar.f15330f.setTag(feedForumData);
                        bVar.f15330f.updateLikeStatus(false);
                        bVar.f15330f.setEnabled(true);
                    } else {
                        l(bVar);
                    }
                }
            }
            if (this.p) {
                this.f15318h.setVisibility(0);
            } else {
                this.f15318h.setVisibility(8);
            }
            q();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SkinManager.setBackgroundColor(this.f15312b, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f15313c, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f15317g, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f15314d, R.color.CAM_X0108, 1);
            SkinManager.setImageResource(this.f15315e, R.drawable.icon_frs_recommend_arrow_down);
            SkinManager.setViewTextColor(this.f15316f, R.color.CAM_X0110, 1);
            for (c.a.r0.d1.c2.b bVar : this.f15319i) {
                SkinManager.setBackgroundResource(bVar.a, R.drawable.frs_like_feed_forum_item_bg);
                SkinManager.setViewTextColor(bVar.f15327c, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(bVar.f15328d, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(bVar.f15329e, R.color.CAM_X0305, 1);
                EntelechyUserLikeButton entelechyUserLikeButton = bVar.f15330f;
                entelechyUserLikeButton.updateLikeStatus(!entelechyUserLikeButton.isEnabled());
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f15312b.setVisibility(0);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.a.getPageActivity());
            aVar.setMessage(this.a.getPageActivity().getString(R.string.not_intrested));
            aVar.setPositiveButton(R.string.alert_yes_button, new b(this));
            aVar.setNegativeButton(R.string.cancel, new c(this));
            aVar.create(this.a).show();
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
        this.f15319i = new ArrayList();
        this.l = new Handler();
        this.m = 1;
        this.n = "";
        this.o = false;
        this.q = new View$OnClickListenerC0931a(this);
        this.r = new d(this);
        n(tbPageContext, view, i2, z, bdUniqueId);
    }
}

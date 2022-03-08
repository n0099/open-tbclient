package c.a.r0.d1.t1;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.e;
import c.a.d.f.p.n;
import c.a.q0.r.t.a;
import c.a.r0.y3.y;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<FrsFragment> a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f16417b;

    /* renamed from: c  reason: collision with root package name */
    public View f16418c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16419d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f16420e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16421f;

    /* renamed from: g  reason: collision with root package name */
    public View f16422g;

    /* renamed from: h  reason: collision with root package name */
    public View f16423h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.r0.d1.t1.b> f16424i;

    /* renamed from: j  reason: collision with root package name */
    public List<FeedForumData> f16425j;
    public LikeModel k;
    public Handler l;
    public int m;
    public String n;
    public boolean o;
    public boolean p;
    public View.OnClickListener q;
    public e r;

    /* renamed from: c.a.r0.d1.t1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1049a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16426e;

        public View$OnClickListenerC1049a(a aVar) {
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
            this.f16426e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.frs_feed_forum_attention) {
                    if (ViewHelper.checkUpIsLogin(this.f16426e.a.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                        this.f16426e.k.N(feedForumData.getForumName(), feedForumData.getForumId());
                        TiebaStatic.log(new StatisticItem(this.f16426e.m == 1 ? "c10028" : "c10040").param("fid", feedForumData.getForumId()));
                    }
                } else if (view.getId() == R.id.like_feed_forums_arrow) {
                    this.f16426e.s();
                    TiebaStatic.log(new StatisticItem("c10029").param("fid", this.f16426e.n));
                } else if (view.getId() != R.id.frs_like_feed_forum_item) {
                    if (view.getId() != this.f16426e.f16421f.getId() || ListUtils.getCount(this.f16426e.f16425j) <= 0) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(this.f16426e.a.getPageActivity(), (Serializable) this.f16426e.f16425j)));
                    TiebaStatic.log(new StatisticItem("c10046").param("fid", this.f16426e.n));
                } else {
                    FeedForumData feedForumData2 = (FeedForumData) view.getTag();
                    if (feedForumData2 != null) {
                        this.f16426e.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f16426e.a.getPageActivity()).createNormalCfg(feedForumData2.getForumName(), this.f16426e.m == 1 ? FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND : "")));
                        TiebaStatic.log(new StatisticItem(this.f16426e.m == 2 ? "c10042" : "c10030").param("fid", feedForumData2.getForumId()));
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16427e;

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
            this.f16427e = aVar;
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f16427e.f16425j != null) {
                    this.f16427e.f16425j.clear();
                }
                this.f16427e.m();
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
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

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.r0.d1.t1.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1050a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ y f16428e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f16429f;

            public RunnableC1050a(d dVar, y yVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, yVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16429f = dVar;
                this.f16428e = yVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Iterator it = this.f16429f.a.f16425j.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        FeedForumData feedForumData = (FeedForumData) it.next();
                        if (feedForumData.getForumId().equals(this.f16428e.g())) {
                            this.f16429f.a.f16425j.remove(feedForumData);
                            break;
                        }
                    }
                    if (this.f16429f.a.f16425j.size() > 0) {
                        this.f16429f.a.p();
                    } else {
                        this.f16429f.a.m();
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
                if (AntiHelper.m(this.a.k.getErrorCode(), this.a.k.getErrorString())) {
                    AntiHelper.u(this.a.a.getPageActivity(), this.a.k.getErrorString());
                } else if (obj == null) {
                    if (StringUtils.isNull(this.a.k.getErrorString())) {
                        return;
                    }
                    n.N(TbadkCoreApplication.getInst(), this.a.k.getErrorString());
                } else {
                    y yVar = (y) obj;
                    if (ListUtils.getCount(this.a.f16425j) <= 0 || yVar == null) {
                        return;
                    }
                    Iterator it = this.a.f16424i.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        c.a.r0.d1.t1.b bVar = (c.a.r0.d1.t1.b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.f16434f.getTag();
                        if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(yVar.g())) {
                            feedForumData.setIsLike(1);
                            this.a.l(bVar);
                            break;
                        }
                    }
                    if (this.a.m == 1) {
                        this.a.l.postDelayed(new RunnableC1050a(this, yVar), 1000L);
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
        this.f16424i = new ArrayList();
        this.l = new Handler();
        this.m = 1;
        this.n = "";
        this.o = false;
        this.q = new View$OnClickListenerC1049a(this);
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

    public final void l(c.a.r0.d1.t1.b bVar) {
        EntelechyUserLikeButton entelechyUserLikeButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null || (entelechyUserLikeButton = bVar.f16434f) == null) {
            return;
        }
        entelechyUserLikeButton.updateLikeStatus(true);
        bVar.f16434f.setEnabled(false);
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16417b.setVisibility(8);
        }
    }

    public void n(TbPageContext tbPageContext, View view, int i2, boolean z, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{tbPageContext, view, Integer.valueOf(i2), Boolean.valueOf(z), bdUniqueId}) == null) {
            this.a = tbPageContext;
            this.f16417b = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
            this.f16418c = view.findViewById(R.id.frs_header_feed_forums_divider);
            this.f16422g = view.findViewById(R.id.layout_like_feed_forum_header);
            this.f16419d = (TextView) this.f16417b.findViewById(R.id.like_feed_forums_label);
            ImageView imageView = (ImageView) this.f16417b.findViewById(R.id.like_feed_forums_arrow);
            this.f16420e = imageView;
            imageView.setOnClickListener(this.q);
            this.f16421f = (TextView) this.f16417b.findViewById(R.id.feed_forums_more);
            this.f16423h = view.findViewById(R.id.feed_forum_bottom_line);
            this.f16421f.setOnClickListener(this.q);
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
            this.f16425j = list;
            p();
            if (this.m != 2 || this.o) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c10035").param("fid", this.n));
            this.o = true;
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (ListUtils.getCount(this.f16425j) == 0) {
                m();
                return;
            }
            r();
            int size = this.f16425j.size() > 2 ? 2 : this.f16425j.size();
            int size2 = size - this.f16424i.size();
            if (size2 > 0) {
                for (int i2 = 0; i2 < size2; i2++) {
                    View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(this.m == 1 ? R.layout.frs_header_feed_forum_item : R.layout.frs_feed_forum_item, (ViewGroup) null);
                    this.f16417b.addView(inflate);
                    this.f16424i.add(new c.a.r0.d1.t1.b(inflate));
                }
            } else if (size2 < 0) {
                for (int i3 = 0; i3 < (-size2); i3++) {
                    int size3 = this.f16424i.size() - 1;
                    this.f16417b.removeView(this.f16424i.get(size3).a);
                    this.f16424i.remove(size3);
                }
            }
            for (int i4 = 0; i4 < size; i4++) {
                FeedForumData feedForumData = this.f16425j.get(i4);
                c.a.r0.d1.t1.b bVar = this.f16424i.get(i4);
                if (feedForumData != null && bVar != null) {
                    bVar.a.setTag(feedForumData);
                    bVar.a.setOnClickListener(this.q);
                    bVar.f16430b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                    bVar.f16430b.setPlaceHolder(1);
                    bVar.f16430b.startLoad(feedForumData.getAvatar(), 15, false);
                    bVar.f16431c.setText(feedForumData.getForumName());
                    bVar.f16432d.setText(String.format(this.a.getPageActivity().getString(R.string.attention_post_count), k(feedForumData.getMemberCount()), k(feedForumData.getPostNum())));
                    bVar.f16433e.setText(feedForumData.getReason());
                    if (feedForumData.getIsLike() == 0) {
                        bVar.f16434f.setClickable(true);
                        bVar.f16434f.setOnClickListener(this.q);
                        bVar.f16434f.setTag(feedForumData);
                        bVar.f16434f.updateLikeStatus(false);
                        bVar.f16434f.setEnabled(true);
                    } else {
                        l(bVar);
                    }
                }
            }
            if (this.p) {
                this.f16423h.setVisibility(0);
            } else {
                this.f16423h.setVisibility(8);
            }
            q();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SkinManager.setBackgroundColor(this.f16417b, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f16418c, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f16422g, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f16419d, R.color.CAM_X0108, 1);
            SkinManager.setImageResource(this.f16420e, R.drawable.icon_frs_recommend_arrow_down);
            SkinManager.setViewTextColor(this.f16421f, R.color.CAM_X0110, 1);
            for (c.a.r0.d1.t1.b bVar : this.f16424i) {
                SkinManager.setBackgroundResource(bVar.a, R.drawable.frs_like_feed_forum_item_bg);
                SkinManager.setViewTextColor(bVar.f16431c, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(bVar.f16432d, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(bVar.f16433e, R.color.CAM_X0305, 1);
                EntelechyUserLikeButton entelechyUserLikeButton = bVar.f16434f;
                entelechyUserLikeButton.updateLikeStatus(!entelechyUserLikeButton.isEnabled());
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f16417b.setVisibility(0);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(this.a.getPageActivity());
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
        this.f16424i = new ArrayList();
        this.l = new Handler();
        this.m = 1;
        this.n = "";
        this.o = false;
        this.q = new View$OnClickListenerC1049a(this);
        this.r = new d(this);
        n(tbPageContext, view, i2, z, bdUniqueId);
    }
}

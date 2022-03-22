package c.a.p0.f1.t1;

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
import c.a.o0.r.t.a;
import c.a.p0.a4.y;
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
    public LinearLayout f14635b;

    /* renamed from: c  reason: collision with root package name */
    public View f14636c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f14637d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f14638e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f14639f;

    /* renamed from: g  reason: collision with root package name */
    public View f14640g;

    /* renamed from: h  reason: collision with root package name */
    public View f14641h;
    public List<c.a.p0.f1.t1.b> i;
    public List<FeedForumData> j;
    public LikeModel k;
    public Handler l;
    public int m;
    public String n;
    public boolean o;
    public boolean p;
    public View.OnClickListener q;
    public e r;

    /* renamed from: c.a.p0.f1.t1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1108a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC1108a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.obfuscated_res_0x7f090ae4) {
                    if (ViewHelper.checkUpIsLogin(this.a.a.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                        this.a.k.P(feedForumData.getForumName(), feedForumData.getForumId());
                        TiebaStatic.log(new StatisticItem(this.a.m == 1 ? "c10028" : "c10040").param("fid", feedForumData.getForumId()));
                    }
                } else if (view.getId() == R.id.obfuscated_res_0x7f091250) {
                    this.a.s();
                    TiebaStatic.log(new StatisticItem("c10029").param("fid", this.a.n));
                } else if (view.getId() != R.id.obfuscated_res_0x7f090b56) {
                    if (view.getId() != this.a.f14639f.getId() || ListUtils.getCount(this.a.j) <= 0) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(this.a.a.getPageActivity(), (Serializable) this.a.j)));
                    TiebaStatic.log(new StatisticItem("c10046").param("fid", this.a.n));
                } else {
                    FeedForumData feedForumData2 = (FeedForumData) view.getTag();
                    if (feedForumData2 != null) {
                        this.a.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.a.getPageActivity()).createNormalCfg(feedForumData2.getForumName(), this.a.m == 1 ? FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND : "")));
                        TiebaStatic.log(new StatisticItem(this.a.m == 2 ? "c10042" : "c10030").param("fid", feedForumData2.getForumId()));
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.a.j != null) {
                    this.a.j.clear();
                }
                this.a.m();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
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

        /* renamed from: c.a.p0.f1.t1.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1109a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ y a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f14642b;

            public RunnableC1109a(d dVar, y yVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, yVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f14642b = dVar;
                this.a = yVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Iterator it = this.f14642b.a.j.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        FeedForumData feedForumData = (FeedForumData) it.next();
                        if (feedForumData.getForumId().equals(this.a.g())) {
                            this.f14642b.a.j.remove(feedForumData);
                            break;
                        }
                    }
                    if (this.f14642b.a.j.size() > 0) {
                        this.f14642b.a.p();
                    } else {
                        this.f14642b.a.m();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    if (ListUtils.getCount(this.a.j) <= 0 || yVar == null) {
                        return;
                    }
                    Iterator it = this.a.i.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        c.a.p0.f1.t1.b bVar = (c.a.p0.f1.t1.b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.f14647f.getTag();
                        if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(yVar.g())) {
                            feedForumData.setIsLike(1);
                            this.a.l(bVar);
                            break;
                        }
                    }
                    if (this.a.m == 1) {
                        this.a.l.postDelayed(new RunnableC1109a(this, yVar), 1000L);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new ArrayList();
        this.l = new Handler();
        this.m = 1;
        this.n = "";
        this.o = false;
        this.q = new View$OnClickListenerC1108a(this);
        this.r = new d(this);
    }

    public final String k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i < 0) {
                return "0";
            }
            if (i < 10000) {
                return String.valueOf(i);
            }
            if (i == 10000) {
                return "1W";
            }
            float f2 = i / 10000.0f;
            return f2 <= 9999.9f ? String.format("%.1fW", Float.valueOf(f2)) : "9999.9+W";
        }
        return (String) invokeI.objValue;
    }

    public final void l(c.a.p0.f1.t1.b bVar) {
        EntelechyUserLikeButton entelechyUserLikeButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null || (entelechyUserLikeButton = bVar.f14647f) == null) {
            return;
        }
        entelechyUserLikeButton.h(true);
        bVar.f14647f.setEnabled(false);
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f14635b.setVisibility(8);
        }
    }

    public void n(TbPageContext tbPageContext, View view, int i, boolean z, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{tbPageContext, view, Integer.valueOf(i), Boolean.valueOf(z), bdUniqueId}) == null) {
            this.a = tbPageContext;
            this.f14635b = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090b28);
            this.f14636c = view.findViewById(R.id.obfuscated_res_0x7f090b29);
            this.f14640g = view.findViewById(R.id.obfuscated_res_0x7f0911e5);
            this.f14637d = (TextView) this.f14635b.findViewById(R.id.obfuscated_res_0x7f091251);
            ImageView imageView = (ImageView) this.f14635b.findViewById(R.id.obfuscated_res_0x7f091250);
            this.f14638e = imageView;
            imageView.setOnClickListener(this.q);
            this.f14639f = (TextView) this.f14635b.findViewById(R.id.obfuscated_res_0x7f090987);
            this.f14641h = view.findViewById(R.id.obfuscated_res_0x7f090986);
            this.f14639f.setOnClickListener(this.q);
            LikeModel likeModel = new LikeModel(tbPageContext);
            this.k = likeModel;
            likeModel.setUniqueId(bdUniqueId);
            this.k.setLoadDataCallBack(this.r);
            this.m = i;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (ListUtils.getCount(this.j) == 0) {
                m();
                return;
            }
            r();
            int size = this.j.size() > 2 ? 2 : this.j.size();
            int size2 = size - this.i.size();
            if (size2 > 0) {
                for (int i = 0; i < size2; i++) {
                    View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(this.m == 1 ? R.layout.obfuscated_res_0x7f0d0323 : R.layout.obfuscated_res_0x7f0d030e, (ViewGroup) null);
                    this.f14635b.addView(inflate);
                    this.i.add(new c.a.p0.f1.t1.b(inflate));
                }
            } else if (size2 < 0) {
                for (int i2 = 0; i2 < (-size2); i2++) {
                    int size3 = this.i.size() - 1;
                    this.f14635b.removeView(this.i.get(size3).a);
                    this.i.remove(size3);
                }
            }
            for (int i3 = 0; i3 < size; i3++) {
                FeedForumData feedForumData = this.j.get(i3);
                c.a.p0.f1.t1.b bVar = this.i.get(i3);
                if (feedForumData != null && bVar != null) {
                    bVar.a.setTag(feedForumData);
                    bVar.a.setOnClickListener(this.q);
                    bVar.f14643b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                    bVar.f14643b.setPlaceHolder(1);
                    bVar.f14643b.J(feedForumData.getAvatar(), 15, false);
                    bVar.f14644c.setText(feedForumData.getForumName());
                    bVar.f14645d.setText(String.format(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f02a9), k(feedForumData.getMemberCount()), k(feedForumData.getPostNum())));
                    bVar.f14646e.setText(feedForumData.getReason());
                    if (feedForumData.getIsLike() == 0) {
                        bVar.f14647f.setClickable(true);
                        bVar.f14647f.setOnClickListener(this.q);
                        bVar.f14647f.setTag(feedForumData);
                        bVar.f14647f.h(false);
                        bVar.f14647f.setEnabled(true);
                    } else {
                        l(bVar);
                    }
                }
            }
            if (this.p) {
                this.f14641h.setVisibility(0);
            } else {
                this.f14641h.setVisibility(8);
            }
            q();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SkinManager.setBackgroundColor(this.f14635b, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f14636c, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f14640g, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f14637d, R.color.CAM_X0108, 1);
            SkinManager.setImageResource(this.f14638e, R.drawable.icon_frs_recommend_arrow_down);
            SkinManager.setViewTextColor(this.f14639f, R.color.CAM_X0110, 1);
            for (c.a.p0.f1.t1.b bVar : this.i) {
                SkinManager.setBackgroundResource(bVar.a, R.drawable.frs_like_feed_forum_item_bg);
                SkinManager.setViewTextColor(bVar.f14644c, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(bVar.f14645d, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(bVar.f14646e, R.color.CAM_X0305, 1);
                EntelechyUserLikeButton entelechyUserLikeButton = bVar.f14647f;
                entelechyUserLikeButton.h(!entelechyUserLikeButton.isEnabled());
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f14635b.setVisibility(0);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getPageActivity());
            aVar.setMessage(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0c75));
            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f025c, new b(this));
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new c(this));
            aVar.create(this.a).show();
        }
    }

    public a(TbPageContext tbPageContext, View view, int i, boolean z, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, Integer.valueOf(i), Boolean.valueOf(z), bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = new ArrayList();
        this.l = new Handler();
        this.m = 1;
        this.n = "";
        this.o = false;
        this.q = new View$OnClickListenerC1108a(this);
        this.r = new d(this);
        n(tbPageContext, view, i, z, bdUniqueId);
    }
}

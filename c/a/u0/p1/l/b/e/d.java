package c.a.u0.p1.l.b.e;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.s.l;
import c.a.t0.s.r.e2;
import c.a.u0.g0.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes8.dex */
public class d extends c.a.u0.g0.b<c.a.u0.p1.l.b.c.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public View B;
    public boolean C;
    public int D;
    public TbPageContext m;
    public c.a.u0.p1.l.b.c.c n;
    public ClickableHeaderImageView o;
    public TextView p;
    public ImageView q;
    public TextView r;
    public AgreeView s;
    public TextView t;
    public ImageView u;
    public TbRichTextView v;
    public ConstrainImageGroup w;
    public RelativeLayout x;
    public View y;
    public TbImageView z;

    /* loaded from: classes8.dex */
    public class a implements c.a.t0.f1.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkedList a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e2 f20921b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f20922c;

        public a(d dVar, LinkedList linkedList, e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, linkedList, e2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20922c = dVar;
            this.a = linkedList;
            this.f20921b = e2Var;
        }

        @Override // c.a.t0.f1.j.d
        public void a(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                if (z) {
                    this.f20922c.t();
                } else {
                    this.f20922c.D(view, this.a, i2, this.f20921b);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext<?> tbPageContext) {
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
        this.C = true;
        this.D = 3;
        this.m = tbPageContext;
        s();
    }

    public void A(c.a.d.f.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || (constrainImageGroup = this.w) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(bVar);
    }

    public final void B(c.a.u0.p1.l.b.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            e2 e2Var = cVar.f20891f;
            ArrayList<MediaData> G0 = e2Var.G0();
            if (l.c().g() && ListUtils.getCount(G0) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < G0.size(); i2++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(G0, i2);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (ListUtils.getCount(linkedList) > 0) {
                    this.x.setVisibility(0);
                    this.w.setFromCDN(this.C);
                    this.w.setImageClickListener(new a(this, linkedList, e2Var));
                    this.w.setImageMediaList(linkedList);
                    return;
                }
                this.x.setVisibility(8);
                return;
            }
            this.x.setVisibility(8);
        }
    }

    public final void C(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            n(bdUniqueId);
            ConstrainImageGroup constrainImageGroup = this.w;
            if (constrainImageGroup != null) {
                constrainImageGroup.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public final void D(View view, List<MediaData> list, int i2, e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048579, this, view, list, i2, e2Var) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                n.M(this.f17875f.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
            for (MediaData mediaData : list) {
                if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                    arrayList.add(mediaData.getSrc_pic());
                    if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = this.C ? 13 : 14;
                        imageUrlData.imageUrl = mediaData.getPicUrl();
                        imageUrlData.originalUrl = mediaData.getOriginalUrl();
                        imageUrlData.originalSize = mediaData.getOriginalSize();
                        imageUrlData.isLongPic = mediaData.isLongPic();
                        imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                        imageUrlData.threadId = c.a.d.f.m.b.g(e2Var.w1(), -1L);
                        imageUrlData.postId = mediaData.getPostId();
                        concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                    }
                }
            }
            if (arrayList.size() <= 0) {
                for (MediaData mediaData2 : list) {
                    if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                        arrayList.add(mediaData2.getPicUrl());
                    }
                }
            }
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
            bVar.x(arrayList);
            bVar.B(i2);
            bVar.z(e2Var.b0());
            bVar.y(String.valueOf(e2Var.U()));
            bVar.O(e2Var.w1());
            bVar.C(this.C);
            bVar.J(arrayList.size() > 0 ? arrayList.get(0) : "");
            bVar.F(true);
            bVar.w(concurrentHashMap);
            bVar.H(true);
            bVar.N(e2Var);
            bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig v = bVar.v(this.f17875f.getPageActivity());
            if (this.l == 2) {
                v.getIntent().putExtra("from", "index");
            } else {
                v.getIntent().putExtra("from", "other");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.f17875f;
            historyMessage.threadId = e2Var.h0();
            historyMessage.threadName = e2Var.getTitle();
            historyMessage.forumName = e2Var.b0();
            historyMessage.postID = e2Var.X();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    @Override // c.a.u0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.topic_discuss_view : invokeV.intValue;
    }

    @Override // c.a.u0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i2) == null) || this.D == i2 || this.n == null) {
            return;
        }
        this.D = i2;
        this.o.setSkinType(i2);
        c.a.u0.p1.l.b.c.c cVar = this.n;
        if (cVar.f20895j) {
            int i3 = cVar.f20893h;
            if (i3 == 1) {
                SkinManager.setImageResource(this.q, R.drawable.label_topic_agree_red);
                this.o.setBorderColor(this.m.getPageActivity().getResources().getColor(R.color.CAM_X0301));
            } else if (i3 == 2) {
                SkinManager.setImageResource(this.q, R.drawable.label_topic_disagree_blue);
                this.o.setBorderColor(this.m.getPageActivity().getResources().getColor(R.color.CAM_X0302));
            } else {
                SkinManager.setImageResource(this.q, R.drawable.label_topic_eat_black);
                this.o.setBorderColor(this.m.getPageActivity().getResources().getColor(R.color.CAM_X0106));
            }
        }
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0107);
        if (this.u != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.u, R.drawable.icon_pure_topic_reply16_svg, R.color.CAM_X0107, null);
        }
        this.s.onChangeSkinType(i2);
        this.v.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        SkinManager.setBackgroundShapeDrawable(this.y, n.f(this.m.getPageActivity(), R.dimen.tbds6), R.color.CAM_X0209, R.color.cp_bg_line_j_alpha50);
        SkinManager.setViewTextColor(this.A, R.color.CAM_X0109);
        this.w.onChangeSkinType();
        SkinManager.setBackgroundColor(this.B, R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.u0.p1.l.b.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || (cVar = this.n) == null || cVar.f20891f == null) {
            return;
        }
        if (view == this.v) {
            if (cVar.f20894i == 1) {
                u();
            } else {
                t();
            }
            q("1");
        }
        if (view != this.t && view != this.u) {
            if (view == this.p) {
                v();
                return;
            }
            t();
            q("2");
            return;
        }
        if (this.n.f20894i == 1) {
            u();
        } else {
            t();
        }
        q("3");
    }

    public final void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            TiebaStatic.log(new StatisticItem("c13356").param("obj_locate", str).param("tid", this.n.f20891f.w1()).param("topic_id", this.n.f20892g).param("obj_type", String.valueOf(this.n.f20894i)));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            View j2 = j();
            this.o = (ClickableHeaderImageView) j2.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
            this.q = (ImageView) j2.findViewById(R.id.card_topic_detail_thread_opinion_img);
            this.p = (TextView) j2.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
            this.r = (TextView) j2.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
            TbRichTextView tbRichTextView = (TbRichTextView) j2.findViewById(R.id.card_topic_detail_discuss_title);
            this.v = tbRichTextView;
            tbRichTextView.setClickable(true);
            this.v.setTextEllipsize(TextUtils.TruncateAt.END);
            this.v.setMaxLines(2);
            c.a.t0.f1.n.a aVar = new c.a.t0.f1.n.a();
            aVar.v(n.f(getContext(), R.dimen.tbds44));
            aVar.o(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
            this.v.setLayoutStrategy(aVar);
            this.x = (RelativeLayout) j2.findViewById(R.id.topic_detail_img_container);
            this.w = (ConstrainImageGroup) j2.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
            this.w.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
            c.a.t0.f1.j.a aVar2 = new c.a.t0.f1.j.a(3);
            aVar2.d(1.0d);
            this.w.setImageProcessor(aVar2);
            AgreeView agreeView = (AgreeView) j2.findViewById(R.id.card_topic_detail_discuss_argee_view);
            this.s = agreeView;
            agreeView.adjustLayoutForTopicDetail();
            this.t = (TextView) j2.findViewById(R.id.topic_comment_number);
            this.u = (ImageView) j2.findViewById(R.id.topic_comment_pic);
            this.y = j2.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
            TbImageView tbImageView = (TbImageView) j2.findViewById(R.id.card_topic_discuss_original_thread_pic);
            this.z = tbImageView;
            tbImageView.setRadius(n.f(getContext(), R.dimen.tbds6));
            this.z.setConrers(5);
            this.z.setDrawCorner(true);
            this.A = (TextView) j2.findViewById(R.id.card_topic_discuss_original_thread_title);
            this.B = j2.findViewById(R.id.card_topic_detail_discuss_line_layout);
            this.p.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.v.setOnClickListener(this);
            this.y.setOnClickListener(this);
            this.A.setOnClickListener(this);
        }
    }

    public void t() {
        c.a.u0.p1.l.b.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (cVar = this.n) == null || cVar.f20891f == null) {
            return;
        }
        PbActivityConfig addLocateParam = new PbActivityConfig(this.m.getPageActivity()).createFromThreadCfg(this.n.f20891f, null, "none", 18003, true, false, false).addLocateParam(null);
        addLocateParam.setForumId(String.valueOf(this.n.f20891f.U()));
        addLocateParam.setFrom("from_personalize");
        addLocateParam.setForumName(this.n.f20891f.b0());
        addLocateParam.setStartFrom(this.l);
        addLocateParam.setJumpGodReply(false);
        addLocateParam.setJumpToCommentArea(true);
        m.a(this.n.f20891f.w1());
        this.f17875f.sendMessage(new CustomMessage(2004001, addLocateParam));
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            String format = String.format("%1$s", this.n.f20891f.z1().G());
            String valueOf = String.valueOf(this.n.f20891f.w1());
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.m.getPageActivity());
            PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(valueOf, format + "", 1, "mention");
            createNormalCfg.setStartFrom(12);
            createNormalCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }

    public final void v() {
        c.a.u0.p1.l.b.c.c cVar;
        e2 e2Var;
        MetaData J;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (cVar = this.n) == null || (e2Var = cVar.f20891f) == null) {
            return;
        }
        if (cVar.f20894i == 1 && e2Var.z1() != null) {
            J = e2Var.z1().t();
        } else {
            J = e2Var.J();
        }
        if (J == null || StringUtils.isNull(J.getName_show()) || StringUtils.isNull(J.getUserId())) {
            return;
        }
        long g2 = c.a.d.f.m.b.g(J.getUserId(), 0L);
        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(g2, g2 == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), J.isBigV(), e2Var.u1() != null, PersonPolymericActivityConfig.VIDEO_PERSON_FROM_TOPIC_DETAIL);
        createNormalConfig.setSourceTid(e2Var.w1());
        createNormalConfig.setSourceNid(e2Var.H0());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.u0.g0.b
    /* renamed from: w */
    public void k(c.a.u0.p1.l.b.c.c cVar) {
        String name_show;
        String formatTime;
        int W0;
        AgreeData B;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) || cVar == null || cVar.f20891f == null) {
            return;
        }
        this.n = cVar;
        l(this.m, TbadkCoreApplication.getInst().getSkinType());
        e2 e2Var = this.n.f20891f;
        PostData z1 = e2Var.z1();
        if (z1 == null) {
            return;
        }
        this.o.setPlaceHolder(1);
        if (this.n.f20894i == 1) {
            this.o.setData(e2Var, false, true);
        } else {
            this.o.setData(e2Var, false, false);
        }
        this.o.setIsRound(true);
        this.o.setBorderWidth(2);
        this.o.setDrawBorder(true);
        this.o.setPageId(this.m.getUniqueId());
        if (this.n.f20895j) {
            this.q.setVisibility(0);
            int i2 = this.n.f20893h;
            if (i2 == 1) {
                this.q.setImageResource(R.drawable.label_topic_agree_red);
                this.o.setBorderColor(this.m.getPageActivity().getResources().getColor(R.color.CAM_X0301));
            } else if (i2 == 2) {
                this.q.setImageResource(R.drawable.label_topic_disagree_blue);
                this.o.setBorderColor(this.m.getPageActivity().getResources().getColor(R.color.CAM_X0302));
            } else {
                this.q.setImageResource(R.drawable.label_topic_eat_black);
                this.o.setBorderColor(this.m.getPageActivity().getResources().getColor(R.color.CAM_X0106));
            }
        } else {
            this.q.setVisibility(8);
        }
        if (this.n.f20894i == 1) {
            name_show = z1.t().getName_show();
            formatTime = StringHelper.getFormatTime(z1.V());
            W0 = z1.R();
        } else {
            name_show = e2Var.J().getName_show();
            formatTime = StringHelper.getFormatTime(e2Var.P());
            W0 = e2Var.W0();
        }
        if (!StringUtils.isNull(name_show)) {
            this.p.setText(StringHelper.cutChineseAndEnglishWithSuffix(name_show, 14, "..."));
        }
        if (StringUtils.isNull(e2Var.b0())) {
            this.r.setText(formatTime);
        } else {
            this.r.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), StringHelper.cutChineseAndEnglishWithSuffix(e2Var.b0(), 10, "..."), formatTime));
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.u, R.drawable.icon_pure_topic_reply16_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        String numFormatOverWan = StringHelper.numFormatOverWan(W0);
        if (W0 > 0) {
            this.t.setVisibility(0);
            this.t.setText(numFormatOverWan);
        } else {
            this.t.setText(this.m.getString(R.string.action_comment_default));
            this.t.setVisibility(0);
        }
        if (this.n.f20894i == 1) {
            B = z1.q();
            B.objType = 1;
        } else {
            B = e2Var.B();
            B.objType = 3;
        }
        B.threadId = e2Var.w1();
        this.s.setData(B);
        this.s.setTopicId(String.valueOf(this.n.f20892g));
        y(z1, e2Var);
        x(cVar, e2Var);
        C(h());
    }

    public final void x(c.a.u0.p1.l.b.c.c cVar, e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, cVar, e2Var) == null) {
            if (this.n.f20894i == 1) {
                this.y.setVisibility(0);
                this.x.setVisibility(8);
                String title = e2Var.getTitle();
                if (StringUtils.isNull(title)) {
                    this.y.setVisibility(8);
                    return;
                }
                this.y.setVisibility(0);
                this.A.setText(title);
                String str = null;
                if (ListUtils.getCount(e2Var.G0()) != 0 && !ListUtils.isEmpty(cVar.f20891f.G0())) {
                    Iterator<MediaData> it = cVar.f20891f.G0().iterator();
                    while (it.hasNext()) {
                        MediaData next = it.next();
                        if (next != null && next.getType() == 3) {
                            str = next.getPicUrl();
                            if (StringUtils.isNull(str)) {
                                str = next.getSmallUrl();
                            }
                            if (StringUtils.isNull(str)) {
                                str = next.getThumbnails_url();
                            }
                            if (StringUtils.isNull(str)) {
                                str = next.getSrc_pic();
                            }
                            if (!StringUtils.isNull(str)) {
                                break;
                            }
                        }
                    }
                }
                if (StringUtils.isNull(str)) {
                    SkinManager.setImageResource(this.z, R.drawable.pic_frs_topic_shareinone);
                    return;
                }
                this.z.setPlaceHolder(1);
                this.z.startLoad(str, 10, false);
                return;
            }
            this.y.setVisibility(8);
            this.x.setVisibility(0);
            B(cVar);
        }
    }

    public final void y(PostData postData, e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, postData, e2Var) == null) {
            if (this.n.f20894i == 1) {
                this.v.setVisibility(0);
                this.v.setText(postData.N());
                return;
            }
            List<PbContent> W = e2Var.W();
            if (ListUtils.getCount(W) > 0) {
                this.v.setVisibility(0);
                this.v.setText(TbRichTextView.parser(W, false, e2Var));
                return;
            }
            SpannableString Q2 = e2Var.Q2();
            if (Q2 != null && !StringUtils.isNull(Q2.toString())) {
                this.v.setVisibility(0);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "0");
                    jSONObject.put("text", Q2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                this.v.setText(TbRichTextView.parse(jSONArray, false));
                return;
            }
            this.v.setVisibility(8);
        }
    }

    public void z(c.a.d.f.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) || (constrainImageGroup = this.w) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(bVar);
    }
}

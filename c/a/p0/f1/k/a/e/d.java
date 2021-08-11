package c.a.p0.f1.k.a.e;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.o0.s.k;
import c.a.o0.s.q.c2;
import c.a.p0.a0.m;
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
/* loaded from: classes3.dex */
public class d extends c.a.p0.a0.b<c.a.p0.f1.k.a.c.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public View B;
    public boolean C;
    public int D;
    public TbPageContext m;
    public c.a.p0.f1.k.a.c.c n;
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

    /* loaded from: classes3.dex */
    public class a implements c.a.o0.d1.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LinkedList f17658a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c2 f17659b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f17660c;

        public a(d dVar, LinkedList linkedList, c2 c2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, linkedList, c2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17660c = dVar;
            this.f17658a = linkedList;
            this.f17659b = c2Var;
        }

        @Override // c.a.o0.d1.j.d
        public void a(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                if (z) {
                    this.f17660c.t();
                } else {
                    this.f17660c.J(view, this.f17658a, i2, this.f17659b);
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

    public void A(c.a.e.e.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || (constrainImageGroup = this.w) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(bVar);
    }

    public final void B(c.a.p0.f1.k.a.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            c2 c2Var = cVar.f17621f;
            ArrayList<MediaData> C0 = c2Var.C0();
            if (k.c().g() && ListUtils.getCount(C0) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < C0.size(); i2++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(C0, i2);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (ListUtils.getCount(linkedList) > 0) {
                    this.x.setVisibility(0);
                    this.w.setFromCDN(this.C);
                    this.w.setImageClickListener(new a(this, linkedList, c2Var));
                    this.w.setImageMediaList(linkedList);
                    return;
                }
                this.x.setVisibility(8);
                return;
            }
            this.x.setVisibility(8);
        }
    }

    public final void D(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            n(bdUniqueId);
            ConstrainImageGroup constrainImageGroup = this.w;
            if (constrainImageGroup != null) {
                constrainImageGroup.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public final void J(View view, List<MediaData> list, int i2, c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048579, this, view, list, i2, c2Var) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                l.L(this.f14946f.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
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
                        imageUrlData.threadId = c.a.e.e.m.b.f(c2Var.q1(), -1L);
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
            bVar.z(c2Var.Z());
            bVar.y(String.valueOf(c2Var.T()));
            bVar.O(c2Var.q1());
            bVar.C(this.C);
            bVar.J(arrayList.size() > 0 ? arrayList.get(0) : "");
            bVar.F(true);
            bVar.w(concurrentHashMap);
            bVar.H(true);
            bVar.N(c2Var);
            bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig v = bVar.v(this.f14946f.getPageActivity());
            if (this.l == 2) {
                v.getIntent().putExtra("from", "index");
            } else {
                v.getIntent().putExtra("from", "other");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.f14946f;
            historyMessage.threadId = c2Var.f0();
            historyMessage.threadName = c2Var.getTitle();
            historyMessage.forumName = c2Var.Z();
            historyMessage.postID = c2Var.W();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    @Override // c.a.p0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.topic_discuss_view : invokeV.intValue;
    }

    @Override // c.a.p0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i2) == null) || this.D == i2 || this.n == null) {
            return;
        }
        this.D = i2;
        this.o.setIsNight(i2 == 1);
        c.a.p0.f1.k.a.c.c cVar = this.n;
        if (cVar.f17625j) {
            int i3 = cVar.f17623h;
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
        SkinManager.setBackgroundShapeDrawable(this.y, l.g(this.m.getPageActivity(), R.dimen.tbds6), R.color.CAM_X0209, R.color.cp_bg_line_j_alpha50);
        SkinManager.setViewTextColor(this.A, R.color.CAM_X0109);
        this.w.onChangeSkinType();
        SkinManager.setBackgroundColor(this.B, R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.p0.f1.k.a.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || (cVar = this.n) == null || cVar.f17621f == null) {
            return;
        }
        if (view == this.v) {
            if (cVar.f17624i == 1) {
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
        if (this.n.f17624i == 1) {
            u();
        } else {
            t();
        }
        q("3");
    }

    public final void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            TiebaStatic.log(new StatisticItem("c13356").param("obj_locate", str).param("tid", this.n.f17621f.q1()).param("topic_id", this.n.f17622g).param("obj_type", String.valueOf(this.n.f17624i)));
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
            c.a.o0.d1.m.a aVar = new c.a.o0.d1.m.a();
            aVar.v(l.g(d(), R.dimen.tbds44));
            aVar.o(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
            this.v.setLayoutStrategy(aVar);
            this.x = (RelativeLayout) j2.findViewById(R.id.topic_detail_img_container);
            this.w = (ConstrainImageGroup) j2.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
            this.w.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
            c.a.o0.d1.j.a aVar2 = new c.a.o0.d1.j.a(3);
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
            tbImageView.setRadius(l.g(d(), R.dimen.tbds6));
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
        c.a.p0.f1.k.a.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (cVar = this.n) == null || cVar.f17621f == null) {
            return;
        }
        PbActivityConfig addLocateParam = new PbActivityConfig(this.m.getPageActivity()).createFromThreadCfg(this.n.f17621f, null, "none", 18003, true, false, false).addLocateParam(null);
        addLocateParam.setForumId(String.valueOf(this.n.f17621f.T()));
        addLocateParam.setFrom("from_personalize");
        addLocateParam.setForumName(this.n.f17621f.Z());
        addLocateParam.setStartFrom(this.l);
        addLocateParam.setJumpGodReply(false);
        addLocateParam.setJumpToCommentArea(true);
        m.a(this.n.f17621f.q1());
        this.f14946f.sendMessage(new CustomMessage(2004001, addLocateParam));
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            String format = String.format("%1$s", this.n.f17621f.t1().E());
            String valueOf = String.valueOf(this.n.f17621f.q1());
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.m.getPageActivity());
            PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(valueOf, format + "", 1, "mention");
            createNormalCfg.setStartFrom(12);
            createNormalCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }

    public final void v() {
        c.a.p0.f1.k.a.c.c cVar;
        c2 c2Var;
        MetaData J;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (cVar = this.n) == null || (c2Var = cVar.f17621f) == null) {
            return;
        }
        if (cVar.f17624i == 1 && c2Var.t1() != null) {
            J = c2Var.t1().t();
        } else {
            J = c2Var.J();
        }
        if (J == null || StringUtils.isNull(J.getName_show()) || StringUtils.isNull(J.getUserId())) {
            return;
        }
        long f2 = c.a.e.e.m.b.f(J.getUserId(), 0L);
        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(d()).createNormalConfig(f2, f2 == c.a.e.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), J.isBigV());
        createNormalConfig.setSourceTid(c2Var.q1());
        createNormalConfig.setSourceNid(c2Var.D0());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a0.b
    /* renamed from: w */
    public void k(c.a.p0.f1.k.a.c.c cVar) {
        String name_show;
        String formatTime;
        int S0;
        AgreeData B;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) || cVar == null || cVar.f17621f == null) {
            return;
        }
        this.n = cVar;
        l(this.m, TbadkCoreApplication.getInst().getSkinType());
        c2 c2Var = this.n.f17621f;
        PostData t1 = c2Var.t1();
        if (t1 == null) {
            return;
        }
        this.o.setPlaceHolder(1);
        if (this.n.f17624i == 1) {
            this.o.setData(c2Var, false, true);
        } else {
            this.o.setData(c2Var, false, false);
        }
        this.o.setIsRound(true);
        this.o.setBorderWidth(2);
        this.o.setDrawBorder(true);
        this.o.setPageId(this.m.getUniqueId());
        if (this.n.f17625j) {
            this.q.setVisibility(0);
            int i2 = this.n.f17623h;
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
        if (this.n.f17624i == 1) {
            name_show = t1.t().getName_show();
            formatTime = StringHelper.getFormatTime(t1.R());
            S0 = t1.N();
        } else {
            name_show = c2Var.J().getName_show();
            formatTime = StringHelper.getFormatTime(c2Var.P());
            S0 = c2Var.S0();
        }
        if (!StringUtils.isNull(name_show)) {
            this.p.setText(StringHelper.cutChineseAndEnglishWithSuffix(name_show, 14, "..."));
        }
        if (StringUtils.isNull(c2Var.Z())) {
            this.r.setText(formatTime);
        } else {
            this.r.setText(String.format(d().getString(R.string.daily_topic_discuss_forum_name), StringHelper.cutChineseAndEnglishWithSuffix(c2Var.Z(), 10, "..."), formatTime));
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.u, R.drawable.icon_pure_topic_reply16_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        String numFormatOverWan = StringHelper.numFormatOverWan(S0);
        if (S0 > 0) {
            this.t.setVisibility(0);
            this.t.setText(numFormatOverWan);
        } else {
            this.t.setText(this.m.getString(R.string.action_comment_default));
            this.t.setVisibility(0);
        }
        if (this.n.f17624i == 1) {
            B = t1.q();
            B.objType = 1;
        } else {
            B = c2Var.B();
            B.objType = 3;
        }
        B.threadId = c2Var.q1();
        this.s.setData(B);
        this.s.setTopicId(String.valueOf(this.n.f17622g));
        y(t1, c2Var);
        x(cVar, c2Var);
        D(h());
    }

    public final void x(c.a.p0.f1.k.a.c.c cVar, c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, cVar, c2Var) == null) {
            if (this.n.f17624i == 1) {
                this.y.setVisibility(0);
                this.x.setVisibility(8);
                String title = c2Var.getTitle();
                if (StringUtils.isNull(title)) {
                    this.y.setVisibility(8);
                    return;
                }
                this.y.setVisibility(0);
                this.A.setText(title);
                String str = null;
                if (ListUtils.getCount(c2Var.C0()) != 0 && !ListUtils.isEmpty(cVar.f17621f.C0())) {
                    Iterator<MediaData> it = cVar.f17621f.C0().iterator();
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

    public final void y(PostData postData, c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, postData, c2Var) == null) {
            if (this.n.f17624i == 1) {
                this.v.setVisibility(0);
                this.v.setText(postData.K());
                return;
            }
            List<PbContent> V = c2Var.V();
            if (ListUtils.getCount(V) > 0) {
                this.v.setVisibility(0);
                this.v.setText(TbRichTextView.parser(d(), V, false));
                return;
            }
            SpannableString G2 = c2Var.G2();
            if (G2 != null && !StringUtils.isNull(G2.toString())) {
                this.v.setVisibility(0);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "0");
                    jSONObject.put("text", G2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                this.v.setText(TbRichTextView.parse(d(), jSONArray, false));
                return;
            }
            this.v.setVisibility(8);
        }
    }

    public void z(c.a.e.e.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) || (constrainImageGroup = this.w) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(bVar);
    }
}

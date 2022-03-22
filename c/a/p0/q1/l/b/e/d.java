package c.a.p0.q1.l.b.e;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.l;
import c.a.p0.h0.m;
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
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class d extends c.a.p0.h0.b<c.a.p0.q1.l.b.c.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public c.a.p0.q1.l.b.c.c j;
    public ClickableHeaderImageView k;
    public TextView l;
    public ImageView m;
    public TextView n;
    public AgreeView o;
    public TextView p;
    public ImageView q;
    public TbRichTextView r;
    public ConstrainImageGroup s;
    public RelativeLayout t;
    public View u;
    public TbImageView v;
    public TextView w;
    public View x;
    public boolean y;
    public int z;

    /* loaded from: classes2.dex */
    public class a implements c.a.o0.e1.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkedList a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ThreadData f17587b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f17588c;

        public a(d dVar, LinkedList linkedList, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, linkedList, threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17588c = dVar;
            this.a = linkedList;
            this.f17587b = threadData;
        }

        @Override // c.a.o0.e1.j.d
        public void a(View view, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                if (z) {
                    this.f17588c.u();
                } else {
                    this.f17588c.E(view, this.a, i, this.f17587b);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.y = true;
        this.z = 3;
        this.i = tbPageContext;
        t();
    }

    public void A(c.a.d.f.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || (constrainImageGroup = this.s) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(bVar);
    }

    public void B(c.a.d.f.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || (constrainImageGroup = this.s) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(bVar);
    }

    public final void C(c.a.p0.q1.l.b.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            ThreadData threadData = cVar.f17559b;
            ArrayList<MediaData> medias = threadData.getMedias();
            if (l.c().g() && ListUtils.getCount(medias) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < medias.size(); i++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(medias, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (ListUtils.getCount(linkedList) > 0) {
                    this.t.setVisibility(0);
                    this.s.setFromCDN(this.y);
                    this.s.setImageClickListener(new a(this, linkedList, threadData));
                    this.s.setImageMediaList(linkedList);
                    return;
                }
                this.t.setVisibility(8);
                return;
            }
            this.t.setVisibility(8);
        }
    }

    public final void D(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            o(bdUniqueId);
            ConstrainImageGroup constrainImageGroup = this.s;
            if (constrainImageGroup != null) {
                constrainImageGroup.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public final void E(View view, List<MediaData> list, int i, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048580, this, view, list, i, threadData) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                n.M(this.f15304b.getPageActivity(), R.string.obfuscated_res_0x7f0f0e63);
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
            for (MediaData mediaData : list) {
                if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                    arrayList.add(mediaData.getSrc_pic());
                    if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = this.y ? 13 : 14;
                        imageUrlData.imageUrl = mediaData.getPicUrl();
                        imageUrlData.originalUrl = mediaData.getOriginalUrl();
                        imageUrlData.originalSize = mediaData.getOriginalSize();
                        imageUrlData.isLongPic = mediaData.isLongPic();
                        imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                        imageUrlData.threadId = c.a.d.f.m.b.g(threadData.getTid(), -1L);
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
            bVar.B(i);
            bVar.z(threadData.getForum_name());
            bVar.y(String.valueOf(threadData.getFid()));
            bVar.O(threadData.getTid());
            bVar.C(this.y);
            bVar.J(arrayList.size() > 0 ? arrayList.get(0) : "");
            bVar.F(true);
            bVar.w(concurrentHashMap);
            bVar.H(true);
            bVar.N(threadData);
            bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig v = bVar.v(this.f15304b.getPageActivity());
            if (this.f15310h == 2) {
                v.getIntent().putExtra("from", "index");
            } else {
                v.getIntent().putExtra("from", "other");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.f15304b;
            historyMessage.threadId = threadData.getId();
            historyMessage.threadName = threadData.getTitle();
            historyMessage.forumName = threadData.getForum_name();
            historyMessage.postID = threadData.getFirstPostId();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? R.layout.obfuscated_res_0x7f0d0845 : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) || this.z == i || this.j == null) {
            return;
        }
        this.z = i;
        this.k.setSkinType(i);
        c.a.p0.q1.l.b.c.c cVar = this.j;
        if (cVar.f17563f) {
            int i2 = cVar.f17561d;
            if (i2 == 1) {
                SkinManager.setImageResource(this.m, R.drawable.label_topic_agree_red);
                this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0301));
            } else if (i2 == 2) {
                SkinManager.setImageResource(this.m, R.drawable.label_topic_disagree_blue);
                this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0302));
            } else {
                SkinManager.setImageResource(this.m, R.drawable.label_topic_eat_black);
                this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0106));
            }
        }
        SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0107);
        if (this.q != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.obfuscated_res_0x7f0809ca, R.color.CAM_X0107, null);
        }
        this.o.v(i);
        this.r.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        SkinManager.setBackgroundShapeDrawable(this.u, n.f(this.i.getPageActivity(), R.dimen.tbds6), R.color.CAM_X0209, R.color.cp_bg_line_j_alpha50);
        SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0109);
        this.s.b();
        SkinManager.setBackgroundColor(this.x, R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.p0.q1.l.b.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) || (cVar = this.j) == null || cVar.f17559b == null) {
            return;
        }
        if (view == this.r) {
            if (cVar.f17562e == 1) {
                v();
            } else {
                u();
            }
            s("1");
        }
        if (view != this.p && view != this.q) {
            if (view == this.l) {
                w();
                return;
            }
            u();
            s("2");
            return;
        }
        if (this.j.f17562e == 1) {
            v();
        } else {
            u();
        }
        s("3");
    }

    public final void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            TiebaStatic.log(new StatisticItem("c13356").param("obj_locate", str).param("tid", this.j.f17559b.getTid()).param("topic_id", this.j.f17560c).param("obj_type", String.valueOf(this.j.f17562e)));
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            View k = k();
            this.k = (ClickableHeaderImageView) k.findViewById(R.id.obfuscated_res_0x7f09057b);
            this.m = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f09057f);
            this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09057c);
            this.n = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090579);
            TbRichTextView tbRichTextView = (TbRichTextView) k.findViewById(R.id.obfuscated_res_0x7f09057d);
            this.r = tbRichTextView;
            tbRichTextView.setClickable(true);
            this.r.setTextEllipsize(TextUtils.TruncateAt.END);
            this.r.setMaxLines(2);
            c.a.o0.e1.n.a aVar = new c.a.o0.e1.n.a();
            aVar.v(n.f(getContext(), R.dimen.tbds44));
            aVar.o(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
            this.r.setLayoutStrategy(aVar);
            this.t = (RelativeLayout) k.findViewById(R.id.obfuscated_res_0x7f0920e8);
            this.s = (ConstrainImageGroup) k.findViewById(R.id.obfuscated_res_0x7f09057a);
            this.s.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
            c.a.o0.e1.j.a aVar2 = new c.a.o0.e1.j.a(3);
            aVar2.d(1.0d);
            this.s.setImageProcessor(aVar2);
            AgreeView agreeView = (AgreeView) k.findViewById(R.id.obfuscated_res_0x7f090576);
            this.o = agreeView;
            agreeView.j();
            this.p = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0920da);
            this.q = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f0920db);
            this.u = k.findViewById(R.id.obfuscated_res_0x7f090578);
            TbImageView tbImageView = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f090581);
            this.v = tbImageView;
            tbImageView.setRadius(n.f(getContext(), R.dimen.tbds6));
            this.v.setConrers(5);
            this.v.setDrawCorner(true);
            this.w = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090582);
            this.x = k.findViewById(R.id.obfuscated_res_0x7f090577);
            this.l.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.w.setOnClickListener(this);
        }
    }

    public void u() {
        c.a.p0.q1.l.b.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (cVar = this.j) == null || cVar.f17559b == null) {
            return;
        }
        PbActivityConfig addLocateParam = new PbActivityConfig(this.i.getPageActivity()).createFromThreadCfg(this.j.f17559b, null, "none", 18003, true, false, false).addLocateParam(null);
        addLocateParam.setForumId(String.valueOf(this.j.f17559b.getFid()));
        addLocateParam.setFrom("from_personalize");
        addLocateParam.setForumName(this.j.f17559b.getForum_name());
        addLocateParam.setStartFrom(this.f15310h);
        addLocateParam.setJumpGodReply(false);
        addLocateParam.setJumpToCommentArea(true);
        m.a(this.j.f17559b.getTid());
        this.f15304b.sendMessage(new CustomMessage(2004001, addLocateParam));
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String format = String.format("%1$s", this.j.f17559b.getTopAgreePost().G());
            String valueOf = String.valueOf(this.j.f17559b.getTid());
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.i.getPageActivity());
            PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(valueOf, format + "", 1, "mention");
            createNormalCfg.setStartFrom(12);
            createNormalCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }

    public final void w() {
        c.a.p0.q1.l.b.c.c cVar;
        ThreadData threadData;
        MetaData author;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (cVar = this.j) == null || (threadData = cVar.f17559b) == null) {
            return;
        }
        if (cVar.f17562e == 1 && threadData.getTopAgreePost() != null) {
            author = threadData.getTopAgreePost().s();
        } else {
            author = threadData.getAuthor();
        }
        if (author == null || StringUtils.isNull(author.getName_show()) || StringUtils.isNull(author.getUserId())) {
            return;
        }
        long g2 = c.a.d.f.m.b.g(author.getUserId(), 0L);
        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(g2, g2 == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), author.isBigV(), threadData.getThreadVideoInfo() != null, PersonPolymericActivityConfig.VIDEO_PERSON_FROM_TOPIC_DETAIL);
        createNormalConfig.setSourceTid(threadData.getTid());
        createNormalConfig.setSourceNid(threadData.getNid());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: x */
    public void l(c.a.p0.q1.l.b.c.c cVar) {
        String name_show;
        String formatTime;
        int reply_num;
        AgreeData agreeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) || cVar == null || cVar.f17559b == null) {
            return;
        }
        this.j = cVar;
        m(this.i, TbadkCoreApplication.getInst().getSkinType());
        ThreadData threadData = this.j.f17559b;
        PostData topAgreePost = threadData.getTopAgreePost();
        if (topAgreePost == null) {
            return;
        }
        this.k.setPlaceHolder(1);
        if (this.j.f17562e == 1) {
            this.k.setData(threadData, false, true);
        } else {
            this.k.setData(threadData, false, false);
        }
        this.k.setIsRound(true);
        this.k.setBorderWidth(2);
        this.k.setDrawBorder(true);
        this.k.setPageId(this.i.getUniqueId());
        if (this.j.f17563f) {
            this.m.setVisibility(0);
            int i = this.j.f17561d;
            if (i == 1) {
                this.m.setImageResource(R.drawable.label_topic_agree_red);
                this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0301));
            } else if (i == 2) {
                this.m.setImageResource(R.drawable.label_topic_disagree_blue);
                this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0302));
            } else {
                this.m.setImageResource(R.drawable.label_topic_eat_black);
                this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0106));
            }
        } else {
            this.m.setVisibility(8);
        }
        if (this.j.f17562e == 1) {
            name_show = topAgreePost.s().getName_show();
            formatTime = StringHelper.getFormatTime(topAgreePost.V());
            reply_num = topAgreePost.R();
        } else {
            name_show = threadData.getAuthor().getName_show();
            formatTime = StringHelper.getFormatTime(threadData.getCreateTime());
            reply_num = threadData.getReply_num();
        }
        if (!StringUtils.isNull(name_show)) {
            this.l.setText(StringHelper.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
        }
        if (StringUtils.isNull(threadData.getForum_name())) {
            this.n.setText(formatTime);
        } else {
            this.n.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0468), StringHelper.cutChineseAndEnglishWithSuffix(threadData.getForum_name(), 10, StringHelper.STRING_MORE), formatTime));
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.obfuscated_res_0x7f0809ca, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        String numFormatOverWan = StringHelper.numFormatOverWan(reply_num);
        if (reply_num > 0) {
            this.p.setVisibility(0);
            this.p.setText(numFormatOverWan);
        } else {
            this.p.setText(this.i.getString(R.string.obfuscated_res_0x7f0f0084));
            this.p.setVisibility(0);
        }
        if (this.j.f17562e == 1) {
            agreeData = topAgreePost.q();
            agreeData.objType = 1;
        } else {
            agreeData = threadData.getAgreeData();
            agreeData.objType = 3;
        }
        agreeData.threadId = threadData.getTid();
        this.o.setData(agreeData);
        this.o.setTopicId(String.valueOf(this.j.f17560c));
        z(topAgreePost, threadData);
        y(cVar, threadData);
        D(i());
    }

    public final void y(c.a.p0.q1.l.b.c.c cVar, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, cVar, threadData) == null) {
            if (this.j.f17562e == 1) {
                this.u.setVisibility(0);
                this.t.setVisibility(8);
                String title = threadData.getTitle();
                if (StringUtils.isNull(title)) {
                    this.u.setVisibility(8);
                    return;
                }
                this.u.setVisibility(0);
                this.w.setText(title);
                String str = null;
                if (ListUtils.getCount(threadData.getMedias()) != 0 && !ListUtils.isEmpty(cVar.f17559b.getMedias())) {
                    Iterator<MediaData> it = cVar.f17559b.getMedias().iterator();
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
                    SkinManager.setImageResource(this.v, R.drawable.pic_frs_topic_shareinone);
                    return;
                }
                this.v.setPlaceHolder(1);
                this.v.J(str, 10, false);
                return;
            }
            this.u.setVisibility(8);
            this.t.setVisibility(0);
            C(cVar);
        }
    }

    public final void z(PostData postData, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, postData, threadData) == null) {
            if (this.j.f17562e == 1) {
                this.r.setVisibility(0);
                this.r.setText(postData.N());
                return;
            }
            List<PbContent> firstFloorList = threadData.getFirstFloorList();
            if (ListUtils.getCount(firstFloorList) > 0) {
                this.r.setVisibility(0);
                this.r.setText(TbRichTextView.Y(firstFloorList, false, threadData));
                return;
            }
            SpannableString parseAbstract = threadData.parseAbstract();
            if (parseAbstract != null && !StringUtils.isNull(parseAbstract.toString())) {
                this.r.setVisibility(0);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "0");
                    jSONObject.put("text", parseAbstract);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                this.r.setText(TbRichTextView.U(jSONArray, false));
                return;
            }
            this.r.setVisibility(8);
        }
    }
}

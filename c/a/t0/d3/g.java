package c.a.t0.d3;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
import c.a.t0.d3.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.ReplyLinearLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class g extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PersonPostModel.c f17065e;

    /* renamed from: f  reason: collision with root package name */
    public PersonPostModel f17066f;

    /* renamed from: g  reason: collision with root package name */
    public final String f17067g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f17068h;

    /* renamed from: i  reason: collision with root package name */
    public String f17069i;

    /* renamed from: j  reason: collision with root package name */
    public TbPageContext<BaseFragmentActivity> f17070j;
    public final PersonPostModel.c k;
    public final a.InterfaceC1081a l;

    /* loaded from: classes7.dex */
    public class a implements PersonPostModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f17071e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17071e = gVar;
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
        public void onResult(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, personPostModel, z) == null) {
                if (z) {
                    this.f17071e.f17066f = personPostModel;
                    Iterator<n> it = this.f17071e.f17066f.postList.iterator();
                    while (it.hasNext()) {
                        n next = it.next();
                        if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                            it.remove();
                        }
                    }
                } else if (this.f17071e.f17066f != null) {
                    for (int i2 = 0; i2 < personPostModel.postList.size(); i2++) {
                        if (personPostModel.postList.get(i2) instanceof PersonPostModel.PostInfoList) {
                            this.f17071e.f17066f.postList.add(personPostModel.postList.get(i2));
                        }
                    }
                }
                if (this.f17071e.f17065e != null) {
                    this.f17071e.f17065e.onResult(personPostModel, z);
                }
                this.f17071e.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.InterfaceC1081a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // c.a.t0.d3.a.InterfaceC1081a
        public void a(View view) {
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                if (id == c.a.t0.y2.d.portrait) {
                    ((BaseFragmentActivity) this.a.f17070j.getOrignalPage()).finish();
                } else if (id == c.a.t0.y2.d.username) {
                    ((BaseFragmentActivity) this.a.f17070j.getOrignalPage()).finish();
                } else if ((id == c.a.t0.y2.d.item_header || id == c.a.t0.y2.d.original_post_title || id == c.a.t0.y2.d.item_footer || id == c.a.t0.y2.d.reply_count) && (strArr = (String[]) view.getTag()) != null) {
                    if (!"0".equals(strArr[2]) && strArr[1] != null) {
                        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(this.a.f17070j.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                        createSubPbActivityConfig.setKeyPageStartFrom(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                        return;
                    }
                    PbActivityConfig createNormalCfg = new PbActivityConfig(this.a.f17070j.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                }
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes7.dex */
    public static class c extends c.a.t0.d3.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ReplyLinearLayout v;
        public TextView w;
        public View x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], (TbPageContext) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.x = view.findViewById(c.a.t0.y2.d.person_child);
            this.m.setIsRound(true);
            ReplyLinearLayout replyLinearLayout = (ReplyLinearLayout) view.findViewById(c.a.t0.y2.d.content_container);
            this.v = replyLinearLayout;
            replyLinearLayout.setPageContext(tbPageContext);
            TextView textView = (TextView) view.findViewById(c.a.t0.y2.d.original_post_title);
            this.w = textView;
            textView.setOnClickListener(this);
            this.f17060i.setVisibility(8);
        }

        @Override // c.a.t0.d3.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                super.a(i2);
                c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.w);
                d2.v(c.a.t0.y2.a.CAM_X0107);
                d2.n(c.a.t0.y2.g.J_X05);
                d2.f(c.a.t0.y2.a.CAM_X0206);
                c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(this.x);
                d3.n(c.a.t0.y2.g.J_X05);
                d3.f(c.a.t0.y2.a.CAM_X0201);
            }
        }
    }

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, str2, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new a(this);
        this.l = new b(this);
        this.f17070j = tbPageContext;
        this.f17067g = str;
        this.f17068h = bdUniqueId;
    }

    public void e() {
        PersonPostModel personPostModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (personPostModel = this.f17066f) == null) {
            return;
        }
        personPostModel.cancelLoadData();
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (this.f17066f == null) {
                PersonPostModel personPostModel = new PersonPostModel(this.f17070j, this.f17068h, null, true, PersonPostModel.FROM_PERSON_POST);
                this.f17066f = personPostModel;
                personPostModel.setUniqueId(this.f17068h);
            }
            this.f17066f.fetchPost(this.f17070j, this.k, z, this.f17067g, false, true, false, null);
        }
    }

    public final void g(int i2, c cVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, cVar, viewGroup) == null) {
            PersonPostModel.PostInfoList h2 = h(i2);
            if (this.f17069i == null) {
                this.f17069i = h2.user_portrait;
            }
            cVar.d(h2, false, this.f17069i);
            ArrayList<String[]> arrayList = new ArrayList<>();
            int length = h2.content.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (h2.content[i3].post_content.length != 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (!h2.content[i3].post_content[0].text.startsWith("回复 ")) {
                        stringBuffer.append("回复：");
                    }
                    int length2 = h2.content[i3].post_content.length;
                    for (int i4 = 0; i4 < length2; i4++) {
                        stringBuffer.append(h2.content[i3].post_content[i4].text);
                    }
                    arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(h2.thread_id), String.valueOf(h2.content[i3].post_id), String.valueOf(h2.content[i3].post_type), StringHelper.getFormatTime(h2.content[i3].create_time * 1000) + (h2.content[i3].is_author_view == 1 ? " " + viewGroup.getContext().getString(c.a.t0.y2.g.not_open_read) : ""), String.valueOf(h2.thread_type)});
                }
            }
            cVar.v.setPost(h2);
            cVar.v.setContent(arrayList);
            if (Pattern.compile("^回复：").matcher(h2.title).find()) {
                cVar.w.setText(h2.title.replaceFirst("回复：", "原贴："));
            } else {
                cVar.w.setText(h2.title);
            }
            OriginalThreadInfo originalThreadInfo = h2.originalThreadInfo;
            if (originalThreadInfo != null && !StringUtils.isNull(originalThreadInfo.f40128b)) {
                cVar.w.setText("分享：" + h2.originalThreadInfo.f40128b);
            }
            cVar.w.setTag(new String[]{String.valueOf(h2.thread_id), null, null, String.valueOf(h2.thread_type)});
            if (h2.thread_type == 33) {
                cVar.w.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(c.a.t0.y2.c.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                cVar.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            SkinManager.setBackgroundResource(cVar.w, c.a.t0.y2.c.person_post_line);
            SkinManager.setViewTextColor(cVar.w, c.a.t0.y2.a.common_color_10039, 1);
            int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(c.a.t0.y2.b.ds20);
            cVar.w.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            cVar.c(this.l);
            cVar.a(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PersonPostModel personPostModel = this.f17066f;
            if (personPostModel == null || (arrayList = personPostModel.postList) == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(c.a.t0.y2.e.person_post_item_reply, viewGroup, false);
                cVar = new c(view, this.f17070j);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            if (i2 == 0) {
                cVar.l.setVisibility(0);
            } else {
                cVar.l.setVisibility(8);
            }
            g(i2, cVar, viewGroup);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public PersonPostModel.PostInfoList h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? (PersonPostModel.PostInfoList) this.f17066f.postList.get(i2) : (PersonPostModel.PostInfoList) invokeI.objValue;
    }

    public void i(PersonPostModel.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f17065e = cVar;
        }
    }
}

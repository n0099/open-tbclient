package c.a.p0.f3;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.p0.f3.a;
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
import com.baidu.tieba.R;
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
/* loaded from: classes2.dex */
public class g extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonPostModel.c a;

    /* renamed from: b  reason: collision with root package name */
    public PersonPostModel f14953b;

    /* renamed from: c  reason: collision with root package name */
    public final String f14954c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f14955d;

    /* renamed from: e  reason: collision with root package name */
    public String f14956e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<BaseFragmentActivity> f14957f;

    /* renamed from: g  reason: collision with root package name */
    public final PersonPostModel.c f14958g;

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC1131a f14959h;

    /* loaded from: classes2.dex */
    public class a implements PersonPostModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
        public void I(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, personPostModel, z) == null) {
                if (z) {
                    this.a.f14953b = personPostModel;
                    Iterator<n> it = this.a.f14953b.postList.iterator();
                    while (it.hasNext()) {
                        n next = it.next();
                        if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                            it.remove();
                        }
                    }
                } else if (this.a.f14953b != null) {
                    for (int i = 0; i < personPostModel.postList.size(); i++) {
                        if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                            this.a.f14953b.postList.add(personPostModel.postList.get(i));
                        }
                    }
                }
                if (this.a.a != null) {
                    this.a.a.I(personPostModel, z);
                }
                this.a.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.InterfaceC1131a {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // c.a.p0.f3.a.InterfaceC1131a
        public void a(View view) {
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                if (id == R.id.obfuscated_res_0x7f0918a4) {
                    ((BaseFragmentActivity) this.a.f14957f.getOrignalPage()).finish();
                } else if (id == R.id.obfuscated_res_0x7f0922e5) {
                    ((BaseFragmentActivity) this.a.f14957f.getOrignalPage()).finish();
                } else if ((id == R.id.obfuscated_res_0x7f090f77 || id == R.id.obfuscated_res_0x7f09161e || id == R.id.obfuscated_res_0x7f090f6d || id == R.id.obfuscated_res_0x7f091a5c) && (strArr = (String[]) view.getTag()) != null) {
                    if (!"0".equals(strArr[2]) && strArr[1] != null) {
                        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(this.a.f14957f.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                        createSubPbActivityConfig.setKeyPageStartFrom(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                        return;
                    }
                    PbActivityConfig createNormalCfg = new PbActivityConfig(this.a.f14957f.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                }
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes2.dex */
    public static class c extends c.a.p0.f3.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ReplyLinearLayout r;
        public TextView s;
        public View t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], (TbPageContext) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.t = view.findViewById(R.id.obfuscated_res_0x7f0917a3);
            this.i.setIsRound(true);
            ReplyLinearLayout replyLinearLayout = (ReplyLinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0906df);
            this.r = replyLinearLayout;
            replyLinearLayout.setPageContext(tbPageContext);
            TextView textView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09161e);
            this.s = textView;
            textView.setOnClickListener(this);
            this.f14946e.setVisibility(8);
        }

        @Override // c.a.p0.f3.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                super.a(i);
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.s);
                d2.v(R.color.CAM_X0107);
                d2.n(R.string.J_X05);
                d2.f(R.color.CAM_X0206);
                c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.t);
                d3.n(R.string.J_X05);
                d3.f(R.color.CAM_X0201);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14958g = new a(this);
        this.f14959h = new b(this);
        this.f14957f = tbPageContext;
        this.f14954c = str;
        this.f14955d = bdUniqueId;
    }

    public void e() {
        PersonPostModel personPostModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (personPostModel = this.f14953b) == null) {
            return;
        }
        personPostModel.cancelLoadData();
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (this.f14953b == null) {
                PersonPostModel personPostModel = new PersonPostModel(this.f14957f, this.f14955d, null, true, PersonPostModel.FROM_PERSON_POST);
                this.f14953b = personPostModel;
                personPostModel.setUniqueId(this.f14955d);
            }
            this.f14953b.fetchPost(this.f14957f, this.f14958g, z, this.f14954c, false, true, false, null);
        }
    }

    public final void g(int i, c cVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, cVar, viewGroup) == null) {
            PersonPostModel.PostInfoList h2 = h(i);
            if (this.f14956e == null) {
                this.f14956e = h2.user_portrait;
            }
            cVar.d(h2, false, this.f14956e);
            ArrayList<String[]> arrayList = new ArrayList<>();
            int length = h2.content.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (h2.content[i2].post_content.length != 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (!h2.content[i2].post_content[0].text.startsWith("回复 ")) {
                        stringBuffer.append("回复：");
                    }
                    int length2 = h2.content[i2].post_content.length;
                    for (int i3 = 0; i3 < length2; i3++) {
                        stringBuffer.append(h2.content[i2].post_content[i3].text);
                    }
                    arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(h2.thread_id), String.valueOf(h2.content[i2].post_id), String.valueOf(h2.content[i2].post_type), StringHelper.getFormatTime(h2.content[i2].create_time * 1000) + (h2.content[i2].is_author_view == 1 ? " " + viewGroup.getContext().getString(R.string.obfuscated_res_0x7f0f0c79) : ""), String.valueOf(h2.thread_type)});
                }
            }
            cVar.r.setPost(h2);
            cVar.r.setContent(arrayList);
            if (Pattern.compile("^回复：").matcher(h2.title).find()) {
                cVar.s.setText(h2.title.replaceFirst("回复：", "原贴："));
            } else {
                cVar.s.setText(h2.title);
            }
            OriginalThreadInfo originalThreadInfo = h2.originalThreadInfo;
            if (originalThreadInfo != null && !StringUtils.isNull(originalThreadInfo.f29822b)) {
                cVar.s.setText("分享：" + h2.originalThreadInfo.f29822b);
            }
            cVar.s.setTag(new String[]{String.valueOf(h2.thread_id), null, null, String.valueOf(h2.thread_type)});
            if (h2.thread_type == 33) {
                cVar.s.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                cVar.s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            SkinManager.setBackgroundResource(cVar.s, R.drawable.person_post_line);
            SkinManager.setViewTextColor(cVar.s, R.color.common_color_10039, 1);
            int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
            cVar.s.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            cVar.c(this.f14959h);
            cVar.a(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PersonPostModel personPostModel = this.f14953b;
            if (personPostModel == null || (arrayList = personPostModel.postList) == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d06d9, viewGroup, false);
                cVar = new c(view, this.f14957f);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            if (i == 0) {
                cVar.f14949h.setVisibility(0);
            } else {
                cVar.f14949h.setVisibility(8);
            }
            g(i, cVar, viewGroup);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public PersonPostModel.PostInfoList h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? (PersonPostModel.PostInfoList) this.f14953b.postList.get(i) : (PersonPostModel.PostInfoList) invokeI.objValue;
    }

    public void i(PersonPostModel.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.a = cVar;
        }
    }
}

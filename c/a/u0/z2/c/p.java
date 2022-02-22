package c.a.u0.z2.c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.personPolymeric.PersonPolymericActivity;
import com.baidu.tieba.personPolymeric.holder.PersonCommentHolder;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class p extends c.a.d.o.e.a<PersonPostModel.PostInfoList, PersonCommentHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String m;
    public TbPageContext<PersonPolymericActivity> n;
    public boolean o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, PersonPostModel.PostInfoList postInfoList, PersonCommentHolder personCommentHolder) {
        a0(i2, view, viewGroup, postInfoList, personCommentHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: Z */
    public PersonCommentHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PersonCommentHolder(LayoutInflater.from(this.n.getPageActivity()).inflate(c.a.u0.a3.e.person_polymeric_item_reply, viewGroup, false), this.n, this.o) : (PersonCommentHolder) invokeL.objValue;
    }

    public View a0(int i2, View view, ViewGroup viewGroup, PersonPostModel.PostInfoList postInfoList, PersonCommentHolder personCommentHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postInfoList, personCommentHolder})) == null) {
            if (postInfoList != null && personCommentHolder != null) {
                if (this.m == null) {
                    this.m = postInfoList.user_portrait;
                }
                personCommentHolder.updateHolderWithData(postInfoList, false, this.m);
                ArrayList<String[]> arrayList = new ArrayList<>();
                int length = postInfoList.content.length;
                for (int i3 = 0; i3 < length; i3++) {
                    if (postInfoList.content[i3].post_content.length != 0) {
                        StringBuffer stringBuffer = new StringBuffer();
                        if (!postInfoList.content[i3].post_content[0].text.startsWith("回复 ")) {
                            stringBuffer.append("回复：");
                        }
                        int length2 = postInfoList.content[i3].post_content.length;
                        for (int i4 = 0; i4 < length2; i4++) {
                            stringBuffer.append(postInfoList.content[i3].post_content[i4].text);
                        }
                        arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(postInfoList.thread_id), String.valueOf(postInfoList.content[i3].post_id), String.valueOf(postInfoList.content[i3].post_type), StringHelper.getFormatTime(postInfoList.content[i3].create_time * 1000), String.valueOf(postInfoList.thread_type)});
                    }
                }
                personCommentHolder.mReplyContent.setContent(arrayList);
                if (Pattern.compile("^回复：").matcher(postInfoList.title).find()) {
                    personCommentHolder.mOriginalPostTitle.setText(postInfoList.title.replaceFirst("回复：", "原贴："));
                } else {
                    personCommentHolder.mOriginalPostTitle.setText(postInfoList.title);
                }
                personCommentHolder.mOriginalPostTitle.setTag(new String[]{String.valueOf(postInfoList.thread_id), null, null, String.valueOf(postInfoList.thread_type)});
                if (postInfoList.thread_type == 33) {
                    personCommentHolder.mOriginalPostTitle.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(c.a.u0.a3.c.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    personCommentHolder.mOriginalPostTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                SkinManager.setBackgroundResource(personCommentHolder.mOriginalPostTitle, c.a.u0.a3.c.person_post_line);
                SkinManager.setViewTextColor(personCommentHolder.mOriginalPostTitle, c.a.u0.a3.a.common_color_10039, 1);
                int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.u0.a3.b.ds20);
                personCommentHolder.mOriginalPostTitle.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                personCommentHolder.changeSkin(TbadkCoreApplication.getInst().getSkinType());
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.o = z;
        }
    }
}

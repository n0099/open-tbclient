package b.a.r0.j1.j;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.holder.RelateTopicForumItemHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class j extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<RelateForumItemData> f19692e;

    /* renamed from: f  reason: collision with root package name */
    public String f19693f;

    /* renamed from: g  reason: collision with root package name */
    public RelateTopicForumActivity f19694g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f19695h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f19696e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19696e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f19696e.f19694g != null && this.f19696e.f19694g.checkUpIsLogin() && view.getId() == b.a.r0.j1.e.forum_add_love && (intValue = ((Integer) view.getTag()).intValue()) >= 0) {
                RelateForumItemData relateForumItemData = (RelateForumItemData) this.f19696e.f19692e.get(intValue);
                if (relateForumItemData.forumId != 0) {
                    TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", b.a.r0.j1.l.k.f19803b).param("topic_id", this.f19696e.f19693f));
                }
                if (b.a.e.f.p.k.isForumName(relateForumItemData.forumName)) {
                    this.f19696e.f19694g.likeModel.L(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
                }
            }
        }
    }

    public j(RelateTopicForumActivity relateTopicForumActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {relateTopicForumActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19692e = new ArrayList<>();
        this.f19695h = new a(this);
        this.f19694g = relateTopicForumActivity;
    }

    public void d(List<RelateForumItemData> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, list, str) == null) {
            this.f19692e.clear();
            this.f19692e.addAll(list);
            this.f19693f = str;
            notifyDataSetChanged();
        }
    }

    public void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            view.setLayoutParams(layoutParams);
        }
    }

    public final void f(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, textView, z) == null) {
            if (z) {
                textView.setEnabled(false);
                SkinManager.setViewTextColor(textView, b.a.r0.j1.b.CAM_X0109, 1);
                textView.setText(TbadkCoreApplication.getInst().getString(b.a.r0.j1.h.relate_forum_is_followed));
                textView.setBackgroundDrawable(null);
                return;
            }
            SkinManager.setViewTextColor(textView, b.a.r0.j1.b.CAM_X0101, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(b.a.r0.j1.h.attention));
            SkinManager.setBackgroundResource(textView, b.a.r0.j1.d.btn_appdownload);
            textView.setEnabled(true);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19692e.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f19692e.get(i2) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        RelateTopicForumItemHolder relateTopicForumItemHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f19694g.getPageContext().getContext()).inflate(b.a.r0.j1.f.hot_topic_list_item, (ViewGroup) null);
                relateTopicForumItemHolder = new RelateTopicForumItemHolder(view);
                view.setTag(relateTopicForumItemHolder);
                relateTopicForumItemHolder.forumAddLove.setOnClickListener(this.f19695h);
            } else {
                relateTopicForumItemHolder = (RelateTopicForumItemHolder) view.getTag();
            }
            relateTopicForumItemHolder.forumAddLove.setTag(Integer.valueOf(i2));
            ArrayList<RelateForumItemData> arrayList = this.f19692e;
            if (arrayList != null && arrayList.get(i2) != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (relateTopicForumItemHolder.skinType != skinType) {
                    SkinManager.setViewTextColor(relateTopicForumItemHolder.forumName, b.a.r0.j1.b.CAM_X0105, 1);
                    SkinManager.setViewTextColor(relateTopicForumItemHolder.postNum, b.a.r0.j1.b.CAM_X0108, 1);
                    SkinManager.setViewTextColor(relateTopicForumItemHolder.memberNum, b.a.r0.j1.b.CAM_X0108, 1);
                    SkinManager.setViewTextColor(relateTopicForumItemHolder.postNumLable, b.a.r0.j1.b.CAM_X0108, 1);
                    SkinManager.setViewTextColor(relateTopicForumItemHolder.memberNumLable, b.a.r0.j1.b.CAM_X0108, 1);
                    SkinManager.setViewTextColor(relateTopicForumItemHolder.content, b.a.r0.j1.b.CAM_X0109, 1);
                    SkinManager.setBackgroundResource(relateTopicForumItemHolder.line, b.a.r0.j1.b.CAM_X0204);
                    SkinManager.setBackgroundResource(relateTopicForumItemHolder.forumAddLove, b.a.r0.j1.d.btn_appdownload);
                    SkinManager.setBackgroundResource(view, b.a.r0.j1.d.list_item_selector);
                    relateTopicForumItemHolder.skinType = skinType;
                }
                relateTopicForumItemHolder.forumName.setText(this.f19692e.get(i2).forumName);
                if (!StringUtils.isNULL(this.f19692e.get(i2).forumAvatar)) {
                    relateTopicForumItemHolder.forumAvatar.startLoad(this.f19692e.get(i2).forumAvatar, 10, false);
                }
                relateTopicForumItemHolder.postNum.setText(StringHelper.numberUniformFormat(this.f19692e.get(i2).postNum));
                relateTopicForumItemHolder.memberNum.setText(StringHelper.numberUniformFormat(this.f19692e.get(i2).followNum));
                relateTopicForumItemHolder.content.setText(StringHelper.forceLToR(this.f19692e.get(i2).forumAbstract));
                f(relateTopicForumItemHolder.forumAddLove, this.f19692e.get(i2).isLiked);
                if (i2 == this.f19692e.size() - 1) {
                    e(relateTopicForumItemHolder.line);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

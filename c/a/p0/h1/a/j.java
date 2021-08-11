package c.a.p0.h1.a;

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
import com.baidu.tieba.R;
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
/* loaded from: classes3.dex */
public class j extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<RelateForumItemData> f18195e;

    /* renamed from: f  reason: collision with root package name */
    public String f18196f;

    /* renamed from: g  reason: collision with root package name */
    public RelateTopicForumActivity f18197g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f18198h;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f18199e;

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
            this.f18199e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f18199e.f18197g != null && this.f18199e.f18197g.checkUpIsLogin() && view.getId() == R.id.forum_add_love && (intValue = ((Integer) view.getTag()).intValue()) >= 0) {
                RelateForumItemData relateForumItemData = (RelateForumItemData) this.f18199e.f18195e.get(intValue);
                if (relateForumItemData.forumId != 0) {
                    TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", c.a.p0.h1.c.k.f18314b).param("topic_id", this.f18199e.f18196f));
                }
                if (c.a.e.e.p.k.isForumName(relateForumItemData.forumName)) {
                    this.f18199e.f18197g.likeModel.L(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
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
        this.f18195e = new ArrayList<>();
        this.f18198h = new a(this);
        this.f18197g = relateTopicForumActivity;
    }

    public void d(List<RelateForumItemData> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, list, str) == null) {
            this.f18195e.clear();
            this.f18195e.addAll(list);
            this.f18196f = str;
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
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109, 1);
                textView.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
                textView.setBackgroundDrawable(null);
                return;
            }
            SkinManager.setViewTextColor(textView, R.color.CAM_X0101, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            SkinManager.setBackgroundResource(textView, R.drawable.btn_appdownload);
            textView.setEnabled(true);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18195e.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f18195e.get(i2) : invokeI.objValue;
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
                view = LayoutInflater.from(this.f18197g.getPageContext().getContext()).inflate(R.layout.hot_topic_list_item, (ViewGroup) null);
                relateTopicForumItemHolder = new RelateTopicForumItemHolder(view);
                view.setTag(relateTopicForumItemHolder);
                relateTopicForumItemHolder.forumAddLove.setOnClickListener(this.f18198h);
            } else {
                relateTopicForumItemHolder = (RelateTopicForumItemHolder) view.getTag();
            }
            relateTopicForumItemHolder.forumAddLove.setTag(Integer.valueOf(i2));
            ArrayList<RelateForumItemData> arrayList = this.f18195e;
            if (arrayList != null && arrayList.get(i2) != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (relateTopicForumItemHolder.skinType != skinType) {
                    SkinManager.setViewTextColor(relateTopicForumItemHolder.forumName, R.color.CAM_X0105, 1);
                    SkinManager.setViewTextColor(relateTopicForumItemHolder.postNum, R.color.CAM_X0108, 1);
                    SkinManager.setViewTextColor(relateTopicForumItemHolder.memberNum, R.color.CAM_X0108, 1);
                    SkinManager.setViewTextColor(relateTopicForumItemHolder.postNumLable, R.color.CAM_X0108, 1);
                    SkinManager.setViewTextColor(relateTopicForumItemHolder.memberNumLable, R.color.CAM_X0108, 1);
                    SkinManager.setViewTextColor(relateTopicForumItemHolder.content, R.color.CAM_X0109, 1);
                    SkinManager.setBackgroundResource(relateTopicForumItemHolder.line, R.color.CAM_X0204);
                    SkinManager.setBackgroundResource(relateTopicForumItemHolder.forumAddLove, R.drawable.btn_appdownload);
                    SkinManager.setBackgroundResource(view, R.drawable.list_item_selector);
                    relateTopicForumItemHolder.skinType = skinType;
                }
                relateTopicForumItemHolder.forumName.setText(this.f18195e.get(i2).forumName);
                if (!StringUtils.isNULL(this.f18195e.get(i2).forumAvatar)) {
                    relateTopicForumItemHolder.forumAvatar.startLoad(this.f18195e.get(i2).forumAvatar, 10, false);
                }
                relateTopicForumItemHolder.postNum.setText(StringHelper.numberUniformFormat(this.f18195e.get(i2).postNum));
                relateTopicForumItemHolder.memberNum.setText(StringHelper.numberUniformFormat(this.f18195e.get(i2).followNum));
                relateTopicForumItemHolder.content.setText(StringHelper.forceLToR(this.f18195e.get(i2).forumAbstract));
                f(relateTopicForumItemHolder.forumAddLove, this.f18195e.get(i2).isLiked);
                if (i2 == this.f18195e.size() - 1) {
                    e(relateTopicForumItemHolder.line);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

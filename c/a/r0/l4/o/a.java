package c.a.r0.l4.o;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.selectForum.HotTopicChangeFourmActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f19570e;

    /* renamed from: f  reason: collision with root package name */
    public HotTopicChangeFourmActivity f19571f;

    /* renamed from: g  reason: collision with root package name */
    public List<HotTopicBussinessData> f19572g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f19573h;

    /* renamed from: c.a.r0.l4.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class C1167a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f19574b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19575c;

        /* renamed from: d  reason: collision with root package name */
        public View f19576d;

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
                }
            }
        }

        public /* synthetic */ b(a aVar, C1167a c1167a) {
            this(aVar);
        }
    }

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hotTopicChangeFourmActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19573h = null;
        this.f19571f = hotTopicChangeFourmActivity;
        this.f19570e = hotTopicChangeFourmActivity.getPageContext().getContext();
    }

    public final b a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        InterceptResult invokeLL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, hotTopicBussinessData)) == null) {
            if (obj == null) {
                bVar = b();
            } else {
                bVar = (b) obj;
            }
            bVar.f19575c.setText(d(hotTopicBussinessData.mForumName));
            bVar.f19574b.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
            SkinManager.setBackgroundResource(bVar.a, R.drawable.select_forum_item_bg);
            SkinManager.setViewTextColor(bVar.f19575c, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(bVar.f19576d, R.color.CAM_X0205);
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    public final b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = new b(this, null);
            View inflate = LayoutInflater.from(this.f19570e).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
            bVar.a = inflate;
            SkinManager.setBackgroundResource(inflate, R.drawable.select_forum_item_bg);
            SkinManager.setViewTextColor(bVar.f19575c, R.color.CAM_X0105);
            bVar.f19575c = (TextView) bVar.a.findViewById(R.id.fourm_tv);
            bVar.f19576d = bVar.a.findViewById(R.id.line_view);
            TbImageView tbImageView = (TbImageView) bVar.a.findViewById(R.id.icon_img);
            bVar.f19574b = tbImageView;
            tbImageView.setDefaultBgResource(R.color.CAM_X0205);
            bVar.f19574b.setDefaultResource(R.drawable.transparent_bg);
            bVar.a.setTag(bVar);
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public HotTopicBussinessData getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            List<HotTopicBussinessData> list = this.f19572g;
            if (list != null && i2 < list.size()) {
                return this.f19572g.get(i2);
            }
            return null;
        }
        return (HotTopicBussinessData) invokeI.objValue;
    }

    public final String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            if (str.length() > 14) {
                return str.substring(0, 13) + "...";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public void e(List<HotTopicBussinessData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f19572g = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (ListUtils.isEmpty(this.f19572g)) {
                return 0;
            }
            return this.f19572g.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            if (this.f19573h == null) {
                this.f19573h = viewGroup;
            }
            HotTopicBussinessData item = getItem(i2);
            if (item != null) {
                bVar = a(view != null ? view.getTag() : null, item);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                return bVar.a;
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }
}

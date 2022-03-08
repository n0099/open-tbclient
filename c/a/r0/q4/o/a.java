package c.a.r0.q4.o;

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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f21294e;

    /* renamed from: f  reason: collision with root package name */
    public HotTopicChangeFourmActivity f21295f;

    /* renamed from: g  reason: collision with root package name */
    public List<HotTopicBussinessData> f21296g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f21297h;

    /* renamed from: c.a.r0.q4.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C1338a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f21298b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f21299c;

        /* renamed from: d  reason: collision with root package name */
        public View f21300d;

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

        public /* synthetic */ b(a aVar, C1338a c1338a) {
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
        this.f21297h = null;
        this.f21295f = hotTopicChangeFourmActivity;
        this.f21294e = hotTopicChangeFourmActivity.getPageContext().getContext();
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
            bVar.f21299c.setText(d(hotTopicBussinessData.mForumName));
            bVar.f21298b.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
            SkinManager.setBackgroundResource(bVar.a, R.drawable.select_forum_item_bg);
            SkinManager.setViewTextColor(bVar.f21299c, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(bVar.f21300d, R.color.CAM_X0205);
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    public final b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = new b(this, null);
            View inflate = LayoutInflater.from(this.f21294e).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
            bVar.a = inflate;
            SkinManager.setBackgroundResource(inflate, R.drawable.select_forum_item_bg);
            SkinManager.setViewTextColor(bVar.f21299c, (int) R.color.CAM_X0105);
            bVar.f21299c = (TextView) bVar.a.findViewById(R.id.fourm_tv);
            bVar.f21300d = bVar.a.findViewById(R.id.line_view);
            TbImageView tbImageView = (TbImageView) bVar.a.findViewById(R.id.icon_img);
            bVar.f21298b = tbImageView;
            tbImageView.setDefaultBgResource(R.color.CAM_X0205);
            bVar.f21298b.setDefaultResource(R.drawable.transparent_bg);
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
            List<HotTopicBussinessData> list = this.f21296g;
            if (list != null && i2 < list.size()) {
                return this.f21296g.get(i2);
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
            this.f21296g = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (ListUtils.isEmpty(this.f21296g)) {
                return 0;
            }
            return this.f21296g.size();
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
            if (this.f21297h == null) {
                this.f21297h = viewGroup;
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
